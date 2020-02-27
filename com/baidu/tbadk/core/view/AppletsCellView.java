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
    private TextView bpo;
    private SmartApp cUd;
    private HeadImageView ddA;
    private TextView ddB;
    private HeadImageView ddx;
    private TextView ddy;
    private TbImageView ddz;
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
        this.ddx = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.ddy = (TextView) findViewById(R.id.applets_app_name);
        this.bpo = (TextView) findViewById(R.id.applets_app_content);
        this.ddz = (TbImageView) findViewById(R.id.applets_app_img);
        this.ddA = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.ddB = (TextView) findViewById(R.id.applets_app_type_name);
        this.ddx.setIsRound(true);
        this.ddx.setIsPreDrawBorder(true);
        this.ddx.setDrawBorder(true);
        this.ddx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.ddx.setDefaultResource(R.color.cp_bg_line_e);
        this.ddx.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.ddz.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.ddz.setLayoutParams(layoutParams);
        this.ddz.setConrers(15);
        setOnClickListener(this);
        this.ddA.setIsRound(true);
        this.ddA.setDrawBorder(false);
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
        this.cUd = smartApp;
        this.ddx.startLoad(smartApp.avatar, 10, false);
        this.ddy.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bpo.setVisibility(8);
        } else {
            this.bpo.setVisibility(0);
            this.bpo.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.ddz.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.ddz.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.ddz.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.ddz.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.ddz.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cUd != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cUd.id, this.cUd.link, "1191003900000000", this.cUd.is_game)) {
                if (!StringUtils.isNull(this.cUd.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cUd.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cy("fid", this.mForumId).cy("tid", this.Pj).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", this.cUd.name).s("obj_id", this.cUd.swan_app_id.longValue()).cy("obj_source", this.mFrom).X("obj_param1", this.cUd.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.ddx.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddx.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bpo, (int) R.color.cp_cont_b);
        this.ddz.setIsNight(this.mSkinType == 1);
        this.ddA.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.ddA.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddA.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddB, (int) R.color.cp_cont_d);
    }
}
