package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.av4;
import com.baidu.tieba.bv4;
import com.baidu.tieba.dv4;
import com.baidu.tieba.ev4;
import com.baidu.tieba.yu4;
import com.baidu.tieba.zu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadFlowView<T extends zu4> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;
    public IndicatorView b;
    public bv4 c;
    public View d;
    public DownloadFlowAdapter<T> e;
    public yu4 f;
    public DownloadFlowView<T>.c g;
    public boolean h;
    public boolean i;
    public boolean j;
    public dv4<T> k;
    public DownloadFlowView<T>.e l;
    public DownloadFlowView<T>.b m;
    public DownloadFlowView<T>.d n;
    public long o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadFlowView a;

        public b(DownloadFlowView downloadFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadFlowView;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.baidu.tieba.dv4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null && (view2.getTag() instanceof Integer)) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (((ApkDownloadInfoData) this.a.e.b(intValue)) == null) {
                    return;
                }
                this.a.k.b(intValue, this.a.m(intValue), true);
            }
        }

        public /* synthetic */ b(DownloadFlowView downloadFlowView, a aVar) {
            this(downloadFlowView);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadFlowView a;

        public c(DownloadFlowView downloadFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadFlowView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.a.t();
            }
        }

        public /* synthetic */ c(DownloadFlowView downloadFlowView, a aVar) {
            this(downloadFlowView);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadFlowView a;

        public e(DownloadFlowView downloadFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadFlowView;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.baidu.tieba.dv4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null && (view2.getTag() instanceof Integer)) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (((ApkDownloadInfoData) this.a.e.b(intValue)) == null) {
                    return;
                }
                this.a.k.b(intValue, this.a.m(intValue), false);
            }
        }

        public /* synthetic */ e(DownloadFlowView downloadFlowView, a aVar) {
            this(downloadFlowView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadFlowView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i) == null) {
            int count = this.e.getCount();
            if (i == 0) {
                this.b.setPosition(0.0f);
            } else if (i == count - 1) {
                this.b.setPosition(i);
            } else {
                this.b.setPosition(i - 1);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DownloadFlowAdapter<T> downloadFlowAdapter = this.e;
            if (downloadFlowAdapter != null && (count = downloadFlowAdapter.getCount()) > 1) {
                int currentItem = this.a.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.a.setCurrentItem(i, false);
                    this.a.invalidate();
                } else if (currentItem > i) {
                    this.a.setCurrentItem(1, false);
                    this.a.invalidate();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public T m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            DownloadFlowAdapter<T> downloadFlowAdapter = this.e;
            if (downloadFlowAdapter == null) {
                return null;
            }
            return downloadFlowAdapter.b(i);
        }
        return (T) invokeI.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && l()) {
            s();
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            q(context);
            p(context);
            setCoverFlowFactory(new av4());
            addView(this.a);
            addView(this.b);
            DownloadFlowAdapter<T> downloadFlowAdapter = new DownloadFlowAdapter<>(context);
            this.e = downloadFlowAdapter;
            downloadFlowAdapter.h(this.l, this.m);
            this.a.setAdapter(this.e);
            this.a.setOnPageChangeListener(this.n);
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.b = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.a = new ListViewPager(context);
        }
    }

    public void r() {
        bv4 bv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.d();
            IndicatorView indicatorView = this.b;
            if (indicatorView == null || (bv4Var = this.c) == null) {
                return;
            }
            indicatorView.setDrawable(SkinManager.getDrawable(bv4Var.a()));
            this.b.setSelector(SkinManager.getDrawable(this.c.b()));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.removeMessages(1);
            this.g.sendEmptyMessageDelayed(1, this.o);
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }

    public void setCallback(dv4<T> dv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dv4Var) == null) {
            this.k = dv4Var;
        }
    }

    public void setCoverFlowFactory(yu4 yu4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, yu4Var) == null) || yu4Var == null) {
            return;
        }
        this.f = yu4Var;
        bv4 a2 = yu4Var.a();
        this.c = a2;
        a2.i(this.b);
        yu4Var.c().b(this.a);
        View b2 = yu4Var.b();
        this.d = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.a);
            addView(this.d);
            addView(this.b);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.e.g(list, this.f);
        int size = list.size();
        if (size > 1) {
            this.b.setVisibility(0);
            this.b.setCount(size);
            this.a.setCurrentItem(1, false);
            this.b.setPosition(0.0f);
            if (this.j) {
                v();
                return;
            }
            return;
        }
        this.b.setVisibility(8);
        this.b.setCount(size);
        this.a.setCurrentItem(1, false);
        this.b.setPosition(0.0f);
        w();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.h = z;
        }
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (indicatorView = this.b) == null) {
            return;
        }
        indicatorView.setVisibility(i);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i = z;
        }
    }

    public void setMarqueenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.o = j;
            s();
        }
    }

    public void setPageMargin(int i) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setPageMargin(i);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public final void t() {
        DownloadFlowAdapter<T> downloadFlowAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.a == null || (downloadFlowAdapter = this.e) == null || (count = downloadFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.a.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.a.setCurrentItem(i, false);
        } else if (currentItem > i) {
            this.a.setCurrentItem(1, false);
        } else {
            this.a.setCurrentItem(currentItem + 1);
        }
        this.a.invalidate();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.e.getCount() < 1) {
            return;
        }
        if (this.e.getCount() == 1) {
            this.k.a(0, false, this.e.b(0));
        } else {
            this.k.a(1, false, this.e.b(1));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            s();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.g.removeMessages(1);
        }
    }

    public void x() {
        DownloadFlowAdapter<T> downloadFlowAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (downloadFlowAdapter = this.e) == null) {
            return;
        }
        downloadFlowAdapter.i();
    }

    public void y(List<T> list) {
        DownloadFlowAdapter<T> downloadFlowAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, list) == null) || list == null || list.isEmpty() || (downloadFlowAdapter = this.e) == null) {
            return;
        }
        downloadFlowAdapter.g(list, this.f);
    }

    public void z(ev4 ev4Var) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, ev4Var) == null) || ev4Var == null || (listViewPager = this.a) == null) {
            return;
        }
        ev4Var.b(listViewPager);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ DownloadFlowView b;

        public d(DownloadFlowView downloadFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = downloadFlowView;
            this.a = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.b.a == null || this.b.e == null) {
                return;
            }
            if (i == 0) {
                if (this.b.j) {
                    this.b.n();
                }
                this.a = false;
            } else if (i != 1) {
            } else {
                if (!this.b.i) {
                    this.b.w();
                    this.b.l();
                }
                this.a = true;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || this.b.b == null || this.b.e == null || this.b.b.getVisibility() != 0 || this.b.h) {
                return;
            }
            int count = this.b.e.getCount();
            if (i == 0) {
                this.b.b.setPosition((count - 3) + f);
            } else if (i == count - 1) {
                this.b.b.setPosition(f);
            } else {
                this.b.b.setPosition((i - 1) + f);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.dv4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.b.e == null) {
                return;
            }
            int count = this.b.e.getCount();
            if (i < 0 || i >= count) {
                return;
            }
            if (this.b.h) {
                this.b.setIndicatorSelected(i);
            }
            if (this.b.k == null) {
                return;
            }
            this.b.k.a(i, this.a, this.b.e.b(i));
        }

        public /* synthetic */ d(DownloadFlowView downloadFlowView, a aVar) {
            this(downloadFlowView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new c(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.l = new e(this, null);
        this.m = new b(this, null);
        this.n = new d(this, null);
        this.o = 3000L;
        o(context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadFlowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
