package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes4.dex */
public class VoiceData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface VoiceConfig {
        public static final int SEND_PLAY_TIME_INTERVAL = 100;
        public static final int SEND_RECORD_TIME_INTERVAL = 200;
        public static final int SEND_VOLUM_INTERVAL = 200;
    }

    /* loaded from: classes4.dex */
    public static class VoiceModel extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5684687527058675291L;
        public transient /* synthetic */ FieldHolder $fh;
        public int curr_time;
        public int duration;
        public int duration2;
        public int elapse;
        public String from;
        public boolean isGroupChat;
        public boolean isLocal;
        public String voiceId;
        public String voiceUrl;
        public Integer voice_status;

        public VoiceModel() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isGroupChat = false;
            this.isLocal = false;
            this.elapse = 0;
            this.curr_time = 0;
            this.voice_status = 1;
        }

        public int getCurr_time() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.curr_time;
            }
            return invokeV.intValue;
        }

        public int getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.duration;
            }
            return invokeV.intValue;
        }

        public String getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return getVoiceId();
            }
            return (String) invokeV.objValue;
        }

        public String getVoiceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.voiceId;
            }
            return (String) invokeV.objValue;
        }

        public String getVoiceUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.voiceUrl;
            }
            return (String) invokeV.objValue;
        }

        public void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.voice_status = 1;
                this.elapse = 0;
                this.isLocal = false;
            }
        }

        public void copy(VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, voiceModel) != null) || voiceModel == null) {
                return;
            }
            this.from = voiceModel.from;
            setVoiceId(voiceModel.getVoiceId());
            this.isLocal = voiceModel.isLocal;
            setDuration(voiceModel.getDuration());
            this.duration2 = voiceModel.duration2;
            this.elapse = voiceModel.elapse;
            setCurr_time(voiceModel.getCurr_time());
            this.voice_status = voiceModel.voice_status;
        }

        public void parseJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            init();
            setDuration(jSONObject.optInt("during_time") / 1000);
            setVoiceId(jSONObject.optString("voice_md5"));
        }

        public void parserProtobuf(Voice voice) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voice) != null) || voice == null) {
                return;
            }
            init();
            setDuration(voice.during_time.intValue() / 1000);
            setVoiceId(voice.voice_md5);
        }

        public void setCurr_time(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.curr_time = i;
            }
        }

        public void setDuration(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                this.duration = i;
            }
        }

        public void setVoiceId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.voiceId = str;
            }
        }

        public void setVoiceUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.voiceUrl = str;
            }
        }
    }

    public VoiceData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
