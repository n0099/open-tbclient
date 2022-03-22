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
/* loaded from: classes4.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f29598b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29599c;

    /* renamed from: d  reason: collision with root package name */
    public Button f29600d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListRecommendViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.a = (SimpleDraweeView) view.findViewById(R.id.obfuscated_res_0x7f091e24);
        this.f29598b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091e25);
        this.f29599c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091e23);
        this.f29600d = (Button) view.findViewById(R.id.obfuscated_res_0x7f091e26);
    }
}
