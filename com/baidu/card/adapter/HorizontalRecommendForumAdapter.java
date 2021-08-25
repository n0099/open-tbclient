package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.p0.n.f;
import c.a.p0.s.q.o;
import c.a.p0.s.q.p1;
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
/* loaded from: classes5.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BAR_ENTRANCE = 2;
    public static final int TYPE_RECOMMEND_FORUM = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f38477a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c.a.p0.i0.b.a> f38478b;

    /* renamed from: c  reason: collision with root package name */
    public f<p1> f38479c;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f38480a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f38481b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f38482c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f38483d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f38484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f38485f;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1635a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f38486e;

            public View$OnClickListenerC1635a(a aVar, HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
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
                this.f38486e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38486e.f38485f.f38479c == null) {
                    return;
                }
                int adapterPosition = this.f38486e.getAdapterPosition();
                this.f38486e.f38485f.f38479c.a(view, null, adapterPosition, adapterPosition);
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
            this.f38485f = horizontalRecommendForumAdapter;
            this.f38480a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f38481b = (BarImageView) this.f38480a.findViewById(R.id.forum_icon);
            this.f38482c = (ImageView) this.f38480a.findViewById(R.id.square_icon);
            this.f38483d = (TextView) this.f38480a.findViewById(R.id.forum_name);
            this.f38484e = (TextView) this.f38480a.findViewById(R.id.desc);
            this.f38480a.setOnClickListener(new View$OnClickListenerC1635a(this, horizontalRecommendForumAdapter));
        }

        public void a(o oVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
                return;
            }
            this.f38482c.setVisibility(0);
            this.f38481b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f38482c, R.drawable.ic_icon_pure_square28, null);
            this.f38483d.setText(R.string.forum_square_title);
            this.f38484e.setText(R.string.forum_square_desc_1);
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f38483d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f38484e, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f38487a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f38488b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f38489c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f38490d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f38491e;

        /* renamed from: f  reason: collision with root package name */
        public p1 f38492f;

        /* renamed from: g  reason: collision with root package name */
        public String f38493g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalRecommendForumAdapter f38494h;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f38495e;

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
                this.f38495e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38495e.f38494h.f38479c == null) {
                    return;
                }
                int adapterPosition = this.f38495e.getAdapterPosition();
                this.f38495e.f38494h.f38479c.a(view, this.f38495e.f38492f, adapterPosition, adapterPosition);
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
            this.f38494h = horizontalRecommendForumAdapter;
            this.f38487a = view;
            this.f38493g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f38488b = (BarImageView) this.f38487a.findViewById(R.id.forum_icon);
            this.f38489c = (ImageView) this.f38487a.findViewById(R.id.square_icon);
            this.f38490d = (TextView) this.f38487a.findViewById(R.id.forum_name);
            this.f38491e = (TextView) this.f38487a.findViewById(R.id.desc);
            this.f38487a.setOnClickListener(new a(this, horizontalRecommendForumAdapter));
        }

        public void b(p1 p1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, p1Var) == null) || p1Var == null) {
                return;
            }
            this.f38492f = p1Var;
            this.f38488b.setShowOval(true);
            this.f38488b.setShowOuterBorder(false);
            this.f38488b.setShowInnerBorder(true);
            this.f38488b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f38488b.setStrokeColorResId(R.color.CAM_X0401);
            this.f38489c.setVisibility(8);
            this.f38488b.setVisibility(0);
            this.f38488b.startLoad(p1Var.k(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(p1Var.p()) <= 10) {
                this.f38490d.setText(p1Var.p());
            } else {
                this.f38490d.setText(StringHelper.cutChineseAndEnglishWithSuffix(p1Var.p(), 8, "..."));
            }
            this.f38491e.setText(this.f38493g + " " + StringHelper.numFormatOverWanWithoutDecimals(p1Var.q()));
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f38490d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f38491e, R.color.CAM_X0109);
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
        this.f38478b = new ArrayList<>();
        this.f38477a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<c.a.p0.i0.b.a> arrayList = this.f38478b;
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
            if (this.f38478b.get(i2) instanceof p1) {
                return 1;
            }
            return this.f38478b.get(i2) instanceof o ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<c.a.p0.i0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (arrayList = this.f38478b) == null || arrayList.size() <= 0) {
            return;
        }
        c.a.p0.i0.b.a aVar = this.f38478b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof o)) {
            ((a) viewHolder).a((o) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof p1)) {
            p1 p1Var = (p1) aVar;
            ((b) viewHolder).b(p1Var);
            f<p1> fVar = this.f38479c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, p1Var, i2, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            View inflate = this.f38477a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
            if (i2 == 2) {
                return new a(this, inflate);
            }
            return new b(this, inflate);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(ArrayList<? extends c.a.p0.i0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f38478b.clear();
        this.f38478b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void setOnItemCoverListener(f<p1> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f38479c = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }
}
