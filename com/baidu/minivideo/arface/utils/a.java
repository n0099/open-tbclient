package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    private static a bwj;
    public static JSONObject bwo;
    private b bwk;
    private String bwl;
    private File bwm;
    private boolean bwn;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bwl = str;
        this.bwm = file;
        this.bwn = z;
    }

    public static a aD(Context context) {
        if (bwj == null) {
            init(context);
        }
        bwj.setContext(context);
        return bwj;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bwj == null) {
                bwj = new a();
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
        boolean Nk = Nk();
        bwo = new JSONObject();
        if (Nk) {
            try {
                bwo.put("type", com.baidu.minivideo.arface.c.bvK ? "assets" : "soloader");
                bwo.put("exist", Nk);
                bwo.put("path", this.bwm);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Nl();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean Nk() {
        return this.bwm != null && this.bwm.isDirectory() && this.bwm.exists();
    }

    private void Nl() {
        this.bwk = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bwo == null) {
                    a.bwo = new JSONObject();
                }
                if (a.this.bwm != null) {
                    if (a.this.bwn || !a.this.Nk()) {
                        if (!a.this.bwm.isDirectory()) {
                            try {
                                a.bwo.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bwm.delete();
                        }
                        File file = new File(a.this.bwm.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bwk.b(a.this.bwl, file);
                        if (b) {
                            try {
                                a.bwo.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bwm);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bwo.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bwm.exists()) {
                                e.deleteDir(a.this.bwm);
                            }
                        }
                        try {
                            a.bwo.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bwo.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bwo.put("sdcardPath", "null");
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
