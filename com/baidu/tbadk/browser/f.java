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
    private BaseWebViewActivity cKP;
    private TextView cKQ;
    private View cKR;
    private ImageView cKS;
    private ImageView cKT;
    private ImageView cKU;
    private LinearLayout cKV;
    private TextView cKW;
    private View.OnClickListener cKY;
    private View cKZ;
    private MorePopupWindow cLa;
    protected View cLb;
    private View cLc;
    private View cLd;
    private com.baidu.tieba.person.e cLg;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView cKX = null;
    private boolean cLe = true;
    private boolean cLf = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.cKP = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cKP.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.cKP.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cKP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        so("");
        if (this.cKP.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.cKP.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.cKP);
            this.mNavigationBar.setVisibility(8);
        }
        this.cKV = (LinearLayout) this.cKP.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKV.setLayoutParams(layoutParams);
        this.cKW = (TextView) this.cKP.findViewById(R.id.webview_crash_tip);
        this.cKX = (ContinuousAnimationView) this.cKP.findViewById(R.id.webview_progress);
        this.cKX.setAnimation(R.raw.lottie_full_screen_refresh);
        this.cKR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cKP != null) {
                    if ((!(f.this.cKP instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.cKP).isDisableGoBack || !((TbWebViewActivity) f.this.cKP).needDealClickGoBack()) && !f.this.cKP.webViewGoBack()) {
                        f.this.cKP.finish();
                    }
                }
            }
        });
        this.cKS = (ImageView) this.cKR.findViewById(R.id.widget_navi_back_button);
        this.cKS.setContentDescription(this.cKP.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cKP != null) {
                    f.this.cKP.finish();
                }
            }
        });
        this.cKT = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKT.setContentDescription(this.cKP.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKT.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.cKP.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cKT.setLayoutParams(layoutParams2);
        this.cKZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.azC()) {
                    f.this.azD();
                } else if (f.this.cKU.getVisibility() != 0) {
                    f.this.arR();
                }
            }
        });
        this.Lb = (ImageView) this.cKZ.findViewById(R.id.widget_navi_more_button);
        this.cKU = (ImageView) this.cKZ.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.cKP.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLa = new MorePopupWindow(this.cKP.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cKP.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azG() {
                f.this.arR();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azH() {
            }
        });
        this.cLb = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLb.setOnClickListener(this.cKP);
        if (com.baidu.tbadk.coreExtra.share.f.dU(this.cKP.getPageContext().getPageActivity())) {
            this.cLb.setVisibility(0);
        } else {
            this.cLb.setVisibility(8);
        }
        this.cLa.refresh();
        this.cLd = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLd.setOnClickListener(this.cKP);
        this.cLc = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLc.setOnClickListener(this.cKP);
    }

    public void azy() {
        if (this.mNavigationBar != null && this.Lb != null && this.cKU != null) {
            this.Lb.setVisibility(8);
            this.cKU.setVisibility(0);
            this.cKU.setOnClickListener(this.cKP);
        }
    }

    public void jo(int i) {
        if (this.mNavigationBar != null && this.Lb != null) {
            this.Lb.setVisibility(i);
        }
    }

    public boolean azz() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void azA() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.cKT != null) {
            this.cKT.setVisibility(8);
        }
    }

    public boolean azB() {
        try {
            this.cKV.addView(this.cKP.createWebView());
            this.cKW.setVisibility(8);
            if (!this.cLe) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKW.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cKV.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cKV.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cLb != null) {
            if (z) {
                this.cLb.setVisibility(0);
            } else {
                this.cLb.setVisibility(8);
            }
            this.cLa.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cKZ != null) {
            if (z) {
                this.cKZ.setVisibility(0);
            } else {
                this.cKZ.setVisibility(8);
            }
        }
    }

    public boolean azC() {
        return this.cLf;
    }

    public void fr(boolean z) {
        this.cLf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azD() {
        if (this.cLg == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.cKP);
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.cKP.getString(R.string.report_text), aVar);
            c0629a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.cLg != null && f.this.cKP != null) {
                        f.this.cLg.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.cKP).createNormalCfg(f.this.cKP.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.cKP.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0629a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.cLg != null) {
                        f.this.cLg.dismiss();
                    }
                }
            });
            aVar.az(arrayList);
            this.cLg = new com.baidu.tieba.person.e(this.cKP, aVar.aEP());
            this.cLg.ae(0.7f);
        }
        this.cLg.show();
    }

    public void arR() {
        this.cLa.showWindowInRightBottomOfHost();
    }

    public void arS() {
        g.dismissPopupWindow(this.cLa, this.cKP.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.cKX.setVisibility(0);
        this.cKX.playAnimation();
    }

    public void hideProgressBar() {
        this.cKX.setVisibility(8);
        this.cKX.cancelAnimation();
    }

    public void showCrashTip() {
        this.cKW.setVisibility(0);
    }

    public void hideCrashTip() {
        this.cKW.setVisibility(8);
    }

    public void so(String str) {
        if (this.mNavigationBar != null) {
            this.cKQ = this.mNavigationBar.setCenterTextTitle(str);
            if (this.cKS != null && this.cKS.getVisibility() == 0 && this.cKT != null && this.cKT.getVisibility() == 0) {
                this.cKQ.setMaxWidth(l.getDimens(this.cKP.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.cKQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.cKP.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dpX) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.cKP, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bwk().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.cKP, shareItem, true, azE())));
        }
    }

    private SparseArray<String> azE() {
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
            this.mNavigationBar.onChangeSkinType(this.cKP.getPageContext(), i);
        }
        if (this.cLa != null) {
            this.cLa.onChangeSkinType(this.cKP, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cKP.getPageContext(), i);
        }
        SvgManager.aGA().a(this.cKS, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.cKT, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.cKU, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKV.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cKP.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cA(null, this.cKP.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cKP.getResources().getString(R.string.refresh), this.cKY)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.cKP.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.cKP.getPageContext());
        }
        this.cKV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKY = onClickListener;
    }

    public void release() {
        if (this.cKV != null) {
            this.cKV.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLa != null) {
            g.dismissPopupWindow(this.cLa, this.cKP.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKV.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.cKS, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKT, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        so("");
        this.cKP.getWindow().setFlags(1024, 1024);
    }

    public void azF() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKV.setLayoutParams(layoutParams);
        if (this.cKS != null) {
            this.cKS.setBackgroundDrawable(null);
        }
        if (this.cKT != null) {
            this.cKT.setBackgroundDrawable(null);
        }
        if (this.Lb != null) {
            this.Lb.setBackgroundDrawable(null);
        }
        if (this.cKU != null) {
            this.cKU.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.cKP != null) {
            this.cKP.getWindow().clearFlags(1024);
        }
    }

    public void fs(boolean z) {
        this.cLe = z;
    }
}
