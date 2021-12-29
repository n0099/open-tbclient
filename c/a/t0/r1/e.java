package c.a.t0.r1;

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
/* loaded from: classes8.dex */
public class e extends BaseExpandableListAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicSelectActivity> f22434e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f22435f;

    /* renamed from: g  reason: collision with root package name */
    public ExpandableListView f22436g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c> f22437h;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f22438b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f22439c;

        /* renamed from: d  reason: collision with root package name */
        public View f22440d;

        /* renamed from: e  reason: collision with root package name */
        public View f22441e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.f22438b = null;
            this.f22439c = null;
            this.f22440d = null;
            this.f22441e = null;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f22442b;

        /* renamed from: c  reason: collision with root package name */
        public View f22443c;

        /* renamed from: d  reason: collision with root package name */
        public View f22444d;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22437h = new ArrayList();
        this.f22434e = tbPageContext;
        this.f22435f = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(a aVar, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, view, i2) == null) || aVar == null || aVar.a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundResource(aVar.f22439c, R.drawable.hot_select_tag_bg);
        SkinManager.setBackgroundColor(aVar.f22440d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(aVar.f22441e, R.color.CAM_X0204);
        SkinManager.setViewTextColor(aVar.f22439c, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(aVar.f22438b, R.color.CAM_X0105, 1);
        aVar.a = i2;
    }

    public final void b(b bVar, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, view, i2) == null) || bVar == null || bVar.a == i2) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(bVar.f22443c, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(bVar.f22444d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(bVar.f22442b, R.color.CAM_X0109, 1);
        bVar.a = i2;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22437h.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: d */
    public d getChild(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (getGroup(i2) == null || getGroup(i2).b() == null) {
                return null;
            }
            return getGroup(i2).b().get(i3);
        }
        return (d) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: e */
    public c getGroup(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f22437h.get(i2) : (c) invokeI.objValue;
    }

    public List<c> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22437h : (List) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f22437h.add(cVar);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) ? i3 : invokeII.longValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            if (getChildTypeCount() == 2) {
                if (i2 != 0 && i2 == 1) {
                    return 2;
                }
            } else if (getChildTypeCount() == 1 && getGroup(i2).getType() != 0 && getGroup(i2).getType() == 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22437h.size() : invokeV.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        InterceptResult invokeCommon;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), view, viewGroup})) == null) {
            d child = getChild(i2, i3);
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                view = this.f22435f.inflate(R.layout.hot_child_bang_item, (ViewGroup) null);
                aVar = new a();
                aVar.f22438b = (TextView) view.findViewById(R.id.hot_topic_title);
                aVar.f22439c = (TextView) view.findViewById(R.id.hot_topic_tag);
                aVar.f22440d = view.findViewById(R.id.divider_line_top);
                aVar.f22441e = view.findViewById(R.id.divider_line_bottom);
                view.setTag(aVar);
            }
            if (child == null) {
                return view;
            }
            aVar.f22438b.setText(c.a.s0.u0.a.a(StringHelper.cutStringWithEllipsisNew(child.b(), 15)));
            h(aVar.f22439c, child.a().intValue());
            a(aVar, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (getGroup(i2) == null || getGroup(i2).b() == null) {
                return 0;
            }
            return getGroup(i2).b().size();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22437h.size() : invokeV.intValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        InterceptResult invokeCommon;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), view, viewGroup})) == null) {
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = this.f22435f.inflate(R.layout.hot_group_item, (ViewGroup) null);
                bVar = new b();
                bVar.f22442b = (TextView) view.findViewById(R.id.header_text);
                bVar.f22443c = view.findViewById(R.id.divider_line);
                bVar.f22444d = view.findViewById(R.id.group_divider);
                view.setTag(bVar);
                view.setClickable(false);
            }
            c group = getGroup(i2);
            if (group == null) {
                return view;
            }
            bVar.f22442b.setText(StringHelper.cutStringWithSuffix(group.a(), 15, null));
            if (i2 == 0) {
                bVar.f22443c.setVisibility(0);
                bVar.f22444d.setVisibility(8);
            } else {
                bVar.f22443c.setVisibility(8);
                bVar.f22444d.setVisibility(0);
            }
            b(bVar, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void h(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, textView, i2) == null) || textView == null) {
            return;
        }
        if (i2 == 10) {
            textView.setVisibility(0);
            textView.setText(this.f22434e.getString(R.string.topic_tag_offical));
        } else if (i2 == 11) {
            textView.setVisibility(0);
            textView.setText(this.f22434e.getString(R.string.topic_tag_bar));
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
    public boolean isChildSelectable(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || this.f22436g == null) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i3 = 0; i3 < groupCount; i3++) {
            if (i3 != i2) {
                this.f22436g.collapseGroup(i2);
            }
        }
    }
}
