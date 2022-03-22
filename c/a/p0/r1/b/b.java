package c.a.p0.r1.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    public int f17941b;

    /* renamed from: c  reason: collision with root package name */
    public ItemViewHolder f17942c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f17943d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f17944e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f17945f;

    public b(Context context, int i, ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), itemViewHolder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17944e = new ArrayList<>();
        this.a = LayoutInflater.from(context);
        this.f17941b = i;
        this.f17942c = itemViewHolder;
    }

    public final void a(ItemViewHolder itemViewHolder, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, itemViewHolder, cVar) == null) || cVar == null || itemViewHolder == null) {
            return;
        }
        itemViewHolder.c(cVar);
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || ListUtils.getCount(this.f17944e) <= 0) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f17944e.iterator();
        while (it.hasNext()) {
            it.next().e(i);
        }
    }

    public void c(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f17943d = list;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f17945f = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f17943d) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? ListUtils.getItem(this.f17943d, i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (ListUtils.getItem(this.f17943d, i) == null) {
                return -1L;
            }
            return ((c) ListUtils.getItem(this.f17943d, i)).hashCode();
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = this.a.inflate(this.f17941b, viewGroup, false);
                ItemViewHolder d2 = this.f17942c.d(view);
                d2.f(this.f17945f);
                view.setTag(d2);
                this.f17944e.add(d2);
            }
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            if (ListUtils.getItem(this.f17943d, i) != null) {
                a(itemViewHolder, this.f17943d.get(i));
            }
            return itemViewHolder.b();
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
