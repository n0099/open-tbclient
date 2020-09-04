package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends c {
    private static a bCk;
    public static JSONObject bCp;
    private b bCl;
    private String bCm;
    private File bCn;
    private boolean bCo;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bCm = str;
        this.bCn = file;
        this.bCo = z;
    }

    public static a aI(Context context) {
        if (bCk == null) {
            init(context);
        }
        bCk.setContext(context);
        return bCk;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bCk == null) {
                bCk = new a();
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
        bCp = new JSONObject();
        if (Tj) {
            try {
                bCp.put("type", com.baidu.minivideo.arface.c.bBL ? "assets" : "soloader");
                bCp.put("exist", Tj);
                bCp.put("path", this.bCn);
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
        return this.bCn != null && this.bCn.isDirectory() && this.bCn.exists();
    }

    private void Tk() {
        this.bCl = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bCp == null) {
                    a.bCp = new JSONObject();
                }
                if (a.this.bCn != null) {
                    if (a.this.bCo || !a.this.Tj()) {
                        if (!a.this.bCn.isDirectory()) {
                            try {
                                a.bCp.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bCn.delete();
                        }
                        File file = new File(a.this.bCn.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bCl.b(a.this.bCm, file);
                        if (b) {
                            try {
                                a.bCp.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bCn);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bCp.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bCn.exists()) {
                                e.deleteDir(a.this.bCn);
                            }
                        }
                        try {
                            a.bCp.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bCp.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bCp.put("sdcardPath", "null");
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
