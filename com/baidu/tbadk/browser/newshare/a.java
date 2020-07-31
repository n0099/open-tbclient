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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final ThreadAchievementShareInfo dJO;
    private final ThreadAchievementShareInfo.ParamBean dJP;
    private TextView dJQ;
    private TextView dJR;
    private TextView dJS;
    private TextView dJT;
    private TextView dJU;
    private TextView dJV;
    private TextView dJW;
    private TextView dJX;
    private TextView dJY;
    private View dJZ;
    private View dKa;
    private View dKb;
    private TbImageView dKc;
    private TbImageView dKd;
    private TbImageView dKe;
    private View dKf;
    private View dKg;
    private View dKh;
    private LinearLayout dKi;
    private ImageView dKj;
    private TextView dKk;
    private LinearLayout dKl;
    private ImageView dKm;
    private TextView dKn;
    private LinearLayout dKo;
    private ImageView dKp;
    private TextView dKq;
    private View dKr;
    private View dKs;
    private View dKt;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.dJO = threadAchievementShareInfo;
        this.dJP = threadAchievementShareInfo.getParams();
        if (this.dJP != null) {
            this.mThreadList = this.dJP.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.dJQ = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.dJR = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.dKc = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.dJS = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.dJZ = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.dJT = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.dJU = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.dKd = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.dJV = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.dKa = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.dJW = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.dJX = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.dKe = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.dJY = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.dKb = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.dKg = this.mRoot.findViewById(R.id.first_item_layout);
        this.dKh = this.mRoot.findViewById(R.id.second_item_layout);
        this.dKf = this.mRoot.findViewById(R.id.current_item_layout);
        this.dKt = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.dKs = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.dKr = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.dKi = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.dKj = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.dKk = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.dKl = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.dKm = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.dKn = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.dKo = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.dKp = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.dKq = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.dKc.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dKc.setConrers(15);
        this.dKc.setPlaceHolder(2);
        this.dKd.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dKd.setConrers(15);
        this.dKd.setPlaceHolder(2);
        this.dKe.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dKe.setConrers(15);
        this.dKe.setPlaceHolder(2);
        this.dJR.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dJU.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dJX.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ao.setViewTextColor(this.dJQ, R.color.cp_cont_a);
        ao.setBackgroundResource(this.dJQ, R.drawable.cp_other_d_round_bg);
        ao.setBackgroundResource(this.dJZ, R.drawable.cp_other_b_alpha20_round_bg);
        ao.setViewTextColor(this.dJR, R.color.cp_cont_b);
        ao.setViewTextColor(this.dJS, R.color.cp_other_d);
        ao.setViewTextColor(this.dJT, R.color.cp_cont_a);
        ao.setBackgroundResource(this.dJT, R.drawable.cp_link_tip_d_round_bg);
        ao.setBackgroundResource(this.dKa, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ao.setViewTextColor(this.dJU, R.color.cp_cont_b);
        ao.setViewTextColor(this.dJV, R.color.cp_link_tip_d);
        ao.setViewTextColor(this.dJW, R.color.cp_cont_a);
        ao.setBackgroundResource(this.dJW, R.drawable.cp_link_tip_d_round_bg);
        ao.setBackgroundResource(this.dKb, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ao.setViewTextColor(this.dJX, R.color.cp_cont_b);
        ao.setViewTextColor(this.dJY, R.color.cp_link_tip_d);
        ao.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.e.a.bbq().mj(1).ml(0).mq(ao.lL(R.color.cp_bg_line_d)).mm(ao.lL(R.color.cp_shadow_a_alpha33)).mk(UIMsg.k_event.MV_MAP_CHANGETO2D).mn(l.getDimens(this.mContext, R.dimen.tbds16)).mo(0).mp(l.getDimens(this.mContext, R.dimen.tbds5)).aX(this.dKf);
        this.dKj.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dKm.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dKp.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        ao.setViewTextColor(this.dKk, R.color.cp_cont_a);
        ao.setViewTextColor(this.dKn, R.color.cp_cont_a);
        ao.setViewTextColor(this.dKq, R.color.cp_cont_a);
    }

    private void initData() {
        if (this.dJP != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.dJP.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.dKf.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dKh.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.dKg.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.dKf.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ao.setBackgroundColor(this.dJW, R.color.cp_other_d);
                ao.setViewTextColor(this.dJY, R.color.cp_other_d);
                ao.setBackgroundColor(this.dKb, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.dKf.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.dKh.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dKg.setVisibility(0);
        this.dJQ.setText(String.valueOf(i));
        this.dJR.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dJZ.setVisibility(0);
            this.dJS.setText("热度 " + as.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dKi.setVisibility(0);
            this.dKt.setVisibility(0);
            this.dKk.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dKc.setVisibility(0);
            this.dKc.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dKc.setVisibility(8);
        this.dKi.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dJR.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dKh.setVisibility(0);
        this.dJT.setText(String.valueOf(i));
        this.dJU.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dKa.setVisibility(0);
            this.dJV.setText("热度 " + as.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dKl.setVisibility(0);
            this.dKs.setVisibility(0);
            this.dKn.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dKd.setVisibility(0);
            this.dKd.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dKd.setVisibility(8);
        this.dKl.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dJU.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dKf.setVisibility(0);
        this.dJW.setText(String.valueOf(i));
        this.dJX.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dKb.setVisibility(0);
            this.dJY.setText("热度 " + as.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dKo.setVisibility(0);
            this.dKr.setVisibility(0);
            this.dKq.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dKe.setVisibility(0);
            this.dKe.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dKe.setVisibility(8);
        this.dKo.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dJX.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
