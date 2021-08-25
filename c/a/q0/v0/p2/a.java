package c.a.q0.v0.p2;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import c.a.q0.o1.o.l.i;
import c.a.q0.v0.h1.g;
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
    public final List<c.a.e.l.e.a<?, ?>> f26968a;

    /* renamed from: b  reason: collision with root package name */
    public final b f26969b;

    /* renamed from: c  reason: collision with root package name */
    public final TbPageContext<?> f26970c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f26971d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoMiddlePageViewModel f26972e;

    /* renamed from: c.a.q0.v0.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1262a<T> implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26973e;

        public C1262a(a aVar) {
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
            this.f26973e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Integer pos) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pos) == null) {
                List<BaseCardInfo> value = this.f26973e.b().getVideoDataList().getValue();
                if (value == null) {
                    value = new ArrayList<>();
                }
                Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: mutableListOf()");
                a aVar = this.f26973e;
                Intrinsics.checkExpressionValueIsNotNull(pos, "pos");
                aVar.e(pos.intValue(), value);
                this.f26973e.a().getListAdapter().notifyDataSetChanged();
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
        this.f26970c = tbPageContext;
        this.f26971d = bdTypeRecyclerView;
        this.f26972e = videoMiddlePageViewModel;
        this.f26968a = new ArrayList();
        TbPageContext<?> tbPageContext2 = this.f26970c;
        BdUniqueId bdUniqueId = g.K;
        Intrinsics.checkExpressionValueIsNotNull(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        b bVar = new b(tbPageContext2, bdUniqueId, this.f26972e);
        this.f26969b = bVar;
        this.f26968a.add(bVar);
        this.f26971d.addAdapters(this.f26968a);
        MutableLiveData<Integer> curPlayingVideoPos = this.f26972e.getCurPlayingVideoPos();
        Activity pageActivity = this.f26970c.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        curPlayingVideoPos.observe((LifecycleOwner) pageActivity, new C1262a(this));
    }

    public final BdTypeRecyclerView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26971d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26972e : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26969b.onDestroy();
        }
    }

    public final void d(List<? extends BaseCardInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            Integer value = this.f26972e.getCurPlayingVideoPos().getValue();
            if (value == null) {
                value = 0;
            }
            e(value.intValue(), list);
            this.f26971d.setData(list);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (value = this.f26972e.getVideoDataList().getValue()) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: return");
        for (BaseCardInfo baseCardInfo : value) {
            if (baseCardInfo instanceof i) {
                ((i) baseCardInfo).setAutoPlay(false);
            }
        }
        this.f26971d.setData(value);
    }
}
