package com.baidu.lcp.sdk.connect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
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
/* loaded from: classes3.dex */
public class g extends d {
    private String avK;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Socket socket;

    public g(Context context, String str) {
        super(context);
        this.avK = str;
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public e y(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return z(str, i);
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public void a(b bVar) throws IOException {
        if (this.socket != null && this.outputStream != null) {
            this.outputStream.write(bVar.auU);
            this.outputStream.flush();
        }
    }

    private e z(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        com.baidu.lcp.sdk.d.d.i("TcpMessageHandler", "---------------ip:" + str + "  port:" + i + "-----------------");
        this.socket = createSocket(str, i);
        e eVar = new e();
        if (this.socket != null) {
            eVar.socket = this.socket;
            eVar.inputStream = this.socket.getInputStream();
            eVar.outputStream = this.socket.getOutputStream();
            eVar.avd = true;
            eVar.ave = true;
        }
        return eVar;
    }

    private Socket createSocket(String str, int i) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return this.avK.equals("tcp") ? createSocketRD(str, i) : createSocketOnLine(str, i);
    }

    private Socket createSocketRD(String str, int i) throws UnknownHostException, IOException {
        return new Socket(str, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        r8 = r4.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Socket createSocketOnLine(String str, int i) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.context);
        if (str.contains("baidu.com")) {
            com.baidu.lcp.sdk.d.d.d("TcpMessageHandler", "localdns begin...,domain:" + str);
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
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
                com.baidu.lcp.sdk.d.d.e("TcpMessageHandler", "createSocketOnLine", e);
            }
        }
        if (str.contains("baidu.com")) {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
        } else {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
        }
        if (sSLCertificateSocketFactory == null) {
            return null;
        }
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i);
        sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
        sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
        sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
        sSLSocket.startHandshake();
        return sSLSocket;
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public boolean socketClose() {
        return c(this.avc);
    }

    public boolean c(e eVar) {
        if (eVar != null && eVar.avd.booleanValue()) {
            try {
                if (eVar.socket != null) {
                    eVar.socket.close();
                    eVar.socket = null;
                }
                if (eVar.inputStream != null) {
                    eVar.inputStream.close();
                    eVar.inputStream = null;
                }
                if (eVar.outputStream != null) {
                    eVar.outputStream.close();
                    eVar.outputStream = null;
                    return true;
                }
                return true;
            } catch (IOException e) {
                com.baidu.lcp.sdk.d.d.e("TcpMessageHandler", "destroy:", e);
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public InputStream vK() throws EOFException, IOException {
        return new DataInputStream(this.inputStream);
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public void a(e eVar) {
        this.avc = eVar;
        if (this.avc != null) {
            this.inputStream = this.avc.inputStream;
            this.outputStream = this.avc.outputStream;
            return;
        }
        this.inputStream = null;
        this.outputStream = null;
    }
}
