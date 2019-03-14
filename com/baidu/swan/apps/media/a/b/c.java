package com.baidu.swan.apps.media.a.b;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.a.b.d;
import com.baidu.ubc.UBC;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class c extends AsyncTask<d.a, String, C0145c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private UnitedSchemeEntity aAo;
    private CallbackHandler aAp;
    private WeakReference<Context> mContextRef;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.aAo = unitedSchemeEntity;
        this.aAp = callbackHandler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C0145c doInBackground(d.a... aVarArr) {
        d.a aVar;
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task doInBackground run >>");
        }
        C0145c c0145c = new C0145c();
        if (aVarArr == null) {
            aVar = null;
        } else {
            aVar = aVarArr[0];
        }
        if (aVar == null || aVar.uri == null) {
            return c0145c.d(true, "uri is null");
        }
        Context context = this.mContextRef.get();
        if (context == null) {
            return c0145c.d(true, "context is null");
        }
        return b.e(aVar).a(context, c0145c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(C0145c c0145c) {
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task onPostExecute.");
        }
        super.onPostExecute(c0145c);
        if (c0145c.EA() || c0145c.isFinished()) {
            if (DEBUG) {
                Log.w("PickVideoTask", "Pick task has Error:" + c0145c.extra);
            }
            if (c0145c.object instanceof d.a) {
                c((d.a) c0145c.object);
                return;
            }
            return;
        }
        switch (c0145c.aAv) {
            case 1:
                if (c0145c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performVideoCompressed.");
                    }
                    a((d.a) c0145c.object);
                    return;
                }
                return;
            case 2:
                if (c0145c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performMovingVideo.");
                    }
                    b((d.a) c0145c.object);
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
        } else if (aVar.aAB == null) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:data.result is Null");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("path", aVar.aAB.aAI);
            bundle.putLong("height", aVar.aAB.aAG);
            bundle.putLong("width", aVar.aAB.aAH);
            bundle.putString("outputPath", an(com.baidu.swan.apps.ae.b.Ji(), aVar.aAB.aAI));
            com.baidu.swan.apps.u.a.CP().a(context, bundle, new a() { // from class: com.baidu.swan.apps.media.a.b.c.1
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
                            aVar.aAB.size = file.length();
                            aVar.aAB.aAF = com.baidu.swan.apps.storage.b.aD(string, com.baidu.swan.apps.ae.b.Ji());
                        }
                        if (c.DEBUG) {
                            Log.i("PickVideoTask", "VideoCompress:success");
                        }
                    } else {
                        aVar.info = bundle2.getString("info");
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
        rx.d.bn(aVar).d(new f<d.a, String>() { // from class: com.baidu.swan.apps.media.a.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public String call(d.a aVar2) {
                if (aVar2.aAB == null) {
                    return null;
                }
                String str = aVar2.aAB.aAI;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String ao = c.this.ao(com.baidu.swan.apps.ae.b.Ji(), str);
                if (TextUtils.isEmpty(ao)) {
                    return null;
                }
                if (com.baidu.swan.c.b.e(new File(str), new File(ao)) <= 0) {
                    ao = null;
                }
                return ao;
            }
        }).b(Schedulers.io()).a(rx.a.b.a.cDU()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.media.a.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && aVar.aAB != null) {
                    aVar.aAB.aAF = com.baidu.swan.apps.storage.b.aD(str, com.baidu.swan.apps.ae.b.Ji());
                }
                c.this.c(aVar);
            }
        });
    }

    private String an(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String u = com.baidu.swan.apps.storage.b.u(str, new File(com.baidu.swan.c.b.bn(str2, "_compressed")).getName(), null);
        com.baidu.swan.c.b.C(new File(u));
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ao(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String u = com.baidu.swan.apps.storage.b.u(str, new File(str2).getName(), null);
        com.baidu.swan.c.b.C(new File(u));
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull d.a aVar) {
        if (this.aAo == null || this.aAp == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "WeakRef return null");
            }
        } else if (aVar.aAB == null || aVar.aAA == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData not completed");
            }
        } else if (TextUtils.isEmpty(aVar.aAA.callback)) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData without callback");
            }
        } else {
            CallbackHandler callbackHandler = this.aAp;
            String str = aVar.aAA.callback;
            d.c cVar = aVar.aAB;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(cVar.aAF)) {
                try {
                    jSONObject.put("info", aVar.info);
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.e("PickVideoTask", "JSONException", e);
                    }
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                return;
            }
            try {
                jSONObject.put("tempFilePath", cVar.aAF);
                jSONObject.put(UBC.CONTENT_KEY_DURATION, cVar.duration / 1000);
                jSONObject.put("height", cVar.aAG);
                jSONObject.put("width", cVar.aAH);
                jSONObject.put("size", cVar.size);
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
        private static final b aAt = new b(null) { // from class: com.baidu.swan.apps.media.a.b.c.b.1
            @Override // com.baidu.swan.apps.media.a.b.c.b
            public C0145c a(Context context, C0145c c0145c) {
                return c0145c;
            }
        };
        protected d.a aAs;

        public abstract C0145c a(Context context, C0145c c0145c);

        public b(@NonNull d.a aVar) {
            this.aAs = aVar;
        }

        public static b e(d.a aVar) {
            if (aVar == null || aVar.aAA == null) {
                return aAt;
            }
            switch (aVar.aAA.sourceType) {
                case 1:
                case 3:
                    return new com.baidu.swan.apps.media.a.b.a(aVar);
                case 2:
                    return new com.baidu.swan.apps.media.a.b.b(aVar);
                default:
                    return aAt;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f(@NonNull d.a aVar) {
            return (aVar.aAA == null || !aVar.aAA.aAC || aVar.aAB.aAG == 0 || aVar.aAB.aAH == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0145c {
        private boolean aAu = false;
        int aAv = 0;
        public String extra;
        public Object object;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0145c b(int i, Object obj) {
            this.aAv = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0145c d(boolean z, String str) {
            this.aAu = z;
            this.extra = str;
            return this;
        }

        public boolean EA() {
            return this.aAu;
        }

        public boolean isFinished() {
            return this.aAv == 0;
        }
    }
}
