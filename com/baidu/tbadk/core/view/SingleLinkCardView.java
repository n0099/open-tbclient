package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.o0.s.f0.b;
import c.a.p0.a0.d0.c;
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
/* loaded from: classes6.dex */
public class SingleLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f47563e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47564f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47565g;

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
                this.f47563e.startLoad(pbLinkData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                    int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int i2 = R.color.CAM_X0305;
                    int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    b bVar = new b(g2, -1, i2, g4, i2, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    bVar.b(g3);
                    bVar.h(g6);
                    bVar.i(g7);
                    spannableStringBuilder.setSpan(bVar, 0, pbLinkData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
                } else {
                    spannableStringBuilder.append((CharSequence) pbLinkData.title);
                }
                this.f47564f.setText(spannableStringBuilder);
                if (pbLinkData.urlType == 2) {
                    if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                        this.f47565g.setVisibility(8);
                    } else {
                        this.f47564f.setMaxLines(1);
                        this.f47565g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbLinkData.extTxt));
                        this.f47565g.setVisibility(0);
                    }
                } else {
                    this.f47565g.setVisibility(8);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.f47564f.setMaxLines(1);
                }
            } else if (cVar instanceof PbGoodsData) {
                PbGoodsData pbGoodsData = (PbGoodsData) cVar;
                this.f47563e.startLoad(pbGoodsData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                    int g8 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int g9 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int i3 = R.color.CAM_X0305;
                    int g10 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int g11 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int g12 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int g13 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    b bVar2 = new b(g8, -1, i3, g10, i3, g11, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    bVar2.b(g9);
                    bVar2.h(g12);
                    bVar2.i(g13);
                    spannableStringBuilder2.setSpan(bVar2, 0, pbGoodsData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkUrl);
                } else {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.title);
                }
                this.f47564f.setText(spannableStringBuilder2);
                if (TextUtils.isEmpty(pbGoodsData.price)) {
                    this.f47565g.setVisibility(8);
                } else {
                    this.f47564f.setMaxLines(1);
                    this.f47565g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbGoodsData.price));
                    this.f47565g.setVisibility(0);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                    this.f47564f.setMaxLines(1);
                }
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.f47564f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f47565g, R.color.CAM_X0305);
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
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.f47563e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f47563e.setDrawCorner(true);
        this.f47563e.setConrers(15);
        this.f47563e.setGifIconSupport(false);
        this.f47563e.setLongIconSupport(false);
        this.f47563e.setDrawBorder(true);
        this.f47563e.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.f47563e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f47563e.setRadius(l.g(context, R.dimen.tbds10));
        this.f47563e.setPlaceHolder(2);
        this.f47564f = (TextView) findViewById(R.id.tv_single_link_text);
        this.f47565g = (TextView) findViewById(R.id.goods_price);
        onChangeSkinType();
    }
}
