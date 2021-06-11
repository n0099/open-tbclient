package com.baidu.sdk.container.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d.a.f0.a.l.c;
import java.util.concurrent.TimeUnit;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public abstract class AbsCountDownView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public long f10039e;

    /* renamed from: f  reason: collision with root package name */
    public b f10040f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.f0.a.l.b f10041g;

    /* loaded from: classes2.dex */
    public class a extends d.a.f0.a.l.b {
        public a() {
        }

        @Override // d.a.f0.a.l.b
        public Object b() {
            AbsCountDownView.this.d();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onEnd();

        void onProgress(int i2);
    }

    public AbsCountDownView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f10041g = new a();
        c.a().d(this.f10041g, 0L, getTaskPeriod(), TimeUnit.MILLISECONDS);
    }

    public void b() {
        c();
        a();
    }

    public void c() {
        d.a.f0.a.l.b bVar = this.f10041g;
        if (bVar != null) {
            bVar.cancel();
            this.f10041g = null;
        }
    }

    public abstract void d();

    public void e(int i2, int i3) {
    }

    public long getTaskPeriod() {
        long j = this.f10039e;
        if (j == 0) {
            return 100L;
        }
        return j;
    }

    public void setCountdownProgressListener(b bVar) {
        this.f10040f = bVar;
    }

    public void setTaskPeriod(long j) {
        this.f10039e = j;
    }

    public abstract void setTimeMillis(long j);

    public AbsCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsCountDownView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
