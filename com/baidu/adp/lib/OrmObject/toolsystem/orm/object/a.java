package com.baidu.adp.lib.OrmObject.toolsystem.orm.object;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.squareup.wire.Message;
import java.util.Map;
import org.json.JSONObject;
import org.w3c.dom.Element;
/* loaded from: classes.dex */
public class a implements b, c, d, e, f, h {
    public void onPreObjectToSource() {
    }

    public void onFinishSourceToObject(boolean z) {
    }

    private boolean fillByDataSource(com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c cVar) {
        boolean a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.e.a(cVar, this);
        onFinishSourceToObject(a2);
        return a2;
    }

    private boolean fillInDataSource(com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c cVar) {
        onPreObjectToSource();
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.d.a(this, cVar);
    }

    public boolean fillByMap(Map<String, Object> map) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.f(map));
    }

    public boolean fillInMap(Map<String, Object> map) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.f(map));
    }

    public boolean fillByJsonObject(JSONObject jSONObject) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.e(jSONObject));
    }

    public boolean fillInJsonObject(JSONObject jSONObject) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.e(jSONObject));
    }

    public boolean fillByIntent(Intent intent) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.d(intent));
    }

    public boolean fillInIntent(Intent intent) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.d(intent));
    }

    public boolean fillByBundle(Bundle bundle) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.a(bundle));
    }

    public boolean fillInBundle(Bundle bundle) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.a(bundle));
    }

    public boolean fillByProtobufObject(Message message) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.g(message));
    }

    public boolean fillInProtobufObject(Message message) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.g(message));
    }

    public boolean fillByCursorObject(Cursor cursor) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.b(cursor));
    }

    public boolean fillInCursorObject(ContentValues contentValues) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.b(contentValues));
    }

    public boolean fillByXmlObject(Element element) {
        return fillByDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.h(element));
    }

    public boolean fillInXmlObject(Element element) {
        return fillInDataSource(new com.baidu.adp.lib.OrmObject.toolsystem.orm.b.h(element));
    }
}
