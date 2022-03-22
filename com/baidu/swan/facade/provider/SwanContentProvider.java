package com.baidu.swan.facade.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a;
import c.a.n0.g.j.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.facade.provider.processor.ProcessorInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class SwanContentProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTHORITY;
    public static final boolean DEBUG;
    public static final int PER_USER_RANGE = 100000;
    public static final String TAG = "SwanContentProvider";
    public static HashSet<String> sAccreditedSet;
    public static UriMatcher sUriMatcher;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ProcessorInfo[] values;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2078722267, "Lcom/baidu/swan/facade/provider/SwanContentProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2078722267, "Lcom/baidu/swan/facade/provider/SwanContentProvider;");
                return;
            }
        }
        DEBUG = a.a;
        AUTHORITY = AppRuntime.getAppContext().getPackageName() + ".provider";
        sUriMatcher = new UriMatcher(-1);
        sAccreditedSet = new HashSet<>();
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                sUriMatcher.addURI(AUTHORITY, processorInfo.getPath(), processorInfo.getMatcherCode());
            }
        }
    }

    public SwanContentProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private boolean checkPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            boolean z = true;
            if (isSameApp(Process.myUid(), Binder.getCallingUid())) {
                return true;
            }
            String callingPackage = getCallingPackage();
            if (sAccreditedSet.contains(callingPackage)) {
                return true;
            }
            String a = c.a(callingPackage);
            Set<String> a2 = c.a.n0.d.g.c.e().a();
            z = (a2 == null || !a2.contains(a)) ? false : false;
            if (z) {
                sAccreditedSet.add(callingPackage);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private boolean checkReadPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? checkPermission() : invokeV.booleanValue;
    }

    private boolean checkWritePermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? checkPermission() : invokeV.booleanValue;
    }

    private c.a.n0.g.j.a.a getProcessor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            Class<? extends c.a.n0.g.j.a.a> processorClass = ProcessorInfo.getProcessorClass(i);
            if (processorClass != null) {
                try {
                    return processorClass.newInstance();
                } catch (IllegalAccessException | InstantiationException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return (c.a.n0.g.j.a.a) invokeI.objValue;
    }

    public static boolean isSameApp(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) ? i % 100000 == i2 % 100000 : invokeII.booleanValue;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        c.a.n0.g.j.a.a processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            if (!checkWritePermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
                return 0;
            }
            return processor.delete(uri, str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        c.a.n0.g.j.a.a processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValues)) == null) {
            if (!checkWritePermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
                return null;
            }
            return processor.insert(uri, contentValues);
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        c.a.n0.g.j.a.a processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            if (!checkReadPermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
                return null;
            }
            return processor.query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        c.a.n0.g.j.a.a processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            if (!checkWritePermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
                return 0;
            }
            return processor.update(uri, contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
