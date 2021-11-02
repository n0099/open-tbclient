package b.a.r0.p2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n extends b.a.r0.b0.b<b.a.r0.p2.e.o> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public View n;
    public TbImageView o;
    public TextView p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(TbPageContext tbPageContext) {
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
        this.n = i4;
        this.m = tbPageContext;
        i4.setTag(this);
        this.o = (TbImageView) this.n.findViewById(R.id.gift_pic);
        this.p = (TextView) this.n.findViewById(R.id.gift_num_text);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.item_gift_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.o, R.drawable.item_gift_selector);
            SkinManager.setBackgroundColor(this.p, R.color.common_color_10294);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0302);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.p2.e.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) {
            if (oVar == null) {
                this.n.setVisibility(8);
                return;
            }
            k(this.m, TbadkCoreApplication.getInst().getSkinType());
            this.o.startLoad(oVar.f22327e, 10, false);
            this.n.setOnClickListener(this);
            if (oVar.f22328f > 0) {
                this.p.setVisibility(0);
                long j = oVar.f22328f;
                if (j > 99) {
                    this.p.setText("99");
                    return;
                } else {
                    this.p.setText(String.valueOf(j));
                    return;
                }
            }
            this.p.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }
}
