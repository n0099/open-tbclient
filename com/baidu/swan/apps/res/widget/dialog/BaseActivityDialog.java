package com.baidu.swan.apps.res.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.bk3;
import com.baidu.tieba.br2;
import com.baidu.tieba.dk3;
import com.baidu.tieba.eo1;
import com.baidu.tieba.ol3;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    public static final boolean q = eo1.a;
    public TextView a;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public View h;
    public View i;
    public FrameLayout j;
    public ImageView k;
    public RelativeLayout l;
    public e m;
    public SwanAppScrollView n;
    public LinearLayout o;
    public int p;

    public void d(int i) {
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static volatile HashMap<String, e> t = new HashMap<>();
        public static ArrayList u = new ArrayList();
        public String a;
        public CharSequence b;
        public String c;
        public String d;
        public View e;
        public Drawable f;
        public boolean g;
        public int h;
        public Bundle i;
        public DialogInterface.OnClickListener j;
        public DialogInterface.OnClickListener k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public Context n;
        public Class<? extends Activity> o;
        public int p;
        public String q;
        public Object r;
        public boolean s;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context appContext = AppRuntime.getAppContext();
                if (e.this.o == null) {
                    e.this.o = BaseActivityDialog.class;
                }
                Intent intent = new Intent(appContext, e.this.o);
                intent.putExtra("BOX_ACTIVITY_DIALOG_NIGHT_MODE", this.a);
                String valueOf = String.valueOf(intent.hashCode());
                intent.putExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER", valueOf);
                if (!TextUtils.isEmpty(e.this.q)) {
                    intent.putExtra("BOX_ACTIVITY_DIALOG_FROM", e.this.q);
                }
                if (e.this.i != null) {
                    intent.putExtras(e.this.i);
                }
                e.t(valueOf, e.this);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                dk3.g(appContext, intent);
            }
        }

        /* loaded from: classes3.dex */
        public static class b {
            public Object a;
        }

        /* loaded from: classes3.dex */
        public static class c {
            public DialogInterface a;
            public int b;

            public c(DialogInterface dialogInterface, int i) {
                this.a = dialogInterface;
                this.b = i;
            }
        }

        public e() {
            this(BaseActivityDialog.class);
        }

        public void D() {
            E(false);
        }

        public void s() {
            u.remove(this.r);
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.e = null;
            this.f = null;
        }

        public e(Class<? extends Activity> cls) {
            this.g = true;
            this.p = -1;
            this.n = AppRuntime.getAppContext();
            this.o = cls;
        }

        public static e r(String str) {
            e remove;
            if (!TextUtils.isEmpty(str)) {
                synchronized (t) {
                    remove = t.remove(str);
                }
                return remove;
            }
            return null;
        }

        public e B(int i) {
            C(this.n.getString(i));
            return this;
        }

        public e C(String str) {
            this.a = str;
            return this;
        }

        public void E(boolean z) {
            ol3.a0(new a(z));
        }

        public void onEvent(c cVar) {
            if (cVar == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i = cVar.b;
            if (i != -2) {
                if (i == -1) {
                    onClickListener = this.j;
                }
            } else {
                onClickListener = this.k;
            }
            if (onClickListener != null) {
                onClickListener.onClick(cVar.a, cVar.b);
            }
        }

        public e u(int i) {
            v(this.n.getString(i));
            return this;
        }

        public e v(String str) {
            this.b = str;
            return this;
        }

        public e y(DialogInterface.OnDismissListener onDismissListener) {
            this.m = onDismissListener;
            return this;
        }

        public static void t(String str, e eVar) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                synchronized (t) {
                    t.put(str, eVar);
                }
            }
        }

        public e A(String str, DialogInterface.OnClickListener onClickListener) {
            this.c = str;
            this.j = onClickListener;
            return this;
        }

        public e w(int i, DialogInterface.OnClickListener onClickListener) {
            x(this.n.getString(i), onClickListener);
            return this;
        }

        public e x(String str, DialogInterface.OnClickListener onClickListener) {
            this.d = str;
            this.k = onClickListener;
            return this;
        }

        public e z(int i, DialogInterface.OnClickListener onClickListener) {
            A(this.n.getString(i), onClickListener);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Action<e.c> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(e.c cVar) {
            BaseActivityDialog.this.m.onEvent(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Action<e.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(e.b bVar) {
            if (bVar.a == BaseActivityDialog.this.m.r) {
                BaseActivityDialog.this.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BaseActivityDialog.this.d(-1);
            BdEventBus.Companion.getDefault().post(new e.c(BaseActivityDialog.this, -1));
            BaseActivityDialog.this.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BaseActivityDialog.this.d(-2);
            BaseActivityDialog.this.dismiss();
            BdEventBus.Companion.getDefault().post(new e.c(BaseActivityDialog.this, -2));
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        e eVar = this.m;
        if (eVar != null && (onCancelListener = eVar.l) != null) {
            onCancelListener.onCancel(this);
        }
        finish();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        e();
        finish();
    }

    public void e() {
        DialogInterface.OnDismissListener onDismissListener;
        e eVar = this.m;
        if (eVar != null && (onDismissListener = eVar.m) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public final void f() {
        if (this.m != null) {
            BdEventBus.Companion.getDefault().unregister(this.m);
            this.m.s();
            this.m = null;
        }
        o(null);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources b2 = br2.M().b();
        if (b2 != null) {
            return b2;
        }
        return super.getResources();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        f();
        super.onDestroy();
    }

    public void g(boolean z) {
        if (z) {
            this.o.setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    public void h(Drawable drawable) {
        int i;
        this.k.setImageDrawable(drawable);
        ImageView imageView = this.k;
        if (drawable != null) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void i(CharSequence charSequence) {
        int i;
        this.b.setText(charSequence);
        LinearLayout linearLayout = this.c;
        if (!TextUtils.isEmpty(charSequence)) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.p);
        layoutParams.addRule(3, R.id.obfuscated_res_0x7f09087a);
        this.o.setLayoutParams(layoutParams);
    }

    public void l(boolean z) {
        this.d.setEnabled(z);
    }

    public void m(int i) {
        this.d.setTextColor(i);
    }

    public void n(String str) {
        this.a.setText(str);
    }

    public void o(View view2) {
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            if (view2 != null) {
                this.j.addView(view2);
                this.c.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.p);
                layoutParams.addRule(3, R.id.dialog_customPanel);
                this.o.setLayoutParams(layoutParams);
            }
        }
    }

    public TextView b() {
        int i;
        TextView textView;
        TextView textView2 = this.d;
        if (textView2 != null && textView2.getVisibility() == 0) {
            textView = this.d;
            i = 1;
        } else {
            i = 0;
            textView = null;
        }
        TextView textView3 = this.e;
        if (textView3 != null && textView3.getVisibility() == 0) {
            i++;
            textView = this.e;
        }
        TextView textView4 = this.f;
        if (textView4 != null && textView4.getVisibility() == 0) {
            i++;
            textView = this.f;
        }
        if (i != 1) {
            return null;
        }
        return textView;
    }

    public void p() {
        e eVar = this.m;
        if (eVar == null) {
            return;
        }
        n(eVar.a);
        h(eVar.f);
        i(eVar.b);
        o(eVar.e);
        l(eVar.g);
        m(eVar.h);
        k(eVar.c);
        j(eVar.d);
        g(eVar.s);
    }

    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090884);
        this.b = (TextView) findViewById(R.id.dialog_message);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09087a);
        this.d = (TextView) findViewById(R.id.positive_button);
        this.e = (TextView) findViewById(R.id.negative_button);
        this.f = (TextView) findViewById(R.id.neutral_button);
        this.h = findViewById(R.id.obfuscated_res_0x7f0908b3);
        this.i = findViewById(R.id.obfuscated_res_0x7f0908b4);
        this.j = (FrameLayout) findViewById(R.id.dialog_custom_content);
        this.k = (ImageView) findViewById(R.id.dialog_icon);
        this.l = (RelativeLayout) findViewById(R.id.searchbox_alert_dialog);
        this.g = findViewById(R.id.obfuscated_res_0x7f0908b2);
        this.n = (SwanAppScrollView) findViewById(R.id.message_scrollview);
        this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904b2);
        this.p = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070123);
        if (this.m.p > 0) {
            this.n.getLayoutParams().height = this.m.p;
        }
        if (bk3.k() || bk3.l()) {
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07012a);
            this.b.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    public void j(String str) {
        this.e.setText(str);
        this.e.setOnClickListener(new d());
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
            if (this.d.getVisibility() == 0) {
                this.h.setVisibility(8);
                return;
            }
            return;
        }
        this.e.setVisibility(0);
        if (this.d.getVisibility() == 0) {
            this.h.setVisibility(0);
        }
    }

    public void k(String str) {
        this.d.setText(str);
        this.d.setOnClickListener(new c());
        if (TextUtils.isEmpty(str)) {
            this.d.setVisibility(8);
            if (this.e.getVisibility() == 0) {
                this.h.setVisibility(8);
                return;
            }
            return;
        }
        this.d.setVisibility(0);
        if (this.e.getVisibility() == 0) {
            this.h.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0098);
        getWindow().setLayout(-1, -1);
        e r = e.r(getIntent().getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
        this.m = r;
        if (r == null) {
            if (q) {
                Log.e("BaseActivityDialog", "The builder for dialog activity can NOT be null.");
            }
            finish();
            return;
        }
        BdEventBus.Companion.getDefault().register(this.m, e.c.class, new a());
        BdEventBus.Companion.getDefault().register(this.m, e.b.class, new b());
        c();
        p();
        q();
    }

    public void q() {
        Resources resources = getResources();
        int color = resources.getColor(R.color.obfuscated_res_0x7f0602f6);
        int color2 = resources.getColor(R.color.obfuscated_res_0x7f0602e9);
        int color3 = resources.getColor(R.color.obfuscated_res_0x7f0602f3);
        this.l.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080144));
        this.a.setTextColor(color);
        this.b.setTextColor(color2);
        this.d.setTextColor(color);
        this.e.setTextColor(color);
        this.f.setTextColor(color);
        this.g.setBackgroundColor(color3);
        this.h.setBackgroundColor(color3);
        this.i.setBackgroundColor(color3);
        this.d.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cd));
        this.e.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cc));
        this.f.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800ce));
        TextView b2 = b();
        if (b2 != null) {
            b2.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cb));
        }
    }
}
