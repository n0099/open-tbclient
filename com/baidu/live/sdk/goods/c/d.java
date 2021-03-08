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
import com.baidu.live.view.e;
import java.util.List;
/* loaded from: classes10.dex */
public class d extends e {
    private RoundRectRelativeLayout bBF;
    private TextView bBG;
    private float bBH;
    private a bBI;
    private boolean isHost;
    private Activity mActivity;
    private ViewGroup mContentLayout;
    private ListView mListView;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void Qc();

        void e(com.baidu.live.sdk.goods.a.a aVar);

        void w(String str, boolean z);

        void x(String str, boolean z);
    }

    public d(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (z) {
            this.bBG.setVisibility(0);
        }
    }

    public void a(a aVar) {
        this.bBI = aVar;
    }

    public void setData(List<com.baidu.live.sdk.goods.a.a> list) {
        this.mTitleTextView.setText("全部商品 " + (list != null ? list.size() : 0));
        if (list == null || list.isEmpty()) {
            Qf();
            return;
        }
        if (!(this.mListView.getAdapter() instanceof b)) {
            b bVar = new b();
            this.mListView.setAdapter((ListAdapter) bVar);
            bVar.a(new b.a() { // from class: com.baidu.live.sdk.goods.c.d.1
                @Override // com.baidu.live.sdk.goods.c.b.a
                public void w(String str, boolean z) {
                    if (d.this.bBI != null) {
                        d.this.bBI.w(str, z);
                    }
                }

                @Override // com.baidu.live.sdk.goods.c.b.a
                public void x(String str, boolean z) {
                    if (d.this.bBI != null) {
                        d.this.bBI.x(str, z);
                    }
                }
            });
        }
        ((b) this.mListView.getAdapter()).e(this.isHost, list);
        if (!this.isHost) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).bAP) {
                    this.mListView.setSelection(i);
                    return;
                }
            }
        }
    }

    public void dT(int i) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            ShowUtil.windowCount++;
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bBF.setCornerRadius(this.bBH, 0.0f, 0.0f, this.bBH);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            Qg();
        } else {
            this.bBF.setCornerRadius(this.bBH, this.bBH, 0.0f, 0.0f);
            setAnimationStyle(a.i.sdk_goods_list_up_to_top);
        }
        int[] dV = dV(i);
        if (z) {
            update(dV[0], dV[1]);
            return;
        }
        setWidth(dV[0]);
        setHeight(dV[1]);
    }

    public void dU(int i) {
        if (i == 2) {
            Qg();
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
                d.this.Qh();
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void initView() {
        this.bBH = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
        setContentView(LayoutInflater.from(this.mActivity).inflate(a.g.live_goods_display_list_popup, (ViewGroup) null));
        this.bBF = (RoundRectRelativeLayout) getContentView().findViewById(a.f.rrrl_goods_display_list);
        this.mTitleTextView = (TextView) getContentView().findViewById(a.f.tv_goods_display_list_title);
        this.bBG = (TextView) getContentView().findViewById(a.f.tv_goods_display_list_config);
        this.mContentLayout = (ViewGroup) getContentView().findViewById(a.f.layout_goods_display_list_content);
        this.mListView = (ListView) getContentView().findViewById(a.f.lv_good_display_list);
        this.bBG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.c.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bBI != null) {
                    d.this.bBI.Qc();
                }
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.sdk.goods.c.d.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.dW(i);
            }
        });
        this.mListView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.sdk.goods.c.d.5
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof b.C0203b) {
                    ((b.C0203b) tag).recycle();
                }
            }
        });
    }

    private int[] dV(int i) {
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
    public void dW(int i) {
        if (this.bBI != null && this.mListView != null && this.mListView.getAdapter() != null) {
            Object item = this.mListView.getAdapter().getItem(i);
            if (item instanceof com.baidu.live.sdk.goods.a.a) {
                this.bBI.e((com.baidu.live.sdk.goods.a.a) item);
            }
        }
    }

    private void Qf() {
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

    private void Qg() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        if (this.mListView != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListView.getChildCount()) {
                    View childAt = this.mListView.getChildAt(i2);
                    if (childAt != null) {
                        Object tag = childAt.getTag();
                        if (tag instanceof b.C0203b) {
                            ((b.C0203b) tag).recycle();
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
