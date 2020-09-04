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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private ImageView akc;
    private TextView dTJ;
    private TextView dTK;
    private TextView dTL;
    private TextView dTM;
    private final ThreadAchievementShareInfo.ParamBean dTb;
    private TbImageView dUk;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.dTb = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dTb != null && this.dTb.getVideo_info() != null && !TextUtils.isEmpty(this.dTb.getVideo_info().getThumbnail_url())) {
            this.dUk.startLoad(this.dTb.getVideo_info().getThumbnail_url(), 10, false);
            this.dTM.setText(at.cU(this.dTb.getAgree_num()));
            this.dTJ.setText(at.cU(this.dTb.getPost_num()));
        }
    }

    private void initUI() {
        this.dTJ = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dTK = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dTL = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dTM = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.dTM.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTJ.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTL.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dTK.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dUk = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.dUk.setDefaultBgResource(R.color.transparent);
        this.dUk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dUk.setPlaceHolder(2);
        this.akc = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.akc.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
