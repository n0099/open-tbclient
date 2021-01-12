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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private final ThreadAchievementShareInfo eFO;
    private final ThreadAchievementShareInfo.ParamBean eFP;
    private TextView eFQ;
    private TextView eFR;
    private TextView eFS;
    private TextView eFT;
    private TextView eFU;
    private TextView eFV;
    private TextView eFW;
    private TextView eFX;
    private TextView eFY;
    private View eFZ;
    private View eGa;
    private View eGb;
    private TbImageView eGc;
    private TbImageView eGd;
    private TbImageView eGe;
    private View eGf;
    private View eGg;
    private View eGh;
    private LinearLayout eGi;
    private ImageView eGj;
    private TextView eGk;
    private LinearLayout eGl;
    private ImageView eGm;
    private TextView eGn;
    private LinearLayout eGo;
    private ImageView eGp;
    private TextView eGq;
    private View eGr;
    private View eGs;
    private View eGt;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.eFO = threadAchievementShareInfo;
        this.eFP = threadAchievementShareInfo.getParams();
        if (this.eFP != null) {
            this.mThreadList = this.eFP.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.eFQ = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.eFR = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.eGc = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.eFS = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.eFZ = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.eFT = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.eFU = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.eGd = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eFV = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.eGa = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.eFW = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.eFX = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.eGe = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.eFY = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.eGb = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eGg = this.mRoot.findViewById(R.id.first_item_layout);
        this.eGh = this.mRoot.findViewById(R.id.second_item_layout);
        this.eGf = this.mRoot.findViewById(R.id.current_item_layout);
        this.eGt = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.eGs = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eGr = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.eGi = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eGj = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.eGk = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eGl = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eGm = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eGn = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.eGo = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.eGp = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.eGq = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.eGc.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eGc.setConrers(15);
        this.eGc.setPlaceHolder(2);
        this.eGd.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eGd.setConrers(15);
        this.eGd.setPlaceHolder(2);
        this.eGe.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eGe.setConrers(15);
        this.eGe.setPlaceHolder(2);
        this.eFR.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eFU.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eFX.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.eFQ, R.color.CAM_X0101);
        ao.setBackgroundResource(this.eFQ, R.drawable.cp_other_d_round_bg);
        ao.setBackgroundResource(this.eFZ, R.drawable.cp_other_b_alpha20_round_bg);
        ao.setViewTextColor(this.eFR, R.color.CAM_X0105);
        ao.setViewTextColor(this.eFS, R.color.CAM_X0310);
        ao.setViewTextColor(this.eFT, R.color.CAM_X0101);
        ao.setBackgroundResource(this.eFT, R.drawable.cp_link_tip_d_round_bg);
        ao.setBackgroundResource(this.eGa, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ao.setViewTextColor(this.eFU, R.color.CAM_X0105);
        ao.setViewTextColor(this.eFV, R.color.CAM_X0305);
        ao.setViewTextColor(this.eFW, R.color.CAM_X0101);
        ao.setBackgroundResource(this.eFW, R.drawable.cp_link_tip_d_round_bg);
        ao.setBackgroundResource(this.eGb, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ao.setViewTextColor(this.eFX, R.color.CAM_X0105);
        ao.setViewTextColor(this.eFY, R.color.CAM_X0305);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        com.baidu.tbadk.core.util.f.a.bta().oU(1).oW(0).pb(ao.ov(R.color.CAM_X0201)).oX(ao.ov(R.color.CAM_X0806)).oV(UIMsg.k_event.MV_MAP_CHANGETO2D).oY(l.getDimens(this.mContext, R.dimen.tbds16)).oZ(0).pa(l.getDimens(this.mContext, R.dimen.tbds5)).bz(this.eGf);
        this.eGj.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eGm.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eGp.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        ao.setViewTextColor(this.eGk, R.color.CAM_X0101);
        ao.setViewTextColor(this.eGn, R.color.CAM_X0101);
        ao.setViewTextColor(this.eGq, R.color.CAM_X0101);
    }

    private void initData() {
        if (this.eFP != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.eFP.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eGf.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGh.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eGg.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eGf.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ao.setBackgroundColor(this.eFW, R.color.CAM_X0310);
                ao.setViewTextColor(this.eFY, R.color.CAM_X0310);
                ao.setBackgroundColor(this.eGb, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eGf.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eGh.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eGg.setVisibility(0);
        this.eFQ.setText(String.valueOf(i));
        this.eFR.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eFZ.setVisibility(0);
            this.eFS.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eGi.setVisibility(0);
            this.eGt.setVisibility(0);
            this.eGk.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eGc.setVisibility(0);
            this.eGc.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eGc.setVisibility(8);
        this.eGi.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eFR.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eGh.setVisibility(0);
        this.eFT.setText(String.valueOf(i));
        this.eFU.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eGa.setVisibility(0);
            this.eFV.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eGl.setVisibility(0);
            this.eGs.setVisibility(0);
            this.eGn.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eGd.setVisibility(0);
            this.eGd.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eGd.setVisibility(8);
        this.eGl.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eFU.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eGf.setVisibility(0);
        this.eFW.setText(String.valueOf(i));
        this.eFX.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eGb.setVisibility(0);
            this.eFY.setText("热度 " + at.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eGo.setVisibility(0);
            this.eGr.setVisibility(0);
            this.eGq.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eGe.setVisibility(0);
            this.eGe.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eGe.setVisibility(8);
        this.eGo.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eFX.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
