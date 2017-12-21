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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private BaseWebViewActivity Se;
    private TextView Sg;
    private View Sh;
    private ImageView Si;
    private ImageView Sj;
    private LinearLayout Sk;
    private TextView Sl;
    private View.OnClickListener Sm;
    private View Sn;
    private MorePopupWindow So;
    protected View Sp;
    private View Sq;
    private View Sr;
    private int Ss;
    private int St;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    protected View Sf = null;
    private ProgressBar mProgressBar = null;
    private boolean Su = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Se = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Se.setContentView(d.h.base_webview_activity);
        this.Sf = this.Se.findViewById(d.g.root_view);
        if (this.Se.isTranslucent()) {
            aj.k(this.Sf, this.Se.getResources().getColor(d.C0095d.black_alpha0));
            this.Sf.setOnClickListener(this.Se);
        }
        this.mNavigationBar = (NavigationBar) this.Se.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cn("");
        this.Sk = (LinearLayout) this.Se.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sk.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Sk.setLayoutParams(layoutParams);
        this.Sl = (TextView) this.Se.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Se.findViewById(d.g.webview_progress);
        this.Sh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Se != null) {
                    e.this.Se.finish();
                }
            }
        });
        this.Si = (ImageView) this.Sh.findViewById(d.g.widget_navi_back_button);
        this.Si.setContentDescription(this.Se.getResources().getString(d.j.close));
        this.Sn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.oq();
            }
        });
        this.Sj = (ImageView) this.Sn.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Se.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.So = new MorePopupWindow(this.Se.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Se.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new e.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.e.a
            public void ou() {
                e.this.oq();
            }

            @Override // com.baidu.tbadk.core.view.e.a
            public void ov() {
            }
        });
        this.Sp = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.Sp.setOnClickListener(this.Se);
        if (com.baidu.tbadk.coreExtra.c.e.aU(this.Se.getPageContext().getPageActivity())) {
            this.Sp.setVisibility(0);
        } else {
            this.Sp.setVisibility(8);
        }
        this.So.refresh();
        this.Sr = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.Sr.setOnClickListener(this.Se);
        this.Sq = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.Sq.setOnClickListener(this.Se);
        om();
    }

    private void om() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.Se.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.Se.getPageContext().getPageActivity()).heightPixels;
        this.Ss = (i - statusBarHeight) - f;
        this.St = i - statusBarHeight;
    }

    public boolean on() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oo() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Si != null) {
            aj.a(this.Si, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean op() {
        try {
            this.Sk.addView(this.Se.createWebView());
            this.Sl.setVisibility(8);
            if (!this.Su) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Sl.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Sk.getLayoutParams().height = this.Ss;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Sk.getLayoutParams().height = this.St;
        this.mNavigationBar.setVisibility(8);
    }

    public void ad(boolean z) {
        if (this.Sp != null) {
            if (z) {
                this.Sp.setVisibility(0);
            } else {
                this.Sp.setVisibility(8);
            }
            this.So.refresh();
        }
    }

    public void ae(boolean z) {
        if (this.Sn != null) {
            if (z) {
                this.Sn.setVisibility(0);
            } else {
                this.Sn.setVisibility(8);
            }
        }
    }

    public void oq() {
        this.So.showWindowInRightBottomOfHost();
    }

    public void or() {
        com.baidu.adp.lib.g.g.a(this.So, this.Se.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sl.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sl.setVisibility(8);
    }

    public void cn(String str) {
        this.Sg = this.mNavigationBar.setCenterTextTitle(str);
        aj.b(this.Sg, d.C0095d.cp_cont_b, d.C0095d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Se.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ac("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Se.getPageContext().getPageActivity(), dVar, true, os())));
        }
    }

    private SparseArray<String> os() {
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
            this.mNavigationBar.onChangeSkinType(this.Se.getPageContext(), i);
        }
        if (this.So != null) {
            this.So.onChangeSkinType(this.Se, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Se.getPageContext(), i);
        }
        aj.a(this.Si, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.Sj, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sk.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Se.getPageContext().getPageActivity(), this.Sf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.Se.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Se.getResources().getString(d.j.refresh), this.Sm)));
        }
        this.mNoDataView.onChangeSkinType(this.Se.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Sk.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sm = onClickListener;
    }

    public void release() {
        if (this.Sk != null) {
            this.Sk.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.So != null) {
            com.baidu.adp.lib.g.g.a(this.So, this.Se.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sk.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Sk.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.j(this.Si, d.f.frs_star_navigation_bg);
        aj.j(this.Sj, d.f.frs_star_navigation_bg);
        cn("");
        this.Se.getWindow().setFlags(1024, 1024);
    }

    public void ot() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sk.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Sk.setLayoutParams(layoutParams);
        this.Si.setBackgroundDrawable(null);
        this.Sj.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Se.getWindow().clearFlags(1024);
    }

    public void af(boolean z) {
        this.Su = z;
    }
}
