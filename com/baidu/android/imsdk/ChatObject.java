package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConfigInternal;
/* loaded from: classes.dex */
public class ChatObject {
    public static final long DEFAULT_PAID = -1;
    public static final int DEFAULT_TYPE = -1;
    public static final int MMD_TYPE = 1000;
    public int mCategory;
    public long mContacter;
    public Context mContext;
    public long mPaid;
    public int mType;

    public ChatObject(Context context, int i, long j, long j2, int i2) {
        this.mPaid = -1L;
        this.mType = -1;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
        this.mPaid = j2;
        this.mType = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatObject) {
            ChatObject chatObject = (ChatObject) obj;
            return this.mCategory == chatObject.mCategory && this.mContacter == chatObject.mContacter && this.mPaid == chatObject.mPaid && this.mType == chatObject.mType;
        }
        return false;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public long getPaid() {
        return this.mPaid;
    }

    public String getToken() {
        return IMConfigInternal.getInstance().getIMConfig(this.mContext).getToken(this);
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        return ((((((this.mCategory + 31) * 31) + ((int) this.mContacter)) * 31) + ((int) this.mPaid)) * 31) + this.mType;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public ChatObject setType(int i) {
        this.mType = i;
        return this;
    }

    public String toString() {
        return getToken();
    }

    public ChatObject(Context context, int i, long j) {
        this.mPaid = -1L;
        this.mType = -1;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
    }
}
