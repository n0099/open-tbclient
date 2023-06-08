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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.n15;
import com.baidu.tieba.o75;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A0;
    public View.OnClickListener v0;
    public TextView w0;
    public TextView x0;
    public LinearLayout y0;
    public String z0;

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, threadData) == null) {
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
        U();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void O(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            super.O(threadData);
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
        U();
    }

    public void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && this.E != null && !TextUtils.isEmpty(str) && str.equals(this.E.getTid())) {
            n15 n15Var = new n15();
            n15Var.b = 4;
            n15Var.d = 2;
            n15Var.j = str2;
            this.e.setStatisticData(n15Var);
            this.e.N();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onClickListener = this.v0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void E(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (onClickListener = this.v0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void G(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && (onClickListener = this.v0) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void Y(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.v0 = onClickListener;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.z0 = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.A0 = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view2) == null) && (onClickListener = this.v0) != null) {
            onClickListener.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
            S();
            onChangeSkinType();
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = this.E;
            if (threadData != null && threadData.getCustomFigure() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = this.E;
            if (threadData != null && threadData.isVideoThreadType() && this.E.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        ThreadData threadData;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (W() && (threadData = this.E) != null && (worksInfoData = threadData.worksInfoData) != null && worksInfoData.isWorks) {
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
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeResForPbFirstFloor();
        }
    }

    public final void S() {
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View findViewById = findViewById(R.id.thread_comment_layout_root);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int g = vi.g(getContext(), R.dimen.tbds68);
            int g2 = vi.g(getContext(), R.dimen.T_X09);
            int g3 = vi.g(getContext(), R.dimen.tbds15);
            int g4 = vi.g(getContext(), R.dimen.M_W_X003);
            int g5 = vi.g(getContext(), R.dimen.tbds10);
            vi.g(getContext(), R.dimen.tbds32);
            vi.g(getContext(), R.dimen.tbds16);
            this.y0 = (LinearLayout) findViewById(R.id.share_more_container);
            int i = 0;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            if (V()) {
                f = 0.25f;
            } else {
                f = 0.5f;
            }
            layoutParams2.weight = f;
            if (X()) {
                layoutParams2.weight = 0.2f;
            }
            this.y0.setLayoutParams(layoutParams2);
            this.y0.setVisibility(0);
            this.y0.setOnClickListener(this.v0);
            ImageView imageView = (ImageView) findViewById(R.id.share_more_img);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g, g);
            imageView.setLayoutParams(layoutParams3);
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            TextView textView = (TextView) findViewById(R.id.share_more_text);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                this.y0.setOrientation(0);
                layoutParams4.leftMargin = g4;
                layoutParams3.topMargin = vi.g(getContext(), R.dimen.tbds3);
            } else {
                this.y0.setOrientation(1);
                layoutParams4.topMargin = -vi.g(getContext(), R.dimen.tbds3);
                layoutParams3.topMargin = g3;
            }
            textView.setLayoutParams(layoutParams4);
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                f2 = vi.g(getContext(), R.dimen.T_X07);
            } else {
                f2 = g2;
            }
            textView.setTextSize(0, f2);
            textView.setText(this.F.getString(R.string.obfuscated_res_0x7f0f133f));
            if (X()) {
                this.L = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.thread_info_commont_container);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                layoutParams5.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams5);
                linearLayout.setOrientation(1);
                ImageView imageView2 = (ImageView) findViewById(R.id.thread_info_commont_img);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(g, g);
                layoutParams6.topMargin = vi.g(getContext(), R.dimen.tbds25);
                layoutParams6.addRule(13, -1);
                imageView2.setLayoutParams(layoutParams6);
                WebPManager.setPureDrawable(imageView2, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.w0 = (TextView) findViewById(R.id.thread_info_commont_num);
                this.w0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.w0.setTextSize(0, g2);
            } else {
                this.L = false;
                setNeedAddReplyIcon(false);
            }
            if (X()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.collect_num_container);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
                layoutParams7.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams7);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(g, g);
                layoutParams8.topMargin = g3;
                ((ImageView) findViewById(R.id.collect_num_image)).setLayoutParams(layoutParams8);
                this.x0 = (TextView) findViewById(R.id.collect_num_text);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams9.topMargin = g5;
                this.x0.setLayoutParams(layoutParams9);
                this.x0.setTextSize(0, g2);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
            if (!UbsABTestHelper.isPbEnterForumStyle()) {
                i = vi.g(getContext(), R.dimen.tbds18);
            }
            layoutParams10.topMargin = i;
            if (V()) {
                f3 = 0.25f;
            } else {
                f3 = 0.5f;
            }
            layoutParams10.weight = f3;
            agreeView.setLayoutParams(layoutParams10);
            agreeView.x();
            agreeView.setTopicId(this.z0);
            agreeView.setTopicSubjectName(this.A0);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.L = false;
            setNeedAddReplyIcon(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setShareVisible(true);
            setWeiXinShareGone(true);
        }
    }

    public boolean Z(ThreadData threadData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, threadData, antiData)) == null) {
            return setData(threadData);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onChangeSkinType();
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_pb_operate_commen, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.h;
            if (eMTextView != null) {
                o75 d = o75.d(eMTextView);
                d.C(R.string.F_X02);
                d.w(R.color.CAM_X0107);
                SkinManager.setBackgroundShapeDrawable(this.h, vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            }
            SkinManager.setViewTextColor(this.w0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.x0, (int) R.drawable.selector_comment_and_prise_item_text_color);
            ThreadData threadData = this.E;
            if (threadData != null) {
                MaskView.c(this.y0, threadData.isNovelThread());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) {
            if (threadData != null) {
                this.e.setDisagreeShow(threadData.isUgcThreadType());
            }
            if (threadData != null && threadData.isVideoWorksInfo()) {
                this.e.setDisagreeShow(true);
            }
            if (threadData != null && threadData.getCustomFigure() != null) {
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
