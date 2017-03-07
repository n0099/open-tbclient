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
public class y {
    private BaseWebViewActivity QY;
    private TextView Ra;
    private View Rb;
    private ImageView Rc;
    private ImageView Rd;
    private LinearLayout Re;
    private TextView Rf;
    private View.OnClickListener Rg;
    private View Rh;
    private MorePopupWindow Ri;
    protected View Rj;
    private View Rk;
    private View Rl;
    private int Rm;
    private int Rn;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected View QZ = null;
    private ProgressBar mProgressBar = null;
    private boolean Ro = true;

    public y(BaseWebViewActivity baseWebViewActivity) {
        this.QY = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.QY.setContentView(w.j.base_webview_activity);
        this.QZ = this.QY.findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) this.QY.findViewById(w.h.view_navigation_bar);
        bR("");
        this.Re = (LinearLayout) this.QY.findViewById(w.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Re.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Re.setLayoutParams(layoutParams);
        this.Rf = (TextView) this.QY.findViewById(w.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.QY.findViewById(w.h.webview_progress);
        this.Rb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.widget_nb_item_finish, new z(this));
        this.Rc = (ImageView) this.Rb.findViewById(w.h.widget_navi_back_button);
        this.Rc.setContentDescription(this.QY.getResources().getString(w.l.close));
        this.Rh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_more, new aa(this));
        this.Rd = (ImageView) this.Rh.findViewById(w.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.QY.getPageContext().getPageActivity()).inflate(w.j.tb_webview_pop_more, (ViewGroup) null);
        this.Ri = new MorePopupWindow(this.QY.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.QY.getPageContext().getResources().getDrawable(w.g.bg_pull_down_right_n), new ab(this));
        this.Rj = inflate.findViewById(w.h.webview_more_pop_item_share_friend_layout);
        this.Rj.setOnClickListener(this.QY);
        if (com.baidu.tbadk.coreExtra.share.i.aK(this.QY.getPageContext().getPageActivity())) {
            this.Rj.setVisibility(0);
        } else {
            this.Rj.setVisibility(8);
        }
        this.Ri.refresh();
        this.Rl = inflate.findViewById(w.h.webview_more_pop_item_open_browser_layout);
        this.Rl.setOnClickListener(this.QY);
        this.Rk = inflate.findViewById(w.h.webview_more_pop_item_copy_link_layout);
        this.Rk.setOnClickListener(this.QY);
        og();
    }

    private void og() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = com.baidu.adp.lib.util.k.g(this.QY.getPageContext().getPageActivity(), w.f.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.QY.getPageContext().getPageActivity()).heightPixels;
        this.Rm = (i - statusBarHeight) - g;
        this.Rn = i - statusBarHeight;
    }

    public boolean oh() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oi() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Rc != null) {
            aq.b(this.Rc, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
    }

    public boolean oj() {
        try {
            this.Re.addView(this.QY.createWebView());
            this.Rf.setVisibility(8);
            if (!this.Ro) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Rf.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Re.getLayoutParams().height = this.Rm;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Re.getLayoutParams().height = this.Rn;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.Rj != null) {
            if (z) {
                this.Rj.setVisibility(0);
            } else {
                this.Rj.setVisibility(8);
            }
            this.Ri.refresh();
        }
    }

    public void af(boolean z) {
        if (this.Rh != null) {
            if (z) {
                this.Rh.setVisibility(0);
            } else {
                this.Rh.setVisibility(8);
            }
        }
    }

    public void ok() {
        this.Ri.showWindowInRightBottomOfHost();
    }

    public void ol() {
        com.baidu.adp.lib.g.j.a(this.Ri, this.QY.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Rf.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Rf.setVisibility(8);
    }

    public void bR(String str) {
        this.Ra = this.mNavigationBar.setTitleText(str);
        aq.b(this.Ra, w.e.cp_cont_b, w.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.g gVar) {
        if (gVar != null) {
            TiebaStatic.eventStat(this.QY.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            as asVar = new as("c10898");
            asVar.Z("obj_url", gVar.linkUrl);
            TiebaStatic.log(asVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.QY.getPageContext().getPageActivity(), gVar, true, om())));
        }
    }

    private SparseArray<String> om() {
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
            this.mNavigationBar.onChangeSkinType(this.QY.getPageContext(), i);
        }
        if (this.Ri != null) {
            this.Ri.onChangeSkinType(this.QY, i, aq.getDrawable(w.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.QY.getPageContext(), i);
        }
        aq.a(this.Rc, w.g.icon_nav_close, w.g.icon_nav_close_w, w.g.icon_nav_close, i);
        aq.a(this.Rd, w.g.icon_more_bg_s, w.g.icon_more_bg_s, w.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Re.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.QY.getPageContext().getPageActivity(), this.QZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.QY.getPageContext().getString(w.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.QY.getResources().getString(w.l.refresh), this.Rg)));
        }
        this.mNoDataView.onChangeSkinType(this.QY.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Re.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.Rg = onClickListener;
    }

    public void release() {
        if (this.Re != null) {
            this.Re.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Ri != null) {
            com.baidu.adp.lib.g.j.a(this.Ri, this.QY.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Re.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Re.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aq.j(this.Rc, w.g.frs_star_navigation_bg);
        aq.j(this.Rd, w.g.frs_star_navigation_bg);
        bR("");
        this.QY.getWindow().setFlags(1024, 1024);
    }

    public void on() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Re.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Re.setLayoutParams(layoutParams);
        this.Rc.setBackgroundDrawable(null);
        this.Rd.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.QY.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.Ro = z;
    }
}
