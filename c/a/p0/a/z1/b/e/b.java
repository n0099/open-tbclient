package c.a.p0.a.z1.b.e;

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

    /* renamed from: a  reason: collision with root package name */
    public final int f10026a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10027b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10028c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f10029d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f10030e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10031f;

    /* renamed from: g  reason: collision with root package name */
    public long f10032g;

    /* renamed from: h  reason: collision with root package name */
    public int f10033h;

    /* renamed from: i  reason: collision with root package name */
    public a f10034i;

    /* renamed from: j  reason: collision with root package name */
    public Context f10035j;

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
        this.f10027b = true;
        this.f10028c = false;
        this.f10031f = true;
        this.f10032g = 0L;
        this.f10033h = 0;
        this.f10035j = context;
        this.f10026a = i2;
        this.f10029d = charSequence;
        this.f10030e = drawable;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10032g : invokeV.longValue;
    }

    public Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.f10030e;
            if (drawable != null) {
                return drawable;
            }
            if (this.f10033h != 0) {
                Drawable drawable2 = this.f10035j.getResources().getDrawable(this.f10033h);
                this.f10033h = 0;
                this.f10030e = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10026a : invokeV.intValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10034i : (a) invokeV.objValue;
    }

    public CharSequence e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10029d : (CharSequence) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f10031f : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f10027b : invokeV.booleanValue;
    }

    public void h(c.a.p0.a.z1.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f10034i = aVar;
        }
    }
}
