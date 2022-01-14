package com.baidu.afd.videopaster.data;

import android.text.TextUtils;
import c.a.e.m.e.a;
import com.baidu.afd.ParseError;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class VideoPasterResponseData extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TPL_IMAGE_TYPE = "ad_video_attach_image";
    public static final String TPL_VIDEO_TYPE = "ad_video_attach_video";
    public static final int VIDEO_PASTER_DEFAULT_DURATION = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public a pasterData;
    public int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPasterResponseData() {
        super(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = 3;
        this.pasterData = new a();
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
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 < optJSONArray3.length()) {
                                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i2);
                                                if (optJSONObject4 != null && TextUtils.equals("extraParam", optJSONObject4.optString("k"))) {
                                                    this.pasterData.q = optJSONObject4.optString("v");
                                                    break;
                                                }
                                                i2++;
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
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i2);
                                        if (optJSONObject4 != null) {
                                            this.pasterData.u.add(optJSONObject4.optString("show_url"));
                                            this.pasterData.v.add(optJSONObject4.optString("click_url"));
                                        }
                                    }
                                }
                                String optString4 = optJSONObject3.optString("title");
                                String optString5 = optJSONObject3.optString("jump_url");
                                if (TextUtils.isEmpty(optString4)) {
                                    a aVar = this.pasterData;
                                    aVar.r = true;
                                    aVar.s = 10;
                                    aVar.t = 2;
                                    aVar.e(3);
                                    return;
                                } else if (TextUtils.isEmpty(optString5)) {
                                    a aVar2 = this.pasterData;
                                    aVar2.r = true;
                                    aVar2.s = 10;
                                    aVar2.t = 1;
                                    aVar2.e(3);
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
                                                a aVar3 = this.pasterData;
                                                aVar3.r = true;
                                                aVar3.s = 10;
                                                aVar3.t = 3;
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
                                        String optString8 = optJSONObject6.optString("jump_url");
                                        JSONObject optJSONObject7 = optJSONObject2.optJSONObject("video");
                                        if (this.type != 1) {
                                            str2 = null;
                                            str3 = null;
                                        } else if (optJSONObject7 != null) {
                                            str3 = optJSONObject7.optString("url");
                                            str2 = optJSONObject7.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                                            if (TextUtils.isEmpty(str3)) {
                                                a aVar4 = this.pasterData;
                                                aVar4.r = true;
                                                aVar4.s = 10;
                                                aVar4.t = 4;
                                                throw new ParseError(2, "video url or cover has no data");
                                            }
                                        } else {
                                            throw new ParseError(2, "video has no data");
                                        }
                                        JSONObject optJSONObject8 = optJSONObject2.optJSONObject("attach");
                                        int optInt = optJSONObject8 != null ? optJSONObject8.optInt("time") : 15;
                                        if (this.type == 3) {
                                            a aVar5 = this.pasterData;
                                            aVar5.r = true;
                                            aVar5.s = 10;
                                            aVar5.t = 24;
                                        }
                                        a aVar6 = this.pasterData;
                                        aVar6.f3459g = optString3;
                                        aVar6.e(this.type);
                                        a aVar7 = this.pasterData;
                                        aVar7.f3458f = optString2;
                                        aVar7.f3462j = optInt;
                                        aVar7.f3461i = optString5;
                                        aVar7.f3460h = optString4;
                                        aVar7.o = optString7;
                                        aVar7.n = optString6;
                                        aVar7.p = optString8;
                                        aVar7.m = str2;
                                        aVar7.l = str3;
                                        aVar7.k = str;
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
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                try {
                    parserJson(jSONObject);
                    return;
                } catch (ParseError e2) {
                    this.pasterData.e(3);
                    e2.printStackTrace();
                    return;
                }
            }
            this.pasterData.e(3);
        }
    }

    public a getPasterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pasterData : (a) invokeV.objValue;
    }
}
