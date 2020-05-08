package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes8.dex */
public class ThreadCardView extends FrameLayout {
    private Runnable ahA;
    private Runnable ahB;
    private r ahy;
    private boolean ahz;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.ahA = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.ahz) {
                    if (ThreadCardView.this.ahy != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ahy, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.ahz) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ahB = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.ahy != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ahy, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahA = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.ahz) {
                    if (ThreadCardView.this.ahy != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ahy, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.ahz) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ahB = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.ahy != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ahy, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahA = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.ahz) {
                    if (ThreadCardView.this.ahy != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ahy, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.ahz) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ahB = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.ahy != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.ahy, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(r rVar) {
        this.ahy = rVar;
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
                this.ahz = false;
                postDelayed(this.ahA, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.ahz = true;
                removeCallbacks(this.ahA);
                CardLinkageManager.INSTANCE.pressLinkage(this.ahy, this.mPosition, true);
                postDelayed(this.ahB, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.ahz = true;
                removeCallbacks(this.ahA);
                removeCallbacks(this.ahB);
                if (this.ahy != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.ahy, this.mPosition, false);
                    break;
                } else if (this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) this.mViewGroup, this.mPosition, false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ahA);
        removeCallbacks(this.ahB);
        super.onDetachedFromWindow();
    }
}
