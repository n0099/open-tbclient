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
/* loaded from: classes3.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f9236a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f9237b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9238c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9239d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9240e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9241f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9242g;

    /* renamed from: h  reason: collision with root package name */
    public Context f9243h;

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
        this.f9243h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f9237b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.f9236a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f9238c = (TextView) findViewById(R.id.title_text);
            this.f9239d = (TextView) findViewById(R.id.msg_text);
            this.f9240e = (TextView) findViewById(R.id.positive_btn);
            this.f9241f = (TextView) findViewById(R.id.negative_btn);
            this.f9242g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f9238c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f9238c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f9239d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f9240e.setText(str);
            this.f9240e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f9242g.setText(str);
            this.f9242g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.f9236a.setDisplayedChild(0);
            } else {
                this.f9236a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f9239d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f9241f.setText(str);
            this.f9241f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f9237b.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f9238c.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f9239d.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f9241f.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f9240e.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f9242g.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f9241f.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f9240e.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f9242g.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f9237b.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f9238c.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f9239d.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f9241f.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f9242g.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f9240e.setTextColor(this.f9243h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f9241f.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f9240e.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f9242g.setBackgroundDrawable(this.f9243h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
