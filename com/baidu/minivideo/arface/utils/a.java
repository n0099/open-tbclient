package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends c {
    private static a bCh;
    public static JSONObject bCm;
    private b bCi;
    private String bCj;
    private File bCk;
    private boolean bCl;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bCj = str;
        this.bCk = file;
        this.bCl = z;
    }

    public static a aI(Context context) {
        if (bCh == null) {
            init(context);
        }
        bCh.setContext(context);
        return bCh;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bCh == null) {
                bCh = new a();
            }
        }
    }

    private Context getContext() {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.get();
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        boolean Tj = Tj();
        bCm = new JSONObject();
        if (Tj) {
            try {
                bCm.put("type", com.baidu.minivideo.arface.c.bBI ? "assets" : "soloader");
                bCm.put("exist", Tj);
                bCm.put("path", this.bCk);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Tk();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean Tj() {
        return this.bCk != null && this.bCk.isDirectory() && this.bCk.exists();
    }

    private void Tk() {
        this.bCi = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bCm == null) {
                    a.bCm = new JSONObject();
                }
                if (a.this.bCk != null) {
                    if (a.this.bCl || !a.this.Tj()) {
                        if (!a.this.bCk.isDirectory()) {
                            try {
                                a.bCm.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bCk.delete();
                        }
                        File file = new File(a.this.bCk.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bCi.b(a.this.bCj, file);
                        if (b) {
                            try {
                                a.bCm.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bCk);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bCm.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bCk.exists()) {
                                e.deleteDir(a.this.bCk);
                            }
                        }
                        try {
                            a.bCm.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bCm.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bCm.put("sdcardPath", "null");
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) {
                super.onPostExecute((AnonymousClass1) bool);
                a.this.setState(bool.booleanValue() ? 2 : 3);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }
}
