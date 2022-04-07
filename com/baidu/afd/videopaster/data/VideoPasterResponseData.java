package com.baidu.afd.videopaster.data;

import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.repackage.xp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoPasterResponseData extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TPL_IMAGE_TYPE = "ad_video_attach_image";
    public static final String TPL_VIDEO_TYPE = "ad_video_attach_video";
    public static final int VIDEO_PASTER_DEFAULT_DURATION = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public xp pasterData;
    public int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPasterResponseData() {
        super(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = 3;
        this.pasterData = new xp();
    }

    private void parserJson(JSONObject jSONObject) throws ParseError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                        if (optJSONObject2 != null) {
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("adInfo");
                            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(0);
                                if (optJSONObject3 != null) {
                                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray("extra");
                                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i < optJSONArray3.length()) {
                                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i);
                                                if (optJSONObject4 != null && TextUtils.equals("extraParam", optJSONObject4.optString("k"))) {
                                                    this.pasterData.m = optJSONObject4.optString("v");
                                                    break;
                                                }
                                                i++;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (optJSONObject3.optInt("advisible", 1) == 0) {
                                        this.type = 2;
                                        this.pasterData.e(2);
                                        return;
                                    }
                                    JSONArray optJSONArray4 = optJSONObject3.optJSONArray("material");
                                    if (optJSONArray4 != null && optJSONArray4.length() != 0) {
                                        JSONObject optJSONObject5 = optJSONArray4.optJSONObject(0);
                                        if (optJSONObject5 != null) {
                                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("info");
                                            if (optJSONArray5 != null && optJSONArray5.length() != 0) {
                                                parserOnePasterJson(optJSONArray5);
                                                return;
                                            }
                                            throw new ParseError(1, "paster first material info has no element");
                                        }
                                        throw new ParseError(1, "paster first material has no element");
                                    }
                                    throw new ParseError(1, "paster material has no element");
                                }
                                throw new ParseError(1, "paster first adinfo has no element");
                            }
                            throw new ParseError(1, "paster adinfo has no data");
                        }
                        throw new ParseError(1, "paster first ad has no adInfo");
                    }
                    throw new ParseError(1, "paster ad has no adInfo");
                }
                throw new ParseError(1, "paster no res");
            }
            throw new ParseError(1, "paster no data");
        }
    }

    private void parserOnePasterJson(JSONArray jSONArray) throws ParseError {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONArray) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("adType");
                    if (!TextUtils.isEmpty(optString) && optString.equals("3")) {
                        this.type = 2;
                        this.pasterData.e(2);
                        return;
                    }
                    String optString2 = optJSONObject.optString("tplName");
                    if (!TextUtils.isEmpty(optString2)) {
                        if (TPL_VIDEO_TYPE.equals(optString2)) {
                            this.type = 1;
                        } else if (TPL_IMAGE_TYPE.equals(optString2)) {
                            this.type = 0;
                        } else {
                            this.type = 3;
                        }
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("content");
                        if (optJSONObject2 != null) {
                            String optString3 = optJSONObject2.optString("id");
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ad_common");
                            if (optJSONObject3 != null) {
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("ad_monitor_url");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                                        if (optJSONObject4 != null) {
                                            this.pasterData.q.add(optJSONObject4.optString("show_url"));
                                            this.pasterData.r.add(optJSONObject4.optString("click_url"));
                                        }
                                    }
                                }
                                String optString4 = optJSONObject3.optString("title");
                                String optString5 = optJSONObject3.optString(BigdayActivityConfig.JUMP_URL);
                                if (TextUtils.isEmpty(optString4)) {
                                    xp xpVar = this.pasterData;
                                    xpVar.n = true;
                                    xpVar.o = 10;
                                    xpVar.p = 2;
                                    xpVar.e(3);
                                    return;
                                } else if (TextUtils.isEmpty(optString5)) {
                                    xp xpVar2 = this.pasterData;
                                    xpVar2.n = true;
                                    xpVar2.o = 10;
                                    xpVar2.p = 1;
                                    xpVar2.e(3);
                                    return;
                                } else {
                                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("image_list");
                                    if (this.type != 0) {
                                        str = null;
                                    } else if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                                        JSONObject optJSONObject5 = optJSONArray2.optJSONObject(0);
                                        if (optJSONObject5 != null) {
                                            str = optJSONObject5.optString("image");
                                            if (TextUtils.isEmpty(str)) {
                                                xp xpVar3 = this.pasterData;
                                                xpVar3.n = true;
                                                xpVar3.o = 10;
                                                xpVar3.p = 3;
                                                throw new ParseError(2, "image has no data");
                                            }
                                        } else {
                                            throw new ParseError(1, "image_item has no element");
                                        }
                                    } else {
                                        throw new ParseError(1, "image_list has no element");
                                    }
                                    JSONObject optJSONObject6 = optJSONObject2.optJSONObject("operate");
                                    if (optJSONObject6 != null) {
                                        String optString6 = optJSONObject6.optString("type");
                                        String optString7 = optJSONObject6.optString("desc");
                                        String optString8 = optJSONObject6.optString(BigdayActivityConfig.JUMP_URL);
                                        JSONObject optJSONObject7 = optJSONObject2.optJSONObject("video");
                                        if (this.type != 1) {
                                            str2 = null;
                                            str3 = null;
                                        } else if (optJSONObject7 != null) {
                                            str3 = optJSONObject7.optString("url");
                                            str2 = optJSONObject7.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                                            if (TextUtils.isEmpty(str3)) {
                                                xp xpVar4 = this.pasterData;
                                                xpVar4.n = true;
                                                xpVar4.o = 10;
                                                xpVar4.p = 4;
                                                throw new ParseError(2, "video url or cover has no data");
                                            }
                                        } else {
                                            throw new ParseError(2, "video has no data");
                                        }
                                        JSONObject optJSONObject8 = optJSONObject2.optJSONObject("attach");
                                        int optInt = optJSONObject8 != null ? optJSONObject8.optInt("time") : 15;
                                        if (this.type == 3) {
                                            xp xpVar5 = this.pasterData;
                                            xpVar5.n = true;
                                            xpVar5.o = 10;
                                            xpVar5.p = 24;
                                        }
                                        xp xpVar6 = this.pasterData;
                                        xpVar6.c = optString3;
                                        xpVar6.e(this.type);
                                        xp xpVar7 = this.pasterData;
                                        xpVar7.b = optString2;
                                        xpVar7.f = optInt;
                                        xpVar7.e = optString5;
                                        xpVar7.d = optString4;
                                        xpVar7.k = optString7;
                                        xpVar7.j = optString6;
                                        xpVar7.l = optString8;
                                        xpVar7.i = str2;
                                        xpVar7.h = str3;
                                        xpVar7.g = str;
                                        return;
                                    }
                                    throw new ParseError(1, "operate_info has no element");
                                }
                            }
                            throw new ParseError(1, "ad_common array has no element");
                        }
                        throw new ParseError(1, "content inner array has no element");
                    }
                    throw new ParseError(2, "tplName is null");
                }
                throw new ParseError(1, "content outter array has no element");
            }
            throw new ParseError(1, "paster first material info has no element");
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                try {
                    parserJson(jSONObject);
                    return;
                } catch (ParseError e) {
                    this.pasterData.e(3);
                    e.printStackTrace();
                    return;
                }
            }
            this.pasterData.e(3);
        }
    }

    public xp getPasterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pasterData : (xp) invokeV.objValue;
    }
}
