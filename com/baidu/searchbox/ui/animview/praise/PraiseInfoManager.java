package com.baidu.searchbox.ui.animview.praise;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PraiseInfoManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static int LRU_MAX_COUNT = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, PraiseInfo> mPraiseInfoMap;

    /* renamed from: com.baidu.searchbox.ui.animview.praise.PraiseInfoManager$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final PraiseInfoManager sINSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1466054227, "Lcom/baidu/searchbox/ui/animview/praise/PraiseInfoManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1466054227, "Lcom/baidu/searchbox/ui/animview/praise/PraiseInfoManager$Holder;");
                    return;
                }
            }
            sINSTANCE = new PraiseInfoManager(null);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class PraiseInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mCounts;
        public int mOffsetY;

        public PraiseInfo(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCounts = j;
            this.mOffsetY = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-329911757, "Lcom/baidu/searchbox/ui/animview/praise/PraiseInfoManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-329911757, "Lcom/baidu/searchbox/ui/animview/praise/PraiseInfoManager;");
        }
    }

    public /* synthetic */ PraiseInfoManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final PraiseInfoManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Holder.sINSTANCE : (PraiseInfoManager) invokeV.objValue;
    }

    public static String makePraiseInfoKey(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            return str + "_" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public int getOffsetY(String str) {
        InterceptResult invokeL;
        PraiseInfo praiseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            LruCache<String, PraiseInfo> lruCache = this.mPraiseInfoMap;
            if (lruCache == null || lruCache.size() <= 0 || TextUtils.isEmpty(str) || (praiseInfo = this.mPraiseInfoMap.get(str)) == null) {
                return -1;
            }
            return praiseInfo.mOffsetY;
        }
        return invokeL.intValue;
    }

    public long getPraiseCounts(String str) {
        InterceptResult invokeL;
        PraiseInfo praiseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            LruCache<String, PraiseInfo> lruCache = this.mPraiseInfoMap;
            if (lruCache == null || lruCache.size() <= 0 || TextUtils.isEmpty(str) || (praiseInfo = this.mPraiseInfoMap.get(str)) == null) {
                return -1L;
            }
            return praiseInfo.mCounts;
        }
        return invokeL.longValue;
    }

    public void updateOffsetY(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) || this.mPraiseInfoMap == null || TextUtils.isEmpty(str)) {
            return;
        }
        PraiseInfo praiseInfo = this.mPraiseInfoMap.get(str);
        if (praiseInfo != null) {
            praiseInfo.mOffsetY = i2;
        } else {
            this.mPraiseInfoMap.put(str, new PraiseInfo(0L, i2));
        }
    }

    public void updatePraiseCounts(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) || this.mPraiseInfoMap == null || TextUtils.isEmpty(str)) {
            return;
        }
        PraiseInfo praiseInfo = this.mPraiseInfoMap.get(str);
        if (praiseInfo != null) {
            praiseInfo.mCounts = j;
        } else {
            this.mPraiseInfoMap.put(str, new PraiseInfo(j, 0));
        }
    }

    public PraiseInfoManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPraiseInfoMap = new LruCache<>(LRU_MAX_COUNT);
    }
}
