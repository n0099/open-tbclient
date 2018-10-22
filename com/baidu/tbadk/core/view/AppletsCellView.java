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
    private HeadImageView aAX;
    private TextView aAY;
    private SmartApp art;
    private TbImageView asX;
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
        this.aAX = (HeadImageView) findViewById(e.g.applets_app_icon);
        this.aAY = (TextView) findViewById(e.g.applets_app_name);
        this.mContentView = (TextView) findViewById(e.g.applets_app_content);
        this.asX = (TbImageView) findViewById(e.g.applets_app_img);
        this.aAX.setIsRound(true);
        this.aAX.setIsPreDrawBorder(true);
        this.aAX.setDrawBorder(true);
        this.aAX.setBorderWidth(com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds1));
        this.aAX.setDefaultResource(e.d.cp_bg_line_e);
        this.aAX.setRadius(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds70));
        ViewGroup.LayoutParams layoutParams = this.asX.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.tbds130)) * 9) / 16;
        this.asX.setLayoutParams(layoutParams);
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
        this.art = smartApp;
        this.aAX.startLoad(smartApp.avatar, 10, false);
        this.aAY.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setVisibility(0);
            this.mContentView.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.asX.setDefaultBgResource(e.f.pic_share_default_applets);
            return;
        }
        this.asX.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.asX.setDefaultBgResource(e.f.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.asX.setDefaultBgResource(e.f.pic_share_default_applets);
            }
        });
        this.asX.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.art != null) {
            if (!com.baidu.tieba.aiapps.a.u(this.art.id, this.art.link, "1191003900000000")) {
                if (!StringUtils.isNull(this.art.h5_url)) {
                    com.baidu.tbadk.browser.a.ae(getContext(), this.art.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, this.mForumId).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", this.art.name).ax(VideoPlayActivityConfig.OBJ_ID, this.art.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this, e.d.cp_bg_line_e);
            this.aAX.setBorderColor(al.getColor(e.d.cp_bg_line_d));
            this.aAX.setIsNight(this.mSkinType == 1);
            al.h(this.aAY, e.d.cp_cont_f);
            al.h(this.mContentView, e.d.cp_cont_b);
            this.asX.setIsNight(this.mSkinType == 1);
        }
    }
}
