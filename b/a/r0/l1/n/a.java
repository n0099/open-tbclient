package b.a.r0.l1.n;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.mygroup.PersonalGroupFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f21806e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f21807f;

    /* renamed from: b.a.r0.l1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1074a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f21808a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f21809b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21810c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21811d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f21812e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f21813f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f21814g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f21815h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f21816i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;

        public C1074a() {
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
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalGroupFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21807f = new ArrayList();
        this.f21806e = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, imageViewArr, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 3) {
                i2 = 3;
            }
            for (int i3 = 1; i3 <= 3; i3++) {
                if (i3 <= i2) {
                    imageViewArr[i3].setVisibility(0);
                } else {
                    imageViewArr[i3].setVisibility(8);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int itemId = (int) getItemId(i2);
            if (itemId < 0 || itemId >= this.f21807f.size()) {
                return null;
            }
            return this.f21807f.get(itemId);
        }
        return (GroupInfoData) invokeI.objValue;
    }

    public void c(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f21807f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21807f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1074a c1074a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1074a)) {
                c1074a = (C1074a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f21806e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
                c1074a = new C1074a();
                c1074a.f21808a = (LinearLayout) view.findViewById(R.id.click_head);
                c1074a.f21814g = (ImageView) view.findViewById(R.id.diver_top);
                c1074a.f21815h = (ImageView) view.findViewById(R.id.diver_buttom_px);
                c1074a.f21816i = (ImageView) view.findViewById(R.id.diver_top_px);
                c1074a.f21809b = (GroupImageView) view.findViewById(R.id.item_head);
                c1074a.f21810c = (TextView) view.findViewById(R.id.item_group_name);
                c1074a.f21811d = (TextView) view.findViewById(R.id.item_group_num);
                c1074a.f21812e = (TextView) view.findViewById(R.id.item_introduce);
                c1074a.f21813f = (TextView) view.findViewById(R.id.isCreator);
                c1074a.j = (ImageView) view.findViewById(R.id.item_grade1);
                c1074a.k = (ImageView) view.findViewById(R.id.item_grade2);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
                c1074a.l = imageView;
                ImageView[] imageViewArr = new ImageView[4];
                c1074a.m = imageViewArr;
                imageViewArr[1] = c1074a.j;
                imageViewArr[2] = c1074a.k;
                imageViewArr[3] = imageView;
                view.setTag(c1074a);
            }
            GroupInfoData groupInfoData = this.f21807f.get(i2);
            c1074a.f21809b.setTag(null);
            c1074a.f21809b.setDrawBorder(true);
            c1074a.f21809b.setPlaceHolder(1);
            if (groupInfoData != null) {
                String portrait = groupInfoData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    c1074a.f21809b.startLoad(portrait, 10, false);
                } else {
                    c1074a.f21809b.startLoad("", 10, false);
                }
                c1074a.f21808a.setOnClickListener(this.f21806e);
                c1074a.f21808a.setTag(groupInfoData);
                c1074a.f21814g.setVisibility(8);
                c1074a.f21816i.setVisibility(8);
                c1074a.f21815h.setVisibility(0);
                c1074a.f21810c.setText(groupInfoData.getName());
                TextView textView = c1074a.f21811d;
                textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
                c1074a.f21812e.setText(groupInfoData.getIntro());
                if (groupInfoData.getIsGroupManager() == 1) {
                    c1074a.f21813f.setVisibility(0);
                } else {
                    c1074a.f21813f.setVisibility(8);
                }
                a(c1074a.m, groupInfoData.getGrade());
            }
            this.f21806e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f21806e.getBaseFragmentActivity().getLayoutMode().j(view);
            if (groupInfoData != null && groupInfoData.isMemGroup()) {
                SkinManager.setViewTextColor(c1074a.f21810c, R.color.common_color_10009, 1);
                SkinManager.setImageResource(c1074a.j, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1074a.k, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1074a.l, R.drawable.icon_vip_grade_big_small_s);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
