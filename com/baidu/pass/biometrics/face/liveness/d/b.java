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
/* loaded from: classes10.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewSwitcher a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f38724b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f38725c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f38726d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38727e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38728f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38729g;

    /* renamed from: h  reason: collision with root package name */
    public Context f38730h;

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
        this.f38730h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f38724b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f38725c = (TextView) findViewById(R.id.title_text);
            this.f38726d = (TextView) findViewById(R.id.msg_text);
            this.f38727e = (TextView) findViewById(R.id.positive_btn);
            this.f38728f = (TextView) findViewById(R.id.negative_btn);
            this.f38729g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f38725c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f38725c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f38726d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f38727e.setText(str);
            this.f38727e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f38729g.setText(str);
            this.f38729g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.a.setDisplayedChild(0);
            } else {
                this.a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f38726d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f38728f.setText(str);
            this.f38728f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f38724b.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f38725c.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f38726d.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f38728f.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f38727e.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f38729g.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f38728f.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f38727e.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f38729g.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f38724b.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f38725c.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f38726d.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f38728f.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f38729g.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f38727e.setTextColor(this.f38730h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f38728f.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f38727e.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f38729g.setBackgroundDrawable(this.f38730h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
