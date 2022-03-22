package c.a.e0.k.e;

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
import c.a.e0.i.c;
import c.a.e0.k.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
    public List<a.C0134a> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2879b;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f2880b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f2881c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f2882d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f2883e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f2884f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f2885g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f2886h;
        public ImageView i;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090703);
            this.f2880b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090702);
            this.f2881c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c77);
            this.f2882d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090594);
            this.f2883e = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090704);
            this.f2884f = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090700);
            this.f2885g = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0906fd);
            this.f2886h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090701);
            this.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c81);
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
        this.f2879b = context;
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? new DecimalFormat("0").format((j * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0134a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (a.C0134a) invokeI.objValue;
    }

    public void c(List<a.C0134a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<a.C0134a> list = this.a;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            a.C0134a item = getItem(i);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f2879b).inflate(R.layout.obfuscated_res_0x7f0d0207, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                if (item.a == -1) {
                    aVar.f2885g.setVisibility(8);
                    aVar.f2884f.setVisibility(0);
                    aVar.f2886h.setText(item.f2874d);
                    aVar.i.setSelected(item.f2878h == 1);
                } else {
                    aVar.f2885g.setVisibility(0);
                    aVar.f2884f.setVisibility(8);
                    aVar.a.setText(item.f2874d);
                    if (TextUtils.isEmpty(item.f2875e)) {
                        aVar.f2880b.setVisibility(8);
                    } else {
                        aVar.f2880b.setVisibility(0);
                        aVar.f2880b.setText(item.f2875e);
                    }
                    aVar.f2881c.setSelected(item.f2878h == 1);
                    SpannableString spannableString = new SpannableString("￥" + a(item.f2877g.longValue()));
                    spannableString.setSpan(new AbsoluteSizeSpan(c.a(this.f2879b, 14.0f)), 0, 1, 33);
                    aVar.f2882d.setText(spannableString);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
