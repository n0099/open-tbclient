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
    private com.baidu.live.gift.dynamicGift.a aJW;
    private AlaDynamicGiftLayout.a aJX;
    private long aJY;
    private Runnable aJZ;
    private a aKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void cg(int i);

        void zJ();

        void zK();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aKa = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void zJ() {
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void cg(int i) {
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void zK() {
                AlaDynamicGiftAnimationView.this.aJW.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aJZ != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aJZ);
                }
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKa = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void zJ() {
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void cg(int i) {
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void zK() {
                AlaDynamicGiftAnimationView.this.aJW.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aJZ != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aJZ);
                }
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKa = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void zJ() {
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void cg(int i2) {
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void zK() {
                AlaDynamicGiftAnimationView.this.aJW.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aJZ != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aJZ);
                }
                if (AlaDynamicGiftAnimationView.this.aJX != null) {
                    AlaDynamicGiftAnimationView.this.aJX.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aJZ = new b(this);
        this.aJW = new com.baidu.live.gift.dynamicGift.a();
        this.aJW.a(this.aKa);
    }

    public void setScreen(int i, int i2) {
        if (this.aJW != null) {
            this.aJW.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aJW.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zI() {
        if (this.aJZ != null) {
            mHandler.postDelayed(this.aJZ, (long) this.aJW.zO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aKc;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aKc = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aKc != null && (alaDynamicGiftAnimationView = this.aKc.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aJW.zN()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aJY > 4000 && alaDynamicGiftAnimationView.aKa != null) {
                            alaDynamicGiftAnimationView.aKa.zK();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.zI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aJW.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aJW != null) {
            this.aJW.g(canvas);
        }
    }

    public void startAnim() {
        this.aJY = System.currentTimeMillis();
        zI();
    }

    public void stopAnim() {
        if (mHandler != null && this.aJZ != null) {
            mHandler.removeCallbacks(this.aJZ);
        }
        this.aJW.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aJX = aVar;
    }
}
