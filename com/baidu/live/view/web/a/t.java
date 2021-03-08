package com.baidu.live.view.web.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.data.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class t extends com.baidu.live.view.web.a {
    private SchemeCallback schemeCallback;

    public t(Context context, SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "sendTagGiftBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl sendTagGiftBridge params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("giftId");
            String optString2 = jSONObject.optString("giftPrice");
            String optString3 = jSONObject.optString("giftName");
            int optInt = jSONObject.optInt("giftNum");
            int optInt2 = jSONObject.optInt("giftType");
            String optString4 = jSONObject.optString("giftUrl");
            try {
                if (!TextUtils.isEmpty(optString4)) {
                    optString4 = URLDecoder.decode(optString4, "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            com.baidu.live.gift.g gVar = new com.baidu.live.gift.g();
            gVar.fW(optString);
            gVar.setGiftName(optString3);
            gVar.setPrice(optString2);
            gVar.fV(String.valueOf(optInt));
            gVar.setSceneFrom(com.baidu.live.utils.q.Vx());
            gVar.cH(optInt2);
            gVar.setThumbnailUrl(optString4);
            BdUniqueId gen = BdUniqueId.gen();
            final int id = gen.getId();
            final String optString5 = jSONObject.optString("callBack");
            if (this.schemeCallback != null) {
                ExtraParamsManager.addH5SendTagGiftCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.t.1
                    @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                    public void onCallback(JSONObject jSONObject2) {
                        Log.i("haha", "@@ haha result=" + jSONObject2);
                        try {
                            if (jSONObject2.optInt("uniqueId", 0) == id) {
                                t.this.schemeCallback.doJsCallback(jSONObject2.optInt("status", 0), jSONObject2.optString("message"), new JSONObject(), optString5);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
            a(gen, gVar, optInt);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a(BdUniqueId bdUniqueId, com.baidu.live.gift.g gVar, int i) {
        ab Fu = ac.Fu();
        ac.b(gVar, i, Fu.aJD.userId + "", Fu.aJD.userName, Fu.mLiveInfo.live_id + "", Fu.mLiveInfo.room_id + "", Fu.mLiveInfo.appId + "", Fu.mLiveInfo.feed_id + "", "", 0L, bdUniqueId);
    }
}
