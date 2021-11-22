package b.a.r0.y1.c.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import b.a.r0.y1.c.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.memberCenter.index.BasicSeperateBaMemberItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f28855e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f28856f;

    /* renamed from: b.a.r0.y1.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1412a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BasicSeperateBaMemberItemView f28857a;

        public C1412a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, ArrayList<o> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28855e = tbPageContext;
        this.f28856f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<o> list = this.f28856f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            List<o> list = this.f28856f;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<o> list = this.f28856f;
            if (list == null) {
                return 0L;
            }
            return list.get(i2).d();
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        BasicSeperateBaMemberItemView basicSeperateBaMemberItemView;
        C1412a c1412a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1412a = new C1412a();
                BasicSeperateBaMemberItemView basicSeperateBaMemberItemView2 = new BasicSeperateBaMemberItemView(this.f28855e.getPageActivity());
                c1412a.f28857a = basicSeperateBaMemberItemView2;
                basicSeperateBaMemberItemView2.setTag(c1412a);
                basicSeperateBaMemberItemView = basicSeperateBaMemberItemView2;
            } else {
                basicSeperateBaMemberItemView = view;
                c1412a = (C1412a) view.getTag();
            }
            c1412a.f28857a.renderView(this.f28856f.get(i2));
            b.a.q0.v0.a.a(this.f28855e, basicSeperateBaMemberItemView);
            return basicSeperateBaMemberItemView;
        }
        return (View) invokeILL.objValue;
    }
}
