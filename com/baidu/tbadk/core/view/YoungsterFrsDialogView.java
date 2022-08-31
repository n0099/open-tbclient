package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.ns4;
import com.baidu.tieba.rv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public LinearLayout b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TBSpecificationBtn f;
    public TBSpecificationBtn g;
    public NoTipAgainView h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterFrsDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d091e, this);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092685);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090efd);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0923ec);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0923eb);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092684);
            this.f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090458);
            rv4 rv4Var = new rv4();
            rv4Var.r(R.color.CAM_X0105);
            this.f.setConfig(rv4Var);
            this.g = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090459);
            rv4 rv4Var2 = new rv4();
            rv4Var2.p(R.color.CAM_X0304);
            this.g.setConfig(rv4Var2);
            this.h = (NoTipAgainView) findViewById(R.id.obfuscated_res_0x7f0916af);
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.obfuscated_res_0x7f081211);
            this.c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080f3f, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
            this.h.b();
            ns4 d = ns4.d(this.a);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            this.f.k();
            this.g.k();
        }
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, onClickListener) == null) || (tBSpecificationBtn = this.f) == null) {
            return;
        }
        tBSpecificationBtn.setText(getContext().getString(i));
        this.f.setOnClickListener(onClickListener);
    }

    public void setNoTipAgainViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, onClickListener) == null) || (tBSpecificationBtn = this.g) == null) {
            return;
        }
        tBSpecificationBtn.setText(getContext().getString(i));
        this.g.setOnClickListener(onClickListener);
    }

    public void setTxtYoungsterDialogContentText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e.setText(getContext().getString(i));
        }
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d.setText(getContext().getString(i));
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.topMargin = i;
            this.b.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
