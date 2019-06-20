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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private SmartApp bLe;
    private HeadImageView bVH;
    private TextView bVI;
    private TbImageView bVJ;
    private HeadImageView bVK;
    private TextView bVL;
    private String bVM;
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
        this.bVH = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.bVI = (TextView) findViewById(R.id.applets_app_name);
        this.mContentView = (TextView) findViewById(R.id.applets_app_content);
        this.bVJ = (TbImageView) findViewById(R.id.applets_app_img);
        this.bVK = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.bVL = (TextView) findViewById(R.id.applets_app_type_name);
        this.bVH.setIsRound(true);
        this.bVH.setIsPreDrawBorder(true);
        this.bVH.setDrawBorder(true);
        this.bVH.setBorderWidth(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1));
        this.bVH.setDefaultResource(R.color.cp_bg_line_e);
        this.bVH.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.bVJ.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.af(getContext()) - com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.bVJ.setLayoutParams(layoutParams);
        this.bVJ.setConrers(15);
        setOnClickListener(this);
        this.bVK.setIsRound(true);
        this.bVK.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.bVM = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bLe = smartApp;
        this.bVH.startLoad(smartApp.avatar, 10, false);
        this.bVI.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setVisibility(0);
            this.mContentView.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.bVJ.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.bVJ.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.bVJ.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.bVJ.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.bVJ.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bLe != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.bLe.id, this.bLe.link, "1191003900000000", this.bLe.is_game)) {
                if (!StringUtils.isNull(this.bLe.h5_url)) {
                    com.baidu.tbadk.browser.a.af(getContext(), this.bLe.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new am("c13274").bT("fid", this.mForumId).bT("tid", this.bVM).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", this.bLe.name).l(VideoPlayActivityConfig.OBJ_ID, this.bLe.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_param1", this.bLe.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        al.k(this, R.drawable.applets_cell_bg);
        this.bVH.setBorderColor(al.getColor(R.color.cp_bg_line_d));
        this.bVH.setIsNight(this.mSkinType == 1);
        al.j(this.bVI, R.color.cp_cont_b);
        al.j(this.mContentView, R.color.cp_cont_b);
        this.bVJ.setIsNight(this.mSkinType == 1);
        this.bVK.setImageDrawable(al.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.bVK.setBorderColor(al.getColor(R.color.cp_bg_line_d));
        this.bVK.setIsNight(this.mSkinType == 1);
        al.j(this.bVL, R.color.cp_cont_d);
    }
}
