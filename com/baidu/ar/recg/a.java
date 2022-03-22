package com.baidu.ar.recg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.c;
import com.baidu.ar.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements IOnDeviceIR {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<IOnDeviceIR> mj;
    public IOnDeviceIRStateChangedListener tT;

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
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof IOnDeviceIR)) {
            IOnDeviceIR iOnDeviceIR = (IOnDeviceIR) cVar;
            this.mj = new WeakReference<>(iOnDeviceIR);
            IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener = this.tT;
            if (iOnDeviceIRStateChangedListener != null) {
                iOnDeviceIR.setStateChangedListener(iOnDeviceIRStateChangedListener);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WeakReference<IOnDeviceIR> weakReference = this.mj;
            if (weakReference != null) {
                weakReference.clear();
                this.mj = null;
            }
            this.tT = null;
        }
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void retry() {
        WeakReference<IOnDeviceIR> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().retry();
    }

    @Override // com.baidu.ar.recg.IOnDeviceIR
    public void setStateChangedListener(IOnDeviceIRStateChangedListener iOnDeviceIRStateChangedListener) {
        WeakReference<IOnDeviceIR> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iOnDeviceIRStateChangedListener) == null) {
            this.tT = iOnDeviceIRStateChangedListener;
            if (iOnDeviceIRStateChangedListener == null || (weakReference = this.mj) == null || weakReference.get() == null) {
                return;
            }
            this.mj.get().setStateChangedListener(this.tT);
        }
    }
}
