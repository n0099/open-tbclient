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
/* loaded from: classes19.dex */
public class d implements Runnable {
    private final com.baidu.swan.game.ad.downloader.c.d djT;
    private final DownloadInfo djZ;
    private final a dkc;
    private long dkd;

    /* loaded from: classes19.dex */
    public interface a {
        void aID();

        void aIx();
    }

    public d(com.baidu.swan.game.ad.downloader.c.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.djT = dVar;
        this.djZ = downloadInfo;
        this.dkd = downloadInfo.getProgress();
        this.dkc = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            if (this.djZ.getSize() <= 0) {
                long tF = tF(this.djZ.getUri());
                if (tF <= 0) {
                    throw new DownloadException(6, "length <= 0");
                }
                this.djZ.setSize(tF);
            }
            this.djZ.setStatus(SwanAdDownloadState.DOWNLOADING.value());
            this.djT.l(this.djZ);
            executeDownload();
        } catch (DownloadException e) {
            this.djZ.setStatus(SwanAdDownloadState.DOWNLOAD_FAILED.value());
            this.djZ.setException(e);
            this.djT.l(this.djZ);
            this.djT.b(e);
        }
    }

    private long tF(String str) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e A[Catch: Exception -> 0x00eb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00eb, blocks: (B:19:0x0099, B:21:0x009e), top: B:73:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void executeDownload() {
        ?? r3;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        RandomAccessFile randomAccessFile2 = null;
        int i = 0;
        try {
            try {
                URL url = new URL(this.djZ.getUri());
                long j = this.dkd;
                Response execute = new OkHttpClient().newCall(new Request.Builder().addHeader("RANGE", "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER).url(url).build()).execute();
                if (execute != null) {
                    inputStream = execute.body().byteStream();
                    try {
                        randomAccessFile = new RandomAccessFile(this.djZ.getPath(), "rw");
                    } catch (DownloadPauseException e) {
                    } catch (ProtocolException e2) {
                        e = e2;
                        randomAccessFile = null;
                        randomAccessFile2 = inputStream;
                    } catch (IOException e3) {
                        e = e3;
                    } catch (Exception e4) {
                        e = e4;
                    }
                    try {
                        randomAccessFile.seek(j);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            aIE();
                            i += read;
                            randomAccessFile.write(bArr, 0, read);
                            this.djZ.setProgress(this.dkd + i);
                            this.dkc.aID();
                        }
                        execute.body().close();
                        this.dkc.aIx();
                    } catch (DownloadPauseException e5) {
                        randomAccessFile2 = randomAccessFile;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return;
                            }
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                            return;
                        }
                        return;
                    } catch (ProtocolException e7) {
                        e = e7;
                        randomAccessFile2 = inputStream;
                        try {
                            throw new DownloadException(4, "Protocol error", e);
                        } catch (Throwable th) {
                            th = th;
                            r3 = randomAccessFile2;
                            randomAccessFile2 = randomAccessFile;
                            if (r3 != 0) {
                                try {
                                    r3.close();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                    throw th;
                                }
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            throw th;
                        }
                    } catch (IOException e9) {
                        e = e9;
                        throw new DownloadException(5, "IO error", e);
                    } catch (Exception e10) {
                        e = e10;
                        throw new DownloadException(9, "other error", e);
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile2 = randomAccessFile;
                        r3 = inputStream;
                        if (r3 != 0) {
                        }
                        if (randomAccessFile2 != null) {
                        }
                        throw th;
                    }
                } else {
                    randomAccessFile = null;
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
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (DownloadPauseException e12) {
            inputStream = null;
        } catch (ProtocolException e13) {
            e = e13;
            randomAccessFile = null;
        } catch (IOException e14) {
            e = e14;
        } catch (Exception e15) {
            e = e15;
        } catch (Throwable th4) {
            th = th4;
            r3 = 0;
        }
    }

    private void aIE() {
        if (this.djZ.isPause()) {
            throw new DownloadPauseException(7);
        }
    }
}
