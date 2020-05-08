package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    private static a bjL;
    public static JSONObject bjQ;
    private b bjM;
    private String bjN;
    private File bjO;
    private boolean bjP;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bjN = str;
        this.bjO = file;
        this.bjP = z;
    }

    public static a as(Context context) {
        if (bjL == null) {
            init(context);
        }
        bjL.setContext(context);
        return bjL;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bjL == null) {
                bjL = new a();
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
        boolean Kg = Kg();
        bjQ = new JSONObject();
        if (Kg) {
            try {
                bjQ.put("type", com.baidu.minivideo.arface.c.bjo ? "assets" : "soloader");
                bjQ.put("exist", Kg);
                bjQ.put("path", this.bjO);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Kh();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean Kg() {
        return this.bjO != null && this.bjO.isDirectory() && this.bjO.exists();
    }

    private void Kh() {
        this.bjM = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bjQ == null) {
                    a.bjQ = new JSONObject();
                }
                if (a.this.bjO != null) {
                    if (a.this.bjP || !a.this.Kg()) {
                        if (!a.this.bjO.isDirectory()) {
                            try {
                                a.bjQ.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bjO.delete();
                        }
                        File file = new File(a.this.bjO.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bjM.b(a.this.bjN, file);
                        if (b) {
                            try {
                                a.bjQ.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bjO);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bjQ.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bjO.exists()) {
                                e.deleteDir(a.this.bjO);
                            }
                        }
                        try {
                            a.bjQ.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bjQ.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bjQ.put("sdcardPath", "null");
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
