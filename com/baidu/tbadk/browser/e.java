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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private View RA;
    private ImageView RB;
    private ImageView RC;
    private LinearLayout RD;
    private TextView RE;
    private View.OnClickListener RF;
    private View RG;
    private MorePopupWindow RH;
    protected View RI;
    private View RJ;
    private View RK;
    private int RL;
    private int RO;
    private BaseWebViewActivity Rx;
    private TextView Rz;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    protected View Ry = null;
    private ProgressBar mProgressBar = null;
    private boolean RP = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Rx = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Rx.setContentView(d.h.base_webview_activity);
        this.Ry = this.Rx.findViewById(d.g.root_view);
        if (this.Rx.isTranslucent()) {
            aj.k(this.Ry, this.Rx.getResources().getColor(d.C0080d.black_alpha0));
            this.Ry.setOnClickListener(this.Rx);
        }
        this.mNavigationBar = (NavigationBar) this.Rx.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cn("");
        this.RD = (LinearLayout) this.Rx.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.RD.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.RD.setLayoutParams(layoutParams);
        this.RE = (TextView) this.Rx.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Rx.findViewById(d.g.webview_progress);
        this.RA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Rx != null) {
                    e.this.Rx.finish();
                }
            }
        });
        this.RB = (ImageView) this.RA.findViewById(d.g.widget_navi_back_button);
        this.RB.setContentDescription(this.Rx.getResources().getString(d.j.close));
        this.RG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ol();
            }
        });
        this.RC = (ImageView) this.RG.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Rx.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.RH = new MorePopupWindow(this.Rx.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Rx.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void op() {
                e.this.ol();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void oq() {
            }
        });
        this.RI = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.RI.setOnClickListener(this.Rx);
        if (com.baidu.tbadk.coreExtra.d.e.aV(this.Rx.getPageContext().getPageActivity())) {
            this.RI.setVisibility(0);
        } else {
            this.RI.setVisibility(8);
        }
        this.RH.refresh();
        this.RK = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.RK.setOnClickListener(this.Rx);
        this.RJ = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.RJ.setOnClickListener(this.Rx);
        oh();
    }

    private void oh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.Rx.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.Rx.getPageContext().getPageActivity()).heightPixels;
        this.RL = (i - statusBarHeight) - f;
        this.RO = i - statusBarHeight;
    }

    public boolean oi() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oj() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.RB != null) {
            aj.a(this.RB, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean ok() {
        try {
            this.RD.addView(this.Rx.createWebView());
            this.RE.setVisibility(8);
            if (!this.RP) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.RE.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.RD.getLayoutParams().height = this.RL;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.RD.getLayoutParams().height = this.RO;
        this.mNavigationBar.setVisibility(8);
    }

    public void ad(boolean z) {
        if (this.RI != null) {
            if (z) {
                this.RI.setVisibility(0);
            } else {
                this.RI.setVisibility(8);
            }
            this.RH.refresh();
        }
    }

    public void ae(boolean z) {
        if (this.RG != null) {
            if (z) {
                this.RG.setVisibility(0);
            } else {
                this.RG.setVisibility(8);
            }
        }
    }

    public void ol() {
        this.RH.showWindowInRightBottomOfHost();
    }

    public void om() {
        g.a(this.RH, this.Rx.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.RE.setVisibility(0);
    }

    public void hideCrashTip() {
        this.RE.setVisibility(8);
    }

    public void cn(String str) {
        this.Rz = this.mNavigationBar.setCenterTextTitle(str);
        aj.b(this.Rz, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.d.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Rx.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ac("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Rx.getPageContext().getPageActivity(), dVar, true, on())));
        }
    }

    private SparseArray<String> on() {
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
            this.mNavigationBar.onChangeSkinType(this.Rx.getPageContext(), i);
        }
        if (this.RH != null) {
            this.RH.onChangeSkinType(this.Rx, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Rx.getPageContext(), i);
        }
        aj.a(this.RB, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.RC, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.RD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Rx.getPageContext().getPageActivity(), this.Ry, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.Rx.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Rx.getResources().getString(d.j.refresh), this.RF)));
        }
        this.mNoDataView.onChangeSkinType(this.Rx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.RD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.RF = onClickListener;
    }

    public void release() {
        if (this.RD != null) {
            this.RD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.RH != null) {
            g.a(this.RH, this.Rx.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.RD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.RD.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.j(this.RB, d.f.frs_star_navigation_bg);
        aj.j(this.RC, d.f.frs_star_navigation_bg);
        cn("");
        this.Rx.getWindow().setFlags(1024, 1024);
    }

    public void oo() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.RD.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.RD.setLayoutParams(layoutParams);
        this.RB.setBackgroundDrawable(null);
        this.RC.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Rx.getWindow().clearFlags(1024);
    }

    public void af(boolean z) {
        this.RP = z;
    }
}
