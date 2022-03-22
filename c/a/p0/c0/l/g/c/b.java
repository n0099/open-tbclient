package c.a.p0.c0.l.g.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.c0.l.g.c.c.a> f13319b;

    /* renamed from: c  reason: collision with root package name */
    public d f13320c;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.c0.l.g.c.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13321b;

        public a(b bVar, c.a.p0.c0.l.g.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13321b = bVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13321b.f13320c == null) {
                return;
            }
            this.f13321b.f13320c.a(this.a.b(0));
        }
    }

    /* renamed from: c.a.p0.c0.l.g.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1004b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.c0.l.g.c.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13322b;

        public View$OnClickListenerC1004b(b bVar, c.a.p0.c0.l.g.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13322b = bVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13322b.f13320c == null) {
                return;
            }
            this.f13322b.f13320c.a(this.a.b(1));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.c0.l.g.c.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13323b;

        public c(b bVar, c.a.p0.c0.l.g.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13323b = bVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13323b.f13320c == null) {
                return;
            }
            this.f13323b.f13320c.a(this.a.b(2));
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(c.a.p0.c0.l.g.c.c.b bVar);
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f13324b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13325c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f13326d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f13327e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f13328f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f13329g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13330h;
        public RelativeLayout i;
        public TextView j;
        public TextView k;
        public TbImageView l;
        public TextView m;
        public RelativeLayout n;
        public TextView o;
        public View p;
        public TextView q;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = tbPageContext;
        this.f13320c = dVar;
    }

    public final List<c.a.p0.c0.l.g.c.c.a> b(List<c.a.p0.c0.l.g.c.c.c> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                List<c.a.p0.c0.l.g.c.c.b> a2 = list.get(i2).a();
                int size = a2.size();
                if (size % 3 == 0) {
                    i = size / 3;
                } else {
                    i = (size / 3) + 1;
                }
                c.a.p0.c0.l.g.c.c.b[][] bVarArr = (c.a.p0.c0.l.g.c.c.b[][]) Array.newInstance(c.a.p0.c0.l.g.c.c.b.class, i, 3);
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = i3 / 3;
                    int i5 = i3 % 3;
                    bVarArr[i4][i5] = a2.get(i3);
                    bVarArr[i4][i5].o(list.get(i2).b());
                }
                arrayList2.add(bVarArr);
            }
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                for (int i7 = 0; i7 < ((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6)).length; i7++) {
                    c.a.p0.c0.l.g.c.c.a aVar = new c.a.p0.c0.l.g.c.c.a();
                    if (((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6)).length == 1) {
                        aVar.e(1);
                    } else if (((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6)).length > 1 && i7 == 0) {
                        aVar.e(2);
                    } else if (((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6)).length > 1 && i7 == ((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6)).length - 1) {
                        aVar.e(3);
                    } else {
                        aVar.e(4);
                    }
                    if (i6 == arrayList2.size() - 1) {
                        if (aVar.getType() == 1) {
                            aVar.e(2);
                        } else if (aVar.getType() == 3) {
                            aVar.e(4);
                        }
                    }
                    for (int i8 = 0; i8 < 3; i8++) {
                        if (((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6))[i7][i8] != null) {
                            aVar.a(((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6))[i7][i8]);
                        }
                    }
                    if (((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6))[0][0] != null) {
                        aVar.d(((c.a.p0.c0.l.g.c.c.b[][]) arrayList2.get(i6))[0][0].h());
                    }
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.q, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f13328f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f13327e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        if (TbadkApplication.getInst().getSkinType() == 1) {
            eVar.f13324b.setDefaultResource(R.drawable.obfuscated_res_0x7f080f26);
            eVar.f13329g.setDefaultResource(R.drawable.obfuscated_res_0x7f080f26);
            eVar.l.setDefaultResource(R.drawable.obfuscated_res_0x7f080f26);
        } else {
            eVar.f13324b.setDefaultResource(R.drawable.obfuscated_res_0x7f080f25);
            eVar.f13329g.setDefaultResource(R.drawable.obfuscated_res_0x7f080f25);
            eVar.l.setDefaultResource(R.drawable.obfuscated_res_0x7f080f25);
        }
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public void d(List<c.a.p0.c0.l.g.c.c.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        List<c.a.p0.c0.l.g.c.c.a> list2 = this.f13319b;
        if (list2 != null && list2.size() > 0) {
            this.f13319b.clear();
        }
        this.f13319b = b(list);
        notifyDataSetChanged();
    }

    public final void e(TbImageView tbImageView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbImageView, i) == null) || tbImageView == null) {
            return;
        }
        if (i == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i == 3) {
            tbImageView.setAlpha(0.2f);
        } else {
            tbImageView.setAlpha(1);
        }
    }

    public final void f(TextView textView, boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{textView, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                textView.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                textView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                textView.setText(AlaStringHelper.formatLowercasekDou((float) j));
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void g(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i) == null) || textView == null) {
            return;
        }
        if (i == 0) {
            textView.setText(R.string.obfuscated_res_0x7f0f01e9);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i == 1) {
            textView.setText(R.string.obfuscated_res_0x7f0f01ea);
            SkinManager.setViewTextColor(textView, (int) R.color.obfuscated_res_0x7f060774);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i == 2) {
            textView.setText(R.string.obfuscated_res_0x7f0f01e8);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i == 3) {
            textView.setText(R.string.obfuscated_res_0x7f0f01e7);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else {
            textView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<c.a.p0.c0.l.g.c.c.a> list = this.f13319b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<c.a.p0.c0.l.g.c.c.a> list = this.f13319b;
            if (list == null || i >= list.size()) {
                return null;
            }
            return this.f13319b.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            c.a.p0.c0.l.g.c.c.a aVar = this.f13319b.get(i);
            if (view == null) {
                view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00e7, viewGroup, false);
                eVar = new e(this, null);
                eVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b4);
                eVar.f13324b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0901af);
                eVar.f13325c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b7);
                eVar.f13326d = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0901ba);
                eVar.f13327e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901bd);
                eVar.f13328f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b5);
                eVar.f13329g = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0901b0);
                eVar.f13330h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b8);
                eVar.i = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0901bb);
                eVar.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901be);
                eVar.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b6);
                eVar.l = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0901b1);
                eVar.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b9);
                eVar.n = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0901bc);
                eVar.o = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901bf);
                eVar.p = view.findViewById(R.id.obfuscated_res_0x7f0901b2);
                eVar.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901b3);
            } else {
                eVar = (e) view.getTag();
            }
            c(eVar);
            if (aVar != null) {
                if (aVar.b(0) != null) {
                    c.a.p0.c0.l.g.c.c.b b2 = aVar.b(0);
                    eVar.f13326d.setVisibility(0);
                    eVar.a.setText(b2.e() == null ? "" : b2.e());
                    if (b2.f() != null) {
                        eVar.f13324b.setDefaultBgResource(R.color.transparent);
                        eVar.f13324b.J(b2.f(), 10, false);
                    }
                    g(eVar.f13325c, b2.j());
                    e(eVar.f13324b, b2.j());
                    f(eVar.f13327e, b2.m(), b2.n);
                    eVar.f13326d.setOnClickListener(new a(this, aVar));
                } else {
                    eVar.f13326d.setVisibility(4);
                    eVar.f13326d.setOnClickListener(null);
                }
                if (aVar.b(1) != null) {
                    c.a.p0.c0.l.g.c.c.b b3 = aVar.b(1);
                    eVar.i.setVisibility(0);
                    eVar.f13328f.setText(b3.e() == null ? "" : b3.e());
                    if (b3.f() != null) {
                        eVar.f13329g.setDefaultBgResource(R.color.transparent);
                        eVar.f13329g.J(b3.f(), 10, false);
                    }
                    g(eVar.f13330h, b3.j());
                    e(eVar.f13329g, b3.j());
                    f(eVar.j, b3.m(), b3.n);
                    eVar.i.setOnClickListener(new View$OnClickListenerC1004b(this, aVar));
                } else {
                    eVar.i.setVisibility(4);
                    eVar.i.setOnClickListener(null);
                }
                if (aVar.b(2) != null) {
                    c.a.p0.c0.l.g.c.c.b b4 = aVar.b(2);
                    eVar.n.setVisibility(0);
                    eVar.k.setText(b4.e() != null ? b4.e() : "");
                    if (b4.f() != null) {
                        eVar.l.setDefaultBgResource(R.color.transparent);
                        eVar.l.J(b4.f(), 10, false);
                    }
                    g(eVar.m, b4.j());
                    e(eVar.l, b4.j());
                    f(eVar.o, b4.m(), b4.n);
                    eVar.n.setOnClickListener(new c(this, aVar));
                } else {
                    eVar.n.setVisibility(4);
                    eVar.n.setOnClickListener(null);
                }
                if (aVar.getType() != 3 && aVar.getType() != 1) {
                    eVar.p.setVisibility(8);
                } else {
                    eVar.p.setVisibility(0);
                }
                if ((aVar.getType() == 1 || aVar.getType() == 2) && aVar.c() != null) {
                    eVar.q.setVisibility(0);
                    eVar.q.setText(aVar.c());
                } else {
                    eVar.q.setVisibility(8);
                }
            }
            view.setTag(eVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
