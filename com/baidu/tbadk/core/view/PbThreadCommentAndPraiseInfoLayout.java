package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.o15;
import com.baidu.tieba.p75;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.wi;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AbilityConf;
/* loaded from: classes4.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A0;
    public String B0;
    public String C0;
    public TextView D0;
    public View.OnClickListener x0;
    public TextView y0;
    public TextView z0;

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbThreadCommentAndPraiseInfoLayout(Context context) {
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
        X();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void R(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            super.R(threadData);
            if (threadData != null && this.h != null && threadData.isVideoWorksInfo()) {
                if (threadData.getReply_num() == 0) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
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
        X();
    }

    public void W(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && this.F != null && !TextUtils.isEmpty(str) && str.equals(this.F.getTid())) {
            o15 o15Var = new o15();
            o15Var.b = 4;
            o15Var.d = 2;
            o15Var.j = str2;
            this.e.setStatisticData(o15Var);
            this.e.O();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void C(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onClickListener = this.x0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (onClickListener = this.x0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void H(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && (onClickListener = this.x0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (onClickListener = this.x0) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void b0(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public void setOnClickBotListener(FriendBotView.d dVar) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) && (agreeView = this.e) != null) {
            agreeView.setFriendBotClickCallBack(dVar);
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.x0 = onClickListener;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.B0 = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.C0 = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(0);
            V();
            onChangeSkinType();
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = this.F;
            if (threadData != null && (threadData.getCustomFigure() != null || this.F.getCallRobotEntrance() != null)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThreadData threadData = this.F;
            if (threadData != null && threadData.isVideoThreadType() && this.F.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        ThreadData threadData;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (Z() && (threadData = this.F) != null && (worksInfoData = threadData.worksInfoData) != null && worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setUseDynamicLikeRes() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeResForPbFirstFloor();
        }
    }

    public final void V() {
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View findViewById = findViewById(R.id.thread_comment_layout_root);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int g = wi.g(getContext(), R.dimen.tbds68);
            int g2 = wi.g(getContext(), R.dimen.T_X09);
            int g3 = wi.g(getContext(), R.dimen.tbds15);
            int g4 = wi.g(getContext(), R.dimen.M_W_X003);
            int g5 = wi.g(getContext(), R.dimen.tbds10);
            wi.g(getContext(), R.dimen.tbds32);
            wi.g(getContext(), R.dimen.tbds16);
            this.A0 = (LinearLayout) findViewById(R.id.share_more_container);
            int i = 0;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            if (Y()) {
                f = 0.25f;
            } else {
                f = 0.5f;
            }
            layoutParams2.weight = f;
            if (a0()) {
                layoutParams2.weight = 0.2f;
            }
            this.A0.setLayoutParams(layoutParams2);
            this.A0.setVisibility(0);
            this.A0.setOnClickListener(this.x0);
            ImageView imageView = (ImageView) findViewById(R.id.share_more_img);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g, g);
            imageView.setLayoutParams(layoutParams3);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            this.D0 = (TextView) findViewById(R.id.share_more_text);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                this.A0.setOrientation(0);
                layoutParams4.leftMargin = g4;
                layoutParams3.topMargin = wi.g(getContext(), R.dimen.tbds3);
            } else {
                this.A0.setOrientation(1);
                layoutParams4.topMargin = -wi.g(getContext(), R.dimen.tbds3);
                layoutParams3.topMargin = g3;
            }
            this.D0.setLayoutParams(layoutParams4);
            TextView textView = this.D0;
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                f2 = wi.g(getContext(), R.dimen.T_X07);
            } else {
                f2 = g2;
            }
            textView.setTextSize(0, f2);
            this.D0.setText(this.G.getString(R.string.obfuscated_res_0x7f0f1343));
            if (a0()) {
                this.M = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.thread_info_commont_container);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                layoutParams5.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams5);
                linearLayout.setOrientation(1);
                ImageView imageView2 = (ImageView) findViewById(R.id.thread_info_commont_img);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(g, g);
                layoutParams6.topMargin = wi.g(getContext(), R.dimen.tbds25);
                layoutParams6.addRule(13, -1);
                imageView2.setLayoutParams(layoutParams6);
                WebPManager.setPureDrawable(imageView2, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.y0 = (TextView) findViewById(R.id.thread_info_commont_num);
                this.y0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.y0.setTextSize(0, g2);
            } else {
                this.M = false;
                setNeedAddReplyIcon(false);
            }
            if (a0()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.collect_num_container);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
                layoutParams7.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams7);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(g, g);
                layoutParams8.topMargin = g3;
                ((ImageView) findViewById(R.id.collect_num_image)).setLayoutParams(layoutParams8);
                this.z0 = (TextView) findViewById(R.id.collect_num_text);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams9.topMargin = g5;
                this.z0.setLayoutParams(layoutParams9);
                this.z0.setTextSize(0, g2);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
            if (!UbsABTestHelper.isPbEnterForumStyle()) {
                i = wi.g(getContext(), R.dimen.tbds18);
            }
            layoutParams10.topMargin = i;
            if (Y()) {
                f3 = 0.25f;
            } else {
                f3 = 0.5f;
            }
            layoutParams10.weight = f3;
            agreeView.setLayoutParams(layoutParams10);
            agreeView.y();
            agreeView.setTopicId(this.B0);
            agreeView.setTopicSubjectName(this.C0);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.M = false;
            setNeedAddReplyIcon(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setShareVisible(true);
            setWeiXinShareGone(true);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                if (agreeView.getFriendBotView().getAshRunnable() != null) {
                    xg.a().removeCallbacks(this.e.getFriendBotView().getAshRunnable());
                }
                this.e.getFriendBotView().setRobotEntrance(null);
            }
        }
    }

    public boolean c0(ThreadData threadData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, threadData, antiData)) == null) {
            return setData(threadData);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onChangeSkinType();
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_pb_operate_commen, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.h;
            if (eMTextView != null) {
                p75 d = p75.d(eMTextView);
                d.D(R.string.F_X02);
                d.x(R.color.CAM_X0107);
                SkinManager.setBackgroundShapeDrawable(this.h, wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            }
            SkinManager.setViewTextColor(this.y0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.z0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.D0, (int) R.color.CAM_X0107);
            ThreadData threadData = this.F;
            if (threadData != null) {
                MaskView.c(this.A0, threadData.isNovelThread());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) {
            if (threadData != null) {
                this.e.setDisagreeShow(threadData.isUgcThreadType());
            }
            if (threadData != null && threadData.isVideoWorksInfo()) {
                this.e.setDisagreeShow(true);
            }
            if (threadData != null && threadData.getCallRobotEntrance() != null && threadData.getCallRobotEntrance().style_conf != null && !TextUtils.isEmpty(threadData.getCallRobotEntrance().style_conf.day.icon) && !TextUtils.isEmpty(threadData.getCallRobotEntrance().style_conf.dark.icon)) {
                this.e.b0(threadData);
                AbilityConf abilityConf = threadData.getCallRobotEntrance().ability_conf;
                String str2 = "";
                if (abilityConf == null) {
                    str = "";
                } else {
                    str = abilityConf.bot_uk;
                }
                boolean j = this.e.getFriendBotView().j();
                if (this.e.getData() != null) {
                    str2 = this.e.getData().forumId;
                }
                CommonStatisticUtils.statisticFriendBotView(1, str, 1, j, str2);
            } else if (threadData != null && threadData.getCustomFigure() != null) {
                this.e.a0(threadData.getCustomFigure(), threadData.getAuthor());
            } else {
                this.e.setDisagreeShow(true);
            }
            if (threadData != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
                if (threadData.isVideoWorksInfo()) {
                    layoutParams.weight = 0.2f;
                } else if (threadData.isUgcThreadType()) {
                    layoutParams.weight = 0.25f;
                } else {
                    layoutParams.weight = 0.5f;
                }
                this.e.setLayoutParams(layoutParams);
            }
        }
    }
}
