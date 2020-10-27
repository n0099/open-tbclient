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
import com.baidu.live.data.bm;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private String bmv;
    private com.baidu.live.noble.data.b bnJ;
    private LinearLayout bol;
    private com.baidu.live.noble.d.a bom;
    private RelativeLayout bon;
    private TextView boo;
    private ImageView bop;
    private CommonEmptyView boq;
    private com.baidu.live.noble.a.a bor;
    private a bos;
    private boolean bot;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void NY();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bot = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bmv = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.bon = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.boo = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.boo.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.bop = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.bop.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.bor = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bmv, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bor);
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOD != null && (!bmVar.aOD.aQU || !bmVar.aOD.aQV)) {
            this.bot = false;
        }
        Oi();
        if (this.bot) {
            this.bop.setVisibility(0);
        } else {
            this.bop.setVisibility(8);
        }
    }

    private void Oi() {
        this.bol = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.bom = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bom != null && this.bom.getRootView() != null && this.bom.getRootView().getParent() == null) {
            this.bol.addView(this.bom.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bol.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bol.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cl(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cl(false);
        } else {
            this.bor.setList(bVar.list);
            this.mListView.setVisibility(0);
            Oj();
        }
        this.bnJ = bVar;
        this.bon.setVisibility(0);
        this.boo.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.bnP)));
        if (this.mIsHost) {
            this.bol.setVisibility(8);
        } else if (this.bot) {
            this.bol.setVisibility(0);
            this.bom.b(bVar);
        } else {
            this.bol.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bop && !UtilHelper.isFastDoubleClick() && this.bnJ != null && !StringUtils.isNull(this.bnJ.bnQ)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bnJ.bnQ});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bol.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bol.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cl(boolean z) {
        if (this.boq != null) {
            this.boq.reset();
            if (z) {
                this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bos != null) {
                            b.this.bos.NY();
                        }
                    }
                });
                this.boq.setTitle(a.i.sdk_net_no);
                this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.boq.setTitle(a.i.noble_list_empty_title);
                this.boq.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.boq.setVisibility(0);
        }
        if (z) {
            this.bon.setVisibility(8);
            this.bol.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Oj() {
        if (this.boq != null) {
            this.boq.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bos = aVar;
    }
}
