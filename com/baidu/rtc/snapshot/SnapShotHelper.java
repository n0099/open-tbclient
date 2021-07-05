package com.baidu.rtc.snapshot;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.rtc.utils.FileUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.webrtc.EglRenderer;
import org.webrtc.Logging;
import org.webrtc.SurfaceViewRenderer;
/* loaded from: classes3.dex */
public class SnapShotHelper implements ISnapShot {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SnapShotHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;
    public final SurfaceViewRenderer mRenderer;

    public SnapShotHelper(SurfaceViewRenderer surfaceViewRenderer, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceViewRenderer, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRenderer = surfaceViewRenderer;
        this.mHandler = handler;
    }

    @Override // com.baidu.rtc.snapshot.ISnapShot
    public void takeSnapShot(String str, SnapShotCallback snapShotCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, snapShotCallback) == null) {
            if (this.mRenderer == null || TextUtils.isEmpty(str)) {
                snapShotCallback.onSnapShotTake(false, "render is null");
                return;
            }
            EglRenderer.FrameListener frameListener = new EglRenderer.FrameListener(this, str, snapShotCallback) { // from class: com.baidu.rtc.snapshot.SnapShotHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public String picFilePath;
                public boolean picHasTake;
                public final /* synthetic */ SnapShotHelper this$0;
                public final /* synthetic */ SnapShotCallback val$callback;
                public final /* synthetic */ String val$filePath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, snapShotCallback};
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
                    this.val$filePath = str;
                    this.val$callback = snapShotCallback;
                    this.picHasTake = false;
                    this.picFilePath = this.val$filePath;
                }

                @Override // org.webrtc.EglRenderer.FrameListener
                public void onFrame(Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                        if (this.picHasTake) {
                            Logging.d(SnapShotHelper.TAG, "pic has take already once!");
                            bitmap.recycle();
                            return;
                        }
                        File file = new File(this.val$filePath);
                        if (!file.getParentFile().exists()) {
                            try {
                                file.getParentFile().mkdirs();
                            } catch (Exception e2) {
                                SnapShotCallback snapShotCallback2 = this.val$callback;
                                if (snapShotCallback2 != null) {
                                    snapShotCallback2.onSnapShotTake(false, e2.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        FileUtils.deleteFile(file);
                        String saveBitmap2JPG = FileUtils.saveBitmap2JPG(file.getParentFile().getPath(), file.getName(), bitmap, 90);
                        bitmap.recycle();
                        this.picHasTake = true;
                        if (this.this$0.mRenderer != null) {
                            this.this$0.mRenderer.post(new Runnable(this, this) { // from class: com.baidu.rtc.snapshot.SnapShotHelper.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ EglRenderer.FrameListener val$finalPicShotListener;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, this};
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
                                    this.val$finalPicShotListener = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.mRenderer.removeFrameListener(this.val$finalPicShotListener);
                                    }
                                }
                            });
                        }
                        SnapShotCallback snapShotCallback3 = this.val$callback;
                        if (snapShotCallback3 != null) {
                            if (saveBitmap2JPG == null) {
                                snapShotCallback3.onSnapShotTake(false, "save bitmap fault");
                                return;
                            }
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Logging.e(SnapShotHelper.TAG, "take pic " + width + "x" + height + " file:" + saveBitmap2JPG);
                            this.val$callback.onSnapShotTake(true, this.val$filePath);
                        }
                    }
                }
            };
            SurfaceViewRenderer surfaceViewRenderer = this.mRenderer;
            if (surfaceViewRenderer != null) {
                surfaceViewRenderer.addFrameListener(frameListener, 1.0f);
            }
        }
    }
}
