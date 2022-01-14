package c.a.t0.x2.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class o extends c.a.t0.g0.b<c.a.t0.x2.e.l> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TbImageView n;
    public TextView o;
    public ImageView p;
    public c.a.t0.x2.e.l q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbPageContext<?> tbPageContext) {
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
        View j2 = j();
        this.m = j2;
        this.n = (TbImageView) j2.findViewById(c.a.t0.y2.d.polymeric_vedio_pic);
        this.o = (TextView) this.m.findViewById(c.a.t0.y2.d.polymeric_vedio_des);
        this.p = (ImageView) this.m.findViewById(c.a.t0.y2.d.polymeric_vedio_play_icon);
        this.m.setOnClickListener(this);
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.t0.y2.e.person_polymeric_vedio_item_layout : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f17766e == i2) {
            return;
        }
        this.f17766e = i2;
        SkinManager.setBackgroundColor(this.m, c.a.t0.y2.a.CAM_X0201);
        SkinManager.setViewTextColor(this.o, c.a.t0.y2.a.CAM_X0105, 1);
        SkinManager.setImageResource(this.p, c.a.t0.y2.c.icon_play_video, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.m == view) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f17768g);
            c.a.t0.x2.e.l lVar = this.q;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(lVar.f25448g, lVar.f25449h, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: p */
    public void k(c.a.t0.x2.e.l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, lVar) == null) || lVar == null) {
            return;
        }
        this.q = lVar;
        this.n.startLoad(lVar.f25446e, 10, false);
        this.o.setText(lVar.f25447f);
        l(this.f17767f, TbadkCoreApplication.getInst().getSkinType());
    }
}
