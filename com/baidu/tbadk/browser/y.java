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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y {
    private BaseWebViewActivity MI;
    private TextView MK;
    private View ML;
    private ImageView MM;
    private ImageView MN;
    private LinearLayout MO;
    private TextView MP;
    private View.OnClickListener MQ;
    private View MR;
    private MorePopupWindow MS;
    protected View MT;
    private View MU;
    private View MV;
    private int MW;
    private int MX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;
    protected View MJ = null;
    private ProgressBar mProgressBar = null;
    private boolean MY = true;

    public y(BaseWebViewActivity baseWebViewActivity) {
        this.MI = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.MI.setContentView(r.h.base_webview_activity);
        this.MJ = this.MI.findViewById(r.g.root_view);
        this.mNavigationBar = (NavigationBar) this.MI.findViewById(r.g.view_navigation_bar);
        ca("");
        this.MO = (LinearLayout) this.MI.findViewById(r.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MO.getLayoutParams();
        layoutParams.addRule(3, r.g.view_navigation_bar);
        this.MO.setLayoutParams(layoutParams);
        this.MP = (TextView) this.MI.findViewById(r.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.MI.findViewById(r.g.webview_progress);
        this.ML = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.widget_nb_item_finish, new z(this));
        this.MM = (ImageView) this.ML.findViewById(r.g.widget_navi_back_button);
        this.MM.setContentDescription(this.MI.getResources().getString(r.j.close));
        this.MR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_more, new aa(this));
        this.MN = (ImageView) this.MR.findViewById(r.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.MI.getPageContext().getPageActivity()).inflate(r.h.tb_webview_pop_more, (ViewGroup) null);
        this.MS = new MorePopupWindow(this.MI.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.MI.getPageContext().getResources().getDrawable(r.f.bg_pull_down_right_n), new ab(this));
        this.MT = inflate.findViewById(r.g.webview_more_pop_item_share_friend_layout);
        this.MT.setOnClickListener(this.MI);
        if (com.baidu.tbadk.coreExtra.share.h.ak(this.MI.getPageContext().getPageActivity())) {
            this.MT.setVisibility(0);
        } else {
            this.MT.setVisibility(8);
        }
        this.MS.refresh();
        this.MV = inflate.findViewById(r.g.webview_more_pop_item_open_browser_layout);
        this.MV.setOnClickListener(this.MI);
        this.MU = inflate.findViewById(r.g.webview_more_pop_item_copy_link_layout);
        this.MU.setOnClickListener(this.MI);
        nY();
    }

    private void nY() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = com.baidu.adp.lib.util.k.e(this.MI.getPageContext().getPageActivity(), r.e.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.MI.getPageContext().getPageActivity()).heightPixels;
        this.MW = (i - statusBarHeight) - e;
        this.MX = i - statusBarHeight;
    }

    public boolean nZ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oa() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.MM != null) {
            ar.b(this.MM, r.f.icon_return_bg_s, r.f.icon_return_bg);
        }
    }

    public boolean ob() {
        try {
            this.MO.addView(this.MI.createWebView());
            this.MP.setVisibility(8);
            if (!this.MY) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.MP.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.MO.getLayoutParams().height = this.MW;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.MO.getLayoutParams().height = this.MX;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.MT != null) {
            if (z) {
                this.MT.setVisibility(0);
            } else {
                this.MT.setVisibility(8);
            }
            this.MS.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.MR != null) {
            if (z) {
                this.MR.setVisibility(0);
            } else {
                this.MR.setVisibility(8);
            }
        }
    }

    public void oc() {
        this.MS.showWindowInRightBottomOfHost();
    }

    public void od() {
        com.baidu.adp.lib.h.j.a(this.MS, this.MI.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.MP.setVisibility(0);
    }

    public void hideCrashTip() {
        this.MP.setVisibility(8);
    }

    public void ca(String str) {
        this.MK = this.mNavigationBar.setTitleText(str);
        ar.b(this.MK, r.d.cp_cont_b, r.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.MI.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            at atVar = new at("c10898");
            atVar.ab("obj_url", fVar.linkUrl);
            TiebaStatic.log(atVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.MI.getPageContext().getPageActivity(), fVar, true, oe())));
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
            this.mNavigationBar.onChangeSkinType(this.MI.getPageContext(), i);
        }
        if (this.MS != null) {
            this.MS.onChangeSkinType(this.MI, i, ar.getDrawable(r.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.MI.getPageContext(), i);
        }
        ar.a(this.MM, r.f.icon_nav_close, r.f.icon_nav_close_w, r.f.icon_nav_close, i);
        ar.a(this.MN, r.f.icon_more_bg_s, r.f.icon_more_bg_s, r.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.MO.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.MI.getPageContext().getPageActivity(), this.MJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.MI.getPageContext().getString(r.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.MI.getResources().getString(r.j.refresh), this.MQ)));
        }
        this.mNoDataView.onChangeSkinType(this.MI.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.MO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.MQ = onClickListener;
    }

    public void release() {
        if (this.MO != null) {
            this.MO.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.MS != null) {
            com.baidu.adp.lib.h.j.a(this.MS, this.MI.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MO.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.MO.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ar.k(this.MM, r.f.frs_star_navigation_bg);
        ar.k(this.MN, r.f.frs_star_navigation_bg);
        ca("");
        this.MI.getWindow().setFlags(1024, 1024);
    }

    public void of() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MO.getLayoutParams();
        layoutParams.addRule(3, r.g.view_navigation_bar);
        this.MO.setLayoutParams(layoutParams);
        this.MM.setBackgroundDrawable(null);
        this.MN.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.MI.getWindow().clearFlags(1024);
    }

    public void ah(boolean z) {
        this.MY = z;
    }
}
