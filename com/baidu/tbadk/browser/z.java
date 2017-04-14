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
    private MorePopupWindow RA;
    protected View RB;
    private View RC;
    private View RD;
    private int RE;
    private int RF;
    private BaseWebViewActivity Rq;
    private TextView Rs;
    private View Rt;
    private ImageView Ru;
    private ImageView Rv;
    private LinearLayout Rw;
    private TextView Rx;
    private View.OnClickListener Ry;
    private View Rz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected View Rr = null;
    private ProgressBar mProgressBar = null;
    private boolean RG = true;

    public z(BaseWebViewActivity baseWebViewActivity) {
        this.Rq = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Rq.setContentView(w.j.base_webview_activity);
        this.Rr = this.Rq.findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Rq.findViewById(w.h.view_navigation_bar);
        bY("");
        this.Rw = (LinearLayout) this.Rq.findViewById(w.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Rw.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Rw.setLayoutParams(layoutParams);
        this.Rx = (TextView) this.Rq.findViewById(w.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Rq.findViewById(w.h.webview_progress);
        this.Rt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.widget_nb_item_finish, new aa(this));
        this.Ru = (ImageView) this.Rt.findViewById(w.h.widget_navi_back_button);
        this.Ru.setContentDescription(this.Rq.getResources().getString(w.l.close));
        this.Rz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_more, new ab(this));
        this.Rv = (ImageView) this.Rz.findViewById(w.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Rq.getPageContext().getPageActivity()).inflate(w.j.tb_webview_pop_more, (ViewGroup) null);
        this.RA = new MorePopupWindow(this.Rq.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Rq.getPageContext().getResources().getDrawable(w.g.bg_pull_down_right_n), new ac(this));
        this.RB = inflate.findViewById(w.h.webview_more_pop_item_share_friend_layout);
        this.RB.setOnClickListener(this.Rq);
        if (com.baidu.tbadk.coreExtra.share.h.aM(this.Rq.getPageContext().getPageActivity())) {
            this.RB.setVisibility(0);
        } else {
            this.RB.setVisibility(8);
        }
        this.RA.refresh();
        this.RD = inflate.findViewById(w.h.webview_more_pop_item_open_browser_layout);
        this.RD.setOnClickListener(this.Rq);
        this.RC = inflate.findViewById(w.h.webview_more_pop_item_copy_link_layout);
        this.RC.setOnClickListener(this.Rq);
        oD();
    }

    private void oD() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = com.baidu.adp.lib.util.k.g(this.Rq.getPageContext().getPageActivity(), w.f.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.Rq.getPageContext().getPageActivity()).heightPixels;
        this.RE = (i - statusBarHeight) - g;
        this.RF = i - statusBarHeight;
    }

    public boolean oE() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oF() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Ru != null) {
            aq.b(this.Ru, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
    }

    public boolean oG() {
        try {
            this.Rw.addView(this.Rq.createWebView());
            this.Rx.setVisibility(8);
            if (!this.RG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Rx.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Rw.getLayoutParams().height = this.RE;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Rw.getLayoutParams().height = this.RF;
        this.mNavigationBar.setVisibility(8);
    }

    public void ag(boolean z) {
        if (this.RB != null) {
            if (z) {
                this.RB.setVisibility(0);
            } else {
                this.RB.setVisibility(8);
            }
            this.RA.refresh();
        }
    }

    public void ah(boolean z) {
        if (this.Rz != null) {
            if (z) {
                this.Rz.setVisibility(0);
            } else {
                this.Rz.setVisibility(8);
            }
        }
    }

    public void oH() {
        this.RA.showWindowInRightBottomOfHost();
    }

    public void oI() {
        com.baidu.adp.lib.g.j.a(this.RA, this.Rq.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Rx.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Rx.setVisibility(8);
    }

    public void bY(String str) {
        this.Rs = this.mNavigationBar.setTitleText(str);
        aq.b(this.Rs, w.e.cp_cont_b, w.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.g gVar) {
        if (gVar != null) {
            TiebaStatic.eventStat(this.Rq.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            as asVar = new as("c10898");
            asVar.aa("obj_url", gVar.linkUrl);
            TiebaStatic.log(asVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Rq.getPageContext().getPageActivity(), gVar, true, oJ())));
        }
    }

    private SparseArray<String> oJ() {
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
            this.mNavigationBar.onChangeSkinType(this.Rq.getPageContext(), i);
        }
        if (this.RA != null) {
            this.RA.onChangeSkinType(this.Rq, i, aq.getDrawable(w.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Rq.getPageContext(), i);
        }
        aq.a(this.Ru, w.g.icon_nav_close, w.g.icon_nav_close_w, w.g.icon_nav_close, i);
        aq.a(this.Rv, w.g.icon_more_bg_s, w.g.icon_more_bg_s, w.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Rw.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Rq.getPageContext().getPageActivity(), this.Rr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.Rq.getPageContext().getString(w.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Rq.getResources().getString(w.l.refresh), this.Ry)));
        }
        this.mNoDataView.onChangeSkinType(this.Rq.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Rw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.Ry = onClickListener;
    }

    public void release() {
        if (this.Rw != null) {
            this.Rw.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.RA != null) {
            com.baidu.adp.lib.g.j.a(this.RA, this.Rq.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Rw.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Rw.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aq.j(this.Ru, w.g.frs_star_navigation_bg);
        aq.j(this.Rv, w.g.frs_star_navigation_bg);
        bY("");
        this.Rq.getWindow().setFlags(1024, 1024);
    }

    public void oK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Rw.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Rw.setLayoutParams(layoutParams);
        this.Ru.setBackgroundDrawable(null);
        this.Rv.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Rq.getWindow().clearFlags(1024);
    }

    public void ai(boolean z) {
        this.RG = z;
    }
}
