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
    private String ahO;
    private TextView bNO;
    private HeadImageView dDB;
    private TextView dDC;
    private TbImageView dDD;
    private HeadImageView dDE;
    private TextView dDF;
    private SmartApp dtH;
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
        this.dDB = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.dDC = (TextView) findViewById(R.id.applets_app_name);
        this.bNO = (TextView) findViewById(R.id.applets_app_content);
        this.dDD = (TbImageView) findViewById(R.id.applets_app_img);
        this.dDE = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.dDF = (TextView) findViewById(R.id.applets_app_type_name);
        this.dDB.setIsRound(true);
        this.dDB.setIsPreDrawBorder(true);
        this.dDB.setDrawBorder(true);
        this.dDB.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.dDB.setDefaultResource(R.color.cp_bg_line_e);
        this.dDB.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.dDD.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.dDD.setLayoutParams(layoutParams);
        this.dDD.setConrers(15);
        setOnClickListener(this);
        this.dDE.setIsRound(true);
        this.dDE.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.ahO = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dtH = smartApp;
        this.dDB.startLoad(smartApp.avatar, 10, false);
        this.dDC.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bNO.setVisibility(8);
        } else {
            this.bNO.setVisibility(0);
            this.bNO.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.dDD.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.dDD.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.dDD.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.dDD.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.dDD.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dtH != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dtH.id, this.dtH.link, "1191003900000000", this.dtH.is_game)) {
                if (!StringUtils.isNull(this.dtH.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.dtH.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cI("fid", this.mForumId).cI("tid", this.ahO).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_name", this.dtH.name).t("obj_id", this.dtH.swan_app_id.longValue()).cI("obj_source", this.mFrom).af("obj_param1", this.dtH.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.dDB.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.dDB.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dDC, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bNO, (int) R.color.cp_cont_b);
        this.dDD.setIsNight(this.mSkinType == 1);
        this.dDE.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.dDE.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.dDE.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dDF, (int) R.color.cp_cont_d);
    }
}
