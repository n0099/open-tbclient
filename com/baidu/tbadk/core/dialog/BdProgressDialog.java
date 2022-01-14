package com.baidu.tbadk.core.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BdProgressDialog extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f40148e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40149f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40150g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView f40151h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f40152i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdProgressDialog(Context context) {
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

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f40148e = str;
            TextView textView = this.f40150g;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void setPercent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TextView textView = this.f40149f;
            if (textView != null) {
                textView.setText(i2 + "%");
            }
            CircleView circleView = this.f40151h;
            if (circleView != null) {
                circleView.setProgress(i2);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setContentView(R.layout.post_video_progress_dialog);
                FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.frame_progress_dialog);
                this.f40152i = frameLayout;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
                this.f40152i.setLayoutParams(layoutParams);
                if (!StringUtils.isNull(this.f40148e)) {
                    TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                    this.f40150g = textView;
                    textView.setText(this.f40148e);
                }
                this.f40149f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
                this.f40151h = (CircleView) window.findViewById(R.id.circle_progress_dialog);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdProgressDialog(Context context, int i2) {
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
