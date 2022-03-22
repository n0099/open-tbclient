package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.l0.b;
import c.a.p0.h0.e0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SingleLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30117b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30118c;

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

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) cVar;
                this.a.J(pbLinkData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                    int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int f5 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int f6 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int f7 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    b bVar = new b(f2, -1, R.color.CAM_X0305, f4, R.color.CAM_X0305, f5, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    bVar.b(f3);
                    bVar.h(f6);
                    bVar.i(f7);
                    spannableStringBuilder.setSpan(bVar, 0, pbLinkData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
                } else {
                    spannableStringBuilder.append((CharSequence) pbLinkData.title);
                }
                this.f30117b.setText(spannableStringBuilder);
                if (pbLinkData.urlType == 2) {
                    if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                        this.f30118c.setVisibility(8);
                    } else {
                        this.f30117b.setMaxLines(1);
                        this.f30118c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0401), pbLinkData.extTxt));
                        this.f30118c.setVisibility(0);
                    }
                } else {
                    this.f30118c.setVisibility(8);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.f30117b.setMaxLines(1);
                }
            } else if (cVar instanceof PbGoodsData) {
                PbGoodsData pbGoodsData = (PbGoodsData) cVar;
                this.a.J(pbGoodsData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                    int f8 = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int f9 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int f10 = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int f11 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int f12 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int f13 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    b bVar2 = new b(f8, -1, R.color.CAM_X0305, f10, R.color.CAM_X0305, f11, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    bVar2.b(f9);
                    bVar2.h(f12);
                    bVar2.i(f13);
                    spannableStringBuilder2.setSpan(bVar2, 0, pbGoodsData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkUrl);
                } else {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.title);
                }
                this.f30117b.setText(spannableStringBuilder2);
                if (TextUtils.isEmpty(pbGoodsData.price)) {
                    this.f30118c.setVisibility(8);
                } else {
                    this.f30117b.setMaxLines(1);
                    this.f30118c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0401), pbGoodsData.price));
                    this.f30118c.setVisibility(0);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                    this.f30117b.setMaxLines(1);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.f30117b, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f30118c, (int) R.color.CAM_X0305);
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0783, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ff8);
        this.a = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.a.setDrawCorner(true);
        this.a.setConrers(15);
        this.a.setGifIconSupport(false);
        this.a.setLongIconSupport(false);
        this.a.setDrawBorder(true);
        this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.a.setRadius(n.f(context, R.dimen.tbds10));
        this.a.setPlaceHolder(2);
        this.f30117b = (TextView) findViewById(R.id.obfuscated_res_0x7f09220a);
        this.f30118c = (TextView) findViewById(R.id.obfuscated_res_0x7f090cdf);
        b();
    }
}
