package c.a.r0.a0.f.c.f.d;

import android.view.View;
import android.view.ViewGroup;
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
public class e extends c.a.r0.g0.b<c.a.r0.a0.f.c.f.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public TbImageView o;
    public TbImageView p;
    public View q;
    public c.a.r0.a0.f.c.f.b.a r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = j();
        this.m = (TextView) j().findViewById(R.id.id_tab_live_sub_notification_title);
        this.n = (TextView) j().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.o = (TbImageView) j().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        TbImageView tbImageView = (TbImageView) j().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.p = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.p.setDefaultResource(17170445);
        this.p.setDefaultBgResource(17170445);
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        l(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_sub_notification_layout : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(this.q, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
            SkinManager.setImageResource(this.o, R.drawable.icon_tab_live_close_n);
            SkinManager.setBackgroundResource(this.n, R.drawable.tab_sub_notification_btn_bg_selecor);
            SkinManager.setImageResource(this.p, R.drawable.bg_tab_live_notification);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || g() == null) {
            return;
        }
        g().a(view, this.r);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: p */
    public void k(c.a.r0.a0.f.c.f.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.r = aVar;
        }
    }
}
