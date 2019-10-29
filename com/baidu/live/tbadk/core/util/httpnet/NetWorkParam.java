package com.baidu.live.tbadk.core.util.httpnet;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class NetWorkParam {
    public boolean mIsJson;
    public boolean mIsBaiduServer = true;
    public String charSet = HTTP.UTF_8;
    public String mUrl = null;
    public ArrayList<BasicNameValuePair> mPostData = null;
    public boolean mRequestGzip = true;
    public boolean mIsBDImage = false;
    public HashMap<String, byte[]> mFileData = null;
    public String mSeqId = null;
    public String mNetType = null;
    public String mFrom = null;

    public NetWorkParam() {
        this.mIsJson = true;
        this.mIsJson = true;
    }
}
