package c.a.u.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes9.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Socket f27069c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f27070d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f27071e;

    /* renamed from: f  reason: collision with root package name */
    public String f27072f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27072f = str;
    }

    @Override // c.a.u.a.c.c
    public InputStream b() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new DataInputStream(this.f27070d) : (InputStream) invokeV.objValue;
    }

    @Override // c.a.u.a.c.c
    public void c(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f27030b = dVar;
            if (dVar != null) {
                this.f27070d = dVar.f27033d;
                this.f27071e = dVar.f27034e;
                return;
            }
            this.f27070d = null;
            this.f27071e = null;
        }
    }

    @Override // c.a.u.a.c.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k(this.f27030b) : invokeV.booleanValue;
    }

    @Override // c.a.u.a.c.c
    public d e(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) ? g(str, i2) : (d) invokeLI.objValue;
    }

    @Override // c.a.u.a.c.c
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f27069c == null || (outputStream = this.f27071e) == null) {
            return;
        }
        outputStream.write(bVar.a);
        this.f27071e.flush();
    }

    public final d g(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            c.a.u.a.h.e.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i2 + "-----------------");
            this.f27069c = h(str, i2);
            d dVar = new d();
            Socket socket = this.f27069c;
            if (socket == null) {
                return dVar;
            }
            dVar.f27032c = socket;
            dVar.f27033d = socket.getInputStream();
            dVar.f27034e = this.f27069c.getOutputStream();
            Boolean bool = Boolean.TRUE;
            dVar.a = bool;
            dVar.f27031b = bool;
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    public final Socket h(String str, int i2) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            if (this.f27072f.equals(b.c.f33650d)) {
                return j(str, i2);
            }
            return i(str, i2);
        }
        return (Socket) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r9 = r6.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket i(String str, int i2) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        InterceptResult invokeLI;
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.a);
            if (str.contains("baidu.com")) {
                c.a.u.a.h.e.a("TcpMessageHandler", "localdns begin...,domain:" + str);
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null && allByName.length > 0) {
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
                    c.a.u.a.h.e.c("TcpMessageHandler", "createSocketOnLine", e2);
                }
            }
            if (str.contains("baidu.com")) {
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
            } else {
                sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
            }
            if (sSLCertificateSocketFactory != null) {
                SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i2);
                sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
                sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
                sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
                sSLSocket.startHandshake();
                return sSLSocket;
            }
            return null;
        }
        return (Socket) invokeLI.objValue;
    }

    public final Socket j(String str, int i2) throws UnknownHostException, IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) ? new Socket(str, i2) : (Socket) invokeLI.objValue;
    }

    public boolean k(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dVar)) == null) {
            if (dVar != null && dVar.a.booleanValue()) {
                try {
                    if (dVar.f27032c != null) {
                        dVar.f27032c.close();
                        dVar.f27032c = null;
                    }
                    if (dVar.f27033d != null) {
                        dVar.f27033d.close();
                        dVar.f27033d = null;
                    }
                    if (dVar.f27034e != null) {
                        dVar.f27034e.close();
                        dVar.f27034e = null;
                        return true;
                    }
                    return true;
                } catch (IOException e2) {
                    c.a.u.a.h.e.c("TcpMessageHandler", "destroy:", e2);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
