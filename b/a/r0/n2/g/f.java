package b.a.r0.n2.g;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.n2.e.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f extends b.a.r0.b0.b<b.a.r0.n2.e.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public b.a.r0.n2.e.g q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f22991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f22992f;

        public a(f fVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22992f = fVar;
            this.f22991e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22992f.q(this.f22991e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext) {
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
        View i4 = i();
        this.m = i4.findViewById(R.id.create_center_container);
        this.n = (TextView) i4.findViewById(R.id.text_create_center);
        ImageView imageView = (ImageView) i4.findViewById(R.id.img_arrow);
        this.o = imageView;
        imageView.setOnClickListener(this);
        this.p = (LinearLayout) i4.findViewById(R.id.func_entrance);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_create_center : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            for (int i3 = 0; i3 < this.p.getChildCount(); i3++) {
                SkinManager.setViewTextColor((TextView) this.p.getChildAt(i3).findViewById(R.id.create_center_item_text), R.color.CAM_X0105);
            }
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(l.g(this.f16225g, R.dimen.tbds21)).setBgColor(R.color.CAM_X0201).setShadowColor(R.color.CAM_X0806).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f16225g, R.dimen.tbds16)).setOffsetX(0).setOffsetY(l.g(this.f16225g, R.dimen.tbds5)).into(this.m);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.getId() == this.o.getId()) {
            t(R.string.create_center, TbConfig.URL_CREATE_CENTER);
            TiebaStatic.log("c13842");
        }
    }

    public final View p(Context context, g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setId(R.id.create_center_item_img);
            tbImageView.setImageResource(aVar.f22949b);
            int g2 = l.g(context, R.dimen.tbds126);
            linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(g2, g2));
            TextView textView = new TextView(context);
            textView.setId(R.id.create_center_item_text);
            textView.setText(aVar.f22950c);
            textView.setIncludeFontPadding(false);
            textView.setTextSize(0, l.g(this.f16225g, R.dimen.tbfontsize32));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = l.g(context, R.dimen.tbds32);
            linearLayout.addView(textView, layoutParams);
            linearLayout.setOnClickListener(new a(this, aVar));
            return linearLayout;
        }
        return (View) invokeLL.objValue;
    }

    public final void q(g.a aVar) {
        b.a.r0.n2.e.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || (gVar = this.q) == null || gVar.f22947f == null) {
            return;
        }
        int i2 = aVar.f22948a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f16224f.getPageActivity(), this.q.f22947f.getUserId(), this.q.f22947f.getSex(), this.q.f22947f.getPortrait())));
            TiebaStatic.log("c13843");
        } else if (i2 == 2) {
            t(R.string.god_authentication, TbConfig.URL_GOD_AUTH);
            TiebaStatic.log(new StatisticItem("c13844").param("obj_type", 1));
        } else if (i2 == 5) {
            t(R.string.god_examination, TbConfig.URL_GOD_EXAMINE);
            TiebaStatic.log(new StatisticItem("c13844").param("obj_type", 2));
        } else if (i2 == 3) {
            t(R.string.create_college, TbConfig.URL_CREATE_COLLEGE);
            TiebaStatic.log("c13845");
        } else if (i2 == 4) {
            t(R.string.hot_activities, TbConfig.URL_HOT_ACTIVITIES);
            TiebaStatic.log("c13846");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: s */
    public void j(b.a.r0.n2.e.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || gVar == null || ListUtils.isEmpty(gVar.f22946e)) {
            return;
        }
        if (gVar != this.q) {
            this.p.removeAllViews();
            int k = (l.k(this.f16225g) - (l.g(this.f16225g, R.dimen.tbds44) * 2)) / gVar.f22946e.size();
            for (g.a aVar : gVar.f22946e) {
                if (aVar != null) {
                    this.p.addView(p(this.f16225g, aVar), new LinearLayout.LayoutParams(k, -2));
                }
            }
            this.q = gVar;
        }
        k(h(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            this.f16224f.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f16224f.getPageActivity(), this.f16224f.getString(i2), str, true)));
        }
    }
}
