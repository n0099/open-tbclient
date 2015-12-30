package com.baidu.tbadk.browser;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private BaseWebViewActivity ST;
    private View SU;
    private ImageView SV;
    private LinearLayout SW;
    private TextView SX;
    private View.OnClickListener SY;
    private View SZ;
    protected View Ta;
    private View Tb;
    private View Tc;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public o(BaseWebViewActivity baseWebViewActivity) {
        this.ST = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.ST.setContentView(n.h.base_webview_activity);
        this.mRoot = this.ST.findViewById(n.g.root_view);
        this.mNavigationBar = (NavigationBar) this.ST.findViewById(n.g.view_navigation_bar);
        this.SW = (LinearLayout) this.ST.findViewById(n.g.webview_container);
        this.SX = (TextView) this.ST.findViewById(n.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.ST.findViewById(n.g.webview_progress);
        this.mNavigationBar = (NavigationBar) this.ST.findViewById(n.g.view_navigation_bar);
        this.SU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.h.widget_nb_item_finish, new p(this));
        this.SV = (ImageView) this.SU.findViewById(n.g.widget_navi_back_button);
        this.SZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_item_more, new q(this));
        View inflate = LayoutInflater.from(this.ST.getPageContext().getPageActivity()).inflate(n.h.tb_webview_pop_more, (ViewGroup) null);
        this.mPopWindow = new MorePopupWindow(this.ST.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.ST.getPageContext().getResources().getDrawable(n.f.bg_pull_down_right_n), new r(this));
        this.Ta = inflate.findViewById(n.g.webview_more_pop_item_share_friend_layout);
        this.Ta.setOnClickListener(this.ST);
        if (com.baidu.tbadk.coreExtra.share.h.aj(this.ST.getPageContext().getPageActivity())) {
            this.Ta.setVisibility(0);
        } else {
            this.Ta.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.Tc = inflate.findViewById(n.g.webview_more_pop_item_open_browser_layout);
        this.Tc.setOnClickListener(this.ST);
        this.Tb = inflate.findViewById(n.g.webview_more_pop_item_copy_link_layout);
        this.Tb.setOnClickListener(this.ST);
    }

    public boolean qj() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void qk() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.SV != null) {
            as.a(this.SV, n.f.icon_return_bg_s, n.f.icon_return_bg);
        }
    }

    public boolean ql() {
        try {
            this.SW.addView(this.ST.createWebView());
            this.SX.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.SX.setVisibility(0);
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
        if (this.Ta != null) {
            if (z) {
                this.Ta.setVisibility(0);
            } else {
                this.Ta.setVisibility(8);
            }
            this.mPopWindow.refresh();
        }
    }

    public void ab(boolean z) {
        if (this.SZ != null) {
            if (z) {
                this.SZ.setVisibility(0);
            } else {
                this.SZ.setVisibility(8);
            }
        }
    }

    public void qm() {
        this.mPopWindow.showWindowInRightBottomOfHost();
    }

    public void qn() {
        com.baidu.adp.lib.h.j.a(this.mPopWindow, this.ST.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.SX.setVisibility(0);
    }

    public void hideCrashTip() {
        this.SX.setVisibility(8);
    }

    public void cd(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.ST.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.ST.getPageContext().getPageActivity(), fVar, true, qo())));
        }
    }

    private SparseArray<String> qo() {
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
            this.mNavigationBar.onChangeSkinType(this.ST.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.ST, i, as.getDrawable(n.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ST.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.SW.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ST.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW), NoDataViewFactory.d.ac(null, this.ST.getPageContext().getString(n.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ST.getResources().getString(n.j.refresh), this.SY)));
        }
        this.mNoDataView.onChangeSkinType(this.ST.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.SW.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.SY = onClickListener;
    }

    public void release() {
        if (this.SW != null) {
            this.SW.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.h.j.a(this.mPopWindow, this.ST.getPageContext().getPageActivity());
        }
    }
}
