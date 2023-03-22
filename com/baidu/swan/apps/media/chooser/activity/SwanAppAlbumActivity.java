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
import com.baidu.tieba.ev2;
import com.baidu.tieba.fv2;
import com.baidu.tieba.jv2;
import com.baidu.tieba.kl3;
import com.baidu.tieba.kv2;
import com.baidu.tieba.nk3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.qv2;
import com.baidu.tieba.sk3;
import com.baidu.tieba.t42;
import com.baidu.tieba.tv2;
import com.baidu.tieba.uv2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public ev2 o;
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
    public ArrayList<tv2> A = new ArrayList<>();
    public AdapterView.OnItemClickListener C = new e();

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (SwanAppAlbumActivity.this.y && !SwanAppAlbumActivity.this.z) {
                SwanAppAlbumActivity.this.X();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements qv2 {
        public b() {
        }

        @Override // com.baidu.tieba.qv2
        public void a(int i) {
            SwanAppAlbumActivity.this.Q();
        }
    }

    /* loaded from: classes3.dex */
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08123a);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            SwanAppAlbumActivity.this.p.setCompoundDrawables(null, null, drawable, null);
        }
    }

    /* loaded from: classes3.dex */
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081228);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            SwanAppAlbumActivity.this.p.setCompoundDrawables(null, null, drawable, null);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (SwanAppAlbumActivity.this.y && !SwanAppAlbumActivity.this.z) {
                SwanAppAlbumActivity.this.X();
            }
            SwanAppAlbumActivity.this.p.setText(((tv2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((tv2) SwanAppAlbumActivity.this.A.get(i)).d;
            SwanAppAlbumActivity.this.o.x(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.s.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.s.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                t42.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.W(obj);
            }
        }
    }

    public final void S() {
        this.w.setAdapter((ListAdapter) new fv2(this, jv2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void T() {
        this.B = new f(this);
        this.x.b(true);
        nk3.j(new uv2(jv2.b, this.B), "loadAlbumTask");
    }

    public final void U() {
        ev2 ev2Var = new ev2(this);
        this.o = ev2Var;
        this.n.setAdapter((ListAdapter) ev2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void X() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010147);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new c());
    }

    public final void Y() {
        if (this.y) {
            return;
        }
        this.u.setVisibility(0);
        this.v.setVisibility(0);
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010146);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f01014d);
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
        kv2.a();
        jv2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.jl4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = nl3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        nl3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0895);
        kl3.a(this);
        R();
        V();
        T();
    }

    public final void Q() {
        if (kv2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060959));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06094a));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f138b, Integer.valueOf(kv2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06095a));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06094b));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f139b));
    }

    public final void R() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = sk3.e(getIntent(), "launchParams");
        jv2.b = sk3.g(e2, "launchType");
        jv2.h = sk3.c(e2, "isShowCamera", true);
        jv2.i = sk3.c(e2, "isFrontCamera", false);
        jv2.g = sk3.f(e2, "maxDuration", 60);
        jv2.c = sk3.f(e2, "count", 9);
        String g = sk3.g(e2, "mode");
        jv2.e = sk3.c(e2, "compressed", true);
        jv2.f = sk3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            jv2.d = g;
        }
        jv2.j = sk3.g(e2, "swanTmpPath");
        int i = jv2.c;
        if (i < 1 || i > 9) {
            jv2.c = 9;
        }
    }

    public final void V() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f090248);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090257);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f09026d);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090242);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090241);
        this.u = findViewById(R.id.obfuscated_res_0x7f09025e);
        this.v = findViewById(R.id.obfuscated_res_0x7f09025d);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f09025c);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f090247);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090253);
        this.w.setListViewHeight(kl3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(jv2.b(this, jv2.b));
    }

    public final void W(Object obj) {
        this.x.b(false);
        ArrayList<tv2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f08123a);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(kl3.f(this, 4.0f));
        } else {
            this.s.setVisibility(8);
        }
        this.q.setVisibility(0);
        Q();
        S();
        U();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.p) {
            ArrayList<tv2> arrayList = this.A;
            if (arrayList == null || arrayList.size() <= 1 || this.z) {
                return;
            }
            if (this.y) {
                X();
            } else {
                Y();
            }
        } else if (view2 == this.q) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", jv2.e);
            bundle.putString("swanAppId", jv2.f);
            bundle.putParcelableArrayList("mediaModels", kv2.e());
            bundle.putString("swanTmpPath", jv2.j);
            jv2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && kv2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            jv2.k(this, bundle2);
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
                ev2 ev2Var = this.o;
                if (ev2Var != null) {
                    ev2Var.notifyDataSetChanged();
                }
                Q();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
