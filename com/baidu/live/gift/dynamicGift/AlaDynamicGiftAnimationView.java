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
    private com.baidu.live.gift.dynamicGift.a baj;
    private AlaDynamicGiftLayout.a bak;
    private long bal;
    private Runnable bam;
    private a ban;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void If();

        void Ig();

        void et(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.ban = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void If() {
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Ig() {
                AlaDynamicGiftAnimationView.this.baj.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bam);
                }
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ban = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void If() {
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Ig() {
                AlaDynamicGiftAnimationView.this.baj.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bam);
                }
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ban = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void If() {
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void et(int i2) {
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void Ig() {
                AlaDynamicGiftAnimationView.this.baj.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bam != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bam);
                }
                if (AlaDynamicGiftAnimationView.this.bak != null) {
                    AlaDynamicGiftAnimationView.this.bak.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bam = new b(this);
        this.baj = new com.baidu.live.gift.dynamicGift.a();
        this.baj.a(this.ban);
    }

    public void setScreen(int i, int i2) {
        if (this.baj != null) {
            this.baj.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.baj.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ie() {
        if (this.bam != null) {
            mHandler.postDelayed(this.bam, (long) this.baj.Ik());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bap;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bap = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bap != null && (alaDynamicGiftAnimationView = this.bap.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.baj.Ij()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bal > 4000 && alaDynamicGiftAnimationView.ban != null) {
                            alaDynamicGiftAnimationView.ban.Ig();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.Ie();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.baj.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.baj != null) {
            this.baj.g(canvas);
        }
    }

    public void startAnim() {
        this.bal = System.currentTimeMillis();
        Ie();
    }

    public void stopAnim() {
        if (mHandler != null && this.bam != null) {
            mHandler.removeCallbacks(this.bam);
        }
        this.baj.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bak = aVar;
    }
}
