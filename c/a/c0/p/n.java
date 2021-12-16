package c.a.c0.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1810b;

    /* renamed from: c  reason: collision with root package name */
    public String f1811c;

    /* renamed from: d  reason: collision with root package name */
    public String f1812d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1813e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1814f;

    /* renamed from: g  reason: collision with root package name */
    public String f1815g;

    /* renamed from: h  reason: collision with root package name */
    public String f1816h;

    /* renamed from: i  reason: collision with root package name */
    public final String f1817i;

    /* renamed from: j  reason: collision with root package name */
    public String f1818j;

    /* renamed from: k  reason: collision with root package name */
    public String f1819k;
    public String l;
    public c m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = this.m;
            return cVar != null && cVar.f1788d;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a() || !TextUtils.isEmpty(this.f1811c) : invokeV.booleanValue;
    }
}
