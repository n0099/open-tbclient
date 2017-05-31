package com.baidu.tbadk.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class z {
    private ImageView QA;
    private ImageView QB;
    private LinearLayout QC;
    private TextView QD;
    private View.OnClickListener QE;
    private View QF;
    private MorePopupWindow QG;
    protected View QH;
    private View QI;
    private View QJ;
    private int QK;
    private int QL;
    private BaseWebViewActivity Qw;
    private TextView Qy;
    private View Qz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected View Qx = null;
    private ProgressBar mProgressBar = null;
    private boolean QM = true;

    public z(BaseWebViewActivity baseWebViewActivity) {
        this.Qw = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Qw.setContentView(w.j.base_webview_activity);
        this.Qx = this.Qw.findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Qw.findViewById(w.h.view_navigation_bar);
        bY("");
        this.QC = (LinearLayout) this.Qw.findViewById(w.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QC.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.QC.setLayoutParams(layoutParams);
        this.QD = (TextView) this.Qw.findViewById(w.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Qw.findViewById(w.h.webview_progress);
        this.Qz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.widget_nb_item_finish, new aa(this));
        this.QA = (ImageView) this.Qz.findViewById(w.h.widget_navi_back_button);
        this.QA.setContentDescription(this.Qw.getResources().getString(w.l.close));
        this.QF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_more, new ab(this));
        this.QB = (ImageView) this.QF.findViewById(w.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Qw.getPageContext().getPageActivity()).inflate(w.j.tb_webview_pop_more, (ViewGroup) null);
        this.QG = new MorePopupWindow(this.Qw.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Qw.getPageContext().getResources().getDrawable(w.g.bg_pull_down_right_n), new ac(this));
        this.QH = inflate.findViewById(w.h.webview_more_pop_item_share_friend_layout);
        this.QH.setOnClickListener(this.Qw);
        if (com.baidu.tbadk.coreExtra.share.i.aP(this.Qw.getPageContext().getPageActivity())) {
            this.QH.setVisibility(0);
        } else {
            this.QH.setVisibility(8);
        }
        this.QG.refresh();
        this.QJ = inflate.findViewById(w.h.webview_more_pop_item_open_browser_layout);
        this.QJ.setOnClickListener(this.Qw);
        this.QI = inflate.findViewById(w.h.webview_more_pop_item_copy_link_layout);
        this.QI.setOnClickListener(this.Qw);
        oc();
    }

    private void oc() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = com.baidu.adp.lib.util.k.g(this.Qw.getPageContext().getPageActivity(), w.f.ds98);
        int i = com.baidu.adp.lib.util.k.o(this.Qw.getPageContext().getPageActivity()).heightPixels;
        this.QK = (i - statusBarHeight) - g;
        this.QL = i - statusBarHeight;
    }

    public boolean od() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oe() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.QA != null) {
            aq.b(this.QA, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
    }

    public boolean of() {
        try {
            this.QC.addView(this.Qw.createWebView());
            this.QD.setVisibility(8);
            if (!this.QM) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.QD.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.QC.getLayoutParams().height = this.QK;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.QC.getLayoutParams().height = this.QL;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.QH != null) {
            if (z) {
                this.QH.setVisibility(0);
            } else {
                this.QH.setVisibility(8);
            }
            this.QG.refresh();
        }
    }

    public void af(boolean z) {
        if (this.QF != null) {
            if (z) {
                this.QF.setVisibility(0);
            } else {
                this.QF.setVisibility(8);
            }
        }
    }

    public void og() {
        this.QG.showWindowInRightBottomOfHost();
    }

    public void oh() {
        com.baidu.adp.lib.g.j.a(this.QG, this.Qw.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.QD.setVisibility(0);
    }

    public void hideCrashTip() {
        this.QD.setVisibility(8);
    }

    public void bY(String str) {
        this.Qy = this.mNavigationBar.setTitleText(str);
        aq.b(this.Qy, w.e.cp_cont_b, w.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.h hVar) {
        if (hVar != null) {
            TiebaStatic.eventStat(this.Qw.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            as asVar = new as("c10898");
            asVar.Z("obj_url", hVar.linkUrl);
            TiebaStatic.log(asVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Qw.getPageContext().getPageActivity(), hVar, true, oi())));
        }
    }

    private SparseArray<String> oi() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.Qw.getPageContext(), i);
        }
        if (this.QG != null) {
            this.QG.onChangeSkinType(this.Qw, i, aq.getDrawable(w.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Qw.getPageContext(), i);
        }
        aq.a(this.QA, w.g.icon_nav_close, w.g.icon_nav_close_w, w.g.icon_nav_close, i);
        aq.a(this.QB, w.g.icon_more_bg_s, w.g.icon_more_bg_s, w.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.QC.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Qw.getPageContext().getPageActivity(), this.Qx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.Qw.getPageContext().getString(w.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Qw.getResources().getString(w.l.refresh), this.QE)));
        }
        this.mNoDataView.onChangeSkinType(this.Qw.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.QC.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.QE = onClickListener;
    }

    public void release() {
        if (this.QC != null) {
            this.QC.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.QG != null) {
            com.baidu.adp.lib.g.j.a(this.QG, this.Qw.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QC.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.QC.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aq.j(this.QA, w.g.frs_star_navigation_bg);
        aq.j(this.QB, w.g.frs_star_navigation_bg);
        bY("");
        this.Qw.getWindow().setFlags(1024, 1024);
    }

    public void oj() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QC.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.QC.setLayoutParams(layoutParams);
        this.QA.setBackgroundDrawable(null);
        this.QB.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Qw.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.QM = z;
    }
}
