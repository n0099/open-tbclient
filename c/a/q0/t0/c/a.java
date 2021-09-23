package c.a.q0.t0.c;

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
    public static Service f15011a;

    /* renamed from: b  reason: collision with root package name */
    public static ContentProvider f15012b;

    /* renamed from: c  reason: collision with root package name */
    public static BroadcastReceiver f15013c;

    /* renamed from: d  reason: collision with root package name */
    public static BroadcastReceiver f15014d;
    public transient /* synthetic */ FieldHolder $fh;

    public static BroadcastReceiver a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f15014d : (BroadcastReceiver) invokeV.objValue;
    }

    public static ContentProvider b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f15012b : (ContentProvider) invokeV.objValue;
    }

    public static BroadcastReceiver c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f15013c : (BroadcastReceiver) invokeV.objValue;
    }

    public static Service d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f15011a : (Service) invokeV.objValue;
    }
}
