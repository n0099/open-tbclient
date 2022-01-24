package c.a.t0.w1.a;

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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LabelSettingView f24741e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.w1.b.b f24742f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.t0.w1.b.a> f24743g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f24744h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f24745e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f24746f;

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
            this.f24746f = bVar;
            this.f24745e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.t0.w1.b.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (item = this.f24746f.getItem(this.f24745e)) == null) {
                return;
            }
            item.f24748c = !item.f24748c;
            if (view instanceof TextView) {
                this.f24746f.d((TextView) view, item);
            }
            if (item.f24748c) {
                this.f24746f.f24744h.add(Integer.valueOf(item.a));
            } else {
                this.f24746f.f24744h.remove(Integer.valueOf(item.a));
            }
            if (this.f24746f.f24741e != null) {
                this.f24746f.f24741e.changeCompleteStatu(ListUtils.getCount(this.f24746f.f24744h) > 0);
            }
        }
    }

    /* renamed from: c.a.t0.w1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1500b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public C1500b(b bVar) {
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
        this.f24741e = labelSettingView;
        this.f24744h = new ArrayList();
    }

    public final void d(TextView textView, c.a.t0.w1.b.a aVar) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, textView, aVar) == null) || aVar == null) {
            return;
        }
        String str = aVar.f24747b;
        if (!StringUtils.isNull(str) && aVar.f24747b.length() > 4) {
            str = aVar.f24747b.substring(0, 3) + "...";
        }
        textView.setText(str);
        if (aVar.f24748c) {
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
    public c.a.t0.w1.b.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (c.a.t0.w1.b.a) ListUtils.getItem(this.f24743g, i2) : (c.a.t0.w1.b.a) invokeI.objValue;
    }

    public List<Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.t0.w1.b.b bVar = this.f24742f;
            return bVar == null ? new ArrayList() : bVar.a();
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24744h : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f24743g) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            c.a.t0.w1.b.a item = getItem(i2);
            if (item == null) {
                return 0L;
            }
            return item.a;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1500b c1500b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f24741e.getContext()).inflate(R.layout.item_label_layout, (ViewGroup) null);
                c1500b = new C1500b(this);
                c1500b.a = (TextView) view;
                view.setTag(c1500b);
            } else {
                c1500b = (C1500b) view.getTag();
            }
            c1500b.a.setOnClickListener(new a(this, i2));
            d(c1500b.a, getItem(i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(c.a.t0.w1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f24742f = bVar;
        this.f24743g = bVar.b();
        if (ListUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f24744h = new ArrayList(bVar.a());
    }
}
