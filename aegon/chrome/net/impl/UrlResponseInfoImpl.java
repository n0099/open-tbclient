package aegon.chrome.net.impl;

import aegon.chrome.net.UrlResponseInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfoImpl extends UrlResponseInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HeaderBlockImpl mHeaders;
    public final int mHttpStatusCode;
    public final String mHttpStatusText;
    public final String mNegotiatedProtocol;
    public final String mProxyServer;
    public final AtomicLong mReceivedByteCount;
    public final List<String> mResponseInfoUrlChain;
    public final boolean mWasCached;

    /* loaded from: classes.dex */
    public static final class HeaderBlockImpl extends UrlResponseInfo.HeaderBlock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Map.Entry<String, String>> mAllHeadersList;

        public HeaderBlockImpl(List<Map.Entry<String, String>> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAllHeadersList = list;
        }
    }

    public UrlResponseInfoImpl(List<String> list, int i2, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2), str, list2, Boolean.valueOf(z), str2, str3, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResponseInfoUrlChain = Collections.unmodifiableList(list);
        this.mHttpStatusCode = i2;
        this.mHttpStatusText = str;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(list2));
        this.mWasCached = z;
        this.mNegotiatedProtocol = str2;
        this.mProxyServer = str3;
        this.mReceivedByteCount = new AtomicLong(j);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Locale locale = Locale.ROOT;
            List<String> list = this.mResponseInfoUrlChain;
            return String.format(locale, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", Integer.toHexString(System.identityHashCode(this)), list.get(list.size() - 1), this.mResponseInfoUrlChain.toString(), Integer.valueOf(this.mHttpStatusCode), this.mHttpStatusText, this.mHeaders.mAllHeadersList.toString(), Boolean.valueOf(this.mWasCached), this.mNegotiatedProtocol, this.mProxyServer, Long.valueOf(this.mReceivedByteCount.get()));
        }
        return (String) invokeV.objValue;
    }
}
