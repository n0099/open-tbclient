package c.a.q0.t.i;

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
import c.a.e.e.p.l;
import c.a.q0.s.l.a;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0689a A;

    /* renamed from: a  reason: collision with root package name */
    public View f14931a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f14932b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f14933c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f14934d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f14935e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f14936f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f14937g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f14938h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f14939i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f14940j;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14941e;

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
            this.f14941e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14941e.p();
                this.f14941e.t();
            }
        }
    }

    /* renamed from: c.a.q0.t.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0709b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14942e;

        public View$OnClickListenerC0709b(b bVar) {
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
            this.f14942e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14942e.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14943e;

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
            this.f14943e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f14943e.f14937g) {
                    this.f14943e.f14935e.clearCheck();
                    this.f14943e.f14937g.setChecked(true);
                    this.f14943e.f14937g.setCompoundDrawables(this.f14943e.s, null, null, null);
                    this.f14943e.f14938h.setChecked(false);
                    this.f14943e.f14938h.setCompoundDrawables(this.f14943e.t, null, null, null);
                    this.f14943e.f14939i.setChecked(false);
                    this.f14943e.f14939i.setCompoundDrawables(this.f14943e.t, null, null, null);
                } else if (compoundButton == this.f14943e.f14938h) {
                    this.f14943e.f14935e.clearCheck();
                    this.f14943e.f14937g.setChecked(false);
                    this.f14943e.f14937g.setCompoundDrawables(this.f14943e.t, null, null, null);
                    this.f14943e.f14938h.setChecked(true);
                    this.f14943e.f14938h.setCompoundDrawables(this.f14943e.s, null, null, null);
                    this.f14943e.f14939i.setChecked(false);
                    this.f14943e.f14939i.setCompoundDrawables(this.f14943e.t, null, null, null);
                } else if (compoundButton == this.f14943e.f14939i) {
                    this.f14943e.f14934d.clearCheck();
                    this.f14943e.f14937g.setChecked(false);
                    this.f14943e.f14937g.setCompoundDrawables(this.f14943e.t, null, null, null);
                    this.f14943e.f14938h.setChecked(false);
                    this.f14943e.f14938h.setCompoundDrawables(this.f14943e.t, null, null, null);
                    this.f14943e.f14939i.setChecked(true);
                    this.f14943e.f14939i.setCompoundDrawables(this.f14943e.s, null, null, null);
                }
                this.f14943e.f14933c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14944e;

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
            this.f14944e = bVar;
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
            this.f14944e.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.f14944e.p();
                l.L(this.f14944e.k, R.string.reset_success);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                c.a.q0.s.l.a.b().a(session.username, session.bduss, "", null, this.f14944e.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f14944e.o.setVisibility(8);
                this.f14944e.n.setVisibility(0);
                this.f14944e.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f14944e.z = true;
            }
        }

        @Override // com.baidu.sapi2.callback.FillUsernameCallback
        public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fillUsernameResult) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(AccountData accountData);
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<String, Integer, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f14945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14946f;

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
            this.f14946f = bVar;
            this.f14945e = null;
            this.f14945e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14946f.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f14946f.k.getSystemService("input_method");
            try {
                if (this.f14945e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f14945e, 0);
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
        this.f14931a = null;
        this.f14932b = null;
        this.f14933c = null;
        this.f14934d = null;
        this.f14935e = null;
        this.f14936f = null;
        this.f14937g = null;
        this.f14938h = null;
        this.f14939i = null;
        this.f14940j = null;
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
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.ds26);
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
            String obj = this.f14933c.getText().toString();
            if (obj != null && obj.length() > 0) {
                if (UtilHelper.getFixedTextSize(obj) > 14) {
                    A(this.k.getString(R.string.input_alias_limit_length_tip));
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
            A(this.k.getString(R.string.error_tip_name_cannot_empty));
        }
    }

    public void p() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f14932b) != null && dialog.isShowing()) {
            c.a.e.e.m.g.a(this.f14932b, this.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14934d.setVisibility(8);
            this.f14934d.clearCheck();
            this.f14935e.setVisibility(8);
            this.f14935e.clearCheck();
            this.f14937g.setVisibility(8);
            this.f14938h.setVisibility(8);
            this.f14939i.setVisibility(8);
            this.f14937g.setChecked(false);
            this.f14938h.setChecked(false);
            this.f14939i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.f14931a, R.drawable.dialog_background);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f14933c, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.f14937g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14938h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14939i, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f14940j, R.drawable.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.f14940j, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.f14933c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f14937g.setCompoundDrawables(this.t, null, null, null);
            this.f14938h.setCompoundDrawables(this.t, null, null, null);
            this.f14939i.setCompoundDrawables(this.t, null, null, null);
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

    public void x(a.InterfaceC0689a interfaceC0689a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0689a) == null) {
            this.A = interfaceC0689a;
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
            if (this.f14932b == null) {
                View inflate = LayoutInflater.from(this.k).inflate(R.layout.main_input_username, (ViewGroup) null);
                this.f14931a = inflate;
                this.v = (TextView) inflate.findViewById(R.id.tip_info);
                this.w = this.f14931a.findViewById(R.id.divider_under_account);
                this.x = this.f14931a.findViewById(R.id.divider_under_radiongroup);
                this.y = this.f14931a.findViewById(R.id.divider_with_yes_no_button);
                EditText editText = (EditText) this.f14931a.findViewById(R.id.account);
                this.f14933c = editText;
                editText.setHint(this.k.getString(R.string.hint_tip_input_name));
                TextView textView = (TextView) this.f14931a.findViewById(R.id.back);
                this.f14940j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.f14931a.findViewById(R.id.confirm);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC0709b(this));
                this.o = (ProgressBar) this.f14931a.findViewById(R.id.confirm_progress);
                this.m = (TextView) this.f14931a.findViewById(R.id.error_info);
                this.f14934d = (RadioGroup) this.f14931a.findViewById(R.id.names_group1);
                this.f14935e = (RadioGroup) this.f14931a.findViewById(R.id.names_group2);
                this.f14937g = (RadioButton) this.f14931a.findViewById(R.id.name1);
                this.f14938h = (RadioButton) this.f14931a.findViewById(R.id.name2);
                this.f14939i = (RadioButton) this.f14931a.findViewById(R.id.name3);
                c cVar = new c(this);
                this.f14936f = cVar;
                this.f14937g.setOnCheckedChangeListener(cVar);
                this.f14938h.setOnCheckedChangeListener(this.f14936f);
                this.f14939i.setOnCheckedChangeListener(this.f14936f);
                this.p = (TextView) this.f14931a.findViewById(R.id.phone_info);
                q();
                Dialog dialog = new Dialog(this.k, R.style.input_username_dialog);
                this.f14932b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f14932b.setCancelable(false);
                this.f14932b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i2 == 1) {
                this.p.setText(R.string.tip_init_user_name);
            } else {
                this.p.setText(R.string.bar_friend);
            }
            if (this.f14932b.isShowing()) {
                return;
            }
            this.f14933c.setText((CharSequence) null);
            q();
            A(null);
            if (this.k.isFinishing()) {
                return;
            }
            this.f14932b.setContentView(this.f14931a);
            c.a.e.e.m.g.i(this.f14932b, this.k);
            Activity activity = this.k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f14933c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f14933c), 150L);
            }
        }
    }
}
