package c.a.o0.g0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.o0.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f10292b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f10293c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f10294d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d052a, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091332);
        EMTextView eMTextView = (EMTextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091333);
        this.f10292b = eMTextView;
        eMTextView.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0a47));
        EMTextView eMTextView2 = (EMTextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091331);
        this.f10293c = eMTextView2;
        eMTextView2.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0a46));
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091328);
        this.f10294d = tBSpecificationBtn;
        tBSpecificationBtn.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0964));
        this.f10294d.setTextSize(R.dimen.T_X05);
        this.f10294d.setConfig(new c.a.o0.r.l0.n.a());
    }

    public void b(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || (tBSpecificationBtn = this.f10294d) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this.f10292b);
            d2.z(R.dimen.T_X06);
            d2.v(R.color.CAM_X0107);
            c d3 = c.d(this.f10293c);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            WebPManager.setMaskDrawable(this.a, R.drawable.obfuscated_res_0x7f080e27, null);
            TBSpecificationBtn tBSpecificationBtn = this.f10294d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    @Override // c.a.o0.f0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }
}
