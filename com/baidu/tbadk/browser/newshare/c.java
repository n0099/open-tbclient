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
    private ImageView amS;
    private final ThreadAchievementShareInfo.ParamBean eJw;
    private TbImageView eKF;
    private TextView eKe;
    private TextView eKf;
    private TextView eKg;
    private TextView eKh;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.eJw = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eJw != null && this.eJw.getVideo_info() != null && !TextUtils.isEmpty(this.eJw.getVideo_info().getThumbnail_url())) {
            this.eKF.startLoad(this.eJw.getVideo_info().getThumbnail_url(), 10, false);
            this.eKh.setText(au.eg(this.eJw.getAgree_num()));
            this.eKe.setText(au.eg(this.eJw.getPost_num()));
        }
    }

    private void initUI() {
        this.eKe = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eKf = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eKg = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eKh = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.eKh.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eKe.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eKg.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eKf.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eKF = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eKF.setDefaultBgResource(R.color.transparent);
        this.eKF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKF.setPlaceHolder(2);
        this.amS = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.amS.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
