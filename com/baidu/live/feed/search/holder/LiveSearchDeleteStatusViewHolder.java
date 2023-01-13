package com.baidu.live.feed.search.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.tieba.zc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveSearchDeleteStatusViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TextView c;
    public ImageView d;
    public View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSearchDeleteStatusViewHolder(View view2) {
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
        this.a = view2;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091435);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907c1);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091434);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f09146b);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.setTextColor(zc0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
            String r = zc0.f().r();
            if (r == "day") {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080d91);
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d7f);
            } else if (r == "night") {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080d9b);
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d80);
            }
        }
    }
}
