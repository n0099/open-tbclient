package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends c {
    private static a cfe;
    public static JSONObject cfj;
    private b cff;
    private String cfg;
    private File cfh;
    private boolean cfi;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.cfg = str;
        this.cfh = file;
        this.cfi = z;
    }

    public static a bs(Context context) {
        if (cfe == null) {
            init(context);
        }
        cfe.setContext(context);
        return cfe;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (cfe == null) {
                cfe = new a();
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
        boolean acL = acL();
        cfj = new JSONObject();
        if (acL) {
            try {
                cfj.put("type", com.baidu.minivideo.arface.c.cdH ? "assets" : "soloader");
                cfj.put("exist", acL);
                cfj.put("path", this.cfh);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                g.d("ARSourceCopyManager", "sdk exist + " + cfj.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    g.d("ARSourceCopyManager", "sdk loading .. to " + this.cfh.getAbsoluteFile());
                }
                acM();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean acL() {
        return this.cfh != null && this.cfh.isDirectory() && this.cfh.exists();
    }

    private void acM() {
        this.cff = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.cfj == null) {
                    a.cfj = new JSONObject();
                }
                if (a.this.cfh != null) {
                    if (a.this.cfi || !a.this.acL()) {
                        if (!a.this.cfh.isDirectory()) {
                            try {
                                a.cfj.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.cfh.delete();
                        }
                        File file = new File(a.this.cfh.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.cff.assetToSD(a.this.cfg, file);
                        if (assetToSD) {
                            try {
                                a.cfj.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.cfh);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.cfj.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.cfh.exists()) {
                                e.deleteDir(a.this.cfh);
                            }
                        }
                        try {
                            a.cfj.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            g.d("ARSourceCopyManager", "sdk exist + " + a.cfj.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.cfj.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.cfj.put("sdcardPath", "null");
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
