package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.nadcore.rotationpop.NadLottiePopView;
import com.baidu.nadcore.rotationpop.NadSensorLottieComponent;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.tieba.R;
import com.baidu.tieba.c11;
import com.baidu.tieba.gn0;
import com.baidu.tieba.jm0;
import com.baidu.tieba.pm0;
import com.baidu.tieba.px0;
import com.baidu.tieba.tk0;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0011¢\u0006\u0004\b7\u00108J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0 ¢\u0006\u0004\b\"\u0010#R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010$R\u001d\u0010)\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00069"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFloatingLayerView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/nadcore/model/NadRotationPopModel;", "model", "", "checkDataValid", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)Z", "Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "getSLComponentSensorListener", "()Lcom/baidu/nadcore/rotation/NadSensorEventAbsListener;", "Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;", "getSLComponentViewListener", "()Lcom/baidu/nadcore/rotationpop/NadLottiePopView$DefaultViewActionListener;", "floatingLayerModel", "", "initSensorComponent", "(Lcom/baidu/nadcore/model/NadRotationPopModel;)V", "", "progress", "onUpdateProgress", "(I)V", "", "cmd", "performInvoke", "(Ljava/lang/String;)V", "release", "()V", "resetSensorState", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setData", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "Lkotlin/Function1;", WebChromeClient.KEY_ARG_CALLBACK, "setTriggerCallback", "(Lkotlin/Function1;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "container$delegate", "Lkotlin/Lazy;", "getContainer", "()Landroid/widget/FrameLayout;", "container", "Lcom/baidu/nadcore/model/NadRotationPopModel;", "hasShown", "Z", "Lcom/baidu/nadcore/rotationpop/NadSensorLottieComponent;", "sensorLottieComponent", "Lcom/baidu/nadcore/rotationpop/NadSensorLottieComponent;", "triggerCallback", "Lkotlin/Function1;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardFloatingLayerView extends FrameLayout {
    public final Lazy a;
    public NadSensorLottieComponent b;
    public pm0 c;
    public gn0 d;
    public Function1<? super String, Unit> e;
    public boolean f;

    @JvmOverloads
    public NadRewardFloatingLayerView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardFloatingLayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout getContainer() {
        return (FrameLayout) this.a.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            gn0 d;
            NadRewardFloatingLayerView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            pm0 pm0Var = NadRewardFloatingLayerView.this.c;
            if (pm0Var != null && (d = pm0Var.d()) != null) {
                int e = (int) ((c11.c.e(this.b) * d.q) + (c11.c.a(this.b, 25.0f) * 2));
                FrameLayout container = NadRewardFloatingLayerView.this.getContainer();
                ViewGroup.LayoutParams layoutParams = NadRewardFloatingLayerView.this.getContainer().getLayoutParams();
                layoutParams.height = e;
                Unit unit = Unit.INSTANCE;
                container.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends px0 {
        @Override // com.baidu.tieba.px0
        public boolean a() {
            return true;
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.px0
        public void h() {
            NadLottiePopView c;
            String str;
            NadSensorLottieComponent nadSensorLottieComponent = NadRewardFloatingLayerView.this.b;
            if (nadSensorLottieComponent != null && (c = nadSensorLottieComponent.c()) != null && c.getVisibility() == 0) {
                tk0.w(NadRewardFloatingLayerView.this.c);
                NadRewardFloatingLayerView nadRewardFloatingLayerView = NadRewardFloatingLayerView.this;
                gn0 gn0Var = nadRewardFloatingLayerView.d;
                if (gn0Var != null) {
                    str = gn0Var.i;
                } else {
                    str = null;
                }
                nadRewardFloatingLayerView.k(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends NadLottiePopView.d {
        @Override // com.baidu.nadcore.rotationpop.NadLottiePopView.e
        public void a(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
        }

        @Override // com.baidu.nadcore.rotationpop.NadLottiePopView.e
        public void onHidden() {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.nadcore.rotationpop.NadLottiePopView.e
        public void b(View view2) {
            String str;
            Intrinsics.checkNotNullParameter(view2, "view");
            tk0.m(NadRewardFloatingLayerView.this.c);
            NadRewardFloatingLayerView nadRewardFloatingLayerView = NadRewardFloatingLayerView.this;
            gn0 gn0Var = nadRewardFloatingLayerView.d;
            if (gn0Var != null) {
                str = gn0Var.i;
            } else {
                str = null;
            }
            nadRewardFloatingLayerView.k(str);
        }

        @Override // com.baidu.nadcore.rotationpop.NadLottiePopView.e
        public boolean c() {
            return !NadRewardFloatingLayerView.this.f;
        }

        @Override // com.baidu.nadcore.rotationpop.NadLottiePopView.e
        public void onShown() {
            String str;
            jm0 jm0Var;
            pm0 pm0Var = NadRewardFloatingLayerView.this.c;
            if (pm0Var != null && (jm0Var = pm0Var.f) != null) {
                str = jm0Var.d;
            } else {
                str = null;
            }
            tk0.n(str);
            NadRewardFloatingLayerView.this.f = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardFloatingLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFloatingLayerView$container$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View findViewById = NadRewardFloatingLayerView.this.findViewById(R.id.floating_layer_container);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.floating_layer_container)");
                return (FrameLayout) findViewById;
            }
        });
        LayoutInflater.from(context).inflate(R.layout.nad_reward_floating_layer_layout, this);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(context));
    }

    public /* synthetic */ NadRewardFloatingLayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final boolean h(gn0 gn0Var) {
        String str;
        if (gn0Var != null) {
            str = gn0Var.n;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "shake") && (!StringsKt__StringsJVMKt.isBlank(gn0Var.b))) {
            return true;
        }
        return false;
    }

    public final void j(int i) {
        NadSensorLottieComponent nadSensorLottieComponent = this.b;
        if (nadSensorLottieComponent != null) {
            nadSensorLottieComponent.j(i);
        }
    }

    public final void k(String str) {
        boolean z;
        NadLottiePopView c2;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        NadSensorLottieComponent nadSensorLottieComponent = this.b;
        if (nadSensorLottieComponent != null && (c2 = nadSensorLottieComponent.c()) != null) {
            c2.m();
        }
        Function1<? super String, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void setData(pm0 pm0Var) {
        gn0 gn0Var;
        this.c = pm0Var;
        if (pm0Var != null) {
            gn0Var = pm0Var.d();
        } else {
            gn0Var = null;
        }
        this.d = gn0Var;
        m();
        if (!h(this.d)) {
            return;
        }
        i(this.d);
    }

    public final void setTriggerCallback(Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.e = callback;
    }

    private final px0 getSLComponentSensorListener() {
        return new b();
    }

    private final NadLottiePopView.d getSLComponentViewListener() {
        return new c();
    }

    public final void l() {
        NadSensorLottieComponent nadSensorLottieComponent = this.b;
        if (nadSensorLottieComponent != null) {
            nadSensorLottieComponent.d();
        }
        setVisibility(8);
    }

    public final void m() {
        NadSensorLottieComponent nadSensorLottieComponent = this.b;
        if (nadSensorLottieComponent != null) {
            nadSensorLottieComponent.d();
        }
        this.b = null;
        this.f = false;
    }

    public final void i(gn0 gn0Var) {
        String str;
        NadLottiePopView c2;
        NadLottiePopView nadLottiePopView = null;
        if (gn0Var != null) {
            str = gn0Var.n;
        } else {
            str = null;
        }
        if (str != null && str.hashCode() == 109399814 && str.equals("shake")) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            NadSensorLottieComponent nadSensorLottieComponent = new NadSensorLottieComponent(context, getSLComponentViewListener(), getSLComponentSensorListener());
            this.b = nadSensorLottieComponent;
            if (nadSensorLottieComponent != null) {
                nadSensorLottieComponent.g(gn0Var);
            }
            NadSensorLottieComponent nadSensorLottieComponent2 = this.b;
            if (nadSensorLottieComponent2 != null && (c2 = nadSensorLottieComponent2.c()) != null) {
                ExtensionsKt.e(c2);
            }
            getContainer().removeAllViews();
            FrameLayout container = getContainer();
            NadSensorLottieComponent nadSensorLottieComponent3 = this.b;
            if (nadSensorLottieComponent3 != null) {
                nadLottiePopView = nadSensorLottieComponent3.c();
            }
            container.addView(nadLottiePopView);
        }
        getContainer().setVisibility(0);
        getContainer().postInvalidate();
    }
}
