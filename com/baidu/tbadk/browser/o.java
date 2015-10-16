package com.baidu.tbadk.browser;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o {
    private BaseWebViewActivity Sf;
    private LinearLayout Sg;
    private TextView Sh;
    private View.OnClickListener Si;
    private View Sj;
    protected View Sk;
    private View Sl;
    private View Sm;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private MorePopupWindow mPopWindow;
    protected View mRoot = null;
    private ProgressBar mProgressBar = null;

    public o(BaseWebViewActivity baseWebViewActivity) {
        this.Sf = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.Sf.setContentView(i.g.base_webview_activity);
        this.mRoot = this.Sf.findViewById(i.f.root_view);
        this.mNavigationBar = (NavigationBar) this.Sf.findViewById(i.f.view_navigation_bar);
        this.Sg = (LinearLayout) this.Sf.findViewById(i.f.webview_container);
        this.Sh = (TextView) this.Sf.findViewById(i.f.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.Sf.findViewById(i.f.webview_progress);
        this.mNavigationBar = (NavigationBar) this.Sf.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.widget_nb_item_finish, new p(this));
        this.Sj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_more, new q(this));
        View inflate = LayoutInflater.from(this.Sf.getPageContext().getPageActivity()).inflate(i.g.tb_webview_pop_more, (ViewGroup) null);
        this.mPopWindow = new MorePopupWindow(this.Sf.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.Sf.getPageContext().getResources().getDrawable(i.e.bg_pull_down_right_n), new r(this));
        this.Sk = inflate.findViewById(i.f.webview_more_pop_item_share_friend_layout);
        this.Sk.setOnClickListener(this.Sf);
        if (com.baidu.tbadk.coreExtra.share.h.aj(this.Sf.getPageContext().getPageActivity())) {
            this.Sk.setVisibility(0);
        } else {
            this.Sk.setVisibility(8);
        }
        this.mPopWindow.refresh();
        this.Sm = inflate.findViewById(i.f.webview_more_pop_item_open_browser_layout);
        this.Sm.setOnClickListener(this.Sf);
        this.Sl = inflate.findViewById(i.f.webview_more_pop_item_copy_link_layout);
        this.Sl.setOnClickListener(this.Sf);
    }

    public boolean qs() {
        try {
            this.Sg.addView(this.Sf.createWebView());
            this.Sh.setVisibility(8);
            return true;
        } catch (Exception e) {
            this.Sh.setVisibility(0);
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

    public void ac(boolean z) {
        if (this.Sj != null) {
            if (z) {
                this.Sj.setVisibility(0);
            } else {
                this.Sj.setVisibility(8);
            }
        }
    }

    public void qt() {
        this.mPopWindow.showWindowInRightBottomOfHost();
    }

    public void qu() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.Sf.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.Sh.setVisibility(0);
    }

    public void hideCrashTip() {
        this.Sh.setVisibility(8);
    }

    public void bX(String str) {
        this.mNavigationBar.setTitleText(str);
    }

    public void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this.Sf.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.Sf.getPageContext().getPageActivity(), fVar, true, qv())));
        }
    }

    private SparseArray<String> qv() {
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
            this.mNavigationBar.onChangeSkinType(this.Sf.getPageContext(), i);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.Sf, i, an.getDrawable(i.e.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Sf.getPageContext(), i);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Sg.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Sf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW), NoDataViewFactory.d.ag(null, this.Sf.getPageContext().getString(i.h.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Sf.getResources().getString(i.h.refresh), this.Si)));
        }
        this.mNoDataView.onChangeSkinType(this.Sf.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.Sg.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.Si = onClickListener;
    }

    public void release() {
        if (this.Sg != null) {
            this.Sg.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.Sf.getPageContext().getPageActivity());
        }
    }
}
