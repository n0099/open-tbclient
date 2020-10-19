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
    private com.baidu.live.gift.dynamicGift.a aYM;
    private AlaDynamicGiftLayout.a aYN;
    private long aYO;
    private Runnable aYP;
    private a aYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void HK();

        void HL();

        void es(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.aYQ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HK() {
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void es(int i) {
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HL() {
                AlaDynamicGiftAnimationView.this.aYM.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aYP != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aYP);
                }
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYQ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HK() {
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void es(int i) {
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HL() {
                AlaDynamicGiftAnimationView.this.aYM.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aYP != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aYP);
                }
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYQ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HK() {
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void es(int i2) {
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void HL() {
                AlaDynamicGiftAnimationView.this.aYM.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aYP != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aYP);
                }
                if (AlaDynamicGiftAnimationView.this.aYN != null) {
                    AlaDynamicGiftAnimationView.this.aYN.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aYP = new b(this);
        this.aYM = new com.baidu.live.gift.dynamicGift.a();
        this.aYM.a(this.aYQ);
    }

    public void setScreen(int i, int i2) {
        if (this.aYM != null) {
            this.aYM.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.aYM.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ() {
        if (this.aYP != null) {
            mHandler.postDelayed(this.aYP, (long) this.aYM.HP());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aYS;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aYS = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aYS != null && (alaDynamicGiftAnimationView = this.aYS.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.aYM.HO()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aYO > 4000 && alaDynamicGiftAnimationView.aYQ != null) {
                            alaDynamicGiftAnimationView.aYQ.HL();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.HJ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.aYM.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aYM != null) {
            this.aYM.g(canvas);
        }
    }

    public void startAnim() {
        this.aYO = System.currentTimeMillis();
        HJ();
    }

    public void stopAnim() {
        if (mHandler != null && this.aYP != null) {
            mHandler.removeCallbacks(this.aYP);
        }
        this.aYM.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.aYN = aVar;
    }
}
