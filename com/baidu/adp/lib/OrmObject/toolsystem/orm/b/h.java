package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

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
    private Set<String> agl = new HashSet();
    private Element agp;

    public h(Element element) {
        String nodeName;
        String nodeName2;
        this.agp = element;
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = attributes.item(i);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.agl.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node item2 = childNodes.item(i2);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.agl.add(nodeName);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> lJ() {
        return this.agl;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0036 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, java.util.ArrayList] */
    public Object getObject(String str) {
        String nodeName;
        Object attribute = this.agp.getAttribute(str);
        if (TextUtils.isEmpty(attribute)) {
            NodeList childNodes = this.agp.getChildNodes();
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

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object object = getObject(str);
        if (object != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h aq = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.aq(object);
            if (aq != null) {
                return aq.g(cVar);
            }
            return object;
        }
        return object;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        if (obj != null && str != null) {
            if (obj instanceof Boolean) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Byte) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Character) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Short) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Integer) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Long) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Float) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof String) {
                this.agp.setAttribute(str, String.valueOf(obj));
            } else {
                if (obj.getClass().isArray() || com.baidu.adp.lib.OrmObject.a.a.d(obj.getClass(), List.class) || com.baidu.adp.lib.OrmObject.a.a.d(obj.getClass(), Queue.class) || com.baidu.adp.lib.OrmObject.a.a.d(obj.getClass(), Set.class) || com.baidu.adp.lib.OrmObject.a.a.d(obj.getClass(), Map.class) || com.baidu.adp.lib.OrmObject.a.a.d(obj.getClass(), SparseArray.class)) {
                }
            }
        }
    }
}
