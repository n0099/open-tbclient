package c.a.r0.w0.h2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.r0.j3.b0;
import c.a.r0.j3.c0;
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
/* loaded from: classes4.dex */
public class c implements b, c.a.r0.w0.h2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26871a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26872b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26873c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26874d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f26875e;

    /* renamed from: f  reason: collision with root package name */
    public c0 f26876f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f26877g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f26878h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f26879i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f26880j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26881e;

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
            this.f26881e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TextUtils.equals(this.f26881e.f26871a.getResources().getString(R.string.hot_user_rank), this.f26881e.f26876f.f20783b) || this.f26881e.f26879i == null || this.f26881e.f26879i.getForum() == null || TextUtils.isEmpty(this.f26881e.f26879i.getForum().getId())) {
                    if (this.f26881e.f26876f != null && this.f26881e.f26876f.f20787f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f26881e.f26876f.f20788g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f26881e.f26876f.f20787f.f20796b).param("obj_name", this.f26881e.f26876f.f20787f.f20795a).param("obj_param1", this.f26881e.f26876f.f20787f.f20798d.intValue()));
                    }
                    d.b(view.getContext(), this.f26881e.f26876f);
                    d.c(this.f26881e.f26876f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.e.e.m.b.g(this.f26881e.f26879i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f26881e.f26879i.getForum().getId());
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
        this.f26880j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f26871a = inflate;
        this.f26872b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f26873c = (TextView) this.f26871a.findViewById(R.id.frs_service_category);
        this.f26874d = (TextView) this.f26871a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f26871a.findViewById(R.id.frs_service_icon);
        this.f26875e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f26875e.setIsRound(true);
        this.f26875e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f26871a.findViewById(R.id.image_group);
        this.f26878h = imageOverlayView;
        imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f26878h.setStrokeStyle(1);
        this.f26878h.setLoadImageType(12);
        this.f26871a.setOnClickListener(this.f26880j);
        this.f26877g = (ImageView) this.f26871a.findViewById(R.id.frs_service_arrow);
    }

    @Override // c.a.r0.w0.h2.b
    public void a(b0 b0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, b0Var, frsViewData) == null) || b0Var == null || ListUtils.isEmpty(b0Var.f20781b)) {
            return;
        }
        this.f26879i = frsViewData;
        c0 c0Var = b0Var.f20781b.get(0);
        if (c0Var == null) {
            return;
        }
        this.f26876f = c0Var;
        if (!TextUtils.equals(this.f26871a.getResources().getString(R.string.hot_user_rank), this.f26876f.f20783b)) {
            this.f26873c.setText(this.f26871a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f26873c.setText(this.f26871a.getContext().getString(R.string.frs_service_special));
            this.f26872b.setText(this.f26871a.getContext().getString(R.string.hot_person));
        }
        this.f26874d.setText(StringHelper.cutStringWithEllipsisStrict(c0Var.f20784c, 20));
        if (TextUtils.equals(this.f26871a.getResources().getString(R.string.hot_user_rank), c0Var.f20783b)) {
            this.f26878h.setVisibility(0);
            this.f26875e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f26875e.startLoad(c0Var.f20783b, 10, false);
            this.f26875e.setVisibility(0);
            this.f26878h.setVisibility(8);
        }
        d.d(c0Var);
    }

    @Override // c.a.r0.w0.h2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f26872b);
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
            this.f26878h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.w0.h2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26871a : (View) invokeV.objValue;
    }

    @Override // c.a.r0.w0.h2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f26873c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26874d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26872b, R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f26877g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f26878h.onChangeSkinType();
        }
    }
}
