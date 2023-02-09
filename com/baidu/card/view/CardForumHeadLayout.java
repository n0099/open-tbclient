package com.baidu.card.view;

import android.content.Context;
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
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.sz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BarImageView b;
    public SingleLineEllipsizeTextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public String j;
    public View.OnClickListener k;
    public int l;
    public ThreadData m;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardForumHeadLayout a;

        public a(CardForumHeadLayout cardForumHeadLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardForumHeadLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardForumHeadLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((RelativeLayout.LayoutParams) this.a.f.getLayoutParams()).width = (int) ((this.a.a.getWidth() * 0.75f) - this.a.b.getWidth());
                this.a.f.requestLayout();
            }
        }
    }

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
        d(context);
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
        d(context);
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
        d(context);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
            this.b = (BarImageView) findViewById(R.id.forum_head_image);
            this.c = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.d = (TextView) findViewById(R.id.forum_head_info_attention);
            this.e = (TextView) findViewById(R.id.forum_head_info_thread);
            this.f = (TextView) findViewById(R.id.forum_recommend_reason);
            post(new a(this));
            this.g = (TextView) findViewById(R.id.hot_rank_index);
            this.h = (TextView) findViewById(R.id.hot_rank_num);
            this.i = (TextView) findViewById(R.id.thread_extend_info);
            this.b.setShowOval(true);
            this.b.setAutoChangeStyle(true);
            this.b.setStrokeWith(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.c.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.c.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            f();
        }
    }

    public final void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && threadData.getForumData() != null && threadData.isFromHomPage) {
            String f = threadData.getForumData().f();
            if (!StringUtils.isNull(f)) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                this.f.setVisibility(0);
                this.f.setText(f);
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || StringUtils.isNull(this.j)) {
            return;
        }
        ThreadData threadData = this.m;
        if (threadData != null && threadData.isFromHomPage) {
            TbSingleton.getInstance().saveHomeRecommendItemClickTime();
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.j, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        createNormalCfg.getIntent().putExtra("transition_type", 0);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        View.OnClickListener onClickListener = this.k;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void f() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.l) {
            return;
        }
        this.l = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int g = ej.g(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, g, g);
        this.c.setCompoundDrawables(null, null, pureDrawable, null);
        this.c.setCompoundDrawablePadding(ej.g(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
        g();
        h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.c);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setOnClickListener(this);
        }
    }

    public final void h() {
        ThreadData threadData;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (threadData = this.m) != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(threadData.position + 1);
            this.g.setCompoundDrawablePadding(ej.g(getContext(), R.dimen.M_W_X002));
            int color = SkinManager.getColor(indexTextColorRes);
            ThreadData threadData2 = this.m;
            if (threadData2.isFromLowFlowsPage) {
                if ("agree_num".equals(threadData2.mTabCode)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
                } else if ("comment_num".equals(this.m.mTabCode)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
                } else if ("share_num".equals(this.m.mTabCode)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate();
                } else {
                    mutate = null;
                }
            } else {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            }
            int g = ej.g(getContext(), R.dimen.tbds42);
            if (mutate == null) {
                return;
            }
            mutate.setBounds(0, 0, g, g);
            DrawableCompat.setTint(mutate, color);
            this.g.setCompoundDrawables(mutate, null, null, null);
            this.g.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(this.g, indexTextColorRes);
            SkinManager.setViewTextColor(this.h, indexTextColorRes);
        }
    }

    public void setData(ThreadData threadData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            this.m = threadData;
            if (threadData != null && threadData.getForumData() != null) {
                if (threadData.isFromHotRankTab) {
                    this.e.setVisibility(8);
                    this.d.setVisibility(8);
                    this.g.setVisibility(8);
                    this.h.setVisibility(8);
                    this.i.setVisibility(0);
                    this.i.setText(threadData.getThreadExtendInfo());
                    int i = threadData.hotNum;
                    if (i < 1000) {
                        i = 1000;
                    }
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
                    TextView textView = this.h;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i2 = threadData.position + 1;
                    TextView textView2 = this.g;
                    if (i2 >= 10) {
                        str2 = String.valueOf(i2);
                    } else {
                        str2 = "0" + i2;
                    }
                    textView2.setText(str2);
                    h();
                    sz4 forumData = threadData.getForumData();
                    this.b.setPlaceHolder(1);
                    this.b.setVisibility(0);
                    this.b.K(forumData.a(), 10, false);
                    this.c.setVisibility(0);
                    this.j = forumData.b;
                    this.c.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.j));
                    HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.c);
                } else if (threadData.isFromLowFlowsPage) {
                    this.i.setVisibility(8);
                    if (!"agree_num".equals(threadData.mTabCode) && !"comment_num".equals(threadData.mTabCode) && !"share_num".equals(threadData.mTabCode)) {
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                    } else {
                        this.g.setVisibility(0);
                        this.h.setVisibility(0);
                        if ("agree_num".equals(threadData.mTabCode)) {
                            long j = 0;
                            if (threadData.getAgreeData() != null) {
                                j = threadData.getAgreeData().agreeNum;
                            }
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(j);
                            TextView textView3 = this.h;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getReply_num());
                            TextView textView4 = this.h;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(threadData.mTabCode)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(threadData.getShareNum());
                            TextView textView5 = this.h;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i3 = threadData.position + 1;
                        TextView textView6 = this.g;
                        if (i3 >= 10) {
                            str = String.valueOf(i3);
                        } else {
                            str = "0" + i3;
                        }
                        textView6.setText(str);
                        h();
                    }
                    setData(threadData.getForumData().b, threadData.getForumData().a(), threadData.getForumData().g, threadData.getForumData().h);
                } else {
                    if (threadData.isFromConcern()) {
                        this.e.setVisibility(8);
                        this.d.setVisibility(8);
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                        this.i.setVisibility(0);
                        this.i.setText(threadData.getThreadExtendInfo());
                    } else {
                        this.i.setVisibility(8);
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                        this.e.setVisibility(0);
                        this.d.setVisibility(0);
                    }
                    setData(threadData.getForumData().b, threadData.getForumData().a(), threadData.getForumData().g, threadData.getForumData().h);
                    if (threadData.showWeakenName()) {
                        if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                            this.d.setText(threadData.getAuthor().getName_show());
                        } else {
                            this.d.setText(R.string.user_name_default_txt);
                        }
                        this.e.setText(threadData.getThreadExtendInfo());
                    }
                }
                e(threadData);
                return;
            }
            i();
        }
    }

    public void setData(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048585, this, str, str2, i, i2) == null) {
            if (StringUtils.isNull(str)) {
                i();
                return;
            }
            this.b.setPlaceHolder(1);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.j = str;
            this.c.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.j));
            this.b.K(str2, 10, false);
            this.e.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i)));
            this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f044e), StringHelper.numberUniformFormatExtra(i2)));
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.c);
        }
    }
}
