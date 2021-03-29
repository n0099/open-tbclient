package com.baidu.mobads.openad.a;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements IOAdEvent {

    /* renamed from: a  reason: collision with root package name */
    public final String f8396a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Object> f8397b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8398c;

    /* renamed from: d  reason: collision with root package name */
    public Object f8399d;

    public b(String str) {
        this(str, 0, new HashMap());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    /* renamed from: a */
    public HashMap<String, Object> getData() {
        return this.f8397b;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public int getCode() {
        return this.f8398c;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public String getMessage() {
        try {
            return (String) this.f8397b.get("message");
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public Object getTarget() {
        return this.f8399d;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public String getType() {
        return this.f8396a;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public void setTarget(Object obj) {
        this.f8399d = obj;
    }

    public b(String str, String str2) {
        this(str, 0, str2);
    }

    public void a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            this.f8397b.put("instanceInfo", iXAdInstanceInfo.getUniqueId());
        }
    }

    public b(String str, HashMap<String, Object> hashMap) {
        this(str, 0, hashMap);
    }

    public b(String str, int i, HashMap<String, Object> hashMap) {
        this.f8396a = str;
        this.f8398c = i;
        this.f8397b = hashMap;
    }

    public b(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.f8397b.put("message", str2);
    }
}
