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
    public View f14957a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f14958b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f14959c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f14960d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f14961e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f14962f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f14963g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f14964h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f14965i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f14966j;
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
        public final /* synthetic */ b f14967e;

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
            this.f14967e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14967e.p();
                this.f14967e.t();
            }
        }
    }

    /* renamed from: c.a.q0.t.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0709b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14968e;

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
            this.f14968e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14968e.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14969e;

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
            this.f14969e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f14969e.f14963g) {
                    this.f14969e.f14961e.clearCheck();
                    this.f14969e.f14963g.setChecked(true);
                    this.f14969e.f14963g.setCompoundDrawables(this.f14969e.s, null, null, null);
                    this.f14969e.f14964h.setChecked(false);
                    this.f14969e.f14964h.setCompoundDrawables(this.f14969e.t, null, null, null);
                    this.f14969e.f14965i.setChecked(false);
                    this.f14969e.f14965i.setCompoundDrawables(this.f14969e.t, null, null, null);
                } else if (compoundButton == this.f14969e.f14964h) {
                    this.f14969e.f14961e.clearCheck();
                    this.f14969e.f14963g.setChecked(false);
                    this.f14969e.f14963g.setCompoundDrawables(this.f14969e.t, null, null, null);
                    this.f14969e.f14964h.setChecked(true);
                    this.f14969e.f14964h.setCompoundDrawables(this.f14969e.s, null, null, null);
                    this.f14969e.f14965i.setChecked(false);
                    this.f14969e.f14965i.setCompoundDrawables(this.f14969e.t, null, null, null);
                } else if (compoundButton == this.f14969e.f14965i) {
                    this.f14969e.f14960d.clearCheck();
                    this.f14969e.f14963g.setChecked(false);
                    this.f14969e.f14963g.setCompoundDrawables(this.f14969e.t, null, null, null);
                    this.f14969e.f14964h.setChecked(false);
                    this.f14969e.f14964h.setCompoundDrawables(this.f14969e.t, null, null, null);
                    this.f14969e.f14965i.setChecked(true);
                    this.f14969e.f14965i.setCompoundDrawables(this.f14969e.s, null, null, null);
                }
                this.f14969e.f14959c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14970e;

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
            this.f14970e = bVar;
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
            this.f14970e.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.f14970e.p();
                l.L(this.f14970e.k, R.string.reset_success);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                c.a.q0.s.l.a.b().a(session.username, session.bduss, "", null, this.f14970e.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f14970e.o.setVisibility(8);
                this.f14970e.n.setVisibility(0);
                this.f14970e.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f14970e.z = true;
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
        public View f14971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14972f;

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
            this.f14972f = bVar;
            this.f14971e = null;
            this.f14971e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14972f.k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f14972f.k.getSystemService("input_method");
            try {
                if (this.f14971e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f14971e, 0);
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
        this.f14957a = null;
        this.f14958b = null;
        this.f14959c = null;
        this.f14960d = null;
        this.f14961e = null;
        this.f14962f = null;
        this.f14963g = null;
        this.f14964h = null;
        this.f14965i = null;
        this.f14966j = null;
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
            String obj = this.f14959c.getText().toString();
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f14958b) != null && dialog.isShowing()) {
            c.a.e.e.m.g.a(this.f14958b, this.k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14960d.setVisibility(8);
            this.f14960d.clearCheck();
            this.f14961e.setVisibility(8);
            this.f14961e.clearCheck();
            this.f14963g.setVisibility(8);
            this.f14964h.setVisibility(8);
            this.f14965i.setVisibility(8);
            this.f14963g.setChecked(false);
            this.f14964h.setChecked(false);
            this.f14965i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.f14957a, R.drawable.dialog_background);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f14959c, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.f14963g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14964h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14965i, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f14966j, R.drawable.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.f14966j, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.f14959c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f14963g.setCompoundDrawables(this.t, null, null, null);
            this.f14964h.setCompoundDrawables(this.t, null, null, null);
            this.f14965i.setCompoundDrawables(this.t, null, null, null);
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
            if (this.f14958b == null) {
                View inflate = LayoutInflater.from(this.k).inflate(R.layout.main_input_username, (ViewGroup) null);
                this.f14957a = inflate;
                this.v = (TextView) inflate.findViewById(R.id.tip_info);
                this.w = this.f14957a.findViewById(R.id.divider_under_account);
                this.x = this.f14957a.findViewById(R.id.divider_under_radiongroup);
                this.y = this.f14957a.findViewById(R.id.divider_with_yes_no_button);
                EditText editText = (EditText) this.f14957a.findViewById(R.id.account);
                this.f14959c = editText;
                editText.setHint(this.k.getString(R.string.hint_tip_input_name));
                TextView textView = (TextView) this.f14957a.findViewById(R.id.back);
                this.f14966j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.f14957a.findViewById(R.id.confirm);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC0709b(this));
                this.o = (ProgressBar) this.f14957a.findViewById(R.id.confirm_progress);
                this.m = (TextView) this.f14957a.findViewById(R.id.error_info);
                this.f14960d = (RadioGroup) this.f14957a.findViewById(R.id.names_group1);
                this.f14961e = (RadioGroup) this.f14957a.findViewById(R.id.names_group2);
                this.f14963g = (RadioButton) this.f14957a.findViewById(R.id.name1);
                this.f14964h = (RadioButton) this.f14957a.findViewById(R.id.name2);
                this.f14965i = (RadioButton) this.f14957a.findViewById(R.id.name3);
                c cVar = new c(this);
                this.f14962f = cVar;
                this.f14963g.setOnCheckedChangeListener(cVar);
                this.f14964h.setOnCheckedChangeListener(this.f14962f);
                this.f14965i.setOnCheckedChangeListener(this.f14962f);
                this.p = (TextView) this.f14957a.findViewById(R.id.phone_info);
                q();
                Dialog dialog = new Dialog(this.k, R.style.input_username_dialog);
                this.f14958b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f14958b.setCancelable(false);
                this.f14958b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i2 == 1) {
                this.p.setText(R.string.tip_init_user_name);
            } else {
                this.p.setText(R.string.bar_friend);
            }
            if (this.f14958b.isShowing()) {
                return;
            }
            this.f14959c.setText((CharSequence) null);
            q();
            A(null);
            if (this.k.isFinishing()) {
                return;
            }
            this.f14958b.setContentView(this.f14957a);
            c.a.e.e.m.g.i(this.f14958b, this.k);
            Activity activity = this.k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f14959c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f14959c), 150L);
            }
        }
    }
}
