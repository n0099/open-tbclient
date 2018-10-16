package com.baidu.searchbox.ng.ai.apps.media.chooser.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.VideoPickHelper;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class ChooseVideoAction extends AiAppAction {
    public static final String CB_KEY_DURATION = "duration";
    public static final String CB_KEY_FILE_PATH = "tempFilePath";
    public static final String CB_KEY_HEIGHT = "height";
    public static final String CB_KEY_SIZE = "size";
    public static final String CB_KEY_WIDTH = "width";
    private static final boolean DEBUG = false;
    public static final String KEY_CALLBACK = "cb";
    public static final String KEY_COMPRESSED = "compressed";
    public static final String KEY_MAX_DURATION = "maxDuration";
    public static final String KEY_SOURCE = "sourceType";
    public static final String KEY_SOURCE_ALBUM = "album";
    public static final String KEY_SOURCE_CAMERA = "camera";
    private static final String MODULE_NAME = "/swan/chooseVideo";
    private static final String TAG = "ChooseVideoAction";

    public ChooseVideoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        boolean performVideoChooseAction = VideoPickHelper.performVideoChooseAction(context, unitedSchemeEntity, callbackHandler, aiApp, UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
        if (performVideoChooseAction) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
        }
        return performVideoChooseAction;
    }
}
