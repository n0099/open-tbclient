package com.baidu.adp.lib.a.b.a.a;

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

    private boolean fillByDataSource(com.baidu.adp.lib.a.b.a.c.c cVar) {
        boolean a = com.baidu.adp.lib.a.b.a.e.e.a(cVar, this);
        onFinishSourceToObject(a);
        return a;
    }

    private boolean fillInDataSource(com.baidu.adp.lib.a.b.a.c.c cVar) {
        onPreObjectToSource();
        return com.baidu.adp.lib.a.b.a.e.d.a(this, cVar);
    }

    public boolean fillByMap(Map<String, Object> map) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.f(map));
    }

    public boolean fillInMap(Map<String, Object> map) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.f(map));
    }

    public boolean fillByJsonObject(JSONObject jSONObject) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.e(jSONObject));
    }

    public boolean fillInJsonObject(JSONObject jSONObject) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.e(jSONObject));
    }

    public boolean fillByIntent(Intent intent) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.d(intent));
    }

    public boolean fillInIntent(Intent intent) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.d(intent));
    }

    public boolean fillByBundle(Bundle bundle) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.a(bundle));
    }

    public boolean fillInBundle(Bundle bundle) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.a(bundle));
    }

    public boolean fillByProtobufObject(Message message) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.g(message));
    }

    public boolean fillInProtobufObject(Message message) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.g(message));
    }

    public boolean fillByCursorObject(Cursor cursor) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.b(cursor));
    }

    public boolean fillInCursorObject(ContentValues contentValues) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.b(contentValues));
    }

    public boolean fillByXmlObject(Element element) {
        return fillByDataSource(new com.baidu.adp.lib.a.b.a.c.h(element));
    }

    public boolean fillInXmlObject(Element element) {
        return fillInDataSource(new com.baidu.adp.lib.a.b.a.c.h(element));
    }
}
