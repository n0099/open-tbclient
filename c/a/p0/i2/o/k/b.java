package c.a.p0.i2.o.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.p0.i2.h.o;
import c.a.p0.i3.h0.s;
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
    public View f19819a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19820b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19821c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f19822d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f19823e;

    /* renamed from: f  reason: collision with root package name */
    public int f19824f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f19825g;

    /* renamed from: h  reason: collision with root package name */
    public int f19826h;

    /* renamed from: i  reason: collision with root package name */
    public int f19827i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f19828j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19829a;

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
            this.f19829a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f19829a.f19823e != null) {
                    return this.f19829a.f19823e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.p0.i2.o.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0938b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19830e;

        public View$OnClickListenerC0938b(b bVar) {
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
            this.f19830e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19830e.f19825g != null) {
                    this.f19830e.f19825g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f19830e.f19820b) {
                            if (view == this.f19830e.f19821c) {
                                this.f19830e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f19830e.k(0);
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
        this.f19824f = 0;
        this.f19828j = new a(this);
        this.k = new View$OnClickListenerC0938b(this);
        if (view == null) {
            return;
        }
        this.f19819a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f19820b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f19819a.findViewById(R.id.owner_reply);
        this.f19821c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f19819a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f19822d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f19828j);
        this.f19822d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f18769f == o.l) {
            this.f19820b.setClickable(true);
            this.f19820b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f19821c.setVisibility(0);
            f(oVar.f18771h);
        }
        if (oVar.f18772i) {
            this.f19821c.setVisibility(8);
            this.f19822d.setVisibility(8);
        } else if (oVar.f18773j) {
            this.f19821c.setVisibility(8);
        } else {
            this.f19821c.setVisibility(0);
        }
        if (!oVar.f18772i && oVar.k != null) {
            this.f19822d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f18770g == oVar.k.get(i3).sort_type.intValue()) {
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
                this.f19822d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f19822d.setVisibility(0);
            this.f19822d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19819a, R.color.CAM_X0205);
            this.f19827i = SkinManager.getColor(R.color.CAM_X0105);
            this.f19826h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f19824f);
            this.f19822d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f19825g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f19823e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f19824f = i2;
            if (i2 == 0) {
                this.f19820b.setTypeface(Typeface.defaultFromStyle(1));
                this.f19821c.setTypeface(Typeface.defaultFromStyle(0));
                this.f19820b.setTextColor(this.f19827i);
                this.f19821c.setTextColor(this.f19826h);
            } else if (i2 == 1) {
                this.f19820b.setTypeface(Typeface.defaultFromStyle(0));
                this.f19821c.setTypeface(Typeface.defaultFromStyle(1));
                this.f19820b.setTextColor(this.f19826h);
                this.f19821c.setTextColor(this.f19827i);
            }
        }
    }
}
