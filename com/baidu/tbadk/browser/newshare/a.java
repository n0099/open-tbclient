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
    private final ThreadAchievementShareInfo eAW;
    private final ThreadAchievementShareInfo.ParamBean eAX;
    private TextView eAY;
    private TextView eAZ;
    private View eBA;
    private View eBB;
    private TextView eBa;
    private TextView eBb;
    private TextView eBc;
    private TextView eBd;
    private TextView eBe;
    private TextView eBf;
    private TextView eBg;
    private View eBh;
    private View eBi;
    private View eBj;
    private TbImageView eBk;
    private TbImageView eBl;
    private TbImageView eBm;
    private View eBn;
    private View eBo;
    private View eBp;
    private LinearLayout eBq;
    private ImageView eBr;
    private TextView eBs;
    private LinearLayout eBt;
    private ImageView eBu;
    private TextView eBv;
    private LinearLayout eBw;
    private ImageView eBx;
    private TextView eBy;
    private View eBz;
    private final Context mContext;
    private final View mRoot;
    private List<ThreadAchievementShareInfo.ThreadListBean> mThreadList;
    private TextView mTitle;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        this.eAW = threadAchievementShareInfo;
        this.eAX = threadAchievementShareInfo.getParams();
        if (this.eAX != null) {
            this.mThreadList = this.eAX.getThread_list();
        }
        initUI();
        initData();
    }

    @SuppressLint({"CutPasteId"})
    private void initUI() {
        this.mTitle = (TextView) this.mRoot.findViewById(R.id.title);
        this.eAY = (TextView) this.mRoot.findViewById(R.id.first_rank_num);
        this.eAZ = (TextView) this.mRoot.findViewById(R.id.first_thread_content);
        this.eBk = (TbImageView) this.mRoot.findViewById(R.id.first_thread_img);
        this.eBa = (TextView) this.mRoot.findViewById(R.id.first_heat_degree);
        this.eBh = this.mRoot.findViewById(R.id.first_heat_degree_bg);
        this.eBb = (TextView) this.mRoot.findViewById(R.id.second_rank_num);
        this.eBc = (TextView) this.mRoot.findViewById(R.id.second_thread_content);
        this.eBl = (TbImageView) this.mRoot.findViewById(R.id.second_thread_img);
        this.eBd = (TextView) this.mRoot.findViewById(R.id.second_heat_degree);
        this.eBi = this.mRoot.findViewById(R.id.second_heat_degree_bg);
        this.eBe = (TextView) this.mRoot.findViewById(R.id.current_rank_num);
        this.eBf = (TextView) this.mRoot.findViewById(R.id.current_thread_content);
        this.eBm = (TbImageView) this.mRoot.findViewById(R.id.current_thread_img);
        this.eBg = (TextView) this.mRoot.findViewById(R.id.current_heat_degree);
        this.eBj = this.mRoot.findViewById(R.id.current_heat_degree_bg);
        this.eBo = this.mRoot.findViewById(R.id.first_item_layout);
        this.eBp = this.mRoot.findViewById(R.id.second_item_layout);
        this.eBn = this.mRoot.findViewById(R.id.current_item_layout);
        this.eBB = this.mRoot.findViewById(R.id.first_thread_img_overlay);
        this.eBA = this.mRoot.findViewById(R.id.second_thread_img_overlay);
        this.eBz = this.mRoot.findViewById(R.id.current_thread_img_overlay);
        this.eBq = (LinearLayout) this.mRoot.findViewById(R.id.first_video_during_container);
        this.eBr = (ImageView) this.mRoot.findViewById(R.id.first_vidoe_play_iv);
        this.eBs = (TextView) this.mRoot.findViewById(R.id.first_video_during_tv);
        this.eBt = (LinearLayout) this.mRoot.findViewById(R.id.second_video_during_container);
        this.eBu = (ImageView) this.mRoot.findViewById(R.id.second_vidoe_play_iv);
        this.eBv = (TextView) this.mRoot.findViewById(R.id.second_video_during_tv);
        this.eBw = (LinearLayout) this.mRoot.findViewById(R.id.current_video_during_container);
        this.eBx = (ImageView) this.mRoot.findViewById(R.id.current_vidoe_play_iv);
        this.eBy = (TextView) this.mRoot.findViewById(R.id.current_video_during_tv);
        this.eBk.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eBk.setConrers(15);
        this.eBk.setPlaceHolder(2);
        this.eBl.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eBl.setConrers(15);
        this.eBl.setPlaceHolder(2);
        this.eBm.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eBm.setConrers(15);
        this.eBm.setPlaceHolder(2);
        this.eAZ.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eBc.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        this.eBf.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds13), 1.0f);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.eAY, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eAY, R.drawable.cp_other_d_round_bg);
        ap.setBackgroundResource(this.eBh, R.drawable.cp_other_b_alpha20_round_bg);
        ap.setViewTextColor(this.eAZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.eBa, R.color.CAM_X0310);
        ap.setViewTextColor(this.eBb, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eBb, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eBi, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eBc, R.color.CAM_X0105);
        ap.setViewTextColor(this.eBd, R.color.CAM_X0305);
        ap.setViewTextColor(this.eBe, R.color.CAM_X0101);
        ap.setBackgroundResource(this.eBe, R.drawable.cp_link_tip_d_round_bg);
        ap.setBackgroundResource(this.eBj, R.drawable.cp_link_tip_d_alpha20_round_bg);
        ap.setViewTextColor(this.eBf, R.color.CAM_X0105);
        ap.setViewTextColor(this.eBg, R.color.CAM_X0305);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        com.baidu.tbadk.core.util.e.a.buy().qq(1).qs(0).qx(ap.pS(R.color.CAM_X0201)).qt(ap.pS(R.color.CAM_X0806)).qr(4112).qu(l.getDimens(this.mContext, R.dimen.tbds16)).qv(0).qw(l.getDimens(this.mContext, R.dimen.tbds5)).bq(this.eBn);
        this.eBr.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eBu.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        this.eBx.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        ap.setViewTextColor(this.eBs, R.color.CAM_X0101);
        ap.setViewTextColor(this.eBv, R.color.CAM_X0101);
        ap.setViewTextColor(this.eBy, R.color.CAM_X0101);
    }

    private void initData() {
        if (this.eAX != null && this.mThreadList != null && this.mThreadList.size() >= 2) {
            int rank = this.eAX.getRank();
            if (rank == 0) {
                ThreadAchievementShareInfo.ThreadListBean threadListBean = this.mThreadList.get(rank);
                threadListBean.setDuration(500);
                a(rank + 1, threadListBean);
                b(rank + 2, this.mThreadList.get(rank + 1));
                this.eBn.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBp.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds8);
            } else if (rank == 1) {
                c(rank, this.mThreadList.get(rank - 1));
                b(rank + 1, this.mThreadList.get(rank));
                this.eBo.setVisibility(4);
                ((RelativeLayout.LayoutParams) this.eBn.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds5);
                ap.setBackgroundColor(this.eBe, R.color.CAM_X0310);
                ap.setViewTextColor(this.eBg, R.color.CAM_X0310);
                ap.setBackgroundColor(this.eBj, R.color.cp_other_b_alpha20);
            } else {
                a(rank - 1, this.mThreadList.get(rank - 2));
                c(rank, this.mThreadList.get(rank - 1));
                ((RelativeLayout.LayoutParams) this.eBn.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds230);
                this.eBp.setVisibility(4);
            }
        }
    }

    private void a(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eBo.setVisibility(0);
        this.eAY.setText(String.valueOf(i));
        this.eAZ.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eBh.setVisibility(0);
            this.eBa.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eBq.setVisibility(0);
            this.eBB.setVisibility(0);
            this.eBs.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eBk.setVisibility(0);
            this.eBk.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eBk.setVisibility(8);
        this.eBq.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eAZ.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void b(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eBp.setVisibility(0);
        this.eBb.setText(String.valueOf(i));
        this.eBc.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eBi.setVisibility(0);
            this.eBd.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eBt.setVisibility(0);
            this.eBA.setVisibility(0);
            this.eBv.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eBl.setVisibility(0);
            this.eBl.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eBl.setVisibility(8);
        this.eBt.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eBc.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    private void c(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.eBn.setVisibility(0);
        this.eBe.setText(String.valueOf(i));
        this.eBf.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.eBj.setVisibility(0);
            this.eBg.setText("热度 " + au.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.eBw.setVisibility(0);
            this.eBz.setVisibility(0);
            this.eBy.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.eBm.setVisibility(0);
            this.eBm.startLoad(threadListBean.getImg(), 10, false);
            return;
        }
        this.eBm.setVisibility(8);
        this.eBw.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.eBf.getLayoutParams()).rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
    }

    public View getView() {
        return this.mRoot;
    }
}
