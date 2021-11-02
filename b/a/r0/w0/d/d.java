package b.a.r0.w0.d;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import b.a.r0.w0.b.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends b.a.r0.b0.b<b.a.r0.w0.c.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;
    public b.a.r0.w0.c.b r;
    public View.OnClickListener s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
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
        this.q = 3;
        this.m = (BarImageView) i().findViewById(R.id.forum_avatar);
        this.n = (TextView) i().findViewById(R.id.forum_name);
        this.o = (TextView) i().findViewById(R.id.forum_attention);
        this.p = (TextView) i().findViewById(R.id.forum_thread_count);
        i().setOnClickListener(this);
        k(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.forum_search_result_item : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.q == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(i(), R.drawable.square_search_item_bg);
        this.q = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.w0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        this.r = bVar;
        this.m.startLoad(bVar.g(), 10, false);
        this.n.setText(p(bVar.o(), bVar.t()));
        this.o.setText(String.format(this.f14737f.getString(R.string.concern), bVar.i()));
        this.p.setText(String.format(this.f14737f.getString(R.string.search_bar_thread), bVar.q()));
        k(this.f14737f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || this.r == null) {
            return;
        }
        TiebaStatic.log("c12261");
        e.d(this.r.t());
        view.setTag(this.r);
        View.OnClickListener onClickListener = this.s;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public SpannableStringBuilder p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
                return null;
            }
            String trim = str2.trim();
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            int indexOf = str.indexOf(trim);
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
