package com.baidu.graph.sdk.framework.translate;

import android.content.Context;
import com.baidu.graph.sdk.framework.IExtFragmentCallback;
/* loaded from: classes3.dex */
public interface ITransFragmentCallback extends IExtFragmentCallback {

    /* loaded from: classes3.dex */
    public interface UrlCallBack {
        void onURLCallback(String str, int i);
    }

    void release();

    void translateBmp(Context context, String str);

    void translateResult(Context context, String str, UrlCallBack urlCallBack);
}
