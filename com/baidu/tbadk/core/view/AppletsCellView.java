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
    private String amM;
    private TextView cRq;
    private SmartApp eRf;
    private HeadImageView fct;
    private TextView fcu;
    private TbImageView fcv;
    private HeadImageView fcw;
    private TextView fcx;
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
        this.fct = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.fcu = (TextView) findViewById(R.id.applets_app_name);
        this.cRq = (TextView) findViewById(R.id.applets_app_content);
        this.fcv = (TbImageView) findViewById(R.id.applets_app_img);
        this.fcw = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.fcx = (TextView) findViewById(R.id.applets_app_type_name);
        this.fct.setIsRound(true);
        this.fct.setIsPreDrawBorder(true);
        this.fct.setDrawBorder(true);
        this.fct.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1));
        this.fct.setDefaultResource(R.color.CAM_X0205);
        this.fct.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.fcv.getLayoutParams();
        layoutParams.height = ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.fcv.setLayoutParams(layoutParams);
        this.fcv.setConrers(15);
        setOnClickListener(this);
        this.fcw.setIsRound(true);
        this.fcw.setDrawBorder(false);
        onChangeSkinType();
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setThreadId(String str) {
        this.amM = str;
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eRf = smartApp;
        this.fct.startLoad(smartApp.avatar, 10, false);
        this.fcu.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.cRq.setVisibility(8);
        } else {
            this.cRq.setVisibility(0);
            this.cRq.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.fcv.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.fcv.setEvent(new TbImageView.b() { // from class: com.baidu.tbadk.core.view.AppletsCellView.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (!z) {
                    AppletsCellView.this.fcv.setDefaultBgResource(R.drawable.pic_share_default_applets);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
                AppletsCellView.this.fcv.setDefaultBgResource(R.drawable.pic_share_default_applets);
            }
        });
        this.fcv.startLoad(smartApp.pic, 10, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eRf != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.eRf.id, this.eRf.link, "1191003900000000", this.eRf.is_game)) {
                if (!StringUtils.isNull(this.eRf.h5_url)) {
                    com.baidu.tbadk.browser.a.startWebActivity(getContext(), this.eRf.h5_url);
                } else {
                    return;
                }
            }
            TiebaStatic.log(new aq("c13274").dW("fid", this.mForumId).dW("tid", this.amM).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("obj_name", this.eRf.name).w("obj_id", this.eRf.swan_app_id.longValue()).dW("obj_source", this.mFrom).an("obj_param1", this.eRf.is_game.intValue()));
        }
    }

    public void onChangeSkinType() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.fct.setBorderColor(ao.getColor(R.color.CAM_X0201));
        this.fct.setIsNight(this.mSkinType == 1);
        ao.setViewTextColor(this.fcu, R.color.CAM_X0105);
        ao.setViewTextColor(this.cRq, R.color.CAM_X0105);
        this.fcv.setIsNight(this.mSkinType == 1);
        this.fcw.setImageDrawable(ao.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.fcw.setBorderColor(ao.getColor(R.color.CAM_X0201));
        this.fcw.setIsNight(this.mSkinType == 1);
        ao.setViewTextColor(this.fcx, R.color.CAM_X0109);
    }
}
