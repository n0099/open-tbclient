package b.a.r0.x0.s2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.m3.c0;
import b.a.r0.m3.d0;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
/* loaded from: classes6.dex */
public class c implements b, b.a.r0.x0.s2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27898a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27899b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27900c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27901d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f27902e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f27903f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f27904g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f27905h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f27906i;
    public View.OnClickListener j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27907e;

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
            this.f27907e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TextUtils.equals(this.f27907e.f27898a.getResources().getString(i1.hot_user_rank), this.f27907e.f27903f.f22384b) || this.f27907e.f27906i == null || this.f27907e.f27906i.getForum() == null || TextUtils.isEmpty(this.f27907e.f27906i.getForum().getId())) {
                    if (this.f27907e.f27903f != null && this.f27907e.f27903f.f22388f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f27907e.f27903f.f22389g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f27907e.f27903f.f22388f.f22397b).param("obj_name", this.f27907e.f27903f.f22388f.f22396a).param("obj_param1", this.f27907e.f27903f.f22388f.f22399d.intValue()));
                    }
                    d.b(view.getContext(), this.f27907e.f27903f);
                    d.c(this.f27907e.f27903f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(b.a.e.f.m.b.g(this.f27907e.f27906i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f27907e.f27906i.getForum().getId());
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
        this.j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(g1.frs_one_service_layout, (ViewGroup) null);
        this.f27898a = inflate;
        this.f27899b = (TextView) inflate.findViewById(f1.frs_service);
        this.f27900c = (TextView) this.f27898a.findViewById(f1.frs_service_category);
        this.f27901d = (TextView) this.f27898a.findViewById(f1.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f27898a.findViewById(f1.frs_service_icon);
        this.f27902e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f27902e.setIsRound(true);
        this.f27902e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f27898a.findViewById(f1.image_group);
        this.f27905h = imageOverlayView;
        imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, c1.CAM_X0618, dimensionPixelOffset3);
        this.f27905h.setStrokeStyle(1);
        this.f27905h.setLoadImageType(12);
        this.f27898a.setOnClickListener(this.j);
        this.f27904g = (ImageView) this.f27898a.findViewById(f1.frs_service_arrow);
    }

    @Override // b.a.r0.x0.s2.b
    public void a(c0 c0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, c0Var, frsViewData) == null) || c0Var == null || ListUtils.isEmpty(c0Var.f22378b)) {
            return;
        }
        this.f27906i = frsViewData;
        d0 d0Var = c0Var.f22378b.get(0);
        if (d0Var == null) {
            return;
        }
        this.f27903f = d0Var;
        if (!TextUtils.equals(this.f27898a.getResources().getString(i1.hot_user_rank), this.f27903f.f22384b)) {
            this.f27900c.setText(this.f27898a.getContext().getString(i1.forum_exclusive));
        } else {
            this.f27900c.setText(this.f27898a.getContext().getString(i1.frs_service_special));
            this.f27899b.setText(this.f27898a.getContext().getString(i1.hot_person));
        }
        this.f27901d.setText(StringHelper.cutStringWithEllipsisStrict(d0Var.f22385c, 20));
        if (TextUtils.equals(this.f27898a.getResources().getString(i1.hot_user_rank), d0Var.f22384b)) {
            this.f27905h.setVisibility(0);
            this.f27902e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f27902e.startLoad(d0Var.f22384b, 10, false);
            this.f27902e.setVisibility(0);
            this.f27905h.setVisibility(8);
        }
        d.d(d0Var);
    }

    @Override // b.a.r0.x0.s2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), d1.tbds10)).defaultColorValue(i2).into(this.f27899b);
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
            this.f27905h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.x0.s2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27898a : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.s2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f27900c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27901d, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27899b, c1.CAM_X0101);
            WebPManager.setPureDrawable(this.f27904g, e1.icon_pure_arrow12_right, c1.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f27905h.onChangeSkinType();
        }
    }
}
