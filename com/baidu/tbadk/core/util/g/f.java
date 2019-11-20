package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.t;
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
    private b cll;
    private a clm;
    private String mUrl;

    public f(String str, b bVar) {
        this.mUrl = str;
        this.cll = bVar;
    }

    public void load() {
        if (TextUtils.isEmpty(this.mUrl)) {
            g.log("VideoLoaderImp url == null");
        } else if (t.qY(this.mUrl) != null) {
            if (this.cll != null) {
                g.log("complete file has exist, 不需要下载");
                this.cll.onSuccess(this.mUrl);
            }
        } else {
            String ra = t.ra(this.mUrl);
            if (TextUtils.isEmpty(ra)) {
                this.cll.bT(this.mUrl, "dir is null");
                g.log("dir is null " + this.mUrl);
                return;
            }
            File file = new File(ra + "/segments");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "0");
            if (file2.exists()) {
                g.log("segment has exist " + this.mUrl);
                this.cll.onSuccess(this.mUrl);
                return;
            }
            this.clm = new a(this.mUrl, ra, file2.getAbsolutePath(), this.cll);
            this.clm.execute(new Void[0]);
        }
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<Void, Void, Boolean> {
        private b cll;
        private String cln;
        private String clo;
        private String clp;

        public a(String str, String str2, String str3, b bVar) {
            this.cln = str;
            this.clo = str3;
            this.cll = bVar;
            this.clp = str2;
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
                g.log("start load  " + this.cln + " des file " + this.clo);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.cln).openConnection();
                try {
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-" + e.ann().getSize());
                    int timeOutAuto = com.baidu.adp.framework.c.b.eH().eI().getTimeOutAuto();
                    if (timeOutAuto == 0) {
                        timeOutAuto = 5000;
                    }
                    g.log("connectTimeout " + timeOutAuto);
                    httpURLConnection2.setConnectTimeout(timeOutAuto);
                    int timeOutAuto2 = com.baidu.adp.framework.c.b.eH().eK().getTimeOutAuto();
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
                    str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/" + s.toMd5(this.cln);
                    g.log("temp file path is   " + str + "  url: " + this.cln);
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
                    g.log("download success   des: " + this.clo + "  mVideoUrl " + this.cln);
                    File file = new File(str);
                    if (file.exists()) {
                        File file2 = new File(this.clo);
                        if (file2.exists()) {
                            g.log("des file exist " + this.clo + "  mVideoUrl " + this.cln);
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
                    f.q(this.clp, System.currentTimeMillis());
                    new File(this.clp, "header_downloaded").createNewFile();
                    g.log("rename success   des: " + this.clo + "  mVideoUrl " + this.cln);
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
                if (this.cll != null) {
                    this.cll.onSuccess(this.cln);
                }
            } else if (this.cll != null) {
                this.cll.bT(this.cln, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cll != null) {
                this.cll.op(this.cln);
            }
        }
    }

    public void release() {
        g.log("release url: " + this.mUrl);
        this.clm = null;
        this.cll = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(String str, long j) {
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
