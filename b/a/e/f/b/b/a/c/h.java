package b.a.e.f.b.b.a.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
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
public class h implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Element f1642a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f1643b;

    public h(Element element) {
        String nodeName;
        String nodeName2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {element};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1642a = element;
        this.f1643b = new HashSet();
        if (element != null) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i4 = 0; i4 < length; i4++) {
                Node item = attributes.item(i4);
                if (item != null && (nodeName2 = item.getNodeName()) != null) {
                    this.f1643b.add(nodeName2);
                }
            }
            NodeList childNodes = element.getChildNodes();
            int length2 = childNodes.getLength();
            for (int i5 = 0; i5 < length2; i5++) {
                Node item2 = childNodes.item(i5);
                if (item2 != null && (nodeName = item2.getNodeName()) != null) {
                    this.f1643b.add(nodeName);
                }
            }
        }
    }

    @Override // b.a.e.f.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1643b : (Set) invokeV.objValue;
    }

    @Override // b.a.e.f.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) || obj == null || str == null) {
            return;
        }
        if (obj instanceof Boolean) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Byte) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Character) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Short) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Long) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Float) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj instanceof String) {
            this.f1642a.setAttribute(str, String.valueOf(obj));
        } else if (obj.getClass().isArray() || b.a.e.f.b.a.a.e(obj.getClass(), List.class) || b.a.e.f.b.a.a.e(obj.getClass(), Queue.class) || b.a.e.f.b.a.a.e(obj.getClass(), Set.class) || b.a.e.f.b.a.a.e(obj.getClass(), Map.class)) {
        } else {
            b.a.e.f.b.a.a.e(obj.getClass(), SparseArray.class);
        }
    }

    @Override // b.a.e.f.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                b.a.e.f.b.b.a.e.c cVar = new b.a.e.f.b.b.a.e.c(type);
                b.a.e.f.b.b.a.d.h a2 = b.a.e.f.b.b.a.e.g.a(d2);
                return a2 != null ? a2.a(cVar) : d2;
            }
            return d2;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        String nodeName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String attribute = this.f1642a.getAttribute(str);
            if (TextUtils.isEmpty(attribute)) {
                NodeList childNodes = this.f1642a.getChildNodes();
                int length = childNodes.getLength();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    Node item = childNodes.item(i2);
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
}
