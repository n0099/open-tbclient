package b.a.e0.t.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e0.g;
import b.a.e0.h;
import b.a.e0.r.c;
import b.a.e0.t.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<a.C0060a> f2783e;

    /* renamed from: f  reason: collision with root package name */
    public Context f2784f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f2785a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f2786b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f2787c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f2788d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f2789e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f2790f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f2791g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f2792h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f2793i;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2785a = (TextView) view.findViewById(g.coupon_title);
            this.f2786b = (TextView) view.findViewById(g.coupon_subtitle);
            this.f2787c = (ImageView) view.findViewById(g.select_icon);
            this.f2788d = (TextView) view.findViewById(g.cashersdk_tv_coupon_price);
            this.f2789e = (ImageView) view.findViewById(g.coupon_vip_tag);
            this.f2790f = (LinearLayout) view.findViewById(g.coupon_no_use_item_ll);
            this.f2791g = (LinearLayout) view.findViewById(g.coupon_item_ll);
            this.f2792h = (TextView) view.findViewById(g.coupon_no_use_title);
            this.f2793i = (ImageView) view.findViewById(g.select_no_use_icon);
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
        this.f2784f = context;
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? new DecimalFormat("0").format((j * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0060a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < this.f2783e.size()) {
                return this.f2783e.get(i2);
            }
            return null;
        }
        return (a.C0060a) invokeI.objValue;
    }

    public void c(List<a.C0060a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f2783e = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<a.C0060a> list = this.f2783e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            a.C0060a item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f2784f).inflate(h.coupon_list_item, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                if (item.f2774a == -1) {
                    aVar.f2791g.setVisibility(8);
                    aVar.f2790f.setVisibility(0);
                    aVar.f2792h.setText(item.f2777d);
                    aVar.f2793i.setSelected(item.f2781h == 1);
                } else {
                    aVar.f2791g.setVisibility(0);
                    aVar.f2790f.setVisibility(8);
                    aVar.f2785a.setText(item.f2777d);
                    if (TextUtils.isEmpty(item.f2778e)) {
                        aVar.f2786b.setVisibility(8);
                    } else {
                        aVar.f2786b.setVisibility(0);
                        aVar.f2786b.setText(item.f2778e);
                    }
                    aVar.f2787c.setSelected(item.f2781h == 1);
                    SpannableString spannableString = new SpannableString("￥" + a(item.f2780g.longValue()));
                    spannableString.setSpan(new AbsoluteSizeSpan(c.a(this.f2784f, 14.0f)), 0, 1, 33);
                    aVar.f2788d.setText(spannableString);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
