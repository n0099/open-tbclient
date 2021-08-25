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
/* loaded from: classes5.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f44031a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f44032b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f44033c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f44034d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44035e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44036f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44037g;

    /* renamed from: h  reason: collision with root package name */
    public Context f44038h;

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
        this.f44038h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f44032b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.f44031a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f44033c = (TextView) findViewById(R.id.title_text);
            this.f44034d = (TextView) findViewById(R.id.msg_text);
            this.f44035e = (TextView) findViewById(R.id.positive_btn);
            this.f44036f = (TextView) findViewById(R.id.negative_btn);
            this.f44037g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f44033c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f44033c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f44034d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f44035e.setText(str);
            this.f44035e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f44037g.setText(str);
            this.f44037g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.f44031a.setDisplayedChild(0);
            } else {
                this.f44031a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f44034d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f44036f.setText(str);
            this.f44036f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f44032b.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f44033c.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f44034d.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f44036f.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f44035e.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f44037g.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f44036f.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f44035e.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f44037g.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f44032b.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f44033c.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f44034d.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f44036f.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f44037g.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f44035e.setTextColor(this.f44038h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f44036f.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f44035e.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f44037g.setBackgroundDrawable(this.f44038h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
