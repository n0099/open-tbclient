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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    protected ImageView agS;
    private BaseWebViewActivity evf;
    private TextView evg;
    private View evh;
    private ImageView evi;
    private View evj;
    private ImageView evk;
    private ImageView evl;
    private LinearLayout evm;
    private TextView evn;
    private View.OnClickListener evp;
    private View evq;
    private MorePopupWindow evr;
    protected View evs;
    private View evt;
    private View evu;
    private com.baidu.tieba.person.e evx;
    private View evz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView evo = null;
    private boolean evv = true;
    private boolean evw = false;
    public boolean evy = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.evf = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.evf.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.evf.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.evf.findViewById(R.id.view_navigation_bar);
        this.evz = this.evf.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        Ax("");
        if (this.evf.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.evf.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.evf);
            this.mNavigationBar.setVisibility(8);
        }
        this.evm = (LinearLayout) this.evf.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.evm.setLayoutParams(layoutParams);
        this.evn = (TextView) this.evf.findViewById(R.id.webview_crash_tip);
        this.evo = (ContinuousAnimationView) this.evf.findViewById(R.id.webview_progress);
        ap.a(this.evo, R.raw.lottie_full_screen_refresh);
        this.evh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.evf != null) {
                    if ((!(f.this.evf instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.evf).isDisableGoBack || !((TbWebViewActivity) f.this.evf).needDealClickGoBack()) && !f.this.evf.webViewGoBack()) {
                        f.this.evf.finish();
                    }
                }
            }
        });
        this.evi = (ImageView) this.evh.findViewById(R.id.widget_navi_back_button);
        this.evi.setContentDescription(this.evf.getResources().getString(R.string.back));
        this.evj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.evf != null) {
                    f.this.evf.finish();
                }
            }
        });
        this.evk = (ImageView) this.evj.findViewById(R.id.widget_navi_back_button);
        this.evk.setContentDescription(this.evf.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.evk.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.evf.getPageContext().getPageActivity(), R.dimen.ds4);
        this.evk.setLayoutParams(layoutParams2);
        this.evq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bjr()) {
                    f.this.bjs();
                } else if (f.this.evl.getVisibility() != 0) {
                    f.this.aZB();
                }
            }
        });
        this.agS = (ImageView) this.evq.findViewById(R.id.widget_navi_more_button);
        this.evl = (ImageView) this.evq.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.evf.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.evr = new MorePopupWindow(this.evf.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.evf.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bjx() {
                f.this.aZB();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bjy() {
            }
        });
        this.evs = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.evs.setOnClickListener(this.evf);
        if (g.eh(this.evf.getPageContext().getPageActivity())) {
            this.evs.setVisibility(0);
        } else {
            this.evs.setVisibility(8);
        }
        this.evr.refresh();
        this.evu = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.evu.setOnClickListener(this.evf);
        this.evt = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.evt.setOnClickListener(this.evf);
    }

    public void bjn() {
        if (this.mNavigationBar != null && this.agS != null && this.evl != null) {
            this.agS.setVisibility(8);
            this.evl.setVisibility(0);
            this.evl.setOnClickListener(this.evf);
        }
    }

    public void nK(int i) {
        if (this.mNavigationBar != null && this.agS != null) {
            this.agS.setVisibility(i);
        }
    }

    public boolean bjo() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bjp() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.evk != null) {
            this.evk.setVisibility(8);
        }
    }

    public boolean bjq() {
        try {
            this.evm.addView(this.evf.createWebView());
            this.evn.setVisibility(8);
            if (!this.evv) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.evn.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.evm.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.evm.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void it(boolean z) {
        if (this.evs != null) {
            if (z) {
                this.evs.setVisibility(0);
            } else {
                this.evs.setVisibility(8);
            }
            this.evr.refresh();
        }
    }

    public void iu(boolean z) {
        if (this.evq != null) {
            if (z) {
                this.evq.setVisibility(0);
            } else {
                this.evq.setVisibility(8);
            }
        }
    }

    public boolean bjr() {
        return this.evw;
    }

    public void iv(boolean z) {
        this.evw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjs() {
        if (this.evx == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.evf);
            ArrayList arrayList = new ArrayList();
            a.C0870a c0870a = new a.C0870a(this.evf.getString(R.string.report_text), aVar);
            c0870a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.evx != null && f.this.evf != null) {
                        f.this.evx.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.evf).createNormalCfg(f.this.evf.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.evf.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0870a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.evx != null) {
                        f.this.evx.dismiss();
                    }
                }
            });
            aVar.br(arrayList);
            this.evx = new com.baidu.tieba.person.e(this.evf, aVar.bps());
            this.evx.aa(0.7f);
        }
        this.evx.show();
    }

    public void aZB() {
        this.evr.showWindowInRightBottomOfHost();
    }

    public void aZC() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.evr, this.evf.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.evo.setVisibility(0);
            this.evo.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.evo.setVisibility(8);
        this.evo.cancelAnimation();
    }

    public void showCrashTip() {
        this.evn.setVisibility(0);
    }

    public void hideCrashTip() {
        this.evn.setVisibility(8);
    }

    public void Ax(String str) {
        if (this.mNavigationBar != null) {
            this.evg = this.mNavigationBar.setCenterTextTitle(str);
            if (this.evi != null && this.evi.getVisibility() == 0 && this.evk != null && this.evk.getVisibility() == 0) {
                this.evg.setMaxWidth(l.getDimens(this.evf.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.evy) {
                ap.setNavbarTitleColor(this.evg, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.evg.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.evf.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.al("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.fgQ) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.evf, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.cpv().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.evf, shareItem, true, bjt())));
        }
    }

    private SparseArray<String> bjt() {
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
        if (this.evo != null) {
            ap.a(this.evo, R.raw.lottie_full_screen_refresh);
        }
        if (this.evr != null) {
            this.evr.onChangeSkinType(this.evf, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.evf.getPageContext(), i);
        }
        if (!this.evy) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.evf.getPageContext(), i);
            }
            SvgManager.brn().a(this.evi, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.evk, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.evl, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.evz.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.evm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.evf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dS(null, this.evf.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.evf.getResources().getString(R.string.refresh), this.evp)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.evf.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.evf.getPageContext());
        }
        this.evm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.evp = onClickListener;
    }

    public void release() {
        if (this.evm != null) {
            this.evm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.evr != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.evr, this.evf.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.evm.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.evi, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.evk, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agS, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.evl, R.drawable.frs_star_navigation_bg);
        Ax("");
        this.evf.getWindow().setFlags(1024, 1024);
    }

    public void bju() {
        if (this.evm != null) {
            this.evm.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agS != null && this.evl != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agS.setVisibility(8);
            this.evl.setVisibility(0);
            this.evl.setOnClickListener(this.evf);
            this.evg.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evl.getLayoutParams();
            layoutParams.width = l.getDimens(this.evf, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.evf, R.dimen.tbds100);
            SvgManager.brn().a(this.evk, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.evi, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.evl, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bjv() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.evm.setLayoutParams(layoutParams);
        if (this.evi != null) {
            this.evi.setBackgroundDrawable(null);
        }
        if (this.evk != null) {
            this.evk.setBackgroundDrawable(null);
        }
        if (this.agS != null) {
            this.agS.setBackgroundDrawable(null);
        }
        if (this.evl != null) {
            this.evl.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.evf != null) {
            this.evf.getWindow().clearFlags(1024);
        }
    }

    public void iw(boolean z) {
        this.evv = z;
    }

    public void bjw() {
        this.evy = true;
        bju();
    }
}
