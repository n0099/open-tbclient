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
    private String bwh;
    private LinearLayout bye;
    private CommonEmptyView byj;
    private boolean cfl;
    private com.baidu.live.yuyinnoble.d.a cfv;
    private AlaLoadingView cfw;
    private com.baidu.live.yuyinnoble.a.a cfx;
    private a cfy;
    private LinearLayout cfz;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void OS();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.cfl = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.mIsHost = z;
        this.cfl = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.cfz = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.mListView.addFooterView(this.cfz);
        this.cfz.setVisibility(0);
        this.cfw = (AlaLoadingView) this.mRootView.findViewById(a.f.noble_loading_view);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.cfx = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.bwh, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.cfx);
        Pd();
    }

    private void Pd() {
        this.bye = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.cfv = new com.baidu.live.yuyinnoble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.cfv != null && this.cfv.getRootView() != null && this.cfv.getRootView().getParent() == null) {
            this.bye.addView(this.cfv.getRootView(), layoutParams);
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
            this.cfx.setList(dVar.list);
            this.mListView.setVisibility(0);
            Pe();
            this.mListView.post(new Runnable() { // from class: com.baidu.live.yuyinnoble.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.mListView.getHeight() < b.this.mListView.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds144) * dVar.list.size()) {
                            b.this.fw(0);
                        } else {
                            b.this.fw(4);
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
        if (this.mIsHost) {
            this.bye.setVisibility(8);
        } else if (this.cfl) {
            this.bye.setVisibility(0);
            this.cfv.b(dVar);
        } else {
            this.bye.setVisibility(8);
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bye.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bye.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dQ(boolean z) {
        if (z) {
            fw(8);
            this.byj.reset();
            this.byj.setTitle("还没有贵族哦~");
            this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.byj.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.byj.setVisibility(0);
        } else {
            this.byj.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cK(boolean z) {
        fw(8);
        if (this.byj != null) {
            this.byj.reset();
            if (z) {
                this.byj.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.d.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.cfy != null) {
                            b.this.cfy.OS();
                        }
                    }
                });
                this.byj.setTitle("网络加载失败了哦~");
                this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.byj.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            }
            this.byj.setVisibility(0);
        }
        if (z) {
            this.bye.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Pe() {
        if (this.byj != null) {
            this.byj.setVisibility(8);
        }
    }

    public void dR(boolean z) {
        if (this.cfw != null) {
            if (z) {
                this.cfw.setVisibility(0);
            } else {
                this.cfw.setVisibility(8);
            }
        }
    }

    public void a(a aVar) {
        this.cfy = aVar;
    }

    public void fw(int i) {
        if (this.cfz != null) {
            this.cfz.setVisibility(i);
        }
    }
}
