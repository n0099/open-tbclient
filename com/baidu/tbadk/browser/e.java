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
    private View.OnClickListener RA;
    private View RB;
    private MorePopupWindow RC;
    protected View RD;
    private View RE;
    private View RF;
    private int RG;
    private int RH;
    private BaseWebViewActivity Rs;
    private TextView Ru;
    private View Rv;
    private ImageView Rw;
    private ImageView Rx;
    private LinearLayout Ry;
    private TextView Rz;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    protected View Rt = null;
    private ProgressBar mProgressBar = null;
    private boolean RI = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.Rs = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Rs.setContentView(d.j.base_webview_activity);
        this.Rt = this.Rs.findViewById(d.h.root_view);
        if (this.Rs.isTranslucent()) {
            aj.k(this.Rt, this.Rs.getResources().getColor(d.e.black_alpha0));
            this.Rt.setOnClickListener(this.Rs);
        }
        this.mNavigationBar = (NavigationBar) this.Rs.findViewById(d.h.view_navigation_bar);
        ci("");
        this.Ry = (LinearLayout) this.Rs.findViewById(d.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ry.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Ry.setLayoutParams(layoutParams);
        this.Rz = (TextView) this.Rs.findViewById(d.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Rs.findViewById(d.h.webview_progress);
        this.Rv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.Rs != null) {
                    e.this.Rs.finish();
                }
            }
        });
        this.Rw = (ImageView) this.Rv.findViewById(d.h.widget_navi_back_button);
        this.Rw.setContentDescription(this.Rs.getResources().getString(d.l.close));
        this.RB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ol();
            }
        });
        this.Rx = (ImageView) this.RB.findViewById(d.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.Rs.getPageContext().getPageActivity()).inflate(d.j.tb_webview_pop_more, (ViewGroup) null);
        this.RC = new MorePopupWindow(this.Rs.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Rs.getPageContext().getResources().getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void op() {
                e.this.ol();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void oq() {
            }
        });
        this.RD = inflate.findViewById(d.h.webview_more_pop_item_share_friend_layout);
        this.RD.setOnClickListener(this.Rs);
        if (com.baidu.tbadk.coreExtra.d.e.aW(this.Rs.getPageContext().getPageActivity())) {
            this.RD.setVisibility(0);
        } else {
            this.RD.setVisibility(8);
        }
        this.RC.refresh();
        this.RF = inflate.findViewById(d.h.webview_more_pop_item_open_browser_layout);
        this.RF.setOnClickListener(this.Rs);
        this.RE = inflate.findViewById(d.h.webview_more_pop_item_copy_link_layout);
        this.RE.setOnClickListener(this.Rs);
        oh();
    }

    private void oh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.Rs.getPageContext().getPageActivity(), d.f.ds98);
        int i = l.o(this.Rs.getPageContext().getPageActivity()).heightPixels;
        this.RG = (i - statusBarHeight) - f;
        this.RH = i - statusBarHeight;
    }

    public boolean oi() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oj() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.Rw != null) {
            aj.a(this.Rw, d.g.icon_return_bg_s, d.g.icon_return_bg);
        }
    }

    public boolean ok() {
        try {
            this.Ry.addView(this.Rs.createWebView());
            this.Rz.setVisibility(8);
            if (!this.RI) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.Rz.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.Ry.getLayoutParams().height = this.RG;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.Ry.getLayoutParams().height = this.RH;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.RD != null) {
            if (z) {
                this.RD.setVisibility(0);
            } else {
                this.RD.setVisibility(8);
            }
            this.RC.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.RB != null) {
            if (z) {
                this.RB.setVisibility(0);
            } else {
                this.RB.setVisibility(8);
            }
        }
    }

    public void ol() {
        this.RC.showWindowInRightBottomOfHost();
    }

    public void om() {
        g.a(this.RC, this.Rs.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Rz.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Rz.setVisibility(8);
    }

    public void ci(String str) {
        this.Ru = this.mNavigationBar.setTitleText(str);
        aj.b(this.Ru, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.d.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.Rs.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ad("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Rs.getPageContext().getPageActivity(), dVar, true, on())));
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
            this.mNavigationBar.onChangeSkinType(this.Rs.getPageContext(), i);
        }
        if (this.RC != null) {
            this.RC.onChangeSkinType(this.Rs, i, aj.getDrawable(d.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Rs.getPageContext(), i);
        }
        aj.a(this.Rw, d.g.icon_nav_close, d.g.icon_nav_close_w, d.g.icon_nav_close, i);
        aj.a(this.Rx, d.g.icon_more_bg_s, d.g.icon_more_bg_s, d.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ry.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Rs.getPageContext().getPageActivity(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ag(null, this.Rs.getPageContext().getString(d.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Rs.getResources().getString(d.l.refresh), this.RA)));
        }
        this.mNoDataView.onChangeSkinType(this.Rs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.Ry.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.RA = onClickListener;
    }

    public void release() {
        if (this.Ry != null) {
            this.Ry.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.RC != null) {
            g.a(this.RC, this.Rs.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ry.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.Ry.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.j(this.Rw, d.g.frs_star_navigation_bg);
        aj.j(this.Rx, d.g.frs_star_navigation_bg);
        ci("");
        this.Rs.getWindow().setFlags(1024, 1024);
    }

    public void oo() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ry.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.Ry.setLayoutParams(layoutParams);
        this.Rw.setBackgroundDrawable(null);
        this.Rx.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.Rs.getWindow().clearFlags(1024);
    }

    public void ah(boolean z) {
        this.RI = z;
    }
}
