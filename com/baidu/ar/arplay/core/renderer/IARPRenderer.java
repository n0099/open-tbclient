package com.baidu.ar.arplay.core.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.EGLContext;
import android.view.Surface;
import com.baidu.ar.arplay.core.engine.e;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public interface IARPRenderer {
    String addOutputSurface(Surface surface, int i2, int i3);

    String addOutputSurface(Surface surface, int i2, int i3, PixelRotation pixelRotation);

    String addOutputSurface(Surface surface, int i2, int i3, PixelRotation pixelRotation, OutputFillMode outputFillMode);

    String addOutputTarget(int i2, int i3, int i4, int i5);

    String addOutputTarget(int i2, int i3, int i4, int i5, PixelRotation pixelRotation);

    String addOutputTarget(int i2, int i3, int i4, int i5, PixelRotation pixelRotation, OutputFillMode outputFillMode);

    void bindTargetSurface(Surface surface);

    void cancelAysncRenderTask(Runnable runnable);

    void clearAllAsyncRenderTask();

    void clearCaptureData();

    void connectCameraWithTarget();

    void createInputSource(PixelRotation pixelRotation, e eVar);

    void createPixelReaderByPreFilterID(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void createSyncInputSource(PixelRotation pixelRotation, e eVar);

    long createTexture(int i2, int i3, int i4);

    void destroyAllPixelReader();

    void destroyPixelReaderByPreFilterID(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void destroyTexture(long j2);

    String getDefaultLuaPath();

    void getSnapShot(TakePictureCallback takePictureCallback, int i2, int i3, int i4);

    void getSnapShot(TakePictureCallback takePictureCallback, int i2, int i3, int i4, Rect rect);

    int getTextureId(long j2);

    boolean isFrontCamera();

    void loadDefaultFilterLuaPath(String str);

    void onFrameRenderFinished(long j2);

    void onFrameRenderStarted(long j2);

    void onSnapShotFinished(Bitmap bitmap, long j2);

    boolean pixelReadCallback(ByteBuffer byteBuffer, long j2, int i2, int i3, int i4, int i5, int i6, String str, int i7, int i8);

    void purgeMemory();

    void removeAllOutputTarget();

    void removeOutputTargetByAddr(String str);

    void render(long j2);

    void runAsyncOnRenderContext(Runnable runnable);

    void runLuaScriptStr(String str);

    void runSyncOnIOContext(Runnable runnable);

    void runSyncOnRenderContext(Runnable runnable);

    void setAlgoPts(long j2);

    void setCameraFace(boolean z);

    void setCaptureData(int i2);

    void setContext(SoftReference<Context> softReference);

    void setInputMatrix(float[] fArr);

    void setInputTexture(int i2, int i3, int i4, int i5);

    void setIsDumpAlgoPixel(boolean z);

    void setIsRender(boolean z);

    void setOnNeedCacheFrameListener(OnNeedCacheFrameListener onNeedCacheFrameListener);

    void setOnRenderFinishedListener(OnRenderFinishedListener onRenderFinishedListener);

    void setOnRenderStartedListener(OnRenderStartedListener onRenderStartedListener);

    void setPixelReaderRotation(PixelReadParams pixelReadParams, PixelRotation pixelRotation);

    void setPixelReaderRotation(PixelRotation pixelRotation);

    void setSourceSyncProperty(boolean z);

    boolean setUpEGLEnv(EGLContext eGLContext);

    void swapBuffer();

    void updateOutputSurfaceRotation(String str, PixelRotation pixelRotation);

    void uploadPixelToTextureFromPath(long j2, String str);
}
