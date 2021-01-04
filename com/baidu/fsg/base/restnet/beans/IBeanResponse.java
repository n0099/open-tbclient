package com.baidu.fsg.base.restnet.beans;

import android.content.Context;
import com.baidu.fsg.base.NoProguard;
/* loaded from: classes6.dex */
public interface IBeanResponse extends NoProguard {
    boolean checkResponseValidity();

    void storeResponse(Context context);
}
