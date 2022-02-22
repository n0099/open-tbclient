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
/* loaded from: classes11.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewSwitcher f37844b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f37845c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37846d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37847e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37848f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37849g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37850h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37851i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f37852j;
    public TextView k;
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
            this.f37844b = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f37846d = (TextView) findViewById(R.id.dialog_title);
            this.f37847e = (TextView) findViewById(R.id.dialog_msg);
            this.f37848f = (TextView) findViewById(R.id.msg_text);
            this.f37849g = (TextView) findViewById(R.id.pass_bio_dialog_time_left);
            this.f37850h = (TextView) findViewById(R.id.pass_bio_dialog_time_center);
            this.f37851i = (TextView) findViewById(R.id.pass_bio_dialog_time_right);
            this.f37852j = (TextView) findViewById(R.id.positive_btn);
            this.k = (TextView) findViewById(R.id.negative_btn);
            this.l = (TextView) findViewById(R.id.neutral_btn);
            this.m = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
            this.f37845c = (LinearLayout) findViewById(R.id.pass_bio_dialog_ll_content);
            CommonViewUtility.setViewClickAlpha(this.f37852j, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.k, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f37846d.setText(str);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f37847e.setVisibility(0);
            this.f37847e.setText(str);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.f37846d.setVisibility(0);
            } else {
                this.f37846d.setVisibility(8);
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
            this.f37848f.setText(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, onClickListener) == null) {
            this.f37852j.setText(str);
            this.f37852j.setOnClickListener(onClickListener);
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
                this.f37844b.setDisplayedChild(0);
            } else {
                this.f37844b.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f37848f.setVisibility(0);
            this.f37848f.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.k.setText(str);
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f37845c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f37846d.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
                this.f37847e.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f37848f.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f37849g.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f37850h.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.f37851i.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color_night));
                this.k.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f37852j.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.l.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f37852j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                return;
            }
            this.f37845c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f37846d.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f37847e.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f37848f.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f37849g.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f37850h.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.f37851i.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_time_out_msg_color));
            this.k.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f37852j.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.l.setTextColor(this.a.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f37852j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
        }
    }
}
