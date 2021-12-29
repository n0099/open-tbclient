package c.a.t0.f2.g;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.t0.f2.g.a;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f18076e;

    /* renamed from: f  reason: collision with root package name */
    public int f18077f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18078g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f18079h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f18080b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f18081c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18082d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18083e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f18084f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18085g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18086h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f18087i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f18088j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f18089k;
        public TextView l;
        public TextView m;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: c.a.t0.f2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1093c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18090b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18091c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18092d;

        public C1093c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1093c(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPrivilegeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18078g = false;
        this.f18076e = memberPrivilegeActivity;
        this.f18079h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f18076e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1092a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1092a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1092a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f18066d) && TextUtils.getTrimmedLength(next.f18066d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View inflate;
        b bVar;
        a.e eVar;
        a.b bVar2;
        a.d dVar;
        String string;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
                inflate = view;
            } else {
                inflate = LayoutInflater.from(this.f18076e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                bVar = new b(null);
                bVar.a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                bVar.f18080b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                bVar.f18083e = (TextView) inflate.findViewById(R.id.nonmembername);
                bVar.f18081c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                bVar.f18082d = (TextView) inflate.findViewById(R.id.membername);
                bVar.f18084f = (TbImageView) inflate.findViewById(R.id.membericon);
                bVar.f18088j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                bVar.f18089k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                bVar.f18085g = (TextView) inflate.findViewById(R.id.endtime);
                bVar.f18086h = (TextView) inflate.findViewById(R.id.left_button);
                bVar.f18087i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.f18087i.setVisibility(8);
            } else {
                bVar.f18087i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f18074d) == null || (dVar = eVar.f18075e) == null) {
                return null;
            }
            long j2 = dVar.a + dVar.f18071b;
            this.f18077f = (int) bVar2.a;
            long j3 = bVar2.f18067b;
            String e2 = e(j3, bVar2.f18068c);
            bVar.a.startLoad(eVar.f18073c, 25, false);
            SkinManager.setBackgroundResource(bVar.a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j2 = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.f18080b.setVisibility(8);
                bVar.f18081c.setVisibility(0);
                bVar.f18084f.startLoad(eVar.f18074d.f18069d, 21, false);
                if (this.f18078g) {
                    bVar.f18085g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f18077f) {
                        string = this.f18076e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f18076e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    bVar.f18085g.setText(this.f18076e.getResources().getString(R.string.endtiem_memeber_tip, string, m.getDateStringDay(new Date(j3 * 1000))));
                    SkinManager.setViewTextColor(bVar.f18085g, R.color.CAM_X0101, 1);
                }
                bVar.f18082d.setText(eVar.f18072b);
                bVar.f18086h.setText(this.f18077f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                bVar.f18086h.setOnClickListener(this.f18076e);
                bVar.l.setText(String.valueOf(j2));
                SkinManager.setImageResource(bVar.f18088j, R.drawable.icon_vip_dou);
            } else {
                bVar.f18080b.setVisibility(0);
                bVar.f18081c.setVisibility(8);
                bVar.f18083e.setText(eVar.f18072b);
                bVar.f18086h.setText(R.string.dredge_member);
                bVar.f18086h.setOnClickListener(this.f18076e);
                bVar.m.setText(String.valueOf(j2));
                SkinManager.setImageResource(bVar.f18089k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.f18085g, R.drawable.bg_dredge_tips);
            bVar.f18087i.setOnClickListener(this.f18076e);
            this.f18076e.getLayoutMode().k(z);
            this.f18076e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1093c c1093c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1093c)) {
                c1093c = (C1093c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f18076e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                c1093c = new C1093c(null);
                c1093c.a = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1093c.f18090b = (TextView) view.findViewById(R.id.title);
                c1093c.f18091c = (TextView) view.findViewById(R.id.description);
                c1093c.f18092d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(c1093c);
            }
            if (getItemViewType(i2 - 1) == 1) {
                c1093c.f18092d.setVisibility(8);
            }
            a.C1092a c1092a = (a.C1092a) getItem(i2);
            c1093c.a.startLoad(c1092a.a, 10, false);
            c1093c.f18090b.setText(c1092a.f18064b);
            c1093c.f18091c.setText(c1092a.f18065c);
            this.f18076e.getLayoutMode().k(z);
            this.f18076e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final String e(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 - j3;
            int i2 = (0L > j4 ? 1 : (0L == j4 ? 0 : -1));
            if (i2 >= 0 || j4 > 345600) {
                return "";
            }
            this.f18078g = true;
            if (i2 >= 0 || j4 > 86400) {
                return (86400 >= j4 || j4 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j4 || j4 > 259200) ? "3" : "2" : "1";
            }
            return this.f18076e.getPageContext().getString(R.string.today);
        }
        return (String) invokeCommon.objValue;
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f18076e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.a.setText((String) getItem(i2));
            this.f18076e.getLayoutMode().k(z);
            this.f18076e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1092a> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                b(arrayList);
                if (arrayList.size() > 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<Object> arrayList = this.f18079h;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<Object> arrayList = this.f18079h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f18079h.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.f18079h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f18079h.size()) {
                Object obj = this.f18079h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1092a) {
                    return 2;
                }
            }
            return 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                return c(i2, view, viewGroup);
            }
            if (itemViewType == 1) {
                return f(i2, view, viewGroup);
            }
            if (itemViewType == 2) {
                return d(i2, view, viewGroup);
            }
            if (itemViewType == 3) {
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public void h(c.a.t0.f2.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1092a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f18079h.clear();
            if (aVar == null || aVar.a == null || (list = aVar.f18063b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a) && (arrayList = cVar.f18070b) != null && arrayList.size() != 0 && g(cVar.f18070b)) {
                    arrayList2.add(cVar.a);
                    Iterator<a.C1092a> it = cVar.f18070b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f18079h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
