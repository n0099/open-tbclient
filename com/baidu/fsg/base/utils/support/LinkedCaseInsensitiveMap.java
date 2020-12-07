package com.baidu.fsg.base.utils.support;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes16.dex */
public class LinkedCaseInsensitiveMap<V> extends LinkedHashMap<String, V> {
    private static final long serialVersionUID = 1;
    private final Map<String, String> caseInsensitiveKeys;
    private final Locale locale;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((String) obj, (String) obj2);
    }

    public LinkedCaseInsensitiveMap() {
        this((Locale) null);
    }

    public LinkedCaseInsensitiveMap(Locale locale) {
        this.caseInsensitiveKeys = new HashMap();
        this.locale = locale == null ? Locale.getDefault() : locale;
    }

    public LinkedCaseInsensitiveMap(int i) {
        this(i, null);
    }

    public LinkedCaseInsensitiveMap(int i, Locale locale) {
        super(i);
        this.caseInsensitiveKeys = new HashMap(i);
        this.locale = locale == null ? Locale.getDefault() : locale;
    }

    public V put(String str, V v) {
        this.caseInsensitiveKeys.put(convertKey(str), str);
        return (V) super.put((LinkedCaseInsensitiveMap<V>) str, (String) v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends String, ? extends V> map) {
        if (!map.isEmpty()) {
            for (Map.Entry<? extends String, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), (String) entry.getValue());
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return (obj instanceof String) && this.caseInsensitiveKeys.containsKey(convertKey((String) obj));
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj instanceof String) {
            return (V) super.get(this.caseInsensitiveKeys.get(convertKey((String) obj)));
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj instanceof String) {
            return (V) super.remove(this.caseInsensitiveKeys.remove(convertKey((String) obj)));
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.caseInsensitiveKeys.clear();
        super.clear();
    }

    protected String convertKey(String str) {
        return str.toLowerCase(this.locale);
    }
}
