package c.a.r0.a1.b;

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
    public Context f15713e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f15714f;

    /* renamed from: g  reason: collision with root package name */
    public int f15715g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.a1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0752b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15716a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15717b;

        /* renamed from: c  reason: collision with root package name */
        public View f15718c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15719d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15720e;

        public C0752b() {
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

        public /* synthetic */ C0752b(a aVar) {
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
        this.f15715g = -1;
        this.f15713e = context;
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
            return this.f15714f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15715g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15714f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15715g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f15714f;
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
        C0752b c0752b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c0752b = (C0752b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15713e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c0752b = new C0752b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c0752b.f15716a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c0752b.f15717b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c0752b.f15717b.setDefaultResource(R.drawable.transparent_bg);
                c0752b.f15718c = view.findViewById(R.id.mask);
                c0752b.f15719d = (TextView) view.findViewById(R.id.name);
                c0752b.f15720e = (TextView) view.findViewById(R.id.price);
                view.setTag(c0752b);
            }
            SkinManager.setViewTextColor(c0752b.f15719d, R.color.CAM_X0105, 1);
            if (i2 == this.f15715g) {
                SkinManager.setBackgroundResource(c0752b.f15718c, R.drawable.chx_box_gift_s);
            } else {
                c0752b.f15718c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c0752b.f15719d.setText(item.f14221b);
                c0752b.f15716a.startLoad(item.f14223d, 10, false);
                c0752b.f15717b.startLoad(item.f14226g, 10, false);
                int i3 = item.f14225f;
                if (i3 == 5) {
                    c0752b.f15720e.setVisibility(8);
                } else if (i3 == 3) {
                    c0752b.f15720e.setVisibility(0);
                    c0752b.f15720e.setText(g.b(item.a(), false, item.s));
                } else {
                    c0752b.f15720e.setVisibility(0);
                    c0752b.f15720e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
