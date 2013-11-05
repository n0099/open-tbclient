package com.baidu.android.nebula.cmd;

import android.content.Context;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ File f664a;
    final /* synthetic */ String b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, File file, String str) {
        this.c = hVar;
        this.f664a = file;
        this.b = str;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        String str;
        Timer timer;
        Context context;
        cancel();
        long length = this.f664a.length();
        str = this.c.f662a.mFileLength;
        if (length < Integer.parseInt(str)) {
            this.c.a(this.b);
            return;
        }
        timer = this.c.c;
        timer.cancel();
        h hVar = this.c;
        context = this.c.f662a.mContext;
        hVar.a(context, this.f664a);
    }
}
