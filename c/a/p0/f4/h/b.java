package c.a.p0.f4.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f15109b;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15110b;

        /* renamed from: c  reason: collision with root package name */
        public View f15111c;

        /* renamed from: d  reason: collision with root package name */
        public View f15112d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15109b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<d> list = this.a;
            if (list == null || list.size() <= 0 || i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (d) invokeI.objValue;
    }

    public void b(List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            d item = getItem(i);
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15109b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0246, viewGroup, false);
                aVar = new a();
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f09083c);
                aVar.a = headImageView;
                headImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
                aVar.a.setDefaultBgResource(R.color.CAM_X0204);
                aVar.f15110b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09083b);
                aVar.f15111c = view.findViewById(R.id.obfuscated_res_0x7f092025);
                aVar.f15112d = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
                view.setTag(aVar);
            }
            if (item != null) {
                aVar.a.J(item.a(), 10, false);
                aVar.f15110b.setText(item.b());
                c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
                if (item.c() - k.m("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), 0L) > 0) {
                    aVar.f15111c.setVisibility(0);
                } else {
                    aVar.f15111c.setVisibility(4);
                }
                if (i == getCount() - 1) {
                    aVar.f15112d.setVisibility(8);
                } else {
                    aVar.f15112d.setVisibility(0);
                }
            }
            this.f15109b.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
