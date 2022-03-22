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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import c.a.n0.a.s1.b.f.e;
import c.a.n0.b.g.b.d;
import c.a.n0.b.g.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwanAppQuickLoginDialog extends SwanAppLoginAndGetMobileDialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdBaseImageView j;
    public TextView k;
    public TextView l;
    public CheckBox m;
    public Button n;
    public TextView o;
    public TextView p;

    /* loaded from: classes4.dex */
    public class a extends Dialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppQuickLoginDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppQuickLoginDialog swanAppQuickLoginDialog, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppQuickLoginDialog, context, Integer.valueOf(i)};
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
            this.a = swanAppQuickLoginDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J0(true);
                this.a.D0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppQuickLoginDialog a;

        public b(SwanAppQuickLoginDialog swanAppQuickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppQuickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppQuickLoginDialog;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.a.n.setClickable(true);
                    this.a.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f081134);
                    return;
                }
                this.a.n.setClickable(false);
                e.f(this.a.f29377b, R.string.obfuscated_res_0x7f0f12e7).H(true);
                this.a.n.setBackgroundResource(R.drawable.obfuscated_res_0x7f08117a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.n0.b.g.d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppQuickLoginDialog a;

        public c(SwanAppQuickLoginDialog swanAppQuickLoginDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppQuickLoginDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppQuickLoginDialog;
        }

        @Override // c.a.n0.b.g.d.e
        public void onResult(int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a.onLoginResult(i);
                if (i == 0) {
                    str = "succ_agree";
                } else {
                    this.a.P0();
                    str = com.baidu.pass.biometrics.face.liveness.b.a.g0;
                }
                SwanAppQuickLoginDialog swanAppQuickLoginDialog = this.a;
                d.a("click", "quickLogin", str, swanAppQuickLoginDialog.f29383h, swanAppQuickLoginDialog.i);
            }
        }
    }

    public SwanAppQuickLoginDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void F0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutInflater, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07c9, viewGroup, false);
            this.f29379d = linearLayout;
            this.j = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090662);
            this.k = (TextView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f09202b);
            this.m = (CheckBox) this.f29379d.findViewById(R.id.obfuscated_res_0x7f091826);
            this.l = (TextView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f0922c4);
            this.n = (Button) this.f29379d.findViewById(R.id.obfuscated_res_0x7f0922c9);
            this.o = (TextView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f0922ba);
            this.p = (TextView) this.f29379d.findViewById(R.id.obfuscated_res_0x7f0922d3);
            S0();
            R0();
            QuickLoginInfo quickLoginInfo = this.f29381f;
            if (quickLoginInfo != null) {
                this.l.setText(quickLoginInfo.encryptPhoneNum);
            }
            this.o.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.m.setOnCheckedChangeListener(new b(this));
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog
    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Resources resources = getContext().getResources();
            this.j.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081167));
            TextView textView = this.k;
            boolean z = this.f29378c;
            int i = R.color.obfuscated_res_0x7f0603c0;
            textView.setTextColor(resources.getColor(z ? R.color.obfuscated_res_0x7f0603c1 : R.color.obfuscated_res_0x7f0603c0));
            this.l.setTextColor(resources.getColor(this.f29378c ? R.color.obfuscated_res_0x7f0603c1 : R.color.obfuscated_res_0x7f060a26));
            CheckBox checkBox = this.m;
            if (this.f29378c) {
                i = R.color.obfuscated_res_0x7f0603c1;
            }
            checkBox.setTextColor(resources.getColor(i));
            this.m.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(this.f29378c ? R.drawable.obfuscated_res_0x7f0800d1 : R.drawable.obfuscated_res_0x7f0800d0), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final void P0() {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fragmentManager = getFragmentManager()) == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        J0(false);
        SwanAppPhoneLoginDialog swanAppPhoneLoginDialog = (SwanAppPhoneLoginDialog) c.a.n0.b.g.b.e.a(this.f29380e, this.f29378c, null, this.f29383h, this.i);
        swanAppPhoneLoginDialog.I0(getActivity());
        swanAppPhoneLoginDialog.T0(true);
        swanAppPhoneLoginDialog.K0((SwanAppLoginAndGetMobileDialog.b) this.f29377b);
        swanAppPhoneLoginDialog.show(fragmentManager, "swan_phone_login");
        d.a("show", "telLogin", null, this.f29383h, this.i);
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!SwanAppNetworkUtils.i(this.f29377b)) {
                e.f(this.f29377b, R.string.obfuscated_res_0x7f0f129b).H(true);
                return;
            }
            QuickLoginInfo quickLoginInfo = this.f29381f;
            if (quickLoginInfo == null) {
                return;
            }
            f.e(this.f29377b, quickLoginInfo.loginMode, new c(this));
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f12ad);
            CheckBox checkBox = this.m;
            if (!TextUtils.isEmpty(this.f29380e)) {
                string = String.format(getString(R.string.obfuscated_res_0x7f0f1270), this.f29380e);
            }
            checkBox.setText(string);
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f12cd));
            if (this.f29381f != null) {
                int length = spannableStringBuilder.length();
                QuickLoginInfo quickLoginInfo = this.f29381f;
                C0(spannableStringBuilder, length, quickLoginInfo.agreeText, quickLoginInfo.serviceAgreement);
                spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f12ca));
            }
            C0(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f12cc), c.a.n0.a.s0.a.o().G());
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f12ca));
            C0(spannableStringBuilder, spannableStringBuilder.length(), getString(R.string.obfuscated_res_0x7f0f12c9), "https://passport.baidu.com/static/passpc-account/html/protocal.html");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f12cb));
            this.p.setMovementMethod(LinkMovementMethod.getInstance());
            this.p.setText(spannableStringBuilder);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f0922ba) {
                P0();
            } else if (id == R.id.obfuscated_res_0x7f0922c9) {
                Q0();
            } else if (id == R.id.obfuscated_res_0x7f090662) {
                J0(true);
                D0();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) ? new a(this, this.f29377b, getTheme()) : (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
        }
    }
}
