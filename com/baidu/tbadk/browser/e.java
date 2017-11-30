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
    private BaseWebViewActivity Sg;
    private TextView Si;
    private View Sj;
    private ImageView Sk;
    private ImageView Sl;
    private LinearLayout Sm;
    private TextView Sn;
    private View.OnClickListener So;
    private View Sp;
    private MorePopupWindow Sq;
    protected View Sr;
    private View Ss;
    private View St;
    private int Su;
    private int Sv;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    protected View Sh = null;
    private ProgressBar mProgressBar = null;
    private boolean Sw = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Sg = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Sg.setContentView(d.h.base_webview_activity);
        this.Sh = this.Sg.findViewById(d.g.root_view);
        if (this.Sg.isTranslucent()) {
            aj.k(this.Sh, this.Sg.getResources().getColor(d.C0082d.black_alpha0));
            this.Sh.setOnClickListener(this.Sg);
        }
        this.mNavigationBar = (NavigationBar) this.Sg.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cn("");
        this.Sm = (LinearLayout) this.Sg.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sm.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Sm.setLayoutParams(layoutParams);
        this.Sn = (TextView) this.Sg.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sg.findViewById(d.g.webview_progress);
        this.Sj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Sg != null) {
                    e.this.Sg.finish();
                }
            }
        });
        this.Sk = (ImageView) this.Sj.findViewById(d.g.widget_navi_back_button);
        this.Sk.setContentDescription(this.Sg.getResources().getString(d.j.close));
        this.Sp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.os();
            }
        });
        this.Sl = (ImageView) this.Sp.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Sg.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.Sq = new MorePopupWindow(this.Sg.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sg.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void ow() {
                e.this.os();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void ox() {
            }
        });
        this.Sr = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.Sr.setOnClickListener(this.Sg);
        if (com.baidu.tbadk.coreExtra.c.e.aX(this.Sg.getPageContext().getPageActivity())) {
            this.Sr.setVisibility(0);
        } else {
            this.Sr.setVisibility(8);
        }
        this.Sq.refresh();
        this.St = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.St.setOnClickListener(this.Sg);
        this.Ss = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.Ss.setOnClickListener(this.Sg);
        oo();
    }

    private void oo() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.Sg.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.Sg.getPageContext().getPageActivity()).heightPixels;
        this.Su = (i - statusBarHeight) - f;
        this.Sv = i - statusBarHeight;
    }

    public boolean op() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oq() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Sk != null) {
            aj.a(this.Sk, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean or() {
        try {
            this.Sm.addView(this.Sg.createWebView());
            this.Sn.setVisibility(8);
            if (!this.Sw) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Sn.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Sm.getLayoutParams().height = this.Su;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Sm.getLayoutParams().height = this.Sv;
        this.mNavigationBar.setVisibility(8);
    }

    public void ad(boolean z) {
        if (this.Sr != null) {
            if (z) {
                this.Sr.setVisibility(0);
            } else {
                this.Sr.setVisibility(8);
            }
            this.Sq.refresh();
        }
    }

    public void ae(boolean z) {
        if (this.Sp != null) {
            if (z) {
                this.Sp.setVisibility(0);
            } else {
                this.Sp.setVisibility(8);
            }
        }
    }

    public void os() {
        this.Sq.showWindowInRightBottomOfHost();
    }

    public void ot() {
        g.a(this.Sq, this.Sg.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sn.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sn.setVisibility(8);
    }

    public void cn(String str) {
        this.Si = this.mNavigationBar.setCenterTextTitle(str);
        aj.b(this.Si, d.C0082d.cp_cont_b, d.C0082d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Sg.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ac("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Sg.getPageContext().getPageActivity(), dVar, true, ou())));
        }
    }

    private SparseArray<String> ou() {
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
            this.mNavigationBar.onChangeSkinType(this.Sg.getPageContext(), i);
        }
        if (this.Sq != null) {
            this.Sq.onChangeSkinType(this.Sg, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sg.getPageContext(), i);
        }
        aj.a(this.Sk, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.Sl, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sg.getPageContext().getPageActivity(), this.Sh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.Sg.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sg.getResources().getString(d.j.refresh), this.So)));
        }
        this.mNoDataView.onChangeSkinType(this.Sg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Sm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.So = onClickListener;
    }

    public void release() {
        if (this.Sm != null) {
            this.Sm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Sq != null) {
            g.a(this.Sq, this.Sg.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Sm.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.j(this.Sk, d.f.frs_star_navigation_bg);
        aj.j(this.Sl, d.f.frs_star_navigation_bg);
        cn("");
        this.Sg.getWindow().setFlags(1024, 1024);
    }

    public void ov() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sm.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Sm.setLayoutParams(layoutParams);
        this.Sk.setBackgroundDrawable(null);
        this.Sl.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Sg.getWindow().clearFlags(1024);
    }

    public void af(boolean z) {
        this.Sw = z;
    }
}
