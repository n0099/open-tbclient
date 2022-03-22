package c.a.p0.k1.d;

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
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
public class b extends c.a.p0.h0.b<h> {
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
    public MetaData q;
    public h r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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
        clickableHeaderImageView.setGodIconMargin(R.dimen.obfuscated_res_0x7f0702df);
        this.k.setAfterClickListener(this);
        this.l = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090cc9);
        this.m = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090cc5);
        this.n = (TextView) k().findViewById(R.id.obfuscated_res_0x7f0919ce);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) k().findViewById(R.id.obfuscated_res_0x7f090cc8);
        this.i = commonUserLikeButton;
        this.j = new c(tbPageContext, commonUserLikeButton);
        this.i.setAfterOnClickListener(this);
        this.o = k().findViewById(R.id.obfuscated_res_0x7f0903ca);
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0196 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(k(), R.drawable.home_thread_card_item_bg);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
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
                h().a(view, this.r);
            }
            if (view != k() || (metaData = this.q) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.q.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.p.getPageActivity(), this.q.getUserId(), this.q.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.r = hVar;
        MetaData metaData2 = hVar.a;
        this.q = metaData2;
        this.k.setData(metaData2);
        this.l.setText(hVar.a.getName_show());
        this.m.setText(hVar.a.getGodUserData().getIntro());
        String string = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f0f58);
        String recommendReason = hVar.a.getGodUserData().getRecommendReason();
        if (StringUtils.isNull(recommendReason)) {
            this.n.setText("");
        } else {
            this.n.setText(String.format(string, recommendReason));
        }
        this.j.n(hVar.a);
        m(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }
}
