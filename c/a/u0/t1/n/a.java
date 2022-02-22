package c.a.u0.t1.n;

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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f22668e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f22669f;

    /* renamed from: c.a.u0.t1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1389a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f22670b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f22671c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f22672d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22673e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f22674f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f22675g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f22676h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f22677i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f22678j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;

        public C1389a() {
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
        this.f22669f = new ArrayList();
        this.f22668e = personalGroupFragment;
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
            if (itemId < 0 || itemId >= this.f22669f.size()) {
                return null;
            }
            return this.f22669f.get(itemId);
        }
        return (GroupInfoData) invokeI.objValue;
    }

    public void c(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f22669f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22669f.size() : invokeV.intValue;
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
        C1389a c1389a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1389a)) {
                c1389a = (C1389a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f22668e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
                c1389a = new C1389a();
                c1389a.a = (LinearLayout) view.findViewById(R.id.click_head);
                c1389a.f22675g = (ImageView) view.findViewById(R.id.diver_top);
                c1389a.f22676h = (ImageView) view.findViewById(R.id.diver_buttom_px);
                c1389a.f22677i = (ImageView) view.findViewById(R.id.diver_top_px);
                c1389a.f22670b = (GroupImageView) view.findViewById(R.id.item_head);
                c1389a.f22671c = (TextView) view.findViewById(R.id.item_group_name);
                c1389a.f22672d = (TextView) view.findViewById(R.id.item_group_num);
                c1389a.f22673e = (TextView) view.findViewById(R.id.item_introduce);
                c1389a.f22674f = (TextView) view.findViewById(R.id.isCreator);
                c1389a.f22678j = (ImageView) view.findViewById(R.id.item_grade1);
                c1389a.k = (ImageView) view.findViewById(R.id.item_grade2);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
                c1389a.l = imageView;
                ImageView[] imageViewArr = new ImageView[4];
                c1389a.m = imageViewArr;
                imageViewArr[1] = c1389a.f22678j;
                imageViewArr[2] = c1389a.k;
                imageViewArr[3] = imageView;
                view.setTag(c1389a);
            }
            GroupInfoData groupInfoData = this.f22669f.get(i2);
            c1389a.f22670b.setTag(null);
            c1389a.f22670b.setDrawBorder(true);
            c1389a.f22670b.setPlaceHolder(1);
            if (groupInfoData != null) {
                String portrait = groupInfoData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    c1389a.f22670b.startLoad(portrait, 10, false);
                } else {
                    c1389a.f22670b.startLoad("", 10, false);
                }
                c1389a.a.setOnClickListener(this.f22668e);
                c1389a.a.setTag(groupInfoData);
                c1389a.f22675g.setVisibility(8);
                c1389a.f22677i.setVisibility(8);
                c1389a.f22676h.setVisibility(0);
                c1389a.f22671c.setText(groupInfoData.getName());
                TextView textView = c1389a.f22672d;
                textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
                c1389a.f22673e.setText(groupInfoData.getIntro());
                if (groupInfoData.getIsGroupManager() == 1) {
                    c1389a.f22674f.setVisibility(0);
                } else {
                    c1389a.f22674f.setVisibility(8);
                }
                a(c1389a.m, groupInfoData.getGrade());
            }
            this.f22668e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f22668e.getBaseFragmentActivity().getLayoutMode().j(view);
            if (groupInfoData != null && groupInfoData.isMemGroup()) {
                SkinManager.setViewTextColor(c1389a.f22671c, R.color.common_color_10009, 1);
                SkinManager.setImageResource(c1389a.f22678j, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1389a.k, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1389a.l, R.drawable.icon_vip_grade_big_small_s);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
