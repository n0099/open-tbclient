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
    private com.baidu.live.gift.dynamicGift.a aNX;
    private AlaDynamicGiftLayout.a aNY;
    private long aNZ;
    private Runnable aOa;
    private a aOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void AL();

        void AM();

        void cu(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aOb = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void AL() {
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void cu(int i) {
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void AM() {
                AlaDynamicGiftAnimationView.this.aNX.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aOa != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aOa);
                }
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOb = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void AL() {
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void cu(int i) {
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void AM() {
                AlaDynamicGiftAnimationView.this.aNX.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aOa != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aOa);
                }
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOb = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void AL() {
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void cu(int i2) {
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void AM() {
                AlaDynamicGiftAnimationView.this.aNX.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aOa != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aOa);
                }
                if (AlaDynamicGiftAnimationView.this.aNY != null) {
                    AlaDynamicGiftAnimationView.this.aNY.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aOa = new b(this);
        this.aNX = new com.baidu.live.gift.dynamicGift.a();
        this.aNX.a(this.aOb);
    }

    public void setScreen(int i, int i2) {
        if (this.aNX != null) {
            this.aNX.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aNX.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        if (this.aOa != null) {
            mHandler.postDelayed(this.aOa, (long) this.aNX.AQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aOd;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aOd = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aOd != null && (alaDynamicGiftAnimationView = this.aOd.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aNX.AP()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aNZ > 4000 && alaDynamicGiftAnimationView.aOb != null) {
                            alaDynamicGiftAnimationView.aOb.AM();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.AK();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aNX.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aNX != null) {
            this.aNX.g(canvas);
        }
    }

    public void startAnim() {
        this.aNZ = System.currentTimeMillis();
        AK();
    }

    public void stopAnim() {
        if (mHandler != null && this.aOa != null) {
            mHandler.removeCallbacks(this.aOa);
        }
        this.aNX.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aNY = aVar;
    }
}
