package c.a.p0.w0.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.o0.c1.o0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f19427b;

    /* renamed from: c  reason: collision with root package name */
    public int f19428c;

    /* renamed from: d  reason: collision with root package name */
    public View f19429d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19430e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19431f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19432g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19433h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public IrregularImageView m;
    public TextView n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public ImageOverlayView r;
    public ImageView s;
    public ImageView t;
    public String u;
    public View v;
    public c.a.p0.w0.j.c.a w;
    public View.OnClickListener x;

    /* renamed from: c.a.p0.w0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1468a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1468a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f19427b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13671");
                    statisticItem.param("fid", this.a.f19427b);
                    TiebaStatic.log(statisticItem);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.f19429d.getContext());
                hotUserRankActivityConfig.setCategory(this.a.u);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getId() != this.a.v.getId() || this.a.w == null || this.a.w.f19442c == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.f19429d.getContext(), this.a.w.f19442c.getUserId(), this.a.w.f19442c.getName_show())));
            if (!TextUtils.isEmpty(this.a.a)) {
                StatisticItem statisticItem = new StatisticItem("c13659");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.w.a);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.w.f19442c.rankNum);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13683");
            statisticItem2.param("uid", this.a.w.f19442c.getUserId());
            statisticItem2.param("fid", this.a.f19427b);
            TiebaStatic.log(statisticItem2);
        }
    }

    public a(View view, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19428c = 3;
        this.x = new b(this);
        this.f19429d = view;
        this.a = str;
        this.f19427b = j;
        View findViewById = view.findViewById(R.id.obfuscated_res_0x7f0920ad);
        this.v = findViewById;
        findViewById.setOnClickListener(this.x);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919b6);
        this.f19430e = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f19431f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920d0);
        this.f19432g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0919b0);
        this.f19433h = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ebc);
        this.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ebb);
        this.j = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ea6);
        this.k = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ed1);
        this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ed0);
        IrregularImageView irregularImageView = (IrregularImageView) view.findViewById(R.id.obfuscated_res_0x7f090edf);
        this.m = irregularImageView;
        irregularImageView.setErrorRes(R.drawable.obfuscated_res_0x7f080f1d);
        this.f19433h.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810e9, 1, false));
        this.i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810e5, 1, false));
        this.j.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810e7, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810e6, 1, false));
        this.l.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810e8, 1, false));
        TextView textView2 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f2e);
        this.n = textView2;
        textView2.setText(this.f19429d.getResources().getString(R.string.obfuscated_res_0x7f0f0889));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f090dba);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(new View$OnClickListenerC1468a(this));
        this.p = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090dbc);
        this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090dbd);
        this.t = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090dbe);
        this.r = (ImageOverlayView) view.findViewById(R.id.obfuscated_res_0x7f090dbf);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.r.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.r.setStrokeStyle(1);
        this.r.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.r.setLoadImageType(12);
        this.s = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090dbb);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            int count = ListUtils.getCount(list);
            if (count == 0) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
            if (count < 3) {
                int i = 3 - count;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.rightMargin = dimensionPixelOffset - (i * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
                this.t.setLayoutParams(layoutParams);
            }
        }
    }

    public BdUniqueId h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext().getUniqueId();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public final List<String> i(List<User> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (User user : list) {
                if (user != null) {
                    arrayList.add(user.portrait);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.f19428c == i) {
            return;
        }
        this.f19428c = i;
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.p, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.t, R.drawable.obfuscated_res_0x7f0810e0, SvgManager.SvgResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
        this.r.d();
    }

    public void k(c.a.p0.w0.j.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, aVar, z) == null) {
            this.w = aVar;
            if (aVar == null) {
                return;
            }
            this.f19430e.setText(aVar.a);
            if (aVar.f19442c != null) {
                String str = aVar.f19441b;
                if (o0.d(str) > 10) {
                    str = o0.n(aVar.f19441b, 10) + StringHelper.STRING_MORE;
                }
                this.f19431f.setText(String.format(this.f19429d.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f088c), str));
            }
            if (aVar.f19443d == 0) {
                this.f19432g.setVisibility(8);
            } else {
                this.f19432g.setVisibility(0);
                this.f19432g.setText(String.format(this.f19429d.getContext().getString(R.string.obfuscated_res_0x7f0f0888), StringHelper.getDateStringMdChinease(aVar.f19443d * 1000)));
            }
            this.m.setImage(aVar.f19444e, h(this.f19429d.getContext()), R.drawable.obfuscated_res_0x7f080d3d);
            TiebaFieldsInfo tiebaFieldsInfo = aVar.f19445f;
            if (tiebaFieldsInfo != null && !z && !TextUtils.isEmpty(tiebaFieldsInfo.tieba_name)) {
                this.o.setVisibility(0);
                this.q.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0384), aVar.f19445f.tieba_name));
                List<String> i = i(aVar.f19445f.user_rank);
                this.r.setData(i);
                g(i);
                this.u = aVar.f19445f.tieba_name;
                if (this.f19427b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13670");
                    statisticItem.param("fid", this.f19427b);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.o.setVisibility(8);
        }
    }
}
