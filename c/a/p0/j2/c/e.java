package c.a.p0.j2.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
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
public class e extends c.a.e.a.d<PraiseListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f20835a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f20836b;

    /* renamed from: c  reason: collision with root package name */
    public View f20837c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f20838d;

    /* renamed from: e  reason: collision with root package name */
    public View f20839e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f20840f;

    /* renamed from: g  reason: collision with root package name */
    public View f20841g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20842h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f20843i;

    /* renamed from: j  reason: collision with root package name */
    public View f20844j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20835a = null;
        this.f20836b = null;
        this.f20837c = null;
        this.f20838d = null;
        this.f20839e = null;
        this.f20840f = null;
        this.f20841g = null;
        this.f20842h = null;
        this.f20843i = null;
        this.f20844j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f20836b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f20837c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f20838d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f20839e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f20840f = NoDataViewFactory.a(this.f20836b.getPageContext().getContext(), this.f20837c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f20836b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f20843i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f20836b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f20843i.addHeaderView(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f20835a = cVar;
        this.f20843i.setAdapter((ListAdapter) cVar);
        this.f20843i.setOnScrollListener(this.f20835a);
        this.f20838d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f20838d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f20841g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f20841g.findViewById(R.id.zan_list_head_text);
        this.f20842h = textView2;
        textView2.setText(str);
        this.f20841g.setVisibility(8);
        this.f20843i.addHeaderView(this.f20841g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.f20844j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.f20844j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.f20844j.findViewById(R.id.zan_list_foot_progress);
        this.f20844j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f20843i.addFooterView(this.f20844j);
        this.f20843i.setOnItemClickListener(praiseListActivity);
    }

    public void c(c.a.o0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) || cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f20837c);
        cVar.j(this.f20841g);
        cVar.j(this.f20844j);
        this.f20838d.onChangeSkinType(this.f20836b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f20844j, R.drawable.bg_pack);
        NoDataView noDataView = this.f20840f;
        if (noDataView != null) {
            noDataView.onChangeSkinType(this.f20836b.getPageContext(), i2);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20841g : (View) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getVisibility() == 0 || this.n.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void g() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f20835a) == null) {
            return;
        }
        cVar.notifyDataSetChanged();
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f20839e.setVisibility(8);
            this.f20840f.setVisibility(0);
            if (!StringUtils.isNull(str)) {
                this.f20840f.setTextOption(NoDataViewFactory.e.c(str));
            } else if (1 == i2) {
                this.f20840f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
            } else {
                this.f20840f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
            } else {
                this.m.setVisibility(0);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void k(int i2, List<a> list, int i3, int i4) {
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f20841g.setVisibility(0);
            if (i2 > 0) {
                PraiseListActivity praiseListActivity = this.f20836b;
                if (praiseListActivity.pageType != 1) {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
                } else {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
                }
                this.f20838d.setTitleText(format2);
            } else {
                this.f20838d.setTitleText("");
            }
            if (list != null && list.size() >= 1) {
                this.f20839e.setVisibility(0);
                this.f20840f.setVisibility(8);
                this.f20835a.c(list);
                this.f20835a.notifyDataSetChanged();
                switch (i3) {
                    case 1001:
                        this.f20844j.setVisibility(0);
                        this.k.setVisibility(0);
                        this.l.setVisibility(8);
                        return;
                    case 1002:
                        this.f20844j.setVisibility(8);
                        return;
                    case 1003:
                        this.f20844j.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f20844j, R.drawable.bg_pack);
                        this.k.setVisibility(8);
                        this.l.setVisibility(0);
                        PraiseListActivity praiseListActivity2 = this.f20836b;
                        if (praiseListActivity2.pageType != 1) {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.praise_item_more), StringHelper.numFormatOverWan(i2));
                        } else {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
                        }
                        this.l.setText(format);
                        return;
                    default:
                        this.f20844j.setVisibility(8);
                        return;
                }
            }
            h(null, this.f20836b.pageType);
        }
    }
}
