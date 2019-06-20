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
import com.baidu.tieba.R;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private com.baidu.tieba.person.e bBB;
    private BaseWebViewActivity bBf;
    private TextView bBh;
    private View bBi;
    private ImageView bBj;
    private View bBk;
    private ImageView bBl;
    protected ImageView bBm;
    private ImageView bBn;
    private LinearLayout bBo;
    private TextView bBp;
    private View.OnClickListener bBr;
    private View bBs;
    private MorePopupWindow bBt;
    protected View bBu;
    private View bBv;
    private View bBw;
    private int bBx;
    private int bBy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View bBg = null;
    private ContinuousAnimationView bBq = null;
    private boolean bBz = true;
    private boolean bBA = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bBf = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bBf.setContentView(R.layout.base_webview_activity_new);
        this.bBg = this.bBf.findViewById(R.id.root_view);
        if (this.bBf.isTranslucent()) {
            al.l(this.bBg, this.bBf.getResources().getColor(R.color.black_alpha0));
            this.bBg.setOnClickListener(this.bBf);
        }
        this.mNavigationBar = (NavigationBar) this.bBf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        lU("");
        this.bBo = (LinearLayout) this.bBf.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBo.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bBo.setLayoutParams(layoutParams);
        this.bBp = (TextView) this.bBf.findViewById(R.id.webview_crash_tip);
        this.bBq = (ContinuousAnimationView) this.bBf.findViewById(R.id.webview_progress);
        this.bBi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bBf != null) {
                    if ((!(f.this.bBf instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bBf).isDisableGoBack || !((TbWebViewActivity) f.this.bBf).needDealClickGoBack()) && !f.this.bBf.webViewGoBack()) {
                        f.this.bBf.finish();
                    }
                }
            }
        });
        this.bBj = (ImageView) this.bBi.findViewById(R.id.widget_navi_back_button);
        this.bBj.setContentDescription(this.bBf.getResources().getString(R.string.back));
        this.bBk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bBf != null) {
                    f.this.bBf.finish();
                }
            }
        });
        this.bBl = (ImageView) this.bBk.findViewById(R.id.widget_navi_back_button);
        this.bBl.setContentDescription(this.bBf.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bBl.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.bBf.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bBl.setLayoutParams(layoutParams2);
        this.bBs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aaw()) {
                    f.this.aax();
                } else if (f.this.bBn.getVisibility() != 0) {
                    f.this.TT();
                }
            }
        });
        this.bBm = (ImageView) this.bBs.findViewById(R.id.widget_navi_more_button);
        this.bBn = (ImageView) this.bBs.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bBf.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bBt = new MorePopupWindow(this.bBf.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bBf.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aaA() {
                f.this.TT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aaB() {
            }
        });
        this.bBu = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bBu.setOnClickListener(this.bBf);
        if (com.baidu.tbadk.coreExtra.c.f.cI(this.bBf.getPageContext().getPageActivity())) {
            this.bBu.setVisibility(0);
        } else {
            this.bBu.setVisibility(8);
        }
        this.bBt.refresh();
        this.bBw = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bBw.setOnClickListener(this.bBf);
        this.bBv = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bBv.setOnClickListener(this.bBf);
        aar();
    }

    private void aar() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.bBf.getPageContext().getPageActivity(), R.dimen.ds88);
        int i = l.s(this.bBf.getPageContext().getPageActivity()).heightPixels;
        this.bBx = (i - statusBarHeight) - g;
        this.bBy = statusBarHeight + i;
    }

    public void aas() {
        if (this.mNavigationBar != null && this.bBm != null && this.bBn != null) {
            this.mNavigationBar.setVisibility(0);
            this.bBm.setVisibility(8);
            this.bBn.setVisibility(0);
            this.bBn.setOnClickListener(this.bBf);
        }
    }

    public void gn(int i) {
        if (this.mNavigationBar != null && this.bBm != null) {
            this.bBm.setVisibility(i);
        }
    }

    public boolean aat() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void aau() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bBl != null) {
            this.bBl.setVisibility(8);
        }
    }

    public boolean aav() {
        try {
            this.bBo.addView(this.bBf.createWebView());
            this.bBp.setVisibility(8);
            if (!this.bBz) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bBp.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bBo.getLayoutParams().height = this.bBx;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        if (UtilHelper.hasNavBar(this.bBf)) {
            this.bBo.getLayoutParams().height = this.bBy + UtilHelper.getVirtualBarHeight(this.bBf);
        } else {
            this.bBo.getLayoutParams().height = this.bBy;
        }
        this.mNavigationBar.setVisibility(8);
    }

    public void dw(boolean z) {
        if (this.bBu != null) {
            if (z) {
                this.bBu.setVisibility(0);
            } else {
                this.bBu.setVisibility(8);
            }
            this.bBt.refresh();
        }
    }

    public void dx(boolean z) {
        if (this.bBs != null) {
            if (z) {
                this.bBs.setVisibility(0);
            } else {
                this.bBs.setVisibility(8);
            }
        }
    }

    public boolean aaw() {
        return this.bBA;
    }

    public void dy(boolean z) {
        this.bBA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aax() {
        if (this.bBB == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bBf);
            ArrayList arrayList = new ArrayList();
            a.C0426a c0426a = new a.C0426a(this.bBf.getString(R.string.report_text), aVar);
            c0426a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.bBB != null && f.this.bBf != null) {
                        f.this.bBB.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bBf).createNormalCfg(f.this.bBf.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0426a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.bBB != null) {
                        f.this.bBB.dismiss();
                    }
                }
            });
            aVar.W(arrayList);
            this.bBB = new com.baidu.tieba.person.e(this.bBf, aVar.afZ());
            this.bBB.an(0.7f);
        }
        this.bBB.show();
    }

    public void TT() {
        this.bBt.showWindowInRightBottomOfHost();
    }

    public void TU() {
        g.a(this.bBt, this.bBf.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bBq.setVisibility(0);
        this.bBq.bo();
    }

    public void hideProgressBar() {
        this.bBq.setVisibility(8);
        this.bBq.cancelAnimation();
    }

    public void showCrashTip() {
        this.bBp.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bBp.setVisibility(8);
    }

    public void lU(String str) {
        this.bBh = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bBj != null && this.bBj.getVisibility() == 0 && this.bBl != null && this.bBl.getVisibility() == 0) {
            this.bBh.setMaxWidth(l.g(this.bBf.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        al.e(this.bBh, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.bBf.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.bT("obj_url", eVar.linkUrl);
            amVar.P("obj_type", 0);
            TiebaStatic.log(amVar);
            if (eVar.cjv) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.bBf, eVar, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bBf, eVar, true, aay())));
        }
    }

    private SparseArray<String> aay() {
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
            this.mNavigationBar.onChangeSkinType(this.bBf.getPageContext(), i);
        }
        if (this.bBt != null) {
            this.bBt.onChangeSkinType(this.bBf, i, al.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bBf.getPageContext(), i);
        }
        al.a(this.bBj, (int) R.drawable.selector_web_topbar_return_black, (int) R.drawable.selector_web_topbar_return_white, i);
        al.a(this.bBl, (int) R.drawable.selector_web_topbar_close_black, (int) R.drawable.selector_web_topbar_close_white, i);
        al.a(this.bBm, (int) R.drawable.selector_web_topbar_more_black, (int) R.drawable.selector_web_topbar_more_white, i);
        al.a(this.bBn, (int) R.drawable.selector_web_topbar_share_black, (int) R.drawable.selector_web_topbar_share_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bBo.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bBf.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bW(null, this.bBf.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bBf.getResources().getString(R.string.refresh), this.bBr)));
        }
        if (!j.jG()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bBf.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bBf.getPageContext());
        }
        this.bBo.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBr = onClickListener;
    }

    public void release() {
        if (this.bBo != null) {
            this.bBo.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bBt != null) {
            g.a(this.bBt, this.bBf.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBo.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bBo.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.k(this.bBj, R.drawable.frs_star_navigation_bg);
        al.k(this.bBl, R.drawable.frs_star_navigation_bg);
        al.k(this.bBm, R.drawable.frs_star_navigation_bg);
        al.k(this.bBn, R.drawable.frs_star_navigation_bg);
        lU("");
        this.bBf.getWindow().setFlags(1024, 1024);
    }

    public void aaz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bBo.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bBo.setLayoutParams(layoutParams);
        this.bBj.setBackgroundDrawable(null);
        this.bBl.setBackgroundDrawable(null);
        this.bBm.setBackgroundDrawable(null);
        this.bBn.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bBf.getWindow().clearFlags(1024);
    }

    public void dz(boolean z) {
        this.bBz = z;
    }
}
