package com.baidu.crabsdk.lite.a;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            return "Total: " + com.baidu.crabsdk.lite.b.c.a(blockCount) + " Used: " + com.baidu.crabsdk.lite.b.c.a(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.lite.b.c.a(availableBlocks);
        }
        return (String) invokeV.objValue;
    }
}
