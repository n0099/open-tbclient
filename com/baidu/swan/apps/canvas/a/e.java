package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject hC(int i) {
        return super.hC(i);
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/canvas/measureTextSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        int i;
        int i2;
        Rect rect;
        unitedSchemeEntity.result = hC(201);
        com.baidu.swan.apps.canvas.b.d d = d(unitedSchemeEntity);
        if (d == null) {
            return false;
        }
        if (d.mText == null || d.mText.length() <= 0) {
            i = 0;
        } else {
            if (d.cCu && d.mItalic) {
                i2 = 3;
            } else if (d.cCu) {
                i2 = 1;
            } else {
                i2 = d.mItalic ? 2 : 0;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.create(d.cCs, i2));
            textPaint.setTextSize(d.cCt);
            textPaint.getTextBounds(d.mText, 0, d.mText.length(), new Rect());
            i = ah.P(rect.width());
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
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: g */
    public com.baidu.swan.apps.canvas.b.d d(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.b.d(str);
    }
}
