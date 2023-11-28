package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GroupChatEntranceStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonGroupChatCard.TbGroupChatCardLinkLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.g55;
import com.baidu.tieba.rd;
import com.baidu.tieba.rm6;
import com.baidu.tieba.zr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SingleLinkCardView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;
    public View d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public ImageView h;
    public rm6 i;
    public View.OnClickListener j;

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

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 6).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
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
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.a = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.a.setDrawCorner(true);
        this.a.setConrers(15);
        this.a.setGifIconSupport(false);
        this.a.setLongIconSupport(false);
        this.a.setDrawBorder(true);
        this.a.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.a.setRadius(BdUtilHelper.getDimens(context, R.dimen.tbds10));
        this.a.setPlaceHolder(2);
        this.b = (TextView) findViewById(R.id.tv_single_link_text);
        this.c = (TextView) findViewById(R.id.goods_price);
        this.d = findViewById(R.id.extra_info_container);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090808);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09080b);
        this.g = (ImageView) findViewById(R.id.content1_icon);
        this.h = (ImageView) findViewById(R.id.content2_icon);
        d();
    }

    public void a(rm6 rm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rm6Var) == null) {
            this.i = rm6Var;
            this.a.setPlaceHolder(2);
            this.a.setUseNightOrDarkMask(false);
            if (rm6Var instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) rm6Var;
                this.a.setPlaceHolder(2);
                this.a.startLoad(pbLinkData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int dimens5 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int dimens6 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    g55 g55Var = new g55(dimens, -1, (int) R.color.CAM_X0305, dimens3, (int) R.color.CAM_X0305, dimens4, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    g55Var.b(dimens2);
                    g55Var.h(dimens5);
                    g55Var.i(dimens6);
                    spannableStringBuilder.setSpan(g55Var, 0, pbLinkData.linkFrom.length(), 17);
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                    spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
                } else {
                    spannableStringBuilder.append((CharSequence) pbLinkData.title);
                }
                this.b.setText(spannableStringBuilder);
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                int i = pbLinkData.urlType;
                if (i == 2) {
                    if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                        this.c.setVisibility(8);
                    } else {
                        this.b.setMaxLines(1);
                        this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbLinkData.extTxt));
                        this.c.setVisibility(0);
                    }
                } else if (i == 5) {
                    this.a.setDefaultBgResource(R.drawable.icon_pure_group_chat_card_link_default);
                    this.a.setUseNightOrDarkMask(true);
                    if (TextUtils.isEmpty(pbLinkData.content1) && TextUtils.isEmpty(pbLinkData.content2)) {
                        this.d.setVisibility(8);
                    } else {
                        this.d.setVisibility(0);
                        if (TextUtils.isEmpty(pbLinkData.content1)) {
                            this.e.setVisibility(8);
                            this.g.setVisibility(8);
                        } else {
                            this.e.setVisibility(0);
                            this.g.setVisibility(0);
                            this.e.setText(pbLinkData.content1);
                        }
                        if (TextUtils.isEmpty(pbLinkData.content2)) {
                            this.f.setVisibility(8);
                            this.h.setVisibility(8);
                        } else {
                            this.f.setVisibility(0);
                            this.h.setVisibility(0);
                            this.f.setText(pbLinkData.content2);
                        }
                        TbGroupChatCardLinkLayout.e(this.e, this.g, this.f, pbLinkData.content1, pbLinkData.content2);
                    }
                }
                if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.b.setMaxLines(1);
                }
            } else if (rm6Var instanceof PbGoodsData) {
                PbGoodsData pbGoodsData = (PbGoodsData) rm6Var;
                this.a.startLoad(pbGoodsData.picUrl, 10, false);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                    spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                    int dimens7 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int dimens8 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int dimens9 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int dimens10 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int dimens11 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int dimens12 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    g55 g55Var2 = new g55(dimens7, -1, (int) R.color.CAM_X0305, dimens9, (int) R.color.CAM_X0305, dimens10, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    g55Var2.b(dimens8);
                    g55Var2.h(dimens11);
                    g55Var2.i(dimens12);
                    spannableStringBuilder2.setSpan(g55Var2, 0, pbGoodsData.linkFrom.length(), 17);
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
                    this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbGoodsData.price));
                    this.c.setVisibility(0);
                }
                if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                    this.b.setMaxLines(1);
                }
            }
            c(rm6Var);
        }
    }

    public final void c(@Nullable rm6 rm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rm6Var) == null) {
            View.OnClickListener onClickListener = this.j;
            if (onClickListener != null) {
                setOnClickListener(onClickListener);
            } else if ((rm6Var instanceof PbLinkData) && ((PbLinkData) rm6Var).urlType == 5) {
                setOnClickListener(this);
            } else {
                setClickable(false);
            }
        }
    }

    public void setItemOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.j = onClickListener;
            setOnClickListener(onClickListener);
        }
    }

    public void setMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
            requestLayout();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0305);
            EMManager.from(this.e).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.f).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_group_chat_bar_icon, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.h, R.drawable.icon_group_chat_icon, R.color.CAM_X0109, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (this.i instanceof PbLinkData) && (getContext() instanceof TbPageContextSupport)) {
            PbLinkData pbLinkData = (PbLinkData) this.i;
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) getContext();
            if (pbLinkData.urlType == 5) {
                b(pbLinkData.linkUrl);
            }
            int i = pbLinkData.urlType;
            if (i != 1 && i != 5) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{zr4.a + rd.getUrlEncode(pbLinkData.linkUrl)});
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
        }
    }
}
