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
    private ImageView akT;
    private TextView ehV;
    private TextView ehW;
    private TextView ehX;
    private TextView ehY;
    private final ThreadAchievementShareInfo.ParamBean ehn;
    private TbImageView eiw;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.ehn = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.ehn != null && this.ehn.getVideo_info() != null && !TextUtils.isEmpty(this.ehn.getVideo_info().getThumbnail_url())) {
            this.eiw.startLoad(this.ehn.getVideo_info().getThumbnail_url(), 10, false);
            this.ehY.setText(at.dd(this.ehn.getAgree_num()));
            this.ehV.setText(at.dd(this.ehn.getPost_num()));
        }
    }

    private void initUI() {
        this.ehV = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.ehW = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.ehX = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.ehY = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.ehY.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ehV.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ehX.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ehW.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.eiw = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eiw.setDefaultBgResource(R.color.transparent);
        this.eiw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eiw.setPlaceHolder(2);
        this.akT = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.akT.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
