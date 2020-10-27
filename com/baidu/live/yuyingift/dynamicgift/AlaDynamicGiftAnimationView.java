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
    private com.baidu.live.yuyingift.dynamicgift.a bKR;
    private AlaDynamicGiftLayout.a bKS;
    private a bKT;
    private long bal;
    private Runnable bam;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void If();

        void Ig();

        void et(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bKT = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void If() {
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void Ig() {
                AlaDynamicGiftAnimationView.this.bKR.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bam);
                }
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKT = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void If() {
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void Ig() {
                AlaDynamicGiftAnimationView.this.bKR.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bam);
                }
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKT = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void If() {
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void et(int i2) {
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void Ig() {
                AlaDynamicGiftAnimationView.this.bKR.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bam);
                }
                if (AlaDynamicGiftAnimationView.this.bKS != null) {
                    AlaDynamicGiftAnimationView.this.bKS.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bam = new b(this);
        this.bKR = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bKR.a(this.bKT);
    }

    public void setScreen(int i, int i2) {
        if (this.bKR != null) {
            this.bKR.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bKR.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ie() {
        if (this.bam != null) {
            mHandler.postDelayed(this.bam, (long) this.bKR.Ik());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bap;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bap = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bap != null && (alaDynamicGiftAnimationView = this.bap.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bKR.Ij()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bal > 4000 && alaDynamicGiftAnimationView.bKT != null) {
                            alaDynamicGiftAnimationView.bKT.Ig();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Ie();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bKR.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bKR != null) {
            this.bKR.g(canvas);
        }
    }

    public void startAnim() {
        this.bal = System.currentTimeMillis();
        Ie();
    }

    public void stopAnim() {
        if (mHandler != null && this.bam != null) {
            mHandler.removeCallbacks(this.bam);
        }
        this.bKR.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bKS = aVar;
    }
}
