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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String alT;
    private TextView cGd;
    private SmartApp eAN;
    private HeadImageView eLv;
    private TextView eLw;
    private TbImageView eLx;
    private HeadImageView eLy;
    private TextView eLz;
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
        this.eLv = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eLw = (TextView) findViewById(R.id.applets_app_name);
        this.cGd = (TextView) findViewById(R.id.applets_app_content);
        this.eLx = (TbImageView) findViewById(R.id.applets_app_img);
        this.eLy = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eLz = (TextView) findViewById(R.id.applets_app_type_name);
        this.eLv.setIsRound(true);
        this.eLv.setIsPreDrawBorder(true);
        this.eLv.setDrawBorder(true);
        this.eLv.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eLv.setDefaultResource(R.color.cp_bg_line_e);
        this.eLv.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eLx.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eLx.setLayoutParams(layoutParams);
        this.eLx.setConrers(15);
        setOnClickListener(this);
        this.eLy.setIsRound(true);
        this.eLy.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.alT = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eAN = smartApp;
        this.eLv.startLoad(smartApp.avatar, 10, false);
        this.eLw.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cGd.setVisibility(8);
        } else {
            this.cGd.setVisibility(0);
            this.cGd.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eLx.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eLx.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eLx.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eLx.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eLx.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eAN != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eAN.id, this.eAN.link, "1191003900000000", this.eAN.is_game)) {
                if (!StringUtils.isNull(this.eAN.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eAN.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dR("fid", this.mForumId).dR("tid", this.alT).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", this.eAN.name).w("obj_id", this.eAN.swan_app_id.longValue()).dR("obj_source", this.mFrom).aj("obj_param1", this.eAN.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eLv.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eLv.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eLw, R.color.cp_cont_b);
        ap.setViewTextColor(this.cGd, R.color.cp_cont_b);
        this.eLx.setIsNight(this.mSkinType == 1);
        this.eLy.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eLy.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eLy.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eLz, R.color.cp_cont_d);
    }
}
