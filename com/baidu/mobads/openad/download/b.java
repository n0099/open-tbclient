package com.baidu.mobads.openad.download;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
/* loaded from: classes2.dex */
public class b extends Observable implements IOAdDownloader, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f8421a;

    /* renamed from: b  reason: collision with root package name */
    public URL f8422b;

    /* renamed from: c  reason: collision with root package name */
    public String f8423c;

    /* renamed from: d  reason: collision with root package name */
    public String f8424d;

    /* renamed from: e  reason: collision with root package name */
    public int f8425e;

    /* renamed from: f  reason: collision with root package name */
    public IOAdDownloader.DownloadStatus f8426f;

    /* renamed from: g  reason: collision with root package name */
    public int f8427g;

    /* renamed from: h  reason: collision with root package name */
    public int f8428h;
    public byte[] i;
    public Bitmap j;
    public boolean k;
    public IXAdURIUitls l = new aa();

    public b(Context context, URL url, String str, String str2, boolean z) {
        this.k = false;
        this.f8421a = context;
        this.f8422b = url;
        this.f8423c = str;
        this.k = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.f8424d = str2;
        } else {
            String file = url.getFile();
            this.f8424d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.f8425e = -1;
        this.f8426f = IOAdDownloader.DownloadStatus.DOWNLOADING;
        this.f8427g = 0;
        this.f8428h = 0;
    }

    private void d() {
        a(IOAdDownloader.DownloadStatus.ERROR);
    }

    public void a(IOAdDownloader.DownloadStatus downloadStatus) {
        this.f8426f = downloadStatus;
        b();
    }

    public void b() {
        setChanged();
        notifyObservers();
    }

    public void c() {
        XAdSDKFoundationFacade.getInstance().getIoUtils().renameFile(this.f8423c + this.f8424d + ".tmp", this.f8423c + this.f8424d);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public void cancel() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public int getFileSize() {
        return this.f8425e;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getOutputPath() {
        return this.f8423c + this.f8424d;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public String getPackageName() {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public float getProgress() {
        return Math.abs((this.f8427g / this.f8425e) * 100.0f);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public IOAdDownloader.DownloadStatus getState() {
        return this.f8426f;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public String getTitle() {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public String getURL() {
        return this.f8422b.toString();
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public boolean isPausedManually() {
        return false;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public void pause() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void removeObservers() {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    @Deprecated
    public void resume() {
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x027c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0242 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x025f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        IXAdURIUitls iXAdURIUitls;
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        int read;
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        try {
            HttpURLConnection httpURLConnection2 = XAdSDKFoundationFacade.getInstance().getURIUitls().getHttpURLConnection(this.f8422b);
            try {
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2 = a(httpURLConnection2);
                    responseCode = httpURLConnection2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    d();
                    IXAdURIUitls iXAdURIUitls2 = this.l;
                    if (iXAdURIUitls2 != null) {
                        iXAdURIUitls2.closeHttpURLConnection(httpURLConnection2);
                        return;
                    }
                    return;
                }
                int contentLength = httpURLConnection2.getContentLength();
                if (contentLength > 0) {
                    this.f8425e = contentLength;
                }
                File file = new File(this.f8423c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    if (this.f8422b.toString().indexOf("mobads.baidu.com") == -1 && this.f8422b.toString().indexOf(".mp4") == -1 && this.f8422b.toString().indexOf(".gif") == -1) {
                        try {
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                            this.j = decodeStream;
                            if (decodeStream != null) {
                                XAdSimpleMemoryCache.getInstance().put(this.f8424d, this.j);
                                a(IOAdDownloader.DownloadStatus.COMPLETED);
                                com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new c(this));
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e2) {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e2.getMessage());
                                }
                                IXAdURIUitls iXAdURIUitls3 = this.l;
                                if (iXAdURIUitls3 != null) {
                                    iXAdURIUitls3.closeHttpURLConnection(httpURLConnection2);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = httpURLConnection2;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    byteArrayOutputStream = null;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    iXAdURIUitls = this.l;
                    if (iXAdURIUitls != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[10240];
                    ByteArrayOutputStream byteArrayOutputStream2 = this.k ? new ByteArrayOutputStream() : null;
                    int i = 0;
                    while (this.f8426f == IOAdDownloader.DownloadStatus.DOWNLOADING && (read = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        i += read;
                        a(read, i / this.f8425e);
                    }
                    bufferedOutputStream.flush();
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.flush();
                    }
                    if (this.f8426f == IOAdDownloader.DownloadStatus.DOWNLOADING) {
                        c();
                        a(IOAdDownloader.DownloadStatus.COMPLETED);
                    } else {
                        IOAdDownloader.DownloadStatus downloadStatus = IOAdDownloader.DownloadStatus.ERROR;
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e4.getMessage());
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e5) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e5.getMessage());
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e6) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e6.getMessage());
                    }
                    IXAdURIUitls iXAdURIUitls4 = this.l;
                    if (iXAdURIUitls4 != null) {
                        iXAdURIUitls4.closeHttpURLConnection(httpURLConnection2);
                    }
                } catch (Exception e7) {
                    e = e7;
                    httpURLConnection = httpURLConnection2;
                    byteArrayOutputStream = null;
                    bufferedOutputStream2 = bufferedOutputStream;
                    try {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
                        d();
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
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
                        IXAdURIUitls iXAdURIUitls5 = this.l;
                        if (iXAdURIUitls5 != null) {
                            iXAdURIUitls5.closeHttpURLConnection(httpURLConnection);
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        th = th2;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (Exception e11) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e11.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
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
                        iXAdURIUitls = this.l;
                        if (iXAdURIUitls != null) {
                            iXAdURIUitls.closeHttpURLConnection(httpURLConnection);
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    httpURLConnection = httpURLConnection2;
                    byteArrayOutputStream = null;
                    bufferedOutputStream2 = bufferedOutputStream;
                    th = th2;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    iXAdURIUitls = this.l;
                    if (iXAdURIUitls != null) {
                    }
                    throw th;
                }
            } catch (Exception e14) {
                e = e14;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection2;
                byteArrayOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection2;
                byteArrayOutputStream = null;
            }
        } catch (Exception e15) {
            e = e15;
            byteArrayOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void setPausedManually(boolean z) {
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloader
    public void start() {
        a(IOAdDownloader.DownloadStatus.DOWNLOADING);
        a();
    }

    public void a() {
        com.baidu.mobads.f.c.a().a(this);
    }

    public void a(int i, float f2) {
        this.f8427g += i;
        b();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.f8422b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }
}
