package com.baidu.baiduarsdk.filter;

import android.os.AsyncTask;
import com.baidu.baiduarsdk.filter.e;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends AsyncTask<List<com.baidu.baiduarsdk.filter.configdata.a>, Integer, Map<Integer, a>> {
    e.a<Map<Integer, a>> a;

    public c(e.a<Map<Integer, a>> aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Map<Integer, a> doInBackground(List<com.baidu.baiduarsdk.filter.configdata.a>... listArr) {
        return d.a(listArr[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Map<Integer, a> map) {
        if (this.a != null) {
            this.a.a(map);
        }
    }
}
