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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class x {
    private TextView KB;
    private View KC;
    private ImageView KD;
    private LinearLayout KE;
    private TextView KF;
    private View.OnClickListener KG;
    private View KH;
    private MorePopupWindow KI;
    protected View KJ;
    private View KK;
    private View KL;
    private BaseWebViewActivity Kz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected View KA = null;
    private ProgressBar mProgressBar = null;

    public x(BaseWebViewActivity baseWebViewActivity) {
        this.Kz = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Kz.setContentView(u.h.base_webview_activity);
        this.KA = this.Kz.findViewById(u.g.root_view);
        this.mNavigationBar = (NavigationBar) this.Kz.findViewById(u.g.view_navigation_bar);
        bX("");
        this.KE = (LinearLayout) this.Kz.findViewById(u.g.webview_container);
        this.KF = (TextView) this.Kz.findViewById(u.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Kz.findViewById(u.g.webview_progress);
        this.KC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.widget_nb_item_finish, new y(this));
        this.KD = (ImageView) this.KC.findViewById(u.g.widget_navi_back_button);
        this.KD.setContentDescription(this.Kz.getResources().getString(u.j.close));
        this.KH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_more, new z(this));
        View inflate = LayoutInflater.from(this.Kz.getPageContext().getPageActivity()).inflate(u.h.tb_webview_pop_more, (ViewGroup) null);
        this.KI = new MorePopupWindow(this.Kz.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Kz.getPageContext().getResources().getDrawable(u.f.bg_pull_down_right_n), new aa(this));
        this.KJ = inflate.findViewById(u.g.webview_more_pop_item_share_friend_layout);
        this.KJ.setOnClickListener(this.Kz);
        if (com.baidu.tbadk.coreExtra.share.h.ae(this.Kz.getPageContext().getPageActivity())) {
            this.KJ.setVisibility(0);
        } else {
            this.KJ.setVisibility(8);
        }
        this.KI.refresh();
        this.KL = inflate.findViewById(u.g.webview_more_pop_item_open_browser_layout);
        this.KL.setOnClickListener(this.Kz);
        this.KK = inflate.findViewById(u.g.webview_more_pop_item_copy_link_layout);
        this.KK.setOnClickListener(this.Kz);
    }

    public boolean nb() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void nc() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.KD != null) {
            av.b(this.KD, u.f.icon_return_bg_s, u.f.icon_return_bg);
        }
    }

    public boolean nd() {
        try {
            this.KE.addView(this.Kz.createWebView());
            this.KF.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.KF.setVisibility(0);
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

    public void ad(boolean z) {
        if (this.KJ != null) {
            if (z) {
                this.KJ.setVisibility(0);
            } else {
                this.KJ.setVisibility(8);
            }
            this.KI.refresh();
        }
    }

    public void ae(boolean z) {
        if (this.KH != null) {
            if (z) {
                this.KH.setVisibility(0);
            } else {
                this.KH.setVisibility(8);
            }
        }
    }

    public void ne() {
        this.KI.showWindowInRightBottomOfHost();
    }

    public void nf() {
        com.baidu.adp.lib.h.j.a(this.KI, this.Kz.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.KF.setVisibility(0);
    }

    public void hideCrashTip() {
        this.KF.setVisibility(8);
    }

    public void bX(String str) {
        this.KB = this.mNavigationBar.setTitleText(str);
        av.b(this.KB, u.d.cp_cont_b, u.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Kz.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ay ayVar = new ay("c10898");
            ayVar.ab("obj_url", fVar.linkUrl);
            TiebaStatic.log(ayVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.Kz.getPageContext().getPageActivity(), fVar, true, ng())));
        }
    }

    private SparseArray<String> ng() {
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
            this.mNavigationBar.onChangeSkinType(this.Kz.getPageContext(), i);
        }
        if (this.KI != null) {
            this.KI.onChangeSkinType(this.Kz, i, av.getDrawable(u.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Kz.getPageContext(), i);
        }
        av.a(this.KD, u.f.icon_nav_close, u.f.icon_nav_close_w, u.f.icon_nav_close, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.KE.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Kz.getPageContext().getPageActivity(), this.KA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.af(null, this.Kz.getPageContext().getString(u.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Kz.getResources().getString(u.j.refresh), this.KG)));
        }
        this.mNoDataView.onChangeSkinType(this.Kz.getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
        this.KE.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.KG = onClickListener;
    }

    public void release() {
        if (this.KE != null) {
            this.KE.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.KI != null) {
            com.baidu.adp.lib.h.j.a(this.KI, this.Kz.getPageContext().getPageActivity());
        }
    }
}
