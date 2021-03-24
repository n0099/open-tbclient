package aegon.chrome.net.impl;

import aegon.chrome.net.ICronetEngineBuilder;
import android.content.Context;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    public final Context mApplicationContext;
    public boolean mDisableCache;
    public String mExperimentalOptions;
    public long mHttpCacheMaxSize;
    public int mHttpCacheMode;
    public long mMockCertVerifier;
    public boolean mNetworkQualityEstimatorEnabled;
    public boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    public String mStoragePath;
    public String mUserAgent;
    public final List<QuicHint> mQuicHints = new LinkedList();
    public final List<Pkp> mPkps = new LinkedList();
    public int mThreadPriority = 20;
    public boolean mQuicEnabled = false;
    public boolean mHttp2Enabled = true;
    public boolean mBrotiEnabled = false;

    /* loaded from: classes.dex */
    public static class Pkp {
        public final Date mExpirationDate;
        public final byte[][] mHashes;
        public final String mHost;
        public final boolean mIncludeSubdomains;
    }

    /* loaded from: classes.dex */
    public static class QuicHint {
        public final int mAlternatePort;
        public final String mHost;
        public final int mPort;
    }

    static {
        Pattern.compile("^[0-9\\.]*$");
    }

    public CronetEngineBuilderImpl(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        if (this.mStoragePath != null) {
            throw new IllegalArgumentException("Storage path must not be set");
        }
        this.mDisableCache = true;
        this.mHttpCacheMaxSize = 0L;
        this.mHttpCacheMode = 0;
        this.mNetworkQualityEstimatorEnabled = false;
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = true;
    }

    public int httpCacheMode() {
        return this.mHttpCacheMode;
    }

    public boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }
}
