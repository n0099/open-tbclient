package c.a.r0.o1.a;

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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LabelSettingView f23111e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.o1.b.b f23112f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.r0.o1.b.a> f23113g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f23114h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f23115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f23116f;

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
            this.f23116f = bVar;
            this.f23115e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.r0.o1.b.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (item = this.f23116f.getItem(this.f23115e)) == null) {
                return;
            }
            item.f23120c = !item.f23120c;
            if (view instanceof TextView) {
                this.f23116f.d((TextView) view, item);
            }
            if (item.f23120c) {
                this.f23116f.f23114h.add(Integer.valueOf(item.f23118a));
            } else {
                this.f23116f.f23114h.remove(Integer.valueOf(item.f23118a));
            }
            if (this.f23116f.f23111e != null) {
                this.f23116f.f23111e.changeCompleteStatu(ListUtils.getCount(this.f23116f.f23114h) > 0);
            }
        }
    }

    /* renamed from: c.a.r0.o1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1078b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23117a;

        public C1078b(b bVar) {
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
        this.f23111e = labelSettingView;
        this.f23114h = new ArrayList();
    }

    public final void d(TextView textView, c.a.r0.o1.b.a aVar) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, textView, aVar) == null) || aVar == null) {
            return;
        }
        String str = aVar.f23119b;
        if (!StringUtils.isNull(str) && aVar.f23119b.length() > 4) {
            str = aVar.f23119b.substring(0, 3) + "...";
        }
        textView.setText(str);
        if (aVar.f23120c) {
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
    public c.a.r0.o1.b.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (c.a.r0.o1.b.a) ListUtils.getItem(this.f23113g, i2) : (c.a.r0.o1.b.a) invokeI.objValue;
    }

    public List<Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.o1.b.b bVar = this.f23112f;
            return bVar == null ? new ArrayList() : bVar.a();
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23114h : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f23113g) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            c.a.r0.o1.b.a item = getItem(i2);
            if (item == null) {
                return 0L;
            }
            return item.f23118a;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1078b c1078b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f23111e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
                c1078b = new C1078b(this);
                c1078b.f23117a = (TextView) view;
                view.setTag(c1078b);
            } else {
                c1078b = (C1078b) view.getTag();
            }
            c1078b.f23117a.setOnClickListener(new a(this, i2));
            d(c1078b.f23117a, getItem(i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(c.a.r0.o1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f23112f = bVar;
        this.f23113g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f23114h = new ArrayList(bVar.a());
    }
}
