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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final ThreadAchievementShareInfo etU;
    private final ThreadAchievementShareInfo.ParamBean etV;
    private TextView etW;
    private TextView etX;
    private TextView etY;
    private TextView etZ;
    private TextView eua;
    private TextView eub;
    private TextView euc;
    private TextView eud;
    private TextView eue;
    private View euf;
    private View eug;
    private View euh;
    private TbImageView eui;
    private TbImageView euj;
    private TbImageView euk;
    private View eul;
    private View eum;
    private View eun;
    private LinearLayout euo;
    private ImageView eup;
    private TextView euq;
    private LinearLayout eur;
    private ImageView eus;
    private TextView eut;
    private LinearLayout euu;
    private ImageView euv;
    private TextView euw;
    private View eux;
    private View euy;
    private View euz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.etU = threadAchievementShareInfo;
        this.etV = threadAchievementShareInfo.getParams();
        if (this.etV != null) {
            this.mThreadList = this.etV.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.etW = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.etX = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.eui = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.etY = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.euf = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.etZ = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.eua = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.euj = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eub = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.eug = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.euc = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.eud = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.euk = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.eue = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.euh = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eum = this.mRoot.findViewById(R.id.first_item_layout);
        this.eun = this.mRoot.findViewById(R.id.second_item_layout);
        this.eul = this.mRoot.findViewById(R.id.current_item_layout);
        this.euz = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.euy = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eux = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.euo = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eup = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.euq = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eur = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eus = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eut = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.euu = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.euv = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.euw = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.eui.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eui.setConrers(15);
        this.eui.setPlaceHolder(2);
        this.euj.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.euj.setConrers(15);
        this.euj.setPlaceHolder(2);
        this.euk.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.euk.setConrers(15);
        this.euk.setPlaceHolder(2);
        this.etX.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eua.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eud.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.etW, R.color.CAM_X0101);
        ap.setBackgroundResource(this.etW, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.euf, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.etX, R.color.CAM_X0105);
        ap.setViewTextColor(this.etY, R.color.CAM_X0310);
        ap.setViewTextColor(this.etZ, R.color.CAM_X0101);
        ap.setBackgroundResource(this.etZ, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eug, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eua, R.color.CAM_X0105);
        ap.setViewTextColor(this.eub, R.color.CAM_X0305);
        ap.setViewTextColor(this.euc, R.color.CAM_X0101);
        ap.setBackgroundResource(this.euc, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.euh, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eud, R.color.CAM_X0105);
        ap.setViewTextColor(this.eue, R.color.CAM_X0305);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        com.baidu.tbadk.core.util.e.a.brb().pQ(1).pS(0).pX(ap.ps(R.color.CAM_X0201)).pT(ap.ps(R.color.CAM_X0806)).pR(4112).pU(l.getDimens(this.mContext, R.dimen.tbds16)).pV(0).pW(l.getDimens(this.mContext, R.dimen.tbds5)).bn(this.eul);
        this.eup.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eus.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.euv.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.euq, R.color.CAM_X0101);
        ap.setViewTextColor(this.eut, R.color.CAM_X0101);
        ap.setViewTextColor(this.euw, R.color.CAM_X0101);
    }

    private void initData() {
        if (this.etV != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.etV.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eul.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eun.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eum.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eul.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.euc, R.color.CAM_X0310);
                ap.setViewTextColor(this.eue, R.color.CAM_X0310);
                ap.setBackgroundColor(this.euh, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eul.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eun.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eum.setVisibility(0);
        this.etW.setText(String.valueOf(i));
        this.etX.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.euf.setVisibility(0);
            this.etY.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.euo.setVisibility(0);
            this.euz.setVisibility(0);
            this.euq.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eui.setVisibility(0);
            this.eui.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eui.setVisibility(8);
        this.euo.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.etX.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eun.setVisibility(0);
        this.etZ.setText(String.valueOf(i));
        this.eua.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eug.setVisibility(0);
            this.eub.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eur.setVisibility(0);
            this.euy.setVisibility(0);
            this.eut.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.euj.setVisibility(0);
            this.euj.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.euj.setVisibility(8);
        this.eur.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eua.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eul.setVisibility(0);
        this.euc.setText(String.valueOf(i));
        this.eud.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.euh.setVisibility(0);
            this.eue.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.euu.setVisibility(0);
            this.eux.setVisibility(0);
            this.euw.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.euk.setVisibility(0);
            this.euk.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.euk.setVisibility(8);
        this.euu.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eud.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
