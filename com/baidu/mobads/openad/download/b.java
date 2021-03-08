package com.baidu.mobads.openad.download;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
/* loaded from: classes4.dex */
public class b extends Observable implements IOAdDownloader, Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f2441a;
    protected URL b;
    protected String c;
    protected String d;
    protected int e;
    protected IOAdDownloader.DownloadStatus f;
    protected int g;
    protected int h;
    protected byte[] i;
    protected Bitmap j;
    private boolean k;
    private IXAdURIUitls l = new aa();

    public b(Context context, URL url, String str, String str2, boolean z) {
        this.k = false;
        this.f2441a = context;
        this.b = url;
        this.c = str;
        this.k = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.d = str2;
        } else {
            String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.e = -1;
        this.f = IOAdDownloader.DownloadStatus.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public void pause() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public void cancel() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public void resume() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void start() {
        a(IOAdDownloader.DownloadStatus.DOWNLOADING);
        a();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getURL() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public int getFileSize() {
        return this.e;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public float getProgress() {
        return Math.abs((this.g / this.e) * 100.0f);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public IOAdDownloader.DownloadStatus getState() {
        return this.f;
    }

    protected void a(IOAdDownloader.DownloadStatus downloadStatus) {
        this.f = downloadStatus;
        b();
    }

    protected void a() {
        com.baidu.mobads.f.c.a().a(this);
    }

    protected void a(int i, float f) {
        this.g += i;
        b();
    }

    protected void b() {
        setChanged();
        notifyObservers();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getOutputPath() {
        return this.c + this.d;
    }

    private void d() {
        a(IOAdDownloader.DownloadStatus.ERROR);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [322=5, 324=4, 325=4, 326=4, 329=4, 331=4, 332=4, 333=4, 337=4, 339=4, 340=4, 341=4, 344=4, 345=4] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0292 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Exception exc;
        int read;
        BufferedOutputStream bufferedOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = XAdSDKFoundationFacade.getInstance().getURIUitls().getHttpURLConnection(this.b);
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection = a(httpURLConnection);
                    responseCode = httpURLConnection.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    d();
                }
                int contentLength = httpURLConnection.getContentLength();
                if (contentLength > 0) {
                    this.e = contentLength;
                }
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    if (this.b.toString().indexOf("mobads.baidu.com") == -1 && this.b.toString().indexOf(".mp4") == -1 && this.b.toString().indexOf(".gif") == -1) {
                        try {
                            this.j = BitmapFactory.decodeStream(bufferedInputStream);
                            if (this.j != null) {
                                XAdSimpleMemoryCache.getInstance().put(this.d, this.j);
                                a(IOAdDownloader.DownloadStatus.COMPLETED);
                                com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new c(this));
                                if (0 != 0) {
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (Exception e) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
                                    }
                                }
                                if (0 != 0) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e2) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e2.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e3) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e3.getMessage());
                                    }
                                }
                                if (this.l != null) {
                                    this.l.closeHttpURLConnection(httpURLConnection);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                        }
                    }
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
                    try {
                        byte[] bArr = new byte[10240];
                        ByteArrayOutputStream byteArrayOutputStream3 = this.k ? new ByteArrayOutputStream() : null;
                        int i = 0;
                        while (this.f == IOAdDownloader.DownloadStatus.DOWNLOADING && (read = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                            try {
                                bufferedOutputStream.write(bArr, 0, read);
                                if (byteArrayOutputStream3 != null) {
                                    byteArrayOutputStream3.write(bArr, 0, read);
                                }
                                i += read;
                                a(read, i / this.e);
                            } catch (Exception e4) {
                                exc = e4;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                try {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", exc.getMessage());
                                    d();
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception e5) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e5.getMessage());
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e6) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e6.getMessage());
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e7) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e7.getMessage());
                                        }
                                    }
                                    if (this.l != null) {
                                        this.l.closeHttpURLConnection(httpURLConnection);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception e8) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e8.getMessage());
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e9) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e9.getMessage());
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e10) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e10.getMessage());
                                        }
                                    }
                                    if (this.l != null) {
                                        this.l.closeHttpURLConnection(httpURLConnection);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                if (bufferedOutputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                if (this.l != null) {
                                }
                                throw th;
                            }
                        }
                        bufferedOutputStream.flush();
                        if (byteArrayOutputStream3 != null) {
                            byteArrayOutputStream3.flush();
                        }
                        if (this.f == IOAdDownloader.DownloadStatus.DOWNLOADING) {
                            c();
                            a(IOAdDownloader.DownloadStatus.COMPLETED);
                        } else if (this.f == IOAdDownloader.DownloadStatus.ERROR) {
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e11) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e11.getMessage());
                            }
                        }
                        if (byteArrayOutputStream3 != null) {
                            try {
                                byteArrayOutputStream3.close();
                            } catch (Exception e12) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e12.getMessage());
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e13) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e13.getMessage());
                            }
                        }
                        if (this.l != null) {
                            this.l.closeHttpURLConnection(httpURLConnection);
                        }
                    } catch (Exception e14) {
                        exc = e14;
                        byteArrayOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream = null;
                    }
                } catch (Exception e15) {
                    exc = e15;
                    byteArrayOutputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    bufferedOutputStream = null;
                }
            } catch (Exception e16) {
                exc = e16;
                byteArrayOutputStream = null;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                byteArrayOutputStream = null;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Exception e17) {
            exc = e17;
            byteArrayOutputStream = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        while (true) {
            try {
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection2;
                }
                this.b = new URL(httpURLConnection2.getHeaderField(Headers.LOCATION));
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.b.openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setInstanceFollowRedirects(false);
                    httpURLConnection3.setRequestProperty(Headers.RANGE, "bytes=0-");
                    httpURLConnection2 = httpURLConnection3;
                } catch (Exception e) {
                    return httpURLConnection3;
                }
            } catch (Exception e2) {
                return httpURLConnection2;
            }
        }
    }

    protected void c() {
        XAdSDKFoundationFacade.getInstance().getIoUtils().renameFile(this.c + this.d + ".tmp", this.c + this.d);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public String getTitle() {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public String getPackageName() {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void removeObservers() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public boolean isPausedManually() {
        return false;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void setPausedManually(boolean z) {
    }
}
