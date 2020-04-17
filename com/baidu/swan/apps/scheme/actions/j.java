package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j extends ab {
    public j(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/getImageInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("getImageInfo", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = com.baidu.swan.apps.as.s.parseString(unitedSchemeEntity.getParam("params")).optString(UserAccountActionItem.KEY_SRC);
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("getImageInfo", "path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONObject jSONObject = null;
        if (com.baidu.swan.apps.storage.b.nm(optString) == PathType.BD_FILE) {
            jSONObject = br(com.baidu.swan.apps.storage.b.by(optString, eVar.id), optString);
        } else if (com.baidu.swan.apps.storage.b.nm(optString) == PathType.RELATIVE) {
            jSONObject = br(com.baidu.swan.apps.storage.b.a(optString, eVar, eVar.getVersion()), optString);
        }
        if (jSONObject != null) {
            com.baidu.swan.apps.console.c.i("getImageInfo", "getImgInfo success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    private JSONObject br(String str, String str2) {
        int i = 1;
        com.baidu.swan.apps.console.c.i("getImageInfo", "getImgInfo start");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str3 = options.outMimeType;
        String str4 = "";
        if (!TextUtils.isEmpty(str3)) {
            String[] split = str3.split("/");
            str4 = split[split.length - 1];
        }
        if (!TextUtils.equals("png", str4)) {
            ExifInterface gN = gN(str);
            if (gN == null) {
                return null;
            }
            i = gN.getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            jSONObject.put("path", str2);
            jSONObject.put("orientation", gu(i));
            jSONObject.put("type", str4);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("getImageInfo", "getImgInfo failed by json exception");
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.console.c.i("getImageInfo", "getImgInfo end");
        return jSONObject;
    }

    private String gu(int i) {
        switch (i) {
            case 0:
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "left";
            case 7:
                return "right-mirrored";
            case 8:
                return HorizontalTranslateLayout.DIRECTION_RIGHT;
            default:
                return "";
        }
    }

    private ExifInterface gN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (IOException e) {
            return null;
        }
    }
}
