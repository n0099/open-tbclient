package com.baidu.tbadk.core.pagestay;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.pageStayDuration.IPageStayDuration;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tbadk/core/pagestay/PageStayDurationProxy;", "Lcom/baidu/tbadk/pageStayDuration/IPageStayDuration;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getCurrentPageKey", "", "getCurrentPageSourceKeyList", "", "getNextPageSourceKeyList", "getPageStayDurationItem", "Lcom/baidu/tbadk/pageStayDuration/PageStayDurationItem;", "getPageStayFilter", "Lcom/baidu/tbadk/pageStayDuration/PageStayDurationFilter;", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PageStayDurationProxy implements IPageStayDuration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String KEY_S_TIME_PAGE_COUNT = "12.51_s_time_page_count_a";
    public static List<String> currentPageKeyList;
    public static int sTimeABTest;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity activity;

    public /* synthetic */ PageStayDurationProxy(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    @JvmStatic
    public static final boolean isPageCountSTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Companion.a() : invokeV.booleanValue;
    }

    @JvmStatic
    public static final IPageStayDuration pageStayDuration(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) ? Companion.b(activity) : (IPageStayDuration) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final boolean a() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (PageStayDurationProxy.sTimeABTest == 0) {
                    if (UbsABTestHelper.isExistSid(PageStayDurationProxy.KEY_S_TIME_PAGE_COUNT)) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    PageStayDurationProxy.sTimeABTest = i;
                }
                if (PageStayDurationProxy.sTimeABTest == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @JvmStatic
        public final IPageStayDuration b(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (activity instanceof IPageStayDuration) {
                    a aVar = PageStayDurationProxy.Companion;
                    IPageStayDuration iPageStayDuration = (IPageStayDuration) activity;
                    List<String> nextPageSourceKeyList = iPageStayDuration.getNextPageSourceKeyList();
                    if (nextPageSourceKeyList == null) {
                        nextPageSourceKeyList = new ArrayList<>();
                    }
                    PageStayDurationProxy.currentPageKeyList = nextPageSourceKeyList;
                    return iPageStayDuration;
                }
                PageStayDurationProxy pageStayDurationProxy = new PageStayDurationProxy(activity, null);
                a aVar2 = PageStayDurationProxy.Companion;
                PageStayDurationProxy.currentPageKeyList = pageStayDurationProxy.getNextPageSourceKeyList();
                return pageStayDurationProxy;
            }
            return (IPageStayDuration) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-214034653, "Lcom/baidu/tbadk/core/pagestay/PageStayDurationProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-214034653, "Lcom/baidu/tbadk/core/pagestay/PageStayDurationProxy;");
                return;
            }
        }
        Companion = new a(null);
        currentPageKeyList = new ArrayList();
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String simpleName = this.activity.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
            return simpleName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return currentPageKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String currentPageKey = getCurrentPageKey();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getCurrentPageSourceKeyList());
            arrayList.add(currentPageKey);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PageStayDurationItem pageStayDurationItem = new PageStayDurationItem();
            pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public PageStayDurationProxy(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.activity = activity;
    }
}
