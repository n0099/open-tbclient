package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BdProgressDialog1080 extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f40181e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40182f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40183g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView1080 f40184h;

    /* renamed from: i  reason: collision with root package name */
    public int f40185i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdProgressDialog1080(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40185i : invokeV.intValue;
    }

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f40181e = str;
            TextView textView = this.f40183g;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void setPercent(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 == this.f40185i) {
            return;
        }
        this.f40185i = i2;
        TextView textView = this.f40182f;
        if (textView != null) {
            textView.setText(i2 + "%");
        }
        CircleView1080 circleView1080 = this.f40184h;
        if (circleView1080 != null) {
            circleView1080.setProgress(i2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setContentView(R.layout.progress_dialog_1080);
                View findViewById = findViewById(R.id.frame_progress_dialog);
                if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                    layoutParams.topMargin = n.f(getContext(), R.dimen.tbds50);
                    findViewById.setLayoutParams(layoutParams);
                }
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f40183g = textView;
                if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f40183g.getLayoutParams();
                    layoutParams2.topMargin = n.f(getContext(), R.dimen.tbds35);
                    this.f40183g.setLayoutParams(layoutParams2);
                }
                if (!StringUtils.isNull(this.f40181e)) {
                    this.f40183g.setText(this.f40181e);
                }
                this.f40182f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
                this.f40184h = (CircleView1080) window.findViewById(R.id.circle_progress_dialog);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdProgressDialog1080(Context context, int i2) {
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
    }
}
