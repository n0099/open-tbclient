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
    private BaseWebViewActivity aGG;
    private TextView aGI;
    private View aGJ;
    private ImageView aGK;
    private ImageView aGL;
    private LinearLayout aGM;
    private TextView aGN;
    private View.OnClickListener aGO;
    private View aGP;
    private MorePopupWindow aGQ;
    protected View aGR;
    private View aGS;
    private View aGT;
    private int aGU;
    private int aGV;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    protected View aGH = null;
    private ProgressBar mProgressBar = null;
    private boolean aGW = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.aGG = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aGG.setContentView(d.h.base_webview_activity);
        this.aGH = this.aGG.findViewById(d.g.root_view);
        if (this.aGG.isTranslucent()) {
            aj.t(this.aGH, this.aGG.getResources().getColor(d.C0107d.black_alpha0));
            this.aGH.setOnClickListener(this.aGG);
        }
        this.mNavigationBar = (NavigationBar) this.aGG.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cu("");
        this.aGM = (LinearLayout) this.aGG.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGM.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aGM.setLayoutParams(layoutParams);
        this.aGN = (TextView) this.aGG.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aGG.findViewById(d.g.webview_progress);
        this.aGJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aGG != null) {
                    e.this.aGG.finish();
                }
            }
        });
        this.aGK = (ImageView) this.aGJ.findViewById(d.g.widget_navi_back_button);
        this.aGK.setContentDescription(this.aGG.getResources().getString(d.j.close));
        this.aGP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.vS();
            }
        });
        this.aGL = (ImageView) this.aGP.findViewById(d.g.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.aGG.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aGQ = new MorePopupWindow(this.aGG.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aGG.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.f.a
            public void vW() {
                e.this.vS();
            }

            @Override // com.baidu.tbadk.core.view.f.a
            public void vX() {
            }
        });
        this.aGR = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aGR.setOnClickListener(this.aGG);
        if (com.baidu.tbadk.coreExtra.c.e.bg(this.aGG.getPageContext().getPageActivity())) {
            this.aGR.setVisibility(0);
        } else {
            this.aGR.setVisibility(8);
        }
        this.aGQ.refresh();
        this.aGT = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aGT.setOnClickListener(this.aGG);
        this.aGS = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aGS.setOnClickListener(this.aGG);
        vO();
    }

    private void vO() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int s = l.s(this.aGG.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.o(this.aGG.getPageContext().getPageActivity()).heightPixels;
        this.aGU = (i - statusBarHeight) - s;
        this.aGV = i - statusBarHeight;
    }

    public boolean vP() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void vQ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aGK != null) {
            aj.a(this.aGK, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean vR() {
        try {
            this.aGM.addView(this.aGG.createWebView());
            this.aGN.setVisibility(8);
            if (!this.aGW) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aGN.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aGM.getLayoutParams().height = this.aGU;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aGM.getLayoutParams().height = this.aGV;
        this.mNavigationBar.setVisibility(8);
    }

    public void aJ(boolean z) {
        if (this.aGR != null) {
            if (z) {
                this.aGR.setVisibility(0);
            } else {
                this.aGR.setVisibility(8);
            }
            this.aGQ.refresh();
        }
    }

    public void aK(boolean z) {
        if (this.aGP != null) {
            if (z) {
                this.aGP.setVisibility(0);
            } else {
                this.aGP.setVisibility(8);
            }
        }
    }

    public void vS() {
        this.aGQ.showWindowInRightBottomOfHost();
    }

    public void vT() {
        g.a(this.aGQ, this.aGG.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aGN.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aGN.setVisibility(8);
    }

    public void cu(String str) {
        this.aGI = this.mNavigationBar.setCenterTextTitle(str);
        aj.d(this.aGI, d.C0107d.cp_cont_b, d.C0107d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aGG.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ab("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.aGG.getPageContext().getPageActivity(), dVar, true, vU())));
        }
    }

    private SparseArray<String> vU() {
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
            this.mNavigationBar.onChangeSkinType(this.aGG.getPageContext(), i);
        }
        if (this.aGQ != null) {
            this.aGQ.onChangeSkinType(this.aGG, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aGG.getPageContext(), i);
        }
        aj.a(this.aGK, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.aGL, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aGM.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aGG.getPageContext().getPageActivity(), this.aGH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.aGG.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aGG.getResources().getString(d.j.refresh), this.aGO)));
        }
        this.mNoDataView.onChangeSkinType(this.aGG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aGM.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aGO = onClickListener;
    }

    public void release() {
        if (this.aGM != null) {
            this.aGM.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aGQ != null) {
            g.a(this.aGQ, this.aGG.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGM.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aGM.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aGK, d.f.frs_star_navigation_bg);
        aj.s(this.aGL, d.f.frs_star_navigation_bg);
        cu("");
        this.aGG.getWindow().setFlags(1024, 1024);
    }

    public void vV() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGM.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aGM.setLayoutParams(layoutParams);
        this.aGK.setBackgroundDrawable(null);
        this.aGL.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aGG.getWindow().clearFlags(1024);
    }

    public void aL(boolean z) {
        this.aGW = z;
    }
}
