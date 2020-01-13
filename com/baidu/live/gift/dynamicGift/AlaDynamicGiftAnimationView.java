package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a ajD;
    private AlaDynamicGiftLayout.a ajE;
    private long ajF;
    private Runnable ajG;
    private a ajH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void bC(int i);

        void sJ();

        void sK();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.ajH = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void sJ() {
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bC(int i) {
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void sK() {
                AlaDynamicGiftAnimationView.this.ajD.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.ajG != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.ajG);
                }
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajH = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void sJ() {
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bC(int i) {
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void sK() {
                AlaDynamicGiftAnimationView.this.ajD.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.ajG != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.ajG);
                }
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajH = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void sJ() {
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bC(int i2) {
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void sK() {
                AlaDynamicGiftAnimationView.this.ajD.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.ajG != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.ajG);
                }
                if (AlaDynamicGiftAnimationView.this.ajE != null) {
                    AlaDynamicGiftAnimationView.this.ajE.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ajG = new b(this);
        this.ajD = new com.baidu.live.gift.dynamicGift.a();
        this.ajD.a(this.ajH);
    }

    public void setScreen(int i, int i2) {
        if (this.ajD != null) {
            this.ajD.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.ajD.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sI() {
        if (this.ajG != null) {
            mHandler.postDelayed(this.ajG, (long) this.ajD.sO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> ajJ;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.ajJ = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.ajJ != null && (alaDynamicGiftAnimationView = this.ajJ.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.ajD.sN()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.ajF > 4000 && alaDynamicGiftAnimationView.ajH != null) {
                            alaDynamicGiftAnimationView.ajH.sK();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.sI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.ajD.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ajD != null) {
            this.ajD.g(canvas);
        }
    }

    public void startAnim() {
        this.ajF = System.currentTimeMillis();
        sI();
    }

    public void stopAnim() {
        if (mHandler != null && this.ajG != null) {
            mHandler.removeCallbacks(this.ajG);
        }
        this.ajD.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.ajE = aVar;
    }
}
