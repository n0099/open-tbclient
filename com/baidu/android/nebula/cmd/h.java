package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Thread {
    e a;
    final /* synthetic */ ScanDownloadFile b;
    private CharSequence c;

    public h(ScanDownloadFile scanDownloadFile, CharSequence charSequence) {
        String str;
        this.b = scanDownloadFile;
        StringBuilder sb = new StringBuilder();
        str = scanDownloadFile.mFileName;
        setName(sb.append(str).append("_moplus_getdownloadinfo_thread").toString());
        this.c = charSequence;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        long j;
        Process.setThreadPriority(19);
        try {
            j = this.b.mScanedOneTime;
            sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context = this.b.mContext;
        com.baidu.android.nebula.a.a aVar = new com.baidu.android.nebula.a.a(context);
        try {
            HttpResponse execute = aVar.execute(new HttpGet(this.c.toString()));
            if (execute.getStatusLine().getStatusCode() == 200) {
                String entityUtils = EntityUtils.toString(execute.getEntity(), "utf-8");
                if (!isInterrupted()) {
                    this.a = new e(this.b, new JSONArray(entityUtils));
                    this.a.start();
                }
            } else {
                Log.d("ScanDownloadFile", "request failed  " + execute.getStatusLine());
            }
        } catch (Exception e2) {
            Log.w("ScanDownloadFile", "error", e2);
        } finally {
            aVar.a();
        }
    }
}
