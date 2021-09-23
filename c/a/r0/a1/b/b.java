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
    public Context f15723e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f15724f;

    /* renamed from: g  reason: collision with root package name */
    public int f15725g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.a1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0750b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15726a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15727b;

        /* renamed from: c  reason: collision with root package name */
        public View f15728c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15729d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15730e;

        public C0750b() {
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

        public /* synthetic */ C0750b(a aVar) {
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
        this.f15725g = -1;
        this.f15723e = context;
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
            return this.f15724f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15725g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15724f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15725g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f15724f;
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
        C0750b c0750b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c0750b = (C0750b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15723e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c0750b = new C0750b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c0750b.f15726a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c0750b.f15727b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c0750b.f15727b.setDefaultResource(R.drawable.transparent_bg);
                c0750b.f15728c = view.findViewById(R.id.mask);
                c0750b.f15729d = (TextView) view.findViewById(R.id.name);
                c0750b.f15730e = (TextView) view.findViewById(R.id.price);
                view.setTag(c0750b);
            }
            SkinManager.setViewTextColor(c0750b.f15729d, R.color.CAM_X0105, 1);
            if (i2 == this.f15725g) {
                SkinManager.setBackgroundResource(c0750b.f15728c, R.drawable.chx_box_gift_s);
            } else {
                c0750b.f15728c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c0750b.f15729d.setText(item.f14221b);
                c0750b.f15726a.startLoad(item.f14223d, 10, false);
                c0750b.f15727b.startLoad(item.f14226g, 10, false);
                int i3 = item.f14225f;
                if (i3 == 5) {
                    c0750b.f15730e.setVisibility(8);
                } else if (i3 == 3) {
                    c0750b.f15730e.setVisibility(0);
                    c0750b.f15730e.setText(g.b(item.a(), false, item.s));
                } else {
                    c0750b.f15730e.setVisibility(0);
                    c0750b.f15730e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
