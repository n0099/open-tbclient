package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.os.Process;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.browser.core.util.BdUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    h f574a;
    final /* synthetic */ ScanDownloadFile b;
    private CharSequence c;

    public k(ScanDownloadFile scanDownloadFile, CharSequence charSequence) {
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
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(context);
        try {
            HttpResponse execute = proxyHttpClient.execute(new HttpGet(this.c.toString()));
            if (execute.getStatusLine().getStatusCode() == 200) {
                String entityUtils = EntityUtils.toString(execute.getEntity(), BdUtil.UTF8);
                if (!isInterrupted()) {
                    this.f574a = new h(this.b, new JSONArray(entityUtils));
                    this.f574a.start();
                }
            } else {
                Log.d("ScanDownloadFile", "request failed  " + execute.getStatusLine());
            }
        } catch (Exception e2) {
            Log.w("ScanDownloadFile", "error", e2);
        } finally {
            proxyHttpClient.close();
        }
    }
}
