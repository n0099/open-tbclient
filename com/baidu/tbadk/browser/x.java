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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x {
    private BaseWebViewActivity MM;
    private TextView MO;
    private View MP;
    private ImageView MQ;
    private LinearLayout MR;
    private TextView MS;
    private View.OnClickListener MT;
    private View MU;
    private MorePopupWindow MV;
    protected View MW;
    private View MX;
    private View MY;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected View MN = null;
    private ProgressBar mProgressBar = null;

    public x(BaseWebViewActivity baseWebViewActivity) {
        this.MM = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.MM.setContentView(t.h.base_webview_activity);
        this.MN = this.MM.findViewById(t.g.root_view);
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(t.g.view_navigation_bar);
        bY("");
        this.MR = (LinearLayout) this.MM.findViewById(t.g.webview_container);
        this.MS = (TextView) this.MM.findViewById(t.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.MM.findViewById(t.g.webview_progress);
        this.MP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.widget_nb_item_finish, new y(this));
        this.MQ = (ImageView) this.MP.findViewById(t.g.widget_navi_back_button);
        this.MQ.setContentDescription(this.MM.getResources().getString(t.j.close));
        this.MU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_more, new z(this));
        View inflate = LayoutInflater.from(this.MM.getPageContext().getPageActivity()).inflate(t.h.tb_webview_pop_more, (ViewGroup) null);
        this.MV = new MorePopupWindow(this.MM.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.MM.getPageContext().getResources().getDrawable(t.f.bg_pull_down_right_n), new aa(this));
        this.MW = inflate.findViewById(t.g.webview_more_pop_item_share_friend_layout);
        this.MW.setOnClickListener(this.MM);
        if (com.baidu.tbadk.coreExtra.share.h.ao(this.MM.getPageContext().getPageActivity())) {
            this.MW.setVisibility(0);
        } else {
            this.MW.setVisibility(8);
        }
        this.MV.refresh();
        this.MY = inflate.findViewById(t.g.webview_more_pop_item_open_browser_layout);
        this.MY.setOnClickListener(this.MM);
        this.MX = inflate.findViewById(t.g.webview_more_pop_item_copy_link_layout);
        this.MX.setOnClickListener(this.MM);
    }

    public boolean nW() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void nX() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.MQ != null) {
            av.b(this.MQ, t.f.icon_return_bg_s, t.f.icon_return_bg);
        }
    }

    public boolean nY() {
        try {
            this.MR.addView(this.MM.createWebView());
            this.MS.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.MS.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.mNavigationBar.setVisibility(0);
        } else {
            this.mNavigationBar.setVisibility(8);
        }
    }

    public void af(boolean z) {
        if (this.MW != null) {
            if (z) {
                this.MW.setVisibility(0);
            } else {
                this.MW.setVisibility(8);
            }
            this.MV.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.MU != null) {
            if (z) {
                this.MU.setVisibility(0);
            } else {
                this.MU.setVisibility(8);
            }
        }
    }

    public void nZ() {
        this.MV.showWindowInRightBottomOfHost();
    }

    public void oa() {
        com.baidu.adp.lib.h.j.a(this.MV, this.MM.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.MS.setVisibility(0);
    }

    public void hideCrashTip() {
        this.MS.setVisibility(8);
    }

    public void bY(String str) {
        this.MO = this.mNavigationBar.setTitleText(str);
        av.b(this.MO, t.d.cp_cont_b, t.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.MM.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ay ayVar = new ay("c10898");
            ayVar.ab("obj_url", fVar.linkUrl);
            TiebaStatic.log(ayVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.MM.getPageContext().getPageActivity(), fVar, true, ob())));
        }
    }

    private SparseArray<String> ob() {
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
            this.mNavigationBar.onChangeSkinType(this.MM.getPageContext(), i);
        }
        if (this.MV != null) {
            this.MV.onChangeSkinType(this.MM, i, av.getDrawable(t.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.MM.getPageContext(), i);
        }
        av.a(this.MQ, t.f.icon_nav_close, t.f.icon_nav_close_w, t.f.icon_nav_close, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.MR.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.MM.getPageContext().getPageActivity(), this.MN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.MM.getPageContext().getString(t.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.MM.getResources().getString(t.j.refresh), this.MT)));
        }
        this.mNoDataView.onChangeSkinType(this.MM.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.MR.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
    }

    public void release() {
        if (this.MR != null) {
            this.MR.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.MV != null) {
            com.baidu.adp.lib.h.j.a(this.MV, this.MM.getPageContext().getPageActivity());
        }
    }
}
