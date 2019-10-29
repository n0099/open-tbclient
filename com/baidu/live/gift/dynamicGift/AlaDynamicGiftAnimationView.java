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
    private com.baidu.live.gift.dynamicGift.a abi;
    private AlaDynamicGiftLayout.a abj;
    private long abk;
    private Runnable abl;
    private a abm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void bq(int i);

        void qJ();

        void qK();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.abm = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qJ() {
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bq(int i) {
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qK() {
                AlaDynamicGiftAnimationView.this.abi.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.abl != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.abl);
                }
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abm = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qJ() {
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bq(int i) {
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qK() {
                AlaDynamicGiftAnimationView.this.abi.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.abl != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.abl);
                }
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abm = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qJ() {
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bq(int i2) {
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void qK() {
                AlaDynamicGiftAnimationView.this.abi.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.abl != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.abl);
                }
                if (AlaDynamicGiftAnimationView.this.abj != null) {
                    AlaDynamicGiftAnimationView.this.abj.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.abl = new b(this);
        this.abi = new com.baidu.live.gift.dynamicGift.a();
        this.abi.a(this.abm);
    }

    public void setScreen(int i, int i2) {
        if (this.abi != null) {
            this.abi.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.abi.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI() {
        if (this.abl != null) {
            mHandler.postDelayed(this.abl, (long) this.abi.qO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> abo;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.abo = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.abo != null && (alaDynamicGiftAnimationView = this.abo.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.abi.qN()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.abk > 4000 && alaDynamicGiftAnimationView.abm != null) {
                            alaDynamicGiftAnimationView.abm.qK();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.qI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.abi.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abi != null) {
            this.abi.f(canvas);
        }
    }

    public void startAnim() {
        this.abk = System.currentTimeMillis();
        qI();
    }

    public void stopAnim() {
        if (mHandler != null && this.abl != null) {
            mHandler.removeCallbacks(this.abl);
        }
        this.abi.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.abj = aVar;
    }
}
