package c.a.p0.x2.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.praise.PraiseListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends c.a.d.a.d<PraiseListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f20686b;

    /* renamed from: c  reason: collision with root package name */
    public View f20687c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f20688d;

    /* renamed from: e  reason: collision with root package name */
    public View f20689e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f20690f;

    /* renamed from: g  reason: collision with root package name */
    public View f20691g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20692h;
    public BdListView i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {praiseListActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f20686b = null;
        this.f20687c = null;
        this.f20688d = null;
        this.f20689e = null;
        this.f20690f = null;
        this.f20691g = null;
        this.f20692h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f20686b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.obfuscated_res_0x7f0d08ec);
        this.f20687c = praiseListActivity.findViewById(R.id.obfuscated_res_0x7f0924da);
        this.f20688d = (NavigationBar) praiseListActivity.findViewById(R.id.obfuscated_res_0x7f0924d9);
        this.f20689e = praiseListActivity.findViewById(R.id.obfuscated_res_0x7f0924d7);
        this.f20690f = NoDataViewFactory.a(this.f20686b.getPageContext().getContext(), this.f20687c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.f20686b.getActivity(), R.dimen.obfuscated_res_0x7f070297)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0ea6), null);
        this.i = (BdListView) praiseListActivity.findViewById(R.id.obfuscated_res_0x7f0924d8);
        TextView textView = new TextView(this.f20686b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.obfuscated_res_0x7f0924db);
        c cVar = new c(praiseListActivity);
        this.a = cVar;
        this.i.setAdapter((ListAdapter) cVar);
        this.i.setOnScrollListener(this.a);
        this.f20688d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f20688d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d08ee, (ViewGroup) null);
        this.f20691g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f20691g.findViewById(R.id.obfuscated_res_0x7f0924d2);
        this.f20692h = textView2;
        textView2.setText(str);
        this.f20691g.setVisibility(8);
        this.i.addHeaderView(this.f20691g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d08ed, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f0924d0);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f0924d1);
        this.n = (ProgressBar) this.j.findViewById(R.id.obfuscated_res_0x7f0924cf);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.i.addFooterView(this.j);
        this.i.setOnItemClickListener(praiseListActivity);
    }

    public void c(c.a.o0.r.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i) == null) || cVar == null) {
            return;
        }
        cVar.k(i == 1);
        cVar.j(this.f20687c);
        cVar.j(this.f20691g);
        cVar.j(this.j);
        this.f20688d.onChangeSkinType(this.f20686b.getPageContext(), i);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f20690f;
        if (noDataView != null) {
            noDataView.f(this.f20686b.getPageContext(), i);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20691g : (View) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getVisibility() == 0 || this.n.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void i() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.a) == null) {
            return;
        }
        cVar.notifyDataSetChanged();
    }

    public void j(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f20689e.setVisibility(8);
            this.f20690f.setVisibility(0);
            if (!StringUtils.isNull(str)) {
                this.f20690f.setTextOption(NoDataViewFactory.e.c(str));
            } else if (1 == i) {
                this.f20690f.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f07cc));
            } else {
                this.f20690f.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0ea6));
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
            } else {
                this.m.setVisibility(0);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void m(int i, List<a> list, int i2, int i3) {
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), list, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f20691g.setVisibility(0);
            if (i > 0) {
                PraiseListActivity praiseListActivity = this.f20686b;
                if (praiseListActivity.pageType != 1) {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ea7), StringHelper.numFormatOverWan(i));
                } else {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.obfuscated_res_0x7f0f07cd), StringHelper.numFormatOverWan(i));
                }
                this.f20688d.setTitleText(format2);
            } else {
                this.f20688d.setTitleText("");
            }
            if (list != null && list.size() >= 1) {
                this.f20689e.setVisibility(0);
                this.f20690f.setVisibility(8);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                switch (i2) {
                    case 1001:
                        this.j.setVisibility(0);
                        this.k.setVisibility(0);
                        this.l.setVisibility(8);
                        return;
                    case 1002:
                        this.j.setVisibility(8);
                        return;
                    case 1003:
                        this.j.setVisibility(0);
                        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
                        this.k.setVisibility(8);
                        this.l.setVisibility(0);
                        PraiseListActivity praiseListActivity2 = this.f20686b;
                        if (praiseListActivity2.pageType != 1) {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0ea5), StringHelper.numFormatOverWan(i));
                        } else {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f07cd), StringHelper.numFormatOverWan(i));
                        }
                        this.l.setText(format);
                        return;
                    default:
                        this.j.setVisibility(8);
                        return;
                }
            }
            j(null, this.f20686b.pageType);
        }
    }
}
