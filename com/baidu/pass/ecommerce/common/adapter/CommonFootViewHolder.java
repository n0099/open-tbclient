package com.baidu.pass.ecommerce.common.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.view.RotateYAnimation;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CommonFootViewHolder extends BaseRecyclerViewHolder<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public TextView mFootTv;
    public View mFooterIc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFootViewHolder(@NonNull View view2, boolean z) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Boolean.valueOf(z)};
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
        this.mFooterIc = view2.findViewById(R.id.obfuscated_res_0x7f091d02);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d03);
        this.mFootTv = textView;
        this.isDarkMode = z;
        if (z) {
            textView.setTextColor(view2.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06098e));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder
    public void bindData2View(int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bool) == null) {
            super.bindData2View(i, (int) bool);
            if (bool.booleanValue()) {
                this.mFooterIc.setVisibility(0);
                this.mFootTv.setText("正在加载...");
                RotateYAnimation rotateYAnimation = new RotateYAnimation();
                rotateYAnimation.setRepeatCount(-1);
                this.mFooterIc.startAnimation(rotateYAnimation);
                return;
            }
            this.mFooterIc.setVisibility(8);
            this.mFootTv.setText("已经到底啦");
        }
    }
}
