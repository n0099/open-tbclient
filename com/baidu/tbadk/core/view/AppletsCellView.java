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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String anU;
    private TextView cVd;
    private SmartApp eUS;
    private HeadImageView fgh;
    private TextView fgi;
    private TbImageView fgj;
    private HeadImageView fgk;
    private TextView fgl;
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
        this.fgh = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.fgi = (TextView) findViewById(R.id.applets_app_name);
        this.cVd = (TextView) findViewById(R.id.applets_app_content);
        this.fgj = (TbImageView) findViewById(R.id.applets_app_img);
        this.fgk = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.fgl = (TextView) findViewById(R.id.applets_app_type_name);
        this.fgh.setIsRound(true);
        this.fgh.setIsPreDrawBorder(true);
        this.fgh.setDrawBorder(true);
        this.fgh.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.fgh.setDefaultResource(R.color.CAM_X0205);
        this.fgh.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.fgj.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.fgj.setLayoutParams(layoutParams);
        this.fgj.setConrers(15);
        setOnClickListener(this);
        this.fgk.setIsRound(true);
        this.fgk.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.anU = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eUS = smartApp;
        this.fgh.startLoad(smartApp.avatar, 10, false);
        this.fgi.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cVd.setVisibility(8);
        } else {
            this.cVd.setVisibility(0);
            this.cVd.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.fgj.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.fgj.setEvent(new TbImageView.b() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.fgj.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
                AppletsCellView.this.fgj.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.fgj.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eUS != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eUS.id, this.eUS.link, "1191003900000000", this.eUS.is_game)) {
                if (!StringUtils.isNull(this.eUS.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eUS.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new ar("c13274").dR("fid", this.mForumId).dR("tid", this.anU).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", this.eUS.name).v("obj_id", this.eUS.swan_app_id.longValue()).dR("obj_source", this.mFrom).aq("obj_param1", this.eUS.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.fgh.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.fgh.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.fgi, R.color.CAM_X0105);
        ap.setViewTextColor(this.cVd, R.color.CAM_X0105);
        this.fgj.setIsNight(this.mSkinType == 1);
        this.fgk.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.fgk.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.fgk.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.fgl, R.color.CAM_X0109);
    }
}
