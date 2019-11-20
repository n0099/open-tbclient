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
    private UnitedSchemeEntity aVs;
    private CallbackHandler aVt;
    private WeakReference<Context> mContextRef;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.aVs = unitedSchemeEntity;
        this.aVt = callbackHandler;
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
        if (c0193c.Md() || c0193c.isFinished()) {
            if (DEBUG) {
                Log.w("PickVideoTask", "Pick task has Error:" + c0193c.extra);
            }
            if (c0193c.object instanceof d.a) {
                c((d.a) c0193c.object);
                return;
            }
            return;
        }
        switch (c0193c.aVz) {
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
        } else if (aVar.aVF == null) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:data.result is Null");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("path", aVar.aVF.aVM);
            bundle.putLong("height", aVar.aVF.aVK);
            bundle.putLong("width", aVar.aVF.aVL);
            bundle.putString("outputPath", aw(com.baidu.swan.apps.ae.b.Rm(), aVar.aVF.aVM));
            com.baidu.swan.apps.u.a.JA().a(context, bundle, new a() { // from class: com.baidu.swan.apps.media.a.b.c.1
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
                            aVar.aVF.size = file.length();
                            aVar.aVF.aVJ = com.baidu.swan.apps.storage.b.aN(string, com.baidu.swan.apps.ae.b.Rm());
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
                if (aVar2.aVF == null) {
                    return null;
                }
                String str = aVar2.aVF.aVM;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String ax = c.this.ax(com.baidu.swan.apps.ae.b.Rm(), str);
                if (TextUtils.isEmpty(ax)) {
                    return null;
                }
                if (com.baidu.swan.c.a.e(new File(str), new File(ax)) <= 0) {
                    ax = null;
                }
                return ax;
            }
        }).b(Schedulers.io()).a(rx.a.b.a.cOq()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.media.a.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && aVar.aVF != null) {
                    aVar.aVF.aVJ = com.baidu.swan.apps.storage.b.aN(str, com.baidu.swan.apps.ae.b.Rm());
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
        if (this.aVs == null || this.aVt == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "WeakRef return null");
            }
        } else if (aVar.aVF == null || aVar.aVE == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData not completed");
            }
        } else if (TextUtils.isEmpty(aVar.aVE.callback)) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData without callback");
            }
        } else {
            CallbackHandler callbackHandler = this.aVt;
            String str = aVar.aVE.callback;
            d.c cVar = aVar.aVF;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(cVar.aVJ)) {
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
                jSONObject.put("tempFilePath", cVar.aVJ);
                jSONObject.put("duration", cVar.duration / 1000);
                jSONObject.put("height", cVar.aVK);
                jSONObject.put("width", cVar.aVL);
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
        private static final b aVx = new b(null) { // from class: com.baidu.swan.apps.media.a.b.c.b.1
            @Override // com.baidu.swan.apps.media.a.b.c.b
            public C0193c a(Context context, C0193c c0193c) {
                return c0193c;
            }
        };
        protected d.a aVw;

        public abstract C0193c a(Context context, C0193c c0193c);

        public b(@NonNull d.a aVar) {
            this.aVw = aVar;
        }

        public static b e(d.a aVar) {
            if (aVar == null || aVar.aVE == null) {
                return aVx;
            }
            switch (aVar.aVE.sourceType) {
                case 1:
                case 3:
                    return new com.baidu.swan.apps.media.a.b.a(aVar);
                case 2:
                    return new com.baidu.swan.apps.media.a.b.b(aVar);
                default:
                    return aVx;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f(@NonNull d.a aVar) {
            return (aVar.aVE == null || !aVar.aVE.aVG || aVar.aVF.aVK == 0 || aVar.aVF.aVL == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0193c {
        private boolean aVy = false;
        int aVz = 0;
        public String extra;
        public Object object;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0193c f(int i, Object obj) {
            this.aVz = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0193c e(boolean z, String str) {
            this.aVy = z;
            this.extra = str;
            return this;
        }

        public boolean Md() {
            return this.aVy;
        }

        public boolean isFinished() {
            return this.aVz == 0;
        }
    }
}
