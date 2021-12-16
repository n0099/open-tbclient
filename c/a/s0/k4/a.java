package c.a.s0.k4;

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
import c.a.d.f.p.l;
import c.a.r0.s.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends c.a.r0.s.t.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f19050e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19051f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19052g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f19053h;

    /* renamed from: i  reason: collision with root package name */
    public TbCheckBox f19054i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19055j;

    /* renamed from: k  reason: collision with root package name */
    public Button f19056k;
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
    public final c.a.d.f.l.c<c.a.d.m.d.a> x;

    /* renamed from: c.a.s0.k4.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1143a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1143a(a aVar) {
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
    public class b extends c.a.d.f.l.c<c.a.d.m.d.a> {
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
        public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.a.f19051f.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                this.a.f19051f.setBackgroundResource(0);
                this.a.f19051f.setImageDrawable(null);
                aVar.h(this.a.f19051f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19057e;

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
            this.f19057e = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19057e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f19057e = z;
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
        this.w = new C1143a(this);
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
            this.f19050e = viewGroup;
            this.f19051f = (ImageView) viewGroup.findViewById(R.id.dialog_bg);
            this.f19052g = (TextView) this.f19050e.findViewById(R.id.message);
            Button button = (Button) this.f19050e.findViewById(R.id.negative_btn);
            this.l = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.f19050e.findViewById(R.id.positive_btn);
            this.f19056k = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f19050e.findViewById(R.id.close);
            this.m = imageView;
            imageView.setOnClickListener(this);
            this.f19053h = (ViewGroup) this.f19050e.findViewById(R.id.checkbox_container);
            this.f19055j = (TextView) this.f19050e.findViewById(R.id.checkbox_text);
            TbCheckBox tbCheckBox = (TbCheckBox) this.f19050e.findViewById(R.id.checkbox);
            this.f19054i = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
            this.f19054i.setStatedChangedListener(this.w);
            this.f19054i.setTagData(new c(this));
            this.f19053h.setClickable(true);
            this.f19053h.setOnClickListener(this);
            setContentView(this.f19050e);
        }
    }

    @Override // c.a.r0.s.t.a
    public c.a.r0.s.t.a create(f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.v) {
                return this;
            }
            this.v = true;
            super.create(fVar);
            if (!l.isEmpty(this.o)) {
                this.f19052g.setText(this.o);
            }
            if (!l.isEmpty(this.t)) {
                this.f19055j.setText(this.t);
            } else {
                this.f19053h.setVisibility(4);
            }
            if (!l.isEmpty(this.r)) {
                this.l.setText(this.r);
            }
            if (!l.isEmpty(this.p)) {
                this.f19056k.setText(this.p);
            }
            if (!TextUtils.isEmpty(this.n)) {
                d.h().m(this.n, 10, this.x, fVar.getUniqueId());
            } else {
                this.f19051f.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (c.a.r0.s.t.a) invokeL.objValue;
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
            TbCheckBox tbCheckBox = this.f19054i;
            tbCheckBox.setChecked(!tbCheckBox.isChecked());
        }
    }

    @Override // c.a.r0.s.t.a
    public /* bridge */ /* synthetic */ c.a.r0.s.t.a setMessage(String str) {
        f(str);
        return this;
    }

    @Override // c.a.r0.s.t.a
    public /* bridge */ /* synthetic */ c.a.r0.s.t.a setNegativeButton(@StringRes int i2, a.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // c.a.r0.s.t.a
    public /* bridge */ /* synthetic */ c.a.r0.s.t.a setPositiveButton(int i2, a.e eVar) {
        h(i2, eVar);
        return this;
    }

    @Override // c.a.r0.s.t.a
    public c.a.r0.s.t.a setNegativeButton(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.r = str;
            this.s = eVar;
            return this;
        }
        return (c.a.r0.s.t.a) invokeLL.objValue;
    }

    @Override // c.a.r0.s.t.a
    public /* bridge */ /* synthetic */ c.a.r0.s.t.a setPositiveButton(String str, a.e eVar) {
        i(str, eVar);
        return this;
    }
}
