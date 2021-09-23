package c.a.r0.n0.m;

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
    public b f22845e;

    /* renamed from: f  reason: collision with root package name */
    public int f22846f;

    /* renamed from: g  reason: collision with root package name */
    public c f22847g;

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
        public List<C1066d> f22848a;

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
                for (C1066d c1066d : this.f22848a) {
                    for (C1066d c1066d2 : bVar.f22848a) {
                        if (c1066d.f22849a == c1066d2.f22849a) {
                            return c1066d.f22850b - c1066d2.f22850b;
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
            this.f22848a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = absListView.getChildAt(i5);
                if (childAt != null) {
                    this.f22848a.add(new C1066d(dVar, childAt, i2 + i5, null));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(AbsListView absListView, int i2, int i3);
    }

    /* renamed from: c.a.r0.n0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1066d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f22849a;

        /* renamed from: b  reason: collision with root package name */
        public int f22850b;

        public /* synthetic */ C1066d(d dVar, View view, int i2, a aVar) {
            this(dVar, view, i2);
        }

        public C1066d(d dVar, View view, int i2) {
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
            this.f22849a = i2;
            this.f22850b = view.getTop();
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
        this.f22846f = 0;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f22847g = cVar;
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
            int i5 = this.f22846f;
            if (i5 != 0 && (cVar = this.f22847g) != null) {
                cVar.a(absListView, 0, -i5);
            }
            this.f22846f = 0;
            this.f22845e = null;
            return;
        }
        b bVar = new b(this, absListView, i2, null);
        b bVar2 = this.f22845e;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.f22845e = bVar;
            int i6 = this.f22846f + b2;
            this.f22846f = i6;
            c cVar2 = this.f22847g;
            if (cVar2 != null) {
                cVar2.a(absListView, i6, b2);
                return;
            }
            return;
        }
        this.f22845e = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.f22846f = paddingTop;
        c cVar3 = this.f22847g;
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
