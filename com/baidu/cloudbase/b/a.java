package com.baidu.cloudbase.b;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cloudbase.download.exception.DownloadException;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class a {
    public List<c> aol;
    public Map<String, Integer> aom = new HashMap();
    public Context mContext;

    /* renamed from: com.baidu.cloudbase.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0105a extends com.baidu.cloudbase.download.a.a {
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ File d;
        public final /* synthetic */ String e;
        public final /* synthetic */ c zy;

        public C0105a(c cVar, String str, File file, File file2, String str2) {
            this.zy = cVar;
            this.b = str;
            this.c = file;
            this.d = file2;
            this.e = str2;
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void c(DownloadException downloadException) {
            downloadException.printStackTrace();
            com.baidu.cloudbase.d.a.deleteFile(this.c.getAbsolutePath());
            a.this.a(this.zy, this.b, downloadException.getErrorCode(), downloadException.getErrorMessage());
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onCompleted(String str) {
            try {
                this.c.renameTo(this.d);
                Log.e("RtcDownSo", "unzip:" + this.d + "---" + this.e);
                com.baidu.cloudbase.d.a.unzipFile(this.d, this.e);
                com.baidu.cloudbase.d.a.deleteFile(this.d.getAbsolutePath());
                a.this.a(this.zy, this.b, this.e);
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.cloudbase.d.a.deleteFile(this.d.getAbsolutePath());
                if (com.baidu.cloudbase.d.a.isExists(this.e)) {
                    com.baidu.cloudbase.d.a.deleteDir(new File(this.e));
                }
                a.this.a(this.zy, this.b, 108, "unzip exception");
            }
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onProgress(long j, long j2, int i) {
            a.this.a(this.zy, this.b, i);
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onStarted() {
            a.this.a(this.zy, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b {
        public static a aon = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, String str) {
        if (cVar != null) {
            cVar.dC(str);
        }
        if (this.aol == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aol.size()) {
                return;
            }
            this.aol.get(i2).dC(str);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, String str, float f) {
        if (cVar != null) {
            cVar.p(f);
        }
        if (this.aol == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aol.size()) {
                return;
            }
            this.aol.get(i2).p(f);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, String str, int i, String str2) {
        this.aom.put(str, 2);
        if (cVar != null) {
            cVar.b(str, i, str2);
        }
        if (this.aol == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.aol.size()) {
                return;
            }
            this.aol.get(i3).b(str, i, str2);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, String str, String str2) {
        this.aom.put(str, 3);
        if (cVar != null) {
            cVar.U(str, str2);
        }
        if (this.aol == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aol.size()) {
                return;
            }
            this.aol.get(i2).U(str, str2);
            i = i2 + 1;
        }
    }

    private void a(String str, String str2, Looper looper, c cVar) {
        if (!cL(str)) {
            com.baidu.cloudbase.d.a.deleteDir(new File(str2));
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.aom.put(str, 1);
        String m = com.baidu.cloudbase.b.b.m(this.mContext, str, str2);
        File file2 = new File(m + ".temp");
        File file3 = new File(m + ".zip");
        Log.d("RtcDownSo", "start down folder=" + str2 + "name=" + file2.getName());
        com.baidu.cloudbase.download.a.uH().a(str, str2, file2.getName(), looper, new C0105a(cVar, str, file2, file3, m));
    }

    public static a ab(Context context) {
        b.aon.mContext = context.getApplicationContext();
        return b.aon;
    }

    private boolean cL(String str) {
        return com.baidu.cloudbase.download.a.uH().isRunning(str);
    }

    public boolean T(@NonNull String str, String str2) {
        return com.baidu.cloudbase.b.b.n(this.mContext, str, str2);
    }

    public void a(@NonNull String str, boolean z, c cVar) {
        String Z = com.baidu.cloudbase.b.b.Z(this.mContext);
        if (TextUtils.isEmpty(str)) {
            cVar.b(str, 108, "download url is empty.");
        } else if (T(str, Z)) {
            if (cVar != null) {
                cVar.U(str, com.baidu.cloudbase.b.b.m(this.mContext, str, Z));
            }
        } else if (!z) {
            a(str, Z, Looper.getMainLooper(), cVar);
        } else if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.d("RtcDownSo", "start down so main thread");
            a(str, Z, Looper.getMainLooper(), cVar);
        } else {
            Looper.prepare();
            Log.d("RtcDownSo", "start down so sub thread");
            a(str, Z, Looper.myLooper(), cVar);
            Looper.loop();
        }
    }

    public boolean dA(@NonNull String str) {
        File file = new File(str);
        if (file.exists()) {
            Context context = this.mContext;
            if (context == null ? false : a.a.a.c.a.c.hq().d(context, file)) {
                return true;
            }
            try {
                a.a.a.c.a.c.hq().a(this.mContext, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Context context2 = this.mContext;
            if (context2 != null) {
                return a.a.a.c.a.c.hq().d(context2, file);
            }
            return false;
        }
        return false;
    }

    public void dB(String str) {
        com.baidu.cloudbase.b.b.dz(str);
    }
}
