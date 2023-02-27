package com.baidu.swan.trace.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.R;
import com.baidu.tieba.ko4;
import com.baidu.tieba.lo4;
import com.baidu.tieba.mo4;
import com.baidu.tieba.no4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class TraceInfoActivity extends Activity implements View.OnClickListener {
    public TextView a;
    public Button b;
    public List<ko4> c;
    public Set<String> d;
    public int e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceInfoActivity.this.h(TraceInfoActivity.this.f());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TraceInfoActivity.this.a != null) {
                TraceInfoActivity.this.a.setText(this.a);
            }
        }
    }

    public final void d() {
        this.a.setText("-- LOADING --");
        ExecutorUtilsExt.postOnElastic(new a(), "show-trace", 3);
    }

    public final void e() {
        for (ko4 ko4Var : this.c) {
            this.d.add(ko4Var.f());
        }
    }

    public final void g() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0924b6);
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f092190);
        this.b = button;
        button.setOnClickListener(this);
        this.d = new HashSet();
    }

    public final void h(String str) {
        runOnUiThread(new b(str));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        List<ko4> list;
        if (view2.getId() == R.id.obfuscated_res_0x7f092190 && (list = this.c) != null && list.size() > 0) {
            d();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0058);
        g();
        i();
    }

    public final String f() {
        ArrayList arrayList = new ArrayList(this.d);
        int i = this.e;
        this.e = i + 1;
        String str = (String) arrayList.get(i % arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        for (ko4 ko4Var : this.c) {
            if (TextUtils.equals(ko4Var.f(), str)) {
                arrayList2.add(ko4Var);
            }
        }
        return no4.c(arrayList2, null);
    }

    public final void i() {
        mo4<List<ko4>> c = lo4.b().c();
        if (c == null) {
            this.a.setText("NO DATA");
            return;
        }
        List<ko4> a2 = c.a();
        if (a2 != null && a2.size() > 0) {
            this.c = a2;
            this.e = 0;
            e();
            d();
            return;
        }
        this.a.setText("NO DATA");
    }
}
