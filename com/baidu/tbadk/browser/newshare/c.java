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
    private ImageView alZ;
    private final ThreadAchievementShareInfo.ParamBean eAX;
    private TextView eBF;
    private TextView eBG;
    private TextView eBH;
    private TextView eBI;
    private TbImageView eCg;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.eAX = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eAX != null && this.eAX.getVideo_info() != null && !TextUtils.isEmpty(this.eAX.getVideo_info().getThumbnail_url())) {
            this.eCg.startLoad(this.eAX.getVideo_info().getThumbnail_url(), 10, false);
            this.eBI.setText(au.ea(this.eAX.getAgree_num()));
            this.eBF.setText(au.ea(this.eAX.getPost_num()));
        }
    }

    private void initUI() {
        this.eBF = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eBG = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eBH = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eBI = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.eBI.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eBF.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eBH.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eBG.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eCg = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eCg.setDefaultBgResource(R.color.transparent);
        this.eCg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eCg.setPlaceHolder(2);
        this.alZ = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.alZ.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
