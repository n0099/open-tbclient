package c.a.r0.a.c2.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5565b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5566c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f5567d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f5568e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5569f;

    /* renamed from: g  reason: collision with root package name */
    public long f5570g;

    /* renamed from: h  reason: collision with root package name */
    public int f5571h;

    /* renamed from: i  reason: collision with root package name */
    public a f5572i;

    /* renamed from: j  reason: collision with root package name */
    public Context f5573j;

    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);
    }

    public b(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5565b = true;
        this.f5566c = false;
        this.f5569f = true;
        this.f5570g = 0L;
        this.f5571h = 0;
        this.f5573j = context;
        this.a = i2;
        this.f5567d = charSequence;
        this.f5568e = drawable;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5570g : invokeV.longValue;
    }

    public Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.f5568e;
            if (drawable != null) {
                return drawable;
            }
            if (this.f5571h != 0) {
                Drawable drawable2 = this.f5573j.getResources().getDrawable(this.f5571h);
                this.f5571h = 0;
                this.f5568e = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5572i : (a) invokeV.objValue;
    }

    public CharSequence e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5567d : (CharSequence) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5569f : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5565b : invokeV.booleanValue;
    }

    public void h(c.a.r0.a.c2.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f5572i = aVar;
        }
    }
}
