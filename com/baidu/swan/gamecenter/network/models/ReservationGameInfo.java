package com.baidu.swan.gamecenter.network.models;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class ReservationGameInfo implements Serializable {
    @SerializedName(Constants.APP_ID)
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
}
