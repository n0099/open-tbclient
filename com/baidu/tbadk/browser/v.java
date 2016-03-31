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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class v {
    private BaseWebViewActivity PK;
    private View PM;
    private ImageView PN;
    private LinearLayout PO;
    private TextView PP;
    private View.OnClickListener PQ;
    private View PR;
    private MorePopupWindow PS;
    protected View PT;
    private View PU;
    private View PV;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;
    protected View PL = null;
    private ProgressBar mProgressBar = null;

    public v(BaseWebViewActivity baseWebViewActivity) {
        this.PK = baseWebViewActivity;
        pU();
    }

    private void pU() {
        this.PK.setContentView(t.h.base_webview_activity);
        this.PL = this.PK.findViewById(t.g.root_view);
        this.mNavigationBar = (NavigationBar) this.PK.findViewById(t.g.view_navigation_bar);
        this.PO = (LinearLayout) this.PK.findViewById(t.g.webview_container);
        this.PP = (TextView) this.PK.findViewById(t.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.PK.findViewById(t.g.webview_progress);
        this.mNavigationBar = (NavigationBar) this.PK.findViewById(t.g.view_navigation_bar);
        this.PM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.widget_nb_item_finish, new w(this));
        this.PN = (ImageView) this.PM.findViewById(t.g.widget_navi_back_button);
        this.PR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_more, new x(this));
        View inflate = LayoutInflater.from(this.PK.getPageContext().getPageActivity()).inflate(t.h.tb_webview_pop_more, (ViewGroup) null);
        this.PS = new MorePopupWindow(this.PK.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.PK.getPageContext().getResources().getDrawable(t.f.bg_pull_down_right_n), new y(this));
        this.PT = inflate.findViewById(t.g.webview_more_pop_item_share_friend_layout);
        this.PT.setOnClickListener(this.PK);
        if (com.baidu.tbadk.coreExtra.share.h.ag(this.PK.getPageContext().getPageActivity())) {
            this.PT.setVisibility(0);
        } else {
            this.PT.setVisibility(8);
        }
        this.PS.refresh();
        this.PV = inflate.findViewById(t.g.webview_more_pop_item_open_browser_layout);
        this.PV.setOnClickListener(this.PK);
        this.PU = inflate.findViewById(t.g.webview_more_pop_item_copy_link_layout);
        this.PU.setOnClickListener(this.PK);
    }

    public boolean pV() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void pW() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.PN != null) {
            at.a(this.PN, t.f.icon_return_bg_s, t.f.icon_return_bg);
        }
    }

    public boolean pX() {
        try {
            this.PO.addView(this.PK.createWebView());
            this.PP.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.PP.setVisibility(0);
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

    public void Z(boolean z) {
        if (this.PT != null) {
            if (z) {
                this.PT.setVisibility(0);
            } else {
                this.PT.setVisibility(8);
            }
            this.PS.refresh();
        }
    }

    public void aa(boolean z) {
        if (this.PR != null) {
            if (z) {
                this.PR.setVisibility(0);
            } else {
                this.PR.setVisibility(8);
            }
        }
    }

    public void pY() {
        this.PS.showWindowInRightBottomOfHost();
    }

    public void pZ() {
        com.baidu.adp.lib.h.j.a(this.PS, this.PK.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.PP.setVisibility(0);
    }

    public void hideCrashTip() {
        this.PP.setVisibility(8);
    }

    public void bZ(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.PK.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aw awVar = new aw("c10898");
            awVar.ac("obj_url", fVar.linkUrl);
            TiebaStatic.log(awVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.PK.getPageContext().getPageActivity(), fVar, true, qa())));
        }
    }

    private SparseArray<String> qa() {
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
            this.mNavigationBar.onChangeSkinType(this.PK.getPageContext(), i);
        }
        if (this.PS != null) {
            this.PS.onChangeSkinType(this.PK, i, at.getDrawable(t.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.PK.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.PO.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.PK.getPageContext().getPageActivity(), this.PL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW), NoDataViewFactory.d.ag(null, this.PK.getPageContext().getString(t.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.PK.getResources().getString(t.j.refresh), this.PQ)));
        }
        this.mNoDataView.onChangeSkinType(this.PK.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.PO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.PQ = onClickListener;
    }

    public void release() {
        if (this.PO != null) {
            this.PO.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.PS != null) {
            com.baidu.adp.lib.h.j.a(this.PS, this.PK.getPageContext().getPageActivity());
        }
    }
}
