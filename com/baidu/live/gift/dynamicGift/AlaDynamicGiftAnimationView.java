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
    private com.baidu.live.gift.dynamicGift.a aVB;
    private AlaDynamicGiftLayout.a aVC;
    private long aVD;
    private Runnable aVE;
    private a aVF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void GO();

        void GP();

        void en(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aVF = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void en(int i) {
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GP() {
                AlaDynamicGiftAnimationView.this.aVB.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aVE != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aVE);
                }
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVF = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void en(int i) {
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GP() {
                AlaDynamicGiftAnimationView.this.aVB.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aVE != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aVE);
                }
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVF = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void en(int i2) {
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GP() {
                AlaDynamicGiftAnimationView.this.aVB.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aVE != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aVE);
                }
                if (AlaDynamicGiftAnimationView.this.aVC != null) {
                    AlaDynamicGiftAnimationView.this.aVC.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aVE = new b(this);
        this.aVB = new com.baidu.live.gift.dynamicGift.a();
        this.aVB.a(this.aVF);
    }

    public void setScreen(int i, int i2) {
        if (this.aVB != null) {
            this.aVB.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aVB.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
        if (this.aVE != null) {
            mHandler.postDelayed(this.aVE, (long) this.aVB.GT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aVH;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aVH = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aVH != null && (alaDynamicGiftAnimationView = this.aVH.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aVB.GS()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aVD > 4000 && alaDynamicGiftAnimationView.aVF != null) {
                            alaDynamicGiftAnimationView.aVF.GP();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.GN();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aVB.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aVB != null) {
            this.aVB.g(canvas);
        }
    }

    public void startAnim() {
        this.aVD = System.currentTimeMillis();
        GN();
    }

    public void stopAnim() {
        if (mHandler != null && this.aVE != null) {
            mHandler.removeCallbacks(this.aVE);
        }
        this.aVB.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aVC = aVar;
    }
}
