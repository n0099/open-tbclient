package com.baidu.tbadk.browser;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class o {
    protected View SA;
    private View SB;
    private View SC;
    private BaseWebViewActivity Sv;
    private LinearLayout Sw;
    private TextView Sx;
    private View.OnClickListener Sy;
    private View Sz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public o(BaseWebViewActivity baseWebViewActivity) {
        this.Sv = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Sv.setContentView(n.g.base_webview_activity);
        this.mRoot = this.Sv.findViewById(n.f.root_view);
        this.mNavigationBar = (NavigationBar) this.Sv.findViewById(n.f.view_navigation_bar);
        this.Sw = (LinearLayout) this.Sv.findViewById(n.f.webview_container);
        this.Sx = (TextView) this.Sv.findViewById(n.f.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sv.findViewById(n.f.webview_progress);
        this.mNavigationBar = (NavigationBar) this.Sv.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.g.widget_nb_item_finish, new p(this));
        this.Sz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_item_more, new q(this));
        View inflate = LayoutInflater.from(this.Sv.getPageContext().getPageActivity()).inflate(n.g.tb_webview_pop_more, (ViewGroup) null);
        this.mPopWindow = new MorePopupWindow(this.Sv.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sv.getPageContext().getResources().getDrawable(n.e.bg_pull_down_right_n), new r(this));
        this.SA = inflate.findViewById(n.f.webview_more_pop_item_share_friend_layout);
        this.SA.setOnClickListener(this.Sv);
        if (com.baidu.tbadk.coreExtra.share.h.ak(this.Sv.getPageContext().getPageActivity())) {
            this.SA.setVisibility(0);
        } else {
            this.SA.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.SC = inflate.findViewById(n.f.webview_more_pop_item_open_browser_layout);
        this.SC.setOnClickListener(this.Sv);
        this.SB = inflate.findViewById(n.f.webview_more_pop_item_copy_link_layout);
        this.SB.setOnClickListener(this.Sv);
    }

    public boolean qC() {
        try {
            this.Sw.addView(this.Sv.createWebView());
            this.Sx.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.Sx.setVisibility(0);
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

    public void ad(boolean z) {
        if (this.SA != null) {
            if (z) {
                this.SA.setVisibility(0);
            } else {
                this.SA.setVisibility(8);
            }
            this.mPopWindow.refresh();
        }
    }

    public void ae(boolean z) {
        if (this.Sz != null) {
            if (z) {
                this.Sz.setVisibility(0);
            } else {
                this.Sz.setVisibility(8);
            }
        }
    }

    public void qD() {
        this.mPopWindow.showWindowInRightBottomOfHost();
    }

    public void qE() {
        com.baidu.adp.lib.h.j.a(this.mPopWindow, this.Sv.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sx.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sx.setVisibility(8);
    }

    public void cb(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Sv.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.Sv.getPageContext().getPageActivity(), fVar, true, qF())));
        }
    }

    private SparseArray<String> qF() {
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
            this.mNavigationBar.onChangeSkinType(this.Sv.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.Sv, i, as.getDrawable(n.e.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sv.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sw.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sv.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW), NoDataViewFactory.d.ad(null, this.Sv.getPageContext().getString(n.i.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sv.getResources().getString(n.i.refresh), this.Sy)));
        }
        this.mNoDataView.onChangeSkinType(this.Sv.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.Sw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sy = onClickListener;
    }

    public void release() {
        if (this.Sw != null) {
            this.Sw.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.h.j.a(this.mPopWindow, this.Sv.getPageContext().getPageActivity());
        }
    }
}
