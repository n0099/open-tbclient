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
import com.baidu.tieba.az2;
import com.baidu.tieba.co3;
import com.baidu.tieba.d82;
import com.baidu.tieba.dz2;
import com.baidu.tieba.ez2;
import com.baidu.tieba.oy2;
import com.baidu.tieba.py2;
import com.baidu.tieba.ty2;
import com.baidu.tieba.uo3;
import com.baidu.tieba.uy2;
import com.baidu.tieba.xn3;
import com.baidu.tieba.xo3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public oy2 o;
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
    public ArrayList<dz2> A = new ArrayList<>();
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
    public class b implements az2 {
        public b() {
        }

        @Override // com.baidu.tieba.az2
        public void a(int i) {
            SwanAppAlbumActivity.this.O();
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08145d);
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08144b);
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
            SwanAppAlbumActivity.this.p.setText(((dz2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((dz2) SwanAppAlbumActivity.this.A.get(i)).d;
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
                d82.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.U(obj);
            }
        }
    }

    public final void Q() {
        this.w.setAdapter((ListAdapter) new py2(this, ty2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void R() {
        this.B = new f(this);
        this.x.b(true);
        xn3.j(new ez2(ty2.b, this.B), "loadAlbumTask");
    }

    public final void S() {
        oy2 oy2Var = new oy2(this);
        this.o = oy2Var;
        this.n.setAdapter((ListAdapter) oy2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void W() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010171);
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
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010170);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f010177);
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
        uy2.a();
        ty2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.to4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = xo3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        xo3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d0928);
        uo3.a(this);
        P();
        T();
        R();
    }

    public final void O() {
        if (uy2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060afc));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060aed));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1508, Integer.valueOf(uy2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060afd));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060aee));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f1518));
    }

    public final void P() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = co3.e(getIntent(), "launchParams");
        ty2.b = co3.g(e2, "launchType");
        ty2.h = co3.c(e2, "isShowCamera", true);
        ty2.i = co3.c(e2, "isFrontCamera", false);
        ty2.g = co3.f(e2, "maxDuration", 60);
        ty2.c = co3.f(e2, "count", 9);
        String g = co3.g(e2, "mode");
        ty2.e = co3.c(e2, "compressed", true);
        ty2.f = co3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            ty2.d = g;
        }
        ty2.j = co3.g(e2, "swanTmpPath");
        int i = ty2.c;
        if (i < 1 || i > 9) {
            ty2.c = 9;
        }
    }

    public final void T() {
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
        this.w.setListViewHeight(uo3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(ty2.b(this, ty2.b));
    }

    public final void U(Object obj) {
        this.x.b(false);
        ArrayList<dz2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f08145d);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(uo3.f(this, 4.0f));
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
            ArrayList<dz2> arrayList = this.A;
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
            bundle.putBoolean("compressed", ty2.e);
            bundle.putString("swanAppId", ty2.f);
            bundle.putParcelableArrayList("mediaModels", uy2.e());
            bundle.putString("swanTmpPath", ty2.j);
            ty2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && uy2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            ty2.k(this, bundle2);
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
                oy2 oy2Var = this.o;
                if (oy2Var != null) {
                    oy2Var.notifyDataSetChanged();
                }
                O();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
