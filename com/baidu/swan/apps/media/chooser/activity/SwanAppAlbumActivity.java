package com.baidu.swan.apps.media.chooser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.bp3;
import com.baidu.tieba.c03;
import com.baidu.tieba.c92;
import com.baidu.tieba.d03;
import com.baidu.tieba.nz2;
import com.baidu.tieba.oz2;
import com.baidu.tieba.sz2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.tz2;
import com.baidu.tieba.wo3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.zz2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public nz2 o;
    public TextView p;
    public TextView q;
    public TextView r;
    public RelativeLayout s;
    public TextView t;
    public View u;
    public View v;
    public HeightListView w;
    public LoadingLayout x;
    public boolean y = false;
    public boolean z = false;
    public ArrayList<c03> A = new ArrayList<>();
    public AdapterView.OnItemClickListener C = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (SwanAppAlbumActivity.this.y && !SwanAppAlbumActivity.this.z) {
                SwanAppAlbumActivity.this.W();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zz2 {
        public b() {
        }

        @Override // com.baidu.tieba.zz2
        public void a(int i) {
            SwanAppAlbumActivity.this.P();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwanAppAlbumActivity.this.y = false;
            SwanAppAlbumActivity.this.z = false;
            SwanAppAlbumActivity.this.u.setVisibility(8);
            SwanAppAlbumActivity.this.v.setVisibility(8);
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081429);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            SwanAppAlbumActivity.this.p.setCompoundDrawables(null, null, drawable, null);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwanAppAlbumActivity.this.y = true;
            SwanAppAlbumActivity.this.z = false;
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081417);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            SwanAppAlbumActivity.this.p.setCompoundDrawables(null, null, drawable, null);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (SwanAppAlbumActivity.this.y && !SwanAppAlbumActivity.this.z) {
                SwanAppAlbumActivity.this.W();
            }
            SwanAppAlbumActivity.this.p.setText(((c03) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((c03) SwanAppAlbumActivity.this.A.get(i)).d;
            SwanAppAlbumActivity.this.o.x(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.s.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.s.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends Handler {
        public WeakReference<SwanAppAlbumActivity> a;

        public f(SwanAppAlbumActivity swanAppAlbumActivity) {
            this.a = new WeakReference<>(swanAppAlbumActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            SwanAppAlbumActivity swanAppAlbumActivity = this.a.get();
            if (swanAppAlbumActivity != null && !swanAppAlbumActivity.isFinishing() && message.what == 0) {
                c92.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.V(obj);
            }
        }
    }

    public final void R() {
        this.w.setAdapter((ListAdapter) new oz2(this, sz2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void S() {
        this.B = new f(this);
        this.x.b(true);
        wo3.j(new d03(sz2.b, this.B), "loadAlbumTask");
    }

    public final void T() {
        nz2 nz2Var = new nz2(this);
        this.o = nz2Var;
        this.n.setAdapter((ListAdapter) nz2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void W() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f01016c);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new c());
    }

    public final void X() {
        if (this.y) {
            return;
        }
        this.u.setVisibility(0);
        this.v.setVisibility(0);
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f01016b);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f010172);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.m;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.B;
        if (handler != null) {
            handler.removeMessages(0);
            this.B = null;
        }
        tz2.a();
        sz2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.sp4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = wp3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        wp3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d08fc);
        tp3.a(this);
        Q();
        U();
        S();
    }

    public final void P() {
        if (tz2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060aef));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ae0));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14e0, Integer.valueOf(tz2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060af0));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ae1));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f14f0));
    }

    public final void Q() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = bp3.e(getIntent(), "launchParams");
        sz2.b = bp3.g(e2, "launchType");
        sz2.h = bp3.c(e2, "isShowCamera", true);
        sz2.i = bp3.c(e2, "isFrontCamera", false);
        sz2.g = bp3.f(e2, "maxDuration", 60);
        sz2.c = bp3.f(e2, "count", 9);
        String g = bp3.g(e2, "mode");
        sz2.e = bp3.c(e2, "compressed", true);
        sz2.f = bp3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            sz2.d = g;
        }
        sz2.j = bp3.g(e2, "swanTmpPath");
        int i = sz2.c;
        if (i < 1 || i > 9) {
            sz2.c = 9;
        }
    }

    public final void U() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f09024a);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090259);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f09026f);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090244);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090243);
        this.u = findViewById(R.id.obfuscated_res_0x7f090260);
        this.v = findViewById(R.id.obfuscated_res_0x7f09025f);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f09025e);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f090249);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090255);
        this.w.setListViewHeight(tp3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(sz2.b(this, sz2.b));
    }

    public final void V(Object obj) {
        this.x.b(false);
        ArrayList<c03> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f081429);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(tp3.f(this, 4.0f));
        } else {
            this.s.setVisibility(8);
        }
        this.q.setVisibility(0);
        P();
        R();
        T();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.p) {
            ArrayList<c03> arrayList = this.A;
            if (arrayList == null || arrayList.size() <= 1 || this.z) {
                return;
            }
            if (this.y) {
                W();
            } else {
                X();
            }
        } else if (view2 == this.q) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", sz2.e);
            bundle.putString("swanAppId", sz2.f);
            bundle.putParcelableArrayList("mediaModels", tz2.e());
            bundle.putString("swanTmpPath", sz2.j);
            sz2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && tz2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            sz2.k(this, bundle2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 32770 && i2 == -1) {
            boolean z = false;
            if (intent != null) {
                z = intent.getBooleanExtra("isRefresh", false);
            }
            if (z) {
                nz2 nz2Var = this.o;
                if (nz2Var != null) {
                    nz2Var.notifyDataSetChanged();
                }
                P();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
