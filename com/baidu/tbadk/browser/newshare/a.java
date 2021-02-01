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
    private final ThreadAchievementShareInfo eHU;
    private final ThreadAchievementShareInfo.ParamBean eHV;
    private TextView eHW;
    private TextView eHX;
    private TextView eHY;
    private TextView eHZ;
    private TextView eIa;
    private TextView eIb;
    private TextView eIc;
    private TextView eId;
    private TextView eIe;
    private View eIf;
    private View eIg;
    private View eIh;
    private TbImageView eIi;
    private TbImageView eIj;
    private TbImageView eIk;
    private View eIl;
    private View eIm;
    private View eIn;
    private LinearLayout eIo;
    private ImageView eIp;
    private TextView eIq;
    private LinearLayout eIr;
    private ImageView eIs;
    private TextView eIt;
    private LinearLayout eIu;
    private ImageView eIv;
    private TextView eIw;
    private View eIx;
    private View eIy;
    private View eIz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.eHU = threadAchievementShareInfo;
        this.eHV = threadAchievementShareInfo.getParams();
        if (this.eHV != null) {
            this.mThreadList = this.eHV.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.eHW = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.eHX = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.eIi = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.eHY = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.eIf = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.eHZ = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.eIa = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.eIj = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eIb = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.eIg = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.eIc = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.eId = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.eIk = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.eIe = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.eIh = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eIm = this.mRoot.findViewById(R.id.first_item_layout);
        this.eIn = this.mRoot.findViewById(R.id.second_item_layout);
        this.eIl = this.mRoot.findViewById(R.id.current_item_layout);
        this.eIz = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.eIy = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eIx = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.eIo = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eIp = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.eIq = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eIr = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eIs = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eIt = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.eIu = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.eIv = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.eIw = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.eIi.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eIi.setConrers(15);
        this.eIi.setPlaceHolder(2);
        this.eIj.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eIj.setConrers(15);
        this.eIj.setPlaceHolder(2);
        this.eIk.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eIk.setConrers(15);
        this.eIk.setPlaceHolder(2);
        this.eHX.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eIa.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eId.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.eHW, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eHW, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.eIf, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.eHX, R.color.CAM_X0105);
        ap.setViewTextColor(this.eHY, R.color.CAM_X0310);
        ap.setViewTextColor(this.eHZ, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eHZ, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eIg, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eIa, R.color.CAM_X0105);
        ap.setViewTextColor(this.eIb, R.color.CAM_X0305);
        ap.setViewTextColor(this.eIc, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eIc, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eIh, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eId, R.color.CAM_X0105);
        ap.setViewTextColor(this.eIe, R.color.CAM_X0305);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        com.baidu.tbadk.core.util.f.a.btu().oZ(1).pb(0).pg(ap.oA(R.color.CAM_X0201)).pc(ap.oA(R.color.CAM_X0806)).pa(UIMsg.k_event.MV_MAP_CHANGETO2D).pd(l.getDimens(this.mContext, R.dimen.tbds16)).pe(0).pf(l.getDimens(this.mContext, R.dimen.tbds5)).bv(this.eIl);
        this.eIp.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eIs.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eIv.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.eIq, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIt, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIw, R.color.CAM_X0101);
    }

    private void initData() {
        if (this.eHV != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.eHV.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eIl.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIn.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eIm.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eIl.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.eIc, R.color.CAM_X0310);
                ap.setViewTextColor(this.eIe, R.color.CAM_X0310);
                ap.setBackgroundColor(this.eIh, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eIl.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eIn.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eIm.setVisibility(0);
        this.eHW.setText(String.valueOf(i));
        this.eHX.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eIf.setVisibility(0);
            this.eHY.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eIo.setVisibility(0);
            this.eIz.setVisibility(0);
            this.eIq.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eIi.setVisibility(0);
            this.eIi.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eIi.setVisibility(8);
        this.eIo.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eHX.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eIn.setVisibility(0);
        this.eHZ.setText(String.valueOf(i));
        this.eIa.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eIg.setVisibility(0);
            this.eIb.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eIr.setVisibility(0);
            this.eIy.setVisibility(0);
            this.eIt.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eIj.setVisibility(0);
            this.eIj.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eIj.setVisibility(8);
        this.eIr.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eIa.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eIl.setVisibility(0);
        this.eIc.setText(String.valueOf(i));
        this.eId.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eIh.setVisibility(0);
            this.eIe.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eIu.setVisibility(0);
            this.eIx.setVisibility(0);
            this.eIw.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eIk.setVisibility(0);
            this.eIk.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eIk.setVisibility(8);
        this.eIu.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eId.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
