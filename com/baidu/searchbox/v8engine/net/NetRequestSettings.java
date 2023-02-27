package com.baidu.searchbox.v8engine.net;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.v8engine.NotProguard;
@NotProguard
/* loaded from: classes3.dex */
public class NetRequestSettings {
    public int mTimeout = 60000;
    public long mUploadDataLimit = Config.FULL_TRACE_LOG_LIMIT;
    public boolean mLoadDoNotSendCookies = false;
    public boolean mShouldNeverClearReferer = false;
    public boolean mEnableEncodingInNetThread = false;
    public boolean mEnableEncodingUsingGURLLibrary = false;
}
