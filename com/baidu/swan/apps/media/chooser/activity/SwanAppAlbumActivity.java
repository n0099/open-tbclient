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
import com.baidu.tieba.bo3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.ez2;
import com.baidu.tieba.go3;
import com.baidu.tieba.h82;
import com.baidu.tieba.hz2;
import com.baidu.tieba.iz2;
import com.baidu.tieba.sy2;
import com.baidu.tieba.ty2;
import com.baidu.tieba.xy2;
import com.baidu.tieba.yo3;
import com.baidu.tieba.yy2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public Handler B;
    public ActivityResultDispatcher m;
    public GridView n;
    public sy2 o;
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
    public ArrayList<hz2> A = new ArrayList<>();
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
    public class b implements ez2 {
        public b() {
        }

        @Override // com.baidu.tieba.ez2
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081482);
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
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081470);
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
            SwanAppAlbumActivity.this.p.setText(((hz2) SwanAppAlbumActivity.this.A.get(i)).c());
            ArrayList<MediaModel> arrayList = ((hz2) SwanAppAlbumActivity.this.A.get(i)).d;
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
                h82.b("SwanAppAlbumActivity", "LoadAlbumTask finished");
                Object obj = message.obj;
                if (!(obj instanceof ArrayList)) {
                    return;
                }
                swanAppAlbumActivity.U(obj);
            }
        }
    }

    public final void Q() {
        this.w.setAdapter((ListAdapter) new ty2(this, xy2.b, this.A));
        this.w.setOnItemClickListener(this.C);
    }

    public final void R() {
        this.B = new f(this);
        this.x.b(true);
        bo3.j(new iz2(xy2.b, this.B), "loadAlbumTask");
    }

    public final void S() {
        sy2 sy2Var = new sy2(this);
        this.o = sy2Var;
        this.n.setAdapter((ListAdapter) sy2Var);
        this.o.x(this.A.get(0).d);
        this.o.z(new b());
    }

    public final void W() {
        if (!this.y) {
            return;
        }
        this.z = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010175);
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
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.obfuscated_res_0x7f010174);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.v.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f01017b);
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
        yy2.a();
        xy2.a();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.xo4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = bp3.c0(this);
        super.onCreate(bundle);
        this.m = new ActivityResultDispatcher(this, 1);
        bp3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d093d);
        yo3.a(this);
        P();
        T();
        R();
    }

    public final void O() {
        if (yy2.d() > 0) {
            this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b03));
            this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060af4));
            this.q.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1521, Integer.valueOf(yy2.d())));
            return;
        }
        this.q.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060b04));
        this.r.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060af5));
        this.q.setText(getString(R.string.obfuscated_res_0x7f0f1531));
    }

    public final void P() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = go3.e(getIntent(), "launchParams");
        xy2.b = go3.g(e2, "launchType");
        xy2.h = go3.c(e2, "isShowCamera", true);
        xy2.i = go3.c(e2, "isFrontCamera", false);
        xy2.g = go3.f(e2, "maxDuration", 60);
        xy2.c = go3.f(e2, "count", 9);
        String g = go3.g(e2, "mode");
        xy2.e = go3.c(e2, "compressed", true);
        xy2.f = go3.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g)) {
            xy2.d = g;
        }
        xy2.j = go3.g(e2, "swanTmpPath");
        int i = xy2.c;
        if (i < 1 || i > 9) {
            xy2.c = 9;
        }
    }

    public final void T() {
        this.n = (GridView) findViewById(R.id.obfuscated_res_0x7f09024f);
        this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09025e);
        this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090274);
        this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090249);
        this.s = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090248);
        this.u = findViewById(R.id.obfuscated_res_0x7f090265);
        this.v = findViewById(R.id.obfuscated_res_0x7f090264);
        this.w = (HeightListView) findViewById(R.id.obfuscated_res_0x7f090263);
        this.x = (LoadingLayout) findViewById(R.id.obfuscated_res_0x7f09024e);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09025a);
        this.w.setListViewHeight(yo3.f(this, 400.0f));
        this.p.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnTouchListener(new a());
        this.s.setVisibility(0);
        this.p.setText(xy2.b(this, xy2.b));
    }

    public final void U(Object obj) {
        this.x.b(false);
        ArrayList<hz2> arrayList = (ArrayList) obj;
        this.A = arrayList;
        if (arrayList.size() > 0 && this.A.get(0) != null) {
            if (this.A.get(0).f() == null || this.A.get(0).f().size() == 0) {
                this.s.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f081482);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.p.setCompoundDrawables(null, null, drawable, null);
            this.p.setCompoundDrawablePadding(yo3.f(this, 4.0f));
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
            ArrayList<hz2> arrayList = this.A;
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
            bundle.putBoolean("compressed", xy2.e);
            bundle.putString("swanAppId", xy2.f);
            bundle.putParcelableArrayList("mediaModels", yy2.e());
            bundle.putString("swanTmpPath", xy2.j);
            xy2.g(this, bundle);
        } else if (view2 == this.t) {
            finish();
        } else if (view2 == this.r && yy2.d() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            xy2.k(this, bundle2);
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
                sy2 sy2Var = this.o;
                if (sy2Var != null) {
                    sy2Var.notifyDataSetChanged();
                }
                O();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }
}
