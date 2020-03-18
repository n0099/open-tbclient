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
    private String Pk;
    private TextView bpC;
    private SmartApp cUs;
    private HeadImageView ddY;
    private TextView ddZ;
    private TbImageView dea;
    private HeadImageView deb;
    private TextView dec;
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
        this.ddY = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.ddZ = (TextView) findViewById(R.id.applets_app_name);
        this.bpC = (TextView) findViewById(R.id.applets_app_content);
        this.dea = (TbImageView) findViewById(R.id.applets_app_img);
        this.deb = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.dec = (TextView) findViewById(R.id.applets_app_type_name);
        this.ddY.setIsRound(true);
        this.ddY.setIsPreDrawBorder(true);
        this.ddY.setDrawBorder(true);
        this.ddY.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.ddY.setDefaultResource(R.color.cp_bg_line_e);
        this.ddY.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.dea.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.dea.setLayoutParams(layoutParams);
        this.dea.setConrers(15);
        setOnClickListener(this);
        this.deb.setIsRound(true);
        this.deb.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.Pk = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cUs = smartApp;
        this.ddY.startLoad(smartApp.avatar, 10, false);
        this.ddZ.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bpC.setVisibility(8);
        } else {
            this.bpC.setVisibility(0);
            this.bpC.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.dea.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.dea.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.dea.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.dea.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.dea.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cUs != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cUs.id, this.cUs.link, "1191003900000000", this.cUs.is_game)) {
                if (!StringUtils.isNull(this.cUs.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cUs.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cx("fid", this.mForumId).cx("tid", this.Pk).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("obj_name", this.cUs.name).s("obj_id", this.cUs.swan_app_id.longValue()).cx("obj_source", this.mFrom).X("obj_param1", this.cUs.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.ddY.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddY.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bpC, (int) R.color.cp_cont_b);
        this.dea.setIsNight(this.mSkinType == 1);
        this.deb.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.deb.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.deb.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.dec, (int) R.color.cp_cont_d);
    }
}
