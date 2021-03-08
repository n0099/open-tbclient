package com.baidu.ala.rtc;

import android.content.Context;
import com.baidu.rtc.BaiduRtcRoom;
/* loaded from: classes10.dex */
public abstract class BaseRtcRoom {
    protected String mAppId;
    protected BaiduRtcRoom mBaiduRtcRoom;
    protected Context mContext;
    protected boolean mIsAutoPublish;
    protected boolean mIsAutoSubScribe;
    protected String mRoomName;
    protected RtcRoomListener mRtcRoomListener;
    protected String mToken;
    protected long mUid;
    protected String mUserName;

    protected abstract void initAndLoginRtcRoom(boolean z);

    public BaseRtcRoom(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loginRtcRoom(String str, long j, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        this.mRoomName = str;
        this.mAppId = str3;
        this.mUid = j;
        this.mUserName = str2;
        this.mToken = str4;
        this.mIsAutoSubScribe = z2;
        this.mIsAutoPublish = z;
        initAndLoginRtcRoom(z3);
    }

    public void setRtcRoomListener(RtcRoomListener rtcRoomListener) {
        this.mRtcRoomListener = rtcRoomListener;
    }

    public boolean logoutRoom() {
        if (this.mBaiduRtcRoom != null) {
            try {
                this.mBaiduRtcRoom.logoutRtcRoom();
                this.mBaiduRtcRoom.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
