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
    private String OG;
    private TextView ble;
    private SmartApp cQb;
    private HeadImageView cZs;
    private TextView cZt;
    private TbImageView cZu;
    private HeadImageView cZv;
    private TextView cZw;
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
        this.cZs = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.cZt = (TextView) findViewById(R.id.applets_app_name);
        this.ble = (TextView) findViewById(R.id.applets_app_content);
        this.cZu = (TbImageView) findViewById(R.id.applets_app_img);
        this.cZv = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.cZw = (TextView) findViewById(R.id.applets_app_type_name);
        this.cZs.setIsRound(true);
        this.cZs.setIsPreDrawBorder(true);
        this.cZs.setDrawBorder(true);
        this.cZs.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.cZs.setDefaultResource(R.color.cp_bg_line_e);
        this.cZs.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.cZu.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.cZu.setLayoutParams(layoutParams);
        this.cZu.setConrers(15);
        setOnClickListener(this);
        this.cZv.setIsRound(true);
        this.cZv.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.OG = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cQb = smartApp;
        this.cZs.startLoad(smartApp.avatar, 10, false);
        this.cZt.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.ble.setVisibility(8);
        } else {
            this.ble.setVisibility(0);
            this.ble.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.cZu.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.cZu.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.cZu.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.cZu.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.cZu.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cQb != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cQb.id, this.cQb.link, "1191003900000000", this.cQb.is_game)) {
                if (!StringUtils.isNull(this.cQb.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.cQb.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").cp("fid", this.mForumId).cp("tid", this.OG).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", this.cQb.name).s("obj_id", this.cQb.swan_app_id.longValue()).cp("obj_source", this.mFrom).Z("obj_param1", this.cQb.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.cZs.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.cZs.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.cZt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ble, (int) R.color.cp_cont_b);
        this.cZu.setIsNight(this.mSkinType == 1);
        this.cZv.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.cZv.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.cZv.setIsNight(this.mSkinType == 1);
        am.setViewTextColor(this.cZw, (int) R.color.cp_cont_d);
    }
}
