package com.baidu.ala.player;

import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.helper.AlaLiveStreamCmdInfo;
/* loaded from: classes7.dex */
public class AlaLivePlayerData {
    public static final int INIT_STATUS = 0;
    public static final int MAX_VIDEO_BUFF_SIZE = 1048576;
    public static final int RUN_STATUS = 1;
    public static final int STOP_STATUS = 3;
    public volatile AlaLiveStreamCmdInfo.CmdParseResult mCmdInfo;
    public int mIndex;
    public String mPlayUrl;
    public volatile int mFastOpen = 0;
    public long mLastStreamTime = 0;
    public boolean mSurfaceCreated = false;
    public volatile boolean mHasAvailableVideoFrame = false;
    public volatile int mIsRun = 0;
    public byte[] mNativeVideoFrame = null;
    public AlaLiveDebugInfo mLiveDebugInfo = new AlaLiveDebugInfo();
    public AlaLiveBaseInfo mStartBaseInfo = new AlaLiveBaseInfo();

    public AlaLivePlayerData(int i) {
        this.mIndex = 0;
        this.mIndex = i;
    }
}
