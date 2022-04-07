package com.baidu.swan.gamecenter.network.models;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ReservationGameInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("app_id")
    public String app_id;
    @SerializedName("app_name")
    public String app_name;
    @SerializedName("auto_download")
    public boolean auto_download;
    @SerializedName("download_url")
    public String download_url;
    @SerializedName("package_id")
    public String package_id;
    @SerializedName(TiebaStatic.Params.RESOURCE_ID)
    public String resource_id;
    @SerializedName("resource_key")
    public String resource_key;

    public ReservationGameInfo() {
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
