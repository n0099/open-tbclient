package c.a.t0.h0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.t0.s.v.c;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.t0.g0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f13185b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f13186c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f13187d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(LayoutInflater.from(context).inflate(h.loaction_view_layout, (ViewGroup) null));
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
        this.a = (ImageView) view.findViewById(g.location_view_emotion);
        EMTextView eMTextView = (EMTextView) this.attachedView.findViewById(g.location_view_title);
        this.f13185b = eMTextView;
        eMTextView.setText(context.getResources().getString(j.location_view_title));
        EMTextView eMTextView2 = (EMTextView) this.attachedView.findViewById(g.location_view_desc);
        this.f13186c = eMTextView2;
        eMTextView2.setText(context.getResources().getString(j.location_view_desc));
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.attachedView.findViewById(g.locatin_view_button);
        this.f13187d = tBSpecificationBtn;
        tBSpecificationBtn.setText(context.getResources().getString(j.isopen));
        this.f13187d.setTextSize(e.T_X05);
        this.f13187d.setConfig(new c.a.t0.s.l0.n.a());
    }

    public void b(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || (tBSpecificationBtn = this.f13187d) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this.f13185b);
            d2.z(e.T_X06);
            d2.v(d.CAM_X0107);
            c d3 = c.d(this.f13186c);
            d3.z(e.T_X09);
            d3.v(d.CAM_X0108);
            WebPManager.setMaskDrawable(this.a, f.new_pic_emotion_location, null);
            TBSpecificationBtn tBSpecificationBtn = this.f13187d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    @Override // c.a.t0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }
}
