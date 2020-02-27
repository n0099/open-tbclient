package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a alL;
    private AlaDynamicGiftLayout.a alM;
    private long alN;
    private Runnable alO;
    private a alP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void bJ(int i);

        void tV();

        void tW();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.alP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tV() {
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i) {
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tW() {
                AlaDynamicGiftAnimationView.this.alL.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alO != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alO);
                }
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tV() {
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i) {
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tW() {
                AlaDynamicGiftAnimationView.this.alL.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alO != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alO);
                }
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tV() {
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i2) {
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tW() {
                AlaDynamicGiftAnimationView.this.alL.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alO != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alO);
                }
                if (AlaDynamicGiftAnimationView.this.alM != null) {
                    AlaDynamicGiftAnimationView.this.alM.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.alO = new b(this);
        this.alL = new com.baidu.live.gift.dynamicGift.a();
        this.alL.a(this.alP);
    }

    public void setScreen(int i, int i2) {
        if (this.alL != null) {
            this.alL.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.alL.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU() {
        if (this.alO != null) {
            mHandler.postDelayed(this.alO, (long) this.alL.ua());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> alR;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.alR = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.alR != null && (alaDynamicGiftAnimationView = this.alR.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.alL.tZ()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.alN > 4000 && alaDynamicGiftAnimationView.alP != null) {
                            alaDynamicGiftAnimationView.alP.tW();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.tU();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.alL.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.alL != null) {
            this.alL.g(canvas);
        }
    }

    public void startAnim() {
        this.alN = System.currentTimeMillis();
        tU();
    }

    public void stopAnim() {
        if (mHandler != null && this.alO != null) {
            mHandler.removeCallbacks(this.alO);
        }
        this.alL.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.alM = aVar;
    }
}
