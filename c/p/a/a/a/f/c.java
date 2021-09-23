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
    public Context f34470a;

    /* renamed from: b  reason: collision with root package name */
    public String f34471b;

    /* renamed from: c  reason: collision with root package name */
    public String f34472c;

    /* renamed from: d  reason: collision with root package name */
    public String f34473d;

    /* renamed from: e  reason: collision with root package name */
    public String f34474e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34475f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34476g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1518c f34477h;

    /* renamed from: i  reason: collision with root package name */
    public View f34478i;

    /* renamed from: j  reason: collision with root package name */
    public int f34479j;

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
        public Context f34480a;

        /* renamed from: b  reason: collision with root package name */
        public String f34481b;

        /* renamed from: c  reason: collision with root package name */
        public String f34482c;

        /* renamed from: d  reason: collision with root package name */
        public String f34483d;

        /* renamed from: e  reason: collision with root package name */
        public String f34484e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34485f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f34486g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1518c f34487h;

        /* renamed from: i  reason: collision with root package name */
        public View f34488i;

        /* renamed from: j  reason: collision with root package name */
        public int f34489j;

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
            this.f34480a = context;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34489j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f34486g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC1518c interfaceC1518c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1518c)) == null) {
                this.f34487h = interfaceC1518c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34481b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f34485f = z;
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
                this.f34482c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f34483d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f34484e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* renamed from: c.p.a.a.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1518c {
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
        this.f34475f = true;
        this.f34470a = bVar.f34480a;
        this.f34471b = bVar.f34481b;
        this.f34472c = bVar.f34482c;
        this.f34473d = bVar.f34483d;
        this.f34474e = bVar.f34484e;
        this.f34475f = bVar.f34485f;
        this.f34476g = bVar.f34486g;
        this.f34477h = bVar.f34487h;
        this.f34478i = bVar.f34488i;
        this.f34479j = bVar.f34489j;
    }
}
