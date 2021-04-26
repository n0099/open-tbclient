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
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.util.LogUtil;
import com.heytap.mcssdk.mode.Message;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f4734a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4735b;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f4738e;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.clientupdate.c.a f4741h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.clientupdate.a.d f4742i;

    /* renamed from: c  reason: collision with root package name */
    public ClientUpdateInfo f4736c = null;

    /* renamed from: d  reason: collision with root package name */
    public RuleInfo f4737d = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4739f = false;

    /* renamed from: g  reason: collision with root package name */
    public String f4740g = null;

    public a(Context context) {
        this.f4735b = context;
        this.f4742i = com.baidu.clientupdate.a.d.a(context);
        this.f4741h = com.baidu.clientupdate.c.a.a(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f4734a == null) {
                f4734a = new a(context);
            }
            aVar = f4734a;
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mDownurl;
        download.mMimeType = "application/vnd.android.package-archive";
        download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
        DownloadManager.getInstance(this.f4735b).start(download);
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mDownurl;
        download.mMimeType = "application/vnd.android.package-archive";
        download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
        DownloadManager.getInstance(this.f4735b).start(download, z);
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Download download = new Download();
        download.mFileName = appInfo.mSname;
        download.mSavedPath = str;
        download.mUrl = appInfo.mPatchDownUrl;
        download.mMimeType = SchemeDescPatchListener.PATCH;
        download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
        DownloadManager.getInstance(this.f4735b).start(download);
    }

    public static void e() {
        synchronized (a.class) {
            if (f4734a != null && f4734a.f4738e != null) {
                f4734a.f4735b.unregisterReceiver(f4734a.f4738e);
            }
        }
    }

    private void f() {
        try {
            File file = new File(com.baidu.util.a.a(this.f4735b).a("lcsdk_xml", "path", ""));
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public ClientUpdateInfo a() {
        return this.f4736c;
    }

    public synchronized ClientUpdateInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("status");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (Integer.valueOf(optString).intValue() != 1) {
            if (Integer.valueOf(optString).intValue() == 0) {
                f();
                ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
                this.f4736c = clientUpdateInfo;
                clientUpdateInfo.mStatus = optString;
                return clientUpdateInfo;
            }
            return null;
        }
        ClientUpdateInfo clientUpdateInfo2 = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
        this.f4736c = clientUpdateInfo2;
        if (clientUpdateInfo2 != null) {
            clientUpdateInfo2.mStatus = jSONObject.optString("status");
            this.f4736c.mReverson = jSONObject.optString("re_version");
        }
        return this.f4736c;
    }

    public synchronized void a(ClientUpdateInfo clientUpdateInfo, String str) {
        if (clientUpdateInfo == null) {
            return;
        }
        this.f4740g = str;
        if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1) {
            if (!TextUtils.isEmpty(clientUpdateInfo.mPatchDownUrl) && !TextUtils.isEmpty(clientUpdateInfo.mPatchSize) && Integer.valueOf(clientUpdateInfo.mPatchSize).intValue() > 0) {
                b((AppInfo) clientUpdateInfo, str);
            }
            this.f4739f = true;
        }
    }

    public synchronized void a(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        if (clientUpdateInfo == null) {
            return;
        }
        if (this.f4736c == null) {
            this.f4736c = clientUpdateInfo;
        }
        this.f4740g = str;
        if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
            a((AppInfo) clientUpdateInfo, str, z);
            this.f4739f = false;
        }
    }

    public synchronized void a(JSONObject jSONObject, IClientUpdaterCallback iClientUpdaterCallback) {
        try {
            this.f4739f = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.clientupdate.a.d dVar = this.f4742i;
            String c2 = this.f4741h.c();
            String b2 = this.f4741h.b();
            dVar.a(c2, "0", b2, "a5", "1", (System.currentTimeMillis() / 1000) + "", "", "parseResult", e2.toString());
        }
        if (jSONObject == null) {
            iClientUpdaterCallback.onCompleted(null, null);
            com.baidu.clientupdate.a.d dVar2 = this.f4742i;
            String c3 = this.f4741h.c();
            String b3 = this.f4741h.b();
            dVar2.a(c3, "0", b3, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
            return;
        }
        String optString = jSONObject.optString("status");
        if (TextUtils.isEmpty(optString)) {
            iClientUpdaterCallback.onCompleted(null, null);
        } else if (Integer.valueOf(optString).intValue() == 1) {
            this.f4736c = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
            if (!new URI(this.f4736c.mDownurl).getHost().endsWith("baidu.com")) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("msgId", "3");
                jSONObject2.put("messageDetail", "下载地址有问题");
                if (iClientUpdaterCallback != null) {
                    iClientUpdaterCallback.onError(jSONObject2);
                }
            }
            this.f4737d = (RuleInfo) h.a(jSONObject.optJSONObject(Message.RULE), 3);
            if (this.f4736c != null) {
                this.f4736c.mStatus = jSONObject.optString("status");
                this.f4736c.mReverson = jSONObject.optString("re_version");
            }
            if (this.f4736c != null) {
                LogUtil.logD("ClientUpdateUtility", "mClientUpdateInfo: " + this.f4736c.toString());
            }
            iClientUpdaterCallback.onCompleted(this.f4736c, this.f4737d);
        } else if (Integer.valueOf(optString).intValue() == 0) {
            f();
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            this.f4736c = clientUpdateInfo;
            clientUpdateInfo.mStatus = optString;
            iClientUpdaterCallback.onCompleted(clientUpdateInfo, null);
        }
        com.baidu.clientupdate.a.d dVar3 = this.f4742i;
        String c4 = this.f4741h.c();
        String b4 = this.f4741h.b();
        dVar3.a(c4, "0", b4, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
        LogUtil.logE("ClientUpdateUtility", "加入统计耗时：" + (System.currentTimeMillis() - ClientUpdater.stime));
    }

    public RuleInfo b() {
        return this.f4737d;
    }

    public synchronized RuleInfo b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("status");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (Integer.valueOf(optString).intValue() == 1) {
            RuleInfo ruleInfo = (RuleInfo) h.a(jSONObject.optJSONObject(Message.RULE), 3);
            this.f4737d = ruleInfo;
            return ruleInfo;
        }
        return null;
    }

    public synchronized void b(ClientUpdateInfo clientUpdateInfo, String str) {
        if (clientUpdateInfo == null) {
            return;
        }
        if (this.f4736c == null) {
            this.f4736c = clientUpdateInfo;
        }
        this.f4740g = str;
        if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
            a((AppInfo) clientUpdateInfo, str);
            this.f4739f = false;
        }
    }

    public synchronized void c() {
        if (this.f4736c != null) {
            this.f4736c = null;
        }
        if (this.f4740g != null) {
            this.f4740g = null;
        }
        this.f4739f = false;
    }

    public boolean d() {
        return this.f4739f;
    }
}
