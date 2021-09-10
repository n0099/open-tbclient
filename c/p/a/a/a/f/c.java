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
    public Context f34447a;

    /* renamed from: b  reason: collision with root package name */
    public String f34448b;

    /* renamed from: c  reason: collision with root package name */
    public String f34449c;

    /* renamed from: d  reason: collision with root package name */
    public String f34450d;

    /* renamed from: e  reason: collision with root package name */
    public String f34451e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34452f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34453g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1519c f34454h;

    /* renamed from: i  reason: collision with root package name */
    public View f34455i;

    /* renamed from: j  reason: collision with root package name */
    public int f34456j;

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
        public Context f34457a;

        /* renamed from: b  reason: collision with root package name */
        public String f34458b;

        /* renamed from: c  reason: collision with root package name */
        public String f34459c;

        /* renamed from: d  reason: collision with root package name */
        public String f34460d;

        /* renamed from: e  reason: collision with root package name */
        public String f34461e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34462f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f34463g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1519c f34464h;

        /* renamed from: i  reason: collision with root package name */
        public View f34465i;

        /* renamed from: j  reason: collision with root package name */
        public int f34466j;

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
            this.f34457a = context;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34466j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f34463g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC1519c interfaceC1519c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1519c)) == null) {
                this.f34464h = interfaceC1519c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34458b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f34462f = z;
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
                this.f34459c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f34460d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f34461e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* renamed from: c.p.a.a.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1519c {
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
        this.f34452f = true;
        this.f34447a = bVar.f34457a;
        this.f34448b = bVar.f34458b;
        this.f34449c = bVar.f34459c;
        this.f34450d = bVar.f34460d;
        this.f34451e = bVar.f34461e;
        this.f34452f = bVar.f34462f;
        this.f34453g = bVar.f34463g;
        this.f34454h = bVar.f34464h;
        this.f34455i = bVar.f34465i;
        this.f34456j = bVar.f34466j;
    }
}
