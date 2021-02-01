package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private ImageView alA;
    private final ThreadAchievementShareInfo.ParamBean eHV;
    private TextView eID;
    private TextView eIE;
    private TextView eIF;
    private TextView eIG;
    private TbImageView eJe;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.eHV = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eHV != null && this.eHV.getVideo_info() != null && !TextUtils.isEmpty(this.eHV.getVideo_info().getThumbnail_url())) {
            this.eJe.startLoad(this.eHV.getVideo_info().getThumbnail_url(), 10, false);
            this.eIG.setText(au.eg(this.eHV.getAgree_num()));
            this.eID.setText(au.eg(this.eHV.getPost_num()));
        }
    }

    private void initUI() {
        this.eID = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eIE = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eIF = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eIG = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.eIG.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eID.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eIF.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eIE.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eJe = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eJe.setDefaultBgResource(R.color.transparent);
        this.eJe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eJe.setPlaceHolder(2);
        this.alA = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.alA.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
