package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    public static final /* synthetic */ i[] l;
    public transient /* synthetic */ FieldHolder $fh;
    public String j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197698910, "Lcom/baidu/mobads/sdk/internal/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(197698910, "Lcom/baidu/mobads/sdk/internal/i;");
                return;
            }
        }
        a = new i("NEWS", 0, CommonToolbarStatisticConstants.TOOLBAR_MENU_NEW_DETAIL_BROWSER, 0);
        b = new i("IMAGE", 1, "image", 1);
        c = new i(HlsPlaylistParser.TYPE_VIDEO, 2, "video", 2);
        d = new i("TOPIC", 3, "topic", 3);
        e = new i("AD", 4, "ad", 4);
        f = new i("HOTDOC", 5, "hotkey", 5);
        g = new i("SMALLVIDEO", 6, "smallvideo", 6);
        h = new i("RECALLNEWS", 7, "recallNews", 8);
        i iVar = new i("POLICETASK", 8, "policetask", 9);
        i = iVar;
        l = new i[]{a, b, c, d, e, f, g, h, iVar};
    }

    public i(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = str2;
        this.k = i3;
    }

    public static i a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (i) Enum.valueOf(i.class, str);
        }
        return (i) invokeL.objValue;
    }

    public static i[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (i[]) l.clone();
        }
        return (i[]) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public static i b(String str) {
        InterceptResult invokeL;
        i[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            for (i iVar : a()) {
                if (iVar != null && TextUtils.isEmpty(iVar.j) && iVar.j.equals(str)) {
                    return iVar;
                }
            }
            return null;
        }
        return (i) invokeL.objValue;
    }
}
