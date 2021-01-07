package com.baidu.swan.game.ad.downloader.core;

import android.os.Process;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.exception.DownloadPauseException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d implements Runnable {
    private final com.baidu.swan.game.ad.downloader.c.d eaH;
    private final DownloadInfo eaM;
    private final a eaP;
    private long eaQ;

    /* loaded from: classes3.dex */
    public interface a {
        void aVd();

        void aVj();
    }

    public d(com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.eaH = dVar;
        this.eaM = downloadInfo;
        this.eaQ = downloadInfo.getProgress();
        this.eaP = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            if (this.eaM.getSize() <= 0) {
                long vT = vT(this.eaM.getUri());
                if (vT <= 0) {
                    throw new DownloadException(6, "length <= 0");
                }
                this.eaM.setSize(vT);
            }
            this.eaM.setStatus(SwanAdDownloadState.DOWNLOADING.value());
            this.eaH.l(this.eaM);
            executeDownload();
        } catch (DownloadException e) {
            this.eaM.setStatus(SwanAdDownloadState.DOWNLOAD_FAILED.value());
            this.eaM.setException(e);
            this.eaH.l(this.eaM);
            this.eaH.b(e);
        }
    }

    private long vT(String str) {
        try {
            Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
            if (execute == null || !execute.isSuccessful()) {
                return 0L;
            }
            long contentLength = execute.body().contentLength();
            execute.body().close();
            return contentLength;
        } catch (MalformedURLException e) {
            throw new DownloadException(2, "Bad url.", e);
        } catch (ProtocolException e2) {
            throw new DownloadException(4, "Protocol error", e2);
        } catch (IOException e3) {
            throw new DownloadException(5, "IO error", e3);
        } catch (Exception e4) {
            throw new DownloadException(9, "Unknown error", e4);
        }
    }

    private void executeDownload() {
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        RandomAccessFile randomAccessFile2;
        int i = 0;
        try {
            try {
                URL url = new URL(this.eaM.getUri());
                long j = this.eaQ;
                Response execute = new OkHttpClient().newCall(new Request.Builder().addHeader("RANGE", "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER).url(url).build()).execute();
                if (execute != null) {
                    inputStream = execute.body().byteStream();
                    try {
                        randomAccessFile2 = new RandomAccessFile(this.eaM.getPath(), "rw");
                        try {
                            randomAccessFile2.seek(j);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                aVk();
                                i += read;
                                randomAccessFile2.write(bArr, 0, read);
                                this.eaM.setProgress(this.eaQ + i);
                                this.eaP.aVj();
                            }
                            execute.body().close();
                            this.eaP.aVd();
                        } catch (DownloadPauseException e) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                                return;
                            }
                            return;
                        } catch (ProtocolException e3) {
                            e = e3;
                            throw new DownloadException(4, "Protocol error", e);
                        } catch (IOException e4) {
                            e = e4;
                            throw new DownloadException(5, "IO error", e);
                        } catch (Exception e5) {
                            e = e5;
                            throw new DownloadException(9, "other error", e);
                        }
                    } catch (DownloadPauseException e6) {
                        randomAccessFile2 = null;
                    } catch (ProtocolException e7) {
                        e = e7;
                    } catch (IOException e8) {
                        e = e8;
                    } catch (Exception e9) {
                        e = e9;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = null;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                throw th;
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                } else {
                    randomAccessFile2 = null;
                    inputStream = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return;
                    }
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (DownloadPauseException e12) {
            randomAccessFile2 = null;
            inputStream = null;
        } catch (ProtocolException e13) {
            e = e13;
        } catch (IOException e14) {
            e = e14;
        } catch (Exception e15) {
            e = e15;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            inputStream = null;
        }
    }

    private void aVk() {
        if (this.eaM.isPause()) {
            throw new DownloadPauseException(7);
        }
    }
}
