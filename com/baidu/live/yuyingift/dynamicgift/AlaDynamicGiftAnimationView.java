package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private AlaDynamicGiftLayout.a bQA;
    private a bQB;
    private com.baidu.live.yuyingift.dynamicgift.a bQz;
    private long bbE;
    private Runnable bbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void IG();

        void IH();

        void et(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bQB = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void IG() {
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void IH() {
                AlaDynamicGiftAnimationView.this.bQz.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bbF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bbF);
                }
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQB = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void IG() {
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void IH() {
                AlaDynamicGiftAnimationView.this.bQz.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bbF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bbF);
                }
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bQB = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void IG() {
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void et(int i2) {
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void IH() {
                AlaDynamicGiftAnimationView.this.bQz.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bbF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bbF);
                }
                if (AlaDynamicGiftAnimationView.this.bQA != null) {
                    AlaDynamicGiftAnimationView.this.bQA.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bbF = new b(this);
        this.bQz = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bQz.a(this.bQB);
    }

    public void setScreen(int i, int i2) {
        if (this.bQz != null) {
            this.bQz.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bQz.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        if (this.bbF != null) {
            mHandler.postDelayed(this.bbF, (long) this.bQz.IL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bbI;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bbI = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bbI != null && (alaDynamicGiftAnimationView = this.bbI.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bQz.IK()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bbE > 4000 && alaDynamicGiftAnimationView.bQB != null) {
                            alaDynamicGiftAnimationView.bQB.IH();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.IF();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bQz.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bQz != null) {
            this.bQz.g(canvas);
        }
    }

    public void startAnim() {
        this.bbE = System.currentTimeMillis();
        IF();
    }

    public void stopAnim() {
        if (mHandler != null && this.bbF != null) {
            mHandler.removeCallbacks(this.bbF);
        }
        this.bQz.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bQA = aVar;
    }
}
