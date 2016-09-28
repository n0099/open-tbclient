package com.baidu.tbadk.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x {
    private BaseWebViewActivity MK;
    private TextView MN;
    private View MO;
    private ImageView MP;
    private LinearLayout MQ;
    private TextView MR;
    private View.OnClickListener MS;
    private View MT;
    private MorePopupWindow MU;
    protected View MV;
    private View MW;
    private View MX;
    private int MY;
    private int MZ;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.v mNoDataView;
    protected View MM = null;
    private ProgressBar mProgressBar = null;

    public x(BaseWebViewActivity baseWebViewActivity) {
        this.MK = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.MK.setContentView(r.h.base_webview_activity);
        this.MM = this.MK.findViewById(r.g.root_view);
        this.mNavigationBar = (NavigationBar) this.MK.findViewById(r.g.view_navigation_bar);
        bY("");
        this.MQ = (LinearLayout) this.MK.findViewById(r.g.webview_container);
        this.MR = (TextView) this.MK.findViewById(r.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.MK.findViewById(r.g.webview_progress);
        this.MO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.widget_nb_item_finish, new y(this));
        this.MP = (ImageView) this.MO.findViewById(r.g.widget_navi_back_button);
        this.MP.setContentDescription(this.MK.getResources().getString(r.j.close));
        this.MT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_more, new z(this));
        View inflate = LayoutInflater.from(this.MK.getPageContext().getPageActivity()).inflate(r.h.tb_webview_pop_more, (ViewGroup) null);
        this.MU = new MorePopupWindow(this.MK.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.MK.getPageContext().getResources().getDrawable(r.f.bg_pull_down_right_n), new aa(this));
        this.MV = inflate.findViewById(r.g.webview_more_pop_item_share_friend_layout);
        this.MV.setOnClickListener(this.MK);
        if (com.baidu.tbadk.coreExtra.share.h.am(this.MK.getPageContext().getPageActivity())) {
            this.MV.setVisibility(0);
        } else {
            this.MV.setVisibility(8);
        }
        this.MU.refresh();
        this.MX = inflate.findViewById(r.g.webview_more_pop_item_open_browser_layout);
        this.MX.setOnClickListener(this.MK);
        this.MW = inflate.findViewById(r.g.webview_more_pop_item_copy_link_layout);
        this.MW.setOnClickListener(this.MK);
        nW();
    }

    private void nW() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = com.baidu.adp.lib.util.k.e(this.MK.getPageContext().getPageActivity(), r.e.ds98);
        int i = com.baidu.adp.lib.util.k.n(this.MK.getPageContext().getPageActivity()).heightPixels;
        this.MY = (i - statusBarHeight) - e;
        this.MZ = i - statusBarHeight;
    }

    public boolean nX() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void nY() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.MP != null) {
            av.b(this.MP, r.f.icon_return_bg_s, r.f.icon_return_bg);
        }
    }

    public boolean nZ() {
        try {
            this.MQ.addView(this.MK.createWebView());
            this.MR.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.MR.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.MQ.getLayoutParams().height = this.MY;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.MQ.getLayoutParams().height = this.MZ;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.MV != null) {
            if (z) {
                this.MV.setVisibility(0);
            } else {
                this.MV.setVisibility(8);
            }
            this.MU.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.MT != null) {
            if (z) {
                this.MT.setVisibility(0);
            } else {
                this.MT.setVisibility(8);
            }
        }
    }

    public void oa() {
        this.MU.showWindowInRightBottomOfHost();
    }

    public void ob() {
        com.baidu.adp.lib.h.j.a(this.MU, this.MK.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.MR.setVisibility(0);
    }

    public void hideCrashTip() {
        this.MR.setVisibility(8);
    }

    public void bY(String str) {
        this.MN = this.mNavigationBar.setTitleText(str);
        av.b(this.MN, r.d.cp_cont_b, r.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.MK.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ax axVar = new ax("c10898");
            axVar.ab("obj_url", fVar.linkUrl);
            TiebaStatic.log(axVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.MK.getPageContext().getPageActivity(), fVar, true, oc())));
        }
    }

    private SparseArray<String> oc() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(7);
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
            this.mNavigationBar.onChangeSkinType(this.MK.getPageContext(), i);
        }
        if (this.MU != null) {
            this.MU.onChangeSkinType(this.MK, i, av.getDrawable(r.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.MK.getPageContext(), i);
        }
        av.a(this.MP, r.f.icon_nav_close, r.f.icon_nav_close_w, r.f.icon_nav_close, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.MQ.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.MK.getPageContext().getPageActivity(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.MK.getPageContext().getString(r.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.MK.getResources().getString(r.j.refresh), this.MS)));
        }
        this.mNoDataView.onChangeSkinType(this.MK.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.MQ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.MS = onClickListener;
    }

    public void release() {
        if (this.MQ != null) {
            this.MQ.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.MU != null) {
            com.baidu.adp.lib.h.j.a(this.MU, this.MK.getPageContext().getPageActivity());
        }
    }
}
