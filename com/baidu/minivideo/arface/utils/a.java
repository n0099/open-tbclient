package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a extends c {
    private static a bYF;
    public static JSONObject bYK;
    private b bYG;
    private String bYH;
    private File bYI;
    private boolean bYJ;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bYH = str;
        this.bYI = file;
        this.bYJ = z;
    }

    public static a aM(Context context) {
        if (bYF == null) {
            init(context);
        }
        bYF.setContext(context);
        return bYF;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bYF == null) {
                bYF = new a();
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
        boolean ZD = ZD();
        bYK = new JSONObject();
        if (ZD) {
            try {
                bYK.put("type", com.baidu.minivideo.arface.c.bYg ? "assets" : "soloader");
                bYK.put("exist", ZD);
                bYK.put("path", this.bYI);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                h.d("ARSourceCopyManager", "sdk exist + " + bYK.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    h.d("ARSourceCopyManager", "sdk loading .. to " + this.bYI.getAbsoluteFile());
                }
                ZE();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean ZD() {
        return this.bYI != null && this.bYI.isDirectory() && this.bYI.exists();
    }

    private void ZE() {
        this.bYG = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bYK == null) {
                    a.bYK = new JSONObject();
                }
                if (a.this.bYI != null) {
                    if (a.this.bYJ || !a.this.ZD()) {
                        if (!a.this.bYI.isDirectory()) {
                            try {
                                a.bYK.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bYI.delete();
                        }
                        File file = new File(a.this.bYI.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.bYG.assetToSD(a.this.bYH, file);
                        if (assetToSD) {
                            try {
                                a.bYK.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bYI);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.bYK.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bYI.exists()) {
                                e.deleteDir(a.this.bYI);
                            }
                        }
                        try {
                            a.bYK.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            h.d("ARSourceCopyManager", "sdk exist + " + a.bYK.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bYK.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bYK.put("sdcardPath", "null");
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
