package com.baidu.tbadk.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BaseWebViewActivity bua;
    private TextView buc;
    private View bud;
    private ImageView bue;
    protected ImageView bug;
    private ImageView buh;
    private LinearLayout bui;
    private TextView buj;
    private View.OnClickListener bul;
    private View bum;
    private MorePopupWindow bun;
    protected View buo;
    private View bup;
    private View buq;
    private int bur;
    private int bus;
    private com.baidu.tieba.person.e buv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View bub = null;
    private ContinuousAnimationView buk = null;
    private boolean but = true;
    private boolean buu = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bua = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bua.setContentView(d.h.base_webview_activity_new);
        this.bub = this.bua.findViewById(d.g.root_view);
        if (this.bua.isTranslucent()) {
            al.l(this.bub, this.bua.getResources().getColor(d.C0277d.black_alpha0));
            this.bub.setOnClickListener(this.bua);
        }
        this.mNavigationBar = (NavigationBar) this.bua.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        kQ("");
        this.bui = (LinearLayout) this.bua.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bui.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.bui.setLayoutParams(layoutParams);
        this.buj = (TextView) this.bua.findViewById(d.g.webview_crash_tip);
        this.buk = (ContinuousAnimationView) this.bua.findViewById(d.g.webview_progress);
        this.bud = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bua != null) {
                    if (!(f.this.bua instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bua).isDisableGoBack || !((TbWebViewActivity) f.this.bua).needDealClickGoBack()) {
                        f.this.bua.finish();
                    }
                }
            }
        });
        this.bue = (ImageView) this.bud.findViewById(d.g.widget_navi_back_button);
        this.bue.setContentDescription(this.bua.getResources().getString(d.j.close));
        this.bum = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.VQ()) {
                    f.this.VR();
                } else if (f.this.buh.getVisibility() != 0) {
                    f.this.Qh();
                }
            }
        });
        this.bug = (ImageView) this.bum.findViewById(d.g.widget_navi_more_button);
        this.buh = (ImageView) this.bum.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bua.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.bun = new MorePopupWindow(this.bua.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bua.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VU() {
                f.this.Qh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VV() {
            }
        });
        this.buo = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.buo.setOnClickListener(this.bua);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.bua.getPageContext().getPageActivity())) {
            this.buo.setVisibility(0);
        } else {
            this.buo.setVisibility(8);
        }
        this.bun.refresh();
        this.buq = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.buq.setOnClickListener(this.bua);
        this.bup = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.bup.setOnClickListener(this.bua);
        VL();
    }

    private void VL() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.bua.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.s(this.bua.getPageContext().getPageActivity()).heightPixels;
        this.bur = (i - statusBarHeight) - h;
        this.bus = i - statusBarHeight;
    }

    public void VM() {
        if (this.mNavigationBar != null && this.bug != null && this.buh != null) {
            this.mNavigationBar.setVisibility(0);
            this.bug.setVisibility(8);
            this.buh.setVisibility(0);
            this.buh.setOnClickListener(this.bua);
        }
    }

    public boolean VN() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void VO() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bue != null) {
            al.a(this.bue, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean VP() {
        try {
            this.bui.addView(this.bua.createWebView());
            this.buj.setVisibility(8);
            if (!this.but) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.buj.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bui.getLayoutParams().height = this.bur;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bui.getLayoutParams().height = this.bus;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.buo != null) {
            if (z) {
                this.buo.setVisibility(0);
            } else {
                this.buo.setVisibility(8);
            }
            this.bun.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.bum != null) {
            if (z) {
                this.bum.setVisibility(0);
            } else {
                this.bum.setVisibility(8);
            }
        }
    }

    public boolean VQ() {
        return this.buu;
    }

    public void dd(boolean z) {
        this.buu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.buv == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bua);
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.bua.getString(d.j.report_text), aVar);
            c0407a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.buv != null && f.this.bua != null) {
                        f.this.buv.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bua).createNormalCfg(f.this.bua.getResources().getString(d.j.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0407a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.buv != null) {
                        f.this.buv.dismiss();
                    }
                }
            });
            aVar.P(arrayList);
            this.buv = new com.baidu.tieba.person.e(this.bua, aVar.abh());
            this.buv.al(0.7f);
        }
        this.buv.show();
    }

    public void Qh() {
        this.bun.showWindowInRightBottomOfHost();
    }

    public void Qi() {
        g.a(this.bun, this.bua.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.buk.setVisibility(0);
        this.buk.cu();
    }

    public void hideProgressBar() {
        this.buk.setVisibility(8);
        this.buk.cancelAnimation();
    }

    public void showCrashTip() {
        this.buj.setVisibility(0);
    }

    public void hideCrashTip() {
        this.buj.setVisibility(8);
    }

    public void kQ(String str) {
        this.buc = this.mNavigationBar.setCenterTextTitle(str);
        al.c(this.buc, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bua.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bua, dVar, true, VS())));
        }
    }

    private SparseArray<String> VS() {
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
            this.mNavigationBar.onChangeSkinType(this.bua.getPageContext(), i);
        }
        if (this.bun != null) {
            this.bun.onChangeSkinType(this.bua, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bua.getPageContext(), i);
        }
        al.a(this.bue, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        al.a(this.bug, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        al.a(this.buh, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bui.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bua.getPageContext().getPageActivity(), this.bub, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bM(null, this.bua.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bua.getResources().getString(d.j.refresh), this.bul)));
        }
        if (!j.kM()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bua.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bua.getPageContext());
        }
        this.bui.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bul = onClickListener;
    }

    public void release() {
        if (this.bui != null) {
            this.bui.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bun != null) {
            g.a(this.bun, this.bua.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bui.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bui.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bue, d.f.frs_star_navigation_bg);
        al.k(this.bug, d.f.frs_star_navigation_bg);
        al.k(this.buh, d.f.frs_star_navigation_bg);
        kQ("");
        this.bua.getWindow().setFlags(1024, 1024);
    }

    public void VT() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bui.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.bui.setLayoutParams(layoutParams);
        this.bue.setBackgroundDrawable(null);
        this.bug.setBackgroundDrawable(null);
        this.buh.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bua.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.but = z;
    }
}
