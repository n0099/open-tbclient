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
    private String amY;
    private TextView cRf;
    private SmartApp eLW;
    private HeadImageView eXA;
    private TextView eXB;
    private TbImageView eXC;
    private HeadImageView eXD;
    private TextView eXE;
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
        this.eXA = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eXB = (TextView) findViewById(R.id.applets_app_name);
        this.cRf = (TextView) findViewById(R.id.applets_app_content);
        this.eXC = (TbImageView) findViewById(R.id.applets_app_img);
        this.eXD = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eXE = (TextView) findViewById(R.id.applets_app_type_name);
        this.eXA.setIsRound(true);
        this.eXA.setIsPreDrawBorder(true);
        this.eXA.setDrawBorder(true);
        this.eXA.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eXA.setDefaultResource(R.color.CAM_X0205);
        this.eXA.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eXC.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eXC.setLayoutParams(layoutParams);
        this.eXC.setConrers(15);
        setOnClickListener(this);
        this.eXD.setIsRound(true);
        this.eXD.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.amY = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eLW = smartApp;
        this.eXA.startLoad(smartApp.avatar, 10, false);
        this.eXB.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cRf.setVisibility(8);
        } else {
            this.cRf.setVisibility(0);
            this.cRf.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eXC.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eXC.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eXC.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eXC.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eXC.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eLW != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eLW.id, this.eLW.link, "1191003900000000", this.eLW.is_game)) {
                if (!StringUtils.isNull(this.eLW.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eLW.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new ar("c13274").dY("fid", this.mForumId).dY("tid", this.amY).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("obj_name", this.eLW.name).w("obj_id", this.eLW.swan_app_id.longValue()).dY("obj_source", this.mFrom).al("obj_param1", this.eLW.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eXA.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.eXA.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eXB, R.color.CAM_X0105);
        ap.setViewTextColor(this.cRf, R.color.CAM_X0105);
        this.eXC.setIsNight(this.mSkinType == 1);
        this.eXD.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eXD.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.eXD.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eXE, R.color.CAM_X0109);
    }
}
