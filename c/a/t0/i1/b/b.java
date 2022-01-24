package c.a.t0.i1.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.s0.s.q.j0;
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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18327e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f18328f;

    /* renamed from: g  reason: collision with root package name */
    public int f18329g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.t0.i1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1142b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f18330b;

        /* renamed from: c  reason: collision with root package name */
        public View f18331c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18332d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18333e;

        public C1142b() {
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

        public /* synthetic */ C1142b(a aVar) {
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
        this.f18329g = -1;
        this.f18327e = context;
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
            return this.f18328f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18329g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f18328f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f18329g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f18328f;
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
        C1142b c1142b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c1142b = (C1142b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f18327e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c1142b = new C1142b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c1142b.a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c1142b.f18330b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c1142b.f18330b.setDefaultResource(R.drawable.transparent_bg);
                c1142b.f18331c = view.findViewById(R.id.mask);
                c1142b.f18332d = (TextView) view.findViewById(R.id.name);
                c1142b.f18333e = (TextView) view.findViewById(R.id.price);
                view.setTag(c1142b);
            }
            SkinManager.setViewTextColor(c1142b.f18332d, R.color.CAM_X0105, 1);
            if (i2 == this.f18329g) {
                SkinManager.setBackgroundResource(c1142b.f18331c, R.drawable.chx_box_gift_s);
            } else {
                c1142b.f18331c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c1142b.f18332d.setText(item.f13611b);
                c1142b.a.startLoad(item.f13613d, 10, false);
                c1142b.f18330b.startLoad(item.f13616g, 10, false);
                int i3 = item.f13615f;
                if (i3 == 5) {
                    c1142b.f18333e.setVisibility(8);
                } else if (i3 == 3) {
                    c1142b.f18333e.setVisibility(0);
                    c1142b.f18333e.setText(g.b(item.a(), false, item.s));
                } else {
                    c1142b.f18333e.setVisibility(0);
                    c1142b.f18333e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
