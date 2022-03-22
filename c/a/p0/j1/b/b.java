package c.a.p0.j1.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.o0.r.r.j0;
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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<j0> f15576b;

    /* renamed from: c  reason: collision with root package name */
    public int f15577c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.j1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1173b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15578b;

        /* renamed from: c  reason: collision with root package name */
        public View f15579c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15580d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15581e;

        public C1173b() {
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

        public /* synthetic */ C1173b(a aVar) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15577c = -1;
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public j0 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.f15576b.get(i);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15577c : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15576b = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f15577c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f15576b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1173b c1173b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c1173b = (C1173b) view.getTag();
            } else {
                view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0383, (ViewGroup) null);
                c1173b = new C1173b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e69);
                c1173b.a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09139a);
                c1173b.f15578b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
                c1173b.f15578b.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
                c1173b.f15579c = view.findViewById(R.id.obfuscated_res_0x7f0913b0);
                c1173b.f15580d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
                c1173b.f15581e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918ea);
                view.setTag(c1173b);
            }
            SkinManager.setViewTextColor(c1173b.f15580d, R.color.CAM_X0105, 1);
            if (i == this.f15577c) {
                SkinManager.setBackgroundResource(c1173b.f15579c, R.drawable.obfuscated_res_0x7f080459);
            } else {
                c1173b.f15579c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i);
            if (item != null) {
                c1173b.f15580d.setText(item.f10890b);
                c1173b.a.J(item.f10892d, 10, false);
                c1173b.f15578b.J(item.f10895g, 10, false);
                int i2 = item.f10894f;
                if (i2 == 5) {
                    c1173b.f15581e.setVisibility(8);
                } else if (i2 == 3) {
                    c1173b.f15581e.setVisibility(0);
                    c1173b.f15581e.setText(g.b(item.a(), false, item.s));
                } else {
                    c1173b.f15581e.setVisibility(0);
                    c1173b.f15581e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
