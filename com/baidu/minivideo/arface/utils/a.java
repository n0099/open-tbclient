package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c {
    private static a bFH;
    public static JSONObject bFM;
    private b bFI;
    private String bFJ;
    private File bFK;
    private boolean bFL;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bFJ = str;
        this.bFK = file;
        this.bFL = z;
    }

    public static a aI(Context context) {
        if (bFH == null) {
            init(context);
        }
        bFH.setContext(context);
        return bFH;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bFH == null) {
                bFH = new a();
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
        boolean Ua = Ua();
        bFM = new JSONObject();
        if (Ua) {
            try {
                bFM.put("type", com.baidu.minivideo.arface.c.bFi ? "assets" : "soloader");
                bFM.put("exist", Ua);
                bFM.put("path", this.bFK);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Ub();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean Ua() {
        return this.bFK != null && this.bFK.isDirectory() && this.bFK.exists();
    }

    private void Ub() {
        this.bFI = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bFM == null) {
                    a.bFM = new JSONObject();
                }
                if (a.this.bFK != null) {
                    if (a.this.bFL || !a.this.Ua()) {
                        if (!a.this.bFK.isDirectory()) {
                            try {
                                a.bFM.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bFK.delete();
                        }
                        File file = new File(a.this.bFK.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bFI.b(a.this.bFJ, file);
                        if (b) {
                            try {
                                a.bFM.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bFK);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bFM.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bFK.exists()) {
                                e.deleteDir(a.this.bFK);
                            }
                        }
                        try {
                            a.bFM.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bFM.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bFM.put("sdcardPath", "null");
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
