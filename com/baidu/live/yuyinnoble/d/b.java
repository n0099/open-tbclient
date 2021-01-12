package com.baidu.live.yuyinnoble.d;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.noble.data.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.AlaLoadingView;
/* loaded from: classes10.dex */
public class b {
    private boolean bZF;
    private com.baidu.live.yuyinnoble.d.a bZP;
    private AlaLoadingView bZQ;
    private com.baidu.live.yuyinnoble.a.a bZR;
    private a bZS;
    private LinearLayout bZT;
    private String bre;
    private LinearLayout bta;
    private CommonEmptyView btf;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void Nq();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.bZF = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
        this.mIsHost = z;
        this.bZF = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bZT = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.mListView.addFooterView(this.bZT);
        this.bZT.setVisibility(0);
        this.bZQ = (AlaLoadingView) this.mRootView.findViewById(a.f.noble_loading_view);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bZR = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.bre, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bZR);
        NB();
    }

    private void NB() {
        this.bta = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bZP = new com.baidu.live.yuyinnoble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bZP != null && this.bZP.getRootView() != null && this.bZP.getRootView().getParent() == null) {
            this.bta.addView(this.bZP.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(final d dVar) {
        if (dVar == null) {
            cB(true);
            return;
        }
        if (ListUtils.isEmpty(dVar.list)) {
            dI(true);
        } else {
            this.bZR.setList(dVar.list);
            this.mListView.setVisibility(0);
            NC();
            this.mListView.post(new Runnable() { // from class: com.baidu.live.yuyinnoble.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.mListView.getHeight() < b.this.mListView.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds144) * dVar.list.size()) {
                            b.this.fp(0);
                        } else {
                            b.this.fp(4);
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
        if (this.mIsHost) {
            this.bta.setVisibility(8);
        } else if (this.bZF) {
            this.bta.setVisibility(0);
            this.bZP.b(dVar);
        } else {
            this.bta.setVisibility(8);
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bta.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bta.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dI(boolean z) {
        if (z) {
            fp(8);
            this.btf.reset();
            this.btf.setTitle("还没有贵族哦~");
            this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btf.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.btf.setVisibility(0);
        } else {
            this.btf.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cB(boolean z) {
        fp(8);
        if (this.btf != null) {
            this.btf.reset();
            if (z) {
                this.btf.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.d.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bZS != null) {
                            b.this.bZS.Nq();
                        }
                    }
                });
                this.btf.setTitle("网络加载失败了哦~");
                this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.btf.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            }
            this.btf.setVisibility(0);
        }
        if (z) {
            this.bta.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void NC() {
        if (this.btf != null) {
            this.btf.setVisibility(8);
        }
    }

    public void dJ(boolean z) {
        if (this.bZQ != null) {
            if (z) {
                this.bZQ.setVisibility(0);
            } else {
                this.bZQ.setVisibility(8);
            }
        }
    }

    public void a(a aVar) {
        this.bZS = aVar;
    }

    public void fp(int i) {
        if (this.bZT != null) {
            this.bZT.setVisibility(i);
        }
    }
}
