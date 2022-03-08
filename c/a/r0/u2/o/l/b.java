package c.a.r0.u2.o.l;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.u2.h.q;
import c.a.r0.y3.k0.r;
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
    public TextView f24072b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24073c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f24074d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f24075e;

    /* renamed from: f  reason: collision with root package name */
    public int f24076f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f24077g;

    /* renamed from: h  reason: collision with root package name */
    public int f24078h;

    /* renamed from: i  reason: collision with root package name */
    public int f24079i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f24080j;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.a.f24075e != null) {
                    return this.a.f24075e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.r0.u2.o.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1481b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24081e;

        public View$OnClickListenerC1481b(b bVar) {
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
            this.f24081e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f24081e.f24077g != null) {
                    this.f24081e.f24077g.onClick(view);
                }
                if (l.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f24081e.f24072b) {
                            if (view == this.f24081e.f24073c) {
                                this.f24081e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f24081e.k(0);
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
        this.f24076f = 0;
        this.f24080j = new a(this);
        this.k = new View$OnClickListenerC1481b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f24072b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.a.findViewById(R.id.owner_reply);
        this.f24073c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f24074d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f24080j);
        this.f24074d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f23129f == q.l) {
            this.f24072b.setClickable(true);
            this.f24072b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f24073c.setVisibility(0);
            f(qVar.f23131h);
        }
        if (qVar.f23132i) {
            this.f24073c.setVisibility(8);
            this.f24074d.setVisibility(8);
        } else if (qVar.f23133j) {
            this.f24073c.setVisibility(8);
        } else {
            this.f24073c.setVisibility(0);
        }
        if (!qVar.f23132i && qVar.k != null) {
            this.f24074d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.k.size()) {
                    if (qVar.k.get(i3) != null && qVar.f23130g == qVar.k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(qVar.k, i2);
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
                this.f24074d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                r rVar = new r();
                rVar.c(pbSortType.sort_type.intValue());
                rVar.d(pbSortType.sort_name);
                arrayList.add(rVar);
            }
            this.f24074d.setVisibility(0);
            this.f24074d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            this.f24079i = SkinManager.getColor(R.color.CAM_X0105);
            this.f24078h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f24076f);
            this.f24074d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24077g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f24075e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f24076f = i2;
            if (i2 == 0) {
                this.f24072b.setTypeface(Typeface.defaultFromStyle(1));
                this.f24073c.setTypeface(Typeface.defaultFromStyle(0));
                this.f24072b.setTextColor(this.f24079i);
                this.f24073c.setTextColor(this.f24078h);
            } else if (i2 == 1) {
                this.f24072b.setTypeface(Typeface.defaultFromStyle(0));
                this.f24073c.setTypeface(Typeface.defaultFromStyle(1));
                this.f24072b.setTextColor(this.f24078h);
                this.f24073c.setTextColor(this.f24079i);
            }
        }
    }
}
