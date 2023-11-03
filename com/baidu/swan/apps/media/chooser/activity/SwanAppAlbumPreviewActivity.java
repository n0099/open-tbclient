package com.baidu.swan.apps.media.chooser.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailTouchCallback;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.DragView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ak3;
import com.baidu.tieba.eu2;
import com.baidu.tieba.fj3;
import com.baidu.tieba.r43;
import com.baidu.tieba.rm1;
import com.baidu.tieba.tt2;
import com.baidu.tieba.wt2;
import com.baidu.tieba.xt2;
import com.baidu.tieba.y53;
import com.baidu.tieba.zt2;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, zt2, eu2 {
    public static final boolean J = rm1.a;
    public SwanAppThumbnailAdapter A;
    public int C;
    public String F;
    public ArrayList<MediaModel> H;
    public View m;
    public ViewPager n;
    public DragView o;
    public RecyclerView p;
    public View q;
    public ImageView r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public View w;
    public View x;
    public r43 y;
    public SwanAppAlbumPreviewAdapter z;
    public boolean B = true;
    public boolean D = true;
    public boolean E = false;
    public int G = 200;
    public ViewPager.OnPageChangeListener I = new c();

    @Override // com.baidu.swan.apps.view.DragView.b
    public void e(MotionEvent motionEvent) {
    }

    /* loaded from: classes4.dex */
    public class a extends LinearLayoutManager {

        /* renamed from: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0202a extends LinearSmoothScroller {
            public C0202a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return (SwanAppAlbumPreviewActivity.this.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i) {
                return super.computeScrollVectorForPosition(i);
            }
        }

        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            C0202a c0202a = new C0202a(recyclerView.getContext());
            c0202a.setTargetPosition(i);
            startSmoothScroll(c0202a);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SwanAppThumbnailClickListener {
        public final /* synthetic */ tt2 c;
        public final /* synthetic */ ItemTouchHelper d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecyclerView recyclerView, tt2 tt2Var, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            this.c = tt2Var;
            this.d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            if (SwanAppAlbumPreviewActivity.this.H == null) {
                return;
            }
            MediaModel l = SwanAppAlbumPreviewActivity.this.A.l(viewHolder.getAdapterPosition());
            int size = SwanAppAlbumPreviewActivity.this.H.size();
            for (int i = 0; i < size; i++) {
                if (SwanAppAlbumPreviewActivity.this.H.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.H.get(i)).equals(l)) {
                    this.c.a(true);
                    SwanAppAlbumPreviewActivity.this.n.setCurrentItem(i);
                    this.c.a(false);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void c(RecyclerView.ViewHolder viewHolder) {
            ArrayList<MediaModel> m = SwanAppAlbumPreviewActivity.this.A.m();
            if (viewHolder.getLayoutPosition() >= 0 && m != null && viewHolder.getLayoutPosition() != m.size()) {
                this.d.startDrag(viewHolder);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.z.r();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.C = i;
            SwanAppAlbumPreviewActivity.this.Y();
            SwanAppAlbumPreviewActivity.this.U();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a > 0) {
                SwanAppAlbumPreviewActivity.this.p.smoothScrollToPosition(this.a - 1);
            } else {
                SwanAppAlbumPreviewActivity.this.p.smoothScrollToPosition(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanAppAlbumPreviewActivity.this.E = false;
            SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = SwanAppAlbumPreviewActivity.this;
            swanAppAlbumPreviewActivity.D = !swanAppAlbumPreviewActivity.D;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanAppAlbumPreviewActivity.this.E = false;
            SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = SwanAppAlbumPreviewActivity.this;
            swanAppAlbumPreviewActivity.D = !swanAppAlbumPreviewActivity.D;
        }
    }

    public final void N() {
        if (TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.u.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    public final void O() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    @TargetApi(19)
    public final void X() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    @Override // com.baidu.tieba.zt2
    public void f() {
        if (!this.E && this.D) {
            c();
        } else if (!this.E) {
            d();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClose() {
        finish();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010175, R.anim.obfuscated_res_0x7f01001d);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.z;
        if (swanAppAlbumPreviewAdapter != null) {
            swanAppAlbumPreviewAdapter.l();
            this.z = null;
        }
        this.A = null;
        this.y = null;
        if (this.H != null) {
            this.H = null;
        }
    }

    public final tt2 P(ViewPager viewPager) {
        tt2 tt2Var = new tt2(viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, tt2Var);
        } catch (Exception e2) {
            if (J) {
                e2.printStackTrace();
            }
        }
        return tt2Var;
    }

    public final String Q(MediaModel mediaModel) {
        return String.valueOf(xt2.c(mediaModel) + 1);
    }

    public final void V(int i) {
        float f2;
        if (i == 0) {
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        View view2 = this.w;
        if (view2 != null) {
            view2.setAlpha(1.0f - f2);
        }
        View view3 = this.x;
        if (view3 != null) {
            view3.setAlpha(1.0f - f2);
        }
    }

    public void W(Drawable drawable) {
        View view2 = this.m;
        if (view2 != null) {
            view2.setBackground(drawable);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            O();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.eu2
    public void onMove(int i, int i2) {
        ArrayList<MediaModel> arrayList = this.H;
        if (arrayList != null && this.C < arrayList.size()) {
            this.v.setText(Q(this.H.get(this.C)));
        }
    }

    public final void R() {
        ArrayList<MediaModel> e2;
        this.p = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0925af);
        this.q = findViewById(R.id.obfuscated_res_0x7f090285);
        a aVar = new a(this);
        aVar.setOrientation(0);
        this.p.setLayoutManager(aVar);
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
        this.A = swanAppThumbnailAdapter;
        this.p.setAdapter(swanAppThumbnailAdapter);
        if (xt2.e() == null) {
            e2 = null;
        } else {
            e2 = xt2.e();
        }
        this.A.q(e2);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.A));
        itemTouchHelper.attachToRecyclerView(this.p);
        tt2 P = P(this.n);
        RecyclerView recyclerView = this.p;
        recyclerView.addOnItemTouchListener(new b(recyclerView, P, itemTouchHelper));
        Z();
        Y();
    }

    public final void U() {
        ArrayList<MediaModel> arrayList = this.H;
        if (arrayList == null) {
            return;
        }
        MediaModel mediaModel = null;
        if (this.C < arrayList.size()) {
            mediaModel = this.H.get(this.C);
        }
        if (mediaModel == null) {
            return;
        }
        if (xt2.g(mediaModel)) {
            this.v.setVisibility(0);
            this.v.setText(Q(this.H.get(this.C)));
            this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f081487);
            return;
        }
        this.v.setVisibility(8);
        if (wt2.f(wt2.d, mediaModel)) {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f081489);
        } else {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f081488);
        }
    }

    public final void S() {
        String string;
        this.m = findViewById(R.id.obfuscated_res_0x7f090280);
        DragView dragView = (DragView) findViewById(R.id.obfuscated_res_0x7f09098f);
        this.o = dragView;
        dragView.setOnCloseListener(this);
        this.o.setBackgroundColor(-16777216);
        this.n = (ViewPager) findViewById(R.id.obfuscated_res_0x7f090289);
        this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f090287);
        this.t = findViewById(R.id.obfuscated_res_0x7f09027e);
        this.s = findViewById(R.id.obfuscated_res_0x7f090288);
        this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f090281);
        this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f090286);
        this.w = findViewById(R.id.obfuscated_res_0x7f09027f);
        this.x = findViewById(R.id.obfuscated_res_0x7f090282);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.n.setOnPageChangeListener(this.I);
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.H);
        this.z = swanAppAlbumPreviewAdapter;
        this.n.setAdapter(swanAppAlbumPreviewAdapter);
        this.z.y(this);
        this.n.setCurrentItem(this.C);
        this.s.setOnClickListener(this);
        this.u.setBackgroundResource(R.drawable.obfuscated_res_0x7f081486);
        this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b02));
        if (xt2.d() != 0) {
            string = getString(R.string.obfuscated_res_0x7f0f155c) + "(" + xt2.d() + SmallTailInfo.EMOTION_SUFFIX;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f155c);
        }
        this.u.setText(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(int i) {
        int i2;
        int abs = Math.abs(i);
        int i3 = 0;
        if (abs >= 0) {
            float f2 = abs;
            if (f2 < 300.0f) {
                i2 = (int) (255.0f - ((f2 / 300.0f) * 20.0f));
                Drawable mutate = this.m.getBackground().mutate();
                if (i2 >= 0) {
                    i3 = i2;
                }
                mutate.setAlpha(i3);
            }
        }
        float f3 = abs;
        if (f3 >= 300.0f) {
            float f4 = 235;
            i2 = (int) (f4 - (((f3 - 300.0f) / 900.0f) * f4));
        } else {
            i2 = 0;
        }
        Drawable mutate2 = this.m.getBackground().mutate();
        if (i2 >= 0) {
        }
        mutate2.setAlpha(i3);
    }

    public final void Y() {
        int p;
        if (this.A != null && this.C < this.H.size() && (p = this.A.p(this.H.get(this.C))) >= 0) {
            int i = p + 1;
            if (i < this.A.getItemCount()) {
                this.p.smoothScrollToPosition(i);
            } else {
                this.p.smoothScrollToPosition(p);
            }
            this.p.postDelayed(new d(p), 300L);
        }
    }

    public final void Z() {
        ArrayList<MediaModel> e2 = xt2.e();
        ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070859);
        if (e2 != null && e2.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070843)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070864);
    }

    @Override // com.baidu.tieba.zt2
    public void c() {
        if (!this.D) {
            return;
        }
        this.E = true;
        float y = this.x.getY();
        float y2 = this.w.getY();
        View view2 = this.x;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "y", y, y - view2.getHeight());
        ofFloat.setDuration(this.G);
        ofFloat.addListener(new e());
        ofFloat.start();
        View view3 = this.w;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "y", y2, y2 + view3.getHeight());
        ofFloat2.setDuration(this.G);
        ofFloat2.start();
    }

    @Override // com.baidu.tieba.zt2
    public void d() {
        if (this.D) {
            return;
        }
        this.E = true;
        float y = this.x.getY();
        float y2 = this.w.getY();
        View view2 = this.x;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "y", y, y + view2.getHeight());
        ofFloat.setDuration(this.G);
        ofFloat.addListener(new f());
        ofFloat.start();
        View view3 = this.w;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "y", y2, y2 - view3.getHeight());
        ofFloat2.setDuration(this.G);
        ofFloat2.start();
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void a(int i) {
        V(i);
        T(i);
        if (i != 0 && this.B) {
            W(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.o.setBackground(new ColorDrawable(0));
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.z;
            if (swanAppAlbumPreviewAdapter != null) {
                swanAppAlbumPreviewAdapter.x(this.C, 0);
            }
            this.B = false;
        }
        if (i == 0) {
            W(new ColorDrawable(0));
            this.o.setBackgroundColor(-16777216);
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.z;
            if (swanAppAlbumPreviewAdapter2 != null) {
                swanAppAlbumPreviewAdapter2.x(this.C, -16777216);
            }
            this.B = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ArrayList<MediaModel> arrayList;
        String string;
        if (view2 == this.t) {
            O();
            finish();
            return;
        }
        ArrayList<MediaModel> arrayList2 = this.H;
        if (arrayList2 != null && this.C < arrayList2.size()) {
            MediaModel mediaModel = this.H.get(this.C);
            if (view2 == this.s) {
                if (xt2.f(mediaModel)) {
                    this.A.notifyItemRemoved(xt2.c(mediaModel));
                    xt2.h(mediaModel);
                    if (xt2.d() == 0) {
                        this.A.q(null);
                    }
                    this.v.setVisibility(8);
                    this.r.setImageResource(R.drawable.obfuscated_res_0x7f081488);
                    if (xt2.d() > 0) {
                        string = getString(R.string.obfuscated_res_0x7f0f155c) + "(" + xt2.d() + SmallTailInfo.EMOTION_SUFFIX;
                    } else {
                        string = getString(R.string.obfuscated_res_0x7f0f155c);
                    }
                    this.u.setText(string);
                    Z();
                    return;
                }
                int d2 = xt2.d();
                if (d2 == wt2.c) {
                    wt2.j(wt2.d);
                } else if (d2 > 0 && TextUtils.equals(wt2.d, "single") && !TextUtils.equals(xt2.b(), mediaModel.getType())) {
                    y53.f(this, R.string.obfuscated_res_0x7f0f154b).G();
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    y53.f(this, R.string.obfuscated_res_0x7f0f154a).G();
                } else {
                    int d3 = xt2.d();
                    this.A.notifyItemInserted(d3);
                    xt2.i(mediaModel);
                    if (this.A.m() == null) {
                        this.A.q(xt2.e());
                    }
                    this.p.smoothScrollToPosition(d3);
                    this.v.setVisibility(0);
                    this.v.setText(Q(mediaModel));
                    this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f081487);
                    this.u.setText(getString(R.string.obfuscated_res_0x7f0f155c) + "(" + xt2.d() + SmallTailInfo.EMOTION_SUFFIX);
                    this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b02));
                    Z();
                }
            } else if (view2 == this.u) {
                if (xt2.d() == 0 && (arrayList = this.H) != null && arrayList.size() > 0 && this.C < this.H.size()) {
                    xt2.i(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", wt2.e);
                bundle.putString("swanAppId", wt2.f);
                bundle.putParcelableArrayList("mediaModels", xt2.e());
                bundle.putString("swanTmpPath", wt2.j);
                wt2.g(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vj4, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList<MediaModel> parcelableArrayList;
        int c0 = ak3.c0(this);
        super.onCreate(bundle);
        ak3.g(this, c0);
        X();
        r43 r43Var = new r43(this);
        this.y = r43Var;
        r43Var.b(false);
        getWindow().setFlags(1024, 1024);
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(getApplicationContext());
        }
        setContentView(R.layout.obfuscated_res_0x7f0d0948);
        if (getIntent() != null) {
            Bundle e2 = fj3.e(getIntent(), "launchParams");
            this.C = fj3.f(e2, "previewPosition", 0);
            String g = fj3.g(e2, "previewFrom");
            this.F = g;
            if (TextUtils.equals(g, "bottomPreview")) {
                ArrayList<MediaModel> arrayList = new ArrayList<>();
                this.H = arrayList;
                arrayList.addAll(xt2.e());
            } else if (TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                if (e2 == null) {
                    parcelableArrayList = null;
                } else {
                    parcelableArrayList = e2.getParcelableArrayList("mediaModels");
                }
                this.H = parcelableArrayList;
            } else {
                this.H = wt2.c();
            }
            if (this.H == null) {
                this.H = new ArrayList<>();
            }
        }
        S();
        U();
        R();
        N();
    }
}
