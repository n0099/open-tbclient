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
    private com.baidu.live.gift.dynamicGift.a bbC;
    private AlaDynamicGiftLayout.a bbD;
    private long bbE;
    private Runnable bbF;
    private a bbG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void IG();

        void IH();

        void et(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bbG = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void IG() {
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void IH() {
                AlaDynamicGiftAnimationView.this.bbC.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bbF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bbF);
                }
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbG = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void IG() {
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void et(int i) {
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void IH() {
                AlaDynamicGiftAnimationView.this.bbC.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bbF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bbF);
                }
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbG = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void IG() {
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameStart();
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void et(int i2) {
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftAnimationView.a
            public void IH() {
                AlaDynamicGiftAnimationView.this.bbC.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.bbF != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.bbF);
                }
                if (AlaDynamicGiftAnimationView.this.bbD != null) {
                    AlaDynamicGiftAnimationView.this.bbD.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bbF = new b(this);
        this.bbC = new com.baidu.live.gift.dynamicGift.a();
        this.bbC.a(this.bbG);
    }

    public void setScreen(int i, int i2) {
        if (this.bbC != null) {
            this.bbC.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bbC.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        if (this.bbF != null) {
            mHandler.postDelayed(this.bbF, (long) this.bbC.IL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> bbI;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.bbI = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.bbI != null && (alaDynamicGiftAnimationView = this.bbI.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bbC.IK()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.bbE > 4000 && alaDynamicGiftAnimationView.bbG != null) {
                            alaDynamicGiftAnimationView.bbG.IH();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.IF();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bbC.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bbC != null) {
            this.bbC.g(canvas);
        }
    }

    public void startAnim() {
        this.bbE = System.currentTimeMillis();
        IF();
    }

    public void stopAnim() {
        if (mHandler != null && this.bbF != null) {
            mHandler.removeCallbacks(this.bbF);
        }
        this.bbC.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bbD = aVar;
    }
}
