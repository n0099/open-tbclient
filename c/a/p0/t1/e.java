package c.a.p0.t1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopicselect.HotTopicSelectActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends BaseExpandableListAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicSelectActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f18589b;

    /* renamed from: c  reason: collision with root package name */
    public ExpandableListView f18590c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c> f18591d;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18592b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18593c;

        /* renamed from: d  reason: collision with root package name */
        public View f18594d;

        /* renamed from: e  reason: collision with root package name */
        public View f18595e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.f18592b = null;
            this.f18593c = null;
            this.f18594d = null;
            this.f18595e = null;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18596b;

        /* renamed from: c  reason: collision with root package name */
        public View f18597c;

        /* renamed from: d  reason: collision with root package name */
        public View f18598d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }
    }

    public e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18591d = new ArrayList();
        this.a = tbPageContext;
        this.f18589b = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(a aVar, View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, view, i) == null) || aVar == null || aVar.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundResource(aVar.f18593c, R.drawable.hot_select_tag_bg);
        SkinManager.setBackgroundColor(aVar.f18594d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(aVar.f18595e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(aVar.f18593c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(aVar.f18592b, R.color.CAM_X0105, 1);
        aVar.a = i;
    }

    public final void b(b bVar, View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, view, i) == null) || bVar == null || bVar.a == i) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(bVar.f18597c, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(bVar.f18598d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(bVar.f18596b, R.color.CAM_X0109, 1);
        bVar.a = i;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18591d.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: d */
    public d getChild(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (getGroup(i) == null || getGroup(i).b() == null) {
                return null;
            }
            return getGroup(i).b().get(i2);
        }
        return (d) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: e */
    public c getGroup(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.f18591d.get(i) : (c) invokeI.objValue;
    }

    public List<c> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18591d : (List) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f18591d.add(cVar);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) ? i2 : invokeII.longValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            if (getChildTypeCount() == 2) {
                if (i != 0 && i == 1) {
                    return 2;
                }
            } else if (getChildTypeCount() == 1 && getGroup(i).getType() != 0 && getGroup(i).getType() == 1) {
                return 2;
            }
            return 1;
        }
        return invokeII.intValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f18591d.size() : invokeV.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        InterceptResult invokeCommon;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), view, viewGroup})) == null) {
            d child = getChild(i, i2);
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                view = this.f18589b.inflate(R.layout.obfuscated_res_0x7f0d03a7, (ViewGroup) null);
                aVar = new a();
                aVar.f18592b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090dee);
                aVar.f18593c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090ded);
                aVar.f18594d = view.findViewById(R.id.obfuscated_res_0x7f0907ff);
                aVar.f18595e = view.findViewById(R.id.obfuscated_res_0x7f0907f9);
                view.setTag(aVar);
            }
            if (child == null) {
                return view;
            }
            aVar.f18592b.setText(c.a.o0.t0.a.a(StringHelper.cutStringWithEllipsisNew(child.b(), 15)));
            h(aVar.f18593c, child.a().intValue());
            a(aVar, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (getGroup(i) == null || getGroup(i).b() == null) {
                return 0;
            }
            return getGroup(i).b().size();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f18591d.size() : invokeV.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), view, viewGroup})) == null) {
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = this.f18589b.inflate(R.layout.obfuscated_res_0x7f0d03a8, (ViewGroup) null);
                bVar = new b();
                bVar.f18596b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090d41);
                bVar.f18597c = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
                bVar.f18598d = view.findViewById(R.id.group_divider);
                view.setTag(bVar);
                view.setClickable(false);
            }
            c group = getGroup(i);
            if (group == null) {
                return view;
            }
            bVar.f18596b.setText(StringHelper.cutStringWithSuffix(group.a(), 15, null));
            if (i == 0) {
                bVar.f18597c.setVisibility(0);
                bVar.f18598d.setVisibility(8);
            } else {
                bVar.f18597c.setVisibility(8);
                bVar.f18598d.setVisibility(0);
            }
            b(bVar, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void h(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, textView, i) == null) || textView == null) {
            return;
        }
        if (i == 10) {
            textView.setVisibility(0);
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f140e));
        } else if (i == 11) {
            textView.setVisibility(0);
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f140d));
        } else {
            textView.setVisibility(8);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i, i2)) == null) {
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || this.f18590c == null) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            if (i2 != i) {
                this.f18590c.collapseGroup(i);
            }
        }
    }
}
