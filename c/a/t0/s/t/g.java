package c.a.t0.s.t;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.t.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public j f14059b;

    /* renamed from: c  reason: collision with root package name */
    public View f14060c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f14061d;

    /* renamed from: e  reason: collision with root package name */
    public View f14062e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14063f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f14064g;

    /* renamed from: h  reason: collision with root package name */
    public String f14065h;

    /* renamed from: i  reason: collision with root package name */
    public int f14066i;

    /* renamed from: j  reason: collision with root package name */
    public int f14067j;
    public int k;
    public j.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f14068e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14068e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14068e.l != null) {
                    this.f14068e.l.onClick();
                }
                if (this.f14068e.f14059b == null || this.f14068e.f14059b.d() == null) {
                    return;
                }
                this.f14068e.f14059b.d().onItemClick(this.f14068e.f14059b, this.f14068e.a, this.f14068e.f14061d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(516745944, "Lc/a/t0/s/t/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(516745944, "Lc/a/t0/s/t/g;");
                return;
            }
        }
        q = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.a4.e.tbds251);
        r = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.a4.e.tbds231);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(j jVar) {
        this(null, jVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (j) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g();
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14065h : (String) invokeV.objValue;
    }

    public final void g() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f14059b) == null || jVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f14059b.getContext()).inflate(c.a.u0.a4.h.popup_dialog_view_horizal_item, this.f14059b.f(), false);
        this.f14060c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f14061d.getTag();
        EMTextView eMTextView = (EMTextView) this.f14060c.findViewById(c.a.u0.a4.g.item_view);
        this.f14061d = eMTextView;
        eMTextView.setText(this.f14065h);
        this.f14061d.setGravity(this.k);
        this.f14061d.setTag(tag);
        View findViewById = this.f14060c.findViewById(c.a.u0.a4.g.divider_line);
        this.f14062e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f14060c.findViewById(c.a.u0.a4.g.item_image);
        this.f14063f = imageView;
        imageView.setImageDrawable(this.f14064g);
        onChangeSkinType();
        this.f14060c.setOnClickListener(this.p);
    }

    @Override // c.a.t0.s.t.i
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14060c : (View) invokeV.objValue;
    }

    public final void h() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f14061d) == null) {
            return;
        }
        eMTextView.setOnClickListener(this.p);
    }

    public final void i() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jVar = this.f14059b) == null || jVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f14059b.getContext()).inflate(c.a.u0.a4.h.popup_dialog_view_item, this.f14059b.f(), false);
        this.f14060c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(c.a.u0.a4.g.item_view);
        this.f14061d = eMTextView;
        eMTextView.setText(this.f14065h);
        this.f14061d.setGravity(this.k);
        View findViewById = this.f14060c.findViewById(c.a.u0.a4.g.divider_line);
        this.f14062e = findViewById;
        if (this.m) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        onChangeSkinType();
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.o = z;
        }
    }

    public void k(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            this.f14064g = drawable;
        }
    }

    public void l(j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.l = dVar;
            h();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f14065h = str;
            this.f14061d.setText(str);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f14067j = i2;
            SkinManager.setBackgroundResource(this.f14061d, i2);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.t0.s.v.c.d(this.f14061d).A(c.a.u0.a4.j.F_X02);
        }
    }

    @Override // c.a.t0.s.t.i
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setBackgroundResource(this.f14061d, this.f14067j);
            SkinManager.setViewTextColorSelector(this.f14061d, this.f14066i);
            SkinManager.setBackgroundColor(this.f14062e, c.a.u0.a4.d.CAM_X0204);
            MaskView.maskTextView(this.f14061d, this.n);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f14066i = i2;
            SkinManager.setViewTextColor(this.f14061d, i2);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
            MaskView.maskTextView(this.f14061d, z);
        }
    }

    public g(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f14066i = c.a.u0.a4.d.CAM_X0105;
        this.f14067j = c.a.u0.a4.d.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f14065h = str;
        this.f14059b = jVar;
        this.a = hashCode();
        i();
        h();
    }

    public g(int i2, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14066i = c.a.u0.a4.d.CAM_X0105;
        this.f14067j = c.a.u0.a4.d.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.a = i2;
        this.f14065h = str;
        this.f14059b = jVar;
        i();
        h();
    }
}
