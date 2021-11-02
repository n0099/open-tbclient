package b.a.r0.w.l.g.c;

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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f25205e;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a.r0.w.l.g.c.b.a> f25206f;

    /* renamed from: g  reason: collision with root package name */
    public d f25207g;

    /* renamed from: b.a.r0.w.l.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1231a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.l.g.c.b.a f25208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25209f;

        public View$OnClickListenerC1231a(a aVar, b.a.r0.w.l.g.c.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25209f = aVar;
            this.f25208e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25209f.f25207g == null) {
                return;
            }
            this.f25209f.f25207g.a(this.f25208e.b(0));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.l.g.c.b.a f25210e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25211f;

        public b(a aVar, b.a.r0.w.l.g.c.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25211f = aVar;
            this.f25210e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25211f.f25207g == null) {
                return;
            }
            this.f25211f.f25207g.a(this.f25210e.b(1));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.l.g.c.b.a f25212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25213f;

        public c(a aVar, b.a.r0.w.l.g.c.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25213f = aVar;
            this.f25212e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25213f.f25207g == null) {
                return;
            }
            this.f25213f.f25207g.a(this.f25212e.b(2));
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(b.a.r0.w.l.g.c.b.b bVar);
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f25214a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25215b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25216c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f25217d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25218e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f25219f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f25220g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25221h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f25222i;
        public TextView j;
        public TextView k;
        public TbImageView l;
        public TextView m;
        public RelativeLayout n;
        public TextView o;
        public View p;
        public TextView q;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(a aVar, View$OnClickListenerC1231a view$OnClickListenerC1231a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25205e = null;
        this.f25205e = tbPageContext;
        this.f25207g = dVar;
    }

    public final List<b.a.r0.w.l.g.c.b.a> b(List<b.a.r0.w.l.g.c.b.c> list) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                List<b.a.r0.w.l.g.c.b.b> a2 = list.get(i3).a();
                int size = a2.size();
                if (size % 3 == 0) {
                    i2 = size / 3;
                } else {
                    i2 = (size / 3) + 1;
                }
                b.a.r0.w.l.g.c.b.b[][] bVarArr = (b.a.r0.w.l.g.c.b.b[][]) Array.newInstance(b.a.r0.w.l.g.c.b.b.class, i2, 3);
                for (int i4 = 0; i4 < size; i4++) {
                    int i5 = i4 / 3;
                    int i6 = i4 % 3;
                    bVarArr[i5][i6] = a2.get(i4);
                    bVarArr[i5][i6].o(list.get(i3).b());
                }
                arrayList2.add(bVarArr);
            }
            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                for (int i8 = 0; i8 < ((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7)).length; i8++) {
                    b.a.r0.w.l.g.c.b.a aVar = new b.a.r0.w.l.g.c.b.a();
                    if (((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7)).length == 1) {
                        aVar.e(1);
                    } else if (((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7)).length > 1 && i8 == 0) {
                        aVar.e(2);
                    } else if (((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7)).length > 1 && i8 == ((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7)).length - 1) {
                        aVar.e(3);
                    } else {
                        aVar.e(4);
                    }
                    if (i7 == arrayList2.size() - 1) {
                        if (aVar.getType() == 1) {
                            aVar.e(2);
                        } else if (aVar.getType() == 3) {
                            aVar.e(4);
                        }
                    }
                    for (int i9 = 0; i9 < 3; i9++) {
                        if (((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7))[i8][i9] != null) {
                            aVar.a(((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7))[i8][i9]);
                        }
                    }
                    if (((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7))[0][0] != null) {
                        aVar.d(((b.a.r0.w.l.g.c.b.b[][]) arrayList2.get(i7))[0][0].h());
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
        SkinManager.setViewTextColor(eVar.f25214a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f25219f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f25218e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        if (TbadkApplication.getInst().getSkinType() == 1) {
            eVar.f25215b.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.f25220g.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor_1);
        } else {
            eVar.f25215b.setDefaultResource(R.drawable.pic_live_honor);
            eVar.f25220g.setDefaultResource(R.drawable.pic_live_honor);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor);
        }
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public void d(List<b.a.r0.w.l.g.c.b.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        List<b.a.r0.w.l.g.c.b.a> list2 = this.f25206f;
        if (list2 != null && list2.size() > 0) {
            this.f25206f.clear();
        }
        this.f25206f = b(list);
        notifyDataSetChanged();
    }

    public final void e(TbImageView tbImageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbImageView, i2) == null) || tbImageView == null) {
            return;
        }
        if (i2 == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i2 == 3) {
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
                int dimensionPixelSize = this.f25205e.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawablePadding(this.f25205e.getResources().getDimensionPixelSize(R.dimen.ds4));
                textView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                textView.setText(AlaStringHelper.formatLowercasekDou((float) j));
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void g(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i2) == null) || textView == null) {
            return;
        }
        if (i2 == 0) {
            textView.setText(R.string.ala_achievement_mark_status_unlock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i2 == 1) {
            textView.setText(R.string.ala_achievement_mark_status_wear);
            SkinManager.setViewTextColor(textView, R.color.live_cp_other_b);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i2 == 2) {
            textView.setText(R.string.ala_achievement_mark_status_lock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i2 == 3) {
            textView.setText(R.string.ala_achievement_mark_status_expired);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
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
            List<b.a.r0.w.l.g.c.b.a> list = this.f25206f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<b.a.r0.w.l.g.c.b.a> list = this.f25206f;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f25206f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            b.a.r0.w.l.g.c.b.a aVar = this.f25206f.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f25205e.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
                eVar = new e(this, null);
                eVar.f25214a = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
                eVar.f25215b = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
                eVar.f25216c = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
                eVar.f25217d = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
                eVar.f25218e = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
                eVar.f25219f = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
                eVar.f25220g = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
                eVar.f25221h = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
                eVar.f25222i = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
                eVar.j = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
                eVar.k = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
                eVar.l = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
                eVar.m = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
                eVar.n = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
                eVar.o = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
                eVar.p = view.findViewById(R.id.ala_achievement_mark_item_line);
                eVar.q = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            } else {
                eVar = (e) view.getTag();
            }
            c(eVar);
            if (aVar != null) {
                if (aVar.b(0) != null) {
                    b.a.r0.w.l.g.c.b.b b2 = aVar.b(0);
                    eVar.f25217d.setVisibility(0);
                    eVar.f25214a.setText(b2.e() == null ? "" : b2.e());
                    if (b2.f() != null) {
                        eVar.f25215b.setDefaultBgResource(R.color.transparent);
                        eVar.f25215b.startLoad(b2.f(), 10, false);
                    }
                    g(eVar.f25216c, b2.j());
                    e(eVar.f25215b, b2.j());
                    f(eVar.f25218e, b2.m(), b2.n);
                    eVar.f25217d.setOnClickListener(new View$OnClickListenerC1231a(this, aVar));
                } else {
                    eVar.f25217d.setVisibility(4);
                    eVar.f25217d.setOnClickListener(null);
                }
                if (aVar.b(1) != null) {
                    b.a.r0.w.l.g.c.b.b b3 = aVar.b(1);
                    eVar.f25222i.setVisibility(0);
                    eVar.f25219f.setText(b3.e() == null ? "" : b3.e());
                    if (b3.f() != null) {
                        eVar.f25220g.setDefaultBgResource(R.color.transparent);
                        eVar.f25220g.startLoad(b3.f(), 10, false);
                    }
                    g(eVar.f25221h, b3.j());
                    e(eVar.f25220g, b3.j());
                    f(eVar.j, b3.m(), b3.n);
                    eVar.f25222i.setOnClickListener(new b(this, aVar));
                } else {
                    eVar.f25222i.setVisibility(4);
                    eVar.f25222i.setOnClickListener(null);
                }
                if (aVar.b(2) != null) {
                    b.a.r0.w.l.g.c.b.b b4 = aVar.b(2);
                    eVar.n.setVisibility(0);
                    eVar.k.setText(b4.e() != null ? b4.e() : "");
                    if (b4.f() != null) {
                        eVar.l.setDefaultBgResource(R.color.transparent);
                        eVar.l.startLoad(b4.f(), 10, false);
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
