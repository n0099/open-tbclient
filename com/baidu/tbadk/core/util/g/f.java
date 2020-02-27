package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.n;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.s;
import com.baidubce.http.Headers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes.dex */
public class f {
    private b dcW;
    private a dcX;
    private String mUrl;

    public f(String str, b bVar) {
        this.mUrl = str;
        this.dcW = bVar;
    }

    public void load() {
        if (TextUtils.isEmpty(this.mUrl)) {
            g.log("VideoLoaderImp url == null");
        } else if (s.wF(this.mUrl) != null) {
            if (this.dcW != null) {
                g.log("complete file has exist, 不需要下载");
                this.dcW.onSuccess(this.mUrl);
            }
        } else {
            String wH = s.wH(this.mUrl);
            if (TextUtils.isEmpty(wH)) {
                this.dcW.cz(this.mUrl, "dir is null");
                g.log("dir is null " + this.mUrl);
                return;
            }
            File file = new File(wH + "/segments");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "0");
            if (file2.exists()) {
                g.log("segment has exist " + this.mUrl);
                this.dcW.onSuccess(this.mUrl);
                return;
            }
            this.dcX = new a(this.mUrl, wH, file2.getAbsolutePath(), this.dcW);
            this.dcX.execute(new Void[0]);
        }
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<Void, Void, Boolean> {
        private b dcW;
        private String dcY;
        private String dcZ;
        private String mVideoUrl;

        public a(String str, String str2, String str3, b bVar) {
            this.mVideoUrl = str;
            this.dcY = str3;
            this.dcW = bVar;
            this.dcZ = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [179=5, 180=4, 182=4, 183=4, 184=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0220  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(Void... voidArr) {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            String str;
            try {
                g.log("start load  " + this.mVideoUrl + " des file " + this.dcY);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.mVideoUrl).openConnection();
                try {
                    httpURLConnection2.setRequestProperty(Headers.RANGE, "bytes=0-" + e.aHj().getSize());
                    int timeOutAuto = com.baidu.adp.framework.c.b.fc().fd().getTimeOutAuto();
                    if (timeOutAuto == 0) {
                        timeOutAuto = 5000;
                    }
                    g.log("connectTimeout " + timeOutAuto);
                    httpURLConnection2.setConnectTimeout(timeOutAuto);
                    int timeOutAuto2 = com.baidu.adp.framework.c.b.fc().ff().getTimeOutAuto();
                    int i = timeOutAuto2 != 0 ? timeOutAuto2 : 5000;
                    g.log("readTimeout " + i);
                    httpURLConnection2.setReadTimeout(i);
                    inputStream = httpURLConnection2.getInputStream();
                    while (inputStream == null) {
                        try {
                            try {
                                Thread.sleep(10L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            inputStream = httpURLConnection2.getInputStream();
                        } catch (Exception e2) {
                            fileOutputStream = null;
                            e = e2;
                            httpURLConnection = httpURLConnection2;
                            try {
                                g.log(e.getMessage());
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                n.close((OutputStream) fileOutputStream);
                                n.close(inputStream);
                                n.close((Writer) null);
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                n.close((OutputStream) fileOutputStream);
                                n.close(inputStream);
                                n.close((Writer) null);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            fileOutputStream = null;
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                            }
                            n.close((OutputStream) fileOutputStream);
                            n.close(inputStream);
                            n.close((Writer) null);
                            throw th;
                        }
                    }
                    str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/" + com.baidu.adp.lib.util.s.toMd5(this.mVideoUrl);
                    g.log("temp file path is   " + str + "  url: " + this.mVideoUrl);
                    fileOutputStream = new FileOutputStream(str, true);
                } catch (Exception e3) {
                    inputStream = null;
                    fileOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    e = e3;
                } catch (Throwable th3) {
                    inputStream = null;
                    fileOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                }
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    g.log("download success   des: " + this.dcY + "  mVideoUrl " + this.mVideoUrl);
                    File file = new File(str);
                    if (file.exists()) {
                        File file2 = new File(this.dcY);
                        if (file2.exists()) {
                            g.log("des file exist " + this.dcY + "  mVideoUrl " + this.mVideoUrl);
                            file.delete();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            n.close((OutputStream) fileOutputStream);
                            n.close(inputStream);
                            n.close((Writer) null);
                            return false;
                        }
                        file.renameTo(file2);
                    }
                    f.t(this.dcZ, System.currentTimeMillis());
                    new File(this.dcZ, "header_downloaded").createNewFile();
                    g.log("rename success   des: " + this.dcY + "  mVideoUrl " + this.mVideoUrl);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    n.close((OutputStream) fileOutputStream);
                    n.close(inputStream);
                    n.close((Writer) null);
                    return true;
                } catch (Exception e4) {
                    httpURLConnection = httpURLConnection2;
                    e = e4;
                    g.log(e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    n.close((OutputStream) fileOutputStream);
                    n.close(inputStream);
                    n.close((Writer) null);
                    return false;
                } catch (Throwable th4) {
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                    }
                    n.close((OutputStream) fileOutputStream);
                    n.close(inputStream);
                    n.close((Writer) null);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                httpURLConnection = null;
                inputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
                fileOutputStream = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            if (bool.booleanValue()) {
                if (this.dcW != null) {
                    this.dcW.onSuccess(this.mVideoUrl);
                }
            } else if (this.dcW != null) {
                this.dcW.cz(this.mVideoUrl, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.dcW != null) {
                this.dcW.tN(this.mVideoUrl);
            }
        }
    }

    public void release() {
        g.log("release url: " + this.mUrl);
        this.dcX = null;
        this.dcW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(String str, long j) {
        BufferedWriter bufferedWriter;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(file.getAbsolutePath() + "/accesstime")));
            try {
                try {
                    bufferedWriter.write(j + "");
                    bufferedWriter.flush();
                    n.close((Writer) bufferedWriter);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    n.close((Writer) bufferedWriter);
                }
            } catch (Throwable th) {
                th = th;
                n.close((Writer) bufferedWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
            n.close((Writer) bufferedWriter);
            throw th;
        }
    }
}
