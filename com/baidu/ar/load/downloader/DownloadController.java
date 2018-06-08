package com.baidu.ar.load.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.load.DownloadTask;
import com.baidu.ar.load.FileManageTask;
import com.baidu.ar.load.QueryTask;
import com.baidu.ar.load.downloader.IDownloadParamsParser;
import com.baidu.ar.load.util.DownloadConstants;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadController {
    private String A;
    private int B;
    private a c;
    private c d;
    private b e;
    private QueryTask.ExtraOperateListener h;
    private FileManageTask.ExtraOperateListener j;
    private QueryTask k;
    private DownloadTask l;
    private FileManageTask m;
    private String n;
    private String o;
    private int p;
    private String q;
    private IDownloadParamsParser r;
    private String s;
    private String t;
    private DownloadTask.FileStoreStrategy u;
    private String v;
    private int w;
    private String x;
    private boolean y;
    private FileManageTask.FileMergeStrategy z;
    private Object a = new Object();
    private STATE b = STATE.INITIAL;
    private boolean C = false;
    private List<ActionResponseListener<String>> f = new ArrayList();
    private List<ActionResponseListener<String>> g = new ArrayList();
    private List<ActionResponseListener<String>> i = new ArrayList();

    /* loaded from: classes3.dex */
    public enum EVENT {
        START_QUERY,
        START_DOWNLOAD,
        START_FILE_MANAGE
    }

    /* loaded from: classes3.dex */
    public enum STATE {
        INITIAL,
        QUERYING,
        QUERY_FINISH,
        QUERY_ERROR,
        DOWNLOADING,
        DOWNLOAD_FINISH,
        DOWNLOAD_ERROR,
        FILE_MANAGING,
        FILE_MANAGE_FINISH,
        FILE_MANAGE_ERROR,
        DONE
    }

    private void a(List<ActionResponseListener<String>> list, int i) {
        for (ActionResponseListener<String> actionResponseListener : list) {
            actionResponseListener.onProgress(i);
        }
    }

    private void a(List<ActionResponseListener<String>> list, String str) {
        for (ActionResponseListener<String> actionResponseListener : list) {
            actionResponseListener.onResponse(str);
        }
    }

    private void d(String str) {
        a(this.g, str);
        try {
            if (ResponseUtil.getIdFromResponse(str) != 0) {
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
                this.b = STATE.QUERY_ERROR;
            } else if (this.r == null) {
                this.b = STATE.DONE;
            } else {
                IDownloadParamsParser.DownloadParam parser = this.r.parser(new JSONObject(ResponseUtil.getHttpResultFromResponse(str)).toString());
                if (parser.mErrorCode != 0) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
                    this.b = STATE.QUERY_ERROR;
                    return;
                }
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_SUCCESS);
                if (!TextUtils.isEmpty(parser.mDownloadPath)) {
                    this.t = parser.mDownloadPath;
                }
                if (!TextUtils.isEmpty(parser.mFileManagePath)) {
                    this.x = parser.mFileManagePath;
                }
                e(parser.mDownloadUrl);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
            this.b = STATE.QUERY_ERROR;
        } catch (JSONException e2) {
            e2.printStackTrace();
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_QUERY_FAILURE);
            this.b = STATE.QUERY_ERROR;
        }
    }

    private void e(String str) {
        g();
        this.l = new DownloadTask(str, this.t, this.u, this.c);
        this.l.setParallel();
        this.l.start();
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_START_DOWNLOAD);
        this.b = STATE.DOWNLOADING;
    }

    private void f() {
        if (this.d == null) {
            this.d = new c(this);
        }
    }

    private void f(String str) {
        a(this.f, str);
        if (ResponseUtil.getIdFromResponse(str) == 0) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_DOWNLOAD_SUCCESS);
            j();
            return;
        }
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_DOWNLOAD_FAILURE);
        this.b = STATE.DOWNLOAD_ERROR;
    }

    private void g() {
        if (this.c == null) {
            this.c = new a(this);
        }
    }

    private void g(String str) {
        a(this.i, str);
        if (ResponseUtil.getIdFromResponse(str) == 0) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_FILE_MANAGE_SUCCESS);
            this.b = STATE.DONE;
            return;
        }
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_FILE_MANAGE_FAILURE);
        this.b = STATE.FILE_MANAGE_ERROR;
    }

    private void h() {
        if (this.e == null) {
            this.e = new b(this);
        }
    }

    private void i() {
        f();
        this.k = new QueryTask(this.n, this.o, this.p, this.d, this.h);
        this.k.setParallel();
        this.k.start();
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_START_QUERY);
        this.b = STATE.QUERYING;
    }

    private void j() {
        h();
        this.m = new FileManageTask(this.t, this.x, this.z, this.e, this.j);
        if (this.y) {
            this.m.setParallel();
        }
        this.m.start();
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOAD_START_FILE_MANAGE);
        this.b = STATE.FILE_MANAGING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        ARLog.e("bdar: onDownloadUpdateProgress = " + i);
        this.w = i;
        if (this.C) {
            a(this.f, this.w);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<com.baidu.ar.task.ActionResponseListener<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.List<com.baidu.ar.task.ActionResponseListener<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.List<com.baidu.ar.task.ActionResponseListener<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(EVENT event, Map<String, Object> map) {
        synchronized (this.a) {
            Bundle bundle = (Bundle) map.get(DownloadConstants.QUERY_INFO);
            if (bundle != null) {
                this.n = bundle.getString(DownloadConstants.QUERY_URL);
                this.o = bundle.getString(DownloadConstants.QUERY_PARAMS);
                this.p = bundle.getInt(DownloadConstants.QUERY_REQUEST_MODE);
            }
            this.r = (IDownloadParamsParser) map.get(DownloadConstants.DOWNLOAD_PARAMS_PARSER);
            this.s = (String) map.get(DownloadConstants.DOWNLOAD_URL);
            this.t = (String) map.get(DownloadConstants.DOWNLOAD_SAVE_PATH);
            this.u = (DownloadTask.FileStoreStrategy) map.get(DownloadConstants.FILE_STORE_STRATEGY);
            this.x = (String) map.get(DownloadConstants.TARGET_PATH);
            this.y = ((Boolean) map.get(DownloadConstants.USE_PARALLEL)).booleanValue();
            this.z = (FileManageTask.FileMergeStrategy) map.get(DownloadConstants.FILE_MERGE_STRATEGY);
            this.g.add(new WeakReference((ActionResponseListener) map.get(DownloadConstants.QUERY_CALLBACK)).get());
            this.h = (QueryTask.ExtraOperateListener) new WeakReference((QueryTask.ExtraOperateListener) map.get(DownloadConstants.QUERY_EXTRA_OPERATOR)).get();
            this.f.add(new WeakReference((ActionResponseListener) map.get(DownloadConstants.DOWNLOAD_CALLBACK)).get());
            this.i.add(new WeakReference((ActionResponseListener) map.get(DownloadConstants.FILE_MANAGE_CALLBACK)).get());
            this.j = (FileManageTask.ExtraOperateListener) new WeakReference((FileManageTask.ExtraOperateListener) map.get(DownloadConstants.FILE_MANAGE_EXTRA_OPERATOR)).get();
            switch (event) {
                case START_QUERY:
                    i();
                    break;
                case START_DOWNLOAD:
                    e(this.s);
                    break;
            }
        }
    }

    public void a(ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        synchronized (this.a) {
            this.g.remove(actionResponseListener);
            this.f.remove(actionResponseListener2);
            this.i.remove(actionResponseListener3);
            this.j = null;
            if (this.g.size() == 0 && this.f.size() == 0 && this.i.size() == 0) {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        synchronized (this.a) {
            this.q = str;
            this.b = STATE.QUERY_FINISH;
            if (this.C) {
                d(this.q);
            }
        }
    }

    public void a(boolean z) {
        this.C = z;
    }

    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = (this.b == STATE.DONE || this.b == STATE.QUERY_ERROR || this.b == STATE.DOWNLOAD_ERROR || this.b == STATE.FILE_MANAGE_ERROR) ? false : true;
        }
        return z;
    }

    public void b() {
        ARLog.e("bdar:DownloadController: when resume params = " + this.o);
        ARLog.e("bdar:DownloadController: when resume mCurrentState = " + this.b);
        synchronized (this.a) {
            switch (this.b) {
                case QUERYING:
                    if (this.k != null) {
                        this.k.resume();
                        break;
                    }
                    break;
                case QUERY_FINISH:
                    d(this.q);
                    break;
                case DOWNLOADING:
                    if (this.l != null) {
                        this.l.resume();
                        break;
                    }
                    break;
                case DOWNLOAD_FINISH:
                    f(this.v);
                    break;
                case FILE_MANAGING:
                    if (this.m != null) {
                        this.m.resume();
                        break;
                    }
                    break;
                case FILE_MANAGE_FINISH:
                    g(this.A);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        ARLog.e("bdar: onFileManageUpdateProgress = " + i);
        this.B = i;
        if (this.C) {
            a(this.i, this.B);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.List<com.baidu.ar.task.ActionResponseListener<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.List<com.baidu.ar.task.ActionResponseListener<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.List<com.baidu.ar.task.ActionResponseListener<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ActionResponseListener<String> actionResponseListener, ActionResponseListener<String> actionResponseListener2, ActionResponseListener<String> actionResponseListener3) {
        synchronized (this.a) {
            if (actionResponseListener != null) {
                this.g.add(new WeakReference(actionResponseListener).get());
            }
            if (actionResponseListener2 != null) {
                this.f.add(new WeakReference(actionResponseListener2).get());
            }
            if (actionResponseListener3 != null) {
                this.i.add(new WeakReference(actionResponseListener3).get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        synchronized (this.a) {
            this.v = str;
            this.b = STATE.DOWNLOAD_FINISH;
            if (this.C) {
                f(this.v);
            }
        }
    }

    public void c() {
        ARLog.e("bdar:DownloadController: when pause queryParams = " + this.o);
        ARLog.e("bdar:DownloadController: when pause mCurrentState = " + this.b);
        synchronized (this.a) {
            switch (this.b) {
                case QUERYING:
                    if (this.k != null) {
                        this.k.pause();
                        break;
                    }
                    break;
                case DOWNLOADING:
                    if (this.l != null) {
                        this.l.pause();
                        break;
                    }
                    break;
                case FILE_MANAGING:
                    if (this.m != null) {
                        this.m.pause();
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        synchronized (this.a) {
            this.A = str;
            this.b = STATE.FILE_MANAGE_FINISH;
            if (this.C) {
                g(this.A);
            }
        }
    }

    public void d() {
        synchronized (this.a) {
            this.g.clear();
            this.f.clear();
            this.i.clear();
            this.j = null;
            e();
        }
    }

    public void e() {
        ARLog.e("bdar:DownloadController: when cancel queryUrl = " + this.n);
        ARLog.e("bdar:DownloadController: when cancel queryParams = " + this.o);
        ARLog.e("bdar:DownloadController: when cancel mCurrentState = " + this.b);
        switch (this.b) {
            case QUERYING:
                if (this.k != null) {
                    this.k.cancel();
                    return;
                }
                return;
            case DOWNLOADING:
                if (this.l != null) {
                    this.l.cancel();
                    return;
                }
                return;
            case FILE_MANAGING:
                if (this.m != null) {
                    this.m.cancel();
                    return;
                }
                return;
            default:
                this.b = STATE.DONE;
                return;
        }
    }
}
