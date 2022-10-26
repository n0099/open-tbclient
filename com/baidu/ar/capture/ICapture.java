package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.ar.callback.ICallbackWith;
/* loaded from: classes.dex */
public interface ICapture {
    void capture(ICallbackWith iCallbackWith);

    void sendBase64ImageToLua(String... strArr);

    void sendImageToLua(Bitmap... bitmapArr);

    void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener);

    void setCaptureCallback(ICallbackWith iCallbackWith);
}
