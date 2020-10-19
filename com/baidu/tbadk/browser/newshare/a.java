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
    private TbImageView ehA;
    private TbImageView ehB;
    private TbImageView ehC;
    private View ehD;
    private View ehE;
    private View ehF;
    private LinearLayout ehG;
    private ImageView ehH;
    private TextView ehI;
    private LinearLayout ehJ;
    private ImageView ehK;
    private TextView ehL;
    private LinearLayout ehM;
    private ImageView ehN;
    private TextView ehO;
    private View ehP;
    private View ehQ;
    private View ehR;
    private final ThreadAchievementShareInfo ehm;
    private final ThreadAchievementShareInfo.ParamBean ehn;
    private TextView eho;
    private TextView ehp;
    private TextView ehq;
    private TextView ehr;
    private TextView ehs;
    private TextView eht;
    private TextView ehu;
    private TextView ehv;
    private TextView ehw;
    private View ehx;
    private View ehy;
    private View ehz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.ehm = threadAchievementShareInfo;
        this.ehn = threadAchievementShareInfo.getParams();
        if (this.ehn != null) {
            this.mThreadList = this.ehn.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.eho = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.ehp = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.ehA = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.ehq = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.ehx = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.ehr = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.ehs = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.ehB = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eht = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.ehy = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.ehu = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.ehv = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.ehC = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.ehw = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.ehz = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.ehE = this.mRoot.findViewById(R.id.first_item_layout);
        this.ehF = this.mRoot.findViewById(R.id.second_item_layout);
        this.ehD = this.mRoot.findViewById(R.id.current_item_layout);
        this.ehR = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.ehQ = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.ehP = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.ehG = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.ehH = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.ehI = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.ehJ = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.ehK = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.ehL = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.ehM = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.ehN = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.ehO = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.ehA.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ehA.setConrers(15);
        this.ehA.setPlaceHolder(2);
        this.ehB.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ehB.setConrers(15);
        this.ehB.setPlaceHolder(2);
        this.ehC.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ehC.setConrers(15);
        this.ehC.setPlaceHolder(2);
        this.ehp.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.ehs.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.ehv.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ap.setViewTextColor(this.eho, R.color.cp_cont_a);
        ap.setBackgroundResource(this.eho, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.ehx, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.ehp, R.color.cp_cont_b);
        ap.setViewTextColor(this.ehq, R.color.cp_other_d);
        ap.setViewTextColor(this.ehr, R.color.cp_cont_a);
        ap.setBackgroundResource(this.ehr, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.ehy, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.ehs, R.color.cp_cont_b);
        ap.setViewTextColor(this.eht, R.color.cp_link_tip_d);
        ap.setViewTextColor(this.ehu, R.color.cp_cont_a);
        ap.setBackgroundResource(this.ehu, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.ehz, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.ehv, R.color.cp_cont_b);
        ap.setViewTextColor(this.ehw, R.color.cp_link_tip_d);
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.bnu().oX(1).oZ(0).pe(ap.oB(R.color.cp_bg_line_d)).pa(ap.oB(R.color.cp_shadow_a_alpha33)).oY(4112).pb(l.getDimens(this.mContext, R.dimen.tbds16)).pc(0).pd(l.getDimens(this.mContext, R.dimen.tbds5)).bf(this.ehD);
        this.ehH.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.ehK.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.ehN.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.ehI, R.color.cp_cont_a);
        ap.setViewTextColor(this.ehL, R.color.cp_cont_a);
        ap.setViewTextColor(this.ehO, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.ehn != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.ehn.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.ehD.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehF.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.ehE.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.ehD.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.ehu, R.color.cp_other_d);
                ap.setViewTextColor(this.ehw, R.color.cp_other_d);
                ap.setBackgroundColor(this.ehz, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.ehD.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.ehF.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.ehE.setVisibility(0);
        this.eho.setText(String.valueOf(i));
        this.ehp.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.ehx.setVisibility(0);
            this.ehq.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.ehG.setVisibility(0);
            this.ehR.setVisibility(0);
            this.ehI.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.ehA.setVisibility(0);
            this.ehA.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.ehA.setVisibility(8);
        this.ehG.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.ehp.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.ehF.setVisibility(0);
        this.ehr.setText(String.valueOf(i));
        this.ehs.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.ehy.setVisibility(0);
            this.eht.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.ehJ.setVisibility(0);
            this.ehQ.setVisibility(0);
            this.ehL.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.ehB.setVisibility(0);
            this.ehB.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.ehB.setVisibility(8);
        this.ehJ.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.ehs.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.ehD.setVisibility(0);
        this.ehu.setText(String.valueOf(i));
        this.ehv.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.ehz.setVisibility(0);
            this.ehw.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.ehM.setVisibility(0);
            this.ehP.setVisibility(0);
            this.ehO.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.ehC.setVisibility(0);
            this.ehC.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.ehC.setVisibility(8);
        this.ehM.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.ehv.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
