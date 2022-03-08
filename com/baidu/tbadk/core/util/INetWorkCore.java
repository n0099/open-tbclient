package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public interface INetWorkCore {
    public static final int DEFAULT_MAX_RETRY_COUNT = 5;
    public static final int DEFAULT_RETRY_INTERVAL = 100;

    void addPostData(String str, String str2);

    void addPostData(String str, byte[] bArr);

    void addPostData(BasicNameValuePair basicNameValuePair);

    void cancelNetConnect();

    boolean downloadFile(String str, Handler handler, int i2, int i3, int i4, boolean z);

    byte[] getNetData();

    String getNetString();

    ArrayList<BasicNameValuePair> getPostData();

    String getSeqId();

    boolean isCancel();

    String postMultiNetData();

    String postNetData();

    void setCancel();

    void setIsBaiduServer(boolean z);

    void setPostData(ArrayList<BasicNameValuePair> arrayList);
}
