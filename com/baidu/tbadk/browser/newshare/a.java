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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final ThreadAchievementShareInfo dDR;
    private final ThreadAchievementShareInfo.ParamBean dDS;
    private TextView dDT;
    private TextView dDU;
    private TextView dDV;
    private TextView dDW;
    private TextView dDX;
    private TextView dDY;
    private TextView dDZ;
    private TextView dEa;
    private TextView dEb;
    private View dEc;
    private View dEd;
    private View dEe;
    private TbImageView dEf;
    private TbImageView dEg;
    private TbImageView dEh;
    private View dEi;
    private View dEj;
    private View dEk;
    private LinearLayout dEl;
    private ImageView dEm;
    private TextView dEn;
    private LinearLayout dEo;
    private ImageView dEp;
    private TextView dEq;
    private LinearLayout dEr;
    private ImageView dEs;
    private TextView dEt;
    private View dEu;
    private View dEv;
    private View dEw;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.dDR = threadAchievementShareInfo;
        this.dDS = threadAchievementShareInfo.getParams();
        if (this.dDS != null) {
            this.mThreadList = this.dDS.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.dDT = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.dDU = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.dEf = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.dDV = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.dEc = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.dDW = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.dDX = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.dEg = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.dDY = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.dEd = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.dDZ = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.dEa = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.dEh = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.dEb = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.dEe = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.dEj = this.mRoot.findViewById(R.id.first_item_layout);
        this.dEk = this.mRoot.findViewById(R.id.second_item_layout);
        this.dEi = this.mRoot.findViewById(R.id.current_item_layout);
        this.dEw = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.dEv = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.dEu = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.dEl = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.dEm = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.dEn = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.dEo = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.dEp = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.dEq = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.dEr = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.dEs = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.dEt = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.dEf.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dEf.setConrers(15);
        this.dEf.setPlaceHolder(2);
        this.dEg.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dEg.setConrers(15);
        this.dEg.setPlaceHolder(2);
        this.dEh.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dEh.setConrers(15);
        this.dEh.setPlaceHolder(2);
        this.dDU.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dDX.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.dEa.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.dDT, (int) R.color.cp_cont_a);
        an.setBackgroundResource(this.dDT, R.drawable.cp_other_d_round_bg);
        an.setBackgroundResource(this.dEc, R.drawable.cp_other_b_alpha20_round_bg);
        an.setViewTextColor(this.dDU, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.dDV, (int) R.color.cp_other_d);
        an.setViewTextColor(this.dDW, (int) R.color.cp_cont_a);
        an.setBackgroundResource(this.dDW, R.drawable.cp_link_tip_d_round_bg);
        an.setBackgroundResource(this.dEd, R.drawable.cp_link_tip_d_alpha20_round_bg);
        an.setViewTextColor(this.dDX, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.dDY, (int) R.color.cp_link_tip_d);
        an.setViewTextColor(this.dDZ, (int) R.color.cp_cont_a);
        an.setBackgroundResource(this.dDZ, R.drawable.cp_link_tip_d_round_bg);
        an.setBackgroundResource(this.dEe, R.drawable.cp_link_tip_d_alpha20_round_bg);
        an.setViewTextColor(this.dEa, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.dEb, (int) R.color.cp_link_tip_d);
        an.setBackgroundColor(this.dEi, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        this.dEm.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dEp.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        this.dEs.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
        an.setViewTextColor(this.dEn, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.dEq, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.dEt, (int) R.color.cp_cont_a);
    }

    private void initData() {
        if (this.dDS != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.dDS.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.dEi.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEk.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.dEj.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.dEi.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                an.setBackgroundColor(this.dDZ, R.color.cp_other_d);
                an.setViewTextColor(this.dEb, (int) R.color.cp_other_d);
                an.setBackgroundColor(this.dEe, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.dEi.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.dEk.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dEj.setVisibility(0);
        this.dDT.setText(String.valueOf(i));
        this.dDU.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dEc.setVisibility(0);
            this.dDV.setText("热度 " + ar.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dEl.setVisibility(0);
            this.dEw.setVisibility(0);
            this.dEn.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dEf.setVisibility(0);
            this.dEf.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dEf.setVisibility(8);
        this.dEl.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dDU.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dEk.setVisibility(0);
        this.dDW.setText(String.valueOf(i));
        this.dDX.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dEd.setVisibility(0);
            this.dDY.setText("热度 " + ar.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dEo.setVisibility(0);
            this.dEv.setVisibility(0);
            this.dEq.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dEg.setVisibility(0);
            this.dEg.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dEg.setVisibility(8);
        this.dEo.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dDX.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.dEi.setVisibility(0);
        this.dDZ.setText(String.valueOf(i));
        this.dEa.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.dEe.setVisibility(0);
            this.dEb.setText("热度 " + ar.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.dEr.setVisibility(0);
            this.dEu.setVisibility(0);
            this.dEt.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.dEh.setVisibility(0);
            this.dEh.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.dEh.setVisibility(8);
        this.dEr.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dEa.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
