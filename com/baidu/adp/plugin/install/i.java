package com.baidu.adp.plugin.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BroadcastReceiver {
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.this$0 = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=5, 149=5, 150=5, 151=5, 152=5, 153=5, 154=5, 155=5, 156=5, 157=5, 159=5] */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PluginInstallTask pluginInstallTask;
        PluginInstallTask pluginInstallTask2;
        PluginInstallTask pluginInstallTask3;
        PluginInstallTask pluginInstallTask4;
        String str;
        PluginInstallTask pluginInstallTask5;
        PluginInstallTask pluginInstallTask6;
        PluginInstallTask pluginInstallTask7;
        PluginInstallTask pluginInstallTask8;
        PluginInstallTask pluginInstallTask9;
        PluginInstallTask pluginInstallTask10;
        PluginInstallTask pluginInstallTask11;
        PluginInstallTask pluginInstallTask12;
        PluginInstallTask pluginInstallTask13;
        PluginInstallTask pluginInstallTask14;
        PluginInstallTask pluginInstallTask15;
        PluginInstallTask pluginInstallTask16;
        PluginInstallTask pluginInstallTask17;
        PluginInstallTask pluginInstallTask18;
        PluginInstallTask pluginInstallTask19;
        PluginInstallTask pluginInstallTask20;
        boolean z = false;
        try {
            if (intent == null) {
                pluginInstallTask17 = this.this$0.Do;
                if (pluginInstallTask17 != null) {
                    pluginInstallTask20 = this.this$0.Do;
                    if (TextUtils.equals(null, pluginInstallTask20.CC)) {
                        this.this$0.iU();
                        this.this$0.Do = null;
                        this.this$0.a((PluginInstallTask) null);
                        return;
                    }
                }
                pluginInstallTask18 = this.this$0.Dq;
                if (pluginInstallTask18 != null) {
                    pluginInstallTask19 = this.this$0.Dq;
                    if (TextUtils.equals(null, pluginInstallTask19.CC)) {
                        this.this$0.iV();
                        this.this$0.a((PluginInstallTask) null);
                        com.baidu.adp.plugin.b.a.jk().aV("plugin_retry_install_succ");
                        return;
                    }
                }
                this.this$0.a((PluginInstallTask) null);
                return;
            }
            try {
                str = intent.getStringExtra("package_name");
                try {
                    if (TextUtils.isEmpty(str)) {
                        pluginInstallTask13 = this.this$0.Do;
                        if (pluginInstallTask13 != null) {
                            pluginInstallTask16 = this.this$0.Do;
                            if (TextUtils.equals(str, pluginInstallTask16.CC)) {
                                this.this$0.iU();
                                this.this$0.Do = null;
                                this.this$0.a((PluginInstallTask) null);
                                return;
                            }
                        }
                        pluginInstallTask14 = this.this$0.Dq;
                        if (pluginInstallTask14 != null) {
                            pluginInstallTask15 = this.this$0.Dq;
                            if (TextUtils.equals(str, pluginInstallTask15.CC)) {
                                this.this$0.iV();
                                this.this$0.a((PluginInstallTask) null);
                                com.baidu.adp.plugin.b.a.jk().aV("plugin_retry_install_succ");
                                return;
                            }
                        }
                        this.this$0.a((PluginInstallTask) null);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("install_src_file");
                    if (stringExtra != null && stringExtra.startsWith("assets://")) {
                        z = true;
                    }
                    String action = intent.getAction();
                    if ("com.baidu.adp.plugin.installed".equals(action)) {
                        this.this$0.e(str, z);
                        com.baidu.adp.plugin.packageManager.status.a.kh().bt(str);
                    } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                        if (z) {
                            this.this$0.Dl = false;
                        }
                        this.this$0.e(str, z);
                        com.baidu.adp.plugin.packageManager.status.a.kh().g(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                    } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                        this.this$0.e(str, z);
                    }
                    pluginInstallTask9 = this.this$0.Do;
                    if (pluginInstallTask9 != null) {
                        pluginInstallTask12 = this.this$0.Do;
                        if (TextUtils.equals(str, pluginInstallTask12.CC)) {
                            this.this$0.iU();
                            this.this$0.Do = null;
                            this.this$0.a((PluginInstallTask) null);
                            return;
                        }
                    }
                    pluginInstallTask10 = this.this$0.Dq;
                    if (pluginInstallTask10 != null) {
                        pluginInstallTask11 = this.this$0.Dq;
                        if (TextUtils.equals(str, pluginInstallTask11.CC)) {
                            this.this$0.iV();
                            this.this$0.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jk().aV("plugin_retry_install_succ");
                            return;
                        }
                    }
                    this.this$0.a((PluginInstallTask) null);
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    pluginInstallTask5 = this.this$0.Do;
                    if (pluginInstallTask5 != null) {
                        pluginInstallTask8 = this.this$0.Do;
                        if (TextUtils.equals(str, pluginInstallTask8.CC)) {
                            this.this$0.iU();
                            this.this$0.Do = null;
                            this.this$0.a((PluginInstallTask) null);
                            return;
                        }
                    }
                    pluginInstallTask6 = this.this$0.Dq;
                    if (pluginInstallTask6 != null) {
                        pluginInstallTask7 = this.this$0.Dq;
                        if (TextUtils.equals(str, pluginInstallTask7.CC)) {
                            this.this$0.iV();
                            this.this$0.a((PluginInstallTask) null);
                            com.baidu.adp.plugin.b.a.jk().aV("plugin_retry_install_succ");
                            return;
                        }
                    }
                    this.this$0.a((PluginInstallTask) null);
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
            } catch (Throwable th) {
                th = th;
                pluginInstallTask = this.this$0.Do;
                if (pluginInstallTask != null) {
                    pluginInstallTask4 = this.this$0.Do;
                    if (TextUtils.equals(null, pluginInstallTask4.CC)) {
                        this.this$0.iU();
                        this.this$0.Do = null;
                        this.this$0.a((PluginInstallTask) null);
                        throw th;
                    }
                }
                pluginInstallTask2 = this.this$0.Dq;
                if (pluginInstallTask2 != null) {
                    pluginInstallTask3 = this.this$0.Dq;
                    if (TextUtils.equals(null, pluginInstallTask3.CC)) {
                        this.this$0.iV();
                        this.this$0.a((PluginInstallTask) null);
                        com.baidu.adp.plugin.b.a.jk().aV("plugin_retry_install_succ");
                        throw th;
                    }
                }
                this.this$0.a((PluginInstallTask) null);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
