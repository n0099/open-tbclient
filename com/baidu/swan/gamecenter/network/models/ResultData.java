package com.baidu.swan.gamecenter.network.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ResultData<T> implements Serializable {
    @SerializedName("data")
    public T data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}
