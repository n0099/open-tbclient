package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a extends c {
    private static a bUG;
    public static JSONObject bUL;
    private b bUH;
    private String bUI;
    private File bUJ;
    private boolean bUK;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bUI = str;
        this.bUJ = file;
        this.bUK = z;
    }

    public static a aM(Context context) {
        if (bUG == null) {
            init(context);
        }
        bUG.setContext(context);
        return bUG;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bUG == null) {
                bUG = new a();
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
        boolean XN = XN();
        bUL = new JSONObject();
        if (XN) {
            try {
                bUL.put("type", com.baidu.minivideo.arface.c.bUh ? "assets" : "soloader");
                bUL.put("exist", XN);
                bUL.put("path", this.bUJ);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                h.d("ARSourceCopyManager", "sdk exist + " + bUL.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    h.d("ARSourceCopyManager", "sdk loading .. to " + this.bUJ.getAbsoluteFile());
                }
                XO();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean XN() {
        return this.bUJ != null && this.bUJ.isDirectory() && this.bUJ.exists();
    }

    private void XO() {
        this.bUH = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bUL == null) {
                    a.bUL = new JSONObject();
                }
                if (a.this.bUJ != null) {
                    if (a.this.bUK || !a.this.XN()) {
                        if (!a.this.bUJ.isDirectory()) {
                            try {
                                a.bUL.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bUJ.delete();
                        }
                        File file = new File(a.this.bUJ.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.bUH.assetToSD(a.this.bUI, file);
                        if (assetToSD) {
                            try {
                                a.bUL.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bUJ);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.bUL.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bUJ.exists()) {
                                e.deleteDir(a.this.bUJ);
                            }
                        }
                        try {
                            a.bUL.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            h.d("ARSourceCopyManager", "sdk exist + " + a.bUL.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bUL.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bUL.put("sdcardPath", "null");
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
