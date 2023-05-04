package com.baidu.tbadk.core.message;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.cg;
import com.baidu.tieba.cy9;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.hi;
import com.baidu.tieba.ng;
import com.baidu.tieba.rc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpriteTipHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rc5 bgUrlTheme;
    public int needSend;
    public int scene;
    public String sendText;
    public String text;
    public rc5 textColorTheme;
    public String version;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(SpriteTipHttpResponseMessage spriteTipHttpResponseMessage, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteTipHttpResponseMessage, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cg.h().m(this.a, 19, null, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpriteTipHttpResponseMessage() {
        super(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
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
    }

    private void preLoadBgUrl() {
        rc5 rc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, this) != null) || (rc5Var = this.bgUrlTheme) == null) {
            return;
        }
        String g = cy9.g(rc5Var);
        if (!hi.isEmpty(g)) {
            ng.c(new a(this, g));
        }
    }

    public rc5 getBgUrlTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bgUrlTheme;
        }
        return (rc5) invokeV.objValue;
    }

    public boolean getNeedSend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.needSend != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.scene;
        }
        return invokeV.intValue;
    }

    public String getSendText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.sendText;
        }
        return (String) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public rc5 getTextColorTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.textColorTheme;
        }
        return (rc5) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.version;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String parseToString = parseToString(bArr);
            if (!TextUtils.isEmpty(parseToString)) {
                JSONObject jSONObject = new JSONObject(parseToString);
                setError(jSONObject.optInt("error_code", -1));
                setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.scene = optJSONObject.optInt("scene");
                    this.text = optJSONObject.optString("text");
                    this.needSend = optJSONObject.optInt("need_send");
                    this.sendText = optJSONObject.optString("send_text");
                    this.version = optJSONObject.optString("version");
                    this.textColorTheme = rc5.c(optJSONObject.optJSONObject(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR));
                    this.bgUrlTheme = rc5.c(optJSONObject.optJSONObject("icon_url"));
                    preLoadBgUrl();
                }
            }
        }
    }
}
