package com.baidu.tbadk.core.util.httpNet;

import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class HttpResponse {
    public String mErrorString;
    public int mNetErrorCode;
    public int mServerErrorCode;
    public String mException = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean isFileSegSuccess() {
        int i2 = this.mNetErrorCode;
        return i2 == 200 || i2 == 206;
    }

    public boolean isNetSuccess() {
        return this.mNetErrorCode == 200;
    }

    public boolean isRequestSuccess() {
        return this.mNetErrorCode == 200 && this.mServerErrorCode == 0;
    }
}
