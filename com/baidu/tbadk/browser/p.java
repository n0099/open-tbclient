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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p {
    private BaseWebViewActivity NK;
    private LinearLayout NL;
    private TextView NM;
    private View.OnClickListener NN;
    private View NO;
    protected View NP;
    private View NQ;
    private View NR;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public p(BaseWebViewActivity baseWebViewActivity) {
        this.NK = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.NK.setContentView(com.baidu.tieba.r.base_webview_activity);
        this.mRoot = this.NK.findViewById(com.baidu.tieba.q.root_view);
        this.mNavigationBar = (NavigationBar) this.NK.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.NL = (LinearLayout) this.NK.findViewById(com.baidu.tieba.q.webview_container);
        this.NM = (TextView) this.NK.findViewById(com.baidu.tieba.q.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.NK.findViewById(com.baidu.tieba.q.webview_progress);
        this.mNavigationBar = (NavigationBar) this.NK.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.widget_nb_item_finish, new q(this));
        this.NO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_more, new r(this));
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.NK.getPageContext().getPageActivity(), com.baidu.tieba.r.tb_webview_pop_more, null);
        this.mPopWindow = new MorePopupWindow(this.NK.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.NK.getPageContext().getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_right_n), new s(this));
        this.NP = inflate.findViewById(com.baidu.tieba.q.webview_more_pop_item_share_friend_layout);
        this.NP.setOnClickListener(this.NK);
        if (com.baidu.tbadk.coreExtra.share.i.ai(this.NK.getPageContext().getPageActivity())) {
            this.NP.setVisibility(0);
        } else {
            this.NP.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.NR = inflate.findViewById(com.baidu.tieba.q.webview_more_pop_item_open_browser_layout);
        this.NR.setOnClickListener(this.NK);
        this.NQ = inflate.findViewById(com.baidu.tieba.q.webview_more_pop_item_copy_link_layout);
        this.NQ.setOnClickListener(this.NK);
    }

    public boolean py() {
        try {
            this.NL.addView(this.NK.createWebView());
            this.NM.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.NM.setVisibility(0);
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

    public void aa(boolean z) {
        if (this.NO != null) {
            if (z) {
                this.NO.setVisibility(0);
            } else {
                this.NO.setVisibility(8);
            }
        }
    }

    public void pz() {
        this.mPopWindow.showWindowInRightBottomOfHost();
    }

    public void pA() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.NK.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.NM.setVisibility(0);
    }

    public void hideCrashTip() {
        this.NM.setVisibility(8);
    }

    public void bW(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.g gVar) {
        if (gVar != null) {
            TiebaStatic.eventStat(this.NK.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001283, new ShareDialogConfig(this.NK.getPageContext().getPageActivity(), gVar, true, pB())));
        }
    }

    private SparseArray<String> pB() {
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
            this.mNavigationBar.onChangeSkinType(this.NK.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.NK, i, ay.getDrawable(com.baidu.tieba.p.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.NK.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.NL.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.NK.getPageContext().getPageActivity(), this.mRoot, aa.a(NoDataViewFactory.ImgType.WEBVIEW), ab.ah(null, this.NK.getPageContext().getString(t.url_not_found)), z.a(new y(this.NK.getResources().getString(t.refresh), this.NN)));
        }
        this.mNoDataView.onChangeSkinType(this.NK.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.NL.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.NN = onClickListener;
    }
}
