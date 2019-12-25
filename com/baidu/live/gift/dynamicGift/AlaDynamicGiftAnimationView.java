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
    private com.baidu.live.gift.dynamicGift.a aiT;
    private AlaDynamicGiftLayout.a aiU;
    private long aiV;
    private Runnable aiW;
    private a aiX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void bC(int i);

        void st();

        void su();
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aiX = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void st() {
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bC(int i) {
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void su() {
                AlaDynamicGiftAnimationView.this.aiT.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aiW != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aiW);
                }
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiX = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void st() {
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bC(int i) {
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void su() {
                AlaDynamicGiftAnimationView.this.aiT.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aiW != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aiW);
                }
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiX = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void st() {
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void bC(int i2) {
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void su() {
                AlaDynamicGiftAnimationView.this.aiT.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aiW != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aiW);
                }
                if (AlaDynamicGiftAnimationView.this.aiU != null) {
                    AlaDynamicGiftAnimationView.this.aiU.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aiW = new b(this);
        this.aiT = new com.baidu.live.gift.dynamicGift.a();
        this.aiT.a(this.aiX);
    }

    public void setScreen(int i, int i2) {
        if (this.aiT != null) {
            this.aiT.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aiT.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss() {
        if (this.aiW != null) {
            mHandler.postDelayed(this.aiW, (long) this.aiT.sy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aiZ;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aiZ = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aiZ != null && (alaDynamicGiftAnimationView = this.aiZ.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aiT.sx()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aiV > 4000 && alaDynamicGiftAnimationView.aiX != null) {
                            alaDynamicGiftAnimationView.aiX.su();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.ss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aiT.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aiT != null) {
            this.aiT.g(canvas);
        }
    }

    public void startAnim() {
        this.aiV = System.currentTimeMillis();
        ss();
    }

    public void stopAnim() {
        if (mHandler != null && this.aiW != null) {
            mHandler.removeCallbacks(this.aiW);
        }
        this.aiT.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aiU = aVar;
    }
}
