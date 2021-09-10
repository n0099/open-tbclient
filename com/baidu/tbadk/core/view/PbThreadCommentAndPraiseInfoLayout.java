package com.baidu.tbadk.core.view;

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
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.f;
import c.a.q0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public View.OnClickListener v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    public void doPraiseClick(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || this.mData == null || TextUtils.isEmpty(str) || !str.equals(this.mData.s1())) {
            return;
        }
        f fVar = new f();
        fVar.f14167b = 4;
        fVar.f14169d = 2;
        fVar.f14175j = str2;
        this.mAgreeView.setStatisticData(fVar);
        this.mAgreeView.onAgreeClick();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(8);
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setManageVisible(false);
            setInFrsAllThread(false);
            this.isCommentNumEnable = false;
            setNeedAddReplyIcon(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setShareVisible(true);
            setQQShareVisible(true);
        }
    }

    public boolean isIfPostForbid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (isVideoPb() && needJumpReplyFragment()) {
                return false;
            }
            return AntiHelper.j(this.mData);
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d2 d2Var = this.mData;
            return (d2Var == null || !d2Var.E2() || this.mData.q1() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoPbWorks() {
        InterceptResult invokeV;
        d2 d2Var;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? isVideoPb() && (d2Var = this.mData) != null && (worksInfoData = d2Var.L2) != null && worksInfoData.isWorks : invokeV.booleanValue;
    }

    public boolean needJumpReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d2 d2Var = this.mData;
            return (d2Var == null || d2Var.U0() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onChangeSkinType();
            if (isVideoPbWorks()) {
                WebPManager.setMaskDrawable(this.mShareImageView, R.drawable.icon_mask_bottom_share_new_wechat26, null);
                WebPManager.setMaskDrawable(this.mQQShareImageView, R.drawable.icon_mask_bottom_share_new_qq28, null);
            } else {
                WebPManager.setMaskDrawable(this.mShareImageView, R.drawable.icon_mask_bottom_share_wechat26, null);
                WebPManager.setMaskDrawable(this.mQQShareImageView, R.drawable.icon_mask_bottom_share_qq28, null);
            }
            WebPManager.setPureDrawable(this.mCommentImageView, R.drawable.icon_pure_pb_operate_commen, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.mCommentGrabSofa;
            if (eMTextView != null) {
                c d2 = c.d(eMTextView);
                d2.B(R.string.F_X02);
                d2.w(R.color.CAM_X0107);
                EMTextView eMTextView2 = this.mCommentGrabSofa;
                int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
                int i2 = R.color.CAM_X0207;
                SkinManager.setBackgroundShapeDrawable(eMTextView2, g2, i2, i2);
            }
            SkinManager.setViewTextColor(this.x, R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.y, R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.w, R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.z, R.drawable.selector_comment_and_prise_item_text_color);
            d2 d2Var = this.mData;
            if (d2Var != null) {
                MaskView.maskNovelViewGroup(this.B, d2Var.p2());
                MaskView.maskNovelViewGroup(this.A, this.mData.p2());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onCollectNumClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.v) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onCommentNumClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || (onClickListener = this.v) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onQQShareClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (onClickListener = this.v) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onShareNumClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || (onClickListener = this.v) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, d2Var) == null) {
            if (d2Var != null) {
                this.mAgreeView.setDisagreeShow(d2Var.D2());
            }
            if (d2Var != null && d2Var.F2()) {
                this.mAgreeView.setDisagreeShow(true);
            }
            if (d2Var != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mAgreeView.getLayoutParams();
                if (d2Var.F2()) {
                    layoutParams.weight = 0.2f;
                } else if (d2Var.D2()) {
                    layoutParams.weight = 0.25f;
                } else {
                    layoutParams.weight = 0.5f;
                }
                this.mAgreeView.setLayoutParams(layoutParams);
            }
        }
    }

    public boolean setData(d2 d2Var, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, d2Var, antiData)) == null) ? setData(d2Var) : invokeLL.booleanValue;
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setVisibility(0);
            v();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyNum(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d2Var) == null) {
            super.updateReplyNum(d2Var);
            if (d2Var == null || this.mCommentGrabSofa == null || !d2Var.F2()) {
                return;
            }
            if (d2Var.U0() == 0) {
                this.mCommentGrabSofa.setVisibility(0);
            } else {
                this.mCommentGrabSofa.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareNum(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, d2Var) == null) {
            super.updateShareNum(d2Var);
            View view = this.mShareContainer;
            if (view == null || this.mShareNum == null || d2Var == null) {
                return;
            }
            view.setVisibility(0);
            this.mShareNum.setVisibility(0);
            this.mShareNum.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, d2Var) == null) {
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            View findViewById = findViewById(R.id.thread_comment_layout_root);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int g2 = l.g(getContext(), R.dimen.tbds68);
            int g3 = l.g(getContext(), R.dimen.T_X09);
            int g4 = l.g(getContext(), R.dimen.tbds15);
            int g5 = l.g(getContext(), R.dimen.tbds10);
            this.B = (LinearLayout) findViewById(R.id.share_num_container);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = isVideoPbWorks() ? 0.2f : 0.25f;
            this.B.setLayoutParams(layoutParams2);
            this.B.setOrientation(1);
            ImageView imageView = (ImageView) findViewById(R.id.share_num_img);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.topMargin = g4;
            imageView.setLayoutParams(layoutParams3);
            imageView.setImageResource(R.drawable.icon_share_wechat_n);
            this.x = (TextView) findViewById(R.id.share_num);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = g5;
            this.x.setLayoutParams(layoutParams4);
            float f2 = g3;
            this.x.setTextSize(0, f2);
            this.x.setText(this.mContext.getString(R.string.share_weixin_friend_new));
            this.A = (LinearLayout) findViewById(R.id.qq_share_container);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
            layoutParams5.weight = isVideoPbWorks() ? 0.2f : 0.25f;
            this.A.setLayoutParams(layoutParams5);
            this.A.setOrientation(1);
            ImageView imageView2 = (ImageView) findViewById(R.id.qq_share_image);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams6.topMargin = g4;
            imageView2.setLayoutParams(layoutParams6);
            imageView2.setImageResource(R.drawable.icon_share_qq_n);
            this.y = (TextView) findViewById(R.id.qq_share_text);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = g5;
            this.y.setLayoutParams(layoutParams7);
            this.y.setTextSize(0, f2);
            this.y.setText(this.mContext.getString(R.string.share_qq_friends));
            if (isVideoPbWorks()) {
                this.isCommentNumEnable = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.thread_info_commont_container);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1);
                layoutParams8.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams8);
                linearLayout.setOrientation(1);
                ImageView imageView3 = (ImageView) findViewById(R.id.thread_info_commont_img);
                RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(g2, g2);
                layoutParams9.topMargin = l.g(getContext(), R.dimen.tbds25);
                layoutParams9.addRule(13, -1);
                imageView3.setLayoutParams(layoutParams9);
                WebPManager.setPureDrawable(imageView3, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.w = (TextView) findViewById(R.id.thread_info_commont_num);
                this.w.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.w.setTextSize(0, f2);
            } else {
                this.isCommentNumEnable = false;
                setNeedAddReplyIcon(false);
            }
            if (isVideoPbWorks()) {
                setCollectVisible(true);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.collect_num_container);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
                layoutParams10.weight = 0.2f;
                linearLayout2.setLayoutParams(layoutParams10);
                linearLayout2.setOrientation(1);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(g2, g2);
                layoutParams11.topMargin = g4;
                ((ImageView) findViewById(R.id.collect_num_image)).setLayoutParams(layoutParams11);
                this.z = (TextView) findViewById(R.id.collect_num_text);
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams12.topMargin = g5;
                this.z.setLayoutParams(layoutParams12);
                this.z.setTextSize(0, f2);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -1);
            layoutParams13.topMargin = l.g(getContext(), R.dimen.tbds18);
            layoutParams2.weight = isVideoPbWorks() ? 0.2f : 0.25f;
            agreeView.setLayoutParams(layoutParams13);
            agreeView.adjustLayoutForPbFirstFloor();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }
}
