package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "src", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "dst", "", "deviceFlag", "", "copyFixedInfo", "(Lcom/baidu/searchbox/common/security/DeviceIdBagMap;Lcom/baidu/searchbox/common/security/CacheDeviceInfo;I)V", "", "source", "crcSign", "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "iteratorFun", "forEachDevice", "(Lkotlin/Function1;)V", "cacheDeviceInfo", "newDeviceValue", "", "isDeviceInfoSyncMapping", "(Lcom/baidu/searchbox/common/security/CacheDeviceInfo;ILjava/lang/String;)Z", "infoMap", "", "validInfoList", "Lorg/json/JSONObject;", "toJson", "(Lcom/baidu/searchbox/common/security/DeviceIdBagMap;ILjava/util/List;)Lorg/json/JSONObject;", "Landroid/util/SparseArray;", "SyncJsonKeyMap", "Landroid/util/SparseArray;", "getSyncJsonKeyMap", "()Landroid/util/SparseArray;", "lib-security-framework_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoUtilKt {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<String> SyncJsonKeyMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-261007993, "Lcom/baidu/searchbox/common/security/DeviceInfoUtilKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-261007993, "Lcom/baidu/searchbox/common/security/DeviceInfoUtilKt;");
                return;
            }
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1, "g");
        sparseArray.put(2, "h");
        sparseArray.put(4, "c");
        sparseArray.put(8, "d");
        sparseArray.put(16, "a");
        sparseArray.put(32, "b");
        sparseArray.put(64, "i");
        sparseArray.put(128, "k");
        sparseArray.put(256, "l");
        SyncJsonKeyMap = sparseArray;
    }

    public static final void copyFixedInfo(DeviceIdBagMap src, CacheDeviceInfo dst, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, src, dst, i) == null) {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dst, "dst");
            forEachDevice(new DeviceInfoUtilKt$copyFixedInfo$1(i, dst, src));
        }
    }

    public static final boolean isDeviceInfoSyncMapping(CacheDeviceInfo cacheDeviceInfo, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, cacheDeviceInfo, i, str)) == null) {
            if (cacheDeviceInfo != null && !TextUtils.isEmpty(str)) {
                return cacheDeviceInfo.isDeviceInfoSyncMapping(i, str);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static final JSONObject toJson(DeviceIdBagMap infoMap, int i, List<Integer> validInfoList) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, infoMap, i, validInfoList)) == null) {
            Intrinsics.checkNotNullParameter(infoMap, "infoMap");
            Intrinsics.checkNotNullParameter(validInfoList, "validInfoList");
            JSONObject jSONObject = new JSONObject();
            forEachDevice(new DeviceInfoUtilKt$toJson$1(i, infoMap, validInfoList, jSONObject));
            return jSONObject;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public static final String crcSign(String source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, source)) == null) {
            Intrinsics.checkNotNullParameter(source, "source");
            CRC32 crc32 = new CRC32();
            byte[] bytes = source.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            crc32.update(bytes);
            return String.valueOf(crc32.getValue());
        }
        return (String) invokeL.objValue;
    }

    public static final void forEachDevice(Function1<? super Integer, Unit> iteratorFun) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iteratorFun) == null) {
            Intrinsics.checkNotNullParameter(iteratorFun, "iteratorFun");
            for (int i = 0; i < 9; i++) {
                iteratorFun.invoke(Integer.valueOf(1 << i));
            }
        }
    }

    public static final SparseArray<String> getSyncJsonKeyMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return SyncJsonKeyMap;
        }
        return (SparseArray) invokeV.objValue;
    }
}
