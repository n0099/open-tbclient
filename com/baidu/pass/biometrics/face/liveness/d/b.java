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
/* loaded from: classes7.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f42718a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f42719b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42720c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42721d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42722e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42723f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42724g;

    /* renamed from: h  reason: collision with root package name */
    public Context f42725h;

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
        this.f42725h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f42719b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.f42718a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f42720c = (TextView) findViewById(R.id.title_text);
            this.f42721d = (TextView) findViewById(R.id.msg_text);
            this.f42722e = (TextView) findViewById(R.id.positive_btn);
            this.f42723f = (TextView) findViewById(R.id.negative_btn);
            this.f42724g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f42720c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f42720c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f42721d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f42722e.setText(str);
            this.f42722e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f42724g.setText(str);
            this.f42724g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.f42718a.setDisplayedChild(0);
            } else {
                this.f42718a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f42721d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f42723f.setText(str);
            this.f42723f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f42719b.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f42720c.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f42721d.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f42723f.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f42722e.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f42724g.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f42723f.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f42722e.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f42724g.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f42719b.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f42720c.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f42721d.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f42723f.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f42724g.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f42722e.setTextColor(this.f42725h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f42723f.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f42722e.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f42724g.setBackgroundDrawable(this.f42725h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
