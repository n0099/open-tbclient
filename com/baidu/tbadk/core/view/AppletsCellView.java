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
    private String ala;
    private TextView cjo;
    private SmartApp edX;
    private HeadImageView eoA;
    private TextView eoB;
    private HeadImageView eox;
    private TextView eoy;
    private TbImageView eoz;
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
        this.eox = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eoy = (TextView) findViewById(R.id.applets_app_name);
        this.cjo = (TextView) findViewById(R.id.applets_app_content);
        this.eoz = (TbImageView) findViewById(R.id.applets_app_img);
        this.eoA = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eoB = (TextView) findViewById(R.id.applets_app_type_name);
        this.eox.setIsRound(true);
        this.eox.setIsPreDrawBorder(true);
        this.eox.setDrawBorder(true);
        this.eox.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eox.setDefaultResource(R.color.cp_bg_line_e);
        this.eox.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eoz.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eoz.setLayoutParams(layoutParams);
        this.eoz.setConrers(15);
        setOnClickListener(this);
        this.eoA.setIsRound(true);
        this.eoA.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.ala = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.edX = smartApp;
        this.eox.startLoad(smartApp.avatar, 10, false);
        this.eoy.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cjo.setVisibility(8);
        } else {
            this.cjo.setVisibility(0);
            this.cjo.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eoz.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eoz.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eoz.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eoz.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eoz.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.edX != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.edX.id, this.edX.link, "1191003900000000", this.edX.is_game)) {
                if (!StringUtils.isNull(this.edX.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.edX.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dD("fid", this.mForumId).dD("tid", this.ala).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", this.edX.name).u("obj_id", this.edX.swan_app_id.longValue()).dD("obj_source", this.mFrom).ai("obj_param1", this.edX.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eox.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eox.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eoy, R.color.cp_cont_b);
        ap.setViewTextColor(this.cjo, R.color.cp_cont_b);
        this.eoz.setIsNight(this.mSkinType == 1);
        this.eoA.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eoA.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eoA.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eoB, R.color.cp_cont_d);
    }
}
