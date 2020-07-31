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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String ajJ;
    private TextView cdm;
    private SmartApp dUx;
    private HeadImageView eeS;
    private TextView eeT;
    private TbImageView eeU;
    private HeadImageView eeV;
    private TextView eeW;
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
        this.eeS = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eeT = (TextView) findViewById(R.id.applets_app_name);
        this.cdm = (TextView) findViewById(R.id.applets_app_content);
        this.eeU = (TbImageView) findViewById(R.id.applets_app_img);
        this.eeV = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eeW = (TextView) findViewById(R.id.applets_app_type_name);
        this.eeS.setIsRound(true);
        this.eeS.setIsPreDrawBorder(true);
        this.eeS.setDrawBorder(true);
        this.eeS.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eeS.setDefaultResource(R.color.cp_bg_line_e);
        this.eeS.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eeU.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eeU.setLayoutParams(layoutParams);
        this.eeU.setConrers(15);
        setOnClickListener(this);
        this.eeV.setIsRound(true);
        this.eeV.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.ajJ = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dUx = smartApp;
        this.eeS.startLoad(smartApp.avatar, 10, false);
        this.eeT.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cdm.setVisibility(8);
        } else {
            this.cdm.setVisibility(0);
            this.cdm.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eeU.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eeU.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eeU.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eeU.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eeU.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dUx != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dUx.id, this.dUx.link, "1191003900000000", this.dUx.is_game)) {
                if (!StringUtils.isNull(this.dUx.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.dUx.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new ap("c13274").dn("fid", this.mForumId).dn("tid", this.ajJ).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("obj_name", this.dUx.name).t("obj_id", this.dUx.swan_app_id.longValue()).dn("obj_source", this.mFrom).ah("obj_param1", this.dUx.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eeS.setBorderColor(ao.getColor(R.color.cp_bg_line_d));
        this.eeS.setIsNight(this.mSkinType == 1);
        ao.setViewTextColor(this.eeT, R.color.cp_cont_b);
        ao.setViewTextColor(this.cdm, R.color.cp_cont_b);
        this.eeU.setIsNight(this.mSkinType == 1);
        this.eeV.setImageDrawable(ao.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eeV.setBorderColor(ao.getColor(R.color.cp_bg_line_d));
        this.eeV.setIsNight(this.mSkinType == 1);
        ao.setViewTextColor(this.eeW, R.color.cp_cont_d);
    }
}
