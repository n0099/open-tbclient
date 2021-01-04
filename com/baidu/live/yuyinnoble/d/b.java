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
/* loaded from: classes11.dex */
public class b {
    private String bvS;
    private LinearLayout bxO;
    private CommonEmptyView bxT;
    private com.baidu.live.yuyinnoble.d.a ceF;
    private AlaLoadingView ceG;
    private com.baidu.live.yuyinnoble.a.a ceH;
    private a ceI;
    private LinearLayout ceJ;
    private boolean cev;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void Rl();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.cev = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.mIsHost = z;
        this.cev = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.ceJ = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.mListView.addFooterView(this.ceJ);
        this.ceJ.setVisibility(0);
        this.ceG = (AlaLoadingView) this.mRootView.findViewById(a.f.noble_loading_view);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.ceH = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.bvS, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.ceH);
        Rw();
    }

    private void Rw() {
        this.bxO = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.ceF = new com.baidu.live.yuyinnoble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.ceF != null && this.ceF.getRootView() != null && this.ceF.getRootView().getParent() == null) {
            this.bxO.addView(this.ceF.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(final d dVar) {
        if (dVar == null) {
            cF(true);
            return;
        }
        if (ListUtils.isEmpty(dVar.list)) {
            dM(true);
        } else {
            this.ceH.setList(dVar.list);
            this.mListView.setVisibility(0);
            Rx();
            this.mListView.post(new Runnable() { // from class: com.baidu.live.yuyinnoble.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.mListView.getHeight() < b.this.mListView.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds144) * dVar.list.size()) {
                            b.this.gW(0);
                        } else {
                            b.this.gW(4);
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
        if (this.mIsHost) {
            this.bxO.setVisibility(8);
        } else if (this.cev) {
            this.bxO.setVisibility(0);
            this.ceF.b(dVar);
        } else {
            this.bxO.setVisibility(8);
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bxO.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bxO.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dM(boolean z) {
        if (z) {
            gW(8);
            this.bxT.reset();
            this.bxT.setTitle("还没有贵族哦~");
            this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bxT.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.bxT.setVisibility(0);
        } else {
            this.bxT.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cF(boolean z) {
        gW(8);
        if (this.bxT != null) {
            this.bxT.reset();
            if (z) {
                this.bxT.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.d.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.ceI != null) {
                            b.this.ceI.Rl();
                        }
                    }
                });
                this.bxT.setTitle("网络加载失败了哦~");
                this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.bxT.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            }
            this.bxT.setVisibility(0);
        }
        if (z) {
            this.bxO.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Rx() {
        if (this.bxT != null) {
            this.bxT.setVisibility(8);
        }
    }

    public void dN(boolean z) {
        if (this.ceG != null) {
            if (z) {
                this.ceG.setVisibility(0);
            } else {
                this.ceG.setVisibility(8);
            }
        }
    }

    public void a(a aVar) {
        this.ceI = aVar;
    }

    public void gW(int i) {
        if (this.ceJ != null) {
            this.ceJ.setVisibility(i);
        }
    }
}
