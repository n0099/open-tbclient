package com.baidu.nadcore.rotationpop;

import android.content.Context;
import com.baidu.nadcore.rotation.NadSensorAbsHelper;
import com.baidu.nadcore.rotationpop.NadLottiePopView;
import com.baidu.tieba.ds0;
import com.baidu.tieba.v21;
import com.baidu.tieba.w21;
import com.baidu.tieba.x21;
import com.baidu.tieba.y21;
import com.baidu.tieba.z21;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000B\u001f\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u000eJ\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u000eJ\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/baidu/nadcore/rotationpop/NadSensorLottieComponent;", "Lcom/baidu/nadcore/model/NadRotationPopModel;", "model", "", "checkDataValid", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)Z", "Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "getHelper", "()Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView;", "getView", "()Lcom/baidu/nadcore/rotationpop/NadLottiePopView;", "", "release", "()V", "reset", "selectHelper", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "setData", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)V", "setSensorActiveTime", "startSensor", "stopSensor", "", "progress", "updatePlayerProgress", "(I)V", "helper", "Lcom/baidu/nadcore/rotation/NadSensorAbsHelper;", "popView$delegate", "Lkotlin/Lazy;", "getPopView", "popView", "", "sensorActiveTimeArray", "[I", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "sensorListener", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "Landroid/content/Context;", "context", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;", "viewListener", "<init>", "(Landroid/content/Context;Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadSensorLottieComponent {
    public final w21 a;
    public final Lazy b;
    public NadSensorAbsHelper c;
    public int[] d;

    public final NadLottiePopView b() {
        return (NadLottiePopView) this.b.getValue();
    }

    public NadSensorLottieComponent(final Context context, final NadLottiePopView.d viewListener, w21 sensorListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewListener, "viewListener");
        Intrinsics.checkNotNullParameter(sensorListener, "sensorListener");
        this.a = sensorListener;
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<NadLottiePopView>() { // from class: com.baidu.nadcore.rotationpop.NadSensorLottieComponent$popView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NadLottiePopView invoke() {
                NadLottiePopView nadLottiePopView = new NadLottiePopView(context, null, 0, 6, null);
                nadLottiePopView.setBusinessActionListener(viewListener);
                return nadLottiePopView;
            }
        });
        this.d = new int[]{0, 0};
    }

    public final boolean a(ds0 ds0Var) {
        boolean z;
        String str = ds0Var.b;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z || ds0Var.d < 0) {
            return false;
        }
        return true;
    }

    public final NadLottiePopView c() {
        return b();
    }

    public final void d() {
        e();
        b().t();
        NadSensorAbsHelper nadSensorAbsHelper = this.c;
        if (nadSensorAbsHelper != null) {
            nadSensorAbsHelper.l();
        }
    }

    public final void e() {
        b().o();
        i();
    }

    public final void i() {
        String str;
        NadSensorAbsHelper nadSensorAbsHelper;
        Object tag = b().getTag();
        if (!(tag instanceof ds0)) {
            tag = null;
        }
        ds0 ds0Var = (ds0) tag;
        if (ds0Var != null && (str = ds0Var.n) != null && str.hashCode() == 109399814 && str.equals("shake") && (nadSensorAbsHelper = this.c) != null) {
            nadSensorAbsHelper.o();
        }
    }

    public final NadSensorAbsHelper f(ds0 ds0Var) {
        Context context = b().getContext();
        if (context == null) {
            return null;
        }
        String str = ds0Var.n;
        int hashCode = str.hashCode();
        if (hashCode != -40300674) {
            if (hashCode != 109399814 || !str.equals("shake")) {
                return null;
            }
            y21 y21Var = new y21(context, this.a);
            y21Var.m(new x21(0, 0, 0, 0.0f, false, ds0Var.s, ds0Var.t, ds0Var.u, 31, null));
            return y21Var;
        } else if (!str.equals("rotation")) {
            return null;
        } else {
            v21 v21Var = new v21(context, this.a);
            v21Var.s(0, ds0Var.f, ds0Var.g, ds0Var.h, true);
            return v21Var;
        }
    }

    public final void g(ds0 model) {
        float f;
        Intrinsics.checkNotNullParameter(model, "model");
        if (!a(model)) {
            d();
            return;
        }
        b().setTag(model);
        h(model);
        NadSensorAbsHelper f2 = f(model);
        if (f2 != null) {
            this.c = f2;
            if (Intrinsics.areEqual(model.m, "follow")) {
                int i = model.f;
                f = i / (i + model.g);
            } else {
                f = 0.0f;
            }
            b().setParams(new z21(model.q, model.p, model.o, model.b, model.v, model.m, model.a, model.c, model.l, model.j, model.k, model.d, model.e, f));
        }
    }

    public final void h(ds0 ds0Var) {
        List split$default = StringsKt__StringsKt.split$default((CharSequence) ds0Var.r, new String[]{"_"}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            int size = split$default.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.d[i] = Integer.parseInt((String) split$default.get(i));
                } catch (NumberFormatException unused) {
                    this.d[i] = 0;
                }
            }
        }
    }

    public final void j(int i) {
        NadSensorAbsHelper nadSensorAbsHelper;
        NadSensorAbsHelper nadSensorAbsHelper2;
        b().y(i);
        int[] iArr = this.d;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (i3 - i2 <= 0) {
            NadSensorAbsHelper nadSensorAbsHelper3 = this.c;
            if (nadSensorAbsHelper3 != null) {
                nadSensorAbsHelper3.o();
            }
        } else if (i2 <= i && i3 >= i) {
            NadSensorAbsHelper nadSensorAbsHelper4 = this.c;
            if ((nadSensorAbsHelper4 == null || !nadSensorAbsHelper4.j()) && (nadSensorAbsHelper2 = this.c) != null) {
                nadSensorAbsHelper2.n();
            }
        } else {
            NadSensorAbsHelper nadSensorAbsHelper5 = this.c;
            if (nadSensorAbsHelper5 != null && nadSensorAbsHelper5.j() && (nadSensorAbsHelper = this.c) != null) {
                nadSensorAbsHelper.o();
            }
        }
    }
}
