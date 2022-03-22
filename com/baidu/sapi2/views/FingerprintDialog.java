package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.touchid.FingerprintDialogInterface;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FingerprintDialog extends Dialog implements FingerprintDialogInterface, NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28542b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28543c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28544d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28545e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f28546f;

    /* renamed from: g  reason: collision with root package name */
    public Context f28547g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FingerprintDialog f28548b;

        public a(FingerprintDialog fingerprintDialog, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fingerprintDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28548b = fingerprintDialog;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    ViewUtility.dismissDialog((Activity) this.f28548b.f28547g, this.f28548b);
                    this.a.onClick(view);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FingerprintDialog f28549b;

        public b(FingerprintDialog fingerprintDialog, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fingerprintDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28549b = fingerprintDialog;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    ViewUtility.dismissDialog((Activity) this.f28549b.f28547g, this.f28549b);
                    this.a.onClick(view);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FingerprintDialog(Context context) {
        super(context, R.style.obfuscated_res_0x7f10017f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28547g = context;
        setContentView(R.layout.obfuscated_res_0x7f0d04d2);
        this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09035f);
        this.f28542b = (TextView) findViewById(R.id.obfuscated_res_0x7f091b93);
        this.f28543c = (TextView) findViewById(R.id.obfuscated_res_0x7f091b92);
        this.f28544d = (TextView) findViewById(R.id.obfuscated_res_0x7f091b90);
        this.f28545e = (TextView) findViewById(R.id.obfuscated_res_0x7f091b91);
        this.f28546f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091b8f);
        a();
        ViewUtility.setViewClickAlpha(this.f28544d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f28545e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if ((i <= 2 ? Math.max(i, 1) : 2) == 1) {
                this.f28544d.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f28545e.getLayoutParams();
                layoutParams.leftMargin = (int) this.f28547g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705bd);
                layoutParams.rightMargin = (int) this.f28547g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705bd);
            } else {
                this.f28544d.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f28545e.getLayoutParams();
                layoutParams2.leftMargin = (int) this.f28547g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705bc);
                layoutParams2.rightMargin = (int) this.f28547g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705be);
            }
            return this;
        }
        return (FingerprintDialogInterface) invokeI.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setIconInvisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            findViewById(R.id.obfuscated_res_0x7f090e06).setVisibility(8);
            return this;
        }
        return (FingerprintDialogInterface) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setNegativeBtn(String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener)) == null) {
            this.f28544d.setText(str);
            this.f28544d.setOnClickListener(new a(this, onClickListener));
            return this;
        }
        return (FingerprintDialogInterface) invokeLL.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, onClickListener)) == null) {
            this.f28545e.setText(str);
            this.f28545e.setOnClickListener(new b(this, onClickListener));
            return this;
        }
        return (FingerprintDialogInterface) invokeLL.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            this.f28542b.setText(str);
            this.f28543c.setText(str2);
            return this;
        }
        return (FingerprintDialogInterface) invokeLL.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            show();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f081033);
                this.f28546f.setImageResource(R.drawable.obfuscated_res_0x7f081031);
                this.f28542b.setTextColor(this.f28547g.getResources().getColor(R.color.obfuscated_res_0x7f0609a5));
                this.f28543c.setTextColor(this.f28547g.getResources().getColor(R.color.obfuscated_res_0x7f0609d7));
                this.f28544d.setTextColor(this.f28547g.getResources().getColor(R.color.obfuscated_res_0x7f0609a5));
                this.f28544d.setBackground(this.f28547g.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081035));
                this.f28545e.setTextColor(this.f28547g.getResources().getColor(R.color.obfuscated_res_0x7f0609a5));
                this.f28545e.setBackground(this.f28547g.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081037));
            }
        }
    }
}
