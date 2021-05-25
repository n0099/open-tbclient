package com.baidu.mapsdkplatform.comapi.b.a;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mapsdkplatform.comapi.util.h;
import java.io.File;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f7525a;

    public d(c cVar) {
        this.f7525a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        File[] listFiles;
        String str2;
        if (h.a().b() == null) {
            return;
        }
        str = c.f7520a;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        try {
            Arrays.sort(listFiles, new e());
        } catch (Exception unused) {
        }
        int length = listFiles.length;
        if (length > 10) {
            length = 10;
        }
        for (int i2 = 0; i2 < length; i2++) {
            File file2 = listFiles[i2];
            if (!file2.isDirectory() && file2.exists() && file2.isFile()) {
                String name = file2.getName();
                str2 = c.f7521b;
                if (name.contains(str2) && (file2.getName().endsWith(DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION) || (file2.getName().endsWith(".zip") && file2.exists()))) {
                    this.f7525a.a(file2);
                }
            }
        }
        if (listFiles.length > 10) {
            this.f7525a.a(listFiles);
        }
    }
}
