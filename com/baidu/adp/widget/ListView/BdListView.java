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
import c.a.d.n.e.e;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes9.dex */
public class BdListView extends ListView implements c.a.d.n.e.p<BdListView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int OVER_SCROLL_NEVER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public n H;
    public Runnable I;
    public t J;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.n.e.e f32337e;

    /* renamed from: f  reason: collision with root package name */
    public AdapterView.OnItemClickListener f32338f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemLongClickListener f32339g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f32340h;

    /* renamed from: i  reason: collision with root package name */
    public m f32341i;

    /* renamed from: j  reason: collision with root package name */
    public l f32342j;

    /* renamed from: k  reason: collision with root package name */
    public AbsListView.OnScrollListener f32343k;
    public o l;
    public r m;
    public long n;
    public s o;
    public int p;
    public p q;
    public q r;
    public c.a.d.n.e.b s;
    public c.a.d.n.e.b t;
    public View u;
    public int v;
    public c.a.d.a.i w;
    public Runnable x;
    public final c.a.d.n.e.q y;
    public Runnable z;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32344e;

        public a(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32344e = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdListView bdListView = this.f32344e;
                bdListView.setSelection(bdListView.getCount() - 1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32345e;

        public b(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32345e = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f32345e.J == null) {
                return;
            }
            this.f32345e.J.c();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32346e;

        public c(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32346e = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f32346e.l == null) {
                return;
            }
            int firstVisiblePosition = this.f32346e.getFirstVisiblePosition();
            int lastVisiblePosition = this.f32346e.getLastVisiblePosition();
            int i2 = 0;
            int i3 = -1;
            if (this.f32346e.f32337e == null || this.f32346e.f32337e.getWrappedAdapter() == null || this.f32346e.f32337e.m() <= 0) {
                i2 = -1;
            } else {
                int l = firstVisiblePosition - this.f32346e.f32337e.l();
                i3 = l < 0 ? 0 : l;
                int l2 = lastVisiblePosition - this.f32346e.f32337e.l();
                if (l2 >= this.f32346e.f32337e.m()) {
                    l2 = this.f32346e.f32337e.m() - 1;
                }
                if (l2 >= 0) {
                    i2 = l2;
                }
            }
            this.f32346e.l.onScrollStop(i3, i2);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.a.d.n.e.q {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // c.a.d.n.e.q
        public void cancelRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdListView bdListView = this.a;
                bdListView.removeCallbacks(bdListView.z);
            }
        }

        @Override // c.a.d.n.e.q
        public c.a.d.n.e.o getAdapter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getAdapter2() : (c.a.d.n.e.o) invokeV.objValue;
        }

        @Override // c.a.d.n.e.q
        public int getFirstVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getFirstVisiblePosition() : invokeV.intValue;
        }

        @Override // c.a.d.n.e.q
        public int getLastVisiblePosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getLastVisiblePosition() : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32347e;

        public e(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32347e = bdListView;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof c.a.d.g.a.h) {
                ((c.a.d.g.a.h) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.d.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int childCount = this.f32347e.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(this.f32347e.getChildAt(i2));
                }
                if (this.f32347e.w != null) {
                    c2 = this.f32347e.w;
                } else {
                    c2 = c.a.d.a.j.c(this.f32347e.getContext());
                }
                if (c2 != null) {
                    c2.onPreLoad(this.f32347e.y);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32348e;

        public f(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32348e = bdListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.d.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f32348e.w != null) {
                    c2 = this.f32348e.w;
                } else {
                    c2 = c.a.d.a.j.c(this.f32348e.getContext());
                }
                if (c2 != null) {
                    c2.onPreLoad(this.f32348e.y);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements e.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdListView;
        }

        @Override // c.a.d.n.e.e.b
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdListView bdListView = this.a;
                bdListView.removeCallbacks(bdListView.A);
                BdListView bdListView2 = this.a;
                bdListView2.postDelayed(bdListView2.A, 100L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32349e;

        public h(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32349e = bdListView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                int l = this.f32349e.f32337e.l();
                if (i2 < l) {
                    if (this.f32349e.s == null || view != this.f32349e.s.b()) {
                        if (this.f32349e.f32341i != null) {
                            this.f32349e.f32341i.onClick(view);
                            return;
                        }
                        return;
                    }
                    this.f32349e.s.c();
                    return;
                }
                int i3 = i2 - l;
                ListAdapter wrappedAdapter = this.f32349e.f32337e.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    if (this.f32349e.t == null || view != this.f32349e.t.b()) {
                        if (this.f32349e.f32342j != null) {
                            this.f32349e.f32342j.onClick(view);
                            return;
                        }
                        return;
                    }
                    this.f32349e.t.c();
                } else if (this.f32349e.f32338f != null) {
                    this.f32349e.f32338f.onItemClick(adapterView, view, i3, j2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32350e;

        public i(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32350e = bdListView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f32350e.v = i2;
                if (this.f32350e.f32343k != null) {
                    this.f32350e.f32343k.onScroll(absListView, i2, i3, i4);
                }
                if (this.f32350e.l == null || this.f32350e.n <= 0) {
                    return;
                }
                this.f32350e.getHandler().removeCallbacks(this.f32350e.x);
                this.f32350e.getHandler().postDelayed(this.f32350e.x, this.f32350e.n);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            c.a.d.a.i c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (this.f32350e.w != null) {
                    c2 = this.f32350e.w;
                } else {
                    c2 = c.a.d.a.j.c(this.f32350e.getContext());
                }
                if (c2 != null) {
                    if (i2 == 2) {
                        BdListView bdListView = this.f32350e;
                        bdListView.removeCallbacks(bdListView.z);
                        c2.setIsScroll(true);
                    } else if (c2.isScroll()) {
                        c2.setIsScroll(false);
                        BdListView bdListView2 = this.f32350e;
                        bdListView2.removeCallbacks(bdListView2.z);
                        BdListView bdListView3 = this.f32350e;
                        bdListView3.postDelayed(bdListView3.z, 100L);
                    } else if (i2 == 0) {
                        BdListView bdListView4 = this.f32350e;
                        bdListView4.removeCallbacks(bdListView4.A);
                        BdListView bdListView5 = this.f32350e;
                        bdListView5.postDelayed(bdListView5.A, 100L);
                    }
                }
                if (this.f32350e.f32343k != null) {
                    this.f32350e.f32343k.onScrollStateChanged(absListView, i2);
                }
                if (i2 == 0) {
                    if (this.f32350e.q != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        this.f32350e.q.onScrollToBottom();
                    }
                    if (this.f32350e.r != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        this.f32350e.r.onScrollToBottom(this.f32350e);
                    }
                    if (this.f32350e.o == null || absListView.getFirstVisiblePosition() > this.f32350e.p) {
                        return;
                    }
                    this.f32350e.o.onScrollToTop();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32351e;

        public j(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32351e = bdListView;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                int l = this.f32351e.f32337e.l();
                if (i2 < l) {
                    return true;
                }
                int i3 = i2 - l;
                ListAdapter wrappedAdapter = this.f32351e.f32337e.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    return true;
                }
                if (this.f32351e.f32339g != null) {
                    return this.f32351e.f32339g.onItemLongClick(adapterView, view, i3, j2);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class k implements AdapterView.OnItemSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView f32352e;

        public k(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32352e = bdListView;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            int l;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < (l = this.f32352e.f32337e.l())) {
                return;
            }
            int i3 = i2 - l;
            ListAdapter wrappedAdapter = this.f32352e.f32337e.getWrappedAdapter();
            if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount() || this.f32352e.f32340h == null) {
                return;
            }
            this.f32352e.f32340h.onItemSelected(adapterView, view, i3, j2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) || this.f32352e.f32340h == null) {
                return;
            }
            this.f32352e.f32340h.onNothingSelected(adapterView);
        }
    }

    /* loaded from: classes9.dex */
    public interface l {
        void onClick(View view);
    }

    /* loaded from: classes9.dex */
    public interface m {
        void onClick(View view);
    }

    /* loaded from: classes9.dex */
    public interface n {
        void a(int i2);
    }

    /* loaded from: classes9.dex */
    public interface o {
        void onScrollStop(int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public interface p {
        void onScrollToBottom();
    }

    /* loaded from: classes9.dex */
    public interface q {
        void onScrollToBottom(BdListView bdListView);
    }

    /* loaded from: classes9.dex */
    public interface r {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes9.dex */
    public interface s {
        void onScrollToTop();
    }

    /* loaded from: classes9.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: k  reason: collision with root package name */
        public static float f32353k = 3.0f;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.d.n.e.c a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f32354b;

        /* renamed from: c  reason: collision with root package name */
        public int f32355c;

        /* renamed from: d  reason: collision with root package name */
        public int f32356d;

        /* renamed from: e  reason: collision with root package name */
        public BdListView f32357e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f32358f;

        /* renamed from: g  reason: collision with root package name */
        public r f32359g;

        /* renamed from: h  reason: collision with root package name */
        public int f32360h;

        /* renamed from: i  reason: collision with root package name */
        public int f32361i;

        /* renamed from: j  reason: collision with root package name */
        public int f32362j;

        /* loaded from: classes9.dex */
        public class a implements c.a.d.n.f.a {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // c.a.d.n.f.a
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

        public t(BdListView bdListView, c.a.d.n.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView, cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f32354b = false;
            this.f32355c = 0;
            this.f32356d = 3;
            this.f32357e = null;
            this.f32358f = Boolean.FALSE;
            this.f32359g = null;
            this.f32362j = 800;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView != null) {
                this.a = cVar;
                this.f32357e = bdListView;
                View view = cVar.getView();
                view.setPadding(0, -this.a.k(), 0, 0);
                view.invalidate();
                this.f32357e.addPullRefreshView(view);
                this.f32360h = ((int) (bdListView.getResources().getDisplayMetrics().density * 86.0f)) * 2;
                return;
            }
            throw new InvalidParameterException("PullRefresh listView is null");
        }

        public static boolean i(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) {
                if (f2 > 0.0f) {
                    f32353k = f2;
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }

        public final void c() {
            c.a.d.n.e.c e2;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (e2 = e()) == null || (view = e2.getView()) == null) {
                return;
            }
            c.a.d.n.e.f fVar = new c.a.d.n.e.f(view.getContext(), 0, -e2.k(), this.f32362j);
            fVar.d(new a(this));
            fVar.e(e2.f3311i);
            fVar.f(view);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32356d = 3;
                c.a.d.n.e.c cVar = this.a;
                cVar.x(0, -cVar.k(), 0, 0);
                this.a.j(true);
                r rVar = this.f32359g;
                if (rVar != null) {
                    rVar.onScrollToPull(false);
                }
            }
        }

        public c.a.d.n.e.c e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.d.n.e.c) invokeV.objValue;
        }

        public void f(MotionEvent motionEvent, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048579, this, motionEvent, i2) == null) && motionEvent.getAction() == 0 && e().l()) {
                this.f32354b = false;
                this.f32358f = Boolean.FALSE;
                if (i2 != 0 || 0 != 0 || this.f32357e.getChildAt(0) == null || this.f32357e.getChildAt(0).getTop() < 0) {
                    return;
                }
                this.f32354b = true;
                this.f32355c = (int) motionEvent.getY();
            }
        }

        public void g(MotionEvent motionEvent, int i2) {
            r rVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048580, this, motionEvent, i2) == null) && e().l()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) motionEvent.getY();
                        if (!this.f32354b && i2 == 0 && this.f32357e.getChildAt(0) != null && this.f32357e.getChildAt(0).getTop() >= 0) {
                            this.f32354b = true;
                            this.f32355c = y;
                        }
                        int i3 = this.f32356d;
                        if (i3 != 2 && this.f32354b) {
                            if (i3 == 0) {
                                this.f32357e.setSelection(0);
                                if (((int) ((y - this.f32355c) / f32353k)) < c.a.d.f.p.n.f(this.a.getContext(), R.dimen.adp_list_view_pull_maxoffset) && y - this.f32355c > 0) {
                                    this.f32356d = 1;
                                    this.a.r(this.f32358f.booleanValue());
                                    this.f32358f = Boolean.FALSE;
                                    r rVar2 = this.f32359g;
                                    if (rVar2 != null) {
                                        rVar2.onScrollToPull(true);
                                    }
                                } else if (y - this.f32355c <= 0) {
                                    this.f32356d = 3;
                                    c.a.d.n.e.c cVar = this.a;
                                    cVar.x(0, -cVar.k(), 0, 0);
                                    this.a.j(false);
                                    r rVar3 = this.f32359g;
                                    if (rVar3 != null) {
                                        rVar3.onScrollToPull(true);
                                    }
                                }
                            } else if (i3 == 1) {
                                this.f32357e.setSelection(0);
                                if (((int) ((y - this.f32355c) / f32353k)) >= c.a.d.f.p.n.f(this.a.getContext(), R.dimen.adp_list_view_pull_maxoffset)) {
                                    this.f32356d = 0;
                                    this.f32358f = Boolean.TRUE;
                                    this.a.t();
                                    r rVar4 = this.f32359g;
                                    if (rVar4 != null) {
                                        rVar4.onScrollToPull(true);
                                    }
                                } else if (y - this.f32355c <= 0) {
                                    this.f32356d = 3;
                                    c.a.d.n.e.c cVar2 = this.a;
                                    cVar2.x(0, -cVar2.k(), 0, 0);
                                    this.a.j(false);
                                    r rVar5 = this.f32359g;
                                    if (rVar5 != null) {
                                        rVar5.onScrollToPull(true);
                                    }
                                }
                            } else if (i3 == 3) {
                                if (y - this.f32355c > 0) {
                                    this.f32356d = 1;
                                    this.a.r(this.f32358f.booleanValue());
                                    this.f32358f = Boolean.FALSE;
                                    r rVar6 = this.f32359g;
                                    if (rVar6 != null) {
                                        rVar6.onScrollToPull(true);
                                    }
                                } else {
                                    r rVar7 = this.f32359g;
                                    if (rVar7 != null) {
                                        rVar7.onScrollToPull(false);
                                    }
                                }
                            }
                            int i4 = this.f32356d;
                            if (i4 == 1 || i4 == 0) {
                                c.a.d.n.e.c cVar3 = this.a;
                                cVar3.x(0, ((int) ((y - this.f32355c) / f32353k)) - cVar3.k(), 0, 0);
                                c.a.d.n.e.c cVar4 = this.a;
                                if (cVar4 != null && y >= this.f32361i) {
                                    float f2 = ((y - this.f32355c) / f32353k) / this.f32360h;
                                    cVar4.onPullPercentChange(f2, f2);
                                }
                            }
                        }
                        this.f32361i = y;
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                int i5 = this.f32356d;
                if (i5 != 2) {
                    if (i5 == 1) {
                        this.f32356d = 3;
                        c.a.d.n.e.c cVar5 = this.a;
                        cVar5.x(0, -cVar5.k(), 0, 0);
                        this.a.j(false);
                        r rVar8 = this.f32359g;
                        if (rVar8 != null) {
                            rVar8.onScrollToPull(true);
                        }
                    } else if (i5 != 0) {
                        if (i5 != 3 || (rVar = this.f32359g) == null) {
                            return;
                        }
                        rVar.onScrollToPull(false);
                    } else {
                        j(false);
                        r rVar9 = this.f32359g;
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
                this.f32359g = rVar;
            }
        }

        public void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                this.f32356d = 2;
                this.a.x(0, 0, 0, 0);
                this.a.s();
                this.a.p(z);
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
        this.f32337e = null;
        this.f32338f = null;
        this.f32339g = null;
        this.f32340h = null;
        this.f32341i = null;
        this.f32342j = null;
        this.f32343k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = new c(this);
        this.y = new d(this);
        this.z = new e(this);
        this.A = new f(this);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = new a(this);
        this.J = null;
        w();
    }

    private int getHeaderIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.s != null) {
                return this.f32337e.l() - 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static boolean setPullRefreshRatio(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65559, null, f2)) == null) ? t.i(f2) : invokeF.booleanValue;
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, obj, z) == null) {
            this.f32337e.d(view, obj, z, -1);
        }
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view, obj, z) == null) {
            this.f32337e.f(view, obj, z, getHeaderIndex());
        }
    }

    public void addPullRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.f32337e.f(view, null, false, 0);
        }
    }

    public void completePullRefresh() {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tVar = this.J) == null) {
            return;
        }
        if (tVar.e() != null) {
            this.J.a.o();
        }
        this.J.c();
    }

    public void completePullRefreshPostDelayed(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            t tVar = this.J;
            if (tVar != null && tVar.e() != null) {
                this.J.a.o();
            }
            c.a.d.f.m.e.a().postDelayed(new b(this), j2);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
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

    @Override // c.a.d.n.e.p
    public int getContentViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (getWrappedAdapter() != null) {
                return getWrappedAdapter().getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ListView, c.a.d.n.e.p
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f32337e.i() : invokeV.intValue;
    }

    @Override // android.widget.ListView, c.a.d.n.e.p
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f32337e.k() : invokeV.intValue;
    }

    public c.a.d.n.e.o getListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getAdapter2() : (c.a.d.n.e.o) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.p
    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (BdListView) invokeV.objValue;
    }

    public c.a.d.n.e.q getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.y : (c.a.d.n.e.q) invokeV.objValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.d.n.e.e eVar = this.f32337e;
            if (eVar instanceof c.a.d.n.e.e) {
                return eVar.getWrappedAdapter();
            }
            return null;
        }
        return (ListAdapter) invokeV.objValue;
    }

    public boolean isRefreshDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            t tVar = this.J;
            return tVar == null || tVar.f32356d == 3;
        }
        return invokeV.booleanValue;
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
                getHandler().removeCallbacks(this.x);
                getHandler().removeCallbacks(this.I);
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
            t tVar = this.J;
            if (tVar != null) {
                tVar.f(motionEvent, this.v);
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
                if (!this.C) {
                    this.C = true;
                    this.F = i5;
                    n nVar = this.H;
                    if (nVar != null) {
                        nVar.a(-1);
                    }
                } else {
                    int i6 = this.F;
                    if (i6 < i5) {
                        i6 = i5;
                    }
                    this.F = i6;
                }
                if (this.C && this.F > i5 && i5 != this.G) {
                    this.D = true;
                    n nVar2 = this.H;
                    if (nVar2 != null) {
                        nVar2.a(-3);
                    }
                    if (this.E && lastVisiblePosition >= getCount() - 1) {
                        getHandler().postDelayed(this.I, 1L);
                    }
                }
                if (this.C && this.D && this.F == i5) {
                    this.D = false;
                    n nVar3 = this.H;
                    if (nVar3 != null) {
                        nVar3.a(-2);
                    }
                }
                this.G = i5;
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
            if (this.B <= 0) {
                super.onMeasure(i2, i3);
                return;
            }
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int i4 = this.B;
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
            t tVar = this.J;
            if (tVar != null) {
                tVar.g(motionEvent, this.v);
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
    public boolean removeFooterView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view)) == null) ? this.f32337e.n(view) : invokeL.booleanValue;
    }

    @Override // android.widget.ListView, c.a.d.n.e.p
    public boolean removeHeaderView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view)) == null) ? this.f32337e.o(view) : invokeL.booleanValue;
    }

    public void setExOnSrollToBottomListener(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, qVar) == null) {
            this.r = qVar;
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.E = z;
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setNextPage(c.a.d.n.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            c.a.d.n.e.b bVar2 = this.t;
            if (bVar2 != null) {
                removeFooterView(bVar2.b());
                this.t = null;
            }
            if (bVar != null) {
                this.f32337e.d(bVar.b(), null, true, 0);
                this.t = bVar;
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
            this.f32342j = lVar;
        }
    }

    public void setOnHeaderClickListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, mVar) == null) {
            this.f32341i = mVar;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onItemClickListener) == null) {
            this.f32338f = onItemClickListener;
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
            this.f32339g = onItemLongClickListener;
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
            this.f32340h = onItemSelectedListener;
            super.setOnItemSelectedListener(new k(this));
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onScrollListener) == null) {
            this.f32343k = onScrollListener;
        }
    }

    public void setOnScrollStopDelayedListener(o oVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048619, this, oVar, j2) == null) {
            this.l = oVar;
            this.n = j2;
        }
    }

    public void setOnScrollToPullListener(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, rVar) == null) {
            this.m = rVar;
        }
    }

    public void setOnSrollToBottomListener(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, pVar) == null) {
            this.q = pVar;
        }
    }

    public void setOnSrollToTopListener(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, sVar) == null) {
            this.o = sVar;
        }
    }

    public void setOnkbdStateListener(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, nVar) == null) {
            this.H = nVar;
        }
    }

    public void setPrePage(c.a.d.n.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bVar) == null) {
            c.a.d.n.e.b bVar2 = this.s;
            if (bVar2 != null) {
                removeHeaderView(bVar2.b());
                this.s = null;
            }
            if (bVar != null) {
                addHeaderView(bVar.b());
                this.s = bVar;
            }
        }
    }

    public void setPullRefresh(c.a.d.n.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, cVar) == null) {
            t tVar = this.J;
            if (tVar != null) {
                removeHeaderView(tVar.e().getView());
            }
            this.J = null;
            if (cVar != null) {
                t tVar2 = new t(this, cVar);
                this.J = tVar2;
                tVar2.h(this.m);
            }
        }
    }

    public void setScrollable(c.a.d.a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, iVar) == null) {
            this.w = iVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048628, this, i2, i3) == null) {
            super.setSelectionFromTop(i2, i3);
        }
    }

    public void smoothScrollToPosition(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048629, this, i2, i3, i4) == null) {
            smoothScrollToPositionFromTop(i2, i3, i4);
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || this.J == null) {
            return;
        }
        setSelection(0);
        this.J.j(true);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            setFadingEdgeLength(0);
            c.a.d.n.e.e eVar = new c.a.d.n.e.e(getContext());
            this.f32337e = eVar;
            eVar.q(new g(this));
            super.setOnItemClickListener(new h(this));
            super.setOnScrollListener(new i(this));
        }
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f32337e.c(view);
        }
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f32337e.e(view, getHeaderIndex());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, listAdapter) == null) {
            super.setAdapter((ListAdapter) null);
            this.f32337e.p(listAdapter);
            super.setAdapter((ListAdapter) this.f32337e);
        }
    }

    public void setOnSrollToTopListener(s sVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, sVar, i2) == null) {
            this.o = sVar;
            int i3 = i2 - 1;
            if (i3 < 0) {
                i3 = 0;
            }
            this.p = i3;
        }
    }

    public void addHeaderView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            this.f32337e.e(view, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'c.a.d.n.e.e' to match base method */
    @Override // android.widget.ListView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f32337e : (c.a.d.n.e.e) invokeV.objValue;
    }

    public void setNoData(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            View view2 = this.u;
            if (view2 != null) {
                removeHeaderView(view2);
                this.u = null;
            }
            if (view != null) {
                addHeaderView(view, null, false);
                this.u = view;
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
        this.f32337e = null;
        this.f32338f = null;
        this.f32339g = null;
        this.f32340h = null;
        this.f32341i = null;
        this.f32342j = null;
        this.f32343k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = new c(this);
        this.y = new d(this);
        this.z = new e(this);
        this.A = new f(this);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = new a(this);
        this.J = null;
        w();
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
        this.f32337e = null;
        this.f32338f = null;
        this.f32339g = null;
        this.f32340h = null;
        this.f32341i = null;
        this.f32342j = null;
        this.f32343k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = new c(this);
        this.y = new d(this);
        this.z = new e(this);
        this.A = new f(this);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = new a(this);
        this.J = null;
        w();
    }
}
