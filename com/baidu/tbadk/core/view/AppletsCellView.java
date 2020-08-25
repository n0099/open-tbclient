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
/* loaded from: classes2.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String akY;
    private TextView cjk;
    private SmartApp edT;
    private HeadImageView eot;
    private TextView eou;
    private TbImageView eov;
    private HeadImageView eow;
    private TextView eox;
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
        this.eot = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eou = (TextView) findViewById(R.id.applets_app_name);
        this.cjk = (TextView) findViewById(R.id.applets_app_content);
        this.eov = (TbImageView) findViewById(R.id.applets_app_img);
        this.eow = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eox = (TextView) findViewById(R.id.applets_app_type_name);
        this.eot.setIsRound(true);
        this.eot.setIsPreDrawBorder(true);
        this.eot.setDrawBorder(true);
        this.eot.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eot.setDefaultResource(R.color.cp_bg_line_e);
        this.eot.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eov.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eov.setLayoutParams(layoutParams);
        this.eov.setConrers(15);
        setOnClickListener(this);
        this.eow.setIsRound(true);
        this.eow.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.akY = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.edT = smartApp;
        this.eot.startLoad(smartApp.avatar, 10, false);
        this.eou.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cjk.setVisibility(8);
        } else {
            this.cjk.setVisibility(0);
            this.cjk.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eov.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eov.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eov.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eov.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eov.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.edT != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.edT.id, this.edT.link, "1191003900000000", this.edT.is_game)) {
                if (!StringUtils.isNull(this.edT.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.edT.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dD("fid", this.mForumId).dD("tid", this.akY).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", this.edT.name).u("obj_id", this.edT.swan_app_id.longValue()).dD("obj_source", this.mFrom).ai("obj_param1", this.edT.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eot.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eot.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eou, R.color.cp_cont_b);
        ap.setViewTextColor(this.cjk, R.color.cp_cont_b);
        this.eov.setIsNight(this.mSkinType == 1);
        this.eow.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eow.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eow.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eox, R.color.cp_cont_d);
    }
}
