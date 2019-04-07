package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public interface q {
    void a(BasicNameValuePair basicNameValuePair);

    boolean a(String str, Handler handler, int i, int i2, int i3, boolean z);

    ArrayList<BasicNameValuePair> acf();

    String acg();

    byte[] ach();

    String aci();

    String acj();

    void d(String str, byte[] bArr);

    void ji();

    void jl();

    void r(ArrayList<BasicNameValuePair> arrayList);

    void x(String str, String str2);
}
