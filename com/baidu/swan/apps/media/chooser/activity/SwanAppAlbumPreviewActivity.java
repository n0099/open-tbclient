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
import com.baidu.tieba.is1;
import com.baidu.tieba.ja3;
import com.baidu.tieba.lz2;
import com.baidu.tieba.oz2;
import com.baidu.tieba.pz2;
import com.baidu.tieba.qb3;
import com.baidu.tieba.rz2;
import com.baidu.tieba.sp3;
import com.baidu.tieba.wz2;
import com.baidu.tieba.xo3;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, rz2, wz2 {
    public static final boolean J = is1.a;
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
    public ja3 y;
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
        public final /* synthetic */ lz2 c;
        public final /* synthetic */ ItemTouchHelper d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecyclerView recyclerView, lz2 lz2Var, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            this.c = lz2Var;
            this.d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            if (SwanAppAlbumPreviewActivity.this.H == null) {
                return;
            }
            MediaModel k = SwanAppAlbumPreviewActivity.this.A.k(viewHolder.getAdapterPosition());
            int size = SwanAppAlbumPreviewActivity.this.H.size();
            for (int i = 0; i < size; i++) {
                if (SwanAppAlbumPreviewActivity.this.H.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.H.get(i)).equals(k)) {
                    this.c.a(true);
                    SwanAppAlbumPreviewActivity.this.n.setCurrentItem(i);
                    this.c.a(false);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void c(RecyclerView.ViewHolder viewHolder) {
            ArrayList<MediaModel> l = SwanAppAlbumPreviewActivity.this.A.l();
            if (viewHolder.getLayoutPosition() >= 0 && l != null && viewHolder.getLayoutPosition() != l.size()) {
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

    @Override // com.baidu.tieba.rz2
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
        overridePendingTransition(R.anim.obfuscated_res_0x7f01016d, R.anim.obfuscated_res_0x7f01001d);
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

    public final lz2 P(ViewPager viewPager) {
        lz2 lz2Var = new lz2(viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, lz2Var);
        } catch (Exception e2) {
            if (J) {
                e2.printStackTrace();
            }
        }
        return lz2Var;
    }

    public final String Q(MediaModel mediaModel) {
        return String.valueOf(pz2.c(mediaModel) + 1);
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

    @Override // com.baidu.tieba.wz2
    public void onMove(int i, int i2) {
        ArrayList<MediaModel> arrayList = this.H;
        if (arrayList != null && this.C < arrayList.size()) {
            this.v.setText(Q(this.H.get(this.C)));
        }
    }

    public final void R() {
        ArrayList<MediaModel> e2;
        this.p = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f092455);
        this.q = findViewById(R.id.obfuscated_res_0x7f09026e);
        a aVar = new a(this);
        aVar.setOrientation(0);
        this.p.setLayoutManager(aVar);
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
        this.A = swanAppThumbnailAdapter;
        this.p.setAdapter(swanAppThumbnailAdapter);
        if (pz2.e() == null) {
            e2 = null;
        } else {
            e2 = pz2.e();
        }
        this.A.p(e2);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.A));
        itemTouchHelper.attachToRecyclerView(this.p);
        lz2 P = P(this.n);
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
        if (pz2.g(mediaModel)) {
            this.v.setVisibility(0);
            this.v.setText(Q(this.H.get(this.C)));
            this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813e9);
            return;
        }
        this.v.setVisibility(8);
        if (oz2.f(oz2.d, mediaModel)) {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f0813eb);
        } else {
            this.r.setImageResource(R.drawable.obfuscated_res_0x7f0813ea);
        }
    }

    public final void S() {
        String string;
        this.m = findViewById(R.id.obfuscated_res_0x7f090269);
        DragView dragView = (DragView) findViewById(R.id.obfuscated_res_0x7f090943);
        this.o = dragView;
        dragView.setOnCloseListener(this);
        this.o.setBackgroundColor(-16777216);
        this.n = (ViewPager) findViewById(R.id.obfuscated_res_0x7f090272);
        this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f090270);
        this.t = findViewById(R.id.obfuscated_res_0x7f090267);
        this.s = findViewById(R.id.obfuscated_res_0x7f090271);
        this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f09026a);
        this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09026f);
        this.w = findViewById(R.id.obfuscated_res_0x7f090268);
        this.x = findViewById(R.id.obfuscated_res_0x7f09026b);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.n.setOnPageChangeListener(this.I);
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.H);
        this.z = swanAppAlbumPreviewAdapter;
        this.n.setAdapter(swanAppAlbumPreviewAdapter);
        this.z.x(this);
        this.n.setCurrentItem(this.C);
        this.s.setOnClickListener(this);
        this.u.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813e8);
        this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060aec));
        if (pz2.d() != 0) {
            string = getString(R.string.obfuscated_res_0x7f0f14cf) + "(" + pz2.d() + SmallTailInfo.EMOTION_SUFFIX;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f14cf);
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
        int o;
        if (this.A != null && this.C < this.H.size() && (o = this.A.o(this.H.get(this.C))) >= 0) {
            int i = o + 1;
            if (i < this.A.getItemCount()) {
                this.p.smoothScrollToPosition(i);
            } else {
                this.p.smoothScrollToPosition(o);
            }
            this.p.postDelayed(new d(o), 300L);
        }
    }

    public final void Z() {
        ArrayList<MediaModel> e2 = pz2.e();
        ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070842);
        if (e2 != null && e2.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07082c)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07084d);
    }

    @Override // com.baidu.tieba.rz2
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

    @Override // com.baidu.tieba.rz2
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
            O();
            finish();
            return;
        }
        ArrayList<MediaModel> arrayList2 = this.H;
        if (arrayList2 != null && this.C < arrayList2.size()) {
            MediaModel mediaModel = this.H.get(this.C);
            if (view2 == this.s) {
                if (pz2.f(mediaModel)) {
                    this.A.notifyItemRemoved(pz2.c(mediaModel));
                    pz2.h(mediaModel);
                    if (pz2.d() == 0) {
                        this.A.p(null);
                    }
                    this.v.setVisibility(8);
                    this.r.setImageResource(R.drawable.obfuscated_res_0x7f0813ea);
                    if (pz2.d() > 0) {
                        string = getString(R.string.obfuscated_res_0x7f0f14cf) + "(" + pz2.d() + SmallTailInfo.EMOTION_SUFFIX;
                    } else {
                        string = getString(R.string.obfuscated_res_0x7f0f14cf);
                    }
                    this.u.setText(string);
                    Z();
                    return;
                }
                int d2 = pz2.d();
                if (d2 == oz2.c) {
                    oz2.j(oz2.d);
                } else if (d2 > 0 && TextUtils.equals(oz2.d, "single") && !TextUtils.equals(pz2.b(), mediaModel.getType())) {
                    qb3.f(this, R.string.obfuscated_res_0x7f0f14be).G();
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    qb3.f(this, R.string.obfuscated_res_0x7f0f14bd).G();
                } else {
                    int d3 = pz2.d();
                    this.A.notifyItemInserted(d3);
                    pz2.i(mediaModel);
                    if (this.A.l() == null) {
                        this.A.p(pz2.e());
                    }
                    this.p.smoothScrollToPosition(d3);
                    this.v.setVisibility(0);
                    this.v.setText(Q(mediaModel));
                    this.v.setBackgroundResource(R.drawable.obfuscated_res_0x7f0813e9);
                    this.u.setText(getString(R.string.obfuscated_res_0x7f0f14cf) + "(" + pz2.d() + SmallTailInfo.EMOTION_SUFFIX);
                    this.u.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060aec));
                    Z();
                }
            } else if (view2 == this.u) {
                if (pz2.d() == 0 && (arrayList = this.H) != null && arrayList.size() > 0 && this.C < this.H.size()) {
                    pz2.i(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", oz2.e);
                bundle.putString("swanAppId", oz2.f);
                bundle.putParcelableArrayList("mediaModels", pz2.e());
                bundle.putString("swanTmpPath", oz2.j);
                oz2.g(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.op4, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList<MediaModel> parcelableArrayList;
        int c0 = sp3.c0(this);
        super.onCreate(bundle);
        sp3.g(this, c0);
        X();
        ja3 ja3Var = new ja3(this);
        this.y = ja3Var;
        ja3Var.b(false);
        getWindow().setFlags(1024, 1024);
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(getApplicationContext());
        }
        setContentView(R.layout.obfuscated_res_0x7f0d08ea);
        if (getIntent() != null) {
            Bundle e2 = xo3.e(getIntent(), "launchParams");
            this.C = xo3.f(e2, "previewPosition", 0);
            String g = xo3.g(e2, "previewFrom");
            this.F = g;
            if (TextUtils.equals(g, "bottomPreview")) {
                ArrayList<MediaModel> arrayList = new ArrayList<>();
                this.H = arrayList;
                arrayList.addAll(pz2.e());
            } else if (TextUtils.equals(this.F, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                if (e2 == null) {
                    parcelableArrayList = null;
                } else {
                    parcelableArrayList = e2.getParcelableArrayList("mediaModels");
                }
                this.H = parcelableArrayList;
            } else {
                this.H = oz2.c();
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
