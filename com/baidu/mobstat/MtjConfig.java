package com.baidu.mobstat;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
/* loaded from: classes8.dex */
public class MtjConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDU_MTJ_PUSH_CALL = "Baidu_mtj_push_call";
    public static final String BAIDU_MTJ_PUSH_MSG = "Baidu_mtj_push_msg";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class FeedTrackStrategy {
        public static /* synthetic */ Interceptable $ic;
        public static final FeedTrackStrategy TRACK_ALL;
        public static final FeedTrackStrategy TRACK_NONE;
        public static final FeedTrackStrategy TRACK_SINGLE;
        public static final /* synthetic */ FeedTrackStrategy[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2086536387, "Lcom/baidu/mobstat/MtjConfig$FeedTrackStrategy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2086536387, "Lcom/baidu/mobstat/MtjConfig$FeedTrackStrategy;");
                    return;
                }
            }
            TRACK_ALL = new FeedTrackStrategy("TRACK_ALL", 0);
            TRACK_SINGLE = new FeedTrackStrategy("TRACK_SINGLE", 1);
            FeedTrackStrategy feedTrackStrategy = new FeedTrackStrategy("TRACK_NONE", 2);
            TRACK_NONE = feedTrackStrategy;
            a = new FeedTrackStrategy[]{TRACK_ALL, TRACK_SINGLE, feedTrackStrategy};
        }

        public FeedTrackStrategy(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FeedTrackStrategy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FeedTrackStrategy) Enum.valueOf(FeedTrackStrategy.class, str) : (FeedTrackStrategy) invokeL.objValue;
        }

        public static FeedTrackStrategy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FeedTrackStrategy[]) a.clone() : (FeedTrackStrategy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class PushPlatform {
        public static /* synthetic */ Interceptable $ic;
        public static final PushPlatform ALIYUN;
        public static final PushPlatform BAIDUYUN;
        public static final PushPlatform GETUI;
        public static final PushPlatform HUAWEI;
        public static final PushPlatform JIGUANG;
        public static final PushPlatform MEIZU;
        public static final PushPlatform OPPO;
        public static final PushPlatform UMENG;
        public static final PushPlatform XIAOMI;
        public static final PushPlatform XINGE;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ PushPlatform[] f36921c;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f36922b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2047865286, "Lcom/baidu/mobstat/MtjConfig$PushPlatform;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2047865286, "Lcom/baidu/mobstat/MtjConfig$PushPlatform;");
                    return;
                }
            }
            BAIDUYUN = new PushPlatform("BAIDUYUN", 0, "baiduyun", 0);
            JIGUANG = new PushPlatform("JIGUANG", 1, "jiguang", 1);
            GETUI = new PushPlatform("GETUI", 2, "getui", 2);
            HUAWEI = new PushPlatform("HUAWEI", 3, RomUtils.MANUFACTURER_HUAWEI, 3);
            XIAOMI = new PushPlatform("XIAOMI", 4, RomUtils.MANUFACTURER_XIAOMI, 4);
            UMENG = new PushPlatform("UMENG", 5, BaseConstants.CATEGORY_UMENG, 5);
            XINGE = new PushPlatform("XINGE", 6, "xinge", 6);
            ALIYUN = new PushPlatform("ALIYUN", 7, "aliyun", 7);
            OPPO = new PushPlatform("OPPO", 8, RomUtils.MANUFACTURER_OPPO, 8);
            PushPlatform pushPlatform = new PushPlatform("MEIZU", 9, "meizu", 9);
            MEIZU = pushPlatform;
            f36921c = new PushPlatform[]{BAIDUYUN, JIGUANG, GETUI, HUAWEI, XIAOMI, UMENG, XINGE, ALIYUN, OPPO, pushPlatform};
        }

        public PushPlatform(String str, int i2, String str2, int i3) {
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
            this.a = str2;
            this.f36922b = i3;
        }

        public static PushPlatform valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PushPlatform) Enum.valueOf(PushPlatform.class, str) : (PushPlatform) invokeL.objValue;
        }

        public static PushPlatform[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PushPlatform[]) f36921c.clone() : (PushPlatform[]) invokeV.objValue;
        }

        public String showName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "p" + this.f36922b;
            }
            return (String) invokeV.objValue;
        }
    }

    public MtjConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
