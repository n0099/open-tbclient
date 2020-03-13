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
    private com.baidu.live.gift.dynamicGift.a alM;
    private AlaDynamicGiftLayout.a alN;
    private long alO;
    private Runnable alP;
    private a alQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void bJ(int i);

        void tV();

        void tW();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.alQ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tV() {
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i) {
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tW() {
                AlaDynamicGiftAnimationView.this.alM.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alP != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alP);
                }
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alQ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tV() {
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i) {
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tW() {
                AlaDynamicGiftAnimationView.this.alM.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alP != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alP);
                }
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alQ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tV() {
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i2) {
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void tW() {
                AlaDynamicGiftAnimationView.this.alM.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alP != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alP);
                }
                if (AlaDynamicGiftAnimationView.this.alN != null) {
                    AlaDynamicGiftAnimationView.this.alN.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.alP = new b(this);
        this.alM = new com.baidu.live.gift.dynamicGift.a();
        this.alM.a(this.alQ);
    }

    public void setScreen(int i, int i2) {
        if (this.alM != null) {
            this.alM.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.alM.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU() {
        if (this.alP != null) {
            mHandler.postDelayed(this.alP, (long) this.alM.ua());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> alS;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.alS = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.alS != null && (alaDynamicGiftAnimationView = this.alS.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.alM.tZ()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.alO > 4000 && alaDynamicGiftAnimationView.alQ != null) {
                            alaDynamicGiftAnimationView.alQ.tW();
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
        this.alM.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.alM != null) {
            this.alM.g(canvas);
        }
    }

    public void startAnim() {
        this.alO = System.currentTimeMillis();
        tU();
    }

    public void stopAnim() {
        if (mHandler != null && this.alP != null) {
            mHandler.removeCallbacks(this.alP);
        }
        this.alM.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.alN = aVar;
    }
}
