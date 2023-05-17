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
import com.baidu.tieba.am3;
import com.baidu.tieba.an3;
import com.baidu.tieba.dx2;
import com.baidu.tieba.fm3;
import com.baidu.tieba.g62;
import com.baidu.tieba.gx2;
import com.baidu.tieba.hx2;
import com.baidu.tieba.rw2;
import com.baidu.tieba.sw2;
import com.baidu.tieba.ww2;
import com.baidu.tieba.xm3;
import com.baidu.tieba.xw2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public rw2 o;
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
    public ArrayList<gx2> A = new ArrayList<>();
    public AdapterView.OnItemClickListener C = new e();

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements dx2 {
        public b() {
        }

        @Override // com.baidu.tieba.dx2
        public void a(int i) {
            SwanAppAlbumActivity.this.Q();
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0813c4);
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0813b1);
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
                SwanAppAlbumActivity.this.X();
            }
            SwanAppAlbumActivity.this.p.setText(((gx2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((gx2) SwanAppAlbumActivity.this.A.get(i)).d;
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
                g62.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.W(obj);
            }
        }
    }

    public final void S() {
        this.w.setAdapter((ListAdapter) new sw2(this, ww2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void T() {
        this.B = new f(this);
        this.x.b(true);
        am3.j(new hx2(ww2.b, this.B), "loadAlbumTask");
    }

    public final void U() {
        rw2 rw2Var = new rw2(this);
        this.o = rw2Var;
        this.n.setAdapter((ListAdapter) rw2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void X() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f01016c);
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
        xw2.a();
        ww2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wm4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = an3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        an3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d08cd);
        xm3.a(this);
        R();
        V();
        T();
    }

    public final void Q() {
        if (xw2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ad6));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ac7));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f146d, Integer.valueOf(xw2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ad7));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060ac8));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f147d));
    }

    public final void R() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = fm3.e(getIntent(), "launchParams");
        ww2.b = fm3.g(e2, "launchType");
        ww2.h = fm3.c(e2, "isShowCamera", true);
        ww2.i = fm3.c(e2, "isFrontCamera", false);
        ww2.g = fm3.f(e2, "maxDuration", 60);
        ww2.c = fm3.f(e2, "count", 9);
        String g = fm3.g(e2, "mode");
        ww2.e = fm3.c(e2, "compressed", true);
        ww2.f = fm3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            ww2.d = g;
        }
        ww2.j = fm3.g(e2, "swanTmpPath");
        int i = ww2.c;
        if (i < 1 || i > 9) {
            ww2.c = 9;
        }
    }

    public final void V() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f09024d);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09025c);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090272);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090247);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090246);
        this.u = findViewById(R.id.obfuscated_res_0x7f090263);
        this.v = findViewById(R.id.obfuscated_res_0x7f090262);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f090261);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f09024c);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090258);
        this.w.setListViewHeight(xm3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(ww2.b(this, ww2.b));
    }

    public final void W(Object obj) {
        this.x.b(false);
        ArrayList<gx2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f0813c4);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(xm3.f(this, 4.0f));
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
            ArrayList<gx2> arrayList = this.A;
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
            bundle.putBoolean("compressed", ww2.e);
            bundle.putString("swanAppId", ww2.f);
            bundle.putParcelableArrayList("mediaModels", xw2.e());
            bundle.putString("swanTmpPath", ww2.j);
            ww2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && xw2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            ww2.k(this, bundle2);
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
                rw2 rw2Var = this.o;
                if (rw2Var != null) {
                    rw2Var.notifyDataSetChanged();
                }
                Q();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
