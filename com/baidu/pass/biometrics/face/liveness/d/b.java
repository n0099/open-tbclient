package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f9279a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9280b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9281c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9282d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9283e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9284f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9285g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9286h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.PassBioBeautyDialog);
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
        this.f9286h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f9280b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.f9279a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f9281c = (TextView) findViewById(R.id.title_text);
            this.f9282d = (TextView) findViewById(R.id.msg_text);
            this.f9283e = (TextView) findViewById(R.id.positive_btn);
            this.f9284f = (TextView) findViewById(R.id.negative_btn);
            this.f9285g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f9281c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f9281c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f9282d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f9283e.setText(str);
            this.f9283e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f9285g.setText(str);
            this.f9285g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.f9279a.setDisplayedChild(0);
            } else {
                this.f9279a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f9282d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f9284f.setText(str);
            this.f9284f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f9280b.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f9281c.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f9282d.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f9284f.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f9283e.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f9285g.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f9284f.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f9283e.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f9285g.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f9280b.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f9281c.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f9282d.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f9284f.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f9285g.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f9283e.setTextColor(this.f9286h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f9284f.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f9283e.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f9285g.setBackgroundDrawable(this.f9286h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
