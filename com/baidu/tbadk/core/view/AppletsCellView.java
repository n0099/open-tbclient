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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {
    private String alS;
    private TextView cxH;
    private HeadImageView eCZ;
    private TextView eDa;
    private TbImageView eDb;
    private HeadImageView eDc;
    private TextView eDd;
    private SmartApp esn;
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
        this.eCZ = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.eDa = (TextView) findViewById(R.id.applets_app_name);
        this.cxH = (TextView) findViewById(R.id.applets_app_content);
        this.eDb = (TbImageView) findViewById(R.id.applets_app_img);
        this.eDc = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.eDd = (TextView) findViewById(R.id.applets_app_type_name);
        this.eCZ.setIsRound(true);
        this.eCZ.setIsPreDrawBorder(true);
        this.eCZ.setDrawBorder(true);
        this.eCZ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.eCZ.setDefaultResource(R.color.cp_bg_line_e);
        this.eCZ.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.eDb.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.eDb.setLayoutParams(layoutParams);
        this.eDb.setConrers(15);
        setOnClickListener(this);
        this.eDc.setIsRound(true);
        this.eDc.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.alS = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.esn = smartApp;
        this.eCZ.startLoad(smartApp.avatar, 10, false);
        this.eDa.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cxH.setVisibility(8);
        } else {
            this.cxH.setVisibility(0);
            this.cxH.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.eDb.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.eDb.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.eDb.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                AppletsCellView.this.eDb.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.eDb.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.esn != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.esn.id, this.esn.link, "1191003900000000", this.esn.is_game)) {
                if (!StringUtils.isNull(this.esn.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.esn.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dK("fid", this.mForumId).dK("tid", this.alS).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("obj_name", this.esn.name).u("obj_id", this.esn.swan_app_id.longValue()).dK("obj_source", this.mFrom).aj("obj_param1", this.esn.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.eCZ.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eCZ.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eDa, R.color.cp_cont_b);
        ap.setViewTextColor(this.cxH, R.color.cp_cont_b);
        this.eDb.setIsNight(this.mSkinType == 1);
        this.eDc.setImageDrawable(ap.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.eDc.setBorderColor(ap.getColor(R.color.cp_bg_line_d));
        this.eDc.setIsNight(this.mSkinType == 1);
        ap.setViewTextColor(this.eDd, R.color.cp_cont_d);
    }
}
