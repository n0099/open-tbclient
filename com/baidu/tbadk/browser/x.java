package com.baidu.tbadk.browser;

import android.content.Context;
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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x {
    private BaseWebViewActivity KA;
    private TextView KC;
    private View KD;
    private ImageView KE;
    private LinearLayout KF;
    private TextView KG;
    private View.OnClickListener KH;
    private View KI;
    private MorePopupWindow KJ;
    protected View KK;
    private View KL;
    private View KM;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected View KB = null;
    private ProgressBar mProgressBar = null;

    public x(BaseWebViewActivity baseWebViewActivity) {
        this.KA = baseWebViewActivity;
        nq();
    }

    private void nq() {
        this.KA.setContentView(t.h.base_webview_activity);
        this.KB = this.KA.findViewById(t.g.root_view);
        this.mNavigationBar = (NavigationBar) this.KA.findViewById(t.g.view_navigation_bar);
        bX("");
        this.KF = (LinearLayout) this.KA.findViewById(t.g.webview_container);
        this.KG = (TextView) this.KA.findViewById(t.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.KA.findViewById(t.g.webview_progress);
        this.KD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.widget_nb_item_finish, new y(this));
        this.KE = (ImageView) this.KD.findViewById(t.g.widget_navi_back_button);
        this.KE.setContentDescription(this.KA.getResources().getString(t.j.close));
        this.KI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_more, new z(this));
        View inflate = LayoutInflater.from(this.KA.getPageContext().getPageActivity()).inflate(t.h.tb_webview_pop_more, (ViewGroup) null);
        this.KJ = new MorePopupWindow(this.KA.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.KA.getPageContext().getResources().getDrawable(t.f.bg_pull_down_right_n), new aa(this));
        this.KK = inflate.findViewById(t.g.webview_more_pop_item_share_friend_layout);
        this.KK.setOnClickListener(this.KA);
        if (com.baidu.tbadk.coreExtra.share.h.af(this.KA.getPageContext().getPageActivity())) {
            this.KK.setVisibility(0);
        } else {
            this.KK.setVisibility(8);
        }
        this.KJ.refresh();
        this.KM = inflate.findViewById(t.g.webview_more_pop_item_open_browser_layout);
        this.KM.setOnClickListener(this.KA);
        this.KL = inflate.findViewById(t.g.webview_more_pop_item_copy_link_layout);
        this.KL.setOnClickListener(this.KA);
    }

    public boolean nr() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void ns() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.KE != null) {
            at.a(this.KE, t.f.icon_return_bg_s, t.f.icon_return_bg);
        }
    }

    public boolean nt() {
        try {
            this.KF.addView(this.KA.createWebView());
            this.KG.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.KG.setVisibility(0);
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
        if (this.KK != null) {
            if (z) {
                this.KK.setVisibility(0);
            } else {
                this.KK.setVisibility(8);
            }
            this.KJ.refresh();
        }
    }

    public void ad(boolean z) {
        if (this.KI != null) {
            if (z) {
                this.KI.setVisibility(0);
            } else {
                this.KI.setVisibility(8);
            }
        }
    }

    public void nu() {
        this.KJ.showWindowInRightBottomOfHost();
    }

    public void nv() {
        com.baidu.adp.lib.h.j.a(this.KJ, this.KA.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.KG.setVisibility(0);
    }

    public void hideCrashTip() {
        this.KG.setVisibility(8);
    }

    public void bX(String str) {
        this.KC = this.mNavigationBar.setTitleText(str);
        at.b(this.KC, t.d.cp_cont_b, t.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.KA.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aw awVar = new aw("c10898");
            awVar.ac("obj_url", fVar.linkUrl);
            TiebaStatic.log(awVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.KA.getPageContext().getPageActivity(), fVar, true, nw())));
        }
    }

    private SparseArray<String> nw() {
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
            this.mNavigationBar.onChangeSkinType(this.KA.getPageContext(), i);
        }
        if (this.KJ != null) {
            this.KJ.onChangeSkinType(this.KA, i, at.getDrawable(t.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.KA.getPageContext(), i);
        }
        at.a(this.KE, t.f.icon_nav_close, t.f.icon_nav_close_w, t.f.icon_nav_close, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.KF.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.KA.getPageContext().getPageActivity(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ag(null, this.KA.getPageContext().getString(t.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.KA.getResources().getString(t.j.refresh), this.KH)));
        }
        this.mNoDataView.onChangeSkinType(this.KA.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        this.KF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.KH = onClickListener;
    }

    public void release() {
        if (this.KF != null) {
            this.KF.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.KJ != null) {
            com.baidu.adp.lib.h.j.a(this.KJ, this.KA.getPageContext().getPageActivity());
        }
    }
}
