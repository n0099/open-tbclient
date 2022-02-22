package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class RimLivenessBaseDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f34702b;

    /* renamed from: c  reason: collision with root package name */
    public Button f34703c;

    /* renamed from: d  reason: collision with root package name */
    public Button f34704d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RimLivenessBaseDialog(Context context) {
        super(context, R.style.BeautyDialog);
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setContentView(R.layout.rim_liveness_alert_dialog_base);
            this.a = (TextView) findViewById(R.id.dialog_title);
            this.f34702b = (LinearLayout) findViewById(R.id.dialog_content);
            this.f34703c = (Button) findViewById(R.id.positive_btn);
            this.f34704d = (Button) findViewById(R.id.negative_btn);
            setCancelable(false);
        }
    }

    public void addContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this.f34702b, true);
        }
    }

    public void setNegativeBtnClickListener(CharSequence charSequence, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, onClickListener) == null) {
            findViewById(R.id.btn_line).setVisibility(0);
            this.f34704d.setVisibility(0);
            this.f34704d.setText(charSequence);
            this.f34704d.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtnClickListener(CharSequence charSequence, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, onClickListener) == null) {
            this.f34703c.setText(charSequence);
            this.f34703c.setOnClickListener(onClickListener);
        }
    }

    public void setTextViewContent(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(charSequence);
            textView.setGravity(17);
            textView.setTextColor(getContext().getResources().getColor(R.color.sapi_dialog_title_text_color));
            textView.setTextSize(1, getContext().getResources().getDimension(R.dimen.rim_base_level16Font));
            textView.setLineSpacing(1.0f, 1.2f);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.rim_dimen_20dp);
            textView.setPadding(dimension, dimension, dimension, dimension);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f34702b.addView(textView);
        }
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) {
            this.a.setText(charSequence);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RimLivenessBaseDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }
}
