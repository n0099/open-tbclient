package com.baidu.swan.gamecenter.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class ReservationGameResultData implements Serializable {
    @SerializedName("apps")
    public List<ReservationGameInfo> apps;
    @SerializedName("has_more")
    public String has_more;
}
