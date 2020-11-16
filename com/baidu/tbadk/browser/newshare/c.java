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
    private ImageView akY;
    private final ThreadAchievementShareInfo.ParamBean etV;
    private TextView euD;
    private TextView euE;
    private TextView euF;
    private TextView euG;
    private TbImageView eve;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.etV = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.etV != null && this.etV.getVideo_info() != null && !TextUtils.isEmpty(this.etV.getVideo_info().getThumbnail_url())) {
            this.eve.startLoad(this.etV.getVideo_info().getThumbnail_url(), 10, false);
            this.euG.setText(au.dB(this.etV.getAgree_num()));
            this.euD.setText(au.dB(this.etV.getPost_num()));
        }
    }

    private void initUI() {
        this.euD = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.euE = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.euF = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.euG = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.euG.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.euD.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.euF.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.euE.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eve = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.eve.setDefaultBgResource(R.color.transparent);
        this.eve.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eve.setPlaceHolder(2);
        this.akY = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.akY.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
