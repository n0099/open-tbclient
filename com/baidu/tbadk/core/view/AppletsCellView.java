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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String OC;
    private TextView bkp;
    private SmartApp cPR;
    private HeadImageView cZi;
    private TextView cZj;
    private TbImageView cZk;
    private HeadImageView cZl;
    private TextView cZm;
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
        this.cZi = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.cZj = (TextView) findViewById(R.id.applets_app_name);
        this.bkp = (TextView) findViewById(R.id.applets_app_content);
        this.cZk = (TbImageView) findViewById(R.id.applets_app_img);
        this.cZl = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.cZm = (TextView) findViewById(R.id.applets_app_type_name);
        this.cZi.setIsRound(true);
        this.cZi.setIsPreDrawBorder(true);
        this.cZi.setDrawBorder(true);
        this.cZi.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.cZi.setDefaultResource(R.color.cp_bg_line_e);
        this.cZi.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.cZk.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.cZk.setLayoutParams(layoutParams);
        this.cZk.setConrers(15);
        setOnClickListener(this);
        this.cZl.setIsRound(true);
        this.cZl.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.OC = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cPR = smartApp;
        this.cZi.startLoad(smartApp.avatar, 10, false);
        this.cZj.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bkp.setVisibility(8);
        } else {
            this.bkp.setVisibility(0);
            this.bkp.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.cZk.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.cZk.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.cZk.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.cZk.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.cZk.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPR != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cPR.id, this.cPR.link, "1191003900000000", this.cPR.is_game)) {
                if (!StringUtils.isNull(this.cPR.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cPR.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cp("fid", this.mForumId).cp("tid", this.OC).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", this.cPR.name).s("obj_id", this.cPR.swan_app_id.longValue()).cp("obj_source", this.mFrom).Z("obj_param1", this.cPR.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.cZi.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.cZi.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.cZj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bkp, (int) R.color.cp_cont_b);
        this.cZk.setIsNight(this.mSkinType == 1);
        this.cZl.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.cZl.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.cZl.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.cZm, (int) R.color.cp_cont_d);
    }
}
