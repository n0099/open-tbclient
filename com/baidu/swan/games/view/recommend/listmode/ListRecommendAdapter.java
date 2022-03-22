package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ListRecommendAdapter extends RecyclerView.Adapter<ListRecommendViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    public a f29594b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.j.p0.g.e.a f29595c;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);
    }

    public ListRecommendAdapter(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(ListRecommendViewHolder listRecommendViewHolder, int i) {
        RecommendItemModel recommendItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, listRecommendViewHolder, i) == null) || (recommendItemModel = this.f29595c.f8898b.get(i)) == null) {
            return;
        }
        listRecommendViewHolder.a.setImageURI(recommendItemModel.iconUrl);
        listRecommendViewHolder.f29598b.setText(recommendItemModel.appName);
        listRecommendViewHolder.f29599c.setText(recommendItemModel.desc);
        listRecommendViewHolder.f29600d.setText(recommendItemModel.buttonText);
        listRecommendViewHolder.itemView.setTag(Integer.valueOf(i));
        listRecommendViewHolder.f29600d.setTag(Integer.valueOf(i));
        listRecommendViewHolder.itemView.setOnClickListener(this);
        listRecommendViewHolder.f29600d.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public ListRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) ? new ListRecommendViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d07f0, viewGroup, false)) : (ListRecommendViewHolder) invokeLI.objValue;
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f29594b = aVar;
        }
    }

    public void g(c.a.n0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f29595c = aVar;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        List<RecommendItemModel> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.n0.j.p0.g.e.a aVar = this.f29595c;
            if (aVar == null || (list = aVar.f8898b) == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || this.f29594b == null || view == null || !(view.getTag() instanceof Integer)) {
            return;
        }
        this.f29594b.a(((Integer) view.getTag()).intValue());
    }
}
