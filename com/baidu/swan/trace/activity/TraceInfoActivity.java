package com.baidu.swan.trace.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.i0.q.c;
import d.a.i0.q.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class TraceInfoActivity extends Activity implements View.OnClickListener {
    public static final String TIP_LOADING = "-- LOADING --";
    public static final String TIP_NO_DATA = "NO DATA";
    public List<d.a.i0.q.a> mBeans;
    public int mIndex;
    public Button mSwitchThread;
    public Set<String> mThreads;
    public TextView mTraceInfo;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceInfoActivity.this.showTextInUIThread(TraceInfoActivity.this.getContent());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11969e;

        public b(String str) {
            this.f11969e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TraceInfoActivity.this.mTraceInfo != null) {
                TraceInfoActivity.this.mTraceInfo.setText(this.f11969e);
            }
        }
    }

    private void doShowInfo() {
        this.mTraceInfo.setText(TIP_LOADING);
        ExecutorUtilsExt.postOnElastic(new a(), "show-trace", 3);
    }

    private void fillThreads() {
        for (d.a.i0.q.a aVar : this.mBeans) {
            this.mThreads.add(aVar.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getContent() {
        ArrayList arrayList = new ArrayList(this.mThreads);
        int i2 = this.mIndex;
        this.mIndex = i2 + 1;
        String str = (String) arrayList.get(i2 % arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        for (d.a.i0.q.a aVar : this.mBeans) {
            if (TextUtils.equals(aVar.f(), str)) {
                arrayList2.add(aVar);
            }
        }
        return d.a.i0.q.f.a.c(arrayList2, null);
    }

    private void initViews() {
        this.mTraceInfo = (TextView) findViewById(d.a.i0.q.b.trace_info);
        Button button = (Button) findViewById(d.a.i0.q.b.switch_thread);
        this.mSwitchThread = button;
        button.setOnClickListener(this);
        this.mThreads = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextInUIThread(String str) {
        runOnUiThread(new b(str));
    }

    private void showTraceInfo() {
        d.a.i0.q.e.a<List<d.a.i0.q.a>> c2 = d.b().c();
        if (c2 == null) {
            this.mTraceInfo.setText(TIP_NO_DATA);
            return;
        }
        List<d.a.i0.q.a> a2 = c2.a();
        if (a2 != null && a2.size() > 0) {
            this.mBeans = a2;
            this.mIndex = 0;
            fillThreads();
            doShowInfo();
            return;
        }
        this.mTraceInfo.setText(TIP_NO_DATA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.a.i0.q.b.switch_thread) {
            doShowInfo();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.activity_trace_info);
        initViews();
        showTraceInfo();
    }
}
