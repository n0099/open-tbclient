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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private ImageView alK;
    private final ThreadAchievementShareInfo.ParamBean eFP;
    private TextView eGA;
    private TbImageView eGY;
    private TextView eGx;
    private TextView eGy;
    private TextView eGz;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.eFP = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eFP != null && this.eFP.getVideo_info() != null && !TextUtils.isEmpty(this.eFP.getVideo_info().getThumbnail_url())) {
            this.eGY.startLoad(this.eFP.getVideo_info().getThumbnail_url(), 10, false);
            this.eGA.setText(at.ea(this.eFP.getAgree_num()));
            this.eGx.setText(at.ea(this.eFP.getPost_num()));
        }
    }

    private void initUI() {
        this.eGx = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eGy = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eGz = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eGA = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.eGA.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eGx.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eGz.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eGy.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eGY = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eGY.setDefaultBgResource(R.color.transparent);
        this.eGY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eGY.setPlaceHolder(2);
        this.alK = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.alK.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
