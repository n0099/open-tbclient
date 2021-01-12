package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d {
    private static a cho;
    public static JSONObject cht;
    private c chp;
    private String chq;
    private File chr;
    private boolean chs;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.chq = str;
        this.chr = file;
        this.chs = z;
    }

    public static a bE(Context context) {
        if (cho == null) {
            init(context);
        }
        cho.setContext(context);
        return cho;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (cho == null) {
                cho = new a();
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
        boolean aaM = aaM();
        cht = new JSONObject();
        if (aaM) {
            try {
                cht.put("type", com.baidu.minivideo.arface.c.cfz ? "assets" : "soloader");
                cht.put("exist", aaM);
                cht.put("path", this.chr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                i.d("ARSourceCopyManager", "sdk exist + " + cht.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    i.d("ARSourceCopyManager", "sdk loading .. to " + this.chr.getAbsoluteFile());
                }
                aaN();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean aaM() {
        return this.chr != null && this.chr.isDirectory() && this.chr.exists();
    }

    private void aaN() {
        this.chp = new c(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.cht == null) {
                    a.cht = new JSONObject();
                }
                if (a.this.chr != null) {
                    if (a.this.chs || !a.this.aaM()) {
                        if (!a.this.chr.isDirectory()) {
                            try {
                                a.cht.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.chr.delete();
                        }
                        File file = new File(a.this.chr.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.chp.assetToSD(a.this.chq, file);
                        if (assetToSD) {
                            try {
                                a.cht.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.chr);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.cht.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            f.deleteDir(file);
                            if (a.this.chr.exists()) {
                                f.deleteDir(a.this.chr);
                            }
                        }
                        try {
                            a.cht.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            i.d("ARSourceCopyManager", "sdk exist + " + a.cht.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.cht.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.cht.put("sdcardPath", "null");
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
