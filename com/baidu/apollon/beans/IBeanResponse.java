package com.baidu.apollon.beans;

import android.content.Context;
import com.baidu.apollon.NoProguard;
/* loaded from: classes8.dex */
public interface IBeanResponse extends NoProguard {
    boolean checkResponseValidity();

    void storeResponse(Context context);
}
