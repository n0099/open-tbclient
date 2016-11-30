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
    private static Handler hj = new Handler(Looper.getMainLooper());
    private static volatile d wB = null;
    private Messenger messenger;
    private com.baidu.adp.plugin.install.a wA;
    private c wF;
    private c wH;
    private ServiceConnection wJ;
    private ArrayList<String> wx;
    private BroadcastReceiver wy;
    private boolean ww = false;
    private boolean wz = false;
    private boolean wC = true;
    private a wD = null;
    private final Object wE = new Object();
    private LinkedList<c> wG = new LinkedList<>();
    private LinkedList<c> wI = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger wK = new Messenger(this.handler);
    private Runnable wL = new f(this);
    private Runnable wM = new g(this);
    private Runnable wN = new h(this);
    private Runnable wO = new i(this);

    public static d hW() {
        if (wB == null) {
            synchronized (d.class) {
                if (wB == null) {
                    wB = new d();
                }
            }
        }
        return wB;
    }

    private d() {
        this.wx = null;
        this.wy = null;
        this.wx = new ArrayList<>();
        this.wy = new j(this);
        hX();
    }

    public void l(String str, int i) {
        if (i == 1) {
            o(BdBaseApplication.getInst(), "plugins/" + str + ".apk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.wx.contains(str)) {
            this.wx.remove(str);
        }
        if (!this.wz && z && this.wx.isEmpty()) {
            this.wz = true;
            if (this.wA != null) {
                this.wA.K(this.wC);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            ia();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.wA = aVar;
        if (this.wD != null) {
            this.wD.cancel();
            this.wD = null;
        }
        this.wD = new a(context);
        this.wD.setPriority(4);
        this.wD.execute(new String[0]);
    }

    public boolean bd(String str) {
        if (this.wF != null) {
            return TextUtils.equals(str, this.wF.vT);
        }
        if (this.wH != null) {
            return TextUtils.equals(str, this.wH.vT);
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
            PluginSetting bl = PluginPackageManager.iB().bl(substring);
            if (substring != null && substring.length() > 0 && bl != null && bl.apkPath != null) {
                File file = new File(bl.apkPath);
                boolean exists = file.exists();
                boolean isFile = file.isFile();
                long length = file.length();
                if (file.exists() && file.isFile() && file.length() > 0) {
                    InputStream inputStream = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                com.baidu.adp.plugin.util.i l = Util.l(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (l.compareTo(Util.l(inputStream)) == 0) {
                                    if (this.wA != null) {
                                        this.wA.bb(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.io().e("plugin_install", "install_timeequals", substring, l.toString());
                                    com.baidu.adp.lib.h.a.j(fileInputStream);
                                    com.baidu.adp.lib.h.a.j(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.j(fileInputStream);
                                com.baidu.adp.lib.h.a.j(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.io().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.j(fileInputStream);
                                com.baidu.adp.lib.h.a.j(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.io().e("plugin_install", substring, bl);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.jl().bH(substring)));
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.h.a.j(r3);
                            com.baidu.adp.lib.h.a.j(null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        ?? lastIndexOf3 = 0;
                        com.baidu.adp.lib.h.a.j(lastIndexOf3);
                        com.baidu.adp.lib.h.a.j(null);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.a.io().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.io().e("plugin_install", substring, bl);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.jl().bH(substring)));
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
            hX();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.wv = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.wv = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.vT = str2;
                if (a(cVar) && z2) {
                    this.wx.add(str2);
                    return;
                }
                return;
            }
            cVar.vT = str;
            a(cVar);
        }
    }

    private boolean a(Context context, c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().findPluginSetting(cVar.vT);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.io().e("plugin_install", "start_install_service", cVar.vT, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.vT);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.iB().iC());
        if (cVar.wu) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.wJ == null && z) {
            this.wJ = new k(this, intent, context);
            if (context.bindService(intent, this.wJ, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File be(String str) {
        PluginSetting bl = PluginPackageManager.iB().bl(str);
        if (bl == null || bl.apkPath == null || bl.apkPath.length() <= 0) {
            return null;
        }
        return new File(bl.apkPath);
    }

    private void hX() {
        if (!this.ww) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.wy, intentFilter);
                this.ww = true;
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
        synchronized (this.wE) {
            if (cVar == null) {
                cVar = this.wG.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.wF != null) {
                Iterator<c> it = this.wG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.vT, next.vT)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.wG.add(cVar);
                }
                return true;
            }
            this.wF = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                ib();
                hj.removeCallbacks(this.wN);
                hj.postDelayed(this.wN, this.wF.hV());
                return true;
            }
            this.wF = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.wE) {
            if (cVar == null) {
                cVar = this.wI.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.wH != null) {
                Iterator<c> it = this.wI.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.vT, next.vT)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.wI.add(cVar);
                }
                return true;
            }
            this.wH = cVar;
            cVar.wu = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                hj.removeCallbacks(this.wO);
                hj.postDelayed(this.wO, this.wH.hV());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY() {
        hj.removeCallbacks(this.wL);
        hj.removeCallbacks(this.wN);
        hj.removeCallbacks(this.wM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ() {
        this.wH = null;
        hj.removeCallbacks(this.wO);
    }

    private void ia() {
        if (this.wJ != null) {
            BdBaseApplication.getInst().unbindService(this.wJ);
            this.wJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        hj.removeCallbacks(this.wL);
        hj.postDelayed(this.wL, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic() {
        if (this.messenger != null && this.wF != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.wF));
                message.replyTo = this.wK;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            hj.removeCallbacks(this.wM);
            hj.postDelayed(this.wM, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id() {
        this.wJ = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.io().e("plugin_install", "system_kill_installprocess", this.wF == null ? "" : this.wF.vT, String.valueOf(this.wG.size()) + "-" + this.wI.size());
        hY();
        ik();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie() {
        com.baidu.adp.plugin.b.a.io().bh("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.io().e("plugin_install", "installprocess_noresponse", this.wF == null ? "" : this.wF.vT, String.valueOf(this.wG.size()) + "-" + this.wI.size());
        hY();
        ih();
        ik();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m5if() {
        if (this.wF != null) {
            com.baidu.adp.plugin.packageManager.a.b.jl().n(this.wF.vT, "plugin_install_timeout", null);
        }
        c cVar = this.wF;
        if (!ii()) {
            com.baidu.adp.plugin.b.a.io().bh("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.io().e("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.vT, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.hV())) + "-" + this.wG.size() + "-" + this.wI.size());
        } else {
            com.baidu.adp.plugin.b.a.io().bh("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.io().e("plugin_install", "timeout", cVar == null ? "" : cVar.vT, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.hV())) + "-" + this.wG.size() + "-" + this.wI.size());
        }
        hY();
        ih();
        ik();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig() {
        if (this.wH != null) {
            com.baidu.adp.plugin.packageManager.a.b.jl().n(this.wH.vT, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.io().e("plugin_install", "timeout", this.wH == null ? "" : this.wH.vT, "timeout-" + (this.wH == null ? "" : Long.valueOf(this.wH.hV())) + "-" + this.wG.size() + "-" + this.wI.size());
        hZ();
    }

    private void ih() {
        if (this.wJ != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.wJ);
        }
        this.wJ = null;
        this.messenger = null;
        int ij = ij();
        if (ij > 0 && ij != Process.myPid()) {
            Process.killProcess(ij);
        }
    }

    private boolean ii() {
        return ij() > 0;
    }

    private int ij() {
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

    private void ik() {
        if (this.wF != null) {
            com.baidu.adp.plugin.b.a.io().D("plugin_retry_install", this.wF.vT);
            com.baidu.adp.plugin.b.a.io().e("plugin_install", "plugin_retry_install", this.wF.vT, new StringBuilder(String.valueOf(this.wF.hV())).toString());
            c(this.wF);
            this.wF = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private Context mContext;
        private String[] wQ = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};

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
                                    o.j(inputStream);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    o.j(inputStream);
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

        private boolean bf(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.wQ) {
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
                    if (str != null && str.endsWith(".apk") && bf(str) && d.this.o(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.wA != null) {
                d.this.wA.K(d.this.wC);
            }
        }
    }
}
