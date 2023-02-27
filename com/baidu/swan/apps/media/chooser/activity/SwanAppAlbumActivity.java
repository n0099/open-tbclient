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
import com.baidu.tieba.cx2;
import com.baidu.tieba.dn3;
import com.baidu.tieba.dx2;
import com.baidu.tieba.gm3;
import com.baidu.tieba.gn3;
import com.baidu.tieba.jx2;
import com.baidu.tieba.lm3;
import com.baidu.tieba.m62;
import com.baidu.tieba.mx2;
import com.baidu.tieba.nx2;
import com.baidu.tieba.xw2;
import com.baidu.tieba.yw2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public xw2 o;
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
    public ArrayList<mx2> A = new ArrayList<>();
    public AdapterView.OnItemClickListener C = new e();

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (SwanAppAlbumActivity.this.y && !SwanAppAlbumActivity.this.z) {
                SwanAppAlbumActivity.this.V();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jx2 {
        public b() {
        }

        @Override // com.baidu.tieba.jx2
        public void a(int i) {
            SwanAppAlbumActivity.this.O();
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081221);
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08120f);
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
                SwanAppAlbumActivity.this.V();
            }
            SwanAppAlbumActivity.this.p.setText(((mx2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((mx2) SwanAppAlbumActivity.this.A.get(i)).d;
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
                m62.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.U(obj);
            }
        }
    }

    public final void Q() {
        this.w.setAdapter((ListAdapter) new yw2(this, cx2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void R() {
        this.B = new f(this);
        this.x.b(true);
        gm3.j(new nx2(cx2.b, this.B), "loadAlbumTask");
    }

    public final void S() {
        xw2 xw2Var = new xw2(this);
        this.o = xw2Var;
        this.n.setAdapter((ListAdapter) xw2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void V() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010143);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new c());
    }

    public final void W() {
        if (this.y) {
            return;
        }
        this.u.setVisibility(0);
        this.v.setVisibility(0);
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010142);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f010149);
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
        dx2.a();
        cx2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.cn4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = gn3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        gn3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d087b);
        dn3.a(this);
        P();
        T();
        R();
    }

    public final void O() {
        if (dx2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060952));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060943));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1377, Integer.valueOf(dx2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060953));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060944));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f1387));
    }

    public final void P() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = lm3.e(getIntent(), "launchParams");
        cx2.b = lm3.g(e2, "launchType");
        cx2.h = lm3.c(e2, "isShowCamera", true);
        cx2.i = lm3.c(e2, "isFrontCamera", false);
        cx2.g = lm3.f(e2, "maxDuration", 60);
        cx2.c = lm3.f(e2, "count", 9);
        String g = lm3.g(e2, "mode");
        cx2.e = lm3.c(e2, "compressed", true);
        cx2.f = lm3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            cx2.d = g;
        }
        cx2.j = lm3.g(e2, "swanTmpPath");
        int i = cx2.c;
        if (i < 1 || i > 9) {
            cx2.c = 9;
        }
    }

    public final void T() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f090241);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090250);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090266);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09023b);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09023a);
        this.u = findViewById(R.id.obfuscated_res_0x7f090257);
        this.v = findViewById(R.id.obfuscated_res_0x7f090256);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f090255);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f090240);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09024c);
        this.w.setListViewHeight(dn3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(cx2.b(this, cx2.b));
    }

    public final void U(Object obj) {
        this.x.b(false);
        ArrayList<mx2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f081221);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(dn3.f(this, 4.0f));
        } else {
            this.s.setVisibility(8);
        }
        this.q.setVisibility(0);
        O();
        Q();
        S();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.p) {
            ArrayList<mx2> arrayList = this.A;
            if (arrayList == null || arrayList.size() <= 1 || this.z) {
                return;
            }
            if (this.y) {
                V();
            } else {
                W();
            }
        } else if (view2 == this.q) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", cx2.e);
            bundle.putString("swanAppId", cx2.f);
            bundle.putParcelableArrayList("mediaModels", dx2.e());
            bundle.putString("swanTmpPath", cx2.j);
            cx2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && dx2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            cx2.k(this, bundle2);
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
                xw2 xw2Var = this.o;
                if (xw2Var != null) {
                    xw2Var.notifyDataSetChanged();
                }
                O();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
