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
    private TextView bpp;
    private SmartApp cUe;
    private TbImageView ddA;
    private HeadImageView ddB;
    private TextView ddC;
    private HeadImageView ddy;
    private TextView ddz;
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
        this.ddy = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.ddz = (TextView) findViewById(R.id.applets_app_name);
        this.bpp = (TextView) findViewById(R.id.applets_app_content);
        this.ddA = (TbImageView) findViewById(R.id.applets_app_img);
        this.ddB = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.ddC = (TextView) findViewById(R.id.applets_app_type_name);
        this.ddy.setIsRound(true);
        this.ddy.setIsPreDrawBorder(true);
        this.ddy.setDrawBorder(true);
        this.ddy.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.ddy.setDefaultResource(R.color.cp_bg_line_e);
        this.ddy.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.ddA.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.ddA.setLayoutParams(layoutParams);
        this.ddA.setConrers(15);
        setOnClickListener(this);
        this.ddB.setIsRound(true);
        this.ddB.setDrawBorder(false);
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
        this.cUe = smartApp;
        this.ddy.startLoad(smartApp.avatar, 10, false);
        this.ddz.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.bpp.setVisibility(8);
        } else {
            this.bpp.setVisibility(0);
            this.bpp.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.ddA.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.ddA.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.ddA.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.ddA.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.ddA.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cUe != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cUe.id, this.cUe.link, "1191003900000000", this.cUe.is_game)) {
                if (!StringUtils.isNull(this.cUe.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cUe.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cy("fid", this.mForumId).cy("tid", this.Pj).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", this.cUe.name).s("obj_id", this.cUe.swan_app_id.longValue()).cy("obj_source", this.mFrom).X("obj_param1", this.cUe.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.ddy.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddy.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddz, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bpp, (int) R.color.cp_cont_b);
        this.ddA.setIsNight(this.mSkinType == 1);
        this.ddB.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.ddB.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.ddB.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.ddC, (int) R.color.cp_cont_d);
    }
}
