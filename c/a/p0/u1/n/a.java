package c.a.p0.u1.n;

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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalGroupFragment a;

    /* renamed from: b  reason: collision with root package name */
    public List<GroupInfoData> f18852b;

    /* renamed from: c.a.p0.u1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1419a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f18853b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18854c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18855d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18856e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18857f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f18858g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f18859h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;

        public C1419a() {
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
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalGroupFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18852b = new ArrayList();
        this.a = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, imageViewArr, i) == null) {
            if (i < 0) {
                i = 0;
            }
            if (i > 3) {
                i = 3;
            }
            for (int i2 = 1; i2 <= 3; i2++) {
                if (i2 <= i) {
                    imageViewArr[i2].setVisibility(0);
                } else {
                    imageViewArr[i2].setVisibility(8);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int itemId = (int) getItemId(i);
            if (itemId < 0 || itemId >= this.f18852b.size()) {
                return null;
            }
            return this.f18852b.get(itemId);
        }
        return (GroupInfoData) invokeI.objValue;
    }

    public void c(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f18852b = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18852b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1419a c1419a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1419a)) {
                c1419a = (C1419a) view.getTag();
            } else {
                view = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d07fa, viewGroup, false);
                c1419a = new C1419a();
                c1419a.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090656);
                c1419a.f18858g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0907d7);
                c1419a.f18859h = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0907d6);
                c1419a.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0907d8);
                c1419a.f18853b = (GroupImageView) view.findViewById(R.id.obfuscated_res_0x7f090f75);
                c1419a.f18854c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f72);
                c1419a.f18855d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f73);
                c1419a.f18856e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f7e);
                c1419a.f18857f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f55);
                c1419a.j = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f6e);
                c1419a.k = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f6f);
                ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f70);
                c1419a.l = imageView;
                ImageView[] imageViewArr = new ImageView[4];
                c1419a.m = imageViewArr;
                imageViewArr[1] = c1419a.j;
                imageViewArr[2] = c1419a.k;
                imageViewArr[3] = imageView;
                view.setTag(c1419a);
            }
            GroupInfoData groupInfoData = this.f18852b.get(i);
            c1419a.f18853b.setTag(null);
            c1419a.f18853b.setDrawBorder(true);
            c1419a.f18853b.setPlaceHolder(1);
            if (groupInfoData != null) {
                String portrait = groupInfoData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    c1419a.f18853b.J(portrait, 10, false);
                } else {
                    c1419a.f18853b.J("", 10, false);
                }
                c1419a.a.setOnClickListener(this.a);
                c1419a.a.setTag(groupInfoData);
                c1419a.f18858g.setVisibility(8);
                c1419a.i.setVisibility(8);
                c1419a.f18859h.setVisibility(0);
                c1419a.f18854c.setText(groupInfoData.getName());
                TextView textView = c1419a.f18855d;
                textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
                c1419a.f18856e.setText(groupInfoData.getIntro());
                if (groupInfoData.getIsGroupManager() == 1) {
                    c1419a.f18857f.setVisibility(0);
                } else {
                    c1419a.f18857f.setVisibility(8);
                }
                a(c1419a.m, groupInfoData.getGrade());
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.a.getBaseFragmentActivity().getLayoutMode().j(view);
            if (groupInfoData != null && groupInfoData.isMemGroup()) {
                SkinManager.setViewTextColor(c1419a.f18854c, R.color.common_color_10009, 1);
                SkinManager.setImageResource(c1419a.j, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1419a.k, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(c1419a.l, R.drawable.icon_vip_grade_big_small_s);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
