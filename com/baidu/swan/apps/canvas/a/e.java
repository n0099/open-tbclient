package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ AbsoluteLayout a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.a(unitedSchemeEntity, str);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject cM(int i) {
        return super.cM(i);
    }

    public e(j jVar) {
        super(jVar, "/swan/canvas/measureTextSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        int i;
        int i2;
        Rect rect;
        unitedSchemeEntity.result = cM(201);
        com.baidu.swan.apps.canvas.c.d c = c(unitedSchemeEntity);
        if (c == null) {
            return false;
        }
        if (c.mText == null || c.mText.length() <= 0) {
            i = 0;
        } else {
            if (c.aGw && c.mItalic) {
                i2 = 3;
            } else if (c.aGw) {
                i2 = 1;
            } else {
                i2 = c.mItalic ? 2 : 0;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.create(c.aGu, i2));
            textPaint.setTextSize(c.aGv);
            textPaint.getTextBounds(c.mText, 0, c.mText.length(), new Rect());
            i = z.U(rect.width());
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
    /* renamed from: f */
    public com.baidu.swan.apps.canvas.c.d c(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.c.d(str);
    }
}
