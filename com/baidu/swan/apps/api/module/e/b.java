package com.baidu.swan.apps.api.module.e;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.widget.dialog.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hm(String str) {
        if (DEBUG) {
            Log.d("Api-Modal", "start show modal");
        }
        return a(str, true, (d.a) new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.api.module.e.b$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.swan.apps.api.a.d.a
        public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, final JSONObject jSONObject, @Nullable final String str) {
            final String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.getContext().getString(a.h.aiapps_ok);
            }
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    g.a aVar = new g.a(b.this.getContext());
                    aVar.e(jSONObject.optString("title")).nq(jSONObject.optString("content")).a(new com.baidu.swan.apps.view.c.a()).eT(false);
                    if (jSONObject.optBoolean("showCancel", true)) {
                        aVar.Q(jSONObject.optString("cancelColor"), a.c.aiapps_modal_cancel_color);
                        String optString2 = jSONObject.optString("cancelText");
                        if (TextUtils.isEmpty(optString2)) {
                            optString2 = b.this.getContext().getString(a.h.aiapps_cancel);
                        }
                        aVar.b(optString2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.b.1.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("type", "cancel");
                                    b.this.a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject2));
                                } catch (JSONException e) {
                                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                        e.printStackTrace();
                                    }
                                    b.this.a(str, new com.baidu.swan.apps.api.c.b(201));
                                }
                            }
                        });
                    }
                    aVar.P(jSONObject.optString("confirmColor"), a.c.aiapps_modal_confirm_color);
                    aVar.a(optString, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.api.module.e.b.1.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("type", "confirm");
                                b.this.a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject2));
                            } catch (JSONException e) {
                                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                    e.printStackTrace();
                                }
                                b.this.a(str, new com.baidu.swan.apps.api.c.b(201));
                            }
                        }
                    });
                    aVar.aon();
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }
}
