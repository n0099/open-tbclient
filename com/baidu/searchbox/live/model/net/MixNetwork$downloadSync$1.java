package com.baidu.searchbox.live.model.net;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.net.DownLoadCallback;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/baidu/searchbox/live/model/net/MixNetwork$downloadSync$1", "Lcom/baidu/searchbox/live/interfaces/net/DownLoadCallback;", "", "key", "", "statusCode", StatConstants.KEY_EXT_ERR_CODE, "", "exception", "", "onFileDownloaded", "(Ljava/lang/Object;IILjava/lang/String;)V", "", "downloadLength", "totalLength", "onFileUpdateProgress", "(Ljava/lang/Object;JJ)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixNetwork$downloadSync$1 implements DownLoadCallback {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ MixNetDownloadCallback $callback;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MixNetwork this$0;

    public MixNetwork$downloadSync$1(MixNetwork mixNetwork, MixNetDownloadCallback mixNetDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mixNetwork, mixNetDownloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = mixNetwork;
        this.$callback = mixNetDownloadCallback;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.DownLoadCallback
    public void onFileDownloaded(final Object obj, final int i, final int i2, final String str) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            handler = this.this$0.getHandler();
            handler.post(new Runnable(this, obj, i, i2, str) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$downloadSync$1$onFileDownloaded$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ int $errCode;
                public final /* synthetic */ String $exception;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object $key;
                public final /* synthetic */ int $statusCode;
                public final /* synthetic */ MixNetwork$downloadSync$1 this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj, Integer.valueOf(i), Integer.valueOf(i2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$key = obj;
                    this.$statusCode = i;
                    this.$errCode = i2;
                    this.$exception = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MixNetDownloadCallback mixNetDownloadCallback;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (mixNetDownloadCallback = this.this$0.$callback) == null) {
                        return;
                    }
                    mixNetDownloadCallback.onFileDownloaded(this.$key, this.$statusCode, this.$errCode, this.$exception);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.DownLoadCallback
    public void onFileUpdateProgress(final Object obj, final long j, final long j2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{obj, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            handler = this.this$0.getHandler();
            handler.post(new Runnable(this, obj, j, j2) { // from class: com.baidu.searchbox.live.model.net.MixNetwork$downloadSync$1$onFileUpdateProgress$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ long $downloadLength;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object $key;
                public final /* synthetic */ long $totalLength;
                public final /* synthetic */ MixNetwork$downloadSync$1 this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj, Long.valueOf(j), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$key = obj;
                    this.$downloadLength = j;
                    this.$totalLength = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MixNetDownloadCallback mixNetDownloadCallback;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (mixNetDownloadCallback = this.this$0.$callback) == null) {
                        return;
                    }
                    mixNetDownloadCallback.onFileUpdateProgress(this.$key, this.$downloadLength, this.$totalLength);
                }
            });
        }
    }
}
