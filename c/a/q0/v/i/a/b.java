package c.a.q0.v.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import com.baidu.ala.view.card.AlaCardBottomUserInfoLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f25576e;

    /* renamed from: f  reason: collision with root package name */
    public List<c2> f25577f;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25578a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25579b;

        /* renamed from: c  reason: collision with root package name */
        public AlaCardBottomUserInfoLayout f25580c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f25581d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f25582e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25578a = view;
            this.f25579b = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.f25580c = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.f25581d = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.f25582e = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
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
        this.f25576e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c2 getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c2> list = this.f25577f;
            if (list != null && i2 >= 0 && i2 <= list.size()) {
                return this.f25577f.get(i2);
            }
            return null;
        }
        return (c2) invokeI.objValue;
    }

    public void b(List<c2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f25577f = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f25577f)) {
                return 0;
            }
            return this.f25577f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        AlaInfoData j1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f25576e.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
                aVar = new a(view);
                aVar.f25579b.setIsRound(true);
                aVar.f25579b.setDrawBorder(false);
                aVar.f25579b.setAutoChangeStyle(true);
                aVar.f25579b.setGifIconSupport(false);
                int k = (l.k(this.f25576e.getPageActivity()) - this.f25576e.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
                int i3 = (k * 16) / 9;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f25581d.getLayoutParams();
                layoutParams.height = k;
                layoutParams.width = i3;
                aVar.f25581d.setLayoutParams(layoutParams);
                AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
                ((ViewGroup.LayoutParams) layoutParams2).width = i3;
                view.setLayoutParams(layoutParams2);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            c2 item = getItem(i2);
            if (item == null || (j1 = item.j1()) == null) {
                return null;
            }
            aVar.f25579b.startLoad(j1.cover, 10, false);
            aVar.f25580c.setData(item);
            aVar.f25580c.setUserHeadImgVisible(8);
            aVar.f25582e.setText(item.getTitle());
            aVar.f25580c.onChangeSkinType(this.f25576e);
            SkinManager.setViewTextColor(aVar.f25582e, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
