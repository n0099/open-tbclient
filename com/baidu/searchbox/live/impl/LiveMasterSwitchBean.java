package com.baidu.searchbox.live.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0014\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003R\u0019\u0010\u000b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/impl/LiveMasterSwitchBean;", "Lcom/baidu/searchbox/live/impl/Data;", "component1", "()Lcom/baidu/searchbox/live/impl/Data;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "data", "errmsg", "errno", "copy", "(Lcom/baidu/searchbox/live/impl/Data;Ljava/lang/String;I)Lcom/baidu/searchbox/live/impl/LiveMasterSwitchBean;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "Lcom/baidu/searchbox/live/impl/Data;", "getData", "Ljava/lang/String;", "getErrmsg", "I", "getErrno", "<init>", "(Lcom/baidu/searchbox/live/impl/Data;Ljava/lang/String;I)V", "lib-live-getswitch-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveMasterSwitchBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Data data;
    public final String errmsg;
    public final int errno;

    public static /* synthetic */ LiveMasterSwitchBean copy$default(LiveMasterSwitchBean liveMasterSwitchBean, Data data, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            data = liveMasterSwitchBean.data;
        }
        if ((i2 & 2) != 0) {
            str = liveMasterSwitchBean.errmsg;
        }
        if ((i2 & 4) != 0) {
            i = liveMasterSwitchBean.errno;
        }
        return liveMasterSwitchBean.copy(data, str, i);
    }

    public final Data component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (Data) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.errmsg : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.errno : invokeV.intValue;
    }

    public final LiveMasterSwitchBean copy(Data data, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, data, str, i)) == null) ? new LiveMasterSwitchBean(data, str, i) : (LiveMasterSwitchBean) invokeLLI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof LiveMasterSwitchBean) {
                    LiveMasterSwitchBean liveMasterSwitchBean = (LiveMasterSwitchBean) obj;
                    return Intrinsics.areEqual(this.data, liveMasterSwitchBean.data) && Intrinsics.areEqual(this.errmsg, liveMasterSwitchBean.errmsg) && this.errno == liveMasterSwitchBean.errno;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Data data = this.data;
            int hashCode = (data != null ? data.hashCode() : 0) * 31;
            String str = this.errmsg;
            return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.errno;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "LiveMasterSwitchBean(data=" + this.data + ", errmsg=" + this.errmsg + ", errno=" + this.errno + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public LiveMasterSwitchBean(Data data, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.data = data;
        this.errmsg = str;
        this.errno = i;
    }

    public final Data getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.data;
        }
        return (Data) invokeV.objValue;
    }

    public final String getErrmsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.errmsg;
        }
        return (String) invokeV.objValue;
    }

    public final int getErrno() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.errno;
        }
        return invokeV.intValue;
    }
}
