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
import com.baidu.tieba.aj3;
import com.baidu.tieba.ak3;
import com.baidu.tieba.du2;
import com.baidu.tieba.fj3;
import com.baidu.tieba.g32;
import com.baidu.tieba.gu2;
import com.baidu.tieba.hu2;
import com.baidu.tieba.rt2;
import com.baidu.tieba.st2;
import com.baidu.tieba.wt2;
import com.baidu.tieba.xj3;
import com.baidu.tieba.xt2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public rt2 o;
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
    public ArrayList<gu2> A = new ArrayList<>();
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
    public class b implements du2 {
        public b() {
        }

        @Override // com.baidu.tieba.du2
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081491);
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08147f);
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
            SwanAppAlbumActivity.this.p.setText(((gu2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((gu2) SwanAppAlbumActivity.this.A.get(i)).d;
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
                g32.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.V(obj);
            }
        }
    }

    public final void R() {
        this.w.setAdapter((ListAdapter) new st2(this, wt2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void S() {
        this.B = new f(this);
        this.x.b(true);
        aj3.j(new hu2(wt2.b, this.B), "loadAlbumTask");
    }

    public final void T() {
        rt2 rt2Var = new rt2(this);
        this.o = rt2Var;
        this.n.setAdapter((ListAdapter) rt2Var);
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
        xt2.a();
        wt2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vj4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = ak3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        ak3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0944);
        xj3.a(this);
        Q();
        U();
        S();
    }

    public final void P() {
        if (xt2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b03));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060af4));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f154c, Integer.valueOf(xt2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b04));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060af5));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f155c));
    }

    public final void Q() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = fj3.e(getIntent(), "launchParams");
        wt2.b = fj3.g(e2, "launchType");
        wt2.h = fj3.c(e2, "isShowCamera", true);
        wt2.i = fj3.c(e2, "isFrontCamera", false);
        wt2.g = fj3.f(e2, "maxDuration", 60);
        wt2.c = fj3.f(e2, "count", 9);
        String g = fj3.g(e2, "mode");
        wt2.e = fj3.c(e2, "compressed", true);
        wt2.f = fj3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            wt2.d = g;
        }
        wt2.j = fj3.g(e2, "swanTmpPath");
        int i = wt2.c;
        if (i < 1 || i > 9) {
            wt2.c = 9;
        }
    }

    public final void U() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f090263);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090272);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f09028a);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09025d);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09025c);
        this.u = findViewById(R.id.obfuscated_res_0x7f09027b);
        this.v = findViewById(R.id.obfuscated_res_0x7f09027a);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f090279);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f090262);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09026e);
        this.w.setListViewHeight(xj3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(wt2.b(this, wt2.b));
    }

    public final void V(Object obj) {
        this.x.b(false);
        ArrayList<gu2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f081491);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(xj3.f(this, 4.0f));
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
            ArrayList<gu2> arrayList = this.A;
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
            bundle.putBoolean("compressed", wt2.e);
            bundle.putString("swanAppId", wt2.f);
            bundle.putParcelableArrayList("mediaModels", xt2.e());
            bundle.putString("swanTmpPath", wt2.j);
            wt2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && xt2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            wt2.k(this, bundle2);
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
                rt2 rt2Var = this.o;
                if (rt2Var != null) {
                    rt2Var.notifyDataSetChanged();
                }
                P();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
