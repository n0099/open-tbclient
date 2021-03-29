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
/* loaded from: classes.dex */
public class MessageHandler extends IMessageHandler {
    public static final HostnameVerifier HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    public static final String TAG = "MessageHandler";
    public SocketState mCurrentSocketState;
    public InputStream mInputStream;
    public BigEndianDataIutputStream mIs;
    public OutputStream mOutputStream;
    public Socket mSocket;

    public MessageHandler(Context context) {
        super(context);
        this.mCurrentSocketState = null;
    }

    private SocketState connectImpl(String str, int i) throws IOException, IllegalArgumentException, AssertionError {
        LogUtils.i(TAG, "---------------ip:" + str + "  port:" + i + "-----------------");
        this.mSocket = createSocket(str, i);
        SocketState socketState = new SocketState();
        Socket socket = this.mSocket;
        if (socket == null) {
            Utility.writeLoginFlag(this.mContext, "14N_2", "socketConnect mSocket = null");
            return socketState;
        }
        socketState.mSocket = socket;
        socketState.mInputStream = socket.getInputStream();
        socketState.mOutputStream = this.mSocket.getOutputStream();
        Boolean bool = Boolean.TRUE;
        socketState.mSocketCreateOk = bool;
        socketState.mSocketEnvOk = bool;
        LogUtils.i(TAG, "socket create OK!");
        return socketState;
    }

    private Socket createSocket(String str, int i) throws IOException, IllegalArgumentException, AssertionError {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData == 1 || readIntData == 2 || readIntData == 3) {
                return createSocketRD(str, i);
            }
            return null;
        } else if (Utility.isCreateTlsSocket(this.mContext)) {
            return createSocketOnLine(str, i);
        } else {
            LogUtils.d(TAG, "createSocketOnlineByTcp ip = " + str + " port = 8100");
            return createSocketOnlineByTcp(str, 8100);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        r8 = r5.getHostAddress();
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
            } catch (Exception e2) {
                LogUtils.e(TAG, "createSocketOnLine", e2);
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

    private Socket createSocketOnlineByTcp(String str, int i) throws IOException {
        return new Socket(str, i);
    }

    private Socket createSocketRD(String str, int i) throws IOException {
        return new Socket(str, i);
    }

    @TargetApi(17)
    public void enableSessionTicket(SSLCertificateSocketFactory sSLCertificateSocketFactory, Socket socket) {
        if (Build.VERSION.SDK_INT > 17) {
            sSLCertificateSocketFactory.setUseSessionTickets(socket, true);
        }
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public Message readMessage() throws EOFException, IOException {
        return super.readMessage(this.mIs);
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public void setCurrentSocketState(SocketState socketState) {
        this.mCurrentSocketState = socketState;
        if (socketState != null) {
            InputStream inputStream = socketState.mInputStream;
            this.mInputStream = inputStream;
            this.mOutputStream = socketState.mOutputStream;
            this.mIs = new BigEndianDataIutputStream(inputStream);
            return;
        }
        this.mInputStream = null;
        this.mOutputStream = null;
        this.mIs = null;
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public boolean socketClose() {
        synchronized (this.mSendQueque) {
            this.mSendQueque.notifyAll();
        }
        return socketClose(this.mCurrentSocketState);
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public SocketState socketConnect(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return connectImpl(str, i);
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public void socketWrite(Message message) throws IOException {
        OutputStream outputStream = this.mOutputStream;
        if (outputStream != null) {
            outputStream.write(message.getMessageBytes());
            this.mOutputStream.flush();
        }
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
            } catch (IOException e2) {
                LogUtils.e(TAG, "destroy:" + e2.getMessage(), e2);
                return false;
            }
        }
        return true;
    }
}
