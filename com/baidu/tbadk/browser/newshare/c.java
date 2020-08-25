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
/* loaded from: classes2.dex */
public class c {
    private ImageView aka;
    private final ThreadAchievementShareInfo.ParamBean dSX;
    private TextView dTF;
    private TextView dTG;
    private TextView dTH;
    private TextView dTI;
    private TbImageView dUg;
    private final Context mContext;
    private final View mRoot;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.dSX = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dSX != null && this.dSX.getVideo_info() != null && !TextUtils.isEmpty(this.dSX.getVideo_info().getThumbnail_url())) {
            this.dUg.startLoad(this.dSX.getVideo_info().getThumbnail_url(), 10, false);
            this.dTI.setText(at.cU(this.dSX.getAgree_num()));
            this.dTF.setText(at.cU(this.dSX.getPost_num()));
        }
    }

    private void initUI() {
        this.dTF = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dTG = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dTH = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dTI = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.dTI.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTF.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTH.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dTG.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dUg = (TbImageView) this.mRoot.findViewById(R.id.video_img);
        this.dUg.setDefaultBgResource(R.color.transparent);
        this.dUg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dUg.setPlaceHolder(2);
        this.aka = (ImageView) this.mRoot.findViewById(R.id.play_icon);
        this.aka.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
    }

    public View getView() {
        return this.mRoot;
    }
}
