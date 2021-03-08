package com.baidu.minivideo.arface.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class j {
    private File cma;
    private File cmb;
    private List<b> cmw = new ArrayList();
    private a cmx;
    private com.baidu.minivideo.arface.a.a cmy;
    private int mProgress;
    private long mTotalSize;
    private String mUrl;

    public j(String str, File file) {
        this.mUrl = str;
        this.cma = file;
        this.cmb = new File(this.cma.getAbsolutePath() + ".loading");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public boolean isLoaded() {
        return this.cma != null && this.cma.exists();
    }

    public boolean isLoading() {
        return this.cmx != null && this.cmx.isLoading();
    }

    public File getLocalFile() {
        return this.cma;
    }

    public void a(b bVar) {
        if (isLoaded()) {
            if (bVar != null) {
                bVar.f(this, this.cma.getAbsolutePath());
                return;
            }
            return;
        }
        if (bVar != null && !this.cmw.contains(bVar)) {
            this.cmw.add(bVar);
        }
        acu();
    }

    private void acu() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    if (this.cmx == null) {
                        this.cmx = new a();
                        this.cmx.K(this);
                    }
                    com.baidu.minivideo.arface.a.b abK = com.baidu.minivideo.arface.b.abK();
                    if (abK != null) {
                        abK.a(this.mUrl, this.cmb.getParent(), this.cmb.getName(), this.cmx);
                    }
                }
            }
        }
    }

    protected boolean jn(String str) {
        boolean z;
        boolean z2 = true;
        File file = new File(str);
        try {
            if (isDebug()) {
                d("onCompleted-unzip:" + str + "\nto " + this.cma.getAbsolutePath());
            }
            File file2 = new File(this.cma + ".ziping");
            if (file2.exists()) {
                if (isDebug()) {
                    d("delete older exists " + file2);
                }
                com.baidu.minivideo.arface.utils.f.deleteFileOrDir(file2);
            }
            try {
                com.baidu.minivideo.arface.utils.j.c(file, file2);
                z = true;
            } catch (Exception e) {
                d("unzipFile Exception : " + e.getMessage() + " " + str);
                z = false;
            }
            if (!z || !n(file2)) {
                z2 = false;
            }
            if (!z2) {
                if (isDebug()) {
                    d("faild on afterUnziped " + file2);
                }
                com.baidu.minivideo.arface.utils.f.deleteFileOrDir(file2);
            } else {
                z2 &= file2.renameTo(this.cma);
            }
        } catch (Exception e2) {
            d("Exception on onFileLoaderCompledted " + e2.getMessage());
            e2.printStackTrace();
            z2 = false;
        }
        com.baidu.minivideo.arface.utils.f.q(file);
        return z2;
    }

    protected boolean n(File file) {
        return true;
    }

    protected boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(String str) {
        Log.d("DuAr_FileLoader", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a<T> implements com.baidu.minivideo.arface.a.a {
        private T cmz;
        private boolean mIsLoading;

        private a() {
        }

        public void K(T t) {
            this.cmz = t;
        }

        public boolean isLoading() {
            return this.mIsLoading;
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onStarted() {
            this.mIsLoading = true;
            if (j.this.isDebug()) {
                d("onStarted");
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= j.this.cmw.size()) {
                    break;
                }
                b bVar = (b) j.this.cmw.get(i2);
                if (bVar != null) {
                    bVar.L(this.cmz);
                }
                i = i2 + 1;
            }
            if (j.this.cmy != null) {
                j.this.cmy.onStarted();
            }
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onConnected(long j, boolean z) {
            if (j.this.isDebug()) {
                d("onConnected: " + j + ", " + z);
            }
            j.this.mTotalSize = j;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= j.this.cmw.size()) {
                    break;
                }
                b bVar = (b) j.this.cmw.get(i2);
                if (bVar != null) {
                    bVar.a(this.cmz, j, z);
                }
                i = i2 + 1;
            }
            if (j.this.cmy != null) {
                j.this.cmy.onConnected(j, z);
            }
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onProgress(long j, long j2, int i) {
            if (i != j.this.mProgress) {
                j.this.mTotalSize = j2;
                j.this.mProgress = i;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= j.this.cmw.size()) {
                        break;
                    }
                    b bVar = (b) j.this.cmw.get(i3);
                    if (bVar != null) {
                        bVar.a(this.cmz, j, j2, i);
                    }
                    i2 = i3 + 1;
                }
                if (j.this.cmy != null) {
                    j.this.cmy.onProgress(j, j2, i);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.minivideo.arface.b.j$a$1] */
        @Override // com.baidu.minivideo.arface.a.a
        public void onCompleted(final String str) {
            if (j.this.isDebug()) {
                d("onCompleted(download): " + str);
            }
            new Thread() { // from class: com.baidu.minivideo.arface.b.j.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    j.this.jn(str);
                    a.this.k(null);
                }
            }.start();
            this.mIsLoading = false;
        }

        protected void k(final Exception exc) {
            if (j.this.cmw != null && !j.this.cmw.isEmpty()) {
                final boolean isLoaded = j.this.isLoaded();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.minivideo.arface.b.j.a.2
                    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: com.baidu.minivideo.arface.b.j$b */
                    /* JADX DEBUG: Multi-variable search result rejected for r0v33, resolved type: com.baidu.minivideo.arface.b.j$b */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        if (isLoaded) {
                            while (true) {
                                int i2 = i;
                                if (i2 >= j.this.cmw.size()) {
                                    break;
                                }
                                b bVar = (b) j.this.cmw.get(i2);
                                if (bVar != 0) {
                                    bVar.f(a.this.cmz, j.this.cma.getAbsolutePath());
                                }
                                i = i2 + 1;
                            }
                            if (j.this.cmy != null) {
                                j.this.cmy.onCompleted(j.this.cma.getAbsolutePath());
                                return;
                            }
                            return;
                        }
                        while (true) {
                            int i3 = i;
                            if (i3 >= j.this.cmw.size()) {
                                break;
                            }
                            b bVar2 = (b) j.this.cmw.get(i3);
                            if (bVar2 != 0) {
                                bVar2.a(a.this.cmz, exc);
                            }
                            i = i3 + 1;
                        }
                        if (j.this.cmy != null) {
                            j.this.cmy.onFailed(exc);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onDownloadPaused() {
            if (j.this.isDebug()) {
                d("onDownloadPaused");
            }
            for (int i = 0; i < j.this.cmw.size(); i++) {
                b bVar = (b) j.this.cmw.get(i);
                if (bVar != null) {
                    bVar.onDownloadPaused(this.cmz);
                }
            }
            if (j.this.cmy != null) {
                j.this.cmy.onDownloadPaused();
            }
            this.mIsLoading = false;
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onDownloadCanceled() {
            if (j.this.isDebug()) {
                d("onDownloadCanceled");
            }
            for (int i = 0; i < j.this.cmw.size(); i++) {
                b bVar = (b) j.this.cmw.get(i);
                if (bVar != null) {
                    bVar.M(this.cmz);
                }
            }
            if (j.this.cmy != null) {
                j.this.cmy.onDownloadCanceled();
            }
            this.mIsLoading = false;
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onFailed(Exception exc) {
            if (j.this.isDebug()) {
                d("onFailed: " + j.this.mUrl + "\n" + (exc != null ? exc.getMessage() : ""));
            }
            if (j.this.cmb.exists()) {
                j.this.cmb.delete();
            }
            for (int i = 0; i < j.this.cmw.size(); i++) {
                b bVar = (b) j.this.cmw.get(i);
                if (bVar != null) {
                    bVar.a(this.cmz, exc);
                }
            }
            if (j.this.cmy != null) {
                j.this.cmy.onFailed(exc);
            }
            this.mIsLoading = false;
        }

        private void d(String str) {
            j.d("res:" + str);
        }
    }

    /* loaded from: classes5.dex */
    public static class b<T> {
        public void L(T t) {
        }

        public void a(T t, long j, boolean z) {
        }

        public void a(T t, long j, long j2, int i) {
        }

        public void onDownloadPaused(T t) {
        }

        public void M(T t) {
        }

        public void f(T t, String str) {
        }

        public void a(T t, Exception exc) {
        }
    }
}
