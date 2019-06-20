package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.mapapi.UIMsg;
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
    private b bUY;
    private a bUZ;
    private String mUrl;

    public f(String str, b bVar) {
        this.mUrl = str;
        this.bUY = bVar;
    }

    public void load() {
        if (TextUtils.isEmpty(this.mUrl)) {
            g.log("VideoLoaderImp url == null");
        } else if (t.rL(this.mUrl) != null) {
            if (this.bUY != null) {
                g.log("complete file has exist, 不需要下载");
                this.bUY.onSuccess(this.mUrl);
            }
        } else {
            String rN = t.rN(this.mUrl);
            if (TextUtils.isEmpty(rN)) {
                this.bUY.bV(this.mUrl, "dir is null");
                g.log("dir is null " + this.mUrl);
                return;
            }
            File file = new File(rN + "/segments");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "0");
            if (file2.exists()) {
                g.log("segment has exist " + this.mUrl);
                this.bUY.onSuccess(this.mUrl);
                return;
            }
            this.bUZ = new a(this.mUrl, rN, file2.getAbsolutePath(), this.bUY);
            this.bUZ.execute(new Void[0]);
        }
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<Void, Void, Boolean> {
        private b bUY;
        private String bVa;
        private String bVb;
        private String bVc;

        public a(String str, String str2, String str3, b bVar) {
            this.bVa = str;
            this.bVb = str3;
            this.bUY = bVar;
            this.bVc = str2;
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
            int i = UIMsg.m_AppUI.MSG_APP_GPS;
            try {
                g.log("start load  " + this.bVa + " des file " + this.bVb);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.bVa).openConnection();
                try {
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-" + e.aiV().getSize());
                    int gi = com.baidu.adp.framework.c.b.ge().gf().gi();
                    if (gi == 0) {
                        gi = 5000;
                    }
                    g.log("connectTimeout " + gi);
                    httpURLConnection2.setConnectTimeout(gi);
                    int gi2 = com.baidu.adp.framework.c.b.ge().gh().gi();
                    if (gi2 != 0) {
                        i = gi2;
                    }
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
                                n.b((OutputStream) fileOutputStream);
                                n.g(inputStream);
                                n.a((Writer) null);
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                n.b((OutputStream) fileOutputStream);
                                n.g(inputStream);
                                n.a((Writer) null);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            fileOutputStream = null;
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                            }
                            n.b((OutputStream) fileOutputStream);
                            n.g(inputStream);
                            n.a((Writer) null);
                            throw th;
                        }
                    }
                    str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/" + s.bm(this.bVa);
                    g.log("temp file path is   " + str + "  url: " + this.bVa);
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
                    g.log("download success   des: " + this.bVb + "  mVideoUrl " + this.bVa);
                    File file = new File(str);
                    if (file.exists()) {
                        File file2 = new File(this.bVb);
                        if (file2.exists()) {
                            g.log("des file exist " + this.bVb + "  mVideoUrl " + this.bVa);
                            file.delete();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            n.b((OutputStream) fileOutputStream);
                            n.g(inputStream);
                            n.a((Writer) null);
                            return false;
                        }
                        file.renameTo(file2);
                    }
                    f.m(this.bVc, System.currentTimeMillis());
                    new File(this.bVc, "header_downloaded").createNewFile();
                    g.log("rename success   des: " + this.bVb + "  mVideoUrl " + this.bVa);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    n.b((OutputStream) fileOutputStream);
                    n.g(inputStream);
                    n.a((Writer) null);
                    return true;
                } catch (Exception e4) {
                    httpURLConnection = httpURLConnection2;
                    e = e4;
                    g.log(e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    n.b((OutputStream) fileOutputStream);
                    n.g(inputStream);
                    n.a((Writer) null);
                    return false;
                } catch (Throwable th4) {
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                    }
                    n.b((OutputStream) fileOutputStream);
                    n.g(inputStream);
                    n.a((Writer) null);
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
                if (this.bUY != null) {
                    this.bUY.onSuccess(this.bVa);
                }
            } else if (this.bUY != null) {
                this.bUY.bV(this.bVa, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bUY != null) {
                this.bUY.oq(this.bVa);
            }
        }
    }

    public void release() {
        g.log("release url: " + this.mUrl);
        this.bUZ = null;
        this.bUY = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(String str, long j) {
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
                    n.a(bufferedWriter);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    n.a(bufferedWriter);
                }
            } catch (Throwable th) {
                th = th;
                n.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
            n.a(bufferedWriter);
            throw th;
        }
    }
}
