package c.a.r0.d1.b3;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final BdTypeRecyclerView f15305b;

    /* renamed from: c  reason: collision with root package name */
    public final VideoMiddlePageViewModel f15306c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.d.m.e.a<?, ?>> f15307d;

    /* renamed from: e  reason: collision with root package name */
    public final q f15308e;

    public p(TbPageContext<?> pageContext, BdTypeRecyclerView recyclerView, VideoMiddlePageViewModel viewModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, recyclerView, viewModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.a = pageContext;
        this.f15305b = recyclerView;
        this.f15306c = viewModel;
        this.f15307d = new ArrayList();
        TbPageContext<?> tbPageContext = this.a;
        BdUniqueId TYPE_VIDEO_AGGREGATION = c.a.r0.d1.s1.g.K;
        Intrinsics.checkNotNullExpressionValue(TYPE_VIDEO_AGGREGATION, "TYPE_VIDEO_AGGREGATION");
        q qVar = new q(tbPageContext, TYPE_VIDEO_AGGREGATION, this.f15306c);
        this.f15308e = qVar;
        this.f15307d.add(qVar);
        this.f15305b.addAdapters(this.f15307d);
        MutableLiveData<Integer> curPlayingVideoPos = this.f15306c.getCurPlayingVideoPos();
        Activity pageActivity = this.a.getPageActivity();
        if (pageActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        curPlayingVideoPos.observe((LifecycleOwner) pageActivity, new Observer() { // from class: c.a.r0.d1.b3.m
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    p.a(p.this, (Integer) obj);
                }
            }
        });
    }

    public static final void a(p this$0, Integer pos) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, pos) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            List<BaseCardInfo> value = this$0.c().getVideoDataList().getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            Intrinsics.checkNotNullExpressionValue(pos, "pos");
            this$0.f(pos.intValue(), value);
            this$0.b().getListAdapter().notifyDataSetChanged();
        }
    }

    public final BdTypeRecyclerView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15305b : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15306c : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15308e.onDestroy();
        }
    }

    public final void e(List<? extends BaseCardInfo> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Integer value = this.f15306c.getCurPlayingVideoPos().getValue();
            if (value == null) {
                value = 0;
            }
            f(value.intValue(), data);
            this.f15305b.setData(data);
        }
    }

    public final void f(int i2, List<? extends BaseCardInfo> dataList) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(1048580, this, i2, dataList) != null) {
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (i2 >= dataList.size() || dataList.size() - 1 < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (dataList.get(i3) instanceof c.a.r0.w1.o.l.i) {
                ((c.a.r0.w1.o.l.i) dataList.get(i3)).setAutoPlay(i3 == i2);
            }
            if (i4 > size) {
                return;
            }
            i3 = i4;
        }
    }

    public final void g() {
        List<BaseCardInfo> value;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (value = this.f15306c.getVideoDataList().getValue()) == null) {
            return;
        }
        for (BaseCardInfo baseCardInfo : value) {
            if (baseCardInfo instanceof c.a.r0.w1.o.l.i) {
                ((c.a.r0.w1.o.l.i) baseCardInfo).setAutoPlay(false);
            }
        }
        this.f15305b.setData(value);
    }
}
