package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public interface q {
    ArrayList<BasicNameValuePair> Ca();

    String Cb();

    byte[] Cc();

    String Cd();

    String Ce();

    void a(BasicNameValuePair basicNameValuePair);

    boolean a(String str, Handler handler, int i, int i2, int i3, boolean z);

    void d(String str, byte[] bArr);

    void m(ArrayList<BasicNameValuePair> arrayList);

    void mS();

    void mV();

    void n(String str, String str2);
}
