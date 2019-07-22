package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends z {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/getImageInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("getImageInfo", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = com.baidu.swan.apps.an.o.dd(unitedSchemeEntity.getParam("params")).optString("src");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("getImageInfo", "path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONObject jSONObject = null;
        if (com.baidu.swan.apps.storage.b.hG(optString) == PathType.BD_FILE) {
            jSONObject = aw(com.baidu.swan.apps.storage.b.aE(optString, bVar.id), optString);
        } else if (com.baidu.swan.apps.storage.b.hG(optString) == PathType.RELATIVE) {
            jSONObject = aw(com.baidu.swan.apps.storage.b.a(optString, bVar, bVar.getVersion()), optString);
        }
        if (jSONObject != null) {
            com.baidu.swan.apps.console.c.i("getImageInfo", "getImgInfo success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    private JSONObject aw(String str, String str2) {
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
            ExifInterface he = he(str);
            if (he == null) {
                return null;
            }
            i = he.getAttributeInt("Orientation", 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            jSONObject.put("path", str2);
            jSONObject.put("orientation", dM(i));
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

    private String dM(int i) {
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
                return CustomDialogData.POS_LEFT;
            case 7:
                return "right-mirrored";
            case 8:
                return "right";
            default:
                return "";
        }
    }

    private ExifInterface he(String str) {
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
