package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
/* loaded from: classes7.dex */
public class f extends Observable implements IOAdDownloader, Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f2381a;
    protected URL b;
    protected String c;
    protected String d;
    protected int e;
    protected IOAdDownloader.DownloadStatus f;
    protected int g;
    protected int h;
    private boolean i;

    public f(Context context, URL url, String str, String str2, boolean z) {
        this.i = false;
        this.f2381a = context;
        this.b = url;
        this.c = str;
        this.i = z;
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
        b();
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
        c();
    }

    protected void b() {
        new Thread(this).start();
    }

    protected void a(int i, float f) {
        this.g += i;
        c();
    }

    protected void c() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        HttpURLConnection httpURLConnection2;
        IXAdLogger adLogger;
        Object[] objArr;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.b.openConnection();
            try {
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.connect();
                if (httpURLConnection3.getResponseCode() / 100 != 2) {
                    d();
                }
                int contentLength = httpURLConnection3.getContentLength();
                if (contentLength > 0) {
                    this.e = contentLength;
                }
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
                    try {
                        byte[] bArr = new byte[10240];
                        ByteArrayOutputStream byteArrayOutputStream2 = this.i ? new ByteArrayOutputStream() : null;
                        int i = 0;
                        while (this.f == IOAdDownloader.DownloadStatus.DOWNLOADING && (read = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                            try {
                                bufferedOutputStream.write(bArr, 0, read);
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                }
                                i += read;
                                a(read, i / this.e);
                            } catch (Exception e) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                bufferedInputStream2 = bufferedInputStream;
                                httpURLConnection2 = httpURLConnection3;
                                e = e;
                                try {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e.getMessage());
                                    d();
                                    if (bufferedOutputStream2 != null) {
                                        try {
                                            bufferedOutputStream2.close();
                                        } catch (Exception e2) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e2.getMessage());
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e3) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e3.getMessage());
                                        }
                                    }
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e4) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e4.getMessage());
                                        }
                                    }
                                    if (httpURLConnection2 != null) {
                                        try {
                                            httpURLConnection2.disconnect();
                                            return;
                                        } catch (Exception e5) {
                                            adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                            objArr = new Object[]{"OAdSimpleFileDownloader", e5.getMessage()};
                                            adLogger.w(objArr);
                                        }
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream2;
                                    httpURLConnection = httpURLConnection2;
                                    bufferedInputStream = bufferedInputStream2;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception e6) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e6.getMessage());
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e7) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e7.getMessage());
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (Exception e8) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e8.getMessage());
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Exception e9) {
                                            XAdSDKFoundationFacade.getInstance().getAdLogger().w("OAdSimpleFileDownloader", e9.getMessage());
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                httpURLConnection = httpURLConnection3;
                                th = th2;
                                if (bufferedOutputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        }
                        bufferedOutputStream.flush();
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.flush();
                        }
                        if (this.f == IOAdDownloader.DownloadStatus.DOWNLOADING) {
                            a();
                            a(IOAdDownloader.DownloadStatus.COMPLETED);
                        } else if (this.f == IOAdDownloader.DownloadStatus.ERROR) {
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e10) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e10.getMessage());
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e11) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e11.getMessage());
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e12) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().e("OAdSimpleFileDownloader", e12.getMessage());
                            }
                        }
                        if (httpURLConnection3 != null) {
                            try {
                                httpURLConnection3.disconnect();
                            } catch (Exception e13) {
                                adLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
                                objArr = new Object[]{"OAdSimpleFileDownloader", e13.getMessage()};
                                adLogger.w(objArr);
                            }
                        }
                    } catch (Exception e14) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream;
                        httpURLConnection2 = httpURLConnection3;
                        e = e14;
                    } catch (Throwable th3) {
                        httpURLConnection = httpURLConnection3;
                        th = th3;
                    }
                } catch (Exception e15) {
                    bufferedInputStream2 = bufferedInputStream;
                    httpURLConnection2 = httpURLConnection3;
                    e = e15;
                    bufferedOutputStream2 = null;
                } catch (Throwable th4) {
                    bufferedOutputStream = null;
                    httpURLConnection = httpURLConnection3;
                    th = th4;
                }
            } catch (Exception e16) {
                bufferedInputStream2 = null;
                httpURLConnection2 = httpURLConnection3;
                e = e16;
                bufferedOutputStream2 = null;
            } catch (Throwable th5) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection3;
                th = th5;
            }
        } catch (Exception e17) {
            e = e17;
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
            httpURLConnection2 = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
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
