package aegon.chrome.net;

import aegon.chrome.base.annotations.CalledByNative;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class AndroidCertVerifyResult {
    public final List<X509Certificate> mCertificateChain;
    public final boolean mIsIssuedByKnownRoot;
    public final int mStatus;

    public AndroidCertVerifyResult(int i) {
        this.mStatus = i;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.mStatus = i;
        this.mIsIssuedByKnownRoot = z;
        this.mCertificateChain = new ArrayList(list);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.mCertificateChain.size()];
        for (int i = 0; i < this.mCertificateChain.size(); i++) {
            try {
                bArr[i] = this.mCertificateChain.get(i).getEncoded();
            } catch (CertificateEncodingException e) {
                return new byte[0];
            }
        }
        return bArr;
    }

    @CalledByNative
    public int getStatus() {
        return this.mStatus;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.mIsIssuedByKnownRoot;
    }
}
