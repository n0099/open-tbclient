package c.a.r0.r1.f.j;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.r1.l.c.a;
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
/* loaded from: classes6.dex */
public class f extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f22892e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.r0.r1.l.c.b> f22893f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<c.a.r0.r1.i.a.b.b> f22894g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f22895h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f22896i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22897j;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22893f = null;
        this.f22894g = null;
        this.f22892e = tbPageContext;
        this.f22895h = cVar;
        this.f22896i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.r0.r1.l.c.b getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c.a.r0.r1.l.c.b> list = this.f22893f;
            if (list == null || list.size() == 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f22893f.get(i2);
        }
        return (c.a.r0.r1.l.c.b) invokeI.objValue;
    }

    public final View b(int i2, View view, ViewGroup viewGroup, c.a.r0.r1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, msgViewHolder})) == null) {
            b msgItemView = msgViewHolder.getMsgItemView();
            a.C1327a d2 = bVar.d();
            d2.m = bVar.b();
            LongSparseArray<c.a.r0.r1.i.a.b.b> longSparseArray = this.f22894g;
            msgItemView.i(this.f22892e.getPageActivity().getBaseContext(), d2, bVar.c(), longSparseArray == null ? null : longSparseArray.get(d2.f23045h), bVar.f(), bVar.g(), i2);
            StatisticItem statisticItem = new StatisticItem(this.f22897j ? "c13865" : "c13863");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            String str = d2.n;
            if (str == null) {
                str = "";
            }
            statisticItem.param("tid", str);
            statisticItem.param("fid", d2.f23042e);
            TiebaStatic.log(statisticItem);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void c(List<c.a.r0.r1.l.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (this.f22893f == null) {
                this.f22893f = new LinkedList();
            }
            this.f22893f.clear();
            this.f22893f.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f22897j = z;
        }
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<c.a.r0.r1.i.a.b.b> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, longSparseArray) == null) {
            if (this.f22894g == null) {
                this.f22894g = new LongSparseArray<>();
            }
            this.f22894g.clear();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                this.f22894g.put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<c.a.r0.r1.l.c.b> list = this.f22893f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            a aVar2 = view != null ? (a) view.getTag() : null;
            if (aVar2 == null) {
                b bVar = new b(this.f22892e, this.f22897j);
                bVar.j(this.f22895h);
                View d2 = bVar.d();
                a aVar3 = new a(this, bVar.d(), bVar);
                d2.setTag(aVar3);
                view = d2;
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            b(i2, view, viewGroup, getItem(i2), aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
