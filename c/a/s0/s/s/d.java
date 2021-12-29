package c.a.s0.s.s;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<l> f13896b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f13897c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f13898d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f13899e;

    /* renamed from: f  reason: collision with root package name */
    public k f13900f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13901g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13902h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13903i;

    /* renamed from: j  reason: collision with root package name */
    public AlertDialog f13904j;

    /* renamed from: k  reason: collision with root package name */
    public AdapterView.OnItemClickListener f13905k;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f13906e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13906e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f13906e.f13897c != null) {
                    this.f13906e.f13897c.onItemClick(adapterView, view, i2, j2);
                }
                this.f13906e.f();
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
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
        this.f13903i = false;
        this.f13905k = new a(this);
        this.f13902h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f13898d = viewGroup;
        this.f13901g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f13899e = (BdListView) this.f13898d.findViewById(R.id.dialog_content_list);
        this.f13900f = new k(this.f13902h);
    }

    public void b(c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f13898d);
            }
            this.f13898d.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f13903i) {
                return this;
            }
            this.f13903i = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.f13901g.setText(this.a);
                this.f13901g.setVisibility(0);
            } else {
                this.f13901g.setVisibility(8);
            }
            this.f13899e.setAdapter((ListAdapter) this.f13900f);
            this.f13900f.c(this.f13896b);
            b(this.f13902h);
            return this;
        }
        return (d) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.f13904j) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.f13902h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13898d : (View) invokeV.objValue;
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
            b(this.f13902h);
            k kVar = this.f13900f;
            if (kVar != null) {
                kVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13896b.size(); i3++) {
                if (i3 == i2) {
                    this.f13896b.get(i3).e(true);
                } else {
                    this.f13896b.get(i3).e(false);
                }
            }
            this.f13900f.c(this.f13896b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f13900f.b(z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13896b.size(); i3++) {
                if (i3 == i2) {
                    l lVar = this.f13896b.get(i3);
                    lVar.e(!lVar.d());
                }
            }
            this.f13900f.c(this.f13896b);
        }
    }

    public d k(ArrayList<l> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f13896b = arrayList;
                if (onItemClickListener != null) {
                    this.f13897c = onItemClickListener;
                    this.f13899e.setOnItemClickListener(this.f13905k);
                }
            }
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public d l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            m(this.f13902h.getResources().getString(i2));
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f13903i) {
                AlertDialog alertDialog = this.f13904j;
                if (alertDialog != null) {
                    c.a.d.f.m.g.j(alertDialog, this.f13902h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f13902h.getPageActivity()).create();
                this.f13904j = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.d.f.m.g.i(this.f13904j, this.f13902h.getPageActivity())) {
                    Window window = this.f13904j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f13898d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (d) invokeV.objValue;
    }
}
