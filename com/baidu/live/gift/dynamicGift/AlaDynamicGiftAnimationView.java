package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a aaP;
    private AlaDynamicGiftLayout.a aaQ;
    private long aaR;
    private Runnable aaS;
    private a aaT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void bq(int i);

        void qK();

        void qL();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aaT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qK() {
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bq(int i) {
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qL() {
                AlaDynamicGiftAnimationView.this.aaP.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aaS != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aaS);
                }
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qK() {
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bq(int i) {
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qL() {
                AlaDynamicGiftAnimationView.this.aaP.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aaS != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aaS);
                }
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qK() {
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bq(int i2) {
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qL() {
                AlaDynamicGiftAnimationView.this.aaP.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aaS != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aaS);
                }
                if (AlaDynamicGiftAnimationView.this.aaQ != null) {
                    AlaDynamicGiftAnimationView.this.aaQ.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aaS = new b(this);
        this.aaP = new com.baidu.live.gift.dynamicGift.a();
        this.aaP.a(this.aaT);
    }

    public void setScreen(int i, int i2) {
        if (this.aaP != null) {
            this.aaP.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aaP.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ() {
        if (this.aaS != null) {
            mHandler.postDelayed(this.aaS, (long) this.aaP.qP());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aaV;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aaV = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aaV != null && (alaDynamicGiftAnimationView = this.aaV.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aaP.qO()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aaR > 4000 && alaDynamicGiftAnimationView.aaT != null) {
                            alaDynamicGiftAnimationView.aaT.qL();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.qJ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aaP.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aaP != null) {
            this.aaP.f(canvas);
        }
    }

    public void startAnim() {
        this.aaR = System.currentTimeMillis();
        qJ();
    }

    public void stopAnim() {
        if (mHandler != null && this.aaS != null) {
            mHandler.removeCallbacks(this.aaS);
        }
        this.aaP.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aaQ = aVar;
    }
}
