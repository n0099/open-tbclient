package android.net.http;

import android.os.Bundle;
import java.security.cert.X509Certificate;
import java.util.Date;
/* loaded from: classes12.dex */
public class SslCertificate {

    /* loaded from: classes12.dex */
    public class DName {
        public DName(String str) {
            throw new RuntimeException("Stub!");
        }

        public String getDName() {
            throw new RuntimeException("Stub!");
        }

        public String getCName() {
            throw new RuntimeException("Stub!");
        }

        public String getOName() {
            throw new RuntimeException("Stub!");
        }

        public String getUName() {
            throw new RuntimeException("Stub!");
        }
    }

    @Deprecated
    public SslCertificate(String str, String str2, String str3, String str4) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public SslCertificate(String str, String str2, Date date, Date date2) {
        throw new RuntimeException("Stub!");
    }

    public SslCertificate(X509Certificate x509Certificate) {
        throw new RuntimeException("Stub!");
    }

    public static Bundle saveState(SslCertificate sslCertificate) {
        throw new RuntimeException("Stub!");
    }

    public static SslCertificate restoreState(Bundle bundle) {
        throw new RuntimeException("Stub!");
    }

    public Date getValidNotBeforeDate() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getValidNotBefore() {
        throw new RuntimeException("Stub!");
    }

    public Date getValidNotAfterDate() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getValidNotAfter() {
        throw new RuntimeException("Stub!");
    }

    public DName getIssuedTo() {
        throw new RuntimeException("Stub!");
    }

    public DName getIssuedBy() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
