package aegon.chrome.net.impl;

import aegon.chrome.net.ICronetEngineBuilder;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mApplicationContext;
    public boolean mBrotiEnabled;
    public boolean mDisableCache;
    public String mExperimentalOptions;
    public boolean mHttp2Enabled;
    public long mHttpCacheMaxSize;
    public int mHttpCacheMode;
    public long mMockCertVerifier;
    public boolean mNetworkQualityEstimatorEnabled;
    public final List<Pkp> mPkps;
    public boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    public boolean mQuicEnabled;
    public final List<QuicHint> mQuicHints;
    public String mStoragePath;
    public int mThreadPriority;
    public String mUserAgent;

    /* loaded from: classes.dex */
    public static class Pkp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Date mExpirationDate;
        public final byte[][] mHashes;
        public final String mHost;
        public final boolean mIncludeSubdomains;
    }

    /* loaded from: classes.dex */
    public static class QuicHint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mAlternatePort;
        public final String mHost;
        public final int mPort;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922183680, "Laegon/chrome/net/impl/CronetEngineBuilderImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922183680, "Laegon/chrome/net/impl/CronetEngineBuilderImpl;");
                return;
            }
        }
        Pattern.compile("^[0-9\\.]*$");
    }

    public CronetEngineBuilderImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mQuicHints = new LinkedList();
        this.mPkps = new LinkedList();
        this.mThreadPriority = 20;
        this.mApplicationContext = context.getApplicationContext();
        this.mQuicEnabled = false;
        this.mHttp2Enabled = true;
        this.mBrotiEnabled = false;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHttpCacheMode : invokeV.intValue;
    }

    public boolean networkQualityEstimatorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNetworkQualityEstimatorEnabled : invokeV.booleanValue;
    }
}
