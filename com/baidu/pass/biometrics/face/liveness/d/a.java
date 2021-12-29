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
import com.baidu.pass.utils.CommonViewUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewSwitcher f38870b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f38871c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f38872d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38873e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38874f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38875g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38876h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38877i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38878j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f38879k;
    public TextView l;
    public LinearLayout m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
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
        this.a = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_alert_dialog);
            setCanceledOnTouchOutside(false);
            this.f38870b = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f38872d = (TextView) findViewById(R.id.dialog_title);
            this.f38873e = (TextView) findViewById(R.id.dialog_msg);
            this.f38874f = (TextView) findViewById(R.id.msg_text);
            this.f38875g = (TextView) findViewById(R.id.pass_bio_dialog_time_left);
            this.f38876h = (TextView) findViewById(R.id.pass_bio_dialog_time_center);
            this.f38877i = (TextView) findViewById(R.id.pass_bio_dialog_time_right);
            this.f38878j = (TextView) findViewById(R.id.positive_btn);
            this.f38879k = (TextView) findViewById(R.id.negative_btn);
            this.l = (TextView) findViewById(R.id.neutral_btn);
            this.m = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
            this.f38871c = (LinearLayout) findViewById(R.id.pass_bio_dialog_ll_content);
            CommonViewUtility.setViewClickAlpha(this.f38878j, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.f38879k, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f38872d.setText(str);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f38873e.setVisibility(0);
            this.f38873e.setText(str);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.f38872d.setVisibility(0);
            } else {
                this.f38872d.setVisibility(8);
            }
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.m.setVisibility(0);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f38874f.setText(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, onClickListener) == null) {
            this.f38878j.setText(str);
            this.f38878j.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.l.setText(str);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.f38870b.setDisplayedChild(0);
            } else {
                this.f38870b.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f38874f.setVisibility(0);
            this.f38874f.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f38879k.setText(str);
            this.f38879k.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f38871c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f38872d.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
                this.f38873e.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f38874f.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f38875g.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f38876h.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f38877i.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f38879k.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f38878j.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.l.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f38879k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f38878j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                return;
            }
            this.f38871c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f38872d.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f38873e.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f38874f.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f38875g.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f38876h.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f38877i.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f38879k.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f38878j.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.l.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f38879k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f38878j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        }
    }
}
