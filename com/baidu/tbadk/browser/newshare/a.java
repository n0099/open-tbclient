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
    private LinearLayout dTA;
    private ImageView dTB;
    private TextView dTC;
    private View dTD;
    private View dTE;
    private View dTF;
    private final ThreadAchievementShareInfo dTa;
    private final ThreadAchievementShareInfo.ParamBean dTb;
    private TextView dTc;
    private TextView dTd;
    private TextView dTe;
    private TextView dTf;
    private TextView dTg;
    private TextView dTh;
    private TextView dTi;
    private TextView dTj;
    private TextView dTk;
    private View dTl;
    private View dTm;
    private View dTn;
    private TbImageView dTo;
    private TbImageView dTp;
    private TbImageView dTq;
    private View dTr;
    private View dTs;
    private View dTt;
    private LinearLayout dTu;
    private ImageView dTv;
    private TextView dTw;
    private LinearLayout dTx;
    private ImageView dTy;
    private TextView dTz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.dTa = threadAchievementShareInfo;
        this.dTb = threadAchievementShareInfo.getParams();
        if (this.dTb != null) {
            this.mThreadList = this.dTb.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.dTc = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.dTd = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.dTo = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.dTe = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.dTl = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.dTf = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.dTg = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.dTp = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.dTh = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.dTm = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.dTi = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.dTj = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.dTq = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.dTk = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.dTn = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.dTs = this.mRoot.findViewById(R.id.first_item_layout);
        this.dTt = this.mRoot.findViewById(R.id.second_item_layout);
        this.dTr = this.mRoot.findViewById(R.id.current_item_layout);
        this.dTF = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.dTE = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.dTD = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.dTu = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.dTv = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.dTw = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.dTx = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.dTy = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.dTz = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.dTA = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.dTB = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.dTC = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.dTo.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dTo.setConrers(15);
        this.dTo.setPlaceHolder(2);
        this.dTp.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dTp.setConrers(15);
        this.dTp.setPlaceHolder(2);
        this.dTq.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dTq.setConrers(15);
        this.dTq.setPlaceHolder(2);
        this.dTd.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dTg.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dTj.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTc, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dTc, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.dTl, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.dTd, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTe, R.color.cp_other_d);
        ap.setViewTextColor(this.dTf, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dTf, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.dTm, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.dTg, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTh, R.color.cp_link_tip_d);
        ap.setViewTextColor(this.dTi, R.color.cp_cont_a);
        ap.setBackgroundResource(this.dTi, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.dTn, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.dTj, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTk, R.color.cp_link_tip_d);
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.bjP().on(1).op(0).ou(ap.nS(R.color.cp_bg_line_d)).oq(ap.nS(R.color.cp_shadow_a_alpha33)).oo(4112).or(l.getDimens(this.mContext, R.dimen.tbds16)).os(0).ot(l.getDimens(this.mContext, R.dimen.tbds5)).aZ(this.dTr);
        this.dTv.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dTy.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dTB.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.dTw, R.color.cp_cont_a);
        ap.setViewTextColor(this.dTz, R.color.cp_cont_a);
        ap.setViewTextColor(this.dTC, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.dTb != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.dTb.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.dTr.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTt.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.dTs.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.dTr.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.dTi, R.color.cp_other_d);
                ap.setViewTextColor(this.dTk, R.color.cp_other_d);
                ap.setBackgroundColor(this.dTn, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.dTr.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.dTt.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dTs.setVisibility(0);
        this.dTc.setText(String.valueOf(i));
        this.dTd.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dTl.setVisibility(0);
            this.dTe.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dTu.setVisibility(0);
            this.dTF.setVisibility(0);
            this.dTw.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dTo.setVisibility(0);
            this.dTo.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dTo.setVisibility(8);
        this.dTu.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTd.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dTt.setVisibility(0);
        this.dTf.setText(String.valueOf(i));
        this.dTg.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dTm.setVisibility(0);
            this.dTh.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dTx.setVisibility(0);
            this.dTE.setVisibility(0);
            this.dTz.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dTp.setVisibility(0);
            this.dTp.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dTp.setVisibility(8);
        this.dTx.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTg.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dTr.setVisibility(0);
        this.dTi.setText(String.valueOf(i));
        this.dTj.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dTn.setVisibility(0);
            this.dTk.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dTA.setVisibility(0);
            this.dTD.setVisibility(0);
            this.dTC.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dTq.setVisibility(0);
            this.dTq.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dTq.setVisibility(8);
        this.dTA.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTj.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
