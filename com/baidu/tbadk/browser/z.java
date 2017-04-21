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
    private View.OnClickListener RA;
    private View RB;
    private MorePopupWindow RC;
    protected View RD;
    private View RE;
    private View RF;
    private int RG;
    private int RH;
    private BaseWebViewActivity Rs;
    private TextView Ru;
    private View Rv;
    private ImageView Rw;
    private ImageView Rx;
    private LinearLayout Ry;
    private TextView Rz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected View Rt = null;
    private ProgressBar mProgressBar = null;
    private boolean RI = true;

    public z(BaseWebViewActivity baseWebViewActivity) {
        this.Rs = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Rs.setContentView(w.j.base_webview_activity);
        this.Rt = this.Rs.findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Rs.findViewById(w.h.view_navigation_bar);
        bY("");
        this.Ry = (LinearLayout) this.Rs.findViewById(w.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ry.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Ry.setLayoutParams(layoutParams);
        this.Rz = (TextView) this.Rs.findViewById(w.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Rs.findViewById(w.h.webview_progress);
        this.Rv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.widget_nb_item_finish, new aa(this));
        this.Rw = (ImageView) this.Rv.findViewById(w.h.widget_navi_back_button);
        this.Rw.setContentDescription(this.Rs.getResources().getString(w.l.close));
        this.RB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_more, new ab(this));
        this.Rx = (ImageView) this.RB.findViewById(w.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Rs.getPageContext().getPageActivity()).inflate(w.j.tb_webview_pop_more, (ViewGroup) null);
        this.RC = new MorePopupWindow(this.Rs.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Rs.getPageContext().getResources().getDrawable(w.g.bg_pull_down_right_n), new ac(this));
        this.RD = inflate.findViewById(w.h.webview_more_pop_item_share_friend_layout);
        this.RD.setOnClickListener(this.Rs);
        if (com.baidu.tbadk.coreExtra.share.i.aM(this.Rs.getPageContext().getPageActivity())) {
            this.RD.setVisibility(0);
        } else {
            this.RD.setVisibility(8);
        }
        this.RC.refresh();
        this.RF = inflate.findViewById(w.h.webview_more_pop_item_open_browser_layout);
        this.RF.setOnClickListener(this.Rs);
        this.RE = inflate.findViewById(w.h.webview_more_pop_item_copy_link_layout);
        this.RE.setOnClickListener(this.Rs);
        oD();
    }

    private void oD() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = com.baidu.adp.lib.util.k.g(this.Rs.getPageContext().getPageActivity(), w.f.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.Rs.getPageContext().getPageActivity()).heightPixels;
        this.RG = (i - statusBarHeight) - g;
        this.RH = i - statusBarHeight;
    }

    public boolean oE() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oF() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Rw != null) {
            aq.b(this.Rw, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
    }

    public boolean oG() {
        try {
            this.Ry.addView(this.Rs.createWebView());
            this.Rz.setVisibility(8);
            if (!this.RI) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Rz.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Ry.getLayoutParams().height = this.RG;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Ry.getLayoutParams().height = this.RH;
        this.mNavigationBar.setVisibility(8);
    }

    public void ag(boolean z) {
        if (this.RD != null) {
            if (z) {
                this.RD.setVisibility(0);
            } else {
                this.RD.setVisibility(8);
            }
            this.RC.refresh();
        }
    }

    public void ah(boolean z) {
        if (this.RB != null) {
            if (z) {
                this.RB.setVisibility(0);
            } else {
                this.RB.setVisibility(8);
            }
        }
    }

    public void oH() {
        this.RC.showWindowInRightBottomOfHost();
    }

    public void oI() {
        com.baidu.adp.lib.g.j.a(this.RC, this.Rs.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Rz.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Rz.setVisibility(8);
    }

    public void bY(String str) {
        this.Ru = this.mNavigationBar.setTitleText(str);
        aq.b(this.Ru, w.e.cp_cont_b, w.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.h hVar) {
        if (hVar != null) {
            TiebaStatic.eventStat(this.Rs.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            as asVar = new as("c10898");
            asVar.aa("obj_url", hVar.linkUrl);
            TiebaStatic.log(asVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Rs.getPageContext().getPageActivity(), hVar, true, oJ())));
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
            this.mNavigationBar.onChangeSkinType(this.Rs.getPageContext(), i);
        }
        if (this.RC != null) {
            this.RC.onChangeSkinType(this.Rs, i, aq.getDrawable(w.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Rs.getPageContext(), i);
        }
        aq.a(this.Rw, w.g.icon_nav_close, w.g.icon_nav_close_w, w.g.icon_nav_close, i);
        aq.a(this.Rx, w.g.icon_more_bg_s, w.g.icon_more_bg_s, w.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ry.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Rs.getPageContext().getPageActivity(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.Rs.getPageContext().getString(w.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Rs.getResources().getString(w.l.refresh), this.RA)));
        }
        this.mNoDataView.onChangeSkinType(this.Rs.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Ry.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.RA = onClickListener;
    }

    public void release() {
        if (this.Ry != null) {
            this.Ry.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.RC != null) {
            com.baidu.adp.lib.g.j.a(this.RC, this.Rs.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ry.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Ry.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aq.j(this.Rw, w.g.frs_star_navigation_bg);
        aq.j(this.Rx, w.g.frs_star_navigation_bg);
        bY("");
        this.Rs.getWindow().setFlags(1024, 1024);
    }

    public void oK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ry.getLayoutParams();
        layoutParams.addRule(3, w.h.view_navigation_bar);
        this.Ry.setLayoutParams(layoutParams);
        this.Rw.setBackgroundDrawable(null);
        this.Rx.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Rs.getWindow().clearFlags(1024);
    }

    public void ai(boolean z) {
        this.RI = z;
    }
}
