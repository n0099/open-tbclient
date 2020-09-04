package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public interface s {
    void addPostData(String str, String str2);

    void addPostData(String str, byte[] bArr);

    void addPostData(BasicNameValuePair basicNameValuePair);

    void cancelNetConnect();

    boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z);

    byte[] getNetData();

    String getNetString();

    ArrayList<BasicNameValuePair> getPostData();

    String postMultiNetData();

    String postNetData();

    void setCancel();

    void setPostData(ArrayList<BasicNameValuePair> arrayList);
}
