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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private BaseWebViewActivity Sc;
    private TextView Se;
    private View Sf;
    private ImageView Sg;
    private ImageView Sh;
    private LinearLayout Si;
    private TextView Sj;
    private View.OnClickListener Sk;
    private View Sl;
    private MorePopupWindow Sm;
    protected View Sn;
    private View So;
    private View Sp;
    private int Sq;
    private int Sr;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected View Sd = null;
    private ProgressBar mProgressBar = null;
    private boolean Ss = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Sc = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Sc.setContentView(d.j.base_webview_activity);
        this.Sd = this.Sc.findViewById(d.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Sc.findViewById(d.h.view_navigation_bar);
        cp("");
        this.Si = (LinearLayout) this.Sc.findViewById(d.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Si.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Si.setLayoutParams(layoutParams);
        this.Sj = (TextView) this.Sc.findViewById(d.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sc.findViewById(d.h.webview_progress);
        this.Sf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Sc != null) {
                    e.this.Sc.finish();
                }
            }
        });
        this.Sg = (ImageView) this.Sf.findViewById(d.h.widget_navi_back_button);
        this.Sg.setContentDescription(this.Sc.getResources().getString(d.l.close));
        this.Sl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.op();
            }
        });
        this.Sh = (ImageView) this.Sl.findViewById(d.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Sc.getPageContext().getPageActivity()).inflate(d.j.tb_webview_pop_more, (ViewGroup) null);
        this.Sm = new MorePopupWindow(this.Sc.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sc.getPageContext().getResources().getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void ot() {
                e.this.op();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void ou() {
            }
        });
        this.Sn = inflate.findViewById(d.h.webview_more_pop_item_share_friend_layout);
        this.Sn.setOnClickListener(this.Sc);
        if (f.aQ(this.Sc.getPageContext().getPageActivity())) {
            this.Sn.setVisibility(0);
        } else {
            this.Sn.setVisibility(8);
        }
        this.Sm.refresh();
        this.Sp = inflate.findViewById(d.h.webview_more_pop_item_open_browser_layout);
        this.Sp.setOnClickListener(this.Sc);
        this.So = inflate.findViewById(d.h.webview_more_pop_item_copy_link_layout);
        this.So.setOnClickListener(this.Sc);
        om();
    }

    private void om() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = k.g(this.Sc.getPageContext().getPageActivity(), d.f.ds98);
        int i = k.o(this.Sc.getPageContext().getPageActivity()).heightPixels;
        this.Sq = (i - statusBarHeight) - g;
        this.Sr = i - statusBarHeight;
    }

    public boolean on() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oo() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Sg != null) {
            ai.b(this.Sg, d.g.icon_return_bg_s, d.g.icon_return_bg);
        }
    }

    public boolean initWebView() {
        try {
            this.Si.addView(this.Sc.createWebView());
            this.Sj.setVisibility(8);
            if (!this.Ss) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Sj.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Si.getLayoutParams().height = this.Sq;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Si.getLayoutParams().height = this.Sr;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.Sn != null) {
            if (z) {
                this.Sn.setVisibility(0);
            } else {
                this.Sn.setVisibility(8);
            }
            this.Sm.refresh();
        }
    }

    public void af(boolean z) {
        if (this.Sl != null) {
            if (z) {
                this.Sl.setVisibility(0);
            } else {
                this.Sl.setVisibility(8);
            }
        }
    }

    public void op() {
        this.Sm.showWindowInRightBottomOfHost();
    }

    public void oq() {
        g.a(this.Sm, this.Sc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sj.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sj.setVisibility(8);
    }

    public void cp(String str) {
        this.Se = this.mNavigationBar.setTitleText(str);
        ai.b(this.Se, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.Sc.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aj ajVar = new aj("c10898");
            ajVar.aa("obj_url", eVar.linkUrl);
            TiebaStatic.log(ajVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Sc.getPageContext().getPageActivity(), eVar, true, or())));
        }
    }

    private SparseArray<String> or() {
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
            this.mNavigationBar.onChangeSkinType(this.Sc.getPageContext(), i);
        }
        if (this.Sm != null) {
            this.Sm.onChangeSkinType(this.Sc, i, ai.getDrawable(d.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sc.getPageContext(), i);
        }
        ai.a(this.Sg, d.g.icon_nav_close, d.g.icon_nav_close_w, d.g.icon_nav_close, i);
        ai.a(this.Sh, d.g.icon_more_bg_s, d.g.icon_more_bg_s, d.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Si.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sc.getPageContext().getPageActivity(), this.Sd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.Sc.getPageContext().getString(d.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sc.getResources().getString(d.l.refresh), this.Sk)));
        }
        this.mNoDataView.onChangeSkinType(this.Sc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Si.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.Sk = onClickListener;
    }

    public void release() {
        if (this.Si != null) {
            this.Si.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Sm != null) {
            g.a(this.Sm, this.Sc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Si.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Si.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ai.j(this.Sg, d.g.frs_star_navigation_bg);
        ai.j(this.Sh, d.g.frs_star_navigation_bg);
        cp("");
        this.Sc.getWindow().setFlags(1024, 1024);
    }

    public void os() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Si.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Si.setLayoutParams(layoutParams);
        this.Sg.setBackgroundDrawable(null);
        this.Sh.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Sc.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.Ss = z;
    }
}
