package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.f.f;
import java.util.List;
/* loaded from: classes3.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f11972e;

    /* renamed from: f  reason: collision with root package name */
    public a f11973f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.h.o0.g.e.a f11974g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11972e = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i2) {
        RecommendItemModel recommendItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, listRecommendViewHolder, i2) == null) || (recommendItemModel = this.f11974g.f50737b.get(i2)) == null) {
            return;
        }
        listRecommendViewHolder.f11978a.setImageURI(recommendItemModel.iconUrl);
        listRecommendViewHolder.f11979b.setText(recommendItemModel.appName);
        listRecommendViewHolder.f11980c.setText(recommendItemModel.desc);
        listRecommendViewHolder.f11981d.setText(recommendItemModel.buttonText);
        listRecommendViewHolder.itemView.setTag(Integer.valueOf(i2));
        listRecommendViewHolder.f11981d.setTag(Integer.valueOf(i2));
        listRecommendViewHolder.itemView.setOnClickListener(this);
        listRecommendViewHolder.f11981d.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ListRecommendViewHolder(this.f11972e.inflate(f.swangame_recommend_dialog_item, viewGroup, false)) : (ListRecommendViewHolder) invokeLI.objValue;
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f11973f = aVar;
        }
    }

    public void g(d.a.o0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f11974g = aVar;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List<RecommendItemModel> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.o0.h.o0.g.e.a aVar = this.f11974g;
            if (aVar == null || (list = aVar.f50737b) == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || this.f11973f == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f11973f.a(((Integer) view.getTag()).intValue());
    }
}
