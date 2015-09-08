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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o {
    private BaseWebViewActivity Ss;
    private LinearLayout St;
    private TextView Su;
    private View.OnClickListener Sv;
    private View Sw;
    protected View Sx;
    private View Sy;
    private View Sz;
    private NavigationBar mNavigationBar;
    private u mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public o(BaseWebViewActivity baseWebViewActivity) {
        this.Ss = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Ss.setContentView(i.g.base_webview_activity);
        this.mRoot = this.Ss.findViewById(i.f.root_view);
        this.mNavigationBar = (NavigationBar) this.Ss.findViewById(i.f.view_navigation_bar);
        this.St = (LinearLayout) this.Ss.findViewById(i.f.webview_container);
        this.Su = (TextView) this.Ss.findViewById(i.f.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Ss.findViewById(i.f.webview_progress);
        this.mNavigationBar = (NavigationBar) this.Ss.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.widget_nb_item_finish, new p(this));
        this.Sw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_more, new q(this));
        View inflate = LayoutInflater.from(this.Ss.getPageContext().getPageActivity()).inflate(i.g.tb_webview_pop_more, (ViewGroup) null);
        this.mPopWindow = new MorePopupWindow(this.Ss.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Ss.getPageContext().getResources().getDrawable(i.e.bg_pull_down_right_n), new r(this));
        this.Sx = inflate.findViewById(i.f.webview_more_pop_item_share_friend_layout);
        this.Sx.setOnClickListener(this.Ss);
        if (com.baidu.tbadk.coreExtra.share.h.ak(this.Ss.getPageContext().getPageActivity())) {
            this.Sx.setVisibility(0);
        } else {
            this.Sx.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.Sz = inflate.findViewById(i.f.webview_more_pop_item_open_browser_layout);
        this.Sz.setOnClickListener(this.Ss);
        this.Sy = inflate.findViewById(i.f.webview_more_pop_item_copy_link_layout);
        this.Sy.setOnClickListener(this.Ss);
    }

    public boolean qw() {
        try {
            this.St.addView(this.Ss.createWebView());
            this.Su.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.Su.setVisibility(0);
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

    public void ac(boolean z) {
        if (this.Sw != null) {
            if (z) {
                this.Sw.setVisibility(0);
            } else {
                this.Sw.setVisibility(8);
            }
        }
    }

    public void qx() {
        this.mPopWindow.showWindowInRightBottomOfHost();
    }

    public void qy() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.Ss.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Su.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Su.setVisibility(8);
    }

    public void bW(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Ss.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.Ss.getPageContext().getPageActivity(), fVar, true, qz())));
        }
    }

    private SparseArray<String> qz() {
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
            this.mNavigationBar.onChangeSkinType(this.Ss.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.Ss, i, al.getDrawable(i.e.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Ss.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.St.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Ss.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW), NoDataViewFactory.d.ah(null, this.Ss.getPageContext().getString(i.h.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Ss.getResources().getString(i.h.refresh), this.Sv)));
        }
        this.mNoDataView.onChangeSkinType(this.Ss.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.St.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sv = onClickListener;
    }

    public void release() {
        if (this.St != null) {
            this.St.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.Ss.getPageContext().getPageActivity());
        }
    }
}
