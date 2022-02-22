package c.a.u0.h2.c.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.adapter.CooperatePrivilegeViewHolder;
import com.baidu.tieba.memberCenter.index.adapter.ExpandViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18322e;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragmentActivity f18323f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.u0.h2.c.k.f> f18324g;

    public f(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18323f = baseFragmentActivity;
        this.f18322e = baseFragmentActivity.getActivity();
        this.f18324g = new ArrayList();
    }

    public View a(c.a.u0.h2.c.k.f fVar, View view, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, fVar, view, viewGroup)) == null) {
            CooperatePrivilegeViewHolder cooperatePrivilegeViewHolder = null;
            r2 = null;
            ExpandViewHolder expandViewHolder = null;
            cooperatePrivilegeViewHolder = null;
            if (fVar.f()) {
                if (view != null && (view.getTag() instanceof ExpandViewHolder)) {
                    expandViewHolder = (ExpandViewHolder) view.getTag();
                }
                if (expandViewHolder == null) {
                    view = LayoutInflater.from(this.f18322e).inflate(R.layout.index_expand_item, viewGroup, false);
                    expandViewHolder = new ExpandViewHolder(view, this.f18323f);
                    view.setTag(expandViewHolder);
                }
                expandViewHolder.renderView(fVar);
            } else {
                if (view != null && (view.getTag() instanceof CooperatePrivilegeViewHolder)) {
                    cooperatePrivilegeViewHolder = (CooperatePrivilegeViewHolder) view.getTag();
                }
                if (cooperatePrivilegeViewHolder == null) {
                    view = LayoutInflater.from(this.f18322e).inflate(R.layout.index_cooperate_item, viewGroup, false);
                    cooperatePrivilegeViewHolder = new CooperatePrivilegeViewHolder(view, this.f18323f);
                    view.setTag(cooperatePrivilegeViewHolder);
                }
                cooperatePrivilegeViewHolder.renderView(fVar);
            }
            return view;
        }
        return (View) invokeLLL.objValue;
    }

    public List<c.a.u0.h2.c.k.f> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18324g : (List) invokeV.objValue;
    }

    public void c(List<c.a.u0.h2.c.k.f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f18324g = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<c.a.u0.h2.c.k.f> list = this.f18324g;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f18324g.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            c.a.u0.h2.c.k.f fVar = this.f18324g.get(i2);
            return fVar != null ? a(fVar, view, viewGroup) : view;
        }
        return (View) invokeILL.objValue;
    }
}
