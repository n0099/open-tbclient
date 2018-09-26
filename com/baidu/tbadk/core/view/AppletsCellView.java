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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private SmartApp amy;
    private TbImageView aof;
    private HeadImageView awm;
    private TextView awn;
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
        LayoutInflater.from(context).inflate(e.h.applets_cell_layout, (ViewGroup) this, true);
        this.awm = (HeadImageView) findViewById(e.g.applets_app_icon);
        this.awn = (TextView) findViewById(e.g.applets_app_name);
        this.mContentView = (TextView) findViewById(e.g.applets_app_content);
        this.aof = (TbImageView) findViewById(e.g.applets_app_img);
        this.awm.setIsRound(true);
        this.awm.setIsPreDrawBorder(true);
        this.awm.setDrawBorder(true);
        this.awm.setBorderWidth(com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds1));
        this.awm.setDefaultResource(e.d.cp_bg_line_e);
        this.awm.setRadius(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds70));
        ViewGroup.LayoutParams layoutParams = this.aof.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds130)) * 9) / 16;
        this.aof.setLayoutParams(layoutParams);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.amy = smartApp;
        this.awm.startLoad(smartApp.avatar, 10, false);
        this.awn.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setVisibility(0);
            this.mContentView.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.aof.setDefaultBgResource(e.f.pic_share_default_applets);
            return;
        }
        this.aof.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.aof.setDefaultBgResource(e.f.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.aof.setDefaultBgResource(e.f.pic_share_default_applets);
            }
        });
        this.aof.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.amy != null && !StringUtils.isNull(this.amy.h5_url)) {
            TiebaStatic.log(new am("c13274").al(ImageViewerConfig.FORUM_ID, this.mForumId).al("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_name", this.amy.name).al(VideoPlayActivityConfig.OBJ_ID, this.amy.id).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
            com.baidu.tbadk.browser.a.ae(getContext(), this.amy.h5_url);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.cp_bg_line_e);
            this.awm.setBorderColor(al.getColor(e.d.cp_bg_line_d));
            this.awm.setIsNight(this.mSkinType == 1);
            al.h(this.awn, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.aof.setIsNight(this.mSkinType == 1);
        }
    }
}
