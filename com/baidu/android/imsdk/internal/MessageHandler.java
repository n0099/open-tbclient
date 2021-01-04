package com.baidu.android.imsdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.BigEndianDataIutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
/* loaded from: classes4.dex */
public class MessageHandler extends IMessageHandler {
    private static final HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    private static final String TAG = "MessageHandler";
    private SocketState mCurrentSocketState;
    private InputStream mInputStream;
    private BigEndianDataIutputStream mIs;
    private OutputStream mOutputStream;
    private Socket mSocket;

    public MessageHandler(Context context) {
        super(context);
        this.mCurrentSocketState = null;
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public SocketState socketConnect(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return connectImpl(str, i);
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public void socketWrite(Message message) throws IOException {
        if (this.mOutputStream != null) {
            this.mOutputStream.write(message.getMessageBytes());
            this.mOutputStream.flush();
        }
    }

    private SocketState connectImpl(String str, int i) throws IOException, IllegalArgumentException, AssertionError {
        LogUtils.i(TAG, "---------------ip:" + str + "  port:" + i + "-----------------");
        this.mSocket = createSocket(str, i);
        SocketState socketState = new SocketState();
        if (this.mSocket == null) {
            Utility.writeLoginFlag(this.mContext, "14N_2", "socketConnect mSocket = null");
        } else {
            socketState.mSocket = this.mSocket;
            socketState.mInputStream = this.mSocket.getInputStream();
            socketState.mOutputStream = this.mSocket.getOutputStream();
            socketState.mSocketCreateOk = true;
            socketState.mSocketEnvOk = true;
            LogUtils.i(TAG, "socket create OK!");
        }
        return socketState;
    }

    private Socket createSocket(String str, int i) throws IOException, IllegalArgumentException, AssertionError {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                if (Utility.isCreateTlsSocket(this.mContext)) {
                    return createSocketOnLine(str, i);
                }
                LogUtils.d(TAG, "createSocketOnlineByTcp ip = " + str + " port = " + Constants.SOCKET_PORT_TCP);
                return createSocketOnlineByTcp(str, Constants.SOCKET_PORT_TCP);
            case 1:
            case 2:
            case 3:
                return createSocketRD(str, i);
            default:
                return null;
        }
    }

    private Socket createSocketRD(String str, int i) throws IOException {
        return new Socket(str, i);
    }

    private Socket createSocketOnlineByTcp(String str, int i) throws IOException {
        return new Socket(str, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        r8 = r4.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Socket createSocketOnLine(String str, int i) throws IOException, IllegalArgumentException, AssertionError {
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.mContext);
        if (Constants.URL_SOCKET_SERVER.equals(str)) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0 && Utility.isIpv4Reachable()) {
                    int length = allByName.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        InetAddress inetAddress = allByName[i2];
                        if (inetAddress instanceof Inet4Address) {
                            break;
                        }
                        i2++;
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "createSocketOnLine", e);
            }
        }
        LogUtils.e(TAG, "createSocketOnLine request ip = " + str);
        if (Constants.URL_SOCKET_SERVER.equals(str)) {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
        } else {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
        }
        SSLSocket sSLSocket = null;
        if (sSLCertificateSocketFactory != null) {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i);
            sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
            sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
            enableSessionTicket(sSLCertificateSocketFactory, sSLSocket);
            if (sSLSocket.getInetAddress() != null) {
                this.mSocketIp = sSLSocket.getInetAddress().getHostAddress();
            }
            Utility.writeLoginFlag(this.mContext, "14N_3", "socketConnect sf = null");
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Utility.writeLoginFlag(this.mContext, "14N_4", "SSLHandshakeException");
            if (!str.equals(Constants.URL_SOCKET_SERVER) && !HOSTNAME_VERIFIER.verify(Constants.URL_SOCKET_SERVER, session)) {
                throw new SSLHandshakeException("Exepected pimc.baidu.com, found" + session.getPeerPrincipal());
            }
        }
        return sSLSocket;
    }

    @TargetApi(17)
    public void enableSessionTicket(SSLCertificateSocketFactory sSLCertificateSocketFactory, Socket socket) {
        if (Build.VERSION.SDK_INT > 17) {
            sSLCertificateSocketFactory.setUseSessionTickets(socket, true);
        }
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public boolean socketClose() {
        synchronized (this.mSendQueque) {
            this.mSendQueque.notifyAll();
        }
        return socketClose(this.mCurrentSocketState);
    }

    public boolean socketClose(SocketState socketState) {
        if (socketState != null && socketState.mSocketCreateOk.booleanValue()) {
            try {
                if (socketState.mSocket != null) {
                    socketState.mSocket.close();
                    socketState.mSocket = null;
                }
                if (socketState.mInputStream != null) {
                    socketState.mInputStream.close();
                    socketState.mInputStream = null;
                }
                if (socketState.mOutputStream != null) {
                    socketState.mOutputStream.close();
                    socketState.mOutputStream = null;
                    return true;
                }
                return true;
            } catch (IOException e) {
                LogUtils.e(TAG, "destroy:" + e.getMessage(), e);
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public Message readMessage() throws EOFException, IOException {
        return super.readMessage(this.mIs);
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public void setCurrentSocketState(SocketState socketState) {
        this.mCurrentSocketState = socketState;
        if (this.mCurrentSocketState != null) {
            this.mInputStream = this.mCurrentSocketState.mInputStream;
            this.mOutputStream = this.mCurrentSocketState.mOutputStream;
            this.mIs = new BigEndianDataIutputStream(this.mInputStream);
            return;
        }
        this.mInputStream = null;
        this.mOutputStream = null;
        this.mIs = null;
    }
}
