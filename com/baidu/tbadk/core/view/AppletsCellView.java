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
    private String alA;
    private TextView clp;
    private SmartApp egh;
    private HeadImageView eqN;
    private TextView eqO;
    private TbImageView eqP;
    private HeadImageView eqQ;
    private TextView eqR;
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
        this.eqN = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eqO = (TextView) findViewById(R.id.applets_app_name);
        this.clp = (TextView) findViewById(R.id.applets_app_content);
        this.eqP = (TbImageView) findViewById(R.id.applets_app_img);
        this.eqQ = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eqR = (TextView) findViewById(R.id.applets_app_type_name);
        this.eqN.setIsRound(true);
        this.eqN.setIsPreDrawBorder(true);
        this.eqN.setDrawBorder(true);
        this.eqN.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eqN.setDefaultResource(R.color.cp_bg_line_e);
        this.eqN.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eqP.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eqP.setLayoutParams(layoutParams);
        this.eqP.setConrers(15);
        setOnClickListener(this);
        this.eqQ.setIsRound(true);
        this.eqQ.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.alA = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.egh = smartApp;
        this.eqN.startLoad(smartApp.avatar, 10, false);
        this.eqO.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.clp.setVisibility(8);
        } else {
            this.clp.setVisibility(0);
            this.clp.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eqP.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eqP.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eqP.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eqP.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eqP.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.egh != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.egh.id, this.egh.link, "1191003900000000", this.egh.is_game)) {
                if (!StringUtils.isNull(this.egh.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.egh.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dF("fid", this.mForumId).dF("tid", this.alA).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("obj_name", this.egh.name).u("obj_id", this.egh.swan_app_id.longValue()).dF("obj_source", this.mFrom).ai("obj_param1", this.egh.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eqN.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eqN.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eqO, R.color.cp_cont_b);
        ap.setViewTextColor(this.clp, R.color.cp_cont_b);
        this.eqP.setIsNight(this.mSkinType == 1);
        this.eqQ.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eqQ.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eqQ.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eqR, R.color.cp_cont_d);
    }
}
