package c.a.p0.r0.c;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Service f13780a;

    /* renamed from: b  reason: collision with root package name */
    public static ContentProvider f13781b;

    /* renamed from: c  reason: collision with root package name */
    public static BroadcastReceiver f13782c;

    /* renamed from: d  reason: collision with root package name */
    public static BroadcastReceiver f13783d;
    public transient /* synthetic */ FieldHolder $fh;

    public static BroadcastReceiver a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f13783d : (BroadcastReceiver) invokeV.objValue;
    }

    public static ContentProvider b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f13781b : (ContentProvider) invokeV.objValue;
    }

    public static BroadcastReceiver c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f13782c : (BroadcastReceiver) invokeV.objValue;
    }

    public static Service d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f13780a : (Service) invokeV.objValue;
    }
}
