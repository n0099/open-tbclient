package c.a.r0.d1.k2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.y3.d0;
import c.a.r0.y3.e0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes2.dex */
public class c implements b, c.a.r0.d1.k2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15767b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15768c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15769d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f15770e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f15771f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15772g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f15773h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f15774i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f15775j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15776e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15776e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15776e.f15771f != null && "tiebaclient://accelerator".equals(this.f15776e.f15771f.f24976d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.r0.d1.g1.b.a(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.f15776e.f15774i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (!TextUtils.equals(this.f15776e.a.getResources().getString(R.string.hot_user_rank), this.f15776e.f15771f.f24974b) || this.f15776e.f15774i == null || this.f15776e.f15774i.getForum() == null || TextUtils.isEmpty(this.f15776e.f15774i.getForum().getId())) {
                    if (this.f15776e.f15771f != null && this.f15776e.f15771f.f24978f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f15776e.f15771f.f24979g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f15776e.f15771f.f24978f.f24986b).param("obj_name", this.f15776e.f15771f.f24978f.a).param("obj_param1", this.f15776e.f15771f.f24978f.f24988d.intValue()));
                    }
                    if (this.f15776e.f15771f != null && !"tiebaclient://accelerator".equals(this.f15776e.f15771f.f24976d)) {
                        d.b(view.getContext(), this.f15776e.f15771f);
                    }
                    d.c(this.f15776e.f15771f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f15776e.f15774i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f15776e.f15774i.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15775j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.a = inflate;
        this.f15767b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f15768c = (TextView) this.a.findViewById(R.id.frs_service_category);
        this.f15769d = (TextView) this.a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(R.id.frs_service_icon);
        this.f15770e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f15770e.setIsRound(true);
        this.f15770e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(R.id.image_group);
        this.f15773h = imageOverlayView;
        imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f15773h.setStrokeStyle(1);
        this.f15773h.setLoadImageType(12);
        this.a.setOnClickListener(this.f15775j);
        this.f15772g = (ImageView) this.a.findViewById(R.id.frs_service_arrow);
    }

    @Override // c.a.r0.d1.k2.b
    public void a(d0 d0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d0Var, frsViewData) == null) || d0Var == null || ListUtils.isEmpty(d0Var.f24970b)) {
            return;
        }
        this.f15774i = frsViewData;
        e0 e0Var = d0Var.f24970b.get(0);
        if (e0Var == null) {
            return;
        }
        this.f15771f = e0Var;
        if (!TextUtils.equals(this.a.getResources().getString(R.string.hot_user_rank), this.f15771f.f24974b)) {
            this.f15768c.setText(this.a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f15768c.setText(this.a.getContext().getString(R.string.frs_service_special));
            this.f15767b.setText(this.a.getContext().getString(R.string.hot_person));
        }
        this.f15769d.setText(StringHelper.cutStringWithEllipsisStrict(e0Var.f24975c, 20));
        if (TextUtils.equals(this.a.getResources().getString(R.string.hot_user_rank), e0Var.f24974b)) {
            this.f15773h.setVisibility(0);
            this.f15770e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f15770e.startLoad(e0Var.f24974b, 10, false);
            this.f15770e.setVisibility(0);
            this.f15773h.setVisibility(8);
        }
        d.d(e0Var);
    }

    @Override // c.a.r0.d1.k2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f15767b);
        }
    }

    public final boolean f(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData)) == null) {
            if (frsViewData.getHotUserRankData() == null || frsViewData.getHotUserRankData().hot_user == null || frsViewData.getHotUserRankData().hot_user.size() <= 0) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
                if (shortUserInfo != null) {
                    arrayList.add(shortUserInfo.portrait);
                }
            }
            this.f15773h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.d1.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.k2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f15768c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15769d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15767b, (int) R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f15772g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f15773h.onChangeSkinType();
        }
    }
}
