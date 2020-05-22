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
    private String ais;
    private TextView bWU;
    private SmartApp dHA;
    private HeadImageView dRN;
    private TextView dRO;
    private TbImageView dRP;
    private HeadImageView dRQ;
    private TextView dRR;
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
        this.dRN = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.dRO = (TextView) findViewById(R.id.applets_app_name);
        this.bWU = (TextView) findViewById(R.id.applets_app_content);
        this.dRP = (TbImageView) findViewById(R.id.applets_app_img);
        this.dRQ = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.dRR = (TextView) findViewById(R.id.applets_app_type_name);
        this.dRN.setIsRound(true);
        this.dRN.setIsPreDrawBorder(true);
        this.dRN.setDrawBorder(true);
        this.dRN.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.dRN.setDefaultResource(R.color.cp_bg_line_e);
        this.dRN.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.dRP.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.dRP.setLayoutParams(layoutParams);
        this.dRP.setConrers(15);
        setOnClickListener(this);
        this.dRQ.setIsRound(true);
        this.dRQ.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.ais = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dHA = smartApp;
        this.dRN.startLoad(smartApp.avatar, 10, false);
        this.dRO.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bWU.setVisibility(8);
        } else {
            this.bWU.setVisibility(0);
            this.bWU.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.dRP.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.dRP.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.dRP.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.dRP.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.dRP.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dHA != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dHA.id, this.dHA.link, "1191003900000000", this.dHA.is_game)) {
                if (!StringUtils.isNull(this.dHA.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.dHA.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").dh("fid", this.mForumId).dh("tid", this.ais).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("obj_name", this.dHA.name).s("obj_id", this.dHA.swan_app_id.longValue()).dh("obj_source", this.mFrom).ag("obj_param1", this.dHA.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.dRN.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.dRN.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dRO, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bWU, (int) R.color.cp_cont_b);
        this.dRP.setIsNight(this.mSkinType == 1);
        this.dRQ.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.dRQ.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.dRQ.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dRR, (int) R.color.cp_cont_d);
    }
}
