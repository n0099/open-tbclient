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
    private String buH;
    private LinearLayout bwE;
    private CommonEmptyView bwJ;
    private boolean cdL;
    private com.baidu.live.yuyinnoble.d.a cdV;
    private AlaLoadingView cdW;
    private com.baidu.live.yuyinnoble.a.a cdX;
    private a cdY;
    private LinearLayout cdZ;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void OP();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.cdL = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
        this.mIsHost = z;
        this.cdL = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.cdZ = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.mListView.addFooterView(this.cdZ);
        this.cdZ.setVisibility(0);
        this.cdW = (AlaLoadingView) this.mRootView.findViewById(a.f.noble_loading_view);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.cdX = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.buH, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.cdX);
        Pa();
    }

    private void Pa() {
        this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.cdV = new com.baidu.live.yuyinnoble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.cdV != null && this.cdV.getRootView() != null && this.cdV.getRootView().getParent() == null) {
            this.bwE.addView(this.cdV.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(final d dVar) {
        if (dVar == null) {
            cK(true);
            return;
        }
        if (ListUtils.isEmpty(dVar.list)) {
            dQ(true);
        } else {
            this.cdX.setList(dVar.list);
            this.mListView.setVisibility(0);
            Pb();
            this.mListView.post(new Runnable() { // from class: com.baidu.live.yuyinnoble.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.mListView.getHeight() < b.this.mListView.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds144) * dVar.list.size()) {
                            b.this.fv(0);
                        } else {
                            b.this.fv(4);
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
        if (this.mIsHost) {
            this.bwE.setVisibility(8);
        } else if (this.cdL) {
            this.bwE.setVisibility(0);
            this.cdV.b(dVar);
        } else {
            this.bwE.setVisibility(8);
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bwE.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bwE.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dQ(boolean z) {
        if (z) {
            fv(8);
            this.bwJ.reset();
            this.bwJ.setTitle("还没有贵族哦~");
            this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bwJ.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.bwJ.setVisibility(0);
        } else {
            this.bwJ.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cK(boolean z) {
        fv(8);
        if (this.bwJ != null) {
            this.bwJ.reset();
            if (z) {
                this.bwJ.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.d.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.cdY != null) {
                            b.this.cdY.OP();
                        }
                    }
                });
                this.bwJ.setTitle("网络加载失败了哦~");
                this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.bwJ.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            }
            this.bwJ.setVisibility(0);
        }
        if (z) {
            this.bwE.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Pb() {
        if (this.bwJ != null) {
            this.bwJ.setVisibility(8);
        }
    }

    public void dR(boolean z) {
        if (this.cdW != null) {
            if (z) {
                this.cdW.setVisibility(0);
            } else {
                this.cdW.setVisibility(8);
            }
        }
    }

    public void a(a aVar) {
        this.cdY = aVar;
    }

    public void fv(int i) {
        if (this.cdZ != null) {
            this.cdZ.setVisibility(i);
        }
    }
}
