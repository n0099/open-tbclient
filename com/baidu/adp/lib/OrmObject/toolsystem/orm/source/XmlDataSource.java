package com.baidu.adp.lib.OrmObject.toolsystem.orm.source;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.le;
import com.baidu.tieba.nd;
import com.baidu.tieba.pe;
import com.baidu.tieba.sc;
import com.baidu.tieba.vd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class XmlDataSource implements nd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Element element;
    public Set<String> keySet;

    public XmlDataSource(Element element) {
        String nodeName;
        String nodeName2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {element};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.element = element;
        this.keySet = new HashSet();
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i3 = 0; i3 < length; i3++) {
                Node item = attributes.item(i3);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.keySet.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i4 = 0; i4 < length2; i4++) {
                Node item2 = childNodes.item(i4);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.keySet.add(nodeName);
                }
            }
        }
    }

    @Override // com.baidu.tieba.nd
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.keySet;
        }
        return (Set) invokeV.objValue;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        String nodeName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String attribute = this.element.getAttribute(str);
            if (TextUtils.isEmpty(attribute)) {
                NodeList childNodes = this.element.getChildNodes();
                int length = childNodes.getLength();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    Node item = childNodes.item(i);
                    if (item != null && (nodeName = item.getNodeName()) != null && nodeName.equals(str)) {
                        arrayList.add(item);
                    }
                }
                return arrayList;
            }
            return attribute;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.nd
    public Object getObjectByType(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object object = getObject(str);
            if (object != null) {
                le leVar = new le(type);
                vd a = pe.a(object);
                if (a != null) {
                    return a.a(leVar);
                }
                return object;
            }
            return object;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.nd
    public void set(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) && obj != null && str != null) {
            if (obj instanceof Boolean) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Byte) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Character) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Short) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Integer) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Long) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Float) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (obj instanceof String) {
                this.element.setAttribute(str, String.valueOf(obj));
            } else if (!obj.getClass().isArray() && !sc.e(obj.getClass(), List.class) && !sc.e(obj.getClass(), Queue.class) && !sc.e(obj.getClass(), Set.class) && !sc.e(obj.getClass(), Map.class)) {
                sc.e(obj.getClass(), SparseArray.class);
            }
        }
    }
}
