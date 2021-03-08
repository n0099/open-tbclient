package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a beU;
    private AlaDynamicGiftLayout.a beV;
    private long beW;
    private Runnable beX;
    private a beY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void GO();

        void GP();

        void di(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.beY = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void di(int i) {
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GP() {
                AlaDynamicGiftAnimationView.this.beU.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.beX != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.beX);
                }
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beY = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void di(int i) {
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GP() {
                AlaDynamicGiftAnimationView.this.beU.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.beX != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.beX);
                }
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.beY = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GO() {
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void di(int i2) {
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void GP() {
                AlaDynamicGiftAnimationView.this.beU.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.beX != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.beX);
                }
                if (AlaDynamicGiftAnimationView.this.beV != null) {
                    AlaDynamicGiftAnimationView.this.beV.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.beX = new b(this);
        this.beU = new com.baidu.live.gift.dynamicGift.a();
        this.beU.a(this.beY);
    }

    public void setScreen(int i, int i2) {
        if (this.beU != null) {
            this.beU.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.beU.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
        if (this.beX != null) {
            mHandler.postDelayed(this.beX, (long) this.beU.GT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bfa;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bfa = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bfa != null && (alaDynamicGiftAnimationView = this.bfa.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.beU.GS()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.beW > 4000 && alaDynamicGiftAnimationView.beY != null) {
                            alaDynamicGiftAnimationView.beY.GP();
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
        this.beU.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.beU != null) {
            this.beU.h(canvas);
        }
    }

    public void startAnim() {
        this.beW = System.currentTimeMillis();
        GN();
    }

    public void stopAnim() {
        if (mHandler != null && this.beX != null) {
            mHandler.removeCallbacks(this.beX);
        }
        this.beU.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.beV = aVar;
    }
}
