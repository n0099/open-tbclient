package c.a.p0.w0.n.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.w0.n.d.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f19560b;

    /* renamed from: c  reason: collision with root package name */
    public View f19561c;

    /* renamed from: d  reason: collision with root package name */
    public RoundRelativeLayout f19562d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19563e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19564f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19565g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19566h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public HotUserRankImageOverlayView l;
    public ImageView m;
    public int n;
    public String o;
    public String p;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.f19560b.getPageActivity());
                hotUserRankActivityConfig.setCategory(this.a.o);
                this.a.f19560b.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13655");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.p);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f19560b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01bf, (ViewGroup) null);
        this.f19561c = inflate;
        this.f19562d = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0923b8);
        this.f19563e = (ImageView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f090e03);
        this.f19564f = (ImageView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f090e04);
        this.f19565g = (TbImageView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f0919b3);
        this.f19566h = (ImageView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f0919b4);
        this.i = (TextView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f090a8e);
        this.j = (TextView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f09157f);
        this.l = (HotUserRankImageOverlayView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f090e7b);
        this.k = (ImageView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f090fca);
        this.m = (ImageView) this.f19561c.findViewById(R.id.obfuscated_res_0x7f090e15);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.l.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.l.setStrokeStyle(1);
        this.l.setLoadImageType(12);
        this.l.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.f19562d.setOnClickListener(new a(this));
        int f2 = n.f(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.n = f2;
        this.f19562d.setRoundLayoutRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19561c : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.a = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.f19562d, R.color.CAM_X0206);
        if (this.f19566h.getVisibility() == 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f19566h, R.drawable.obfuscated_res_0x7f0805eb, SvgManager.SvgResourceStateType.NORMAL);
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f19563e, R.drawable.obfuscated_res_0x7f08064b, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setImageResource(this.f19564f, R.drawable.obfuscated_res_0x7f080f1e);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.obfuscated_res_0x7f0805f8, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0311);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0311);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f0805e8, null);
        this.l.d();
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        String str = cVar.f19550b;
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.o = "";
        }
        TextView textView = this.i;
        textView.setText(this.o + "榜");
        List<ShortUserInfo> list = cVar.a;
        if (list != null && list.size() > 0) {
            TextView textView2 = this.j;
            textView2.setText("NO.1 " + cVar.a.get(0).user_name);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ShortUserInfo shortUserInfo : cVar.a) {
                if (i > 2) {
                    break;
                }
                i++;
                arrayList.add(shortUserInfo.portrait);
            }
            this.l.setData(arrayList);
            if (!TextUtils.isEmpty(cVar.f19551c)) {
                this.f19565g.setVisibility(0);
                this.f19566h.setVisibility(8);
                this.f19565g.J(cVar.f19551c, 12, false);
            } else {
                this.f19566h.setVisibility(0);
                this.f19565g.setVisibility(8);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f19566h, R.drawable.obfuscated_res_0x7f0805eb, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
        e();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.p = str;
        }
    }
}
