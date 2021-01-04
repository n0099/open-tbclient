package com.baidu.tbadk.core.util.b;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class g {
    public boolean mIsJson;
    public boolean mIsBaiduServer = true;
    public String charSet = "UTF-8";
    public String mUrl = null;
    public ArrayList<BasicNameValuePair> mPostData = null;
    public boolean mRequestGzip = true;
    public boolean mIsBDImage = false;
    public HashMap<String, byte[]> mFileData = null;
    public String mSeqId = null;
    public String mNetType = null;
    public String mFrom = null;

    public g() {
        this.mIsJson = true;
        this.mIsJson = true;
    }
}
