package c.a.p0.a.s.c.c;

import android.content.Context;
import androidx.annotation.NonNull;
import c.a.p0.a.s.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c.a.p0.a.s.b.a<CameraPreview, c.a.p0.a.p.e.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull c.a.p0.a.p.e.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.b.a
    @NonNull
    /* renamed from: F */
    public CameraPreview v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new CameraPreview(context, n()) : (CameraPreview) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.b.a
    /* renamed from: G */
    public void C(@NonNull CameraPreview cameraPreview, @NonNull c.a.p0.a.p.e.a aVar, @NonNull c.a.p0.a.s.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cameraPreview, aVar, bVar) == null) {
            super.C(cameraPreview, aVar, bVar);
            if (t()) {
                cameraPreview.updateAttr(aVar);
            }
        }
    }

    @Override // c.a.p0.a.s.b.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.z();
            CameraPreview q = q();
            if (q != null) {
                q.onRelease();
            }
        }
    }
}
