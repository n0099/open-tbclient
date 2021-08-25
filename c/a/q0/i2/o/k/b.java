package c.a.q0.i2.o.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.q0.i2.h.o;
import c.a.q0.i3.i0.s;
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

    /* renamed from: a  reason: collision with root package name */
    public View f20143a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20144b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20145c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f20146d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f20147e;

    /* renamed from: f  reason: collision with root package name */
    public int f20148f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20149g;

    /* renamed from: h  reason: collision with root package name */
    public int f20150h;

    /* renamed from: i  reason: collision with root package name */
    public int f20151i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f20152j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20153a;

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
            this.f20153a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f20153a.f20147e != null) {
                    return this.f20153a.f20147e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.q0.i2.o.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0950b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20154e;

        public View$OnClickListenerC0950b(b bVar) {
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
            this.f20154e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20154e.f20149g != null) {
                    this.f20154e.f20149g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f20154e.f20144b) {
                            if (view == this.f20154e.f20145c) {
                                this.f20154e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f20154e.k(0);
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
        this.f20148f = 0;
        this.f20152j = new a(this);
        this.k = new View$OnClickListenerC0950b(this);
        if (view == null) {
            return;
        }
        this.f20143a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f20144b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f20143a.findViewById(R.id.owner_reply);
        this.f20145c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f20143a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f20146d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f20152j);
        this.f20146d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f19102f == o.l) {
            this.f20144b.setClickable(true);
            this.f20144b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f20145c.setVisibility(0);
            f(oVar.f19104h);
        }
        if (oVar.f19105i) {
            this.f20145c.setVisibility(8);
            this.f20146d.setVisibility(8);
        } else if (oVar.f19106j) {
            this.f20145c.setVisibility(8);
        } else {
            this.f20145c.setVisibility(0);
        }
        if (!oVar.f19105i && oVar.k != null) {
            this.f20146d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f19103g == oVar.k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(oVar.k, i2);
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
                this.f20146d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f20146d.setVisibility(0);
            this.f20146d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f20143a, R.color.CAM_X0205);
            this.f20151i = SkinManager.getColor(R.color.CAM_X0105);
            this.f20150h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f20148f);
            this.f20146d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f20149g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f20147e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f20148f = i2;
            if (i2 == 0) {
                this.f20144b.setTypeface(Typeface.defaultFromStyle(1));
                this.f20145c.setTypeface(Typeface.defaultFromStyle(0));
                this.f20144b.setTextColor(this.f20151i);
                this.f20145c.setTextColor(this.f20150h);
            } else if (i2 == 1) {
                this.f20144b.setTypeface(Typeface.defaultFromStyle(0));
                this.f20145c.setTypeface(Typeface.defaultFromStyle(1));
                this.f20144b.setTextColor(this.f20150h);
                this.f20145c.setTextColor(this.f20151i);
            }
        }
    }
}
