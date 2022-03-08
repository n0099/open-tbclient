package c.a.q0.a1.c.q;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.s;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f11989b;

    /* renamed from: c  reason: collision with root package name */
    public String f11990c;

    /* renamed from: d  reason: collision with root package name */
    public String f11991d;

    /* renamed from: e  reason: collision with root package name */
    public int f11992e;

    /* renamed from: f  reason: collision with root package name */
    public int f11993f;

    /* renamed from: g  reason: collision with root package name */
    public int f11994g;

    /* renamed from: h  reason: collision with root package name */
    public int f11995h;

    /* renamed from: i  reason: collision with root package name */
    public String f11996i;

    public a(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 2;
        this.f11989b = "index";
        this.f11990c = "index";
        this.f11991d = "2001";
        this.f11992e = 1;
        this.f11993f = 1;
        this.f11994g = 1;
        this.f11995h = 3;
        this.f11996i = "personalize_page";
        if (sVar == null || sVar.getListView() == null) {
            return;
        }
        String a = TbPageExtraHelper.findPageExtraByView(sVar.getListView()).a();
        this.a = c(a);
        this.f11989b = e(a);
        this.f11990c = d(a);
        this.f11991d = i(a);
        this.f11992e = a(a);
        this.f11993f = b(a);
        this.f11994g = f(a);
        this.f11995h = g(a);
        this.f11996i = h(a);
        c.a.q0.a1.h.a.b("currentPageKey=" + a);
        c.a.q0.a1.h.a.b(toString());
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("a072".equals(str)) {
                return 10;
            }
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str)) {
                return 2;
            }
            if ("a005".equals(str)) {
                return 4;
            }
            if ("a007".equals(str)) {
                return 12;
            }
            if ("a038".equals(str)) {
                return 9;
            }
            if ("a066".equals(str)) {
                return 15;
            }
            if ("a067".equals(str)) {
                return 21;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 1;
            }
            if ("a011".equals(str)) {
                return 3;
            }
            if ("a068".equals(str)) {
                return 22;
            }
            return "a008".equals(str) ? 13 : 1;
        }
        return invokeL.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if ("a072".equals(str)) {
                return 10;
            }
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str)) {
                return 2;
            }
            if ("a005".equals(str)) {
                return 7;
            }
            if ("a007".equals(str)) {
                return 9;
            }
            if ("a038".equals(str)) {
                return 4;
            }
            if ("a066".equals(str)) {
                return 11;
            }
            if ("a067".equals(str)) {
                return 18;
            }
            if (!"a001".equals(str) && !"a002".equals(str)) {
                if ("a010".equals(str) || "a014".equals(str)) {
                    return 5;
                }
                if ("a011".equals(str)) {
                    return 3;
                }
                if ("a068".equals(str)) {
                    return 19;
                }
                if ("a008".equals(str)) {
                    return 10;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return 3;
            }
            if ("a005".equals(str)) {
                return 20;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 2;
            }
            if ("a038".equals(str)) {
                return 1;
            }
            if ("a066".equals(str)) {
                return 18;
            }
            if ("a067".equals(str)) {
                return 19;
            }
            if ("a011".equals(str)) {
                return 4;
            }
            return ("a068".equals(str) || "a023".equals(str) || !"a024".equals(str)) ? 2 : 17;
        }
        return invokeL.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) ? "frs" : "a005".equals(str) ? "pb" : ("a007".equals(str) || "a001".equals(str) || "a002".equals(str)) ? "index" : "a038".equals(str) ? "concern_tab" : "a066".equals(str) ? ImageViewerConfig.FROM_GAME_VIDEO : "a067".equals(str) ? "video_tab" : "a011".equals(str) ? "profile" : "a068".equals(str) ? "14" : "a023".equals(str) ? "auto_midpage" : "index" : (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return "frs";
            }
            if ("a005".equals(str)) {
                return "pb";
            }
            if ("a038".equals(str)) {
                return ImageViewerConfig.FROM_CONCERN;
            }
            if ("a066".equals(str)) {
                return ImageViewerConfig.FROM_GAME_VIDEO;
            }
            if ("a067".equals(str)) {
                return "video_tab";
            }
            if ("a001".equals(str)) {
                return "index";
            }
            "a002".equals(str);
            return "index";
        }
        return (String) invokeL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return 2;
            }
            if ("a005".equals(str)) {
                return 4;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 1;
            }
            if ("a038".equals(str)) {
                return 9;
            }
            if ("a066".equals(str)) {
                return 12;
            }
            if ("a067".equals(str)) {
                return 16;
            }
            return "a011".equals(str) ? 8 : 1;
        }
        return invokeL.intValue;
    }

    public static int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return 1;
            }
            if ("a005".equals(str)) {
                return 2;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 3;
            }
            if ("a038".equals(str)) {
                return 4;
            }
            if ("a066".equals(str)) {
                return 9;
            }
            if ("a067".equals(str)) {
                return 10;
            }
            if ("a011".equals(str)) {
                return 6;
            }
            if ("a075".equals(str)) {
                return 12;
            }
            return "a076".equals(str) ? 13 : 3;
        }
        return invokeL.intValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return FrsFragment.STAR_FRS;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return "personalize_page";
            }
            if ("a011".equals(str)) {
                return "person_page";
            }
            if ("a038".equals(str)) {
                return "concern_page";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return "2003";
            }
            if ("a005".equals(str)) {
                return "2002";
            }
            if ("a023".equals(str)) {
                return "2005";
            }
            if ("a001".equals(str)) {
                return "2001";
            }
            "a002".equals(str);
            return "2001";
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "AdapterSourceItem:【pbPageFromType=" + this.a + ",imageViewerFromType=" + this.f11989b + ",videoLocationType=" + this.f11990c + ",videoStageType=" + this.f11991d + ",agreeLocate=" + this.f11992e + ",disagreeLocate=" + this.f11993f + ",pageFrom=" + this.f11994g + ",shareReportFrom=" + this.f11995h + ",stType=" + this.f11996i + "】";
        }
        return (String) invokeV.objValue;
    }
}
