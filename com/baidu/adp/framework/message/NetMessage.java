package com.baidu.adp.framework.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.HttpVersion;
/* loaded from: classes4.dex */
public abstract class NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HTTP_DATA_KEY = "data";
    public static final String HTTP_HEADER_KEY = "x_bd_data_type";
    public static a mGlobalSwitchToHttpStrategy;
    public transient /* synthetic */ FieldHolder $fh;
    public long clientLogID;
    public int httpCmd;
    public HttpMessage mHttpMessage;
    public NetType mNetType;
    public SocketMessage mSocketMessage;
    public a mSwitchToHttpStrategy;
    public int socketCmd;
    public long socketCostTime;
    public int socketErrNo;
    public BdUniqueId tag;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class NetType {
        public static final /* synthetic */ NetType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetType AUTO;
        public static final NetType HTTP;
        public static final NetType SOCKET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-521644395, "Lcom/baidu/adp/framework/message/NetMessage$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-521644395, "Lcom/baidu/adp/framework/message/NetMessage$NetType;");
                    return;
                }
            }
            SOCKET = new NetType("SOCKET", 0);
            HTTP = new NetType(HttpVersion.HTTP, 1);
            NetType netType = new NetType("AUTO", 2);
            AUTO = netType;
            $VALUES = new NetType[]{SOCKET, HTTP, netType};
        }

        public NetType(String str, int i2) {
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

        public static NetType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetType) Enum.valueOf(NetType.class, str) : (NetType) invokeL.objValue;
        }

        public static NetType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetType[]) $VALUES.clone() : (NetType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage);
    }

    public NetMessage(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHttpMessage = null;
        this.mSocketMessage = null;
        this.mNetType = NetType.AUTO;
        this.socketErrNo = 0;
        this.socketCostTime = 0L;
        init(i2, i3, null);
    }

    private void init(int i2, int i3, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, this, i2, i3, bdUniqueId) == null) {
            this.httpCmd = i2;
            this.socketCmd = i3;
            this.tag = bdUniqueId;
            this.clientLogID = BdStatisticsManager.getInstance().getClientLogId();
        }
    }

    public static void setGlobalSwitchToHttpStrategy(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, aVar) == null) || aVar == null) {
            return;
        }
        mGlobalSwitchToHttpStrategy = aVar;
    }

    public abstract Object encode(boolean z);

    public byte[] encodeExtraDataInBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public final HttpMessage getHttpMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mHttpMessage == null) {
                HttpMessage httpMessage = new HttpMessage(this.httpCmd, this.tag);
                this.mHttpMessage = httpMessage;
                httpMessage.setExtra(this);
                this.mHttpMessage.setSelf(this);
                this.mHttpMessage.setClientLogID(this.clientLogID);
                this.mHttpMessage.addParam("data", encode(true));
                this.mHttpMessage.addHeader(HTTP_HEADER_KEY, "protobuf");
            }
            return this.mHttpMessage;
        }
        return (HttpMessage) invokeV.objValue;
    }

    public long getLogID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.clientLogID : invokeV.longValue;
    }

    public NetType getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mNetType : (NetType) invokeV.objValue;
    }

    public long getSocketCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.socketCostTime : invokeV.longValue;
    }

    public int getSocketErrNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.socketErrNo : invokeV.intValue;
    }

    public final SocketMessage getSocketMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mSocketMessage == null) {
                SocketMessage socketMessage = new SocketMessage(this.socketCmd, this.tag);
                this.mSocketMessage = socketMessage;
                socketMessage.setData(encode(false));
                this.mSocketMessage.setExtra(this);
                this.mSocketMessage.setSelf(this);
                this.mSocketMessage.setExtraData(encodeExtraDataInBackGround());
                this.mSocketMessage.setClientLogID(this.clientLogID);
            }
            return this.mSocketMessage;
        }
        return (SocketMessage) invokeV.objValue;
    }

    public a getSwitchToHttpStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a aVar = this.mSwitchToHttpStrategy;
            return aVar == null ? mGlobalSwitchToHttpStrategy : aVar;
        }
        return (a) invokeV.objValue;
    }

    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.tag : (BdUniqueId) invokeV.objValue;
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mHttpMessage = null;
            this.mSocketMessage = null;
        }
    }

    public void setLogID(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.clientLogID = j2;
        }
    }

    public void setNetType(NetType netType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, netType) == null) {
            this.mNetType = netType;
        }
    }

    public void setSocketCostTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.socketCostTime = j2;
        }
    }

    public void setSocketErrNo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.socketErrNo = i2;
        }
    }

    public void setSwitchToHttpStrategy(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        this.mSwitchToHttpStrategy = aVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.tag = bdUniqueId;
        }
    }

    public NetMessage(int i2, int i3, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHttpMessage = null;
        this.mSocketMessage = null;
        this.mNetType = NetType.AUTO;
        this.socketErrNo = 0;
        this.socketCostTime = 0L;
        init(i2, i3, bdUniqueId);
    }
}
