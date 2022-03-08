package c.a.r0.u2.k.f.c1;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.r0.u2.h.q;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
                int calculateDtToFit = super.calculateDtToFit(i2, i3, i4, i5, i6);
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
            int i2;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayMetrics)) == null) ? (displayMetrics == null || (i2 = displayMetrics.densityDpi) == 0) ? super.calculateSpeedPerPixel(displayMetrics) : 300.0f / i2 : invokeL.floatValue;
        }
    }

    /* renamed from: c.a.r0.u2.k.f.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1450b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdTypeRecyclerView f23360e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f23361f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LinearSmoothScroller f23362g;

        public RunnableC1450b(BdTypeRecyclerView bdTypeRecyclerView, String str, LinearSmoothScroller linearSmoothScroller) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView, str, linearSmoothScroller};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23360e = bdTypeRecyclerView;
            this.f23361f = str;
            this.f23362g = linearSmoothScroller;
        }

        @Override // java.lang.Runnable
        public void run() {
            int b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b2 = b.b(this.f23360e, this.f23361f)) < 0) {
                return;
            }
            this.f23362g.setTargetPosition(b2);
            RecyclerView.LayoutManager layoutManager = this.f23360e.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(this.f23362g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1811447846, "Lc/a/r0/u2/k/f/c1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1811447846, "Lc/a/r0/u2/k/f/c1/b;");
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
                for (int i2 = 0; i2 < data.size(); i2++) {
                    c.a.d.o.e.n nVar = data.get(i2);
                    if ((nVar instanceof PostData) && nVar.getType() == PostData.A0) {
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
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.d.o.e.n nVar = data.get(i2);
                        if ((nVar instanceof PostData) && nVar.getType() == PostData.A0 && str.equals(((PostData) nVar).G())) {
                            return i2 + headerViewsCount;
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
                for (int i2 = 0; i2 < size; i2++) {
                    if (data.get(i2) instanceof q) {
                        return i2 + headerViewsCount;
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
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.d.o.e.n nVar = data.get(i2);
                    if ((nVar instanceof q) && ((q) nVar).f23129f == q.m) {
                        return i2 + headerViewsCount;
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
        c.a.d.f.m.e.a().post(new RunnableC1450b(bdTypeRecyclerView, str, aVar));
    }
}
