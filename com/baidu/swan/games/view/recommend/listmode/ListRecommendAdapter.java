package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.o0.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f46980e;

    /* renamed from: f  reason: collision with root package name */
    public a f46981f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.h.o0.g.e.a f46982g;

    /* loaded from: classes6.dex */
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
        this.f46980e = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List<RecommendItemModel> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.o0.h.o0.g.e.a aVar = this.f46982g;
            if (aVar == null || (list = aVar.f11450b) == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.f46981f == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f46981f.a(((Integer) view.getTag()).intValue());
    }

    public void setItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f46981f = aVar;
        }
    }

    public void updateModel(c.a.o0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f46982g = aVar;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i2) {
        RecommendItemModel recommendItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, listRecommendViewHolder, i2) == null) || (recommendItemModel = this.f46982g.f11450b.get(i2)) == null) {
            return;
        }
        listRecommendViewHolder.icon.setImageURI(recommendItemModel.iconUrl);
        listRecommendViewHolder.name.setText(recommendItemModel.appName);
        listRecommendViewHolder.detail.setText(recommendItemModel.desc);
        listRecommendViewHolder.play.setText(recommendItemModel.buttonText);
        listRecommendViewHolder.itemView.setTag(Integer.valueOf(i2));
        listRecommendViewHolder.play.setTag(Integer.valueOf(i2));
        listRecommendViewHolder.itemView.setOnClickListener(this);
        listRecommendViewHolder.play.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new ListRecommendViewHolder(this.f46980e.inflate(f.swangame_recommend_dialog_item, viewGroup, false)) : (ListRecommendViewHolder) invokeLI.objValue;
    }
}
