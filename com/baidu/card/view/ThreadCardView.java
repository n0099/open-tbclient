package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes.dex */
public class ThreadCardView extends FrameLayout {
    private s anC;
    private boolean anD;
    private Runnable anE;
    private Runnable anF;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.anE = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.anD) {
                    if (ThreadCardView.this.anC != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anC, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.anD) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.anF = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.anC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anC, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anE = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.anD) {
                    if (ThreadCardView.this.anC != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anC, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.anD) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.anF = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.anC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anC, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anE = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.anD) {
                    if (ThreadCardView.this.anC != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anC, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.anD) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.anF = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.anC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anC, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(s sVar) {
        this.anC = sVar;
    }

    public void setParent(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.anD = false;
                postDelayed(this.anE, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.anD = true;
                removeCallbacks(this.anE);
                CardLinkageManager.INSTANCE.pressLinkage(this.anC, this.mPosition, true);
                postDelayed(this.anF, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.anD = true;
                removeCallbacks(this.anE);
                removeCallbacks(this.anF);
                if (this.anC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.anC, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.anE);
        removeCallbacks(this.anF);
        super.onDetachedFromWindow();
    }
}
