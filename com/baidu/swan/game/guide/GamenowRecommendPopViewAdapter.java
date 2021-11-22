package com.baidu.swan.game.guide;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.p0.h.j.h;
import b.a.p0.h.j.i;
import b.a.p0.h.j.n.c;
import b.a.p0.h.j.r.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes8.dex */
public class GamenowRecommendPopViewAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45395e;

    /* renamed from: f  reason: collision with root package name */
    public List<GameGuideConfigInfo.RecommendGameInfo> f45396f;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f45397a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45398b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GamenowRecommendPopViewAdapter gamenowRecommendPopViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopViewAdapter, view};
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
            this.f45397a = (SimpleDraweeView) view.findViewById(h.dv_icon);
            this.f45398b = (TextView) view.findViewById(h.tv_name);
        }
    }

    public GamenowRecommendPopViewAdapter(Context context, List<GameGuideConfigInfo.RecommendGameInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45395e = context;
        this.f45396f = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45396f.size() : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view.getTag() == null || (intValue = ((Integer) view.getTag()).intValue()) >= this.f45396f.size()) {
            return;
        }
        GameGuideConfigInfo.RecommendGameInfo recommendGameInfo = this.f45396f.get(intValue);
        if (TextUtils.isEmpty(recommendGameInfo.appKey)) {
            return;
        }
        b.n().b("gbBDialogClick", "3", recommendGameInfo.appKey, String.valueOf(intValue));
        c.n().A(recommendGameInfo.appKey, recommendGameInfo.appName, recommendGameInfo.iconUrl, intValue);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i2) {
        GameGuideConfigInfo.RecommendGameInfo recommendGameInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) || (recommendGameInfo = this.f45396f.get(i2)) == null) {
            return;
        }
        aVar.f45397a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendGameInfo.iconUrl).build());
        aVar.f45398b.setText(recommendGameInfo.appName);
        aVar.itemView.setTag(Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            a aVar = new a(this, LayoutInflater.from(this.f45395e).inflate(i.aiapps_gamenow_recommend_item_view, viewGroup, false));
            aVar.itemView.setOnClickListener(this);
            return aVar;
        }
        return (a) invokeLI.objValue;
    }
}
