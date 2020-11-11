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
import com.baidu.live.data.bn;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private String bnP;
    private LinearLayout bpE;
    private com.baidu.live.noble.d.a bpF;
    private RelativeLayout bpG;
    private TextView bpH;
    private ImageView bpI;
    private CommonEmptyView bpJ;
    private com.baidu.live.noble.a.a bpK;
    private a bpL;
    private boolean bpM;
    private com.baidu.live.noble.data.b bpc;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Oy();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bpM = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bnP = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.bpG = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bpH = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bpH.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bpI = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bpI.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bpK = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bnP, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bpK);
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPA != null && (!bnVar.aPA.aRW || !bnVar.aPA.aRX)) {
            this.bpM = false;
        }
        OI();
        if (this.bpM) {
            this.bpI.setVisibility(0);
        } else {
            this.bpI.setVisibility(8);
        }
    }

    private void OI() {
        this.bpE = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bpF = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bpF != null && this.bpF.getRootView() != null && this.bpF.getRootView().getParent() == null) {
            this.bpE.addView(this.bpF.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bpE.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bpE.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cm(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cm(false);
        } else {
            this.bpK.setList(bVar.list);
            this.mListView.setVisibility(0);
            OJ();
        }
        this.bpc = bVar;
        this.bpG.setVisibility(0);
        this.bpH.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bpi)));
        if (this.mIsHost) {
            this.bpE.setVisibility(8);
        } else if (this.bpM) {
            this.bpE.setVisibility(0);
            this.bpF.b(bVar);
        } else {
            this.bpE.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bpI && !UtilHelper.isFastDoubleClick() && this.bpc != null && !StringUtils.isNull(this.bpc.bpj)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bpc.bpj});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bpE.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bpE.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cm(boolean z) {
        if (this.bpJ != null) {
            this.bpJ.reset();
            if (z) {
                this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bpL != null) {
                            b.this.bpL.Oy();
                        }
                    }
                });
                this.bpJ.setTitle(a.h.sdk_net_no);
                this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bpJ.setTitle(a.h.noble_list_empty_title);
                this.bpJ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bpJ.setVisibility(0);
        }
        if (z) {
            this.bpG.setVisibility(8);
            this.bpE.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void OJ() {
        if (this.bpJ != null) {
            this.bpJ.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bpL = aVar;
    }
}
