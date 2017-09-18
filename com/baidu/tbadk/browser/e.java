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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private BaseWebViewActivity Rg;
    private TextView Ri;
    private View Rj;
    private ImageView Rk;
    private ImageView Rl;
    private LinearLayout Rm;
    private TextView Rn;
    private View.OnClickListener Ro;
    private View Rp;
    private MorePopupWindow Rq;
    protected View Rr;
    private View Rs;
    private View Rt;
    private int Ru;
    private int Rv;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected View Rh = null;
    private ProgressBar mProgressBar = null;
    private boolean Rw = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Rg = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Rg.setContentView(d.j.base_webview_activity);
        this.Rh = this.Rg.findViewById(d.h.root_view);
        if (this.Rg.isTranslucent()) {
            aj.k(this.Rh, this.Rg.getResources().getColor(d.e.black_alpha0));
            this.Rh.setOnClickListener(this.Rg);
        }
        this.mNavigationBar = (NavigationBar) this.Rg.findViewById(d.h.view_navigation_bar);
        ci("");
        this.Rm = (LinearLayout) this.Rg.findViewById(d.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Rm.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Rm.setLayoutParams(layoutParams);
        this.Rn = (TextView) this.Rg.findViewById(d.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Rg.findViewById(d.h.webview_progress);
        this.Rj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Rg != null) {
                    e.this.Rg.finish();
                }
            }
        });
        this.Rk = (ImageView) this.Rj.findViewById(d.h.widget_navi_back_button);
        this.Rk.setContentDescription(this.Rg.getResources().getString(d.l.close));
        this.Rp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ok();
            }
        });
        this.Rl = (ImageView) this.Rp.findViewById(d.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Rg.getPageContext().getPageActivity()).inflate(d.j.tb_webview_pop_more, (ViewGroup) null);
        this.Rq = new MorePopupWindow(this.Rg.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Rg.getPageContext().getResources().getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void oo() {
                e.this.ok();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void op() {
            }
        });
        this.Rr = inflate.findViewById(d.h.webview_more_pop_item_share_friend_layout);
        this.Rr.setOnClickListener(this.Rg);
        if (com.baidu.tbadk.coreExtra.d.e.aW(this.Rg.getPageContext().getPageActivity())) {
            this.Rr.setVisibility(0);
        } else {
            this.Rr.setVisibility(8);
        }
        this.Rq.refresh();
        this.Rt = inflate.findViewById(d.h.webview_more_pop_item_open_browser_layout);
        this.Rt.setOnClickListener(this.Rg);
        this.Rs = inflate.findViewById(d.h.webview_more_pop_item_copy_link_layout);
        this.Rs.setOnClickListener(this.Rg);
        oh();
    }

    private void oh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = k.f(this.Rg.getPageContext().getPageActivity(), d.f.ds98);
        int i = k.o(this.Rg.getPageContext().getPageActivity()).heightPixels;
        this.Ru = (i - statusBarHeight) - f;
        this.Rv = i - statusBarHeight;
    }

    public boolean oi() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oj() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Rk != null) {
            aj.a(this.Rk, d.g.icon_return_bg_s, d.g.icon_return_bg);
        }
    }

    public boolean initWebView() {
        try {
            this.Rm.addView(this.Rg.createWebView());
            this.Rn.setVisibility(8);
            if (!this.Rw) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Rn.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Rm.getLayoutParams().height = this.Ru;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Rm.getLayoutParams().height = this.Rv;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.Rr != null) {
            if (z) {
                this.Rr.setVisibility(0);
            } else {
                this.Rr.setVisibility(8);
            }
            this.Rq.refresh();
        }
    }

    public void af(boolean z) {
        if (this.Rp != null) {
            if (z) {
                this.Rp.setVisibility(0);
            } else {
                this.Rp.setVisibility(8);
            }
        }
    }

    public void ok() {
        this.Rq.showWindowInRightBottomOfHost();
    }

    public void ol() {
        g.a(this.Rq, this.Rg.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Rn.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Rn.setVisibility(8);
    }

    public void ci(String str) {
        this.Ri = this.mNavigationBar.setTitleText(str);
        aj.b(this.Ri, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.d.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Rg.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ad("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Rg.getPageContext().getPageActivity(), dVar, true, om())));
        }
    }

    private SparseArray<String> om() {
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
            this.mNavigationBar.onChangeSkinType(this.Rg.getPageContext(), i);
        }
        if (this.Rq != null) {
            this.Rq.onChangeSkinType(this.Rg, i, aj.getDrawable(d.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Rg.getPageContext(), i);
        }
        aj.a(this.Rk, d.g.icon_nav_close, d.g.icon_nav_close_w, d.g.icon_nav_close, i);
        aj.a(this.Rl, d.g.icon_more_bg_s, d.g.icon_more_bg_s, d.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Rm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Rg.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ag(null, this.Rg.getPageContext().getString(d.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Rg.getResources().getString(d.l.refresh), this.Ro)));
        }
        this.mNoDataView.onChangeSkinType(this.Rg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Rm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Ro = onClickListener;
    }

    public void release() {
        if (this.Rm != null) {
            this.Rm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Rq != null) {
            g.a(this.Rq, this.Rg.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Rm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Rm.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.j(this.Rk, d.g.frs_star_navigation_bg);
        aj.j(this.Rl, d.g.frs_star_navigation_bg);
        ci("");
        this.Rg.getWindow().setFlags(1024, 1024);
    }

    public void on() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Rm.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Rm.setLayoutParams(layoutParams);
        this.Rk.setBackgroundDrawable(null);
        this.Rl.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Rg.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.Rw = z;
    }
}
