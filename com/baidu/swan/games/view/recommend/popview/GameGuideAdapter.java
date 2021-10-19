package com.baidu.swan.games.view.recommend.popview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.f.e;
import c.a.p0.f.f;
import c.a.p0.h.o0.g.b.c;
import c.a.p0.h.o0.g.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes6.dex */
public class GameGuideAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47128e;

    /* renamed from: f  reason: collision with root package name */
    public List<RecommendItemModel> f47129f;

    /* renamed from: g  reason: collision with root package name */
    public c f47130g;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f47131a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f47132b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GameGuideAdapter gameGuideAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideAdapter, view};
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
            this.f47131a = (SimpleDraweeView) view.findViewById(e.dv_icon);
            this.f47132b = (TextView) view.findViewById(e.tv_name);
        }
    }

    public GameGuideAdapter(Context context, List<RecommendItemModel> list) {
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
        this.f47128e = context;
        this.f47129f = list;
        this.f47130g = new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47129f.size() : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view.getTag() == null || (intValue = ((Integer) view.getTag()).intValue()) >= this.f47129f.size()) {
            return;
        }
        RecommendItemModel recommendItemModel = this.f47129f.get(intValue);
        if (TextUtils.isEmpty(recommendItemModel.getScheme()) || TextUtils.isEmpty(recommendItemModel.getAppKey())) {
            return;
        }
        SchemeRouter.invokeSchemeForInner(this.f47128e, Uri.parse(recommendItemModel.getScheme()));
        c.a.p0.h.o0.g.b.e.d(4, recommendItemModel.getAppKey());
        this.f47130g.b(3, "popview", recommendItemModel.getAppKey(), String.valueOf(intValue + 1));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i2) {
        RecommendItemModel recommendItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) || (recommendItemModel = this.f47129f.get(i2)) == null) {
            return;
        }
        aVar.f47131a.setController(Fresco.newDraweeControllerBuilder().setUri(recommendItemModel.getIconUrl()).build());
        aVar.f47132b.setText(recommendItemModel.getAppName());
        aVar.itemView.setTag(Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"InflateParams"})
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            a aVar = new a(this, LayoutInflater.from(this.f47128e).inflate(f.swangame_game_close_guide_item_view, (ViewGroup) null));
            aVar.itemView.setOnClickListener(this);
            d.a(aVar.itemView);
            return aVar;
        }
        return (a) invokeLI.objValue;
    }
}
