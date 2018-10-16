package com.baidu.searchbox.ng.ai.apps.canvas.action;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasMeasureTextModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasMeasureTextAction extends AbsCanvasAction {
    public static final String ACTION_TYPE = "/swan/canvas/measureTextSync";
    private static final String SECOND_LEVEL_JSON_KEY = "width";

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.callback(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ WebView getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.getBdWebViewBySlaveId(unitedSchemeEntity, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ JSONObject resultCode(int i) {
        return super.resultCode(i);
    }

    public CanvasMeasureTextAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        int i;
        int i2;
        Rect rect;
        unitedSchemeEntity.result = resultCode(201);
        CanvasMeasureTextModel parseMsgToModel = parseMsgToModel(unitedSchemeEntity);
        if (parseMsgToModel == null) {
            return false;
        }
        if (parseMsgToModel.mText == null || parseMsgToModel.mText.length() <= 0) {
            i = 0;
        } else {
            if (parseMsgToModel.mBold && parseMsgToModel.mItalic) {
                i2 = 3;
            } else if (parseMsgToModel.mBold) {
                i2 = 1;
            } else {
                i2 = parseMsgToModel.mItalic ? 2 : 0;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.create(parseMsgToModel.mFontFamily, i2));
            textPaint.setTextSize(parseMsgToModel.mFontSize);
            textPaint.getTextBounds(parseMsgToModel.mText, 0, parseMsgToModel.mText.length(), new Rect());
            i = AiAppsUIUtils.px2dp(rect.width());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("width", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public CanvasMeasureTextModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new CanvasMeasureTextModel(str);
    }
}
