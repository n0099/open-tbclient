package com.baidu.swan.gamecenter.network.models;

import com.baidu.android.imsdk.db.TableDefine;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ReservationGameInfo implements Serializable {
    @SerializedName("app_id")
    public String app_id;
    @SerializedName("app_name")
    public String app_name;
    @SerializedName("auto_download")
    public boolean auto_download;
    @SerializedName("download_url")
    public String download_url;
    @SerializedName(TableDefine.EmojiColumns.COLUMN_PACKAGE_ID)
    public String package_id;
    @SerializedName("resource_id")
    public String resource_id;
    @SerializedName("resource_key")
    public String resource_key;
}
