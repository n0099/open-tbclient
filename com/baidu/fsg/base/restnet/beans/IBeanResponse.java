package com.baidu.fsg.base.restnet.beans;

import android.content.Context;
import com.baidu.fsg.base.NoProguard;
/* loaded from: classes7.dex */
public interface IBeanResponse extends NoProguard {
    boolean checkResponseValidity();

    void storeResponse(Context context);
}
