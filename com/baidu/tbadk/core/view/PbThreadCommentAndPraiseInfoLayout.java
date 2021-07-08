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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.f;
import d.a.o0.r.u.c;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener p0;
    public TextView q0;
    public TextView r0;
    public TextView s0;
    public TextView t0;

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
        R();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
            P();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void L(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            super.L(b2Var);
            if (b2Var == null || this.k == null || !b2Var.r2()) {
                return;
            }
            if (b2Var.P0() == 0) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void O(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            super.O(b2Var);
            View view = this.o;
            if (view == null || this.m == null || b2Var == null) {
                return;
            }
            view.setVisibility(0);
            this.m.setVisibility(0);
            this.m.setText(this.F.getString(R.string.share_weixin_friend_new));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View findViewById = findViewById(R.id.thread_comment_layout_root);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            int g2 = l.g(getContext(), R.dimen.tbds68);
            int g3 = l.g(getContext(), R.dimen.T_X09);
            int g4 = l.g(getContext(), R.dimen.tbds15);
            int g5 = l.g(getContext(), R.dimen.tbds10);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.share_num_container);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = T() ? 0.2f : 0.25f;
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(1);
            ImageView imageView = (ImageView) findViewById(R.id.share_num_img);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.topMargin = g4;
            imageView.setLayoutParams(layoutParams3);
            imageView.setImageResource(R.drawable.icon_share_wechat_n);
            this.r0 = (TextView) findViewById(R.id.share_num);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = g5;
            this.r0.setLayoutParams(layoutParams4);
            float f2 = g3;
            this.r0.setTextSize(0, f2);
            this.r0.setText(this.F.getString(R.string.share_weixin_friend_new));
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.qq_share_container);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
            layoutParams5.weight = T() ? 0.2f : 0.25f;
            linearLayout2.setLayoutParams(layoutParams5);
            linearLayout2.setOrientation(1);
            ImageView imageView2 = (ImageView) findViewById(R.id.qq_share_image);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams6.topMargin = g4;
            imageView2.setLayoutParams(layoutParams6);
            imageView2.setImageResource(R.drawable.icon_share_qq_n);
            this.s0 = (TextView) findViewById(R.id.qq_share_text);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = g5;
            this.s0.setLayoutParams(layoutParams7);
            this.s0.setTextSize(0, f2);
            this.s0.setText(this.F.getString(R.string.share_qq_friends));
            if (T()) {
                this.L = true;
                setNeedAddReplyIcon(true);
                LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.thread_info_commont_container);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1);
                layoutParams8.weight = 0.2f;
                linearLayout3.setLayoutParams(layoutParams8);
                linearLayout3.setOrientation(1);
                ImageView imageView3 = (ImageView) findViewById(R.id.thread_info_commont_img);
                RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(g2, g2);
                layoutParams9.topMargin = l.g(getContext(), R.dimen.tbds25);
                layoutParams9.addRule(13, -1);
                imageView3.setLayoutParams(layoutParams9);
                WebPManager.setPureDrawable(imageView3, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                this.q0 = (TextView) findViewById(R.id.thread_info_commont_num);
                this.q0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.q0.setTextSize(0, f2);
            } else {
                this.L = false;
                setNeedAddReplyIcon(false);
            }
            if (T()) {
                setCollectVisible(true);
                LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.collect_num_container);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
                layoutParams10.weight = 0.2f;
                linearLayout4.setLayoutParams(layoutParams10);
                linearLayout4.setOrientation(1);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(g2, g2);
                layoutParams11.topMargin = g4;
                ((ImageView) findViewById(R.id.collect_num_image)).setLayoutParams(layoutParams11);
                this.t0 = (TextView) findViewById(R.id.collect_num_text);
                LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams12.topMargin = g5;
                this.t0.setLayoutParams(layoutParams12);
                this.t0.setTextSize(0, f2);
            } else {
                setCollectVisible(false);
            }
            AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -1);
            layoutParams13.topMargin = l.g(getContext(), R.dimen.tbds18);
            layoutParams2.weight = T() ? 0.2f : 0.25f;
            agreeView.setLayoutParams(layoutParams13);
            agreeView.g();
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.E == null || TextUtils.isEmpty(str) || !str.equals(this.E.n1())) {
            return;
        }
        f fVar = new f();
        fVar.f52647b = 4;
        fVar.f52649d = 2;
        this.f12554h.setStatisticData(fVar);
        this.f12554h.t();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
            setQQShareVisible(true);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b2 b2Var = this.E;
            return (b2Var == null || !b2Var.q2() || this.E.l1() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        b2 b2Var;
        WorksInfoData worksInfoData;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? S() && (b2Var = this.E) != null && (worksInfoData = b2Var.I2) != null && worksInfoData.isWorks : invokeV.booleanValue;
    }

    public boolean U(b2 b2Var, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, b2Var, antiData)) == null) ? setData(b2Var) : invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onChangeSkinType();
            if (T()) {
                WebPManager.setMaskDrawable(this.n, R.drawable.icon_mask_bottom_share_new_wechat26, null);
                WebPManager.setMaskDrawable(this.w, R.drawable.icon_mask_bottom_share_new_qq28, null);
            } else {
                WebPManager.setMaskDrawable(this.n, R.drawable.icon_mask_bottom_share_wechat26, null);
                WebPManager.setMaskDrawable(this.w, R.drawable.icon_mask_bottom_share_qq28, null);
            }
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_pb_operate_commen, R.color.CAM_X0107, null);
            EMTextView eMTextView = this.k;
            if (eMTextView != null) {
                c d2 = c.d(eMTextView);
                d2.y(R.string.F_X02);
                d2.t(R.color.CAM_X0107);
                EMTextView eMTextView2 = this.k;
                int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
                int i2 = R.color.CAM_X0207;
                SkinManager.setBackgroundShapeDrawable(eMTextView2, g2, i2, i2);
            }
            SkinManager.setViewTextColor(this.r0, R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.s0, R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.q0, R.drawable.selector_comment_and_prise_item_text_color);
            SkinManager.setViewTextColor(this.t0, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b2Var) == null) {
            if (b2Var != null) {
                this.f12554h.setDisagreeShow(b2Var.p2());
            }
            if (b2Var != null && b2Var.r2()) {
                this.f12554h.setDisagreeShow(true);
            }
            if (b2Var != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12554h.getLayoutParams();
                if (b2Var.r2()) {
                    layoutParams.weight = 0.2f;
                } else if (b2Var.p2()) {
                    layoutParams.weight = 0.25f;
                } else {
                    layoutParams.weight = 0.5f;
                }
                this.f12554h.setLayoutParams(layoutParams);
            }
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.p0 = onClickListener;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void u(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, b2Var) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void y(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (onClickListener = this.p0) == null) {
            return;
        }
        onClickListener.onClick(view);
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
        R();
    }
}
