package c.a.q0.l2.g;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.a0.b0;
import c.a.q0.l2.e.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends c.a.q0.a0.b<c.a.q0.l2.e.h> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public View n;
    public ImageView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public View v;
    public View w;
    public c.a.q0.l2.e.h x;
    public j y;
    public UserData z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        View j2 = j();
        this.n = j2.findViewById(R.id.item_content);
        this.v = j2.findViewById(R.id.function_item_bottom_divider);
        this.w = j2.findViewById(R.id.function_item_bottom_divider_line);
        this.o = (ImageView) j2.findViewById(R.id.function_icon);
        this.s = (ImageView) j2.findViewById(R.id.function_right_arrow);
        this.p = (TextView) j2.findViewById(R.id.function_title);
        this.q = (ImageView) j2.findViewById(R.id.function_red_tip);
        this.r = (TextView) j2.findViewById(R.id.function_desc);
        this.t = (TextView) j2.findViewById(R.id.right_text);
        this.u = (TextView) j2.findViewById(R.id.function_title_mark);
        this.t.setOnClickListener(this);
        this.n.setOnClickListener(this);
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_center_function_item_layout : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setImageResource(this.q, R.drawable.person_center_red_tip_shape);
        SkinManager.setBackgroundColor(this.v, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0105);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b0<T> b0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null) {
            return;
        }
        if (view == this.n) {
            c.a.q0.l2.e.h hVar = this.x;
            if (hVar.f21785e == 36 && "游戏".equals(hVar.f21789i) && (b0Var = this.f15235i) != 0) {
                b0Var.a(view, this.x);
                return;
            } else {
                p();
                return;
            }
        }
        q(view);
    }

    public final void p() {
        c.a.q0.l2.e.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.x) == null) {
            return;
        }
        switch (hVar.f21785e) {
            case 10:
                c.a.q0.y2.a.v().L(1, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                if (this.z == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.f15232f.getPageActivity(), this.z.getUserId(), this.z.getUserName(), this.z.getName_show(), this.z.getSex(), "iowner_gift")));
                return;
            case 11:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                if (StringUtils.isNull(this.x.k)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{this.x.k});
                return;
            case 12:
                c.a.q0.y2.a.v().L(7, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 12));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.f15232f.getPageActivity())));
                return;
            case 13:
            case 14:
            case 15:
            case 19:
            case 20:
            case 21:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 32:
            case 34:
            case 35:
            case 40:
            case 42:
            default:
                return;
            case 16:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
                c.a.q0.y2.a.v().L(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.f15232f.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.f15232f.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 15));
                UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 11));
                if (this.z == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.f15232f.getPageActivity(), this.z.getSex(), 0, 1)));
                return;
            case 25:
                if (this.z == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.f15232f.getPageActivity(), this.z.getUserId(), this.z.getUserName(), this.z.getPortrait(), this.z.getSex(), true)));
                return;
            case 30:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                if (c.a.p0.r0.b.b(this.f15232f)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(i().getPageActivity()).createNormalConfig("hottopic", "all")));
                return;
            case 31:
                c.a.q0.y2.a.v().L(10, false, true);
                c.a.p0.s.d0.b.j().t("key_feedback_tip_show", false);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                StringBuilder sb = new StringBuilder();
                sb.append("http://tieba.baidu.com/mo/q/hybrid-main-service/uegServiceCenter?is_yy_user=");
                sb.append(TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                c.a.p0.m.a.m(this.f15232f.getPageActivity(), sb.toString());
                return;
            case 33:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.f15232f.getPageActivity(), this.x.n)));
                return;
            case 36:
                TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.x.o));
                s(this.x.k);
                return;
            case 37:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                c.a.p0.s.d0.b.j().t("key_has_borrow_cash_clicked", true);
                j jVar = this.x.m;
                if (jVar != null) {
                    jVar.f21793a = false;
                }
                this.q.setVisibility(8);
                String p = c.a.p0.s.d0.b.j().p("cash_pay", "");
                if (StringUtils.isNull(p)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001447, p));
                return;
            case 38:
                c.a.p0.t.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.f()) {
                    String c2 = activityPrizeData.c();
                    if (StringUtils.isNull(c2)) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12598"));
                    c.a.q0.y2.a.v().L(9, false, true);
                    UrlManager.getInstance().dealOneLink(i(), new String[]{c2}, true);
                    return;
                }
                return;
            case 39:
                c.a.p0.m.a.v(true, this.f15232f.getPageActivity(), this.f15232f.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                c.a.p0.s.d0.b.j().t("key_baidu_financial_has_clicked", true);
                j jVar2 = this.x.m;
                if (jVar2 != null) {
                    jVar2.f21793a = false;
                }
                this.q.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                t();
                c.a.p0.m.a.m(this.f15232f.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                if (!TextUtils.isEmpty(this.x.k)) {
                    UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{this.x.k});
                }
                if (!k.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", d().getString(R.string.third_lite_game_center)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", d().getString(R.string.baidu_lite_game_center)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                }
            case 45:
                if (!TextUtils.isEmpty(hVar.k)) {
                    c.a.p0.m.a.m(this.f15233g, this.x.k);
                }
                StatisticItem.make("c13548").eventStat();
                return;
            case 46:
                UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{this.x.k}, true);
                return;
        }
    }

    public final void q(View view) {
        c.a.q0.l2.e.h hVar;
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && (hVar = this.x) != null && view == this.t) {
            int i2 = hVar.f21785e;
            if (i2 == 10) {
                CurrencyJumpHelper.personGotoBuyBean(this.f15232f.getPageActivity());
            } else if (i2 != 45 || (jVar = this.y) == null || TextUtils.isEmpty(jVar.f21796d)) {
            } else {
                UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{this.y.f21796d});
            }
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            v(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, ""));
            sb.append(str.contains("?") ? "&" : "?");
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{str});
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: u */
    public void k(c.a.q0.l2.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) || hVar == null) {
            return;
        }
        this.x = hVar;
        this.z = hVar.l;
        this.y = hVar.m;
        this.p.setText(hVar.f21789i);
        w();
        x(hVar);
        y(this.y);
        l(this.f15232f, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                l.L(this.f15232f.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f15232f, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            c.a.p0.m.a.t(this.f15232f.getPageActivity(), true, str);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.x.f21786f > 0) {
                this.o.setVisibility(0);
                c.a.q0.l2.e.h hVar = this.x;
                if (hVar.f21787g) {
                    if (hVar.f21788h) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, this.x.f21786f, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.o, this.x.f21786f, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.o, hVar.f21786f);
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public final void x(c.a.q0.l2.e.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            if (hVar.f21790j) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
        }
    }

    public final void y(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
            if (jVar != null) {
                if (jVar.f21793a) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                if (!StringUtils.isNull(jVar.f21794b)) {
                    this.r.setVisibility(0);
                    this.r.setText(jVar.f21794b);
                } else {
                    this.r.setVisibility(8);
                }
                if (jVar.f21800h) {
                    this.u.setVisibility(0);
                } else {
                    this.u.setVisibility(8);
                }
                if (!TextUtils.isEmpty(jVar.f21795c)) {
                    this.t.setVisibility(0);
                    this.t.setText(jVar.f21795c);
                    TextView textView = this.t;
                    Drawable drawable = jVar.f21797e;
                    Drawable drawable2 = jVar.f21798f;
                    Drawable drawable3 = jVar.f21799g;
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable3);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        }
    }
}
