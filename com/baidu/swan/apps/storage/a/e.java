package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends z {
    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/file/getSavedFileList");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (context == null || callbackHandler == null || bVar == null || bVar.Re() == null) {
            com.baidu.swan.apps.console.c.e("getSavedFileList", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        ArrayList arrayList = (ArrayList) bVar.Re().SO();
        JSONArray jSONArray = new JSONArray();
        if (arrayList == null || arrayList.size() == 0) {
            com.baidu.swan.apps.console.c.e("getSavedFileList", "file list is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0));
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.storage.a aVar = (com.baidu.swan.apps.storage.a) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("filePath", com.baidu.swan.apps.storage.b.aN(aVar.getPath(), com.baidu.swan.apps.ae.b.Rm()));
                jSONObject.put("createTime", aVar.SL());
                jSONObject.put(TiebaInitialize.LogFields.SIZE, aVar.getSize());
                if (DEBUG) {
                    Log.d("GetSavedFileListAction", "——> handle: fileInfo (" + jSONObject.get("filePath") + " , " + jSONObject.get("createTime") + " , " + jSONObject.get(TiebaInitialize.LogFields.SIZE) + ")");
                }
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.w("getSavedFileList", "file info to json fail");
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("fileList", jSONArray);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
            return true;
        } catch (JSONException e2) {
            com.baidu.swan.apps.console.c.e("getSavedFileList", "file list to json fail");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, com.baidu.swan.apps.scheme.f.getErrMessage(2003)));
            if (DEBUG) {
                Log.d("GetSavedFileListAction", "——> handle: jsonException " + e2.getMessage());
            }
            return false;
        }
    }
}
