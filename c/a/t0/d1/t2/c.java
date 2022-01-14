package c.a.t0.d1.t2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.w3.c0;
import c.a.t0.w3.d0;
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
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes7.dex */
public class c implements b, c.a.t0.d1.t2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16630b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16631c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16632d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f16633e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f16634f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16635g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f16636h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f16637i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f16638j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16639e;

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
            this.f16639e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16639e.f16634f != null && "tiebaclient://accelerator".equals(this.f16639e.f16634f.f24784d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.t0.d1.q1.b.a(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.f16639e.f16637i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (!TextUtils.equals(this.f16639e.a.getResources().getString(i1.hot_user_rank), this.f16639e.f16634f.f24782b) || this.f16639e.f16637i == null || this.f16639e.f16637i.getForum() == null || TextUtils.isEmpty(this.f16639e.f16637i.getForum().getId())) {
                    if (this.f16639e.f16634f != null && this.f16639e.f16634f.f24786f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f16639e.f16634f.f24787g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f16639e.f16634f.f24786f.f24793b).param("obj_name", this.f16639e.f16634f.f24786f.a).param("obj_param1", this.f16639e.f16634f.f24786f.f24795d.intValue()));
                    }
                    if (this.f16639e.f16634f != null && !"tiebaclient://accelerator".equals(this.f16639e.f16634f.f24784d)) {
                        d.b(view.getContext(), this.f16639e.f16634f);
                    }
                    d.c(this.f16639e.f16634f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f16639e.f16637i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f16639e.f16637i.getForum().getId());
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
        this.f16638j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(g1.frs_one_service_layout, (ViewGroup) null);
        this.a = inflate;
        this.f16630b = (TextView) inflate.findViewById(f1.frs_service);
        this.f16631c = (TextView) this.a.findViewById(f1.frs_service_category);
        this.f16632d = (TextView) this.a.findViewById(f1.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(f1.frs_service_icon);
        this.f16633e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f16633e.setIsRound(true);
        this.f16633e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(f1.image_group);
        this.f16636h = imageOverlayView;
        imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, c1.CAM_X0618, dimensionPixelOffset3);
        this.f16636h.setStrokeStyle(1);
        this.f16636h.setLoadImageType(12);
        this.a.setOnClickListener(this.f16638j);
        this.f16635g = (ImageView) this.a.findViewById(f1.frs_service_arrow);
    }

    @Override // c.a.t0.d1.t2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f24778b)) {
            return;
        }
        this.f16637i = frsViewData;
        d0 d0Var = c0Var.f24778b.get(0);
        if (d0Var == null) {
            return;
        }
        this.f16634f = d0Var;
        if (!TextUtils.equals(this.a.getResources().getString(i1.hot_user_rank), this.f16634f.f24782b)) {
            this.f16631c.setText(this.a.getContext().getString(i1.forum_exclusive));
        } else {
            this.f16631c.setText(this.a.getContext().getString(i1.frs_service_special));
            this.f16630b.setText(this.a.getContext().getString(i1.hot_person));
        }
        this.f16632d.setText(StringHelper.cutStringWithEllipsisStrict(d0Var.f24783c, 20));
        if (TextUtils.equals(this.a.getResources().getString(i1.hot_user_rank), d0Var.f24782b)) {
            this.f16636h.setVisibility(0);
            this.f16633e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f16633e.startLoad(d0Var.f24782b, 10, false);
            this.f16633e.setVisibility(0);
            this.f16636h.setVisibility(8);
        }
        d.d(d0Var);
    }

    @Override // c.a.t0.d1.t2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(getView().getContext(), d1.tbds10)).defaultColorValue(i2).into(this.f16630b);
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
            this.f16636h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.d1.t2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.t0.d1.t2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f16631c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16632d, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16630b, c1.CAM_X0101);
            WebPManager.setPureDrawable(this.f16635g, e1.icon_pure_arrow12_right, c1.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f16636h.onChangeSkinType();
        }
    }
}
