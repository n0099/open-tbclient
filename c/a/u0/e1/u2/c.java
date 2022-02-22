package c.a.u0.e1.u2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import c.a.u0.e1.i1;
import c.a.u0.z3.d0;
import c.a.u0.z3.e0;
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
/* loaded from: classes8.dex */
public class c implements b, c.a.u0.e1.u2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17166b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17167c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17168d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f17169e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f17170f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17171g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f17172h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f17173i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f17174j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17175e;

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
            this.f17175e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17175e.f17170f != null && "tiebaclient://accelerator".equals(this.f17175e.f17170f.f26154d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.u0.e1.q1.b.a(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.f17175e.f17173i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (!TextUtils.equals(this.f17175e.a.getResources().getString(i1.hot_user_rank), this.f17175e.f17170f.f26152b) || this.f17175e.f17173i == null || this.f17175e.f17173i.getForum() == null || TextUtils.isEmpty(this.f17175e.f17173i.getForum().getId())) {
                    if (this.f17175e.f17170f != null && this.f17175e.f17170f.f26156f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f17175e.f17170f.f26157g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f17175e.f17170f.f26156f.f26164b).param("obj_name", this.f17175e.f17170f.f26156f.a).param("obj_param1", this.f17175e.f17170f.f26156f.f26166d.intValue()));
                    }
                    if (this.f17175e.f17170f != null && !"tiebaclient://accelerator".equals(this.f17175e.f17170f.f26154d)) {
                        d.b(view.getContext(), this.f17175e.f17170f);
                    }
                    d.c(this.f17175e.f17170f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.f17175e.f17173i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f17175e.f17173i.getForum().getId());
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
        this.f17174j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(g1.frs_one_service_layout, (ViewGroup) null);
        this.a = inflate;
        this.f17166b = (TextView) inflate.findViewById(f1.frs_service);
        this.f17167c = (TextView) this.a.findViewById(f1.frs_service_category);
        this.f17168d = (TextView) this.a.findViewById(f1.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(f1.frs_service_icon);
        this.f17169e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f17169e.setIsRound(true);
        this.f17169e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(f1.image_group);
        this.f17172h = imageOverlayView;
        imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, c1.CAM_X0618, dimensionPixelOffset3);
        this.f17172h.setStrokeStyle(1);
        this.f17172h.setLoadImageType(12);
        this.a.setOnClickListener(this.f17174j);
        this.f17171g = (ImageView) this.a.findViewById(f1.frs_service_arrow);
    }

    @Override // c.a.u0.e1.u2.b
    public void a(d0 d0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d0Var, frsViewData) == null) || d0Var == null || ListUtils.isEmpty(d0Var.f26148b)) {
            return;
        }
        this.f17173i = frsViewData;
        e0 e0Var = d0Var.f26148b.get(0);
        if (e0Var == null) {
            return;
        }
        this.f17170f = e0Var;
        if (!TextUtils.equals(this.a.getResources().getString(i1.hot_user_rank), this.f17170f.f26152b)) {
            this.f17167c.setText(this.a.getContext().getString(i1.forum_exclusive));
        } else {
            this.f17167c.setText(this.a.getContext().getString(i1.frs_service_special));
            this.f17166b.setText(this.a.getContext().getString(i1.hot_person));
        }
        this.f17168d.setText(StringHelper.cutStringWithEllipsisStrict(e0Var.f26153c, 20));
        if (TextUtils.equals(this.a.getResources().getString(i1.hot_user_rank), e0Var.f26152b)) {
            this.f17172h.setVisibility(0);
            this.f17169e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f17169e.startLoad(e0Var.f26152b, 10, false);
            this.f17169e.setVisibility(0);
            this.f17172h.setVisibility(8);
        }
        d.d(e0Var);
    }

    @Override // c.a.u0.e1.u2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(getView().getContext(), d1.tbds10)).defaultColorValue(i2).into(this.f17166b);
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
            this.f17172h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.u0.e1.u2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.u0.e1.u2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f17167c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f17168d, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f17166b, c1.CAM_X0101);
            WebPManager.setPureDrawable(this.f17171g, e1.icon_pure_arrow12_right, c1.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f17172h.onChangeSkinType();
        }
    }
}
