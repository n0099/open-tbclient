package com.baidu.live.sdk.goods.c;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.c.b;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends f {
    private float bjQ;
    private RoundRectRelativeLayout bmk;
    private TextView bml;
    private a bmm;
    private boolean isHost;
    private Activity mActivity;
    private ViewGroup mContentLayout;
    private ListView mListView;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void NE();

        void e(com.baidu.live.sdk.goods.a.a aVar);

        void u(String str, boolean z);

        void v(String str, boolean z);
    }

    public d(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (z) {
            this.bml.setVisibility(0);
        }
    }

    public void a(a aVar) {
        this.bmm = aVar;
    }

    public void setData(List<com.baidu.live.sdk.goods.a.a> list) {
        this.mTitleTextView.setText("全部商品 " + (list != null ? list.size() : 0));
        if (list == null || list.isEmpty()) {
            NH();
            return;
        }
        if (!(this.mListView.getAdapter() instanceof b)) {
            b bVar = new b();
            this.mListView.setAdapter((ListAdapter) bVar);
            bVar.a(new b.a() { // from class: com.baidu.live.sdk.goods.c.d.1
                @Override // com.baidu.live.sdk.goods.c.b.a
                public void u(String str, boolean z) {
                    if (d.this.bmm != null) {
                        d.this.bmm.u(str, z);
                    }
                }

                @Override // com.baidu.live.sdk.goods.c.b.a
                public void v(String str, boolean z) {
                    if (d.this.bmm != null) {
                        d.this.bmm.v(str, z);
                    }
                }
            });
        }
        ((b) this.mListView.getAdapter()).e(this.isHost, list);
        if (!this.isHost) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).blv) {
                    this.mListView.setSelection(i);
                    return;
                }
            }
        }
    }

    public void eR(int i) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            ShowUtil.windowCount++;
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bmk.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
            setAnimationStyle(a.j.sdk_goods_list_right_left);
            MO();
        } else {
            this.bmk.setCornerRadius(this.bjQ, this.bjQ, 0.0f, 0.0f);
            setAnimationStyle(a.j.sdk_goods_list_up_to_top);
        }
        int[] eN = eN(i);
        if (z) {
            update(eN[0], eN[1]);
            return;
        }
        setWidth(eN[0]);
        setHeight(eN[1]);
    }

    public void eM(int i) {
        if (i == 2) {
            MO();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.live.sdk.goods.c.d.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                d.this.NI();
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void initView() {
        this.bjQ = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        setContentView(LayoutInflater.from(this.mActivity).inflate(a.h.live_goods_display_list_popup, (ViewGroup) null));
        this.bmk = (RoundRectRelativeLayout) getContentView().findViewById(a.g.rrrl_goods_display_list);
        this.mTitleTextView = (TextView) getContentView().findViewById(a.g.tv_goods_display_list_title);
        this.bml = (TextView) getContentView().findViewById(a.g.tv_goods_display_list_config);
        this.mContentLayout = (ViewGroup) getContentView().findViewById(a.g.layout_goods_display_list_content);
        this.mListView = (ListView) getContentView().findViewById(a.g.lv_good_display_list);
        this.bml.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.c.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bmm != null) {
                    d.this.bmm.NE();
                }
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.sdk.goods.c.d.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.onItemClick(i);
            }
        });
        this.mListView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.sdk.goods.c.d.5
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof b.C0188b) {
                    ((b.C0188b) tag).recycle();
                }
            }
        });
    }

    private int[] eN(int i) {
        int[] iArr = new int[2];
        if (i == 2) {
            iArr[0] = (int) (ScreenHelper.getRealScreenWidth(this.mActivity) * 0.5f);
            iArr[1] = ScreenHelper.getRealScreenHeight(this.mActivity);
        } else {
            iArr[0] = ScreenHelper.getRealScreenWidth(this.mActivity);
            iArr[1] = (int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.65f);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int i) {
        if (this.bmm != null && this.mListView != null && this.mListView.getAdapter() != null) {
            Object item = this.mListView.getAdapter().getItem(i);
            if (item instanceof com.baidu.live.sdk.goods.a.a) {
                this.bmm.e((com.baidu.live.sdk.goods.a.a) item);
            }
        }
    }

    private void NH() {
        if (this.mActivity != null && this.mContentLayout != null && this.mListView != null) {
            View emptyView = this.mListView.getEmptyView();
            if (!(emptyView instanceof CommonEmptyView)) {
                emptyView = new CommonEmptyView(this.mActivity);
            }
            CommonEmptyView commonEmptyView = (CommonEmptyView) emptyView;
            if (this.mContentLayout.indexOfChild(commonEmptyView) < 0) {
                if (this.mContentLayout instanceof RelativeLayout) {
                    commonEmptyView.addToParent((RelativeLayout) this.mContentLayout);
                } else if (this.mContentLayout instanceof FrameLayout) {
                    commonEmptyView.addToParent((FrameLayout) this.mContentLayout);
                }
            }
            commonEmptyView.reset();
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
            commonEmptyView.setTitle("暂未配置商品");
            this.mListView.setEmptyView(commonEmptyView);
        }
    }

    private void MO() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI() {
        if (this.mListView != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListView.getChildCount()) {
                    View childAt = this.mListView.getChildAt(i2);
                    if (childAt != null) {
                        Object tag = childAt.getTag();
                        if (tag instanceof b.C0188b) {
                            ((b.C0188b) tag).recycle();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
