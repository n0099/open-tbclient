package c.a.r0.j2.g.d;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.j2.l.b.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.r0.j2.l.b.d> f19554e;

    /* renamed from: f  reason: collision with root package name */
    public Context f19555f;

    /* renamed from: g  reason: collision with root package name */
    public int f19556g;

    /* renamed from: h  reason: collision with root package name */
    public int f19557h;

    /* renamed from: c.a.r0.j2.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0941a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f19558a;

        public C0941a() {
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
        this.f19556g = 0;
        this.f19557h = 0;
        this.f19555f = context;
        this.f19554e = new ArrayList();
        this.f19556g = l.k(context) - (((int) context.getResources().getDimension(R.dimen.ds30)) * 2);
        this.f19557h = context.getResources().getDimensionPixelSize(R.dimen.ds32);
    }

    public final View a(int i2, View view) {
        InterceptResult invokeIL;
        C0941a c0941a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, view)) == null) {
            if (view != null && (view.getTag() instanceof C0941a)) {
                c0941a = (C0941a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f19555f).inflate(R.layout.chosen_pb_image_item, (ViewGroup) null);
                c0941a = new C0941a();
                c0941a.f19558a = (TbImageView) view.findViewById(R.id.pb_chosen_list_image);
                view.setTag(c0941a);
            }
            c.a.r0.j2.l.b.d item = getItem(i2);
            if (item instanceof c.a.r0.j2.l.b.e) {
                c.a.r0.j2.l.b.e eVar = (c.a.r0.j2.l.b.e) item;
                if (!StringUtils.isNull(eVar.f20499i) && !"1".equals(eVar.f20499i)) {
                    c0941a.f19558a.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = c0941a.f19558a.getLayoutParams();
                    int i3 = this.f19556g;
                    int c2 = eVar.c(i3);
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(i3, c2);
                    } else {
                        layoutParams.height = c2;
                        layoutParams.width = i3;
                    }
                    c0941a.f19558a.setLayoutParams(layoutParams);
                    c0941a.f19558a.startLoad(eVar.d(), 17, false);
                } else {
                    c0941a.f19558a.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public c.a.r0.j2.l.b.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            List<c.a.r0.j2.l.b.d> list = this.f19554e;
            if (list != null && list.size() > 0) {
                int size = this.f19554e.size();
                if (i2 >= 0 && i2 < size) {
                    return this.f19554e.get(i2);
                }
            }
            return null;
        }
        return (c.a.r0.j2.l.b.d) invokeI.objValue;
    }

    public final View c(int i2, View view) {
        InterceptResult invokeIL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, view)) == null) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = new TextView(this.f19555f);
                textView.setTextSize(0, this.f19555f.getResources().getDimensionPixelSize(R.dimen.fontsize32));
                textView.setLineSpacing(0.0f, 1.2f);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                int i3 = this.f19557h;
                textView.setPadding(i3, 0, i3, 0);
            }
            c.a.r0.j2.l.b.d item = getItem(i2);
            if (item instanceof g) {
                g gVar = (g) item;
                textView.setText(gVar.b());
                int d2 = gVar.d();
                if (d2 == 1) {
                    textView.setGravity(17);
                } else if (d2 != 2) {
                    textView.setGravity(3);
                } else {
                    textView.setGravity(5);
                }
                if (!StringUtils.isNull(gVar.e())) {
                    if (!SkinManager.setViewTextColor(textView, gVar.e())) {
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    }
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                }
                if (gVar.f() > 0) {
                    textView.setTextSize(0, gVar.f());
                }
            }
            return textView;
        }
        return (View) invokeIL.objValue;
    }

    public void d(List<c.a.r0.j2.l.b.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f19554e.clear();
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f19554e.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<c.a.r0.j2.l.b.d> list = this.f19554e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<c.a.r0.j2.l.b.d> list = this.f19554e;
            if (list != null && list.size() > 0) {
                if (i2 >= 0 && i2 < this.f19554e.size()) {
                    c.a.r0.j2.l.b.d dVar = this.f19554e.get(i2);
                    if (dVar == null) {
                        return super.getItemViewType(i2);
                    }
                    if (dVar.getType() == 0) {
                        return 0;
                    }
                    if (dVar.getType() == 3) {
                        return 1;
                    }
                    return super.getItemViewType(i2);
                }
                return super.getItemViewType(i2);
            }
            return super.getItemViewType(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                return c(i2, view);
            }
            if (itemViewType == 1) {
                return a(i2, view);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
