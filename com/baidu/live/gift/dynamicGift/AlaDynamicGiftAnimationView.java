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
    private com.baidu.live.gift.dynamicGift.a aZQ;
    private AlaDynamicGiftLayout.a aZR;
    private long aZS;
    private Runnable aZT;
    private a aZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void HX();

        void HY();

        void ep(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aZU = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HX() {
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ep(int i) {
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HY() {
                AlaDynamicGiftAnimationView.this.aZQ.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aZT != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aZT);
                }
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZU = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HX() {
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ep(int i) {
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HY() {
                AlaDynamicGiftAnimationView.this.aZQ.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aZT != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aZT);
                }
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZU = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HX() {
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ep(int i2) {
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HY() {
                AlaDynamicGiftAnimationView.this.aZQ.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aZT != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aZT);
                }
                if (AlaDynamicGiftAnimationView.this.aZR != null) {
                    AlaDynamicGiftAnimationView.this.aZR.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aZT = new b(this);
        this.aZQ = new com.baidu.live.gift.dynamicGift.a();
        this.aZQ.a(this.aZU);
    }

    public void setScreen(int i, int i2) {
        if (this.aZQ != null) {
            this.aZQ.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aZQ.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HW() {
        if (this.aZT != null) {
            mHandler.postDelayed(this.aZT, (long) this.aZQ.Ic());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aZW;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aZW = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aZW != null && (alaDynamicGiftAnimationView = this.aZW.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aZQ.Ib()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aZS > 4000 && alaDynamicGiftAnimationView.aZU != null) {
                            alaDynamicGiftAnimationView.aZU.HY();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.HW();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aZQ.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aZQ != null) {
            this.aZQ.g(canvas);
        }
    }

    public void startAnim() {
        this.aZS = System.currentTimeMillis();
        HW();
    }

    public void stopAnim() {
        if (mHandler != null && this.aZT != null) {
            mHandler.removeCallbacks(this.aZT);
        }
        this.aZQ.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aZR = aVar;
    }
}
