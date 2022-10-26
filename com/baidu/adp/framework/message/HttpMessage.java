package com.baidu.adp.framework.message;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpMessage extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_COOKIE = "Cookie";
    public transient /* synthetic */ FieldHolder $fh;
    public Comparator mComparator;
    public HashMap mHeaders;
    public boolean mNeedProgress;
    public HashMap mParams;
    public String mUserAgent;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public final class SORT {
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
            SORT sort = new SORT(HlsPlaylistParser.METHOD_NONE, 2);
            NONE = sort;
            $VALUES = new SORT[]{ASCEND, DESCEND, sort};
        }

        public SORT(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SORT) Enum.valueOf(SORT.class, str);
            }
            return (SORT) invokeL.objValue;
        }

        public static SORT[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SORT[]) $VALUES.clone();
            }
            return (SORT[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SORT a;

        public a(SORT sort) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sort};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.a = sort;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry entry, Map.Entry entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                if (this.a == SORT.ASCEND) {
                    return ((String) entry.getKey()).compareTo((String) entry2.getKey());
                }
                return ((String) entry2.getKey()).compareTo((String) entry.getKey());
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private String map2KVString(String str, Map map) {
        InterceptResult invokeLL;
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, map)) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    String str2 = StringUtil.NULL_STRING;
                    if (key == null) {
                        obj = StringUtil.NULL_STRING;
                    } else {
                        obj = key.toString();
                    }
                    sb.append(obj);
                    sb.append('=');
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

    private Map parseKVString(String str, String str2) {
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
            } catch (Exception e) {
                BdLog.detailException((Throwable) e, true);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private void initial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mParams = new HashMap();
            this.mHeaders = new HashMap();
            setSort(SORT.ASCEND);
        }
    }

    public HashMap getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mHeaders;
        }
        return (HashMap) invokeV.objValue;
    }

    public HashMap getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mParams;
        }
        return (HashMap) invokeV.objValue;
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mUserAgent;
        }
        return (String) invokeV.objValue;
    }

    public void removeAllParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mParams.clear();
        }
    }

    public String addCookie(String str, String str2) {
        InterceptResult invokeLL;
        Map parseKVString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.mHeaders.containsKey("Cookie") && (parseKVString = parseKVString((String) this.mHeaders.get("Cookie"), ParamableElem.DIVIDE_PARAM)) != null) {
                    if (parseKVString.containsKey(str)) {
                        str3 = (String) parseKVString.get(str);
                    }
                    parseKVString.put(str, str2);
                    addHeader("Cookie", map2KVString(ParamableElem.DIVIDE_PARAM, parseKVString));
                    return str3;
                }
                addHeader("Cookie", str + '=' + str2 + WebvttCueParser.CHAR_SEMI_COLON);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public String addHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            return (String) this.mHeaders.put(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public Object addParam(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            if (str == null) {
                return null;
            }
            return this.mParams.put(str, String.valueOf(i));
        }
        return invokeLI.objValue;
    }

    public Object addParam(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
            if (str == null) {
                return null;
            }
            return this.mParams.put(str, String.valueOf(j));
        }
        return invokeLJ.objValue;
    }

    public Object addParam(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, obj)) == null) {
            if (str != null && obj != null) {
                return this.mParams.put(str, obj);
            }
            return null;
        }
        return invokeLL.objValue;
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
    public boolean checkCmd(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return FrameHelper.b(i);
        }
        return invokeI.booleanValue;
    }

    public String removeHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return (String) this.mHeaders.remove(str);
        }
        return (String) invokeL.objValue;
    }

    public Object removeParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return this.mParams.remove(str);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.adp.framework.message.Message
    public void setClientLogID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            super.setClientLogID(j);
        }
    }

    public synchronized void setSort(SORT sort) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sort) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mUserAgent = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.Message
    public synchronized List encodeInBackGround() {
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
}
