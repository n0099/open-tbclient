package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends c {
    public static JSONObject bwD;
    private static a bwy;
    private String bwA;
    private File bwB;
    private boolean bwC;
    private b bwz;
    private WeakReference<Context> mContext;

    private a() {
    }

    private void setContext(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void a(String str, File file, boolean z) {
        this.bwA = str;
        this.bwB = file;
        this.bwC = z;
    }

    public static a aD(Context context) {
        if (bwy == null) {
            init(context);
        }
        bwy.setContext(context);
        return bwy;
    }

    private static synchronized void init(Context context) {
        synchronized (a.class) {
            if (bwy == null) {
                bwy = new a();
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
        boolean Np = Np();
        bwD = new JSONObject();
        if (Np) {
            try {
                bwD.put("type", com.baidu.minivideo.arface.c.bvZ ? "assets" : "soloader");
                bwD.put("exist", Np);
                bwD.put("path", this.bwB);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            setState(2);
        } else if (getContext() != null) {
            try {
                Nq();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean Np() {
        return this.bwB != null && this.bwB.isDirectory() && this.bwB.exists();
    }

    private void Nq() {
        this.bwz = new b(getContext());
        new AsyncTask<Void, Void, Boolean>() { // from class: com.baidu.minivideo.arface.utils.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                boolean renameTo;
                if (a.bwD == null) {
                    a.bwD = new JSONObject();
                }
                if (a.this.bwB != null) {
                    if (a.this.bwC || !a.this.Np()) {
                        if (!a.this.bwB.isDirectory()) {
                            try {
                                a.bwD.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.bwB.delete();
                        }
                        File file = new File(a.this.bwB.getAbsoluteFile() + ".loading");
                        boolean b = a.this.bwz.b(a.this.bwA, file);
                        if (b) {
                            try {
                                a.bwD.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            renameTo = file.renameTo(a.this.bwB);
                        } else {
                            renameTo = b;
                        }
                        if (!renameTo) {
                            try {
                                a.bwD.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            e.deleteDir(file);
                            if (a.this.bwB.exists()) {
                                e.deleteDir(a.this.bwB);
                            }
                        }
                        try {
                            a.bwD.put("result", renameTo);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        return Boolean.valueOf(renameTo);
                    }
                    try {
                        a.bwD.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return true;
                }
                try {
                    a.bwD.put("sdcardPath", "null");
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
