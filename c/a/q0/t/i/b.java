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
import c.a.d.f.p.l;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0804a A;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f13570b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f13571c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f13572d;

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f13573e;

    /* renamed from: f  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f13574f;

    /* renamed from: g  reason: collision with root package name */
    public RadioButton f13575g;

    /* renamed from: h  reason: collision with root package name */
    public RadioButton f13576h;

    /* renamed from: i  reason: collision with root package name */
    public RadioButton f13577i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f13578j;

    /* renamed from: k  reason: collision with root package name */
    public Activity f13579k;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13580e;

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
            this.f13580e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13580e.p();
                this.f13580e.t();
            }
        }
    }

    /* renamed from: c.a.q0.t.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0824b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13581e;

        public View$OnClickListenerC0824b(b bVar) {
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
            this.f13581e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13581e.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13582e;

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
            this.f13582e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                if (compoundButton == this.f13582e.f13575g) {
                    this.f13582e.f13573e.clearCheck();
                    this.f13582e.f13575g.setChecked(true);
                    this.f13582e.f13575g.setCompoundDrawables(this.f13582e.s, null, null, null);
                    this.f13582e.f13576h.setChecked(false);
                    this.f13582e.f13576h.setCompoundDrawables(this.f13582e.t, null, null, null);
                    this.f13582e.f13577i.setChecked(false);
                    this.f13582e.f13577i.setCompoundDrawables(this.f13582e.t, null, null, null);
                } else if (compoundButton == this.f13582e.f13576h) {
                    this.f13582e.f13573e.clearCheck();
                    this.f13582e.f13575g.setChecked(false);
                    this.f13582e.f13575g.setCompoundDrawables(this.f13582e.t, null, null, null);
                    this.f13582e.f13576h.setChecked(true);
                    this.f13582e.f13576h.setCompoundDrawables(this.f13582e.s, null, null, null);
                    this.f13582e.f13577i.setChecked(false);
                    this.f13582e.f13577i.setCompoundDrawables(this.f13582e.t, null, null, null);
                } else if (compoundButton == this.f13582e.f13577i) {
                    this.f13582e.f13572d.clearCheck();
                    this.f13582e.f13575g.setChecked(false);
                    this.f13582e.f13575g.setCompoundDrawables(this.f13582e.t, null, null, null);
                    this.f13582e.f13576h.setChecked(false);
                    this.f13582e.f13576h.setCompoundDrawables(this.f13582e.t, null, null, null);
                    this.f13582e.f13577i.setChecked(true);
                    this.f13582e.f13577i.setCompoundDrawables(this.f13582e.s, null, null, null);
                }
                this.f13582e.f13571c.setText(compoundButton.getText());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends FillUsernameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13583e;

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
            this.f13583e = bVar;
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
            this.f13583e.A(fillUsernameResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onSuccess(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fillUsernameResult) == null) {
                this.f13583e.p();
                l.L(this.f13583e.f13579k, R.string.reset_success);
                SapiAccount session = SapiAccountManager.getInstance().getSession();
                c.a.q0.s.l.a.b().a(session.username, session.bduss, "", null, this.f13583e.A);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f13583e.o.setVisibility(8);
                this.f13583e.n.setVisibility(0);
                this.f13583e.z = false;
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f13583e.z = true;
            }
        }

        @Override // com.baidu.sapi2.callback.FillUsernameCallback
        public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fillUsernameResult) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(AccountData accountData);
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<String, Integer, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f13584e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f13585f;

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
            this.f13585f = bVar;
            this.f13584e = null;
            this.f13584e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13585f.f13579k.isFinishing()) {
                return;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) this.f13585f.f13579k.getSystemService("input_method");
            try {
                if (this.f13584e != null && inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f13584e, 0);
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
        this.f13570b = null;
        this.f13571c = null;
        this.f13572d = null;
        this.f13573e = null;
        this.f13574f = null;
        this.f13575g = null;
        this.f13576h = null;
        this.f13577i = null;
        this.f13578j = null;
        this.f13579k = null;
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
        this.f13579k = activity;
        this.s = SkinManager.getDrawable(R.drawable.icon_tips_names_s);
        this.t = SkinManager.getDrawable(R.drawable.icon_tips_names_n);
        int dimensionPixelSize = this.f13579k.getResources().getDimensionPixelSize(R.dimen.ds26);
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
            String obj = this.f13571c.getText().toString();
            if (obj != null && obj.length() > 0) {
                if (UtilHelper.getFixedTextSize(obj) > 14) {
                    A(this.f13579k.getString(R.string.input_alias_limit_length_tip));
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
            A(this.f13579k.getString(R.string.error_tip_name_cannot_empty));
        }
    }

    public void p() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dialog = this.f13570b) != null && dialog.isShowing()) {
            c.a.d.f.m.g.a(this.f13570b, this.f13579k);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f13572d.setVisibility(8);
            this.f13572d.clearCheck();
            this.f13573e.setVisibility(8);
            this.f13573e.clearCheck();
            this.f13575g.setVisibility(8);
            this.f13576h.setVisibility(8);
            this.f13577i.setVisibility(8);
            this.f13575g.setChecked(false);
            this.f13576h.setChecked(false);
            this.f13577i.setChecked(false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundResource(this.a, R.drawable.dialog_background);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f13571c, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_search_input);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.f13575g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f13576h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f13577i, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f13578j, R.drawable.dialog_left_button_selector);
            SkinManager.setViewTextColor(this.f13578j, R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.n, R.drawable.dialog_right_button_selector);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.f13571c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f13575g.setCompoundDrawables(this.t, null, null, null);
            this.f13576h.setCompoundDrawables(this.t, null, null, null);
            this.f13577i.setCompoundDrawables(this.t, null, null, null);
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

    public void x(a.InterfaceC0804a interfaceC0804a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0804a) == null) {
            this.A = interfaceC0804a;
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
            if (this.f13570b == null) {
                View inflate = LayoutInflater.from(this.f13579k).inflate(R.layout.main_input_username, (ViewGroup) null);
                this.a = inflate;
                this.v = (TextView) inflate.findViewById(R.id.tip_info);
                this.w = this.a.findViewById(R.id.divider_under_account);
                this.x = this.a.findViewById(R.id.divider_under_radiongroup);
                this.y = this.a.findViewById(R.id.divider_with_yes_no_button);
                EditText editText = (EditText) this.a.findViewById(R.id.account);
                this.f13571c = editText;
                editText.setHint(this.f13579k.getString(R.string.hint_tip_input_name));
                TextView textView = (TextView) this.a.findViewById(R.id.back);
                this.f13578j = textView;
                textView.setOnClickListener(new a(this));
                TextView textView2 = (TextView) this.a.findViewById(R.id.confirm);
                this.n = textView2;
                textView2.setOnClickListener(new View$OnClickListenerC0824b(this));
                this.o = (ProgressBar) this.a.findViewById(R.id.confirm_progress);
                this.m = (TextView) this.a.findViewById(R.id.error_info);
                this.f13572d = (RadioGroup) this.a.findViewById(R.id.names_group1);
                this.f13573e = (RadioGroup) this.a.findViewById(R.id.names_group2);
                this.f13575g = (RadioButton) this.a.findViewById(R.id.name1);
                this.f13576h = (RadioButton) this.a.findViewById(R.id.name2);
                this.f13577i = (RadioButton) this.a.findViewById(R.id.name3);
                c cVar = new c(this);
                this.f13574f = cVar;
                this.f13575g.setOnCheckedChangeListener(cVar);
                this.f13576h.setOnCheckedChangeListener(this.f13574f);
                this.f13577i.setOnCheckedChangeListener(this.f13574f);
                this.p = (TextView) this.a.findViewById(R.id.phone_info);
                q();
                Dialog dialog = new Dialog(this.f13579k, R.style.input_username_dialog);
                this.f13570b = dialog;
                dialog.setCanceledOnTouchOutside(false);
                this.f13570b.setCancelable(false);
                this.f13570b.setCanceledOnTouchOutside(false);
                r();
            }
            if (i2 == 1) {
                this.p.setText(R.string.tip_init_user_name);
            } else {
                this.p.setText(R.string.bar_friend);
            }
            if (this.f13570b.isShowing()) {
                return;
            }
            this.f13571c.setText((CharSequence) null);
            q();
            A(null);
            if (this.f13579k.isFinishing()) {
                return;
            }
            this.f13570b.setContentView(this.a);
            c.a.d.f.m.g.i(this.f13570b, this.f13579k);
            Activity activity = this.f13579k;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).ShowSoftKeyPadDelay(this.f13571c, 150);
            } else {
                new Handler().postDelayed(new g(this, this.f13571c), 150L);
            }
        }
    }
}
