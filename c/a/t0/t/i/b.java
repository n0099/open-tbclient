package c.a.t0.t.i;

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
import c.a.t0.s.m.a;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import c.a.u0.a4.k;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0895a A;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f14477b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f14478c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f14479d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f14480e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f14481f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f14482g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f14483h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f14484i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f14485j;
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14486e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14486e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14486e.p();
                this.f14486e.t();
            }
        }
    }

    /* renamed from: c.a.t0.t.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0919b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14487e;

        public View$OnClickListenerC0919b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14487e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14487e.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14488e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14488e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f14488e.f14482g) {
                    this.f14488e.f14480e.clearCheck();
                    this.f14488e.f14482g.setChecked(true);
                    this.f14488e.f14482g.setCompoundDrawables(this.f14488e.s, null, null, null);
                    this.f14488e.f14483h.setChecked(false);
                    this.f14488e.f14483h.setCompoundDrawables(this.f14488e.t, null, null, null);
                    this.f14488e.f14484i.setChecked(false);
                    this.f14488e.f14484i.setCompoundDrawables(this.f14488e.t, null, null, null);
                } else if (compoundButton == this.f14488e.f14483h) {
                    this.f14488e.f14480e.clearCheck();
                    this.f14488e.f14482g.setChecked(false);
                    this.f14488e.f14482g.setCompoundDrawables(this.f14488e.t, null, null, null);
                    this.f14488e.f14483h.setChecked(true);
                    this.f14488e.f14483h.setCompoundDrawables(this.f14488e.s, null, null, null);
                    this.f14488e.f14484i.setChecked(false);
                    this.f14488e.f14484i.setCompoundDrawables(this.f14488e.t, null, null, null);
                } else if (compoundButton == this.f14488e.f14484i) {
                    this.f14488e.f14479d.clearCheck();
                    this.f14488e.f14482g.setChecked(false);
                    this.f14488e.f14482g.setCompoundDrawables(this.f14488e.t, null, null, null);
                    this.f14488e.f14483h.setChecked(false);
                    this.f14488e.f14483h.setCompoundDrawables(this.f14488e.t, null, null, null);
                    this.f14488e.f14484i.setChecked(true);
                    this.f14488e.f14484i.setCompoundDrawables(this.f14488e.s, null, null, null);
                }
                this.f14488e.f14478c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14489e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14489e = bVar;
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
            this.f14489e.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.f14489e.p();
                n.M(this.f14489e.k, j.reset_success);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                c.a.t0.s.m.a.b().a(session.username, session.bduss, "", null, this.f14489e.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f14489e.o.setVisibility(8);
                this.f14489e.n.setVisibility(0);
                this.f14489e.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f14489e.z = true;
            }
        }

        @Override // com.baidu.sapi2.callback.FillUsernameCallback
        public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fillUsernameResult) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(AccountData accountData);
    }

    /* loaded from: classes6.dex */
    public class f extends BdAsyncTask<String, Integer, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f14490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14491f;

        public g(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14491f = bVar;
            this.f14490e = null;
            this.f14490e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14491f.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f14491f.k.getSystemService("input_method");
            try {
                if (this.f14490e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f14490e, 0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f14477b = null;
        this.f14478c = null;
        this.f14479d = null;
        this.f14480e = null;
        this.f14481f = null;
        this.f14482g = null;
        this.f14483h = null;
        this.f14484i = null;
        this.f14485j = null;
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
        this.s = SkinManager.getDrawable(c.a.u0.a4.f.icon_tips_names_s);
        this.t = SkinManager.getDrawable(c.a.u0.a4.f.icon_tips_names_n);
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(c.a.u0.a4.e.ds26);
        this.u = dimensionPixelSize;
        this.s.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Drawable drawable = this.t;
        int i4 = this.u;
        drawable.setBounds(0, 0, i4, i4);
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
            String obj = this.f14478c.getText().toString();
            if (obj != null && obj.length() > 0) {
                if (UtilHelper.getFixedTextSize(obj) > 14) {
                    A(this.k.getString(j.input_alias_limit_length_tip));
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
            A(this.k.getString(j.error_tip_name_cannot_empty));
        }
    }

    public void p() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f14477b) != null && dialog.isShowing()) {
            c.a.d.f.m.g.a(this.f14477b, this.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14479d.setVisibility(8);
            this.f14479d.clearCheck();
            this.f14480e.setVisibility(8);
            this.f14480e.clearCheck();
            this.f14482g.setVisibility(8);
            this.f14483h.setVisibility(8);
            this.f14484i.setVisibility(8);
            this.f14482g.setChecked(false);
            this.f14483h.setChecked(false);
            this.f14484i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.a, c.a.u0.a4.f.dialog_background);
            SkinManager.setViewTextColor(this.p, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setViewTextColor(this.v, c.a.u0.a4.d.CAM_X0106);
            SkinManager.setViewTextColor(this.f14478c, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, c.a.u0.a4.f.bg_search_input);
            SkinManager.setViewTextColor(this.m, c.a.u0.a4.d.CAM_X0301);
            SkinManager.setViewTextColor(this.f14482g, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setViewTextColor(this.f14483h, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setViewTextColor(this.f14484i, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, c.a.u0.a4.d.CAM_X0204);
            SkinManager.setBackgroundResource(this.f14485j, c.a.u0.a4.f.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.f14485j, c.a.u0.a4.d.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, c.a.u0.a4.d.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, c.a.u0.a4.f.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, c.a.u0.a4.d.CAM_X0302);
            this.f14478c.setHintTextColor(SkinManager.getColor(c.a.u0.a4.d.CAM_X0110));
            this.f14482g.setCompoundDrawables(this.t, null, null, null);
            this.f14483h.setCompoundDrawables(this.t, null, null, null);
            this.f14484i.setCompoundDrawables(this.t, null, null, null);
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

    public void x(a.InterfaceC0895a interfaceC0895a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0895a) == null) {
            this.A = interfaceC0895a;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            z(0);
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f14477b == null) {
                View inflate = LayoutInflater.from(this.k).inflate(h.main_input_username, (ViewGroup) null);
                this.a = inflate;
                this.v = (TextView) inflate.findViewById(c.a.u0.a4.g.tip_info);
                this.w = this.a.findViewById(c.a.u0.a4.g.divider_under_account);
                this.x = this.a.findViewById(c.a.u0.a4.g.divider_under_radiongroup);
                this.y = this.a.findViewById(c.a.u0.a4.g.divider_with_yes_no_button);
                EditText editText = (EditText) this.a.findViewById(c.a.u0.a4.g.account);
                this.f14478c = editText;
                editText.setHint(this.k.getString(j.hint_tip_input_name));
                TextView textView = (TextView) this.a.findViewById(c.a.u0.a4.g.back);
                this.f14485j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.a.findViewById(c.a.u0.a4.g.confirm);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC0919b(this));
                this.o = (ProgressBar) this.a.findViewById(c.a.u0.a4.g.confirm_progress);
                this.m = (TextView) this.a.findViewById(c.a.u0.a4.g.error_info);
                this.f14479d = (RadioGroup) this.a.findViewById(c.a.u0.a4.g.names_group1);
                this.f14480e = (RadioGroup) this.a.findViewById(c.a.u0.a4.g.names_group2);
                this.f14482g = (RadioButton) this.a.findViewById(c.a.u0.a4.g.name1);
                this.f14483h = (RadioButton) this.a.findViewById(c.a.u0.a4.g.name2);
                this.f14484i = (RadioButton) this.a.findViewById(c.a.u0.a4.g.name3);
                c cVar = new c(this);
                this.f14481f = cVar;
                this.f14482g.setOnCheckedChangeListener(cVar);
                this.f14483h.setOnCheckedChangeListener(this.f14481f);
                this.f14484i.setOnCheckedChangeListener(this.f14481f);
                this.p = (TextView) this.a.findViewById(c.a.u0.a4.g.phone_info);
                q();
                Dialog dialog = new Dialog(this.k, k.input_username_dialog);
                this.f14477b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f14477b.setCancelable(false);
                this.f14477b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i2 == 1) {
                this.p.setText(j.tip_init_user_name);
            } else {
                this.p.setText(j.bar_friend);
            }
            if (this.f14477b.isShowing()) {
                return;
            }
            this.f14478c.setText((CharSequence) null);
            q();
            A(null);
            if (this.k.isFinishing()) {
                return;
            }
            this.f14477b.setContentView(this.a);
            c.a.d.f.m.g.i(this.f14477b, this.k);
            Activity activity = this.k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f14478c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f14478c), 150L);
            }
        }
    }
}
