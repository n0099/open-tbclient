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
    private final ThreadAchievementShareInfo.ParamBean epL;
    private TbImageView eqU;
    private TextView eqt;
    private TextView equ;
    private TextView eqv;
    private TextView eqw;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.epL = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.epL != null && this.epL.getVideo_info() != null && !TextUtils.isEmpty(this.epL.getVideo_info().getThumbnail_url())) {
            this.eqU.startLoad(this.epL.getVideo_info().getThumbnail_url(), 10, false);
            this.eqw.setText(at.df(this.epL.getAgree_num()));
            this.eqt.setText(at.df(this.epL.getPost_num()));
        }
    }

    private void initUI() {
        this.eqt = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.equ = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eqv = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eqw = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.eqw.setTextColor(ap.getColor(R.color.cp_other_d));
        this.eqt.setTextColor(ap.getColor(R.color.cp_other_d));
        this.eqv.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.equ.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.eqU = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eqU.setDefaultBgResource(R.color.transparent);
        this.eqU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eqU.setPlaceHolder(2);
        this.akU = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.akU.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
