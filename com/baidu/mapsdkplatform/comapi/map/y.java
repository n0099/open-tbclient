package com.baidu.mapsdkplatform.comapi.map;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            String str2 = com.baidu.mapsdkplatform.comapi.util.h.c;
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String aESSaltKey = JNITools.getAESSaltKey(str2);
            String aESViKey = JNITools.getAESViKey(str2);
            if (!TextUtils.isEmpty(aESSaltKey) && !TextUtils.isEmpty(aESViKey) && !TextUtils.isEmpty(str)) {
                try {
                    return new String(AlgorithmUtil.getDecryptInfo(aESViKey, aESSaltKey, c(str))).trim();
                } catch (Exception unused) {
                    Log.e("PrismBuildingInfo", "getBuildingGeom Decrypt failed");
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<LatLng> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String b = b(str);
            ArrayList<LatLng> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(b)) {
                for (String str2 : b.split(ParamableElem.DIVIDE_PARAM)) {
                    String[] split = str2.split(",");
                    if (split.length == 2) {
                        try {
                            arrayList.add(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private byte[] c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
