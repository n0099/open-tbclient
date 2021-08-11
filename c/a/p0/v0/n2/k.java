package c.a.p0.v0.n2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            try {
                SharedPreferences.Editor edit = c().edit();
                edit.clear();
                edit.commit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return "pref_name_frs_sortType_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static SharedPreferences c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences(b(), 0) : (SharedPreferences) invokeV.objValue;
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        if (i2 != 6) {
                            if (i2 != 7) {
                                return i2 != 8 ? -1 : 4;
                            }
                            return 3;
                        }
                        return 2;
                    }
                    return 0;
                }
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public static int e(int i2, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, frsRequestData)) == null) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        if (i2 != 6) {
                            if (i2 != 7) {
                                if (i2 == 8 && frsRequestData != null) {
                                    frsRequestData.setSortType(4);
                                    frsRequestData.K(0);
                                }
                            } else if (frsRequestData != null) {
                                frsRequestData.setSortType(3);
                                frsRequestData.K(0);
                            }
                        } else if (frsRequestData != null) {
                            frsRequestData.setSortType(2);
                            frsRequestData.K(0);
                        }
                    } else if (frsRequestData != null) {
                        frsRequestData.setSortType(0);
                        frsRequestData.K(1);
                    }
                } else if (frsRequestData != null) {
                    frsRequestData.setSortType(1);
                    frsRequestData.K(0);
                }
            } else if (frsRequestData != null) {
                frsRequestData.setSortType(0);
                frsRequestData.K(0);
            }
            return 1;
        }
        return invokeIL.intValue;
    }

    public static int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return i2 != 4 ? -1 : 8;
                        }
                        return 7;
                    }
                    return 6;
                }
                return 3;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return 1;
                        }
                        if (i2 != 4) {
                            return -1;
                        }
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return c().getInt(str, -1);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65544, null, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = c().edit();
            edit.putInt(str, i2);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
