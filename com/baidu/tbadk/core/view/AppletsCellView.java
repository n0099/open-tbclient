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
    private String ahL;
    private TextView bNJ;
    private HeadImageView dDA;
    private TextView dDB;
    private HeadImageView dDx;
    private TextView dDy;
    private TbImageView dDz;
    private SmartApp dtD;
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
        this.dDx = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.dDy = (TextView) findViewById(R.id.applets_app_name);
        this.bNJ = (TextView) findViewById(R.id.applets_app_content);
        this.dDz = (TbImageView) findViewById(R.id.applets_app_img);
        this.dDA = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.dDB = (TextView) findViewById(R.id.applets_app_type_name);
        this.dDx.setIsRound(true);
        this.dDx.setIsPreDrawBorder(true);
        this.dDx.setDrawBorder(true);
        this.dDx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.dDx.setDefaultResource(R.color.cp_bg_line_e);
        this.dDx.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.dDz.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.dDz.setLayoutParams(layoutParams);
        this.dDz.setConrers(15);
        setOnClickListener(this);
        this.dDA.setIsRound(true);
        this.dDA.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.ahL = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dtD = smartApp;
        this.dDx.startLoad(smartApp.avatar, 10, false);
        this.dDy.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bNJ.setVisibility(8);
        } else {
            this.bNJ.setVisibility(0);
            this.bNJ.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.dDz.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.dDz.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.dDz.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.dDz.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.dDz.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dtD != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dtD.id, this.dtD.link, "1191003900000000", this.dtD.is_game)) {
                if (!StringUtils.isNull(this.dtD.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.dtD.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cI("fid", this.mForumId).cI("tid", this.ahL).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_name", this.dtD.name).t("obj_id", this.dtD.swan_app_id.longValue()).cI("obj_source", this.mFrom).af("obj_param1", this.dtD.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.dDx.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.dDx.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dDy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bNJ, (int) R.color.cp_cont_b);
        this.dDz.setIsNight(this.mSkinType == 1);
        this.dDA.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.dDA.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.dDA.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dDB, (int) R.color.cp_cont_d);
    }
}
