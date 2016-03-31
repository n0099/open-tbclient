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
    private ServiceConnection DA;
    private ArrayList<String> Do;
    private BroadcastReceiver Dp;
    private com.baidu.adp.plugin.install.a Dr;
    private c Dw;
    private c Dy;
    private Messenger messenger;
    private static Handler oC = new Handler(Looper.getMainLooper());
    private static volatile d Ds = null;
    private boolean Dn = false;
    private boolean Dq = false;
    private boolean Dt = true;
    private a Du = null;
    private final Object Dv = new Object();
    private LinkedList<c> Dx = new LinkedList<>();
    private LinkedList<c> Dz = new LinkedList<>();
    private Handler handler = new e(this, Looper.getMainLooper());
    private Messenger DC = new Messenger(this.handler);
    private Runnable DD = new f(this);
    private Runnable DE = new g(this);
    private Runnable DF = new h(this);
    private Runnable DG = new i(this);

    public static d kN() {
        if (Ds == null) {
            synchronized (d.class) {
                if (Ds == null) {
                    Ds = new d();
                }
            }
        }
        return Ds;
    }

    private d() {
        this.Do = null;
        this.Dp = null;
        this.Do = new ArrayList<>();
        this.Dp = new j(this);
        kO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.Do.contains(str)) {
            this.Do.remove(str);
        }
        if (!this.Dq && z && this.Do.isEmpty()) {
            this.Dq = true;
            if (this.Dr != null) {
                this.Dr.G(this.Dt);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
            kR();
        }
    }

    public void a(Context context, com.baidu.adp.plugin.install.a aVar) {
        this.Dr = aVar;
        if (this.Du != null) {
            this.Du.cancel();
            this.Du = null;
        }
        this.Du = new a(context);
        this.Du.setPriority(4);
        this.Du.execute(new String[0]);
    }

    public boolean bi(String str) {
        if (this.Dw != null) {
            return TextUtils.equals(str, this.Dw.pkgName);
        }
        if (this.Dy != null) {
            return TextUtils.equals(str, this.Dy.pkgName);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4, 255=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0165 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    public boolean n(Context context, String str) {
        int lastIndexOf;
        int lastIndexOf2;
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && (r3 = (lastIndexOf = str.lastIndexOf("/")) + 1) < (lastIndexOf2 = str.lastIndexOf(".apk"))) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bq = PluginPackageManager.ls().bq(substring);
            if (substring != null && substring.length() > 0 && bq != null && bq.apkPath != null) {
                File file = new File(bq.apkPath);
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
                                    if (this.Dr != null) {
                                        this.Dr.bg(substring);
                                    }
                                    com.baidu.adp.plugin.b.a.lf().e("plugin_install", "install_timeequals", substring, e.toString());
                                    com.baidu.adp.lib.h.a.c(fileInputStream);
                                    com.baidu.adp.lib.h.a.c(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.h.a.c(fileInputStream);
                                com.baidu.adp.lib.h.a.c(inputStream);
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e(e);
                                com.baidu.adp.plugin.b.a.lf().e("plugin_install", "install_timeequals_error", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length + "-" + e.getMessage());
                                com.baidu.adp.lib.h.a.c(fileInputStream);
                                com.baidu.adp.lib.h.a.c(inputStream);
                                a(context, "assets://" + str, false);
                                com.baidu.adp.plugin.b.a.lf().e("plugin_install", substring, bq);
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.ma().bM(substring)));
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
                    com.baidu.adp.plugin.b.a.lf().e("plugin_install", "install_timeequals_jump", substring, "exist-" + exists + "-isfile-" + isFile + "-length-" + length);
                }
            }
            a(context, "assets://" + str, false);
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", substring, bq);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000993, com.baidu.adp.plugin.packageManager.a.b.ma().bM(substring)));
            return true;
        }
        return false;
    }

    public void o(Context context, String str) {
        a(context, SkiaImageDecoder.FILE_PREFIX + str, false);
    }

    private void a(Context context, String str, boolean z) {
        String str2;
        boolean z2;
        if (context != null && !TextUtils.isEmpty(str)) {
            kO();
            String str3 = null;
            c cVar = new c();
            cVar.apkFilePath = str;
            if (str.startsWith("assets://")) {
                String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                try {
                    cVar.Dm = context.getAssets().open(str.substring("assets://".length())).available();
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
                cVar.Dm = new File(substring2).length();
                str2 = str3;
                z2 = false;
            }
            if (str2 != null) {
                cVar.pkgName = str2;
                if (a(cVar) && z2) {
                    this.Do.add(str2);
                    return;
                }
                return;
            }
            cVar.pkgName = str;
            a(cVar);
        }
    }

    private boolean a(Context context, c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lU().findPluginSetting(cVar.pkgName);
        if (cVar.apkFilePath != null && cVar.apkFilePath.startsWith("assets://")) {
            z = true;
        }
        com.baidu.adp.plugin.b.a.lf().e("plugin_install", "start_install_service", cVar.pkgName, cVar.apkFilePath);
        Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
        intent.putExtra("install_src_file", cVar.apkFilePath);
        intent.putExtra("package_name", cVar.pkgName);
        intent.putExtra("start_install_time", System.currentTimeMillis());
        if (findPluginSetting != null) {
            intent.putExtra("plugin_setting", findPluginSetting);
        }
        intent.putExtra("is_debug_plugin", PluginPackageManager.ls().lt());
        if (cVar.Dl) {
            intent.setClass(context, PluginInstallerRetryService.class);
            context.startService(intent);
            return true;
        }
        intent.setClass(context, PluginInstallerService.class);
        if (this.DA == null && z) {
            this.DA = new k(this, intent, context);
            if (context.bindService(intent, this.DA, 1)) {
                return true;
            }
            context.startService(intent);
            return true;
        }
        context.startService(intent);
        return true;
    }

    public static File bj(String str) {
        PluginSetting bq = PluginPackageManager.ls().bq(str);
        if (bq == null || bq.apkPath == null || bq.apkPath.length() <= 0) {
            return null;
        }
        return new File(bq.apkPath);
    }

    private void kO() {
        if (!this.Dn) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                intentFilter.addAction("com.baidu.adp.plugin.installcancel");
                applicationContext.registerReceiver(this.Dp, intentFilter);
                this.Dn = true;
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
        synchronized (this.Dv) {
            if (cVar == null) {
                cVar = this.Dx.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.Dw != null) {
                Iterator<c> it = this.Dx.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.pkgName, next.pkgName)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Dx.add(cVar);
                }
                return true;
            }
            this.Dw = cVar;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                kS();
                oC.removeCallbacks(this.DF);
                oC.postDelayed(this.DF, this.Dw.kM());
                return true;
            }
            this.Dw = null;
            return a((c) null);
        }
    }

    private boolean c(c cVar) {
        boolean z = false;
        synchronized (this.Dv) {
            if (cVar == null) {
                cVar = this.Dz.poll();
            }
            if (cVar == null) {
                return false;
            }
            if (this.Dy != null) {
                Iterator<c> it = this.Dz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && TextUtils.equals(cVar.pkgName, next.pkgName)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.Dz.add(cVar);
                }
                return true;
            }
            this.Dy = cVar;
            cVar.Dl = true;
            if (a(BdBaseApplication.getInst().getApplicationContext(), cVar)) {
                oC.removeCallbacks(this.DG);
                oC.postDelayed(this.DG, this.Dy.kM());
                return true;
            }
            return a((c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP() {
        oC.removeCallbacks(this.DD);
        oC.removeCallbacks(this.DF);
        oC.removeCallbacks(this.DE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ() {
        this.Dy = null;
        oC.removeCallbacks(this.DG);
    }

    private void kR() {
        if (this.DA != null) {
            BdBaseApplication.getInst().unbindService(this.DA);
            this.DA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kS() {
        oC.removeCallbacks(this.DD);
        oC.postDelayed(this.DD, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT() {
        if (this.messenger != null && this.Dw != null) {
            Message message = new Message();
            try {
                message.setData(com.baidu.adp.lib.a.b.a.a.i.bundleWithObject(this.Dw));
                message.replyTo = this.DC;
                this.messenger.send(message);
            } catch (RemoteException e) {
                BdLog.detailException(e);
            }
            oC.removeCallbacks(this.DE);
            oC.postDelayed(this.DE, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU() {
        this.DA = null;
        this.messenger = null;
        com.baidu.adp.plugin.b.a.lf().e("plugin_install", "system_kill_installprocess", this.Dw == null ? "" : this.Dw.pkgName, String.valueOf(this.Dx.size()) + "-" + this.Dz.size());
        kP();
        lb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV() {
        com.baidu.adp.plugin.b.a.lf().bm("plugin_installprocess_noresponse");
        com.baidu.adp.plugin.b.a.lf().e("plugin_install", "installprocess_noresponse", this.Dw == null ? "" : this.Dw.pkgName, String.valueOf(this.Dx.size()) + "-" + this.Dz.size());
        kP();
        kY();
        lb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW() {
        if (this.Dw != null) {
            com.baidu.adp.plugin.packageManager.a.b.ma().j(this.Dw.pkgName, "plugin_install_timeout", null);
        }
        c cVar = this.Dw;
        if (!kZ()) {
            com.baidu.adp.plugin.b.a.lf().bm("plugin_install_timeout_installprocess_notlive");
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", "timeout_installprocess_notlive", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.kM())) + "-" + this.Dx.size() + "-" + this.Dz.size());
        } else {
            com.baidu.adp.plugin.b.a.lf().bm("plugin_install_timeout");
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", "timeout", cVar == null ? "" : cVar.pkgName, "timeout-" + (cVar == null ? "" : Long.valueOf(cVar.kM())) + "-" + this.Dx.size() + "-" + this.Dz.size());
        }
        kP();
        kY();
        lb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX() {
        if (this.Dy != null) {
            com.baidu.adp.plugin.packageManager.a.b.ma().j(this.Dy.pkgName, "plugin_install_retry_timeout", null);
        }
        com.baidu.adp.plugin.b.a.lf().e("plugin_install", "timeout", this.Dy == null ? "" : this.Dy.pkgName, "timeout-" + (this.Dy == null ? "" : Long.valueOf(this.Dy.kM())) + "-" + this.Dx.size() + "-" + this.Dz.size());
        kQ();
    }

    private void kY() {
        if (this.DA != null) {
            BdBaseApplication.getInst().getApplicationContext().unbindService(this.DA);
        }
        this.DA = null;
        this.messenger = null;
        int la = la();
        if (la > 0 && la != Process.myPid()) {
            Process.killProcess(la);
        }
    }

    private boolean kZ() {
        return la() > 0;
    }

    private int la() {
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

    private void lb() {
        if (this.Dw != null) {
            com.baidu.adp.plugin.b.a.lf().E("plugin_retry_install", this.Dw.pkgName);
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", "plugin_retry_install", this.Dw.pkgName, new StringBuilder(String.valueOf(this.Dw.kM())).toString());
            c(this.Dw);
            this.Dw = null;
            return;
        }
        a((c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, String[]> {
        private String[] DI = {"com.baidu.tieba.pluginInjectAll", "com.baidu.tieba.pluginLive", "com.baidu.tieba.pluginPhotoLive"};
        private Context mContext;

        public a(Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
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

        private boolean bk(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Build.VERSION.SDK_INT <= 10) {
                for (String str2 : this.DI) {
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
        /* renamed from: l */
        public void onPostExecute(String[] strArr) {
            boolean z = false;
            super.onPostExecute(strArr);
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str != null && str.endsWith(".apk") && bk(str) && d.this.n(this.mContext, "plugins/" + str)) {
                        z = true;
                    }
                }
            }
            if (!z && d.this.Dr != null) {
                d.this.Dr.G(d.this.Dt);
            }
        }
    }
}
