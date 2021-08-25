package c.a.p0.s.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.s.i;
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
/* loaded from: classes3.dex */
public class f implements h {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14460a;

    /* renamed from: b  reason: collision with root package name */
    public i f14461b;

    /* renamed from: c  reason: collision with root package name */
    public View f14462c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f14463d;

    /* renamed from: e  reason: collision with root package name */
    public View f14464e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14465f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f14466g;

    /* renamed from: h  reason: collision with root package name */
    public String f14467h;

    /* renamed from: i  reason: collision with root package name */
    public int f14468i;

    /* renamed from: j  reason: collision with root package name */
    public int f14469j;
    public i.d k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final View.OnClickListener o;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14470e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14470e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14470e.k != null) {
                    this.f14470e.k.onClick();
                }
                if (this.f14470e.f14461b == null || this.f14470e.f14461b.e() == null) {
                    return;
                }
                this.f14470e.f14461b.e().onItemClick(this.f14470e.f14461b, this.f14470e.f14460a, this.f14470e.f14463d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843400618, "Lc/a/p0/s/s/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843400618, "Lc/a/p0/s/s/f;");
                return;
            }
        }
        p = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        q = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(i iVar) {
        this(null, iVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (i) objArr2[1]);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14460a : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14467h : (String) invokeV.objValue;
    }

    public final void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iVar = this.f14461b) == null || iVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f14461b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f14461b.g(), false);
        this.f14462c = inflate;
        inflate.getLayoutParams().width = this.n ? q : p;
        Object tag = this.f14463d.getTag();
        EMTextView eMTextView = (EMTextView) this.f14462c.findViewById(R.id.item_view);
        this.f14463d = eMTextView;
        eMTextView.setText(this.f14467h);
        this.f14463d.setGravity(this.f14469j);
        this.f14463d.setTag(tag);
        View findViewById = this.f14462c.findViewById(R.id.divider_line);
        this.f14464e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f14462c.findViewById(R.id.item_image);
        this.f14465f = imageView;
        imageView.setImageDrawable(this.f14466g);
        onChangeSkinType();
        this.f14462c.setOnClickListener(this.o);
    }

    @Override // c.a.p0.s.s.h
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14462c : (View) invokeV.objValue;
    }

    public final void h() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f14463d) == null) {
            return;
        }
        eMTextView.setOnClickListener(this.o);
    }

    public final void i() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.f14461b) == null || iVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f14461b.d()).inflate(R.layout.popup_dialog_view_item, this.f14461b.g(), false);
        this.f14462c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f14463d = eMTextView;
        eMTextView.setText(this.f14467h);
        this.f14463d.setGravity(this.f14469j);
        View findViewById = this.f14462c.findViewById(R.id.divider_line);
        this.f14464e = findViewById;
        if (this.l) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        onChangeSkinType();
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }

    public void k(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            this.f14466g = drawable;
        }
    }

    public void l(i.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.k = dVar;
            h();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f14467h = str;
            this.f14463d.setText(str);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f14468i = i2;
            SkinManager.setViewTextColor(this.f14463d, i2);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
            MaskView.maskTextView(this.f14463d, z);
        }
    }

    @Override // c.a.p0.s.s.h
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setViewTextColorSelector(this.f14463d, this.f14468i);
            SkinManager.setBackgroundColor(this.f14464e, R.color.CAM_X0204);
            MaskView.maskTextView(this.f14463d, this.m);
        }
    }

    public f(String str, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f14468i = R.color.CAM_X0105;
        this.f14469j = 17;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = new a(this);
        this.f14467h = str;
        this.f14461b = iVar;
        this.f14460a = hashCode();
        i();
        h();
    }

    public f(int i2, String str, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14468i = R.color.CAM_X0105;
        this.f14469j = 17;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = new a(this);
        this.f14460a = i2;
        this.f14467h = str;
        this.f14461b = iVar;
        i();
        h();
    }
}
