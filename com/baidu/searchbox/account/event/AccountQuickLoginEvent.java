package com.baidu.searchbox.account.event;

import android.content.ContentValues;
import com.baidu.searchbox.NoProGuard;
/* loaded from: classes3.dex */
public class AccountQuickLoginEvent implements NoProGuard {
    public static final int EVENT_TYPE_QUICKVIEW_SHOW = 1;
    public static final String PARAM_SOURCE = "source";
    public int mEventType;
    public ContentValues mParams = new ContentValues();

    public ContentValues getAllParams() {
        return this.mParams;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public Object getParam(String str) {
        return this.mParams.get(str);
    }

    public void setEventType(int i) {
        this.mEventType = i;
    }

    public void putParam(String str, String str2) {
        if (this.mParams == null) {
            this.mParams = new ContentValues();
        }
        this.mParams.put(str, str2);
    }
}
