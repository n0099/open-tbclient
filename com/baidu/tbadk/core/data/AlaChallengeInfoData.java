package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaChallengeInfo;
/* loaded from: classes11.dex */
public class AlaChallengeInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7697481412505420403L;
    public transient /* synthetic */ FieldHolder $fh;
    public long challenge_id;
    public String ext;
    public String rival_hls_url;
    public String rival_rtmp_url;
    public String rival_session;
    public long winning_num;

    public AlaChallengeInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.challenge_id = jSONObject.optLong("challenge_id");
        this.winning_num = jSONObject.optLong("winning_num");
        this.rival_session = jSONObject.optString("rival_session");
        this.rival_rtmp_url = jSONObject.optString("rival_rtmp_url");
        this.rival_hls_url = jSONObject.optString("rival_hls_url");
        this.ext = jSONObject.optString("ext");
    }

    public void parserProtobuf(AlaChallengeInfo alaChallengeInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaChallengeInfo) == null) || alaChallengeInfo == null) {
            return;
        }
        this.challenge_id = alaChallengeInfo.challenge_id.longValue();
        this.winning_num = alaChallengeInfo.winning_num.longValue();
        this.rival_session = alaChallengeInfo.rival_session;
        this.rival_rtmp_url = alaChallengeInfo.rival_rtmp_url;
        this.rival_hls_url = alaChallengeInfo.rival_hls_url;
        this.ext = alaChallengeInfo.ext;
    }
}
