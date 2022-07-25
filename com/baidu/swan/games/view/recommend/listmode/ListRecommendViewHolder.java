package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public Button d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListRecommendViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091eae);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091eaf);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ead);
        this.d = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091eb0);
    }
}
