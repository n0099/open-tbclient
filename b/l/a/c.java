package b.l.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f33984a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f33985b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f33986c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f33987d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f33988e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> f33989f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> f33990g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33991h;

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
        this.f33984a = new HashMap<>();
        this.f33985b = new HashMap<>();
        this.f33986c = new HashMap<>();
        this.f33987d = new HashMap<>();
        this.f33988e = new HashMap<>();
        this.f33989f = new HashMap<>();
        this.f33990g = new HashMap<>();
    }

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33989f : (HashMap) invokeV.objValue;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33990g : (HashMap) invokeV.objValue;
    }

    public final HashMap<String, Boolean> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33984a : (HashMap) invokeV.objValue;
    }

    public final HashMap<String, Bitmap> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33985b : (HashMap) invokeV.objValue;
    }

    public final HashMap<String, StaticLayout> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33988e : (HashMap) invokeV.objValue;
    }

    public final HashMap<String, String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33986c : (HashMap) invokeV.objValue;
    }

    public final HashMap<String, TextPaint> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33987d : (HashMap) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33991h : invokeV.booleanValue;
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f33991h = z;
        }
    }
}
