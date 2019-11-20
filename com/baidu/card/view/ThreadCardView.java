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
    private r Iu;
    private boolean Iv;
    private Runnable Iw;
    private Runnable Ix;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.Iw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.Iv) {
                    if (ThreadCardView.this.Iu != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.Iu, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.Iv) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.Ix = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.Iu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.Iu, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Iw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.Iv) {
                    if (ThreadCardView.this.Iu != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.Iu, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.Iv) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.Ix = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.Iu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.Iu, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Iw = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.Iv) {
                    if (ThreadCardView.this.Iu != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.Iu, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof r) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.Iv) {
                        CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.Ix = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.Iu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.Iu, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof r) {
                    CardLinkageManager.INSTANCE.pressLinkage((r) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(r rVar) {
        this.Iu = rVar;
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
                this.Iv = false;
                postDelayed(this.Iw, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.Iv = true;
                removeCallbacks(this.Iw);
                CardLinkageManager.INSTANCE.pressLinkage(this.Iu, this.mPosition, true);
                postDelayed(this.Ix, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.Iv = true;
                removeCallbacks(this.Iw);
                removeCallbacks(this.Ix);
                if (this.Iu != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.Iu, this.mPosition, false);
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
        removeCallbacks(this.Iw);
        removeCallbacks(this.Ix);
        super.onDetachedFromWindow();
    }
}
