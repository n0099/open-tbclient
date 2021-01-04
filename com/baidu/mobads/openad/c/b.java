package com.baidu.mobads.openad.c;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements IOAdEvent {
    public static final String COMPLETE = "complete";
    public static final String EVENT_MESSAGE = "message";

    /* renamed from: a  reason: collision with root package name */
    private final String f3448a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f3449b;
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

    public b(String str, int i) {
        this(str, i, new HashMap());
    }

    public b(String str, int i, HashMap<String, Object> hashMap) {
        this.f3448a = str;
        this.c = i;
        this.f3449b = hashMap;
    }

    public b(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.f3449b.put("message", str2);
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public String getType() {
        return this.f3448a;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public int getCode() {
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEvent
    public HashMap<String, Object> getData() {
        return this.f3449b;
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
            return (String) this.f3449b.get("message");
        } catch (Exception e) {
            return "";
        }
    }
}
