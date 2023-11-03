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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.hw4;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
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
    public String A0;
    public String B0;
    public TextView C0;
    public View.OnClickListener w0;
    public TextView x0;
    public TextView y0;
    public LinearLayout z0;

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
        W();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            super.Q(threadData);
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
        W();
    }

    public void V(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && this.C != null && !TextUtils.isEmpty(str) && str.equals(this.C.getTid())) {
            hw4 hw4Var = new hw4();
            hw4Var.b = 4;
            hw4Var.d = 2;
            hw4Var.j = str2;
            this.e.setStatisticData(hw4Var);
            this.e.N();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void C(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onClickListener = this.w0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (onClickListener = this.w0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void H(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && (onClickListener = this.w0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (onClickListener = this.w0) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void a0(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public void setOnClickBotListener(FriendBotView.f fVar) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) && (agreeView = this.e) != null) {
            agreeView.setFriendBotClickCallBack(fVar);
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.w0 = onClickListener;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.A0 = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.B0 = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(0);
            U();
            onChangeSkinType();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = this.C;
            if (threadData != null && (threadData.getCustomFigure() != null || this.C.getCallRobotEntrance() != null)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThreadData threadData = this.C;
            if (threadData != null && threadData.isVideoThreadType() && this.C.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        ThreadData threadData;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (Y() && (threadData = this.C) != null && (worksInfoData = threadData.worksInfoData) != null && worksInfoData.isWorks) {
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

    public final void U() {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View findViewById = findViewById(R.id.thread_comment_layout_root);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds68);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.T_X09);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds15);
            BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X003);
            int dimens4 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds10);
            BdUtilHelper.getDimens(getContext(), R.dimen.tbds32);
            BdUtilHelper.getDimens(getContext(), R.dimen.tbds16);
            this.z0 = (LinearLayout) findViewById(R.id.share_more_container);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            if (X()) {
                f = 0.25f;
            } else {
                f = 0.5f;
            }
            layoutParams2.weight = f;
            if (Z()) {
                layoutParams2.weight = 0.2f;
            }
            this.z0.setLayoutParams(layoutParams2);
            this.z0.setVisibility(0);
            this.z0.setOnClickListener(this.w0);
            ImageView imageView = (ImageView) findViewById(R.id.share_more_img);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
            imageView.setLayoutParams(layoutParams3);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            this.C0 = (TextView) findViewById(R.id.share_more_text);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            this.z0.setOrientation(1);
            layoutParams4.topMargin = -BdUtilHelper.getDimens(getContext(), R.dimen.tbds3);
            layoutParams3.topMargin = dimens3;
            this.C0.setLayoutParams(layoutParams4);
            float f3 = dimens2;
            this.C0.setTextSize(0, f3);
            this.C0.setText(this.D.getString(R.string.obfuscated_res_0x7f0f13c7));
            if (Z()) {
                this.J = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.thread_info_commont_container);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                layoutParams5.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams5);
                linearLayout.setOrientation(1);
                ImageView imageView2 = (ImageView) findViewById(R.id.thread_info_commont_img);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(dimens, dimens);
                layoutParams6.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds25);
                layoutParams6.addRule(13, -1);
                imageView2.setLayoutParams(layoutParams6);
                WebPManager.setPureDrawable(imageView2, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.x0 = (TextView) findViewById(R.id.thread_info_commont_num);
                this.x0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.x0.setTextSize(0, f3);
            } else {
                this.J = false;
                setNeedAddReplyIcon(false);
            }
            if (Z()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.collect_num_container);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
                layoutParams7.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams7);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(dimens, dimens);
                layoutParams8.topMargin = dimens3;
                ((ImageView) findViewById(R.id.collect_num_image)).setLayoutParams(layoutParams8);
                this.y0 = (TextView) findViewById(R.id.collect_num_text);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams9.topMargin = dimens4;
                this.y0.setLayoutParams(layoutParams9);
                this.y0.setTextSize(0, f3);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
            layoutParams10.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds18);
            if (X()) {
                f2 = 0.25f;
            } else {
                f2 = 0.5f;
            }
            layoutParams10.weight = f2;
            agreeView.setLayoutParams(layoutParams10);
            agreeView.y();
            agreeView.setTopicId(this.A0);
            agreeView.setTopicSubjectName(this.B0);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.J = false;
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
                    SafeHandler.getInst().removeCallbacks(this.e.getFriendBotView().getAshRunnable());
                }
                this.e.getFriendBotView().setRobotEntrance(null);
            }
        }
    }

    public boolean b0(ThreadData threadData, AntiData antiData) {
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
                EMManager.from(eMTextView).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0107);
                SkinManager.setBackgroundShapeDrawable(this.h, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            }
            SkinManager.setViewTextColor(this.x0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.y0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.C0, (int) R.color.CAM_X0107);
            ThreadData threadData = this.C;
            if (threadData != null) {
                MaskView.e(this.z0, threadData.isDisableShare(), this.C.getDisableShareToast());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(ThreadData threadData) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) {
            if (threadData != null) {
                this.e.setDisagreeShow(threadData.isUgcThreadType());
            }
            if (threadData != null && threadData.isVideoWorksInfo()) {
                this.e.setDisagreeShow(true);
            }
            if (threadData != null && threadData.getCallRobotEntrance() != null && threadData.getCallRobotEntrance().style_conf != null && !TextUtils.isEmpty(threadData.getCallRobotEntrance().style_conf.day.icon) && !TextUtils.isEmpty(threadData.getCallRobotEntrance().style_conf.dark.icon)) {
                this.e.a0(threadData);
                AbilityConf abilityConf = threadData.getCallRobotEntrance().ability_conf;
                String str3 = "";
                if (abilityConf == null) {
                    str = "";
                } else {
                    str = abilityConf.bot_uk;
                }
                boolean o = this.e.getFriendBotView().o();
                if (this.e.getData() == null) {
                    str2 = "";
                } else {
                    str2 = this.e.getData().forumId;
                }
                if (this.e.getData() != null) {
                    str3 = this.e.getData().threadId;
                }
                CommonStatisticUtils.statisticFriendBotView(1, str, 1, o, str2, str3);
            } else if (threadData != null && threadData.getCustomFigure() != null) {
                this.e.Z(threadData.getCustomFigure(), threadData.getAuthor());
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
