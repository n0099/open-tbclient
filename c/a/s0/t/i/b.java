package c.a.s0.t.i;

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
import c.a.s0.s.l.a;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0864a A;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f14397b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f14398c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f14399d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f14400e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f14401f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f14402g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f14403h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f14404i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f14405j;

    /* renamed from: k  reason: collision with root package name */
    public Activity f14406k;
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
        public final /* synthetic */ b f14407e;

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
            this.f14407e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14407e.p();
                this.f14407e.t();
            }
        }
    }

    /* renamed from: c.a.s0.t.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0885b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14408e;

        public View$OnClickListenerC0885b(b bVar) {
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
            this.f14408e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14408e.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14409e;

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
            this.f14409e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f14409e.f14402g) {
                    this.f14409e.f14400e.clearCheck();
                    this.f14409e.f14402g.setChecked(true);
                    this.f14409e.f14402g.setCompoundDrawables(this.f14409e.s, null, null, null);
                    this.f14409e.f14403h.setChecked(false);
                    this.f14409e.f14403h.setCompoundDrawables(this.f14409e.t, null, null, null);
                    this.f14409e.f14404i.setChecked(false);
                    this.f14409e.f14404i.setCompoundDrawables(this.f14409e.t, null, null, null);
                } else if (compoundButton == this.f14409e.f14403h) {
                    this.f14409e.f14400e.clearCheck();
                    this.f14409e.f14402g.setChecked(false);
                    this.f14409e.f14402g.setCompoundDrawables(this.f14409e.t, null, null, null);
                    this.f14409e.f14403h.setChecked(true);
                    this.f14409e.f14403h.setCompoundDrawables(this.f14409e.s, null, null, null);
                    this.f14409e.f14404i.setChecked(false);
                    this.f14409e.f14404i.setCompoundDrawables(this.f14409e.t, null, null, null);
                } else if (compoundButton == this.f14409e.f14404i) {
                    this.f14409e.f14399d.clearCheck();
                    this.f14409e.f14402g.setChecked(false);
                    this.f14409e.f14402g.setCompoundDrawables(this.f14409e.t, null, null, null);
                    this.f14409e.f14403h.setChecked(false);
                    this.f14409e.f14403h.setCompoundDrawables(this.f14409e.t, null, null, null);
                    this.f14409e.f14404i.setChecked(true);
                    this.f14409e.f14404i.setCompoundDrawables(this.f14409e.s, null, null, null);
                }
                this.f14409e.f14398c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14410e;

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
            this.f14410e = bVar;
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
            this.f14410e.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.f14410e.p();
                n.L(this.f14410e.f14406k, R.string.reset_success);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                c.a.s0.s.l.a.b().a(session.username, session.bduss, "", null, this.f14410e.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f14410e.o.setVisibility(8);
                this.f14410e.n.setVisibility(0);
                this.f14410e.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f14410e.z = true;
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
        public View f14411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f14412f;

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
            this.f14412f = bVar;
            this.f14411e = null;
            this.f14411e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14412f.f14406k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f14412f.f14406k.getSystemService("input_method");
            try {
                if (this.f14411e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f14411e, 0);
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
        this.f14397b = null;
        this.f14398c = null;
        this.f14399d = null;
        this.f14400e = null;
        this.f14401f = null;
        this.f14402g = null;
        this.f14403h = null;
        this.f14404i = null;
        this.f14405j = null;
        this.f14406k = null;
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
        this.f14406k = activity;
        this.s = SkinManager.getDrawable(R.drawable.icon_tips_names_s);
        this.t = SkinManager.getDrawable(R.drawable.icon_tips_names_n);
        int dimensionPixelSize = this.f14406k.getResources().getDimensionPixelSize(R.dimen.ds26);
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
            String obj = this.f14398c.getText().toString();
            if (obj != null && obj.length() > 0) {
                if (UtilHelper.getFixedTextSize(obj) > 14) {
                    A(this.f14406k.getString(R.string.input_alias_limit_length_tip));
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
            A(this.f14406k.getString(R.string.error_tip_name_cannot_empty));
        }
    }

    public void p() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f14397b) != null && dialog.isShowing()) {
            c.a.d.f.m.g.a(this.f14397b, this.f14406k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14399d.setVisibility(8);
            this.f14399d.clearCheck();
            this.f14400e.setVisibility(8);
            this.f14400e.clearCheck();
            this.f14402g.setVisibility(8);
            this.f14403h.setVisibility(8);
            this.f14404i.setVisibility(8);
            this.f14402g.setChecked(false);
            this.f14403h.setChecked(false);
            this.f14404i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.drawable.dialog_background);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f14398c, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.f14402g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14403h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14404i, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f14405j, R.drawable.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.f14405j, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.f14398c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f14402g.setCompoundDrawables(this.t, null, null, null);
            this.f14403h.setCompoundDrawables(this.t, null, null, null);
            this.f14404i.setCompoundDrawables(this.t, null, null, null);
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

    public void x(a.InterfaceC0864a interfaceC0864a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0864a) == null) {
            this.A = interfaceC0864a;
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
            if (this.f14397b == null) {
                View inflate = LayoutInflater.from(this.f14406k).inflate(R.layout.main_input_username, (ViewGroup) null);
                this.a = inflate;
                this.v = (TextView) inflate.findViewById(R.id.tip_info);
                this.w = this.a.findViewById(R.id.divider_under_account);
                this.x = this.a.findViewById(R.id.divider_under_radiongroup);
                this.y = this.a.findViewById(R.id.divider_with_yes_no_button);
                EditText editText = (EditText) this.a.findViewById(R.id.account);
                this.f14398c = editText;
                editText.setHint(this.f14406k.getString(R.string.hint_tip_input_name));
                TextView textView = (TextView) this.a.findViewById(R.id.back);
                this.f14405j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.a.findViewById(R.id.confirm);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC0885b(this));
                this.o = (ProgressBar) this.a.findViewById(R.id.confirm_progress);
                this.m = (TextView) this.a.findViewById(R.id.error_info);
                this.f14399d = (RadioGroup) this.a.findViewById(R.id.names_group1);
                this.f14400e = (RadioGroup) this.a.findViewById(R.id.names_group2);
                this.f14402g = (RadioButton) this.a.findViewById(R.id.name1);
                this.f14403h = (RadioButton) this.a.findViewById(R.id.name2);
                this.f14404i = (RadioButton) this.a.findViewById(R.id.name3);
                c cVar = new c(this);
                this.f14401f = cVar;
                this.f14402g.setOnCheckedChangeListener(cVar);
                this.f14403h.setOnCheckedChangeListener(this.f14401f);
                this.f14404i.setOnCheckedChangeListener(this.f14401f);
                this.p = (TextView) this.a.findViewById(R.id.phone_info);
                q();
                Dialog dialog = new Dialog(this.f14406k, R.style.input_username_dialog);
                this.f14397b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f14397b.setCancelable(false);
                this.f14397b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i2 == 1) {
                this.p.setText(R.string.tip_init_user_name);
            } else {
                this.p.setText(R.string.bar_friend);
            }
            if (this.f14397b.isShowing()) {
                return;
            }
            this.f14398c.setText((CharSequence) null);
            q();
            A(null);
            if (this.f14406k.isFinishing()) {
                return;
            }
            this.f14397b.setContentView(this.a);
            c.a.d.f.m.g.i(this.f14397b, this.f14406k);
            Activity activity = this.f14406k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f14398c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f14398c), 150L);
            }
        }
    }
}
