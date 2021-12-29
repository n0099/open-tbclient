package c.a.h0.t.c;

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
import c.a.h0.g;
import c.a.h0.h;
import c.a.h0.r.c;
import c.a.h0.t.c.a;
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
    public List<a.C0144a> f3744e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3745f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3746b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f3747c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f3748d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f3749e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f3750f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f3751g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f3752h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f3753i;

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
            this.a = (TextView) view.findViewById(g.coupon_title);
            this.f3746b = (TextView) view.findViewById(g.coupon_subtitle);
            this.f3747c = (ImageView) view.findViewById(g.select_icon);
            this.f3748d = (TextView) view.findViewById(g.cashersdk_tv_coupon_price);
            this.f3749e = (ImageView) view.findViewById(g.coupon_vip_tag);
            this.f3750f = (LinearLayout) view.findViewById(g.coupon_no_use_item_ll);
            this.f3751g = (LinearLayout) view.findViewById(g.coupon_item_ll);
            this.f3752h = (TextView) view.findViewById(g.coupon_no_use_title);
            this.f3753i = (ImageView) view.findViewById(g.select_no_use_icon);
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
        this.f3745f = context;
    }

    public final String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? new DecimalFormat("0").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0144a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < this.f3744e.size()) {
                return this.f3744e.get(i2);
            }
            return null;
        }
        return (a.C0144a) invokeI.objValue;
    }

    public void c(List<a.C0144a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f3744e = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<a.C0144a> list = this.f3744e;
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
            a.C0144a item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f3745f).inflate(h.coupon_list_item, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                if (item.a == -1) {
                    aVar.f3751g.setVisibility(8);
                    aVar.f3750f.setVisibility(0);
                    aVar.f3752h.setText(item.f3738d);
                    aVar.f3753i.setSelected(item.f3742h == 1);
                } else {
                    aVar.f3751g.setVisibility(0);
                    aVar.f3750f.setVisibility(8);
                    aVar.a.setText(item.f3738d);
                    if (TextUtils.isEmpty(item.f3739e)) {
                        aVar.f3746b.setVisibility(8);
                    } else {
                        aVar.f3746b.setVisibility(0);
                        aVar.f3746b.setText(item.f3739e);
                    }
                    aVar.f3747c.setSelected(item.f3742h == 1);
                    SpannableString spannableString = new SpannableString("￥" + a(item.f3741g.longValue()));
                    spannableString.setSpan(new AbsoluteSizeSpan(c.a(this.f3745f, 14.0f)), 0, 1, 33);
                    aVar.f3748d.setText(spannableString);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
