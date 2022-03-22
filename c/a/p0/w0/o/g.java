package c.a.p0.w0.o;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public int f19599b;

    /* renamed from: c  reason: collision with root package name */
    public c f19600c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<d> a;

        public /* synthetic */ b(g gVar, AbsListView absListView, int i, a aVar) {
            this(gVar, absListView, i);
        }

        public final int b(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (bVar == null) {
                    return 0;
                }
                for (d dVar : this.a) {
                    for (d dVar2 : bVar.a) {
                        if (dVar.a == dVar2.a) {
                            return dVar.f19601b - dVar2.f19601b;
                        }
                    }
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public b(g gVar, AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, absListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = absListView.getChildAt(i4);
                if (childAt != null) {
                    this.a.add(new d(gVar, childAt, i + i4, null));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(AbsListView absListView, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f19601b;

        public /* synthetic */ d(g gVar, View view, int i, a aVar) {
            this(gVar, view, i);
        }

        public d(g gVar, View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, view, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f19601b = view.getTop();
            view.getBottom();
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19599b = 0;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f19600c = cVar;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i, i2, i3) == null) || absListView == null || i < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i4 = this.f19599b;
            if (i4 != 0 && (cVar = this.f19600c) != null) {
                cVar.a(absListView, 0, -i4);
            }
            this.f19599b = 0;
            this.a = null;
            return;
        }
        b bVar = new b(this, absListView, i, null);
        b bVar2 = this.a;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.a = bVar;
            int i5 = this.f19599b + b2;
            this.f19599b = i5;
            c cVar2 = this.f19600c;
            if (cVar2 != null) {
                cVar2.a(absListView, i5, b2);
                return;
            }
            return;
        }
        this.a = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f19599b = paddingTop;
        c cVar3 = this.f19600c;
        if (cVar3 != null) {
            cVar3.a(absListView, paddingTop, 0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i) == null) || i == 0) {
        }
    }
}
