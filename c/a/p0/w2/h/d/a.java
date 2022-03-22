package c.a.p0.w2.h.d;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.w2.n.b.g;
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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.w2.n.b.d> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f19765b;

    /* renamed from: c  reason: collision with root package name */
    public int f19766c;

    /* renamed from: d  reason: collision with root package name */
    public int f19767d;

    /* renamed from: c.a.p0.w2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1493a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        public C1493a() {
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
    }

    public a(Context context) {
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
        this.f19766c = 0;
        this.f19767d = 0;
        this.f19765b = context;
        this.a = new ArrayList();
        this.f19766c = n.k(context) - (((int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201)) * 2);
        this.f19767d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
    }

    public final View a(int i, View view) {
        InterceptResult invokeIL;
        C1493a c1493a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, view)) == null) {
            if (view != null && (view.getTag() instanceof C1493a)) {
                c1493a = (C1493a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f19765b).inflate(R.layout.obfuscated_res_0x7f0d01e0, (ViewGroup) null);
                c1493a = new C1493a();
                c1493a.a = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091697);
                view.setTag(c1493a);
            }
            c.a.p0.w2.n.b.d item = getItem(i);
            if (item instanceof c.a.p0.w2.n.b.e) {
                c.a.p0.w2.n.b.e eVar = (c.a.p0.w2.n.b.e) item;
                if (!StringUtils.isNull(eVar.f20411e) && !"1".equals(eVar.f20411e)) {
                    c1493a.a.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = c1493a.a.getLayoutParams();
                    int i2 = this.f19766c;
                    int c2 = eVar.c(i2);
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(i2, c2);
                    } else {
                        layoutParams.height = c2;
                        layoutParams.width = i2;
                    }
                    c1493a.a.setLayoutParams(layoutParams);
                    c1493a.a.J(eVar.d(), 17, false);
                } else {
                    c1493a.a.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public c.a.p0.w2.n.b.d getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<c.a.p0.w2.n.b.d> list = this.a;
            if (list != null && list.size() > 0) {
                int size = this.a.size();
                if (i >= 0 && i < size) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (c.a.p0.w2.n.b.d) invokeI.objValue;
    }

    public final View c(int i, View view) {
        InterceptResult invokeIL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, view)) == null) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = new TextView(this.f19765b);
                textView.setTextSize(0, this.f19765b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b7));
                textView.setLineSpacing(0.0f, 1.2f);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                int i2 = this.f19767d;
                textView.setPadding(i2, 0, i2, 0);
            }
            c.a.p0.w2.n.b.d item = getItem(i);
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

    public void d(List<c.a.p0.w2.n.b.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a.clear();
            if (list == null || list.size() <= 0) {
                return;
            }
            this.a.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<c.a.p0.w2.n.b.d> list = this.a;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<c.a.p0.w2.n.b.d> list = this.a;
            if (list != null && list.size() > 0) {
                if (i >= 0 && i < this.a.size()) {
                    c.a.p0.w2.n.b.d dVar = this.a.get(i);
                    if (dVar == null) {
                        return super.getItemViewType(i);
                    }
                    if (dVar.getType() == 0) {
                        return 0;
                    }
                    if (dVar.getType() == 3) {
                        return 1;
                    }
                    return super.getItemViewType(i);
                }
                return super.getItemViewType(i);
            }
            return super.getItemViewType(i);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                return c(i, view);
            }
            if (itemViewType == 1) {
                return a(i, view);
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
