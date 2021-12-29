package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.c;
import com.baidu.ar.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class a extends d implements ITrack2D {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ITrack2D> mj;
    public ITrack2DStateChangedListener xR;

    public a() {
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

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof ITrack2D)) {
            ITrack2D iTrack2D = (ITrack2D) cVar;
            this.mj = new WeakReference<>(iTrack2D);
            ITrack2DStateChangedListener iTrack2DStateChangedListener = this.xR;
            if (iTrack2DStateChangedListener != null) {
                iTrack2D.setStateChangedListener(iTrack2DStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WeakReference<ITrack2D> weakReference = this.mj;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return this.mj.get().getTargetBitmap();
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        WeakReference<ITrack2D> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().haltTrack();
    }

    @Override // com.baidu.ar.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WeakReference<ITrack2D> weakReference = this.mj;
            if (weakReference != null) {
                weakReference.clear();
                this.mj = null;
            }
            this.xR = null;
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        WeakReference<ITrack2D> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().resumeTrack();
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        WeakReference<ITrack2D> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iTrack2DStateChangedListener) == null) {
            this.xR = iTrack2DStateChangedListener;
            if (iTrack2DStateChangedListener == null || (weakReference = this.mj) == null || weakReference.get() == null) {
                return;
            }
            this.mj.get().setStateChangedListener(this.xR);
        }
    }
}
