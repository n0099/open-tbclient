package c.a.r0.w0.q2;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import c.a.r0.p1.o.l.i;
import c.a.r0.w0.h1.g;
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
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<c.a.e.l.e.a<?, ?>> f27677a;

    /* renamed from: b  reason: collision with root package name */
    public final b f27678b;

    /* renamed from: c  reason: collision with root package name */
    public final TbPageContext<?> f27679c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f27680d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoMiddlePageViewModel f27681e;

    /* renamed from: c.a.r0.w0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1299a<T> implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27682e;

        public C1299a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27682e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Integer pos) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pos) == null) {
                List<BaseCardInfo> value = this.f27682e.b().getVideoDataList().getValue();
                if (value == null) {
                    value = new ArrayList<>();
                }
                Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: mutableListOf()");
                a aVar = this.f27682e;
                Intrinsics.checkExpressionValueIsNotNull(pos, "pos");
                aVar.e(pos.intValue(), value);
                this.f27682e.a().getListAdapter().notifyDataSetChanged();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, videoMiddlePageViewModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27679c = tbPageContext;
        this.f27680d = bdTypeRecyclerView;
        this.f27681e = videoMiddlePageViewModel;
        this.f27677a = new ArrayList();
        TbPageContext<?> tbPageContext2 = this.f27679c;
        BdUniqueId bdUniqueId = g.K;
        Intrinsics.checkExpressionValueIsNotNull(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        b bVar = new b(tbPageContext2, bdUniqueId, this.f27681e);
        this.f27678b = bVar;
        this.f27677a.add(bVar);
        this.f27680d.addAdapters(this.f27677a);
        MutableLiveData<Integer> curPlayingVideoPos = this.f27681e.getCurPlayingVideoPos();
        Activity pageActivity = this.f27679c.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        curPlayingVideoPos.observe((LifecycleOwner) pageActivity, new C1299a(this));
    }

    public final BdTypeRecyclerView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27680d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27681e : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27678b.onDestroy();
        }
    }

    public final void d(List<? extends BaseCardInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            Integer value = this.f27681e.getCurPlayingVideoPos().getValue();
            if (value == null) {
                value = 0;
            }
            e(value.intValue(), list);
            this.f27680d.setData(list);
        }
    }

    public final void e(int i2, List<? extends BaseCardInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, list) == null) || i2 >= list.size()) {
            return;
        }
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            if (list.get(i3) instanceof i) {
                BaseCardInfo baseCardInfo = list.get(i3);
                if (baseCardInfo != null) {
                    ((i) baseCardInfo).setAutoPlay(i3 == i2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.lego.card.view.IPassAutoPlayData");
                }
            }
            i3++;
        }
    }

    public final void f() {
        List<BaseCardInfo> value;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (value = this.f27681e.getVideoDataList().getValue()) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: return");
        for (BaseCardInfo baseCardInfo : value) {
            if (baseCardInfo instanceof i) {
                ((i) baseCardInfo).setAutoPlay(false);
            }
        }
        this.f27680d.setData(value);
    }
}
