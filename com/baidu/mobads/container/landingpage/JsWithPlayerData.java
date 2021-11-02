package com.baidu.mobads.container.landingpage;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class JsWithPlayerData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callJsfunc;
    public String interactivetype;
    public boolean isAutoPlayNext;
    public boolean isAutoPlayThis;
    public boolean isExistNextVideo;
    public boolean isExistPreVideo;
    public boolean isFullScreenPlay;
    public boolean isPlayerTopLocation;
    public boolean isShowSpeed;
    public boolean isShowTitle;
    public String mCurVideoPlayTime;
    public String mCurVideoStatus;
    public String mCurVideoUserAction;
    public String mPrerolls_Id;
    public String mPrerolls_Img;
    public String mPrerolls_Title;
    public String nextVideoPicurl;
    public String nextVideoTitle;
    public String nextVideoUrl;
    public String preVideoTitle;
    public String prevVideoPicurl;
    public String prevVideoUrl;
    public String videoId;
    public String videoIndex;
    public String videoPicUrl;
    public String videoTitle;
    public String videoUrl;

    public JsWithPlayerData(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.interactivetype = jSONObject.optString("type");
        this.isAutoPlayThis = jSONObject.optBoolean("isautoplaythis", true);
        this.isAutoPlayNext = jSONObject.optBoolean("isautoplaynext");
        this.isPlayerTopLocation = jSONObject.optBoolean("isvieoattop");
        this.isShowSpeed = jSONObject.optBoolean("isshowspeed");
        this.isFullScreenPlay = jSONObject.optBoolean("isfullscreen");
        this.isFullScreenPlay = true;
        this.isExistPreVideo = jSONObject.optBoolean("isexistprevideo");
        this.isExistNextVideo = jSONObject.optBoolean("isexistnextvideo");
        this.isShowTitle = jSONObject.optBoolean("isshowtitle");
        this.videoUrl = jSONObject.optString("videourl");
        this.videoTitle = jSONObject.optString("videotitle");
        this.videoPicUrl = jSONObject.optString("mainpicurl");
        this.videoId = jSONObject.optString("videoid");
        this.videoIndex = jSONObject.optString("videoindex");
        this.prevVideoUrl = jSONObject.optString("prevideourl");
        this.nextVideoUrl = jSONObject.optString("nextvideourl");
        this.prevVideoPicurl = jSONObject.optString("prevideopicurl");
        this.nextVideoPicurl = jSONObject.optString("nextvideopicurl");
        this.preVideoTitle = jSONObject.optString("prevideotitle");
        this.nextVideoTitle = jSONObject.optString("nextvideotitle");
        this.mPrerolls_Id = jSONObject.optString("bdadid");
        this.mPrerolls_Img = jSONObject.optString("bdadimg");
        this.mPrerolls_Title = jSONObject.optString("bdadtitle");
        this.callJsfunc = str;
    }

    public static JsWithPlayerData createObjFromUrl(String str) {
        InterceptResult invokeL;
        String str2;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject jSONObject = null;
            try {
                Uri parse = Uri.parse(str);
                queryParameter = parse.getQueryParameter("params");
                str2 = parse.getQueryParameter("callback");
            } catch (Exception e2) {
                e = e2;
                str2 = null;
            }
            try {
                jSONObject = new JSONObject(queryParameter);
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return new JsWithPlayerData(jSONObject, str2);
            }
            return new JsWithPlayerData(jSONObject, str2);
        }
        return (JsWithPlayerData) invokeL.objValue;
    }

    public String getCurVideoPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurVideoPlayTime : (String) invokeV.objValue;
    }

    public String getCurVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurVideoStatus : (String) invokeV.objValue;
    }

    public String getCurVideoUserAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurVideoUserAction : (String) invokeV.objValue;
    }

    public void setCurVideoPlayTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mCurVideoPlayTime = str;
        }
    }

    public void setCurVideoStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mCurVideoStatus = str;
        }
    }

    public void setCurVideoUserAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mCurVideoUserAction = str;
        }
    }
}
