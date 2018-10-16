package com.baidu.searchbox.ng.ai.apps.map;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public class MapAction extends AiAppAction {
    private static final String ACTION_CHOOSE_LOCATION = "/swan/map/chooseLocation";
    private static final String ACTION_CREATE = "/swan/map/create";
    private static final String ACTION_GET_CENTER_LOCATION = "/swan/map/getCenterLocation";
    private static final String ACTION_GET_REGION = "/swan/map/getRegion";
    private static final String ACTION_GET_SCALE = "/swan/map/getScale";
    private static final String ACTION_INCLUDE_POINTS = "/swan/map/includePoints";
    private static final String ACTION_MOVE_TO_LOCATION = "/swan/map/moveToLocation";
    private static final String ACTION_OPEN_LOCATION = "/swan/map/openLocation";
    private static final String ACTION_OPEN_NAVIGATION = "/swan/map/openWalkNavigation";
    private static final String ACTION_REMOVE = "/swan/map/remove";
    private static final String ACTION_TRANSLATE_MARKER = "/swan/map/translateMarker";
    private static final String ACTION_UPDATE = "/swan/map/update";
    private static final boolean DEBUG = false;
    private static final String MODULE_NAME = "/swan/map";
    private static final String MODULE_PATH = "/swan/map/";
    public static final String MODULE_TAG = "map";
    private static final String TAG = "MapAction";

    public MapAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        boolean openWalkNavigation;
        AiAppsLog.i("map", "handleSubAction " + str);
        char c = 65535;
        switch (str.hashCode()) {
            case -1733613079:
                if (str.equals(ACTION_OPEN_NAVIGATION)) {
                    c = 11;
                    break;
                }
                break;
            case -1106368664:
                if (str.equals(ACTION_GET_REGION)) {
                    c = '\b';
                    break;
                }
                break;
            case -758520770:
                if (str.equals(ACTION_CREATE)) {
                    c = 0;
                    break;
                }
                break;
            case -340837434:
                if (str.equals(ACTION_REMOVE)) {
                    c = 2;
                    break;
                }
                break;
            case -245072885:
                if (str.equals(ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
            case -220100127:
                if (str.equals(ACTION_OPEN_LOCATION)) {
                    c = 4;
                    break;
                }
                break;
            case 332527518:
                if (str.equals(ACTION_GET_CENTER_LOCATION)) {
                    c = '\t';
                    break;
                }
                break;
            case 877004326:
                if (str.equals(ACTION_TRANSLATE_MARKER)) {
                    c = 3;
                    break;
                }
                break;
            case 1162505769:
                if (str.equals(ACTION_INCLUDE_POINTS)) {
                    c = 6;
                    break;
                }
                break;
            case 1350642262:
                if (str.equals(ACTION_GET_SCALE)) {
                    c = 7;
                    break;
                }
                break;
            case 1767935811:
                if (str.equals(ACTION_MOVE_TO_LOCATION)) {
                    c = 5;
                    break;
                }
                break;
            case 1986876462:
                if (str.equals(ACTION_CHOOSE_LOCATION)) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().create(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 1:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().update(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 2:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().remove(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 3:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().translateMarker(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 4:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().openLocation(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 5:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().moveToLocation(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 6:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().includePoints(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 7:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().getScale(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case '\b':
                openWalkNavigation = AiAppsRuntime.getMapRuntime().getRegion(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case '\t':
                openWalkNavigation = AiAppsRuntime.getMapRuntime().getCenterLocation(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case '\n':
                openWalkNavigation = AiAppsRuntime.getMapRuntime().chooseLocation(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 11:
                openWalkNavigation = AiAppsRuntime.getMapRuntime().openWalkNavigation(context, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            default:
                openWalkNavigation = false;
                break;
        }
        return openWalkNavigation || super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
    }
}
