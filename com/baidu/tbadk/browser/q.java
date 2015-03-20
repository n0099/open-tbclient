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
    private BaseWebViewActivity Nr;
    private LinearLayout Ns;
    private TextView Nt;
    private View.OnClickListener Nu;
    protected View Nv;
    private View Nw;
    private View Nx;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public q(BaseWebViewActivity baseWebViewActivity) {
        this.Nr = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Nr.setContentView(w.base_webview_activity);
        this.mRoot = this.Nr.findViewById(v.root_view);
        this.mNavigationBar = (NavigationBar) this.Nr.findViewById(v.view_navigation_bar);
        this.Ns = (LinearLayout) this.Nr.findViewById(v.webview_container);
        this.Nt = (TextView) this.Nr.findViewById(v.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Nr.findViewById(v.webview_progress);
        this.mNavigationBar = (NavigationBar) this.Nr.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.widget_nb_item_finish, new r(this));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_more, new s(this));
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.Nr.getPageContext().getPageActivity(), w.tb_webview_pop_more, null);
        this.mPopWindow = new MorePopupWindow(this.Nr.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Nr.getPageContext().getResources().getDrawable(u.bg_pull_down_right_n), new t(this));
        this.Nv = inflate.findViewById(v.webview_more_pop_item_share_friend_layout);
        this.Nv.setOnClickListener(this.Nr);
        if (com.baidu.tbadk.coreExtra.share.i.ae(this.Nr.getPageContext().getPageActivity())) {
            this.Nv.setVisibility(0);
        } else {
            this.Nv.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.Nx = inflate.findViewById(v.webview_more_pop_item_open_browser_layout);
        this.Nx.setOnClickListener(this.Nr);
        this.Nw = inflate.findViewById(v.webview_more_pop_item_copy_link_layout);
        this.Nw.setOnClickListener(this.Nr);
    }

    public boolean oU() {
        try {
            this.Ns.addView(this.Nr.createWebView());
            this.Nt.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.Nt.setVisibility(0);
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
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.Nr.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Nt.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Nt.setVisibility(8);
    }

    public void bJ(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Nr.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001283, new ShareDialogConfig(this.Nr.getPageContext().getPageActivity(), fVar, true, oX())));
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
            this.mNavigationBar.onChangeSkinType(this.Nr.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.Nr, i, ba.getDrawable(u.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Nr.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ns.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Nr.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.WEBVIEW), com.baidu.tbadk.core.view.w.ac(null, this.Nr.getPageContext().getString(y.url_not_found)), com.baidu.tbadk.core.view.u.a(new com.baidu.tbadk.core.view.t(this.Nr.getResources().getString(y.refresh), this.Nu)));
        }
        this.mNoDataView.onChangeSkinType(this.Nr.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.Ns.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.Nu = onClickListener;
    }
}
