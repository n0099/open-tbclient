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
    private TextView aLN;
    private SmartApp cdz;
    private HeadImageView clV;
    private TextView clW;
    private TbImageView clX;
    private HeadImageView clY;
    private TextView clZ;
    private String cma;
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
        this.clV = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.clW = (TextView) findViewById(R.id.applets_app_name);
        this.aLN = (TextView) findViewById(R.id.applets_app_content);
        this.clX = (TbImageView) findViewById(R.id.applets_app_img);
        this.clY = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.clZ = (TextView) findViewById(R.id.applets_app_type_name);
        this.clV.setIsRound(true);
        this.clV.setIsPreDrawBorder(true);
        this.clV.setDrawBorder(true);
        this.clV.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.clV.setDefaultResource(R.color.cp_bg_line_e);
        this.clV.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.clX.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.clX.setLayoutParams(layoutParams);
        this.clX.setConrers(15);
        setOnClickListener(this);
        this.clY.setIsRound(true);
        this.clY.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.cma = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cdz = smartApp;
        this.clV.startLoad(smartApp.avatar, 10, false);
        this.clW.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.aLN.setVisibility(8);
        } else {
            this.aLN.setVisibility(0);
            this.aLN.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.clX.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.clX.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.clX.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.clX.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.clX.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cdz != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cdz.id, this.cdz.link, "1191003900000000", this.cdz.is_game)) {
                if (!StringUtils.isNull(this.cdz.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cdz.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").bS("fid", this.mForumId).bS("tid", this.cma).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", this.cdz.name).p("obj_id", this.cdz.swan_app_id.longValue()).bS("obj_source", this.mFrom).O("obj_param1", this.cdz.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.clV.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.clV.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.clW, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.aLN, (int) R.color.cp_cont_b);
        this.clX.setIsNight(this.mSkinType == 1);
        this.clY.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.clY.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.clY.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.clZ, (int) R.color.cp_cont_d);
    }
}
