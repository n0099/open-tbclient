package b.a.x.b.g;

import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float[] f29408e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f29409f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29410g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29411h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float[] fArr = new float[16];
        this.f29408e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f29409f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f29410g = false;
        this.f29411h = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public b clone() {
        b bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                bVar = (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                bVar = null;
            }
            if (bVar != null) {
                bVar.g((float[]) this.f29408e.clone());
                bVar.h((float[]) this.f29409f.clone());
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public float[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29408e : (float[]) invokeV.objValue;
    }

    public float[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29409f : (float[]) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29411h : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29410g : invokeV.booleanValue;
    }

    public void g(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fArr) == null) {
            this.f29408e = fArr;
        }
    }

    public void h(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fArr) == null) {
            this.f29409f = fArr;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
        }
    }
}
