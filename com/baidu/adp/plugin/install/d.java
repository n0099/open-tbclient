package com.baidu.adp.plugin.install;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static Handler es = new Handler(Looper.getMainLooper());
    private static volatile d tM = null;
    private Messenger messenger;
    private ArrayList<String> tI;
    private BroadcastReceiver tJ;
    private com.baidu.adp.plugin.install.a tL;
    private c tQ;
    private c tS;
    private ServiceConnection tU;
    private boolean tH = false;
    private boolean tK = false;
    private boolean tN = true;
    private a tO = null;
    private final Object tP = new Object();
    private LinkedList<c> tR = new LinkedList<>();
    private LinkedList<c> tT = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger tV = new Messenger(this.handler);
    private Runnable tW = new f(this);
    private Runnable tX = new g(this);
    private Runnable tY = new h(this);
    private Runnable tZ = new i(this);

    public static d hc() {
        if (tM == null) {
            synchronized (d.class) {
                if (tM == null) {
                    tM = new d();
                }
            }
        }
        return tM;
    }

    private d() {
        this.tI = null;
        this.tJ = null;
        this.tI = new ArrayList<>();
        this.tJ = new j(this);
        hd();
    }

    public void l(String str, int i) {
        if (i == 1) {
            o(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.tI.contains(str)) {
            this.tI.remove(str);
        }
        if (!this.tK && z && this.tI.isEmpty()) {
            this.tK = true;
            if (this.tL != null) {
                this.tL.G(this.tN);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            hg();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.tL = aVar;
        if (this.tO != null) {
            this.tO.cancel();
            this.tO = null;
        }
        this.tO = new a(context);
        this.tO.setPriority(4);
        this.tO.execute(new String[0]);
    }

    public boolean bb(String str) {
        if (this.tQ != null) {
            return TextUtils.equals(str, this.tQ.tc);
        }
        if (this.tS != null) {
            return TextUtils.equals(str, this.tS.tc);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [272=4, 273=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0165 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    public boolean o(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bj = PluginPackageManager.hH().bj(substring);
            if (substring != null && substring.length() > 0 && bj != null && bj.apkPath != null) {
                File file = new File(bj.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    InputStream inputStream = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                com.baidu.adp.plugin.util.i e = Util.e(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (e.compareTo(Util.e(inputStream)) == 0) {
                                    if (this.tL != null) {
                                        this.tL.aZ(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.hu().e("plugin_install", "install_timeequals", substring, e.toString());
                                    com.baidu.adp.lib.h.a.c(fileInputStream);
                                    com.baidu.adp.lib.h.a.c(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.c(fileInputStream);
                                com.baidu.adp.lib.h.a.c(inputStream);
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.hu().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.c(fileInputStream);
                                com.baidu.adp.lib.h.a.c(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.hu().e("plugin_install", substring, bj);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.ir().bF(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.h.a.c(r3);
                            com.baidu.adp.lib.h.a.c(null);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.h.a.c(lastIndexOf3);
                        com.baidu.adp.lib.h.a.c(null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.hu().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.hu().e("plugin_install", substring, bj);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.ir().bF(substring)));
            return true;
        }
        return false;
    }

    public void p(Context context, String str) {
        a(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void a(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            hd();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.tG = context.getAssets().open(str.substring("assets://".length())).available();
                    z2 = true;
                    str2 = substring;
                } catch (IOException e) {
                    BdLog.detailException(e);
                    z2 = true;
                    str2 = substring;
                }
            } else if (!str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
                str2 = null;
                z2 = false;
            } else {
                PackageManager packageManager = context.getPackageManager();
                String substring2 = str.substring(SkiaImageDecoder.FILE_PREFIX.length());
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring2, 0);
                if (packageArchiveInfo != null) {
                    str3 = packageArchiveInfo.packageName;
                }
                cVar.tG = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.tc = str2;
                if (a(cVar) && z2) {
                    this.tI.add(str2);
                    return;
                }
                return;
            }
            cVar.tc = str;
            a(cVar);
        }
    }

    private boolean a(Context context, c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ik().findPluginSetting(cVar.tc);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.hu().e("plugin_install", "start_install_service", cVar.tc, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.tc);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.hH().hI());
        if (cVar.tF) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.tU == null && z) {
            this.tU = new k(this, intent, context);
            if (context.bindService(intent, this.tU, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bc(String str) {
        PluginSetting bj = PluginPackageManager.hH().bj(str);
        if (bj == null || bj.apkPath == null || bj.apkPath.length() <= 0) {
            return null;
        }
        return new File(bj.apkPath);
    }

    private void hd() {
        if (!this.tH) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.tJ, intentFilter);
                this.tH = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar) {
        if (b(cVar)) {
            return true;
        }
        return c(cVar);
    }

    private boolean b(c cVar) {
        boolean z = false;
        synchronized (this.tP) {
            if (cVar == null) {
                cVar = this.tR.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.tQ != null) {
                Iterator<c> it = this.tR.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.tc, next.tc)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.tR.add(cVar);
                }
                return true;
            }
            this.tQ = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                hh();
                es.removeCallbacks(this.tY);
                es.postDelayed(this.tY, this.tQ.hb());
                return true;
            }
            this.tQ = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.tP) {
            if (cVar == null) {
                cVar = this.tT.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.tS != null) {
                Iterator<c> it = this.tT.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.tc, next.tc)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.tT.add(cVar);
                }
                return true;
            }
            this.tS = cVar;
            cVar.tF = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                es.removeCallbacks(this.tZ);
                es.postDelayed(this.tZ, this.tS.hb());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he() {
        es.removeCallbacks(this.tW);
        es.removeCallbacks(this.tY);
        es.removeCallbacks(this.tX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        this.tS = null;
        es.removeCallbacks(this.tZ);
    }

    private void hg() {
        if (this.tU != null) {
            BdBaseApplication.getInst().unbindService(this.tU);
            this.tU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh() {
        es.removeCallbacks(this.tW);
        es.postDelayed(this.tW, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi() {
        if (this.messenger != null && this.tQ != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.tQ));
                message.replyTo = this.tV;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            es.removeCallbacks(this.tX);
            es.postDelayed(this.tX, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj() {
        this.tU = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.hu().e("plugin_install", "system_kill_installprocess", this.tQ == null ? "" : this.tQ.tc, String.valueOf(this.tR.size()) + "-" + this.tT.size());
        he();
        hq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk() {
        com.baidu.adp.plugin.b.a.hu().bf("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.hu().e("plugin_install", "installprocess_noresponse", this.tQ == null ? "" : this.tQ.tc, String.valueOf(this.tR.size()) + "-" + this.tT.size());
        he();
        hn();
        hq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl() {
        if (this.tQ != null) {
            com.baidu.adp.plugin.packageManager.a.b.ir().n(this.tQ.tc, "plugin_install_timeout", null);
        }
        c cVar = this.tQ;
        if (!ho()) {
            com.baidu.adp.plugin.b.a.hu().bf("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.hu().e("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.tc, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.hb())) + "-" + this.tR.size() + "-" + this.tT.size());
        } else {
            com.baidu.adp.plugin.b.a.hu().bf("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.hu().e("plugin_install", "timeout", cVar == null ? "" : cVar.tc, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.hb())) + "-" + this.tR.size() + "-" + this.tT.size());
        }
        he();
        hn();
        hq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hm() {
        if (this.tS != null) {
            com.baidu.adp.plugin.packageManager.a.b.ir().n(this.tS.tc, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.hu().e("plugin_install", "timeout", this.tS == null ? "" : this.tS.tc, "timeout-" + (this.tS == null ? "" : Long.valueOf(this.tS.hb())) + "-" + this.tR.size() + "-" + this.tT.size());
        hf();
    }

    private void hn() {
        if (this.tU != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.tU);
        }
        this.tU = null;
        this.messenger = null;
        int hp = hp();
        if (hp > 0 && hp != Process.myPid()) {
            Process.killProcess(hp);
        }
    }

    private boolean ho() {
        return hp() > 0;
    }

    private int hp() {
        ServiceInfo serviceInfo;
        Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
        try {
            serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, PluginInstallerService.class), 0);
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            serviceInfo = null;
        }
        if (serviceInfo != null) {
            String str = serviceInfo.processName;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && TextUtils.equals(str, runningAppProcessInfo.processName)) {
                        return runningAppProcessInfo.pid;
                    }
                }
            }
        }
        return ExploreByTouchHelper.INVALID_ID;
    }

    private void hq() {
        if (this.tQ != null) {
            com.baidu.adp.plugin.b.a.hu().D("plugin_retry_install", this.tQ.tc);
            com.baidu.adp.plugin.b.a.hu().e("plugin_install", "plugin_retry_install", this.tQ.tc, new StringBuilder(String.valueOf(this.tQ.hb())).toString());
            c(this.tQ);
            this.tQ = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] ub = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public String[] doInBackground(String... strArr) {
            InputStream inputStream;
            String[] strArr2 = null;
            if (this.mContext == null) {
                return null;
            }
            try {
                AssetManager assets = this.mContext.getAssets();
                String[] list = assets.list("plugins");
                if (list != null) {
                    try {
                        if (list.length > 0) {
                            HashMap hashMap = new HashMap();
                            try {
                                inputStream = assets.open("plugins/plugin.config");
                            } catch (IOException e) {
                                BdLog.e("plugin.config file not in assets");
                                inputStream = null;
                            }
                            if (inputStream != null) {
                                try {
                                    byte[] bArr = new byte[inputStream.available()];
                                    inputStream.read(bArr);
                                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                                    Iterator<String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (next instanceof String) {
                                            String str = next;
                                            JSONObject optJSONObject = jSONObject.optJSONObject(str);
                                            String str2 = !str.endsWith(".apk") ? String.valueOf(str) + ".apk" : str;
                                            com.baidu.adp.plugin.packageManager.a.a aVar = (com.baidu.adp.plugin.packageManager.a.a) com.baidu.adp.plugin.packageManager.a.a.objectWithJson(optJSONObject, com.baidu.adp.plugin.packageManager.a.a.class);
                                            if (aVar != null) {
                                                hashMap.put(str2, aVar);
                                            }
                                        }
                                    }
                                    o.c(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.c(inputStream);
                                }
                                if (list.length - 1 != hashMap.size()) {
                                    BdLog.e("plugin.config size not equals plugin num");
                                }
                                Arrays.sort(list, new l(this, hashMap));
                                return list;
                            }
                        }
                    } catch (Exception e3) {
                        strArr2 = list;
                        e = e3;
                        BdLog.e(e);
                        return strArr2;
                    }
                }
                return list;
            } catch (Exception e4) {
                e = e4;
            }
        }

        private boolean bd(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.ub) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public void onPostExecute(String[] strArr) {
            boolean z = false;
            super.onPostExecute(strArr);
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && bd(str) && d.this.o(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.tL != null) {
                d.this.tL.G(d.this.tN);
            }
        }
    }
}
