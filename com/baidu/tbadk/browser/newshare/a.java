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
    private TbImageView dVA;
    private View dVB;
    private View dVC;
    private View dVD;
    private LinearLayout dVE;
    private ImageView dVF;
    private TextView dVG;
    private LinearLayout dVH;
    private ImageView dVI;
    private TextView dVJ;
    private LinearLayout dVK;
    private ImageView dVL;
    private TextView dVM;
    private View dVN;
    private View dVO;
    private View dVP;
    private final ThreadAchievementShareInfo dVk;
    private final ThreadAchievementShareInfo.ParamBean dVl;
    private TextView dVm;
    private TextView dVn;
    private TextView dVo;
    private TextView dVp;
    private TextView dVq;
    private TextView dVr;
    private TextView dVs;
    private TextView dVt;
    private TextView dVu;
    private View dVv;
    private View dVw;
    private View dVx;
    private TbImageView dVy;
    private TbImageView dVz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.dVk = threadAchievementShareInfo;
        this.dVl = threadAchievementShareInfo.getParams();
        if (this.dVl != null) {
            this.mThreadList = this.dVl.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.dVm = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.dVn = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.dVy = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.dVo = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.dVv = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.dVp = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.dVq = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.dVz = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.dVr = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.dVw = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.dVs = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.dVt = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.dVA = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.dVu = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.dVx = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.dVC = this.mRoot.findViewById(R.id.first_item_layout);
        this.dVD = this.mRoot.findViewById(R.id.second_item_layout);
        this.dVB = this.mRoot.findViewById(R.id.current_item_layout);
        this.dVP = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.dVO = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.dVN = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.dVE = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.dVF = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.dVG = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.dVH = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.dVI = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.dVJ = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.dVK = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.dVL = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.dVM = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.dVy.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dVy.setConrers(15);
        this.dVy.setPlaceHolder(2);
        this.dVz.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dVz.setConrers(15);
        this.dVz.setPlaceHolder(2);
        this.dVA.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dVA.setConrers(15);
        this.dVA.setPlaceHolder(2);
        this.dVn.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dVq.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dVt.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.dVm, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dVm, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.dVv, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.dVn, R.color.cp_cont_b);
        ap.setViewTextColor(this.dVo, R.color.cp_other_d);
        ap.setViewTextColor(this.dVp, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dVp, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.dVw, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.dVq, R.color.cp_cont_b);
        ap.setViewTextColor(this.dVr, R.color.cp_link_tip_d);
        ap.setViewTextColor(this.dVs, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dVs, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.dVx, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.dVt, R.color.cp_cont_b);
        ap.setViewTextColor(this.dVu, R.color.cp_link_tip_d);
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.bkK().oz(1).oB(0).oG(ap.oe(R.color.cp_bg_line_d)).oC(ap.oe(R.color.cp_shadow_a_alpha33)).oA(4112).oD(l.getDimens(this.mContext, R.dimen.tbds16)).oE(0).oF(l.getDimens(this.mContext, R.dimen.tbds5)).bb(this.dVB);
        this.dVF.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dVI.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dVL.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.dVG, R.color.cp_cont_a);
        ap.setViewTextColor(this.dVJ, R.color.cp_cont_a);
        ap.setViewTextColor(this.dVM, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.dVl != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.dVl.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.dVB.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVD.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.dVC.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.dVB.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.dVs, R.color.cp_other_d);
                ap.setViewTextColor(this.dVu, R.color.cp_other_d);
                ap.setBackgroundColor(this.dVx, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.dVB.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.dVD.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dVC.setVisibility(0);
        this.dVm.setText(String.valueOf(i));
        this.dVn.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dVv.setVisibility(0);
            this.dVo.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dVE.setVisibility(0);
            this.dVP.setVisibility(0);
            this.dVG.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dVy.setVisibility(0);
            this.dVy.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dVy.setVisibility(8);
        this.dVE.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dVn.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dVD.setVisibility(0);
        this.dVp.setText(String.valueOf(i));
        this.dVq.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dVw.setVisibility(0);
            this.dVr.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dVH.setVisibility(0);
            this.dVO.setVisibility(0);
            this.dVJ.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dVz.setVisibility(0);
            this.dVz.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dVz.setVisibility(8);
        this.dVH.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dVq.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dVB.setVisibility(0);
        this.dVs.setText(String.valueOf(i));
        this.dVt.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dVx.setVisibility(0);
            this.dVu.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dVK.setVisibility(0);
            this.dVN.setVisibility(0);
            this.dVM.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dVA.setVisibility(0);
            this.dVA.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dVA.setVisibility(8);
        this.dVK.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dVt.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
