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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private ImageView aiT;
    private final ThreadAchievementShareInfo.ParamBean dDS;
    private TextView dEA;
    private TextView dEB;
    private TextView dEC;
    private TextView dED;
    private TbImageView dFb;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.dDS = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dDS != null && this.dDS.getVideo_info() != null && !TextUtils.isEmpty(this.dDS.getVideo_info().getThumbnail_url())) {
            this.dFb.startLoad(this.dDS.getVideo_info().getThumbnail_url(), 10, false);
            this.dED.setText(ar.cq(this.dDS.getAgree_num()));
            this.dEA.setText(ar.cq(this.dDS.getPost_num()));
        }
    }

    private void initUI() {
        this.dEA = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dEB = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dEC = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dED = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.dED.setTextColor(an.getColor(R.color.cp_other_d));
        this.dEA.setTextColor(an.getColor(R.color.cp_other_d));
        this.dEC.setTextColor(an.getColor(R.color.cp_cont_b));
        this.dEB.setTextColor(an.getColor(R.color.cp_cont_b));
        this.dFb = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.dFb.setDefaultBgResource(R.color.transparent);
        this.dFb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dFb.setPlaceHolder(2);
        this.aiT = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.aiT.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
