package com.baidu.adp.lib.a.b.a.c;

import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* loaded from: classes.dex */
public class h implements c {
    private Set<String> sm = new HashSet();
    private Element ss;

    public h(Element element) {
        String nodeName;
        String nodeName2;
        this.ss = element;
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = attributes.item(i);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.sm.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node item2 = childNodes.item(i2);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.sm.add(nodeName);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fR() {
        return this.sm;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x001e */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, java.util.ArrayList] */
    public Object getObject(String str) {
        String nodeName;
        Object attribute = this.ss.getAttribute(str);
        if (TextUtils.isEmpty(attribute)) {
            NodeList childNodes = this.ss.getChildNodes();
            int length = childNodes.getLength();
            attribute = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item != null && (nodeName = item.getNodeName()) != null && nodeName.equals(str)) {
                    attribute.add(item);
                }
            }
        }
        return attribute;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h j = com.baidu.adp.lib.a.b.a.e.g.j(object);
            if (j != null) {
                return j.g(cVar);
            }
            return object;
        }
        return object;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        if (obj != null && str != null) {
            if (obj instanceof Boolean) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Byte) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Character) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Short) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Integer) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Long) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Float) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof String) {
                this.ss.setAttribute(str, String.valueOf(obj));
            } else if (!obj.getClass().isArray() && !com.baidu.adp.lib.a.a.a.a(obj.getClass(), List.class) && !com.baidu.adp.lib.a.a.a.a(obj.getClass(), Queue.class) && !com.baidu.adp.lib.a.a.a.a(obj.getClass(), Set.class) && !com.baidu.adp.lib.a.a.a.a(obj.getClass(), Map.class)) {
                com.baidu.adp.lib.a.a.a.a(obj.getClass(), SparseArray.class);
            }
        }
    }
}
