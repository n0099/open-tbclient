package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a extends c {
    private static a caq;
    public static JSONObject cav;
    private b car;
    private String cas;
    private File cat;
    private boolean cau;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.cas = str;
        this.cat = file;
        this.cau = z;
    }

    public static a aM(Context context) {
        if (caq == null) {
            init(context);
        }
        caq.setContext(context);
        return caq;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (caq == null) {
                caq = new a();
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
        boolean aam = aam();
        cav = new JSONObject();
        if (aam) {
            try {
                cav.put("type", com.baidu.minivideo.arface.c.bZR ? "assets" : "soloader");
                cav.put("exist", aam);
                cav.put("path", this.cat);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                h.d("ARSourceCopyManager", "sdk exist + " + cav.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    h.d("ARSourceCopyManager", "sdk loading .. to " + this.cat.getAbsoluteFile());
                }
                aan();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean aam() {
        return this.cat != null && this.cat.isDirectory() && this.cat.exists();
    }

    private void aan() {
        this.car = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.cav == null) {
                    a.cav = new JSONObject();
                }
                if (a.this.cat != null) {
                    if (a.this.cau || !a.this.aam()) {
                        if (!a.this.cat.isDirectory()) {
                            try {
                                a.cav.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.cat.delete();
                        }
                        File file = new File(a.this.cat.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.car.assetToSD(a.this.cas, file);
                        if (assetToSD) {
                            try {
                                a.cav.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.cat);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.cav.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.cat.exists()) {
                                e.deleteDir(a.this.cat);
                            }
                        }
                        try {
                            a.cav.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            h.d("ARSourceCopyManager", "sdk exist + " + a.cav.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.cav.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.cav.put("sdcardPath", "null");
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
