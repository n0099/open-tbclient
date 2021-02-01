package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {
    private static a clD;
    public static JSONObject clI;
    private c clE;
    private String clF;
    private File clG;
    private boolean clH;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.clF = str;
        this.clG = file;
        this.clH = z;
    }

    public static a bH(Context context) {
        if (clD == null) {
            init(context);
        }
        clD.setContext(context);
        return clD;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (clD == null) {
                clD = new a();
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
        boolean acA = acA();
        clI = new JSONObject();
        if (acA) {
            try {
                clI.put("type", com.baidu.minivideo.arface.c.cjJ ? "assets" : "soloader");
                clI.put("exist", acA);
                clI.put("path", this.clG);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                i.d("ARSourceCopyManager", "sdk exist + " + clI.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    i.d("ARSourceCopyManager", "sdk loading .. to " + this.clG.getAbsoluteFile());
                }
                acB();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean acA() {
        return this.clG != null && this.clG.isDirectory() && this.clG.exists();
    }

    private void acB() {
        this.clE = new c(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.clI == null) {
                    a.clI = new JSONObject();
                }
                if (a.this.clG != null) {
                    if (a.this.clH || !a.this.acA()) {
                        if (!a.this.clG.isDirectory()) {
                            try {
                                a.clI.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.clG.delete();
                        }
                        File file = new File(a.this.clG.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.clE.assetToSD(a.this.clF, file);
                        if (assetToSD) {
                            try {
                                a.clI.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.clG);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.clI.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            f.deleteDir(file);
                            if (a.this.clG.exists()) {
                                f.deleteDir(a.this.clG);
                            }
                        }
                        try {
                            a.clI.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            i.d("ARSourceCopyManager", "sdk exist + " + a.clI.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.clI.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.clI.put("sdcardPath", "null");
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
