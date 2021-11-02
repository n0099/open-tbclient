package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes8.dex */
public class VoiceData$VoiceModel extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5684687527058675291L;
    public transient /* synthetic */ FieldHolder $fh;
    public int curr_time;
    public int duration;
    public int duration2;
    public int elapse;
    public String from;
    public boolean isLocal;
    public String voiceId;
    public Integer voice_status;

    public VoiceData$VoiceModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isLocal = false;
        this.elapse = 0;
        this.curr_time = 0;
        this.voice_status = 1;
    }

    public void copy(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null) {
            return;
        }
        this.from = voiceData$VoiceModel.from;
        this.voiceId = voiceData$VoiceModel.voiceId;
        this.isLocal = voiceData$VoiceModel.isLocal;
        this.duration = voiceData$VoiceModel.duration;
        this.duration2 = voiceData$VoiceModel.duration2;
        this.elapse = voiceData$VoiceModel.elapse;
        this.curr_time = voiceData$VoiceModel.curr_time;
        this.voice_status = voiceData$VoiceModel.voice_status;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.voiceId : (String) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.voice_status = 1;
            this.elapse = 0;
            this.isLocal = false;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        init();
        this.duration = jSONObject.optInt("during_time") / 1000;
        this.voiceId = jSONObject.optString("voice_md5");
    }

    public void parserProtobuf(Voice voice) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, voice) == null) || voice == null) {
            return;
        }
        init();
        this.duration = voice.during_time.intValue() / 1000;
        this.voiceId = voice.voice_md5;
    }
}
