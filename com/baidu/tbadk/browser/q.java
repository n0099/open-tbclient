package com.baidu.tbadk.browser;

import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class q {
    private BaseWebViewActivity Nt;
    private LinearLayout Nu;
    private TextView Nv;
    private View.OnClickListener Nw;
    protected View Nx;
    private View Ny;
    private View Nz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public q(BaseWebViewActivity baseWebViewActivity) {
        this.Nt = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Nt.setContentView(w.base_webview_activity);
        this.mRoot = this.Nt.findViewById(v.root_view);
        this.mNavigationBar = (NavigationBar) this.Nt.findViewById(v.view_navigation_bar);
        this.Nu = (LinearLayout) this.Nt.findViewById(v.webview_container);
        this.Nv = (TextView) this.Nt.findViewById(v.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Nt.findViewById(v.webview_progress);
        this.mNavigationBar = (NavigationBar) this.Nt.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.widget_nb_item_finish, new r(this));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_more, new s(this));
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.Nt.getPageContext().getPageActivity(), w.tb_webview_pop_more, null);
        this.mPopWindow = new MorePopupWindow(this.Nt.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Nt.getPageContext().getResources().getDrawable(u.bg_pull_down_right_n), new t(this));
        this.Nx = inflate.findViewById(v.webview_more_pop_item_share_friend_layout);
        this.Nx.setOnClickListener(this.Nt);
        if (com.baidu.tbadk.coreExtra.share.i.ae(this.Nt.getPageContext().getPageActivity())) {
            this.Nx.setVisibility(0);
        } else {
            this.Nx.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.Nz = inflate.findViewById(v.webview_more_pop_item_open_browser_layout);
        this.Nz.setOnClickListener(this.Nt);
        this.Ny = inflate.findViewById(v.webview_more_pop_item_copy_link_layout);
        this.Ny.setOnClickListener(this.Nt);
    }

    public boolean oU() {
        try {
            this.Nu.addView(this.Nt.createWebView());
            this.Nv.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.Nv.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.mNavigationBar.setVisibility(0);
        } else {
            this.mNavigationBar.setVisibility(8);
        }
    }

    public void oV() {
        this.mPopWindow.showWindowInRightBottomOfHost();
    }

    public void oW() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.Nt.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Nv.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Nv.setVisibility(8);
    }

    public void bJ(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Nt.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001283, new ShareDialogConfig(this.Nt.getPageContext().getPageActivity(), fVar, true, oX())));
        }
    }

    private SparseArray<String> oX() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(7);
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
            this.mNavigationBar.onChangeSkinType(this.Nt.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.Nt, i, ba.getDrawable(u.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Nt.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Nu.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Nt.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.WEBVIEW), com.baidu.tbadk.core.view.w.ac(null, this.Nt.getPageContext().getString(y.url_not_found)), com.baidu.tbadk.core.view.u.a(new com.baidu.tbadk.core.view.t(this.Nt.getResources().getString(y.refresh), this.Nw)));
        }
        this.mNoDataView.onChangeSkinType(this.Nt.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.Nu.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
    }
}
