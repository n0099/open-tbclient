package com.baidu.ar.face;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements IFace {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String L;
    public WeakReference<IFace> nD;
    public FaceListener nq;

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
    public void a(com.baidu.ar.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                WeakReference<IFace> weakReference = this.nD;
                if (weakReference != null) {
                    weakReference.clear();
                    this.nD = null;
                    return;
                }
                return;
            }
            if (cVar instanceof IFace) {
                this.nD = new WeakReference<>((IFace) cVar);
                if (!TextUtils.isEmpty(this.L)) {
                    this.nD.get().setFaceModelPath(this.L);
                }
            }
            if (this.nq != null) {
                this.nD.get().setFaceListener(this.nq);
            }
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WeakReference<IFace> weakReference = this.nD;
            if (weakReference != null) {
                weakReference.clear();
                this.nD = null;
            }
            this.nq = null;
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceListener) == null) {
            this.nq = faceListener;
            WeakReference<IFace> weakReference = this.nD;
            if (weakReference != null) {
                weakReference.get().setFaceListener(this.nq);
            }
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceModelPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.L = str;
            WeakReference<IFace> weakReference = this.nD;
            if (weakReference != null) {
                weakReference.get().setFaceModelPath(str);
            }
        }
    }
}
