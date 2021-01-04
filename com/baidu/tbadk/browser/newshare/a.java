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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final ThreadAchievementShareInfo.ParamBean eKA;
    private TextView eKB;
    private TextView eKC;
    private TextView eKD;
    private TextView eKE;
    private TextView eKF;
    private TextView eKG;
    private TextView eKH;
    private TextView eKI;
    private TextView eKJ;
    private View eKK;
    private View eKL;
    private View eKM;
    private TbImageView eKN;
    private TbImageView eKO;
    private TbImageView eKP;
    private View eKQ;
    private View eKR;
    private View eKS;
    private LinearLayout eKT;
    private ImageView eKU;
    private TextView eKV;
    private LinearLayout eKW;
    private ImageView eKX;
    private TextView eKY;
    private LinearLayout eKZ;
    private final ThreadAchievementShareInfo eKz;
    private ImageView eLa;
    private TextView eLb;
    private View eLc;
    private View eLd;
    private View eLe;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.eKz = threadAchievementShareInfo;
        this.eKA = threadAchievementShareInfo.getParams();
        if (this.eKA != null) {
            this.mThreadList = this.eKA.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.eKB = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.eKC = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.eKN = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.eKD = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.eKK = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.eKE = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.eKF = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.eKO = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eKG = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.eKL = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.eKH = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.eKI = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.eKP = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.eKJ = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.eKM = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eKR = this.mRoot.findViewById(R.id.first_item_layout);
        this.eKS = this.mRoot.findViewById(R.id.second_item_layout);
        this.eKQ = this.mRoot.findViewById(R.id.current_item_layout);
        this.eLe = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.eLd = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eLc = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.eKT = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eKU = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.eKV = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eKW = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eKX = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eKY = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.eKZ = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.eLa = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.eLb = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.eKN.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eKN.setConrers(15);
        this.eKN.setPlaceHolder(2);
        this.eKO.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eKO.setConrers(15);
        this.eKO.setPlaceHolder(2);
        this.eKP.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eKP.setConrers(15);
        this.eKP.setPlaceHolder(2);
        this.eKC.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eKF.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eKI.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.eKB, R.color.CAM_X0101);
        ao.setBackgroundResource(this.eKB, R.drawable.cp_other_d_round_bg);
        ao.setBackgroundResource(this.eKK, R.drawable.cp_other_b_alpha20_round_bg);
        ao.setViewTextColor(this.eKC, R.color.CAM_X0105);
        ao.setViewTextColor(this.eKD, R.color.CAM_X0310);
        ao.setViewTextColor(this.eKE, R.color.CAM_X0101);
        ao.setBackgroundResource(this.eKE, R.drawable.cp_link_tip_d_round_bg);
        ao.setBackgroundResource(this.eKL, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ao.setViewTextColor(this.eKF, R.color.CAM_X0105);
        ao.setViewTextColor(this.eKG, R.color.CAM_X0305);
        ao.setViewTextColor(this.eKH, R.color.CAM_X0101);
        ao.setBackgroundResource(this.eKH, R.drawable.cp_link_tip_d_round_bg);
        ao.setBackgroundResource(this.eKM, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ao.setViewTextColor(this.eKI, R.color.CAM_X0105);
        ao.setViewTextColor(this.eKJ, R.color.CAM_X0305);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        com.baidu.tbadk.core.util.f.a.bwT().qB(1).qD(0).qI(ao.qc(R.color.CAM_X0201)).qE(ao.qc(R.color.CAM_X0806)).qC(4112).qF(l.getDimens(this.mContext, R.dimen.tbds16)).qG(0).qH(l.getDimens(this.mContext, R.dimen.tbds5)).bz(this.eKQ);
        this.eKU.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eKX.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eLa.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        ao.setViewTextColor(this.eKV, R.color.CAM_X0101);
        ao.setViewTextColor(this.eKY, R.color.CAM_X0101);
        ao.setViewTextColor(this.eLb, R.color.CAM_X0101);
    }

    private void initData() {
        if (this.eKA != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.eKA.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eKQ.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKS.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eKR.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eKQ.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ao.setBackgroundColor(this.eKH, R.color.CAM_X0310);
                ao.setViewTextColor(this.eKJ, R.color.CAM_X0310);
                ao.setBackgroundColor(this.eKM, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eKQ.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eKS.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eKR.setVisibility(0);
        this.eKB.setText(String.valueOf(i));
        this.eKC.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eKK.setVisibility(0);
            this.eKD.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eKT.setVisibility(0);
            this.eLe.setVisibility(0);
            this.eKV.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eKN.setVisibility(0);
            this.eKN.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eKN.setVisibility(8);
        this.eKT.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eKC.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eKS.setVisibility(0);
        this.eKE.setText(String.valueOf(i));
        this.eKF.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eKL.setVisibility(0);
            this.eKG.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eKW.setVisibility(0);
            this.eLd.setVisibility(0);
            this.eKY.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eKO.setVisibility(0);
            this.eKO.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eKO.setVisibility(8);
        this.eKW.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eKF.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eKQ.setVisibility(0);
        this.eKH.setText(String.valueOf(i));
        this.eKI.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eKM.setVisibility(0);
            this.eKJ.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eKZ.setVisibility(0);
            this.eLc.setVisibility(0);
            this.eLb.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eKP.setVisibility(0);
            this.eKP.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eKP.setVisibility(8);
        this.eKZ.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eKI.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
