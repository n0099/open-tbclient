package c.a.s0.s.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.s.j;
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
/* loaded from: classes6.dex */
public class g implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public j f13594b;

    /* renamed from: c  reason: collision with root package name */
    public View f13595c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f13596d;

    /* renamed from: e  reason: collision with root package name */
    public View f13597e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13598f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f13599g;

    /* renamed from: h  reason: collision with root package name */
    public String f13600h;

    /* renamed from: i  reason: collision with root package name */
    public int f13601i;

    /* renamed from: j  reason: collision with root package name */
    public int f13602j;
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
        public final /* synthetic */ g f13603e;

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
            this.f13603e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f13603e.l != null) {
                    this.f13603e.l.onClick();
                }
                if (this.f13603e.f13594b == null || this.f13603e.f13594b.d() == null) {
                    return;
                }
                this.f13603e.f13594b.d().onItemClick(this.f13603e.f13594b, this.f13603e.a, this.f13603e.f13596d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1970796680, "Lc/a/s0/s/s/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1970796680, "Lc/a/s0/s/s/g;");
                return;
            }
        }
        q = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        r = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds231);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13600h : (String) invokeV.objValue;
    }

    public final void g() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f13594b) == null || jVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f13594b.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.f13594b.f(), false);
        this.f13595c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f13596d.getTag();
        EMTextView eMTextView = (EMTextView) this.f13595c.findViewById(R.id.item_view);
        this.f13596d = eMTextView;
        eMTextView.setText(this.f13600h);
        this.f13596d.setGravity(this.k);
        this.f13596d.setTag(tag);
        View findViewById = this.f13595c.findViewById(R.id.divider_line);
        this.f13597e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f13595c.findViewById(R.id.item_image);
        this.f13598f = imageView;
        imageView.setImageDrawable(this.f13599g);
        onChangeSkinType();
        this.f13595c.setOnClickListener(this.p);
    }

    @Override // c.a.s0.s.s.i
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13595c : (View) invokeV.objValue;
    }

    public final void h() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f13596d) == null) {
            return;
        }
        eMTextView.setOnClickListener(this.p);
    }

    public final void i() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jVar = this.f13594b) == null || jVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f13594b.getContext()).inflate(R.layout.popup_dialog_view_item, this.f13594b.f(), false);
        this.f13595c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f13596d = eMTextView;
        eMTextView.setText(this.f13600h);
        this.f13596d.setGravity(this.k);
        View findViewById = this.f13595c.findViewById(R.id.divider_line);
        this.f13597e = findViewById;
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
            this.f13599g = drawable;
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
            this.f13600h = str;
            this.f13596d.setText(str);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f13602j = i2;
            SkinManager.setBackgroundResource(this.f13596d, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f13601i = i2;
            SkinManager.setViewTextColor(this.f13596d, i2);
        }
    }

    @Override // c.a.s0.s.s.i
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setBackgroundResource(this.f13596d, this.f13602j);
            SkinManager.setViewTextColorSelector(this.f13596d, this.f13601i);
            SkinManager.setBackgroundColor(this.f13597e, R.color.CAM_X0204);
            MaskView.maskTextView(this.f13596d, this.n);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.n = z;
            MaskView.maskTextView(this.f13596d, z);
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
        this.f13601i = R.color.CAM_X0105;
        this.f13602j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f13600h = str;
        this.f13594b = jVar;
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
        this.f13601i = R.color.CAM_X0105;
        this.f13602j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.a = i2;
        this.f13600h = str;
        this.f13594b = jVar;
        i();
        h();
    }
}
