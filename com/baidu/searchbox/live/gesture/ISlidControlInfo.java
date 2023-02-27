package com.baidu.searchbox.live.gesture;

import android.content.Context;
import com.baidu.searchbox.live.util.ListExtKt;
/* loaded from: classes2.dex */
public interface ISlidControlInfo {
    int getLeftDivision();

    int getLeftMaxOffset();

    int getRightDivision();

    int getRightMaxOffset();

    boolean hasLeftSlidOut();

    boolean hasRightSlidIn();

    boolean isEnable();

    boolean isSlideRecover();

    /* loaded from: classes2.dex */
    public static class SimpleControlInfo implements ISlidControlInfo {
        public final Context context;

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean hasLeftSlidOut() {
            return false;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean hasRightSlidIn() {
            return false;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean isEnable() {
            return true;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean isSlideRecover() {
            return true;
        }

        public SimpleControlInfo(Context context) {
            this.context = context;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getLeftDivision() {
            if (ListExtKt.isDynamicDisplay(this.context)) {
                return ListExtKt.getDisplayWidth(this.context) / 4;
            }
            return ListExtKt.getDisplayWidth() / 4;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getLeftMaxOffset() {
            if (ListExtKt.isDynamicDisplay(this.context)) {
                return ListExtKt.getDisplayWidth(this.context);
            }
            return ListExtKt.getDisplayWidth();
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getRightDivision() {
            return (int) (ListExtKt.getDisplayWidth() * 0.41f);
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getRightMaxOffset() {
            return (int) ((-ListExtKt.getDisplayWidth()) * 0.82f);
        }
    }
}
