package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AlaDynamicGiftAnimationView extends ImageView {
    private static Handler mHandler = new Handler();
    private long aZS;
    private Runnable aZT;
    private com.baidu.live.yuyingift.dynamicgift.a bOP;
    private AlaDynamicGiftLayout.a bOQ;
    private a bOR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void HX();

        void HY();

        void ep(int i);
    }

    public AlaDynamicGiftAnimationView(Context context) {
        super(context);
        this.bOR = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void HX() {
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void ep(int i) {
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void HY() {
                AlaDynamicGiftAnimationView.this.bOP.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aZT != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aZT);
                }
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOR = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void HX() {
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void ep(int i) {
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameUpdate(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void HY() {
                AlaDynamicGiftAnimationView.this.bOP.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aZT != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aZT);
                }
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOR = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.1
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void HX() {
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameStart();
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void ep(int i2) {
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameUpdate(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void HY() {
                AlaDynamicGiftAnimationView.this.bOP.release();
                if (AlaDynamicGiftAnimationView.mHandler != null && AlaDynamicGiftAnimationView.this.aZT != null) {
                    AlaDynamicGiftAnimationView.mHandler.removeCallbacks(AlaDynamicGiftAnimationView.this.aZT);
                }
                if (AlaDynamicGiftAnimationView.this.bOQ != null) {
                    AlaDynamicGiftAnimationView.this.bOQ.onFrameEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aZT = new b(this);
        this.bOP = new com.baidu.live.yuyingift.dynamicgift.a();
        this.bOP.a(this.bOR);
    }

    public void setScreen(int i, int i2) {
        if (this.bOP != null) {
            this.bOP.setScreen(i, i2);
        }
    }

    public void setData(com.baidu.live.gift.c cVar) {
        this.bOP.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HW() {
        if (this.aZT != null) {
            mHandler.postDelayed(this.aZT, (long) this.bOP.Ic());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        WeakReference<AlaDynamicGiftAnimationView> aZW;

        public b(AlaDynamicGiftAnimationView alaDynamicGiftAnimationView) {
            this.aZW = new WeakReference<>(alaDynamicGiftAnimationView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaDynamicGiftAnimationView alaDynamicGiftAnimationView;
            if (this.aZW != null && (alaDynamicGiftAnimationView = this.aZW.get()) != null) {
                try {
                    if (!alaDynamicGiftAnimationView.isShown() || !alaDynamicGiftAnimationView.bOP.Ib()) {
                        if (System.currentTimeMillis() - alaDynamicGiftAnimationView.aZS > 4000 && alaDynamicGiftAnimationView.bOR != null) {
                            alaDynamicGiftAnimationView.bOR.HY();
                        }
                    } else {
                        alaDynamicGiftAnimationView.postInvalidate();
                    }
                    alaDynamicGiftAnimationView.HW();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onDestroy() {
        stopAnim();
        this.bOP.release();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bOP != null) {
            this.bOP.g(canvas);
        }
    }

    public void startAnim() {
        this.aZS = System.currentTimeMillis();
        HW();
    }

    public void stopAnim() {
        if (mHandler != null && this.aZT != null) {
            mHandler.removeCallbacks(this.aZT);
        }
        this.bOP.release();
    }

    public void setFrameCallback(AlaDynamicGiftLayout.a aVar) {
        this.bOQ = aVar;
    }
}
