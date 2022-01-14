package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.s0.n.f;
import c.a.s0.s.q.o;
import c.a.s0.s.q.q1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BAR_ENTRANCE = 2;
    public static final int TYPE_RECOMMEND_FORUM = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.s0.l0.b.a> f33088b;

    /* renamed from: c  reason: collision with root package name */
    public f<q1> f33089c;

    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f33090b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f33091c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f33092d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f33093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f33094f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class View$OnClickListenerC1794a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f33095e;

            public View$OnClickListenerC1794a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, horizontalRecommendForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33095e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f33095e.f33094f.f33089c == null) {
                    return;
                }
                int adapterPosition = this.f33095e.getAdapterPosition();
                this.f33095e.f33094f.f33089c.a(view, null, adapterPosition, adapterPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalRecommendForumAdapter, view};
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
            this.f33094f = horizontalRecommendForumAdapter;
            this.a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f33090b = (BarImageView) this.a.findViewById(R.id.forum_icon);
            this.f33091c = (ImageView) this.a.findViewById(R.id.square_icon);
            this.f33092d = (TextView) this.a.findViewById(R.id.forum_name);
            this.f33093e = (TextView) this.a.findViewById(R.id.desc);
            this.a.setOnClickListener(new View$OnClickListenerC1794a(this, horizontalRecommendForumAdapter));
        }

        public void a(o oVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
                return;
            }
            this.f33091c.setVisibility(0);
            this.f33090b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f33091c, R.drawable.ic_icon_pure_square28, null);
            this.f33092d.setText(R.string.forum_square_title);
            this.f33093e.setText(R.string.forum_square_desc_1);
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f33092d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f33093e, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f33096b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f33097c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f33098d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f33099e;

        /* renamed from: f  reason: collision with root package name */
        public q1 f33100f;

        /* renamed from: g  reason: collision with root package name */
        public String f33101g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f33102h;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f33103e;

            public a(b bVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, horizontalRecommendForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33103e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f33103e.f33102h.f33089c == null) {
                    return;
                }
                int adapterPosition = this.f33103e.getAdapterPosition();
                this.f33103e.f33102h.f33089c.a(view, this.f33103e.f33100f, adapterPosition, adapterPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalRecommendForumAdapter, view};
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
            this.f33102h = horizontalRecommendForumAdapter;
            this.a = view;
            this.f33101g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f33096b = (BarImageView) this.a.findViewById(R.id.forum_icon);
            this.f33097c = (ImageView) this.a.findViewById(R.id.square_icon);
            this.f33098d = (TextView) this.a.findViewById(R.id.forum_name);
            this.f33099e = (TextView) this.a.findViewById(R.id.desc);
            this.a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(q1 q1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) || q1Var == null) {
                return;
            }
            this.f33100f = q1Var;
            this.f33096b.setShowOval(true);
            this.f33096b.setShowOuterBorder(false);
            this.f33096b.setShowInnerBorder(true);
            this.f33096b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f33096b.setStrokeColorResId(R.color.CAM_X0401);
            this.f33097c.setVisibility(8);
            this.f33096b.setVisibility(0);
            this.f33096b.startLoad(q1Var.k(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(q1Var.p()) <= 10) {
                this.f33098d.setText(q1Var.p());
            } else {
                this.f33098d.setText(StringHelper.cutChineseAndEnglishWithSuffix(q1Var.p(), 8, "..."));
            }
            this.f33099e.setText(this.f33101g + " " + StringHelper.numFormatOverWanWithoutDecimals(q1Var.q()));
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f33098d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f33099e, R.color.CAM_X0109);
            }
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33088b = new ArrayList<>();
        this.a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<c.a.s0.l0.b.a> arrayList = this.f33088b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f33088b.get(i2) instanceof q1) {
                return 1;
            }
            return this.f33088b.get(i2) instanceof o ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<c.a.s0.l0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (arrayList = this.f33088b) == null || arrayList.size() <= 0) {
            return;
        }
        c.a.s0.l0.b.a aVar = this.f33088b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof o)) {
            ((a) viewHolder).a((o) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof q1)) {
            q1 q1Var = (q1) aVar;
            ((b) viewHolder).b(q1Var);
            f<q1> fVar = this.f33089c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, q1Var, i2, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            View inflate = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
            if (i2 == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(ArrayList<? extends c.a.s0.l0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f33088b.clear();
        this.f33088b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void setOnItemCoverListener(f<q1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f33089c = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }
}
