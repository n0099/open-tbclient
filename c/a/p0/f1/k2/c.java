package c.a.p0.f1.k2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.a4.d0;
import c.a.p0.a4.e0;
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
public class c implements b, c.a.p0.f1.k2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14178b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14179c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14180d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f14181e;

    /* renamed from: f  reason: collision with root package name */
    public e0 f14182f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14183g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f14184h;
    public FrsViewData i;
    public View.OnClickListener j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f14182f != null && "tiebaclient://accelerator".equals(this.a.f14182f.f12183d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new c.a.p0.f1.g1.b.a(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.a.i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (!TextUtils.equals(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0886), this.a.f14182f.f12181b) || this.a.i == null || this.a.i.getForum() == null || TextUtils.isEmpty(this.a.i.getForum().getId())) {
                    if (this.a.f14182f != null && this.a.f14182f.f12185f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f14182f.f12186g).param("obj_source", "frs_card").param("obj_id", this.a.f14182f.f12185f.f12192b).param("obj_name", this.a.f14182f.f12185f.a).param("obj_param1", this.a.f14182f.f12185f.f12194d.intValue()));
                    }
                    if (this.a.f14182f != null && !"tiebaclient://accelerator".equals(this.a.f14182f.f12183d)) {
                        d.b(view.getContext(), this.a.f14182f);
                    }
                    d.c(this.a.f14182f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(this.a.i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.a.i.getForum().getId());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0347, (ViewGroup) null);
        this.a = inflate;
        this.f14178b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bc6);
        this.f14179c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bc8);
        this.f14180d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bca);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090bc9);
        this.f14181e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f14181e.setIsRound(true);
        this.f14181e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(R.id.obfuscated_res_0x7f090e73);
        this.f14184h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f14184h.setStrokeStyle(1);
        this.f14184h.setLoadImageType(12);
        this.a.setOnClickListener(this.j);
        this.f14183g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090bc7);
    }

    @Override // c.a.p0.f1.k2.b
    public void a(d0 d0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d0Var, frsViewData) == null) || d0Var == null || ListUtils.isEmpty(d0Var.f12177b)) {
            return;
        }
        this.i = frsViewData;
        e0 e0Var = d0Var.f12177b.get(0);
        if (e0Var == null) {
            return;
        }
        this.f14182f = e0Var;
        if (!TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0886), this.f14182f.f12181b)) {
            this.f14179c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0659));
        } else {
            this.f14179c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f072c));
            this.f14178b.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f085b));
        }
        this.f14180d.setText(StringHelper.cutStringWithEllipsisStrict(e0Var.f12182c, 20));
        if (TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0886), e0Var.f12181b)) {
            this.f14184h.setVisibility(0);
            this.f14181e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f14181e.J(e0Var.f12181b, 10, false);
            this.f14181e.setVisibility(0);
            this.f14184h.setVisibility(8);
        }
        d.d(e0Var);
    }

    @Override // c.a.p0.f1.k2.a
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i).into(this.f14178b);
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
            this.f14184h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.f1.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.k2.b
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.f14179c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14180d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14178b, (int) R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f14183g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f14184h.d();
        }
    }
}
