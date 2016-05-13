package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public interface t {
    void a(BasicNameValuePair basicNameValuePair);

    boolean a(String str, Handler handler, int i, int i2, int i3, boolean z);

    void c(String str, byte[] bArr);

    void dl();

    /* renamed from: do */
    void mo15do();

    void k(ArrayList<BasicNameValuePair> arrayList);

    void n(String str, String str2);

    ArrayList<BasicNameValuePair> tc();

    String td();

    byte[] te();

    String tf();

    String tg();
}
