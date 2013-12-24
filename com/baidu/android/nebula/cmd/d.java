package com.baidu.android.nebula.cmd;

import android.content.Context;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends TimerTask {
    final /* synthetic */ File a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, File file, String str) {
        this.c = bVar;
        this.a = file;
        this.b = str;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        String str;
        Timer timer;
        Context context;
        cancel();
        long length = this.a.length();
        str = this.c.a.mFileLength;
        if (length < Integer.parseInt(str)) {
            this.c.a(this.b);
            return;
        }
        timer = this.c.c;
        timer.cancel();
        b bVar = this.c;
        context = this.c.a.mContext;
        bVar.a(context, this.a);
    }
}
