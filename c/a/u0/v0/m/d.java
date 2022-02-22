package c.a.u0.v0.m;

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
/* loaded from: classes9.dex */
public class d implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f24704e;

    /* renamed from: f  reason: collision with root package name */
    public int f24705f;

    /* renamed from: g  reason: collision with root package name */
    public c f24706g;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C1499d> a;

        public /* synthetic */ b(d dVar, AbsListView absListView, int i2, a aVar) {
            this(dVar, absListView, i2);
        }

        public final int b(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (bVar == null) {
                    return 0;
                }
                for (C1499d c1499d : this.a) {
                    for (C1499d c1499d2 : bVar.a) {
                        if (c1499d.a == c1499d2.a) {
                            return c1499d.f24707b - c1499d2.f24707b;
                        }
                    }
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public b(d dVar, AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, absListView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = absListView.getChildAt(i5);
                if (childAt != null) {
                    this.a.add(new C1499d(dVar, childAt, i2 + i5, null));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(AbsListView absListView, int i2, int i3);
    }

    /* renamed from: c.a.u0.v0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1499d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f24707b;

        public /* synthetic */ C1499d(d dVar, View view, int i2, a aVar) {
            this(dVar, view, i2);
        }

        public C1499d(d dVar, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f24707b = view.getTop();
            view.getBottom();
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24705f = 0;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f24706g = cVar;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        View childAt;
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2, i3, i4) == null) || absListView == null || i2 < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i2 == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i5 = this.f24705f;
            if (i5 != 0 && (cVar = this.f24706g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f24705f = 0;
            this.f24704e = null;
            return;
        }
        b bVar = new b(this, absListView, i2, null);
        b bVar2 = this.f24704e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f24704e = bVar;
            int i6 = this.f24705f + b2;
            this.f24705f = i6;
            c cVar2 = this.f24706g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f24704e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f24705f = paddingTop;
        c cVar3 = this.f24706g;
        if (cVar3 != null) {
            cVar3.a(absListView, paddingTop, 0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i2) == null) || i2 == 0) {
        }
    }
}
