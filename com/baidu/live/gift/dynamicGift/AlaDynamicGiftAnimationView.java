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
    private com.baidu.live.gift.dynamicGift.a bal;
    private AlaDynamicGiftLayout.a bam;
    private long ban;
    private Runnable bao;
    private a bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void Fv();

        void Fw();

        void dc(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bap = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Fv() {
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void dc(int i) {
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Fw() {
                AlaDynamicGiftAnimationView.this.bal.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bao != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bao);
                }
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bap = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Fv() {
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void dc(int i) {
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Fw() {
                AlaDynamicGiftAnimationView.this.bal.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bao != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bao);
                }
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bap = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Fv() {
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void dc(int i2) {
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Fw() {
                AlaDynamicGiftAnimationView.this.bal.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bao != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bao);
                }
                if (AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.this.bam.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bao = new b(this);
        this.bal = new com.baidu.live.gift.dynamicGift.a();
        this.bal.a(this.bap);
    }

    public void setScreen(int i, int i2) {
        if (this.bal != null) {
            this.bal.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bal.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fu() {
        if (this.bao != null) {
            mHandler.postDelayed(this.bao, (long) this.bal.FA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bas;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bas = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bas != null && (alaDynamicGiftAnimationView = this.bas.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bal.Fz()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.ban > 4000 && alaDynamicGiftAnimationView.bap != null) {
                            alaDynamicGiftAnimationView.bap.Fw();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Fu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bal.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bal != null) {
            this.bal.h(canvas);
        }
    }

    public void startAnim() {
        this.ban = System.currentTimeMillis();
        Fu();
    }

    public void stopAnim() {
        if (mHandler != null && this.bao != null) {
            mHandler.removeCallbacks(this.bao);
        }
        this.bal.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bam = aVar;
    }
}
