package c.a.r0.m4;

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
import c.a.q0.r.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.q0.r.t.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f19350e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19351f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19352g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f19353h;

    /* renamed from: i  reason: collision with root package name */
    public TbCheckBox f19354i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19355j;
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
    public final c.a.d.f.l.c<c.a.d.o.d.a> x;

    /* renamed from: c.a.r0.m4.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1212a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1212a(a aVar) {
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

    /* loaded from: classes2.dex */
    public class b extends c.a.d.f.l.c<c.a.d.o.d.a> {
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
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.a.f19351f.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                this.a.f19351f.setBackgroundResource(0);
                this.a.f19351f.setImageDrawable(null);
                aVar.h(this.a.f19351f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19356e;

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
            this.f19356e = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19356e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f19356e = z;
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
        this.w = new C1212a(this);
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
            this.f19350e = viewGroup;
            this.f19351f = (ImageView) viewGroup.findViewById(R.id.dialog_bg);
            this.f19352g = (TextView) this.f19350e.findViewById(R.id.message);
            Button button = (Button) this.f19350e.findViewById(R.id.negative_btn);
            this.l = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.f19350e.findViewById(R.id.positive_btn);
            this.k = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f19350e.findViewById(R.id.close);
            this.m = imageView;
            imageView.setOnClickListener(this);
            this.f19353h = (ViewGroup) this.f19350e.findViewById(R.id.checkbox_container);
            this.f19355j = (TextView) this.f19350e.findViewById(R.id.checkbox_text);
            TbCheckBox tbCheckBox = (TbCheckBox) this.f19350e.findViewById(R.id.checkbox);
            this.f19354i = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
            this.f19354i.setStatedChangedListener(this.w);
            this.f19354i.setTagData(new c(this));
            this.f19353h.setClickable(true);
            this.f19353h.setOnClickListener(this);
            setContentView(this.f19350e);
        }
    }

    @Override // c.a.q0.r.t.a
    public c.a.q0.r.t.a create(f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.v) {
                return this;
            }
            this.v = true;
            super.create(fVar);
            if (!m.isEmpty(this.o)) {
                this.f19352g.setText(this.o);
            }
            if (!m.isEmpty(this.t)) {
                this.f19355j.setText(this.t);
            } else {
                this.f19353h.setVisibility(4);
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
                this.f19351f.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (c.a.q0.r.t.a) invokeL.objValue;
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
            TbCheckBox tbCheckBox = this.f19354i;
            tbCheckBox.setChecked(!tbCheckBox.isChecked());
        }
    }

    @Override // c.a.q0.r.t.a
    public /* bridge */ /* synthetic */ c.a.q0.r.t.a setMessage(String str) {
        f(str);
        return this;
    }

    @Override // c.a.q0.r.t.a
    public /* bridge */ /* synthetic */ c.a.q0.r.t.a setNegativeButton(@StringRes int i2, a.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // c.a.q0.r.t.a
    public /* bridge */ /* synthetic */ c.a.q0.r.t.a setPositiveButton(int i2, a.e eVar) {
        h(i2, eVar);
        return this;
    }

    @Override // c.a.q0.r.t.a
    public c.a.q0.r.t.a setNegativeButton(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.r = str;
            this.s = eVar;
            return this;
        }
        return (c.a.q0.r.t.a) invokeLL.objValue;
    }

    @Override // c.a.q0.r.t.a
    public /* bridge */ /* synthetic */ c.a.q0.r.t.a setPositiveButton(String str, a.e eVar) {
        i(str, eVar);
        return this;
    }
}
