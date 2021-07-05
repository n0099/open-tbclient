package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalUrlRequest;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UrlRequest;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UrlRequestBuilderImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowDirectExecutor;
    public final UrlRequest.Callback mCallback;
    public final CronetEngineBase mCronetEngine;
    public boolean mDisableCache;
    public boolean mDisableConnectionMigration;
    public final Executor mExecutor;
    public String mMethod;
    public int mPriority;
    public Collection<Object> mRequestAnnotations;
    public RequestFinishedInfo.Listener mRequestFinishedListener;
    public final ArrayList<Pair<String, String>> mRequestHeaders;
    public int mTrafficStatsTag;
    public boolean mTrafficStatsTagSet;
    public int mTrafficStatsUid;
    public boolean mTrafficStatsUidSet;
    public UploadDataProvider mUploadDataProvider;
    public Executor mUploadDataProviderExecutor;
    public final String mUrl;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor, CronetEngineBase cronetEngineBase) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, callback, executor, cronetEngineBase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestHeaders = new ArrayList<>();
        this.mPriority = 3;
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (callback == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        if (cronetEngineBase == null) {
            throw new NullPointerException("CronetEngine is required.");
        }
        this.mUrl = str;
        this.mCallback = callback;
        this.mExecutor = executor;
        this.mCronetEngine = cronetEngineBase;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public ExperimentalUrlRequest.Builder addHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (str != null) {
                if (str2 != null) {
                    if ("Accept-Encoding".equalsIgnoreCase(str)) {
                        Log.w(TAG, "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
                    } else {
                        this.mRequestHeaders.add(Pair.create(str, str2));
                    }
                    return this;
                }
                throw new NullPointerException("Invalid header value.");
            }
            throw new NullPointerException("Invalid header name.");
        }
        return (ExperimentalUrlRequest.Builder) invokeLL.objValue;
    }

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public ExperimentalUrlRequest.Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataProvider, executor)) == null) {
            if (uploadDataProvider != null) {
                if (executor != null) {
                    if (this.mMethod == null) {
                        this.mMethod = "POST";
                    }
                    this.mUploadDataProvider = uploadDataProvider;
                    this.mUploadDataProviderExecutor = executor;
                    return this;
                }
                throw new NullPointerException("Invalid UploadDataProvider Executor.");
            }
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        return (ExperimentalUrlRequest.Builder) invokeLL.objValue;
    }
}
