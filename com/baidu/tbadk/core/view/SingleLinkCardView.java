package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.q26;
import com.baidu.tieba.tx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SingleLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleLinkCardView(Context context) {
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

    public void a(q26 q26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q26Var) == null) {
            if (q26Var instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) q26Var;
                this.a.K(pbLinkData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                    int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int f5 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int f6 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    tx4 tx4Var = new tx4(f, -1, R.color.CAM_X0305, f3, R.color.CAM_X0305, f4, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    tx4Var.b(f2);
                    tx4Var.h(f5);
                    tx4Var.i(f6);
                    spannableStringBuilder.setSpan(tx4Var, 0, pbLinkData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
                } else {
                    spannableStringBuilder.append((CharSequence) pbLinkData.title);
                }
                this.b.setText(spannableStringBuilder);
                if (pbLinkData.urlType == 2) {
                    if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                        this.c.setVisibility(8);
                    } else {
                        this.b.setMaxLines(1);
                        this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0419), pbLinkData.extTxt));
                        this.c.setVisibility(0);
                    }
                } else {
                    this.c.setVisibility(8);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.b.setMaxLines(1);
                }
            } else if (q26Var instanceof PbGoodsData) {
                PbGoodsData pbGoodsData = (PbGoodsData) q26Var;
                this.a.K(pbGoodsData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                    int f7 = ej.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int f8 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int f9 = ej.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int f10 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int f11 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int f12 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    tx4 tx4Var2 = new tx4(f7, -1, R.color.CAM_X0305, f9, R.color.CAM_X0305, f10, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    tx4Var2.b(f8);
                    tx4Var2.h(f11);
                    tx4Var2.i(f12);
                    spannableStringBuilder2.setSpan(tx4Var2, 0, pbGoodsData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkUrl);
                } else {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.title);
                }
                this.b.setText(spannableStringBuilder2);
                if (TextUtils.isEmpty(pbGoodsData.price)) {
                    this.c.setVisibility(8);
                } else {
                    this.b.setMaxLines(1);
                    this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0419), pbGoodsData.price));
                    this.c.setVisibility(0);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                    this.b.setMaxLines(1);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0305);
        }
    }

    public void setMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
            requestLayout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleLinkCardView(Context context, AttributeSet attributeSet) {
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
    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i) {
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07cf, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09102c);
        this.a = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.a.setDrawCorner(true);
        this.a.setConrers(15);
        this.a.setGifIconSupport(false);
        this.a.setLongIconSupport(false);
        this.a.setDrawBorder(true);
        this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.a.setRadius(ej.f(context, R.dimen.tbds10));
        this.a.setPlaceHolder(2);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092406);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090ce5);
        b();
    }
}
