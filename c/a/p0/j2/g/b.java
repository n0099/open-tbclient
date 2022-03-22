package c.a.p0.j2.g;

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
import c.a.p0.j2.g.a;
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
    public MemberPrivilegeActivity a;

    /* renamed from: b  reason: collision with root package name */
    public int f15776b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15777c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Object> f15778d;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.j2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1184b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f15779b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f15780c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15781d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15782e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f15783f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15784g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15785h;
        public TextView i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public C1184b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1184b(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15786b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15787c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f15788d;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15777c = false;
        this.a = memberPrivilegeActivity;
        this.f15778d = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0558, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1183a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1183a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1183a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f15766d) && TextUtils.getTrimmedLength(next.f15766d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View inflate;
        C1184b c1184b;
        a.e eVar;
        a.b bVar;
        a.d dVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1184b)) {
                c1184b = (C1184b) view.getTag();
                inflate = view;
            } else {
                inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d054f, (ViewGroup) null);
                c1184b = new C1184b(null);
                c1184b.a = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090d24);
                c1184b.f15779b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0915ad);
                c1184b.f15782e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915af);
                c1184b.f15780c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913e2);
                c1184b.f15781d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913e7);
                c1184b.f15783f = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0913e6);
                c1184b.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0923f1);
                c1184b.k = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0915ac);
                c1184b.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923fa);
                c1184b.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915ae);
                c1184b.f15784g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908d3);
                c1184b.f15785h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09121b);
                c1184b.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091aa7);
                inflate.setTag(c1184b);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                c1184b.i.setVisibility(8);
            } else {
                c1184b.i.setVisibility(0);
            }
            if (getItem(i) == null || (eVar = (a.e) getItem(i)) == null || (bVar = eVar.f15774d) == null || (dVar = eVar.f15775e) == null) {
                return null;
            }
            long j = dVar.a + dVar.f15771b;
            this.f15776b = (int) bVar.a;
            long j2 = bVar.f15767b;
            String e2 = e(j2, bVar.f15768c);
            c1184b.a.J(eVar.f15773c, 25, false);
            SkinManager.setBackgroundResource(c1184b.a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j = 0;
            }
            if (bVar.a() && dVar.a()) {
                c1184b.f15779b.setVisibility(8);
                c1184b.f15780c.setVisibility(0);
                c1184b.f15783f.J(eVar.f15774d.f15769d, 21, false);
                if (this.f15777c) {
                    c1184b.f15784g.setText(a(e2));
                    i2 = 1;
                } else {
                    if (1 == this.f15776b) {
                        string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a9a);
                    } else {
                        string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f150a);
                    }
                    i2 = 1;
                    c1184b.f15784g.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0557, string, m.getDateStringDay(new Date(j2 * 1000))));
                    SkinManager.setViewTextColor(c1184b.f15784g, R.color.CAM_X0101, 1);
                }
                c1184b.f15781d.setText(eVar.f15772b);
                c1184b.f15785h.setText(this.f15776b == i2 ? R.string.obfuscated_res_0x7f0f0431 : R.string.obfuscated_res_0x7f0f0433);
                c1184b.f15785h.setOnClickListener(this.a);
                c1184b.l.setText(String.valueOf(j));
                SkinManager.setImageResource(c1184b.j, R.drawable.icon_vip_dou);
            } else {
                c1184b.f15779b.setVisibility(0);
                c1184b.f15780c.setVisibility(8);
                c1184b.f15782e.setText(eVar.f15772b);
                c1184b.f15785h.setText(R.string.obfuscated_res_0x7f0f0503);
                c1184b.f15785h.setOnClickListener(this.a);
                c1184b.m.setText(String.valueOf(j));
                SkinManager.setImageResource(c1184b.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(c1184b.f15784g, R.drawable.bg_dredge_tips);
            c1184b.i.setOnClickListener(this.a);
            this.a.getLayoutMode().k(z);
            this.a.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0550, (ViewGroup) null);
                cVar = new c(null);
                cVar.a = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090f8a);
                cVar.f15786b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09202b);
                cVar.f15787c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090783);
                cVar.f15788d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0907da);
                view.setTag(cVar);
            }
            if (getItemViewType(i - 1) == 1) {
                cVar.f15788d.setVisibility(8);
            }
            a.C1183a c1183a = (a.C1183a) getItem(i);
            cVar.a.J(c1183a.a, 10, false);
            cVar.f15786b.setText(c1183a.f15764b);
            cVar.f15787c.setText(c1183a.f15765c);
            this.a.getLayoutMode().k(z);
            this.a.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final String e(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j - j2;
            int i = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
            if (i >= 0 || j3 > 345600) {
                return "";
            }
            this.f15777c = true;
            if (i >= 0 || j3 > 86400) {
                return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
            }
            return this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13fa);
        }
        return (String) invokeCommon.objValue;
    }

    public final View f(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0551, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09205f);
                view.setTag(dVar);
            }
            dVar.a.setText((String) getItem(i));
            this.a.getLayoutMode().k(z);
            this.a.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1183a> arrayList) {
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
            ArrayList<Object> arrayList = this.f15778d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ArrayList<Object> arrayList = this.f15778d;
            if (arrayList == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return this.f15778d.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.f15778d != null && i >= 0 && i <= getCount() && i < this.f15778d.size()) {
                Object obj = this.f15778d.get(i);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1183a) {
                    return 2;
                }
            }
            return 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                return c(i, view, viewGroup);
            }
            if (itemViewType == 1) {
                return f(i, view, viewGroup);
            }
            if (itemViewType == 2) {
                return d(i, view, viewGroup);
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

    public void h(c.a.p0.j2.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1183a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f15778d.clear();
            if (aVar == null || aVar.a == null || (list = aVar.f15763b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a) && (arrayList = cVar.f15770b) != null && arrayList.size() != 0 && g(cVar.f15770b)) {
                    arrayList2.add(cVar.a);
                    Iterator<a.C1183a> it = cVar.f15770b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f15778d.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
