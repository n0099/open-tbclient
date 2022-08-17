package com.baidu.card.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.er4;
import com.repackage.ms4;
import com.repackage.qi;
/* loaded from: classes.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;
    public SingleLineEllipsizeTextView b;
    public TextView c;
    public TextView d;
    public EMTextView e;
    public EMTextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public String j;
    public View.OnClickListener k;
    public int l;
    public ThreadData m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0181, (ViewGroup) this, true);
            this.a = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090a57);
            this.b = (SingleLineEllipsizeTextView) findViewById(R.id.obfuscated_res_0x7f090a56);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090a58);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a59);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090a55);
            this.f = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090a7b);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090dbd);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090dbe);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092137);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setStrokeWith(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.b.setEllipsisSuffix(getResources().getString(R.string.obfuscated_res_0x7f0f0542));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.b.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            d();
        }
    }

    public final void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null || threadData.getForumRecTip() == null || !threadData.isFromHomPage) {
            return;
        }
        String attentionStatus = threadData.getForumRecTip().getAttentionStatus();
        String recReason = threadData.getForumRecTip().getRecReason();
        if (UbsABTestHelper.isForumRecReasonAndStatusUbsABTestA() && !StringUtils.isNull(attentionStatus)) {
            this.f.setVisibility(8);
            this.e.setVisibility(0);
            this.e.setText(attentionStatus);
        } else if (UbsABTestHelper.isForumRecReasonAndStatusUbsABTestB() && !StringUtils.isNull(recReason)) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText(recReason);
        } else if (UbsABTestHelper.isForumRecReasonAndStatusUbsABTestC()) {
            if (!StringUtils.isNull(attentionStatus)) {
                this.e.setVisibility(0);
                this.e.setText(attentionStatus);
            } else {
                this.e.setVisibility(8);
            }
            if (!StringUtils.isNull(recReason)) {
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                this.f.setVisibility(0);
                this.f.setText(recReason);
            } else {
                this.f.setVisibility(8);
            }
        } else {
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ms4 d = ms4.d(this.e);
            d.n(R.string.J_X04);
            d.v(R.color.CAM_X0108);
            d.f(R.color.CAM_X0206);
            if (UbsABTestHelper.isfForumRecReasonColorTestA()) {
                if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
                    marginLayoutParams.topMargin = qi.f(getContext(), R.dimen.tbds8);
                    this.f.setLayoutParams(marginLayoutParams);
                }
                this.f.setPadding(0, 0, 0, 0);
                ms4 d2 = ms4.d(this.f);
                d2.v(R.color.CAM_X0316);
                d2.z(R.dimen.T_X09);
                d2.f(0);
                return;
            }
            if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
                marginLayoutParams2.topMargin = qi.f(getContext(), R.dimen.tbds14);
                this.f.setLayoutParams(marginLayoutParams2);
            }
            int f = qi.f(getContext(), R.dimen.M_W_X002);
            this.f.setPadding(f, 0, f, 0);
            ms4 d3 = ms4.d(this.f);
            d3.n(R.string.J_X04);
            d3.v(R.color.CAM_X0304);
            d3.z(R.dimen.T_X10);
            d3.f(R.color.CAM_X0905);
        }
    }

    public void d() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.l) {
            return;
        }
        this.l = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int f = qi.f(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, f, f);
        this.b.setCompoundDrawables(null, null, pureDrawable, null);
        this.b.setCompoundDrawablePadding(qi.f(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        c();
        e();
        f();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.b);
        }
    }

    public final void f() {
        ThreadData threadData;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (threadData = this.m) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(threadData.position + 1);
        this.g.setCompoundDrawablePadding(qi.f(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        ThreadData threadData2 = this.m;
        if (threadData2.isFromLowFlowsPage) {
            if ("agree_num".equals(threadData2.mTabCode)) {
                mutate = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0809df).mutate();
            } else if ("comment_num".equals(this.m.mTabCode)) {
                mutate = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0809de).mutate();
            } else {
                mutate = "share_num".equals(this.m.mTabCode) ? SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0809e0).mutate() : null;
            }
        } else {
            mutate = SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080a0d).mutate();
        }
        int f = qi.f(getContext(), R.dimen.tbds42);
        if (mutate == null) {
            return;
        }
        mutate.setBounds(0, 0, f, f);
        DrawableCompat.setTint(mutate, color);
        this.g.setCompoundDrawables(mutate, null, null, null);
        this.g.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.g, indexTextColorRes);
        SkinManager.setViewTextColor(this.h, indexTextColorRes);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || StringUtils.isNull(this.j)) {
            return;
        }
        ThreadData threadData = this.m;
        if (threadData != null && threadData.isFromHomPage) {
            TbSingleton.getInstance().saveHomeRecommendItemClickTime();
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.j, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        Intent intent = createNormalCfg.getIntent();
        if (UbsABTestHelper.isEnterFrsNoAnmi()) {
            intent.putExtra("transition_type", 0);
        } else {
            ThreadData threadData2 = this.m;
            if (threadData2 != null && threadData2.getForumData() != null && this.m.getForumData().h() != null) {
                Rect rect = new Rect();
                this.a.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.b.getGlobalVisibleRect(rect2);
                intent.putExtra("transition_type", 2);
                intent.putExtra("info_forum_image_rect", rect);
                intent.putExtra("info_forum_image_url", this.a.getUrl());
                intent.putExtra("info_forum_name_rect", rect2);
                intent.putExtra("info_forum_name_text", this.j);
                er4 forumData = this.m.getForumData();
                intent.putExtra("info_forum_head_background_color", forumData.g());
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (forumData.h().night != null && forumData.h().night.pattern_image != null) {
                        intent.putExtra("info_forum_head_background_vector", forumData.h().night.pattern_image);
                    }
                } else if (forumData.h().day != null && forumData.h().day.pattern_image != null) {
                    intent.putExtra("info_forum_head_background_vector", forumData.h().day.pattern_image);
                }
            } else {
                intent.putExtra("transition_type", 0);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        View.OnClickListener onClickListener = this.k;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setData(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, str, str2, i, i2) == null) {
            if (StringUtils.isNull(str)) {
                g();
                return;
            }
            this.a.setPlaceHolder(1);
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.j = str;
            this.b.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f03d2), this.j));
            this.a.K(str2, 10, false);
            this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f06c3), StringHelper.numberUniformFormatExtra(i)));
            this.c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0424), StringHelper.numberUniformFormatExtra(i2)));
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.b);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.setOnClickListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.l = 3;
        a(context);
    }

    public void setData(ThreadData threadData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            this.m = threadData;
            if (threadData != null && threadData.getForumData() != null) {
                if (threadData.isFromHotRankTab) {
                    this.d.setVisibility(8);
                    this.c.setVisibility(8);
                    if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                    } else {
                        this.g.setVisibility(0);
                        this.h.setVisibility(0);
                    }
                    this.i.setVisibility(0);
                    this.i.setText(threadData.getThreadExtendInfo());
                    int i = threadData.hotNum;
                    if (i < 1000) {
                        i = 1000;
                    }
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
                    TextView textView = this.h;
                    textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f13cf, numberUniformFormatExtraWithRoundInt));
                    int i2 = threadData.position + 1;
                    TextView textView2 = this.g;
                    if (i2 >= 10) {
                        str2 = String.valueOf(i2);
                    } else {
                        str2 = "0" + i2;
                    }
                    textView2.setText(str2);
                    f();
                    er4 forumData = threadData.getForumData();
                    this.a.setPlaceHolder(1);
                    this.a.setVisibility(0);
                    this.a.K(forumData.a(), 10, false);
                    this.b.setVisibility(0);
                    this.j = forumData.b;
                    this.b.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f03d2), this.j));
                    HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.b);
                } else if (threadData.isFromLowFlowsPage) {
                    this.i.setVisibility(8);
                    if (!"agree_num".equals(threadData.mTabCode) && !"comment_num".equals(threadData.mTabCode) && !"share_num".equals(threadData.mTabCode)) {
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                    } else {
                        this.g.setVisibility(0);
                        this.h.setVisibility(0);
                        if ("agree_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getAgreeData() != null ? threadData.getAgreeData().agreeNum : 0L);
                            TextView textView3 = this.h;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f13cd, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getReply_num());
                            TextView textView4 = this.h;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f13c7, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getShareNum());
                            TextView textView5 = this.h;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f13d2, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i3 = threadData.position + 1;
                        TextView textView6 = this.g;
                        if (i3 >= 10) {
                            str = String.valueOf(i3);
                        } else {
                            str = "0" + i3;
                        }
                        textView6.setText(str);
                        f();
                    }
                    setData(threadData.getForumData().b, threadData.getForumData().a(), threadData.getForumData().h, threadData.getForumData().i);
                } else {
                    if (threadData.isFromConcern()) {
                        this.d.setVisibility(8);
                        this.c.setVisibility(8);
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                        this.i.setVisibility(0);
                        this.i.setText(threadData.getThreadExtendInfo());
                    } else {
                        this.i.setVisibility(8);
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                        this.d.setVisibility(0);
                        this.c.setVisibility(0);
                    }
                    setData(threadData.getForumData().b, threadData.getForumData().a(), threadData.getForumData().h, threadData.getForumData().i);
                    if (threadData.showWeakenName()) {
                        if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                            this.c.setText(threadData.getAuthor().getName_show());
                        } else {
                            this.c.setText(R.string.obfuscated_res_0x7f0f14ee);
                        }
                        this.d.setText(threadData.getThreadExtendInfo());
                    }
                }
                b(threadData);
                return;
            }
            g();
        }
    }
}
