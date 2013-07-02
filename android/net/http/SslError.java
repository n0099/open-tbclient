package android.net.http;

import java.security.cert.X509Certificate;
/* loaded from: classes.dex */
public class SslError {
    public static final int SSL_EXPIRED = 1;
    public static final int SSL_IDMISMATCH = 2;
    public static final int SSL_MAX_ERROR = 4;
    public static final int SSL_NOTYETVALID = 0;
    public static final int SSL_UNTRUSTED = 3;
    SslCertificate mCertificate;
    int mErrors;

    public SslError(int i, SslCertificate sslCertificate) {
        addError(i);
        this.mCertificate = sslCertificate;
    }

    public SslError(int i, X509Certificate x509Certificate) {
        addError(i);
        this.mCertificate = new SslCertificate(x509Certificate);
    }

    public SslCertificate getCertificate() {
        return this.mCertificate;
    }

    public boolean addError(int i) {
        boolean z = i >= 0 && i < 4;
        if (z) {
            this.mErrors = (1 << i) | this.mErrors;
        }
        return z;
    }

    public boolean hasError(int i) {
        boolean z = i >= 0 && i < 4;
        return z ? (this.mErrors & (1 << i)) != 0 : z;
    }

    public int getPrimaryError() {
        if (this.mErrors != 0) {
            for (int i = 3; i >= 0; i--) {
                if ((this.mErrors & (1 << i)) != 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    public String toString() {
        return "primary error: " + getPrimaryError() + " certificate: " + getCertificate();
    }
}
