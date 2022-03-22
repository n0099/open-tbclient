package c.a.o0.e1.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.dragsort.DragSortItemView;
import com.baidu.tbadk.widget.dragsort.DragSortItemViewCheckable;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements c.a.o0.e1.e.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public int C;
    public int D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public e J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public j Q;
    public MotionEvent R;
    public int S;
    public float T;
    public float U;
    public c V;
    public boolean W;
    public g X;
    public boolean Y;
    public boolean Z;
    public View a;
    public k a0;

    /* renamed from: b  reason: collision with root package name */
    public Point f10047b;
    public m b0;

    /* renamed from: c  reason: collision with root package name */
    public Point f10048c;
    public l c0;

    /* renamed from: d  reason: collision with root package name */
    public int f10049d;
    public h d0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10050e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f10051f;
    public float f0;

    /* renamed from: g  reason: collision with root package name */
    public float f10052g;
    public ListView g0;

    /* renamed from: h  reason: collision with root package name */
    public float f10053h;
    public c.a.o0.e1.e.d h0;
    public int i;
    public c.a.o0.e1.e.b i0;
    public int j;
    public boolean j0;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public d p;
    public i q;
    public n r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public View[] y;
    public f z;

    /* renamed from: c.a.o0.e1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0793a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0793a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.e1.e.a.e
        public float a(float f2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Long.valueOf(j)})) == null) ? this.a.I * f2 : invokeCommon.floatValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t == 4) {
                this.a.R();
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ListAdapter a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10054b;

        /* renamed from: c.a.o0.e1.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0794a extends DataSetObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public C0794a(c cVar, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.notifyDataSetChanged();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.notifyDataSetInvalidated();
                }
            }
        }

        public c(a aVar, ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, listAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10054b = aVar;
            this.a = listAdapter;
            listAdapter.registerDataSetObserver(new C0794a(this, aVar));
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.areAllItemsEnabled() : invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getCount() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.a.getItem(i) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.a.getItemId(i) : invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.a.getItemViewType(i) : invokeI.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
                if (view != null) {
                    dragSortItemView2 = (DragSortItemView) view;
                    View childAt = dragSortItemView2.getChildAt(0);
                    View view2 = this.a.getView(i, childAt, this.f10054b.g0);
                    if (view2 != childAt) {
                        if (childAt != null) {
                            dragSortItemView2.removeViewAt(0);
                        }
                        dragSortItemView2.addView(view2);
                    }
                } else {
                    View view3 = this.a.getView(i, null, this.f10054b.g0);
                    if (view3 instanceof Checkable) {
                        dragSortItemView = new DragSortItemViewCheckable(this.f10054b.g0.getContext());
                    } else {
                        dragSortItemView = new DragSortItemView(this.f10054b.g0.getContext());
                    }
                    dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    dragSortItemView.addView(view3);
                    dragSortItemView2 = dragSortItemView;
                }
                a aVar = this.f10054b;
                aVar.M(i + aVar.g0.getHeaderViewsCount(), dragSortItemView2, true);
                return dragSortItemView2;
            }
            return (View) invokeILL.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getViewTypeCount() : invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.hasStableIds() : invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? this.a.isEnabled(i) : invokeI.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        float a(float f2, long j);
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public long f10055b;

        /* renamed from: c  reason: collision with root package name */
        public long f10056c;

        /* renamed from: d  reason: collision with root package name */
        public int f10057d;

        /* renamed from: e  reason: collision with root package name */
        public float f10058e;

        /* renamed from: f  reason: collision with root package name */
        public long f10059f;

        /* renamed from: g  reason: collision with root package name */
        public int f10060g;

        /* renamed from: h  reason: collision with root package name */
        public float f10061h;
        public boolean i;
        public final /* synthetic */ a j;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = aVar;
            this.i = false;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.i) {
                    return this.f10060g;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i : invokeV.booleanValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.i) {
                return;
            }
            this.a = false;
            this.i = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f10059f = uptimeMillis;
            this.f10055b = uptimeMillis;
            this.f10060g = i;
            this.j.g0.post(this);
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (z) {
                    this.j.g0.removeCallbacks(this);
                    this.i = false;
                    return;
                }
                this.a = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (!this.a) {
                    int firstVisiblePosition = this.j.g0.getFirstVisiblePosition();
                    int lastVisiblePosition = this.j.g0.getLastVisiblePosition();
                    int count = this.j.g0.getCount();
                    int paddingTop = this.j.g0.getPaddingTop();
                    int height = (this.j.g0.getHeight() - paddingTop) - this.j.g0.getPaddingBottom();
                    int min = Math.min(this.j.L, this.j.f10049d + this.j.w);
                    int max = Math.max(this.j.L, this.j.f10049d - this.j.w);
                    if (this.f10060g == 0) {
                        View childAt = this.j.g0.getChildAt(0);
                        if (childAt == null) {
                            this.i = false;
                            return;
                        } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                            this.i = false;
                            return;
                        } else {
                            this.f10061h = this.j.J.a((this.j.F - max) / this.j.G, this.f10055b);
                        }
                    } else {
                        View childAt2 = this.j.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                        if (childAt2 == null) {
                            this.i = false;
                            return;
                        } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                            this.i = false;
                            return;
                        } else {
                            this.f10061h = -this.j.J.a((min - this.j.E) / this.j.H, this.f10055b);
                        }
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f10056c = uptimeMillis;
                    float f2 = (float) (uptimeMillis - this.f10055b);
                    this.f10058e = f2;
                    int round = Math.round(this.f10061h * f2);
                    this.f10057d = round;
                    if (round >= 0) {
                        this.f10057d = Math.min(height, round);
                        lastVisiblePosition = firstVisiblePosition;
                    } else {
                        this.f10057d = Math.max(-height, round);
                    }
                    View childAt3 = this.j.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    int top = childAt3.getTop() + this.f10057d;
                    if (lastVisiblePosition == 0 && top > paddingTop) {
                        top = paddingTop;
                    }
                    this.j.Y = true;
                    this.j.g0.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                    this.j.a();
                    this.j.g0.invalidate();
                    this.j.Y = false;
                    this.j.W(lastVisiblePosition, childAt3, false);
                    this.f10055b = this.f10056c;
                    this.j.g0.post(this);
                    return;
                }
                this.i = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public File f10062b;

        /* renamed from: c  reason: collision with root package name */
        public int f10063c;

        /* renamed from: d  reason: collision with root package name */
        public int f10064d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10065e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10066f;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10066f = aVar;
            this.a = new StringBuilder();
            this.f10063c = 0;
            this.f10064d = 0;
            this.f10065e = false;
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.f10062b = file;
            if (file.exists()) {
                return;
            }
            try {
                this.f10062b.createNewFile();
                Log.d("mobeta", "file created");
            } catch (IOException e2) {
                Log.w("mobeta", "Could not create dslv_state.txt");
                Log.d("mobeta", e2.getMessage());
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10065e) {
                this.a.append("<DSLVState>\n");
                int childCount = this.f10066f.g0.getChildCount();
                int firstVisiblePosition = this.f10066f.g0.getFirstVisiblePosition();
                this.a.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    StringBuilder sb = this.a;
                    sb.append(firstVisiblePosition + i);
                    sb.append(",");
                }
                this.a.append("</Positions>\n");
                this.a.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb2 = this.a;
                    sb2.append(this.f10066f.g0.getChildAt(i2).getTop());
                    sb2.append(",");
                }
                this.a.append("</Tops>\n");
                this.a.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb3 = this.a;
                    sb3.append(this.f10066f.g0.getChildAt(i3).getBottom());
                    sb3.append(",");
                }
                this.a.append("</Bottoms>\n");
                StringBuilder sb4 = this.a;
                sb4.append("    <FirstExpPos>");
                sb4.append(this.f10066f.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.a;
                sb5.append("    <FirstExpBlankHeight>");
                a aVar = this.f10066f;
                int e0 = aVar.e0(aVar.j);
                a aVar2 = this.f10066f;
                sb5.append(e0 - aVar2.c0(aVar2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.a;
                sb6.append("    <SecondExpPos>");
                sb6.append(this.f10066f.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.a;
                sb7.append("    <SecondExpBlankHeight>");
                a aVar3 = this.f10066f;
                int e02 = aVar3.e0(aVar3.k);
                a aVar4 = this.f10066f;
                sb7.append(e02 - aVar4.c0(aVar4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.a;
                sb8.append("    <SrcPos>");
                sb8.append(this.f10066f.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.a;
                sb9.append("    <SrcHeight>");
                sb9.append(this.f10066f.v + this.f10066f.g0.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.a;
                sb10.append("    <ViewHeight>");
                sb10.append(this.f10066f.g0.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.a;
                sb11.append("    <LastY>");
                sb11.append(this.f10066f.M);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.a;
                sb12.append("    <FloatY>");
                sb12.append(this.f10066f.f10049d);
                sb12.append("</FloatY>\n");
                this.a.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb13 = this.a;
                    a aVar5 = this.f10066f;
                    sb13.append(aVar5.f0(firstVisiblePosition + i4, aVar5.g0.getChildAt(i4).getTop()));
                    sb13.append(",");
                }
                this.a.append("</ShuffleEdges>\n");
                this.a.append("</DSLVState>\n");
                int i5 = this.f10063c + 1;
                this.f10063c = i5;
                if (i5 > 1000) {
                    b();
                    this.f10063c = 0;
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f10065e) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f10062b, this.f10064d != 0);
                    fileWriter.write(this.a.toString());
                    this.a.delete(0, this.a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.f10064d++;
                } catch (IOException unused) {
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.append("<DSLVStates>\n");
                this.f10064d = 0;
                this.f10065e = true;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f10065e) {
                this.a.append("</DSLVStates>\n");
                b();
                this.f10065e = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int j;
        public int k;
        public float l;
        public float m;
        public final /* synthetic */ a n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a aVar, float f2, int i) {
            super(aVar, f2, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Float.valueOf(f2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = aVar;
        }

        @Override // c.a.o0.e1.e.a.o
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j = this.n.i;
                this.k = this.n.m;
                this.n.t = 2;
                this.l = this.n.f10047b.y - f();
                this.m = this.n.f10047b.x - this.n.g0.getPaddingLeft();
            }
        }

        @Override // c.a.o0.e1.e.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.n.b0();
            }
        }

        @Override // c.a.o0.e1.e.a.o
        public void c(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                int f4 = f();
                float paddingLeft = this.n.f10047b.x - this.n.g0.getPaddingLeft();
                float f5 = 1.0f - f3;
                if (f5 < Math.abs((this.n.f10047b.y - f4) / this.l) || f5 < Math.abs(paddingLeft / this.m)) {
                    this.n.f10047b.y = f4 + ((int) (this.l * f5));
                    this.n.f10047b.x = this.n.g0.getPaddingLeft() + ((int) (this.m * f5));
                    this.n.X(true);
                }
            }
        }

        public final int f() {
            InterceptResult invokeV;
            int bottom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int firstVisiblePosition = this.n.g0.getFirstVisiblePosition();
                int dividerHeight = (this.n.u + this.n.g0.getDividerHeight()) / 2;
                View childAt = this.n.g0.getChildAt(this.j - firstVisiblePosition);
                if (childAt != null) {
                    int i = this.j;
                    int i2 = this.k;
                    if (i == i2) {
                        return childAt.getTop();
                    }
                    if (i < i2) {
                        bottom = childAt.getTop();
                    } else {
                        bottom = childAt.getBottom() + dividerHeight;
                        dividerHeight = this.n.v;
                    }
                    return bottom - dividerHeight;
                }
                cancel();
                return -1;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(View view);

        View b(int i);

        void c(View view, Point point, Point point2);
    }

    /* loaded from: classes2.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseIntArray a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Integer> f10067b;

        /* renamed from: c  reason: collision with root package name */
        public int f10068c;

        public k(a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new SparseIntArray(i);
            this.f10067b = new ArrayList<>(i);
            this.f10068c = i;
        }

        public void a(int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || (i3 = this.a.get(i, -1)) == i2) {
                return;
            }
            if (i3 == -1) {
                if (this.a.size() == this.f10068c) {
                    this.a.delete(this.f10067b.remove(0).intValue());
                }
            } else {
                this.f10067b.remove(Integer.valueOf(i));
            }
            this.a.put(i, i2);
            this.f10067b.add(Integer.valueOf(i));
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.clear();
                this.f10067b.clear();
            }
        }

        public int c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.a.get(i, -1) : invokeI.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class l extends o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class m extends o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float j;
        public float k;
        public float l;
        public int m;
        public int n;
        public int o;
        public int p;
        public final /* synthetic */ a q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(a aVar, float f2, int i) {
            super(aVar, f2, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Float.valueOf(f2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.q = aVar;
            this.m = -1;
            this.n = -1;
        }

        @Override // c.a.o0.e1.e.a.o
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.m = -1;
                this.n = -1;
                this.o = this.q.j;
                this.p = this.q.k;
                int unused = this.q.m;
                this.q.t = 1;
                this.j = this.q.f10047b.x;
                if (this.q.e0) {
                    float width = this.q.g0.getWidth() * 2.0f;
                    if (this.q.f0 == 0.0f) {
                        this.q.f0 = (this.j >= 0.0f ? 1 : -1) * width;
                        return;
                    }
                    float f2 = width * 2.0f;
                    if (this.q.f0 < 0.0f) {
                        float f3 = -f2;
                        if (this.q.f0 > f3) {
                            this.q.f0 = f3;
                            return;
                        }
                    }
                    if (this.q.f0 <= 0.0f || this.q.f0 >= f2) {
                        return;
                    }
                    this.q.f0 = f2;
                    return;
                }
                this.q.U();
            }
        }

        @Override // c.a.o0.e1.e.a.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.q.Y();
            }
        }

        @Override // c.a.o0.e1.e.a.o
        public void c(float f2, float f3) {
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                float f4 = 1.0f - f3;
                int firstVisiblePosition = this.q.g0.getFirstVisiblePosition();
                View childAt2 = this.q.g0.getChildAt(this.o - firstVisiblePosition);
                if (this.q.e0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.a)) / 1000.0f;
                    if (uptimeMillis == 0.0f) {
                        return;
                    }
                    float f5 = this.q.f0 * uptimeMillis;
                    int width = this.q.g0.getWidth();
                    a aVar = this.q;
                    float f6 = (this.q.f0 > 0.0f ? 1 : -1) * uptimeMillis;
                    float f7 = width;
                    aVar.f0 = aVar.f0 + (f6 * f7);
                    this.j += f5;
                    Point point = this.q.f10047b;
                    float f8 = this.j;
                    point.x = (int) f8;
                    if (f8 < f7 && f8 > (-width)) {
                        this.a = SystemClock.uptimeMillis();
                        this.q.X(true);
                        return;
                    }
                }
                if (childAt2 != null) {
                    if (this.m == -1) {
                        this.m = this.q.d0(this.o, childAt2, false);
                        this.k = childAt2.getHeight() - this.m;
                    }
                    int max = Math.max((int) (this.k * f4), 1);
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    layoutParams.height = this.m + max;
                    childAt2.setLayoutParams(layoutParams);
                }
                if (this.p == this.o || (childAt = this.q.g0.getChildAt(this.p - firstVisiblePosition)) == null) {
                    return;
                }
                if (this.n == -1) {
                    this.n = this.q.d0(this.p, childAt, false);
                    this.l = childAt.getHeight() - this.n;
                }
                int max2 = Math.max((int) (f4 * this.l), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = this.n + max2;
                childAt.setLayoutParams(layoutParams2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface n {
        void remove(int i);
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public float f10069b;

        /* renamed from: c  reason: collision with root package name */
        public float f10070c;

        /* renamed from: d  reason: collision with root package name */
        public float f10071d;

        /* renamed from: e  reason: collision with root package name */
        public float f10072e;

        /* renamed from: f  reason: collision with root package name */
        public float f10073f;

        /* renamed from: g  reason: collision with root package name */
        public float f10074g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f10075h;
        public final /* synthetic */ a i;

        public o(a aVar, float f2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Float.valueOf(f2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = aVar;
            this.f10070c = f2;
            this.f10069b = i;
            float f3 = 1.0f / ((f2 * 2.0f) * (1.0f - f2));
            this.f10074g = f3;
            this.f10071d = f3;
            this.f10072e = f2 / ((f2 - 1.0f) * 2.0f);
            this.f10073f = 1.0f / (1.0f - f2);
        }

        public abstract void a();

        public abstract void b();

        public abstract void c(float f2, float f3);

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f10075h = true;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = SystemClock.uptimeMillis();
                this.f10075h = false;
                a();
                this.i.g0.post(this);
            }
        }

        public float e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
                float f3 = this.f10070c;
                if (f2 < f3) {
                    return this.f10071d * f2 * f2;
                }
                if (f2 < 1.0f - f3) {
                    return this.f10072e + (this.f10073f * f2);
                }
                float f4 = f2 - 1.0f;
                return 1.0f - ((this.f10074g * f4) * f4);
            }
            return invokeF.floatValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f10075h) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.a)) / this.f10069b;
            if (uptimeMillis >= 1.0f) {
                c(1.0f, 1.0f);
                b();
                return;
            }
            c(uptimeMillis, e(uptimeMillis));
            this.i.g0.post(this);
        }
    }

    public a(ListView listView, c.a.o0.e1.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10047b = new Point();
        this.f10048c = new Point();
        this.f10050e = false;
        this.f10052g = 1.0f;
        this.f10053h = 1.0f;
        this.l = false;
        this.s = true;
        this.t = 0;
        this.u = 1;
        this.x = 0;
        this.y = new View[1];
        this.A = 0.33333334f;
        this.B = 0.33333334f;
        this.I = 0.5f;
        this.J = new C0793a(this);
        this.N = 0;
        this.O = false;
        this.P = false;
        this.Q = null;
        this.S = 0;
        this.T = 0.25f;
        this.U = 0.0f;
        this.W = false;
        this.Y = false;
        this.Z = false;
        this.a0 = new k(this, 3);
        this.f0 = 0.0f;
        this.j0 = false;
        this.h0 = dVar;
        this.g0 = listView;
    }

    public boolean A0(boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            this.e0 = true;
            return z0(z, f2);
        }
        return invokeCommon.booleanValue;
    }

    public final void B0() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.Q != null) {
                this.f10048c.set(this.K, this.L);
                this.Q.c(this.a, this.f10047b, this.f10048c);
            }
            Point point = this.f10047b;
            int i4 = point.x;
            int i5 = point.y;
            int paddingLeft = this.g0.getPaddingLeft();
            if ((this.N & 1) == 0 && i4 > paddingLeft) {
                this.f10047b.x = paddingLeft;
            } else if ((this.N & 2) == 0 && i4 < paddingLeft) {
                this.f10047b.x = paddingLeft;
            }
            int headerViewsCount = this.g0.getHeaderViewsCount();
            int footerViewsCount = this.g0.getFooterViewsCount();
            int firstVisiblePosition = this.g0.getFirstVisiblePosition();
            int lastVisiblePosition = this.g0.getLastVisiblePosition();
            int paddingTop = this.g0.getPaddingTop();
            if (firstVisiblePosition < headerViewsCount) {
                paddingTop = this.g0.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
            }
            if ((this.N & 8) == 0 && firstVisiblePosition <= (i3 = this.m)) {
                paddingTop = Math.max(this.g0.getChildAt(i3 - firstVisiblePosition).getTop(), paddingTop);
            }
            int height = this.g0.getHeight() - this.g0.getPaddingBottom();
            if (lastVisiblePosition >= (this.g0.getCount() - footerViewsCount) - 1) {
                ListView listView = this.g0;
                height = listView.getChildAt(((listView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
            }
            if ((this.N & 4) == 0 && lastVisiblePosition >= (i2 = this.m)) {
                height = Math.min(this.g0.getChildAt(i2 - firstVisiblePosition).getBottom(), height);
            }
            if (i5 < paddingTop) {
                this.f10047b.y = paddingTop;
            } else {
                int i6 = this.v;
                if (i5 + i6 > height) {
                    this.f10047b.y = height - i6;
                }
            }
            this.f10049d = this.f10047b.y + this.w;
        }
    }

    public final boolean C0() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int firstVisiblePosition = this.g0.getFirstVisiblePosition();
            int i4 = this.j;
            View childAt = this.g0.getChildAt(i4 - firstVisiblePosition);
            if (childAt == null) {
                i4 = (this.g0.getChildCount() / 2) + firstVisiblePosition;
                childAt = this.g0.getChildAt(i4 - firstVisiblePosition);
            }
            int top = childAt.getTop();
            int height = childAt.getHeight();
            int f0 = f0(i4, top);
            int dividerHeight = this.g0.getDividerHeight();
            if (this.f10049d < f0) {
                while (i4 >= 0) {
                    i4--;
                    int e0 = e0(i4);
                    if (i4 == 0) {
                        i2 = (top - dividerHeight) - e0;
                        int i5 = f0;
                        f0 = i2;
                        i3 = i5;
                        break;
                    }
                    top -= e0 + dividerHeight;
                    int f02 = f0(i4, top);
                    if (this.f10049d >= f02) {
                        i3 = f0;
                        f0 = f02;
                        break;
                    }
                    f0 = f02;
                }
                i3 = f0;
            } else {
                int count = this.g0.getCount();
                while (i4 < count) {
                    if (i4 == count - 1) {
                        i2 = top + dividerHeight + height;
                        int i52 = f0;
                        f0 = i2;
                        i3 = i52;
                        break;
                    }
                    top += height + dividerHeight;
                    int i6 = i4 + 1;
                    int e02 = e0(i6);
                    int f03 = f0(i6, top);
                    if (this.f10049d < f03) {
                        i3 = f0;
                        f0 = f03;
                        break;
                    }
                    i4 = i6;
                    height = e02;
                    f0 = f03;
                }
                i3 = f0;
            }
            int headerViewsCount = this.g0.getHeaderViewsCount();
            int footerViewsCount = this.g0.getFooterViewsCount();
            boolean z = false;
            int i7 = this.j;
            int i8 = this.k;
            float f2 = this.U;
            if (this.l) {
                int abs = Math.abs(f0 - i3);
                if (this.f10049d < f0) {
                    int i9 = f0;
                    f0 = i3;
                    i3 = i9;
                }
                int i10 = (int) (this.T * 0.5f * abs);
                float f3 = i10;
                int i11 = f0 + i10;
                int i12 = i3 - i10;
                int i13 = this.f10049d;
                if (i13 < i11) {
                    this.j = i4 - 1;
                    this.k = i4;
                    this.U = ((i11 - i13) * 0.5f) / f3;
                } else if (i13 < i12) {
                    this.j = i4;
                    this.k = i4;
                } else {
                    this.j = i4;
                    this.k = i4 + 1;
                    this.U = (((i3 - i13) / f3) + 1.0f) * 0.5f;
                }
            } else {
                this.j = i4;
                this.k = i4;
            }
            if (this.j < headerViewsCount) {
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                i4 = headerViewsCount;
            } else if (this.k >= this.g0.getCount() - footerViewsCount) {
                i4 = (this.g0.getCount() - footerViewsCount) - 1;
                this.j = i4;
                this.k = i4;
            }
            z = (this.j == i7 && this.k == i8 && this.U == f2) ? true : true;
            int i14 = this.i;
            if (i4 != i14) {
                d dVar = this.p;
                if (dVar != null) {
                    dVar.a(i14 - headerViewsCount, i4 - headerViewsCount);
                }
                this.i = i4;
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void D0() {
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int paddingTop = this.g0.getPaddingTop();
            float height2 = (this.g0.getHeight() - paddingTop) - this.g0.getPaddingBottom();
            float f2 = paddingTop;
            float f3 = (this.A * height2) + f2;
            this.F = f3;
            float f4 = ((1.0f - this.B) * height2) + f2;
            this.E = f4;
            this.C = (int) f3;
            this.D = (int) f4;
            this.G = f3 - f2;
            this.H = (paddingTop + height) - f4;
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int firstVisiblePosition = this.g0.getFirstVisiblePosition();
            int lastVisiblePosition = this.g0.getLastVisiblePosition();
            int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((this.g0.getCount() - 1) - this.g0.getFooterViewsCount()) - firstVisiblePosition);
            for (int max = Math.max(0, this.g0.getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
                View childAt = this.g0.getChildAt(max);
                if (childAt != null) {
                    M(firstVisiblePosition + max, childAt, false);
                }
            }
        }
    }

    public final void M(int i2, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)}) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int Q = (i2 == this.m || i2 == this.j || i2 == this.k) ? Q(i2, view, z) : -2;
            if (Q != layoutParams.height) {
                layoutParams.height = Q;
                view.setLayoutParams(layoutParams);
            }
            if (i2 == this.j || i2 == this.k) {
                int i3 = this.m;
                if (i2 < i3) {
                    ((DragSortItemView) view).setGravity(80);
                } else if (i2 > i3) {
                    ((DragSortItemView) view).setGravity(48);
                }
            }
            int visibility = view.getVisibility();
            int i4 = 0;
            if (i2 == this.m && this.a != null) {
                i4 = 4;
            }
            if (i4 != visibility) {
                view.setVisibility(i4);
            }
        }
    }

    public final void N() {
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.m >= (firstVisiblePosition = this.g0.getFirstVisiblePosition())) {
            return;
        }
        View childAt = this.g0.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : 0;
        ListView listView = this.g0;
        listView.setSelectionFromTop(firstVisiblePosition - 1, top - listView.getPaddingTop());
    }

    public final int O(int i2, View view, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int c0 = c0(i2);
            int height = view.getHeight();
            int P = P(i2, c0);
            if (i2 != this.m) {
                i5 = height - c0;
                i6 = P - c0;
            } else {
                i5 = height;
                i6 = P;
            }
            int i7 = this.v;
            int i8 = this.m;
            if (i8 != this.j && i8 != this.k) {
                i7 -= this.u;
            }
            if (i2 <= i3) {
                if (i2 > this.j) {
                    return 0 + (i7 - i6);
                }
                return 0;
            } else if (i2 == i4) {
                if (i2 <= this.j) {
                    i5 -= i7;
                } else if (i2 == this.k) {
                    return 0 + (height - P);
                }
                return 0 + i5;
            } else if (i2 <= this.j) {
                return 0 - i7;
            } else {
                if (i2 == this.k) {
                    return 0 - i6;
                }
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public final int P(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            this.g0.getDividerHeight();
            boolean z = this.l && this.j != this.k;
            int i4 = this.v;
            int i5 = this.u;
            int i6 = i4 - i5;
            int i7 = (int) (this.U * i6);
            int i8 = this.m;
            return i2 == i8 ? i8 == this.j ? z ? i7 + i5 : i4 : i8 == this.k ? i4 - i7 : i5 : i2 == this.j ? z ? i3 + i7 : i3 + i6 : i2 == this.k ? (i3 + i6) - i7 : i3;
        }
        return invokeII.intValue;
    }

    public final int Q(int i2, View view, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)})) == null) ? P(i2, d0(i2, view, z)) : invokeCommon.intValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.t == 4) {
            this.z.d(true);
            U();
            S();
            L();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m = -1;
            this.j = -1;
            this.k = -1;
            this.i = -1;
        }
    }

    public final void T(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            Point point = this.f10047b;
            point.x = i2 - this.n;
            point.y = i3 - this.o;
            X(true);
            int min = Math.min(i3, this.f10049d + this.w);
            int max = Math.max(i3, this.f10049d - this.w);
            int a = this.z.a();
            if (min > this.M && min > this.D && a != 1) {
                if (a != -1) {
                    this.z.d(true);
                }
                this.z.c(1);
            } else if (max < this.M && max < this.C && a != 0) {
                if (a != -1) {
                    this.z.d(true);
                }
                this.z.c(0);
            } else if (max < this.C || min > this.D || !this.z.b()) {
            } else {
                this.z.d(true);
            }
        }
    }

    public final void U() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (view = this.a) == null) {
            return;
        }
        view.setVisibility(8);
        j jVar = this.Q;
        if (jVar != null) {
            jVar.a(this.a);
        }
        this.a = null;
        this.g0.invalidate();
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.S = 0;
            this.P = false;
            if (this.t == 3) {
                this.t = 0;
            }
            this.f10053h = this.f10052g;
            this.j0 = false;
            this.a0.b();
        }
    }

    public final void W(int i2, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)}) == null) {
            this.Y = true;
            B0();
            int i3 = this.j;
            int i4 = this.k;
            boolean C0 = C0();
            if (C0) {
                L();
                this.g0.setSelectionFromTop(i2, (view.getTop() + O(i2, view, i3, i4)) - this.g0.getPaddingTop());
                a();
            }
            if (C0 || z) {
                this.g0.invalidate();
            }
            this.Y = false;
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            int firstVisiblePosition = this.g0.getFirstVisiblePosition() + (this.g0.getChildCount() / 2);
            ListView listView = this.g0;
            View childAt = listView.getChildAt(listView.getChildCount() / 2);
            if (childAt == null) {
                return;
            }
            W(firstVisiblePosition, childAt, z);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Z(this.m - this.g0.getHeaderViewsCount());
        }
    }

    public final void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.t = 1;
            n nVar = this.r;
            if (nVar != null) {
                nVar.remove(i2);
            }
            U();
            N();
            S();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    @Override // c.a.o0.e1.e.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.h0.a();
            View view = this.a;
            if (view != null) {
                if (view.isLayoutRequested() && !this.f10050e) {
                    i0();
                }
                View view2 = this.a;
                view2.layout(0, 0, view2.getMeasuredWidth(), this.a.getMeasuredHeight());
                this.f10050e = false;
            }
        }
    }

    public final void a0(int i2, Canvas canvas) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, canvas) == null) {
            Drawable divider = this.g0.getDivider();
            int dividerHeight = this.g0.getDividerHeight();
            if (divider == null || dividerHeight == 0) {
                return;
            }
            ListView listView = this.g0;
            ViewGroup viewGroup = (ViewGroup) listView.getChildAt(i2 - listView.getFirstVisiblePosition());
            if (viewGroup != null) {
                int paddingLeft = this.g0.getPaddingLeft();
                int width = this.g0.getWidth() - this.g0.getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i2 > this.m) {
                    i4 = viewGroup.getTop() + height;
                    i3 = dividerHeight + i4;
                } else {
                    int bottom = viewGroup.getBottom() - height;
                    int i5 = bottom - dividerHeight;
                    i3 = bottom;
                    i4 = i5;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, i4, width, i3);
                divider.setBounds(paddingLeft, i4, width, i3);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // c.a.o0.e1.e.c
    public void b(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, canvas) == null) {
            this.h0.b(canvas);
            if (this.t != 0) {
                int i2 = this.j;
                if (i2 != this.m) {
                    a0(i2, canvas);
                }
                int i3 = this.k;
                if (i3 != this.j && i3 != this.m) {
                    a0(i3, canvas);
                }
            }
            View view = this.a;
            if (view != null) {
                int width = view.getWidth();
                int height = this.a.getHeight();
                int i4 = this.f10047b.x;
                int width2 = this.g0.getWidth();
                if (i4 < 0) {
                    i4 = -i4;
                }
                if (i4 < width2) {
                    float f3 = (width2 - i4) / width2;
                    f2 = f3 * f3;
                } else {
                    f2 = 0.0f;
                }
                canvas.save();
                Point point = this.f10047b;
                canvas.translate(point.x, point.y);
                canvas.clipRect(0, 0, width, height);
                canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.f10053h * 255.0f * f2), 31);
                this.a.draw(canvas);
                canvas.restore();
                canvas.restore();
            }
        }
    }

    public final void b0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.t = 2;
            if (this.q != null && (i2 = this.i) >= 0 && i2 < this.g0.getCount()) {
                int headerViewsCount = this.g0.getHeaderViewsCount();
                this.q.a(this.m - headerViewsCount, this.i - headerViewsCount);
            }
            U();
            N();
            S();
            L();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    @Override // c.a.o0.e1.e.c
    public void c(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, listView, context, attributeSet) == null) {
            int i4 = 150;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040141, R.attr.obfuscated_res_0x7f040153, R.attr.obfuscated_res_0x7f0401ba, R.attr.obfuscated_res_0x7f0401bb, R.attr.obfuscated_res_0x7f0401bc, R.attr.obfuscated_res_0x7f0401cd, R.attr.obfuscated_res_0x7f040214, R.attr.obfuscated_res_0x7f040215, R.attr.obfuscated_res_0x7f040216, R.attr.obfuscated_res_0x7f040423, R.attr.obfuscated_res_0x7f0404f0, R.attr.obfuscated_res_0x7f0404f1, R.attr.obfuscated_res_0x7f040566, R.attr.obfuscated_res_0x7f04056d, R.attr.obfuscated_res_0x7f0405d9, R.attr.obfuscated_res_0x7f0405da, R.attr.obfuscated_res_0x7f040663, R.attr.obfuscated_res_0x7f040674}, 0, 0);
                this.u = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(1, 1));
                boolean z = obtainStyledAttributes.getBoolean(16, false);
                this.W = z;
                if (z) {
                    this.X = new g(this);
                }
                float f2 = obtainStyledAttributes.getFloat(7, this.f10052g);
                this.f10052g = f2;
                this.f10053h = f2;
                this.s = obtainStyledAttributes.getBoolean(2, this.s);
                float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(12, 0.75f)));
                this.T = max;
                this.l = max > 0.0f;
                q0(obtainStyledAttributes.getFloat(4, this.A));
                this.I = obtainStyledAttributes.getFloat(9, this.I);
                int i5 = obtainStyledAttributes.getInt(10, 150);
                i2 = obtainStyledAttributes.getInt(5, 150);
                if (obtainStyledAttributes.getBoolean(17, true)) {
                    boolean z2 = obtainStyledAttributes.getBoolean(11, false);
                    int i6 = obtainStyledAttributes.getInt(14, 1);
                    boolean z3 = obtainStyledAttributes.getBoolean(13, true);
                    int resourceId = obtainStyledAttributes.getResourceId(3, 0);
                    int resourceId2 = obtainStyledAttributes.getResourceId(6, 0);
                    int resourceId3 = obtainStyledAttributes.getResourceId(0, 0);
                    int color = obtainStyledAttributes.getColor(8, -16777216);
                    i3 = i5;
                    c.a.o0.e1.e.b bVar = new c.a.o0.e1.e.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                    bVar.s(z2);
                    bVar.u(z3);
                    bVar.d(color);
                    this.Q = bVar;
                    s0(bVar);
                } else {
                    i3 = i5;
                }
                obtainStyledAttributes.recycle();
                i4 = i3;
            } else {
                i2 = 150;
            }
            this.z = new f(this);
            if (i4 > 0) {
                this.b0 = new m(this, 0.5f, i4);
            }
            if (i2 > 0) {
                this.d0 = new h(this, 0.5f, i2);
            }
            this.R = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            this.f10051f = new b(this);
        }
    }

    public final int c0(int i2) {
        InterceptResult invokeI;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (i2 == this.m) {
                return 0;
            }
            ListView listView = this.g0;
            View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
            if (childAt != null) {
                return d0(i2, childAt, false);
            }
            int c2 = this.a0.c(i2);
            if (c2 != -1) {
                return c2;
            }
            ListAdapter adapter = this.g0.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.y.length) {
                this.y = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                View[] viewArr = this.y;
                if (viewArr[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.g0);
                    this.y[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, viewArr[itemViewType], this.g0);
                }
            } else {
                view = adapter.getView(i2, null, this.g0);
            }
            int d0 = d0(i2, view, true);
            this.a0.a(i2, d0);
            return d0;
        }
        return invokeI.intValue;
    }

    public final int d0(int i2, View view, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)})) == null) {
            if (i2 == this.m) {
                return 0;
            }
            if (i2 >= this.g0.getHeaderViewsCount() && i2 < this.g0.getCount() - this.g0.getFooterViewsCount()) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || (i3 = layoutParams.height) <= 0) {
                int height = view.getHeight();
                if (height == 0 || z) {
                    j0(view);
                    return view.getMeasuredHeight();
                }
                return height;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public final int e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            ListView listView = this.g0;
            View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
            if (childAt != null) {
                return childAt.getHeight();
            }
            return P(i2, c0(i2));
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r8 <= r7.m) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i2, i3)) == null) {
            int headerViewsCount = this.g0.getHeaderViewsCount();
            int footerViewsCount = this.g0.getFooterViewsCount();
            if (i2 <= headerViewsCount || i2 >= this.g0.getCount() - footerViewsCount) {
                return i3;
            }
            int dividerHeight = this.g0.getDividerHeight();
            int i4 = this.v - this.u;
            int c0 = c0(i2);
            int e0 = e0(i2);
            int i5 = this.k;
            int i6 = this.m;
            if (i5 <= i6) {
                if (i2 != i5 || this.j == i5) {
                    if (i2 > this.k) {
                    }
                } else if (i2 == i6) {
                    i3 += e0;
                    i4 = this.v;
                } else {
                    i3 += e0 - c0;
                }
                i3 -= i4;
            } else if (i2 <= i6 || i2 > this.j) {
                int i7 = this.k;
                if (i2 == i7 && this.j != i7) {
                    i3 += e0 - c0;
                }
            } else {
                i3 += i4;
            }
            if (i2 <= this.m) {
                return i3 + (((this.v - dividerHeight) - c0(i2 - 1)) / 2);
            }
            return i3 + (((c0 - dividerHeight) - this.v) / 2);
        }
        return invokeII.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.j0 : invokeV.booleanValue;
    }

    public final void i0() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (view = this.a) == null) {
            return;
        }
        j0(view);
        int measuredHeight = this.a.getMeasuredHeight();
        this.v = measuredHeight;
        this.w = measuredHeight / 2;
    }

    public final void j0(View view) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.x, this.g0.getListPaddingLeft() + this.g0.getListPaddingRight(), layoutParams.width);
            int i2 = layoutParams.height;
            if (i2 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    public boolean k0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            motionEvent.getAction();
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                if (this.t == 4) {
                    y0(false);
                }
                V();
            } else if (action == 2) {
                T((int) motionEvent.getX(), (int) motionEvent.getY());
            } else if (action == 3) {
                if (this.t == 4) {
                    R();
                }
                V();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.e0 = false;
            m0(i2, 0.0f);
        }
    }

    public void m0(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int i3 = this.t;
            if (i3 == 0 || i3 == 4) {
                if (this.t == 0) {
                    int headerViewsCount = this.g0.getHeaderViewsCount() + i2;
                    this.m = headerViewsCount;
                    this.j = headerViewsCount;
                    this.k = headerViewsCount;
                    this.i = headerViewsCount;
                    ListView listView = this.g0;
                    View childAt = listView.getChildAt(headerViewsCount - listView.getFirstVisiblePosition());
                    if (childAt != null) {
                        childAt.setVisibility(4);
                    }
                }
                this.t = 1;
                this.f0 = f2;
                if (this.P) {
                    int i4 = this.S;
                    if (i4 == 1) {
                        this.h0.onTouchEvent(this.R);
                    } else if (i4 == 2) {
                        this.h0.onInterceptTouchEvent(this.R);
                    }
                }
                m mVar = this.b0;
                if (mVar != null) {
                    mVar.d();
                } else {
                    Z(i2);
                }
            }
        }
    }

    public final void n0(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, motionEvent) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                this.M = this.L;
            }
            this.K = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.L = y;
            if (action == 0) {
                this.M = y;
            }
            motionEvent.getRawX();
            motionEvent.getRawY();
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.s = z;
        }
    }

    @Override // c.a.o0.e1.e.c
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, canvas) == null) {
            this.h0.onDraw(canvas);
            if (this.W) {
                this.X.a();
            }
        }
    }

    @Override // c.a.o0.e1.e.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            if (!this.s) {
                return this.h0.onInterceptTouchEvent(motionEvent);
            }
            c.a.o0.e1.e.b bVar = this.i0;
            if (bVar != null) {
                bVar.q().onTouchEvent(motionEvent);
            }
            n0(motionEvent);
            this.O = true;
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                if (this.t != 0) {
                    this.Z = true;
                    return true;
                }
                this.P = true;
            }
            if (this.a != null) {
                z = true;
            } else {
                if (this.h0.onInterceptTouchEvent(motionEvent)) {
                    this.j0 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (action == 1 || action == 3) {
                    V();
                } else if (z) {
                    this.S = 1;
                } else {
                    this.S = 2;
                }
            }
            if (action == 1 || action == 3) {
                this.P = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.e1.e.c
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i2, i3) == null) {
            this.h0.onMeasure(i2, i3);
            View view = this.a;
            if (view != null) {
                if (view.isLayoutRequested()) {
                    i0();
                }
                this.f10050e = true;
            }
            this.x = i2;
        }
    }

    @Override // c.a.o0.e1.e.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048616, this, i2, i3, i4, i5) == null) {
            this.h0.onSizeChanged(i2, i3, i4, i5);
            D0();
        }
    }

    @Override // c.a.o0.e1.e.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            boolean z = false;
            if (this.Z) {
                this.Z = false;
                return false;
            } else if (!this.s) {
                return this.h0.onTouchEvent(motionEvent);
            } else {
                boolean z2 = this.O;
                this.O = false;
                if (!z2) {
                    n0(motionEvent);
                }
                int i2 = this.t;
                if (i2 == 4) {
                    k0(motionEvent);
                    return true;
                }
                if (i2 == 0 && this.h0.onTouchEvent(motionEvent)) {
                    z = true;
                }
                int action = motionEvent.getAction() & 255;
                if (action == 1 || action == 3) {
                    V();
                } else if (z) {
                    this.S = 1;
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public void p0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, dVar) == null) {
            this.p = dVar;
        }
    }

    public void q0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            r0(f2, f2);
        }
    }

    public void r0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f3 > 0.5f) {
                this.B = 0.5f;
            } else {
                this.B = f3;
            }
            if (f2 > 0.5f) {
                this.A = 0.5f;
            } else {
                this.A = f2;
            }
            if (this.g0.getHeight() != 0) {
                D0();
            }
        }
    }

    @Override // c.a.o0.e1.e.c
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.Y) {
            return;
        }
        this.h0.requestLayout();
    }

    public void s0(c.a.o0.e1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.i0 = bVar;
            this.g0.setOnTouchListener(bVar);
        }
    }

    @Override // c.a.o0.e1.e.c
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, listAdapter) == null) {
            if (listAdapter != null) {
                this.V = new c(this, listAdapter);
                listAdapter.registerDataSetObserver(this.f10051f);
                if (listAdapter instanceof i) {
                    t0((i) listAdapter);
                }
                if (listAdapter instanceof d) {
                    p0((d) listAdapter);
                }
                if (listAdapter instanceof n) {
                    v0((n) listAdapter);
                }
            } else {
                this.V = null;
            }
            this.h0.setAdapter(this.V);
        }
    }

    public void t0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, iVar) == null) {
            this.q = iVar;
        }
    }

    public void u0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jVar) == null) {
            this.Q = jVar;
        }
    }

    public void v0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, nVar) == null) {
            this.r = nVar;
        }
    }

    public boolean w0(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        j jVar;
        View b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048627, this, i2, i3, i4, i5)) == null) {
            if (!this.P || (jVar = this.Q) == null || (b2 = jVar.b(i2)) == null) {
                return false;
            }
            return x0(i2, b2, i3, i4, i5);
        }
        return invokeIIII.booleanValue;
    }

    public boolean x0(int i2, View view, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), view, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (this.t == 0 && this.P && this.a == null && view != null && this.s) {
                if (this.g0.getParent() != null) {
                    this.g0.getParent().requestDisallowInterceptTouchEvent(true);
                }
                int headerViewsCount = i2 + this.g0.getHeaderViewsCount();
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.m = headerViewsCount;
                this.i = headerViewsCount;
                this.t = 4;
                this.N = 0;
                this.N = i3 | 0;
                this.a = view;
                i0();
                this.n = i4;
                this.o = i5;
                int i6 = this.L;
                Point point = this.f10047b;
                point.x = this.K - i4;
                point.y = i6 - i5;
                ListView listView = this.g0;
                View childAt = listView.getChildAt(this.m - listView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
                if (this.W) {
                    this.X.c();
                }
                int i7 = this.S;
                if (i7 == 1) {
                    this.h0.onTouchEvent(this.R);
                } else if (i7 == 2) {
                    this.h0.onInterceptTouchEvent(this.R);
                }
                this.g0.requestLayout();
                l lVar = this.c0;
                if (lVar != null) {
                    lVar.d();
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean y0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
            this.e0 = false;
            return z0(z, 0.0f);
        }
        return invokeZ.booleanValue;
    }

    public boolean z0(boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            if (this.a != null) {
                this.z.d(true);
                if (z) {
                    m0(this.m - this.g0.getHeaderViewsCount(), f2);
                } else {
                    h hVar = this.d0;
                    if (hVar != null) {
                        hVar.d();
                    } else {
                        b0();
                    }
                }
                if (this.W) {
                    this.X.d();
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
