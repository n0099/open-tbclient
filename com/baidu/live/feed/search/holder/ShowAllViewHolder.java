package com.baidu.live.feed.search.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.uc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ShowAllViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Context b;
    public TextView c;
    public View d;
    public ImageView e;
    public String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowAllViewHolder(Context context, View view2, String str) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str};
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
        this.a = view2;
        this.b = context;
        this.f = str;
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ec5);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f0913d7);
        this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ecc);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.setText("查看全部");
            if ("recommend".equals(this.f)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            String r = uc0.f().r();
            if ("day".equals(r)) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f080d2d);
            } else if ("night".equals(r)) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f080d2e);
            }
        }
    }
}
