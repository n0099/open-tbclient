package com.baidu.searchbox.suspensionwindow;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.baidu.searchbox.suspensionwindow.util.DeviceUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public class SuspensionWindow {
    private static Builder mBuilder;
    private static Map<String, IFloatWindow> mFloatWindowMap;

    private SuspensionWindow() {
    }

    public static IFloatWindow get(@NonNull String str) {
        if (mFloatWindowMap == null) {
            return null;
        }
        return mFloatWindowMap.get(str);
    }

    @MainThread
    public static Builder with(@NonNull Context context, @NonNull String str) {
        Builder builder = new Builder(context, str);
        mBuilder = builder;
        return builder;
    }

    public static void destroy(String str) {
        if (mFloatWindowMap != null && mFloatWindowMap.containsKey(str)) {
            mFloatWindowMap.get(str).dismiss();
            mFloatWindowMap.remove(str);
            if (mBuilder != null && mBuilder.mSuspensionListener != null) {
                mBuilder.mSuspensionListener.onStateChange(str, 4);
            }
        }
    }

    public static void destroyAll() {
        if (mFloatWindowMap != null && !mFloatWindowMap.isEmpty()) {
            for (String str : mFloatWindowMap.keySet()) {
                destroy(str);
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class Builder {
        Context mApplicationContext;
        View[] mBarriers;
        int mBottomPadding;
        int mLeftPadding;
        int mRightPadding;
        int mSpacing;
        SuspensionListener mSuspensionListener;
        String mTag;
        int mTopPadding;
        View mView;
        float mXOffset;
        float mYOffset;
        int mWidth = -2;
        int mHeight = -2;
        int mGravity = 8388659;
        long mDuration = 200;
        TimeInterpolator mInterpolator = new DecelerateInterpolator();

        Builder(@NonNull Context context, @NonNull String str) {
            this.mApplicationContext = context;
            this.mTag = str;
        }

        public Builder setView(@NonNull View view) {
            this.mView = view;
            return this;
        }

        public Builder setWidth(int i) {
            this.mWidth = i;
            return this;
        }

        public Builder setWidth(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mWidth = (int) (screenHeight * f);
            return this;
        }

        public Builder setHeight(int i) {
            this.mHeight = i;
            return this;
        }

        public Builder setHeight(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mHeight = (int) (screenHeight * f);
            return this;
        }

        public Builder setX(int i) {
            this.mXOffset = i;
            return this;
        }

        public Builder setX(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mXOffset = (int) (screenHeight * f);
            return this;
        }

        public Builder setY(int i) {
            this.mYOffset = i;
            return this;
        }

        public Builder setY(int i, float f) {
            int screenHeight;
            if (i == 0) {
                screenHeight = DeviceUtil.getScreenWidth(this.mApplicationContext);
            } else {
                screenHeight = DeviceUtil.getScreenHeight(this.mApplicationContext);
            }
            this.mYOffset = (int) (screenHeight * f);
            return this;
        }

        public Builder setSpacing(int i) {
            this.mSpacing = Math.max(i, 0);
            return this;
        }

        public Builder setPadding(int i, int i2, int i3, int i4) {
            this.mLeftPadding = i;
            this.mTopPadding = i2;
            this.mRightPadding = i3;
            this.mBottomPadding = i4;
            return this;
        }

        public Builder setMoveStyle(long j, @Nullable TimeInterpolator timeInterpolator) {
            this.mDuration = j;
            this.mInterpolator = timeInterpolator;
            return this;
        }

        public Builder setBarriers(View... viewArr) {
            this.mBarriers = viewArr;
            return this;
        }

        public Builder setSuspensionListener(SuspensionListener suspensionListener) {
            this.mSuspensionListener = suspensionListener;
            return this;
        }

        public void build() {
            if (SuspensionWindow.mFloatWindowMap == null) {
                Map unused = SuspensionWindow.mFloatWindowMap = new HashMap();
            }
            if (!SuspensionWindow.mFloatWindowMap.containsKey(this.mTag) && this.mView != null) {
                SuspensionWindow.mFloatWindowMap.put(this.mTag, new IFloatWindowImpl(this));
                if (this.mSuspensionListener != null) {
                    this.mSuspensionListener.onStateChange(this.mTag, 3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setTag(@NonNull String str) {
            IFloatWindow iFloatWindow;
            if (SuspensionWindow.mFloatWindowMap != null && !TextUtils.equals(str, this.mTag) && (iFloatWindow = (IFloatWindow) SuspensionWindow.mFloatWindowMap.get(this.mTag)) != null) {
                SuspensionWindow.mFloatWindowMap.remove(this.mTag);
                SuspensionWindow.mFloatWindowMap.put(str, iFloatWindow);
                this.mTag = str;
            }
        }
    }
}
