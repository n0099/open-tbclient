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
    private j mNoDataView;
    protected View Sf = null;
    private ProgressBar mProgressBar = null;
    private boolean Su = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Se = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Se.setContentView(d.j.base_webview_activity);
        this.Sf = this.Se.findViewById(d.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Se.findViewById(d.h.view_navigation_bar);
        cp("");
        this.Sk = (LinearLayout) this.Se.findViewById(d.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sk.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Sk.setLayoutParams(layoutParams);
        this.Sl = (TextView) this.Se.findViewById(d.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Se.findViewById(d.h.webview_progress);
        this.Sh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Se != null) {
                    e.this.Se.finish();
                }
            }
        });
        this.Si = (ImageView) this.Sh.findViewById(d.h.widget_navi_back_button);
        this.Si.setContentDescription(this.Se.getResources().getString(d.l.close));
        this.Sn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.op();
            }
        });
        this.Sj = (ImageView) this.Sn.findViewById(d.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Se.getPageContext().getPageActivity()).inflate(d.j.tb_webview_pop_more, (ViewGroup) null);
        this.So = new MorePopupWindow(this.Se.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Se.getPageContext().getResources().getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void ot() {
                e.this.op();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void ou() {
            }
        });
        this.Sp = inflate.findViewById(d.h.webview_more_pop_item_share_friend_layout);
        this.Sp.setOnClickListener(this.Se);
        if (f.aQ(this.Se.getPageContext().getPageActivity())) {
            this.Sp.setVisibility(0);
        } else {
            this.Sp.setVisibility(8);
        }
        this.So.refresh();
        this.Sr = inflate.findViewById(d.h.webview_more_pop_item_open_browser_layout);
        this.Sr.setOnClickListener(this.Se);
        this.Sq = inflate.findViewById(d.h.webview_more_pop_item_copy_link_layout);
        this.Sq.setOnClickListener(this.Se);
        om();
    }

    private void om() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = k.g(this.Se.getPageContext().getPageActivity(), d.f.ds98);
        int i = k.o(this.Se.getPageContext().getPageActivity()).heightPixels;
        this.Ss = (i - statusBarHeight) - g;
        this.St = i - statusBarHeight;
    }

    public boolean on() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oo() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Si != null) {
            ai.b(this.Si, d.g.icon_return_bg_s, d.g.icon_return_bg);
        }
    }

    public boolean initWebView() {
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

    public void ae(boolean z) {
        if (this.Sp != null) {
            if (z) {
                this.Sp.setVisibility(0);
            } else {
                this.Sp.setVisibility(8);
            }
            this.So.refresh();
        }
    }

    public void af(boolean z) {
        if (this.Sn != null) {
            if (z) {
                this.Sn.setVisibility(0);
            } else {
                this.Sn.setVisibility(8);
            }
        }
    }

    public void op() {
        this.So.showWindowInRightBottomOfHost();
    }

    public void oq() {
        g.a(this.So, this.Se.getPageContext().getPageActivity());
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

    public void cp(String str) {
        this.Sg = this.mNavigationBar.setTitleText(str);
        ai.b(this.Sg, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.Se.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aj ajVar = new aj("c10898");
            ajVar.aa("obj_url", eVar.linkUrl);
            TiebaStatic.log(ajVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Se.getPageContext().getPageActivity(), eVar, true, or())));
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
            this.mNavigationBar.onChangeSkinType(this.Se.getPageContext(), i);
        }
        if (this.So != null) {
            this.So.onChangeSkinType(this.Se, i, ai.getDrawable(d.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Se.getPageContext(), i);
        }
        ai.a(this.Si, d.g.icon_nav_close, d.g.icon_nav_close_w, d.g.icon_nav_close, i);
        ai.a(this.Sj, d.g.icon_more_bg_s, d.g.icon_more_bg_s, d.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sk.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Se.getPageContext().getPageActivity(), this.Sf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.Se.getPageContext().getString(d.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Se.getResources().getString(d.l.refresh), this.Sm)));
        }
        this.mNoDataView.onChangeSkinType(this.Se.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Sk.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
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
            g.a(this.So, this.Se.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sk.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Sk.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ai.j(this.Si, d.g.frs_star_navigation_bg);
        ai.j(this.Sj, d.g.frs_star_navigation_bg);
        cp("");
        this.Se.getWindow().setFlags(1024, 1024);
    }

    public void os() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sk.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Sk.setLayoutParams(layoutParams);
        this.Si.setBackgroundDrawable(null);
        this.Sj.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Se.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.Su = z;
    }
}
