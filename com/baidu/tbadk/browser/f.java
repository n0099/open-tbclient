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
    private BaseWebViewActivity cKQ;
    private TextView cKR;
    private View cKS;
    private ImageView cKT;
    private ImageView cKU;
    private ImageView cKV;
    private LinearLayout cKW;
    private TextView cKX;
    private View.OnClickListener cKZ;
    private View cLa;
    private MorePopupWindow cLb;
    protected View cLc;
    private View cLd;
    private View cLe;
    private com.baidu.tieba.person.e cLh;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView cKY = null;
    private boolean cLf = true;
    private boolean cLg = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.cKQ = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cKQ.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.cKQ.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cKQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        so("");
        if (this.cKQ.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.cKQ.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.cKQ);
            this.mNavigationBar.setVisibility(8);
        }
        this.cKW = (LinearLayout) this.cKQ.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKW.setLayoutParams(layoutParams);
        this.cKX = (TextView) this.cKQ.findViewById(R.id.webview_crash_tip);
        this.cKY = (ContinuousAnimationView) this.cKQ.findViewById(R.id.webview_progress);
        this.cKY.setAnimation(R.raw.lottie_full_screen_refresh);
        this.cKS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cKQ != null) {
                    if ((!(f.this.cKQ instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.cKQ).isDisableGoBack || !((TbWebViewActivity) f.this.cKQ).needDealClickGoBack()) && !f.this.cKQ.webViewGoBack()) {
                        f.this.cKQ.finish();
                    }
                }
            }
        });
        this.cKT = (ImageView) this.cKS.findViewById(R.id.widget_navi_back_button);
        this.cKT.setContentDescription(this.cKQ.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cKQ != null) {
                    f.this.cKQ.finish();
                }
            }
        });
        this.cKU = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKU.setContentDescription(this.cKQ.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKU.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.cKQ.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cKU.setLayoutParams(layoutParams2);
        this.cLa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.azE()) {
                    f.this.azF();
                } else if (f.this.cKV.getVisibility() != 0) {
                    f.this.arT();
                }
            }
        });
        this.Lb = (ImageView) this.cLa.findViewById(R.id.widget_navi_more_button);
        this.cKV = (ImageView) this.cLa.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.cKQ.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLb = new MorePopupWindow(this.cKQ.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cKQ.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azI() {
                f.this.arT();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azJ() {
            }
        });
        this.cLc = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLc.setOnClickListener(this.cKQ);
        if (com.baidu.tbadk.coreExtra.share.f.dU(this.cKQ.getPageContext().getPageActivity())) {
            this.cLc.setVisibility(0);
        } else {
            this.cLc.setVisibility(8);
        }
        this.cLb.refresh();
        this.cLe = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLe.setOnClickListener(this.cKQ);
        this.cLd = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLd.setOnClickListener(this.cKQ);
    }

    public void azA() {
        if (this.mNavigationBar != null && this.Lb != null && this.cKV != null) {
            this.Lb.setVisibility(8);
            this.cKV.setVisibility(0);
            this.cKV.setOnClickListener(this.cKQ);
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
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.cKU != null) {
            this.cKU.setVisibility(8);
        }
    }

    public boolean azD() {
        try {
            this.cKW.addView(this.cKQ.createWebView());
            this.cKX.setVisibility(8);
            if (!this.cLf) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cKX.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cKW.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cKW.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cLc != null) {
            if (z) {
                this.cLc.setVisibility(0);
            } else {
                this.cLc.setVisibility(8);
            }
            this.cLb.refresh();
        }
    }

    public void fq(boolean z) {
        if (this.cLa != null) {
            if (z) {
                this.cLa.setVisibility(0);
            } else {
                this.cLa.setVisibility(8);
            }
        }
    }

    public boolean azE() {
        return this.cLg;
    }

    public void fr(boolean z) {
        this.cLg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azF() {
        if (this.cLh == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.cKQ);
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.cKQ.getString(R.string.report_text), aVar);
            c0629a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.cLh != null && f.this.cKQ != null) {
                        f.this.cLh.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.cKQ).createNormalCfg(f.this.cKQ.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.cKQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0629a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.cLh != null) {
                        f.this.cLh.dismiss();
                    }
                }
            });
            aVar.az(arrayList);
            this.cLh = new com.baidu.tieba.person.e(this.cKQ, aVar.aER());
            this.cLh.ae(0.7f);
        }
        this.cLh.show();
    }

    public void arT() {
        this.cLb.showWindowInRightBottomOfHost();
    }

    public void arU() {
        g.dismissPopupWindow(this.cLb, this.cKQ.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.cKY.setVisibility(0);
        this.cKY.playAnimation();
    }

    public void hideProgressBar() {
        this.cKY.setVisibility(8);
        this.cKY.cancelAnimation();
    }

    public void showCrashTip() {
        this.cKX.setVisibility(0);
    }

    public void hideCrashTip() {
        this.cKX.setVisibility(8);
    }

    public void so(String str) {
        if (this.mNavigationBar != null) {
            this.cKR = this.mNavigationBar.setCenterTextTitle(str);
            if (this.cKT != null && this.cKT.getVisibility() == 0 && this.cKU != null && this.cKU.getVisibility() == 0) {
                this.cKR.setMaxWidth(l.getDimens(this.cKQ.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.cKR, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.cKQ.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cy(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dpY) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.cKQ, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bwm().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.cKQ, shareItem, true, azG())));
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
            this.mNavigationBar.onChangeSkinType(this.cKQ.getPageContext(), i);
        }
        if (this.cLb != null) {
            this.cLb.onChangeSkinType(this.cKQ, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cKQ.getPageContext(), i);
        }
        SvgManager.aGC().a(this.cKT, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.cKU, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.cKV, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cKW.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cKQ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cA(null, this.cKQ.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cKQ.getResources().getString(R.string.refresh), this.cKZ)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.cKQ.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.cKQ.getPageContext());
        }
        this.cKW.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKZ = onClickListener;
    }

    public void release() {
        if (this.cKW != null) {
            this.cKW.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLb != null) {
            g.dismissPopupWindow(this.cLb, this.cKQ.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cKW.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.cKT, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKU, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cKV, R.drawable.frs_star_navigation_bg);
        so("");
        this.cKQ.getWindow().setFlags(1024, 1024);
    }

    public void azH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cKW.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cKW.setLayoutParams(layoutParams);
        if (this.cKT != null) {
            this.cKT.setBackgroundDrawable(null);
        }
        if (this.cKU != null) {
            this.cKU.setBackgroundDrawable(null);
        }
        if (this.Lb != null) {
            this.Lb.setBackgroundDrawable(null);
        }
        if (this.cKV != null) {
            this.cKV.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.cKQ != null) {
            this.cKQ.getWindow().clearFlags(1024);
        }
    }

    public void fs(boolean z) {
        this.cLf = z;
    }
}
