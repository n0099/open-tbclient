package com.baidu.searchbox.live.gesture;
/* loaded from: classes4.dex */
public interface OnGestureListener {

    /* loaded from: classes4.dex */
    public static class SimpleOnGestureListener implements OnGestureListener {
        @Override // com.baidu.searchbox.live.gesture.OnGestureListener
        public void onCloseEvent() {
        }

        @Override // com.baidu.searchbox.live.gesture.OnGestureListener
        public void onLeftMove(int i, int i2) {
        }

        @Override // com.baidu.searchbox.live.gesture.OnGestureListener
        public void onRightMove(int i, int i2) {
        }
    }

    void onCloseEvent();

    void onLeftMove(int i, int i2);

    void onRightMove(int i, int i2);
}
