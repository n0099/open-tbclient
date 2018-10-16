package com.baidu.searchbox.ng.ai.apps.canvas.action;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
interface ICanvasPreHandle {
    void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z);

    WebView getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str);

    CanvasBasicModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity);

    JSONObject resultCode(int i);
}
