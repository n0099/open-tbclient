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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class z {
    private BaseWebViewActivity QJ;
    private TextView QL;
    private View QM;
    private ImageView QN;
    private ImageView QO;
    private LinearLayout QP;
    private TextView QR;
    private View.OnClickListener QS;
    private View QT;
    private MorePopupWindow QU;
    protected View QV;
    private View QW;
    private View QX;
    private int QY;
    private int QZ;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected View QK = null;
    private ProgressBar mProgressBar = null;
    private boolean Ra = true;

    public z(BaseWebViewActivity baseWebViewActivity) {
        this.QJ = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.QJ.setContentView(w.j.base_webview_activity);
        this.QK = this.QJ.findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) this.QJ.findViewById(w.h.view_navigation_bar);
        bY("");
        this.QP = (LinearLayout) this.QJ.findViewById(w.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QP.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.QP.setLayoutParams(layoutParams);
        this.QR = (TextView) this.QJ.findViewById(w.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.QJ.findViewById(w.h.webview_progress);
        this.QM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.widget_nb_item_finish, new aa(this));
        this.QN = (ImageView) this.QM.findViewById(w.h.widget_navi_back_button);
        this.QN.setContentDescription(this.QJ.getResources().getString(w.l.close));
        this.QT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_more, new ab(this));
        this.QO = (ImageView) this.QT.findViewById(w.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.QJ.getPageContext().getPageActivity()).inflate(w.j.tb_webview_pop_more, (ViewGroup) null);
        this.QU = new MorePopupWindow(this.QJ.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.QJ.getPageContext().getResources().getDrawable(w.g.bg_pull_down_right_n), new ac(this));
        this.QV = inflate.findViewById(w.h.webview_more_pop_item_share_friend_layout);
        this.QV.setOnClickListener(this.QJ);
        if (com.baidu.tbadk.coreExtra.share.i.aP(this.QJ.getPageContext().getPageActivity())) {
            this.QV.setVisibility(0);
        } else {
            this.QV.setVisibility(8);
        }
        this.QU.refresh();
        this.QX = inflate.findViewById(w.h.webview_more_pop_item_open_browser_layout);
        this.QX.setOnClickListener(this.QJ);
        this.QW = inflate.findViewById(w.h.webview_more_pop_item_copy_link_layout);
        this.QW.setOnClickListener(this.QJ);
        ok();
    }

    private void ok() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = com.baidu.adp.lib.util.k.g(this.QJ.getPageContext().getPageActivity(), w.f.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.QJ.getPageContext().getPageActivity()).heightPixels;
        this.QY = (i - statusBarHeight) - g;
        this.QZ = i - statusBarHeight;
    }

    public boolean ol() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void om() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.QN != null) {
            aq.b(this.QN, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
    }

    public boolean on() {
        try {
            this.QP.addView(this.QJ.createWebView());
            this.QR.setVisibility(8);
            if (!this.Ra) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.QR.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.QP.getLayoutParams().height = this.QY;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.QP.getLayoutParams().height = this.QZ;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.QV != null) {
            if (z) {
                this.QV.setVisibility(0);
            } else {
                this.QV.setVisibility(8);
            }
            this.QU.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.QT != null) {
            if (z) {
                this.QT.setVisibility(0);
            } else {
                this.QT.setVisibility(8);
            }
        }
    }

    public void oo() {
        this.QU.showWindowInRightBottomOfHost();
    }

    public void op() {
        com.baidu.adp.lib.g.j.a(this.QU, this.QJ.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.QR.setVisibility(0);
    }

    public void hideCrashTip() {
        this.QR.setVisibility(8);
    }

    public void bY(String str) {
        this.QL = this.mNavigationBar.setTitleText(str);
        aq.b(this.QL, w.e.cp_cont_b, w.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.h hVar) {
        if (hVar != null) {
            TiebaStatic.eventStat(this.QJ.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            as asVar = new as("c10898");
            asVar.aa("obj_url", hVar.linkUrl);
            TiebaStatic.log(asVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.QJ.getPageContext().getPageActivity(), hVar, true, oq())));
        }
    }

    private SparseArray<String> oq() {
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
            this.mNavigationBar.onChangeSkinType(this.QJ.getPageContext(), i);
        }
        if (this.QU != null) {
            this.QU.onChangeSkinType(this.QJ, i, aq.getDrawable(w.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.QJ.getPageContext(), i);
        }
        aq.a(this.QN, w.g.icon_nav_close, w.g.icon_nav_close_w, w.g.icon_nav_close, i);
        aq.a(this.QO, w.g.icon_more_bg_s, w.g.icon_more_bg_s, w.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.QP.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.QJ.getPageContext().getPageActivity(), this.QK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.QJ.getPageContext().getString(w.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.QJ.getResources().getString(w.l.refresh), this.QS)));
        }
        this.mNoDataView.onChangeSkinType(this.QJ.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.QP.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.QS = onClickListener;
    }

    public void release() {
        if (this.QP != null) {
            this.QP.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.QU != null) {
            com.baidu.adp.lib.g.j.a(this.QU, this.QJ.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QP.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.QP.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aq.j(this.QN, w.g.frs_star_navigation_bg);
        aq.j(this.QO, w.g.frs_star_navigation_bg);
        bY("");
        this.QJ.getWindow().setFlags(1024, 1024);
    }

    public void or() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QP.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.QP.setLayoutParams(layoutParams);
        this.QN.setBackgroundDrawable(null);
        this.QO.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.QJ.getWindow().clearFlags(1024);
    }

    public void ah(boolean z) {
        this.Ra = z;
    }
}
