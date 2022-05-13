package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dp;
import com.repackage.e9;
import com.repackage.f9;
import com.repackage.fo;
import com.repackage.go;
import com.repackage.io;
import com.repackage.jo;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.so;
import com.repackage.tk;
import com.repackage.to;
import com.repackage.vo;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView implements to<BdListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public n D;
    public Runnable E;
    public t F;
    public io a;
    public AdapterView.OnItemClickListener b;
    public AdapterView.OnItemLongClickListener c;
    public AdapterView.OnItemSelectedListener d;
    public m e;
    public l f;
    public AbsListView.OnScrollListener g;
    public o h;
    public r i;
    public long j;
    public s k;
    public int l;
    public p m;
    public q n;
    public fo o;
    public fo p;
    public View q;
    public int r;
    public e9 s;
    public Runnable t;
    public final vo u;
    public Runnable v;
    public Runnable w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public a(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdListView bdListView = this.a;
                bdListView.setSelection(bdListView.getCount() - 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public b(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.F == null) {
                return;
            }
            this.a.F.c();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public c(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null) {
                return;
            }
            int firstVisiblePosition = this.a.getFirstVisiblePosition();
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            int i = 0;
            int i2 = -1;
            if (this.a.a == null || this.a.a.getWrappedAdapter() == null || this.a.a.o() <= 0) {
                i = -1;
            } else {
                int n = firstVisiblePosition - this.a.a.n();
                i2 = n < 0 ? 0 : n;
                int n2 = lastVisiblePosition - this.a.a.n();
                if (n2 >= this.a.a.o()) {
                    n2 = this.a.a.o() - 1;
                }
                if (n2 >= 0) {
                    i = n2;
                }
            }
            this.a.h.onScrollStop(i2, i);
        }
    }

    /* loaded from: classes.dex */
    public class d implements vo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public d(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // com.repackage.vo
        public void cancelRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdListView bdListView = this.a;
                bdListView.removeCallbacks(bdListView.v);
            }
        }

        @Override // com.repackage.vo
        public so getAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getAdapter2() : (so) invokeV.objValue;
        }

        @Override // com.repackage.vo
        public int getFirstVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getFirstVisiblePosition() : invokeV.intValue;
        }

        @Override // com.repackage.vo
        public int getLastVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getLastVisiblePosition() : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public e(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof tk) {
                ((tk) view2).refresh();
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(this.a.getChildAt(i));
                }
                if (this.a.s != null) {
                    c = this.a.s;
                } else {
                    c = f9.c(this.a.getContext());
                }
                if (c != null) {
                    c.onPreLoad(this.a.u);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public f(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            e9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.s != null) {
                    c = this.a.s;
                } else {
                    c = f9.c(this.a.getContext());
                }
                if (c != null) {
                    c.onPreLoad(this.a.u);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements io.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public g(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // com.repackage.io.b
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdListView bdListView = this.a;
                bdListView.removeCallbacks(bdListView.w);
                BdListView bdListView2 = this.a;
                bdListView2.postDelayed(bdListView2.w, 100L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public h(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int n = this.a.a.n();
                if (i < n) {
                    if (this.a.o == null || view2 != this.a.o.b()) {
                        if (this.a.e != null) {
                            this.a.e.onClick(view2);
                            return;
                        }
                        return;
                    }
                    this.a.o.c();
                    return;
                }
                int i2 = i - n;
                ListAdapter wrappedAdapter = this.a.a.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
                    if (this.a.p == null || view2 != this.a.p.b()) {
                        if (this.a.f != null) {
                            this.a.f.onClick(view2);
                            return;
                        }
                        return;
                    }
                    this.a.p.c();
                } else if (this.a.b != null) {
                    this.a.b.onItemClick(adapterView, view2, i2, j);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public i(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                this.a.r = i;
                if (this.a.g != null) {
                    this.a.g.onScroll(absListView, i, i2, i3);
                }
                if (this.a.h == null || this.a.j <= 0) {
                    return;
                }
                this.a.getHandler().removeCallbacks(this.a.t);
                this.a.getHandler().postDelayed(this.a.t, this.a.j);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            e9 c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (this.a.s != null) {
                    c = this.a.s;
                } else {
                    c = f9.c(this.a.getContext());
                }
                if (c != null) {
                    if (i == 2) {
                        BdListView bdListView = this.a;
                        bdListView.removeCallbacks(bdListView.v);
                        c.setIsScroll(true);
                    } else if (c.isScroll()) {
                        c.setIsScroll(false);
                        BdListView bdListView2 = this.a;
                        bdListView2.removeCallbacks(bdListView2.v);
                        BdListView bdListView3 = this.a;
                        bdListView3.postDelayed(bdListView3.v, 100L);
                    } else if (i == 0) {
                        BdListView bdListView4 = this.a;
                        bdListView4.removeCallbacks(bdListView4.w);
                        BdListView bdListView5 = this.a;
                        bdListView5.postDelayed(bdListView5.w, 100L);
                    }
                }
                if (this.a.g != null) {
                    this.a.g.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (this.a.m != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        this.a.m.onScrollToBottom();
                    }
                    if (this.a.n != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        this.a.n.m(this.a);
                    }
                    if (this.a.k == null || absListView.getFirstVisiblePosition() > this.a.l) {
                        return;
                    }
                    this.a.k.onScrollToTop();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public j(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                int n = this.a.a.n();
                if (i < n) {
                    return true;
                }
                int i2 = i - n;
                ListAdapter wrappedAdapter = this.a.a.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
                    return true;
                }
                if (this.a.c != null) {
                    return this.a.c.onItemLongClick(adapterView, view2, i2, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class k implements AdapterView.OnItemSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdListView a;

        public k(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
            int n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < (n = this.a.a.n())) {
                return;
            }
            int i2 = i - n;
            ListAdapter wrappedAdapter = this.a.a.getWrappedAdapter();
            if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount() || this.a.d == null) {
                return;
            }
            this.a.d.onItemSelected(adapterView, view2, i2, j);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) || this.a.d == null) {
                return;
            }
            this.a.d.onNothingSelected(adapterView);
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        void onClick(View view2);
    }

    /* loaded from: classes.dex */
    public interface m {
        void onClick(View view2);
    }

    /* loaded from: classes.dex */
    public interface n {
        void a(int i);
    }

    /* loaded from: classes.dex */
    public interface o {
        void onScrollStop(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface p {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface q {
        void m(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface r {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes.dex */
    public interface s {
        void onScrollToTop();
    }

    /* loaded from: classes.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic = null;
        public static float k = 3.0f;
        public transient /* synthetic */ FieldHolder $fh;
        public go a;
        public boolean b;
        public int c;
        public int d;
        public BdListView e;
        public Boolean f;
        public r g;
        public int h;
        public int i;
        public int j;

        /* loaded from: classes.dex */
        public class a implements dp {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // com.repackage.dp
            public void onOver() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.d();
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(481176789, "Lcom/baidu/adp/widget/ListView/BdListView$t;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(481176789, "Lcom/baidu/adp/widget/ListView/BdListView$t;");
            }
        }

        public t(BdListView bdListView, go goVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView, goVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = false;
            this.c = 0;
            this.d = 3;
            this.e = null;
            this.f = Boolean.FALSE;
            this.g = null;
            this.j = 800;
            if (goVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView != null) {
                this.a = goVar;
                this.e = bdListView;
                View view2 = goVar.getView();
                view2.setPadding(0, -this.a.p(), 0, 0);
                view2.invalidate();
                this.e.y(view2);
                this.h = ((int) (bdListView.getResources().getDisplayMetrics().density * 86.0f)) * 2;
                return;
            }
            throw new InvalidParameterException("PullRefresh listView is null");
        }

        public static boolean i(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f)) == null) {
                if (f > 0.0f) {
                    k = f;
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }

        public final void c() {
            go e;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (e = e()) == null || (view2 = e.getView()) == null) {
                return;
            }
            jo joVar = new jo(view2.getContext(), 0, -e.p(), this.j);
            joVar.d(new a(this));
            joVar.e(e.e);
            joVar.f(view2);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.d = 3;
                go goVar = this.a;
                goVar.C(0, -goVar.p(), 0, 0);
                this.a.o(true);
                r rVar = this.g;
                if (rVar != null) {
                    rVar.onScrollToPull(false);
                }
            }
        }

        public go e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (go) invokeV.objValue;
        }

        public void f(MotionEvent motionEvent, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048579, this, motionEvent, i) == null) && motionEvent.getAction() == 0 && e().q()) {
                this.b = false;
                this.f = Boolean.FALSE;
                if (i != 0 || 0 != 0 || this.e.getChildAt(0) == null || this.e.getChildAt(0).getTop() < 0) {
                    return;
                }
                this.b = true;
                this.c = (int) motionEvent.getY();
            }
        }

        public void g(MotionEvent motionEvent, int i) {
            r rVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048580, this, motionEvent, i) == null) && e().q()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) motionEvent.getY();
                        if (!this.b && i == 0 && this.e.getChildAt(0) != null && this.e.getChildAt(0).getTop() >= 0) {
                            this.b = true;
                            this.c = y;
                        }
                        int i2 = this.d;
                        if (i2 != 2 && this.b) {
                            if (i2 == 0) {
                                this.e.setSelection(0);
                                if (((int) ((y - this.c) / k)) < mi.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f0700dd) && y - this.c > 0) {
                                    this.d = 1;
                                    this.a.w(this.f.booleanValue());
                                    this.f = Boolean.FALSE;
                                    r rVar2 = this.g;
                                    if (rVar2 != null) {
                                        rVar2.onScrollToPull(true);
                                    }
                                } else if (y - this.c <= 0) {
                                    this.d = 3;
                                    go goVar = this.a;
                                    goVar.C(0, -goVar.p(), 0, 0);
                                    this.a.o(false);
                                    r rVar3 = this.g;
                                    if (rVar3 != null) {
                                        rVar3.onScrollToPull(true);
                                    }
                                }
                            } else if (i2 == 1) {
                                this.e.setSelection(0);
                                if (((int) ((y - this.c) / k)) >= mi.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f0700dd)) {
                                    this.d = 0;
                                    this.f = Boolean.TRUE;
                                    this.a.y();
                                    r rVar4 = this.g;
                                    if (rVar4 != null) {
                                        rVar4.onScrollToPull(true);
                                    }
                                } else if (y - this.c <= 0) {
                                    this.d = 3;
                                    go goVar2 = this.a;
                                    goVar2.C(0, -goVar2.p(), 0, 0);
                                    this.a.o(false);
                                    r rVar5 = this.g;
                                    if (rVar5 != null) {
                                        rVar5.onScrollToPull(true);
                                    }
                                }
                            } else if (i2 == 3) {
                                if (y - this.c > 0) {
                                    this.d = 1;
                                    this.a.w(this.f.booleanValue());
                                    this.f = Boolean.FALSE;
                                    r rVar6 = this.g;
                                    if (rVar6 != null) {
                                        rVar6.onScrollToPull(true);
                                    }
                                } else {
                                    r rVar7 = this.g;
                                    if (rVar7 != null) {
                                        rVar7.onScrollToPull(false);
                                    }
                                }
                            }
                            int i3 = this.d;
                            if (i3 == 1 || i3 == 0) {
                                go goVar3 = this.a;
                                goVar3.C(0, ((int) ((y - this.c) / k)) - goVar3.p(), 0, 0);
                                go goVar4 = this.a;
                                if (goVar4 != null && y >= this.i) {
                                    float f = ((y - this.c) / k) / this.h;
                                    goVar4.c(f, f);
                                }
                            }
                        }
                        this.i = y;
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                int i4 = this.d;
                if (i4 != 2) {
                    if (i4 == 1) {
                        this.d = 3;
                        go goVar5 = this.a;
                        goVar5.C(0, -goVar5.p(), 0, 0);
                        this.a.o(false);
                        r rVar8 = this.g;
                        if (rVar8 != null) {
                            rVar8.onScrollToPull(true);
                        }
                    } else if (i4 != 0) {
                        if (i4 != 3 || (rVar = this.g) == null) {
                            return;
                        }
                        rVar.onScrollToPull(false);
                    } else {
                        j(false);
                        r rVar9 = this.g;
                        if (rVar9 != null) {
                            rVar9.onScrollToPull(true);
                        }
                    }
                }
            }
        }

        public void h(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, rVar) == null) {
                this.g = rVar;
            }
        }

        public void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                this.d = 2;
                this.a.C(0, 0, 0, 0);
                this.a.x();
                this.a.u(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = null;
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = null;
        this.E = new a(this);
        this.F = null;
        B();
    }

    public static boolean D(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) ? t.i(f2) : invokeF.booleanValue;
    }

    private int getHeaderIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.o != null) {
                return this.a.n() - 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void A(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            t tVar = this.F;
            if (tVar != null && tVar.e() != null) {
                this.F.a.t();
            }
            ng.a().postDelayed(new b(this), j2);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setFadingEdgeLength(0);
            io ioVar = new io(getContext());
            this.a = ioVar;
            ioVar.s(new g(this));
            super.setOnItemClickListener(new h(this));
            super.setOnScrollListener(new i(this));
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t tVar = this.F;
            return tVar == null || tVar.d == 3;
        }
        return invokeV.booleanValue;
    }

    public void E(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
            smoothScrollToPositionFromTop(i2, i3, i4);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.F == null) {
            return;
        }
        setSelection(0);
        this.F.j(true);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, view2, obj, z) == null) {
            this.a.f(view2, obj, z, -1);
        }
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, obj, z) == null) {
            this.a.h(view2, obj, z, getHeaderIndex());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            try {
                super.dispatchDraw(canvas);
            } catch (NullPointerException e2) {
                BdLog.detailException(e2);
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            }
        }
    }

    @Override // com.repackage.to
    public int getContentViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (getWrappedAdapter() != null) {
                return getWrappedAdapter().getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ListView, com.repackage.to
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.k() : invokeV.intValue;
    }

    @Override // android.widget.ListView, com.repackage.to
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.m() : invokeV.intValue;
    }

    public so getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getAdapter2() : (so) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.to
    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (BdListView) invokeV.objValue;
    }

    public vo getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u : (vo) invokeV.objValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            io ioVar = this.a;
            if (ioVar instanceof io) {
                return ioVar.getWrappedAdapter();
            }
            return null;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                super.layoutChildren();
            } catch (NullPointerException e2) {
                BdLog.detailException(e2);
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                super.onDetachedFromWindow();
                getHandler().removeCallbacks(this.t);
                getHandler().removeCallbacks(this.E);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            t tVar = this.F;
            if (tVar != null) {
                tVar.f(motionEvent, this.r);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int lastVisiblePosition = getLastVisiblePosition();
            try {
                super.onLayout(z, i2, i3, i4, i5);
                if (!this.y) {
                    this.y = true;
                    this.B = i5;
                    n nVar = this.D;
                    if (nVar != null) {
                        nVar.a(-1);
                    }
                } else {
                    int i6 = this.B;
                    if (i6 < i5) {
                        i6 = i5;
                    }
                    this.B = i6;
                }
                if (this.y && this.B > i5 && i5 != this.C) {
                    this.z = true;
                    n nVar2 = this.D;
                    if (nVar2 != null) {
                        nVar2.a(-3);
                    }
                    if (this.A && lastVisiblePosition >= getCount() - 1) {
                        getHandler().postDelayed(this.E, 1L);
                    }
                }
                if (this.y && this.z && this.B == i5) {
                    this.z = false;
                    n nVar3 = this.D;
                    if (nVar3 != null) {
                        nVar3.a(-2);
                    }
                }
                this.C = i5;
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            if (this.x <= 0) {
                super.onMeasure(i2, i3);
                return;
            }
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int i4 = this.x;
            if (size > i4) {
                i3 = View.MeasureSpec.makeMeasureSpec(i4, mode);
            }
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            t tVar = this.F;
            if (tVar != null) {
                tVar.g(motionEvent, this.r);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view2)) == null) ? this.a.p(view2) : invokeL.booleanValue;
    }

    @Override // android.widget.ListView, com.repackage.to
    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) ? this.a.q(view2) : invokeL.booleanValue;
    }

    public void setExOnSrollToBottomListener(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, qVar) == null) {
            this.n = qVar;
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.A = z;
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setNextPage(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, foVar) == null) {
            fo foVar2 = this.p;
            if (foVar2 != null) {
                removeFooterView(foVar2.b());
                this.p = null;
            }
            if (foVar != null) {
                this.a.f(foVar.b(), null, true, 0);
                this.p = foVar;
            }
        }
    }

    public void setNoData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || str == null) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        setNoData(textView);
    }

    public void setOnFooterClickListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, lVar) == null) {
            this.f = lVar;
        }
    }

    public void setOnHeaderClickListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, mVar) == null) {
            this.e = mVar;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onItemClickListener) == null) {
            this.b = onItemClickListener;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onItemLongClickListener) == null) {
            if (onItemLongClickListener == null) {
                super.setOnItemLongClickListener(null);
                return;
            }
            this.c = onItemLongClickListener;
            super.setOnItemLongClickListener(new j(this));
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onItemSelectedListener) == null) {
            if (onItemSelectedListener == null) {
                super.setOnItemSelectedListener(null);
                return;
            }
            this.d = onItemSelectedListener;
            super.setOnItemSelectedListener(new k(this));
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onScrollListener) == null) {
            this.g = onScrollListener;
        }
    }

    public void setOnScrollStopDelayedListener(o oVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048619, this, oVar, j2) == null) {
            this.h = oVar;
            this.j = j2;
        }
    }

    public void setOnScrollToPullListener(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, rVar) == null) {
            this.i = rVar;
        }
    }

    public void setOnSrollToBottomListener(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, pVar) == null) {
            this.m = pVar;
        }
    }

    public void setOnSrollToTopListener(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, sVar) == null) {
            this.k = sVar;
        }
    }

    public void setOnkbdStateListener(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, nVar) == null) {
            this.D = nVar;
        }
    }

    public void setPrePage(fo foVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, foVar) == null) {
            fo foVar2 = this.o;
            if (foVar2 != null) {
                removeHeaderView(foVar2.b());
                this.o = null;
            }
            if (foVar != null) {
                addHeaderView(foVar.b());
                this.o = foVar;
            }
        }
    }

    public void setPullRefresh(go goVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, goVar) == null) {
            t tVar = this.F;
            if (tVar != null) {
                removeHeaderView(tVar.e().getView());
            }
            this.F = null;
            if (goVar != null) {
                t tVar2 = new t(this, goVar);
                this.F = tVar2;
                tVar2.h(this.i);
            }
        }
    }

    public void setScrollable(e9 e9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, e9Var) == null) {
            this.s = e9Var;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
            super.setSelectionFromTop(i2, i3);
        }
    }

    public void x(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048629, this, view2, i2) == null) {
            this.a.g(view2, i2);
        }
    }

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, view2) == null) {
            this.a.h(view2, null, false, 0);
        }
    }

    public void z() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (tVar = this.F) == null) {
            return;
        }
        if (tVar.e() != null) {
            this.F.a.t();
        }
        this.F.c();
    }

    @Override // android.widget.ListView
    public void addFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.a.e(view2);
        }
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.a.g(view2, getHeaderIndex());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, listAdapter) == null) {
            super.setAdapter((ListAdapter) null);
            this.a.r(listAdapter);
            super.setAdapter((ListAdapter) this.a);
        }
    }

    public void setOnSrollToTopListener(s sVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, sVar, i2) == null) {
            this.k = sVar;
            int i3 = i2 - 1;
            if (i3 < 0) {
                i3 = 0;
            }
            this.l = i3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.repackage.io' to match base method */
    @Override // android.widget.ListView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : (io) invokeV.objValue;
    }

    public void setNoData(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view2) == null) {
            View view3 = this.q;
            if (view3 != null) {
                removeHeaderView(view3);
                this.q = null;
            }
            if (view2 != null) {
                addHeaderView(view2, null, false);
                this.q = view2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = null;
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = null;
        this.E = new a(this);
        this.F = null;
        B();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = null;
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = null;
        this.E = new a(this);
        this.F = null;
        B();
    }
}
