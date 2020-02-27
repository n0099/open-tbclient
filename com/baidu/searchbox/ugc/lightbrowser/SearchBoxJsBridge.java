package com.baidu.searchbox.ugc.lightbrowser;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
/* loaded from: classes13.dex */
public class SearchBoxJsBridge extends BaseJsBridge implements NoProGuard {
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_jsbridge";
    private static final String TAG = "SearchBoxJsBridge";
    private Context mContext;

    public SearchBoxJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        super(context, unitedSchemeMainDispatcher, callbackHandler);
        this.mContext = context;
    }

    @JavascriptInterface
    public boolean dispatch(String str) {
        BaseRouter.invoke(this.mContext, str);
        return true;
    }

    private boolean doSchemeDispatch(String str, String str2) {
        return false;
    }
}
