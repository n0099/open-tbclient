package b.a.r0.s3.h;

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
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d> f25028e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25029f;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f25030a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25031b;

        /* renamed from: c  reason: collision with root package name */
        public View f25032c;

        /* renamed from: d  reason: collision with root package name */
        public View f25033d;

        public a() {
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

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25029f = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d> list = this.f25028e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f25028e.size()) {
                return null;
            }
            return this.f25028e.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public void b(List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f25028e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d> list = this.f25028e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f25029f.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
                aVar = new a();
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.dress_icon);
                aVar.f25030a = headImageView;
                headImageView.setDefaultResource(R.drawable.img_default_100);
                aVar.f25030a.setDefaultBgResource(R.color.CAM_X0204);
                aVar.f25031b = (TextView) view.findViewById(R.id.dress_desc_view);
                aVar.f25032c = view.findViewById(R.id.tip_view);
                aVar.f25033d = view.findViewById(R.id.divider_line);
                view.setTag(aVar);
            }
            if (item != null) {
                aVar.f25030a.startLoad(item.a(), 10, false);
                aVar.f25031b.setText(item.b());
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                if (item.c() - j.l("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), 0L) > 0) {
                    aVar.f25032c.setVisibility(0);
                } else {
                    aVar.f25032c.setVisibility(4);
                }
                if (i2 == getCount() - 1) {
                    aVar.f25033d.setVisibility(8);
                } else {
                    aVar.f25033d.setVisibility(0);
                }
            }
            this.f25029f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
