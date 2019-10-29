package com.baidu.swan.apps.media.a.b;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.a.b.d;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class c extends AsyncTask<d.a, String, C0193c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private UnitedSchemeEntity aVK;
    private CallbackHandler aVL;
    private WeakReference<Context> mContextRef;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.aVK = unitedSchemeEntity;
        this.aVL = callbackHandler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C0193c doInBackground(d.a... aVarArr) {
        d.a aVar;
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task doInBackground run >>");
        }
        C0193c c0193c = new C0193c();
        if (aVarArr == null) {
            aVar = null;
        } else {
            aVar = aVarArr[0];
        }
        if (aVar == null || aVar.uri == null) {
            return c0193c.e(true, "uri is null");
        }
        Context context = this.mContextRef.get();
        if (context == null) {
            return c0193c.e(true, "context is null");
        }
        return b.e(aVar).a(context, c0193c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(C0193c c0193c) {
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task onPostExecute.");
        }
        super.onPostExecute(c0193c);
        if (c0193c.Mc() || c0193c.isFinished()) {
            if (DEBUG) {
                Log.w("PickVideoTask", "Pick task has Error:" + c0193c.extra);
            }
            if (c0193c.object instanceof d.a) {
                c((d.a) c0193c.object);
                return;
            }
            return;
        }
        switch (c0193c.aVR) {
            case 1:
                if (c0193c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performVideoCompressed.");
                    }
                    a((d.a) c0193c.object);
                    return;
                }
                return;
            case 2:
                if (c0193c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performMovingVideo.");
                    }
                    b((d.a) c0193c.object);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(@NonNull final d.a aVar) {
        Context context = this.mContextRef.get();
        if (context == null || !(context instanceof Activity)) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:Context=" + context);
            }
        } else if (aVar.aVX == null) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:data.result is Null");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("path", aVar.aVX.aWe);
            bundle.putLong("height", aVar.aVX.aWc);
            bundle.putLong("width", aVar.aVX.aWd);
            bundle.putString("outputPath", aw(com.baidu.swan.apps.ae.b.Rk(), aVar.aVX.aWe));
            com.baidu.swan.apps.u.a.Jz().a(context, bundle, new a() { // from class: com.baidu.swan.apps.media.a.b.c.1
                @Override // com.baidu.swan.apps.media.a.b.c.a
                public void a(boolean z, Bundle bundle2) {
                    if (!z) {
                        c.this.c(aVar);
                        return;
                    }
                    if (bundle2.getBoolean("success", false)) {
                        String string = bundle2.getString("path");
                        if (!TextUtils.isEmpty(string)) {
                            File file = new File(string);
                            aVar.aVX.size = file.length();
                            aVar.aVX.aWb = com.baidu.swan.apps.storage.b.aN(string, com.baidu.swan.apps.ae.b.Rk());
                        }
                        if (c.DEBUG) {
                            Log.i("PickVideoTask", "VideoCompress:success");
                        }
                    } else {
                        aVar.info = bundle2.getString(Config.LAUNCH_INFO);
                        if (c.DEBUG) {
                            Log.e("PickVideoTask", "VideoCompress:fail" + aVar.info);
                        }
                    }
                    c.this.c(aVar);
                }
            });
        }
    }

    private void b(@NonNull final d.a aVar) {
        rx.d.bh(aVar).d(new f<d.a, String>() { // from class: com.baidu.swan.apps.media.a.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public String call(d.a aVar2) {
                if (aVar2.aVX == null) {
                    return null;
                }
                String str = aVar2.aVX.aWe;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String ax = c.this.ax(com.baidu.swan.apps.ae.b.Rk(), str);
                if (TextUtils.isEmpty(ax)) {
                    return null;
                }
                if (com.baidu.swan.c.a.e(new File(str), new File(ax)) <= 0) {
                    ax = null;
                }
                return ax;
            }
        }).b(Schedulers.io()).a(rx.a.b.a.cOs()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.media.a.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && aVar.aVX != null) {
                    aVar.aVX.aWb = com.baidu.swan.apps.storage.b.aN(str, com.baidu.swan.apps.ae.b.Rk());
                }
                c.this.c(aVar);
            }
        });
    }

    private String aw(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String A = com.baidu.swan.apps.storage.b.A(str, new File(com.baidu.swan.c.a.bC(str2, "_compressed")).getName(), null);
        com.baidu.swan.c.a.n(new File(A));
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ax(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String A = com.baidu.swan.apps.storage.b.A(str, new File(str2).getName(), null);
        com.baidu.swan.c.a.n(new File(A));
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull d.a aVar) {
        if (this.aVK == null || this.aVL == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "WeakRef return null");
            }
        } else if (aVar.aVX == null || aVar.aVW == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData not completed");
            }
        } else if (TextUtils.isEmpty(aVar.aVW.callback)) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData without callback");
            }
        } else {
            CallbackHandler callbackHandler = this.aVL;
            String str = aVar.aVW.callback;
            d.c cVar = aVar.aVX;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(cVar.aWb)) {
                try {
                    jSONObject.put(Config.LAUNCH_INFO, aVar.info);
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.e("PickVideoTask", "JSONException", e);
                    }
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                return;
            }
            try {
                jSONObject.put("tempFilePath", cVar.aWb);
                jSONObject.put("duration", cVar.duration / 1000);
                jSONObject.put("height", cVar.aWc);
                jSONObject.put("width", cVar.aWd);
                jSONObject.put(TiebaInitialize.LogFields.SIZE, cVar.size);
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.e("PickVideoTask", "JSONException", e2);
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        private static final b aVP = new b(null) { // from class: com.baidu.swan.apps.media.a.b.c.b.1
            @Override // com.baidu.swan.apps.media.a.b.c.b
            public C0193c a(Context context, C0193c c0193c) {
                return c0193c;
            }
        };
        protected d.a aVO;

        public abstract C0193c a(Context context, C0193c c0193c);

        public b(@NonNull d.a aVar) {
            this.aVO = aVar;
        }

        public static b e(d.a aVar) {
            if (aVar == null || aVar.aVW == null) {
                return aVP;
            }
            switch (aVar.aVW.sourceType) {
                case 1:
                case 3:
                    return new com.baidu.swan.apps.media.a.b.a(aVar);
                case 2:
                    return new com.baidu.swan.apps.media.a.b.b(aVar);
                default:
                    return aVP;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f(@NonNull d.a aVar) {
            return (aVar.aVW == null || !aVar.aVW.aVY || aVar.aVX.aWc == 0 || aVar.aVX.aWd == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0193c {
        private boolean aVQ = false;
        int aVR = 0;
        public String extra;
        public Object object;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0193c f(int i, Object obj) {
            this.aVR = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0193c e(boolean z, String str) {
            this.aVQ = z;
            this.extra = str;
            return this;
        }

        public boolean Mc() {
            return this.aVQ;
        }

        public boolean isFinished() {
            return this.aVR == 0;
        }
    }
}
