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
    protected ImageView adY;
    private com.baidu.tieba.person.e dkB;
    private BaseWebViewActivity dkj;
    private TextView dkk;
    private View dkl;
    private ImageView dkm;
    private View dkn;
    private ImageView dko;
    private ImageView dkp;
    private LinearLayout dkq;
    private TextView dkr;
    private View.OnClickListener dkt;
    private View dku;
    private MorePopupWindow dkv;
    protected View dkw;
    private View dkx;
    private View dky;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dks = null;
    private boolean dkz = true;
    private boolean dkA = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dkj = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dkj.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dkj.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dkj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        tC("");
        if (this.dkj.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.dkj.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dkj);
            this.mNavigationBar.setVisibility(8);
        }
        this.dkq = (LinearLayout) this.dkj.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkq.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dkq.setLayoutParams(layoutParams);
        this.dkr = (TextView) this.dkj.findViewById(R.id.webview_crash_tip);
        this.dks = (ContinuousAnimationView) this.dkj.findViewById(R.id.webview_progress);
        am.a(this.dks, R.raw.lottie_full_screen_refresh);
        this.dkl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dkj != null) {
                    if ((!(f.this.dkj instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dkj).isDisableGoBack || !((TbWebViewActivity) f.this.dkj).needDealClickGoBack()) && !f.this.dkj.webViewGoBack()) {
                        f.this.dkj.finish();
                    }
                }
            }
        });
        this.dkm = (ImageView) this.dkl.findViewById(R.id.widget_navi_back_button);
        this.dkm.setContentDescription(this.dkj.getResources().getString(R.string.back));
        this.dkn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dkj != null) {
                    f.this.dkj.finish();
                }
            }
        });
        this.dko = (ImageView) this.dkn.findViewById(R.id.widget_navi_back_button);
        this.dko.setContentDescription(this.dkj.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dko.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dkj.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dko.setLayoutParams(layoutParams2);
        this.dku = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aHU()) {
                    f.this.aHV();
                } else if (f.this.dkp.getVisibility() != 0) {
                    f.this.aAh();
                }
            }
        });
        this.adY = (ImageView) this.dku.findViewById(R.id.widget_navi_more_button);
        this.dkp = (ImageView) this.dku.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dkj.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dkv = new MorePopupWindow(this.dkj.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dkj.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHY() {
                f.this.aAh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aHZ() {
            }
        });
        this.dkw = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dkw.setOnClickListener(this.dkj);
        if (com.baidu.tbadk.coreExtra.share.f.dH(this.dkj.getPageContext().getPageActivity())) {
            this.dkw.setVisibility(0);
        } else {
            this.dkw.setVisibility(8);
        }
        this.dkv.refresh();
        this.dky = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dky.setOnClickListener(this.dkj);
        this.dkx = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dkx.setOnClickListener(this.dkj);
    }

    public void aHQ() {
        if (this.mNavigationBar != null && this.adY != null && this.dkp != null) {
            this.adY.setVisibility(8);
            this.dkp.setVisibility(0);
            this.dkp.setOnClickListener(this.dkj);
        }
    }

    public void jv(int i) {
        if (this.mNavigationBar != null && this.adY != null) {
            this.adY.setVisibility(i);
        }
    }

    public boolean aHR() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void aHS() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dko != null) {
            this.dko.setVisibility(8);
        }
    }

    public boolean aHT() {
        try {
            this.dkq.addView(this.dkj.createWebView());
            this.dkr.setVisibility(8);
            if (!this.dkz) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dkr.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dkq.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dkq.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void gn(boolean z) {
        if (this.dkw != null) {
            if (z) {
                this.dkw.setVisibility(0);
            } else {
                this.dkw.setVisibility(8);
            }
            this.dkv.refresh();
        }
    }

    public void go(boolean z) {
        if (this.dku != null) {
            if (z) {
                this.dku.setVisibility(0);
            } else {
                this.dku.setVisibility(8);
            }
        }
    }

    public boolean aHU() {
        return this.dkA;
    }

    public void gp(boolean z) {
        this.dkA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHV() {
        if (this.dkB == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dkj);
            ArrayList arrayList = new ArrayList();
            a.C0671a c0671a = new a.C0671a(this.dkj.getString(R.string.report_text), aVar);
            c0671a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dkB != null && f.this.dkj != null) {
                        f.this.dkB.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dkj).createNormalCfg(f.this.dkj.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dkj.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0671a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dkB != null) {
                        f.this.dkB.dismiss();
                    }
                }
            });
            aVar.aI(arrayList);
            this.dkB = new com.baidu.tieba.person.e(this.dkj, aVar.aNj());
            this.dkB.O(0.7f);
        }
        this.dkB.show();
    }

    public void aAh() {
        this.dkv.showWindowInRightBottomOfHost();
    }

    public void aAi() {
        g.dismissPopupWindow(this.dkv, this.dkj.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.dks.setVisibility(0);
        this.dks.playAnimation();
    }

    public void hideProgressBar() {
        this.dks.setVisibility(8);
        this.dks.cancelAnimation();
    }

    public void showCrashTip() {
        this.dkr.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dkr.setVisibility(8);
    }

    public void tC(String str) {
        if (this.mNavigationBar != null) {
            this.dkk = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dkm != null && this.dkm.getVisibility() == 0 && this.dko != null && this.dko.getVisibility() == 0) {
                this.dkk.setMaxWidth(l.getDimens(this.dkj.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.dkk, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dkj.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cI(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.af("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dQr) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dkj, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bGe().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dkj, shareItem, true, aHW())));
        }
    }

    private SparseArray<String> aHW() {
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
        if (this.dks != null) {
            am.a(this.dks, R.raw.lottie_full_screen_refresh);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dkj.getPageContext(), i);
        }
        if (this.dkv != null) {
            this.dkv.onChangeSkinType(this.dkj, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dkj.getPageContext(), i);
        }
        SvgManager.aOU().a(this.dkm, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.dko, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.adY, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.dkp, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dkq.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dkj.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cK(null, this.dkj.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dkj.getResources().getString(R.string.refresh), this.dkt)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dkj.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dkj.getPageContext());
        }
        this.dkq.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkt = onClickListener;
    }

    public void release() {
        if (this.dkq != null) {
            this.dkq.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dkv != null) {
            g.dismissPopupWindow(this.dkv, this.dkj.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkq.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dkq.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.dkm, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dko, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.adY, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dkp, R.drawable.frs_star_navigation_bg);
        tC("");
        this.dkj.getWindow().setFlags(1024, 1024);
    }

    public void aHX() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkq.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dkq.setLayoutParams(layoutParams);
        if (this.dkm != null) {
            this.dkm.setBackgroundDrawable(null);
        }
        if (this.dko != null) {
            this.dko.setBackgroundDrawable(null);
        }
        if (this.adY != null) {
            this.adY.setBackgroundDrawable(null);
        }
        if (this.dkp != null) {
            this.dkp.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dkj != null) {
            this.dkj.getWindow().clearFlags(1024);
        }
    }

    public void gq(boolean z) {
        this.dkz = z;
    }
}
