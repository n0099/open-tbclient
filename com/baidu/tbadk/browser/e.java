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
    private BaseWebViewActivity aGI;
    private TextView aGK;
    private View aGL;
    private ImageView aGM;
    private ImageView aGN;
    private LinearLayout aGO;
    private TextView aGP;
    private View.OnClickListener aGQ;
    private View aGR;
    private MorePopupWindow aGS;
    protected View aGT;
    private View aGU;
    private View aGV;
    private int aGW;
    private int aGX;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    protected View aGJ = null;
    private ProgressBar mProgressBar = null;
    private boolean aGY = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.aGI = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aGI.setContentView(d.h.base_webview_activity);
        this.aGJ = this.aGI.findViewById(d.g.root_view);
        if (this.aGI.isTranslucent()) {
            aj.t(this.aGJ, this.aGI.getResources().getColor(d.C0108d.black_alpha0));
            this.aGJ.setOnClickListener(this.aGI);
        }
        this.mNavigationBar = (NavigationBar) this.aGI.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cu("");
        this.aGO = (LinearLayout) this.aGI.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGO.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aGO.setLayoutParams(layoutParams);
        this.aGP = (TextView) this.aGI.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aGI.findViewById(d.g.webview_progress);
        this.aGL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aGI != null) {
                    e.this.aGI.finish();
                }
            }
        });
        this.aGM = (ImageView) this.aGL.findViewById(d.g.widget_navi_back_button);
        this.aGM.setContentDescription(this.aGI.getResources().getString(d.j.close));
        this.aGR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.vT();
            }
        });
        this.aGN = (ImageView) this.aGR.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.aGI.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aGS = new MorePopupWindow(this.aGI.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aGI.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new e.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.e.a
            public void vX() {
                e.this.vT();
            }

            @Override // com.baidu.tbadk.core.view.e.a
            public void vY() {
            }
        });
        this.aGT = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aGT.setOnClickListener(this.aGI);
        if (com.baidu.tbadk.coreExtra.c.e.bg(this.aGI.getPageContext().getPageActivity())) {
            this.aGT.setVisibility(0);
        } else {
            this.aGT.setVisibility(8);
        }
        this.aGS.refresh();
        this.aGV = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aGV.setOnClickListener(this.aGI);
        this.aGU = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aGU.setOnClickListener(this.aGI);
        vP();
    }

    private void vP() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int s = l.s(this.aGI.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.aGI.getPageContext().getPageActivity()).heightPixels;
        this.aGW = (i - statusBarHeight) - s;
        this.aGX = i - statusBarHeight;
    }

    public boolean vQ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void vR() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aGM != null) {
            aj.a(this.aGM, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean vS() {
        try {
            this.aGO.addView(this.aGI.createWebView());
            this.aGP.setVisibility(8);
            if (!this.aGY) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aGP.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aGO.getLayoutParams().height = this.aGW;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aGO.getLayoutParams().height = this.aGX;
        this.mNavigationBar.setVisibility(8);
    }

    public void aJ(boolean z) {
        if (this.aGT != null) {
            if (z) {
                this.aGT.setVisibility(0);
            } else {
                this.aGT.setVisibility(8);
            }
            this.aGS.refresh();
        }
    }

    public void aK(boolean z) {
        if (this.aGR != null) {
            if (z) {
                this.aGR.setVisibility(0);
            } else {
                this.aGR.setVisibility(8);
            }
        }
    }

    public void vT() {
        this.aGS.showWindowInRightBottomOfHost();
    }

    public void vU() {
        com.baidu.adp.lib.g.g.a(this.aGS, this.aGI.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aGP.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aGP.setVisibility(8);
    }

    public void cu(String str) {
        this.aGK = this.mNavigationBar.setCenterTextTitle(str);
        aj.d(this.aGK, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aGI.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ab("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.aGI.getPageContext().getPageActivity(), dVar, true, vV())));
        }
    }

    private SparseArray<String> vV() {
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
            this.mNavigationBar.onChangeSkinType(this.aGI.getPageContext(), i);
        }
        if (this.aGS != null) {
            this.aGS.onChangeSkinType(this.aGI, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aGI.getPageContext(), i);
        }
        aj.a(this.aGM, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.aGN, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aGO.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aGI.getPageContext().getPageActivity(), this.aGJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.aGI.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aGI.getResources().getString(d.j.refresh), this.aGQ)));
        }
        this.mNoDataView.onChangeSkinType(this.aGI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aGO.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aGQ = onClickListener;
    }

    public void release() {
        if (this.aGO != null) {
            this.aGO.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aGS != null) {
            com.baidu.adp.lib.g.g.a(this.aGS, this.aGI.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGO.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aGO.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aGM, d.f.frs_star_navigation_bg);
        aj.s(this.aGN, d.f.frs_star_navigation_bg);
        cu("");
        this.aGI.getWindow().setFlags(1024, 1024);
    }

    public void vW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGO.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aGO.setLayoutParams(layoutParams);
        this.aGM.setBackgroundDrawable(null);
        this.aGN.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aGI.getWindow().clearFlags(1024);
    }

    public void aL(boolean z) {
        this.aGY = z;
    }
}
