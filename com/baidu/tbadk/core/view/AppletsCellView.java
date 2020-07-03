package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String ajO;
    private TextView cbI;
    private SmartApp dOm;
    private HeadImageView dYF;
    private TextView dYG;
    private TbImageView dYH;
    private HeadImageView dYI;
    private TextView dYJ;
    private String mForumId;
    private String mFrom;
    private int mSkinType;

    public AppletsCellView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public AppletsCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public AppletsCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.applets_cell_layout, (ViewGroup) this, true);
        this.dYF = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.dYG = (TextView) findViewById(R.id.applets_app_name);
        this.cbI = (TextView) findViewById(R.id.applets_app_content);
        this.dYH = (TbImageView) findViewById(R.id.applets_app_img);
        this.dYI = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.dYJ = (TextView) findViewById(R.id.applets_app_type_name);
        this.dYF.setIsRound(true);
        this.dYF.setIsPreDrawBorder(true);
        this.dYF.setDrawBorder(true);
        this.dYF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.dYF.setDefaultResource(R.color.cp_bg_line_e);
        this.dYF.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.dYH.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.dYH.setLayoutParams(layoutParams);
        this.dYH.setConrers(15);
        setOnClickListener(this);
        this.dYI.setIsRound(true);
        this.dYI.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.ajO = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dOm = smartApp;
        this.dYF.startLoad(smartApp.avatar, 10, false);
        this.dYG.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cbI.setVisibility(8);
        } else {
            this.cbI.setVisibility(0);
            this.cbI.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.dYH.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.dYH.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.dYH.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.dYH.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.dYH.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dOm != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dOm.id, this.dOm.link, "1191003900000000", this.dOm.is_game)) {
                if (!StringUtils.isNull(this.dOm.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.dOm.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new ao("c13274").dk("fid", this.mForumId).dk("tid", this.ajO).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("obj_name", this.dOm.name).s("obj_id", this.dOm.swan_app_id.longValue()).dk("obj_source", this.mFrom).ag("obj_param1", this.dOm.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        an.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.dYF.setBorderColor(an.getColor(R.color.cp_bg_line_d));
        this.dYF.setIsNight(this.mSkinType == 1);
        an.setViewTextColor(this.dYG, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.cbI, (int) R.color.cp_cont_b);
        this.dYH.setIsNight(this.mSkinType == 1);
        this.dYI.setImageDrawable(an.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.dYI.setBorderColor(an.getColor(R.color.cp_bg_line_d));
        this.dYI.setIsNight(this.mSkinType == 1);
        an.setViewTextColor(this.dYJ, (int) R.color.cp_cont_d);
    }
}
