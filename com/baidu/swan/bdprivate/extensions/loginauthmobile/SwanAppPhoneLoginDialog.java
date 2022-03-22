package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.x;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppPhoneLoginDialog extends SwanAppLoginAndGetMobileDialog implements CompoundButton.OnCheckedChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdBaseImageView j;
    public BdBaseImageView k;
    public AccountSmsLoginView l;
    public FrameLayout m;
    public CheckBox n;
    public TextView o;
    public boolean p;
    public boolean q;
    public EditText r;
    public TextView s;
    public View t;

    /* loaded from: classes4.dex */
    public class a extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.a;
                swanAppPhoneLoginDialog.J0(!swanAppPhoneLoginDialog.q);
                this.a.D0();
                if (this.a.q) {
                    FragmentManager fragmentManager = this.a.getFragmentManager();
                    if (fragmentManager != null) {
                        fragmentManager.popBackStackImmediate();
                    }
                    SwanAppPhoneLoginDialog swanAppPhoneLoginDialog2 = this.a;
                    c.a.n0.b.g.b.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog2.f29383h, swanAppPhoneLoginDialog2.i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        public b(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.J0(true);
                this.a.D0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        public c(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.J0(false);
                this.a.D0();
                FragmentManager fragmentManager = this.a.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.popBackStackImmediate();
                }
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.a;
                c.a.n0.b.g.b.d.a("show", "quickLogin", null, swanAppPhoneLoginDialog.f29383h, swanAppPhoneLoginDialog.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        public d(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n.setVisibility(8);
                this.a.s.setVisibility(8);
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.n.setVisibility(0);
                this.a.s.setVisibility(0);
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.a;
                c.a.n0.b.g.b.d.a("click", "telLogin", com.baidu.pass.biometrics.face.liveness.b.a.g0, swanAppPhoneLoginDialog.f29383h, swanAppPhoneLoginDialog.i);
                if (this.a.p) {
                    this.a.D0();
                    return;
                }
                SwanAppLoginAndGetMobileDialog.b bVar = this.a.a;
                if (bVar != null) {
                    bVar.onLoginResult(-1);
                }
                FragmentActivity fragmentActivity = this.a.f29377b;
                if (fragmentActivity == null || fragmentActivity.getWindow() == null) {
                    return;
                }
                FragmentActivity fragmentActivity2 = this.a.f29377b;
                x.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
            }
        }

        @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog.g
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = this.a;
                c.a.n0.b.g.b.d.a("click", "telLogin", "succ_agree", swanAppPhoneLoginDialog.f29383h, swanAppPhoneLoginDialog.i);
                FragmentActivity fragmentActivity = this.a.f29377b;
                if (fragmentActivity != null && fragmentActivity.getWindow() != null) {
                    FragmentActivity fragmentActivity2 = this.a.f29377b;
                    x.a(fragmentActivity2, fragmentActivity2.getWindow().getDecorView().getWindowToken());
                }
                SwanAppLoginAndGetMobileDialog.b bVar = this.a.a;
                if (bVar != null) {
                    bVar.onLoginResult(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        public e(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l == null) {
                return;
            }
            this.a.l.clean();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog a;

        public f(SwanAppPhoneLoginDialog swanAppPhoneLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppPhoneLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppPhoneLoginDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.n0.a.s1.b.f.e.f(this.a.f29377b, R.string.obfuscated_res_0x7f0f12e7).H(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a();

        void b();

        void onFailure();

        void onSuccess();
    }

    public SwanAppPhoneLoginDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AccountSmsLoginView accountSmsLoginView = this.l;
            if (accountSmsLoginView != null) {
                accountSmsLoginView.close();
            }
            super.D0();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CheckBox checkBox = this.n;
            if (checkBox != null) {
                checkBox.setVisibility(0);
                this.n.setOnCheckedChangeListener(this);
            }
            TextView textView = this.s;
            if (textView != null) {
                textView.setVisibility(0);
            }
            JSONObject jSONObject = new JSONObject();
            String str = null;
            try {
                jSONObject.put("sms_login", "native");
                str = URLEncoder.encode(jSONObject.toString(), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            c.a.n0.b.c.a.P(getContext(), new d(this), str);
            AccountSmsLoginView accountSmsLoginView = new AccountSmsLoginView(getContext());
            this.l = accountSmsLoginView;
            this.m.addView(accountSmsLoginView);
            this.r = (EditText) this.f29379d.findViewById(R.id.obfuscated_res_0x7f09181f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n0.g(80.0f));
            layoutParams.setMargins(n0.g(40.0f), 0, n0.g(40.0f), 0);
            this.m.addView(this.t, layoutParams);
            this.t.setVisibility(8);
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void F0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07c2, viewGroup, false);
            this.f29379d = linearLayout;
            this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090662);
            this.k = (BdBaseImageView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f0902ef);
            this.n = (CheckBox) this.f29379d.findViewById(R.id.obfuscated_res_0x7f091826);
            this.m = (FrameLayout) this.f29379d.findViewById(R.id.obfuscated_res_0x7f091338);
            this.t = new View(getContext());
            this.o = (TextView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f09202b);
            this.s = (TextView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f0922d3);
            U0();
            this.j.setOnClickListener(new b(this));
            if (this.q) {
                this.k.setVisibility(0);
                this.k.setOnClickListener(new c(this));
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void G0(boolean z) {
        AccountSmsLoginView accountSmsLoginView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.G0(z);
            if (this.m != null && (accountSmsLoginView = this.l) != null) {
                accountSmsLoginView.close();
                this.m.removeView(this.l);
            }
            E0();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void M0() {
        Resources resources;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (resources = getContext().getResources()) == null) {
            return;
        }
        this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081167));
        this.k.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f080103));
        TextView textView = this.o;
        boolean z = this.f29378c;
        int i = R.color.obfuscated_res_0x7f0603c1;
        textView.setTextColor(resources.getColor(z ? R.color.obfuscated_res_0x7f0603c1 : R.color.obfuscated_res_0x7f0603c0));
        CheckBox checkBox = this.n;
        if (!this.f29378c) {
            i = R.color.obfuscated_res_0x7f0603c0;
        }
        checkBox.setTextColor(resources.getColor(i));
        this.n.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.f29378c ? R.drawable.obfuscated_res_0x7f0800d1 : R.drawable.obfuscated_res_0x7f0800d0), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f12ad);
            CheckBox checkBox = this.n;
            if (!TextUtils.isEmpty(this.f29380e)) {
                string = String.format(getString(R.string.obfuscated_res_0x7f0f1270), this.f29380e);
            }
            checkBox.setText(string);
            this.l.postDelayed(new e(this), 150L);
        }
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.q = z;
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f12cd));
            C0(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f12cc), c.a.n0.a.s0.a.o().G());
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f12ca));
            C0(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f12c9), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
            this.s.setMovementMethod(LinkMovementMethod.getInstance());
            this.s.setText(spannableStringBuilder);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, compoundButton, z) == null) {
            if (z) {
                this.t.setVisibility(8);
                this.r.setEnabled(true);
                this.l.p();
                return;
            }
            this.t.setVisibility(0);
            this.t.setOnClickListener(new f(this));
            this.r.setEnabled(false);
            c.a.n0.a.s1.b.f.e.f(this.f29377b, R.string.obfuscated_res_0x7f0f12e7).H(true);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) ? new a(this, this.f29377b, getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            S0();
            return this.f29379d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AccountSmsLoginView accountSmsLoginView = this.l;
            if (accountSmsLoginView != null) {
                accountSmsLoginView.close();
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dialogInterface) == null) {
            AccountSmsLoginView accountSmsLoginView = this.l;
            if (accountSmsLoginView != null) {
                accountSmsLoginView.close();
            }
            super.onDismiss(dialogInterface);
        }
    }
}
