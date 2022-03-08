package c.a.r0.d1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static UserData a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15684b;

    /* renamed from: c  reason: collision with root package name */
    public static String f15685c;
    public transient /* synthetic */ FieldHolder $fh;

    public static UserData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (UserData) invokeV.objValue;
    }

    public static UserData b(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) {
            UserData userData = frsViewData != null ? frsViewData.getUserData() : null;
            a = userData;
            return userData;
        }
        return (UserData) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f15685c : (String) invokeV.objValue;
    }

    public static boolean d(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, userData)) == null) {
            if (userData == null) {
                return false;
            }
            int is_manager = userData.getIs_manager();
            return is_manager == 1 || is_manager == 2 || is_manager == 3 || is_manager == 4;
        }
        return invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            UserData a2 = a();
            return a2 != null && a2.getIs_manager() == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            UserData a2 = a();
            return a2 != null && a2.getIs_manager() == 3;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f15684b : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            UserData a2 = a();
            if (a2 != null && (forumToolAuth = a2.getForumToolAuth()) != null) {
                for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void i(c.a.l.a aVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, aVar, frsViewData) == null) || aVar == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            f15684b = frsViewData.getForum().isFrsMask();
            f15685c = frsViewData.getForum().getId();
        }
        if (frsViewData != null && (d(b(frsViewData)) || h())) {
            aVar.a(4);
        } else {
            aVar.b(4);
        }
    }

    public static void j(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, threadCommentAndPraiseInfoLayout, frsViewData) == null) || threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            f15684b = frsViewData.getForum().isFrsMask();
            f15685c = frsViewData.getForum().getId();
        }
        if (frsViewData != null && d(b(frsViewData))) {
            threadCommentAndPraiseInfoLayout.setManageVisible(true);
        } else {
            threadCommentAndPraiseInfoLayout.setManageVisible(false);
        }
    }
}
