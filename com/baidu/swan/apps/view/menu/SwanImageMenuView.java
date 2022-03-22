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
import c.a.n0.a.s1.b.e.a;
import c.a.n0.a.s1.b.e.b;
import c.a.n0.a.s1.b.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.view.SwanAppRoundCornerListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanImageMenuView extends FrameLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public c f29369b;

    /* renamed from: c  reason: collision with root package name */
    public Context f29370c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppRoundCornerListView f29371d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.q2.j.b f29372e;

    /* renamed from: f  reason: collision with root package name */
    public View f29373f;

    /* renamed from: g  reason: collision with root package name */
    public int f29374g;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanImageMenuView a;

        public a(SwanImageMenuView swanImageMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanImageMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanImageMenuView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.f29369b.b(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanImageMenuView a;

        public b(SwanImageMenuView swanImageMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanImageMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanImageMenuView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f29372e == null) {
                return;
            }
            this.a.f29372e.j();
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.n0.a.s1.b.e.b> a;

        /* renamed from: b  reason: collision with root package name */
        public Context f29375b;

        public c(Context context, List<c.a.n0.a.s1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.f29375b = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public c.a.n0.a.s1.b.e.b getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.a.get(i) : (c.a.n0.a.s1.b.e.b) invokeI.objValue;
        }

        public void b(int i) {
            c.a.n0.a.s1.b.e.b bVar;
            b.a d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (d2 = (bVar = this.a.get(i)).d()) == null) {
                return;
            }
            d2.a(bVar);
        }

        public final void c(@NonNull View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i) == null) {
                if (i == 0) {
                    view.setBackground(this.f29375b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08112d));
                } else {
                    view.setBackground(this.f29375b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08112c));
                }
            }
        }

        public void d(List<c.a.n0.a.s1.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            View inflate;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
                c.a.n0.a.s1.b.e.b item = getItem(i);
                if (item instanceof d) {
                    inflate = View.inflate(this.f29375b, R.layout.obfuscated_res_0x7f0d07c1, null);
                    String i2 = ((d) item).i();
                    if (!TextUtils.isEmpty(i2)) {
                        ((SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f090e06)).setImageURI(i2);
                    }
                    ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914e9)).setText(item.e());
                } else {
                    inflate = View.inflate(this.f29375b, R.layout.obfuscated_res_0x7f0d00d2, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f1b);
                    textView.setTextColor(this.f29375b.getResources().getColor(R.color.obfuscated_res_0x7f06037c));
                    textView.setText(item.e());
                }
                c(inflate, i);
                return inflate;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanImageMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f29374g = -1;
        this.f29370c = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f29370c).inflate(R.layout.obfuscated_res_0x7f0d07c0, (ViewGroup) null);
            SwanAppRoundCornerListView swanAppRoundCornerListView = (SwanAppRoundCornerListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091277);
            this.f29371d = swanAppRoundCornerListView;
            swanAppRoundCornerListView.setOnItemClickListener(new a(this));
            this.f29371d.setSelector(new ColorDrawable(0));
            ((TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091535)).setOnClickListener(new b(this));
            addView(linearLayout);
            if (c.a.n0.a.s0.a.M().a()) {
                View view = new View(this.f29370c);
                this.f29373f = view;
                view.setBackgroundResource(R.drawable.obfuscated_res_0x7f08112e);
                this.f29373f.setVisibility(8);
                addView(this.f29373f);
            }
        }
    }

    public void d(List<c.a.n0.a.s1.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.a) {
            return;
        }
        c cVar = this.f29369b;
        if (cVar == null) {
            c cVar2 = new c(this.f29370c, list);
            this.f29369b = cVar2;
            this.f29371d.setAdapter((ListAdapter) cVar2);
        } else {
            cVar.d(list);
        }
        this.a = true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int measuredHeight = getMeasuredHeight();
            View view = this.f29373f;
            if (view == null || this.f29374g == measuredHeight) {
                return;
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, measuredHeight));
            this.f29373f.setVisibility(0);
            this.f29374g = measuredHeight;
        }
    }

    public void setMenu(c.a.n0.a.q2.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f29372e = bVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f29374g = -1;
        this.f29370c = context;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f29374g = -1;
        this.f29370c = context;
        c();
    }
}
