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
    private ImageView akU;
    private final ThreadAchievementShareInfo.ParamBean evE;
    private TbImageView ewN;
    private TextView ewm;
    private TextView ewn;
    private TextView ewo;
    private TextView ewp;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.evE = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.evE != null && this.evE.getVideo_info() != null && !TextUtils.isEmpty(this.evE.getVideo_info().getThumbnail_url())) {
            this.ewN.startLoad(this.evE.getVideo_info().getThumbnail_url(), 10, false);
            this.ewp.setText(at.dB(this.evE.getAgree_num()));
            this.ewm.setText(at.dB(this.evE.getPost_num()));
        }
    }

    private void initUI() {
        this.ewm = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.ewn = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.ewo = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.ewp = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.ewp.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ewm.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ewo.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ewn.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ewN = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.ewN.setDefaultBgResource(R.color.transparent);
        this.ewN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ewN.setPlaceHolder(2);
        this.akU = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.akU.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
