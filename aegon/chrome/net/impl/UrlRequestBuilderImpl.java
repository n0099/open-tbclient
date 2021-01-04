package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalUrlRequest;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UrlRequest;
import android.util.Log;
import android.util.Pair;
import com.baidubce.http.Headers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    public static final String TAG = "UrlRequestBuilderImpl";
    public boolean mAllowDirectExecutor;
    public final UrlRequest.Callback mCallback;
    public final CronetEngineBase mCronetEngine;
    public boolean mDisableCache;
    public boolean mDisableConnectionMigration;
    public final Executor mExecutor;
    public String mMethod;
    public Collection<Object> mRequestAnnotations;
    public RequestFinishedInfo.Listener mRequestFinishedListener;
    public int mTrafficStatsTag;
    public boolean mTrafficStatsTagSet;
    public int mTrafficStatsUid;
    public boolean mTrafficStatsUidSet;
    public UploadDataProvider mUploadDataProvider;
    public Executor mUploadDataProviderExecutor;
    public final String mUrl;
    public final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList<>();
    public int mPriority = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor, CronetEngineBase cronetEngineBase) {
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
        if (str != null) {
            if (str2 != null) {
                if (Headers.ACCEPT_ENCODING.equalsIgnoreCase(str)) {
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

    @Override // aegon.chrome.net.ExperimentalUrlRequest.Builder
    public ExperimentalUrlRequest.Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
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
}
