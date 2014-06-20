package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(k kVar, String str, Context context) {
        this.c = kVar;
        this.a = str;
        this.b = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r1.exists() == false) goto L27;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3;
        String a;
        File file;
        File file2;
        FileOutputStream fileOutputStream;
        DataOutputStream dataOutputStream4;
        DataOutputStream dataOutputStream5;
        File file3;
        try {
            try {
                a = com.baidu.android.systemmonitor.security.a.a(this.a);
            } finally {
                try {
                    dataOutputStream3 = k.c;
                    dataOutputStream3.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                dataOutputStream2 = k.c;
                dataOutputStream2.flush();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            try {
                dataOutputStream = k.c;
                dataOutputStream.flush();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(a)) {
            try {
                return;
            } catch (Exception e6) {
                return;
            }
        }
        file = this.c.b;
        if (file != null) {
            file3 = this.c.b;
        }
        this.c.g();
        file2 = this.c.b;
        FileOutputStream unused = k.d = new FileOutputStream(file2, true);
        fileOutputStream = k.d;
        DataOutputStream unused2 = k.c = new DataOutputStream(fileOutputStream);
        dataOutputStream4 = k.c;
        dataOutputStream4.writeBytes(a + IOUtils.LINE_SEPARATOR_WINDOWS);
        try {
            dataOutputStream5 = k.c;
            dataOutputStream5.flush();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        if (this.b != null && com.baidu.android.moplus.util.a.b(this.b, com.baidu.android.moplus.util.a.m(this.b)) && com.baidu.android.systemmonitor.util.b.a(this.b)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.baidu.android.a.g.PV_EVENT);
            com.baidu.android.systemmonitor.a.a.a(this.b).a(arrayList);
            com.baidu.android.moplus.util.a.n(this.b);
        }
    }
}
