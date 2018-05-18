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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f {
    private BaseWebViewActivity Tg;
    private TextView Ti;
    private View Tj;
    private ImageView Tk;
    protected ImageView Tl;
    private ImageView Tm;
    private LinearLayout Tn;
    private TextView To;
    private View.OnClickListener Tp;
    private View Tq;
    private MorePopupWindow Tr;
    protected View Ts;
    private View Tt;
    private View Tu;
    private int Tv;
    private int Tw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View Th = null;
    private ProgressBar mProgressBar = null;
    private boolean Tx = true;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.Tg = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Tg.setContentView(d.i.base_webview_activity);
        this.Th = this.Tg.findViewById(d.g.root_view);
        if (this.Tg.isTranslucent()) {
            ak.j(this.Th, this.Tg.getResources().getColor(d.C0126d.black_alpha0));
            this.Th.setOnClickListener(this.Tg);
        }
        this.mNavigationBar = (NavigationBar) this.Tg.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cx("");
        this.Tn = (LinearLayout) this.Tg.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Tn.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Tn.setLayoutParams(layoutParams);
        this.To = (TextView) this.Tg.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Tg.findViewById(d.g.webview_progress);
        this.Tj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.Tg != null) {
                    f.this.Tg.finish();
                }
            }
        });
        this.Tk = (ImageView) this.Tj.findViewById(d.g.widget_navi_back_button);
        this.Tk.setContentDescription(this.Tg.getResources().getString(d.k.close));
        this.Tq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.Tm.getVisibility() != 0) {
                    f.this.pp();
                }
            }
        });
        this.Tl = (ImageView) this.Tq.findViewById(d.g.widget_navi_more_button);
        this.Tm = (ImageView) this.Tq.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.Tg.getPageContext().getPageActivity()).inflate(d.i.tb_webview_pop_more, (ViewGroup) null);
        this.Tr = new MorePopupWindow(this.Tg.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Tg.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void pt() {
                f.this.pp();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void pu() {
            }
        });
        this.Ts = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.Ts.setOnClickListener(this.Tg);
        if (com.baidu.tbadk.coreExtra.c.e.aN(this.Tg.getPageContext().getPageActivity())) {
            this.Ts.setVisibility(0);
        } else {
            this.Ts.setVisibility(8);
        }
        this.Tr.refresh();
        this.Tu = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.Tu.setOnClickListener(this.Tg);
        this.Tt = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.Tt.setOnClickListener(this.Tg);
        pk();
    }

    private void pk() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = l.e(this.Tg.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.q(this.Tg.getPageContext().getPageActivity()).heightPixels;
        this.Tv = (i - statusBarHeight) - e;
        this.Tw = i - statusBarHeight;
    }

    public void pl() {
        if (this.mNavigationBar != null && this.Tl != null && this.Tm != null) {
            this.mNavigationBar.setVisibility(0);
            this.Tl.setVisibility(8);
            this.Tm.setVisibility(0);
            this.Tm.setOnClickListener(this.Tg);
        }
    }

    public boolean pm() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void pn() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Tk != null) {
            ak.a(this.Tk, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean po() {
        try {
            this.Tn.addView(this.Tg.createWebView());
            this.To.setVisibility(8);
            if (!this.Tx) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.To.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Tn.getLayoutParams().height = this.Tv;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Tn.getLayoutParams().height = this.Tw;
        this.mNavigationBar.setVisibility(8);
    }

    public void ag(boolean z) {
        if (this.Ts != null) {
            if (z) {
                this.Ts.setVisibility(0);
            } else {
                this.Ts.setVisibility(8);
            }
            this.Tr.refresh();
        }
    }

    public void ah(boolean z) {
        if (this.Tq != null) {
            if (z) {
                this.Tq.setVisibility(0);
            } else {
                this.Tq.setVisibility(8);
            }
        }
    }

    public void pp() {
        this.Tr.showWindowInRightBottomOfHost();
    }

    public void pq() {
        g.a(this.Tr, this.Tg.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.To.setVisibility(0);
    }

    public void hideCrashTip() {
        this.To.setVisibility(8);
    }

    public void cx(String str) {
        this.Ti = this.mNavigationBar.setCenterTextTitle(str);
        ak.b(this.Ti, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Tg.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            al alVar = new al("c10898");
            alVar.ac("obj_url", dVar.linkUrl);
            TiebaStatic.log(alVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.Tg.getPageContext().getPageActivity(), dVar, true, pr())));
        }
    }

    private SparseArray<String> pr() {
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
            this.mNavigationBar.onChangeSkinType(this.Tg.getPageContext(), i);
        }
        if (this.Tr != null) {
            this.Tr.onChangeSkinType(this.Tg, i, ak.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Tg.getPageContext(), i);
        }
        ak.a(this.Tk, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        ak.a(this.Tl, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        ak.a(this.Tm, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Tn.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Tg.getPageContext().getPageActivity(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.Tg.getPageContext().getString(d.k.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Tg.getResources().getString(d.k.refresh), this.Tp)));
        }
        this.mNoDataView.onChangeSkinType(this.Tg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Tn.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tp = onClickListener;
    }

    public void release() {
        if (this.Tn != null) {
            this.Tn.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Tr != null) {
            g.a(this.Tr, this.Tg.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Tn.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Tn.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ak.i(this.Tk, d.f.frs_star_navigation_bg);
        ak.i(this.Tl, d.f.frs_star_navigation_bg);
        ak.i(this.Tm, d.f.frs_star_navigation_bg);
        cx("");
        this.Tg.getWindow().setFlags(1024, 1024);
    }

    public void ps() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Tn.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.Tn.setLayoutParams(layoutParams);
        this.Tk.setBackgroundDrawable(null);
        this.Tl.setBackgroundDrawable(null);
        this.Tm.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Tg.getWindow().clearFlags(1024);
    }

    public void ai(boolean z) {
        this.Tx = z;
    }
}
