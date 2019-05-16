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
public class c extends AsyncTask<d.a, String, C0150c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private UnitedSchemeEntity aBp;
    private CallbackHandler aBq;
    private WeakReference<Context> mContextRef;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.aBp = unitedSchemeEntity;
        this.aBq = callbackHandler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C0150c doInBackground(d.a... aVarArr) {
        d.a aVar;
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task doInBackground run >>");
        }
        C0150c c0150c = new C0150c();
        if (aVarArr == null) {
            aVar = null;
        } else {
            aVar = aVarArr[0];
        }
        if (aVar == null || aVar.uri == null) {
            return c0150c.d(true, "uri is null");
        }
        Context context = this.mContextRef.get();
        if (context == null) {
            return c0150c.d(true, "context is null");
        }
        return b.e(aVar).a(context, c0150c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(C0150c c0150c) {
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task onPostExecute.");
        }
        super.onPostExecute(c0150c);
        if (c0150c.Gu() || c0150c.isFinished()) {
            if (DEBUG) {
                Log.w("PickVideoTask", "Pick task has Error:" + c0150c.extra);
            }
            if (c0150c.object instanceof d.a) {
                c((d.a) c0150c.object);
                return;
            }
            return;
        }
        switch (c0150c.aBw) {
            case 1:
                if (c0150c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performVideoCompressed.");
                    }
                    a((d.a) c0150c.object);
                    return;
                }
                return;
            case 2:
                if (c0150c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performMovingVideo.");
                    }
                    b((d.a) c0150c.object);
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
        } else if (aVar.aBC == null) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:data.result is Null");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("path", aVar.aBC.aBJ);
            bundle.putLong("height", aVar.aBC.aBH);
            bundle.putLong("width", aVar.aBC.aBI);
            bundle.putString("outputPath", ao(com.baidu.swan.apps.ae.b.LB(), aVar.aBC.aBJ));
            com.baidu.swan.apps.u.a.DS().a(context, bundle, new a() { // from class: com.baidu.swan.apps.media.a.b.c.1
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
                            aVar.aBC.size = file.length();
                            aVar.aBC.aBG = com.baidu.swan.apps.storage.b.aG(string, com.baidu.swan.apps.ae.b.LB());
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
        rx.d.bl(aVar).d(new f<d.a, String>() { // from class: com.baidu.swan.apps.media.a.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public String call(d.a aVar2) {
                if (aVar2.aBC == null) {
                    return null;
                }
                String str = aVar2.aBC.aBJ;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String ap = c.this.ap(com.baidu.swan.apps.ae.b.LB(), str);
                if (TextUtils.isEmpty(ap)) {
                    return null;
                }
                if (com.baidu.swan.c.a.f(new File(str), new File(ap)) <= 0) {
                    ap = null;
                }
                return ap;
            }
        }).b(Schedulers.io()).a(rx.a.b.a.cLp()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.media.a.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && aVar.aBC != null) {
                    aVar.aBC.aBG = com.baidu.swan.apps.storage.b.aG(str, com.baidu.swan.apps.ae.b.LB());
                }
                c.this.c(aVar);
            }
        });
    }

    private String ao(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String u = com.baidu.swan.apps.storage.b.u(str, new File(com.baidu.swan.c.a.bv(str2, "_compressed")).getName(), null);
        com.baidu.swan.c.a.w(new File(u));
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ap(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String u = com.baidu.swan.apps.storage.b.u(str, new File(str2).getName(), null);
        com.baidu.swan.c.a.w(new File(u));
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull d.a aVar) {
        if (this.aBp == null || this.aBq == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "WeakRef return null");
            }
        } else if (aVar.aBC == null || aVar.aBB == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData not completed");
            }
        } else if (TextUtils.isEmpty(aVar.aBB.callback)) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData without callback");
            }
        } else {
            CallbackHandler callbackHandler = this.aBq;
            String str = aVar.aBB.callback;
            d.c cVar = aVar.aBC;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(cVar.aBG)) {
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
                jSONObject.put("tempFilePath", cVar.aBG);
                jSONObject.put(UBC.CONTENT_KEY_DURATION, cVar.duration / 1000);
                jSONObject.put("height", cVar.aBH);
                jSONObject.put("width", cVar.aBI);
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
        private static final b aBu = new b(null) { // from class: com.baidu.swan.apps.media.a.b.c.b.1
            @Override // com.baidu.swan.apps.media.a.b.c.b
            public C0150c a(Context context, C0150c c0150c) {
                return c0150c;
            }
        };
        protected d.a aBt;

        public abstract C0150c a(Context context, C0150c c0150c);

        public b(@NonNull d.a aVar) {
            this.aBt = aVar;
        }

        public static b e(d.a aVar) {
            if (aVar == null || aVar.aBB == null) {
                return aBu;
            }
            switch (aVar.aBB.sourceType) {
                case 1:
                case 3:
                    return new com.baidu.swan.apps.media.a.b.a(aVar);
                case 2:
                    return new com.baidu.swan.apps.media.a.b.b(aVar);
                default:
                    return aBu;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f(@NonNull d.a aVar) {
            return (aVar.aBB == null || !aVar.aBB.aBD || aVar.aBC.aBH == 0 || aVar.aBC.aBI == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0150c {
        private boolean aBv = false;
        int aBw = 0;
        public String extra;
        public Object object;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0150c b(int i, Object obj) {
            this.aBw = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0150c d(boolean z, String str) {
            this.aBv = z;
            this.extra = str;
            return this;
        }

        public boolean Gu() {
            return this.aBv;
        }

        public boolean isFinished() {
            return this.aBw == 0;
        }
    }
}
