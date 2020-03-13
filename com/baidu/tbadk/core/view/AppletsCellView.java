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
    private String Pj;
    private TextView bpq;
    private SmartApp cUf;
    private HeadImageView ddL;
    private TextView ddM;
    private TbImageView ddN;
    private HeadImageView ddO;
    private TextView ddP;
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
        this.ddL = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.ddM = (TextView) findViewById(R.id.applets_app_name);
        this.bpq = (TextView) findViewById(R.id.applets_app_content);
        this.ddN = (TbImageView) findViewById(R.id.applets_app_img);
        this.ddO = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.ddP = (TextView) findViewById(R.id.applets_app_type_name);
        this.ddL.setIsRound(true);
        this.ddL.setIsPreDrawBorder(true);
        this.ddL.setDrawBorder(true);
        this.ddL.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.ddL.setDefaultResource(R.color.cp_bg_line_e);
        this.ddL.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.ddN.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.ddN.setLayoutParams(layoutParams);
        this.ddN.setConrers(15);
        setOnClickListener(this);
        this.ddO.setIsRound(true);
        this.ddO.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.Pj = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cUf = smartApp;
        this.ddL.startLoad(smartApp.avatar, 10, false);
        this.ddM.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bpq.setVisibility(8);
        } else {
            this.bpq.setVisibility(0);
            this.bpq.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.ddN.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.ddN.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.ddN.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.ddN.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.ddN.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cUf != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cUf.id, this.cUf.link, "1191003900000000", this.cUf.is_game)) {
                if (!StringUtils.isNull(this.cUf.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cUf.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cy("fid", this.mForumId).cy("tid", this.Pj).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", this.cUf.name).s("obj_id", this.cUf.swan_app_id.longValue()).cy("obj_source", this.mFrom).X("obj_param1", this.cUf.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.ddL.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddL.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddM, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bpq, (int) R.color.cp_cont_b);
        this.ddN.setIsNight(this.mSkinType == 1);
        this.ddO.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.ddO.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddO.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddP, (int) R.color.cp_cont_d);
    }
}
