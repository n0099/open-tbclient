package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.view.SwanAppRoundCornerListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.o0.a.e;
import d.a.o0.a.f;
import d.a.o0.a.g;
import d.a.o0.a.z1.b.e.a;
import d.a.o0.a.z1.b.e.b;
import d.a.o0.a.z1.b.e.d;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanImageMenuView extends FrameLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11657e;

    /* renamed from: f  reason: collision with root package name */
    public c f11658f;

    /* renamed from: g  reason: collision with root package name */
    public Context f11659g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppRoundCornerListView f11660h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.a.w2.j.b f11661i;
    public View j;
    public int k;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanImageMenuView f11662e;

        public a(SwanImageMenuView swanImageMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanImageMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11662e = swanImageMenuView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f11662e.f11658f.b(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanImageMenuView f11663e;

        public b(SwanImageMenuView swanImageMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanImageMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11663e = swanImageMenuView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11663e.f11661i == null) {
                return;
            }
            this.f11663e.f11661i.j();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<d.a.o0.a.z1.b.e.b> f11664e;

        /* renamed from: f  reason: collision with root package name */
        public Context f11665f;

        public c(Context context, List<d.a.o0.a.z1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11664e = list;
            this.f11665f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d.a.o0.a.z1.b.e.b getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f11664e.get(i2) : (d.a.o0.a.z1.b.e.b) invokeI.objValue;
        }

        public void b(int i2) {
            d.a.o0.a.z1.b.e.b bVar;
            b.a d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (d2 = (bVar = this.f11664e.get(i2)).d()) == null) {
                return;
            }
            d2.a(bVar);
        }

        public final void c(@NonNull View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
                if (i2 == 0) {
                    view.setBackground(this.f11665f.getResources().getDrawable(e.swan_image_menu_item_rounded_bg));
                } else {
                    view.setBackground(this.f11665f.getResources().getDrawable(e.swan_image_menu_item_bg));
                }
            }
        }

        public void d(List<d.a.o0.a.z1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.f11664e = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11664e.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            View inflate;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
                d.a.o0.a.z1.b.e.b item = getItem(i2);
                if (item instanceof d) {
                    inflate = View.inflate(this.f11665f, g.swan_app_img_menu_swan_item_layout, null);
                    String i3 = ((d) item).i();
                    if (!TextUtils.isEmpty(i3)) {
                        ((SimpleDraweeView) inflate.findViewById(f.icon)).setImageURI(i3);
                    }
                    ((TextView) inflate.findViewById(f.name)).setText(item.e());
                } else {
                    inflate = View.inflate(this.f11665f, g.aiapps_scheme_utils_show_action_sheet_item, null);
                    TextView textView = (TextView) inflate.findViewById(f.text);
                    textView.setTextColor(this.f11665f.getResources().getColor(d.a.o0.a.c.aiapps_action_sheet_item_color));
                    textView.setText(item.e());
                }
                c(inflate, i2);
                return inflate;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanImageMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f11657e = false;
        this.k = -1;
        this.f11659g = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f11659g).inflate(g.swan_app_img_menu, (ViewGroup) null);
            SwanAppRoundCornerListView swanAppRoundCornerListView = (SwanAppRoundCornerListView) linearLayout.findViewById(f.list);
            this.f11660h = swanAppRoundCornerListView;
            swanAppRoundCornerListView.setOnItemClickListener(new a(this));
            this.f11660h.setSelector(new ColorDrawable(0));
            ((TextView) linearLayout.findViewById(f.negative_button)).setOnClickListener(new b(this));
            addView(linearLayout);
            if (d.a.o0.a.c1.a.H().a()) {
                View view = new View(this.f11659g);
                this.j = view;
                view.setBackgroundResource(e.swan_image_menu_night_mask);
                this.j.setVisibility(8);
                addView(this.j);
            }
        }
    }

    public void d(List<d.a.o0.a.z1.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f11657e) {
            return;
        }
        c cVar = this.f11658f;
        if (cVar == null) {
            c cVar2 = new c(this.f11659g, list);
            this.f11658f = cVar2;
            this.f11660h.setAdapter((ListAdapter) cVar2);
        } else {
            cVar.d(list);
        }
        this.f11657e = true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int measuredHeight = getMeasuredHeight();
            View view = this.j;
            if (view == null || this.k == measuredHeight) {
                return;
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, measuredHeight));
            this.j.setVisibility(0);
            this.k = measuredHeight;
        }
    }

    public void setMenu(d.a.o0.a.w2.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f11661i = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanImageMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11657e = false;
        this.k = -1;
        this.f11659g = context;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanImageMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11657e = false;
        this.k = -1;
        this.f11659g = context;
        c();
    }
}
