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
    private ImageView akB;
    private TextView dVT;
    private TextView dVU;
    private TextView dVV;
    private TextView dVW;
    private final ThreadAchievementShareInfo.ParamBean dVl;
    private TbImageView dWu;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.dVl = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dVl != null && this.dVl.getVideo_info() != null && !TextUtils.isEmpty(this.dVl.getVideo_info().getThumbnail_url())) {
            this.dWu.startLoad(this.dVl.getVideo_info().getThumbnail_url(), 10, false);
            this.dVW.setText(at.cV(this.dVl.getAgree_num()));
            this.dVT.setText(at.cV(this.dVl.getPost_num()));
        }
    }

    private void initUI() {
        this.dVT = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dVU = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dVV = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dVW = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.dVW.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dVT.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dVV.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dVU.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dWu = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.dWu.setDefaultBgResource(R.color.transparent);
        this.dWu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dWu.setPlaceHolder(2);
        this.akB = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.akB.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
