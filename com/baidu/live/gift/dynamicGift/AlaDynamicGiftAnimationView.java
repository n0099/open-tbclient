package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private com.baidu.live.gift.dynamicGift.a aTm;
    private AlaDynamicGiftLayout.a aTn;
    private long aTo;
    private Runnable aTp;
    private a aTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void Go();

        void Gp();

        void ej(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aTq = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Go() {
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ej(int i) {
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Gp() {
                AlaDynamicGiftAnimationView.this.aTm.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aTp != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aTp);
                }
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTq = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Go() {
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ej(int i) {
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Gp() {
                AlaDynamicGiftAnimationView.this.aTm.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aTp != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aTp);
                }
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTq = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Go() {
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ej(int i2) {
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Gp() {
                AlaDynamicGiftAnimationView.this.aTm.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aTp != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aTp);
                }
                if (AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.this.aTn.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTp = new b(this);
        this.aTm = new com.baidu.live.gift.dynamicGift.a();
        this.aTm.a(this.aTq);
    }

    public void setScreen(int i, int i2) {
        if (this.aTm != null) {
            this.aTm.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aTm.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gn() {
        if (this.aTp != null) {
            mHandler.postDelayed(this.aTp, (long) this.aTm.Gt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aTs;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aTs = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aTs != null && (alaDynamicGiftAnimationView = this.aTs.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aTm.Gs()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aTo > 4000 && alaDynamicGiftAnimationView.aTq != null) {
                            alaDynamicGiftAnimationView.aTq.Gp();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Gn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aTm.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aTm != null) {
            this.aTm.g(canvas);
        }
    }

    public void startAnim() {
        this.aTo = System.currentTimeMillis();
        Gn();
    }

    public void stopAnim() {
        if (mHandler != null && this.aTp != null) {
            mHandler.removeCallbacks(this.aTp);
        }
        this.aTm.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aTn = aVar;
    }
}
