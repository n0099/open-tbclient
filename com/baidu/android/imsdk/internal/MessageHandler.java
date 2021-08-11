package com.baidu.android.imsdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.BigEndianDataIutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final HostnameVerifier HOSTNAME_VERIFIER;
    public static final String TAG = "MessageHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public SocketState mCurrentSocketState;
    public InputStream mInputStream;
    public BigEndianDataIutputStream mIs;
    public OutputStream mOutputStream;
    public Socket mSocket;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738756973, "Lcom/baidu/android/imsdk/internal/MessageHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738756973, "Lcom/baidu/android/imsdk/internal/MessageHandler;");
                return;
            }
        }
        HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageHandler(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentSocketState = null;
    }

    private SocketState connectImpl(String str, int i2) throws IOException, IllegalArgumentException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, str, i2)) == null) {
            LogUtils.i(TAG, "---------------ip:" + str + "  port:" + i2 + "-----------------");
            this.mSocket = createSocket(str, i2);
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
        return (SocketState) invokeLI.objValue;
    }

    private Socket createSocket(String str, int i2) throws IOException, IllegalArgumentException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, str, i2)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if (readIntData == 1 || readIntData == 2 || readIntData == 3) {
                    return createSocketRD(str, i2);
                }
                return null;
            } else if (Utility.isCreateTlsSocket(this.mContext)) {
                return createSocketOnLine(str, i2);
            } else {
                LogUtils.d(TAG, "createSocketOnlineByTcp ip = " + str + " port = 8100");
                return createSocketOnlineByTcp(str, 8100);
            }
        }
        return (Socket) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        r8 = r5.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Socket createSocketOnLine(String str, int i2) throws IOException, IllegalArgumentException, AssertionError {
        InterceptResult invokeLI;
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i2)) == null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.mContext);
            if (Constants.URL_SOCKET_SERVER.equals(str)) {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null && allByName.length > 0 && Utility.isIpv4Reachable()) {
                        int length = allByName.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            InetAddress inetAddress = allByName[i3];
                            if (inetAddress instanceof Inet4Address) {
                                break;
                            }
                            i3++;
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
                sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i2);
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
        return (Socket) invokeLI.objValue;
    }

    private Socket createSocketOnlineByTcp(String str, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, str, i2)) == null) ? new Socket(str, i2) : (Socket) invokeLI.objValue;
    }

    private Socket createSocketRD(String str, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, this, str, i2)) == null) ? new Socket(str, i2) : (Socket) invokeLI.objValue;
    }

    @TargetApi(17)
    public void enableSessionTicket(SSLCertificateSocketFactory sSLCertificateSocketFactory, Socket socket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, sSLCertificateSocketFactory, socket) == null) || Build.VERSION.SDK_INT <= 17) {
            return;
        }
        sSLCertificateSocketFactory.setUseSessionTickets(socket, true);
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public Message readMessage() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.readMessage(this.mIs) : (Message) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public void setCurrentSocketState(SocketState socketState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, socketState) == null) {
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
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public boolean socketClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mSendQueque) {
                this.mSendQueque.notifyAll();
            }
            return socketClose(this.mCurrentSocketState);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public SocketState socketConnect(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) ? connectImpl(str, i2) : (SocketState) invokeLI.objValue;
    }

    @Override // com.baidu.android.imsdk.internal.IMessageHandler
    public void socketWrite(Message message) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, message) == null) || (outputStream = this.mOutputStream) == null) {
            return;
        }
        outputStream.write(message.getMessageBytes());
        this.mOutputStream.flush();
    }

    public boolean socketClose(SocketState socketState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, socketState)) == null) {
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
        return invokeL.booleanValue;
    }
}
