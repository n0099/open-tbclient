package com.baidu.minivideo.arface.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j {
    private File ckA;
    private File ckB;
    private List<b> ckV = new ArrayList();
    private a ckW;
    private com.baidu.minivideo.arface.a.a ckX;
    private int mProgress;
    private long mTotalSize;
    private String mUrl;

    public j(String str, File file) {
        this.mUrl = str;
        this.ckA = file;
        this.ckB = new File(this.ckA.getAbsolutePath() + ".loading");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public boolean isLoaded() {
        return this.ckA != null && this.ckA.exists();
    }

    public boolean isLoading() {
        return this.ckW != null && this.ckW.isLoading();
    }

    public File getLocalFile() {
        return this.ckA;
    }

    public void a(b bVar) {
        if (isLoaded()) {
            if (bVar != null) {
                bVar.e(this, this.ckA.getAbsolutePath());
                return;
            }
            return;
        }
        if (bVar != null && !this.ckV.contains(bVar)) {
            this.ckV.add(bVar);
        }
        acr();
    }

    private void acr() {
        if (!isLoaded() && !isLoading()) {
            synchronized (this) {
                if (!isLoaded() && !isLoading()) {
                    if (this.ckW == null) {
                        this.ckW = new a();
                        this.ckW.I(this);
                    }
                    com.baidu.minivideo.arface.a.b abH = com.baidu.minivideo.arface.b.abH();
                    if (abH != null) {
                        abH.a(this.mUrl, this.ckB.getParent(), this.ckB.getName(), this.ckW);
                    }
                }
            }
        }
    }

    protected boolean jh(String str) {
        boolean z;
        boolean z2 = true;
        File file = new File(str);
        try {
            if (isDebug()) {
                d("onCompleted-unzip:" + str + "\nto " + this.ckA.getAbsolutePath());
            }
            File file2 = new File(this.ckA + ".ziping");
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
                z2 &= file2.renameTo(this.ckA);
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
    /* loaded from: classes3.dex */
    public class a<T> implements com.baidu.minivideo.arface.a.a {
        private T ckY;
        private boolean mIsLoading;

        private a() {
        }

        public void I(T t) {
            this.ckY = t;
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
                if (i2 >= j.this.ckV.size()) {
                    break;
                }
                b bVar = (b) j.this.ckV.get(i2);
                if (bVar != null) {
                    bVar.J(this.ckY);
                }
                i = i2 + 1;
            }
            if (j.this.ckX != null) {
                j.this.ckX.onStarted();
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
                if (i2 >= j.this.ckV.size()) {
                    break;
                }
                b bVar = (b) j.this.ckV.get(i2);
                if (bVar != null) {
                    bVar.a(this.ckY, j, z);
                }
                i = i2 + 1;
            }
            if (j.this.ckX != null) {
                j.this.ckX.onConnected(j, z);
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
                    if (i3 >= j.this.ckV.size()) {
                        break;
                    }
                    b bVar = (b) j.this.ckV.get(i3);
                    if (bVar != null) {
                        bVar.a(this.ckY, j, j2, i);
                    }
                    i2 = i3 + 1;
                }
                if (j.this.ckX != null) {
                    j.this.ckX.onProgress(j, j2, i);
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
                    j.this.jh(str);
                    a.this.k(null);
                }
            }.start();
            this.mIsLoading = false;
        }

        protected void k(final Exception exc) {
            if (j.this.ckV != null && !j.this.ckV.isEmpty()) {
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
                                if (i2 >= j.this.ckV.size()) {
                                    break;
                                }
                                b bVar = (b) j.this.ckV.get(i2);
                                if (bVar != 0) {
                                    bVar.e(a.this.ckY, j.this.ckA.getAbsolutePath());
                                }
                                i = i2 + 1;
                            }
                            if (j.this.ckX != null) {
                                j.this.ckX.onCompleted(j.this.ckA.getAbsolutePath());
                                return;
                            }
                            return;
                        }
                        while (true) {
                            int i3 = i;
                            if (i3 >= j.this.ckV.size()) {
                                break;
                            }
                            b bVar2 = (b) j.this.ckV.get(i3);
                            if (bVar2 != 0) {
                                bVar2.a(a.this.ckY, exc);
                            }
                            i = i3 + 1;
                        }
                        if (j.this.ckX != null) {
                            j.this.ckX.onFailed(exc);
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
            for (int i = 0; i < j.this.ckV.size(); i++) {
                b bVar = (b) j.this.ckV.get(i);
                if (bVar != null) {
                    bVar.onDownloadPaused(this.ckY);
                }
            }
            if (j.this.ckX != null) {
                j.this.ckX.onDownloadPaused();
            }
            this.mIsLoading = false;
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onDownloadCanceled() {
            if (j.this.isDebug()) {
                d("onDownloadCanceled");
            }
            for (int i = 0; i < j.this.ckV.size(); i++) {
                b bVar = (b) j.this.ckV.get(i);
                if (bVar != null) {
                    bVar.K(this.ckY);
                }
            }
            if (j.this.ckX != null) {
                j.this.ckX.onDownloadCanceled();
            }
            this.mIsLoading = false;
        }

        @Override // com.baidu.minivideo.arface.a.a
        public void onFailed(Exception exc) {
            if (j.this.isDebug()) {
                d("onFailed: " + j.this.mUrl + "\n" + (exc != null ? exc.getMessage() : ""));
            }
            if (j.this.ckB.exists()) {
                j.this.ckB.delete();
            }
            for (int i = 0; i < j.this.ckV.size(); i++) {
                b bVar = (b) j.this.ckV.get(i);
                if (bVar != null) {
                    bVar.a(this.ckY, exc);
                }
            }
            if (j.this.ckX != null) {
                j.this.ckX.onFailed(exc);
            }
            this.mIsLoading = false;
        }

        private void d(String str) {
            j.d("res:" + str);
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> {
        public void J(T t) {
        }

        public void a(T t, long j, boolean z) {
        }

        public void a(T t, long j, long j2, int i) {
        }

        public void onDownloadPaused(T t) {
        }

        public void K(T t) {
        }

        public void e(T t, String str) {
        }

        public void a(T t, Exception exc) {
        }
    }
}
