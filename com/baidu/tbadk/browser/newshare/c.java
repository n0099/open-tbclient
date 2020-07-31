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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private ImageView aiL;
    private final ThreadAchievementShareInfo.ParamBean dJP;
    private TextView dKA;
    private TbImageView dKY;
    private TextView dKx;
    private TextView dKy;
    private TextView dKz;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.dJP = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dJP != null && this.dJP.getVideo_info() != null && !TextUtils.isEmpty(this.dJP.getVideo_info().getThumbnail_url())) {
            this.dKY.startLoad(this.dJP.getVideo_info().getThumbnail_url(), 10, false);
            this.dKA.setText(as.cJ(this.dJP.getAgree_num()));
            this.dKx.setText(as.cJ(this.dJP.getPost_num()));
        }
    }

    private void initUI() {
        this.dKx = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dKy = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dKz = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dKA = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.dKA.setTextColor(ao.getColor(R.color.cp_other_d));
        this.dKx.setTextColor(ao.getColor(R.color.cp_other_d));
        this.dKz.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.dKy.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.dKY = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.dKY.setDefaultBgResource(R.color.transparent);
        this.dKY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dKY.setPlaceHolder(2);
        this.aiL = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.aiL.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
