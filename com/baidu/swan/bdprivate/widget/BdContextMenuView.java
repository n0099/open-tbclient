package com.baidu.swan.bdprivate.widget;

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
import b.a.p0.a.k;
import b.a.p0.a.z1.b.e.a;
import b.a.p0.a.z1.b.e.b;
import b.a.p0.b.c;
import b.a.p0.b.d;
import b.a.p0.b.e;
import b.a.p0.b.f;
import b.a.p0.b.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class BdContextMenuView extends FrameLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f44421i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44422e;

    /* renamed from: f  reason: collision with root package name */
    public b f44423f;

    /* renamed from: g  reason: collision with root package name */
    public Context f44424g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f44425h;
    public boolean mLayoutInCenter;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdContextMenuView f44426e;

        public a(BdContextMenuView bdContextMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdContextMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44426e = bdContextMenuView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f44426e.f44423f.a(i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<b.a.p0.a.z1.b.e.b> f44427e;

        /* renamed from: f  reason: collision with root package name */
        public Context f44428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdContextMenuView f44429g;

        /* loaded from: classes8.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public ImageView f44430a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f44431b;

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

        public b(BdContextMenuView bdContextMenuView, Context context, List<b.a.p0.a.z1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdContextMenuView, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44429g = bdContextMenuView;
            this.f44427e = list;
            this.f44428f = context;
        }

        public void a(int i2) {
            b.a.p0.a.z1.b.e.b bVar;
            b.a d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (d2 = (bVar = this.f44427e.get(i2)).d()) == null) {
                return;
            }
            d2.a(bVar);
        }

        public final void b(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                if (getCount() == 1) {
                    view.setBackground(this.f44428f.getResources().getDrawable(e.aiapps_context_menu_round_corner_selector));
                } else if (i2 == 0) {
                    view.setBackground(this.f44428f.getResources().getDrawable(e.aiapps_context_menu_top_corner_selector));
                } else if (i2 == getCount() - 1) {
                    view.setBackground(this.f44428f.getResources().getDrawable(e.aiapps_context_menu_bottom_corner_selector));
                } else {
                    view.setBackground(this.f44428f.getResources().getDrawable(e.aiapps_context_menu_no_corner_selector));
                }
            }
        }

        public void c(List<b.a.p0.a.z1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                this.f44427e = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44427e.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f44427e.get(i2) : invokeI.objValue;
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
                    view = LayoutInflater.from(this.f44428f).inflate(g.aiapps_menu_item_view, (ViewGroup) null);
                    aVar = new a(this);
                    aVar.f44430a = (ImageView) view.findViewById(f.item_icon);
                    TextView textView = (TextView) view.findViewById(f.item_title);
                    aVar.f44431b = textView;
                    textView.setTextColor(this.f44428f.getResources().getColor(c.aiapps_context_menu_item_title_color));
                    b(view, i2);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                b.a.p0.a.z1.b.e.b bVar = this.f44427e.get(i2);
                aVar.f44431b.setText(bVar.e());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f44431b.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f44430a.getLayoutParams();
                if (bVar.b() != null) {
                    aVar.f44430a.setVisibility(0);
                    aVar.f44430a.setImageDrawable(bVar.b());
                    layoutParams.setMarginStart(this.f44428f.getResources().getDimensionPixelSize(d.aiapps_context_menu_item_title_left_margin));
                    aVar.f44431b.setLayoutParams(layoutParams);
                } else {
                    aVar.f44430a.setVisibility(8);
                    layoutParams.setMarginStart(this.f44428f.getResources().getDimensionPixelSize(d.aiapps_context_menu_item_icon_left_margin));
                    aVar.f44431b.setLayoutParams(layoutParams);
                }
                if (this.f44429g.mLayoutInCenter) {
                    ((LinearLayout) view).setGravity(17);
                    layoutParams.width = -2;
                    if (bVar.b() != null) {
                        layoutParams2.setMarginStart(0);
                        aVar.f44430a.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams.setMarginStart(0);
                        aVar.f44431b.setLayoutParams(layoutParams);
                    }
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(485284695, "Lcom/baidu/swan/bdprivate/widget/BdContextMenuView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(485284695, "Lcom/baidu/swan/bdprivate/widget/BdContextMenuView;");
                return;
            }
        }
        f44421i = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f44422e = false;
        this.f44424g = context;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            setBackground(this.f44424g.getResources().getDrawable(e.aiapps_context_menu_bg));
            ListView listView = new ListView(this.f44424g);
            this.f44425h = listView;
            listView.setCacheColorHint(0);
            this.f44425h.setDivider(getResources().getDrawable(c.aiapps_context_menu_divider_color));
            this.f44425h.setDividerHeight(1);
            this.f44425h.setSelector(new ColorDrawable(0));
            addView(this.f44425h, new FrameLayout.LayoutParams(-1, -1));
            this.f44425h.setOnItemClickListener(new a(this));
        }
    }

    public void layoutMenu(List<b.a.p0.a.z1.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            boolean z = f44421i;
            if (this.f44422e) {
                return;
            }
            b bVar = this.f44423f;
            if (bVar == null) {
                b bVar2 = new b(this, this.f44424g, list);
                this.f44423f = bVar2;
                this.f44425h.setAdapter((ListAdapter) bVar2);
            } else {
                bVar.c(list);
            }
            this.f44422e = true;
        }
    }

    public void onMenuItemUpdated(b.a.p0.a.z1.b.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
        }
    }

    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f44422e = false;
        }
    }

    public void setLayoutInCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mLayoutInCenter = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44422e = false;
        this.f44424g = context;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44422e = false;
        this.f44424g = context;
        b();
    }
}
