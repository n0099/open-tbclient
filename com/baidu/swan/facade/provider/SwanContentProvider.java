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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.facade.provider.processor.ProcessorInfo;
import com.baidu.tieba.ct3;
import com.baidu.tieba.cv3;
import com.baidu.tieba.gp1;
import com.baidu.tieba.iv3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class SwanContentProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static UriMatcher c;
    public static HashSet<String> d;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

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
        a = gp1.a;
        b = AppRuntime.getAppContext().getPackageName() + ".provider";
        c = new UriMatcher(-1);
        d = new HashSet<>();
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                c.addURI(b, processorInfo.getPath(), processorInfo.getMatcherCode());
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

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return a();
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return a();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            if (i % 100000 == i2 % 100000) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        cv3 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, uri, contentValues)) == null) {
            if (!c() || (d2 = d(c.match(uri))) == null) {
                return null;
            }
            return d2.insert(uri, contentValues);
        }
        return (Uri) invokeLL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = true;
            if (e(Process.myUid(), Binder.getCallingUid())) {
                return true;
            }
            String callingPackage = getCallingPackage();
            if (d.contains(callingPackage)) {
                return true;
            }
            String a2 = iv3.a(callingPackage);
            Set<String> a3 = ct3.e().a();
            z = (a3 == null || !a3.contains(a2)) ? false : false;
            if (z) {
                d.add(callingPackage);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final cv3 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Class<? extends cv3> processorClass = ProcessorInfo.getProcessorClass(i);
            if (processorClass != null) {
                try {
                    return processorClass.newInstance();
                } catch (IllegalAccessException | InstantiationException e) {
                    if (a) {
                        e.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return (cv3) invokeI.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        cv3 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, uri, str, strArr)) == null) {
            if (!c() || (d2 = d(c.match(uri))) == null) {
                return 0;
            }
            return d2.delete(uri, str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        cv3 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, strArr, str, strArr2, str2)) == null) {
            if (!b() || (d2 = d(c.match(uri))) == null) {
                return null;
            }
            return d2.query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        cv3 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, uri, contentValues, str, strArr)) == null) {
            if (!c() || (d2 = d(c.match(uri))) == null) {
                return 0;
            }
            return d2.update(uri, contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
