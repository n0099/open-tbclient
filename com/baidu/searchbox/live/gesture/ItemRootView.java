package com.baidu.searchbox.live.gesture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.util.ImmersionUtils;
/* loaded from: classes4.dex */
public class ItemRootView extends FrameLayout {
    public int downY;
    public boolean isInterceptAllTouch;
    public ItemGestureListener listener;
    public GestureDetector mGestureDetector;

    /* loaded from: classes4.dex */
    public static class SimpleGestureListener implements ItemGestureListener {
        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onDoubleTap(int i, int i2) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onDown(@Nullable MotionEvent motionEvent) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onLongPress(@Nullable MotionEvent motionEvent) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onMove(@Nullable MotionEvent motionEvent) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onSingleTap(int i, int i2) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onSlid(int i) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onTouchCancel(@Nullable MotionEvent motionEvent) {
        }

        @Override // com.baidu.searchbox.live.gesture.ItemGestureListener
        public void onTouchUp(@Nullable MotionEvent motionEvent) {
        }
    }

    public ItemRootView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.live.gesture.ItemRootView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (ItemRootView.this.listener != null) {
                    ItemRootView.this.listener.onDoubleTap(x, y);
                }
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (ItemRootView.this.listener != null) {
                    ItemRootView.this.listener.onDown(motionEvent);
                }
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (ItemRootView.this.listener != null) {
                    ItemRootView.this.listener.onLongPress(motionEvent);
                }
                super.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (ItemRootView.this.listener != null) {
                    ItemRootView.this.listener.onSingleTap(x, y);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isInterceptAllTouch) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setGestureListener(ItemGestureListener itemGestureListener) {
        this.listener = itemGestureListener;
    }

    public void setInterceptAllTouchEvent(boolean z) {
        this.isInterceptAllTouch = z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ItemGestureListener itemGestureListener;
        ItemGestureListener itemGestureListener2;
        if (this.isInterceptAllTouch) {
            return true;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.downY = (int) motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            ItemGestureListener itemGestureListener3 = this.listener;
            if (itemGestureListener3 != null) {
                itemGestureListener3.onMove(motionEvent);
            }
        } else if (motionEvent.getAction() == 1) {
            if (Math.abs(((int) motionEvent.getY()) - this.downY) > ImmersionUtils.dp2px(3.0f) && (itemGestureListener2 = this.listener) != null) {
                itemGestureListener2.onSlid(0);
            }
            ItemGestureListener itemGestureListener4 = this.listener;
            if (itemGestureListener4 != null) {
                itemGestureListener4.onTouchUp(motionEvent);
            }
        } else if (motionEvent.getAction() == 3 && (itemGestureListener = this.listener) != null) {
            itemGestureListener.onTouchCancel(motionEvent);
        }
        return true;
    }
}
