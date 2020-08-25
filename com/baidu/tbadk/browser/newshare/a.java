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
/* loaded from: classes2.dex */
public class a {
    private final ThreadAchievementShareInfo dSW;
    private final ThreadAchievementShareInfo.ParamBean dSX;
    private TextView dSY;
    private TextView dSZ;
    private View dTA;
    private View dTB;
    private TextView dTa;
    private TextView dTb;
    private TextView dTc;
    private TextView dTd;
    private TextView dTe;
    private TextView dTf;
    private TextView dTg;
    private View dTh;
    private View dTi;
    private View dTj;
    private TbImageView dTk;
    private TbImageView dTl;
    private TbImageView dTm;
    private View dTn;
    private View dTo;
    private View dTp;
    private LinearLayout dTq;
    private ImageView dTr;
    private TextView dTs;
    private LinearLayout dTt;
    private ImageView dTu;
    private TextView dTv;
    private LinearLayout dTw;
    private ImageView dTx;
    private TextView dTy;
    private View dTz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.dSW = threadAchievementShareInfo;
        this.dSX = threadAchievementShareInfo.getParams();
        if (this.dSX != null) {
            this.mThreadList = this.dSX.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.dSY = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.dSZ = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.dTk = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.dTa = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.dTh = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.dTb = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.dTc = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.dTl = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.dTd = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.dTi = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.dTe = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.dTf = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.dTm = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.dTg = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.dTj = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.dTo = this.mRoot.findViewById(R.id.first_item_layout);
        this.dTp = this.mRoot.findViewById(R.id.second_item_layout);
        this.dTn = this.mRoot.findViewById(R.id.current_item_layout);
        this.dTB = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.dTA = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.dTz = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.dTq = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.dTr = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.dTs = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.dTt = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.dTu = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.dTv = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.dTw = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.dTx = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.dTy = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.dTk.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dTk.setConrers(15);
        this.dTk.setPlaceHolder(2);
        this.dTl.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dTl.setConrers(15);
        this.dTl.setPlaceHolder(2);
        this.dTm.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dTm.setConrers(15);
        this.dTm.setPlaceHolder(2);
        this.dSZ.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dTc.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dTf.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.dSY, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dSY, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.dTh, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.dSZ, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTa, R.color.cp_other_d);
        ap.setViewTextColor(this.dTb, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dTb, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.dTi, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.dTc, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTd, R.color.cp_link_tip_d);
        ap.setViewTextColor(this.dTe, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dTe, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.dTj, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.dTf, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTg, R.color.cp_link_tip_d);
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.bjP().on(1).op(0).ou(ap.nS(R.color.cp_bg_line_d)).oq(ap.nS(R.color.cp_shadow_a_alpha33)).oo(4112).or(l.getDimens(this.mContext, R.dimen.tbds16)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(this.dTn);
        this.dTr.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dTu.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dTx.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.dTs, R.color.cp_cont_a);
        ap.setViewTextColor(this.dTv, R.color.cp_cont_a);
        ap.setViewTextColor(this.dTy, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.dSX != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.dSX.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.dTn.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTp.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.dTo.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.dTn.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.dTe, R.color.cp_other_d);
                ap.setViewTextColor(this.dTg, R.color.cp_other_d);
                ap.setBackgroundColor(this.dTj, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.dTn.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.dTp.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dTo.setVisibility(0);
        this.dSY.setText(String.valueOf(i));
        this.dSZ.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dTh.setVisibility(0);
            this.dTa.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dTq.setVisibility(0);
            this.dTB.setVisibility(0);
            this.dTs.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dTk.setVisibility(0);
            this.dTk.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dTk.setVisibility(8);
        this.dTq.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dSZ.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dTp.setVisibility(0);
        this.dTb.setText(String.valueOf(i));
        this.dTc.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dTi.setVisibility(0);
            this.dTd.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dTt.setVisibility(0);
            this.dTA.setVisibility(0);
            this.dTv.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dTl.setVisibility(0);
            this.dTl.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dTl.setVisibility(8);
        this.dTt.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTc.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dTn.setVisibility(0);
        this.dTe.setText(String.valueOf(i));
        this.dTf.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dTj.setVisibility(0);
            this.dTg.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dTw.setVisibility(0);
            this.dTz.setVisibility(0);
            this.dTy.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dTm.setVisibility(0);
            this.dTm.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dTm.setVisibility(8);
        this.dTw.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTf.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
