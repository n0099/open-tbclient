package com.baidu.adp.framework.message;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class HttpMessage extends Message<List<Map.Entry<String, Object>>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_COOKIE = "Cookie";
    public transient /* synthetic */ FieldHolder $fh;
    public Comparator<Map.Entry<String, Object>> mComparator;
    public HashMap<String, String> mHeaders;
    public boolean mNeedProgress;
    public HashMap<String, Object> mParams;
    public String mUserAgent;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class SORT {
        public static final /* synthetic */ SORT[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SORT ASCEND;
        public static final SORT DESCEND;
        public static final SORT NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2041402449, "Lcom/baidu/adp/framework/message/HttpMessage$SORT;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2041402449, "Lcom/baidu/adp/framework/message/HttpMessage$SORT;");
                    return;
                }
            }
            ASCEND = new SORT("ASCEND", 0);
            DESCEND = new SORT("DESCEND", 1);
            SORT sort = new SORT(PolyActivity.NONE_PANEL_TYPE, 2);
            NONE = sort;
            $VALUES = new SORT[]{ASCEND, DESCEND, sort};
        }

        public SORT(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SORT valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SORT) Enum.valueOf(SORT.class, str) : (SORT) invokeL.objValue;
        }

        public static SORT[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SORT[]) $VALUES.clone() : (SORT[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements Comparator<Map.Entry<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SORT f31153e;

        public a(SORT sort) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sort};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31153e = null;
            this.f31153e = sort;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                if (this.f31153e == SORT.ASCEND) {
                    return entry.getKey().compareTo(entry2.getKey());
                }
                return entry2.getKey().compareTo(entry.getKey());
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mNeedProgress = false;
        initial();
    }

    private byte[] getByte(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, obj)) == null) {
            try {
                Object invoke = obj.getClass().getMethod("toByteArray", new Class[0]).invoke(obj, new Object[0]);
                if (invoke == null || !(invoke instanceof byte[])) {
                    return null;
                }
                return (byte[]) invoke;
            } catch (Exception e2) {
                BdLog.detailException((Throwable) e2, true);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private void initial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mParams = new HashMap<>();
            this.mHeaders = new HashMap<>();
            setSort(SORT.ASCEND);
        }
    }

    private String map2KVString(String str, Map<?, ?> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, map)) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null && map != null) {
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    String str2 = StringUtil.NULL_STRING;
                    sb.append(key == null ? StringUtil.NULL_STRING : key.toString());
                    sb.append(com.alipay.sdk.encrypt.a.f30865h);
                    if (value != null) {
                        str2 = value.toString();
                    }
                    sb.append(str2);
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    private Map<String, String> parseKVString(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            if (str != null && str2 != null) {
                for (String str3 : str.split(str2)) {
                    int indexOf = str3.indexOf("=");
                    if (indexOf != -1) {
                        String trim = str3.substring(0, indexOf).trim();
                        String trim2 = str3.substring(indexOf + 1).trim();
                        if (!trim.isEmpty() && !trim2.isEmpty()) {
                            hashMap.put(trim.trim(), trim2.trim());
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public String addCookie(String str, String str2) {
        InterceptResult invokeLL;
        Map<String, String> parseKVString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.mHeaders.containsKey("Cookie") && (parseKVString = parseKVString(this.mHeaders.get("Cookie"), ";")) != null) {
                    String str3 = parseKVString.containsKey(str) ? parseKVString.get(str) : null;
                    parseKVString.put(str, str2);
                    addHeader("Cookie", map2KVString(";", parseKVString));
                    return str3;
                }
                addHeader("Cookie", str + com.alipay.sdk.encrypt.a.f30865h + str2 + ';');
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public String addHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? this.mHeaders.put(str, str2) : (String) invokeLL.objValue;
    }

    public byte[] addParam(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Object put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, bArr)) == null) {
            if (str == null || bArr == null || (put = this.mParams.put(str, bArr)) == null || !(put instanceof byte[])) {
                return null;
            }
            return (byte[]) put;
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? FrameHelper.b(i2) : invokeI.booleanValue;
    }

    public HashMap<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mHeaders : (HashMap) invokeV.objValue;
    }

    public HashMap<String, Object> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mParams : (HashMap) invokeV.objValue;
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mUserAgent : (String) invokeV.objValue;
    }

    public void removeAllParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mParams.clear();
        }
    }

    public String removeCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (str == null || !this.mHeaders.containsKey("Cookie")) {
                return null;
            }
            Map<String, String> parseKVString = parseKVString(this.mHeaders.get("Cookie"), ";");
            String remove = parseKVString.remove(str);
            addHeader("Cookie", map2KVString(";", parseKVString));
            return remove;
        }
        return (String) invokeL.objValue;
    }

    public String removeHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? this.mHeaders.remove(str) : (String) invokeL.objValue;
    }

    public Object removeParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? this.mParams.remove(str) : invokeL.objValue;
    }

    @Override // com.baidu.adp.framework.message.Message
    public void setClientLogID(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            super.setClientLogID(j2);
        }
    }

    public boolean setNeedProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mNeedProgress : invokeV.booleanValue;
    }

    public synchronized void setSort(SORT sort) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, sort) == null) {
            synchronized (this) {
                if (sort == SORT.NONE) {
                    this.mComparator = null;
                } else {
                    this.mComparator = new a(sort);
                }
            }
        }
    }

    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mUserAgent = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.Message
    public synchronized List<Map.Entry<String, Object>> encodeInBackGround() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mParams.entrySet());
                if (this.mComparator != null) {
                    Collections.sort(arrayList, this.mComparator);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object value = entry.getValue();
                    if (!(value instanceof String) && !(value instanceof byte[])) {
                        Object obj = getByte(value);
                        if (obj == null) {
                            obj = value.toString();
                        }
                        if (obj == null) {
                            it.remove();
                        } else {
                            entry.setValue(obj);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void setNeedProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mNeedProgress = z;
        }
    }

    public Object addParam(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, obj)) == null) {
            if (str == null || obj == null) {
                return null;
            }
            return this.mParams.put(str, obj);
        }
        return invokeLL.objValue;
    }

    public Object addParam(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            return this.mParams.put(str, String.valueOf(i2));
        }
        return invokeLI.objValue;
    }

    public Object addParam(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j2)) == null) {
            if (str == null) {
                return null;
            }
            return this.mParams.put(str, String.valueOf(j2));
        }
        return invokeLJ.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpMessage(int i2, BdUniqueId bdUniqueId) {
        super(i2, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mNeedProgress = false;
        initial();
    }

    public String addParam(String str, String str2) {
        InterceptResult invokeLL;
        Object put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (str == null || str2 == null || (put = this.mParams.put(str, str2)) == null || !(put instanceof String)) {
                return null;
            }
            return (String) put;
        }
        return (String) invokeLL.objValue;
    }
}
