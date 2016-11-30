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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y {
    private BaseWebViewActivity MK;
    private TextView MN;
    private View MO;
    private ImageView MP;
    private ImageView MQ;
    private LinearLayout MR;
    private TextView MS;
    private View.OnClickListener MT;
    private View MU;
    private MorePopupWindow MV;
    protected View MW;
    private View MX;
    private View MY;
    private int MZ;
    private int Na;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;
    protected View MM = null;
    private ProgressBar mProgressBar = null;
    private boolean Nb = true;

    public y(BaseWebViewActivity baseWebViewActivity) {
        this.MK = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.MK.setContentView(r.h.base_webview_activity);
        this.MM = this.MK.findViewById(r.g.root_view);
        this.mNavigationBar = (NavigationBar) this.MK.findViewById(r.g.view_navigation_bar);
        bZ("");
        this.MR = (LinearLayout) this.MK.findViewById(r.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MR.getLayoutParams();
        layoutParams.addRule(3, r.g.view_navigation_bar);
        this.MR.setLayoutParams(layoutParams);
        this.MS = (TextView) this.MK.findViewById(r.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.MK.findViewById(r.g.webview_progress);
        this.MO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.widget_nb_item_finish, new z(this));
        this.MP = (ImageView) this.MO.findViewById(r.g.widget_navi_back_button);
        this.MP.setContentDescription(this.MK.getResources().getString(r.j.close));
        this.MU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_more, new aa(this));
        this.MQ = (ImageView) this.MU.findViewById(r.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.MK.getPageContext().getPageActivity()).inflate(r.h.tb_webview_pop_more, (ViewGroup) null);
        this.MV = new MorePopupWindow(this.MK.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.MK.getPageContext().getResources().getDrawable(r.f.bg_pull_down_right_n), new ab(this));
        this.MW = inflate.findViewById(r.g.webview_more_pop_item_share_friend_layout);
        this.MW.setOnClickListener(this.MK);
        if (com.baidu.tbadk.coreExtra.share.h.am(this.MK.getPageContext().getPageActivity())) {
            this.MW.setVisibility(0);
        } else {
            this.MW.setVisibility(8);
        }
        this.MV.refresh();
        this.MY = inflate.findViewById(r.g.webview_more_pop_item_open_browser_layout);
        this.MY.setOnClickListener(this.MK);
        this.MX = inflate.findViewById(r.g.webview_more_pop_item_copy_link_layout);
        this.MX.setOnClickListener(this.MK);
        nY();
    }

    private void nY() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = com.baidu.adp.lib.util.k.e(this.MK.getPageContext().getPageActivity(), r.e.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.MK.getPageContext().getPageActivity()).heightPixels;
        this.MZ = (i - statusBarHeight) - e;
        this.Na = i - statusBarHeight;
    }

    public boolean nZ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oa() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.MP != null) {
            at.b(this.MP, r.f.icon_return_bg_s, r.f.icon_return_bg);
        }
    }

    public boolean ob() {
        try {
            this.MR.addView(this.MK.createWebView());
            this.MS.setVisibility(8);
            if (!this.Nb) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.MS.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.MR.getLayoutParams().height = this.MZ;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.MR.getLayoutParams().height = this.Na;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.MW != null) {
            if (z) {
                this.MW.setVisibility(0);
            } else {
                this.MW.setVisibility(8);
            }
            this.MV.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.MU != null) {
            if (z) {
                this.MU.setVisibility(0);
            } else {
                this.MU.setVisibility(8);
            }
        }
    }

    public void oc() {
        this.MV.showWindowInRightBottomOfHost();
    }

    public void od() {
        com.baidu.adp.lib.h.j.a(this.MV, this.MK.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.MS.setVisibility(0);
    }

    public void hideCrashTip() {
        this.MS.setVisibility(8);
    }

    public void bZ(String str) {
        this.MN = this.mNavigationBar.setTitleText(str);
        at.b(this.MN, r.d.cp_cont_b, r.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.MK.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            av avVar = new av("c10898");
            avVar.ab("obj_url", fVar.linkUrl);
            TiebaStatic.log(avVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.MK.getPageContext().getPageActivity(), fVar, true, oe())));
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
            this.mNavigationBar.onChangeSkinType(this.MK.getPageContext(), i);
        }
        if (this.MV != null) {
            this.MV.onChangeSkinType(this.MK, i, at.getDrawable(r.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.MK.getPageContext(), i);
        }
        at.a(this.MP, r.f.icon_nav_close, r.f.icon_nav_close_w, r.f.icon_nav_close, i);
        at.a(this.MQ, r.f.icon_more_bg_s, r.f.icon_more_bg_s, r.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.MR.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.MK.getPageContext().getPageActivity(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.MK.getPageContext().getString(r.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.MK.getResources().getString(r.j.refresh), this.MT)));
        }
        this.mNoDataView.onChangeSkinType(this.MK.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.MR.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
    }

    public void release() {
        if (this.MR != null) {
            this.MR.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.MV != null) {
            com.baidu.adp.lib.h.j.a(this.MV, this.MK.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MR.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.MR.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        at.k(this.MP, r.f.frs_star_navigation_bg);
        at.k(this.MQ, r.f.frs_star_navigation_bg);
        bZ("");
        this.MK.getWindow().setFlags(1024, 1024);
    }

    public void of() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MR.getLayoutParams();
        layoutParams.addRule(3, r.g.view_navigation_bar);
        this.MR.setLayoutParams(layoutParams);
        this.MP.setBackgroundDrawable(null);
        this.MQ.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.MK.getWindow().clearFlags(1024);
    }

    public void ah(boolean z) {
        this.Nb = z;
    }
}
