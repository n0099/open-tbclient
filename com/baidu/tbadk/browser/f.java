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
    private BaseWebViewActivity btV;
    private TextView btX;
    private View btY;
    private ImageView btZ;
    protected ImageView bua;
    private ImageView bub;
    private LinearLayout buc;
    private TextView bud;
    private View.OnClickListener bug;
    private View buh;
    private MorePopupWindow bui;
    protected View buj;
    private View buk;
    private View bul;
    private int bum;
    private int bun;
    private com.baidu.tieba.person.e buq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View btW = null;
    private ContinuousAnimationView bue = null;
    private boolean buo = true;
    private boolean bup = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.btV = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.btV.setContentView(d.h.base_webview_activity_new);
        this.btW = this.btV.findViewById(d.g.root_view);
        if (this.btV.isTranslucent()) {
            al.l(this.btW, this.btV.getResources().getColor(d.C0236d.black_alpha0));
            this.btW.setOnClickListener(this.btV);
        }
        this.mNavigationBar = (NavigationBar) this.btV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        kP("");
        this.buc = (LinearLayout) this.btV.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buc.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buc.setLayoutParams(layoutParams);
        this.bud = (TextView) this.btV.findViewById(d.g.webview_crash_tip);
        this.bue = (ContinuousAnimationView) this.btV.findViewById(d.g.webview_progress);
        this.btY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.btV != null) {
                    if (!(f.this.btV instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.btV).isDisableGoBack || !((TbWebViewActivity) f.this.btV).needDealClickGoBack()) {
                        f.this.btV.finish();
                    }
                }
            }
        });
        this.btZ = (ImageView) this.btY.findViewById(d.g.widget_navi_back_button);
        this.btZ.setContentDescription(this.btV.getResources().getString(d.j.close));
        this.buh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.VT()) {
                    f.this.VU();
                } else if (f.this.bub.getVisibility() != 0) {
                    f.this.Qj();
                }
            }
        });
        this.bua = (ImageView) this.buh.findViewById(d.g.widget_navi_more_button);
        this.bub = (ImageView) this.buh.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.btV.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.bui = new MorePopupWindow(this.btV.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.btV.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VX() {
                f.this.Qj();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void VY() {
            }
        });
        this.buj = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.buj.setOnClickListener(this.btV);
        if (com.baidu.tbadk.coreExtra.c.e.dc(this.btV.getPageContext().getPageActivity())) {
            this.buj.setVisibility(0);
        } else {
            this.buj.setVisibility(8);
        }
        this.bui.refresh();
        this.bul = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.bul.setOnClickListener(this.btV);
        this.buk = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.buk.setOnClickListener(this.btV);
        VO();
    }

    private void VO() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.btV.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.s(this.btV.getPageContext().getPageActivity()).heightPixels;
        this.bum = (i - statusBarHeight) - h;
        this.bun = i - statusBarHeight;
    }

    public void VP() {
        if (this.mNavigationBar != null && this.bua != null && this.bub != null) {
            this.mNavigationBar.setVisibility(0);
            this.bua.setVisibility(8);
            this.bub.setVisibility(0);
            this.bub.setOnClickListener(this.btV);
        }
    }

    public boolean VQ() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void VR() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.btZ != null) {
            al.a(this.btZ, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean VS() {
        try {
            this.buc.addView(this.btV.createWebView());
            this.bud.setVisibility(8);
            if (!this.buo) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bud.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.buc.getLayoutParams().height = this.bum;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.buc.getLayoutParams().height = this.bun;
        this.mNavigationBar.setVisibility(8);
    }

    public void db(boolean z) {
        if (this.buj != null) {
            if (z) {
                this.buj.setVisibility(0);
            } else {
                this.buj.setVisibility(8);
            }
            this.bui.refresh();
        }
    }

    public void dc(boolean z) {
        if (this.buh != null) {
            if (z) {
                this.buh.setVisibility(0);
            } else {
                this.buh.setVisibility(8);
            }
        }
    }

    public boolean VT() {
        return this.bup;
    }

    public void dd(boolean z) {
        this.bup = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VU() {
        if (this.buq == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.btV);
            ArrayList arrayList = new ArrayList();
            a.C0311a c0311a = new a.C0311a(this.btV.getString(d.j.report_text), aVar);
            c0311a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.buq != null && f.this.btV != null) {
                        f.this.buq.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.btV).createNormalCfg(f.this.btV.getResources().getString(d.j.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0311a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.buq != null) {
                        f.this.buq.dismiss();
                    }
                }
            });
            aVar.P(arrayList);
            this.buq = new com.baidu.tieba.person.e(this.btV, aVar.abk());
            this.buq.al(0.7f);
        }
        this.buq.show();
    }

    public void Qj() {
        this.bui.showWindowInRightBottomOfHost();
    }

    public void Qk() {
        g.a(this.bui, this.btV.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bue.setVisibility(0);
        this.bue.cu();
    }

    public void hideProgressBar() {
        this.bue.setVisibility(8);
        this.bue.cancelAnimation();
    }

    public void showCrashTip() {
        this.bud.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bud.setVisibility(8);
    }

    public void kP(String str) {
        this.btX = this.mNavigationBar.setCenterTextTitle(str);
        al.c(this.btX, d.C0236d.cp_cont_b, d.C0236d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.btV.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bJ("obj_url", dVar.linkUrl);
            amVar.T("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.btV, dVar, true, VV())));
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
            this.mNavigationBar.onChangeSkinType(this.btV.getPageContext(), i);
        }
        if (this.bui != null) {
            this.bui.onChangeSkinType(this.btV, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.btV.getPageContext(), i);
        }
        al.a(this.btZ, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        al.a(this.bua, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        al.a(this.bub, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.buc.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.btV.getPageContext().getPageActivity(), this.btW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bM(null, this.btV.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.btV.getResources().getString(d.j.refresh), this.bug)));
        }
        if (!j.kM()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.btV.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.btV.getPageContext());
        }
        this.buc.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bug = onClickListener;
    }

    public void release() {
        if (this.buc != null) {
            this.buc.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bui != null) {
            g.a(this.bui, this.btV.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buc.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.buc.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.btZ, d.f.frs_star_navigation_bg);
        al.k(this.bua, d.f.frs_star_navigation_bg);
        al.k(this.bub, d.f.frs_star_navigation_bg);
        kP("");
        this.btV.getWindow().setFlags(1024, 1024);
    }

    public void VW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buc.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.buc.setLayoutParams(layoutParams);
        this.btZ.setBackgroundDrawable(null);
        this.bua.setBackgroundDrawable(null);
        this.bub.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.btV.getWindow().clearFlags(1024);
    }

    public void de(boolean z) {
        this.buo = z;
    }
}
