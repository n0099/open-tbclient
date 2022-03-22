package c.a.p0.w2.q.l;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.p0.w2.i.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20525b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20526c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f20527d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f20528e;

    /* renamed from: f  reason: collision with root package name */
    public int f20529f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20530g;

    /* renamed from: h  reason: collision with root package name */
    public int f20531h;
    public int i;
    public SortSwitchButton.f j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.f20528e != null) {
                    return this.a.f20528e.a(i);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.p0.w2.q.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1535b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1535b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f20530g != null) {
                    this.a.f20530g.onClick(view);
                }
                if (l.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.a.f20525b) {
                            if (view == this.a.f20526c) {
                                this.a.k(1);
                                return;
                            }
                            return;
                        }
                        this.a.k(0);
                    }
                }
            }
        }
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20529f = 0;
        this.j = new a(this);
        this.k = new View$OnClickListenerC1535b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090260);
        this.f20525b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091635);
        this.f20526c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(R.id.obfuscated_res_0x7f09235d);
        this.f20527d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f20527d.v(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rVar) == null) || rVar == null) {
            return;
        }
        int i = 0;
        if (rVar.f19848b == r.f19847h) {
            this.f20525b.setClickable(true);
            this.f20525b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0268));
            this.f20526c.setVisibility(0);
            f(rVar.f19850d);
        }
        if (rVar.f19851e) {
            this.f20526c.setVisibility(8);
            this.f20527d.setVisibility(8);
        } else if (rVar.f19852f) {
            this.f20526c.setVisibility(8);
        } else {
            this.f20526c.setVisibility(0);
        }
        if (!rVar.f19851e && rVar.f19853g != null) {
            this.f20527d.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 < rVar.f19853g.size()) {
                    if (rVar.f19853g.get(i2) != null && rVar.f19849c == rVar.f19853g.get(i2).sort_type.intValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            g(rVar.f19853g, i);
        }
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                k(1);
            } else {
                k(0);
            }
        }
    }

    public void g(List<PbSortType> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f20527d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                c.a.p0.a4.k0.r rVar = new c.a.p0.a4.k0.r();
                rVar.c(pbSortType.sort_type.intValue());
                rVar.d(pbSortType.sort_name);
                arrayList.add(rVar);
            }
            this.f20527d.setVisibility(0);
            this.f20527d.setData(arrayList, i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            this.i = SkinManager.getColor(R.color.CAM_X0105);
            this.f20531h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f20529f);
            this.f20527d.H();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f20530g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f20528e = fVar;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f20529f = i;
            if (i == 0) {
                this.f20525b.setTypeface(Typeface.defaultFromStyle(1));
                this.f20526c.setTypeface(Typeface.defaultFromStyle(0));
                this.f20525b.setTextColor(this.i);
                this.f20526c.setTextColor(this.f20531h);
            } else if (i == 1) {
                this.f20525b.setTypeface(Typeface.defaultFromStyle(0));
                this.f20526c.setTypeface(Typeface.defaultFromStyle(1));
                this.f20525b.setTextColor(this.f20531h);
                this.f20526c.setTextColor(this.i);
            }
        }
    }
}
