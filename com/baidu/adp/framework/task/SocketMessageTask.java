package com.baidu.adp.framework.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes.dex */
public class SocketMessageTask extends MessageTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRIORITY_SUPER_HIGH = -3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCanRetry;
    public DupLicateMode mDupLicateMode;
    public boolean mNeedAck;
    public boolean mNeedCompress;
    public Class<? extends SocketResponsedMessage> mResponsedClass;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class DupLicateMode {
        public static final /* synthetic */ DupLicateMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DupLicateMode NONE;
        public static final DupLicateMode REMOVE_ALL;
        public static final DupLicateMode REMOVE_ME;
        public static final DupLicateMode REMOVE_WAITING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(172233953, "Lcom/baidu/adp/framework/task/SocketMessageTask$DupLicateMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(172233953, "Lcom/baidu/adp/framework/task/SocketMessageTask$DupLicateMode;");
                    return;
                }
            }
            NONE = new DupLicateMode(HlsPlaylistParser.METHOD_NONE, 0);
            REMOVE_ME = new DupLicateMode("REMOVE_ME", 1);
            REMOVE_WAITING = new DupLicateMode("REMOVE_WAITING", 2);
            DupLicateMode dupLicateMode = new DupLicateMode("REMOVE_ALL", 3);
            REMOVE_ALL = dupLicateMode;
            $VALUES = new DupLicateMode[]{NONE, REMOVE_ME, REMOVE_WAITING, dupLicateMode};
        }

        public DupLicateMode(String str, int i) {
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

        public static DupLicateMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (DupLicateMode) Enum.valueOf(DupLicateMode.class, str);
            }
            return (DupLicateMode) invokeL.objValue;
        }

        public static DupLicateMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (DupLicateMode[]) $VALUES.clone();
            }
            return (DupLicateMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketMessageTask(int i) {
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
        this.mNeedAck = false;
        this.mNeedCompress = false;
        this.mCanRetry = true;
        this.mDupLicateMode = DupLicateMode.NONE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return FrameHelper.c(this.mCmd);
        }
        return invokeV.booleanValue;
    }

    public DupLicateMode getDupLicateMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDupLicateMode;
        }
        return (DupLicateMode) invokeV.objValue;
    }

    public boolean getNeedAck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mNeedAck;
        }
        return invokeV.booleanValue;
    }

    public boolean getNeedCompress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mNeedCompress;
        }
        return invokeV.booleanValue;
    }

    public Class<? extends SocketResponsedMessage> getResponsedClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mResponsedClass;
        }
        return (Class) invokeV.objValue;
    }

    public boolean isCanRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCanRetry;
        }
        return invokeV.booleanValue;
    }

    public void setCanRetry(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mCanRetry = z;
        }
    }

    public void setDupLicateMode(DupLicateMode dupLicateMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dupLicateMode) == null) {
            this.mDupLicateMode = dupLicateMode;
        }
    }

    public void setNeedAck(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mNeedAck = z;
        }
    }

    public void setNeedCompress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mNeedCompress = z;
        }
    }

    public void setResponsedClass(Class<? extends SocketResponsedMessage> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cls) == null) {
            this.mResponsedClass = cls;
        }
    }
}
