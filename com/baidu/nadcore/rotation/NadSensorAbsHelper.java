package com.baidu.nadcore.rotation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.nadcore.rotation.NadSensorAbsHelper$sensorEventListener$2;
import com.baidu.tieba.gy0;
import com.baidu.tieba.hy0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000B\u0017\u0012\u0006\u00107\u001a\u00020\u0014\u0012\u0006\u00108\u001a\u00020\u000e¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0001H&¢\u0006\u0004\b\u0004\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u000e8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00178F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001d\u00102\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "", "getSensitivity", "()I", "getSensorType", "Landroid/hardware/SensorEvent;", "event", "", "handleEvent", "(Landroid/hardware/SensorEvent;)V", "release", "()V", "start", "stop", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "businessListener", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "getBusinessListener", "()Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextRef", "Ljava/lang/ref/WeakReference;", "", "isActive", "Z", "()Z", "setActive", "(Z)V", "isReady", "setReady", "Lcom/baidu/nadcore/rotation/NadSensorHelperParams;", "params", "Lcom/baidu/nadcore/rotation/NadSensorHelperParams;", "getParams", "()Lcom/baidu/nadcore/rotation/NadSensorHelperParams;", "setParams", "(Lcom/baidu/nadcore/rotation/NadSensorHelperParams;)V", "", "registerTimestamp", "J", "Landroid/hardware/Sensor;", "getSensor", "()Landroid/hardware/Sensor;", "sensor", "Landroid/hardware/SensorEventListener;", "sensorEventListener$delegate", "Lkotlin/Lazy;", "getSensorEventListener", "()Landroid/hardware/SensorEventListener;", "sensorEventListener", "Landroid/hardware/SensorManager;", "getSensorMgr", "()Landroid/hardware/SensorManager;", "sensorMgr", "context", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;)V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class NadSensorAbsHelper {
    public final WeakReference<Context> a;
    public final Lazy b;
    public long c;
    public final gy0 d;
    public hy0 e;
    public boolean f;

    public abstract int d();

    public final SensorEventListener f() {
        return (SensorEventListener) this.b.getValue();
    }

    public abstract int h();

    public abstract void i(SensorEvent sensorEvent);

    public NadSensorAbsHelper(Context context, gy0 listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.a = new WeakReference<>(context);
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<NadSensorAbsHelper$sensorEventListener$2.a>() { // from class: com.baidu.nadcore.rotation.NadSensorAbsHelper$sensorEventListener$2
            {
                super(0);
            }

            /* loaded from: classes3.dex */
            public static final class a implements SensorEventListener {
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                }

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public a() {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    long j;
                    long nanoTime = System.nanoTime();
                    j = NadSensorAbsHelper.this.c;
                    if (nanoTime - j < 200000000) {
                        return;
                    }
                    NadSensorAbsHelper.this.i(sensorEvent);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.c = -1L;
        this.d = listener;
        this.e = new hy0(0, 0, 0, 0.0f, false, 0, 0.0f, 0, 255, null);
    }

    public final void m(hy0 hy0Var) {
        Intrinsics.checkNotNullParameter(hy0Var, "<set-?>");
        this.e = hy0Var;
    }

    public final gy0 b() {
        return this.d;
    }

    public final hy0 c() {
        return this.e;
    }

    public final Sensor e() {
        SensorManager g = g();
        if (g != null) {
            return g.getDefaultSensor(h());
        }
        return null;
    }

    public final SensorManager g() {
        Object obj;
        Context context = this.a.get();
        SensorManager sensorManager = null;
        if (context != null) {
            obj = context.getSystemService("sensor");
        } else {
            obj = null;
        }
        if (obj instanceof SensorManager) {
            sensorManager = obj;
        }
        return sensorManager;
    }

    public final boolean j() {
        return this.f;
    }

    public final boolean k() {
        if (g() != null && e() != null) {
            return true;
        }
        return false;
    }

    public void l() {
        o();
        this.f = false;
    }

    public void o() {
        SensorManager g = g();
        if (g != null) {
            g.unregisterListener(f());
        }
        this.f = false;
    }

    public void n() {
        if (e() != null && g() != null && !this.f) {
            if (!this.d.a()) {
                o();
                return;
            }
            this.f = true;
            Sensor e = e();
            if (e != null) {
                SensorManager g = g();
                if (g != null) {
                    g.registerListener(f(), e, d());
                }
                this.c = System.nanoTime();
            }
        }
    }
}
