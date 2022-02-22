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
import c.a.t0.s.l0.b;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import c.a.u0.g0.d0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SingleLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f40729e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40730f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40731g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleLinkCardView(Context context) {
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

    public void bindData(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) cVar;
                this.f40729e.startLoad(pbLinkData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                    int f2 = n.f(TbadkCoreApplication.getInst(), e.L_X01);
                    int f3 = n.f(TbadkCoreApplication.getInst(), e.tbds10);
                    int i2 = d.CAM_X0305;
                    int f4 = n.f(TbadkCoreApplication.getInst(), e.T_X10);
                    int f5 = n.f(TbadkCoreApplication.getInst(), e.M_W_X002);
                    int f6 = n.f(TbadkCoreApplication.getInst(), e.tbds2);
                    int f7 = n.f(TbadkCoreApplication.getInst(), e.M_W_X003);
                    b bVar = new b(f2, -1, i2, f4, i2, f5, n.f(TbadkCoreApplication.getInst(), e.tbds38));
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
                this.f40730f.setText(spannableStringBuilder);
                if (pbLinkData.urlType == 2) {
                    if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                        this.f40731g.setVisibility(8);
                    } else {
                        this.f40730f.setMaxLines(1);
                        this.f40731g.setText(String.format(TbadkCoreApplication.getInst().getString(j.commodity_price_prefix), pbLinkData.extTxt));
                        this.f40731g.setVisibility(0);
                    }
                } else {
                    this.f40731g.setVisibility(8);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.f40730f.setMaxLines(1);
                }
            } else if (cVar instanceof PbGoodsData) {
                PbGoodsData pbGoodsData = (PbGoodsData) cVar;
                this.f40729e.startLoad(pbGoodsData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                    int f8 = n.f(TbadkCoreApplication.getInst(), e.L_X01);
                    int f9 = n.f(TbadkCoreApplication.getInst(), e.tbds10);
                    int i3 = d.CAM_X0305;
                    int f10 = n.f(TbadkCoreApplication.getInst(), e.T_X10);
                    int f11 = n.f(TbadkCoreApplication.getInst(), e.M_W_X002);
                    int f12 = n.f(TbadkCoreApplication.getInst(), e.tbds2);
                    int f13 = n.f(TbadkCoreApplication.getInst(), e.M_W_X003);
                    b bVar2 = new b(f8, -1, i3, f10, i3, f11, n.f(TbadkCoreApplication.getInst(), e.tbds38));
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
                this.f40730f.setText(spannableStringBuilder2);
                if (TextUtils.isEmpty(pbGoodsData.price)) {
                    this.f40731g.setVisibility(8);
                } else {
                    this.f40730f.setMaxLines(1);
                    this.f40731g.setText(String.format(TbadkCoreApplication.getInst().getString(j.commodity_price_prefix), pbGoodsData.price));
                    this.f40731g.setVisibility(0);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                    this.f40730f.setMaxLines(1);
                }
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, f.bg_link_card);
            SkinManager.setViewTextColor(this.f40730f, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f40731g, d.CAM_X0305);
        }
    }

    public void setMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i2;
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
    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i2) {
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
        LayoutInflater.from(context).inflate(h.single_link_card_layout, this);
        TbImageView tbImageView = (TbImageView) findViewById(g.iv_single_link_icon);
        this.f40729e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f40729e.setDrawCorner(true);
        this.f40729e.setConrers(15);
        this.f40729e.setGifIconSupport(false);
        this.f40729e.setLongIconSupport(false);
        this.f40729e.setDrawBorder(true);
        this.f40729e.setBorderWidth(UtilHelper.getDimenPixelSize(e.tbds1));
        this.f40729e.setBorderColor(SkinManager.getColor(d.CAM_X0401));
        this.f40729e.setRadius(n.f(context, e.tbds10));
        this.f40729e.setPlaceHolder(2);
        this.f40730f = (TextView) findViewById(g.tv_single_link_text);
        this.f40731g = (TextView) findViewById(g.goods_price);
        onChangeSkinType();
    }
}
