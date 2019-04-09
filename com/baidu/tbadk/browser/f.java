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
    private BaseWebViewActivity bub;
    private TextView bud;
    private View bue;
    private ImageView bug;
    protected ImageView buh;
    private ImageView bui;
    private LinearLayout buj;
    private TextView buk;
    private View.OnClickListener bum;
    private View bun;
    private MorePopupWindow buo;
    protected View bup;
    private View buq;
    private View bur;
    private int bus;
    private int but;
    private com.baidu.tieba.person.e buw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View buc = null;
    private ContinuousAnimationView bul = null;
    private boolean buu = true;
    private boolean buv = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bub = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bub.setContentView(d.h.base_webview_activity_new);
        this.buc = this.bub.findViewById(d.g.root_view);
        if (this.bub.isTranslucent()) {
            al.l(this.buc, this.bub.getResources().getColor(d.C0277d.black_alpha0));
            this.buc.setOnClickListener(this.bub);
        }
        this.mNavigationBar = (NavigationBar) this.bub.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        kQ("");
        this.buj = (LinearLayout) this.bub.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buj.setLayoutParams(layoutParams);
        this.buk = (TextView) this.bub.findViewById(d.g.webview_crash_tip);
        this.bul = (ContinuousAnimationView) this.bub.findViewById(d.g.webview_progress);
        this.bue = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bub != null) {
                    if (!(f.this.bub instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bub).isDisableGoBack || !((TbWebViewActivity) f.this.bub).needDealClickGoBack()) {
                        f.this.bub.finish();
                    }
                }
            }
        });
        this.bug = (ImageView) this.bue.findViewById(d.g.widget_navi_back_button);
        this.bug.setContentDescription(this.bub.getResources().getString(d.j.close));
        this.bun = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.VQ()) {
                    f.this.VR();
                } else if (f.this.bui.getVisibility() != 0) {
                    f.this.Qh();
                }
            }
        });
        this.buh = (ImageView) this.bun.findViewById(d.g.widget_navi_more_button);
        this.bui = (ImageView) this.bun.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bub.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.buo = new MorePopupWindow(this.bub.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bub.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VU() {
                f.this.Qh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VV() {
            }
        });
        this.bup = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.bup.setOnClickListener(this.bub);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.bub.getPageContext().getPageActivity())) {
            this.bup.setVisibility(0);
        } else {
            this.bup.setVisibility(8);
        }
        this.buo.refresh();
        this.bur = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.bur.setOnClickListener(this.bub);
        this.buq = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.buq.setOnClickListener(this.bub);
        VL();
    }

    private void VL() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.bub.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.s(this.bub.getPageContext().getPageActivity()).heightPixels;
        this.bus = (i - statusBarHeight) - h;
        this.but = i - statusBarHeight;
    }

    public void VM() {
        if (this.mNavigationBar != null && this.buh != null && this.bui != null) {
            this.mNavigationBar.setVisibility(0);
            this.buh.setVisibility(8);
            this.bui.setVisibility(0);
            this.bui.setOnClickListener(this.bub);
        }
    }

    public boolean VN() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void VO() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bug != null) {
            al.a(this.bug, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean VP() {
        try {
            this.buj.addView(this.bub.createWebView());
            this.buk.setVisibility(8);
            if (!this.buu) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.buk.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.buj.getLayoutParams().height = this.bus;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.buj.getLayoutParams().height = this.but;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.bup != null) {
            if (z) {
                this.bup.setVisibility(0);
            } else {
                this.bup.setVisibility(8);
            }
            this.buo.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.bun != null) {
            if (z) {
                this.bun.setVisibility(0);
            } else {
                this.bun.setVisibility(8);
            }
        }
    }

    public boolean VQ() {
        return this.buv;
    }

    public void dd(boolean z) {
        this.buv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.buw == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bub);
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.bub.getString(d.j.report_text), aVar);
            c0407a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.buw != null && f.this.bub != null) {
                        f.this.buw.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bub).createNormalCfg(f.this.bub.getResources().getString(d.j.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0407a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.buw != null) {
                        f.this.buw.dismiss();
                    }
                }
            });
            aVar.P(arrayList);
            this.buw = new com.baidu.tieba.person.e(this.bub, aVar.abh());
            this.buw.al(0.7f);
        }
        this.buw.show();
    }

    public void Qh() {
        this.buo.showWindowInRightBottomOfHost();
    }

    public void Qi() {
        g.a(this.buo, this.bub.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bul.setVisibility(0);
        this.bul.cu();
    }

    public void hideProgressBar() {
        this.bul.setVisibility(8);
        this.bul.cancelAnimation();
    }

    public void showCrashTip() {
        this.buk.setVisibility(0);
    }

    public void hideCrashTip() {
        this.buk.setVisibility(8);
    }

    public void kQ(String str) {
        this.bud = this.mNavigationBar.setCenterTextTitle(str);
        al.c(this.bud, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.bub.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bub, dVar, true, VS())));
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
            this.mNavigationBar.onChangeSkinType(this.bub.getPageContext(), i);
        }
        if (this.buo != null) {
            this.buo.onChangeSkinType(this.bub, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bub.getPageContext(), i);
        }
        al.a(this.bug, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        al.a(this.buh, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        al.a(this.bui, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.buj.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bub.getPageContext().getPageActivity(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bM(null, this.bub.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bub.getResources().getString(d.j.refresh), this.bum)));
        }
        if (!j.kM()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bub.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bub.getPageContext());
        }
        this.buj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bum = onClickListener;
    }

    public void release() {
        if (this.buj != null) {
            this.buj.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.buo != null) {
            g.a(this.buo, this.bub.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buj.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.buj.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bug, d.f.frs_star_navigation_bg);
        al.k(this.buh, d.f.frs_star_navigation_bg);
        al.k(this.bui, d.f.frs_star_navigation_bg);
        kQ("");
        this.bub.getWindow().setFlags(1024, 1024);
    }

    public void VT() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buj.setLayoutParams(layoutParams);
        this.bug.setBackgroundDrawable(null);
        this.buh.setBackgroundDrawable(null);
        this.bui.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bub.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.buu = z;
    }
}
