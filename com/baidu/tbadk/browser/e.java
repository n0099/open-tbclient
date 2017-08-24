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
    private BaseWebViewActivity Sf;
    private TextView Sh;
    private View Si;
    private ImageView Sj;
    private ImageView Sk;
    private LinearLayout Sl;
    private TextView Sm;
    private View.OnClickListener Sn;
    private View So;
    private MorePopupWindow Sp;
    protected View Sq;
    private View Sr;
    private View Ss;
    private int St;
    private int Su;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected View Sg = null;
    private ProgressBar mProgressBar = null;
    private boolean Sv = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Sf = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Sf.setContentView(d.j.base_webview_activity);
        this.Sg = this.Sf.findViewById(d.h.root_view);
        this.mNavigationBar = (NavigationBar) this.Sf.findViewById(d.h.view_navigation_bar);
        cs("");
        this.Sl = (LinearLayout) this.Sf.findViewById(d.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sl.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Sl.setLayoutParams(layoutParams);
        this.Sm = (TextView) this.Sf.findViewById(d.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sf.findViewById(d.h.webview_progress);
        this.Si = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Sf != null) {
                    e.this.Sf.finish();
                }
            }
        });
        this.Sj = (ImageView) this.Si.findViewById(d.h.widget_navi_back_button);
        this.Sj.setContentDescription(this.Sf.getResources().getString(d.l.close));
        this.So = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.oq();
            }
        });
        this.Sk = (ImageView) this.So.findViewById(d.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Sf.getPageContext().getPageActivity()).inflate(d.j.tb_webview_pop_more, (ViewGroup) null);
        this.Sp = new MorePopupWindow(this.Sf.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sf.getPageContext().getResources().getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void ou() {
                e.this.oq();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void ov() {
            }
        });
        this.Sq = inflate.findViewById(d.h.webview_more_pop_item_share_friend_layout);
        this.Sq.setOnClickListener(this.Sf);
        if (f.aQ(this.Sf.getPageContext().getPageActivity())) {
            this.Sq.setVisibility(0);
        } else {
            this.Sq.setVisibility(8);
        }
        this.Sp.refresh();
        this.Ss = inflate.findViewById(d.h.webview_more_pop_item_open_browser_layout);
        this.Ss.setOnClickListener(this.Sf);
        this.Sr = inflate.findViewById(d.h.webview_more_pop_item_copy_link_layout);
        this.Sr.setOnClickListener(this.Sf);
        on();
    }

    private void on() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = k.g(this.Sf.getPageContext().getPageActivity(), d.f.ds98);
        int i = k.o(this.Sf.getPageContext().getPageActivity()).heightPixels;
        this.St = (i - statusBarHeight) - g;
        this.Su = i - statusBarHeight;
    }

    public boolean oo() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void op() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Sj != null) {
            ai.b(this.Sj, d.g.icon_return_bg_s, d.g.icon_return_bg);
        }
    }

    public boolean initWebView() {
        try {
            this.Sl.addView(this.Sf.createWebView());
            this.Sm.setVisibility(8);
            if (!this.Sv) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Sm.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Sl.getLayoutParams().height = this.St;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Sl.getLayoutParams().height = this.Su;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.Sq != null) {
            if (z) {
                this.Sq.setVisibility(0);
            } else {
                this.Sq.setVisibility(8);
            }
            this.Sp.refresh();
        }
    }

    public void af(boolean z) {
        if (this.So != null) {
            if (z) {
                this.So.setVisibility(0);
            } else {
                this.So.setVisibility(8);
            }
        }
    }

    public void oq() {
        this.Sp.showWindowInRightBottomOfHost();
    }

    public void or() {
        g.a(this.Sp, this.Sf.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sm.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sm.setVisibility(8);
    }

    public void cs(String str) {
        this.Sh = this.mNavigationBar.setTitleText(str);
        ai.b(this.Sh, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.Sf.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aj ajVar = new aj("c10898");
            ajVar.aa("obj_url", eVar.linkUrl);
            TiebaStatic.log(ajVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Sf.getPageContext().getPageActivity(), eVar, true, os())));
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
            this.mNavigationBar.onChangeSkinType(this.Sf.getPageContext(), i);
        }
        if (this.Sp != null) {
            this.Sp.onChangeSkinType(this.Sf, i, ai.getDrawable(d.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sf.getPageContext(), i);
        }
        ai.a(this.Sj, d.g.icon_nav_close, d.g.icon_nav_close_w, d.g.icon_nav_close, i);
        ai.a(this.Sk, d.g.icon_more_bg_s, d.g.icon_more_bg_s, d.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sl.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sf.getPageContext().getPageActivity(), this.Sg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.Sf.getPageContext().getString(d.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sf.getResources().getString(d.l.refresh), this.Sn)));
        }
        this.mNoDataView.onChangeSkinType(this.Sf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Sl.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sn = onClickListener;
    }

    public void release() {
        if (this.Sl != null) {
            this.Sl.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.Sp != null) {
            g.a(this.Sp, this.Sf.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sl.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Sl.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ai.j(this.Sj, d.g.frs_star_navigation_bg);
        ai.j(this.Sk, d.g.frs_star_navigation_bg);
        cs("");
        this.Sf.getWindow().setFlags(1024, 1024);
    }

    public void ot() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Sl.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Sl.setLayoutParams(layoutParams);
        this.Sj.setBackgroundDrawable(null);
        this.Sk.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Sf.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.Sv = z;
    }
}
