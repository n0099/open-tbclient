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
    private Set<String> iO = new HashSet();
    private Element iS;

    public h(Element element) {
        String nodeName;
        String nodeName2;
        this.iS = element;
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = attributes.item(i);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.iO.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node item2 = childNodes.item(i2);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.iO.add(nodeName);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> cg() {
        return this.iO;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x001e */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, java.util.ArrayList] */
    public Object getObject(String str) {
        String nodeName;
        Object attribute = this.iS.getAttribute(str);
        if (TextUtils.isEmpty(attribute)) {
            NodeList childNodes = this.iS.getChildNodes();
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
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.a.b.a.e.c cVar = new com.baidu.adp.lib.a.b.a.e.c(type);
            com.baidu.adp.lib.a.b.a.d.h m = com.baidu.adp.lib.a.b.a.e.g.m(object);
            if (m != null) {
                return m.g(cVar);
            }
            return object;
        }
        return object;
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void j(String str, Object obj) {
        if (obj != null && str != null) {
            if (obj instanceof Boolean) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Byte) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Character) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Short) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Integer) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Long) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Float) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof String) {
                this.iS.setAttribute(str, String.valueOf(obj));
            } else if (!obj.getClass().isArray() && !com.baidu.adp.lib.a.a.a.e(obj.getClass(), List.class) && !com.baidu.adp.lib.a.a.a.e(obj.getClass(), Queue.class) && !com.baidu.adp.lib.a.a.a.e(obj.getClass(), Set.class) && !com.baidu.adp.lib.a.a.a.e(obj.getClass(), Map.class)) {
                com.baidu.adp.lib.a.a.a.e(obj.getClass(), SparseArray.class);
            }
        }
    }
}
