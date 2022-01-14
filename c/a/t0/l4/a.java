package c.a.t0.l4;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.l.d;
import c.a.d.f.p.m;
import c.a.s0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends c.a.s0.s.s.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f19158e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19159f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19160g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f19161h;

    /* renamed from: i  reason: collision with root package name */
    public TbCheckBox f19162i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19163j;
    public Button k;
    public Button l;
    public ImageView m;
    public String n;
    public String o;
    public String p;
    public a.e q;
    public String r;
    public a.e s;
    public String t;
    public CompoundButton.OnCheckedChangeListener u;
    public boolean v;
    public TbCheckBox.b w;
    public final c.a.d.f.l.c<c.a.d.n.d.a> x;

    /* renamed from: c.a.t0.l4.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1198a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1198a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) || this.a.u == null) {
                return;
            }
            this.a.u.onCheckedChanged(null, z);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.a.f19159f.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                this.a.f19159f.setBackgroundResource(0);
                this.a.f19159f.setImageDrawable(null);
                aVar.h(this.a.f19159f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19164e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19164e = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19164e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f19164e = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = false;
        this.w = new C1198a(this);
        this.x = new b(this);
        c();
        setContentViewSize(1);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
            this.f19158e = viewGroup;
            this.f19159f = (ImageView) viewGroup.findViewById(R.id.dialog_bg);
            this.f19160g = (TextView) this.f19158e.findViewById(R.id.message);
            Button button = (Button) this.f19158e.findViewById(R.id.negative_btn);
            this.l = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.f19158e.findViewById(R.id.positive_btn);
            this.k = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f19158e.findViewById(R.id.close);
            this.m = imageView;
            imageView.setOnClickListener(this);
            this.f19161h = (ViewGroup) this.f19158e.findViewById(R.id.checkbox_container);
            this.f19163j = (TextView) this.f19158e.findViewById(R.id.checkbox_text);
            TbCheckBox tbCheckBox = (TbCheckBox) this.f19158e.findViewById(R.id.checkbox);
            this.f19162i = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
            this.f19162i.setStatedChangedListener(this.w);
            this.f19162i.setTagData(new c(this));
            this.f19161h.setClickable(true);
            this.f19161h.setOnClickListener(this);
            setContentView(this.f19158e);
        }
    }

    @Override // c.a.s0.s.s.a
    public c.a.s0.s.s.a create(f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.v) {
                return this;
            }
            this.v = true;
            super.create(fVar);
            if (!m.isEmpty(this.o)) {
                this.f19160g.setText(this.o);
            }
            if (!m.isEmpty(this.t)) {
                this.f19163j.setText(this.t);
            } else {
                this.f19161h.setVisibility(4);
            }
            if (!m.isEmpty(this.r)) {
                this.l.setText(this.r);
            }
            if (!m.isEmpty(this.p)) {
                this.k.setText(this.p);
            }
            if (!TextUtils.isEmpty(this.n)) {
                d.h().m(this.n, 10, this.x, fVar.getUniqueId());
            } else {
                this.f19159f.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (c.a.s0.s.s.a) invokeL.objValue;
    }

    public a d(@StringRes int i2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onCheckedChangeListener)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.t = activity.getResources().getString(i2);
                this.u = onCheckedChangeListener;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(@StringRes int i2, a.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.r = activity.getResources().getString(i2);
                this.s = eVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a h(int i2, a.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.p = activity.getResources().getString(i2);
                this.q = eVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a i(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, eVar)) == null) {
            this.p = str;
            this.q = eVar;
            return this;
        }
        return (a) invokeLL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.positive_btn) {
            a.e eVar = this.q;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.negative_btn) {
            a.e eVar2 = this.s;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.close) {
            dismiss();
        } else if (id == R.id.checkbox_container) {
            TbCheckBox tbCheckBox = this.f19162i;
            tbCheckBox.setChecked(!tbCheckBox.isChecked());
        }
    }

    @Override // c.a.s0.s.s.a
    public /* bridge */ /* synthetic */ c.a.s0.s.s.a setMessage(String str) {
        f(str);
        return this;
    }

    @Override // c.a.s0.s.s.a
    public /* bridge */ /* synthetic */ c.a.s0.s.s.a setNegativeButton(@StringRes int i2, a.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // c.a.s0.s.s.a
    public /* bridge */ /* synthetic */ c.a.s0.s.s.a setPositiveButton(int i2, a.e eVar) {
        h(i2, eVar);
        return this;
    }

    @Override // c.a.s0.s.s.a
    public c.a.s0.s.s.a setNegativeButton(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.r = str;
            this.s = eVar;
            return this;
        }
        return (c.a.s0.s.s.a) invokeLL.objValue;
    }

    @Override // c.a.s0.s.s.a
    public /* bridge */ /* synthetic */ c.a.s0.s.s.a setPositiveButton(String str, a.e eVar) {
        i(str, eVar);
        return this;
    }
}
