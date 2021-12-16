package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
@NotProguard
/* loaded from: classes10.dex */
public class NetRequestParam implements IHeaderMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte DATA_TYPE_JSON = 1;
    public static final byte DATA_TYPE_STRING = 0;
    public static final byte METHOD_CONNECT = 7;
    public static final byte METHOD_DELETE = 5;
    public static final byte METHOD_GET = 1;
    public static final byte METHOD_HEAD = 2;
    public static final byte METHOD_OPTIONS = 0;
    public static final byte METHOD_POST = 3;
    public static final byte METHOD_PUT = 4;
    public static final byte METHOD_TRACE = 6;
    public static final byte METHOD_UNKNOWN = 8;
    public static final byte RESPONSE_TYPE_ARRAY_BUFFER = 1;
    public static final byte RESPONSE_TYPE_TEXT = 0;
    public static final String TAG = "NetRequestParam";
    public transient /* synthetic */ FieldHolder $fh;
    public Object mData;
    public byte mDataType;
    public boolean mDirty;
    public HeaderMap mHeaderMap;
    public JsObject mJsObject;
    public byte mMethod;
    public long mNativePtr;
    public NetRequestCallback mNetRequestCallback;
    public Observer mNetRequestObserver;
    public byte mResponseType;
    public String mUrl;

    /* renamed from: com.baidu.searchbox.v8engine.net.NetRequestParam$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetRequestParam mNetRequestParam;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNetRequestParam = new NetRequestParam(0L, (AnonymousClass1) null);
        }

        public NetRequestParam build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mNetRequestParam : (NetRequestParam) invokeV.objValue;
        }

        public Builder setData(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mNetRequestParam.mData = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDataType(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2)) == null) {
                this.mNetRequestParam.mDataType = b2;
                return this;
            }
            return (Builder) invokeB.objValue;
        }

        public Builder setHeaderMap(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.mNetRequestParam.mHeaderMap.addHeader(entry.getKey(), entry.getValue());
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMethod(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(1048580, this, b2)) == null) {
                this.mNetRequestParam.mMethod = b2;
                return this;
            }
            return (Builder) invokeB.objValue;
        }

        public Builder setNetRequestCallback(NetRequestCallback netRequestCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, netRequestCallback)) == null) {
                this.mNetRequestParam.mNetRequestCallback = netRequestCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setResponseType(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(1048582, this, b2)) == null) {
                this.mNetRequestParam.mResponseType = b2;
                return this;
            }
            return (Builder) invokeB.objValue;
        }

        public Builder setUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.mNetRequestParam.mUrl = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class HeaderMap implements IHeaderMap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> mMap;
        public long mNativePtr;

        public HeaderMap(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNativePtr = 0L;
            this.mMap = new HashMap();
            this.mNativePtr = j2;
        }

        private native void nativeAddHeader(long j2, String str, String str2);

        private native String nativeGetHeaderValue(long j2, String str);

        private native String[] nativeGetTransformedHeaderMap(long j2);

        private native boolean nativeHasHeader(long j2, String str);

        private native void nativeRemoveHeader(long j2, String str);

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public void addHeader(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.mMap.put(str, str2);
                long j2 = this.mNativePtr;
                if (j2 != 0) {
                    nativeAddHeader(j2, str, str2);
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public String getHeaderValue(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                String str2 = this.mMap.get(str);
                if (str2 != null) {
                    return str2;
                }
                long j2 = this.mNativePtr;
                if (j2 != 0) {
                    return nativeGetHeaderValue(j2, str);
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public Map<String, String> getTransformedHeaderMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? NetRequestParam.stringPairToMap(nativeGetTransformedHeaderMap(this.mNativePtr)) : (Map) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public boolean hasHeader(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (this.mMap.get(str) != null) {
                    return true;
                }
                long j2 = this.mNativePtr;
                if (j2 != 0) {
                    return nativeHasHeader(j2, str);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public void removeHeader(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mMap.remove(str);
                long j2 = this.mNativePtr;
                if (j2 != 0) {
                    nativeRemoveHeader(j2, str);
                }
            }
        }
    }

    public /* synthetic */ NetRequestParam(long j2, AnonymousClass1 anonymousClass1) {
        this(j2);
    }

    public static String buildUrlWithJsonStringQuery(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) ? a.a(str, str2) : (String) invokeLL.objValue;
    }

    public static String buildUrlWithStringArrayQuery(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, strArr)) == null) ? a.a(str, strArr) : (String) invokeLL.objValue;
    }

    private void clearDirty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mDirty = false;
        }
    }

    public static String encodeQuery(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? a.d(str) : (String) invokeL.objValue;
    }

    private Map<String, String> getJavaHeaderMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.mHeaderMap.mMap : (Map) invokeV.objValue;
    }

    private String[] getJavaHeaderMapStringPairs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.mHeaderMap.mMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    arrayList.add(str);
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeV.objValue;
    }

    private boolean isDirty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.mDirty : invokeV.booleanValue;
    }

    private native Object nativeGetData(long j2);

    private native void nativeSetData(long j2, String str);

    private native void nativeSetDataType(long j2, byte b2);

    private native void nativeSetMethod(long j2, byte b2);

    private native void nativeSetResponseType(long j2, byte b2);

    private native void nativeSetUrl(long j2, String str);

    private void setDirty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, this, z) == null) {
            this.mDirty = z;
        }
    }

    public static Map<String, String> stringPairToMap(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, strArr)) == null) {
            if (strArr == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                int i3 = i2 + 1;
                if (i3 < strArr.length) {
                    hashMap.put(strArr[i2], strArr[i3]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String transformJSONStringToQueryString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) ? a.c(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.mDirty = true;
            this.mHeaderMap.addHeader(str, str2);
        }
    }

    public Object getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.mData;
            if (obj != null) {
                return obj;
            }
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                this.mData = nativeGetData(j2);
            }
            return this.mData;
        }
        return invokeV.objValue;
    }

    public byte getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDataType : invokeV.byteValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public String getHeaderValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mHeaderMap.getHeaderValue(str) : (String) invokeL.objValue;
    }

    public JsObject getJsObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mJsObject : (JsObject) invokeV.objValue;
    }

    public byte getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMethod : invokeV.byteValue;
    }

    public NetRequestCallback getNetRequestCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNetRequestCallback : (NetRequestCallback) invokeV.objValue;
    }

    public byte getResponseType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mResponseType : invokeV.byteValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public Map<String, String> getTransformedHeaderMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mHeaderMap.getTransformedHeaderMap() : (Map) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public boolean hasHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.mHeaderMap.hasHeader(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public void removeHeader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mDirty = true;
            this.mHeaderMap.removeHeader(str);
        }
    }

    public NetRequestParam setData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.mDirty = true;
            this.mData = str;
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                nativeSetData(j2, str);
            }
            return this;
        }
        return (NetRequestParam) invokeL.objValue;
    }

    public NetRequestParam setDataType(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048589, this, b2)) == null) {
            this.mDirty = true;
            this.mDataType = b2;
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                nativeSetDataType(j2, b2);
            }
            return this;
        }
        return (NetRequestParam) invokeB.objValue;
    }

    public void setJsObject(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            this.mJsObject = jsObject;
        }
    }

    public NetRequestParam setMethod(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048591, this, b2)) == null) {
            this.mDirty = true;
            this.mMethod = b2;
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                nativeSetMethod(j2, b2);
            }
            return this;
        }
        return (NetRequestParam) invokeB.objValue;
    }

    public void setNetRequestCallback(NetRequestCallback netRequestCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, netRequestCallback) == null) {
            this.mNetRequestCallback = netRequestCallback;
        }
    }

    public NetRequestParam setResponseType(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048593, this, b2)) == null) {
            this.mDirty = true;
            this.mResponseType = b2;
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                nativeSetResponseType(j2, b2);
            }
            return this;
        }
        return (NetRequestParam) invokeB.objValue;
    }

    public NetRequestParam setUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.mDirty = true;
            this.mUrl = str;
            long j2 = this.mNativePtr;
            if (j2 != 0) {
                nativeSetUrl(j2, str);
            }
            return this;
        }
        return (NetRequestParam) invokeL.objValue;
    }

    public NetRequestParam(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNativePtr = j2;
        this.mHeaderMap = new HeaderMap(j2);
    }

    public static String encodeQuery(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, strArr)) == null) ? a.a(strArr) : (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NetRequestParam(long j2, JsObject jsObject) {
        this(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJsObject = jsObject;
    }
}
