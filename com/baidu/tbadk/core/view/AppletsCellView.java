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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String anD;
    private TextView cWc;
    private SmartApp eVQ;
    private HeadImageView fhb;
    private TextView fhc;
    private TbImageView fhd;
    private HeadImageView fhe;
    private TextView fhf;
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
        this.fhb = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.fhc = (TextView) findViewById(R.id.applets_app_name);
        this.cWc = (TextView) findViewById(R.id.applets_app_content);
        this.fhd = (TbImageView) findViewById(R.id.applets_app_img);
        this.fhe = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.fhf = (TextView) findViewById(R.id.applets_app_type_name);
        this.fhb.setIsRound(true);
        this.fhb.setIsPreDrawBorder(true);
        this.fhb.setDrawBorder(true);
        this.fhb.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.fhb.setDefaultResource(R.color.CAM_X0205);
        this.fhb.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.fhd.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.fhd.setLayoutParams(layoutParams);
        this.fhd.setConrers(15);
        setOnClickListener(this);
        this.fhe.setIsRound(true);
        this.fhe.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.anD = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eVQ = smartApp;
        this.fhb.startLoad(smartApp.avatar, 10, false);
        this.fhc.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cWc.setVisibility(8);
        } else {
            this.cWc.setVisibility(0);
            this.cWc.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.fhd.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.fhd.setEvent(new TbImageView.b() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.fhd.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
                AppletsCellView.this.fhd.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.fhd.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eVQ != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eVQ.id, this.eVQ.link, "1191003900000000", this.eVQ.is_game)) {
                if (!StringUtils.isNull(this.eVQ.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eVQ.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dX("fid", this.mForumId).dX("tid", this.anD).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_name", this.eVQ.name).w("obj_id", this.eVQ.swan_app_id.longValue()).dX("obj_source", this.mFrom).an("obj_param1", this.eVQ.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.fhb.setBorderColor(ao.getColor(R.color.CAM_X0201));
        this.fhb.setIsNight(this.mSkinType == 1);
        ao.setViewTextColor(this.fhc, R.color.CAM_X0105);
        ao.setViewTextColor(this.cWc, R.color.CAM_X0105);
        this.fhd.setIsNight(this.mSkinType == 1);
        this.fhe.setImageDrawable(ao.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.fhe.setBorderColor(ao.getColor(R.color.CAM_X0201));
        this.fhe.setIsNight(this.mSkinType == 1);
        ao.setViewTextColor(this.fhf, R.color.CAM_X0109);
    }
}
