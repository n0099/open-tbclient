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
    private final ThreadAchievementShareInfo epK;
    private final ThreadAchievementShareInfo.ParamBean epL;
    private TextView epM;
    private TextView epN;
    private TextView epO;
    private TextView epP;
    private TextView epQ;
    private TextView epR;
    private TextView epS;
    private TextView epT;
    private TextView epU;
    private View epV;
    private View epW;
    private View epX;
    private TbImageView epY;
    private TbImageView epZ;
    private TbImageView eqa;
    private View eqb;
    private View eqc;
    private View eqd;
    private LinearLayout eqe;
    private ImageView eqf;
    private TextView eqg;
    private LinearLayout eqh;
    private ImageView eqi;
    private TextView eqj;
    private LinearLayout eqk;
    private ImageView eql;
    private TextView eqm;
    private View eqn;
    private View eqo;
    private View eqp;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.epK = threadAchievementShareInfo;
        this.epL = threadAchievementShareInfo.getParams();
        if (this.epL != null) {
            this.mThreadList = this.epL.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.epM = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.epN = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.epY = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.epO = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.epV = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.epP = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.epQ = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.epZ = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.epR = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.epW = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.epS = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.epT = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.eqa = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.epU = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.epX = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eqc = this.mRoot.findViewById(R.id.first_item_layout);
        this.eqd = this.mRoot.findViewById(R.id.second_item_layout);
        this.eqb = this.mRoot.findViewById(R.id.current_item_layout);
        this.eqp = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.eqo = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eqn = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.eqe = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eqf = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.eqg = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eqh = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eqi = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eqj = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.eqk = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.eql = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.eqm = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.epY.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.epY.setConrers(15);
        this.epY.setPlaceHolder(2);
        this.epZ.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.epZ.setConrers(15);
        this.epZ.setPlaceHolder(2);
        this.eqa.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eqa.setConrers(15);
        this.eqa.setPlaceHolder(2);
        this.epN.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.epQ.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.epT.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.epM, R.color.cp_cont_a);
        ap.setBackgroundResource(this.epM, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.epV, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.epN, R.color.cp_cont_b);
        ap.setViewTextColor(this.epO, R.color.cp_other_d);
        ap.setViewTextColor(this.epP, R.color.cp_cont_a);
        ap.setBackgroundResource(this.epP, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.epW, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.epQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.epR, R.color.cp_link_tip_d);
        ap.setViewTextColor(this.epS, R.color.cp_cont_a);
        ap.setBackgroundResource(this.epS, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.epX, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.epT, R.color.cp_cont_b);
        ap.setViewTextColor(this.epU, R.color.cp_link_tip_d);
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.bpn().pi(1).pk(0).pq(ap.oM(R.color.cp_bg_line_d)).pl(ap.oM(R.color.cp_shadow_a_alpha33)).pj(4112).pm(l.getDimens(this.mContext, R.dimen.tbds16)).po(0).pp(l.getDimens(this.mContext, R.dimen.tbds5)).bg(this.eqb);
        this.eqf.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.eqi.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.eql.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.eqg, R.color.cp_cont_a);
        ap.setViewTextColor(this.eqj, R.color.cp_cont_a);
        ap.setViewTextColor(this.eqm, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.epL != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.epL.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eqb.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqd.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eqc.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eqb.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.epS, R.color.cp_other_d);
                ap.setViewTextColor(this.epU, R.color.cp_other_d);
                ap.setBackgroundColor(this.epX, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eqb.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eqd.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eqc.setVisibility(0);
        this.epM.setText(String.valueOf(i));
        this.epN.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.epV.setVisibility(0);
            this.epO.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eqe.setVisibility(0);
            this.eqp.setVisibility(0);
            this.eqg.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.epY.setVisibility(0);
            this.epY.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.epY.setVisibility(8);
        this.eqe.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.epN.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eqd.setVisibility(0);
        this.epP.setText(String.valueOf(i));
        this.epQ.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.epW.setVisibility(0);
            this.epR.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eqh.setVisibility(0);
            this.eqo.setVisibility(0);
            this.eqj.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.epZ.setVisibility(0);
            this.epZ.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.epZ.setVisibility(8);
        this.eqh.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.epQ.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eqb.setVisibility(0);
        this.epS.setText(String.valueOf(i));
        this.epT.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.epX.setVisibility(0);
            this.epU.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eqk.setVisibility(0);
            this.eqn.setVisibility(0);
            this.eqm.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eqa.setVisibility(0);
            this.eqa.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eqa.setVisibility(8);
        this.eqk.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.epT.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
