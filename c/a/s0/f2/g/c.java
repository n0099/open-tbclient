package c.a.s0.f2.g;

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
import c.a.d.f.p.l;
import c.a.s0.f2.g.a;
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
    public MemberPrivilegeActivity f17571e;

    /* renamed from: f  reason: collision with root package name */
    public int f17572f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17573g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f17574h;

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
        public RelativeLayout f17575b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f17576c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17577d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17578e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f17579f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17580g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17581h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f17582i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f17583j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f17584k;
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

    /* renamed from: c.a.s0.f2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1068c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17585b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17586c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17587d;

        public C1068c() {
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

        public /* synthetic */ C1068c(a aVar) {
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
        this.f17573g = false;
        this.f17571e = memberPrivilegeActivity;
        this.f17574h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f17571e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1067a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1067a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1067a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f17561d) && TextUtils.getTrimmedLength(next.f17561d) > 0) {
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
                inflate = LayoutInflater.from(this.f17571e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                bVar = new b(null);
                bVar.a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                bVar.f17575b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                bVar.f17578e = (TextView) inflate.findViewById(R.id.nonmembername);
                bVar.f17576c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                bVar.f17577d = (TextView) inflate.findViewById(R.id.membername);
                bVar.f17579f = (TbImageView) inflate.findViewById(R.id.membericon);
                bVar.f17583j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                bVar.f17584k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                bVar.f17580g = (TextView) inflate.findViewById(R.id.endtime);
                bVar.f17581h = (TextView) inflate.findViewById(R.id.left_button);
                bVar.f17582i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.f17582i.setVisibility(8);
            } else {
                bVar.f17582i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f17569d) == null || (dVar = eVar.f17570e) == null) {
                return null;
            }
            long j2 = dVar.a + dVar.f17566b;
            this.f17572f = (int) bVar2.a;
            long j3 = bVar2.f17562b;
            String e2 = e(j3, bVar2.f17563c);
            bVar.a.startLoad(eVar.f17568c, 25, false);
            SkinManager.setBackgroundResource(bVar.a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j2 = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.f17575b.setVisibility(8);
                bVar.f17576c.setVisibility(0);
                bVar.f17579f.startLoad(eVar.f17569d.f17564d, 21, false);
                if (this.f17573g) {
                    bVar.f17580g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f17572f) {
                        string = this.f17571e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f17571e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    bVar.f17580g.setText(this.f17571e.getResources().getString(R.string.endtiem_memeber_tip, string, l.getDateStringDay(new Date(j3 * 1000))));
                    SkinManager.setViewTextColor(bVar.f17580g, R.color.CAM_X0101, 1);
                }
                bVar.f17577d.setText(eVar.f17567b);
                bVar.f17581h.setText(this.f17572f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                bVar.f17581h.setOnClickListener(this.f17571e);
                bVar.l.setText(String.valueOf(j2));
                SkinManager.setImageResource(bVar.f17583j, R.drawable.icon_vip_dou);
            } else {
                bVar.f17575b.setVisibility(0);
                bVar.f17576c.setVisibility(8);
                bVar.f17578e.setText(eVar.f17567b);
                bVar.f17581h.setText(R.string.dredge_member);
                bVar.f17581h.setOnClickListener(this.f17571e);
                bVar.m.setText(String.valueOf(j2));
                SkinManager.setImageResource(bVar.f17584k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.f17580g, R.drawable.bg_dredge_tips);
            bVar.f17582i.setOnClickListener(this.f17571e);
            this.f17571e.getLayoutMode().k(z);
            this.f17571e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1068c c1068c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1068c)) {
                c1068c = (C1068c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f17571e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                c1068c = new C1068c(null);
                c1068c.a = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1068c.f17585b = (TextView) view.findViewById(R.id.title);
                c1068c.f17586c = (TextView) view.findViewById(R.id.description);
                c1068c.f17587d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(c1068c);
            }
            if (getItemViewType(i2 - 1) == 1) {
                c1068c.f17587d.setVisibility(8);
            }
            a.C1067a c1067a = (a.C1067a) getItem(i2);
            c1068c.a.startLoad(c1067a.a, 10, false);
            c1068c.f17585b.setText(c1067a.f17559b);
            c1068c.f17586c.setText(c1067a.f17560c);
            this.f17571e.getLayoutMode().k(z);
            this.f17571e.getLayoutMode().j(view);
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
            this.f17573g = true;
            if (i2 >= 0 || j4 > 86400) {
                return (86400 >= j4 || j4 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j4 || j4 > 259200) ? "3" : "2" : "1";
            }
            return this.f17571e.getPageContext().getString(R.string.today);
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
                view = LayoutInflater.from(this.f17571e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.a.setText((String) getItem(i2));
            this.f17571e.getLayoutMode().k(z);
            this.f17571e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1067a> arrayList) {
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
            ArrayList<Object> arrayList = this.f17574h;
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
            ArrayList<Object> arrayList = this.f17574h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f17574h.get(i2);
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
            if (this.f17574h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f17574h.size()) {
                Object obj = this.f17574h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1067a) {
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

    public void h(c.a.s0.f2.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1067a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f17574h.clear();
            if (aVar == null || aVar.a == null || (list = aVar.f17558b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a) && (arrayList = cVar.f17565b) != null && arrayList.size() != 0 && g(cVar.f17565b)) {
                    arrayList2.add(cVar.a);
                    Iterator<a.C1067a> it = cVar.f17565b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f17574h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
