package com.baidu.ala.view.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes2.dex */
public class AlaCardBottomUserInfoLayout extends LinearLayout {
    private static final int MAX_USERNAME_LENGTH = 10;
    private HeadImageView alaCardUserHeadImg;
    private TextView alaCardUserName;
    private AlaPlayAnimationView alaPlayAnim;
    private TextView alaWatchCount;

    public AlaCardBottomUserInfoLayout(Context context) {
        super(context);
        init(context);
    }

    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaCardBottomUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        if (this.alaCardUserHeadImg != null) {
            this.alaCardUserHeadImg.setDefaultResource(17170445);
            this.alaCardUserHeadImg.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.alaCardUserHeadImg.setDefaultBgResource(R.color.cp_bg_line_e);
            this.alaCardUserHeadImg.setIsRound(true);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.azX() != null) {
            AlaUserInfoData alaUserInfoData = bjVar.azX().user_info;
            String str = "";
            if (bjVar.azE() != null) {
                str = bjVar.azE().getName_show();
            } else if (alaUserInfoData != null) {
                str = alaUserInfoData.user_name;
            }
            if (ad.getTextLengthWithEmoji(str) > 10) {
                str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
            }
            if (alaUserInfoData != null) {
                this.alaCardUserHeadImg.startLoad(alaUserInfoData.portrait, 28, false);
            }
            this.alaCardUserName.setText(str);
            this.alaWatchCount.setText(String.format(getContext().getResources().getString(R.string.ala_card_watch_num_text), aq.numFormatOverWan(bjVar.azX().audience_count)));
        }
    }

    public void setUserHeadImgVisible(int i) {
        if (this.alaCardUserHeadImg != null) {
            this.alaCardUserHeadImg.setVisibility(i);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        am.setViewTextColor(this.alaCardUserName, R.color.cp_cont_a, TbadkCoreApplication.getInst().getSkinType());
        am.setViewTextColor(this.alaWatchCount, R.color.cp_cont_a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void startPlayAnimation() {
        if (this.alaPlayAnim != null) {
            this.alaPlayAnim.startPlayAnimation();
        }
    }
}
