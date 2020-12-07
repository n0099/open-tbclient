package com.baidu.live.noble.d;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private String brl;
    private com.baidu.live.noble.data.b bsz;
    private LinearLayout btb;
    private com.baidu.live.noble.d.a btc;
    private RelativeLayout btd;
    private TextView bte;
    private ImageView btf;
    private CommonEmptyView btg;
    private com.baidu.live.noble.a.a bth;
    private a bti;
    private boolean btj;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Qi();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.btj = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.btd = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bte = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bte.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.btf = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.btf.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bth = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.brl, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bth);
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQP != null && (!boVar.aQP.aTn || !boVar.aQP.aTo)) {
            this.btj = false;
        }
        Qs();
        if (this.btj) {
            this.btf.setVisibility(0);
        } else {
            this.btf.setVisibility(8);
        }
    }

    private void Qs() {
        this.btb = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.btc = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.btc != null && this.btc.getRootView() != null && this.btc.getRootView().getParent() == null) {
            this.btb.addView(this.btc.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.btb.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.btb.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cC(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cC(false);
        } else {
            this.bth.setList(bVar.list);
            this.mListView.setVisibility(0);
            Qt();
        }
        this.bsz = bVar;
        this.btd.setVisibility(0);
        this.bte.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bsF)));
        if (this.mIsHost) {
            this.btb.setVisibility(8);
        } else if (this.btj) {
            this.btb.setVisibility(0);
            this.btc.b(bVar);
        } else {
            this.btb.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btf && !UtilHelper.isFastDoubleClick() && this.bsz != null && !StringUtils.isNull(this.bsz.bsG)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bsz.bsG});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.btb.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.btb.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cC(boolean z) {
        if (this.btg != null) {
            this.btg.reset();
            if (z) {
                this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bti != null) {
                            b.this.bti.Qi();
                        }
                    }
                });
                this.btg.setTitle(a.h.sdk_net_no);
                this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.btg.setTitle(a.h.noble_list_empty_title);
                this.btg.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.btg.setVisibility(0);
        }
        if (z) {
            this.btd.setVisibility(8);
            this.btb.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Qt() {
        if (this.btg != null) {
            this.btg.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bti = aVar;
    }
}
