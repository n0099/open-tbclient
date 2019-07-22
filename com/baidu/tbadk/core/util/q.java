package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public interface q {
    void a(BasicNameValuePair basicNameValuePair);

    boolean a(String str, Handler handler, int i, int i2, int i3, boolean z);

    ArrayList<BasicNameValuePair> aif();

    String aig();

    byte[] aih();

    String aii();

    String aij();

    void d(String str, byte[] bArr);

    void ik();

    void in();

    void o(String str, String str2);

    void u(ArrayList<BasicNameValuePair> arrayList);
}
