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
import com.baidu.tieba.d;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private SmartApp bDI;
    private HeadImageView bNS;
    private TextView bNT;
    private TbImageView bNU;
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
        LayoutInflater.from(context).inflate(d.h.applets_cell_layout, (ViewGroup) this, true);
        this.bNS = (HeadImageView) findViewById(d.g.applets_app_icon);
        this.bNT = (TextView) findViewById(d.g.applets_app_name);
        this.mContentView = (TextView) findViewById(d.g.applets_app_content);
        this.bNU = (TbImageView) findViewById(d.g.applets_app_img);
        this.bNS.setIsRound(true);
        this.bNS.setIsPreDrawBorder(true);
        this.bNS.setDrawBorder(true);
        this.bNS.setBorderWidth(com.baidu.adp.lib.util.l.h(context, d.e.tbds1));
        this.bNS.setDefaultResource(d.C0277d.cp_bg_line_e);
        this.bNS.setRadius(com.baidu.adp.lib.util.l.h(context, d.e.ds70));
        ViewGroup.LayoutParams layoutParams = this.bNU.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.aO(getContext()) - com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds130)) * 9) / 16;
        this.bNU.setLayoutParams(layoutParams);
        this.bNU.setConrers(15);
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
        this.bDI = smartApp;
        this.bNS.startLoad(smartApp.avatar, 10, false);
        this.bNT.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.mContentView.setVisibility(8);
        } else {
            this.mContentView.setVisibility(0);
            this.mContentView.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.bNU.setDefaultBgResource(d.f.pic_share_default_applets);
            return;
        }
        this.bNU.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.bNU.setDefaultBgResource(d.f.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.bNU.setDefaultBgResource(d.f.pic_share_default_applets);
            }
        });
        this.bNU.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bDI != null) {
            if (!com.baidu.tieba.aiapps.a.H(this.bDI.id, this.bDI.link, "1191003900000000")) {
                if (!StringUtils.isNull(this.bDI.h5_url)) {
                    com.baidu.tbadk.browser.a.ar(getContext(), this.bDI.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, this.mForumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", this.bDI.name).bJ(VideoPlayActivityConfig.OBJ_ID, this.bDI.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        al.l(this, d.C0277d.cp_bg_line_e);
        this.bNS.setBorderColor(al.getColor(d.C0277d.cp_bg_line_d));
        this.bNS.setIsNight(this.mSkinType == 1);
        al.j(this.bNT, d.C0277d.cp_cont_f);
        al.j(this.mContentView, d.C0277d.cp_cont_b);
        this.bNU.setIsNight(this.mSkinType == 1);
    }
}
