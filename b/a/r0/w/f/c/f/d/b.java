package b.a.r0.w.f.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.w.f.g.c.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public ImageView n;
    public View o;
    public View p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.o = i();
        this.m = (TextView) i().findViewById(R.id.tv_empty);
        this.n = (ImageView) i().findViewById(R.id.iv_empty);
        this.p = i().findViewById(R.id.id_tab_live_sub_empty_divider);
        k(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_sub_concern_empty : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_08);
            SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.w.f.g.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            if (eVar.f26345e == 1) {
                this.m.setText(this.f16224f.getResources().getString(R.string.live_sub_tab_no_attention_txt));
                SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_07);
                return;
            }
            this.m.setText(this.f16224f.getResources().getString(R.string.live_sub_tab_empty_txt));
            SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_06);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }
}
