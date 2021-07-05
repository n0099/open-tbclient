package com.baidu.swan.games.view.recommend.listmode;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.q0.f.e;
/* loaded from: classes4.dex */
public class ListRecommendViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SimpleDraweeView f11935a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f11936b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11937c;

    /* renamed from: d  reason: collision with root package name */
    public Button f11938d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListRecommendViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f11935a = (SimpleDraweeView) view.findViewById(e.swangame_recommend_item_icon);
        this.f11936b = (TextView) view.findViewById(e.swangame_recommend_item_name);
        this.f11937c = (TextView) view.findViewById(e.swangame_recommend_item_detail);
        this.f11938d = (Button) view.findViewById(e.swangame_recommend_item_play);
    }
}
