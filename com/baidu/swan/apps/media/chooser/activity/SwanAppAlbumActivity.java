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
import com.baidu.tieba.au2;
import com.baidu.tieba.bk3;
import com.baidu.tieba.bu2;
import com.baidu.tieba.ej3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.hu2;
import com.baidu.tieba.jj3;
import com.baidu.tieba.k32;
import com.baidu.tieba.ku2;
import com.baidu.tieba.lu2;
import com.baidu.tieba.vt2;
import com.baidu.tieba.wt2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public vt2 o;
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
    public ArrayList<ku2> A = new ArrayList<>();
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
    public class b implements hu2 {
        public b() {
        }

        @Override // com.baidu.tieba.hu2
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0814b7);
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0814a5);
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
            SwanAppAlbumActivity.this.p.setText(((ku2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((ku2) SwanAppAlbumActivity.this.A.get(i)).d;
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
                k32.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.V(obj);
            }
        }
    }

    public final void R() {
        this.w.setAdapter((ListAdapter) new wt2(this, au2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void S() {
        this.B = new f(this);
        this.x.b(true);
        ej3.j(new lu2(au2.b, this.B), "loadAlbumTask");
    }

    public final void T() {
        vt2 vt2Var = new vt2(this);
        this.o = vt2Var;
        this.n.setAdapter((ListAdapter) vt2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void W() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010174);
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
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010173);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f01017a);
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
        bu2.a();
        au2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.zj4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = ek3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        ek3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d095f);
        bk3.a(this);
        Q();
        U();
        S();
    }

    public final void P() {
        if (bu2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b0a));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060afb));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f155d, Integer.valueOf(bu2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b0b));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060afc));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f156d));
    }

    public final void Q() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = jj3.e(getIntent(), "launchParams");
        au2.b = jj3.g(e2, "launchType");
        au2.h = jj3.c(e2, "isShowCamera", true);
        au2.i = jj3.c(e2, "isFrontCamera", false);
        au2.g = jj3.f(e2, "maxDuration", 60);
        au2.c = jj3.f(e2, "count", 9);
        String g = jj3.g(e2, "mode");
        au2.e = jj3.c(e2, "compressed", true);
        au2.f = jj3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            au2.d = g;
        }
        au2.j = jj3.g(e2, "swanTmpPath");
        int i = au2.c;
        if (i < 1 || i > 9) {
            au2.c = 9;
        }
    }

    public final void U() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f090279);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090288);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f09029e);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090271);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090270);
        this.u = findViewById(R.id.obfuscated_res_0x7f09028f);
        this.v = findViewById(R.id.obfuscated_res_0x7f09028e);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f09028d);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f090276);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090284);
        this.w.setListViewHeight(bk3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(au2.b(this, au2.b));
    }

    public final void V(Object obj) {
        this.x.b(false);
        ArrayList<ku2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f0814b7);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(bk3.f(this, 4.0f));
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
            ArrayList<ku2> arrayList = this.A;
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
            bundle.putBoolean("compressed", au2.e);
            bundle.putString("swanAppId", au2.f);
            bundle.putParcelableArrayList("mediaModels", bu2.e());
            bundle.putString("swanTmpPath", au2.j);
            au2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && bu2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            au2.k(this, bundle2);
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
                vt2 vt2Var = this.o;
                if (vt2Var != null) {
                    vt2Var.notifyDataSetChanged();
                }
                P();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
