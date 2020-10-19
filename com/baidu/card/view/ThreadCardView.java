package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes21.dex */
public class ThreadCardView extends FrameLayout {
    private v alC;
    private boolean alD;
    private Runnable alE;
    private Runnable alF;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.alE = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.alD) {
                    if (ThreadCardView.this.alC != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alC, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.alD) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.alF = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.alC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alC, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alE = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.alD) {
                    if (ThreadCardView.this.alC != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alC, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.alD) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.alF = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.alC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alC, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alE = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.alD) {
                    if (ThreadCardView.this.alC != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alC, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof v) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.alD) {
                        CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.alF = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.alC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.alC, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(v vVar) {
        this.alC = vVar;
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
                this.alD = false;
                postDelayed(this.alE, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.alD = true;
                removeCallbacks(this.alE);
                CardLinkageManager.INSTANCE.pressLinkage(this.alC, this.mPosition, true);
                postDelayed(this.alF, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.alD = true;
                removeCallbacks(this.alE);
                removeCallbacks(this.alF);
                if (this.alC != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.alC, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof v) {
                    CardLinkageManager.INSTANCE.pressLinkage((v) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.alE);
        removeCallbacks(this.alF);
        super.onDetachedFromWindow();
    }
}
