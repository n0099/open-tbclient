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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    protected ImageView Lb;
    private BaseWebViewActivity cKR;
    private TextView cKS;
    private View cKT;
    private ImageView cKU;
    private ImageView cKV;
    private ImageView cKW;
    private LinearLayout cKX;
    private TextView cKY;
    private View.OnClickListener cLa;
    private View cLb;
    private MorePopupWindow cLc;
    protected View cLd;
    private View cLe;
    private View cLf;
    private com.baidu.tieba.person.e cLi;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView cKZ = null;
    private boolean cLg = true;
    private boolean cLh = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.cKR = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cKR.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.cKR.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cKR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        so("");
        if (this.cKR.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.cKR.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.cKR);
            this.mNavigationBar.setVisibility(8);
        }
        this.cKX = (LinearLayout) this.cKR.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKX.setLayoutParams(layoutParams);
        this.cKY = (TextView) this.cKR.findViewById(R.id.webview_crash_tip);
        this.cKZ = (ContinuousAnimationView) this.cKR.findViewById(R.id.webview_progress);
        this.cKZ.setAnimation(R.raw.lottie_full_screen_refresh);
        this.cKT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cKR != null) {
                    if ((!(f.this.cKR instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.cKR).isDisableGoBack || !((TbWebViewActivity) f.this.cKR).needDealClickGoBack()) && !f.this.cKR.webViewGoBack()) {
                        f.this.cKR.finish();
                    }
                }
            }
        });
        this.cKU = (ImageView) this.cKT.findViewById(R.id.widget_navi_back_button);
        this.cKU.setContentDescription(this.cKR.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cKR != null) {
                    f.this.cKR.finish();
                }
            }
        });
        this.cKV = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKV.setContentDescription(this.cKR.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.cKR.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cKV.setLayoutParams(layoutParams2);
        this.cLb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.azE()) {
                    f.this.azF();
                } else if (f.this.cKW.getVisibility() != 0) {
                    f.this.arT();
                }
            }
        });
        this.Lb = (ImageView) this.cLb.findViewById(R.id.widget_navi_more_button);
        this.cKW = (ImageView) this.cLb.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.cKR.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLc = new MorePopupWindow(this.cKR.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cKR.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azI() {
                f.this.arT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azJ() {
            }
        });
        this.cLd = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLd.setOnClickListener(this.cKR);
        if (com.baidu.tbadk.coreExtra.share.f.dU(this.cKR.getPageContext().getPageActivity())) {
            this.cLd.setVisibility(0);
        } else {
            this.cLd.setVisibility(8);
        }
        this.cLc.refresh();
        this.cLf = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLf.setOnClickListener(this.cKR);
        this.cLe = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLe.setOnClickListener(this.cKR);
    }

    public void azA() {
        if (this.mNavigationBar != null && this.Lb != null && this.cKW != null) {
            this.Lb.setVisibility(8);
            this.cKW.setVisibility(0);
            this.cKW.setOnClickListener(this.cKR);
        }
    }

    public void jo(int i) {
        if (this.mNavigationBar != null && this.Lb != null) {
            this.Lb.setVisibility(i);
        }
    }

    public boolean azB() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void azC() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.cKV != null) {
            this.cKV.setVisibility(8);
        }
    }

    public boolean azD() {
        try {
            this.cKX.addView(this.cKR.createWebView());
            this.cKY.setVisibility(8);
            if (!this.cLg) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKY.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cKX.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cKX.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cLd != null) {
            if (z) {
                this.cLd.setVisibility(0);
            } else {
                this.cLd.setVisibility(8);
            }
            this.cLc.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cLb != null) {
            if (z) {
                this.cLb.setVisibility(0);
            } else {
                this.cLb.setVisibility(8);
            }
        }
    }

    public boolean azE() {
        return this.cLh;
    }

    public void fr(boolean z) {
        this.cLh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azF() {
        if (this.cLi == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.cKR);
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.cKR.getString(R.string.report_text), aVar);
            c0629a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.cLi != null && f.this.cKR != null) {
                        f.this.cLi.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.cKR).createNormalCfg(f.this.cKR.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.cKR.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0629a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.cLi != null) {
                        f.this.cLi.dismiss();
                    }
                }
            });
            aVar.az(arrayList);
            this.cLi = new com.baidu.tieba.person.e(this.cKR, aVar.aER());
            this.cLi.ae(0.7f);
        }
        this.cLi.show();
    }

    public void arT() {
        this.cLc.showWindowInRightBottomOfHost();
    }

    public void arU() {
        g.dismissPopupWindow(this.cLc, this.cKR.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.cKZ.setVisibility(0);
        this.cKZ.playAnimation();
    }

    public void hideProgressBar() {
        this.cKZ.setVisibility(8);
        this.cKZ.cancelAnimation();
    }

    public void showCrashTip() {
        this.cKY.setVisibility(0);
    }

    public void hideCrashTip() {
        this.cKY.setVisibility(8);
    }

    public void so(String str) {
        if (this.mNavigationBar != null) {
            this.cKS = this.mNavigationBar.setCenterTextTitle(str);
            if (this.cKU != null && this.cKU.getVisibility() == 0 && this.cKV != null && this.cKV.getVisibility() == 0) {
                this.cKS.setMaxWidth(l.getDimens(this.cKR.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.cKS, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.cKR.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dql) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.cKR, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bwn().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.cKR, shareItem, true, azG())));
        }
    }

    private SparseArray<String> azG() {
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
            this.mNavigationBar.onChangeSkinType(this.cKR.getPageContext(), i);
        }
        if (this.cLc != null) {
            this.cLc.onChangeSkinType(this.cKR, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cKR.getPageContext(), i);
        }
        SvgManager.aGC().a(this.cKU, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.cKV, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.cKW, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKX.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cKR.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cA(null, this.cKR.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cKR.getResources().getString(R.string.refresh), this.cLa)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.cKR.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.cKR.getPageContext());
        }
        this.cKX.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLa = onClickListener;
    }

    public void release() {
        if (this.cKX != null) {
            this.cKX.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLc != null) {
            g.dismissPopupWindow(this.cLc, this.cKR.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKX.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKV, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKW, R.drawable.frs_star_navigation_bg);
        so("");
        this.cKR.getWindow().setFlags(1024, 1024);
    }

    public void azH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKX.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKX.setLayoutParams(layoutParams);
        if (this.cKU != null) {
            this.cKU.setBackgroundDrawable(null);
        }
        if (this.cKV != null) {
            this.cKV.setBackgroundDrawable(null);
        }
        if (this.Lb != null) {
            this.Lb.setBackgroundDrawable(null);
        }
        if (this.cKW != null) {
            this.cKW.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.cKR != null) {
            this.cKR.getWindow().clearFlags(1024);
        }
    }

    public void fs(boolean z) {
        this.cLg = z;
    }
}
