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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p {
    private BaseWebViewActivity Sm;
    private View So;
    private ImageView Sp;
    private LinearLayout Sq;
    private TextView Sr;
    private View.OnClickListener Ss;
    private View St;
    private MorePopupWindow Su;
    protected View Sv;
    private View Sw;
    private View Sx;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    protected View Sn = null;
    private ProgressBar mProgressBar = null;

    public p(BaseWebViewActivity baseWebViewActivity) {
        this.Sm = baseWebViewActivity;
        qD();
    }

    private void qD() {
        this.Sm.setContentView(t.h.base_webview_activity);
        this.Sn = this.Sm.findViewById(t.g.root_view);
        this.mNavigationBar = (NavigationBar) this.Sm.findViewById(t.g.view_navigation_bar);
        this.Sq = (LinearLayout) this.Sm.findViewById(t.g.webview_container);
        this.Sr = (TextView) this.Sm.findViewById(t.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sm.findViewById(t.g.webview_progress);
        this.mNavigationBar = (NavigationBar) this.Sm.findViewById(t.g.view_navigation_bar);
        this.So = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.widget_nb_item_finish, new q(this));
        this.Sp = (ImageView) this.So.findViewById(t.g.widget_navi_back_button);
        this.St = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_more, new r(this));
        View inflate = LayoutInflater.from(this.Sm.getPageContext().getPageActivity()).inflate(t.h.tb_webview_pop_more, (ViewGroup) null);
        this.Su = new MorePopupWindow(this.Sm.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sm.getPageContext().getResources().getDrawable(t.f.bg_pull_down_right_n), new s(this));
        this.Sv = inflate.findViewById(t.g.webview_more_pop_item_share_friend_layout);
        this.Sv.setOnClickListener(this.Sm);
        if (com.baidu.tbadk.coreExtra.share.h.aj(this.Sm.getPageContext().getPageActivity())) {
            this.Sv.setVisibility(0);
        } else {
            this.Sv.setVisibility(8);
        }
        this.Su.refresh();
        this.Sx = inflate.findViewById(t.g.webview_more_pop_item_open_browser_layout);
        this.Sx.setOnClickListener(this.Sm);
        this.Sw = inflate.findViewById(t.g.webview_more_pop_item_copy_link_layout);
        this.Sw.setOnClickListener(this.Sm);
    }

    public boolean qE() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void qF() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Sp != null) {
            ar.a(this.Sp, t.f.icon_return_bg_s, t.f.icon_return_bg);
        }
    }

    public boolean qG() {
        try {
            this.Sq.addView(this.Sm.createWebView());
            this.Sr.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.Sr.setVisibility(0);
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
        if (this.Sv != null) {
            if (z) {
                this.Sv.setVisibility(0);
            } else {
                this.Sv.setVisibility(8);
            }
            this.Su.refresh();
        }
    }

    public void ab(boolean z) {
        if (this.St != null) {
            if (z) {
                this.St.setVisibility(0);
            } else {
                this.St.setVisibility(8);
            }
        }
    }

    public void qH() {
        this.Su.showWindowInRightBottomOfHost();
    }

    public void qI() {
        com.baidu.adp.lib.h.j.a(this.Su, this.Sm.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sr.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sr.setVisibility(8);
    }

    public void cc(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Sm.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.Sm.getPageContext().getPageActivity(), fVar, true, qJ())));
        }
    }

    private SparseArray<String> qJ() {
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
            this.mNavigationBar.onChangeSkinType(this.Sm.getPageContext(), i);
        }
        if (this.Su != null) {
            this.Su.onChangeSkinType(this.Sm, i, ar.getDrawable(t.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sm.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sq.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sm.getPageContext().getPageActivity(), this.Sn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW), NoDataViewFactory.d.ac(null, this.Sm.getPageContext().getString(t.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sm.getResources().getString(t.j.refresh), this.Ss)));
        }
        this.mNoDataView.onChangeSkinType(this.Sm.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.Sq.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.Ss = onClickListener;
    }

    public void release() {
        if (this.Sq != null) {
            this.Sq.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Su != null) {
            com.baidu.adp.lib.h.j.a(this.Su, this.Sm.getPageContext().getPageActivity());
        }
    }
}
