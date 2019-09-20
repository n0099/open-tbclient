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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private SmartApp bMH;
    private HeadImageView bXI;
    private TextView bXJ;
    private TbImageView bXK;
    private HeadImageView bXL;
    private TextView bXM;
    private String bXN;
    private TextView mContentView;
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
        this.bXI = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.bXJ = (TextView) findViewById(R.id.applets_app_name);
        this.mContentView = (TextView) findViewById(R.id.applets_app_content);
        this.bXK = (TbImageView) findViewById(R.id.applets_app_img);
        this.bXL = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.bXM = (TextView) findViewById(R.id.applets_app_type_name);
        this.bXI.setIsRound(true);
        this.bXI.setIsPreDrawBorder(true);
        this.bXI.setDrawBorder(true);
        this.bXI.setBorderWidth(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1));
        this.bXI.setDefaultResource(R.color.cp_bg_line_e);
        this.bXI.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.bXK.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.af(getContext()) - com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.bXK.setLayoutParams(layoutParams);
        this.bXK.setConrers(15);
        setOnClickListener(this);
        this.bXL.setIsRound(true);
        this.bXL.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.bXN = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bMH = smartApp;
        this.bXI.startLoad(smartApp.avatar, 10, false);
        this.bXJ.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setVisibility(0);
            this.mContentView.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.bXK.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.bXK.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.bXK.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.bXK.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.bXK.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bMH != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.bMH.id, this.bMH.link, "1191003900000000", this.bMH.is_game)) {
                if (!StringUtils.isNull(this.bMH.h5_url)) {
                    com.baidu.tbadk.browser.a.ae(getContext(), this.bMH.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new an("c13274").bT("fid", this.mForumId).bT("tid", this.bXN).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", this.bMH.name).n(VideoPlayActivityConfig.OBJ_ID, this.bMH.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_param1", this.bMH.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        am.k(this, R.drawable.applets_cell_bg);
        this.bXI.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.bXI.setIsNight(this.mSkinType == 1);
        am.j(this.bXJ, R.color.cp_cont_b);
        am.j(this.mContentView, R.color.cp_cont_b);
        this.bXK.setIsNight(this.mSkinType == 1);
        this.bXL.setImageDrawable(am.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.bXL.setBorderColor(am.getColor(R.color.cp_bg_line_d));
        this.bXL.setIsNight(this.mSkinType == 1);
        am.j(this.bXM, R.color.cp_cont_d);
    }
}
