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
    private BaseWebViewActivity btX;
    private TextView btZ;
    private View bua;
    private ImageView bub;
    protected ImageView buc;
    private ImageView bud;
    private LinearLayout bue;
    private TextView bug;
    private View.OnClickListener bui;
    private View buj;
    private MorePopupWindow buk;
    protected View bul;
    private View bum;
    private View bun;
    private int buo;
    private int bup;
    private com.baidu.tieba.person.e bus;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View btY = null;
    private ContinuousAnimationView buh = null;
    private boolean buq = true;
    private boolean bur = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.btX = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.btX.setContentView(d.h.base_webview_activity_new);
        this.btY = this.btX.findViewById(d.g.root_view);
        if (this.btX.isTranslucent()) {
            al.l(this.btY, this.btX.getResources().getColor(d.C0277d.black_alpha0));
            this.btY.setOnClickListener(this.btX);
        }
        this.mNavigationBar = (NavigationBar) this.btX.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        kP("");
        this.bue = (LinearLayout) this.btX.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.bue.setLayoutParams(layoutParams);
        this.bug = (TextView) this.btX.findViewById(d.g.webview_crash_tip);
        this.buh = (ContinuousAnimationView) this.btX.findViewById(d.g.webview_progress);
        this.bua = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.btX != null) {
                    if (!(f.this.btX instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.btX).isDisableGoBack || !((TbWebViewActivity) f.this.btX).needDealClickGoBack()) {
                        f.this.btX.finish();
                    }
                }
            }
        });
        this.bub = (ImageView) this.bua.findViewById(d.g.widget_navi_back_button);
        this.bub.setContentDescription(this.btX.getResources().getString(d.j.close));
        this.buj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.VT()) {
                    f.this.VU();
                } else if (f.this.bud.getVisibility() != 0) {
                    f.this.Qj();
                }
            }
        });
        this.buc = (ImageView) this.buj.findViewById(d.g.widget_navi_more_button);
        this.bud = (ImageView) this.buj.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.btX.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.buk = new MorePopupWindow(this.btX.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.btX.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VX() {
                f.this.Qj();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VY() {
            }
        });
        this.bul = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.bul.setOnClickListener(this.btX);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.btX.getPageContext().getPageActivity())) {
            this.bul.setVisibility(0);
        } else {
            this.bul.setVisibility(8);
        }
        this.buk.refresh();
        this.bun = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.bun.setOnClickListener(this.btX);
        this.bum = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.bum.setOnClickListener(this.btX);
        VO();
    }

    private void VO() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.btX.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.s(this.btX.getPageContext().getPageActivity()).heightPixels;
        this.buo = (i - statusBarHeight) - h;
        this.bup = i - statusBarHeight;
    }

    public void VP() {
        if (this.mNavigationBar != null && this.buc != null && this.bud != null) {
            this.mNavigationBar.setVisibility(0);
            this.buc.setVisibility(8);
            this.bud.setVisibility(0);
            this.bud.setOnClickListener(this.btX);
        }
    }

    public boolean VQ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void VR() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bub != null) {
            al.a(this.bub, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean VS() {
        try {
            this.bue.addView(this.btX.createWebView());
            this.bug.setVisibility(8);
            if (!this.buq) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bug.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bue.getLayoutParams().height = this.buo;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.bue.getLayoutParams().height = this.bup;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.bul != null) {
            if (z) {
                this.bul.setVisibility(0);
            } else {
                this.bul.setVisibility(8);
            }
            this.buk.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.buj != null) {
            if (z) {
                this.buj.setVisibility(0);
            } else {
                this.buj.setVisibility(8);
            }
        }
    }

    public boolean VT() {
        return this.bur;
    }

    public void dd(boolean z) {
        this.bur = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        if (this.bus == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.btX);
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.btX.getString(d.j.report_text), aVar);
            c0407a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.bus != null && f.this.btX != null) {
                        f.this.bus.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.btX).createNormalCfg(f.this.btX.getResources().getString(d.j.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0407a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.bus != null) {
                        f.this.bus.dismiss();
                    }
                }
            });
            aVar.P(arrayList);
            this.bus = new com.baidu.tieba.person.e(this.btX, aVar.abk());
            this.bus.al(0.7f);
        }
        this.bus.show();
    }

    public void Qj() {
        this.buk.showWindowInRightBottomOfHost();
    }

    public void Qk() {
        g.a(this.buk, this.btX.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.buh.setVisibility(0);
        this.buh.cu();
    }

    public void hideProgressBar() {
        this.buh.setVisibility(8);
        this.buh.cancelAnimation();
    }

    public void showCrashTip() {
        this.bug.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bug.setVisibility(8);
    }

    public void kP(String str) {
        this.btZ = this.mNavigationBar.setCenterTextTitle(str);
        al.c(this.btZ, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.btX.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.btX, dVar, true, VV())));
        }
    }

    private SparseArray<String> VV() {
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
            this.mNavigationBar.onChangeSkinType(this.btX.getPageContext(), i);
        }
        if (this.buk != null) {
            this.buk.onChangeSkinType(this.btX, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.btX.getPageContext(), i);
        }
        al.a(this.bub, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        al.a(this.buc, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        al.a(this.bud, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bue.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.btX.getPageContext().getPageActivity(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bM(null, this.btX.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.btX.getResources().getString(d.j.refresh), this.bui)));
        }
        if (!j.kM()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.btX.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.btX.getPageContext());
        }
        this.bue.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bui = onClickListener;
    }

    public void release() {
        if (this.bue != null) {
            this.bue.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.buk != null) {
            g.a(this.buk, this.btX.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bue.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bub, d.f.frs_star_navigation_bg);
        al.k(this.buc, d.f.frs_star_navigation_bg);
        al.k(this.bud, d.f.frs_star_navigation_bg);
        kP("");
        this.btX.getWindow().setFlags(1024, 1024);
    }

    public void VW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.bue.setLayoutParams(layoutParams);
        this.bub.setBackgroundDrawable(null);
        this.buc.setBackgroundDrawable(null);
        this.bud.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.btX.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.buq = z;
    }
}
