package com.baidu.mobads.cid.cesium.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static MessageDigest a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return (MessageDigest) MessageDigest.class.getDeclaredMethod("getInstance", String.class).invoke(null, new StringBuilder(str).reverse().toString());
            } catch (Exception unused) {
                throw new NoSuchAlgorithmException();
            }
        }
        return (MessageDigest) invokeL.objValue;
    }
}
