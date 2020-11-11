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
    private TextView cLW;
    private SmartApp eGC;
    private HeadImageView eRk;
    private TextView eRl;
    private TbImageView eRm;
    private HeadImageView eRn;
    private TextView eRo;
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
        this.eRk = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eRl = (TextView) findViewById(R.id.applets_app_name);
        this.cLW = (TextView) findViewById(R.id.applets_app_content);
        this.eRm = (TbImageView) findViewById(R.id.applets_app_img);
        this.eRn = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eRo = (TextView) findViewById(R.id.applets_app_type_name);
        this.eRk.setIsRound(true);
        this.eRk.setIsPreDrawBorder(true);
        this.eRk.setDrawBorder(true);
        this.eRk.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eRk.setDefaultResource(R.color.cp_bg_line_e);
        this.eRk.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eRm.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eRm.setLayoutParams(layoutParams);
        this.eRm.setConrers(15);
        setOnClickListener(this);
        this.eRn.setIsRound(true);
        this.eRn.setDrawBorder(false);
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
        this.eGC = smartApp;
        this.eRk.startLoad(smartApp.avatar, 10, false);
        this.eRl.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cLW.setVisibility(8);
        } else {
            this.cLW.setVisibility(0);
            this.cLW.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eRm.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eRm.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eRm.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eRm.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eRm.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eGC != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eGC.id, this.eGC.link, "1191003900000000", this.eGC.is_game)) {
                if (!StringUtils.isNull(this.eGC.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eGC.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dR("fid", this.mForumId).dR("tid", this.alT).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", this.eGC.name).w("obj_id", this.eGC.swan_app_id.longValue()).dR("obj_source", this.mFrom).al("obj_param1", this.eGC.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eRk.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eRk.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eRl, R.color.cp_cont_b);
        ap.setViewTextColor(this.cLW, R.color.cp_cont_b);
        this.eRm.setIsNight(this.mSkinType == 1);
        this.eRn.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eRn.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eRn.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eRo, R.color.cp_cont_d);
    }
}
