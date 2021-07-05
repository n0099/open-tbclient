package com.baidu.searchbox.afx.recode;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.afx.recode.Mp4ComposerEngine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class Mp4Composer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Mp4Composer";
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService mExecutorService;

    /* loaded from: classes3.dex */
    public interface Listener {
        void onCompleted();

        void onFailed(Exception exc);

        void onProgress(float f2);
    }

    public Mp4Composer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private ExecutorService getExecutorService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            if (this.mExecutorService == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            }
            return this.mExecutorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mp4Info getMp4Info(AssetFileDescriptor assetFileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, assetFileDescriptor)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (assetFileDescriptor.getDeclaredLength() < 0) {
                mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor());
            } else {
                mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
            return getMp4Info(mediaMetadataRetriever);
        }
        return (Mp4Info) invokeL.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            getExecutorService().shutdownNow();
        }
    }

    public void start(String str, String str2, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, listener) == null) {
            start(new File(str), str2, listener);
        }
    }

    public void start(File file, String str, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, file, str, listener) == null) {
            try {
                start(new FileInputStream(file).getFD(), str, listener);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (listener != null) {
                    listener.onFailed(e2);
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (listener != null) {
                    listener.onFailed(e3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mp4Info getMp4Info(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, fileDescriptor)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor);
            return getMp4Info(mediaMetadataRetriever);
        }
        return (Mp4Info) invokeL.objValue;
    }

    public void start(Context context, String str, String str2, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, listener) == null) {
            try {
                start(context.getAssets().openFd(str), str2, listener);
            } catch (IOException e2) {
                e2.printStackTrace();
                if (listener != null) {
                    listener.onFailed(e2);
                }
            }
        }
    }

    private Mp4Info getMp4Info(MediaMetadataRetriever mediaMetadataRetriever) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, mediaMetadataRetriever)) == null) {
            try {
                mediaMetadataRetriever.extractMetadata(12);
                return new Mp4Info(Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(24)).intValue(), Integer.valueOf(mediaMetadataRetriever.extractMetadata(20)).intValue(), 1000 * Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue());
            } finally {
                if (mediaMetadataRetriever != null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e2) {
                        Log.e(TAG, "Failed to release mediaMetadataRetriever.", e2);
                    }
                }
            }
        }
        return (Mp4Info) invokeL.objValue;
    }

    public void start(AssetFileDescriptor assetFileDescriptor, String str, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, assetFileDescriptor, str, listener) == null) {
            start(assetFileDescriptor, (FileDescriptor) null, str, listener);
        }
    }

    public void start(FileDescriptor fileDescriptor, String str, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, fileDescriptor, str, listener) == null) {
            if (fileDescriptor != null && fileDescriptor.valid()) {
                start((AssetFileDescriptor) null, fileDescriptor, str, listener);
            } else if (listener != null) {
                listener.onFailed(new RuntimeException("The file descriptor object is invalid."));
            }
        }
    }

    private void start(AssetFileDescriptor assetFileDescriptor, FileDescriptor fileDescriptor, String str, Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, this, assetFileDescriptor, fileDescriptor, str, listener) == null) {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                getExecutorService().execute(new Runnable(this, listener, assetFileDescriptor, fileDescriptor, str) { // from class: com.baidu.searchbox.afx.recode.Mp4Composer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Mp4Composer this$0;
                    public final /* synthetic */ AssetFileDescriptor val$afd;
                    public final /* synthetic */ String val$destPath;
                    public final /* synthetic */ FileDescriptor val$fd;
                    public final /* synthetic */ Listener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, listener, assetFileDescriptor, fileDescriptor, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = listener;
                        this.val$afd = assetFileDescriptor;
                        this.val$fd = fileDescriptor;
                        this.val$destPath = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Mp4ComposerEngine mp4ComposerEngine = new Mp4ComposerEngine();
                            mp4ComposerEngine.setProgressCallback(new Mp4ComposerEngine.ProgressCallback(this) { // from class: com.baidu.searchbox.afx.recode.Mp4Composer.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // com.baidu.searchbox.afx.recode.Mp4ComposerEngine.ProgressCallback
                                public void onProgress(float f2) {
                                    Listener listener2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeF(1048576, this, f2) == null) || (listener2 = this.this$1.val$listener) == null) {
                                        return;
                                    }
                                    listener2.onProgress(f2);
                                }
                            });
                            try {
                                if (this.val$afd == null) {
                                    mp4ComposerEngine.compose(this.val$fd, this.val$destPath, this.this$0.getMp4Info(this.val$fd));
                                } else {
                                    mp4ComposerEngine.compose(this.val$afd, this.val$destPath, this.this$0.getMp4Info(this.val$afd));
                                }
                                Listener listener2 = this.val$listener;
                                if (listener2 != null) {
                                    listener2.onCompleted();
                                }
                                this.this$0.mExecutorService.shutdown();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                Listener listener3 = this.val$listener;
                                if (listener3 != null) {
                                    listener3.onFailed(e2);
                                }
                                this.this$0.mExecutorService.shutdown();
                            }
                        }
                    }
                });
            } else if (listener != null) {
                listener.onCompleted();
            }
        }
    }
}
