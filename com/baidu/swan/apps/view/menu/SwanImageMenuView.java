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
import com.baidu.tieba.R;
import com.baidu.tieba.fm2;
import com.baidu.tieba.i23;
import com.baidu.tieba.j23;
import com.baidu.tieba.l23;
import com.baidu.tieba.li3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanImageMenuView extends FrameLayout implements i23.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public c b;
    public Context c;
    public SwanAppRoundCornerListView d;
    public li3 e;
    public View f;
    public int g;

    /* loaded from: classes3.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.b.b(i);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            this.a.e.j();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<j23> a;
        public Context b;

        public c(Context context, List<j23> list) {
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
            this.b = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public j23 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.a.get(i) : (j23) invokeI.objValue;
        }

        public void b(int i) {
            j23 j23Var;
            j23.a d;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (d = (j23Var = this.a.get(i)).d()) == null) {
                return;
            }
            d.a(j23Var);
        }

        public final void c(@NonNull View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
                if (i == 0) {
                    view2.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081167));
                } else {
                    view2.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081166));
                }
            }
        }

        public void d(List<j23> list) {
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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            View inflate;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
                j23 item = getItem(i);
                if (item instanceof l23) {
                    inflate = View.inflate(this.b, R.layout.obfuscated_res_0x7f0d0811, null);
                    String i2 = ((l23) item).i();
                    if (!TextUtils.isEmpty(i2)) {
                        ((SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f090e21)).setImageURI(i2);
                    }
                    ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091620)).setText(item.e());
                } else {
                    inflate = View.inflate(this.b, R.layout.obfuscated_res_0x7f0d00ce, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920fd);
                    textView.setTextColor(this.b.getResources().getColor(R.color.obfuscated_res_0x7f060395));
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
        this.g = -1;
        this.c = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0810, (ViewGroup) null);
            SwanAppRoundCornerListView swanAppRoundCornerListView = (SwanAppRoundCornerListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091328);
            this.d = swanAppRoundCornerListView;
            swanAppRoundCornerListView.setOnItemClickListener(new a(this));
            this.d.setSelector(new ColorDrawable(0));
            ((TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091673)).setOnClickListener(new b(this));
            addView(linearLayout);
            if (fm2.M().a()) {
                View view2 = new View(this.c);
                this.f = view2;
                view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f081168);
                this.f.setVisibility(8);
                addView(this.f);
            }
        }
    }

    public void d(List<j23> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.a) {
            return;
        }
        c cVar = this.b;
        if (cVar == null) {
            c cVar2 = new c(this.c, list);
            this.b = cVar2;
            this.d.setAdapter((ListAdapter) cVar2);
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
            View view2 = this.f;
            if (view2 == null || this.g == measuredHeight) {
                return;
            }
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, measuredHeight));
            this.f.setVisibility(0);
            this.g = measuredHeight;
        }
    }

    public void setMenu(li3 li3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, li3Var) == null) {
            this.e = li3Var;
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
        this.g = -1;
        this.c = context;
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
        this.g = -1;
        this.c = context;
        c();
    }
}
