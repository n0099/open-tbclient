package com.baidu.lcp.sdk.connect;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes3.dex */
public abstract class d {
    protected e auR = null;
    protected Context context;

    public abstract void a(b bVar) throws IOException;

    public abstract void a(e eVar);

    public abstract boolean socketClose() throws IOException;

    public abstract InputStream vH() throws Exception;

    public abstract e y(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, SSLHandshakeException, AssertionError;

    public d(Context context) {
        this.context = context;
    }

    public e vI() {
        return this.auR;
    }
}
