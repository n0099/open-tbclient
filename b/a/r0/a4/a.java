package b.a.r0.a4;

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
import b.a.e.a.f;
import b.a.e.e.l.d;
import b.a.e.e.p.k;
import b.a.q0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends b.a.q0.s.s.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f14721e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14722f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14723g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f14724h;

    /* renamed from: i  reason: collision with root package name */
    public TbCheckBox f14725i;
    public TextView j;
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
    public final b.a.e.e.l.c<b.a.e.l.d.a> x;

    /* renamed from: b.a.r0.a4.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0746a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f14726a;

        public C0746a(a aVar) {
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
            this.f14726a = aVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) || this.f14726a.u == null) {
                return;
            }
            this.f14726a.u.onCheckedChanged(null, z);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f14727a;

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
            this.f14727a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.f14727a.f14722f.setImageResource(R.drawable.frs_luhan_moren_background);
                    return;
                }
                this.f14727a.f14722f.setBackgroundResource(0);
                this.f14727a.f14722f.setImageDrawable(null);
                aVar.h(this.f14727a.f14722f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14728e;

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
            this.f14728e = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14728e : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f14728e = z;
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
        this.w = new C0746a(this);
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
            this.f14721e = viewGroup;
            this.f14722f = (ImageView) viewGroup.findViewById(R.id.dialog_bg);
            this.f14723g = (TextView) this.f14721e.findViewById(R.id.message);
            Button button = (Button) this.f14721e.findViewById(R.id.negative_btn);
            this.l = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.f14721e.findViewById(R.id.positive_btn);
            this.k = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f14721e.findViewById(R.id.close);
            this.m = imageView;
            imageView.setOnClickListener(this);
            this.f14724h = (ViewGroup) this.f14721e.findViewById(R.id.checkbox_container);
            this.j = (TextView) this.f14721e.findViewById(R.id.checkbox_text);
            TbCheckBox tbCheckBox = (TbCheckBox) this.f14721e.findViewById(R.id.checkbox);
            this.f14725i = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
            this.f14725i.setStatedChangedListener(this.w);
            this.f14725i.setTagData(new c(this));
            this.f14724h.setClickable(true);
            this.f14724h.setOnClickListener(this);
            setContentView(this.f14721e);
        }
    }

    @Override // b.a.q0.s.s.a
    public b.a.q0.s.s.a create(f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.v) {
                return this;
            }
            this.v = true;
            super.create(fVar);
            if (!k.isEmpty(this.o)) {
                this.f14723g.setText(this.o);
            }
            if (!k.isEmpty(this.t)) {
                this.j.setText(this.t);
            } else {
                this.f14724h.setVisibility(4);
            }
            if (!k.isEmpty(this.r)) {
                this.l.setText(this.r);
            }
            if (!k.isEmpty(this.p)) {
                this.k.setText(this.p);
            }
            if (!TextUtils.isEmpty(this.n)) {
                d.h().m(this.n, 10, this.x, fVar.getUniqueId());
            } else {
                this.f14722f.setImageResource(R.drawable.frs_luhan_moren_background);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (b.a.q0.s.s.a) invokeL.objValue;
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
            TbCheckBox tbCheckBox = this.f14725i;
            tbCheckBox.setChecked(!tbCheckBox.isChecked());
        }
    }

    @Override // b.a.q0.s.s.a
    public /* bridge */ /* synthetic */ b.a.q0.s.s.a setMessage(String str) {
        f(str);
        return this;
    }

    @Override // b.a.q0.s.s.a
    public /* bridge */ /* synthetic */ b.a.q0.s.s.a setNegativeButton(@StringRes int i2, a.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // b.a.q0.s.s.a
    public /* bridge */ /* synthetic */ b.a.q0.s.s.a setPositiveButton(int i2, a.e eVar) {
        h(i2, eVar);
        return this;
    }

    @Override // b.a.q0.s.s.a
    public b.a.q0.s.s.a setNegativeButton(String str, a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.r = str;
            this.s = eVar;
            return this;
        }
        return (b.a.q0.s.s.a) invokeLL.objValue;
    }

    @Override // b.a.q0.s.s.a
    public /* bridge */ /* synthetic */ b.a.q0.s.s.a setPositiveButton(String str, a.e eVar) {
        i(str, eVar);
        return this;
    }
}
