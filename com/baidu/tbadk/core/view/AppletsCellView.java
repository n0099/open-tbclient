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
    private String amC;
    private TextView cTD;
    private SmartApp eTr;
    private HeadImageView feI;
    private TextView feJ;
    private TbImageView feK;
    private HeadImageView feL;
    private TextView feM;
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
        this.feI = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.feJ = (TextView) findViewById(R.id.applets_app_name);
        this.cTD = (TextView) findViewById(R.id.applets_app_content);
        this.feK = (TbImageView) findViewById(R.id.applets_app_img);
        this.feL = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.feM = (TextView) findViewById(R.id.applets_app_type_name);
        this.feI.setIsRound(true);
        this.feI.setIsPreDrawBorder(true);
        this.feI.setDrawBorder(true);
        this.feI.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.feI.setDefaultResource(R.color.CAM_X0205);
        this.feI.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.feK.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.feK.setLayoutParams(layoutParams);
        this.feK.setConrers(15);
        setOnClickListener(this);
        this.feL.setIsRound(true);
        this.feL.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.amC = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eTr = smartApp;
        this.feI.startLoad(smartApp.avatar, 10, false);
        this.feJ.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cTD.setVisibility(8);
        } else {
            this.cTD.setVisibility(0);
            this.cTD.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.feK.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.feK.setEvent(new TbImageView.b() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.feK.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
                AppletsCellView.this.feK.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.feK.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eTr != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eTr.id, this.eTr.link, "1191003900000000", this.eTr.is_game)) {
                if (!StringUtils.isNull(this.eTr.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eTr.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new ar("c13274").dR("fid", this.mForumId).dR("tid", this.amC).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", this.eTr.name).v("obj_id", this.eTr.swan_app_id.longValue()).dR("obj_source", this.mFrom).ap("obj_param1", this.eTr.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.feI.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.feI.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.feJ, R.color.CAM_X0105);
        ap.setViewTextColor(this.cTD, R.color.CAM_X0105);
        this.feK.setIsNight(this.mSkinType == 1);
        this.feL.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.feL.setBorderColor(ap.getColor(R.color.CAM_X0201));
        this.feL.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.feM, R.color.CAM_X0109);
    }
}
