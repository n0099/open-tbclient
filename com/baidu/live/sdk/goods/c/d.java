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
/* loaded from: classes11.dex */
public class d extends e {
    private RoundRectRelativeLayout bBp;
    private TextView bBq;
    private a bBr;
    private float byT;
    private boolean isHost;
    private Activity mActivity;
    private ViewGroup mContentLayout;
    private ListView mListView;
    private TextView mTitleTextView;

    /* loaded from: classes11.dex */
    public interface a {
        void Sv();

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
            this.bBq.setVisibility(0);
        }
    }

    public void a(a aVar) {
        this.bBr = aVar;
    }

    public void setData(List<com.baidu.live.sdk.goods.a.a> list) {
        this.mTitleTextView.setText("全部商品 " + (list != null ? list.size() : 0));
        if (list == null || list.isEmpty()) {
            Sy();
            return;
        }
        if (!(this.mListView.getAdapter() instanceof b)) {
            b bVar = new b();
            this.mListView.setAdapter((ListAdapter) bVar);
            bVar.a(new b.a() { // from class: com.baidu.live.sdk.goods.c.d.1
                @Override // com.baidu.live.sdk.goods.c.b.a
                public void w(String str, boolean z) {
                    if (d.this.bBr != null) {
                        d.this.bBr.w(str, z);
                    }
                }

                @Override // com.baidu.live.sdk.goods.c.b.a
                public void x(String str, boolean z) {
                    if (d.this.bBr != null) {
                        d.this.bBr.x(str, z);
                    }
                }
            });
        }
        ((b) this.mListView.getAdapter()).d(this.isHost, list);
        if (!this.isHost) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).bAz) {
                    this.mListView.setSelection(i);
                    return;
                }
            }
        }
    }

    public void fw(int i) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            n(i, false);
            showAtLocation(findViewById, 85, 0, 0);
            ShowUtil.windowCount++;
        }
    }

    public void n(int i, boolean z) {
        if (i == 2) {
            this.bBp.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
            setAnimationStyle(a.i.sdk_goods_list_right_left);
            RF();
        } else {
            this.bBp.setCornerRadius(this.byT, this.byT, 0.0f, 0.0f);
            setAnimationStyle(a.i.sdk_goods_list_up_to_top);
        }
        int[] ft = ft(i);
        if (z) {
            update(ft[0], ft[1]);
            return;
        }
        setWidth(ft[0]);
        setHeight(ft[1]);
    }

    public void fs(int i) {
        if (i == 2) {
            RF();
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
                d.this.Sz();
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void initView() {
        this.byT = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
        setContentView(LayoutInflater.from(this.mActivity).inflate(a.g.live_goods_display_list_popup, (ViewGroup) null));
        this.bBp = (RoundRectRelativeLayout) getContentView().findViewById(a.f.rrrl_goods_display_list);
        this.mTitleTextView = (TextView) getContentView().findViewById(a.f.tv_goods_display_list_title);
        this.bBq = (TextView) getContentView().findViewById(a.f.tv_goods_display_list_config);
        this.mContentLayout = (ViewGroup) getContentView().findViewById(a.f.layout_goods_display_list_content);
        this.mListView = (ListView) getContentView().findViewById(a.f.lv_good_display_list);
        this.bBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.c.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bBr != null) {
                    d.this.bBr.Sv();
                }
            }
        });
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.sdk.goods.c.d.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d.this.fx(i);
            }
        });
        this.mListView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.sdk.goods.c.d.5
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof b.C0205b) {
                    ((b.C0205b) tag).recycle();
                }
            }
        });
    }

    private int[] ft(int i) {
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
    public void fx(int i) {
        if (this.bBr != null && this.mListView != null && this.mListView.getAdapter() != null) {
            Object item = this.mListView.getAdapter().getItem(i);
            if (item instanceof com.baidu.live.sdk.goods.a.a) {
                this.bBr.e((com.baidu.live.sdk.goods.a.a) item);
            }
        }
    }

    private void Sy() {
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

    private void RF() {
        if (getContentView() != null && Build.VERSION.SDK_INT >= 19) {
            getContentView().setSystemUiVisibility(5380);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sz() {
        if (this.mListView != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListView.getChildCount()) {
                    View childAt = this.mListView.getChildAt(i2);
                    if (childAt != null) {
                        Object tag = childAt.getTag();
                        if (tag instanceof b.C0205b) {
                            ((b.C0205b) tag).recycle();
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
