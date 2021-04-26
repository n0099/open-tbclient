package com.baidu.ala.view.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AlaPlayAnimationView;
import d.a.i0.r.q.a2;
import d.a.i0.z0.i0;
/* loaded from: classes.dex */
public class AlaCardBottomUserInfoLayout extends LinearLayout {
    public static final int MAX_USERNAME_LENGTH = 10;
    public HeadImageView alaCardUserHeadImg;
    public TextView alaCardUserName;
    public AlaPlayAnimationView alaPlayAnim;
    public TextView alaWatchCount;

    public AlaCardBottomUserInfoLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ala_card_bottom_user_info_layout, (ViewGroup) this, true);
        this.alaCardUserHeadImg = (HeadImageView) inflate.findViewById(R.id.ala_card_user_head_img);
        this.alaCardUserName = (TextView) inflate.findViewById(R.id.ala_card_user_name);
        this.alaPlayAnim = (AlaPlayAnimationView) inflate.findViewById(R.id.ala_play_anim);
        this.alaWatchCount = (TextView) inflate.findViewById(R.id.ala_watch_count);
        initHeaderImg();
    }

    private void initHeaderImg() {
        HeadImageView headImageView = this.alaCardUserHeadImg;
        if (headImageView == null) {
            return;
        }
        headImageView.setDefaultResource(17170445);
        this.alaCardUserHeadImg.setDefaultBgResource(R.color.CAM_X0205);
        this.alaCardUserHeadImg.setIsRound(true);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        SkinManager.setViewTextColor(this.alaCardUserName, R.color.CAM_X0101, TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.alaWatchCount, R.color.CAM_X0101, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(a2 a2Var) {
        String str;
        if (a2Var == null || a2Var.q1() == null) {
            return;
        }
        AlaUserInfoData alaUserInfoData = a2Var.q1().user_info;
        if (a2Var.T() != null) {
            str = a2Var.T().getName_show();
        } else {
            str = alaUserInfoData != null ? alaUserInfoData.user_name : "";
        }
        if (i0.d(str) > 10) {
            str = i0.m(str, 10) + StringHelper.STRING_MORE;
        }
        if (alaUserInfoData != null) {
            this.alaCardUserHeadImg.V(alaUserInfoData.portrait, 28, false);
        }
        this.alaCardUserName.setText(str);
        this.alaWatchCount.setText(String.format(getContext().getResources().getString(R.string.ala_card_watch_num_text), StringHelper.numFormatOverWan(a2Var.q1().audience_count)));
    }

    public void setUserHeadImgVisible(int i2) {
        HeadImageView headImageView = this.alaCardUserHeadImg;
        if (headImageView != null) {
            headImageView.setVisibility(i2);
        }
    }

    public void startPlayAnimation() {
        AlaPlayAnimationView alaPlayAnimationView = this.alaPlayAnim;
        if (alaPlayAnimationView != null) {
            alaPlayAnimationView.b();
        }
    }

    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }
}
