package com.baidu.searchbox.ng.ai.apps.network.interceptor;

import com.baidu.searchbox.ng.ai.apps.network.IProgressListener;
import com.baidu.searchbox.ng.ai.apps.network.ProgressResponseBody;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class DownloadProgressInterceptor implements Interceptor {
    public static final String EXCEPTION_NULL_PROGRESS = "DownloadProgressInterceptor.mIProgressCallback == null";
    public static final int PROGRESS_100 = 100;
    public static final int UNKNOWN_LENGTH = -1;
    public static final int ZERO = 0;
    private IProgressCallback mIProgressCallback;
    final IProgressListener progressListener = new IProgressListener() { // from class: com.baidu.searchbox.ng.ai.apps.network.interceptor.DownloadProgressInterceptor.1
        @Override // com.baidu.searchbox.ng.ai.apps.network.IProgressListener
        public void onProgress(long j, long j2, boolean z) {
            if (DownloadProgressInterceptor.this.mIProgressCallback != null) {
                if (j2 == -1 && j != 0) {
                    DownloadProgressInterceptor.this.mIProgressCallback.onSuccess(0, j, j2);
                } else if (j2 > 10485760) {
                    DownloadProgressInterceptor.this.mIProgressCallback.onSizeFail(j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    DownloadProgressInterceptor.this.mIProgressCallback.onFail(j, j2);
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor != 100) {
                        DownloadProgressInterceptor.this.mIProgressCallback.onSuccess(floor, j, j2);
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface IProgressCallback {
        void onFail(long j, long j2);

        void onSizeFail(long j);

        void onSuccess(int i, long j, long j2);
    }

    public void setProgressListener(IProgressCallback iProgressCallback) {
        this.mIProgressCallback = iProgressCallback;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), this.progressListener)).build();
    }
}
