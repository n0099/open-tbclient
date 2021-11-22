package b.a.q0.s.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.i;
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
/* loaded from: classes4.dex */
public class f implements h {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14335a;

    /* renamed from: b  reason: collision with root package name */
    public i f14336b;

    /* renamed from: c  reason: collision with root package name */
    public View f14337c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f14338d;

    /* renamed from: e  reason: collision with root package name */
    public View f14339e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14340f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f14341g;

    /* renamed from: h  reason: collision with root package name */
    public String f14342h;

    /* renamed from: i  reason: collision with root package name */
    public int f14343i;
    public int j;
    public int k;
    public i.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14344e;

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
            this.f14344e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14344e.l != null) {
                    this.f14344e.l.onClick();
                }
                if (this.f14344e.f14336b == null || this.f14344e.f14336b.d() == null) {
                    return;
                }
                this.f14344e.f14336b.d().onItemClick(this.f14344e.f14336b, this.f14344e.f14335a, this.f14344e.f14338d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1937515222, "Lb/a/q0/s/s/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1937515222, "Lb/a/q0/s/s/f;");
                return;
            }
        }
        q = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        r = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14335a : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14342h : (String) invokeV.objValue;
    }

    public final void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iVar = this.f14336b) == null || iVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f14336b.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.f14336b.f(), false);
        this.f14337c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f14338d.getTag();
        EMTextView eMTextView = (EMTextView) this.f14337c.findViewById(R.id.item_view);
        this.f14338d = eMTextView;
        eMTextView.setText(this.f14342h);
        this.f14338d.setGravity(this.k);
        this.f14338d.setTag(tag);
        View findViewById = this.f14337c.findViewById(R.id.divider_line);
        this.f14339e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f14337c.findViewById(R.id.item_image);
        this.f14340f = imageView;
        imageView.setImageDrawable(this.f14341g);
        onChangeSkinType();
        this.f14337c.setOnClickListener(this.p);
    }

    @Override // b.a.q0.s.s.h
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14337c : (View) invokeV.objValue;
    }

    public final void h() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f14338d) == null) {
            return;
        }
        eMTextView.setOnClickListener(this.p);
    }

    public final void i() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.f14336b) == null || iVar.getContext() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f14336b.getContext()).inflate(R.layout.popup_dialog_view_item, this.f14336b.f(), false);
        this.f14337c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f14338d = eMTextView;
        eMTextView.setText(this.f14342h);
        this.f14338d.setGravity(this.k);
        View findViewById = this.f14337c.findViewById(R.id.divider_line);
        this.f14339e = findViewById;
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
            this.f14341g = drawable;
        }
    }

    public void l(i.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.l = dVar;
            h();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f14342h = str;
            this.f14338d.setText(str);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.j = i2;
            SkinManager.setBackgroundResource(this.f14338d, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f14343i = i2;
            SkinManager.setViewTextColor(this.f14338d, i2);
        }
    }

    @Override // b.a.q0.s.s.h
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setBackgroundResource(this.f14338d, this.j);
            SkinManager.setViewTextColorSelector(this.f14338d, this.f14343i);
            SkinManager.setBackgroundColor(this.f14339e, R.color.CAM_X0204);
            MaskView.maskTextView(this.f14338d, this.n);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.n = z;
            MaskView.maskTextView(this.f14338d, z);
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
        this.f14343i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f14342h = str;
        this.f14336b = iVar;
        this.f14335a = hashCode();
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
        this.f14343i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.f14335a = i2;
        this.f14342h = str;
        this.f14336b = iVar;
        i();
        h();
    }
}
