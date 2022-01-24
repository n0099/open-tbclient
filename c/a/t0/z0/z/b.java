package c.a.t0.z0.z;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.face.view.EmotionPreview;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailActivity;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionPackageDetailActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final float f26121b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26122c;

    /* renamed from: d  reason: collision with root package name */
    public final int f26123d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f26124e;

    /* renamed from: f  reason: collision with root package name */
    public int f26125f;

    /* renamed from: g  reason: collision with root package name */
    public int f26126g;

    /* renamed from: h  reason: collision with root package name */
    public int f26127h;

    /* renamed from: i  reason: collision with root package name */
    public int f26128i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f26129j;
    public EmotionPreview k;
    public PackageDetailListView l;
    public boolean m;
    public boolean n;
    public FrameLayout o;
    public int p;
    public e q;
    public final Runnable r;
    public final PackageDetailListView.a s;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26130e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26130e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26130e.B();
            }
        }
    }

    /* renamed from: c.a.t0.z0.z.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1576b implements PackageDetailListView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1576b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            e v;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (motionEvent == null) {
                    return false;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.f26125f > -1 && this.a.f26126g > -1) {
                                this.a.f26127h = (int) motionEvent.getX();
                                this.a.f26128i = (int) motionEvent.getY();
                                if (this.a.m || this.a.q != null) {
                                    if (this.a.q != null && (v = this.a.v()) != null && (this.a.q == null || !this.a.q.equals(v))) {
                                        this.a.z(v);
                                    }
                                } else {
                                    float f2 = this.a.f26127h - this.a.f26125f;
                                    float f3 = this.a.f26128i - this.a.f26126g;
                                    if ((f2 * f2) + (f3 * f3) > this.a.f26121b * this.a.f26121b) {
                                        this.a.m = true;
                                    }
                                }
                            }
                            return this.a.q != null;
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    this.a.u();
                    return false;
                }
                this.a.f26125f = (int) motionEvent.getX();
                this.a.f26126g = (int) motionEvent.getY();
                this.a.m = false;
                this.a.A();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26131e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26131e = bVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f26131e.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements SwipeBackLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.n = false;
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.n = true;
                this.a.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f26132b;

        /* renamed from: c  reason: collision with root package name */
        public int f26133c;

        public e(View view, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f26132b = i2;
            this.f26133c = i3;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == null || !(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return eVar.f26132b == this.f26132b && eVar.f26133c == this.f26133c && eVar.a == this.a;
            }
            return invokeL.booleanValue;
        }
    }

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emotionPackageDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26124e = new Rect();
        this.f26125f = -1;
        this.f26126g = -1;
        this.f26127h = -1;
        this.f26128i = -1;
        this.m = false;
        this.n = false;
        this.p = 3;
        this.r = new a(this);
        this.s = new C1576b(this);
        this.a = emotionPackageDetailActivity;
        PackageDetailListView listView = emotionPackageDetailActivity.getListView();
        this.l = listView;
        listView.setTouchEventInterceptHandler(this.s);
        this.f26129j = emotionPackageDetailActivity.getSafeHandler();
        this.l = emotionPackageDetailActivity.getListView();
        this.f26121b = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.f26122c = n.f(emotionPackageDetailActivity, R.dimen.ds240);
        this.f26123d = n.f(emotionPackageDetailActivity, R.dimen.ds260);
        this.l.setOnScrollListener(new c(this));
        SwipeBackLayout swipeBackLayout = emotionPackageDetailActivity.getSwipeBackLayout();
        if (swipeBackLayout != null) {
            swipeBackLayout.setOnSlidingStateChangeListener(new d(this));
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26129j.removeCallbacks(this.r);
            this.f26129j.postDelayed(this.r, 500L);
        }
    }

    public final void B() {
        e v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.m || this.n || this.q != null || (v = v()) == null) {
            return;
        }
        z(v);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26129j.removeCallbacks(this.r);
            u();
        }
    }

    public final boolean t(View view, EmotionPackageData.SingleEmotionData singleEmotionData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, singleEmotionData)) == null) {
            if (singleEmotionData == null || TextUtils.isEmpty(singleEmotionData.url) || view == null) {
                return false;
            }
            String str = "show preview, url: " + singleEmotionData.url;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            EmotionPreview emotionPreview = new EmotionPreview(this.a);
            this.k = emotionPreview;
            SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, this.p);
            this.k.loadImage(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26122c, this.f26123d);
            int i2 = iArr[0] - 60;
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = iArr[1] - this.f26123d;
            if (i2 < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.f26122c > n.k(this.a)) {
                layoutParams.leftMargin = n.k(this.a) - this.f26122c;
            }
            if (this.o == null) {
                this.o = (FrameLayout) this.a.getWindow().getDecorView();
            }
            if (this.k.getParent() != null) {
                ViewParent parent = this.k.getParent();
                FrameLayout frameLayout = this.o;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.k);
                }
            }
            this.o.addView(this.k, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26128i = -1;
            this.f26127h = -1;
            this.f26126g = -1;
            this.f26125f = -1;
            this.m = false;
            this.a.setSwipeBackEnabled(true);
            EmotionPreview emotionPreview = this.k;
            if (emotionPreview == null || this.q == null) {
                return;
            }
            if (emotionPreview.getParent() != null) {
                ViewParent parent = this.k.getParent();
                FrameLayout frameLayout = this.o;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.k);
                }
            }
            this.q = null;
            this.l.setDisableListViewTouchIntercept(false);
        }
    }

    public final e v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f26127h;
            int i3 = this.f26128i;
            if (i2 < 0) {
                i2 = this.f26125f;
            }
            if (i3 < 0) {
                i3 = this.f26126g;
            }
            int pointToPosition = this.l.pointToPosition(i2, i3);
            if (pointToPosition >= 0) {
                this.f26124e.set(i2, i3, i2 + 1, i3 + 1);
                View childAt = this.l.getChildAt(pointToPosition);
                if (childAt == null || !(childAt instanceof ViewGroup)) {
                    return null;
                }
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.l.offsetRectIntoDescendantCoords(childAt, this.f26124e);
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = viewGroup.getChildAt(i4);
                    if (childAt2.getLeft() < this.f26124e.left && childAt2.getRight() > this.f26124e.right && childAt2.getTop() < this.f26124e.left && childAt2.getBottom() > this.f26124e.bottom) {
                        int headerViewsCount = pointToPosition - this.l.getHeaderViewsCount();
                        e eVar = new e(childAt2, headerViewsCount, i4);
                        String str = "touch cell: (" + headerViewsCount + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX;
                        return eVar;
                    }
                }
                return null;
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    public final EmotionPackageData.SingleEmotionData w(int i2, int i3) {
        InterceptResult invokeII;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            c.a.d.n.e.e adapter2 = this.l.getAdapter2();
            int i4 = (i2 * 4) + i3;
            int headerViewsCount = i2 + this.l.getHeaderViewsCount();
            if (adapter2 == null || headerViewsCount <= -1 || headerViewsCount >= adapter2.getCount() || (list = (List) adapter2.getItem(headerViewsCount)) == null || i4 <= -1 || i4 >= list.size()) {
                return null;
            }
            return (EmotionPackageData.SingleEmotionData) list.get(i4);
        }
        return (EmotionPackageData.SingleEmotionData) invokeII.objValue;
    }

    public final void x() {
        EmotionPreview emotionPreview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (emotionPreview = this.k) == null || this.o == null) {
            return;
        }
        if (emotionPreview.getParent() != null) {
            ViewParent parent = this.k.getParent();
            FrameLayout frameLayout = this.o;
            if (parent == frameLayout) {
                frameLayout.removeView(this.k);
            }
        }
        this.k = null;
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
            EmotionPreview emotionPreview = this.k;
            if (emotionPreview != null) {
                SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, i2);
            }
        }
    }

    public final void z(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        x();
        if (t(eVar.a, w(eVar.f26132b, eVar.f26133c))) {
            this.q = eVar;
            this.l.setDisableListViewTouchIntercept(true);
            this.a.setSwipeBackEnabled(false);
        }
    }
}
