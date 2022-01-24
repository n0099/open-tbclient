package c.a.t0.t1.n;

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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f22455e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f22456f;

    /* renamed from: c.a.t0.t1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1383a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f22457b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f22458c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f22459d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22460e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f22461f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f22462g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f22463h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f22464i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f22465j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;

        public C1383a() {
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
        this.f22456f = new ArrayList();
        this.f22455e = personalGroupFragment;
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
            if (itemId < 0 || itemId >= this.f22456f.size()) {
                return null;
            }
            return this.f22456f.get(itemId);
        }
        return (GroupInfoData) invokeI.objValue;
    }

    public void c(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f22456f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22456f.size() : invokeV.intValue;
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
        C1383a c1383a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1383a)) {
                c1383a = (C1383a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f22455e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
                c1383a = new C1383a();
                c1383a.a = (LinearLayout) view.findViewById(R.id.click_head);
                c1383a.f22462g = (ImageView) view.findViewById(R.id.diver_top);
                c1383a.f22463h = (ImageView) view.findViewById(R.id.diver_buttom_px);
                c1383a.f22464i = (ImageView) view.findViewById(R.id.diver_top_px);
                c1383a.f22457b = (GroupImageView) view.findViewById(R.id.item_head);
                c1383a.f22458c = (TextView) view.findViewById(R.id.item_group_name);
                c1383a.f22459d = (TextView) view.findViewById(R.id.item_group_num);
                c1383a.f22460e = (TextView) view.findViewById(R.id.item_introduce);
                c1383a.f22461f = (TextView) view.findViewById(R.id.isCreator);
                c1383a.f22465j = (ImageView) view.findViewById(R.id.item_grade1);
                c1383a.k = (ImageView) view.findViewById(R.id.item_grade2);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
                c1383a.l = imageView;
                ImageView[] imageViewArr = new ImageView[4];
                c1383a.m = imageViewArr;
                imageViewArr[1] = c1383a.f22465j;
                imageViewArr[2] = c1383a.k;
                imageViewArr[3] = imageView;
                view.setTag(c1383a);
            }
            GroupInfoData groupInfoData = this.f22456f.get(i2);
            c1383a.f22457b.setTag(null);
            c1383a.f22457b.setDrawBorder(true);
            c1383a.f22457b.setPlaceHolder(1);
            if (groupInfoData != null) {
                String portrait = groupInfoData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    c1383a.f22457b.startLoad(portrait, 10, false);
                } else {
                    c1383a.f22457b.startLoad("", 10, false);
                }
                c1383a.a.setOnClickListener(this.f22455e);
                c1383a.a.setTag(groupInfoData);
                c1383a.f22462g.setVisibility(8);
                c1383a.f22464i.setVisibility(8);
                c1383a.f22463h.setVisibility(0);
                c1383a.f22458c.setText(groupInfoData.getName());
                TextView textView = c1383a.f22459d;
                textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
                c1383a.f22460e.setText(groupInfoData.getIntro());
                if (groupInfoData.getIsGroupManager() == 1) {
                    c1383a.f22461f.setVisibility(0);
                } else {
                    c1383a.f22461f.setVisibility(8);
                }
                a(c1383a.m, groupInfoData.getGrade());
            }
            this.f22455e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f22455e.getBaseFragmentActivity().getLayoutMode().j(view);
            if (groupInfoData != null && groupInfoData.isMemGroup()) {
                SkinManager.setViewTextColor(c1383a.f22458c, R.color.common_color_10009, 1);
                SkinManager.setImageResource(c1383a.f22465j, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1383a.k, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1383a.l, R.drawable.icon_vip_grade_big_small_s);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
