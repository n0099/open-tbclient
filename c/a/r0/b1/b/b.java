package c.a.r0.b1.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.q0.s.q.j0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f15879e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f15880f;

    /* renamed from: g  reason: collision with root package name */
    public int f15881g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.b1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0758b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15882a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15883b;

        /* renamed from: c  reason: collision with root package name */
        public View f15884c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15885d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15886e;

        public C0758b() {
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

        public /* synthetic */ C0758b(a aVar) {
            this();
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15881g = -1;
        this.f15879e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public j0 getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f15880f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15881g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15880f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15881g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f15880f;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0758b c0758b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c0758b = (C0758b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15879e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c0758b = new C0758b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c0758b.f15882a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c0758b.f15883b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c0758b.f15883b.setDefaultResource(R.drawable.transparent_bg);
                c0758b.f15884c = view.findViewById(R.id.mask);
                c0758b.f15885d = (TextView) view.findViewById(R.id.name);
                c0758b.f15886e = (TextView) view.findViewById(R.id.price);
                view.setTag(c0758b);
            }
            SkinManager.setViewTextColor(c0758b.f15885d, R.color.CAM_X0105, 1);
            if (i2 == this.f15881g) {
                SkinManager.setBackgroundResource(c0758b.f15884c, R.drawable.chx_box_gift_s);
            } else {
                c0758b.f15884c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c0758b.f15885d.setText(item.f14244b);
                c0758b.f15882a.startLoad(item.f14246d, 10, false);
                c0758b.f15883b.startLoad(item.f14249g, 10, false);
                int i3 = item.f14248f;
                if (i3 == 5) {
                    c0758b.f15886e.setVisibility(8);
                } else if (i3 == 3) {
                    c0758b.f15886e.setVisibility(0);
                    c0758b.f15886e.setText(g.b(item.a(), false, item.s));
                } else {
                    c0758b.f15886e.setVisibility(0);
                    c0758b.f15886e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
