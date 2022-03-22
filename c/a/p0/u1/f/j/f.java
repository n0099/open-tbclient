package c.a.p0.u1.f.j;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.u1.l.c.a;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<OfficialBarFeedActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.u1.l.c.b> f18728b;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<c.a.p0.u1.i.a.b.b> f18729c;

    /* renamed from: d  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f18730d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f18731e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18732f;

    /* loaded from: classes2.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, view, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18728b = null;
        this.f18729c = null;
        this.a = tbPageContext;
        this.f18730d = cVar;
        this.f18731e = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.p0.u1.l.c.b getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<c.a.p0.u1.l.c.b> list = this.f18728b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.f18728b.get(i);
        }
        return (c.a.p0.u1.l.c.b) invokeI.objValue;
    }

    public final View b(int i, View view, ViewGroup viewGroup, c.a.p0.u1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, msgViewHolder})) == null) {
            b c2 = msgViewHolder.c();
            a.C1417a d2 = bVar.d();
            d2.m = bVar.b();
            LongSparseArray<c.a.p0.u1.i.a.b.b> longSparseArray = this.f18729c;
            c2.k(this.a.getPageActivity().getBaseContext(), d2, bVar.c(), longSparseArray == null ? null : longSparseArray.get(d2.f18840h), bVar.e(), bVar.g(), i);
            StatisticItem statisticItem = new StatisticItem(this.f18732f ? "c13865" : "c13863");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            String str = d2.n;
            if (str == null) {
                str = "";
            }
            statisticItem.param("tid", str);
            statisticItem.param("fid", d2.f18837e);
            TiebaStatic.log(statisticItem);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void c(List<c.a.p0.u1.l.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (this.f18728b == null) {
                this.f18728b = new LinkedList();
            }
            this.f18728b.clear();
            this.f18728b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f18732f = z;
        }
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<c.a.p0.u1.i.a.b.b> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, longSparseArray) == null) {
            if (this.f18729c == null) {
                this.f18729c = new LongSparseArray<>();
            }
            this.f18729c.clear();
            for (int i = 0; i < longSparseArray.size(); i++) {
                this.f18729c.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<c.a.p0.u1.l.c.b> list = this.f18728b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            a aVar2 = view != null ? (a) view.getTag() : null;
            if (aVar2 == null) {
                b bVar = new b(this.a, this.f18732f);
                bVar.l(this.f18730d);
                View d2 = bVar.d();
                a aVar3 = new a(this, bVar.d(), bVar);
                d2.setTag(aVar3);
                view = d2;
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            b(i, view, viewGroup, getItem(i), aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
