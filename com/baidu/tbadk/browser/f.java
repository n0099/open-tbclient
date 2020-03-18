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
    private BaseWebViewActivity cLc;
    private TextView cLd;
    private View cLe;
    private ImageView cLf;
    private ImageView cLg;
    private ImageView cLh;
    private LinearLayout cLi;
    private TextView cLj;
    private View.OnClickListener cLl;
    private View cLm;
    private MorePopupWindow cLn;
    protected View cLo;
    private View cLp;
    private View cLq;
    private com.baidu.tieba.person.e cLt;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView cLk = null;
    private boolean cLr = true;
    private boolean cLs = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.cLc = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cLc.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.cLc.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cLc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        sn("");
        if (this.cLc.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.cLc.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.cLc);
            this.mNavigationBar.setVisibility(8);
        }
        this.cLi = (LinearLayout) this.cLc.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cLi.setLayoutParams(layoutParams);
        this.cLj = (TextView) this.cLc.findViewById(R.id.webview_crash_tip);
        this.cLk = (ContinuousAnimationView) this.cLc.findViewById(R.id.webview_progress);
        this.cLk.setAnimation(R.raw.lottie_full_screen_refresh);
        this.cLe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cLc != null) {
                    if ((!(f.this.cLc instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.cLc).isDisableGoBack || !((TbWebViewActivity) f.this.cLc).needDealClickGoBack()) && !f.this.cLc.webViewGoBack()) {
                        f.this.cLc.finish();
                    }
                }
            }
        });
        this.cLf = (ImageView) this.cLe.findViewById(R.id.widget_navi_back_button);
        this.cLf.setContentDescription(this.cLc.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cLc != null) {
                    f.this.cLc.finish();
                }
            }
        });
        this.cLg = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cLg.setContentDescription(this.cLc.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cLg.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.cLc.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cLg.setLayoutParams(layoutParams2);
        this.cLm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.azH()) {
                    f.this.azI();
                } else if (f.this.cLh.getVisibility() != 0) {
                    f.this.arW();
                }
            }
        });
        this.Lb = (ImageView) this.cLm.findViewById(R.id.widget_navi_more_button);
        this.cLh = (ImageView) this.cLm.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.cLc.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cLn = new MorePopupWindow(this.cLc.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cLc.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azL() {
                f.this.arW();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void azM() {
            }
        });
        this.cLo = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cLo.setOnClickListener(this.cLc);
        if (com.baidu.tbadk.coreExtra.share.f.dT(this.cLc.getPageContext().getPageActivity())) {
            this.cLo.setVisibility(0);
        } else {
            this.cLo.setVisibility(8);
        }
        this.cLn.refresh();
        this.cLq = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cLq.setOnClickListener(this.cLc);
        this.cLp = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cLp.setOnClickListener(this.cLc);
    }

    public void azD() {
        if (this.mNavigationBar != null && this.Lb != null && this.cLh != null) {
            this.Lb.setVisibility(8);
            this.cLh.setVisibility(0);
            this.cLh.setOnClickListener(this.cLc);
        }
    }

    public void jo(int i) {
        if (this.mNavigationBar != null && this.Lb != null) {
            this.Lb.setVisibility(i);
        }
    }

    public boolean azE() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void azF() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.cLg != null) {
            this.cLg.setVisibility(8);
        }
    }

    public boolean azG() {
        try {
            this.cLi.addView(this.cLc.createWebView());
            this.cLj.setVisibility(8);
            if (!this.cLr) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cLj.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cLi.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cLi.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void fq(boolean z) {
        if (this.cLo != null) {
            if (z) {
                this.cLo.setVisibility(0);
            } else {
                this.cLo.setVisibility(8);
            }
            this.cLn.refresh();
        }
    }

    public void fr(boolean z) {
        if (this.cLm != null) {
            if (z) {
                this.cLm.setVisibility(0);
            } else {
                this.cLm.setVisibility(8);
            }
        }
    }

    public boolean azH() {
        return this.cLs;
    }

    public void fs(boolean z) {
        this.cLs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azI() {
        if (this.cLt == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.cLc);
            ArrayList arrayList = new ArrayList();
            a.C0630a c0630a = new a.C0630a(this.cLc.getString(R.string.report_text), aVar);
            c0630a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.cLt != null && f.this.cLc != null) {
                        f.this.cLt.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.cLc).createNormalCfg(f.this.cLc.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.cLc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0630a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.cLt != null) {
                        f.this.cLt.dismiss();
                    }
                }
            });
            aVar.az(arrayList);
            this.cLt = new com.baidu.tieba.person.e(this.cLc, aVar.aEV());
            this.cLt.ae(0.7f);
        }
        this.cLt.show();
    }

    public void arW() {
        this.cLn.showWindowInRightBottomOfHost();
    }

    public void arX() {
        g.dismissPopupWindow(this.cLn, this.cLc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.cLk.setVisibility(0);
        this.cLk.playAnimation();
    }

    public void hideProgressBar() {
        this.cLk.setVisibility(8);
        this.cLk.cancelAnimation();
    }

    public void showCrashTip() {
        this.cLj.setVisibility(0);
    }

    public void hideCrashTip() {
        this.cLj.setVisibility(8);
    }

    public void sn(String str) {
        if (this.mNavigationBar != null) {
            this.cLd = this.mNavigationBar.setCenterTextTitle(str);
            if (this.cLf != null && this.cLf.getVisibility() == 0 && this.cLg != null && this.cLg.getVisibility() == 0) {
                this.cLd.setMaxWidth(l.getDimens(this.cLc.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.cLd, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.cLc.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cx(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.X("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dqy) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.cLc, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bws().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.cLc, shareItem, true, azJ())));
        }
    }

    private SparseArray<String> azJ() {
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
            this.mNavigationBar.onChangeSkinType(this.cLc.getPageContext(), i);
        }
        if (this.cLn != null) {
            this.cLn.onChangeSkinType(this.cLc, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cLc.getPageContext(), i);
        }
        SvgManager.aGG().a(this.cLf, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.cLg, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.cLh, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cLi.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cLc.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cz(null, this.cLc.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cLc.getResources().getString(R.string.refresh), this.cLl)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.cLc.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.cLc.getPageContext());
        }
        this.cLi.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLl = onClickListener;
    }

    public void release() {
        if (this.cLi != null) {
            this.cLi.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cLn != null) {
            g.dismissPopupWindow(this.cLn, this.cLc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cLi.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.cLf, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cLg, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.Lb, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cLh, R.drawable.frs_star_navigation_bg);
        sn("");
        this.cLc.getWindow().setFlags(1024, 1024);
    }

    public void azK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cLi.setLayoutParams(layoutParams);
        if (this.cLf != null) {
            this.cLf.setBackgroundDrawable(null);
        }
        if (this.cLg != null) {
            this.cLg.setBackgroundDrawable(null);
        }
        if (this.Lb != null) {
            this.Lb.setBackgroundDrawable(null);
        }
        if (this.cLh != null) {
            this.cLh.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.cLc != null) {
            this.cLc.getWindow().clearFlags(1024);
        }
    }

    public void ft(boolean z) {
        this.cLr = z;
    }
}
