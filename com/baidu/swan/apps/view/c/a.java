package com.baidu.swan.apps.view.c;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.scheme.actions.a {
    public a(j jVar) {
        super(jVar, "/swan/animView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.a
    @NonNull
    public String JI() {
        return "/swan/animView";
    }

    @Override // com.baidu.swan.apps.scheme.actions.a
    public boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        JSONObject j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "params is null");
            return false;
        }
        C0181a c0181a = new C0181a(j);
        if (!c0181a.Nb()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse insert params, but invalid");
            return false;
        }
        JSONObject c = c(c0181a.path, bVar);
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse insert params, path file is invalid");
            return false;
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.G(c0181a.loop);
        lottieAnimationView.setAnimation(c);
        if (c0181a.aZA != null) {
            lottieAnimationView.a(new PorterDuffColorFilter(Color.parseColor(c0181a.aZA.aZB), PorterDuff.Mode.ADD));
            lottieAnimationView.setAlpha(c0181a.aZA.aZC);
        }
        if (c0181a.autoPlay) {
            lottieAnimationView.cu();
        }
        if (!c0181a.loop) {
            a(lottieAnimationView, c0181a);
        }
        boolean a = new SwanAppNAViewContainer(context).a(lottieAnimationView, c0181a);
        c.i("AbsSwanAppWidget", "insert anim view success = " + a);
        if (a) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            c.e("AbsSwanAppWidget", "insert anim view, but failure");
        }
        return a;
    }

    @Override // com.baidu.swan.apps.scheme.actions.a
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        JSONObject j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "params is null");
            return false;
        }
        C0181a c0181a = new C0181a(j);
        if (!c0181a.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse update params, but invalid");
            return false;
        }
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(c0181a, null);
        if (a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            c.e("AbsSwanAppWidget", "get wrapper is null");
            return false;
        }
        View nAView = a.getNAView();
        if (nAView == null || !(nAView instanceof LottieAnimationView)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            c.e("AbsSwanAppWidget", "get lottie view is null");
            return false;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) nAView;
        if (c0181a.aZA != null) {
            lottieAnimationView.a(new PorterDuffColorFilter(Color.parseColor(c0181a.aZA.aZB), PorterDuff.Mode.ADD));
            lottieAnimationView.setAlpha(c0181a.aZA.aZC);
        }
        String str2 = c0181a.action;
        if (TextUtils.equals(str2, "play")) {
            lottieAnimationView.cv();
        } else if (TextUtils.equals(str2, "pause")) {
            lottieAnimationView.cw();
        } else if (TextUtils.equals(str2, IntentConfig.STOP)) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
        }
        boolean a2 = a.a(c0181a);
        c.i("AbsSwanAppWidget", "update anim view success = " + a2);
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return a2;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        c.e("AbsSwanAppWidget", "update anim view, but failure");
        return a2;
    }

    @Override // com.baidu.swan.apps.scheme.actions.a
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        JSONObject j = j(unitedSchemeEntity);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "params is null");
            return false;
        }
        C0181a c0181a = new C0181a(j);
        if (!c0181a.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.e("AbsSwanAppWidget", "parse remove params, but invalid");
            return false;
        }
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(c0181a, null);
        boolean z = a != null && a.MK();
        c.i("AbsSwanAppWidget", "remove anim view success = " + z);
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            c.e("AbsSwanAppWidget", "remove anim view, but failure");
        }
        return z;
    }

    @Override // com.baidu.swan.apps.scheme.actions.a
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        return false;
    }

    private void a(@NonNull final LottieAnimationView lottieAnimationView, final C0181a c0181a) {
        final JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("wvID", c0181a.aBD);
            jSONObject.put("vtype", "ended");
            jSONObject2.putOpt("animationViewId", c0181a.id);
            jSONObject.put("data", jSONObject2.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        lottieAnimationView.a(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.view.c.a.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (lottieAnimationView.getProgress() == 1.0f) {
                    d.a(c0181a.aBD, c0181a.id, "animateview", "ended", jSONObject);
                }
                c.d("AbsSwanAppWidget", "progress: " + lottieAnimationView.getProgress());
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                c.d("AbsSwanAppWidget", "onAnimationRepeat ");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0181a extends com.baidu.swan.apps.model.a.a.a {
        C0182a aZA;
        String action;
        boolean autoPlay;
        boolean loop;
        String path;

        C0181a(JSONObject jSONObject) {
            super("sanId", "animateview");
            this.loop = false;
            this.autoPlay = true;
            this.action = null;
            try {
                parseFromJson(jSONObject);
            } catch (JSONException e) {
                c.e("animView", "parsing animView occurs exception", e);
            }
        }

        @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.path = jSONObject.optString("path");
                this.loop = jSONObject.optBoolean("loop");
                this.autoPlay = jSONObject.optBoolean("autoPlay");
                this.action = jSONObject.optString("action");
                JSONObject optJSONObject = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
                if (optJSONObject != null) {
                    this.aZA = new C0182a();
                    this.aZA.aZB = optJSONObject.optString("bgColor");
                    this.aZA.aZC = (float) optJSONObject.optDouble("opacity");
                }
            }
        }

        @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
        public boolean isValid() {
            return (TextUtils.isEmpty(this.aBD) || TextUtils.isEmpty(this.id)) ? false : true;
        }

        public boolean Nb() {
            return isValid() && !TextUtils.isEmpty(this.path);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.swan.apps.view.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0182a {
            String aZB;
            float aZC;

            C0182a() {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [438=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00af */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056 A[Catch: all -> 0x00af, TryCatch #9 {all -> 0x00af, blocks: (B:17:0x0042, B:18:0x0047, B:20:0x004d, B:36:0x007c, B:23:0x0052, B:25:0x0056, B:26:0x0059), top: B:75:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject c(String str, b bVar) {
        BufferedReader bufferedReader;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || bVar == null) {
            return null;
        }
        try {
            String aC = "bdfile".equalsIgnoreCase(URI.create(str).getScheme()) ? com.baidu.swan.apps.storage.b.aC(str, bVar.id) : com.baidu.swan.apps.storage.b.a(str, bVar, bVar.getVersion());
            ?? isEmpty = TextUtils.isEmpty(aC);
            if (isEmpty != 0) {
                return null;
            }
            File file = new File(aC);
            if (!file.exists()) {
                return null;
            }
            try {
                if (file.isFile()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            jSONObject = new JSONObject(sb.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            c.e("AbsSwanAppWidget", "insert anim view, read json data occur exception");
                            if (bufferedReader == null) {
                                try {
                                    bufferedReader.close();
                                    jSONObject = null;
                                } catch (IOException e3) {
                                    if (DEBUG) {
                                        e3.printStackTrace();
                                    }
                                    jSONObject = null;
                                }
                            } else {
                                jSONObject = null;
                            }
                            return jSONObject;
                        } catch (JSONException e4) {
                            e = e4;
                            if (DEBUG) {
                            }
                            c.e("AbsSwanAppWidget", "insert anim view, read json data occur exception");
                            if (bufferedReader == null) {
                            }
                            return jSONObject;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (JSONException e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        isEmpty = 0;
                        if (isEmpty != 0) {
                            try {
                                isEmpty.close();
                            } catch (IOException e7) {
                                if (DEBUG) {
                                    e7.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            if (DEBUG) {
                e8.printStackTrace();
                return null;
            }
            return null;
        }
    }
}
