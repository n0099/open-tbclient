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
    private UnitedSchemeEntity aAs;
    private CallbackHandler aAt;
    private WeakReference<Context> mContextRef;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.aAs = unitedSchemeEntity;
        this.aAt = callbackHandler;
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
        if (c0145c.Ey() || c0145c.isFinished()) {
            if (DEBUG) {
                Log.w("PickVideoTask", "Pick task has Error:" + c0145c.extra);
            }
            if (c0145c.object instanceof d.a) {
                c((d.a) c0145c.object);
                return;
            }
            return;
        }
        switch (c0145c.aAz) {
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
        } else if (aVar.aAF == null) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:data.result is Null");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("path", aVar.aAF.aAM);
            bundle.putLong("height", aVar.aAF.aAK);
            bundle.putLong("width", aVar.aAF.aAL);
            bundle.putString("outputPath", an(com.baidu.swan.apps.ae.b.Jg(), aVar.aAF.aAM));
            com.baidu.swan.apps.u.a.CN().a(context, bundle, new a() { // from class: com.baidu.swan.apps.media.a.b.c.1
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
                            aVar.aAF.size = file.length();
                            aVar.aAF.aAJ = com.baidu.swan.apps.storage.b.aD(string, com.baidu.swan.apps.ae.b.Jg());
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
        rx.d.bj(aVar).d(new f<d.a, String>() { // from class: com.baidu.swan.apps.media.a.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public String call(d.a aVar2) {
                if (aVar2.aAF == null) {
                    return null;
                }
                String str = aVar2.aAF.aAM;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String ao = c.this.ao(com.baidu.swan.apps.ae.b.Jg(), str);
                if (TextUtils.isEmpty(ao)) {
                    return null;
                }
                if (com.baidu.swan.c.b.e(new File(str), new File(ao)) <= 0) {
                    ao = null;
                }
                return ao;
            }
        }).b(Schedulers.io()).a(rx.a.b.a.cDJ()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.media.a.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && aVar.aAF != null) {
                    aVar.aAF.aAJ = com.baidu.swan.apps.storage.b.aD(str, com.baidu.swan.apps.ae.b.Jg());
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
        if (this.aAs == null || this.aAt == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "WeakRef return null");
            }
        } else if (aVar.aAF == null || aVar.aAE == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData not completed");
            }
        } else if (TextUtils.isEmpty(aVar.aAE.callback)) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData without callback");
            }
        } else {
            CallbackHandler callbackHandler = this.aAt;
            String str = aVar.aAE.callback;
            d.c cVar = aVar.aAF;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(cVar.aAJ)) {
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
                jSONObject.put("tempFilePath", cVar.aAJ);
                jSONObject.put(UBC.CONTENT_KEY_DURATION, cVar.duration / 1000);
                jSONObject.put("height", cVar.aAK);
                jSONObject.put("width", cVar.aAL);
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
        private static final b aAx = new b(null) { // from class: com.baidu.swan.apps.media.a.b.c.b.1
            @Override // com.baidu.swan.apps.media.a.b.c.b
            public C0145c a(Context context, C0145c c0145c) {
                return c0145c;
            }
        };
        protected d.a aAw;

        public abstract C0145c a(Context context, C0145c c0145c);

        public b(@NonNull d.a aVar) {
            this.aAw = aVar;
        }

        public static b e(d.a aVar) {
            if (aVar == null || aVar.aAE == null) {
                return aAx;
            }
            switch (aVar.aAE.sourceType) {
                case 1:
                case 3:
                    return new com.baidu.swan.apps.media.a.b.a(aVar);
                case 2:
                    return new com.baidu.swan.apps.media.a.b.b(aVar);
                default:
                    return aAx;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f(@NonNull d.a aVar) {
            return (aVar.aAE == null || !aVar.aAE.aAG || aVar.aAF.aAK == 0 || aVar.aAF.aAL == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0145c {
        private boolean aAy = false;
        int aAz = 0;
        public String extra;
        public Object object;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0145c b(int i, Object obj) {
            this.aAz = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0145c d(boolean z, String str) {
            this.aAy = z;
            this.extra = str;
            return this;
        }

        public boolean Ey() {
            return this.aAy;
        }

        public boolean isFinished() {
            return this.aAz == 0;
        }
    }
}
