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
    public Context f34232a;

    /* renamed from: b  reason: collision with root package name */
    public String f34233b;

    /* renamed from: c  reason: collision with root package name */
    public String f34234c;

    /* renamed from: d  reason: collision with root package name */
    public String f34235d;

    /* renamed from: e  reason: collision with root package name */
    public String f34236e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34237f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34238g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1515c f34239h;

    /* renamed from: i  reason: collision with root package name */
    public View f34240i;

    /* renamed from: j  reason: collision with root package name */
    public int f34241j;

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
        public Context f34242a;

        /* renamed from: b  reason: collision with root package name */
        public String f34243b;

        /* renamed from: c  reason: collision with root package name */
        public String f34244c;

        /* renamed from: d  reason: collision with root package name */
        public String f34245d;

        /* renamed from: e  reason: collision with root package name */
        public String f34246e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34247f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f34248g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1515c f34249h;

        /* renamed from: i  reason: collision with root package name */
        public View f34250i;

        /* renamed from: j  reason: collision with root package name */
        public int f34251j;

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
            this.f34242a = context;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34251j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f34248g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC1515c interfaceC1515c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1515c)) == null) {
                this.f34249h = interfaceC1515c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34243b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f34247f = z;
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
                this.f34244c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f34245d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f34246e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* renamed from: c.p.a.a.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1515c {
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
        this.f34237f = true;
        this.f34232a = bVar.f34242a;
        this.f34233b = bVar.f34243b;
        this.f34234c = bVar.f34244c;
        this.f34235d = bVar.f34245d;
        this.f34236e = bVar.f34246e;
        this.f34237f = bVar.f34247f;
        this.f34238g = bVar.f34248g;
        this.f34239h = bVar.f34249h;
        this.f34240i = bVar.f34250i;
        this.f34241j = bVar.f34251j;
    }
}
