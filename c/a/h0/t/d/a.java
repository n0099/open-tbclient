package c.a.h0.t.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.h0.f;
import c.a.h0.g;
import c.a.h0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<PayChannelEntity> f3754e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3755f;

    /* renamed from: c.a.h0.t.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0145a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3756b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f3757c;

        public C0145a(View view) {
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
            this.a = (ImageView) view.findViewById(g.poly_sdk_bank_icon);
            this.f3756b = (TextView) view.findViewById(g.poly_sdk_bank_name);
            this.f3757c = (ImageView) view.findViewById(g.poly_sdk_bank_select_view);
        }
    }

    public a(Context context) {
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
        this.f3755f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public PayChannelEntity getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f3754e.size()) {
                return null;
            }
            return this.f3754e.get(i2);
        }
        return (PayChannelEntity) invokeI.objValue;
    }

    public void b(List<PayChannelEntity> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f3754e = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PayChannelEntity> list = this.f3754e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            PayChannelEntity item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f3755f).inflate(h.digital_bank_channel_list_item, (ViewGroup) null, false);
                view.setTag(new C0145a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof C0145a)) {
                C0145a c0145a = (C0145a) view.getTag();
                c.a.h0.m.b.b().a(c0145a.a, item.getIcon());
                c0145a.f3756b.setText(item.getDisplayName());
                if (item.getIsSelected() == 1) {
                    c0145a.f3757c.setImageResource(f.channel_checked);
                } else {
                    c0145a.f3757c.setImageResource(f.unchecked);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
