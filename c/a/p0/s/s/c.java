package c.a.p0.s.s;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14442a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<k> f14443b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f14444c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f14445d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f14446e;

    /* renamed from: f  reason: collision with root package name */
    public j f14447f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14448g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f14449h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14450i;

    /* renamed from: j  reason: collision with root package name */
    public AlertDialog f14451j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f14452e;

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
            this.f14452e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f14452e.f14444c != null) {
                    this.f14452e.f14444c.onItemClick(adapterView, view, i2, j2);
                }
                this.f14452e.f();
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
        this.f14450i = false;
        this.k = new a(this);
        this.f14449h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f14445d = viewGroup;
        this.f14448g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f14446e = (BdListView) this.f14445d.findViewById(R.id.dialog_content_list);
        this.f14447f = new j(this.f14449h);
    }

    public void b(c.a.e.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f14445d);
            }
            this.f14445d.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f14450i) {
                return this;
            }
            this.f14450i = true;
            if (!TextUtils.isEmpty(this.f14442a)) {
                this.f14448g.setText(this.f14442a);
                this.f14448g.setVisibility(0);
            } else {
                this.f14448g.setVisibility(8);
            }
            this.f14446e.setAdapter((ListAdapter) this.f14447f);
            this.f14447f.c(this.f14443b);
            b(this.f14449h);
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.f14451j) == null) {
            return;
        }
        c.a.e.e.m.g.a(alertDialog, this.f14449h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14445d : (View) invokeV.objValue;
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
            b(this.f14449h);
            j jVar = this.f14447f;
            if (jVar != null) {
                jVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            for (int i3 = 0; i3 < this.f14443b.size(); i3++) {
                if (i3 == i2) {
                    this.f14443b.get(i3).e(true);
                } else {
                    this.f14443b.get(i3).e(false);
                }
            }
            this.f14447f.c(this.f14443b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f14447f.b(z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (int i3 = 0; i3 < this.f14443b.size(); i3++) {
                if (i3 == i2) {
                    k kVar = this.f14443b.get(i3);
                    kVar.e(!kVar.d());
                }
            }
            this.f14447f.c(this.f14443b);
        }
    }

    public c k(ArrayList<k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f14443b = arrayList;
                if (onItemClickListener != null) {
                    this.f14444c = onItemClickListener;
                    this.f14446e.setOnItemClickListener(this.k);
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
            m(this.f14449h.getResources().getString(i2));
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f14442a = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f14450i) {
                AlertDialog alertDialog = this.f14451j;
                if (alertDialog != null) {
                    c.a.e.e.m.g.j(alertDialog, this.f14449h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f14449h.getPageActivity()).create();
                this.f14451j = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.e.e.m.g.i(this.f14451j, this.f14449h.getPageActivity())) {
                    Window window = this.f14451j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f14445d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (c) invokeV.objValue;
    }
}
