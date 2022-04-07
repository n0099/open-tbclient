package com.baidu.ar.cloud;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.c;
import com.baidu.ar.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends d implements ICloudIR {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ICloudIR> mj;
    public ICloudIRStateChangedListener mk;

    public a() {
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
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof ICloudIR)) {
            ICloudIR iCloudIR = (ICloudIR) cVar;
            this.mj = new WeakReference<>(iCloudIR);
            ICloudIRStateChangedListener iCloudIRStateChangedListener = this.mk;
            if (iCloudIRStateChangedListener != null) {
                iCloudIR.setStateChangedListener(iCloudIRStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void pause() {
        WeakReference<ICloudIR> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WeakReference<ICloudIR> weakReference = this.mj;
            if (weakReference != null) {
                weakReference.clear();
                this.mj = null;
            }
            this.mk = null;
        }
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void resume() {
        WeakReference<ICloudIR> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().resume();
    }

    @Override // com.baidu.ar.cloud.ICloudIR
    public void setStateChangedListener(ICloudIRStateChangedListener iCloudIRStateChangedListener) {
        WeakReference<ICloudIR> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iCloudIRStateChangedListener) == null) {
            this.mk = iCloudIRStateChangedListener;
            if (iCloudIRStateChangedListener == null || (weakReference = this.mj) == null || weakReference.get() == null) {
                return;
            }
            this.mj.get().setStateChangedListener(this.mk);
        }
    }
}
