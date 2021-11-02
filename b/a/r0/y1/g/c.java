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
import b.a.e.e.p.k;
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
    public MemberPrivilegeActivity f27622e;

    /* renamed from: f  reason: collision with root package name */
    public int f27623f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27624g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f27625h;

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
        public HeadImageView f27626a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f27627b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f27628c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27629d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f27630e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f27631f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f27632g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f27633h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f27634i;
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
    public static class C1351c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f27635a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f27636b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27637c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f27638d;

        public C1351c() {
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

        public /* synthetic */ C1351c(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f27639a;

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
        this.f27624g = false;
        this.f27622e = memberPrivilegeActivity;
        this.f27625h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f27622e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1350a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1350a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1350a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f27608d) && TextUtils.getTrimmedLength(next.f27608d) > 0) {
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
                inflate = LayoutInflater.from(this.f27622e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                bVar = new b(null);
                bVar.f27626a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                bVar.f27627b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                bVar.f27630e = (TextView) inflate.findViewById(R.id.nonmembername);
                bVar.f27628c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                bVar.f27629d = (TextView) inflate.findViewById(R.id.membername);
                bVar.f27631f = (TbImageView) inflate.findViewById(R.id.membericon);
                bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                bVar.f27632g = (TextView) inflate.findViewById(R.id.endtime);
                bVar.f27633h = (TextView) inflate.findViewById(R.id.left_button);
                bVar.f27634i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.f27634i.setVisibility(8);
            } else {
                bVar.f27634i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f27620d) == null || (dVar = eVar.f27621e) == null) {
                return null;
            }
            long j = dVar.f27615a + dVar.f27616b;
            this.f27623f = (int) bVar2.f27609a;
            long j2 = bVar2.f27610b;
            String e2 = e(j2, bVar2.f27611c);
            bVar.f27626a.startLoad(eVar.f27619c, 25, false);
            SkinManager.setBackgroundResource(bVar.f27626a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.f27627b.setVisibility(8);
                bVar.f27628c.setVisibility(0);
                bVar.f27631f.startLoad(eVar.f27620d.f27612d, 21, false);
                if (this.f27624g) {
                    bVar.f27632g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f27623f) {
                        string = this.f27622e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f27622e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    bVar.f27632g.setText(this.f27622e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                    SkinManager.setViewTextColor(bVar.f27632g, R.color.CAM_X0101, 1);
                }
                bVar.f27629d.setText(eVar.f27618b);
                bVar.f27633h.setText(this.f27623f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                bVar.f27633h.setOnClickListener(this.f27622e);
                bVar.l.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
            } else {
                bVar.f27627b.setVisibility(0);
                bVar.f27628c.setVisibility(8);
                bVar.f27630e.setText(eVar.f27618b);
                bVar.f27633h.setText(R.string.dredge_member);
                bVar.f27633h.setOnClickListener(this.f27622e);
                bVar.m.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.f27632g, R.drawable.bg_dredge_tips);
            bVar.f27634i.setOnClickListener(this.f27622e);
            this.f27622e.getLayoutMode().k(z);
            this.f27622e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1351c c1351c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1351c)) {
                c1351c = (C1351c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f27622e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                c1351c = new C1351c(null);
                c1351c.f27635a = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1351c.f27636b = (TextView) view.findViewById(R.id.title);
                c1351c.f27637c = (TextView) view.findViewById(R.id.description);
                c1351c.f27638d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(c1351c);
            }
            if (getItemViewType(i2 - 1) == 1) {
                c1351c.f27638d.setVisibility(8);
            }
            a.C1350a c1350a = (a.C1350a) getItem(i2);
            c1351c.f27635a.startLoad(c1350a.f27605a, 10, false);
            c1351c.f27636b.setText(c1350a.f27606b);
            c1351c.f27637c.setText(c1350a.f27607c);
            this.f27622e.getLayoutMode().k(z);
            this.f27622e.getLayoutMode().j(view);
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
            this.f27624g = true;
            if (i2 >= 0 || j3 > 86400) {
                return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
            }
            return this.f27622e.getPageContext().getString(R.string.today);
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
                view = LayoutInflater.from(this.f27622e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.f27639a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.f27639a.setText((String) getItem(i2));
            this.f27622e.getLayoutMode().k(z);
            this.f27622e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1350a> arrayList) {
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
            ArrayList<Object> arrayList = this.f27625h;
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
            ArrayList<Object> arrayList = this.f27625h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f27625h.get(i2);
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
            if (this.f27625h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f27625h.size()) {
                Object obj = this.f27625h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1350a) {
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
        ArrayList<a.C1350a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f27625h.clear();
            if (aVar == null || aVar.f27603a == null || (list = aVar.f27604b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.f27603a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.f27613a) && (arrayList = cVar.f27614b) != null && arrayList.size() != 0 && g(cVar.f27614b)) {
                    arrayList2.add(cVar.f27613a);
                    Iterator<a.C1350a> it = cVar.f27614b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f27625h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
