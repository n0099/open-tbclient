package b.a.r0.o1.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.view.LabelSettingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LabelSettingView f21973e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.o1.b.b f21974f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.a.r0.o1.b.a> f21975g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f21976h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f21977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21978f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21978f = bVar;
            this.f21977e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.r0.o1.b.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (item = this.f21978f.getItem(this.f21977e)) == null) {
                return;
            }
            item.f21982c = !item.f21982c;
            if (view instanceof TextView) {
                this.f21978f.d((TextView) view, item);
            }
            if (item.f21982c) {
                this.f21978f.f21976h.add(Integer.valueOf(item.f21980a));
            } else {
                this.f21978f.f21976h.remove(Integer.valueOf(item.f21980a));
            }
            if (this.f21978f.f21973e != null) {
                this.f21978f.f21973e.changeCompleteStatu(ListUtils.getCount(this.f21978f.f21976h) > 0);
            }
        }
    }

    /* renamed from: b.a.r0.o1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1075b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f21979a;

        public C1075b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b(LabelSettingView labelSettingView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {labelSettingView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21973e = labelSettingView;
        this.f21976h = new ArrayList();
    }

    public final void d(TextView textView, b.a.r0.o1.b.a aVar) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, textView, aVar) == null) || aVar == null) {
            return;
        }
        String str = aVar.f21981b;
        if (!StringUtils.isNull(str) && aVar.f21981b.length() > 4) {
            str = aVar.f21981b.substring(0, 3) + "...";
        }
        textView.setText(str);
        if (aVar.f21982c) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            drawable = SkinManager.getDrawable(R.drawable.icon_lable_confirm_s);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            drawable = SkinManager.getDrawable(R.drawable.icon_lable_confirm_n);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public b.a.r0.o1.b.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (b.a.r0.o1.b.a) ListUtils.getItem(this.f21975g, i2) : (b.a.r0.o1.b.a) invokeI.objValue;
    }

    public List<Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.r0.o1.b.b bVar = this.f21974f;
            return bVar == null ? new ArrayList() : bVar.a();
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21976h : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f21975g) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            b.a.r0.o1.b.a item = getItem(i2);
            if (item == null) {
                return 0L;
            }
            return item.f21980a;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1075b c1075b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f21973e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
                c1075b = new C1075b(this);
                c1075b.f21979a = (TextView) view;
                view.setTag(c1075b);
            } else {
                c1075b = (C1075b) view.getTag();
            }
            c1075b.f21979a.setOnClickListener(new a(this, i2));
            d(c1075b.f21979a, getItem(i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(b.a.r0.o1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f21974f = bVar;
        this.f21975g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f21976h = new ArrayList(bVar.a());
    }
}
