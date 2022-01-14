package c.a.t0.u0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f24268b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f24269c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f24270d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24271e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24272f;

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f24268b = inflate;
        this.f24269c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f24270d = (ImageView) this.f24268b.findViewById(R.id.image);
        this.f24271e = (TextView) this.f24268b.findViewById(R.id.hint_text_1);
        this.f24272f = (TextView) this.f24268b.findViewById(R.id.hint_text_2);
        this.f24271e.setText(R.string.no_like_forum_hint_1);
        this.f24272f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.f24270d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.f24271e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f24272f, R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).trRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).blRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).brRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).into(this.f24269c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24268b : (View) invokeV.objValue;
    }
}
