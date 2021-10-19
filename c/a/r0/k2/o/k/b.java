package c.a.r0.k2.o.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.r0.k2.h.o;
import c.a.r0.k3.i0.s;
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
    public View f20900a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20901b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20902c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f20903d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f20904e;

    /* renamed from: f  reason: collision with root package name */
    public int f20905f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20906g;

    /* renamed from: h  reason: collision with root package name */
    public int f20907h;

    /* renamed from: i  reason: collision with root package name */
    public int f20908i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f20909j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20910a;

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
            this.f20910a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f20910a.f20904e != null) {
                    return this.f20910a.f20904e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.r0.k2.o.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0990b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20911e;

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
            this.f20911e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20911e.f20906g != null) {
                    this.f20911e.f20906g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f20911e.f20901b) {
                            if (view == this.f20911e.f20902c) {
                                this.f20911e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f20911e.k(0);
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
        this.f20905f = 0;
        this.f20909j = new a(this);
        this.k = new View$OnClickListenerC0990b(this);
        if (view == null) {
            return;
        }
        this.f20900a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f20901b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f20900a.findViewById(R.id.owner_reply);
        this.f20902c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f20900a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f20903d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f20909j);
        this.f20903d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f19843f == o.l) {
            this.f20901b.setClickable(true);
            this.f20901b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f20902c.setVisibility(0);
            f(oVar.f19845h);
        }
        if (oVar.f19846i) {
            this.f20902c.setVisibility(8);
            this.f20903d.setVisibility(8);
        } else if (oVar.f19847j) {
            this.f20902c.setVisibility(8);
        } else {
            this.f20902c.setVisibility(0);
        }
        if (!oVar.f19846i && oVar.k != null) {
            this.f20903d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f19844g == oVar.k.get(i3).sort_type.intValue()) {
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
                this.f20903d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f20903d.setVisibility(0);
            this.f20903d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f20900a, R.color.CAM_X0205);
            this.f20908i = SkinManager.getColor(R.color.CAM_X0105);
            this.f20907h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f20905f);
            this.f20903d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f20906g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f20904e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f20905f = i2;
            if (i2 == 0) {
                this.f20901b.setTypeface(Typeface.defaultFromStyle(1));
                this.f20902c.setTypeface(Typeface.defaultFromStyle(0));
                this.f20901b.setTextColor(this.f20908i);
                this.f20902c.setTextColor(this.f20907h);
            } else if (i2 == 1) {
                this.f20901b.setTypeface(Typeface.defaultFromStyle(0));
                this.f20902c.setTypeface(Typeface.defaultFromStyle(1));
                this.f20901b.setTextColor(this.f20907h);
                this.f20902c.setTextColor(this.f20908i);
            }
        }
    }
}
