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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private TextView adB;
    private View adC;
    private ImageView adD;
    protected ImageView adE;
    private ImageView adF;
    private LinearLayout adG;
    private TextView adH;
    private View.OnClickListener adI;
    private View adJ;
    private MorePopupWindow adK;
    protected View adL;
    private View adM;
    private View adN;
    private int adO;
    private int adP;
    private com.baidu.tieba.person.e adS;
    private BaseWebViewActivity adz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View adA = null;
    private ProgressBar mProgressBar = null;
    private boolean adQ = true;
    private boolean adR = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.adz = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.adz.setContentView(e.h.base_webview_activity);
        this.adA = this.adz.findViewById(e.g.root_view);
        if (this.adz.isTranslucent()) {
            al.j(this.adA, this.adz.getResources().getColor(e.d.black_alpha0));
            this.adA.setOnClickListener(this.adz);
        }
        this.mNavigationBar = (NavigationBar) this.adz.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        m13do("");
        this.adG = (LinearLayout) this.adz.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adG.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.adG.setLayoutParams(layoutParams);
        this.adH = (TextView) this.adz.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.adz.findViewById(e.g.webview_progress);
        this.adC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.adz != null) {
                    f.this.adz.finish();
                }
            }
        });
        this.adD = (ImageView) this.adC.findViewById(e.g.widget_navi_back_button);
        this.adD.setContentDescription(this.adz.getResources().getString(e.j.close));
        this.adJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.tC()) {
                    f.this.tD();
                } else if (f.this.adF.getVisibility() != 0) {
                    f.this.tE();
                }
            }
        });
        this.adE = (ImageView) this.adJ.findViewById(e.g.widget_navi_more_button);
        this.adF = (ImageView) this.adJ.findViewById(e.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.adz.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.adK = new MorePopupWindow(this.adz.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.adz.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void tI() {
                f.this.tE();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void tJ() {
            }
        });
        this.adL = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.adL.setOnClickListener(this.adz);
        if (com.baidu.tbadk.coreExtra.c.e.bD(this.adz.getPageContext().getPageActivity())) {
            this.adL.setVisibility(0);
        } else {
            this.adL.setVisibility(8);
        }
        this.adK.refresh();
        this.adN = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.adN.setOnClickListener(this.adz);
        this.adM = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.adM.setOnClickListener(this.adz);
        tx();
    }

    private void tx() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.adz.getPageContext().getPageActivity(), e.C0141e.ds88);
        int i = l.s(this.adz.getPageContext().getPageActivity()).heightPixels;
        this.adO = (i - statusBarHeight) - h;
        this.adP = i - statusBarHeight;
    }

    public void ty() {
        if (this.mNavigationBar != null && this.adE != null && this.adF != null) {
            this.mNavigationBar.setVisibility(0);
            this.adE.setVisibility(8);
            this.adF.setVisibility(0);
            this.adF.setOnClickListener(this.adz);
        }
    }

    public boolean tz() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void tA() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.adD != null) {
            al.a(this.adD, e.f.icon_return_bg_s, e.f.icon_return_bg);
        }
    }

    public boolean tB() {
        try {
            this.adG.addView(this.adz.createWebView());
            this.adH.setVisibility(8);
            if (!this.adQ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.adH.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.adG.getLayoutParams().height = this.adO;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.adG.getLayoutParams().height = this.adP;
        this.mNavigationBar.setVisibility(8);
    }

    public void ap(boolean z) {
        if (this.adL != null) {
            if (z) {
                this.adL.setVisibility(0);
            } else {
                this.adL.setVisibility(8);
            }
            this.adK.refresh();
        }
    }

    public void aq(boolean z) {
        if (this.adJ != null) {
            if (z) {
                this.adJ.setVisibility(0);
            } else {
                this.adJ.setVisibility(8);
            }
        }
    }

    public boolean tC() {
        return this.adR;
    }

    public void ar(boolean z) {
        this.adR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tD() {
        if (this.adS == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.adz);
            ArrayList arrayList = new ArrayList();
            a.C0257a c0257a = new a.C0257a(this.adz.getString(e.j.report_text), aVar);
            c0257a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.adS != null && f.this.adz != null) {
                        f.this.adS.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.adz).createNormalCfg(f.this.adz.getResources().getString(e.j.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0257a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.adS != null) {
                        f.this.adS.dismiss();
                    }
                }
            });
            aVar.dN(arrayList);
            this.adS = new com.baidu.tieba.person.e(this.adz, aVar.bHj());
            this.adS.au(0.7f);
        }
        this.adS.show();
    }

    public void tE() {
        this.adK.showWindowInRightBottomOfHost();
    }

    public void tF() {
        g.a(this.adK, this.adz.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.adH.setVisibility(0);
    }

    public void hideCrashTip() {
        this.adH.setVisibility(8);
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(String str) {
        this.adB = this.mNavigationBar.setCenterTextTitle(str);
        al.b(this.adB, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.adz.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.al("obj_url", dVar.linkUrl);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.adz, dVar, true, tG())));
        }
    }

    private SparseArray<String> tG() {
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
            this.mNavigationBar.onChangeSkinType(this.adz.getPageContext(), i);
        }
        if (this.adK != null) {
            this.adK.onChangeSkinType(this.adz, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.adz.getPageContext(), i);
        }
        al.a(this.adD, e.f.icon_topbar_close_n, e.f.icon_topbar_close_s, e.f.icon_topbar_close_n, i);
        al.a(this.adE, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
        al.a(this.adF, e.f.icon_home_card_share, e.f.icon_home_card_share, e.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.adG.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.adz.getPageContext().getPageActivity(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ao(null, this.adz.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.adz.getResources().getString(e.j.refresh), this.adI)));
        }
        this.mNoDataView.onChangeSkinType(this.adz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.adG.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.adI = onClickListener;
    }

    public void release() {
        if (this.adG != null) {
            this.adG.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.adK != null) {
            g.a(this.adK, this.adz.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adG.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.adG.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.adD, e.f.frs_star_navigation_bg);
        al.i(this.adE, e.f.frs_star_navigation_bg);
        al.i(this.adF, e.f.frs_star_navigation_bg);
        m13do("");
        this.adz.getWindow().setFlags(1024, 1024);
    }

    public void tH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adG.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.adG.setLayoutParams(layoutParams);
        this.adD.setBackgroundDrawable(null);
        this.adE.setBackgroundDrawable(null);
        this.adF.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.adz.getWindow().clearFlags(1024);
    }

    public void as(boolean z) {
        this.adQ = z;
    }
}
