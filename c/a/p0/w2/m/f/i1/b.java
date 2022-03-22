package c.a.p0.w2.m.f.i1;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.p0.w2.i.r;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends LinearSmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeRecyclerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bdTypeRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                int calculateDtToFit = super.calculateDtToFit(i, i2, i3, i4, i5);
                if (calculateDtToFit == 0) {
                    return calculateDtToFit;
                }
                int[] iArr = new int[2];
                this.a.getLocationOnScreen(iArr);
                return ((calculateDtToFit - b.a) - ((iArr[1] + this.a.getHeight()) - n.i(TbadkCoreApplication.getInst().getApp()))) + c.a.d.f.p.c.b(TbadkCoreApplication.getInst().getApp());
            }
            return invokeCommon.intValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayMetrics)) == null) ? (displayMetrics == null || (i = displayMetrics.densityDpi) == 0) ? super.calculateSpeedPerPixel(displayMetrics) : 300.0f / i : invokeL.floatValue;
        }
    }

    /* renamed from: c.a.p0.w2.m.f.i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1505b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeRecyclerView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20082b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LinearSmoothScroller f20083c;

        public RunnableC1505b(BdTypeRecyclerView bdTypeRecyclerView, String str, LinearSmoothScroller linearSmoothScroller) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView, str, linearSmoothScroller};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
            this.f20082b = str;
            this.f20083c = linearSmoothScroller;
        }

        @Override // java.lang.Runnable
        public void run() {
            int b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b2 = b.b(this.a, this.f20082b)) < 0) {
                return;
            }
            this.f20083c.setTargetPosition(b2);
            RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(this.f20083c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-259890838, "Lc/a/p0/w2/m/f/i1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-259890838, "Lc/a/p0/w2/m/f/i1/b;");
                return;
            }
        }
        a = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
    }

    public static boolean a(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        List<c.a.d.o.e.n> data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView != null && (data = bdTypeRecyclerView.getData()) != null && data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    c.a.d.o.e.n nVar = data.get(i);
                    if ((nVar instanceof PostData) && nVar.getType() == PostData.w0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bdTypeRecyclerView, str)) == null) {
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
                List<c.a.d.o.e.n> data = bdTypeRecyclerView.getData();
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i = 0; i < size; i++) {
                        c.a.d.o.e.n nVar = data.get(i);
                        if ((nVar instanceof PostData) && nVar.getType() == PostData.w0 && str.equals(((PostData) nVar).G())) {
                            return i + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int c(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView == null) {
                return -1;
            }
            List<c.a.d.o.e.n> data = bdTypeRecyclerView.getData();
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    if (data.get(i) instanceof r) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int d(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView == null) {
                return -1;
            }
            List<c.a.d.o.e.n> data = bdTypeRecyclerView.getData();
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    c.a.d.o.e.n nVar = data.get(i);
                    if ((nVar instanceof r) && ((r) nVar).f19848b == r.i) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void e(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null) {
            return;
        }
        int d2 = d(bdTypeRecyclerView);
        if (d2 < 0) {
            d2 = c(bdTypeRecyclerView);
        }
        if (d2 >= 0) {
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(d2, 0);
            }
        }
    }

    public static void f(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, bdTypeRecyclerView, str) == null) || bdTypeRecyclerView == null) {
            return;
        }
        bdTypeRecyclerView.getLayoutManager().scrollToPosition(b(bdTypeRecyclerView, str));
    }

    public static void g(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, bdTypeRecyclerView, str) == null) || bdTypeRecyclerView == null || TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = new a(bdTypeRecyclerView.getContext(), bdTypeRecyclerView);
        e(bdTypeRecyclerView);
        c.a.d.f.m.e.a().post(new RunnableC1505b(bdTypeRecyclerView, str, aVar));
    }
}
