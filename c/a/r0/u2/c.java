package c.a.r0.u2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f25215a;

    /* renamed from: b  reason: collision with root package name */
    public View f25216b;

    /* renamed from: c  reason: collision with root package name */
    public View f25217c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f25218d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.v1.d f25219e;

    /* renamed from: f  reason: collision with root package name */
    public View f25220f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.s.a f25221g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f25222h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25223i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25224e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25224e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25224e.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25225e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25225e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                TiebaStatic.log(new StatisticItem("c12403").param("fid", this.f25225e.f25215a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f25225e.f25215a.mForumName));
                String str = (String) this.f25225e.f25218d.getItemAtPosition(i2 + 1);
                this.f25225e.f25215a.setEditSearchText(str);
                this.f25225e.f25215a.startSearch(str);
                PostSearchActivity unused = this.f25225e.f25215a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", this.f25225e.f25215a.mForumId));
            }
        }
    }

    /* renamed from: c.a.r0.u2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1172c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25226e;

        public View$OnTouchListenerC1172c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25226e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f25226e.f25215a.hideSoftKeyPad();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25227e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25227e = cVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f25227e.f25215a.getModel().g();
                this.f25227e.f25218d.setVisibility(8);
                this.f25227e.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25228e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25228e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f25228e.f25215a.hideSoftKeyPad();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25219e = null;
        this.f25220f = null;
        this.f25223i = false;
        this.f25215a = postSearchActivity;
        this.f25216b = view;
        h();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25217c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25223i = false;
            this.f25215a.hideLoadingView(this.f25217c);
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f25222h) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25217c = this.f25215a.findViewById(R.id.history_frame);
            this.f25218d = (BdListView) this.f25216b.findViewById(R.id.history_list);
            BdListViewHelper.d(this.f25215a.getActivity(), this.f25218d, BdListViewHelper.HeadType.DEFAULT);
            c.a.r0.v1.d dVar = new c.a.r0.v1.d(this.f25215a.getPageContext().getPageActivity(), null);
            this.f25219e = dVar;
            dVar.b(false);
            this.f25218d.setAdapter((ListAdapter) this.f25219e);
            View inflate = LayoutInflater.from(this.f25215a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
            this.f25220f = inflate;
            this.f25218d.addFooterView(inflate);
            this.f25220f.setOnClickListener(new a(this));
            this.f25218d.setOnItemClickListener(new b(this));
            this.f25218d.setOnTouchListener(new View$OnTouchListenerC1172c(this));
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f25217c.getVisibility() != 0 || this.f25223i) {
                return false;
            }
            NoDataView noDataView = this.f25222h;
            return noDataView == null || 8 == noDataView.getVisibility();
        }
        return invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c.a.q0.w0.a.a(this.f25215a.getPageContext(), this.f25220f);
            this.f25219e.notifyDataSetChanged();
            NoDataView noDataView = this.f25222h;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f25215a.getPageContext(), i2);
            }
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f25217c.setVisibility(0);
            f();
            if (arrayList != null && arrayList.size() != 0) {
                g();
                this.f25218d.setVisibility(0);
                this.f25219e.a(arrayList);
                this.f25219e.notifyDataSetChanged();
                return;
            }
            this.f25218d.setVisibility(8);
            n();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f25221g == null) {
                this.f25221g = new c.a.q0.s.s.a(this.f25215a.getPageContext().getPageActivity()).setMessage(this.f25215a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f25215a.getPageContext().getString(R.string.clear_all_text), new e(this)).setNegativeButton(this.f25215a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f25215a.getPageContext());
            }
            this.f25221g.show();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f25223i = true;
            PostSearchActivity postSearchActivity = this.f25215a;
            postSearchActivity.showLoadingView(this.f25217c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(R.string.new_text_no_search_record);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f25222h == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f25215a.getPageContext().getPageActivity(), this.f25217c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f25215a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
                this.f25222h = a2;
                a2.onChangeSkinType(this.f25215a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.f25222h.setOnTouchListener(new f(this));
            }
            this.f25222h.setTextOption(NoDataViewFactory.e.d(null, this.f25215a.getResources().getString(i2)));
            this.f25222h.setVisibility(0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25218d.setVisibility(8);
            o(R.string.new_text_no_search_result);
        }
    }
}
