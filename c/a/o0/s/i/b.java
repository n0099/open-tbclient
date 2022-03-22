package c.a.o0.s.i;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.m.a;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0834a A;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f11396b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f11397c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f11398d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f11399e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f11400f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f11401g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f11402h;
    public RadioButton i;
    public TextView j;
    public Activity k;
    public f l;
    public TextView m;
    public TextView n;
    public ProgressBar o;
    public TextView p;
    public AccountData q;
    public e r;
    public Drawable s;
    public Drawable t;
    public int u;
    public TextView v;
    public View w;
    public View x;
    public View y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.p();
                this.a.t();
            }
        }
    }

    /* renamed from: c.a.o0.s.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0858b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC0858b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.a.f11401g) {
                    this.a.f11399e.clearCheck();
                    this.a.f11401g.setChecked(true);
                    this.a.f11401g.setCompoundDrawables(this.a.s, null, null, null);
                    this.a.f11402h.setChecked(false);
                    this.a.f11402h.setCompoundDrawables(this.a.t, null, null, null);
                    this.a.i.setChecked(false);
                    this.a.i.setCompoundDrawables(this.a.t, null, null, null);
                } else if (compoundButton == this.a.f11402h) {
                    this.a.f11399e.clearCheck();
                    this.a.f11401g.setChecked(false);
                    this.a.f11401g.setCompoundDrawables(this.a.t, null, null, null);
                    this.a.f11402h.setChecked(true);
                    this.a.f11402h.setCompoundDrawables(this.a.s, null, null, null);
                    this.a.i.setChecked(false);
                    this.a.i.setCompoundDrawables(this.a.t, null, null, null);
                } else if (compoundButton == this.a.i) {
                    this.a.f11398d.clearCheck();
                    this.a.f11401g.setChecked(false);
                    this.a.f11401g.setCompoundDrawables(this.a.t, null, null, null);
                    this.a.f11402h.setChecked(false);
                    this.a.f11402h.setCompoundDrawables(this.a.t, null, null, null);
                    this.a.i.setChecked(true);
                    this.a.i.setCompoundDrawables(this.a.s, null, null, null);
                }
                this.a.f11397c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        /* renamed from: a */
        public void onBdussExpired(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fillUsernameResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onFailure(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fillUsernameResult) == null) || StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                return;
            }
            this.a.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.a.p();
                n.M(this.a.k, R.string.obfuscated_res_0x7f0f0fb5);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                c.a.o0.r.m.a.b().a(session.username, session.bduss, "", null, this.a.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.o.setVisibility(8);
                this.a.n.setVisibility(0);
                this.a.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.a.z = true;
            }
        }

        @Override // com.baidu.sapi2.callback.FillUsernameCallback
        public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fillUsernameResult) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(AccountData accountData);
    }

    /* loaded from: classes2.dex */
    public class f extends BdAsyncTask<String, Integer, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f11403b;

        public g(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11403b = bVar;
            this.a = null;
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11403b.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f11403b.k.getSystemService("input_method");
            try {
                if (this.a != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.a, 0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f11396b = null;
        this.f11397c = null;
        this.f11398d = null;
        this.f11399e = null;
        this.f11400f = null;
        this.f11401g = null;
        this.f11402h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.z = false;
        this.k = activity;
        this.s = SkinManager.getDrawable(R.drawable.icon_tips_names_s);
        this.t = SkinManager.getDrawable(R.drawable.icon_tips_names_n);
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0);
        this.u = dimensionPixelSize;
        this.s.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Drawable drawable = this.t;
        int i3 = this.u;
        drawable.setBounds(0, 0, i3, i3);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str == null) {
                this.m.setVisibility(4);
                this.m.setText((CharSequence) null);
                return;
            }
            this.m.setVisibility(0);
            this.m.setText(str);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String obj = this.f11397c.getText().toString();
            if (obj != null && obj.length() > 0) {
                if (UtilHelper.getFixedTextSize(obj) > 14) {
                    A(this.k.getString(R.string.obfuscated_res_0x7f0f08dc));
                    return;
                }
                f fVar = this.l;
                if (fVar != null) {
                    fVar.cancel();
                }
                if (this.z || this.q == null) {
                    return;
                }
                this.o.setVisibility(0);
                this.n.setVisibility(8);
                A(null);
                q();
                SapiAccountManager.getInstance().getAccountService().fillUsername(new d(this), this.q.getBDUSS(), obj);
                return;
            }
            A(this.k.getString(R.string.obfuscated_res_0x7f0f0597));
        }
    }

    public void p() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f11396b) != null && dialog.isShowing()) {
            c.a.d.f.m.g.a(this.f11396b, this.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f11398d.setVisibility(8);
            this.f11398d.clearCheck();
            this.f11399e.setVisibility(8);
            this.f11399e.clearCheck();
            this.f11401g.setVisibility(8);
            this.f11402h.setVisibility(8);
            this.i.setVisibility(8);
            this.f11401g.setChecked(false);
            this.f11402h.setChecked(false);
            this.i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.drawable.dialog_background);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f11397c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.f11401g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f11402h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.j, R.drawable.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0302);
            this.f11397c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f11401g.setCompoundDrawables(this.t, null, null, null);
            this.f11402h.setCompoundDrawables(this.t, null, null, null);
            this.i.setCompoundDrawables(this.t, null, null, null);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f fVar = this.l;
            if (fVar != null) {
                fVar.cancel();
                this.l = null;
            }
            p();
        }
    }

    public final void t() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.r) == null) {
            return;
        }
        eVar.a(null);
    }

    public void u(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, accountData) == null) {
            this.q = accountData;
        }
    }

    public void v(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void w(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
        }
    }

    public void x(a.InterfaceC0834a interfaceC0834a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0834a) == null) {
            this.A = interfaceC0834a;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            z(0);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.f11396b == null) {
                View inflate = LayoutInflater.from(this.k).inflate(R.layout.obfuscated_res_0x7f0d0534, (ViewGroup) null);
                this.a = inflate;
                this.v = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092019);
                this.w = this.a.findViewById(R.id.obfuscated_res_0x7f090806);
                this.x = this.a.findViewById(R.id.obfuscated_res_0x7f090808);
                this.y = this.a.findViewById(R.id.obfuscated_res_0x7f09080c);
                EditText editText = (EditText) this.a.findViewById(R.id.obfuscated_res_0x7f09004c);
                this.f11397c = editText;
                editText.setHint(this.k.getString(R.string.obfuscated_res_0x7f0f0826));
                TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0902ef);
                this.j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0906ba);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC0858b(this));
                this.o = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f0906c0);
                this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090905);
                this.f11398d = (RadioGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0914f0);
                this.f11399e = (RadioGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0914f1);
                this.f11401g = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f0914ea);
                this.f11402h = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f0914eb);
                this.i = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f0914ec);
                c cVar = new c(this);
                this.f11400f = cVar;
                this.f11401g.setOnCheckedChangeListener(cVar);
                this.f11402h.setOnCheckedChangeListener(this.f11400f);
                this.i.setOnCheckedChangeListener(this.f11400f);
                this.p = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091820);
                q();
                Dialog dialog = new Dialog(this.k, R.style.obfuscated_res_0x7f1003b1);
                this.f11396b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f11396b.setCancelable(false);
                this.f11396b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i == 1) {
                this.p.setText(R.string.obfuscated_res_0x7f0f13d5);
            } else {
                this.p.setText(R.string.obfuscated_res_0x7f0f02cf);
            }
            if (this.f11396b.isShowing()) {
                return;
            }
            this.f11397c.setText((CharSequence) null);
            q();
            A(null);
            if (this.k.isFinishing()) {
                return;
            }
            this.f11396b.setContentView(this.a);
            c.a.d.f.m.g.i(this.f11396b, this.k);
            Activity activity = this.k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f11397c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f11397c), 150L);
            }
        }
    }
}
