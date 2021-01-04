package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {
    private static a cmb;
    public static JSONObject cmh;
    private c cmc;
    private String cme;
    private File cmf;
    private boolean cmg;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.cme = str;
        this.cmf = file;
        this.cmg = z;
    }

    public static a bF(Context context) {
        if (cmb == null) {
            init(context);
        }
        cmb.setContext(context);
        return cmb;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (cmb == null) {
                cmb = new a();
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
        boolean aeE = aeE();
        cmh = new JSONObject();
        if (aeE) {
            try {
                cmh.put("type", com.baidu.minivideo.arface.c.ckm ? "assets" : "soloader");
                cmh.put("exist", aeE);
                cmh.put("path", this.cmf);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isDebug()) {
                i.d("ARSourceCopyManager", "sdk exist + " + cmh.toString());
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                if (isDebug()) {
                    i.d("ARSourceCopyManager", "sdk loading .. to " + this.cmf.getAbsoluteFile());
                }
                aeF();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean aeE() {
        return this.cmf != null && this.cmf.isDirectory() && this.cmf.exists();
    }

    private void aeF() {
        this.cmc = new c(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.cmh == null) {
                    a.cmh = new JSONObject();
                }
                if (a.this.cmf != null) {
                    if (a.this.cmg || !a.this.aeE()) {
                        if (!a.this.cmf.isDirectory()) {
                            try {
                                a.cmh.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.cmf.delete();
                        }
                        File file = new File(a.this.cmf.getAbsoluteFile() + ".loading");
                        boolean assetToSD = a.this.cmc.assetToSD(a.this.cme, file);
                        if (assetToSD) {
                            try {
                                a.cmh.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.cmf);
                        } else {
                            renameTo = assetToSD;
                        }
                        if (!renameTo) {
                            try {
                                a.cmh.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            f.deleteDir(file);
                            if (a.this.cmf.exists()) {
                                f.deleteDir(a.this.cmf);
                            }
                        }
                        try {
                            a.cmh.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (a.this.isDebug()) {
                            i.d("ARSourceCopyManager", "sdk exist + " + a.cmh.toString());
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.cmh.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.cmh.put("sdcardPath", "null");
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
