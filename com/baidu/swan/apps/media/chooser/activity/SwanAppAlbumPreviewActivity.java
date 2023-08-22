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
import com.baidu.tieba.bz2;
import com.baidu.tieba.co3;
import com.baidu.tieba.nr1;
import com.baidu.tieba.o93;
import com.baidu.tieba.qy2;
import com.baidu.tieba.ty2;
import com.baidu.tieba.uy2;
import com.baidu.tieba.va3;
import com.baidu.tieba.wy2;
import com.baidu.tieba.xo3;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, wy2, bz2 {
    public static final boolean J = nr1.a;
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
    public o93 y;
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
        public class C0210a extends LinearSmoothScroller {
            public C0210a(Context context) {
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
            C0210a c0210a = new C0210a(recyclerView.getContext());
            c0210a.setTargetPosition(i);
            startSmoothScroll(c0210a);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends SwanAppThumbnailClickListener {
        public final /* synthetic */ qy2 c;
        public final /* synthetic */ ItemTouchHelper d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecyclerView recyclerView, qy2 qy2Var, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            this.c = qy2Var;
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
            SwanAppAlbumPreviewActivity.this.z.q();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.C = i;
            SwanAppAlbumPreviewActivity.this.Y();
            SwanAppAlbumPreviewActivity.this.T();
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

    public final void M() {
        if (TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.u.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    public final void N() {
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

    @Override // com.baidu.tieba.wy2
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
        overridePendingTransition(R.anim.obfuscated_res_0x7f010172, R.anim.obfuscated_res_0x7f01001d);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.z;
        if (swanAppAlbumPreviewAdapter != null) {
            swanAppAlbumPreviewAdapter.k();
            this.z = null;
        }
        this.A = null;
        this.y = null;
        if (this.H != null) {
            this.H = null;
        }
    }

    public final qy2 O(ViewPager viewPager) {
        qy2 qy2Var = new qy2(viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, qy2Var);
        } catch (Exception e2) {
            if (J) {
                e2.printStackTrace();
            }
        }
        return qy2Var;
    }

    public final String P(MediaModel mediaModel) {
        return String.valueOf(uy2.c(mediaModel) + 1);
    }

    public final void U(int i) {
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
            N();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.bz2
    public void onMove(int i, int i2) {
        ArrayList<MediaModel> arrayList = this.H;
        if (arrayList != null && this.C < arrayList.size()) {
            this.v.setText(P(this.H.get(this.C)));
        }
    }

    public final void Q() {
        ArrayList<MediaModel> e2;
        this.p = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f092541);
        this.q = findViewById(R.id.obfuscated_res_0x7f09026d);
        a aVar = new a(this);
        aVar.setOrientation(0);
        this.p.setLayoutManager(aVar);
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
        this.A = swanAppThumbnailAdapter;
        this.p.setAdapter(swanAppThumbnailAdapter);
        if (uy2.e() == null) {
            e2 = null;
        } else {
            e2 = uy2.e();
        }
        this.A.q(e2);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.A));
        itemTouchHelper.attachToRecyclerView(this.p);
        qy2 O = O(this.n);
        RecyclerView recyclerView = this.p;
        recyclerView.addOnItemTouchListener(new b(recyclerView, O, itemTouchHelper));
        Z();
        Y();
    }

    public final void T() {
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
        if (uy2.g(mediaModel)) {
            this.v.setVisibility(0);
            this.v.setText(P(this.H.get(this.C)));
            this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f081453);
            return;
        }
        this.v.setVisibility(8);
        if (ty2.f(ty2.d, mediaModel)) {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f081455);
        } else {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f081454);
        }
    }

    public final void R() {
        String string;
        this.m = findViewById(R.id.obfuscated_res_0x7f090268);
        DragView dragView = (DragView) findViewById(R.id.obfuscated_res_0x7f090963);
        this.o = dragView;
        dragView.setOnCloseListener(this);
        this.o.setBackgroundColor(-16777216);
        this.n = (ViewPager) findViewById(R.id.obfuscated_res_0x7f090271);
        this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f09026f);
        this.t = findViewById(R.id.obfuscated_res_0x7f090266);
        this.s = findViewById(R.id.obfuscated_res_0x7f090270);
        this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f090269);
        this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09026e);
        this.w = findViewById(R.id.obfuscated_res_0x7f090267);
        this.x = findViewById(R.id.obfuscated_res_0x7f09026a);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.n.setOnPageChangeListener(this.I);
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.H);
        this.z = swanAppAlbumPreviewAdapter;
        this.n.setAdapter(swanAppAlbumPreviewAdapter);
        this.z.x(this);
        this.n.setCurrentItem(this.C);
        this.s.setOnClickListener(this);
        this.u.setBackgroundResource(R.drawable.obfuscated_res_0x7f081452);
        this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060afb));
        if (uy2.d() != 0) {
            string = getString(R.string.obfuscated_res_0x7f0f1518) + "(" + uy2.d() + SmallTailInfo.EMOTION_SUFFIX;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f1518);
        }
        this.u.setText(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(int i) {
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
        ArrayList<MediaModel> e2 = uy2.e();
        ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070858);
        if (e2 != null && e2.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070842)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070863);
    }

    @Override // com.baidu.tieba.wy2
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

    @Override // com.baidu.tieba.wy2
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
        U(i);
        S(i);
        if (i != 0 && this.B) {
            W(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.o.setBackground(new ColorDrawable(0));
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.z;
            if (swanAppAlbumPreviewAdapter != null) {
                swanAppAlbumPreviewAdapter.u(this.C, 0);
            }
            this.B = false;
        }
        if (i == 0) {
            W(new ColorDrawable(0));
            this.o.setBackgroundColor(-16777216);
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.z;
            if (swanAppAlbumPreviewAdapter2 != null) {
                swanAppAlbumPreviewAdapter2.u(this.C, -16777216);
            }
            this.B = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ArrayList<MediaModel> arrayList;
        String string;
        if (view2 == this.t) {
            N();
            finish();
            return;
        }
        ArrayList<MediaModel> arrayList2 = this.H;
        if (arrayList2 != null && this.C < arrayList2.size()) {
            MediaModel mediaModel = this.H.get(this.C);
            if (view2 == this.s) {
                if (uy2.f(mediaModel)) {
                    this.A.notifyItemRemoved(uy2.c(mediaModel));
                    uy2.h(mediaModel);
                    if (uy2.d() == 0) {
                        this.A.q(null);
                    }
                    this.v.setVisibility(8);
                    this.r.setImageResource(R.drawable.obfuscated_res_0x7f081454);
                    if (uy2.d() > 0) {
                        string = getString(R.string.obfuscated_res_0x7f0f1518) + "(" + uy2.d() + SmallTailInfo.EMOTION_SUFFIX;
                    } else {
                        string = getString(R.string.obfuscated_res_0x7f0f1518);
                    }
                    this.u.setText(string);
                    Z();
                    return;
                }
                int d2 = uy2.d();
                if (d2 == ty2.c) {
                    ty2.j(ty2.d);
                } else if (d2 > 0 && TextUtils.equals(ty2.d, "single") && !TextUtils.equals(uy2.b(), mediaModel.getType())) {
                    va3.f(this, R.string.obfuscated_res_0x7f0f1507).G();
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    va3.f(this, R.string.obfuscated_res_0x7f0f1506).G();
                } else {
                    int d3 = uy2.d();
                    this.A.notifyItemInserted(d3);
                    uy2.i(mediaModel);
                    if (this.A.m() == null) {
                        this.A.q(uy2.e());
                    }
                    this.p.smoothScrollToPosition(d3);
                    this.v.setVisibility(0);
                    this.v.setText(P(mediaModel));
                    this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f081453);
                    this.u.setText(getString(R.string.obfuscated_res_0x7f0f1518) + "(" + uy2.d() + SmallTailInfo.EMOTION_SUFFIX);
                    this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060afb));
                    Z();
                }
            } else if (view2 == this.u) {
                if (uy2.d() == 0 && (arrayList = this.H) != null && arrayList.size() > 0 && this.C < this.H.size()) {
                    uy2.i(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", ty2.e);
                bundle.putString("swanAppId", ty2.f);
                bundle.putParcelableArrayList("mediaModels", uy2.e());
                bundle.putString("swanTmpPath", ty2.j);
                ty2.g(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.to4, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList<MediaModel> parcelableArrayList;
        int c0 = xo3.c0(this);
        super.onCreate(bundle);
        xo3.g(this, c0);
        X();
        o93 o93Var = new o93(this);
        this.y = o93Var;
        o93Var.b(false);
        getWindow().setFlags(1024, 1024);
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(getApplicationContext());
        }
        setContentView(R.layout.obfuscated_res_0x7f0d092c);
        if (getIntent() != null) {
            Bundle e2 = co3.e(getIntent(), "launchParams");
            this.C = co3.f(e2, "previewPosition", 0);
            String g = co3.g(e2, "previewFrom");
            this.F = g;
            if (TextUtils.equals(g, "bottomPreview")) {
                ArrayList<MediaModel> arrayList = new ArrayList<>();
                this.H = arrayList;
                arrayList.addAll(uy2.e());
            } else if (TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                if (e2 == null) {
                    parcelableArrayList = null;
                } else {
                    parcelableArrayList = e2.getParcelableArrayList("mediaModels");
                }
                this.H = parcelableArrayList;
            } else {
                this.H = ty2.c();
            }
            if (this.H == null) {
                this.H = new ArrayList<>();
            }
        }
        R();
        T();
        Q();
        M();
    }
}
