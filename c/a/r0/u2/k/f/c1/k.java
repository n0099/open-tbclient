package c.a.r0.u2.k.f.c1;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.u2.h.q;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
public class k {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23417b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdTypeListView f23418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f23419f;

        public a(BdTypeListView bdTypeListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23418e = bdTypeListView;
            this.f23419f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a = k.a(this.f23418e, this.f23419f)) < 0) {
                return;
            }
            int height = this.f23418e.getHeight();
            int width = this.f23418e.getWidth();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            BdTypeListView bdTypeListView = this.f23418e;
            View childAt = bdTypeListView.getChildAt(a - bdTypeListView.getFirstVisiblePosition());
            if ((childAt == null || childAt.getBottom() > height - k.f23417b) && (view = this.f23418e.getAdapter2().getView(a, null, this.f23418e)) != null) {
                view.measure(makeMeasureSpec2, makeMeasureSpec);
                this.f23418e.setSelectionFromTop(a, (height - view.getMeasuredHeight()) - k.f23417b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1811448125, "Lc/a/r0/u2/k/f/c1/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1811448125, "Lc/a/r0/u2/k/f/c1/k;");
                return;
            }
        }
        a = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds240);
        f23417b = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
    }

    public static int a(BdTypeListView bdTypeListView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bdTypeListView, str)) == null) {
            if (bdTypeListView != null && !TextUtils.isEmpty(str)) {
                List<c.a.d.o.e.n> data = bdTypeListView.getData();
                int headerViewsCount = bdTypeListView.getHeaderViewsCount();
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

    public static int b(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<c.a.d.o.e.n> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
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

    public static int c(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<c.a.d.o.e.n> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.d.o.e.n nVar = data.get(i2);
                    if ((nVar instanceof PostData) && nVar.getType() == PostData.A0) {
                        return i2 + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int d(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<c.a.d.o.e.n> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
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

    public static void e(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        int d2 = d(bdTypeListView);
        if (d2 < 0) {
            d2 = b(bdTypeListView);
        }
        if (d2 >= 0) {
            bdTypeListView.setSelectionFromTop(d2, a);
        }
    }

    public static void f(BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, bdTypeListView, str) == null) || bdTypeListView == null || TextUtils.isEmpty(str) || bdTypeListView.getAdapter2() == null) {
            return;
        }
        e(bdTypeListView);
        bdTypeListView.post(new a(bdTypeListView, str));
    }

    public static void g(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.setSelectionFromTop(0, 0);
    }
}
