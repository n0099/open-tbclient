package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.mapapi.UIMsg;
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
    private b aEM;
    private a aEN;
    private String mUrl;

    public f(String str, b bVar) {
        this.mUrl = str;
        this.aEM = bVar;
    }

    public void load() {
        if (TextUtils.isEmpty(this.mUrl)) {
            g.log("VideoLoaderImp url == null");
        } else if (t.jC(this.mUrl) != null) {
            if (this.aEM != null) {
                g.log("complete file has exist, 不需要下载");
                this.aEM.onSuccess(this.mUrl);
            }
        } else {
            String jE = t.jE(this.mUrl);
            if (TextUtils.isEmpty(jE)) {
                this.aEM.aC(this.mUrl, "dir is null");
                g.log("dir is null " + this.mUrl);
                return;
            }
            File file = new File(jE + "/segments");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "0");
            if (file2.exists()) {
                g.log("segment has exist " + this.mUrl);
                this.aEM.onSuccess(this.mUrl);
                return;
            }
            this.aEN = new a(this.mUrl, jE, file2.getAbsolutePath(), this.aEM);
            this.aEN.execute(new Void[0]);
        }
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<Void, Void, Boolean> {
        private b aEM;
        private String aEO;
        private String aEP;
        private String aEQ;

        public a(String str, String str2, String str3, b bVar) {
            this.aEO = str;
            this.aEP = str3;
            this.aEM = bVar;
            this.aEQ = str2;
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
                g.log("start load  " + this.aEO + " des file " + this.aEP);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.aEO).openConnection();
                try {
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-" + e.EC().getSize());
                    int hr = com.baidu.adp.framework.c.b.hn().ho().hr();
                    if (hr == 0) {
                        hr = 5000;
                    }
                    g.log("connectTimeout " + hr);
                    httpURLConnection2.setConnectTimeout(hr);
                    int hr2 = com.baidu.adp.framework.c.b.hn().hq().hr();
                    if (hr2 != 0) {
                        i = hr2;
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
                                n.h(inputStream);
                                n.b((Writer) null);
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                n.b((OutputStream) fileOutputStream);
                                n.h(inputStream);
                                n.b((Writer) null);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            fileOutputStream = null;
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                            }
                            n.b((OutputStream) fileOutputStream);
                            n.h(inputStream);
                            n.b((Writer) null);
                            throw th;
                        }
                    }
                    str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/" + s.bC(this.aEO);
                    g.log("temp file path is   " + str + "  url: " + this.aEO);
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
                    g.log("download success   des: " + this.aEP + "  mVideoUrl " + this.aEO);
                    File file = new File(str);
                    if (file.exists()) {
                        File file2 = new File(this.aEP);
                        if (file2.exists()) {
                            g.log("des file exist " + this.aEP + "  mVideoUrl " + this.aEO);
                            file.delete();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            n.b((OutputStream) fileOutputStream);
                            n.h(inputStream);
                            n.b((Writer) null);
                            return false;
                        }
                        file.renameTo(file2);
                    }
                    f.j(this.aEQ, System.currentTimeMillis());
                    new File(this.aEQ, "header_downloaded").createNewFile();
                    g.log("rename success   des: " + this.aEP + "  mVideoUrl " + this.aEO);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    n.b((OutputStream) fileOutputStream);
                    n.h(inputStream);
                    n.b((Writer) null);
                    return true;
                } catch (Exception e4) {
                    httpURLConnection = httpURLConnection2;
                    e = e4;
                    g.log(e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    n.b((OutputStream) fileOutputStream);
                    n.h(inputStream);
                    n.b((Writer) null);
                    return false;
                } catch (Throwable th4) {
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                    }
                    n.b((OutputStream) fileOutputStream);
                    n.h(inputStream);
                    n.b((Writer) null);
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
                if (this.aEM != null) {
                    this.aEM.onSuccess(this.aEO);
                }
            } else if (this.aEM != null) {
                this.aEM.aC(this.aEO, "fail");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aEM != null) {
                this.aEM.gh(this.aEO);
            }
        }
    }

    public void release() {
        g.log("release url: " + this.mUrl);
        this.aEN = null;
        this.aEM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, long j) {
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
                    n.b((Writer) bufferedWriter);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    n.b((Writer) bufferedWriter);
                }
            } catch (Throwable th) {
                th = th;
                n.b((Writer) bufferedWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
            n.b((Writer) bufferedWriter);
            throw th;
        }
    }
}
