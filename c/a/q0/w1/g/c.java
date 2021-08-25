package c.a.q0.w1.g;

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
import c.a.e.e.p.k;
import c.a.q0.w1.g.a;
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
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f28022e;

    /* renamed from: f  reason: collision with root package name */
    public int f28023f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28024g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f28025h;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f28026a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f28027b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f28028c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f28029d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f28030e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f28031f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f28032g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f28033h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f28034i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f28035j;
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

    /* renamed from: c.a.q0.w1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1307c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f28036a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f28037b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f28038c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f28039d;

        public C1307c() {
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

        public /* synthetic */ C1307c(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f28040a;

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
        this.f28024g = false;
        this.f28022e = memberPrivilegeActivity;
        this.f28025h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f28022e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1306a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1306a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1306a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f28008d) && TextUtils.getTrimmedLength(next.f28008d) > 0) {
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
                inflate = LayoutInflater.from(this.f28022e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                bVar = new b(null);
                bVar.f28026a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                bVar.f28027b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                bVar.f28030e = (TextView) inflate.findViewById(R.id.nonmembername);
                bVar.f28028c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                bVar.f28029d = (TextView) inflate.findViewById(R.id.membername);
                bVar.f28031f = (TbImageView) inflate.findViewById(R.id.membericon);
                bVar.f28035j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                bVar.f28032g = (TextView) inflate.findViewById(R.id.endtime);
                bVar.f28033h = (TextView) inflate.findViewById(R.id.left_button);
                bVar.f28034i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.f28034i.setVisibility(8);
            } else {
                bVar.f28034i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f28020d) == null || (dVar = eVar.f28021e) == null) {
                return null;
            }
            long j2 = dVar.f28015a + dVar.f28016b;
            this.f28023f = (int) bVar2.f28009a;
            long j3 = bVar2.f28010b;
            String e2 = e(j3, bVar2.f28011c);
            bVar.f28026a.startLoad(eVar.f28019c, 25, false);
            SkinManager.setBackgroundResource(bVar.f28026a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j2 = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.f28027b.setVisibility(8);
                bVar.f28028c.setVisibility(0);
                bVar.f28031f.startLoad(eVar.f28020d.f28012d, 21, false);
                if (this.f28024g) {
                    bVar.f28032g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f28023f) {
                        string = this.f28022e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f28022e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    bVar.f28032g.setText(this.f28022e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j3 * 1000))));
                    SkinManager.setViewTextColor(bVar.f28032g, R.color.CAM_X0101, 1);
                }
                bVar.f28029d.setText(eVar.f28018b);
                bVar.f28033h.setText(this.f28023f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                bVar.f28033h.setOnClickListener(this.f28022e);
                bVar.l.setText(String.valueOf(j2));
                SkinManager.setImageResource(bVar.f28035j, R.drawable.icon_vip_dou);
            } else {
                bVar.f28027b.setVisibility(0);
                bVar.f28028c.setVisibility(8);
                bVar.f28030e.setText(eVar.f28018b);
                bVar.f28033h.setText(R.string.dredge_member);
                bVar.f28033h.setOnClickListener(this.f28022e);
                bVar.m.setText(String.valueOf(j2));
                SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.f28032g, R.drawable.bg_dredge_tips);
            bVar.f28034i.setOnClickListener(this.f28022e);
            this.f28022e.getLayoutMode().k(z);
            this.f28022e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1307c c1307c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1307c)) {
                c1307c = (C1307c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f28022e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                c1307c = new C1307c(null);
                c1307c.f28036a = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1307c.f28037b = (TextView) view.findViewById(R.id.title);
                c1307c.f28038c = (TextView) view.findViewById(R.id.description);
                c1307c.f28039d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(c1307c);
            }
            if (getItemViewType(i2 - 1) == 1) {
                c1307c.f28039d.setVisibility(8);
            }
            a.C1306a c1306a = (a.C1306a) getItem(i2);
            c1307c.f28036a.startLoad(c1306a.f28005a, 10, false);
            c1307c.f28037b.setText(c1306a.f28006b);
            c1307c.f28038c.setText(c1306a.f28007c);
            this.f28022e.getLayoutMode().k(z);
            this.f28022e.getLayoutMode().j(view);
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
            this.f28024g = true;
            if (i2 >= 0 || j4 > 86400) {
                return (86400 >= j4 || j4 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j4 || j4 > 259200) ? "3" : "2" : "1";
            }
            return this.f28022e.getPageContext().getString(R.string.today);
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
                view = LayoutInflater.from(this.f28022e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.f28040a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.f28040a.setText((String) getItem(i2));
            this.f28022e.getLayoutMode().k(z);
            this.f28022e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1306a> arrayList) {
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
            ArrayList<Object> arrayList = this.f28025h;
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
            ArrayList<Object> arrayList = this.f28025h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f28025h.get(i2);
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
            if (this.f28025h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f28025h.size()) {
                Object obj = this.f28025h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1306a) {
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

    public void h(c.a.q0.w1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1306a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f28025h.clear();
            if (aVar == null || aVar.f28003a == null || (list = aVar.f28004b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.f28003a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.f28013a) && (arrayList = cVar.f28014b) != null && arrayList.size() != 0 && g(cVar.f28014b)) {
                    arrayList2.add(cVar.f28013a);
                    Iterator<a.C1306a> it = cVar.f28014b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f28025h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
