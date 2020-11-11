package com.baidu.tbadk.browser.newshare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final ThreadAchievementShareInfo evD;
    private final ThreadAchievementShareInfo.ParamBean evE;
    private TextView evF;
    private TextView evG;
    private TextView evH;
    private TextView evI;
    private TextView evJ;
    private TextView evK;
    private TextView evL;
    private TextView evM;
    private TextView evN;
    private View evO;
    private View evP;
    private View evQ;
    private TbImageView evR;
    private TbImageView evS;
    private TbImageView evT;
    private View evU;
    private View evV;
    private View evW;
    private LinearLayout evX;
    private ImageView evY;
    private TextView evZ;
    private LinearLayout ewa;
    private ImageView ewb;
    private TextView ewc;
    private LinearLayout ewd;
    private ImageView ewe;
    private TextView ewf;
    private View ewg;
    private View ewh;
    private View ewi;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.evD = threadAchievementShareInfo;
        this.evE = threadAchievementShareInfo.getParams();
        if (this.evE != null) {
            this.mThreadList = this.evE.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.evF = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.evG = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.evR = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.evH = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.evO = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.evI = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.evJ = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.evS = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.evK = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.evP = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.evL = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.evM = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.evT = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.evN = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.evQ = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.evV = this.mRoot.findViewById(R.id.first_item_layout);
        this.evW = this.mRoot.findViewById(R.id.second_item_layout);
        this.evU = this.mRoot.findViewById(R.id.current_item_layout);
        this.ewi = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.ewh = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.ewg = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.evX = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.evY = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.evZ = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.ewa = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.ewb = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.ewc = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.ewd = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.ewe = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.ewf = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.evR.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.evR.setConrers(15);
        this.evR.setPlaceHolder(2);
        this.evS.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.evS.setConrers(15);
        this.evS.setPlaceHolder(2);
        this.evT.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.evT.setConrers(15);
        this.evT.setPlaceHolder(2);
        this.evG.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.evJ.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.evM.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.evF, R.color.cp_cont_a);
        ap.setBackgroundResource(this.evF, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.evO, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.evG, R.color.cp_cont_b);
        ap.setViewTextColor(this.evH, R.color.cp_other_d);
        ap.setViewTextColor(this.evI, R.color.cp_cont_a);
        ap.setBackgroundResource(this.evI, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.evP, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.evJ, R.color.cp_cont_b);
        ap.setViewTextColor(this.evK, R.color.cp_link_tip_d);
        ap.setViewTextColor(this.evL, R.color.cp_cont_a);
        ap.setBackgroundResource(this.evL, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.evQ, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.evM, R.color.cp_cont_b);
        ap.setViewTextColor(this.evN, R.color.cp_link_tip_d);
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.brN().pt(1).pv(0).pA(ap.oW(R.color.cp_bg_line_d)).pw(ap.oW(R.color.cp_shadow_a_alpha33)).pu(4112).px(l.getDimens(this.mContext, R.dimen.tbds16)).py(0).pz(l.getDimens(this.mContext, R.dimen.tbds5)).bk(this.evU);
        this.evY.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.ewb.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.ewe.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.evZ, R.color.cp_cont_a);
        ap.setViewTextColor(this.ewc, R.color.cp_cont_a);
        ap.setViewTextColor(this.ewf, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.evE != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.evE.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.evU.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evW.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.evV.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.evU.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.evL, R.color.cp_other_d);
                ap.setViewTextColor(this.evN, R.color.cp_other_d);
                ap.setBackgroundColor(this.evQ, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.evU.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.evW.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.evV.setVisibility(0);
        this.evF.setText(String.valueOf(i));
        this.evG.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.evO.setVisibility(0);
            this.evH.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.evX.setVisibility(0);
            this.ewi.setVisibility(0);
            this.evZ.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.evR.setVisibility(0);
            this.evR.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.evR.setVisibility(8);
        this.evX.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.evG.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.evW.setVisibility(0);
        this.evI.setText(String.valueOf(i));
        this.evJ.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.evP.setVisibility(0);
            this.evK.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.ewa.setVisibility(0);
            this.ewh.setVisibility(0);
            this.ewc.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.evS.setVisibility(0);
            this.evS.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.evS.setVisibility(8);
        this.ewa.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.evJ.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.evU.setVisibility(0);
        this.evL.setText(String.valueOf(i));
        this.evM.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.evQ.setVisibility(0);
            this.evN.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.ewd.setVisibility(0);
            this.ewg.setVisibility(0);
            this.ewf.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.evT.setVisibility(0);
            this.evT.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.evT.setVisibility(8);
        this.ewd.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.evM.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
