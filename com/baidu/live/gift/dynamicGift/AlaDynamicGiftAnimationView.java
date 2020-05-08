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
    private com.baidu.live.gift.dynamicGift.a aEu;
    private AlaDynamicGiftLayout.a aEv;
    private long aEw;
    private Runnable aEx;
    private a aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void bZ(int i);

        void yt();

        void yu();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aEy = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yt() {
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bZ(int i) {
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yu() {
                AlaDynamicGiftAnimationView.this.aEu.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aEx != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aEx);
                }
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEy = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yt() {
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bZ(int i) {
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yu() {
                AlaDynamicGiftAnimationView.this.aEu.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aEx != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aEx);
                }
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEy = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yt() {
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bZ(int i2) {
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yu() {
                AlaDynamicGiftAnimationView.this.aEu.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aEx != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aEx);
                }
                if (AlaDynamicGiftAnimationView.this.aEv != null) {
                    AlaDynamicGiftAnimationView.this.aEv.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aEx = new b(this);
        this.aEu = new com.baidu.live.gift.dynamicGift.a();
        this.aEu.a(this.aEy);
    }

    public void setScreen(int i, int i2) {
        if (this.aEu != null) {
            this.aEu.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aEu.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys() {
        if (this.aEx != null) {
            mHandler.postDelayed(this.aEx, (long) this.aEu.yy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aEA;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aEA = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aEA != null && (alaDynamicGiftAnimationView = this.aEA.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aEu.yx()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aEw > 4000 && alaDynamicGiftAnimationView.aEy != null) {
                            alaDynamicGiftAnimationView.aEy.yu();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.ys();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aEu.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aEu != null) {
            this.aEu.g(canvas);
        }
    }

    public void startAnim() {
        this.aEw = System.currentTimeMillis();
        ys();
    }

    public void stopAnim() {
        if (mHandler != null && this.aEx != null) {
            mHandler.removeCallbacks(this.aEx);
        }
        this.aEu.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aEv = aVar;
    }
}
