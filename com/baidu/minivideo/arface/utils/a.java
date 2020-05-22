package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    private static a brg;
    public static JSONObject brl;
    private b brh;
    private String bri;
    private File brj;
    private boolean brk;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bri = str;
        this.brj = file;
        this.brk = z;
    }

    public static a aC(Context context) {
        if (brg == null) {
            init(context);
        }
        brg.setContext(context);
        return brg;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (brg == null) {
                brg = new a();
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
        boolean LZ = LZ();
        brl = new JSONObject();
        if (LZ) {
            try {
                brl.put("type", com.baidu.minivideo.arface.c.bqJ ? "assets" : "soloader");
                brl.put("exist", LZ);
                brl.put("path", this.brj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Ma();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean LZ() {
        return this.brj != null && this.brj.isDirectory() && this.brj.exists();
    }

    private void Ma() {
        this.brh = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.brl == null) {
                    a.brl = new JSONObject();
                }
                if (a.this.brj != null) {
                    if (a.this.brk || !a.this.LZ()) {
                        if (!a.this.brj.isDirectory()) {
                            try {
                                a.brl.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.brj.delete();
                        }
                        File file = new File(a.this.brj.getAbsoluteFile() + ".loading");
                        boolean b = a.this.brh.b(a.this.bri, file);
                        if (b) {
                            try {
                                a.brl.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.brj);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.brl.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.brj.exists()) {
                                e.deleteDir(a.this.brj);
                            }
                        }
                        try {
                            a.brl.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.brl.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.brl.put("sdcardPath", "null");
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
