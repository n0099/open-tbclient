package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewSwitcher a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f36256b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36257c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36258d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36259e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36260f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36261g;

    /* renamed from: h  reason: collision with root package name */
    public Context f36262h;

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
        this.f36262h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f36256b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f36257c = (TextView) findViewById(R.id.title_text);
            this.f36258d = (TextView) findViewById(R.id.msg_text);
            this.f36259e = (TextView) findViewById(R.id.positive_btn);
            this.f36260f = (TextView) findViewById(R.id.negative_btn);
            this.f36261g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f36257c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f36257c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f36258d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f36259e.setText(str);
            this.f36259e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f36261g.setText(str);
            this.f36261g.setOnClickListener(onClickListener);
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
            this.f36258d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f36260f.setText(str);
            this.f36260f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f36256b.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f36257c.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f36258d.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f36260f.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f36259e.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f36261g.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f36260f.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f36259e.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f36261g.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f36256b.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f36257c.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f36258d.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f36260f.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f36261g.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f36259e.setTextColor(this.f36262h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f36260f.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f36259e.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f36261g.setBackgroundDrawable(this.f36262h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
