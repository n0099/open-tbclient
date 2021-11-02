package b.a.q0.s.s;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13537a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<k> f13538b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f13539c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f13540d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f13541e;

    /* renamed from: f  reason: collision with root package name */
    public j f13542f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13543g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13544h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13545i;
    public AlertDialog j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13546e;

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
            this.f13546e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f13546e.f13539c != null) {
                    this.f13546e.f13539c.onItemClick(adapterView, view, i2, j);
                }
                this.f13546e.f();
            }
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13545i = false;
        this.k = new a(this);
        this.f13544h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f13540d = viewGroup;
        this.f13543g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f13541e = (BdListView) this.f13540d.findViewById(R.id.dialog_content_list);
        this.f13542f = new j(this.f13544h);
    }

    public void b(b.a.e.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f13540d);
            }
            this.f13540d.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f13545i) {
                return this;
            }
            this.f13545i = true;
            if (!TextUtils.isEmpty(this.f13537a)) {
                this.f13543g.setText(this.f13537a);
                this.f13543g.setVisibility(0);
            } else {
                this.f13543g.setVisibility(8);
            }
            this.f13541e.setAdapter((ListAdapter) this.f13542f);
            this.f13542f.c(this.f13538b);
            b(this.f13544h);
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.j) == null) {
            return;
        }
        b.a.e.e.m.g.a(alertDialog, this.f13544h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13540d : (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b(this.f13544h);
            j jVar = this.f13542f;
            if (jVar != null) {
                jVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13538b.size(); i3++) {
                if (i3 == i2) {
                    this.f13538b.get(i3).e(true);
                } else {
                    this.f13538b.get(i3).e(false);
                }
            }
            this.f13542f.c(this.f13538b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f13542f.b(z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13538b.size(); i3++) {
                if (i3 == i2) {
                    k kVar = this.f13538b.get(i3);
                    kVar.e(!kVar.d());
                }
            }
            this.f13542f.c(this.f13538b);
        }
    }

    public c k(ArrayList<k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f13538b = arrayList;
                if (onItemClickListener != null) {
                    this.f13539c = onItemClickListener;
                    this.f13541e.setOnItemClickListener(this.k);
                }
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            m(this.f13544h.getResources().getString(i2));
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f13537a = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f13545i) {
                AlertDialog alertDialog = this.j;
                if (alertDialog != null) {
                    b.a.e.e.m.g.j(alertDialog, this.f13544h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f13544h.getPageActivity()).create();
                this.j = create;
                create.setCanceledOnTouchOutside(true);
                if (b.a.e.e.m.g.i(this.j, this.f13544h.getPageActivity())) {
                    Window window = this.j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f13540d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (c) invokeV.objValue;
    }
}
