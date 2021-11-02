package b.a.r0.n2.g;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends b.a.r0.b0.b<b.a.r0.n2.e.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public UserData B;
    public int C;
    public int D;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public View y;
    public View z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
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
        this.C = 3;
        this.D = 0;
        View i4 = i();
        this.A = (LinearLayout) i4.findViewById(R.id.layout_container);
        this.y = i4.findViewById(R.id.top_divider_line);
        this.z = i4.findViewById(R.id.bottom_divider_line);
        this.m = (TextView) i4.findViewById(R.id.fans_num);
        this.n = (TextView) i4.findViewById(R.id.fans_title);
        this.o = (TextView) i4.findViewById(R.id.concer_num);
        this.p = (TextView) i4.findViewById(R.id.concer_title);
        this.q = (TextView) i4.findViewById(R.id.attention_bar_num);
        this.r = (TextView) i4.findViewById(R.id.attention_bar_title);
        this.s = (TextView) i4.findViewById(R.id.thread_num);
        this.t = (TextView) i4.findViewById(R.id.thread_title);
        this.u = (LinearLayout) i4.findViewById(R.id.fans_action);
        this.v = (LinearLayout) i4.findViewById(R.id.concer_action);
        this.w = (LinearLayout) i4.findViewById(R.id.attention_action);
        this.x = (LinearLayout) i4.findViewById(R.id.thread_action);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_center_actions_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.C == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
        int g2 = l.g(getContext(), R.dimen.tbds16);
        TBSelector.makeShadowDrawable().setShape(1).setShadowSide(4096).setBgColor(R.color.CAM_X0205).setShapeRadius(0).setShadowLayer(R.color.cp_shadow_a, 0.2f, 0, l.g(getContext(), R.dimen.tbds5), g2).into(i());
        this.C = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.n2.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.B = dVar.j;
            this.D = dVar.f21435f;
            this.m.setText(StringHelper.numFormatOverWanNa(dVar.f21434e));
            this.o.setText(Integer.toString(dVar.f21435f));
            this.q.setText(Integer.toString(dVar.f21436g));
            this.s.setText(StringHelper.longNumFormatOver9999wan(dVar.f21437h));
            this.u.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            k(h(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.fans_action) {
            if (this.B == null) {
                return;
            }
            b.a.r0.a3.a.v().L(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f14737f.getPageActivity(), false, this.B.getUserId(), this.B.getSex()).updateBjhUser(this.B.isBaijiahaoUser())));
        } else if (view.getId() == R.id.concer_action) {
            if (this.B == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 5));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f14737f.getPageActivity(), true, this.B.getUserId(), this.B.getSex()).updateBjhUser(this.B.isBaijiahaoUser()).updateFollowNum(this.D, this.B.getPortrait())));
        } else if (view.getId() == R.id.attention_action) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 7));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f14737f.getPageActivity(), this.B.getLike_bars(), this.B.getUserId(), this.B.getSex())));
        } else if (view.getId() == R.id.thread_action) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f14737f.getPageActivity(), this.B.getUserId(), this.B.getSex(), this.B.getPortrait())));
        }
    }
}
