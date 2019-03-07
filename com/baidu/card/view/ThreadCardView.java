package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.card.CardLinkageManager;
/* loaded from: classes3.dex */
public class ThreadCardView extends FrameLayout {
    private r aaJ;
    private boolean aaK;
    private Runnable aaL;
    private Runnable aaM;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.aaL = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aaK) {
                    if (ThreadCardView.this.aaJ != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aaJ, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aaK) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aaM = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.aaJ != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aaJ, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaL = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aaK) {
                    if (ThreadCardView.this.aaJ != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aaJ, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aaK) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aaM = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.aaJ != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aaJ, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaL = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.aaK) {
                    if (ThreadCardView.this.aaJ != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aaJ, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.aaK) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.aaM = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.aaJ != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.aaJ, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(r rVar) {
        this.aaJ = rVar;
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
                this.aaK = false;
                postDelayed(this.aaL, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.aaK = true;
                removeCallbacks(this.aaL);
                CardLinkageManager.INSTANCE.pressLinkage(this.aaJ, this.mPosition, true);
                postDelayed(this.aaM, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.aaK = true;
                removeCallbacks(this.aaL);
                removeCallbacks(this.aaM);
                if (this.aaJ != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.aaJ, this.mPosition, false);
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
        removeCallbacks(this.aaL);
        removeCallbacks(this.aaM);
        super.onDetachedFromWindow();
    }
}
