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
    protected ImageView aeb;
    protected View dkA;
    private View dkB;
    private View dkC;
    private com.baidu.tieba.person.e dkF;
    private BaseWebViewActivity dkn;
    private TextView dko;
    private View dkp;
    private ImageView dkq;
    private View dkr;
    private ImageView dks;
    private ImageView dkt;
    private LinearLayout dku;
    private TextView dkv;
    private View.OnClickListener dkx;
    private View dky;
    private MorePopupWindow dkz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dkw = null;
    private boolean dkD = true;
    private boolean dkE = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dkn = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dkn.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dkn.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dkn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        tF("");
        if (this.dkn.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.dkn.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dkn);
            this.mNavigationBar.setVisibility(8);
        }
        this.dku = (LinearLayout) this.dkn.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dku.setLayoutParams(layoutParams);
        this.dkv = (TextView) this.dkn.findViewById(R.id.webview_crash_tip);
        this.dkw = (ContinuousAnimationView) this.dkn.findViewById(R.id.webview_progress);
        am.a(this.dkw, R.raw.lottie_full_screen_refresh);
        this.dkp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dkn != null) {
                    if ((!(f.this.dkn instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dkn).isDisableGoBack || !((TbWebViewActivity) f.this.dkn).needDealClickGoBack()) && !f.this.dkn.webViewGoBack()) {
                        f.this.dkn.finish();
                    }
                }
            }
        });
        this.dkq = (ImageView) this.dkp.findViewById(R.id.widget_navi_back_button);
        this.dkq.setContentDescription(this.dkn.getResources().getString(R.string.back));
        this.dkr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dkn != null) {
                    f.this.dkn.finish();
                }
            }
        });
        this.dks = (ImageView) this.dkr.findViewById(R.id.widget_navi_back_button);
        this.dks.setContentDescription(this.dkn.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dks.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dkn.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dks.setLayoutParams(layoutParams2);
        this.dky = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aHS()) {
                    f.this.aHT();
                } else if (f.this.dkt.getVisibility() != 0) {
                    f.this.aAh();
                }
            }
        });
        this.aeb = (ImageView) this.dky.findViewById(R.id.widget_navi_more_button);
        this.dkt = (ImageView) this.dky.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dkn.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dkz = new MorePopupWindow(this.dkn.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dkn.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHW() {
                f.this.aAh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHX() {
            }
        });
        this.dkA = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dkA.setOnClickListener(this.dkn);
        if (com.baidu.tbadk.coreExtra.share.f.dv(this.dkn.getPageContext().getPageActivity())) {
            this.dkA.setVisibility(0);
        } else {
            this.dkA.setVisibility(8);
        }
        this.dkz.refresh();
        this.dkC = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dkC.setOnClickListener(this.dkn);
        this.dkB = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dkB.setOnClickListener(this.dkn);
    }

    public void aHO() {
        if (this.mNavigationBar != null && this.aeb != null && this.dkt != null) {
            this.aeb.setVisibility(8);
            this.dkt.setVisibility(0);
            this.dkt.setOnClickListener(this.dkn);
        }
    }

    public void jv(int i) {
        if (this.mNavigationBar != null && this.aeb != null) {
            this.aeb.setVisibility(i);
        }
    }

    public boolean aHP() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void aHQ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dks != null) {
            this.dks.setVisibility(8);
        }
    }

    public boolean aHR() {
        try {
            this.dku.addView(this.dkn.createWebView());
            this.dkv.setVisibility(8);
            if (!this.dkD) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dkv.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dku.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dku.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void gn(boolean z) {
        if (this.dkA != null) {
            if (z) {
                this.dkA.setVisibility(0);
            } else {
                this.dkA.setVisibility(8);
            }
            this.dkz.refresh();
        }
    }

    public void go(boolean z) {
        if (this.dky != null) {
            if (z) {
                this.dky.setVisibility(0);
            } else {
                this.dky.setVisibility(8);
            }
        }
    }

    public boolean aHS() {
        return this.dkE;
    }

    public void gp(boolean z) {
        this.dkE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHT() {
        if (this.dkF == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dkn);
            ArrayList arrayList = new ArrayList();
            a.C0692a c0692a = new a.C0692a(this.dkn.getString(R.string.report_text), aVar);
            c0692a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dkF != null && f.this.dkn != null) {
                        f.this.dkF.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dkn).createNormalCfg(f.this.dkn.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dkn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0692a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dkF != null) {
                        f.this.dkF.dismiss();
                    }
                }
            });
            aVar.aI(arrayList);
            this.dkF = new com.baidu.tieba.person.e(this.dkn, aVar.aNh());
            this.dkF.O(0.7f);
        }
        this.dkF.show();
    }

    public void aAh() {
        this.dkz.showWindowInRightBottomOfHost();
    }

    public void aAi() {
        g.dismissPopupWindow(this.dkz, this.dkn.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.dkw.setVisibility(0);
        this.dkw.playAnimation();
    }

    public void hideProgressBar() {
        this.dkw.setVisibility(8);
        this.dkw.cancelAnimation();
    }

    public void showCrashTip() {
        this.dkv.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dkv.setVisibility(8);
    }

    public void tF(String str) {
        if (this.mNavigationBar != null) {
            this.dko = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dkq != null && this.dkq.getVisibility() == 0 && this.dks != null && this.dks.getVisibility() == 0) {
                this.dko.setMaxWidth(l.getDimens(this.dkn.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.dko, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dkn.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cI(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.af("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dQw) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dkn, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bGc().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dkn, shareItem, true, aHU())));
        }
    }

    private SparseArray<String> aHU() {
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
        if (this.dkw != null) {
            am.a(this.dkw, R.raw.lottie_full_screen_refresh);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dkn.getPageContext(), i);
        }
        if (this.dkz != null) {
            this.dkz.onChangeSkinType(this.dkn, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dkn.getPageContext(), i);
        }
        SvgManager.aOR().a(this.dkq, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.dks, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.aeb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.dkt, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dku.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dkn.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cK(null, this.dkn.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dkn.getResources().getString(R.string.refresh), this.dkx)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dkn.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dkn.getPageContext());
        }
        this.dku.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkx = onClickListener;
    }

    public void release() {
        if (this.dku != null) {
            this.dku.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dkz != null) {
            g.dismissPopupWindow(this.dkz, this.dkn.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dku.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.dkq, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dks, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.aeb, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dkt, R.drawable.frs_star_navigation_bg);
        tF("");
        this.dkn.getWindow().setFlags(1024, 1024);
    }

    public void aHV() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dku.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dku.setLayoutParams(layoutParams);
        if (this.dkq != null) {
            this.dkq.setBackgroundDrawable(null);
        }
        if (this.dks != null) {
            this.dks.setBackgroundDrawable(null);
        }
        if (this.aeb != null) {
            this.aeb.setBackgroundDrawable(null);
        }
        if (this.dkt != null) {
            this.dkt.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dkn != null) {
            this.dkn.getWindow().clearFlags(1024);
        }
    }

    public void gq(boolean z) {
        this.dkD = z;
    }
}
