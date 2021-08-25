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
    public Context f34338a;

    /* renamed from: b  reason: collision with root package name */
    public String f34339b;

    /* renamed from: c  reason: collision with root package name */
    public String f34340c;

    /* renamed from: d  reason: collision with root package name */
    public String f34341d;

    /* renamed from: e  reason: collision with root package name */
    public String f34342e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34343f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f34344g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1519c f34345h;

    /* renamed from: i  reason: collision with root package name */
    public View f34346i;

    /* renamed from: j  reason: collision with root package name */
    public int f34347j;

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
        public Context f34348a;

        /* renamed from: b  reason: collision with root package name */
        public String f34349b;

        /* renamed from: c  reason: collision with root package name */
        public String f34350c;

        /* renamed from: d  reason: collision with root package name */
        public String f34351d;

        /* renamed from: e  reason: collision with root package name */
        public String f34352e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34353f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f34354g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1519c f34355h;

        /* renamed from: i  reason: collision with root package name */
        public View f34356i;

        /* renamed from: j  reason: collision with root package name */
        public int f34357j;

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
            this.f34348a = context;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f34357j = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
                this.f34354g = drawable;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(InterfaceC1519c interfaceC1519c) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1519c)) == null) {
                this.f34355h = interfaceC1519c;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f34349b = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f34353f = z;
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
                this.f34350c = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f34351d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f34352e = str;
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
        this.f34343f = true;
        this.f34338a = bVar.f34348a;
        this.f34339b = bVar.f34349b;
        this.f34340c = bVar.f34350c;
        this.f34341d = bVar.f34351d;
        this.f34342e = bVar.f34352e;
        this.f34343f = bVar.f34353f;
        this.f34344g = bVar.f34354g;
        this.f34345h = bVar.f34355h;
        this.f34346i = bVar.f34356i;
        this.f34347j = bVar.f34357j;
    }
}
