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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab {
    private MorePopupWindow QA;
    protected View QB;
    private View QC;
    private View QD;
    private int QE;
    private int QF;
    private BaseWebViewActivity Qq;
    private TextView Qs;
    private View Qt;
    private ImageView Qu;
    private ImageView Qv;
    private LinearLayout Qw;
    private TextView Qx;
    private View.OnClickListener Qy;
    private View Qz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected View Qr = null;
    private ProgressBar mProgressBar = null;
    private boolean QG = true;

    public ab(BaseWebViewActivity baseWebViewActivity) {
        this.Qq = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Qq.setContentView(w.j.base_webview_activity);
        this.Qr = this.Qq.findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Qq.findViewById(w.h.view_navigation_bar);
        ce("");
        this.Qw = (LinearLayout) this.Qq.findViewById(w.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Qw.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Qw.setLayoutParams(layoutParams);
        this.Qx = (TextView) this.Qq.findViewById(w.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Qq.findViewById(w.h.webview_progress);
        this.Qt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.widget_nb_item_finish, new ac(this));
        this.Qu = (ImageView) this.Qt.findViewById(w.h.widget_navi_back_button);
        this.Qu.setContentDescription(this.Qq.getResources().getString(w.l.close));
        this.Qz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_more, new ad(this));
        this.Qv = (ImageView) this.Qz.findViewById(w.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Qq.getPageContext().getPageActivity()).inflate(w.j.tb_webview_pop_more, (ViewGroup) null);
        this.QA = new MorePopupWindow(this.Qq.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Qq.getPageContext().getResources().getDrawable(w.g.bg_pull_down_right_n), new ae(this));
        this.QB = inflate.findViewById(w.h.webview_more_pop_item_share_friend_layout);
        this.QB.setOnClickListener(this.Qq);
        if (com.baidu.tbadk.coreExtra.share.i.aP(this.Qq.getPageContext().getPageActivity())) {
            this.QB.setVisibility(0);
        } else {
            this.QB.setVisibility(8);
        }
        this.QA.refresh();
        this.QD = inflate.findViewById(w.h.webview_more_pop_item_open_browser_layout);
        this.QD.setOnClickListener(this.Qq);
        this.QC = inflate.findViewById(w.h.webview_more_pop_item_copy_link_layout);
        this.QC.setOnClickListener(this.Qq);
        nY();
    }

    private void nY() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = com.baidu.adp.lib.util.k.g(this.Qq.getPageContext().getPageActivity(), w.f.ds98);
        int i = com.baidu.adp.lib.util.k.o(this.Qq.getPageContext().getPageActivity()).heightPixels;
        this.QE = (i - statusBarHeight) - g;
        this.QF = i - statusBarHeight;
    }

    public boolean nZ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oa() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Qu != null) {
            as.b(this.Qu, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
    }

    public boolean ob() {
        try {
            this.Qw.addView(this.Qq.createWebView());
            this.Qx.setVisibility(8);
            if (!this.QG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Qx.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Qw.getLayoutParams().height = this.QE;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Qw.getLayoutParams().height = this.QF;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.QB != null) {
            if (z) {
                this.QB.setVisibility(0);
            } else {
                this.QB.setVisibility(8);
            }
            this.QA.refresh();
        }
    }

    public void af(boolean z) {
        if (this.Qz != null) {
            if (z) {
                this.Qz.setVisibility(0);
            } else {
                this.Qz.setVisibility(8);
            }
        }
    }

    public void oc() {
        this.QA.showWindowInRightBottomOfHost();
    }

    public void od() {
        com.baidu.adp.lib.g.j.a(this.QA, this.Qq.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Qx.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Qx.setVisibility(8);
    }

    public void ce(String str) {
        this.Qs = this.mNavigationBar.setTitleText(str);
        as.b(this.Qs, w.e.cp_cont_b, w.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.h hVar) {
        if (hVar != null) {
            TiebaStatic.eventStat(this.Qq.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            au auVar = new au("c10898");
            auVar.Z("obj_url", hVar.linkUrl);
            TiebaStatic.log(auVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Qq.getPageContext().getPageActivity(), hVar, true, oe())));
        }
    }

    private SparseArray<String> oe() {
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
            this.mNavigationBar.onChangeSkinType(this.Qq.getPageContext(), i);
        }
        if (this.QA != null) {
            this.QA.onChangeSkinType(this.Qq, i, as.getDrawable(w.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Qq.getPageContext(), i);
        }
        as.a(this.Qu, w.g.icon_nav_close, w.g.icon_nav_close_w, w.g.icon_nav_close, i);
        as.a(this.Qv, w.g.icon_more_bg_s, w.g.icon_more_bg_s, w.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Qw.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Qq.getPageContext().getPageActivity(), this.Qr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.Qq.getPageContext().getString(w.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Qq.getResources().getString(w.l.refresh), this.Qy)));
        }
        this.mNoDataView.onChangeSkinType(this.Qq.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Qw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.Qy = onClickListener;
    }

    public void release() {
        if (this.Qw != null) {
            this.Qw.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.QA != null) {
            com.baidu.adp.lib.g.j.a(this.QA, this.Qq.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Qw.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Qw.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        as.j(this.Qu, w.g.frs_star_navigation_bg);
        as.j(this.Qv, w.g.frs_star_navigation_bg);
        ce("");
        this.Qq.getWindow().setFlags(1024, 1024);
    }

    public void of() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Qw.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Qw.setLayoutParams(layoutParams);
        this.Qu.setBackgroundDrawable(null);
        this.Qv.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Qq.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.QG = z;
    }
}
