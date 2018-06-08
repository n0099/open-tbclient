package com.baidu.baiduarsdk.filter;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.e;
/* loaded from: classes3.dex */
public class b extends AsyncTask<String, Integer, com.baidu.baiduarsdk.filter.configdata.c> {
    e.a<com.baidu.baiduarsdk.filter.configdata.c> a;

    public b(e.a<com.baidu.baiduarsdk.filter.configdata.c> aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.baiduarsdk.filter.configdata.c doInBackground(String... strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.a(str, com.baidu.baiduarsdk.util.a.a(str.concat(str2)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.baiduarsdk.filter.configdata.c cVar) {
        if (this.a != null) {
            this.a.a(cVar);
        }
    }
}
