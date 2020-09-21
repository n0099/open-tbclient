package com.baidu.swan.game.ad.c;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static void a(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.aJG()) {
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
            for (String str : adElementInfo.aJI()) {
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
            return str.replaceAll("\\{REQ_WIDTH\\}", bVar.dnu).replaceAll("\\{REQ_HEIGHT\\}", bVar.dnv).replaceAll("\\{WIDTH\\}", bVar.dnw).replaceAll("\\{HEIGHT\\}", bVar.dnx).replaceAll("\\{DOWN_X\\}", bVar.dny).replaceAll("\\{DOWN_Y\\}", bVar.dnz).replaceAll("\\{UP_X\\}", bVar.dnA).replaceAll("\\{UP_Y\\}", bVar.dnB).replaceAll("\\{VIDEO_TIME\\}", bVar.dnC).replaceAll("\\{BEGIN_TIME\\}", bVar.dnD).replaceAll("\\{END_TIME\\}", bVar.mEndTime).replaceAll("\\{PLAY_FIRST_FRAME\\}", bVar.dnE).replaceAll("\\{PLAY_LAST_FRAME\\}", bVar.dnF).replaceAll("\\{SCENE\\}", bVar.dnG).replaceAll("\\{TYPE\\}", bVar.mType).replaceAll("\\{BEHAVIOR\\}", bVar.dnH).replaceAll("\\{STATUS\\}", bVar.mStatus).replaceAll("\\{CONVERSION_ACTION\\}", bVar.dnI).replaceAll("\\{CLICK_ID\\}", bVar.mClickId);
        }
        return str;
    }

    private static void a(String str, com.baidu.swan.game.ad.a.b bVar) {
        bVar.uk(str);
    }

    public static void a(b bVar, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar2, final a.d dVar) {
        if (adElementInfo != null && !TextUtils.isEmpty(adElementInfo.aJB())) {
            String a = a(adElementInfo.aJB(), bVar);
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
                                if (!TextUtils.equals(jSONObject.optString("ret", ""), "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                                    return null;
                                }
                                a aVar = new a();
                                aVar.mClickId = optJSONObject.optString("clickid");
                                aVar.dnt = optJSONObject.optString("dstlink");
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
                        a.d.this.cC(aVar.mClickId, aVar.dnt);
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            };
            if (SwanAppNetworkUtils.isNetworkConnected(AppRuntime.getAppContext()) && bVar2 != null) {
                bVar2.b(a, responseCallback);
            }
        }
    }
}
