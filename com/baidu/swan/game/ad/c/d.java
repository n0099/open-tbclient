package com.baidu.swan.game.ad.c;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.qq.e.comm.constants.Constants;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static void a(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.aRW()) {
                a(a(str, (b) null), bVar);
            }
        }
    }

    public static void d(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getThirdClickTrackingUrls()) {
                a(a(str, (b) null), bVar);
            }
        }
    }

    public static void a(b bVar, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar2) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.aRY()) {
                a(a(str, bVar), bVar2);
            }
        }
    }

    public static void b(b bVar, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar2) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getCloseTrackers()) {
                a(a(str, bVar), bVar2);
            }
        }
    }

    public static String a(String str, b bVar) {
        if (bVar != null) {
            return str.replaceAll("\\{REQ_WIDTH\\}", bVar.dZv).replaceAll("\\{REQ_HEIGHT\\}", bVar.dZw).replaceAll("\\{WIDTH\\}", bVar.dZx).replaceAll("\\{HEIGHT\\}", bVar.dZy).replaceAll("\\{DOWN_X\\}", bVar.dZz).replaceAll("\\{DOWN_Y\\}", bVar.dZA).replaceAll("\\{UP_X\\}", bVar.dZB).replaceAll("\\{UP_Y\\}", bVar.dZC).replaceAll("\\{VIDEO_TIME\\}", bVar.dZD).replaceAll("\\{BEGIN_TIME\\}", bVar.dZE).replaceAll("\\{END_TIME\\}", bVar.mEndTime).replaceAll("\\{PLAY_FIRST_FRAME\\}", bVar.dZF).replaceAll("\\{PLAY_LAST_FRAME\\}", bVar.dZG).replaceAll("\\{SCENE\\}", bVar.dZH).replaceAll("\\{TYPE\\}", bVar.mType).replaceAll("\\{BEHAVIOR\\}", bVar.dZI).replaceAll("\\{STATUS\\}", bVar.mStatus).replaceAll("\\{CONVERSION_ACTION\\}", bVar.dZJ).replaceAll("\\{CLICK_ID\\}", bVar.dZt);
        }
        return str;
    }

    private static void a(String str, com.baidu.swan.game.ad.a.b bVar) {
        bVar.vm(str);
    }

    public static void a(b bVar, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar2, final a.d dVar) {
        if (adElementInfo != null && !TextUtils.isEmpty(adElementInfo.aRR())) {
            String a2 = a(adElementInfo.aRR(), bVar);
            ResponseCallback<a> responseCallback = new ResponseCallback<a>() { // from class: com.baidu.swan.game.ad.c.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: d */
                public a parseResponse(Response response, int i) {
                    JSONObject optJSONObject;
                    if (response == null || response.body() == null || !response.isSuccessful()) {
                        return null;
                    }
                    try {
                        try {
                            String string = response.body().string();
                            if (TextUtils.isEmpty(string)) {
                                return null;
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(string);
                                if (!TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                                    return null;
                                }
                                a aVar = new a();
                                aVar.dZt = optJSONObject.optString("clickid");
                                aVar.dZu = optJSONObject.optString("dstlink");
                                return aVar;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return null;
                            }
                        } catch (Exception e2) {
                            return null;
                        }
                    } catch (OutOfMemoryError e3) {
                        return null;
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: a */
                public void onSuccess(a aVar, int i) {
                    if (aVar != null && a.d.this != null) {
                        a.d.this.cM(aVar.dZt, aVar.dZu);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            };
            if (SwanAppNetworkUtils.isNetworkConnected(AppRuntime.getAppContext()) && bVar2 != null) {
                bVar2.b(a2, responseCallback);
            }
        }
    }
}
