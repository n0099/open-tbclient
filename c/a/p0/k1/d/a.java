package c.a.p0.k1.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import c.a.o0.r.l0.t.c;
import c.a.p0.h0.e0.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.p0.h0.b<h> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonUserLikeButton i;
    public c j;
    public ClickableHeaderImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public TbPageContext<?> p;
    public Drawable q;
    public MetaData r;
    public h s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = tbPageContext;
        k().setOnClickListener(this);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) k().findViewById(R.id.obfuscated_res_0x7f090cc6);
        this.k = clickableHeaderImageView;
        clickableHeaderImageView.setGodIconMargin(R.dimen.obfuscated_res_0x7f070224);
        this.k.setAfterClickListener(this);
        this.m = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090cc9);
        this.n = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090cc5);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) k().findViewById(R.id.obfuscated_res_0x7f090cc8);
        this.i = commonUserLikeButton;
        this.j = new c(tbPageContext, commonUserLikeButton);
        this.i.setAfterOnClickListener(this);
        this.o = k().findViewById(R.id.obfuscated_res_0x7f0903ca);
        this.l = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090cca);
        this.q = this.p.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081200);
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0195 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(k(), R.drawable.home_thread_card_item_bg);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (h() != null) {
                h().a(view, this.s);
            }
            if (view != k() || (metaData = this.r) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.r.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.p.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.r.getUserId(), 0L), false, this.r.isBigV())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: q */
    public void l(h hVar) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) || hVar == null || (metaData = hVar.a) == null || metaData.getGodUserData() == null) {
            return;
        }
        this.s = hVar;
        this.r = hVar.a;
        t(hVar.f15333c);
        this.k.setData(hVar.a);
        this.m.setText(hVar.a.getName_show());
        this.n.setText(hVar.a.getGodUserData().getIntro());
        this.j.n(hVar.a);
        m(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public final void t(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i == 1) {
                this.l.setText("");
                SkinManager.setBackgroundResource(this.l, R.drawable.icon_grade_round_no1);
            } else if (i == 2) {
                this.l.setText("");
                SkinManager.setBackgroundResource(this.l, R.drawable.icon_grade_round_no2);
            } else if (i != 3) {
                this.l.setBackgroundDrawable(this.q);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.l.setText(str);
            } else {
                this.l.setText("");
                SkinManager.setBackgroundResource(this.l, R.drawable.icon_grade_round_no3);
            }
        }
    }
}
