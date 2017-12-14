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
    private BaseWebViewActivity Sd;
    private TextView Sf;
    private View Sg;
    private ImageView Sh;
    private ImageView Si;
    private LinearLayout Sj;
    private TextView Sk;
    private View.OnClickListener Sl;
    private View Sm;
    private MorePopupWindow Sn;
    protected View So;
    private View Sp;
    private View Sq;
    private int Sr;
    private int Ss;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    protected View Se = null;
    private ProgressBar mProgressBar = null;
    private boolean St = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Sd = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Sd.setContentView(d.h.base_webview_activity);
        this.Se = this.Sd.findViewById(d.g.root_view);
        if (this.Sd.isTranslucent()) {
            aj.k(this.Se, this.Sd.getResources().getColor(d.C0096d.black_alpha0));
            this.Se.setOnClickListener(this.Sd);
        }
        this.mNavigationBar = (NavigationBar) this.Sd.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cn("");
        this.Sj = (LinearLayout) this.Sd.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Sj.setLayoutParams(layoutParams);
        this.Sk = (TextView) this.Sd.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sd.findViewById(d.g.webview_progress);
        this.Sg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Sd != null) {
                    e.this.Sd.finish();
                }
            }
        });
        this.Sh = (ImageView) this.Sg.findViewById(d.g.widget_navi_back_button);
        this.Sh.setContentDescription(this.Sd.getResources().getString(d.j.close));
        this.Sm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.oq();
            }
        });
        this.Si = (ImageView) this.Sm.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Sd.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.Sn = new MorePopupWindow(this.Sd.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sd.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new e.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.e.a
            public void ou() {
                e.this.oq();
            }

            @Override // com.baidu.tbadk.core.view.e.a
            public void ov() {
            }
        });
        this.So = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.So.setOnClickListener(this.Sd);
        if (com.baidu.tbadk.coreExtra.c.e.aU(this.Sd.getPageContext().getPageActivity())) {
            this.So.setVisibility(0);
        } else {
            this.So.setVisibility(8);
        }
        this.Sn.refresh();
        this.Sq = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.Sq.setOnClickListener(this.Sd);
        this.Sp = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.Sp.setOnClickListener(this.Sd);
        om();
    }

    private void om() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.Sd.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.Sd.getPageContext().getPageActivity()).heightPixels;
        this.Sr = (i - statusBarHeight) - f;
        this.Ss = i - statusBarHeight;
    }

    public boolean on() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oo() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Sh != null) {
            aj.a(this.Sh, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean op() {
        try {
            this.Sj.addView(this.Sd.createWebView());
            this.Sk.setVisibility(8);
            if (!this.St) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Sk.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Sj.getLayoutParams().height = this.Sr;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Sj.getLayoutParams().height = this.Ss;
        this.mNavigationBar.setVisibility(8);
    }

    public void ad(boolean z) {
        if (this.So != null) {
            if (z) {
                this.So.setVisibility(0);
            } else {
                this.So.setVisibility(8);
            }
            this.Sn.refresh();
        }
    }

    public void ae(boolean z) {
        if (this.Sm != null) {
            if (z) {
                this.Sm.setVisibility(0);
            } else {
                this.Sm.setVisibility(8);
            }
        }
    }

    public void oq() {
        this.Sn.showWindowInRightBottomOfHost();
    }

    public void or() {
        com.baidu.adp.lib.g.g.a(this.Sn, this.Sd.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sk.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sk.setVisibility(8);
    }

    public void cn(String str) {
        this.Sf = this.mNavigationBar.setCenterTextTitle(str);
        aj.b(this.Sf, d.C0096d.cp_cont_b, d.C0096d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Sd.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ac("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Sd.getPageContext().getPageActivity(), dVar, true, os())));
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
            this.mNavigationBar.onChangeSkinType(this.Sd.getPageContext(), i);
        }
        if (this.Sn != null) {
            this.Sn.onChangeSkinType(this.Sd, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sd.getPageContext(), i);
        }
        aj.a(this.Sh, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.Si, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sj.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sd.getPageContext().getPageActivity(), this.Se, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.Sd.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sd.getResources().getString(d.j.refresh), this.Sl)));
        }
        this.mNoDataView.onChangeSkinType(this.Sd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Sj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sl = onClickListener;
    }

    public void release() {
        if (this.Sj != null) {
            this.Sj.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Sn != null) {
            com.baidu.adp.lib.g.g.a(this.Sn, this.Sd.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sj.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Sj.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.j(this.Sh, d.f.frs_star_navigation_bg);
        aj.j(this.Si, d.f.frs_star_navigation_bg);
        cn("");
        this.Sd.getWindow().setFlags(1024, 1024);
    }

    public void ot() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Sj.setLayoutParams(layoutParams);
        this.Sh.setBackgroundDrawable(null);
        this.Si.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Sd.getWindow().clearFlags(1024);
    }

    public void af(boolean z) {
        this.St = z;
    }
}
