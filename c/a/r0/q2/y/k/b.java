package c.a.r0.q2.y.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.j;
import c.a.r0.q2.f;
import c.a.r0.q2.i;
import c.a.r0.q2.l;
import c.a.r0.q2.r.q;
import c.a.r0.t3.j0.s;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22531b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22532c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f22533d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f22534e;

    /* renamed from: f  reason: collision with root package name */
    public int f22535f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f22536g;

    /* renamed from: h  reason: collision with root package name */
    public int f22537h;

    /* renamed from: i  reason: collision with root package name */
    public int f22538i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f22539j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f22540k;

    /* loaded from: classes6.dex */
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
                if (this.a.f22534e != null) {
                    return this.a.f22534e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.r0.q2.y.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1306b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22541e;

        public View$OnClickListenerC1306b(b bVar) {
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
            this.f22541e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f22541e.f22536g != null) {
                    this.f22541e.f22536g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f22541e.f22531b) {
                            if (view == this.f22541e.f22532c) {
                                this.f22541e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f22541e.k(0);
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
        this.f22535f = 0;
        this.f22539j = new a(this);
        this.f22540k = new View$OnClickListenerC1306b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f22531b = textView;
        textView.setOnClickListener(this.f22540k);
        TextView textView2 = (TextView) this.a.findViewById(i.owner_reply);
        this.f22532c = textView2;
        textView2.setOnClickListener(this.f22540k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(i.video_pb_sort_switch_btn);
        this.f22533d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f22539j);
        this.f22533d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f21555f == q.l) {
            this.f22531b.setClickable(true);
            this.f22531b.setText(TbadkCoreApplication.getInst().getString(l.all_reply));
            this.f22532c.setVisibility(0);
            f(qVar.f21557h);
        }
        if (qVar.f21558i) {
            this.f22532c.setVisibility(8);
            this.f22533d.setVisibility(8);
        } else if (qVar.f21559j) {
            this.f22532c.setVisibility(8);
        } else {
            this.f22532c.setVisibility(0);
        }
        if (!qVar.f21558i && qVar.f21560k != null) {
            this.f22533d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.f21560k.size()) {
                    if (qVar.f21560k.get(i3) != null && qVar.f21556g == qVar.f21560k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(qVar.f21560k, i2);
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
                this.f22533d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f22533d.setVisibility(0);
            this.f22533d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, f.CAM_X0205);
            this.f22538i = SkinManager.getColor(f.CAM_X0105);
            this.f22537h = SkinManager.getColor(f.CAM_X0107);
            k(this.f22535f);
            this.f22533d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f22536g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f22534e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f22535f = i2;
            if (i2 == 0) {
                this.f22531b.setTypeface(Typeface.defaultFromStyle(1));
                this.f22532c.setTypeface(Typeface.defaultFromStyle(0));
                this.f22531b.setTextColor(this.f22538i);
                this.f22532c.setTextColor(this.f22537h);
            } else if (i2 == 1) {
                this.f22531b.setTypeface(Typeface.defaultFromStyle(0));
                this.f22532c.setTypeface(Typeface.defaultFromStyle(1));
                this.f22531b.setTextColor(this.f22537h);
                this.f22532c.setTextColor(this.f22538i);
            }
        }
    }
}
