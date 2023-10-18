package com.baidu.searchbox.live.gesture;

import android.view.MotionEvent;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/gesture/ItemGestureListener;", "Lkotlin/Any;", "", "x", "y", "", "onDoubleTap", "(II)V", "Landroid/view/MotionEvent;", "e", "onDown", "(Landroid/view/MotionEvent;)V", "onLongPress", "onMove", "onSingleTap", "i", "onSlid", "(I)V", "onTouchCancel", "onTouchUp", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ItemGestureListener {
    void onDoubleTap(int i, int i2);

    void onDown(MotionEvent motionEvent);

    void onLongPress(MotionEvent motionEvent);

    void onMove(MotionEvent motionEvent);

    void onSingleTap(int i, int i2);

    void onSlid(int i);

    void onTouchCancel(MotionEvent motionEvent);

    void onTouchUp(MotionEvent motionEvent);
}
