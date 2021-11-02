package b.a.r0.b1.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import b.a.q0.s.q.j0;
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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f14900e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f14901f;

    /* renamed from: g  reason: collision with root package name */
    public int f14902g;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.r0.b1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0752b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f14903a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14904b;

        /* renamed from: c  reason: collision with root package name */
        public View f14905c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14906d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14907e;

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
        this.f14902g = -1;
        this.f14900e = context;
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
            return this.f14901f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14902g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f14901f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f14902g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f14901f;
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
                view = LayoutInflater.from(this.f14900e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c0752b = new C0752b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c0752b.f14903a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c0752b.f14904b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c0752b.f14904b.setDefaultResource(R.drawable.transparent_bg);
                c0752b.f14905c = view.findViewById(R.id.mask);
                c0752b.f14906d = (TextView) view.findViewById(R.id.name);
                c0752b.f14907e = (TextView) view.findViewById(R.id.price);
                view.setTag(c0752b);
            }
            SkinManager.setViewTextColor(c0752b.f14906d, R.color.CAM_X0105, 1);
            if (i2 == this.f14902g) {
                SkinManager.setBackgroundResource(c0752b.f14905c, R.drawable.chx_box_gift_s);
            } else {
                c0752b.f14905c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c0752b.f14906d.setText(item.f13359b);
                c0752b.f14903a.startLoad(item.f13361d, 10, false);
                c0752b.f14904b.startLoad(item.f13364g, 10, false);
                int i3 = item.f13363f;
                if (i3 == 5) {
                    c0752b.f14907e.setVisibility(8);
                } else if (i3 == 3) {
                    c0752b.f14907e.setVisibility(0);
                    c0752b.f14907e.setText(g.b(item.a(), false, item.s));
                } else {
                    c0752b.f14907e.setVisibility(0);
                    c0752b.f14907e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
