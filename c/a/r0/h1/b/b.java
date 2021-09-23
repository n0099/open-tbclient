package c.a.r0.h1.b;

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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f18928e;

    /* renamed from: f  reason: collision with root package name */
    public int f18929f;

    /* renamed from: g  reason: collision with root package name */
    public ItemViewHolder f18930g;

    /* renamed from: h  reason: collision with root package name */
    public List<c> f18931h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f18932i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f18933j;

    public b(Context context, int i2, ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), itemViewHolder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18932i = new ArrayList<>();
        this.f18928e = LayoutInflater.from(context);
        this.f18929f = i2;
        this.f18930g = itemViewHolder;
    }

    public final void a(ItemViewHolder itemViewHolder, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, itemViewHolder, cVar) == null) || cVar == null || itemViewHolder == null) {
            return;
        }
        itemViewHolder.bindDataToView(cVar);
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || ListUtils.getCount(this.f18932i) <= 0) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f18932i.iterator();
        while (it.hasNext()) {
            it.next().onChangeSkinType(i2);
        }
    }

    public void c(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f18931h = list;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f18933j = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f18931h) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? ListUtils.getItem(this.f18931h, i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (ListUtils.getItem(this.f18931h, i2) == null) {
                return -1L;
            }
            return ((c) ListUtils.getItem(this.f18931h, i2)).hashCode();
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = this.f18928e.inflate(this.f18929f, viewGroup, false);
                ItemViewHolder createItemViewHolder = this.f18930g.createItemViewHolder(view);
                createItemViewHolder.setOnClickListener(this.f18933j);
                view.setTag(createItemViewHolder);
                this.f18932i.add(createItemViewHolder);
            }
            ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
            if (ListUtils.getItem(this.f18931h, i2) != null) {
                a(itemViewHolder, this.f18931h.get(i2));
            }
            return itemViewHolder.getView();
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
