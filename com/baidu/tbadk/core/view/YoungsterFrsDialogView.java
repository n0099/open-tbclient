package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.o0.r.l0.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f30227b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30228c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30229d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30230e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f30231f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f30232g;

    /* renamed from: h  reason: collision with root package name */
    public NoTipAgainView f30233h;

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
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d08e9, this);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0924bf);
            this.f30228c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ee6);
            this.f30229d = (TextView) findViewById(R.id.obfuscated_res_0x7f092249);
            this.f30230e = (TextView) findViewById(R.id.obfuscated_res_0x7f092248);
            this.f30227b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0924be);
            this.f30231f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090443);
            c cVar = new c();
            cVar.r(R.color.CAM_X0105);
            this.f30231f.setConfig(cVar);
            this.f30232g = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090444);
            c cVar2 = new c();
            cVar2.p(R.color.CAM_X0304);
            this.f30232g.setConfig(cVar2);
            this.f30233h = (NoTipAgainView) findViewById(R.id.obfuscated_res_0x7f0915a4);
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.obfuscated_res_0x7f081200);
            this.f30228c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080f2e, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(this.f30229d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f30230e, (int) R.color.CAM_X0107);
            this.f30233h.b();
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.a);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            this.f30231f.k();
            this.f30232g.k();
        }
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, onClickListener) == null) || (tBSpecificationBtn = this.f30231f) == null) {
            return;
        }
        tBSpecificationBtn.setText(getContext().getString(i));
        this.f30231f.setOnClickListener(onClickListener);
    }

    public void setNoTipAgainViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f30233h.setVisibility(z ? 0 : 8);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, onClickListener) == null) || (tBSpecificationBtn = this.f30232g) == null) {
            return;
        }
        tBSpecificationBtn.setText(getContext().getString(i));
        this.f30232g.setOnClickListener(onClickListener);
    }

    public void setTxtYoungsterDialogContentText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f30230e.setText(getContext().getString(i));
        }
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f30229d.setText(getContext().getString(i));
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f30227b.getLayoutParams();
            layoutParams.topMargin = i;
            this.f30227b.setLayoutParams(layoutParams);
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
