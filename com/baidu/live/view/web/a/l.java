package com.baidu.live.view.web.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.utils.p;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l extends com.baidu.live.view.web.a {
    private SchemeCallback bRj;

    public l(Context context, SchemeCallback schemeCallback) {
        this.bRj = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "sendTagGiftBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jm(String str) {
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
            gVar.gW(optString);
            gVar.setGiftName(optString3);
            gVar.setPrice(optString2);
            gVar.gV(String.valueOf(optInt));
            gVar.setSceneFrom(p.WB());
            gVar.ej(optInt2);
            gVar.setThumbnailUrl(optString4);
            BdUniqueId gen = BdUniqueId.gen();
            final int id = gen.getId();
            final String optString5 = jSONObject.optString("callBack");
            if (this.bRj != null) {
                ExtraParamsManager.addH5SendTagGiftCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.l.1
                    @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                    public void onCallback(JSONObject jSONObject2) {
                        Log.i("haha", "@@ haha result=" + jSONObject2);
                        try {
                            if (jSONObject2.optInt("uniqueId", 0) == id) {
                                l.this.bRj.doJsCallback(jSONObject2.optInt("status", 0), jSONObject2.optString("message"), new JSONObject(), optString5);
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
        w Iv = ac.Iv();
        ac.b(gVar, i, Iv.aJV.userId + "", Iv.aJV.userName, Iv.mLiveInfo.live_id + "", Iv.mLiveInfo.room_id + "", Iv.mLiveInfo.appId + "", Iv.mLiveInfo.feed_id + "", "", 0L, bdUniqueId);
    }
}
