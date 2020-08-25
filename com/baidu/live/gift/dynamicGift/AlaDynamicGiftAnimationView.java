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
    private com.baidu.live.gift.dynamicGift.a aTk;
    private AlaDynamicGiftLayout.a aTl;
    private long aTm;
    private Runnable aTn;
    private a aTo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void Go();

        void Gp();

        void ej(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aTo = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Go() {
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ej(int i) {
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Gp() {
                AlaDynamicGiftAnimationView.this.aTk.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aTn);
                }
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTo = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Go() {
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ej(int i) {
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Gp() {
                AlaDynamicGiftAnimationView.this.aTk.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aTn);
                }
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTo = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Go() {
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void ej(int i2) {
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Gp() {
                AlaDynamicGiftAnimationView.this.aTk.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aTn != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aTn);
                }
                if (AlaDynamicGiftAnimationView.this.aTl != null) {
                    AlaDynamicGiftAnimationView.this.aTl.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTn = new b(this);
        this.aTk = new com.baidu.live.gift.dynamicGift.a();
        this.aTk.a(this.aTo);
    }

    public void setScreen(int i, int i2) {
        if (this.aTk != null) {
            this.aTk.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aTk.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gn() {
        if (this.aTn != null) {
            mHandler.postDelayed(this.aTn, (long) this.aTk.Gt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aTq;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aTq = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aTq != null && (alaDynamicGiftAnimationView = this.aTq.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aTk.Gs()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aTm > 4000 && alaDynamicGiftAnimationView.aTo != null) {
                            alaDynamicGiftAnimationView.aTo.Gp();
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
        this.aTk.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aTk != null) {
            this.aTk.g(canvas);
        }
    }

    public void startAnim() {
        this.aTm = System.currentTimeMillis();
        Gn();
    }

    public void stopAnim() {
        if (mHandler != null && this.aTn != null) {
            mHandler.removeCallbacks(this.aTn);
        }
        this.aTk.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aTl = aVar;
    }
}
