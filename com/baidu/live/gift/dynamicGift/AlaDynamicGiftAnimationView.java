package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a bdq;
    private AlaDynamicGiftLayout.a bdr;
    private long bds;
    private Runnable bdt;
    private a bdu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void JO();

        void JP();

        void eK(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bdu = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void JO() {
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void eK(int i) {
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void JP() {
                AlaDynamicGiftAnimationView.this.bdq.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdt);
                }
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdu = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void JO() {
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void eK(int i) {
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void JP() {
                AlaDynamicGiftAnimationView.this.bdq.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdt);
                }
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdu = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void JO() {
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void eK(int i2) {
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void JP() {
                AlaDynamicGiftAnimationView.this.bdq.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bdt != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bdt);
                }
                if (AlaDynamicGiftAnimationView.this.bdr != null) {
                    AlaDynamicGiftAnimationView.this.bdr.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bdt = new b(this);
        this.bdq = new com.baidu.live.gift.dynamicGift.a();
        this.bdq.a(this.bdu);
    }

    public void setScreen(int i, int i2) {
        if (this.bdq != null) {
            this.bdq.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bdq.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JN() {
        if (this.bdt != null) {
            mHandler.postDelayed(this.bdt, (long) this.bdq.JT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bdw;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bdw = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bdw != null && (alaDynamicGiftAnimationView = this.bdw.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bdq.JS()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bds > 4000 && alaDynamicGiftAnimationView.bdu != null) {
                            alaDynamicGiftAnimationView.bdu.JP();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.JN();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bdq.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bdq != null) {
            this.bdq.g(canvas);
        }
    }

    public void startAnim() {
        this.bds = System.currentTimeMillis();
        JN();
    }

    public void stopAnim() {
        if (mHandler != null && this.bdt != null) {
            mHandler.removeCallbacks(this.bdt);
        }
        this.bdq.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bdr = aVar;
    }
}
