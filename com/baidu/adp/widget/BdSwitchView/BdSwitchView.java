package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.d;
import com.baidu.adp.e;
import com.baidu.adp.f;
/* loaded from: classes.dex */
public class BdSwitchView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f194a;
    ImageView b;
    private c c;
    private SwitchState d;
    private boolean e;
    private boolean f;
    private TranslateAnimation g;
    private TranslateAnimation h;
    private Animation.AnimationListener i;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchState[] valuesCustom() {
            SwitchState[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchState[] switchStateArr = new SwitchState[length];
            System.arraycopy(valuesCustom, 0, switchStateArr, 0, length);
            return switchStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum SwitchStyle {
        DAY,
        NIGHT,
        SIDE_BAR;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchStyle[] valuesCustom() {
            SwitchStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchStyle[] switchStyleArr = new SwitchStyle[length];
            System.arraycopy(valuesCustom, 0, switchStyleArr, 0, length);
            return switchStyleArr;
        }
    }

    public BdSwitchView(Context context) {
        super(context);
        this.c = null;
        this.d = SwitchState.ON;
        this.e = false;
        this.f = false;
        this.i = null;
        this.f194a = null;
        this.b = null;
        a(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = SwitchState.ON;
        this.e = false;
        this.f = false;
        this.i = null;
        this.f194a = null;
        this.b = null;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(f.bd_switch_view, (ViewGroup) this, true);
        this.f194a = (FrameLayout) findViewById(e.layout);
        this.b = (ImageView) findViewById(e.switch_image);
        d();
        e();
        this.i = new a(this);
        setOnClickListener(new b(this));
        f();
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f194a.getLayoutParams();
        layoutParams.width = this.f194a.getForeground().getIntrinsicWidth();
        this.f194a.setLayoutParams(layoutParams);
    }

    private void e() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = this.b.getBackground().getIntrinsicWidth();
        this.b.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.e) {
            super.setOnClickListener(onClickListener);
            this.e = true;
        }
    }

    private void f() {
        float translateDis = getTranslateDis();
        this.g = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
        this.g.setDuration(200L);
        this.g.setFillAfter(true);
        this.g.setAnimationListener(this.i);
        this.h = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        this.h.setDuration(200L);
        this.h.setFillAfter(true);
        this.h.setAnimationListener(this.i);
    }

    private float getTranslateDis() {
        return this.f194a.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1631)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:332)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static /* synthetic */ void b(BdSwitchView bdSwitchView, boolean z) {
        bdSwitchView.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!this.f) {
            if (this.d == SwitchState.ON) {
                this.d = SwitchState.OFF;
                if (this.h != null) {
                    if (z) {
                        this.h.setDuration(200L);
                    } else {
                        this.h.setDuration(1L);
                    }
                    this.b.startAnimation(this.h);
                }
            } else {
                this.d = SwitchState.ON;
                if (this.g != null) {
                    if (z) {
                        this.g.setDuration(200L);
                    } else {
                        this.g.setDuration(1L);
                    }
                    this.b.startAnimation(this.g);
                }
            }
            if (this.c != null) {
                this.c.a(this, this.d);
            }
        }
    }

    public void setSwitchFrame(int i) {
        this.f194a.setForeground(getResources().getDrawable(i));
        d();
    }

    public void setSwitchImage(int i) {
        this.b.setBackgroundResource(i);
        e();
    }

    public void setSwitchStyle(SwitchStyle switchStyle) {
        if (switchStyle == SwitchStyle.DAY) {
            setSwitchFrame(d.btn_switch_masking);
            setSwitchImage(d.btn_switch);
        } else if (switchStyle == SwitchStyle.NIGHT) {
            setSwitchFrame(d.btn_switch_masking_1);
            setSwitchImage(d.btn_switch_1);
        } else if (switchStyle == SwitchStyle.SIDE_BAR) {
            setSwitchFrame(d.btn_switch_masking_sidebar);
            setSwitchImage(d.btn_switch_1);
        }
    }

    public void a() {
        if (this.d != SwitchState.ON) {
            a(false);
        }
    }

    public void b() {
        if (this.d != SwitchState.OFF) {
            a(false);
        }
    }

    public boolean c() {
        return this.d == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.c = cVar;
    }
}
