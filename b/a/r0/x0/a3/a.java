package b.a.r0.x0.a3;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.a.r0.q1.o.l.i;
import b.a.r0.x0.r1.g;
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
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b.a.e.l.e.a<?, ?>> f25509a;

    /* renamed from: b  reason: collision with root package name */
    public final b f25510b;

    /* renamed from: c  reason: collision with root package name */
    public final TbPageContext<?> f25511c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f25512d;

    /* renamed from: e  reason: collision with root package name */
    public final VideoMiddlePageViewModel f25513e;

    /* renamed from: b.a.r0.x0.a3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1255a<T> implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25514e;

        public C1255a(a aVar) {
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
            this.f25514e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Integer pos) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pos) == null) {
                List<BaseCardInfo> value = this.f25514e.b().getVideoDataList().getValue();
                if (value == null) {
                    value = new ArrayList<>();
                }
                Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: mutableListOf()");
                a aVar = this.f25514e;
                Intrinsics.checkExpressionValueIsNotNull(pos, "pos");
                aVar.e(pos.intValue(), value);
                this.f25514e.a().getListAdapter().notifyDataSetChanged();
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
        this.f25511c = tbPageContext;
        this.f25512d = bdTypeRecyclerView;
        this.f25513e = videoMiddlePageViewModel;
        this.f25509a = new ArrayList();
        TbPageContext<?> tbPageContext2 = this.f25511c;
        BdUniqueId bdUniqueId = g.K;
        Intrinsics.checkExpressionValueIsNotNull(bdUniqueId, "VideoAggregationData.TYPE_VIDEO_AGGREGATION");
        b bVar = new b(tbPageContext2, bdUniqueId, this.f25513e);
        this.f25510b = bVar;
        this.f25509a.add(bVar);
        this.f25512d.addAdapters(this.f25509a);
        MutableLiveData<Integer> curPlayingVideoPos = this.f25513e.getCurPlayingVideoPos();
        Activity pageActivity = this.f25511c.getPageActivity();
        if (pageActivity == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        curPlayingVideoPos.observe((LifecycleOwner) pageActivity, new C1255a(this));
    }

    public final BdTypeRecyclerView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25512d : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25513e : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25510b.onDestroy();
        }
    }

    public final void d(List<? extends BaseCardInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            Integer value = this.f25513e.getCurPlayingVideoPos().getValue();
            if (value == null) {
                value = 0;
            }
            e(value.intValue(), list);
            this.f25512d.setData(list);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (value = this.f25513e.getVideoDataList().getValue()) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoDataList.value ?: return");
        for (BaseCardInfo baseCardInfo : value) {
            if (baseCardInfo instanceof i) {
                ((i) baseCardInfo).setAutoPlay(false);
            }
        }
        this.f25512d.setData(value);
    }
}
