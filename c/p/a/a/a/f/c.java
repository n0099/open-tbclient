package c.p.a.a.a.f;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34474a;

    /* renamed from: b  reason: collision with root package name */
    public String f34475b;

    /* renamed from: c  reason: collision with root package name */
    public String f34476c;

    /* renamed from: d  reason: collision with root package name */
    public String f34477d;

    /* renamed from: e  reason: collision with root package name */
    public String f34478e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34479f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34480g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1520c f34481h;

    /* renamed from: i  reason: collision with root package name */
    public View f34482i;

    /* renamed from: j  reason: collision with root package name */
    public int f34483j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f34484a;

        /* renamed from: b  reason: collision with root package name */
        public String f34485b;

        /* renamed from: c  reason: collision with root package name */
        public String f34486c;

        /* renamed from: d  reason: collision with root package name */
        public String f34487d;

        /* renamed from: e  reason: collision with root package name */
        public String f34488e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34489f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f34490g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1520c f34491h;

        /* renamed from: i  reason: collision with root package name */
        public View f34492i;

        /* renamed from: j  reason: collision with root package name */
        public int f34493j;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34484a = context;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34493j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f34490g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC1520c interfaceC1520c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1520c)) == null) {
                this.f34491h = interfaceC1520c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34485b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f34489f = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public c g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f34486c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f34487d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f34488e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* renamed from: c.p.a.a.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1520c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34479f = true;
        this.f34474a = bVar.f34484a;
        this.f34475b = bVar.f34485b;
        this.f34476c = bVar.f34486c;
        this.f34477d = bVar.f34487d;
        this.f34478e = bVar.f34488e;
        this.f34479f = bVar.f34489f;
        this.f34480g = bVar.f34490g;
        this.f34481h = bVar.f34491h;
        this.f34482i = bVar.f34492i;
        this.f34483j = bVar.f34493j;
    }
}
