package com.baidu.tbadk.abtest.helper;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.LiveEnterForumABTest;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.a2b;
import com.baidu.tieba.br6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ok5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper;", "", "()V", "KEY_LIVE_ENTER_FORUM_TEST", "", "testHited", "Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper$LiveEnterForumTest;", "forbidInsertLiveModel", "", "getLiveEnterForumHitTestByName", "testName", "getLiveEnterForumHitTestName", "getLiveEnterForumTest", "isLiveEnterForumTestA", "isLiveEnterForumTestB", "isLiveEnterForumTestCompare", "resetLiveEnterForumTest", "", "writeTest", "LiveEnterForumTest", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LiveEnterForumTestHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final LiveEnterForumTestHelper INSTANCE;
    public static final String KEY_LIVE_ENTER_FORUM_TEST = "LIVE_ENTER_FORUM_TEST";
    public static LiveEnterForumTest testHited;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper$LiveEnterForumTest;", "", "(Ljava/lang/String;I)V", HlsPlaylistParser.METHOD_NONE, "TEST_COMPARE", "TEST_A", "TEST_B", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class LiveEnterForumTest {
        public static final /* synthetic */ LiveEnterForumTest[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LiveEnterForumTest NONE;
        public static final LiveEnterForumTest TEST_A;
        public static final LiveEnterForumTest TEST_B;
        public static final LiveEnterForumTest TEST_COMPARE;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ LiveEnterForumTest[] $values() {
            return new LiveEnterForumTest[]{NONE, TEST_COMPARE, TEST_A, TEST_B};
        }

        public static LiveEnterForumTest valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LiveEnterForumTest) Enum.valueOf(LiveEnterForumTest.class, str) : (LiveEnterForumTest) invokeL.objValue;
        }

        public static LiveEnterForumTest[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LiveEnterForumTest[]) $VALUES.clone() : (LiveEnterForumTest[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1692619821, "Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper$LiveEnterForumTest;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1692619821, "Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper$LiveEnterForumTest;");
                    return;
                }
            }
            NONE = new LiveEnterForumTest(HlsPlaylistParser.METHOD_NONE, 0);
            TEST_COMPARE = new LiveEnterForumTest("TEST_COMPARE", 1);
            TEST_A = new LiveEnterForumTest("TEST_A", 2);
            TEST_B = new LiveEnterForumTest("TEST_B", 3);
            $VALUES = $values();
        }

        public LiveEnterForumTest(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1839035422, "Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1839035422, "Lcom/baidu/tbadk/abtest/helper/LiveEnterForumTestHelper;");
                return;
            }
        }
        INSTANCE = new LiveEnterForumTestHelper();
        testHited = LiveEnterForumTest.NONE;
    }

    public LiveEnterForumTestHelper() {
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

    @JvmStatic
    public static final boolean forbidInsertLiveModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!a2b.j.a().a() && isLiveEnterForumTestA()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean isLiveEnterForumTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (INSTANCE.getLiveEnterForumTest() == LiveEnterForumTest.TEST_A) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean isLiveEnterForumTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (INSTANCE.getLiveEnterForumTest() == LiveEnterForumTest.TEST_B) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean isLiveEnterForumTestCompare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (INSTANCE.getLiveEnterForumTest() == LiveEnterForumTest.TEST_COMPARE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final void resetLiveEnterForumTest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            testHited = LiveEnterForumTest.NONE;
        }
    }

    private final LiveEnterForumTest getLiveEnterForumHitTestByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            switch (str.hashCode()) {
                case -585120117:
                    if (str.equals(LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID)) {
                        return LiveEnterForumTest.TEST_COMPARE;
                    }
                    break;
                case 340286381:
                    if (str.equals(LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID_A)) {
                        return LiveEnterForumTest.TEST_A;
                    }
                    break;
                case 340286382:
                    if (str.equals(LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID_B)) {
                        return LiveEnterForumTest.TEST_B;
                    }
                    break;
            }
            if (!TbadkApplication.getInst().isDebugMode()) {
                DefaultLog.getInstance().e("LiveSecondFloorTestHelper", "实验组映射失败,需增加新实验组");
                return LiveEnterForumTest.TEST_COMPARE;
            }
            throw new IllegalArgumentException("实验组映射失败,需增加新实验组");
        }
        return (LiveEnterForumTest) invokeL.objValue;
    }

    private final String getLiveEnterForumHitTestName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (UbsABTestHelper.isLiveEnterForumTestA()) {
                br6.b().c(new ok5());
                return LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID_A;
            } else if (UbsABTestHelper.isLiveEnterForumTestB()) {
                return LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID_B;
            } else {
                if (UbsABTestHelper.isLiveEnterForumTestCompare()) {
                    return LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID;
                }
                if (!TbadkApplication.getInst().isDebugMode()) {
                    DefaultLog.getInstance().e("LiveSecondFloorTestHelper", "获取直播命中实验失败,serve未下发");
                    return LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID;
                }
                throw new IllegalArgumentException("获取直播命中实验失败,serve未下发");
            }
        }
        return (String) invokeV.objValue;
    }

    private final LiveEnterForumTest getLiveEnterForumTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (testHited == LiveEnterForumTest.NONE) {
                String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount(KEY_LIVE_ENTER_FORUM_TEST), LiveEnterForumABTest.LIVE_ENTER_FORUM_SECOND_FLOOR_SID);
                Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…R_FORUM_SECOND_FLOOR_SID)");
                testHited = getLiveEnterForumHitTestByName(string);
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i(LiveEnterForumTestHelperKt.LIVE_ENTER_FORUM_TEST_LOG_TAGE, "读取本地直播二楼、进吧二楼实验开关" + testHited);
            return testHited;
        }
        return (LiveEnterForumTest) invokeV.objValue;
    }

    @JvmStatic
    public static final void writeTest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            String liveEnterForumHitTestName = INSTANCE.getLiveEnterForumHitTestName();
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount(KEY_LIVE_ENTER_FORUM_TEST), liveEnterForumHitTestName);
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i(LiveEnterForumTestHelperKt.LIVE_ENTER_FORUM_TEST_LOG_TAGE, "写入直播二楼、进吧二楼实验开关" + liveEnterForumHitTestName);
        }
    }
}
