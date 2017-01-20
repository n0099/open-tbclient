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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y {
    private BaseWebViewActivity LV;
    private TextView LX;
    private View LY;
    private ImageView LZ;
    private ImageView Ma;
    private LinearLayout Mb;
    private TextView Mc;
    private View.OnClickListener Md;
    private View Me;
    private MorePopupWindow Mf;
    protected View Mg;
    private View Mh;
    private View Mi;
    private int Mj;
    private int Mk;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    protected View LW = null;
    private ProgressBar mProgressBar = null;
    private boolean Ml = true;

    public y(BaseWebViewActivity baseWebViewActivity) {
        this.LV = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.LV.setContentView(r.j.base_webview_activity);
        this.LW = this.LV.findViewById(r.h.root_view);
        this.mNavigationBar = (NavigationBar) this.LV.findViewById(r.h.view_navigation_bar);
        bY("");
        this.Mb = (LinearLayout) this.LV.findViewById(r.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Mb.getLayoutParams();
        layoutParams.addRule(3, r.h.view_navigation_bar);
        this.Mb.setLayoutParams(layoutParams);
        this.Mc = (TextView) this.LV.findViewById(r.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.LV.findViewById(r.h.webview_progress);
        this.LY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.widget_nb_item_finish, new z(this));
        this.LZ = (ImageView) this.LY.findViewById(r.h.widget_navi_back_button);
        this.LZ.setContentDescription(this.LV.getResources().getString(r.l.close));
        this.Me = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.widget_nb_item_more, new aa(this));
        this.Ma = (ImageView) this.Me.findViewById(r.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.LV.getPageContext().getPageActivity()).inflate(r.j.tb_webview_pop_more, (ViewGroup) null);
        this.Mf = new MorePopupWindow(this.LV.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.LV.getPageContext().getResources().getDrawable(r.g.bg_pull_down_right_n), new ab(this));
        this.Mg = inflate.findViewById(r.h.webview_more_pop_item_share_friend_layout);
        this.Mg.setOnClickListener(this.LV);
        if (com.baidu.tbadk.coreExtra.share.h.am(this.LV.getPageContext().getPageActivity())) {
            this.Mg.setVisibility(0);
        } else {
            this.Mg.setVisibility(8);
        }
        this.Mf.refresh();
        this.Mi = inflate.findViewById(r.h.webview_more_pop_item_open_browser_layout);
        this.Mi.setOnClickListener(this.LV);
        this.Mh = inflate.findViewById(r.h.webview_more_pop_item_copy_link_layout);
        this.Mh.setOnClickListener(this.LV);
        nS();
    }

    private void nS() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = com.baidu.adp.lib.util.k.e(this.LV.getPageContext().getPageActivity(), r.f.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.LV.getPageContext().getPageActivity()).heightPixels;
        this.Mj = (i - statusBarHeight) - e;
        this.Mk = i - statusBarHeight;
    }

    public boolean nT() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void nU() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.LZ != null) {
            ap.b(this.LZ, r.g.icon_return_bg_s, r.g.icon_return_bg);
        }
    }

    public boolean nV() {
        try {
            this.Mb.addView(this.LV.createWebView());
            this.Mc.setVisibility(8);
            if (!this.Ml) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Mc.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Mb.getLayoutParams().height = this.Mj;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Mb.getLayoutParams().height = this.Mk;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.Mg != null) {
            if (z) {
                this.Mg.setVisibility(0);
            } else {
                this.Mg.setVisibility(8);
            }
            this.Mf.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.Me != null) {
            if (z) {
                this.Me.setVisibility(0);
            } else {
                this.Me.setVisibility(8);
            }
        }
    }

    public void nW() {
        this.Mf.showWindowInRightBottomOfHost();
    }

    public void nX() {
        com.baidu.adp.lib.g.j.a(this.Mf, this.LV.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Mc.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Mc.setVisibility(8);
    }

    public void bY(String str) {
        this.LX = this.mNavigationBar.setTitleText(str);
        ap.b(this.LX, r.e.cp_cont_b, r.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.LV.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar("c10898");
            arVar.ab("obj_url", fVar.linkUrl);
            TiebaStatic.log(arVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.LV.getPageContext().getPageActivity(), fVar, true, nY())));
        }
    }

    private SparseArray<String> nY() {
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
            this.mNavigationBar.onChangeSkinType(this.LV.getPageContext(), i);
        }
        if (this.Mf != null) {
            this.Mf.onChangeSkinType(this.LV, i, ap.getDrawable(r.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.LV.getPageContext(), i);
        }
        ap.a(this.LZ, r.g.icon_nav_close, r.g.icon_nav_close_w, r.g.icon_nav_close, i);
        ap.a(this.Ma, r.g.icon_more_bg_s, r.g.icon_more_bg_s, r.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Mb.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.LV.getPageContext().getPageActivity(), this.LW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.LV.getPageContext().getString(r.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.LV.getResources().getString(r.l.refresh), this.Md)));
        }
        this.mNoDataView.onChangeSkinType(this.LV.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Mb.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.Md = onClickListener;
    }

    public void release() {
        if (this.Mb != null) {
            this.Mb.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Mf != null) {
            com.baidu.adp.lib.g.j.a(this.Mf, this.LV.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Mb.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Mb.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ap.j(this.LZ, r.g.frs_star_navigation_bg);
        ap.j(this.Ma, r.g.frs_star_navigation_bg);
        bY("");
        this.LV.getWindow().setFlags(1024, 1024);
    }

    public void nZ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Mb.getLayoutParams();
        layoutParams.addRule(3, r.h.view_navigation_bar);
        this.Mb.setLayoutParams(layoutParams);
        this.LZ.setBackgroundDrawable(null);
        this.Ma.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.LV.getWindow().clearFlags(1024);
    }

    public void ah(boolean z) {
        this.Ml = z;
    }
}
