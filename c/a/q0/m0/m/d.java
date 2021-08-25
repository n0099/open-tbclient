package c.a.q0.m0.m;

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
/* loaded from: classes3.dex */
public class d implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f22261e;

    /* renamed from: f  reason: collision with root package name */
    public int f22262f;

    /* renamed from: g  reason: collision with root package name */
    public c f22263g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C1035d> f22264a;

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
                for (C1035d c1035d : this.f22264a) {
                    for (C1035d c1035d2 : bVar.f22264a) {
                        if (c1035d.f22265a == c1035d2.f22265a) {
                            return c1035d.f22266b - c1035d2.f22266b;
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
            this.f22264a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = absListView.getChildAt(i5);
                if (childAt != null) {
                    this.f22264a.add(new C1035d(dVar, childAt, i2 + i5, null));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(AbsListView absListView, int i2, int i3);
    }

    /* renamed from: c.a.q0.m0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1035d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f22265a;

        /* renamed from: b  reason: collision with root package name */
        public int f22266b;

        public /* synthetic */ C1035d(d dVar, View view, int i2, a aVar) {
            this(dVar, view, i2);
        }

        public C1035d(d dVar, View view, int i2) {
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
            this.f22265a = i2;
            this.f22266b = view.getTop();
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
        this.f22262f = 0;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f22263g = cVar;
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
            int i5 = this.f22262f;
            if (i5 != 0 && (cVar = this.f22263g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f22262f = 0;
            this.f22261e = null;
            return;
        }
        b bVar = new b(this, absListView, i2, null);
        b bVar2 = this.f22261e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f22261e = bVar;
            int i6 = this.f22262f + b2;
            this.f22262f = i6;
            c cVar2 = this.f22263g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f22261e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f22262f = paddingTop;
        c cVar3 = this.f22263g;
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
