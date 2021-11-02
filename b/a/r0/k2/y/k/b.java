package b.a.r0.k2.y.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.r0.k2.f;
import b.a.r0.k2.i;
import b.a.r0.k2.l;
import b.a.r0.k2.r.p;
import b.a.r0.l3.j0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19872a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19873b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19874c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f19875d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f19876e;

    /* renamed from: f  reason: collision with root package name */
    public int f19877f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f19878g;

    /* renamed from: h  reason: collision with root package name */
    public int f19879h;

    /* renamed from: i  reason: collision with root package name */
    public int f19880i;
    public SortSwitchButton.f j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19881a;

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
                    return;
                }
            }
            this.f19881a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f19881a.f19876e != null) {
                    return this.f19881a.f19876e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: b.a.r0.k2.y.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0990b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19882e;

        public View$OnClickListenerC0990b(b bVar) {
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
                    return;
                }
            }
            this.f19882e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19882e.f19878g != null) {
                    this.f19882e.f19878g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f19882e.f19873b) {
                            if (view == this.f19882e.f19874c) {
                                this.f19882e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f19882e.k(0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19877f = 0;
        this.j = new a(this);
        this.k = new View$OnClickListenerC0990b(this);
        if (view == null) {
            return;
        }
        this.f19872a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f19873b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f19872a.findViewById(i.owner_reply);
        this.f19874c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f19872a.findViewById(i.video_pb_sort_switch_btn);
        this.f19875d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f19875d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null) {
            return;
        }
        int i2 = 0;
        if (pVar.f18795f == p.l) {
            this.f19873b.setClickable(true);
            this.f19873b.setText(TbadkCoreApplication.getInst().getString(l.all_reply));
            this.f19874c.setVisibility(0);
            f(pVar.f18797h);
        }
        if (pVar.f18798i) {
            this.f19874c.setVisibility(8);
            this.f19875d.setVisibility(8);
        } else if (pVar.j) {
            this.f19874c.setVisibility(8);
        } else {
            this.f19874c.setVisibility(0);
        }
        if (!pVar.f18798i && pVar.k != null) {
            this.f19875d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < pVar.k.size()) {
                    if (pVar.k.get(i3) != null && pVar.f18796g == pVar.k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(pVar.k, i2);
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

    public void g(List<PbSortType> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i2) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f19875d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f19875d.setVisibility(0);
            this.f19875d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19872a, f.CAM_X0205);
            this.f19880i = SkinManager.getColor(f.CAM_X0105);
            this.f19879h = SkinManager.getColor(f.CAM_X0107);
            k(this.f19877f);
            this.f19875d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f19878g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f19876e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f19877f = i2;
            if (i2 == 0) {
                this.f19873b.setTypeface(Typeface.defaultFromStyle(1));
                this.f19874c.setTypeface(Typeface.defaultFromStyle(0));
                this.f19873b.setTextColor(this.f19880i);
                this.f19874c.setTextColor(this.f19879h);
            } else if (i2 == 1) {
                this.f19873b.setTypeface(Typeface.defaultFromStyle(0));
                this.f19874c.setTypeface(Typeface.defaultFromStyle(1));
                this.f19873b.setTextColor(this.f19879h);
                this.f19874c.setTextColor(this.f19880i);
            }
        }
    }
}
