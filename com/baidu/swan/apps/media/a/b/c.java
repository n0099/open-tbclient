package com.baidu.swan.apps.media.a.b;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
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
public class c extends AsyncTask<d.a, String, C0161c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private UnitedSchemeEntity aCv;
    private CallbackHandler aCw;
    private WeakReference<Context> mContextRef;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.aCv = unitedSchemeEntity;
        this.aCw = callbackHandler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C0161c doInBackground(d.a... aVarArr) {
        d.a aVar;
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task doInBackground run >>");
        }
        C0161c c0161c = new C0161c();
        if (aVarArr == null) {
            aVar = null;
        } else {
            aVar = aVarArr[0];
        }
        if (aVar == null || aVar.uri == null) {
            return c0161c.d(true, "uri is null");
        }
        Context context = this.mContextRef.get();
        if (context == null) {
            return c0161c.d(true, "context is null");
        }
        return b.e(aVar).a(context, c0161c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(C0161c c0161c) {
        if (DEBUG) {
            Log.i("PickVideoTask", "Pick task onPostExecute.");
        }
        super.onPostExecute(c0161c);
        if (c0161c.Hi() || c0161c.isFinished()) {
            if (DEBUG) {
                Log.w("PickVideoTask", "Pick task has Error:" + c0161c.extra);
            }
            if (c0161c.object instanceof d.a) {
                c((d.a) c0161c.object);
                return;
            }
            return;
        }
        switch (c0161c.aCC) {
            case 1:
                if (c0161c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performVideoCompressed.");
                    }
                    a((d.a) c0161c.object);
                    return;
                }
                return;
            case 2:
                if (c0161c.object instanceof d.a) {
                    if (DEBUG) {
                        Log.i("PickVideoTask", "Pick task performMovingVideo.");
                    }
                    b((d.a) c0161c.object);
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
        } else if (aVar.aCI == null) {
            if (DEBUG) {
                Log.w("PickVideoTask", "VideoCompress:data.result is Null");
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("path", aVar.aCI.aCP);
            bundle.putLong("height", aVar.aCI.aCN);
            bundle.putLong("width", aVar.aCI.aCO);
            bundle.putString("outputPath", ao(com.baidu.swan.apps.ae.b.Ms(), aVar.aCI.aCP));
            com.baidu.swan.apps.u.a.EF().a(context, bundle, new a() { // from class: com.baidu.swan.apps.media.a.b.c.1
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
                            aVar.aCI.size = file.length();
                            aVar.aCI.aCM = com.baidu.swan.apps.storage.b.aG(string, com.baidu.swan.apps.ae.b.Ms());
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
        rx.d.bm(aVar).d(new f<d.a, String>() { // from class: com.baidu.swan.apps.media.a.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public String call(d.a aVar2) {
                if (aVar2.aCI == null) {
                    return null;
                }
                String str = aVar2.aCI.aCP;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String ap = c.this.ap(com.baidu.swan.apps.ae.b.Ms(), str);
                if (TextUtils.isEmpty(ap)) {
                    return null;
                }
                if (com.baidu.swan.c.a.f(new File(str), new File(ap)) <= 0) {
                    ap = null;
                }
                return ap;
            }
        }).b(Schedulers.io()).a(rx.a.b.a.cQm()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.media.a.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && aVar.aCI != null) {
                    aVar.aCI.aCM = com.baidu.swan.apps.storage.b.aG(str, com.baidu.swan.apps.ae.b.Ms());
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
        if (this.aCv == null || this.aCw == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "WeakRef return null");
            }
        } else if (aVar.aCI == null || aVar.aCH == null) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData not completed");
            }
        } else if (TextUtils.isEmpty(aVar.aCH.callback)) {
            if (DEBUG) {
                Log.e("PickVideoTask", "PickData without callback");
            }
        } else {
            CallbackHandler callbackHandler = this.aCw;
            String str = aVar.aCH.callback;
            d.c cVar = aVar.aCI;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(cVar.aCM)) {
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
                jSONObject.put("tempFilePath", cVar.aCM);
                jSONObject.put("duration", cVar.duration / 1000);
                jSONObject.put("height", cVar.aCN);
                jSONObject.put("width", cVar.aCO);
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
        private static final b aCA = new b(null) { // from class: com.baidu.swan.apps.media.a.b.c.b.1
            @Override // com.baidu.swan.apps.media.a.b.c.b
            public C0161c a(Context context, C0161c c0161c) {
                return c0161c;
            }
        };
        protected d.a aCz;

        public abstract C0161c a(Context context, C0161c c0161c);

        public b(@NonNull d.a aVar) {
            this.aCz = aVar;
        }

        public static b e(d.a aVar) {
            if (aVar == null || aVar.aCH == null) {
                return aCA;
            }
            switch (aVar.aCH.sourceType) {
                case 1:
                case 3:
                    return new com.baidu.swan.apps.media.a.b.a(aVar);
                case 2:
                    return new com.baidu.swan.apps.media.a.b.b(aVar);
                default:
                    return aCA;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f(@NonNull d.a aVar) {
            return (aVar.aCH == null || !aVar.aCH.aCJ || aVar.aCI.aCN == 0 || aVar.aCI.aCO == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.media.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0161c {
        private boolean aCB = false;
        int aCC = 0;
        public String extra;
        public Object object;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0161c b(int i, Object obj) {
            this.aCC = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0161c d(boolean z, String str) {
            this.aCB = z;
            this.extra = str;
            return this;
        }

        public boolean Hi() {
            return this.aCB;
        }

        public boolean isFinished() {
            return this.aCC == 0;
        }
    }
}
