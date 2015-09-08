package com.baidu.adp.plugin.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BroadcastReceiver {
    final /* synthetic */ d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.this$0 = dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [139=5, 140=5, 141=5, 142=5, 143=5, 144=5, 145=5, 146=5, 147=5, 148=5, 150=5] */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        String str;
        c cVar5;
        c cVar6;
        c cVar7;
        c cVar8;
        c cVar9;
        c cVar10;
        c cVar11;
        c cVar12;
        c cVar13;
        c cVar14;
        c cVar15;
        c cVar16;
        c cVar17;
        c cVar18;
        c cVar19;
        c cVar20;
        boolean z = false;
        try {
            if (intent == null) {
                cVar17 = this.this$0.CG;
                if (cVar17 != null) {
                    cVar20 = this.this$0.CG;
                    if (TextUtils.equals(null, cVar20.pkgName)) {
                        this.this$0.lq();
                        this.this$0.CG = null;
                        this.this$0.a((c) null);
                        return;
                    }
                }
                cVar18 = this.this$0.CI;
                if (cVar18 != null) {
                    cVar19 = this.this$0.CI;
                    if (TextUtils.equals(null, cVar19.pkgName)) {
                        this.this$0.lr();
                        this.this$0.a((c) null);
                        com.baidu.adp.plugin.b.a.lE().bi("plugin_retry_install_succ");
                        return;
                    }
                }
                this.this$0.a((c) null);
                return;
            }
            try {
                str = intent.getStringExtra("package_name");
                try {
                    if (TextUtils.isEmpty(str)) {
                        cVar13 = this.this$0.CG;
                        if (cVar13 != null) {
                            cVar16 = this.this$0.CG;
                            if (TextUtils.equals(str, cVar16.pkgName)) {
                                this.this$0.lq();
                                this.this$0.CG = null;
                                this.this$0.a((c) null);
                                return;
                            }
                        }
                        cVar14 = this.this$0.CI;
                        if (cVar14 != null) {
                            cVar15 = this.this$0.CI;
                            if (TextUtils.equals(str, cVar15.pkgName)) {
                                this.this$0.lr();
                                this.this$0.a((c) null);
                                com.baidu.adp.plugin.b.a.lE().bi("plugin_retry_install_succ");
                                return;
                            }
                        }
                        this.this$0.a((c) null);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("install_src_file");
                    if (stringExtra != null && stringExtra.startsWith("assets://")) {
                        z = true;
                    }
                    String action = intent.getAction();
                    if ("com.baidu.adp.plugin.installed".equals(action)) {
                        this.this$0.e(str, z);
                        com.baidu.adp.plugin.packageManager.a.b.ms().bE(str);
                    } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                        if (z) {
                            this.this$0.CD = false;
                        }
                        this.this$0.e(str, z);
                        com.baidu.adp.plugin.packageManager.a.b.ms().j(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                    }
                    cVar9 = this.this$0.CG;
                    if (cVar9 != null) {
                        cVar12 = this.this$0.CG;
                        if (TextUtils.equals(str, cVar12.pkgName)) {
                            this.this$0.lq();
                            this.this$0.CG = null;
                            this.this$0.a((c) null);
                            return;
                        }
                    }
                    cVar10 = this.this$0.CI;
                    if (cVar10 != null) {
                        cVar11 = this.this$0.CI;
                        if (TextUtils.equals(str, cVar11.pkgName)) {
                            this.this$0.lr();
                            this.this$0.a((c) null);
                            com.baidu.adp.plugin.b.a.lE().bi("plugin_retry_install_succ");
                            return;
                        }
                    }
                    this.this$0.a((c) null);
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    cVar5 = this.this$0.CG;
                    if (cVar5 != null) {
                        cVar8 = this.this$0.CG;
                        if (TextUtils.equals(str, cVar8.pkgName)) {
                            this.this$0.lq();
                            this.this$0.CG = null;
                            this.this$0.a((c) null);
                            return;
                        }
                    }
                    cVar6 = this.this$0.CI;
                    if (cVar6 != null) {
                        cVar7 = this.this$0.CI;
                        if (TextUtils.equals(str, cVar7.pkgName)) {
                            this.this$0.lr();
                            this.this$0.a((c) null);
                            com.baidu.adp.plugin.b.a.lE().bi("plugin_retry_install_succ");
                            return;
                        }
                    }
                    this.this$0.a((c) null);
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
            } catch (Throwable th) {
                th = th;
                cVar = this.this$0.CG;
                if (cVar != null) {
                    cVar4 = this.this$0.CG;
                    if (TextUtils.equals(null, cVar4.pkgName)) {
                        this.this$0.lq();
                        this.this$0.CG = null;
                        this.this$0.a((c) null);
                        throw th;
                    }
                }
                cVar2 = this.this$0.CI;
                if (cVar2 != null) {
                    cVar3 = this.this$0.CI;
                    if (TextUtils.equals(null, cVar3.pkgName)) {
                        this.this$0.lr();
                        this.this$0.a((c) null);
                        com.baidu.adp.plugin.b.a.lE().bi("plugin_retry_install_succ");
                        throw th;
                    }
                }
                this.this$0.a((c) null);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
