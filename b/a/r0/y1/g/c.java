package b.a.r0.y1.g;

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
import b.a.e.f.p.k;
import b.a.r0.y1.g.a;
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
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f29125e;

    /* renamed from: f  reason: collision with root package name */
    public int f29126f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29127g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f29128h;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f29129a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f29130b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f29131c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f29132d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f29133e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f29134f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f29135g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f29136h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f29137i;
        public ImageView j;
        public ImageView k;
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

    /* renamed from: b.a.r0.y1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1418c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f29138a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f29139b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f29140c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f29141d;

        public C1418c() {
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

        public /* synthetic */ C1418c(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f29142a;

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
        this.f29127g = false;
        this.f29125e = memberPrivilegeActivity;
        this.f29128h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f29125e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1417a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1417a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1417a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f29111d) && TextUtils.getTrimmedLength(next.f29111d) > 0) {
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
                inflate = LayoutInflater.from(this.f29125e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                bVar = new b(null);
                bVar.f29129a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                bVar.f29130b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                bVar.f29133e = (TextView) inflate.findViewById(R.id.nonmembername);
                bVar.f29131c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                bVar.f29132d = (TextView) inflate.findViewById(R.id.membername);
                bVar.f29134f = (TbImageView) inflate.findViewById(R.id.membericon);
                bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                bVar.f29135g = (TextView) inflate.findViewById(R.id.endtime);
                bVar.f29136h = (TextView) inflate.findViewById(R.id.left_button);
                bVar.f29137i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.f29137i.setVisibility(8);
            } else {
                bVar.f29137i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f29123d) == null || (dVar = eVar.f29124e) == null) {
                return null;
            }
            long j = dVar.f29118a + dVar.f29119b;
            this.f29126f = (int) bVar2.f29112a;
            long j2 = bVar2.f29113b;
            String e2 = e(j2, bVar2.f29114c);
            bVar.f29129a.startLoad(eVar.f29122c, 25, false);
            SkinManager.setBackgroundResource(bVar.f29129a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.f29130b.setVisibility(8);
                bVar.f29131c.setVisibility(0);
                bVar.f29134f.startLoad(eVar.f29123d.f29115d, 21, false);
                if (this.f29127g) {
                    bVar.f29135g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f29126f) {
                        string = this.f29125e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f29125e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    bVar.f29135g.setText(this.f29125e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                    SkinManager.setViewTextColor(bVar.f29135g, R.color.CAM_X0101, 1);
                }
                bVar.f29132d.setText(eVar.f29121b);
                bVar.f29136h.setText(this.f29126f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                bVar.f29136h.setOnClickListener(this.f29125e);
                bVar.l.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
            } else {
                bVar.f29130b.setVisibility(0);
                bVar.f29131c.setVisibility(8);
                bVar.f29133e.setText(eVar.f29121b);
                bVar.f29136h.setText(R.string.dredge_member);
                bVar.f29136h.setOnClickListener(this.f29125e);
                bVar.m.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.f29135g, R.drawable.bg_dredge_tips);
            bVar.f29137i.setOnClickListener(this.f29125e);
            this.f29125e.getLayoutMode().k(z);
            this.f29125e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1418c c1418c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1418c)) {
                c1418c = (C1418c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f29125e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                c1418c = new C1418c(null);
                c1418c.f29138a = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1418c.f29139b = (TextView) view.findViewById(R.id.title);
                c1418c.f29140c = (TextView) view.findViewById(R.id.description);
                c1418c.f29141d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(c1418c);
            }
            if (getItemViewType(i2 - 1) == 1) {
                c1418c.f29141d.setVisibility(8);
            }
            a.C1417a c1417a = (a.C1417a) getItem(i2);
            c1418c.f29138a.startLoad(c1417a.f29108a, 10, false);
            c1418c.f29139b.setText(c1417a.f29109b);
            c1418c.f29140c.setText(c1417a.f29110c);
            this.f29125e.getLayoutMode().k(z);
            this.f29125e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final String e(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j - j2;
            int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
            if (i2 >= 0 || j3 > 345600) {
                return "";
            }
            this.f29127g = true;
            if (i2 >= 0 || j3 > 86400) {
                return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
            }
            return this.f29125e.getPageContext().getString(R.string.today);
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
                view = LayoutInflater.from(this.f29125e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.f29142a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.f29142a.setText((String) getItem(i2));
            this.f29125e.getLayoutMode().k(z);
            this.f29125e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1417a> arrayList) {
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
            ArrayList<Object> arrayList = this.f29128h;
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
            ArrayList<Object> arrayList = this.f29128h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f29128h.get(i2);
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
            if (this.f29128h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f29128h.size()) {
                Object obj = this.f29128h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1417a) {
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

    public void h(b.a.r0.y1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1417a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f29128h.clear();
            if (aVar == null || aVar.f29106a == null || (list = aVar.f29107b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.f29106a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.f29116a) && (arrayList = cVar.f29117b) != null && arrayList.size() != 0 && g(cVar.f29117b)) {
                    arrayList2.add(cVar.f29116a);
                    Iterator<a.C1417a> it = cVar.f29117b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f29128h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
