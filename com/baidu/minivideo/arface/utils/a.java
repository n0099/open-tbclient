package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d {
    private static a cne;
    public static JSONObject cnj;
    private c cnf;
    private String cng;
    private File cnh;
    private boolean cni;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.cng = str;
        this.cnh = file;
        this.cni = z;
    }

    public static a bG(Context context) {
        if (cne == null) {
            init(context);
        }
        cne.setContext(context);
        return cne;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (cne == null) {
                cne = new a();
            }
        }
    }

    private Context getContext() {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.get();
    }

    @Override // com.baidu.minivideo.arface.utils.d
    protected void run() {
        boolean acD = acD();
        cnj = new JSONObject();
        if (acD) {
            try {
                cnj.put("type", com.baidu.minivideo.arface.c.clj ? "assets" : "soloader");
                cnj.put("exist", acD);
                cnj.put("path", this.cnh);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                i.d("ARSourceCopyManager", "sdk exist + " + cnj.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    i.d("ARSourceCopyManager", "sdk loading .. to " + this.cnh.getAbsoluteFile());
                }
                acE();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean acD() {
        return this.cnh != null && this.cnh.isDirectory() && this.cnh.exists();
    }

    private void acE() {
        this.cnf = new c(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.cnj == null) {
                    a.cnj = new JSONObject();
                }
                if (a.this.cnh != null) {
                    if (a.this.cni || !a.this.acD()) {
                        if (!a.this.cnh.isDirectory()) {
                            try {
                                a.cnj.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.cnh.delete();
                        }
                        File file = new File(a.this.cnh.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.cnf.assetToSD(a.this.cng, file);
                        if (assetToSD) {
                            try {
                                a.cnj.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.cnh);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.cnj.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            f.deleteDir(file);
                            if (a.this.cnh.exists()) {
                                f.deleteDir(a.this.cnh);
                            }
                        }
                        try {
                            a.cnj.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            i.d("ARSourceCopyManager", "sdk exist + " + a.cnj.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.cnj.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.cnj.put("sdcardPath", "null");
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}
