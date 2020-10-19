package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a extends c {
    private static a bMj;
    public static JSONObject bMo;
    private b bMk;
    private String bMl;
    private File bMm;
    private boolean bMn;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bMl = str;
        this.bMm = file;
        this.bMn = z;
    }

    public static a aM(Context context) {
        if (bMj == null) {
            init(context);
        }
        bMj.setContext(context);
        return bMj;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bMj == null) {
                bMj = new a();
            }
        }
    }

    private Context getContext() {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.get();
    }

    @Override // com.baidu.minivideo.arface.utils.c
    protected void run() {
        boolean VT = VT();
        bMo = new JSONObject();
        if (VT) {
            try {
                bMo.put("type", com.baidu.minivideo.arface.c.bLK ? "assets" : "soloader");
                bMo.put("exist", VT);
                bMo.put("path", this.bMm);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                h.d("ARSourceCopyManager", "sdk exist + " + bMo.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    h.d("ARSourceCopyManager", "sdk loading .. to " + this.bMm.getAbsoluteFile());
                }
                VU();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean VT() {
        return this.bMm != null && this.bMm.isDirectory() && this.bMm.exists();
    }

    private void VU() {
        this.bMk = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bMo == null) {
                    a.bMo = new JSONObject();
                }
                if (a.this.bMm != null) {
                    if (a.this.bMn || !a.this.VT()) {
                        if (!a.this.bMm.isDirectory()) {
                            try {
                                a.bMo.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bMm.delete();
                        }
                        File file = new File(a.this.bMm.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.bMk.assetToSD(a.this.bMl, file);
                        if (assetToSD) {
                            try {
                                a.bMo.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bMm);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.bMo.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bMm.exists()) {
                                e.deleteDir(a.this.bMm);
                            }
                        }
                        try {
                            a.bMo.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            h.d("ARSourceCopyManager", "sdk exist + " + a.bMo.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bMo.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bMo.put("sdcardPath", "null");
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
