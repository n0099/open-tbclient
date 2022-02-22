package c.a.u0.u0.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends c.a.t0.x.p.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
        t();
    }

    @Override // c.a.t0.x.p.d
    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int intValue = (i2 < 0 || i2 >= c.a.t0.x.p.c.f14612b.size()) ? 0 : c.a.t0.x.p.c.f14612b.get(i2).intValue();
            for (Map.Entry<String, Integer> entry : c.a.t0.x.p.c.f14613c.entrySet()) {
                if (entry.getValue().intValue() == intValue) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // c.a.t0.x.p.d
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.t0.x.p.c.f14612b.size() : invokeV.intValue;
    }

    @Override // c.a.t0.x.p.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "_local" : (String) invokeV.objValue;
    }

    @Override // c.a.t0.x.p.d
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "_local" : (String) invokeV.objValue;
    }

    @Override // c.a.t0.x.p.d
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? EmotionGroupType.LOCAL : (EmotionGroupType) invokeV.objValue;
    }

    @Override // c.a.t0.x.p.d
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.x.p.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.x.p.d
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.x.p.d
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? c.a.t0.x.p.c.f14613c.get(str) != null : invokeL.booleanValue;
    }

    @Override // c.a.t0.x.p.d
    public c.a.d.o.d.a n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? o(str) : (c.a.d.o.d.a) invokeL.objValue;
    }

    @Override // c.a.t0.x.p.d
    public c.a.d.o.d.a o(String str) {
        InterceptResult invokeL;
        Bitmap e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Integer num = c.a.t0.x.p.c.f14613c.get(str);
            if (num == null || (e2 = f.d().e(TbadkCoreApplication.getInst().getApp(), num.intValue())) == null) {
                return null;
            }
            return new c.a.d.o.d.a(e2, false, str);
        }
        return (c.a.d.o.d.a) invokeL.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.p(7);
            super.s(3);
            c.a.d.o.d.a aVar = new c.a.d.o.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_face_original_s), false);
            super.r(aVar);
            super.q(aVar);
        }
    }
}
