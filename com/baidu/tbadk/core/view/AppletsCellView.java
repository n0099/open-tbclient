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
    private TextView aMf;
    private SmartApp ceq;
    private HeadImageView cmN;
    private TextView cmO;
    private TbImageView cmP;
    private HeadImageView cmQ;
    private TextView cmR;
    private String cmS;
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
        this.cmN = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.cmO = (TextView) findViewById(R.id.applets_app_name);
        this.aMf = (TextView) findViewById(R.id.applets_app_content);
        this.cmP = (TbImageView) findViewById(R.id.applets_app_img);
        this.cmQ = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.cmR = (TextView) findViewById(R.id.applets_app_type_name);
        this.cmN.setIsRound(true);
        this.cmN.setIsPreDrawBorder(true);
        this.cmN.setDrawBorder(true);
        this.cmN.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.cmN.setDefaultResource(R.color.cp_bg_line_e);
        this.cmN.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.cmP.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.cmP.setLayoutParams(layoutParams);
        this.cmP.setConrers(15);
        setOnClickListener(this);
        this.cmQ.setIsRound(true);
        this.cmQ.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.cmS = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ceq = smartApp;
        this.cmN.startLoad(smartApp.avatar, 10, false);
        this.cmO.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.aMf.setVisibility(8);
        } else {
            this.aMf.setVisibility(0);
            this.aMf.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.cmP.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.cmP.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.cmP.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.cmP.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.cmP.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ceq != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.ceq.id, this.ceq.link, "1191003900000000", this.ceq.is_game)) {
                if (!StringUtils.isNull(this.ceq.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.ceq.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").bS("fid", this.mForumId).bS("tid", this.cmS).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", this.ceq.name).p("obj_id", this.ceq.swan_app_id.longValue()).bS("obj_source", this.mFrom).O("obj_param1", this.ceq.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.cmN.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.cmN.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.cmO, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.aMf, (int) R.color.cp_cont_b);
        this.cmP.setIsNight(this.mSkinType == 1);
        this.cmQ.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.cmQ.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.cmQ.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.cmR, (int) R.color.cp_cont_d);
    }
}
