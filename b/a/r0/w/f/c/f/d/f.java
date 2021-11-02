package b.a.r0.w.f.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f extends b.a.r0.b0.b<b.a.r0.w.f.c.f.b.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public HeadImageView o;
    public TextView p;
    public View q;
    public b.a.r0.w.f.c.f.b.b r;
    public RelativeLayout s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.q = i();
        this.s = (RelativeLayout) i().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.m = (TextView) i().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.n = (TextView) i().findViewById(R.id.id_tab_live_sub_offline_item_description);
        HeadImageView headImageView = (HeadImageView) i().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.o = headImageView;
        headImageView.setAutoChangeStyle(true);
        this.o.setIsRound(true);
        this.o.setDrawBorder(true);
        this.o.setPlaceHolder(1);
        this.o.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.o.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.p = (TextView) i().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.s.setOnClickListener(this);
        k(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_sub_live_offline_item_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(this.q, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0108);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.w.f.c.f.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        this.r = bVar;
        String str = bVar.f24635g;
        if (StringUtils.isNull(str)) {
            str = StringUtils.isNull(bVar.f24634f) ? "" : bVar.f24634f;
        }
        this.m.setText(str);
        this.n.setText(StringUtils.isNull(bVar.f24637i) ? "" : bVar.f24637i);
        this.o.startLoad(bVar.f24636h, 10, false);
        this.p.setText(StringUtils.isNull(bVar.j) ? "" : bVar.j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || f() == null) {
            return;
        }
        f().a(view, this.r);
    }
}
