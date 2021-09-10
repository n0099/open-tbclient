package c.a.r0.n0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f22874a;

    /* renamed from: b  reason: collision with root package name */
    public View f22875b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f22876c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22877d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22878e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22879f;

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
        this.f22874a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f22875b = inflate;
        this.f22876c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f22877d = (ImageView) this.f22875b.findViewById(R.id.image);
        this.f22878e = (TextView) this.f22875b.findViewById(R.id.hint_text_1);
        this.f22879f = (TextView) this.f22875b.findViewById(R.id.hint_text_2);
        this.f22878e.setText(R.string.no_like_forum_hint_1);
        this.f22879f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.f22877d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.f22878e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22879f, R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f22874a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f22874a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f22874a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f22874a.getPageActivity(), R.dimen.tbds21)).into(this.f22876c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22875b : (View) invokeV.objValue;
    }
}
