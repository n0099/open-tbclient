package c.a.q0.v0.g2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.i3.a0;
import c.a.q0.i3.b0;
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
public class c implements b, c.a.q0.v0.g2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26127a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26128b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26129c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26130d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f26131e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f26132f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f26133g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f26134h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f26135i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f26136j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26137e;

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
            this.f26137e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TextUtils.equals(this.f26137e.f26127a.getResources().getString(R.string.hot_user_rank), this.f26137e.f26132f.f20207b) || this.f26137e.f26135i == null || this.f26137e.f26135i.getForum() == null || TextUtils.isEmpty(this.f26137e.f26135i.getForum().getId())) {
                    if (this.f26137e.f26132f != null && this.f26137e.f26132f.f20211f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f26137e.f26132f.f20212g).param("obj_source", AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM).param("obj_id", this.f26137e.f26132f.f20211f.f20216b).param("obj_name", this.f26137e.f26132f.f20211f.f20215a).param("obj_param1", this.f26137e.f26132f.f20211f.f20218d.intValue()));
                    }
                    d.b(view.getContext(), this.f26137e.f26132f);
                    d.c(this.f26137e.f26132f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.e.e.m.b.f(this.f26137e.f26135i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f26137e.f26135i.getForum().getId());
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
        this.f26136j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f26127a = inflate;
        this.f26128b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f26129c = (TextView) this.f26127a.findViewById(R.id.frs_service_category);
        this.f26130d = (TextView) this.f26127a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f26127a.findViewById(R.id.frs_service_icon);
        this.f26131e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f26131e.setIsRound(true);
        this.f26131e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f26127a.findViewById(R.id.image_group);
        this.f26134h = imageOverlayView;
        imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f26134h.setStrokeStyle(1);
        this.f26134h.setLoadImageType(12);
        this.f26127a.setOnClickListener(this.f26136j);
        this.f26133g = (ImageView) this.f26127a.findViewById(R.id.frs_service_arrow);
    }

    @Override // c.a.q0.v0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, a0Var, frsViewData) == null) || a0Var == null || ListUtils.isEmpty(a0Var.f20205b)) {
            return;
        }
        this.f26135i = frsViewData;
        b0 b0Var = a0Var.f20205b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f26132f = b0Var;
        if (!TextUtils.equals(this.f26127a.getResources().getString(R.string.hot_user_rank), this.f26132f.f20207b)) {
            this.f26129c.setText(this.f26127a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f26129c.setText(this.f26127a.getContext().getString(R.string.frs_service_special));
            this.f26128b.setText(this.f26127a.getContext().getString(R.string.hot_person));
        }
        this.f26130d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f20208c, 20));
        if (TextUtils.equals(this.f26127a.getResources().getString(R.string.hot_user_rank), b0Var.f20207b)) {
            this.f26134h.setVisibility(0);
            this.f26131e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f26131e.startLoad(b0Var.f20207b, 10, false);
            this.f26131e.setVisibility(0);
            this.f26134h.setVisibility(8);
        }
        d.d(b0Var);
    }

    @Override // c.a.q0.v0.g2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f26128b);
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
            this.f26134h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.v0.g2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26127a : (View) invokeV.objValue;
    }

    @Override // c.a.q0.v0.g2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f26129c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26130d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26128b, R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f26133g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f26134h.onChangeSkinType();
        }
    }
}
