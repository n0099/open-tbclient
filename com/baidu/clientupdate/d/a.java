package com.baidu.clientupdate.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.AppInfo;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.util.LogUtil;
import com.heytap.mcssdk.mode.Message;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1328a = null;
    private Context b;
    private BroadcastReceiver e;
    private com.baidu.clientupdate.c.a h;
    private com.baidu.clientupdate.a.d i;
    private ClientUpdateInfo c = null;
    private RuleInfo d = null;
    private boolean f = false;
    private String g = null;

    private a(Context context) {
        this.b = context;
        this.i = com.baidu.clientupdate.a.d.a(this.b);
        this.h = com.baidu.clientupdate.c.a.a(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f1328a == null) {
                f1328a = new a(context);
            }
            aVar = f1328a;
        }
        return aVar;
    }

    private void a(AppInfo appInfo, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    str = file2.getAbsolutePath();
                    LogUtil.logE("ClientUpdateUtility", "savapath=====" + str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mDownurl;
        download.mMimeType = "application/vnd.android.package-archive";
        download.mSourceKey = appInfo.mPackageName + UgcConstant.AT_RULE_TAG + appInfo.mVercode;
        DownloadManager.getInstance(this.b).start(download);
    }

    private void a(AppInfo appInfo, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    str = file2.getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mDownurl;
        download.mMimeType = "application/vnd.android.package-archive";
        download.mSourceKey = appInfo.mPackageName + UgcConstant.AT_RULE_TAG + appInfo.mVercode;
        DownloadManager.getInstance(this.b).start(download, z);
    }

    private void b(AppInfo appInfo, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    str = file2.getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mPatchDownUrl;
        download.mMimeType = "patch";
        download.mSourceKey = appInfo.mPackageName + UgcConstant.AT_RULE_TAG + appInfo.mVercode;
        DownloadManager.getInstance(this.b).start(download);
    }

    public static void e() {
        synchronized (a.class) {
            if (f1328a != null && f1328a.e != null) {
                f1328a.b.unregisterReceiver(f1328a.e);
            }
        }
    }

    private void f() {
        try {
            File file = new File(com.baidu.util.a.a(this.b).a("lcsdk_xml", "path", ""));
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClientUpdateInfo a() {
        return this.c;
    }

    public synchronized ClientUpdateInfo a(JSONObject jSONObject) {
        ClientUpdateInfo clientUpdateInfo = null;
        synchronized (this) {
            if (jSONObject != null) {
                String optString = jSONObject.optString("status");
                if (!TextUtils.isEmpty(optString)) {
                    if (Integer.valueOf(optString).intValue() == 1) {
                        this.c = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
                        if (this.c != null) {
                            this.c.mStatus = jSONObject.optString("status");
                            this.c.mReverson = jSONObject.optString("re_version");
                        }
                        clientUpdateInfo = this.c;
                    } else if (Integer.valueOf(optString).intValue() == 0) {
                        f();
                        this.c = new ClientUpdateInfo();
                        this.c.mStatus = optString;
                        clientUpdateInfo = this.c;
                    }
                }
            }
        }
        return clientUpdateInfo;
    }

    public synchronized void a(ClientUpdateInfo clientUpdateInfo, String str) {
        if (clientUpdateInfo != null) {
            this.g = str;
            if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1) {
                if (!TextUtils.isEmpty(clientUpdateInfo.mPatchDownUrl) && !TextUtils.isEmpty(clientUpdateInfo.mPatchSize) && Integer.valueOf(clientUpdateInfo.mPatchSize).intValue() > 0) {
                    b((AppInfo) clientUpdateInfo, str);
                }
                this.f = true;
            }
        }
    }

    public synchronized void a(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        if (clientUpdateInfo != null) {
            if (this.c == null) {
                this.c = clientUpdateInfo;
            }
            this.g = str;
            if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
                a((AppInfo) clientUpdateInfo, str, z);
                this.f = false;
            }
        }
    }

    public synchronized void a(JSONObject jSONObject, IClientUpdaterCallback iClientUpdaterCallback) {
        try {
            this.f = false;
        } catch (Exception e) {
            e.printStackTrace();
            this.i.a(this.h.c(), "0", this.h.b(), "a5", "1", (System.currentTimeMillis() / 1000) + "", "", "parseResult", e.toString());
        }
        if (jSONObject == null) {
            iClientUpdaterCallback.onCompleted(null, null);
            this.i.a(this.h.c(), "0", this.h.b(), "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
        } else {
            String optString = jSONObject.optString("status");
            if (TextUtils.isEmpty(optString)) {
                iClientUpdaterCallback.onCompleted(null, null);
            } else if (Integer.valueOf(optString).intValue() == 1) {
                this.c = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
                if (!new URI(this.c.mDownurl).getHost().endsWith("baidu.com")) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("msgId", "3");
                    jSONObject2.put("messageDetail", "下载地址有问题");
                    if (iClientUpdaterCallback != null) {
                        iClientUpdaterCallback.onError(jSONObject2);
                    }
                }
                this.d = (RuleInfo) h.a(jSONObject.optJSONObject(Message.RULE), 3);
                if (this.c != null) {
                    this.c.mStatus = jSONObject.optString("status");
                    this.c.mReverson = jSONObject.optString("re_version");
                }
                if (this.c != null) {
                    LogUtil.logD("ClientUpdateUtility", "mClientUpdateInfo: " + this.c.toString());
                }
                iClientUpdaterCallback.onCompleted(this.c, this.d);
            } else if (Integer.valueOf(optString).intValue() == 0) {
                f();
                this.c = new ClientUpdateInfo();
                this.c.mStatus = optString;
                iClientUpdaterCallback.onCompleted(this.c, null);
            }
            this.i.a(this.h.c(), "0", this.h.b(), "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
            LogUtil.logE("ClientUpdateUtility", "加入统计耗时：" + (System.currentTimeMillis() - ClientUpdater.stime));
        }
    }

    public RuleInfo b() {
        return this.d;
    }

    public synchronized RuleInfo b(JSONObject jSONObject) {
        RuleInfo ruleInfo = null;
        synchronized (this) {
            if (jSONObject != null) {
                String optString = jSONObject.optString("status");
                if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 1) {
                    this.d = (RuleInfo) h.a(jSONObject.optJSONObject(Message.RULE), 3);
                    ruleInfo = this.d;
                }
            }
        }
        return ruleInfo;
    }

    public synchronized void b(ClientUpdateInfo clientUpdateInfo, String str) {
        if (clientUpdateInfo != null) {
            if (this.c == null) {
                this.c = clientUpdateInfo;
            }
            this.g = str;
            if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
                a((AppInfo) clientUpdateInfo, str);
                this.f = false;
            }
        }
    }

    public synchronized void c() {
        if (this.c != null) {
            this.c = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        this.f = false;
    }

    public boolean d() {
        return this.f;
    }
}
