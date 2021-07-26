package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.f0.n.c;
/* loaded from: classes3.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f12721e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f12722f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f12723g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12724h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12725i;
    public TBSpecificationBtn j;
    public TBSpecificationBtn k;
    public NoTipAgainView l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterFrsDialogView(Context context) {
        this(context, null);
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
            LinearLayout.inflate(getContext(), R.layout.youngster_frs_dialog_view, this);
            this.f12721e = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
            this.f12723g = (ImageView) findViewById(R.id.img_youngster_top);
            this.f12724h = (TextView) findViewById(R.id.txt_youngster_dialog_title);
            this.f12725i = (TextView) findViewById(R.id.txt_youngster_dialog_content);
            this.f12722f = (LinearLayout) findViewById(R.id.youngster_dialog_group);
            this.j = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
            c cVar = new c();
            cVar.q(R.color.CAM_X0105);
            this.j.setConfig(cVar);
            this.k = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
            c cVar2 = new c();
            cVar2.o(R.color.CAM_X0304);
            this.k.setConfig(cVar2);
            this.l = (NoTipAgainView) findViewById(R.id.no_tip_again);
            c();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoTipAgainView noTipAgainView = this.l;
            if (noTipAgainView == null) {
                return false;
            }
            return noTipAgainView.b();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.transparent_bg);
            this.f12723g.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.pic_mask_qingshaonian_time, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(this.f12724h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12725i, R.color.CAM_X0107);
            this.l.c();
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f12721e);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            this.j.k();
            this.k.k();
        }
    }

    public void setLeftOnClickListener(int i2, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, onClickListener) == null) || (tBSpecificationBtn = this.j) == null) {
            return;
        }
        tBSpecificationBtn.setText(getContext().getString(i2));
        this.j.setOnClickListener(onClickListener);
    }

    public void setNoTipAgainViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l.setVisibility(z ? 0 : 8);
        }
    }

    public void setRightOnClickListener(int i2, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i2, onClickListener) == null) || (tBSpecificationBtn = this.k) == null) {
            return;
        }
        tBSpecificationBtn.setText(getContext().getString(i2));
        this.k.setOnClickListener(onClickListener);
    }

    public void setTxtYoungsterDialogContentText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f12725i.setText(getContext().getString(i2));
        }
    }

    public void setTxtYoungsterDialogTitleText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f12724h.setText(getContext().getString(i2));
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12722f.getLayoutParams();
            layoutParams.topMargin = i2;
            this.f12722f.setLayoutParams(layoutParams);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
