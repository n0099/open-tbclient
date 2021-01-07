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
    private ImageView amB;
    private final ThreadAchievementShareInfo.ParamBean eKA;
    private TbImageView eLJ;
    private TextView eLi;
    private TextView eLj;
    private TextView eLk;
    private TextView eLl;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.eKA = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eKA != null && this.eKA.getVideo_info() != null && !TextUtils.isEmpty(this.eKA.getVideo_info().getThumbnail_url())) {
            this.eLJ.startLoad(this.eKA.getVideo_info().getThumbnail_url(), 10, false);
            this.eLl.setText(at.ea(this.eKA.getAgree_num()));
            this.eLi.setText(at.ea(this.eKA.getPost_num()));
        }
    }

    private void initUI() {
        this.eLi = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eLj = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eLk = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eLl = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.eLl.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eLi.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eLk.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eLj.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eLJ = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eLJ.setDefaultBgResource(R.color.transparent);
        this.eLJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eLJ.setPlaceHolder(2);
        this.amB = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.amB.setImageDrawable(SvgManager.bwr().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
