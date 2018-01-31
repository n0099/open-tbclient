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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private BaseWebViewActivity aGJ;
    private TextView aGL;
    private View aGM;
    private ImageView aGN;
    private ImageView aGO;
    private LinearLayout aGP;
    private TextView aGQ;
    private View.OnClickListener aGR;
    private View aGS;
    private MorePopupWindow aGT;
    protected View aGU;
    private View aGV;
    private View aGW;
    private int aGX;
    private int aGY;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    protected View aGK = null;
    private ProgressBar mProgressBar = null;
    private boolean aGZ = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.aGJ = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aGJ.setContentView(d.h.base_webview_activity);
        this.aGK = this.aGJ.findViewById(d.g.root_view);
        if (this.aGJ.isTranslucent()) {
            aj.t(this.aGK, this.aGJ.getResources().getColor(d.C0108d.black_alpha0));
            this.aGK.setOnClickListener(this.aGJ);
        }
        this.mNavigationBar = (NavigationBar) this.aGJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cu("");
        this.aGP = (LinearLayout) this.aGJ.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGP.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aGP.setLayoutParams(layoutParams);
        this.aGQ = (TextView) this.aGJ.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aGJ.findViewById(d.g.webview_progress);
        this.aGM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aGJ != null) {
                    e.this.aGJ.finish();
                }
            }
        });
        this.aGN = (ImageView) this.aGM.findViewById(d.g.widget_navi_back_button);
        this.aGN.setContentDescription(this.aGJ.getResources().getString(d.j.close));
        this.aGS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.vT();
            }
        });
        this.aGO = (ImageView) this.aGS.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.aGJ.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aGT = new MorePopupWindow(this.aGJ.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aGJ.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.f.a
            public void vX() {
                e.this.vT();
            }

            @Override // com.baidu.tbadk.core.view.f.a
            public void vY() {
            }
        });
        this.aGU = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aGU.setOnClickListener(this.aGJ);
        if (com.baidu.tbadk.coreExtra.c.e.bd(this.aGJ.getPageContext().getPageActivity())) {
            this.aGU.setVisibility(0);
        } else {
            this.aGU.setVisibility(8);
        }
        this.aGT.refresh();
        this.aGW = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aGW.setOnClickListener(this.aGJ);
        this.aGV = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aGV.setOnClickListener(this.aGJ);
        vP();
    }

    private void vP() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int s = l.s(this.aGJ.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.aGJ.getPageContext().getPageActivity()).heightPixels;
        this.aGX = (i - statusBarHeight) - s;
        this.aGY = i - statusBarHeight;
    }

    public boolean vQ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void vR() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aGN != null) {
            aj.a(this.aGN, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean vS() {
        try {
            this.aGP.addView(this.aGJ.createWebView());
            this.aGQ.setVisibility(8);
            if (!this.aGZ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aGQ.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aGP.getLayoutParams().height = this.aGX;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aGP.getLayoutParams().height = this.aGY;
        this.mNavigationBar.setVisibility(8);
    }

    public void aK(boolean z) {
        if (this.aGU != null) {
            if (z) {
                this.aGU.setVisibility(0);
            } else {
                this.aGU.setVisibility(8);
            }
            this.aGT.refresh();
        }
    }

    public void aL(boolean z) {
        if (this.aGS != null) {
            if (z) {
                this.aGS.setVisibility(0);
            } else {
                this.aGS.setVisibility(8);
            }
        }
    }

    public void vT() {
        this.aGT.showWindowInRightBottomOfHost();
    }

    public void vU() {
        g.a(this.aGT, this.aGJ.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aGQ.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aGQ.setVisibility(8);
    }

    public void cu(String str) {
        this.aGL = this.mNavigationBar.setCenterTextTitle(str);
        aj.d(this.aGL, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aGJ.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.aa("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.aGJ.getPageContext().getPageActivity(), dVar, true, vV())));
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
            this.mNavigationBar.onChangeSkinType(this.aGJ.getPageContext(), i);
        }
        if (this.aGT != null) {
            this.aGT.onChangeSkinType(this.aGJ, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aGJ.getPageContext(), i);
        }
        aj.a(this.aGN, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.aGO, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aGP.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aGJ.getPageContext().getPageActivity(), this.aGK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.aGJ.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aGJ.getResources().getString(d.j.refresh), this.aGR)));
        }
        this.mNoDataView.onChangeSkinType(this.aGJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aGP.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aGR = onClickListener;
    }

    public void release() {
        if (this.aGP != null) {
            this.aGP.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aGT != null) {
            g.a(this.aGT, this.aGJ.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGP.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aGP.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aGN, d.f.frs_star_navigation_bg);
        aj.s(this.aGO, d.f.frs_star_navigation_bg);
        cu("");
        this.aGJ.getWindow().setFlags(1024, 1024);
    }

    public void vW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGP.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aGP.setLayoutParams(layoutParams);
        this.aGN.setBackgroundDrawable(null);
        this.aGO.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aGJ.getWindow().clearFlags(1024);
    }

    public void aM(boolean z) {
        this.aGZ = z;
    }
}
