package com.baidu.searchbox.live.interfaces.multiplugin;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000B)\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J4\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0003¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/multiplugin/SubPluginBundleInfo;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "packageName", "minVersion", "maxVersion", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/baidu/searchbox/live/interfaces/multiplugin/SubPluginBundleInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/Integer;", "getMaxVersion", "getMinVersion", "Ljava/lang/String;", "getPackageName", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class SubPluginBundleInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Integer maxVersion;
    public final Integer minVersion;
    public final String packageName;

    public SubPluginBundleInfo(String str, Integer num, Integer num2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, num, num2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.packageName = str;
        this.minVersion = num;
        this.maxVersion = num2;
    }

    public static /* synthetic */ SubPluginBundleInfo copy$default(SubPluginBundleInfo subPluginBundleInfo, String str, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subPluginBundleInfo.packageName;
        }
        if ((i2 & 2) != 0) {
            num = subPluginBundleInfo.minVersion;
        }
        if ((i2 & 4) != 0) {
            num2 = subPluginBundleInfo.maxVersion;
        }
        return subPluginBundleInfo.copy(str, num, num2);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public final Integer component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.minVersion : (Integer) invokeV.objValue;
    }

    public final Integer component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.maxVersion : (Integer) invokeV.objValue;
    }

    public final SubPluginBundleInfo copy(String str, Integer num, Integer num2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, num, num2)) == null) ? new SubPluginBundleInfo(str, num, num2) : (SubPluginBundleInfo) invokeLLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof SubPluginBundleInfo) {
                    SubPluginBundleInfo subPluginBundleInfo = (SubPluginBundleInfo) obj;
                    return Intrinsics.areEqual(this.packageName, subPluginBundleInfo.packageName) && Intrinsics.areEqual(this.minVersion, subPluginBundleInfo.minVersion) && Intrinsics.areEqual(this.maxVersion, subPluginBundleInfo.maxVersion);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final Integer getMaxVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.maxVersion : (Integer) invokeV.objValue;
    }

    public final Integer getMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.minVersion : (Integer) invokeV.objValue;
    }

    public final String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.packageName;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.minVersion;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.maxVersion;
            return hashCode2 + (num2 != null ? num2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SubBundleInfo{ packageName=" + this.packageName + ", minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + " }";
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ SubPluginBundleInfo(String str, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? 0 : num2);
    }
}
