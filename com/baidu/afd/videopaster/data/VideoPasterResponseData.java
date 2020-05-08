package com.baidu.afd.videopaster.data;

import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class VideoPasterResponseData extends JsonHttpResponsedMessage {
    private static final String TPL_IMAGE_TYPE = "ad_video_attach_image";
    private static final String TPL_VIDEO_TYPE = "ad_video_attach_video";
    private static final int VIDEO_PASTER_DEFAULT_DURATION = 15;
    private a pasterData;
    private int type;

    public VideoPasterResponseData() {
        super(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        this.type = 3;
        this.pasterData = new a();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            try {
                parserJson(jSONObject);
                return;
            } catch (ParseError e) {
                this.pasterData.aK(3);
                e.printStackTrace();
                return;
            }
        }
        this.pasterData.aK(3);
    }

    private void parserJson(JSONObject jSONObject) throws ParseError {
        if (jSONObject == null) {
            throw new ParseError(1, "paster no data");
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("res");
        if (optJSONObject == null) {
            throw new ParseError(1, "paster no res");
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            throw new ParseError(1, "paster ad has no adInfo");
        }
        JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
        if (optJSONObject2 == null) {
            throw new ParseError(1, "paster first ad has no adInfo");
        }
        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("adInfo");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            throw new ParseError(1, "paster adinfo has no data");
        }
        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(0);
        if (optJSONObject3 == null) {
            throw new ParseError(1, "paster first adinfo has no element");
        }
        JSONArray optJSONArray3 = optJSONObject3.optJSONArray("extra");
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            int i = 0;
            while (true) {
                if (i < optJSONArray3.length()) {
                    JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i);
                    if (optJSONObject4 == null || !TextUtils.equals("extraParam", optJSONObject4.optString("k"))) {
                        i++;
                    } else {
                        this.pasterData.extra = optJSONObject4.optString("v");
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (optJSONObject3.optInt("advisible", 1) == 0) {
            this.type = 2;
            this.pasterData.aK(this.type);
            return;
        }
        JSONArray optJSONArray4 = optJSONObject3.optJSONArray("material");
        if (optJSONArray4 == null || optJSONArray4.length() == 0) {
            throw new ParseError(1, "paster material has no element");
        }
        JSONObject optJSONObject5 = optJSONArray4.optJSONObject(0);
        if (optJSONObject5 == null) {
            throw new ParseError(1, "paster first material has no element");
        }
        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("info");
        if (optJSONArray5 == null || optJSONArray5.length() == 0) {
            throw new ParseError(1, "paster first material info has no element");
        }
        parserOnePasterJson(optJSONArray5);
    }

    private void parserOnePasterJson(JSONArray jSONArray) throws ParseError {
        if (jSONArray == null || jSONArray.length() == 0) {
            throw new ParseError(1, "paster first material info has no element");
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            throw new ParseError(1, "content outter array has no element");
        }
        String optString = optJSONObject.optString("adType");
        if (!TextUtils.isEmpty(optString) && optString.equals("3")) {
            this.type = 2;
            this.pasterData.aK(this.type);
            return;
        }
        String optString2 = optJSONObject.optString("tplName");
        if (TextUtils.isEmpty(optString2)) {
            throw new ParseError(2, "tplName is null");
        }
        if (TPL_VIDEO_TYPE.equals(optString2)) {
            this.type = 1;
        } else if (TPL_IMAGE_TYPE.equals(optString2)) {
            this.type = 0;
        } else {
            this.type = 3;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("content");
        if (optJSONObject2 == null) {
            throw new ParseError(1, "content inner array has no element");
        }
        String optString3 = optJSONObject2.optString("id");
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ad_common");
        if (optJSONObject3 == null) {
            throw new ParseError(1, "ad_common array has no element");
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("ad_monitor_url");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                if (optJSONObject4 != null) {
                    this.pasterData.XC.add(optJSONObject4.optString("show_url"));
                    this.pasterData.XD.add(optJSONObject4.optString("click_url"));
                }
            }
        }
        String optString4 = optJSONObject3.optString("title");
        String optString5 = optJSONObject3.optString(BigdayActivityConfig.JUMP_URL);
        String str = null;
        if (TextUtils.isEmpty(optString4)) {
            this.pasterData.Xz = true;
            this.pasterData.XA = 10;
            this.pasterData.XB = 2;
            this.pasterData.aK(3);
        } else if (TextUtils.isEmpty(optString5)) {
            this.pasterData.Xz = true;
            this.pasterData.XA = 10;
            this.pasterData.XB = 1;
            this.pasterData.aK(3);
        } else {
            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("image_list");
            if (this.type == 0) {
                if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                    throw new ParseError(1, "image_list has no element");
                }
                JSONObject optJSONObject5 = optJSONArray2.optJSONObject(0);
                if (optJSONObject5 == null) {
                    throw new ParseError(1, "image_item has no element");
                }
                str = optJSONObject5.optString("image");
                if (TextUtils.isEmpty(str)) {
                    this.pasterData.Xz = true;
                    this.pasterData.XA = 10;
                    this.pasterData.XB = 3;
                    throw new ParseError(2, "image has no data");
                }
            }
            JSONObject optJSONObject6 = optJSONObject2.optJSONObject("operate");
            if (optJSONObject6 == null) {
                throw new ParseError(1, "operate_info has no element");
            }
            String optString6 = optJSONObject6.optString("type");
            String optString7 = optJSONObject6.optString("desc");
            String optString8 = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
            String str2 = null;
            String str3 = null;
            JSONObject optJSONObject7 = optJSONObject2.optJSONObject("video");
            if (this.type == 1) {
                if (optJSONObject7 == null) {
                    throw new ParseError(2, "video has no data");
                }
                str2 = optJSONObject7.optString("url");
                str3 = optJSONObject7.optString("cover");
                if (TextUtils.isEmpty(str2)) {
                    this.pasterData.Xz = true;
                    this.pasterData.XA = 10;
                    this.pasterData.XB = 4;
                    throw new ParseError(2, "video url or cover has no data");
                }
            }
            int i2 = 15;
            JSONObject optJSONObject8 = optJSONObject2.optJSONObject("attach");
            if (optJSONObject8 != null) {
                i2 = optJSONObject8.optInt("time");
            }
            if (this.type == 3) {
                this.pasterData.Xz = true;
                this.pasterData.XA = 10;
                this.pasterData.XB = 24;
            }
            this.pasterData.adid = optString3;
            this.pasterData.aK(this.type);
            this.pasterData.tplName = optString2;
            this.pasterData.Xu = i2;
            this.pasterData.Xt = optString5;
            this.pasterData.Xs = optString4;
            this.pasterData.Xx = optString7;
            this.pasterData.Xw = optString6;
            this.pasterData.Xy = optString8;
            this.pasterData.Xv = str3;
            this.pasterData.videoUrl = str2;
            this.pasterData.picUrl = str;
        }
    }

    public a getPasterData() {
        return this.pasterData;
    }
}
