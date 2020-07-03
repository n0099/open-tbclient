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
    private com.baidu.live.gift.dynamicGift.a aMC;
    private AlaDynamicGiftLayout.a aMD;
    private long aME;
    private Runnable aMF;
    private a aMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void Aj();

        void Ak();

        void co(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aMG = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Aj() {
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void co(int i) {
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Ak() {
                AlaDynamicGiftAnimationView.this.aMC.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aMF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aMF);
                }
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMG = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Aj() {
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void co(int i) {
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Ak() {
                AlaDynamicGiftAnimationView.this.aMC.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aMF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aMF);
                }
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMG = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Aj() {
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void co(int i2) {
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Ak() {
                AlaDynamicGiftAnimationView.this.aMC.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aMF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aMF);
                }
                if (AlaDynamicGiftAnimationView.this.aMD != null) {
                    AlaDynamicGiftAnimationView.this.aMD.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aMF = new b(this);
        this.aMC = new com.baidu.live.gift.dynamicGift.a();
        this.aMC.a(this.aMG);
    }

    public void setScreen(int i, int i2) {
        if (this.aMC != null) {
            this.aMC.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aMC.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai() {
        if (this.aMF != null) {
            mHandler.postDelayed(this.aMF, (long) this.aMC.Ao());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aMI;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aMI = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aMI != null && (alaDynamicGiftAnimationView = this.aMI.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aMC.An()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aME > 4000 && alaDynamicGiftAnimationView.aMG != null) {
                            alaDynamicGiftAnimationView.aMG.Ak();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Ai();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aMC.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aMC != null) {
            this.aMC.g(canvas);
        }
    }

    public void startAnim() {
        this.aME = System.currentTimeMillis();
        Ai();
    }

    public void stopAnim() {
        if (mHandler != null && this.aMF != null) {
            mHandler.removeCallbacks(this.aMF);
        }
        this.aMC.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aMD = aVar;
    }
}
