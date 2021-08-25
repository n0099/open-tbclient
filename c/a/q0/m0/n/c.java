package c.a.q0.m0.n;

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
    public TbPageContext<?> f22306a;

    /* renamed from: b  reason: collision with root package name */
    public View f22307b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f22308c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22309d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22310e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22311f;

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
        this.f22306a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f22307b = inflate;
        this.f22308c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f22309d = (ImageView) this.f22307b.findViewById(R.id.image);
        this.f22310e = (TextView) this.f22307b.findViewById(R.id.hint_text_1);
        this.f22311f = (TextView) this.f22307b.findViewById(R.id.hint_text_2);
        this.f22310e.setText(R.string.no_like_forum_hint_1);
        this.f22311f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.f22309d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.f22310e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f22311f, R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f22306a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f22306a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f22306a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f22306a.getPageActivity(), R.dimen.tbds21)).into(this.f22308c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22307b : (View) invokeV.objValue;
    }
}
