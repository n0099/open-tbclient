package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConfigInternal;
/* loaded from: classes6.dex */
public class ChatObject {
    public static final long DEFAULT_PAID = -1;
    public static final int DEFAULT_TYPE = -1;
    public static final int MMD_TYPE = 1000;
    private int mCategory;
    private long mContacter;
    private Context mContext;
    private long mPaid;
    private int mType;

    public ChatObject(Context context, int i, long j, long j2, int i2) {
        this.mPaid = -1L;
        this.mType = -1;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
        this.mPaid = j2;
        this.mType = i2;
    }

    public ChatObject(Context context, int i, long j) {
        this.mPaid = -1L;
        this.mType = -1;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
    }

    public ChatObject setType(int i) {
        this.mType = i;
        return this;
    }

    public String getToken() {
        return IMConfigInternal.getInstance().getIMConfig(this.mContext).getToken(this);
    }

    public int hashCode() {
        return ((((((this.mCategory + 31) * 31) + ((int) this.mContacter)) * 31) + ((int) this.mPaid)) * 31) + this.mType;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatObject) {
            ChatObject chatObject = (ChatObject) obj;
            if (this.mCategory != chatObject.mCategory || this.mContacter != chatObject.mContacter || this.mPaid != chatObject.mPaid || this.mType != chatObject.mType) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public String toString() {
        return getToken();
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

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public int getType() {
        return this.mType;
    }
}
