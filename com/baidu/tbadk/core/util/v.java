package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public interface v {
    void a(BasicNameValuePair basicNameValuePair);

    boolean a(String str, Handler handler, int i, int i2, int i3, boolean z);

    void dJ();

    void g(String str, byte[] bArr);

    void o(String str, String str2);

    ArrayList<BasicNameValuePair> op();

    boolean oq();

    String or();

    byte[] os();

    String ot();

    String ou();

    void r(ArrayList<BasicNameValuePair> arrayList);
}
