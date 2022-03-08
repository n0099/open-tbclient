package c.a.r0.h2.g;

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
import c.a.r0.h2.g.a;
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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f18001e;

    /* renamed from: f  reason: collision with root package name */
    public int f18002f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18003g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f18004h;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.h2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1130b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f18005b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f18006c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18007d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18008e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f18009f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18010g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18011h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f18012i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f18013j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public C1130b() {
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

        public /* synthetic */ C1130b(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18014b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18015c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18016d;

        public c() {
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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
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

    public b(MemberPrivilegeActivity memberPrivilegeActivity) {
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
        this.f18003g = false;
        this.f18001e = memberPrivilegeActivity;
        this.f18004h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f18001e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1129a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1129a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1129a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f17991d) && TextUtils.getTrimmedLength(next.f17991d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View inflate;
        C1130b c1130b;
        a.e eVar;
        a.b bVar;
        a.d dVar;
        String string;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1130b)) {
                c1130b = (C1130b) view.getTag();
                inflate = view;
            } else {
                inflate = LayoutInflater.from(this.f18001e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                c1130b = new C1130b(null);
                c1130b.a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                c1130b.f18005b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                c1130b.f18008e = (TextView) inflate.findViewById(R.id.nonmembername);
                c1130b.f18006c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                c1130b.f18007d = (TextView) inflate.findViewById(R.id.membername);
                c1130b.f18009f = (TbImageView) inflate.findViewById(R.id.membericon);
                c1130b.f18013j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                c1130b.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                c1130b.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                c1130b.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                c1130b.f18010g = (TextView) inflate.findViewById(R.id.endtime);
                c1130b.f18011h = (TextView) inflate.findViewById(R.id.left_button);
                c1130b.f18012i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(c1130b);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                c1130b.f18012i.setVisibility(8);
            } else {
                c1130b.f18012i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar = eVar.f17999d) == null || (dVar = eVar.f18000e) == null) {
                return null;
            }
            long j2 = dVar.a + dVar.f17996b;
            this.f18002f = (int) bVar.a;
            long j3 = bVar.f17992b;
            String e2 = e(j3, bVar.f17993c);
            c1130b.a.startLoad(eVar.f17998c, 25, false);
            SkinManager.setBackgroundResource(c1130b.a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j2 = 0;
            }
            if (bVar.a() && dVar.a()) {
                c1130b.f18005b.setVisibility(8);
                c1130b.f18006c.setVisibility(0);
                c1130b.f18009f.startLoad(eVar.f17999d.f17994d, 21, false);
                if (this.f18003g) {
                    c1130b.f18010g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f18002f) {
                        string = this.f18001e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f18001e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    c1130b.f18010g.setText(this.f18001e.getResources().getString(R.string.endtiem_memeber_tip, string, m.getDateStringDay(new Date(j3 * 1000))));
                    SkinManager.setViewTextColor(c1130b.f18010g, R.color.CAM_X0101, 1);
                }
                c1130b.f18007d.setText(eVar.f17997b);
                c1130b.f18011h.setText(this.f18002f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                c1130b.f18011h.setOnClickListener(this.f18001e);
                c1130b.l.setText(String.valueOf(j2));
                SkinManager.setImageResource(c1130b.f18013j, R.drawable.icon_vip_dou);
            } else {
                c1130b.f18005b.setVisibility(0);
                c1130b.f18006c.setVisibility(8);
                c1130b.f18008e.setText(eVar.f17997b);
                c1130b.f18011h.setText(R.string.dredge_member);
                c1130b.f18011h.setOnClickListener(this.f18001e);
                c1130b.m.setText(String.valueOf(j2));
                SkinManager.setImageResource(c1130b.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(c1130b.f18010g, R.drawable.bg_dredge_tips);
            c1130b.f18012i.setOnClickListener(this.f18001e);
            this.f18001e.getLayoutMode().k(z);
            this.f18001e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f18001e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                cVar = new c(null);
                cVar.a = (HeadImageView) view.findViewById(R.id.item_portrait);
                cVar.f18014b = (TextView) view.findViewById(R.id.title);
                cVar.f18015c = (TextView) view.findViewById(R.id.description);
                cVar.f18016d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(cVar);
            }
            if (getItemViewType(i2 - 1) == 1) {
                cVar.f18016d.setVisibility(8);
            }
            a.C1129a c1129a = (a.C1129a) getItem(i2);
            cVar.a.startLoad(c1129a.a, 10, false);
            cVar.f18014b.setText(c1129a.f17989b);
            cVar.f18015c.setText(c1129a.f17990c);
            this.f18001e.getLayoutMode().k(z);
            this.f18001e.getLayoutMode().j(view);
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
            this.f18003g = true;
            if (i2 >= 0 || j4 > 86400) {
                return (86400 >= j4 || j4 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j4 || j4 > 259200) ? "3" : "2" : "1";
            }
            return this.f18001e.getPageContext().getString(R.string.today);
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
                view = LayoutInflater.from(this.f18001e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.a.setText((String) getItem(i2));
            this.f18001e.getLayoutMode().k(z);
            this.f18001e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1129a> arrayList) {
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
            ArrayList<Object> arrayList = this.f18004h;
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
            ArrayList<Object> arrayList = this.f18004h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f18004h.get(i2);
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
            if (this.f18004h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f18004h.size()) {
                Object obj = this.f18004h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1129a) {
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

    public void h(c.a.r0.h2.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1129a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f18004h.clear();
            if (aVar == null || aVar.a == null || (list = aVar.f17988b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a) && (arrayList = cVar.f17995b) != null && arrayList.size() != 0 && g(cVar.f17995b)) {
                    arrayList2.add(cVar.a);
                    Iterator<a.C1129a> it = cVar.f17995b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f18004h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
