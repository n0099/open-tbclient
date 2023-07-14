package com.baidu.nadcore.rotation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.nadcore.rotation.NadSensorAbsHelper$sensorEventListener$2;
import com.baidu.tieba.t31;
import com.baidu.tieba.u31;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000B\u0017\u0012\u0006\u00109\u001a\u00020\u0014\u0012\u0006\u0010:\u001a\u00020\u000e¢\u0006\u0004\b;\u0010<J\u000f\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0001H&¢\u0006\u0004\b\u0004\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u000e8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00178F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001f\u0010.\u001a\u0004\u0018\u00010)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001f\u00108\u001a\u0004\u0018\u0001048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107¨\u0006="}, d2 = {"Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "", "getSensitivity", "()I", "getSensorType", "Landroid/hardware/SensorEvent;", "event", "", "handleEvent", "(Landroid/hardware/SensorEvent;)V", "release", "()V", "start", "stop", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "businessListener", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "getBusinessListener", "()Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextRef", "Ljava/lang/ref/WeakReference;", "", "isActive", "Z", "()Z", "setActive", "(Z)V", "isReady", "setReady", "Lcom/baidu/nadcore/rotation/NadSensorHelperParams;", "params", "Lcom/baidu/nadcore/rotation/NadSensorHelperParams;", "getParams", "()Lcom/baidu/nadcore/rotation/NadSensorHelperParams;", "setParams", "(Lcom/baidu/nadcore/rotation/NadSensorHelperParams;)V", "", "registerTimestamp", "J", "Landroid/hardware/Sensor;", "sensor$delegate", "Lkotlin/Lazy;", "getSensor", "()Landroid/hardware/Sensor;", "sensor", "Landroid/hardware/SensorEventListener;", "sensorEventListener$delegate", "getSensorEventListener", "()Landroid/hardware/SensorEventListener;", "sensorEventListener", "Landroid/hardware/SensorManager;", "sensorMgr$delegate", "getSensorMgr", "()Landroid/hardware/SensorManager;", "sensorMgr", "context", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;)V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class NadSensorAbsHelper {
    public final WeakReference<Context> a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public long e;
    public final t31 f;
    public u31 g;
    public boolean h;

    public abstract int f();

    public final Sensor g() {
        return (Sensor) this.c.getValue();
    }

    public final SensorEventListener h() {
        return (SensorEventListener) this.d.getValue();
    }

    public final SensorManager i() {
        return (SensorManager) this.b.getValue();
    }

    public abstract int j();

    public abstract void k(SensorEvent sensorEvent);

    public NadSensorAbsHelper(Context context, t31 listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.a = new WeakReference<>(context);
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<SensorManager>() { // from class: com.baidu.nadcore.rotation.NadSensorAbsHelper$sensorMgr$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SensorManager invoke() {
                WeakReference weakReference;
                Object obj;
                weakReference = NadSensorAbsHelper.this.a;
                Context context2 = (Context) weakReference.get();
                SensorManager sensorManager = null;
                if (context2 != null) {
                    obj = context2.getSystemService("sensor");
                } else {
                    obj = null;
                }
                if (obj instanceof SensorManager) {
                    sensorManager = obj;
                }
                return sensorManager;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<Sensor>() { // from class: com.baidu.nadcore.rotation.NadSensorAbsHelper$sensor$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Sensor invoke() {
                SensorManager i;
                i = NadSensorAbsHelper.this.i();
                if (i != null) {
                    return i.getDefaultSensor(NadSensorAbsHelper.this.j());
                }
                return null;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<NadSensorAbsHelper$sensorEventListener$2.a>() { // from class: com.baidu.nadcore.rotation.NadSensorAbsHelper$sensorEventListener$2
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
                    j = NadSensorAbsHelper.this.e;
                    if (nanoTime - j < 200000000) {
                        return;
                    }
                    NadSensorAbsHelper.this.k(sensorEvent);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.e = -1L;
        this.f = listener;
        this.g = new u31(0, 0, 0, 0.0f, false, 0, 0.0f, 0, 255, null);
    }

    public final void o(u31 u31Var) {
        Intrinsics.checkNotNullParameter(u31Var, "<set-?>");
        this.g = u31Var;
    }

    public final t31 d() {
        return this.f;
    }

    public final u31 e() {
        return this.g;
    }

    public final boolean l() {
        return this.h;
    }

    public final boolean m() {
        if (i() != null && g() != null) {
            return true;
        }
        return false;
    }

    public void n() {
        q();
        this.h = false;
    }

    public void p() {
        if (!this.f.a()) {
            return;
        }
        Sensor g = g();
        if (g != null) {
            SensorManager i = i();
            if (i != null) {
                i.registerListener(h(), g, f());
            }
            this.e = System.nanoTime();
        }
        this.h = true;
    }

    public void q() {
        SensorManager i = i();
        if (i != null) {
            i.unregisterListener(h());
        }
        this.h = false;
    }
}
