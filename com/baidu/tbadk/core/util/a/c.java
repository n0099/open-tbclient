package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {
    public String mErrorString;
    public int mNetErrorCode;
    public int mServerErrorCode;
    public String mException = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean isNetSuccess() {
        return this.mNetErrorCode == 200;
    }

    public boolean isRequestSuccess() {
        return this.mNetErrorCode == 200 && this.mServerErrorCode == 0;
    }

    public boolean isFileSegSuccess() {
        return this.mNetErrorCode == 200 || this.mNetErrorCode == 206;
    }
}
