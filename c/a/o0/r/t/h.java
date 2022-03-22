package c.a.o0.r.t;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public l f11051b;

    /* renamed from: c  reason: collision with root package name */
    public View f11052c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f11053d;

    /* renamed from: e  reason: collision with root package name */
    public View f11054e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f11055f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f11056g;

    /* renamed from: h  reason: collision with root package name */
    public String f11057h;
    public int i;
    public int j;
    public int k;
    public l.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.l != null) {
                    this.a.l.onClick();
                }
                if (this.a.f11051b == null || this.a.f11051b.d() == null) {
                    return;
                }
                this.a.f11051b.d().onItemClick(this.a.f11051b, this.a.a, this.a.f11053d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935454547, "Lc/a/o0/r/t/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935454547, "Lc/a/o0/r/t/h;");
                return;
            }
        }
        q = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        r = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(l lVar) {
        this(null, lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (l) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.r.t.k
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f11053d, this.j);
            SkinManager.setViewTextColorSelector(this.f11053d, this.i);
            SkinManager.setBackgroundColor(this.f11054e, R.color.CAM_X0204);
            MaskView.d(this.f11053d, this.n);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11057h : (String) invokeV.objValue;
    }

    @Override // c.a.o0.r.t.k
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11052c : (View) invokeV.objValue;
    }

    public final void h() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lVar = this.f11051b) == null || lVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f11051b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f9, this.f11051b.f(), false);
        this.f11052c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f11053d.getTag();
        EMTextView eMTextView = (EMTextView) this.f11052c.findViewById(R.id.obfuscated_res_0x7f090fb2);
        this.f11053d = eMTextView;
        eMTextView.setText(this.f11057h);
        this.f11053d.setGravity(this.k);
        this.f11053d.setTag(tag);
        View findViewById = this.f11052c.findViewById(R.id.obfuscated_res_0x7f0907f4);
        this.f11054e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f11052c.findViewById(R.id.obfuscated_res_0x7f090f7c);
        this.f11055f = imageView;
        imageView.setImageDrawable(this.f11056g);
        a();
        this.f11052c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eMTextView = this.f11053d) == null) {
            return;
        }
        eMTextView.setOnClickListener(this.p);
    }

    public final void j() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lVar = this.f11051b) == null || lVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f11051b.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06fa, this.f11051b.f(), false);
        this.f11052c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090fb2);
        this.f11053d = eMTextView;
        eMTextView.setText(this.f11057h);
        this.f11053d.setGravity(this.k);
        View findViewById = this.f11052c.findViewById(R.id.obfuscated_res_0x7f0907f4);
        this.f11054e = findViewById;
        if (this.m) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public void l(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.f11056g = drawable;
        }
    }

    public void m(l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.l = dVar;
            i();
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f11057h = str;
            this.f11053d.setText(str);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j = i;
            SkinManager.setBackgroundResource(this.f11053d, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.o0.r.v.c.d(this.f11053d).A(R.string.F_X02);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = i;
            SkinManager.setViewTextColor(this.f11053d, i);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
            MaskView.d(this.f11053d, z);
        }
    }

    public h(String str, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, lVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f11057h = str;
        this.f11051b = lVar;
        this.a = hashCode();
        j();
        i();
    }

    public h(int i, String str, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.a = i;
        this.f11057h = str;
        this.f11051b = lVar;
        j();
        i();
    }
}
