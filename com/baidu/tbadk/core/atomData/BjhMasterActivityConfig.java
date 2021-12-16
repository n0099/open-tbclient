package com.baidu.tbadk.core.atomData;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BjhMasterActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TiebaExtra tiebaExtra;

    @Keep
    /* loaded from: classes11.dex */
    public static final class TiebaExtra implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(HttpRequest.CLIENT_TYPE)
        public String clientType;
        public String fid;
        @SerializedName(TiebaStatic.Params.H5_FORUM_NAME)
        public String forumName;
        @SerializedName("name_show")
        public String nameShow;
        @SerializedName("user_name")
        public String userName;

        public TiebaExtra() {
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

        public /* synthetic */ TiebaExtra(a aVar) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BjhMasterActivityConfig(@NonNull Application application, @Nullable String str, @Nullable String str2) {
        super(application);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TiebaExtra tiebaExtra = new TiebaExtra(null);
        this.tiebaExtra = tiebaExtra;
        tiebaExtra.fid = str == null ? "0" : str;
        this.tiebaExtra.forumName = str2 == null ? "" : str2;
        this.tiebaExtra.nameShow = TbadkCoreApplication.getCurrentAccountNameShow();
        this.tiebaExtra.userName = TbadkCoreApplication.getCurrentAccountName();
        this.tiebaExtra.clientType = "2";
    }

    @NonNull
    public String getStartJsonParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Objects.requireNonNull(this.tiebaExtra);
            try {
                JSONObject jSONObject = new JSONObject("{\n  \"create_room_params\": {\n    \"is_test_live\": 0\n  }\n}");
                jSONObject.put("tieba_extra", new JSONObject(DataExt.f(this.tiebaExtra)));
                return jSONObject.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
