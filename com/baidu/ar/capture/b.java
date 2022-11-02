package com.baidu.ar.capture;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b extends com.baidu.ar.d implements ICapture {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ICapture> la;
    public ICaptureAbilityListener lb;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                WeakReference<ICapture> weakReference = this.la;
                if (weakReference != null) {
                    weakReference.clear();
                    this.la = null;
                }
            } else if (cVar instanceof ICapture) {
                WeakReference<ICapture> weakReference2 = new WeakReference<>((ICapture) cVar);
                this.la = weakReference2;
                if (this.lb != null) {
                    weakReference2.get().setAbilityListener(this.lb);
                }
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void capture(ICallbackWith<ICaptureResult> iCallbackWith) {
        WeakReference<ICapture> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCallbackWith) == null) || (weakReference = this.la) == null || weakReference.get() == null || iCallbackWith == null) {
            return;
        }
        this.la.get().capture(iCallbackWith);
    }

    @Override // com.baidu.ar.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.lb = null;
            WeakReference<ICapture> weakReference = this.la;
            if (weakReference != null) {
                weakReference.clear();
                this.la = null;
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendBase64ImageToLua(String... strArr) {
        WeakReference<ICapture> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, strArr) == null) || (weakReference = this.la) == null || weakReference.get() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        this.la.get().sendBase64ImageToLua(strArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void sendImageToLua(Bitmap... bitmapArr) {
        WeakReference<ICapture> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bitmapArr) == null) || (weakReference = this.la) == null || weakReference.get() == null || bitmapArr == null || bitmapArr.length <= 0) {
            return;
        }
        this.la.get().sendImageToLua(bitmapArr);
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setAbilityListener(ICaptureAbilityListener iCaptureAbilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iCaptureAbilityListener) == null) {
            WeakReference<ICapture> weakReference = this.la;
            if (weakReference == null || weakReference.get() == null) {
                this.lb = iCaptureAbilityListener;
            } else {
                this.la.get().setAbilityListener(iCaptureAbilityListener);
            }
        }
    }

    @Override // com.baidu.ar.capture.ICapture
    public void setCaptureCallback(ICallbackWith<ICaptureResult> iCallbackWith) {
        WeakReference<ICapture> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iCallbackWith) == null) || (weakReference = this.la) == null || weakReference.get() == null || iCallbackWith == null) {
            return;
        }
        this.la.get().setCaptureCallback(iCallbackWith);
    }
}
