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
    private BaseWebViewActivity QD;
    private TextView QF;
    private View QG;
    private ImageView QH;
    private ImageView QI;
    private LinearLayout QJ;
    private TextView QK;
    private View.OnClickListener QL;
    private View QM;
    private MorePopupWindow QN;
    protected View QO;
    private View QP;
    private View QR;
    private int QS;
    private int QT;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected View QE = null;
    private ProgressBar mProgressBar = null;
    private boolean QU = true;

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.QD = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.QD.setContentView(d.j.base_webview_activity);
        this.QE = this.QD.findViewById(d.h.root_view);
        this.mNavigationBar = (NavigationBar) this.QD.findViewById(d.h.view_navigation_bar);
        cj("");
        this.QJ = (LinearLayout) this.QD.findViewById(d.h.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QJ.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.QJ.setLayoutParams(layoutParams);
        this.QK = (TextView) this.QD.findViewById(d.h.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.QD.findViewById(d.h.webview_progress);
        this.QG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.QD != null) {
                    e.this.QD.finish();
                }
            }
        });
        this.QH = (ImageView) this.QG.findViewById(d.h.widget_navi_back_button);
        this.QH.setContentDescription(this.QD.getResources().getString(d.l.close));
        this.QM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.of();
            }
        });
        this.QI = (ImageView) this.QM.findViewById(d.h.widget_navi_more_button);
        View inflate = LayoutInflater.from(this.QD.getPageContext().getPageActivity()).inflate(d.j.tb_webview_pop_more, (ViewGroup) null);
        this.QN = new MorePopupWindow(this.QD.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.QD.getPageContext().getResources().getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tbadk.browser.e.3
            @Override // com.baidu.tbadk.core.view.d.a
            public void oj() {
                e.this.of();
            }

            @Override // com.baidu.tbadk.core.view.d.a
            public void ok() {
            }
        });
        this.QO = inflate.findViewById(d.h.webview_more_pop_item_share_friend_layout);
        this.QO.setOnClickListener(this.QD);
        if (f.aP(this.QD.getPageContext().getPageActivity())) {
            this.QO.setVisibility(0);
        } else {
            this.QO.setVisibility(8);
        }
        this.QN.refresh();
        this.QR = inflate.findViewById(d.h.webview_more_pop_item_open_browser_layout);
        this.QR.setOnClickListener(this.QD);
        this.QP = inflate.findViewById(d.h.webview_more_pop_item_copy_link_layout);
        this.QP.setOnClickListener(this.QD);
        oc();
    }

    private void oc() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = k.g(this.QD.getPageContext().getPageActivity(), d.f.ds98);
        int i = k.o(this.QD.getPageContext().getPageActivity()).heightPixels;
        this.QS = (i - statusBarHeight) - g;
        this.QT = i - statusBarHeight;
    }

    public boolean od() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void oe() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.QH != null) {
            ai.b(this.QH, d.g.icon_return_bg_s, d.g.icon_return_bg);
        }
    }

    public boolean initWebView() {
        try {
            this.QJ.addView(this.QD.createWebView());
            this.QK.setVisibility(8);
            if (!this.QU) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.QK.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.QJ.getLayoutParams().height = this.QS;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.QJ.getLayoutParams().height = this.QT;
        this.mNavigationBar.setVisibility(8);
    }

    public void ae(boolean z) {
        if (this.QO != null) {
            if (z) {
                this.QO.setVisibility(0);
            } else {
                this.QO.setVisibility(8);
            }
            this.QN.refresh();
        }
    }

    public void af(boolean z) {
        if (this.QM != null) {
            if (z) {
                this.QM.setVisibility(0);
            } else {
                this.QM.setVisibility(8);
            }
        }
    }

    public void of() {
        this.QN.showWindowInRightBottomOfHost();
    }

    public void og() {
        g.a(this.QN, this.QD.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.QK.setVisibility(0);
    }

    public void hideCrashTip() {
        this.QK.setVisibility(8);
    }

    public void cj(String str) {
        this.QF = this.mNavigationBar.setTitleText(str);
        ai.b(this.QF, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.QD.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aj ajVar = new aj("c10898");
            ajVar.aa("obj_url", eVar.linkUrl);
            TiebaStatic.log(ajVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.QD.getPageContext().getPageActivity(), eVar, true, oh())));
        }
    }

    private SparseArray<String> oh() {
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
            this.mNavigationBar.onChangeSkinType(this.QD.getPageContext(), i);
        }
        if (this.QN != null) {
            this.QN.onChangeSkinType(this.QD, i, ai.getDrawable(d.g.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.QD.getPageContext(), i);
        }
        ai.a(this.QH, d.g.icon_nav_close, d.g.icon_nav_close_w, d.g.icon_nav_close, i);
        ai.a(this.QI, d.g.icon_more_bg_s, d.g.icon_more_bg_s, d.g.icon_more_bg_s, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.QJ.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.QD.getPageContext().getPageActivity(), this.QE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ad(null, this.QD.getPageContext().getString(d.l.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.QD.getResources().getString(d.l.refresh), this.QL)));
        }
        this.mNoDataView.onChangeSkinType(this.QD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.QJ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.QL = onClickListener;
    }

    public void release() {
        if (this.QJ != null) {
            this.QJ.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.QN != null) {
            g.a(this.QN, this.QD.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QJ.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.QJ.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        ai.j(this.QH, d.g.frs_star_navigation_bg);
        ai.j(this.QI, d.g.frs_star_navigation_bg);
        cj("");
        this.QD.getWindow().setFlags(1024, 1024);
    }

    public void oi() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.QJ.getLayoutParams();
        layoutParams.addRule(3, d.h.view_navigation_bar);
        this.QJ.setLayoutParams(layoutParams);
        this.QH.setBackgroundDrawable(null);
        this.QI.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.QD.getWindow().clearFlags(1024);
    }

    public void ag(boolean z) {
        this.QU = z;
    }
}
