package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    private static a bjG;
    public static JSONObject bjL;
    private b bjH;
    private String bjI;
    private File bjJ;
    private boolean bjK;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bjI = str;
        this.bjJ = file;
        this.bjK = z;
    }

    public static a aE(Context context) {
        if (bjG == null) {
            init(context);
        }
        bjG.setContext(context);
        return bjG;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bjG == null) {
                bjG = new a();
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
        boolean Kh = Kh();
        bjL = new JSONObject();
        if (Kh) {
            try {
                bjL.put("type", com.baidu.minivideo.arface.c.bjj ? "assets" : "soloader");
                bjL.put("exist", Kh);
                bjL.put("path", this.bjJ);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Ki();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean Kh() {
        return this.bjJ != null && this.bjJ.isDirectory() && this.bjJ.exists();
    }

    private void Ki() {
        this.bjH = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bjL == null) {
                    a.bjL = new JSONObject();
                }
                if (a.this.bjJ != null) {
                    if (a.this.bjK || !a.this.Kh()) {
                        if (!a.this.bjJ.isDirectory()) {
                            try {
                                a.bjL.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bjJ.delete();
                        }
                        File file = new File(a.this.bjJ.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bjH.b(a.this.bjI, file);
                        if (b) {
                            try {
                                a.bjL.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bjJ);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bjL.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bjJ.exists()) {
                                e.deleteDir(a.this.bjJ);
                            }
                        }
                        try {
                            a.bjL.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bjL.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bjL.put("sdcardPath", "null");
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
