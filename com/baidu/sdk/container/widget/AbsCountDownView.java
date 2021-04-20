package com.baidu.sdk.container.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.b.c0.a.l.c;
import java.util.concurrent.TimeUnit;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public abstract class AbsCountDownView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public long f11227e;

    /* renamed from: f  reason: collision with root package name */
    public b f11228f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c0.a.l.b f11229g;

    /* loaded from: classes2.dex */
    public class a extends d.b.c0.a.l.b {
        public a() {
        }

        @Override // d.b.c0.a.l.b
        public Object b() {
            AbsCountDownView.this.d();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onEnd();

        void onProgress(int i);
    }

    public AbsCountDownView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f11229g = new a();
        c.a().d(this.f11229g, 0L, getTaskPeriod(), TimeUnit.MILLISECONDS);
    }

    public void b() {
        c();
        a();
    }

    public void c() {
        d.b.c0.a.l.b bVar = this.f11229g;
        if (bVar != null) {
            bVar.cancel();
            this.f11229g = null;
        }
    }

    public abstract void d();

    public void e(int i, int i2) {
    }

    public long getTaskPeriod() {
        long j = this.f11227e;
        if (j == 0) {
            return 100L;
        }
        return j;
    }

    public void setCountdownProgressListener(b bVar) {
        this.f11228f = bVar;
    }

    public void setTaskPeriod(long j) {
        this.f11227e = j;
    }

    public abstract void setTimeMillis(long j);

    public AbsCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
