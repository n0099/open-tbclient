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
    private com.baidu.live.gift.dynamicGift.a aEo;
    private AlaDynamicGiftLayout.a aEp;
    private long aEq;
    private Runnable aEr;
    private a aEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void bZ(int i);

        void yu();

        void yv();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aEs = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yu() {
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bZ(int i) {
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yv() {
                AlaDynamicGiftAnimationView.this.aEo.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aEr != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aEr);
                }
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEs = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yu() {
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bZ(int i) {
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yv() {
                AlaDynamicGiftAnimationView.this.aEo.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aEr != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aEr);
                }
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEs = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yu() {
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bZ(int i2) {
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void yv() {
                AlaDynamicGiftAnimationView.this.aEo.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aEr != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aEr);
                }
                if (AlaDynamicGiftAnimationView.this.aEp != null) {
                    AlaDynamicGiftAnimationView.this.aEp.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aEr = new b(this);
        this.aEo = new com.baidu.live.gift.dynamicGift.a();
        this.aEo.a(this.aEs);
    }

    public void setScreen(int i, int i2) {
        if (this.aEo != null) {
            this.aEo.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aEo.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt() {
        if (this.aEr != null) {
            mHandler.postDelayed(this.aEr, (long) this.aEo.yz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aEu;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aEu = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aEu != null && (alaDynamicGiftAnimationView = this.aEu.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aEo.yy()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aEq > 4000 && alaDynamicGiftAnimationView.aEs != null) {
                            alaDynamicGiftAnimationView.aEs.yv();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.yt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aEo.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aEo != null) {
            this.aEo.g(canvas);
        }
    }

    public void startAnim() {
        this.aEq = System.currentTimeMillis();
        yt();
    }

    public void stopAnim() {
        if (mHandler != null && this.aEr != null) {
            mHandler.removeCallbacks(this.aEr);
        }
        this.aEo.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aEp = aVar;
    }
}
