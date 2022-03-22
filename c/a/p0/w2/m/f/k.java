package c.a.p0.w2.m.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k extends b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20175c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20175c = null;
    }

    @Override // c.a.p0.w2.m.f.b1
    public void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            TextView textView = (TextView) this.f20029b.findViewById(R.id.obfuscated_res_0x7f090e1f);
            this.f20175c = textView;
            textView.setVisibility(8);
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20175c : (TextView) invokeV.objValue;
    }

    public void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null || threadData.getPushStatusData() == null) {
            return;
        }
        int status = threadData.getPushStatusData().getStatus();
        if (status == 1) {
            g(true);
        } else if (status == 2) {
            g(false);
        }
    }

    public void g(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (textView = this.f20175c) == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.obfuscated_res_0x7f0f0f04);
            SkinManager.setViewTextColor(this.f20175c, (int) R.drawable.obfuscated_res_0x7f080f98);
            SkinManager.setBackgroundResource(this.f20175c, R.drawable.push_bg_selector);
            this.f20175c.setClickable(true);
        } else {
            textView.setText(R.string.obfuscated_res_0x7f0f0270);
            SkinManager.setBackgroundResource(this.f20175c, R.drawable.label_bg_gray80);
            SkinManager.setViewTextColor(this.f20175c, (int) R.color.CAM_X0109);
            this.f20175c.setClickable(false);
        }
        this.f20175c.setVisibility(0);
    }
}
