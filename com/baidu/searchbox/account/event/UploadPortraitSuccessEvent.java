package com.baidu.searchbox.account.event;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class UploadPortraitSuccessEvent {
    public Bitmap mBitmap;
    public boolean mIsDynamicAvatar;
    public String mMessage;
    public int mState;

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public boolean getDynamicAvatar() {
        return this.mIsDynamicAvatar;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getState() {
        return this.mState;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setDynamicAvatar(boolean z) {
        this.mIsDynamicAvatar = z;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setState(int i) {
        this.mState = i;
    }
}
