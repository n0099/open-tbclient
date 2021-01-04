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
    private s anl;
    private boolean anm;
    private Runnable ann;
    private Runnable ano;
    private int mPosition;
    private ViewGroup mViewGroup;

    public ThreadCardView(Context context) {
        super(context);
        this.ann = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.anm) {
                    if (ThreadCardView.this.anl != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anl, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.anm) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ano = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.anl != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anl, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ann = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.anm) {
                    if (ThreadCardView.this.anl != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anl, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.anm) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ano = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.anl != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anl, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public ThreadCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ann = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ThreadCardView.this.anm) {
                    if (ThreadCardView.this.anl != null) {
                        CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anl, ThreadCardView.this.mPosition, true);
                    } else if (ThreadCardView.this.mViewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, true);
                    }
                    if (ThreadCardView.this.anm) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                    }
                }
            }
        };
        this.ano = new Runnable() { // from class: com.baidu.card.view.ThreadCardView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadCardView.this.anl != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(ThreadCardView.this.anl, ThreadCardView.this.mPosition, false);
                } else if (ThreadCardView.this.mViewGroup instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) ThreadCardView.this.mViewGroup, ThreadCardView.this.mPosition, false);
                }
            }
        };
    }

    public void setITypeListView(s sVar) {
        this.anl = sVar;
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
                this.anm = false;
                postDelayed(this.ann, ViewConfiguration.getTapTimeout());
                break;
            case 1:
                this.anm = true;
                removeCallbacks(this.ann);
                CardLinkageManager.INSTANCE.pressLinkage(this.anl, this.mPosition, true);
                postDelayed(this.ano, ViewConfiguration.getTapTimeout());
                break;
            case 3:
                this.anm = true;
                removeCallbacks(this.ann);
                removeCallbacks(this.ano);
                if (this.anl != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.anl, this.mPosition, false);
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
        removeCallbacks(this.ann);
        removeCallbacks(this.ano);
        super.onDetachedFromWindow();
    }
}
