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
    private String alZ;
    private TextView cKm;
    private SmartApp eEU;
    private HeadImageView eQl;
    private TextView eQm;
    private TbImageView eQn;
    private HeadImageView eQo;
    private TextView eQp;
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
        this.eQl = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eQm = (TextView) findViewById(R.id.applets_app_name);
        this.cKm = (TextView) findViewById(R.id.applets_app_content);
        this.eQn = (TbImageView) findViewById(R.id.applets_app_img);
        this.eQo = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eQp = (TextView) findViewById(R.id.applets_app_type_name);
        this.eQl.setIsRound(true);
        this.eQl.setIsPreDrawBorder(true);
        this.eQl.setDrawBorder(true);
        this.eQl.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eQl.setDefaultResource(R.color.CAM_X0205);
        this.eQl.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eQn.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eQn.setLayoutParams(layoutParams);
        this.eQn.setConrers(15);
        setOnClickListener(this);
        this.eQo.setIsRound(true);
        this.eQo.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.alZ = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eEU = smartApp;
        this.eQl.startLoad(smartApp.avatar, 10, false);
        this.eQm.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cKm.setVisibility(8);
        } else {
            this.cKm.setVisibility(0);
            this.cKm.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eQn.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eQn.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eQn.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eQn.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eQn.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eEU != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eEU.id, this.eEU.link, "1191003900000000", this.eEU.is_game)) {
                if (!StringUtils.isNull(this.eEU.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eEU.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new ar("c13274").dR("fid", this.mForumId).dR("tid", this.alZ).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", this.eEU.name).w("obj_id", this.eEU.swan_app_id.longValue()).dR("obj_source", this.mFrom).ak("obj_param1", this.eEU.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eQl.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.eQl.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eQm, R.color.CAM_X0105);
        ap.setViewTextColor(this.cKm, R.color.CAM_X0105);
        this.eQn.setIsNight(this.mSkinType == 1);
        this.eQo.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eQo.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.eQo.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eQp, R.color.CAM_X0109);
    }
}
