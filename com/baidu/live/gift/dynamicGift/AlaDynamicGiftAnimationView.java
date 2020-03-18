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
    private com.baidu.live.gift.dynamicGift.a alW;
    private AlaDynamicGiftLayout.a alX;
    private long alY;
    private Runnable alZ;
    private a ama;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void bJ(int i);

        void ua();

        void ub();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.ama = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ua() {
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i) {
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ub() {
                AlaDynamicGiftAnimationView.this.alW.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alZ != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alZ);
                }
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ama = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ua() {
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i) {
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ub() {
                AlaDynamicGiftAnimationView.this.alW.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alZ != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alZ);
                }
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ama = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ua() {
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bJ(int i2) {
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ub() {
                AlaDynamicGiftAnimationView.this.alW.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.alZ != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.alZ);
                }
                if (AlaDynamicGiftAnimationView.this.alX != null) {
                    AlaDynamicGiftAnimationView.this.alX.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.alZ = new b(this);
        this.alW = new com.baidu.live.gift.dynamicGift.a();
        this.alW.a(this.ama);
    }

    public void setScreen(int i, int i2) {
        if (this.alW != null) {
            this.alW.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.alW.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ() {
        if (this.alZ != null) {
            mHandler.postDelayed(this.alZ, (long) this.alW.uf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> amc;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.amc = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.amc != null && (alaDynamicGiftAnimationView = this.amc.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.alW.ue()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.alY > 4000 && alaDynamicGiftAnimationView.ama != null) {
                            alaDynamicGiftAnimationView.ama.ub();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.tZ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.alW.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.alW != null) {
            this.alW.g(canvas);
        }
    }

    public void startAnim() {
        this.alY = System.currentTimeMillis();
        tZ();
    }

    public void stopAnim() {
        if (mHandler != null && this.alZ != null) {
            mHandler.removeCallbacks(this.alZ);
        }
        this.alW.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.alX = aVar;
    }
}
