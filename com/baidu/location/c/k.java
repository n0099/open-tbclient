package com.baidu.location.c;

import android.os.Environment;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Thread {
    final /* synthetic */ e JS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.JS = eVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.JS.a(new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
