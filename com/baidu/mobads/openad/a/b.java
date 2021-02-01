package com.baidu.mobads.openad.a;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b implements IOAdEvent {

    /* renamed from: a  reason: collision with root package name */
    private final String f3416a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f3417b;
    private final int c;
    private Object d;

    public b(String str) {
        this(str, 0, new HashMap());
    }

    public b(String str, String str2) {
        this(str, 0, str2);
    }

    public b(String str, HashMap<String, Object> hashMap) {
        this(str, 0, hashMap);
    }

    public b(String str, int i, HashMap<String, Object> hashMap) {
        this.f3416a = str;
        this.c = i;
        this.f3417b = hashMap;
    }

    public b(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.f3417b.put("message", str2);
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public String getType() {
        return this.f3416a;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public int getCode() {
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    /* renamed from: a */
    public HashMap<String, Object> getData() {
        return this.f3417b;
    }

    public void a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            this.f3417b.put("instanceInfo", iXAdInstanceInfo.getUniqueId());
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public void setTarget(Object obj) {
        this.d = obj;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public Object getTarget() {
        return this.d;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public String getMessage() {
        try {
            return (String) this.f3417b.get("message");
        } catch (Exception e) {
            return "";
        }
    }
}
