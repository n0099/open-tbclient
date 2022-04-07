package com.baidu.mapsdkplatform.comjni.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class JNIMD5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native String encodeUrlParamsValue(String str);

    public static native String getSignMD5String(String str);

    public static native String getUrlNeedInfo();
}
