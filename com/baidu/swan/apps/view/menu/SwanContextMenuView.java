package com.baidu.swan.apps.view.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.a.n0.a.c;
import c.a.n0.a.d;
import c.a.n0.a.e;
import c.a.n0.a.f;
import c.a.n0.a.g;
import c.a.n0.a.z1.b.e.a;
import c.a.n0.a.z1.b.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class SwanContextMenuView extends FrameLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f46488e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46489f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f46490g;

    /* renamed from: h  reason: collision with root package name */
    public b f46491h;
    public boolean mLayoutInCenter;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanContextMenuView f46492e;

        public a(SwanContextMenuView swanContextMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanContextMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46492e = swanContextMenuView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f46492e.f46491h.a(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Context f46493e;

        /* renamed from: f  reason: collision with root package name */
        public List<c.a.n0.a.z1.b.e.b> f46494f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanContextMenuView f46495g;

        /* loaded from: classes6.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public ImageView f46496a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f46497b;

            public a(b bVar) {
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

        public b(SwanContextMenuView swanContextMenuView, Context context, List<c.a.n0.a.z1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanContextMenuView, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46495g = swanContextMenuView;
            this.f46494f = list;
            this.f46493e = context;
        }

        public void a(int i2) {
            c.a.n0.a.z1.b.e.b bVar;
            b.a d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (d2 = (bVar = this.f46494f.get(i2)).d()) == null) {
                return;
            }
            d2.a(bVar);
        }

        public final void b(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                if (getCount() == 1) {
                    view.setBackground(this.f46493e.getResources().getDrawable(e.swan_app_context_menu_round_corner_selector));
                } else if (i2 == 0) {
                    view.setBackground(this.f46493e.getResources().getDrawable(e.swan_app_context_menu_top_corner_selector));
                } else if (i2 == getCount() - 1) {
                    view.setBackground(this.f46493e.getResources().getDrawable(e.swan_app_context_menu_bottom_corner_selector));
                } else {
                    view.setBackground(this.f46493e.getResources().getDrawable(e.swan_app_context_menu_no_corner_selector));
                }
            }
        }

        public void c(List<c.a.n0.a.z1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                this.f46494f = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46494f.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f46494f.get(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f46493e).inflate(g.swan_app_menu_item_view, (ViewGroup) null);
                    aVar = new a(this);
                    aVar.f46496a = (ImageView) view.findViewById(f.item_icon);
                    aVar.f46497b = (TextView) view.findViewById(f.item_title);
                    b(view, i2);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                c.a.n0.a.z1.b.e.b bVar = this.f46494f.get(i2);
                aVar.f46497b.setText(bVar.e());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f46497b.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f46496a.getLayoutParams();
                if (bVar.b() != null) {
                    aVar.f46496a.setVisibility(0);
                    aVar.f46496a.setImageDrawable(bVar.b());
                    layoutParams.setMarginStart(this.f46493e.getResources().getDimensionPixelSize(d.swan_context_menu_item_title_left_margin));
                } else {
                    aVar.f46496a.setVisibility(8);
                    layoutParams.setMarginStart(this.f46493e.getResources().getDimensionPixelSize(d.swan_context_menu_item_icon_left_margin));
                }
                aVar.f46497b.setLayoutParams(layoutParams);
                if (this.f46495g.mLayoutInCenter) {
                    ((LinearLayout) view).setGravity(17);
                    layoutParams.width = -2;
                    if (bVar.b() != null) {
                        layoutParams2.setMarginStart(0);
                        aVar.f46496a.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams.setMarginStart(0);
                        aVar.f46497b.setLayoutParams(layoutParams);
                    }
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanContextMenuView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f46489f = false;
        this.f46488e = context;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            setBackground(this.f46488e.getResources().getDrawable(e.swan_app_context_menu_bg));
            ListView listView = new ListView(this.f46488e);
            this.f46490g = listView;
            listView.setCacheColorHint(0);
            this.f46490g.setDivider(getResources().getDrawable(c.swan_context_menu_divider_color));
            this.f46490g.setDividerHeight(1);
            this.f46490g.setSelector(new ColorDrawable(0));
            addView(this.f46490g, new FrameLayout.LayoutParams(-1, -1));
            this.f46490g.setOnItemClickListener(new a(this));
        }
    }

    public void layoutMenu(List<c.a.n0.a.z1.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f46489f) {
            return;
        }
        b bVar = this.f46491h;
        if (bVar == null) {
            b bVar2 = new b(this, this.f46488e, list);
            this.f46491h = bVar2;
            this.f46490g.setAdapter((ListAdapter) bVar2);
        } else {
            bVar.c(list);
        }
        this.f46489f = true;
    }

    public void onMenuItemUpdated(c.a.n0.a.z1.b.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
        }
    }

    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f46489f = false;
        }
    }

    public void setLayoutInCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mLayoutInCenter = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanContextMenuView(Context context, AttributeSet attributeSet) {
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
        this.f46489f = false;
        this.f46488e = context;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanContextMenuView(Context context) {
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
        this.f46489f = false;
        this.f46488e = context;
        b();
    }
}
