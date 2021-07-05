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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.a.c;
import d.a.e0.a.d;
import d.a.e0.a.e;
import d.a.e0.a.f;
import d.a.e0.a.h;
/* loaded from: classes3.dex */
public class FingerprintDialog extends Dialog implements FingerprintDialogInterface, NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f10001a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f10002b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10003c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10004d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f10005e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f10006f;

    /* renamed from: g  reason: collision with root package name */
    public Context f10007g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f10008a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FingerprintDialog f10009b;

        public a(FingerprintDialog fingerprintDialog, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fingerprintDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10009b = fingerprintDialog;
            this.f10008a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    ViewUtility.dismissDialog((Activity) this.f10009b.f10007g, this.f10009b);
                    this.f10008a.onClick(view);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f10010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FingerprintDialog f10011b;

        public b(FingerprintDialog fingerprintDialog, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fingerprintDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10011b = fingerprintDialog;
            this.f10010a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                try {
                    ViewUtility.dismissDialog((Activity) this.f10011b.f10007g, this.f10011b);
                    this.f10010a.onClick(view);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FingerprintDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f10007g = context;
        setContentView(f.layout_sapi_sdk_fingerprint_dialog);
        this.f10001a = (LinearLayout) findViewById(e.bg_layout);
        this.f10002b = (TextView) findViewById(e.sapi_sdk_fingerprint_title);
        this.f10003c = (TextView) findViewById(e.sapi_sdk_fingerprint_sub_title);
        this.f10004d = (TextView) findViewById(e.sapi_sdk_fingerprint_negative_btn);
        this.f10005e = (TextView) findViewById(e.sapi_sdk_fingerprint_positive_btn);
        this.f10006f = (ImageView) findViewById(e.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.f10004d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f10005e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if ((i2 <= 2 ? Math.max(i2, 1) : 2) == 1) {
                this.f10004d.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10005e.getLayoutParams();
                layoutParams.leftMargin = (int) this.f10007g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
                layoutParams.rightMargin = (int) this.f10007g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
            } else {
                this.f10004d.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f10005e.getLayoutParams();
                layoutParams2.leftMargin = (int) this.f10007g.getResources().getDimension(c.sapi_sdk_finger_print_btn_left_margin);
                layoutParams2.rightMargin = (int) this.f10007g.getResources().getDimension(c.sapi_sdk_finger_print_btn_right_margin);
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
            findViewById(e.icon).setVisibility(8);
            return this;
        }
        return (FingerprintDialogInterface) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setNegativeBtn(String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener)) == null) {
            this.f10004d.setText(str);
            this.f10004d.setOnClickListener(new a(this, onClickListener));
            return this;
        }
        return (FingerprintDialogInterface) invokeLL.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, onClickListener)) == null) {
            this.f10005e.setText(str);
            this.f10005e.setOnClickListener(new b(this, onClickListener));
            return this;
        }
        return (FingerprintDialogInterface) invokeLL.objValue;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            this.f10002b.setText(str);
            this.f10003c.setText(str2);
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
                this.f10001a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
                this.f10006f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
                this.f10002b.setTextColor(this.f10007g.getResources().getColor(d.a.e0.a.b.sapi_sdk_dark_mode_edit_text_color));
                this.f10003c.setTextColor(this.f10007g.getResources().getColor(d.a.e0.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
                this.f10004d.setTextColor(this.f10007g.getResources().getColor(d.a.e0.a.b.sapi_sdk_dark_mode_edit_text_color));
                this.f10004d.setBackground(this.f10007g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
                this.f10005e.setTextColor(this.f10007g.getResources().getColor(d.a.e0.a.b.sapi_sdk_dark_mode_edit_text_color));
                this.f10005e.setBackground(this.f10007g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
            }
        }
    }
}
