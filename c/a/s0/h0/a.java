package c.a.s0.h0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.s0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.s0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f12926b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f12927c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f12928d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.loaction_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.attachedView) == null) {
            return;
        }
        this.a = (ImageView) view.findViewById(R.id.location_view_emotion);
        EMTextView eMTextView = (EMTextView) this.attachedView.findViewById(R.id.location_view_title);
        this.f12926b = eMTextView;
        eMTextView.setText(context.getResources().getString(R.string.location_view_title));
        EMTextView eMTextView2 = (EMTextView) this.attachedView.findViewById(R.id.location_view_desc);
        this.f12927c = eMTextView2;
        eMTextView2.setText(context.getResources().getString(R.string.location_view_desc));
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.attachedView.findViewById(R.id.locatin_view_button);
        this.f12928d = tBSpecificationBtn;
        tBSpecificationBtn.setText(context.getResources().getString(R.string.isopen));
        this.f12928d.setTextSize(R.dimen.T_X05);
        this.f12928d.setConfig(new c.a.s0.s.k0.n.a());
    }

    public void b(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || (tBSpecificationBtn = this.f12928d) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this.f12926b);
            d2.z(R.dimen.T_X06);
            d2.v(R.color.CAM_X0107);
            c d3 = c.d(this.f12927c);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            WebPManager.setMaskDrawable(this.a, R.drawable.new_pic_emotion_location, null);
            TBSpecificationBtn tBSpecificationBtn = this.f12928d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    @Override // c.a.s0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }
}
