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
    public ViewSwitcher f43924a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f43925b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f43926c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f43927d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43928e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43929f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43930g;

    /* renamed from: h  reason: collision with root package name */
    public Context f43931h;

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
        this.f43931h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.layout_pass_liveness_dialog_alert);
            setCanceledOnTouchOutside(false);
            this.f43925b = (LinearLayout) findViewById(R.id.pass_bio_dialog_alert_ll_content);
            this.f43924a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f43926c = (TextView) findViewById(R.id.title_text);
            this.f43927d = (TextView) findViewById(R.id.msg_text);
            this.f43928e = (TextView) findViewById(R.id.positive_btn);
            this.f43929f = (TextView) findViewById(R.id.negative_btn);
            this.f43930g = (TextView) findViewById(R.id.neutral_btn);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f43926c.setText(str);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f43926c.setVisibility(i2);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f43927d.setVisibility(i2);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f43928e.setText(str);
            this.f43928e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f43930g.setText(str);
            this.f43930g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if ((i2 < 1 ? 1 : Math.min(i2, 2)) == 2) {
                this.f43924a.setDisplayedChild(0);
            } else {
                this.f43924a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f43927d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f43929f.setText(str);
            this.f43929f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f43925b.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg_night));
                this.f43926c.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_title_text_color_night));
                this.f43927d.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_content_text_color_night));
                this.f43929f.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f43928e.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color_night));
                this.f43930g.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color_night));
                this.f43929f.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                this.f43928e.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg_night));
                this.f43930g.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg_night));
                return;
            }
            this.f43925b.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_dialog_bg));
            this.f43926c.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_title_text_color));
            this.f43927d.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_content_text_color));
            this.f43929f.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f43930g.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_negative_btn_text_color));
            this.f43928e.setTextColor(this.f43931h.getResources().getColor(R.color.pass_bio_dialog_positive_btn_text_color));
            this.f43929f.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
            this.f43928e.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_positive_btn_bg));
            this.f43930g.setBackgroundDrawable(this.f43931h.getResources().getDrawable(R.drawable.pass_liveness_bio_dialog_negative_btn_bg));
        }
    }
}
