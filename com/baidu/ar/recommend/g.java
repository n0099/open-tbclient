package com.baidu.ar.recommend;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Debug;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.Utils;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class g extends FrameLayout {
    private b a;
    private List<ARResource> b;
    private ViewGroup c;
    private SlidingDrawer d;
    private View e;
    private View f;
    private GridView g;
    private e h;
    private RotateImageView i;
    private ObjectAnimator j;
    private Context k;
    private Timer l;
    private TimerTask m;
    private RotateViewGroup n;
    private TextView o;
    private SlidingDrawer.OnDrawerOpenListener p;
    private SlidingDrawer.OnDrawerCloseListener q;

    /* loaded from: classes3.dex */
    private class a implements AbsListView.OnScrollListener {
        private boolean b;

        private a() {
        }

        private void a() {
            if (this.b) {
                g.this.f.setBackgroundColor(0);
            } else {
                g.this.f.setBackgroundColor(436207615);
            }
        }

        private boolean a(int i) {
            View childAt;
            return i == 0 && (childAt = g.this.g.getChildAt(i)) != null && childAt.getY() == 0.0f;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean a = a(i);
            if (this.b != a) {
                this.b = a;
                a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean a;
            int firstVisiblePosition = g.this.g.getFirstVisiblePosition();
            if (firstVisiblePosition == -1 || this.b == (a = a(firstVisiblePosition))) {
                return;
            }
            this.b = a;
            a();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(g gVar, View view, int i);
    }

    public g(Context context) {
        super(context);
        View inflate = Res.inflate("bdar_layout_relative");
        if (inflate == null) {
            return;
        }
        this.c = (ViewGroup) inflate.findViewById(Res.id("bdar_ar_btn_relative_layout"));
        this.c.setVisibility(4);
        this.f = inflate.findViewById(Res.id("bdar_ar_btn_relative_close_line"));
        this.g = (GridView) inflate.findViewById(Res.id("bdar_ar_relative_list"));
        this.g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.ar.recommend.g.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (g.this.a != null) {
                    g.this.a.a(g.this, view, i);
                }
            }
        });
        this.g.setOnScrollListener(new a());
        this.e = inflate.findViewById(Res.id("bdar_ar_btn_relative_close"));
        this.d = (SlidingDrawer) inflate.findViewById(Res.id("bdar_ar_sliding_drawer"));
        this.d.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() { // from class: com.baidu.ar.recommend.g.2
            @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
            public void onDrawerOpened() {
                g.this.d();
                if (g.this.p != null) {
                    g.this.p.onDrawerOpened();
                }
            }
        });
        this.d.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() { // from class: com.baidu.ar.recommend.g.3
            @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
            public void onDrawerClosed() {
                if (g.this.q != null) {
                    g.this.q.onDrawerClosed();
                }
            }
        });
        this.i = (RotateImageView) inflate.findViewById(Res.id("bdar_ar_btn_relative"));
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.recommend.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.d.animateOpen();
                g.this.e();
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.RECOMMEND_ENTRANCE_CLICK, ARConfig.getARKey());
            }
        });
        addView(inflate);
    }

    private ARResource b(String str) {
        for (ARResource aRResource : this.b) {
            if (aRResource.getKey().equals(str)) {
                return aRResource;
            }
        }
        return null;
    }

    private void b(Orientation orientation, boolean z) {
        if (this.g != null && this.d.isOpened()) {
            int childCount = this.g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RotateViewUtils.requestOrientation((com.baidu.ar.recommend.b) this.g.getChildAt(i), orientation, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a(OrientationManager.getGlobalOrientation(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
            if (this.i != null) {
                this.i.setTranslationY(0.0f);
            }
        }
    }

    private ObjectAnimator f() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, "translationY", 0.0f, -Utils.dipToPx(this.k, 8.0f), 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(3);
        ofFloat.setDuration(1000L);
        return ofFloat;
    }

    private void g() {
        if (this.n == null || !this.n.isShown()) {
            return;
        }
        if (this.o != null) {
            this.o.setBackground(Res.getDrawable("bdar_drawable_bg_pop_left_bottom"));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.bottomMargin = Utils.dipToPx(this.k, 102.0f);
        layoutParams.leftMargin = Utils.dipToPx(this.k, 18.0f);
        this.n.setLayoutParams(layoutParams);
        this.n.requestLayout();
    }

    private void h() {
        if (this.n == null || !this.n.isShown()) {
            return;
        }
        if (this.o != null) {
            this.o.setBackground(Res.getDrawable("bdar_drawable_bg_pop_left_top"));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.leftMargin = Utils.dipToPx(this.k, 62.0f);
        layoutParams.bottomMargin = Utils.dipToPx(this.k, 52.0f);
        this.n.setLayoutParams(layoutParams);
        this.n.requestLayout();
    }

    private void i() {
        if (this.n == null || !this.n.isShown()) {
            return;
        }
        if (this.o != null) {
            this.o.setBackground(Res.getDrawable("bdar_drawable_bg_pop_right_bottom"));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.leftMargin = Utils.dipToPx(this.k, 62.0f);
        layoutParams.bottomMargin = Utils.dipToPx(this.k, 52.0f);
        this.n.setLayoutParams(layoutParams);
        this.n.requestLayout();
    }

    private void j() {
        if (this.l != null) {
            this.l.cancel();
            this.l.purge();
            this.l = null;
        }
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
    }

    public ARResource a(int i) {
        return this.b.get(i);
    }

    public void a() {
        if (this.d.isOpened()) {
            this.d.animateClose();
        }
    }

    public void a(Orientation orientation, boolean z) {
        RotateViewUtils.requestOrientation(this.i, orientation, z);
        b(orientation, z);
        RotateViewUtils.requestOrientation(this.n, orientation, false);
        if (orientation == Orientation.PORTRAIT) {
            g();
        } else if (orientation == Orientation.LANDSCAPE) {
            h();
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            i();
        }
    }

    public void a(String str) {
        com.baidu.ar.recommend.b bVar = (com.baidu.ar.recommend.b) this.g.findViewWithTag(b(str));
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(String str, int i) {
        com.baidu.ar.recommend.b bVar = (com.baidu.ar.recommend.b) this.g.findViewWithTag(b(str));
        if (bVar != null) {
            bVar.setProgress(i);
        } else {
            Debug.print("updateDownloadProgress not found view:" + str);
        }
    }

    public void a(String str, boolean z, String str2) {
        ARResource b2 = b(str);
        if (b2 == null) {
            return;
        }
        Debug.print("updateDownloadFinish arKey:" + str + "success:" + z);
        b2.setCaseConfigJsonInfo(str2);
        com.baidu.ar.recommend.b bVar = (com.baidu.ar.recommend.b) this.g.findViewWithTag(b2);
        if (bVar != null) {
            if (z) {
                b2.createAnimator();
            }
            bVar.a(b2, z);
        }
    }

    public void b() {
        this.j = f();
        this.j.start();
    }

    public void c() {
        this.n = (RotateViewGroup) findViewById(Res.id("bdar_gui_recommend_guide_frame"));
        this.o = (TextView) findViewById(Res.id("bdar_gui_recommend_guide"));
        if (this.n != null) {
            this.n.setVisibility(0);
            d();
        }
        j();
        this.l = new Timer();
        if (this.m == null) {
            this.m = new TimerTask() { // from class: com.baidu.ar.recommend.g.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.recommend.g.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.n != null) {
                                g.this.n.setVisibility(8);
                            }
                        }
                    });
                }
            };
        }
        this.l.schedule(this.m, 3000L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        j();
    }

    public void setApplicationContext(Context context) {
        this.k = context;
    }

    public void setLoadingCase(ARResource aRResource) {
        this.h.b(aRResource);
    }

    public void setOnDrawerCloseListener(SlidingDrawer.OnDrawerCloseListener onDrawerCloseListener) {
        this.q = onDrawerCloseListener;
    }

    public void setOnDrawerOpenListener(SlidingDrawer.OnDrawerOpenListener onDrawerOpenListener) {
        this.p = onDrawerOpenListener;
    }

    public void setOnItemClickListener(b bVar) {
        this.a = bVar;
    }

    public void setRelativeList(List<ARResource> list) {
        this.b = list;
        this.h = new e(getContext(), list);
        this.g.setAdapter((ListAdapter) this.h);
    }

    public void setSelectedCase(ARResource aRResource) {
        this.h.a(aRResource);
        d.a().a(aRResource.getThumbnailUrl(), this.i);
    }
}
