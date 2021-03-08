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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView eJA;
    private TextView eJB;
    private TextView eJC;
    private TextView eJD;
    private TextView eJE;
    private TextView eJF;
    private View eJG;
    private View eJH;
    private View eJI;
    private TbImageView eJJ;
    private TbImageView eJK;
    private TbImageView eJL;
    private View eJM;
    private View eJN;
    private View eJO;
    private LinearLayout eJP;
    private ImageView eJQ;
    private TextView eJR;
    private LinearLayout eJS;
    private ImageView eJT;
    private TextView eJU;
    private LinearLayout eJV;
    private ImageView eJW;
    private TextView eJX;
    private View eJY;
    private View eJZ;
    private final ThreadAchievementShareInfo eJv;
    private final ThreadAchievementShareInfo.ParamBean eJw;
    private TextView eJx;
    private TextView eJy;
    private TextView eJz;
    private View eKa;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.eJv = threadAchievementShareInfo;
        this.eJw = threadAchievementShareInfo.getParams();
        if (this.eJw != null) {
            this.mThreadList = this.eJw.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.eJx = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.eJy = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.eJJ = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.eJz = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.eJG = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.eJA = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.eJB = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.eJK = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eJC = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.eJH = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.eJD = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.eJE = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.eJL = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.eJF = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.eJI = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eJN = this.mRoot.findViewById(R.id.first_item_layout);
        this.eJO = this.mRoot.findViewById(R.id.second_item_layout);
        this.eJM = this.mRoot.findViewById(R.id.current_item_layout);
        this.eKa = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.eJZ = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eJY = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.eJP = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eJQ = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.eJR = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eJS = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eJT = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eJU = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.eJV = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.eJW = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.eJX = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.eJJ.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eJJ.setConrers(15);
        this.eJJ.setPlaceHolder(2);
        this.eJK.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eJK.setConrers(15);
        this.eJK.setPlaceHolder(2);
        this.eJL.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eJL.setConrers(15);
        this.eJL.setPlaceHolder(2);
        this.eJy.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eJB.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eJE.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.eJx, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eJx, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.eJG, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.eJy, R.color.CAM_X0105);
        ap.setViewTextColor(this.eJz, R.color.CAM_X0310);
        ap.setViewTextColor(this.eJA, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eJA, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eJH, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eJB, R.color.CAM_X0105);
        ap.setViewTextColor(this.eJC, R.color.CAM_X0305);
        ap.setViewTextColor(this.eJD, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eJD, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eJI, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eJE, R.color.CAM_X0105);
        ap.setViewTextColor(this.eJF, R.color.CAM_X0305);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        com.baidu.tbadk.core.util.f.a.btx().pa(1).pc(0).ph(ap.oB(R.color.CAM_X0201)).pd(ap.oB(R.color.CAM_X0806)).pb(UIMsg.k_event.MV_MAP_CHANGETO2D).pe(l.getDimens(this.mContext, R.dimen.tbds16)).pf(0).pg(l.getDimens(this.mContext, R.dimen.tbds5)).bv(this.eJM);
        this.eJQ.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eJT.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eJW.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.eJR, R.color.CAM_X0101);
        ap.setViewTextColor(this.eJU, R.color.CAM_X0101);
        ap.setViewTextColor(this.eJX, R.color.CAM_X0101);
    }

    private void initData() {
        if (this.eJw != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.eJw.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eJM.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJO.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eJN.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eJM.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.eJD, R.color.CAM_X0310);
                ap.setViewTextColor(this.eJF, R.color.CAM_X0310);
                ap.setBackgroundColor(this.eJI, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eJM.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eJO.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eJN.setVisibility(0);
        this.eJx.setText(String.valueOf(i));
        this.eJy.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eJG.setVisibility(0);
            this.eJz.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eJP.setVisibility(0);
            this.eKa.setVisibility(0);
            this.eJR.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eJJ.setVisibility(0);
            this.eJJ.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eJJ.setVisibility(8);
        this.eJP.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eJy.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eJO.setVisibility(0);
        this.eJA.setText(String.valueOf(i));
        this.eJB.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eJH.setVisibility(0);
            this.eJC.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eJS.setVisibility(0);
            this.eJZ.setVisibility(0);
            this.eJU.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eJK.setVisibility(0);
            this.eJK.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eJK.setVisibility(8);
        this.eJS.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eJB.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eJM.setVisibility(0);
        this.eJD.setText(String.valueOf(i));
        this.eJE.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eJI.setVisibility(0);
            this.eJF.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eJV.setVisibility(0);
            this.eJY.setVisibility(0);
            this.eJX.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eJL.setVisibility(0);
            this.eJL.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eJL.setVisibility(8);
        this.eJV.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eJE.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
